package com.google.android.gms.internal;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.ResultTransform;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.TransformedResult;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzr;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public abstract class zzpo<R extends Result> extends PendingResult<R> {
    static final ThreadLocal<Boolean> f10505a = new C33141();
    protected final zza<R> f10506b;
    protected final WeakReference<GoogleApiClient> f10507c;
    private final Object f10508d;
    private final CountDownLatch f10509e;
    private final ArrayList<com.google.android.gms.common.api.PendingResult.zza> f10510f;
    private ResultCallback<? super R> f10511g;
    private R f10512h;
    private zzb f10513i;
    private volatile boolean f10514j;
    private boolean f10515k;
    private boolean f10516l;
    private zzr f10517m;
    private volatile zzqx<R> f10518n;
    private boolean f10519o;

    class C33141 extends ThreadLocal<Boolean> {
        C33141() {
        }

        protected Boolean m17374a() {
            return Boolean.valueOf(false);
        }

        protected /* synthetic */ Object initialValue() {
            return m17374a();
        }
    }

    public static class zza<R extends Result> extends Handler {
        public zza() {
            this(Looper.getMainLooper());
        }

        public zza(Looper looper) {
            super(looper);
        }

        protected void m17375a(ResultCallback<? super R> resultCallback, R r) {
            try {
                resultCallback.onResult(r);
            } catch (RuntimeException e) {
                zzpo.zze(r);
                throw e;
            }
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Pair pair = (Pair) message.obj;
                    m17375a((ResultCallback) pair.first, (Result) pair.second);
                    return;
                case 2:
                    ((zzpo) message.obj).zzaa(Status.st);
                    return;
                default:
                    Log.wtf("BasePendingResult", "Don't know how to handle message: " + message.what, new Exception());
                    return;
            }
        }

        public void zza(ResultCallback<? super R> resultCallback, R r) {
            sendMessage(obtainMessage(1, new Pair(resultCallback, r)));
        }

        public void zza(zzpo<R> com_google_android_gms_internal_zzpo_R, long j) {
            sendMessageDelayed(obtainMessage(2, com_google_android_gms_internal_zzpo_R), j);
        }

        public void zzaoz() {
            removeMessages(2);
        }
    }

    private final class zzb {
        final /* synthetic */ zzpo f11476a;

        private zzb(zzpo com_google_android_gms_internal_zzpo) {
            this.f11476a = com_google_android_gms_internal_zzpo;
        }

        protected void finalize() {
            zzpo.zze(this.f11476a.f10512h);
            super.finalize();
        }
    }

    @Deprecated
    zzpo() {
        this.f10508d = new Object();
        this.f10509e = new CountDownLatch(1);
        this.f10510f = new ArrayList();
        this.f10519o = false;
        this.f10506b = new zza(Looper.getMainLooper());
        this.f10507c = new WeakReference(null);
    }

    @Deprecated
    protected zzpo(Looper looper) {
        this.f10508d = new Object();
        this.f10509e = new CountDownLatch(1);
        this.f10510f = new ArrayList();
        this.f10519o = false;
        this.f10506b = new zza(looper);
        this.f10507c = new WeakReference(null);
    }

    protected zzpo(GoogleApiClient googleApiClient) {
        this.f10508d = new Object();
        this.f10509e = new CountDownLatch(1);
        this.f10510f = new ArrayList();
        this.f10519o = false;
        this.f10506b = new zza(googleApiClient != null ? googleApiClient.getLooper() : Looper.getMainLooper());
        this.f10507c = new WeakReference(googleApiClient);
    }

    private void mo1893a(R r) {
        this.f10512h = r;
        this.f10517m = null;
        this.f10509e.countDown();
        Status status = this.f10512h.getStatus();
        if (this.f10515k) {
            this.f10511g = null;
        } else if (this.f10511g != null) {
            this.f10506b.zzaoz();
            this.f10506b.zza(this.f10511g, mo2509c());
        } else if (this.f10512h instanceof Releasable) {
            this.f10513i = new zzb();
        }
        Iterator it = this.f10510f.iterator();
        while (it.hasNext()) {
            ((com.google.android.gms.common.api.PendingResult.zza) it.next()).zzv(status);
        }
        this.f10510f.clear();
    }

    private R mo2509c() {
        R r;
        boolean z = true;
        synchronized (this.f10508d) {
            if (this.f10514j) {
                z = false;
            }
            zzab.zza(z, (Object) "Result has already been consumed.");
            zzab.zza(isReady(), (Object) "Result is not ready.");
            r = this.f10512h;
            this.f10512h = null;
            this.f10511g = null;
            this.f10514j = true;
        }
        mo1892a();
        return r;
    }

    public static void zze(Result result) {
        if (result instanceof Releasable) {
            try {
                ((Releasable) result).release();
            } catch (Throwable e) {
                String valueOf = String.valueOf(result);
                Log.w("BasePendingResult", new StringBuilder(String.valueOf(valueOf).length() + 18).append("Unable to release ").append(valueOf).toString(), e);
            }
        }
    }

    protected void mo1892a() {
    }

    public final R await() {
        boolean z = true;
        zzab.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "await must not be called on the UI thread");
        zzab.zza(!this.f10514j, (Object) "Result has already been consumed");
        if (this.f10518n != null) {
            z = false;
        }
        zzab.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            this.f10509e.await();
        } catch (InterruptedException e) {
            zzaa(Status.sr);
        }
        zzab.zza(isReady(), (Object) "Result is not ready.");
        return mo2509c();
    }

    public final R await(long j, TimeUnit timeUnit) {
        boolean z = true;
        boolean z2 = j <= 0 || Looper.myLooper() != Looper.getMainLooper();
        zzab.zza(z2, (Object) "await must not be called on the UI thread when time is greater than zero.");
        zzab.zza(!this.f10514j, (Object) "Result has already been consumed.");
        if (this.f10518n != null) {
            z = false;
        }
        zzab.zza(z, (Object) "Cannot await if then() has been called.");
        try {
            if (!this.f10509e.await(j, timeUnit)) {
                zzaa(Status.st);
            }
        } catch (InterruptedException e) {
            zzaa(Status.sr);
        }
        zzab.zza(isReady(), (Object) "Result is not ready.");
        return mo2509c();
    }

    boolean m16785b() {
        return false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancel() {
        /*
        r2 = this;
        r1 = r2.f10508d;
        monitor-enter(r1);
        r0 = r2.f10515k;	 Catch:{ all -> 0x0029 }
        if (r0 != 0) goto L_0x000b;
    L_0x0007:
        r0 = r2.f10514j;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x000d;
    L_0x000b:
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
    L_0x000c:
        return;
    L_0x000d:
        r0 = r2.f10517m;	 Catch:{ all -> 0x0029 }
        if (r0 == 0) goto L_0x0016;
    L_0x0011:
        r0 = r2.f10517m;	 Catch:{ RemoteException -> 0x002c }
        r0.cancel();	 Catch:{ RemoteException -> 0x002c }
    L_0x0016:
        r0 = r2.f10512h;	 Catch:{ all -> 0x0029 }
        zze(r0);	 Catch:{ all -> 0x0029 }
        r0 = 1;
        r2.f10515k = r0;	 Catch:{ all -> 0x0029 }
        r0 = com.google.android.gms.common.api.Status.su;	 Catch:{ all -> 0x0029 }
        r0 = r2.zzc(r0);	 Catch:{ all -> 0x0029 }
        r2.mo1893a(r0);	 Catch:{ all -> 0x0029 }
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        goto L_0x000c;
    L_0x0029:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0029 }
        throw r0;
    L_0x002c:
        r0 = move-exception;
        goto L_0x0016;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.cancel():void");
    }

    public boolean isCanceled() {
        boolean z;
        synchronized (this.f10508d) {
            z = this.f10515k;
        }
        return z;
    }

    public final boolean isReady() {
        return this.f10509e.getCount() == 0;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r6) {
        /*
        r5 = this;
        r0 = 1;
        r1 = 0;
        r3 = r5.f10508d;
        monitor-enter(r3);
        if (r6 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r5.f10511g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r5.f10514j;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzab.zza(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r5.f10518n;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzab.zza(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r5.isCanceled();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r5.isReady();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r5.f10506b;	 Catch:{ all -> 0x0027 }
        r1 = r5.mo2509c();	 Catch:{ all -> 0x0027 }
        r0.zza(r6, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r5.f10511g = r6;	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.setResultCallback(com.google.android.gms.common.api.ResultCallback):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setResultCallback(com.google.android.gms.common.api.ResultCallback<? super R> r7, long r8, java.util.concurrent.TimeUnit r10) {
        /*
        r6 = this;
        r0 = 1;
        r1 = 0;
        r3 = r6.f10508d;
        monitor-enter(r3);
        if (r7 != 0) goto L_0x000c;
    L_0x0007:
        r0 = 0;
        r6.f10511g = r0;	 Catch:{ all -> 0x0027 }
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
    L_0x000b:
        return;
    L_0x000c:
        r2 = r6.f10514j;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002a;
    L_0x0010:
        r2 = r0;
    L_0x0011:
        r4 = "Result has already been consumed.";
        com.google.android.gms.common.internal.zzab.zza(r2, r4);	 Catch:{ all -> 0x0027 }
        r2 = r6.f10518n;	 Catch:{ all -> 0x0027 }
        if (r2 != 0) goto L_0x002c;
    L_0x001a:
        r1 = "Cannot set callbacks if then() has been called.";
        com.google.android.gms.common.internal.zzab.zza(r0, r1);	 Catch:{ all -> 0x0027 }
        r0 = r6.isCanceled();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x002e;
    L_0x0025:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x0027:
        r0 = move-exception;
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        throw r0;
    L_0x002a:
        r2 = r1;
        goto L_0x0011;
    L_0x002c:
        r0 = r1;
        goto L_0x001a;
    L_0x002e:
        r0 = r6.isReady();	 Catch:{ all -> 0x0027 }
        if (r0 == 0) goto L_0x003f;
    L_0x0034:
        r0 = r6.f10506b;	 Catch:{ all -> 0x0027 }
        r1 = r6.mo2509c();	 Catch:{ all -> 0x0027 }
        r0.zza(r7, r1);	 Catch:{ all -> 0x0027 }
    L_0x003d:
        monitor-exit(r3);	 Catch:{ all -> 0x0027 }
        goto L_0x000b;
    L_0x003f:
        r6.f10511g = r7;	 Catch:{ all -> 0x0027 }
        r0 = r6.f10506b;	 Catch:{ all -> 0x0027 }
        r4 = r10.toMillis(r8);	 Catch:{ all -> 0x0027 }
        r0.zza(r6, r4);	 Catch:{ all -> 0x0027 }
        goto L_0x003d;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzpo.setResultCallback(com.google.android.gms.common.api.ResultCallback, long, java.util.concurrent.TimeUnit):void");
    }

    public <S extends Result> TransformedResult<S> then(ResultTransform<? super R, ? extends S> resultTransform) {
        TransformedResult<S> then;
        boolean z = true;
        zzab.zza(!this.f10514j, (Object) "Result has already been consumed.");
        synchronized (this.f10508d) {
            zzab.zza(this.f10518n == null, (Object) "Cannot call then() twice.");
            if (this.f10511g != null) {
                z = false;
            }
            zzab.zza(z, (Object) "Cannot call then() if callbacks are set.");
            this.f10519o = true;
            this.f10518n = new zzqx(this.f10507c);
            then = this.f10518n.then(resultTransform);
            if (isReady()) {
                this.f10506b.zza(this.f10518n, mo2509c());
            } else {
                this.f10511g = this.f10518n;
            }
        }
        return then;
    }

    public final void zza(com.google.android.gms.common.api.PendingResult.zza com_google_android_gms_common_api_PendingResult_zza) {
        boolean z = true;
        zzab.zza(!this.f10514j, (Object) "Result has already been consumed.");
        if (com_google_android_gms_common_api_PendingResult_zza == null) {
            z = false;
        }
        zzab.zzb(z, (Object) "Callback cannot be null.");
        synchronized (this.f10508d) {
            if (isReady()) {
                com_google_android_gms_common_api_PendingResult_zza.zzv(this.f10512h.getStatus());
            } else {
                this.f10510f.add(com_google_android_gms_common_api_PendingResult_zza);
            }
        }
    }

    public final void zzaa(Status status) {
        synchronized (this.f10508d) {
            if (!isReady()) {
                zzc(zzc(status));
                this.f10516l = true;
            }
        }
    }

    public Integer zzaoj() {
        return null;
    }

    public boolean zzaov() {
        boolean isCanceled;
        synchronized (this.f10508d) {
            if (((GoogleApiClient) this.f10507c.get()) == null || !this.f10519o) {
                cancel();
            }
            isCanceled = isCanceled();
        }
        return isCanceled;
    }

    public void zzaow() {
        boolean z = this.f10519o || ((Boolean) f10505a.get()).booleanValue();
        this.f10519o = z;
    }

    protected abstract R zzc(Status status);

    public final void zzc(R r) {
        boolean z = true;
        synchronized (this.f10508d) {
            if (this.f10516l || this.f10515k || (isReady() && m16785b())) {
                zze(r);
                return;
            }
            zzab.zza(!isReady(), (Object) "Results have already been set");
            if (this.f10514j) {
                z = false;
            }
            zzab.zza(z, (Object) "Result has already been consumed");
            mo1893a((Result) r);
        }
    }
}
