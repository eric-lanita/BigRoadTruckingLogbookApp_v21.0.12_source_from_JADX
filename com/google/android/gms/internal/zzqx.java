package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultCallbacks;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import java.lang.ref.WeakReference;

public class zzqx<R extends Result> extends TransformedResult<R> implements ResultCallback<R> {
    private ResultTransform<? super R, ? extends Result> f11675a = null;
    private zzqx<? extends Result> f11676b = null;
    private volatile ResultCallbacks<? super R> f11677c = null;
    private PendingResult<R> f11678d = null;
    private final Object f11679e = new Object();
    private Status f11680f = null;
    private final WeakReference<GoogleApiClient> f11681g;
    private final zza f11682h;
    private boolean f11683i = false;

    private final class zza extends Handler {
        final /* synthetic */ zzqx f11674a;

        public zza(zzqx com_google_android_gms_internal_zzqx, Looper looper) {
            this.f11674a = com_google_android_gms_internal_zzqx;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    PendingResult pendingResult = (PendingResult) message.obj;
                    synchronized (this.f11674a.f11679e) {
                        if (pendingResult == null) {
                            this.f11674a.f11676b.m17519a(new Status(13, "Transform returned null"));
                        } else if (pendingResult instanceof zzqs) {
                            this.f11674a.f11676b.m17519a(((zzqs) pendingResult).m17511a());
                        } else {
                            this.f11674a.f11676b.zza(pendingResult);
                        }
                    }
                    return;
                case 1:
                    RuntimeException runtimeException = (RuntimeException) message.obj;
                    String str = "TransformedResultImpl";
                    String str2 = "Runtime exception on the transformation worker thread: ";
                    String valueOf = String.valueOf(runtimeException.getMessage());
                    Log.e(str, valueOf.length() != 0 ? str2.concat(valueOf) : new String(str2));
                    throw runtimeException;
                default:
                    Log.e("TransformedResultImpl", "TransformationResultHandler received unknown message type: " + message.what);
                    return;
            }
        }
    }

    public zzqx(WeakReference<GoogleApiClient> weakReference) {
        zzab.zzb((Object) weakReference, (Object) "GoogleApiClient reference must not be null");
        this.f11681g = weakReference;
        GoogleApiClient googleApiClient = (GoogleApiClient) this.f11681g.get();
        this.f11682h = new zza(this, googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
    }

    private void m17518a(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                Log.w("TransformedResultImpl", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    private void m17519a(Status status) {
        synchronized (this.f11679e) {
            this.f11680f = status;
            m17524b(this.f11680f);
        }
    }

    private void m17523b() {
        if (this.f11675a != null || this.f11677c != null) {
            GoogleApiClient googleApiClient = (GoogleApiClient) this.f11681g.get();
            if (!(this.f11683i || this.f11675a == null || googleApiClient == null)) {
                googleApiClient.zza(this);
                this.f11683i = true;
            }
            if (this.f11680f != null) {
                m17524b(this.f11680f);
            } else if (this.f11678d != null) {
                this.f11678d.setResultCallback(this);
            }
        }
    }

    private void m17524b(Status status) {
        synchronized (this.f11679e) {
            if (this.f11675a != null) {
                Status onFailure = this.f11675a.onFailure(status);
                zzab.zzb((Object) onFailure, (Object) "onFailure must not return null");
                this.f11676b.m17519a(onFailure);
            } else if (m17526c()) {
                this.f11677c.onFailure(status);
            }
        }
    }

    private boolean m17526c() {
        return (this.f11677c == null || ((GoogleApiClient) this.f11681g.get()) == null) ? false : true;
    }

    void m17529a() {
        this.f11677c = null;
    }

    public void andFinally(ResultCallbacks<? super R> resultCallbacks) {
        boolean z = true;
        synchronized (this.f11679e) {
            zzab.zza(this.f11677c == null, (Object) "Cannot call andFinally() twice.");
            if (this.f11675a != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f11677c = resultCallbacks;
            m17523b();
        }
    }

    public void onResult(final R r) {
        synchronized (this.f11679e) {
            if (!r.getStatus().isSuccess()) {
                m17519a(r.getStatus());
                m17518a((Result) r);
            } else if (this.f11675a != null) {
                zzqr.zzaqc().submit(new Runnable(this) {
                    final /* synthetic */ zzqx f11673b;

                    public void run() {
                        GoogleApiClient googleApiClient;
                        try {
                            zzpo.f10505a.set(Boolean.valueOf(true));
                            this.f11673b.f11682h.sendMessage(this.f11673b.f11682h.obtainMessage(0, this.f11673b.f11675a.onSuccess(r)));
                            zzpo.f10505a.set(Boolean.valueOf(false));
                            this.f11673b.m17518a(r);
                            googleApiClient = (GoogleApiClient) this.f11673b.f11681g.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(this.f11673b);
                            }
                        } catch (RuntimeException e) {
                            this.f11673b.f11682h.sendMessage(this.f11673b.f11682h.obtainMessage(1, e));
                            zzpo.f10505a.set(Boolean.valueOf(false));
                            this.f11673b.m17518a(r);
                            googleApiClient = (GoogleApiClient) this.f11673b.f11681g.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(this.f11673b);
                            }
                        } catch (Throwable th) {
                            Throwable th2 = th;
                            zzpo.f10505a.set(Boolean.valueOf(false));
                            this.f11673b.m17518a(r);
                            googleApiClient = (GoogleApiClient) this.f11673b.f11681g.get();
                            if (googleApiClient != null) {
                                googleApiClient.zzb(this.f11673b);
                            }
                        }
                    }
                });
            } else if (m17526c()) {
                this.f11677c.onSuccess(r);
            }
        }
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult com_google_android_gms_internal_zzqx;
        boolean z = true;
        synchronized (this.f11679e) {
            zzab.zza(this.f11675a == null, (Object) "Cannot call then() twice.");
            if (this.f11677c != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() and andFinally() on the same TransformedResult.");
            this.f11675a = resultTransform;
            com_google_android_gms_internal_zzqx = new zzqx(this.f11681g);
            this.f11676b = com_google_android_gms_internal_zzqx;
            m17523b();
        }
        return com_google_android_gms_internal_zzqx;
    }

    public void zza(PendingResult<?> pendingResult) {
        synchronized (this.f11679e) {
            this.f11678d = pendingResult;
            m17523b();
        }
    }
}
