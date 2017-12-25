package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import com.google.android.gms.auth.api.signin.internal.zzk;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzl;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.Writer;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;

public final class zzpy extends GoogleApiClient implements com.google.android.gms.internal.zzqh.zza {
    final Queue<com.google.android.gms.internal.zzpm.zza<?, ?>> f11557a = new LinkedList();
    zzqe f11558b;
    final Map<zzc<?>, zze> f11559c;
    Set<Scope> f11560d = new HashSet();
    final zzg f11561e;
    final Map<Api<?>, Integer> f11562f;
    final com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> f11563g;
    Set<zzqx> f11564h = null;
    final zzqy f11565i;
    private final Lock f11566j;
    private final zzl f11567k;
    private zzqh f11568l = null;
    private final int f11569m;
    private final Context f11570n;
    private final Looper f11571o;
    private volatile boolean f11572p;
    private long f11573q = 120000;
    private long f11574r = 5000;
    private final zza f11575s;
    private final GoogleApiAvailability f11576t;
    private final zzqo f11577u = new zzqo();
    private final ArrayList<zzpp> f11578v;
    private Integer f11579w = null;
    private final com.google.android.gms.common.internal.zzl.zza f11580x = new C33221(this);

    class C33221 implements com.google.android.gms.common.internal.zzl.zza {
        final /* synthetic */ zzpy f11545a;

        C33221(zzpy com_google_android_gms_internal_zzpy) {
            this.f11545a = com_google_android_gms_internal_zzpy;
        }

        public boolean isConnected() {
            return this.f11545a.isConnected();
        }

        public Bundle zzamh() {
            return null;
        }
    }

    final class zza extends Handler {
        final /* synthetic */ zzpy f11555a;

