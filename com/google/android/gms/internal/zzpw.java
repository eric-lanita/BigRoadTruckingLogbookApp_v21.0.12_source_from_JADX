package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Looper;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzq;
import com.google.android.gms.signin.internal.SignInResponse;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Future;
import java.util.concurrent.locks.Lock;

public class zzpw implements zzpz {
    private final zzqa f11523a;
    private final Lock f11524b;
    private final Context f11525c;
    private final com.google.android.gms.common.zzc f11526d;
    private ConnectionResult f11527e;
    private int f11528f;
    private int f11529g = 0;
    private int f11530h;
    private final Bundle f11531i = new Bundle();
    private final Set<com.google.android.gms.common.api.Api.zzc> f11532j = new HashSet();
    private zzvu f11533k;
    private int f11534l;
    private boolean f11535m;
    private boolean f11536n;
    private zzq f11537o;
    private boolean f11538p;
    private boolean f11539q;
    private final zzg f11540r;
    private final Map<Api<?>, Integer> f11541s;
    private final com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> f11542t;
    private ArrayList<Future<?>> f11543u = new ArrayList();

    class C33181 implements Runnable {
        final /* synthetic */ zzpw f11505a;

        C33181(zzpw com_google_android_gms_internal_zzpw) {
            this.f11505a = com_google_android_gms_internal_zzpw;
        }

        public void run() {
            this.f11505a.f11526d.zzbp(this.f11505a.f11525c);
        }
    }

    private static class zza implements com.google.android.gms.common.internal.zzd.zzf {
        private final WeakReference<zzpw> f11506a;
        private final Api<?> f11507b;
        private final int f11508c;

        public zza(zzpw com_google_android_gms_internal_zzpw, Api<?> api, int i) {
            this.f11506a = new WeakReference(com_google_android_gms_internal_zzpw);
            this.f11507b = api;
            this.f11508c = i;
        }

        public void zzh(ConnectionResult connectionResult) {
            boolean z = false;
            zzpw com_google_android_gms_internal_zzpw = (zzpw) this.f11506a.get();
            if (com_google_android_gms_internal_zzpw != null) {
                if (Looper.myLooper() == com_google_android_gms_internal_zzpw.f11523a.f11588g.getLooper()) {
                    z = true;
                }
                zzab.zza(z, (Object) "onReportServiceBinding must be called on the GoogleApiClient handler thread");
                com_google_android_gms_internal_zzpw.f11524b.lock();
                try {
                    if (com_google_android_gms_internal_zzpw.m17414a(0)) {
                        if (!connectionResult.isSuccess()) {
                            com_google_android_gms_internal_zzpw.m17407a(connectionResult, this.f11507b, this.f11508c);
                        }
                        if (com_google_android_gms_internal_zzpw.m17413a()) {
                            com_google_android_gms_internal_zzpw.m17420b();
                        }
                        com_google_android_gms_internal_zzpw.f11524b.unlock();
                    }
                } finally {
                    com_google_android_gms_internal_zzpw.f11524b.unlock();
                }
            }
        }
    }

    private abstract class zzf implements Runnable {
        final /* synthetic */ zzpw f11513b;

        private zzf(zzpw com_google_android_gms_internal_zzpw) {
            this.f11513b = com_google_android_gms_internal_zzpw;
        }

        public void run() {
            this.f11513b.f11524b.lock();
            try {
                if (!Thread.interrupted()) {
                    zzapl();
                    this.f11513b.f11524b.unlock();
                }
            } catch (RuntimeException e) {
                this.f11513b.f11523a.m17460a(e);
            } finally {
                this.f11513b.f11524b.unlock();
            }
        }

        protected abstract void zzapl();
    }

    private class zzb extends zzf {
        final /* synthetic */ zzpw f11514a;
        private final Map<com.google.android.gms.common.api.Api.zze, zza> f11515c;

        public zzb(zzpw com_google_android_gms_internal_zzpw, Map<com.google.android.gms.common.api.Api.zze, zza> map) {
            this.f11514a = com_google_android_gms_internal_zzpw;
            super();
            this.f11515c = map;
        }

