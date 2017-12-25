package com.bigroad.ttb.android.eobr.realtime;

import android.os.Handler;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.shared.eobr.turbo.BusType;
import com.bigroad.shared.eobr.turbo.logs.C1017o;
import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.shared.eobr.turbo.logs.C1026f;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.android.vehicle.p041b.C2348f;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RealtimeSessionHandler implements C1939b {
    private static final Map<String, RealtimeSessionHandler> f6677v = new HashMap();
    protected final ChangeListener f6678a = new C19362(this);
    private final ap f6679b;
    private final VehicleConnectionManager f6680c;
    private final TruckManager f6681d;
    private final Handler f6682e = new Handler();
    private final String f6683f;
    private final HashSet<Object> f6684g = new HashSet();
    private State f6685h = State.IDLE;
    private C2363e f6686i = null;
    private long f6687j = 0;
    private final C1940a f6688k = new C1940a(86400000, 10000);
    private OdometerSource f6689l;
    private boolean f6690m;
    private C1036s f6691n;
    private C1037t f6692o;
    private C1029i f6693p;
    private MultiOdometerLogEntry f6694q;
    private C1026f f6695r;
    private Map<BusType, C1020a> f6696s = new HashMap();
    private boolean f6697t;
    private final Runnable f6698u = new C19351(this);

    class C19351 implements Runnable {
        final /* synthetic */ RealtimeSessionHandler f6669a;

        C19351(RealtimeSessionHandler realtimeSessionHandler) {
            this.f6669a = realtimeSessionHandler;
        }

        public void run() {
            if (!this.f6669a.f6697t) {
                C2134e.m10678c("TT-RealtimeSessionHandler", "Cannorktion timeout - broadcasting realtime state without all required data");
                this.f6669a.m9550b();
            }
        }
    }

    class C19362 extends C1201a {
        final /* synthetic */ RealtimeSessionHandler f6670a;

        C19362(RealtimeSessionHandler realtimeSessionHandler) {
            this.f6670a = realtimeSessionHandler;
        }

        public void mo888a(C2338a c2338a) {
            if (c2338a == null) {
                C2134e.m10680d("TT-RealtimeSessionHandler", "Unexpected NULL onConnectionStateChanged.");
            } else if (!c2338a.m11450a(ConnectionFlag.CONNECTED) && !c2338a.m11451a(ConnectionSetupFlag.RECONNECTING)) {
                this.f6670a.m9534a(true);
            } else if (c2338a.m11450a(ConnectionFlag.CONNECTED)) {
                C2363e h = this.f6670a.f6680c.m11410h();
                if (h == null) {
                    C2134e.m10682e("TT-RealtimeSessionHandler", "Unexpected " + c2338a + " with a null tracker");
                    this.f6670a.m9534a(true);
                } else if (!am.m4189a(this.f6670a.f6683f, h.m11541d().m8991c())) {
                    C2134e.m10676b("TT-RealtimeSessionHandler", "Unexpected lingering session manager with mismatching session tracker: " + this.f6670a.f6683f);
                    this.f6670a.m9534a(true);
                } else if (!h.m11541d().mo1121o().m4939c() && this.f6670a.f6685h == State.IDLE) {
                    this.f6670a.m9533a(h, false);
                } else if (this.f6670a.f6685h == State.PAUSED) {
                    this.f6670a.m9532a(h);
                }
            } else {
                switch (this.f6670a.f6685h) {
                    case PROCESSING_ENTRIES:
                        this.f6670a.f6685h = State.PAUSED;
                        return;
                    case PAUSED:
                        C2134e.m10680d("TT-RealtimeSessionHandler", "Already paused: " + c2338a);
                        return;
                    default:
                        this.f6670a.m9534a(true);
                        return;
                }
            }
        }
    }

    class C19373 implements Runnable {
        final /* synthetic */ RealtimeSessionHandler f6671a;

        C19373(RealtimeSessionHandler realtimeSessionHandler) {
            this.f6671a = realtimeSessionHandler;
        }

        public void run() {
            this.f6671a.m9545g();
        }
    }

    private enum State {
        IDLE,
        PROCESSING_ENTRIES,
        PAUSED
    }

    public static RealtimeSessionHandler m9528a(String str, Object obj, C2032f c2032f) {
        RealtimeSessionHandler realtimeSessionHandler;
        synchronized (f6677v) {
            realtimeSessionHandler = (RealtimeSessionHandler) f6677v.get(str);
            if (realtimeSessionHandler == null) {
                realtimeSessionHandler = new RealtimeSessionHandler(str, obj, c2032f);
                f6677v.put(str, realtimeSessionHandler);
            }
        }
        realtimeSessionHandler.m9538b(obj);
        return realtimeSessionHandler;
    }

    private synchronized void m9538b(Object obj) {
        this.f6684g.add(obj);
    }

    public synchronized void m9549a(Object obj) {
        if (!this.f6684g.isEmpty()) {
            this.f6684g.remove(obj);
            if (this.f6684g.isEmpty()) {
                m9541d();
            }
        }
    }

    private RealtimeSessionHandler(String str, Object obj, C2032f c2032f) {
        this.f6679b = c2032f.mo1314v();
        this.f6680c = c2032f.mo1311s();
        this.f6681d = c2032f.mo1300h();
        this.f6683f = str;
        m9538b(obj);
        this.f6680c.m11399a(this.f6678a);
        this.f6678a.mo888a(this.f6680c.m11406d());
    }

    private synchronized void m9541d() {
        synchronized (f6677v) {
            if (this.f6684g.isEmpty() && this.f6686i == null && this.f6685h == State.IDLE) {
                this.f6682e.removeCallbacks(this.f6698u);
                this.f6680c.m11404b(this.f6678a);
                f6677v.remove(this.f6683f);
            }
        }
    }

    public int m9546a() {
        return (int) (this.f6679b.mo915c() / 1000);
    }

    public synchronized void mo1163a(C1017o c1017o) {
        Object obj;
        if (c1017o instanceof C1036s) {
            this.f6691n = (C1036s) c1017o;
            obj = 1;
        } else if (c1017o instanceof C1029i) {
            this.f6693p = (C1029i) c1017o;
            r1 = 1;
        } else if (c1017o instanceof MultiOdometerLogEntry) {
            this.f6694q = (MultiOdometerLogEntry) c1017o;
            r1 = 1;
        } else if (c1017o instanceof C1037t) {
            this.f6692o = (C1037t) c1017o;
            obj = null;
        } else if (c1017o instanceof C1026f) {
            this.f6695r = (C1026f) c1017o;
            obj = null;
        } else {
            if (c1017o instanceof C1020a) {
                C1020a c1020a = (C1020a) c1017o;
                this.f6696s.put(c1020a.f3246b, c1020a);
            }
            obj = null;
        }
        if (obj == null || this.f6697t) {
            m9537b(c1017o);
        }
        m9542e();
    }

    private synchronized void m9542e() {
        if (!this.f6697t && m9544f()) {
            m9550b();
        }
    }

    public synchronized void m9550b() {
        if (!this.f6697t) {
            this.f6697t = true;
            m9537b(this.f6693p);
            m9537b(this.f6694q);
            m9537b(this.f6691n);
        }
    }

    public synchronized void mo1162a(OdometerSource odometerSource) {
        this.f6690m = true;
        this.f6689l = odometerSource;
        m9542e();
    }

    public String m9551c() {
        return this.f6683f;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m9544f() {
        /*
        r7 = this;
        r1 = 1;
        r0 = 0;
        monitor-enter(r7);
        r2 = r7.f6690m;	 Catch:{ all -> 0x004b }
        if (r2 == 0) goto L_0x000f;
    L_0x0007:
        r2 = r7.f6694q;	 Catch:{ all -> 0x004b }
        if (r2 == 0) goto L_0x000f;
    L_0x000b:
        r2 = r7.f6691n;	 Catch:{ all -> 0x004b }
        if (r2 != 0) goto L_0x0011;
    L_0x000f:
        monitor-exit(r7);
        return r0;
    L_0x0011:
        r2 = r7.f6689l;	 Catch:{ all -> 0x004b }
        if (r2 == 0) goto L_0x0043;
    L_0x0015:
        r2 = r7.f6694q;	 Catch:{ all -> 0x004b }
        r3 = r2.f3235b;	 Catch:{ all -> 0x004b }
        r4 = r3.length;	 Catch:{ all -> 0x004b }
        r2 = r0;
    L_0x001b:
        if (r2 >= r4) goto L_0x004e;
    L_0x001d:
        r5 = r3[r2];	 Catch:{ all -> 0x004b }
        r6 = r7.f6689l;	 Catch:{ all -> 0x004b }
        if (r5 != r6) goto L_0x0040;
    L_0x0023:
        r2 = r1;
    L_0x0024:
        if (r2 == 0) goto L_0x000f;
    L_0x0026:
        r2 = r7.f6691n;	 Catch:{ all -> 0x004b }
        r2 = r2.m5278c();	 Catch:{ all -> 0x004b }
        if (r2 == 0) goto L_0x000f;
    L_0x002e:
        r2 = r7.f6691n;	 Catch:{ all -> 0x004b }
        r2 = r2.m5279d();	 Catch:{ all -> 0x004b }
        if (r2 != 0) goto L_0x003e;
    L_0x0036:
        r2 = r7.f6691n;	 Catch:{ all -> 0x004b }
        r2 = r2.m5283h();	 Catch:{ all -> 0x004b }
        if (r2 == 0) goto L_0x000f;
    L_0x003e:
        r0 = r1;
        goto L_0x000f;
    L_0x0040:
        r2 = r2 + 1;
        goto L_0x001b;
    L_0x0043:
        r2 = r7.f6694q;	 Catch:{ all -> 0x004b }
        r2 = r2.f3234a;	 Catch:{ all -> 0x004b }
        r2 = r2.length;	 Catch:{ all -> 0x004b }
        if (r2 != 0) goto L_0x0026;
    L_0x004a:
        goto L_0x000f;
    L_0x004b:
        r0 = move-exception;
        monitor-exit(r7);
        throw r0;
    L_0x004e:
        r2 = r0;
        goto L_0x0024;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.eobr.realtime.RealtimeSessionHandler.f():boolean");
    }

    private synchronized void m9545g() {
        this.f6687j = this.f6688k.m9555c() + 43200000;
        if (this.f6692o != null) {
            m9537b(this.f6692o);
        } else if (this.f6686i != null) {
            CharSequence l = this.f6686i.m11541d().m9000l();
            if (!am.m4188a(l)) {
                m9537b(new C1037t(m9546a(), l));
            }
        }
        this.f6680c.m11408f();
        for (C1017o b : this.f6696s.values()) {
            m9537b(b);
        }
        m9537b(this.f6695r);
        if (this.f6697t) {
            m9537b(this.f6693p);
            m9537b(this.f6694q);
            m9537b(this.f6691n);
        }
    }

    private synchronized void m9537b(C1017o c1017o) {
        if (c1017o != null) {
            C2348f a = this.f6688k.m9553a(c1017o, this.f6679b.mo913a());
            if (this.f6686i == null || !this.f6686i.m11535a(a)) {
                C2134e.m10676b("TT-RealtimeSessionHandler", "Failed to enqueue LogEntryVehicleMessage " + a);
            }
            if (m9544f() && this.f6688k.m9555c() >= this.f6687j) {
                this.f6682e.post(new C19373(this));
            }
        }
    }

    private synchronized void m9533a(C2363e c2363e, boolean z) {
        m9538b((Object) this);
        m9534a(!z);
        this.f6682e.postDelayed(this.f6698u, 30000);
        this.f6686i = c2363e;
        m9538b(this.f6686i);
        C2134e.m10678c("TT-RealtimeSessionHandler", "Using Realtime device (VNA): " + C1180y.m5996c(this.f6686i.m11541d().m8992d()));
        this.f6685h = State.PROCESSING_ENTRIES;
        if (z) {
            C2134e.m10678c("TT-RealtimeSessionHandler", "Playing log entries on reconnection - count: " + this.f6688k.m9554b().size());
        } else {
            C2134e.m10678c("TT-RealtimeSessionHandler", "Playing log entries on initial connection - count: " + this.f6688k.m9554b().size());
        }
        c2363e.m11549l();
        c2363e.m11530a(this.f6688k.m9552a());
        c2363e.m11537b(this.f6688k.m9552a());
        for (C2348f a : this.f6688k.m9554b()) {
            c2363e.m11535a(a);
        }
        this.f6680c.m11397a(-1);
        m9545g();
        m9549a((Object) this);
    }

    private synchronized void m9532a(C2363e c2363e) {
        boolean z = false;
        long g = this.f6681d.m6580g();
        Long l = null;
        if (this.f6686i.m11542e().m11600b() != null) {
            l = Long.valueOf(this.f6686i.m11542e().m11600b().getTruckId());
        }
        if (!(this.f6685h != State.PAUSED || c2363e == null || this.f6686i == null || r1 == null || g != r1.longValue())) {
            C2134e.m10678c("TT-RealtimeSessionHandler", "Resuming use of device");
            z = true;
        }
        m9533a(c2363e, z);
    }

    private synchronized void m9534a(boolean z) {
        this.f6682e.removeCallbacks(this.f6698u);
        C2134e.m10678c("TT-RealtimeSessionHandler", "No longer using device");
        if (this.f6686i != null && z) {
            this.f6686i.m11546i();
        }
        this.f6687j = 0;
        this.f6685h = State.IDLE;
        this.f6697t = false;
        this.f6692o = null;
        this.f6691n = null;
        this.f6693p = null;
        this.f6694q = null;
        this.f6695r = null;
        this.f6696s.clear();
        if (this.f6686i != null) {
            m9549a(this.f6686i);
            this.f6686i = null;
        }
    }
}
