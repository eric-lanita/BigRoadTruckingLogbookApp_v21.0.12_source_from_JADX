package com.google.android.gms.internal;

import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v4.p008d.C0270a;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

final class zzpq implements zzqh {
    private final Context f11482a;
    private final zzpy f11483b;
    private final Looper f11484c;
    private final zzqa f11485d;
    private final zzqa f11486e;
    private final Map<zzc<?>, zzqa> f11487f;
    private final Set<zzqt> f11488g = Collections.newSetFromMap(new WeakHashMap());
    private final zze f11489h;
    private Bundle f11490i;
    private ConnectionResult f11491j = null;
    private ConnectionResult f11492k = null;
    private boolean f11493l = false;
    private final Lock f11494m;
    private int f11495n = 0;

    class C33151 implements Runnable {
        final /* synthetic */ zzpq f11479a;

        C33151(zzpq com_google_android_gms_internal_zzpq) {
            this.f11479a = com_google_android_gms_internal_zzpq;
        }

        public void run() {
            this.f11479a.f11494m.lock();
            try {
                this.f11479a.m17388b();
            } finally {
                this.f11479a.f11494m.unlock();
            }
        }
    }

    private class zza implements com.google.android.gms.internal.zzqh.zza {
        final /* synthetic */ zzpq f11480a;

        private zza(zzpq com_google_android_gms_internal_zzpq) {
            this.f11480a = com_google_android_gms_internal_zzpq;
        }

        public void zzc(int i, boolean z) {
            this.f11480a.f11494m.lock();
            try {
                if (this.f11480a.f11493l || this.f11480a.f11492k == null || !this.f11480a.f11492k.isSuccess()) {
                    this.f11480a.f11493l = false;
                    this.f11480a.m17380a(i, z);
                    return;
                }
                this.f11480a.f11493l = true;
                this.f11480a.f11486e.onConnectionSuspended(i);
                this.f11480a.f11494m.unlock();
            } finally {
                this.f11480a.f11494m.unlock();
            }
        }

        public void zzd(ConnectionResult connectionResult) {
            this.f11480a.f11494m.lock();
            try {
                this.f11480a.f11491j = connectionResult;
                this.f11480a.m17388b();
            } finally {
                this.f11480a.f11494m.unlock();
            }
        }

        public void zzm(Bundle bundle) {
            this.f11480a.f11494m.lock();
            try {
                this.f11480a.m17381a(bundle);
                this.f11480a.f11491j = ConnectionResult.rb;
                this.f11480a.m17388b();
            } finally {
                this.f11480a.f11494m.unlock();
            }
        }
    }

    private class zzb implements com.google.android.gms.internal.zzqh.zza {
        final /* synthetic */ zzpq f11481a;

        private zzb(zzpq com_google_android_gms_internal_zzpq) {
            this.f11481a = com_google_android_gms_internal_zzpq;
        }

        public void zzc(int i, boolean z) {
            this.f11481a.f11494m.lock();
            try {
                if (this.f11481a.f11493l) {
                    this.f11481a.f11493l = false;
                    this.f11481a.m17380a(i, z);
                    return;
                }
                this.f11481a.f11493l = true;
                this.f11481a.f11485d.onConnectionSuspended(i);
                this.f11481a.f11494m.unlock();
            } finally {
                this.f11481a.f11494m.unlock();
            }
        }

        public void zzd(ConnectionResult connectionResult) {
            this.f11481a.f11494m.lock();
            try {
                this.f11481a.f11492k = connectionResult;
                this.f11481a.m17388b();
            } finally {
                this.f11481a.f11494m.unlock();
            }
        }

        public void zzm(Bundle bundle) {
            this.f11481a.f11494m.lock();
            try {
                this.f11481a.f11492k = ConnectionResult.rb;
                this.f11481a.m17388b();
            } finally {
                this.f11481a.f11494m.unlock();
            }
        }
    }

    private zzpq(Context context, zzpy com_google_android_gms_internal_zzpy, Lock lock, Looper looper, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, Map<zzc<?>, zze> map, Map<zzc<?>, zze> map2, zzg com_google_android_gms_common_internal_zzg, com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, zze com_google_android_gms_common_api_Api_zze, ArrayList<zzpp> arrayList, ArrayList<zzpp> arrayList2, Map<Api<?>, Integer> map3, Map<Api<?>, Integer> map4) {
        this.f11482a = context;
        this.f11483b = com_google_android_gms_internal_zzpy;
        this.f11494m = lock;
        this.f11484c = looper;
        this.f11489h = com_google_android_gms_common_api_Api_zze;
        this.f11485d = new zzqa(context, this.f11483b, lock, looper, com_google_android_gms_common_zzc, map2, null, map4, null, arrayList2, new zza());
        this.f11486e = new zzqa(context, this.f11483b, lock, looper, com_google_android_gms_common_zzc, map, com_google_android_gms_common_internal_zzg, map3, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, arrayList, new zzb());
        Map c0270a = new C0270a();
        for (zzc put : map2.keySet()) {
            c0270a.put(put, this.f11485d);
        }
        for (zzc put2 : map.keySet()) {
            c0270a.put(put2, this.f11486e);
        }
        this.f11487f = Collections.unmodifiableMap(c0270a);
    }