        public void zzapl() {
            int i;
            int i2 = 1;
            int i3 = 0;
            int i4 = 1;
            int i5 = 0;
            for (com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze : this.f11515c.keySet()) {
                if (!com_google_android_gms_common_api_Api_zze.zzanu()) {
                    i = 0;
                    i4 = i5;
                } else if (((zza) this.f11515c.get(com_google_android_gms_common_api_Api_zze)).f11508c == 0) {
                    i = 1;
                    break;
                } else {
                    i = i4;
                    i4 = 1;
                }
                i5 = i4;
                i4 = i;
            }
            i2 = i5;
            i = 0;
            if (i2 != 0) {
                i3 = this.f11514a.f11526d.isGooglePlayServicesAvailable(this.f11514a.f11525c);
            }
            if (i3 == 0 || (r0 == 0 && i4 == 0)) {
                if (this.f11514a.f11535m) {
                    this.f11514a.f11533k.connect();
                }
                for (com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze2 : this.f11515c.keySet()) {
                    final com.google.android.gms.common.internal.zzd.zzf com_google_android_gms_common_internal_zzd_zzf = (com.google.android.gms.common.internal.zzd.zzf) this.f11515c.get(com_google_android_gms_common_api_Api_zze2);
                    if (!com_google_android_gms_common_api_Api_zze2.zzanu() || i3 == 0) {
                        com_google_android_gms_common_api_Api_zze2.zza(com_google_android_gms_common_internal_zzd_zzf);
                    } else {
                        this.f11514a.f11523a.m17459a(new zza(this, this.f11514a) {
                            final /* synthetic */ zzb f11512b;

                            public void zzapl() {
                                com_google_android_gms_common_internal_zzd_zzf.zzh(new ConnectionResult(16, null));
                            }
                        });
                    }
                }
                return;
            }
            final ConnectionResult connectionResult = new ConnectionResult(i3, null);
            this.f11514a.f11523a.m17459a(new zza(this, this.f11514a) {
                final /* synthetic */ zzb f11510b;

                public void zzapl() {
                    this.f11510b.f11514a.m17425c(connectionResult);
                }
            });
        }
    }

    private class zzc extends zzf {
        final /* synthetic */ zzpw f11516a;
        private final ArrayList<com.google.android.gms.common.api.Api.zze> f11517c;

        public zzc(zzpw com_google_android_gms_internal_zzpw, ArrayList<com.google.android.gms.common.api.Api.zze> arrayList) {
            this.f11516a = com_google_android_gms_internal_zzpw;
            super();
            this.f11517c = arrayList;
        }

        public void zzapl() {
            this.f11516a.f11523a.f11588g.f11560d = this.f11516a.m17432g();
            Iterator it = this.f11517c.iterator();
            while (it.hasNext()) {
                ((com.google.android.gms.common.api.Api.zze) it.next()).zza(this.f11516a.f11537o, this.f11516a.f11523a.f11588g.f11560d);
            }
        }
    }

    private static class zzd extends com.google.android.gms.signin.internal.zzb {
        private final WeakReference<zzpw> f11521a;

        zzd(zzpw com_google_android_gms_internal_zzpw) {
            this.f11521a = new WeakReference(com_google_android_gms_internal_zzpw);
        }

        public void zzb(final SignInResponse signInResponse) {
            final zzpw com_google_android_gms_internal_zzpw = (zzpw) this.f11521a.get();
            if (com_google_android_gms_internal_zzpw != null) {
                com_google_android_gms_internal_zzpw.f11523a.m17459a(new zza(this, com_google_android_gms_internal_zzpw) {
                    final /* synthetic */ zzd f11520c;

                    public void zzapl() {
                        com_google_android_gms_internal_zzpw.m17411a(signInResponse);
                    }
                });
            }
        }
    }

    private class zze implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzpw f11522a;

        private zze(zzpw com_google_android_gms_internal_zzpw) {
            this.f11522a = com_google_android_gms_internal_zzpw;
        }

        public void onConnected(Bundle bundle) {
            this.f11522a.f11533k.zza(new zzd(this.f11522a));
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.f11522a.f11524b.lock();
            try {
                if (this.f11522a.m17421b(connectionResult)) {
                    this.f11522a.m17428e();
                    this.f11522a.m17420b();
                } else {
                    this.f11522a.m17425c(connectionResult);
                }
                this.f11522a.f11524b.unlock();
            } catch (Throwable th) {
                this.f11522a.f11524b.unlock();
            }
        }

