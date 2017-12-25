package com.google.android.gms.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.Process;
import android.support.v4.p008d.C0270a;
import android.util.Log;
import android.util.Pair;
import android.util.SparseArray;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.Api.zzh;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.common.internal.zzd.zzf;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.tasks.TaskCompletionSource;
import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class zzqc implements Callback {
    private static final Object f11618d = new Object();
    private static zzqc f11619e;
    private long f11620a;
    private long f11621b;
    private long f11622c;
    private final Context f11623f;
    private final GoogleApiAvailability f11624g;
    private int f11625h;
    private final AtomicInteger f11626i;
    private final SparseArray<zzc<?>> f11627j;
    private final Map<zzpj<?>, zzc<?>> f11628k;
    private zzpr f11629l;
    private final Set<zzpj<?>> f11630m;
    private final Handler f11631n;
    private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> f11632o;
    private final SparseArray<zza> f11633p;
    private zzb f11634q;

    private final class zza extends PhantomReference<com.google.android.gms.common.api.zzc<?>> {
        final /* synthetic */ zzqc f11598a;
        private final int f11599b;

        public zza(zzqc com_google_android_gms_internal_zzqc, com.google.android.gms.common.api.zzc com_google_android_gms_common_api_zzc, int i, ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue) {
            this.f11598a = com_google_android_gms_internal_zzqc;
            super(com_google_android_gms_common_api_zzc, referenceQueue);
            this.f11599b = i;
        }

        public void zzaqg() {
            this.f11598a.f11631n.sendMessage(this.f11598a.f11631n.obtainMessage(2, this.f11599b, 2));
        }
    }

    private static final class zzb extends Thread {
        private final ReferenceQueue<com.google.android.gms.common.api.zzc<?>> f11600a;
        private final SparseArray<zza> f11601b;
        private final AtomicBoolean f11602c = new AtomicBoolean();

        public zzb(ReferenceQueue<com.google.android.gms.common.api.zzc<?>> referenceQueue, SparseArray<zza> sparseArray) {
            super("GoogleApiCleanup");
            this.f11600a = referenceQueue;
            this.f11601b = sparseArray;
        }

        public void run() {
            this.f11602c.set(true);
            Process.setThreadPriority(10);
            while (this.f11602c.get()) {
                try {
                    zza com_google_android_gms_internal_zzqc_zza = (zza) this.f11600a.remove();
                    this.f11601b.remove(com_google_android_gms_internal_zzqc_zza.f11599b);
                    com_google_android_gms_internal_zzqc_zza.zzaqg();
                } catch (InterruptedException e) {
                } finally {
                    this.f11602c.set(false);
                }
            }
        }
    }

    private class zzc<O extends ApiOptions> implements ConnectionCallbacks, OnConnectionFailedListener {
        final /* synthetic */ zzqc f11605a;
        private final Queue<zzpi> f11606b = new LinkedList();
        private final zze f11607c;
        private final com.google.android.gms.common.api.Api.zzb f11608d;
        private final zzpj<O> f11609e;
        private final SparseArray<zzqy> f11610f = new SparseArray();
        private final Set<zzpl> f11611g = new HashSet();
        private final SparseArray<Map<Object, com.google.android.gms.internal.zzpm.zza>> f11612h = new SparseArray();
        private boolean f11613i;
        private ConnectionResult f11614j = null;

        public zzc(zzqc com_google_android_gms_internal_zzqc, com.google.android.gms.common.api.zzc<O> com_google_android_gms_common_api_zzc_O) {
            this.f11605a = com_google_android_gms_internal_zzqc;
            this.f11607c = m17465a((com.google.android.gms.common.api.zzc) com_google_android_gms_common_api_zzc_O);
            if (this.f11607c instanceof zzah) {
                this.f11608d = ((zzah) this.f11607c).zzatn();
            } else {
                this.f11608d = this.f11607c;
            }
            this.f11609e = com_google_android_gms_common_api_zzc_O.zzaob();
        }

        private zze m17465a(com.google.android.gms.common.api.zzc com_google_android_gms_common_api_zzc) {
            Api zzanz = com_google_android_gms_common_api_zzc.zzanz();
            if (!zzanz.zzant()) {
                return com_google_android_gms_common_api_zzc.zzanz().zzanq().zza(com_google_android_gms_common_api_zzc.getApplicationContext(), this.f11605a.f11631n.getLooper(), zzg.zzcd(com_google_android_gms_common_api_zzc.getApplicationContext()), com_google_android_gms_common_api_zzc.zzaoa(), this, this);
            }
            zzh zzanr = zzanz.zzanr();
            return new zzah(com_google_android_gms_common_api_zzc.getApplicationContext(), this.f11605a.f11631n.getLooper(), zzanr.zzanw(), this, this, zzg.zzcd(com_google_android_gms_common_api_zzc.getApplicationContext()), zzanr.zzr(com_google_android_gms_common_api_zzc.zzaoa()));
        }

        private void m17466a(ConnectionResult connectionResult) {
            for (zzpl zza : this.f11611g) {
                zza.zza(this.f11609e, connectionResult);
            }
            this.f11611g.clear();
        }

        private void m17467a(Status status) {
            for (zzpi zzx : this.f11606b) {
                zzx.zzx(status);
            }
            this.f11606b.clear();
        }

        private void m17468a(zzpi com_google_android_gms_internal_zzpi) {
            com_google_android_gms_internal_zzpi.zza(this.f11610f);
            Map map;
            if (com_google_android_gms_internal_zzpi.iq == 3) {
                try {
                    Map map2;
                    map = (Map) this.f11612h.get(com_google_android_gms_internal_zzpi.sx);
                    if (map == null) {
                        C0270a c0270a = new C0270a(1);
                        this.f11612h.put(com_google_android_gms_internal_zzpi.sx, c0270a);
                        map2 = c0270a;
                    } else {
                        map2 = map;
                    }
                    com.google.android.gms.internal.zzpm.zza com_google_android_gms_internal_zzpm_zza = ((com.google.android.gms.internal.zzpi.zza) com_google_android_gms_internal_zzpi).sy;
                    map2.put(((zzqm) com_google_android_gms_internal_zzpm_zza).zzaqu(), com_google_android_gms_internal_zzpm_zza);
                } catch (ClassCastException e) {
                    throw new IllegalStateException("Listener registration methods must implement ListenerApiMethod");
                }
            } else if (com_google_android_gms_internal_zzpi.iq == 4) {
                try {
                    map = (Map) this.f11612h.get(com_google_android_gms_internal_zzpi.sx);
                    zzqm com_google_android_gms_internal_zzqm = (zzqm) ((com.google.android.gms.internal.zzpi.zza) com_google_android_gms_internal_zzpi).sy;
                    if (map != null) {
                        map.remove(com_google_android_gms_internal_zzqm.zzaqu());
                    } else {
                        Log.w("GoogleApiManager", "Received call to unregister a listener without a matching registration call.");
                    }
                } catch (ClassCastException e2) {
                    throw new IllegalStateException("Listener unregistration methods must implement ListenerApiMethod");
                }
            }
            try {
                com_google_android_gms_internal_zzpi.zzb(this.f11608d);
            } catch (DeadObjectException e3) {
                this.f11607c.disconnect();
                onConnectionSuspended(1);
            }
        }

        private void m17472c() {
            if (this.f11613i) {
                m17480h();
            }
        }

        private void m17474d() {
            if (this.f11613i) {
                this.f11605a.f11631n.removeMessages(9, this.f11609e);
                this.f11605a.f11631n.removeMessages(8, this.f11609e);
                this.f11613i = false;
            }
        }

        private void m17477e() {
            if (this.f11613i) {
                m17474d();
                m17467a(this.f11605a.f11624g.isGooglePlayServicesAvailable(this.f11605a.f11623f) == 18 ? new Status(8, "Connection timed out while waiting for Google Play services update to complete.") : new Status(8, "API failed to connect while resuming due to an unknown error."));
                this.f11607c.disconnect();
            }
        }

        private void m17478f() {
            this.f11605a.f11631n.removeMessages(10, this.f11609e);
            this.f11605a.f11631n.sendMessageDelayed(this.f11605a.f11631n.obtainMessage(10, this.f11609e), this.f11605a.f11622c);
        }

        private void m17479g() {
            if (this.f11607c.isConnected() && this.f11612h.size() == 0) {
                for (int i = 0; i < this.f11610f.size(); i++) {
                    if (((zzqy) this.f11610f.get(this.f11610f.keyAt(i))).zzara()) {
                        m17478f();
                        return;
                    }
                }
                this.f11607c.disconnect();
            }
        }

        private void m17480h() {
            if (!this.f11607c.isConnected() && !this.f11607c.isConnecting()) {
                if (this.f11607c.zzanu() && this.f11605a.f11625h != 0) {
                    this.f11605a.f11625h = this.f11605a.f11624g.isGooglePlayServicesAvailable(this.f11605a.f11623f);
                    if (this.f11605a.f11625h != 0) {
                        onConnectionFailed(new ConnectionResult(this.f11605a.f11625h, null));
                        return;
                    }
                }
                this.f11607c.zza(new zzd(this.f11605a, this.f11607c, this.f11609e));
            }
        }

        ConnectionResult m17481a() {
            return this.f11614j;
        }

        boolean m17482b() {
            return this.f11607c.isConnected();
        }

        public void onConnected(Bundle bundle) {
            zzaqi();
            m17466a(ConnectionResult.rb);
            m17474d();
            for (int i = 0; i < this.f11612h.size(); i++) {
                for (com.google.android.gms.internal.zzpm.zza zzb : ((Map) this.f11612h.get(this.f11612h.keyAt(i))).values()) {
                    try {
                        zzb.zzb(this.f11608d);
                    } catch (DeadObjectException e) {
                        this.f11607c.disconnect();
                        onConnectionSuspended(1);
                    }
                }
            }
            zzaqh();
            m17478f();
        }

        /* JADX WARNING: inconsistent code. */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onConnectionFailed(com.google.android.gms.common.ConnectionResult r6) {
            /*
            r5 = this;
            r5.zzaqi();
            r0 = r5.f11605a;
            r1 = -1;
            r0.f11625h = r1;
            r5.m17466a(r6);
            r0 = r5.f11610f;
            r1 = 0;
            r0 = r0.keyAt(r1);
            r1 = r5.f11606b;
            r1 = r1.isEmpty();
            if (r1 == 0) goto L_0x001e;
        L_0x001b:
            r5.f11614j = r6;
        L_0x001d:
            return;
        L_0x001e:
            r1 = com.google.android.gms.internal.zzqc.f11618d;
            monitor-enter(r1);
            r2 = r5.f11605a;	 Catch:{ all -> 0x0044 }
            r2 = null;	 Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047;
        L_0x002b:
            r2 = r5.f11605a;	 Catch:{ all -> 0x0044 }
            r2 = r2.f11630m;	 Catch:{ all -> 0x0044 }
            r3 = r5.f11609e;	 Catch:{ all -> 0x0044 }
            r2 = r2.contains(r3);	 Catch:{ all -> 0x0044 }
            if (r2 == 0) goto L_0x0047;
        L_0x0039:
            r2 = r5.f11605a;	 Catch:{ all -> 0x0044 }
            r2 = null;	 Catch:{ all -> 0x0044 }
            r2.zzb(r6, r0);	 Catch:{ all -> 0x0044 }
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            goto L_0x001d;
        L_0x0044:
            r0 = move-exception;
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            throw r0;
        L_0x0047:
            monitor-exit(r1);	 Catch:{ all -> 0x0044 }
            r1 = r5.f11605a;
            r0 = r1.m17502a(r6, r0);
            if (r0 != 0) goto L_0x001d;
        L_0x0050:
            r0 = r6.getErrorCode();
            r1 = 18;
            if (r0 != r1) goto L_0x005b;
        L_0x0058:
            r0 = 1;
            r5.f11613i = r0;
        L_0x005b:
            r0 = r5.f11613i;
            if (r0 == 0) goto L_0x007d;
        L_0x005f:
            r0 = r5.f11605a;
            r0 = r0.f11631n;
            r1 = r5.f11605a;
            r1 = r1.f11631n;
            r2 = 8;
            r3 = r5.f11609e;
            r1 = android.os.Message.obtain(r1, r2, r3);
            r2 = r5.f11605a;
            r2 = r2.f11620a;
            r0.sendMessageDelayed(r1, r2);
            goto L_0x001d;
        L_0x007d:
            r0 = new com.google.android.gms.common.api.Status;
            r1 = 17;
            r2 = r5.f11609e;
            r2 = r2.zzaon();
            r2 = java.lang.String.valueOf(r2);
            r3 = new java.lang.StringBuilder;
            r4 = java.lang.String.valueOf(r2);
            r4 = r4.length();
            r4 = r4 + 38;
            r3.<init>(r4);
            r4 = "API: ";
            r3 = r3.append(r4);
            r2 = r3.append(r2);
            r3 = " is not available on this device.";
            r2 = r2.append(r3);
            r2 = r2.toString();
            r0.<init>(r1, r2);
            r5.m17467a(r0);
            goto L_0x001d;
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.zzqc.zzc.onConnectionFailed(com.google.android.gms.common.ConnectionResult):void");
        }

        public void onConnectionSuspended(int i) {
            zzaqi();
            this.f11613i = true;
            this.f11605a.f11631n.sendMessageDelayed(Message.obtain(this.f11605a.f11631n, 8, this.f11609e), this.f11605a.f11620a);
            this.f11605a.f11631n.sendMessageDelayed(Message.obtain(this.f11605a.f11631n, 9, this.f11609e), this.f11605a.f11621b);
            this.f11605a.f11625h = -1;
        }

        public void zzaqh() {
            while (this.f11607c.isConnected() && !this.f11606b.isEmpty()) {
                m17468a((zzpi) this.f11606b.remove());
            }
        }

        public void zzaqi() {
            this.f11614j = null;
        }

        public void zzb(zzpi com_google_android_gms_internal_zzpi) {
            if (this.f11607c.isConnected()) {
                m17468a(com_google_android_gms_internal_zzpi);
                m17478f();
                return;
            }
            this.f11606b.add(com_google_android_gms_internal_zzpi);
            if (this.f11614j == null || !this.f11614j.hasResolution()) {
                m17480h();
            } else {
                onConnectionFailed(this.f11614j);
            }
        }

        public void zzb(zzpl com_google_android_gms_internal_zzpl) {
            this.f11611g.add(com_google_android_gms_internal_zzpl);
        }

        public void zzf(int i, boolean z) {
            Iterator it = this.f11606b.iterator();
            while (it.hasNext()) {
                zzpi com_google_android_gms_internal_zzpi = (zzpi) it.next();
                if (com_google_android_gms_internal_zzpi.sx == i && com_google_android_gms_internal_zzpi.iq != 1 && com_google_android_gms_internal_zzpi.cancel()) {
                    it.remove();
                }
            }
            ((zzqy) this.f11610f.get(i)).release();
            this.f11612h.delete(i);
            if (!z) {
                this.f11610f.remove(i);
                this.f11605a.f11633p.remove(i);
                if (this.f11610f.size() == 0 && this.f11606b.isEmpty()) {
                    m17474d();
                    this.f11607c.disconnect();
                    this.f11605a.f11628k.remove(this.f11609e);
                    synchronized (zzqc.f11618d) {
                        this.f11605a.f11630m.remove(this.f11609e);
                    }
                }
            }
        }

        public void zzfn(int i) {
            this.f11610f.put(i, new zzqy(this.f11609e.zzans(), this.f11607c));
        }

        public void zzfo(final int i) {
            ((zzqy) this.f11610f.get(i)).zza(new zzc(this) {
                final /* synthetic */ zzc f11604b;

                public void zzaqn() {
                    if (this.f11604b.f11606b.isEmpty()) {
                        this.f11604b.zzf(i, false);
                    }
                }
            });
        }
    }

    private class zzd implements zzf {
        final /* synthetic */ zzqc f11615a;
        private final zze f11616b;
        private final zzpj<?> f11617c;

        public zzd(zzqc com_google_android_gms_internal_zzqc, zze com_google_android_gms_common_api_Api_zze, zzpj<?> com_google_android_gms_internal_zzpj_) {
            this.f11615a = com_google_android_gms_internal_zzqc;
            this.f11616b = com_google_android_gms_common_api_Api_zze;
            this.f11617c = com_google_android_gms_internal_zzpj_;
        }

        public void zzh(ConnectionResult connectionResult) {
            if (connectionResult.isSuccess()) {
                this.f11616b.zza(null, Collections.emptySet());
            } else {
                ((zzc) this.f11615a.f11628k.get(this.f11617c)).onConnectionFailed(connectionResult);
            }
        }
    }

    private zzqc(Context context) {
        this(context, GoogleApiAvailability.getInstance());
    }

    private zzqc(Context context, GoogleApiAvailability googleApiAvailability) {
        this.f11620a = 5000;
        this.f11621b = 120000;
        this.f11622c = 10000;
        this.f11625h = -1;
        this.f11626i = new AtomicInteger(1);
        this.f11627j = new SparseArray();
        this.f11628k = new ConcurrentHashMap(5, 0.75f, 1);
        this.f11629l = null;
        this.f11630m = new com.google.android.gms.common.util.zza();
        this.f11632o = new ReferenceQueue();
        this.f11633p = new SparseArray();
        this.f11623f = context;
        HandlerThread handlerThread = new HandlerThread("GoogleApiHandler", 9);
        handlerThread.start();
        this.f11631n = new Handler(handlerThread.getLooper(), this);
        this.f11624g = googleApiAvailability;
    }

    private int m17483a(com.google.android.gms.common.api.zzc<?> com_google_android_gms_common_api_zzc_) {
        int andIncrement = this.f11626i.getAndIncrement();
        this.f11631n.sendMessage(this.f11631n.obtainMessage(6, andIncrement, 0, com_google_android_gms_common_api_zzc_));
        return andIncrement;
    }

    private void m17487a(int i) {
        zzc com_google_android_gms_internal_zzqc_zzc = (zzc) this.f11627j.get(i);
        if (com_google_android_gms_internal_zzqc_zzc != null) {
            this.f11627j.delete(i);
            com_google_android_gms_internal_zzqc_zzc.zzfo(i);
            return;
        }
        Log.wtf("GoogleApiManager", "onCleanupLeakInternal received for unknown instance: " + i, new Exception());
    }

    private void m17488a(int i, boolean z) {
        zzc com_google_android_gms_internal_zzqc_zzc = (zzc) this.f11627j.get(i);
        if (com_google_android_gms_internal_zzqc_zzc != null) {
            if (!z) {
                this.f11627j.delete(i);
            }
            com_google_android_gms_internal_zzqc_zzc.zzf(i, z);
            return;
        }
        Log.wtf("GoogleApiManager", "onRelease received for unknown instance: " + i, new Exception());
    }

    private void m17489a(com.google.android.gms.common.api.zzc<?> com_google_android_gms_common_api_zzc_, int i) {
        zzpj zzaob = com_google_android_gms_common_api_zzc_.zzaob();
        if (!this.f11628k.containsKey(zzaob)) {
            this.f11628k.put(zzaob, new zzc(this, com_google_android_gms_common_api_zzc_));
        }
        zzc com_google_android_gms_internal_zzqc_zzc = (zzc) this.f11628k.get(zzaob);
        com_google_android_gms_internal_zzqc_zzc.zzfn(i);
        this.f11627j.put(i, com_google_android_gms_internal_zzqc_zzc);
        com_google_android_gms_internal_zzqc_zzc.m17480h();
        this.f11633p.put(i, new zza(this, com_google_android_gms_common_api_zzc_, i, this.f11632o));
        if (this.f11634q == null || !this.f11634q.f11602c.get()) {
            this.f11634q = new zzb(this.f11632o, this.f11633p);
            this.f11634q.start();
        }
    }

    private void m17490a(zzpi com_google_android_gms_internal_zzpi) {
        ((zzc) this.f11627j.get(com_google_android_gms_internal_zzpi.sx)).zzb(com_google_android_gms_internal_zzpi);
    }

    private void m17492b() {
        for (zzc com_google_android_gms_internal_zzqc_zzc : this.f11628k.values()) {
            com_google_android_gms_internal_zzqc_zzc.zzaqi();
            com_google_android_gms_internal_zzqc_zzc.m17480h();
        }
    }

    public static Pair<zzqc, Integer> zza(Context context, com.google.android.gms.common.api.zzc<?> com_google_android_gms_common_api_zzc_) {
        Pair<zzqc, Integer> create;
        synchronized (f11618d) {
            if (f11619e == null) {
                f11619e = new zzqc(context.getApplicationContext());
            }
            create = Pair.create(f11619e, Integer.valueOf(f11619e.m17483a((com.google.android.gms.common.api.zzc) com_google_android_gms_common_api_zzc_)));
        }
        return create;
    }

    public static zzqc zzaqd() {
        zzqc com_google_android_gms_internal_zzqc;
        synchronized (f11618d) {
            com_google_android_gms_internal_zzqc = f11619e;
        }
        return com_google_android_gms_internal_zzqc;
    }

    boolean m17502a(ConnectionResult connectionResult, int i) {
        if (!connectionResult.hasResolution() && !this.f11624g.isUserResolvableError(connectionResult.getErrorCode())) {
            return false;
        }
        this.f11624g.zza(this.f11623f, connectionResult, i);
        return true;
    }

    public boolean handleMessage(Message message) {
        boolean z = false;
        switch (message.what) {
            case 1:
                zza((zzpl) message.obj);
                break;
            case 2:
                m17487a(message.arg1);
                break;
            case 3:
                m17492b();
                break;
            case 4:
                m17490a((zzpi) message.obj);
                break;
            case 5:
                if (this.f11627j.get(message.arg1) != null) {
                    ((zzc) this.f11627j.get(message.arg1)).m17467a(new Status(17, "Error resolution was canceled by the user."));
                    break;
                }
                break;
            case 6:
                m17489a((com.google.android.gms.common.api.zzc) message.obj, message.arg1);
                break;
            case 7:
                int i = message.arg1;
                if (message.arg2 == 1) {
                    z = true;
                }
                m17488a(i, z);
                break;
            case 8:
                if (this.f11628k.containsKey(message.obj)) {
                    ((zzc) this.f11628k.get(message.obj)).m17472c();
                    break;
                }
                break;
            case 9:
                if (this.f11628k.containsKey(message.obj)) {
                    ((zzc) this.f11628k.get(message.obj)).m17477e();
                    break;
                }
                break;
            case 10:
                if (this.f11628k.containsKey(message.obj)) {
                    ((zzc) this.f11628k.get(message.obj)).m17479g();
                    break;
                }
                break;
            default:
                Log.w("GoogleApiManager", "Unknown message id: " + message.what);
                return false;
        }
        return true;
    }

    public void zza(ConnectionResult connectionResult, int i) {
        if (!m17502a(connectionResult, i)) {
            this.f11631n.sendMessage(this.f11631n.obtainMessage(5, i, 0));
        }
    }

    public <O extends ApiOptions> void zza(com.google.android.gms.common.api.zzc<O> com_google_android_gms_common_api_zzc_O, int i, com.google.android.gms.internal.zzpm.zza<? extends Result, com.google.android.gms.common.api.Api.zzb> com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb) {
        this.f11631n.sendMessage(this.f11631n.obtainMessage(4, new com.google.android.gms.internal.zzpi.zza(com_google_android_gms_common_api_zzc_O.getInstanceId(), i, com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__com_google_android_gms_common_api_Api_zzb)));
    }

    public <O extends ApiOptions, TResult> void zza(com.google.android.gms.common.api.zzc<O> com_google_android_gms_common_api_zzc_O, int i, zzqw<com.google.android.gms.common.api.Api.zzb, TResult> com_google_android_gms_internal_zzqw_com_google_android_gms_common_api_Api_zzb__TResult, TaskCompletionSource<TResult> taskCompletionSource) {
        this.f11631n.sendMessage(this.f11631n.obtainMessage(4, new com.google.android.gms.internal.zzpi.zzb(com_google_android_gms_common_api_zzc_O.getInstanceId(), i, com_google_android_gms_internal_zzqw_com_google_android_gms_common_api_Api_zzb__TResult, taskCompletionSource)));
    }

    public void zza(zzpl com_google_android_gms_internal_zzpl) {
        for (zzpj com_google_android_gms_internal_zzpj : com_google_android_gms_internal_zzpl.zzaoq()) {
            zzc com_google_android_gms_internal_zzqc_zzc = (zzc) this.f11628k.get(com_google_android_gms_internal_zzpj);
            if (com_google_android_gms_internal_zzqc_zzc == null) {
                com_google_android_gms_internal_zzpl.cancel();
                return;
            } else if (com_google_android_gms_internal_zzqc_zzc.m17482b()) {
                com_google_android_gms_internal_zzpl.zza(com_google_android_gms_internal_zzpj, ConnectionResult.rb);
            } else if (com_google_android_gms_internal_zzqc_zzc.m17481a() != null) {
                com_google_android_gms_internal_zzpl.zza(com_google_android_gms_internal_zzpj, com_google_android_gms_internal_zzqc_zzc.m17481a());
            } else {
                com_google_android_gms_internal_zzqc_zzc.zzb(com_google_android_gms_internal_zzpl);
            }
        }
    }

    public void zza(zzpr com_google_android_gms_internal_zzpr) {
        synchronized (f11618d) {
            if (com_google_android_gms_internal_zzpr == null) {
                this.f11629l = null;
                this.f11630m.clear();
            }
        }
    }

    public void zzaoo() {
        this.f11631n.sendMessage(this.f11631n.obtainMessage(3));
    }

    public void zzd(int i, boolean z) {
        this.f11631n.sendMessage(this.f11631n.obtainMessage(7, i, z ? 1 : 2));
    }
}
