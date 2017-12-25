package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.zzg;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class zzqa implements zzqh {
    final Map<zzc<?>, zze> f11582a;
    final Map<zzc<?>, ConnectionResult> f11583b = new HashMap();
    final zzg f11584c;
    final Map<Api<?>, Integer> f11585d;
    final com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> f11586e;
    int f11587f;
    final zzpy f11588g;
    final com.google.android.gms.internal.zzqh.zza f11589h;
    private final Lock f11590i;
    private final Condition f11591j;
    private final Context f11592k;
    private final com.google.android.gms.common.zzc f11593l;
    private final zzb f11594m;
    private volatile zzpz f11595n;
    private ConnectionResult f11596o = null;

    static abstract class zza {
        private final zzpz f11500a;

        protected zza(zzpz com_google_android_gms_internal_zzpz) {
            this.f11500a = com_google_android_gms_internal_zzpz;
        }

        protected abstract void zzapl();

        public final void zzd(zzqa com_google_android_gms_internal_zzqa) {
            com_google_android_gms_internal_zzqa.f11590i.lock();
            try {
                if (com_google_android_gms_internal_zzqa.f11595n == this.f11500a) {
                    zzapl();
                    com_google_android_gms_internal_zzqa.f11590i.unlock();
                }
            } finally {
                com_google_android_gms_internal_zzqa.f11590i.unlock();
            }
        }
    }

    final class zzb extends Handler {
        final /* synthetic */ zzqa f11581a;

        zzb(zzqa com_google_android_gms_internal_zzqa, Looper looper) {
            this.f11581a = com_google_android_gms_internal_zzqa;
            super(looper);
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    ((zza) message.obj).zzd(this.f11581a);
                    return;
                case 2:
                    throw ((RuntimeException) message.obj);
                default:
                    Log.w("GACStateManager", "Unknown message id: " + message.what);
                    return;
            }
        }
    }

    public zzqa(Context context, zzpy com_google_android_gms_internal_zzpy, Lock lock, Looper looper, com.google.android.gms.common.zzc com_google_android_gms_common_zzc, Map<zzc<?>, zze> map, zzg com_google_android_gms_common_internal_zzg, Map<Api<?>, Integer> map2, com.google.android.gms.common.api.Api.zza<? extends zzvu, zzvv> com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv, ArrayList<zzpp> arrayList, com.google.android.gms.internal.zzqh.zza com_google_android_gms_internal_zzqh_zza) {
        this.f11592k = context;
        this.f11590i = lock;
        this.f11593l = com_google_android_gms_common_zzc;
        this.f11582a = map;
        this.f11584c = com_google_android_gms_common_internal_zzg;
        this.f11585d = map2;
        this.f11586e = com_google_android_gms_common_api_Api_zza__extends_com_google_android_gms_internal_zzvu__com_google_android_gms_internal_zzvv;
        this.f11588g = com_google_android_gms_internal_zzpy;
        this.f11589h = com_google_android_gms_internal_zzqh_zza;
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((zzpp) it.next()).zza(this);
        }
        this.f11594m = new zzb(this, looper);
        this.f11591j = lock.newCondition();
        this.f11595n = new zzpx(this);
    }

    void m17457a() {
        this.f11590i.lock();
        try {
            this.f11595n = new zzpw(this, this.f11584c, this.f11585d, this.f11593l, this.f11586e, this.f11590i, this.f11592k);
            this.f11595n.begin();
            this.f11591j.signalAll();
        } finally {
            this.f11590i.unlock();
        }
    }

    void m17458a(ConnectionResult connectionResult) {
        this.f11590i.lock();
        try {
            this.f11596o = connectionResult;
            this.f11595n = new zzpx(this);
            this.f11595n.begin();
            this.f11591j.signalAll();
        } finally {
            this.f11590i.unlock();
        }
    }

    void m17459a(zza com_google_android_gms_internal_zzqa_zza) {
        this.f11594m.sendMessage(this.f11594m.obtainMessage(1, com_google_android_gms_internal_zzqa_zza));
    }

    void m17460a(RuntimeException runtimeException) {
        this.f11594m.sendMessage(this.f11594m.obtainMessage(2, runtimeException));
    }

    void m17461b() {
        this.f11590i.lock();
        try {
            this.f11588g.m17452d();
            this.f11595n = new zzpv(this);
            this.f11595n.begin();
            this.f11591j.signalAll();
        } finally {
            this.f11590i.unlock();
        }
    }

    public ConnectionResult blockingConnect() {
        connect();
        while (isConnecting()) {
            try {
                this.f11591j.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return new ConnectionResult(15, null);
            }
        }
        return isConnected() ? ConnectionResult.rb : this.f11596o != null ? this.f11596o : new ConnectionResult(13, null);
    }

    public ConnectionResult blockingConnect(long j, TimeUnit timeUnit) {
        connect();
        long toNanos = timeUnit.toNanos(j);
        while (isConnecting()) {
            if (toNanos <= 0) {
                try {
                    disconnect();
                    return new ConnectionResult(14, null);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return new ConnectionResult(15, null);
                }
            }
            toNanos = this.f11591j.awaitNanos(toNanos);
        }
        return isConnected() ? ConnectionResult.rb : this.f11596o != null ? this.f11596o : new ConnectionResult(13, null);
    }

    void m17462c() {
        for (zze disconnect : this.f11582a.values()) {
            disconnect.disconnect();
        }
    }

    public void connect() {
        this.f11595n.connect();
    }

    public void disconnect() {
        if (this.f11595n.disconnect()) {
            this.f11583b.clear();
        }
    }

    public void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        String concat = String.valueOf(str).concat("  ");
        printWriter.append(str).append("mState=").println(this.f11595n);
        for (Api api : this.f11585d.keySet()) {
            printWriter.append(str).append(api.getName()).println(":");
            ((zze) this.f11582a.get(api.zzans())).dump(concat, fileDescriptor, printWriter, strArr);
        }
    }

    public ConnectionResult getConnectionResult(Api<?> api) {
        zzc zzans = api.zzans();
        if (this.f11582a.containsKey(zzans)) {
            if (((zze) this.f11582a.get(zzans)).isConnected()) {
                return ConnectionResult.rb;
            }
            if (this.f11583b.containsKey(zzans)) {
                return (ConnectionResult) this.f11583b.get(zzans);
            }
        }
        return null;
    }

    public boolean isConnected() {
        return this.f11595n instanceof zzpv;
    }

    public boolean isConnecting() {
        return this.f11595n instanceof zzpw;
    }

    public void onConnected(Bundle bundle) {
        this.f11590i.lock();
        try {
            this.f11595n.onConnected(bundle);
        } finally {
            this.f11590i.unlock();
        }
    }

    public void onConnectionSuspended(int i) {
        this.f11590i.lock();
        try {
            this.f11595n.onConnectionSuspended(i);
        } finally {
            this.f11590i.unlock();
        }
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
        this.f11590i.lock();
        try {
            this.f11595n.zza(connectionResult, api, i);
        } finally {
            this.f11590i.unlock();
        }
    }

    public boolean zza(zzqt com_google_android_gms_internal_zzqt) {
        return false;
    }

    public void zzaof() {
    }

    public void zzapb() {
        if (isConnected()) {
            ((zzpv) this.f11595n).m17404a();
        }
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, R extends Result, T extends com.google.android.gms.internal.zzpm.zza<R, A>> T zzc(T t) {
        t.zzaow();
        return this.f11595n.zzc(t);
    }

    public <A extends com.google.android.gms.common.api.Api.zzb, T extends com.google.android.gms.internal.zzpm.zza<? extends Result, A>> T zzd(T t) {
        t.zzaow();
        return this.f11595n.zzd(t);
    }
}