        public void onConnectionSuspended(int i) {
        }
    }

    public zzpw(zzqa com_google_android_gms_internal_zzqa, zzg com_google_android_gms_common_internal_zzg, Map<Api<?>, Integer> map, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, Lock lock, Context context) {
        this.f11523a = com_google_android_gms_internal_zzqa;
        this.f11540r = com_google_android_gms_common_internal_zzg;
        this.f11541s = map;
        this.f11526d = com_google_android_gms_common_zzc;
        this.f11542t = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv;
        this.f11524b = lock;
        this.f11525c = context;
    }

    private void m17407a(ConnectionResult connectionResult, Api<?> api, int i) {
        if (i != 2) {
            int priority = api.zzanp().getPriority();
            if (m17415a(priority, i, connectionResult)) {
                this.f11527e = connectionResult;
                this.f11528f = priority;
            }
        }
        this.f11523a.f11583b.put(api.zzans(), connectionResult);
    }

    private void m17411a(SignInResponse signInResponse) {
        if (m17414a(0)) {
            ConnectionResult zzath = signInResponse.zzath();
            if (zzath.isSuccess()) {
                ResolveAccountResponse zzbzz = signInResponse.zzbzz();
                ConnectionResult zzath2 = zzbzz.zzath();
                if (zzath2.isSuccess()) {
                    this.f11536n = true;
                    this.f11537o = zzbzz.zzatg();
                    this.f11538p = zzbzz.zzati();
                    this.f11539q = zzbzz.zzatj();
                    m17420b();
                    return;
                }
                String valueOf = String.valueOf(zzath2);
                Log.wtf("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 48).append("Sign-in succeeded with resolve account failure: ").append(valueOf).toString(), new Exception());
                m17425c(zzath2);
            } else if (m17421b(zzath)) {
                m17428e();
                m17420b();
            } else {
                m17425c(zzath);
            }
        }
    }

    private void m17412a(boolean z) {
        if (this.f11533k != null) {
            if (this.f11533k.isConnected() && z) {
                this.f11533k.zzbzo();
            }
            this.f11533k.disconnect();
            this.f11537o = null;
        }
    }

    private boolean m17413a() {
        this.f11530h--;
        if (this.f11530h > 0) {
            return false;
        }
        if (this.f11530h < 0) {
            Log.w("GoogleApiClientConnecting", this.f11523a.f11588g.m17454f());
            Log.wtf("GoogleApiClientConnecting", "GoogleApiClient received too many callbacks for the given step. Clients may be in an unexpected state; GoogleApiClient will now disconnect.", new Exception());
            m17425c(new ConnectionResult(8, null));
            return false;
        } else if (this.f11527e == null) {
            return true;
        } else {
            this.f11523a.f11587f = this.f11528f;
            m17425c(this.f11527e);
            return false;
        }
    }

    private boolean m17414a(int i) {
        if (this.f11529g == i) {
            return true;
        }
        Log.w("GoogleApiClientConnecting", this.f11523a.f11588g.m17454f());
        String valueOf = String.valueOf(this);
        Log.w("GoogleApiClientConnecting", new StringBuilder(String.valueOf(valueOf).length() + 23).append("Unexpected callback in ").append(valueOf).toString());
        Log.w("GoogleApiClientConnecting", "mRemainingConnections=" + this.f11530h);
        valueOf = String.valueOf(m17419b(this.f11529g));
        String valueOf2 = String.valueOf(m17419b(i));
        Log.wtf("GoogleApiClientConnecting", new StringBuilder((String.valueOf(valueOf).length() + 70) + String.valueOf(valueOf2).length()).append("GoogleApiClient connecting is in step ").append(valueOf).append(" but received callback for step ").append(valueOf2).toString(), new Exception());
        m17425c(new ConnectionResult(8, null));
        return false;
    }

    private boolean m17415a(int i, int i2, ConnectionResult connectionResult) {
        return (i2 != 1 || m17416a(connectionResult)) ? this.f11527e == null || i < this.f11528f : false;
    }

    private boolean m17416a(ConnectionResult connectionResult) {
        return connectionResult.hasResolution() || this.f11526d.zzfc(connectionResult.getErrorCode()) != null;
    }

    private String m17419b(int i) {
        switch (i) {
            case 0:
                return "STEP_SERVICE_BINDINGS_AND_SIGN_IN";
            case 1:
                return "STEP_GETTING_REMOTE_SERVICE";
            default:
                return "UNKNOWN";
        }
    }

    private void m17420b() {
        if (this.f11530h == 0) {
            if (!this.f11535m || this.f11536n) {
                m17424c();
            }
        }
    }

    private boolean m17421b(ConnectionResult connectionResult) {
        return this.f11534l != 2 ? this.f11534l == 1 && !connectionResult.hasResolution() : true;
    }

    private void m17424c() {
        ArrayList arrayList = new ArrayList();
        this.f11529g = 1;
        this.f11530h = this.f11523a.f11582a.size();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.f11523a.f11582a.keySet()) {
            if (!this.f11523a.f11583b.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                arrayList.add((com.google.android.gms.common.api.Api.zze) this.f11523a.f11582a.get(com_google_android_gms_common_api_Api_zzc));
            } else if (m17413a()) {
                m17427d();
            }
        }
        if (!arrayList.isEmpty()) {
            this.f11543u.add(zzqb.zzaqc().submit(new zzc(this, arrayList)));
        }
    }

    private void m17425c(ConnectionResult connectionResult) {
        m17431f();
        m17412a(!connectionResult.hasResolution());
        this.f11523a.m17458a(connectionResult);
        this.f11523a.f11589h.zzd(connectionResult);
    }

    private void m17427d() {
        this.f11523a.m17461b();
        zzqb.zzaqc().execute(new C33181(this));
        if (this.f11533k != null) {
            if (this.f11538p) {
                this.f11533k.zza(this.f11537o, this.f11539q);
            }
            m17412a(false);
        }
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.f11523a.f11583b.keySet()) {
            ((com.google.android.gms.common.api.Api.zze) this.f11523a.f11582a.get(com_google_android_gms_common_api_Api_zzc)).disconnect();
        }
        this.f11523a.f11589h.zzm(this.f11531i.isEmpty() ? null : this.f11531i);
    }

    private void m17428e() {
        this.f11535m = false;
        this.f11523a.f11588g.f11560d = Collections.emptySet();
        for (com.google.android.gms.common.api.Api.zzc com_google_android_gms_common_api_Api_zzc : this.f11532j) {
            if (!this.f11523a.f11583b.containsKey(com_google_android_gms_common_api_Api_zzc)) {
                this.f11523a.f11583b.put(com_google_android_gms_common_api_Api_zzc, new ConnectionResult(17, null));
            }
        }
    }

    private void m17431f() {
        Iterator it = this.f11543u.iterator();
        while (it.hasNext()) {
            ((Future) it.next()).cancel(true);
        }
        this.f11543u.clear();
    }

    private Set<Scope> m17432g() {
        if (this.f11540r == null) {
            return Collections.emptySet();
        }
        Set<Scope> hashSet = new HashSet(this.f11540r.zzasj());
        Map zzasl = this.f11540r.zzasl();
        for (Api api : zzasl.keySet()) {
            if (!this.f11523a.f11583b.containsKey(api.zzans())) {
                hashSet.addAll(((com.google.android.gms.common.internal.zzg.zza) zzasl.get(api)).dT);
            }
        }
        return hashSet;
    }

    public void begin() {
        this.f11523a.f11583b.clear();
        this.f11535m = false;
        this.f11527e = null;
        this.f11529g = 0;
        this.f11534l = 2;
        this.f11536n = false;
        this.f11538p = false;
        Map hashMap = new HashMap();
        int i = 0;
        for (Api api : this.f11541s.keySet()) {
            com.google.android.gms.common.api.Api.zze com_google_android_gms_common_api_Api_zze = (com.google.android.gms.common.api.Api.zze) this.f11523a.f11582a.get(api.zzans());
            int intValue = ((Integer) this.f11541s.get(api)).intValue();
            int i2 = (api.zzanp().getPriority() == 1 ? 1 : 0) | i;
            if (com_google_android_gms_common_api_Api_zze.zzafk()) {
                this.f11535m = true;
                if (intValue < this.f11534l) {
                    this.f11534l = intValue;
                }
                if (intValue != 0) {
                    this.f11532j.add(api.zzans());
                }
            }
            hashMap.put(com_google_android_gms_common_api_Api_zze, new zza(this, api, intValue));
            i = i2;
        }
        if (i != 0) {
            this.f11535m = false;
        }
        if (this.f11535m) {
            this.f11540r.zzc(Integer.valueOf(this.f11523a.f11588g.getSessionId()));
            ConnectionCallbacks com_google_android_gms_internal_zzpw_zze = new zze();
            this.f11533k = (zzvu) this.f11542t.zza(this.f11525c, this.f11523a.f11588g.getLooper(), this.f11540r, this.f11540r.zzasp(), com_google_android_gms_internal_zzpw_zze, com_google_android_gms_internal_zzpw_zze);
        }
        this.f11530h = this.f11523a.f11582a.size();
        this.f11543u.add(zzqb.zzaqc().submit(new zzb(this, hashMap)));
    }

    public void connect() {
    }

    public boolean disconnect() {
        m17431f();
        m17412a(true);
        this.f11523a.m17458a(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
        if (m17414a(1)) {
            if (bundle != null) {
                this.f11531i.putAll(bundle);
            }
            if (m17413a()) {
                m17427d();
            }
        }
    }

    public void onConnectionSuspended(int i) {
        m17425c(new ConnectionResult(8, null));
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        if (m17414a(1)) {
            m17407a(connectionResult, (Api) api, i);
            if (m17413a()) {
                m17427d();
            }
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpm.zza<R, A>> T zzc(T t) {
        this.f11523a.f11588g.f11557a.add(t);
        return t;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpm.zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