    private void m17379a() {
        this.f11492k = null;
        this.f11491j = null;
        this.f11485d.connect();
        this.f11486e.connect();
    }

    private void m17380a(int i, boolean z) {
        this.f11483b.zzc(i, z);
        this.f11492k = null;
        this.f11491j = null;
    }

    private void m17381a(Bundle bundle) {
        if (this.f11490i == null) {
            this.f11490i = bundle;
        } else if (bundle != null) {
            this.f11490i.putAll(bundle);
        }
    }

    private void m17382a(ConnectionResult connectionResult) {
        switch (this.f11495n) {
            case 1:
                break;
            case 2:
                this.f11483b.zzd(connectionResult);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call failure callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new Exception());
                break;
        }
        m17394d();
        this.f11495n = 0;
    }

    private boolean m17385a(com.google.android.gms.internal.zzpm.zza<? extends Result, ? extends com.google.android.gms.common.api.Api.zzb> com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb) {
        zzc zzans = com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result___extends_com_google_android_gms_common_api_Api_zzb.zzans();
        zzab.zzb(this.f11487f.containsKey(zzans), (Object) "GoogleApiClient is not configured to use the API required for this call.");
        return ((zzqa) this.f11487f.get(zzans)).equals(this.f11486e);
    }

    private void m17388b() {
        if (m17390b(this.f11491j)) {
            if (m17390b(this.f11492k) || m17396e()) {
                m17391c();
            } else if (this.f11492k == null) {
            } else {
                if (this.f11495n == 1) {
                    m17394d();
                    return;
                }
                m17382a(this.f11492k);
                this.f11485d.disconnect();
            }
        } else if (this.f11491j != null && m17390b(this.f11492k)) {
            this.f11486e.disconnect();
            m17382a(this.f11491j);
        } else if (this.f11491j != null && this.f11492k != null) {
            ConnectionResult connectionResult = this.f11491j;
            if (this.f11486e.f11587f < this.f11485d.f11587f) {
                connectionResult = this.f11492k;
            }
            m17382a(connectionResult);
        }
    }

    private static boolean m17390b(ConnectionResult connectionResult) {
        return connectionResult != null && connectionResult.isSuccess();
    }

    private void m17391c() {
        switch (this.f11495n) {
            case 1:
                break;
            case 2:
                this.f11483b.zzm(this.f11490i);
                break;
            default:
                Log.wtf("CompositeGAC", "Attempted to call success callbacks in CONNECTION_MODE_NONE. Callbacks should be disabled via GmsClientSupervisor", new AssertionError());
                break;
        }
        m17394d();
        this.f11495n = 0;
    }

    private void m17394d() {
        for (zzqt zzafy : this.f11488g) {
            zzafy.zzafy();
        }
        this.f11488g.clear();
    }

    private boolean m17396e() {
        return this.f11492k != null && this.f11492k.getErrorCode() == 4;
    }

    private PendingIntent m17397f() {
        return this.f11489h == null ? null : PendingIntent.getActivity(this.f11482a, this.f11483b.getSessionId(), this.f11489h.zzaga(), 134217728);
    }

    public static zzpq zza(Context context, zzpy com_google_android_gms_internal_zzpy, Lock lock, Looper looper, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, Map<zzc<?>, zze> map, zzg com_google_android_gms_common_internal_zzg, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, ArrayList<zzpp> arrayList) {
        zze com_google_android_gms_common_api_Api_zze = null;
        Map c0270a = new C0270a();
        Map c0270a2 = new C0270a();
        for (Entry entry : map.entrySet()) {
            zze com_google_android_gms_common_api_Api_zze2 = (zze) entry.getValue();
            if (com_google_android_gms_common_api_Api_zze2.zzafz()) {
                com_google_android_gms_common_api_Api_zze = com_google_android_gms_common_api_Api_zze2;
            }
            if (com_google_android_gms_common_api_Api_zze2.zzafk()) {
                c0270a.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            } else {
                c0270a2.put((zzc) entry.getKey(), com_google_android_gms_common_api_Api_zze2);
            }
        }
        zzab.zza(!c0270a.isEmpty(), (Object) "CompositeGoogleApiClient should not be used without any APIs that require sign-in.");
        Map c0270a3 = new C0270a();
        Map c0270a4 = new C0270a();
        for (Api api : map2.keySet()) {
            zzc zzans = api.zzans();
            if (c0270a.containsKey(zzans)) {
                c0270a3.put(api, (Integer) map2.get(api));
            } else if (c0270a2.containsKey(zzans)) {
                c0270a4.put(api, (Integer) map2.get(api));
            } else {
                throw new IllegalStateException("Each API in the apiTypeMap must have a corresponding client in the clients map.");
            }
        }
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            zzpp com_google_android_gms_internal_zzpp = (zzpp) it.next();
            if (c0270a3.containsKey(com_google_android_gms_internal_zzpp.pN)) {
                arrayList2.add(com_google_android_gms_internal_zzpp);
            } else if (c0270a4.containsKey(com_google_android_gms_internal_zzpp.pN)) {
                arrayList3.add(com_google_android_gms_internal_zzpp);
            } else {
                throw new IllegalStateException("Each ClientCallbacks must have a corresponding API in the apiTypeMap");
            }
        }
        return new zzpq(context, com_google_android_gms_internal_zzpy, lock, looper, com_google_android_gms_common_zzc, c0270a, c0270a2, com_google_android_gms_common_internal_zzg, com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, com_google_android_gms_common_api_Api_zze, arrayList2, arrayList3, c0270a3, c0270a4);
    }

    public ConnectionResult blockingConnect() {
        throw new UnsupportedOperationException();
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    public void connect() {
        this.f11495n = 2;
        this.f11493l = false;
        m17379a();
    }

    public void disconnect() {
        this.f11492k = null;
        this.f11491j = null;
        this.f11495n = 0;
        this.f11485d.disconnect();
        this.f11486e.disconnect();
        m17394d();
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        printWriter.append(str).append("authClient").println(":");
        this.f11486e.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
        printWriter.append(str).append("anonClient").println(":");
        this.f11485d.dump(String.valueOf(str).concat("  "), fileDescriptor, printWriter, strArr);
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        return ((zzqa) this.f11487f.get(api.zzans())).equals(this.f11486e) ? m17396e() ? new ConnectionResult(4, m17397f()) : this.f11486e.getConnectionResult(api) : this.f11485d.getConnectionResult(api);
    }

    public boolean isConnected() {
        boolean z = true;
        this.f11494m.lock();
        try {
            if (!(this.f11485d.isConnected() && (zzapc() || m17396e() || this.f11495n == 1))) {
                z = false;
            }
            this.f11494m.unlock();
            return z;
        } catch (Throwable th) {
            this.f11494m.unlock();
        }
    }

    public boolean isConnecting() {
        this.f11494m.lock();
        try {
            boolean z = this.f11495n == 2;
            this.f11494m.unlock();
            return z;
        } catch (Throwable th) {
            this.f11494m.unlock();
        }
    }

    public boolean zza(zzqt com_google_android_gms_internal_zzqt) {
        this.f11494m.lock();
        try {
            if ((isConnecting() || isConnected()) && !zzapc()) {
                this.f11488g.add(com_google_android_gms_internal_zzqt);
                if (this.f11495n == 0) {
                    this.f11495n = 1;
                }
                this.f11492k = null;
                this.f11486e.connect();
                return true;
            }
            this.f11494m.unlock();
            return false;
        } finally {
            this.f11494m.unlock();
        }
    }

    public void zzaof() {
        this.f11494m.lock();
        try {
            boolean isConnecting = isConnecting();
            this.f11486e.disconnect();
            this.f11492k = new ConnectionResult(4);
            if (isConnecting) {
                new Handler(this.f11484c).post(new C33151(this));
            } else {
                m17394d();
            }
            this.f11494m.unlock();
        } catch (Throwable th) {
            this.f11494m.unlock();
        }
    }

    public void zzapb() {
        this.f11485d.zzapb();
        this.f11486e.zzapb();
    }

    public boolean zzapc() {
        return this.f11486e.isConnected();
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpm.zza<R, A>> T zzc(T t) {
        if (!m17385a((com.google.android.gms.internal.zzpm.zza) t)) {
            return this.f11485d.zzc(t);
        }
        if (!m17396e()) {
            return this.f11486e.zzc(t);
        }
        t.zzz(new Status(4, null, m17397f()));
        return t;
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpm.zza<? extends Result, A>> T zzd(T t) {
        if (!m17385a((com.google.android.gms.internal.zzpm.zza) t)) {
            return this.f11485d.zzd(t);
        }
        if (!m17396e()) {
            return this.f11486e.zzd(t);
        }
        t.zzz(new Status(4, null, m17397f()));
        return t;
    }
}