        zza(zzpy com_google_android_gms_internal_zzpy, Looper looper) {
            this.f11555a = com_google_android_gms_internal_zzpy;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.f11555a.m17448i();
                    return;
                case 2:
                    this.f11555a.m17447h();
                    return;
                default:
                    Log.w("GoogleApiClientImpl", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    static class zzb extends com.google.android.gms.internal.zzqe.zza {
        private WeakReference<zzpy> f11556a;

        zzb(zzpy com_google_android_gms_internal_zzpy) {
            this.f11556a = new WeakReference(com_google_android_gms_internal_zzpy);
        }

        public void zzaou() {
            zzpy com_google_android_gms_internal_zzpy = (zzpy) this.f11556a.get();
            if (com_google_android_gms_internal_zzpy != null) {
                com_google_android_gms_internal_zzpy.m17447h();
            }
        }
    }

    public zzpy(Context context, Lock lock, Looper looper, zzg com_google_android_gms_common_internal_zzg, GoogleApiAvailability googleApiAvailability, com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, Map<Api<?>, Integer> map, List<ConnectionCallbacks> list, List<OnConnectionFailedListener> list2, Map<zzc<?>, zze> map2, int i, int i2, ArrayList<zzpp> arrayList) {
        this.f11570n = context;
        this.f11566j = lock;
        this.f11567k = new zzl(looper, this.f11580x);
        this.f11571o = looper;
        this.f11575s = new zza(this, looper);
        this.f11576t = googleApiAvailability;
        this.f11569m = i;
        if (this.f11569m >= 0) {
            this.f11579w = Integer.valueOf(i2);
        }
        this.f11562f = map;
        this.f11559c = map2;
        this.f11578v = arrayList;
        this.f11565i = new zzqy(this.f11559c);
        for (ConnectionCallbacks registerConnectionCallbacks : list) {
            this.f11567k.registerConnectionCallbacks(registerConnectionCallbacks);
        }
        for (OnConnectionFailedListener registerConnectionFailedListener : list2) {
            this.f11567k.registerConnectionFailedListener(registerConnectionFailedListener);
        }
        this.f11561e = com_google_android_gms_common_internal_zzg;
        this.f11563g = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv;
    }

    static String m17438a(int i) {
        switch (i) {
            case 1:
                return "SIGN_IN_MODE_REQUIRED";
            case 2:
                return "SIGN_IN_MODE_OPTIONAL";
            case 3:
                return "SIGN_IN_MODE_NONE";
            default:
                return "UNKNOWN";
        }
    }

    private void m17439a(final GoogleApiClient googleApiClient, final zzqu com_google_android_gms_internal_zzqu, final boolean z) {
        zzre.zt.zzg(googleApiClient).setResultCallback(new ResultCallback<Status>(this) {
            final /* synthetic */ zzpy f11554d;

            public /* synthetic */ void onResult(Result result) {
                zzp((Status) result);
            }

            public void zzp(Status status) {
                zzk.zzbc(this.f11554d.f11570n).zzagl();
                if (status.isSuccess() && this.f11554d.isConnected()) {
                    this.f11554d.reconnect();
                }
                com_google_android_gms_internal_zzqu.zzc((Result) status);
                if (z) {
                    googleApiClient.disconnect();
                }
            }
        });
    }

    private void m17442a(zzqi com_google_android_gms_internal_zzqi) {
        if (this.f11569m >= 0) {
            zzpk.zza(com_google_android_gms_internal_zzqi).zzfh(this.f11569m);
            return;
        }
        throw new IllegalStateException("Called stopAutoManage but automatic lifecycle management is not enabled.");
    }

    private void m17443b(int i) {
        if (this.f11579w == null) {
            this.f11579w = Integer.valueOf(i);
        } else if (this.f11579w.intValue() != i) {
            String valueOf = String.valueOf(m17438a(i));
            String valueOf2 = String.valueOf(m17438a(this.f11579w.intValue()));
            throw new IllegalStateException(new StringBuilder((String.valueOf(valueOf).length() + 51) + String.valueOf(valueOf2).length()).append("Cannot use sign-in mode: ").append(valueOf).append(". Mode was already set to ").append(valueOf2).toString());
        }
        if (this.f11568l == null) {
            Object obj = null;
            Object obj2 = null;
            for (zze com_google_android_gms_common_api_Api_zze : this.f11559c.values()) {
                if (com_google_android_gms_common_api_Api_zze.zzafk()) {
                    obj2 = 1;
                }
                obj = com_google_android_gms_common_api_Api_zze.zzafz() ? 1 : obj;
            }
            switch (this.f11579w.intValue()) {
                case 1:
                    if (obj2 == null) {
                        throw new IllegalStateException("SIGN_IN_MODE_REQUIRED cannot be used on a GoogleApiClient that does not contain any authenticated APIs. Use connect() instead.");
                    } else if (obj != null) {
                        throw new IllegalStateException("Cannot use SIGN_IN_MODE_REQUIRED with GOOGLE_SIGN_IN_API. Use connect(SIGN_IN_MODE_OPTIONAL) instead.");
                    }
                    break;
                case 2:
                    if (obj2 != null) {
                        this.f11568l = zzpq.zza(this.f11570n, this, this.f11566j, this.f11571o, this.f11576t, this.f11559c, this.f11561e, this.f11562f, this.f11563g, this.f11578v);
                        return;
                    }
                    break;
            }
            this.f11568l = new zzqa(this.f11570n, this, this.f11566j, this.f11571o, this.f11576t, this.f11559c, this.f11561e, this.f11562f, this.f11563g, this.f11578v, this);
        }
    }

    private void m17446g() {
        this.f11567k.zzasx();
        this.f11568l.connect();
    }

    private void m17447h() {
        this.f11566j.lock();
        try {
            if (m17450b()) {
                m17446g();
            }
            this.f11566j.unlock();
        } catch (Throwable th) {
            this.f11566j.unlock();
        }
    }

    private void m17448i() {
        this.f11566j.lock();
        try {
            if (m17452d()) {
                m17446g();
            }
            this.f11566j.unlock();
        } catch (Throwable th) {
            this.f11566j.unlock();
        }
    }

    public static int zza(Iterable<zze> iterable, boolean z) {
        int i = 0;
        int i2 = 0;
        for (zze com_google_android_gms_common_api_Api_zze : iterable) {
            if (com_google_android_gms_common_api_Api_zze.zzafk()) {
                i2 = 1;
            }
            i = com_google_android_gms_common_api_Api_zze.zzafz() ? 1 : i;
        }
        return i2 != 0 ? (i == 0 || !z) ? 1 : 2 : 3;
    }

    <C extends zze> C m17449a(zzc<?> com_google_android_gms_common_api_Api_zzc_) {
        Object obj = (zze) this.f11559c.get(com_google_android_gms_common_api_Api_zzc_);
        zzab.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    boolean m17450b() {
        return this.f11572p;
    }

    public ConnectionResult blockingConnect() {
        boolean z = true;
        zzab.zza(Looper.myLooper() != Looper.getMainLooper(), (Object) "blockingConnect must not be called on the UI thread");
        this.f11566j.lock();
        try {
            if (this.f11569m >= 0) {
                if (this.f11579w == null) {
                    z = false;
                }
                zzab.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f11579w == null) {
                this.f11579w = Integer.valueOf(zza(this.f11559c.values(), false));
            } else if (this.f11579w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m17443b(this.f11579w.intValue());
            this.f11567k.zzasx();
            ConnectionResult blockingConnect = this.f11568l.blockingConnect();
            return blockingConnect;
        } finally {
            this.f11566j.unlock();
        }
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        boolean z = false;
        if (Looper.myLooper() != Looper.getMainLooper()) {
            z = true;
        }
        zzab.zza(z, (Object) "blockingConnect must not be called on the UI thread");
        zzab.zzb((Object) timeUnit, (Object) "TimeUnit must not be null");
        this.f11566j.lock();
        try {
            if (this.f11579w == null) {
                this.f11579w = Integer.valueOf(zza(this.f11559c.values(), false));
            } else if (this.f11579w.intValue() == 2) {
                throw new IllegalStateException("Cannot call blockingConnect() when sign-in mode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            m17443b(this.f11579w.intValue());
            this.f11567k.zzasx();
            ConnectionResult blockingConnect = this.f11568l.blockingConnect(j, timeUnit);
            return blockingConnect;
        } finally {
            this.f11566j.unlock();
        }
    }

    void m17451c() {
        if (!m17450b()) {
            this.f11572p = true;
            if (this.f11558b == null) {
                this.f11558b = this.f11576t.zza(this.f11570n.getApplicationContext(), new zzb(this));
            }
            this.f11575s.sendMessageDelayed(this.f11575s.obtainMessage(1), this.f11573q);
            this.f11575s.sendMessageDelayed(this.f11575s.obtainMessage(2), this.f11574r);
        }
    }

    public PendingResult<Status> clearDefaultAccountAndReconnect() {
        zzab.zza(isConnected(), (Object) "GoogleApiClient is not connected yet.");
        zzab.zza(this.f11579w.intValue() != 2, (Object) "Cannot use clearDefaultAccountAndReconnect with GOOGLE_SIGN_IN_API");
        final PendingResult com_google_android_gms_internal_zzqu = new zzqu((GoogleApiClient) this);
        if (this.f11559c.containsKey(zzre.bJ)) {
            m17439a(this, com_google_android_gms_internal_zzqu, false);
        } else {
            final AtomicReference atomicReference = new AtomicReference();
            GoogleApiClient build = new Builder(this.f11570n).addApi(zzre.API).addConnectionCallbacks(new ConnectionCallbacks(this) {
                final /* synthetic */ zzpy f11548c;

                public void onConnected(Bundle bundle) {
                    this.f11548c.m17439a((GoogleApiClient) atomicReference.get(), com_google_android_gms_internal_zzqu, true);
                }

                public void onConnectionSuspended(int i) {
                }
            }).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ zzpy f11550b;

                public void onConnectionFailed(ConnectionResult connectionResult) {
                    com_google_android_gms_internal_zzqu.zzc(new Status(8));
                }
            }).setHandler(this.f11575s).build();
            atomicReference.set(build);
            build.connect();
        }
        return com_google_android_gms_internal_zzqu;
    }

    public void connect() {
        boolean z = false;
        this.f11566j.lock();
        try {
            if (this.f11569m >= 0) {
                if (this.f11579w != null) {
                    z = true;
                }
                zzab.zza(z, (Object) "Sign-in mode should have been set explicitly by auto-manage.");
            } else if (this.f11579w == null) {
                this.f11579w = Integer.valueOf(zza(this.f11559c.values(), false));
            } else if (this.f11579w.intValue() == 2) {
                throw new IllegalStateException("Cannot call connect() when SignInMode is set to SIGN_IN_MODE_OPTIONAL. Call connect(SIGN_IN_MODE_OPTIONAL) instead.");
            }
            connect(this.f11579w.intValue());
        } finally {
            this.f11566j.unlock();
        }
    }

    public void connect(int i) {
        boolean z = true;
        this.f11566j.lock();
        if (!(i == 3 || i == 1 || i == 2)) {
            z = false;
        }
        try {
            zzab.zzb(z, "Illegal sign-in mode: " + i);
            m17443b(i);
            m17446g();
        } finally {
            this.f11566j.unlock();
        }
    }

    boolean m17452d() {
        if (!m17450b()) {
            return false;
        }
        this.f11572p = false;
        this.f11575s.removeMessages(2);
        this.f11575s.removeMessages(1);
        if (this.f11558b != null) {
            this.f11558b.unregister();
            this.f11558b = null;
        }
        return true;
    }

    public void disconnect() {
        this.f11566j.lock();
        try {
            this.f11565i.release();
            if (this.f11568l != null) {
                this.f11568l.disconnect();
            }
            this.f11577u.release();
            for (com.google.android.gms.internal.zzpm.zza com_google_android_gms_internal_zzpm_zza : this.f11557a) {
                com_google_android_gms_internal_zzpm_zza.zza(null);
                com_google_android_gms_internal_zzpm_zza.cancel();
            }
            this.f11557a.clear();
            if (this.f11568l != null) {
                m17452d();
                this.f11567k.zzasw();
                this.f11566j.unlock();
            }
        } finally {
            this.f11566j.unlock();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("mContext=").println(this.f11570n);
        printWriter.append(str).append("mResuming=").print(this.f11572p);
        printWriter.append(" mWorkQueue.size()=").print(this.f11557a.size());
        this.f11565i.dump(printWriter);
        if (this.f11568l != null) {
            this.f11568l.dump(str, fileDescriptor, printWriter, strArr);
        }
    }

    boolean m17453e() {
        boolean z = false;
        this.f11566j.lock();
        try {
            if (this.f11564h != null) {
                if (!this.f11564h.isEmpty()) {
                    z = true;
                }
                this.f11566j.unlock();
            }
            return z;
        } finally {
            this.f11566j.unlock();
        }
    }

    String m17454f() {
        Writer stringWriter = new StringWriter();
        dump("", null, new PrintWriter(stringWriter), null);
        return stringWriter.toString();
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        this.f11566j.lock();
        try {
            if (!isConnected() && !m17450b()) {
                throw new IllegalStateException("Cannot invoke getConnectionResult unless GoogleApiClient is connected");
            } else if (this.f11559c.containsKey(api.zzans())) {
                ConnectionResult connectionResult = this.f11568l.getConnectionResult(api);
                if (connectionResult != null) {
                    this.f11566j.unlock();
                } else if (m17450b()) {
                    connectionResult = ConnectionResult.rb;
                } else {
                    Log.w("GoogleApiClientImpl", m17454f());
                    Log.wtf("GoogleApiClientImpl", String.valueOf(api.getName()).concat(" requested in getConnectionResult is not connected but is not present in the failed  connections map"), new Exception());
                    connectionResult = new ConnectionResult(8, null);
                    this.f11566j.unlock();
                }
                return connectionResult;
            } else {
                throw new IllegalArgumentException(String.valueOf(api.getName()).concat(" was never registered with GoogleApiClient"));
            }
        } finally {
            this.f11566j.unlock();
        }
    }

    public Context getContext() {
        return this.f11570n;
    }

    public Looper getLooper() {
        return this.f11571o;
    }

    public int getSessionId() {
        return System.identityHashCode(this);
    }

    public boolean hasConnectedApi(Api<?> api) {
        zze com_google_android_gms_common_api_Api_zze = (zze) this.f11559c.get(api.zzans());
        return com_google_android_gms_common_api_Api_zze != null && com_google_android_gms_common_api_Api_zze.isConnected();
    }

    public boolean isConnected() {
        return this.f11568l != null && this.f11568l.isConnected();
    }

    public boolean isConnecting() {
        return this.f11568l != null && this.f11568l.isConnecting();
    }

    public boolean isConnectionCallbacksRegistered(ConnectionCallbacks connectionCallbacks) {
        return this.f11567k.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    public boolean isConnectionFailedListenerRegistered(OnConnectionFailedListener onConnectionFailedListener) {
        return this.f11567k.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void reconnect() {
        disconnect();
        connect();
    }

    public void registerConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.f11567k.registerConnectionCallbacks(connectionCallbacks);
    }

    public void registerConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.f11567k.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void stopAutoManage(FragmentActivity fragmentActivity) {
        m17442a(new zzqi(fragmentActivity));
    }

    public void unregisterConnectionCallbacks(ConnectionCallbacks connectionCallbacks) {
        this.f11567k.unregisterConnectionCallbacks(connectionCallbacks);
    }

    public void unregisterConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        this.f11567k.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public <C extends zze> C zza(zzc<C> com_google_android_gms_common_api_Api_zzc_C) {
        Object obj = (zze) this.f11559c.get(com_google_android_gms_common_api_Api_zzc_C);
        zzab.zzb(obj, (Object) "Appropriate Api was not requested.");
        return obj;
    }

    public void zza(zzqx com_google_android_gms_internal_zzqx) {
        this.f11566j.lock();
        try {
            if (this.f11564h == null) {
                this.f11564h = new HashSet();
            }
            this.f11564h.add(com_google_android_gms_internal_zzqx);
        } finally {
            this.f11566j.unlock();
        }
    }

    public boolean zza(Api<?> api) {
        return this.f11559c.containsKey(api.zzans());
    }

    public boolean zza(zzqt com_google_android_gms_internal_zzqt) {
        return this.f11568l != null && this.f11568l.zza(com_google_android_gms_internal_zzqt);
    }

    public void zzaof() {
        if (this.f11568l != null) {
            this.f11568l.zzaof();
        }
    }

    public void zzb(zzqx com_google_android_gms_internal_zzqx) {
        this.f11566j.lock();
        try {
            if (this.f11564h == null) {
                Log.wtf("GoogleApiClientImpl", "Attempted to remove pending transform when no transforms are registered.", new Exception());
            } else if (!this.f11564h.remove(com_google_android_gms_internal_zzqx)) {
                Log.wtf("GoogleApiClientImpl", "Failed to remove pending transform - this may lead to memory leaks!", new Exception());
            } else if (!m17453e()) {
                this.f11568l.zzapb();
            }
            this.f11566j.unlock();
        } catch (Throwable th) {
            this.f11566j.unlock();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpm.zza<R, A>> T zzc(T t) {
        zzab.zzb(t.zzans() != null, (Object) "This task can not be enqueued (it's probably a Batch or malformed)");
        boolean containsKey = this.f11559c.containsKey(t.zzans());
        String name = t.zzanz() != null ? t.zzanz().getName() : "the API";
        zzab.zzb(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f11566j.lock();
        try {
            if (this.f11568l == null) {
                this.f11557a.add(t);
            } else {
                t = this.f11568l.zzc(t);
                this.f11566j.unlock();
            }
            return t;
        } finally {
            this.f11566j.unlock();
        }
    }

    public void zzc(int i, boolean z) {
        if (i == 1 && !z) {
            m17451c();
        }
        this.f11565i.zzaqz();
        this.f11567k.zzgf(i);
        this.f11567k.zzasw();
        if (i == 2) {
            m17446g();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpm.zza<? extends Result, A>> T zzd(T t) {
        zzab.zzb(t.zzans() != null, (Object) "This task can not be executed (it's probably a Batch or malformed)");
        boolean containsKey = this.f11559c.containsKey(t.zzans());
        String name = t.zzanz() != null ? t.zzanz().getName() : "the API";
        zzab.zzb(containsKey, new StringBuilder(String.valueOf(name).length() + 65).append("GoogleApiClient is not configured to use ").append(name).append(" required for this call.").toString());
        this.f11566j.lock();
        try {
            if (this.f11568l == null) {
                throw new IllegalStateException("GoogleApiClient is not connected yet.");
            }
            if (m17450b()) {
                this.f11557a.add(t);
                while (!this.f11557a.isEmpty()) {
                    com.google.android.gms.internal.zzpm.zza com_google_android_gms_internal_zzpm_zza = (com.google.android.gms.internal.zzpm.zza) this.f11557a.remove();
                    this.f11565i.m17534a(com_google_android_gms_internal_zzpm_zza);
                    com_google_android_gms_internal_zzpm_zza.zzz(Status.ss);
                }
            } else {
                t = this.f11568l.zzd(t);
                this.f11566j.unlock();
            }
            return t;
        } finally {
            this.f11566j.unlock();
        }
    }

    public void zzd(ConnectionResult connectionResult) {
        if (!this.f11576t.zzc(this.f11570n, connectionResult.getErrorCode())) {
            m17452d();
        }
        if (!m17450b()) {
            this.f11567k.zzm(connectionResult);
            this.f11567k.zzasw();
        }
    }

    public void zzm(Bundle bundle) {
        while (!this.f11557a.isEmpty()) {
            zzd((com.google.android.gms.internal.zzpm.zza) this.f11557a.remove());
        }
        this.f11567k.zzo(bundle);
    }

    public <L> zzqn<L> zzs(L l) {
        this.f11566j.lock();
        try {
            zzqn<L> zzb = this.f11577u.zzb(l, this.f11571o);
            return zzb;
        } finally {
            this.f11566j.unlock();
        }
    }
}
