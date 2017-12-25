package com.bigroad.ttb.android.vehicle;

import android.os.Handler;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2230r;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.android.vehicle.p040a.C2334a;
import com.bigroad.ttb.android.vehicle.p040a.C2336b;
import com.bigroad.ttb.android.vehicle.p040a.C2337d;
import com.bigroad.ttb.android.vehicle.p041b.C2347j;
import com.bigroad.ttb.android.vehicle.p041b.C2348f;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.protobuf.C3642c;
import java.util.Arrays;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class C2363e {
    protected BlockingQueue<C2348f> f8138a = null;
    protected final Runnable f8139b = new C23601(this);
    private final C2032f f8140c;
    private final C2230r f8141d;
    private final TruckManager f8142e;
    private final EventManager f8143f;
    private final ap f8144g;
    private final C2474y f8145h;
    private final EobrDevice f8146i;
    private final C2355b f8147j;
    private final C2320a f8148k;
    private C2358c f8149l = null;
    private C2369i f8150m;
    private C1015l f8151n = null;
    private C1015l f8152o = null;
    private C1015l f8153p = null;
    private final C2336b f8154q;
    private final C2334a f8155r;
    private final C2365f f8156s;
    private final C2366h f8157t;
    private C2359d f8158u;
    private final Handler f8159v = new Handler();
    private Integer f8160w = null;
    private boolean f8161x = false;

    public interface C2320a {
        void mo1275a(ProcessingState processingState);

        void mo1276a(C2363e c2363e, C2369i c2369i, RelativeTimestamp relativeTimestamp);

        void mo1277a(RelativeTimestamp relativeTimestamp);
    }

    class C23601 implements Runnable {
        final /* synthetic */ C2363e f8135a;

        C23601(C2363e c2363e) {
            this.f8135a = c2363e;
        }

        public void run() {
            this.f8135a.f8159v.removeCallbacks(this);
            if (this.f8135a.m11548k()) {
                long c = this.f8135a.f8144g.mo915c();
                int i = 0;
                while (!this.f8135a.f8138a.isEmpty() && i < 16) {
                    C2347j c2347j = (C2348f) this.f8135a.f8138a.poll();
                    if (c2347j == null) {
                        break;
                    }
                    i++;
                    this.f8135a.m11532a(c2347j);
                }
                if (i == 0) {
                    C1015l c2 = this.f8135a.f8156s.m11561c();
                    if (c2 != null) {
                        this.f8135a.m11531a(c2, RelativeTimestamp.newBuilder().m14805b(this.f8135a.f8144g.mo914b()).m14801a(this.f8135a.f8144g.mo915c() / 1000).m14807c());
                    }
                }
                c = this.f8135a.f8144g.mo915c() - c;
                if (c > 500) {
                    C2134e.m10680d("TT-ClientSessionTracker", "Processed " + i + " log entries in " + c + "ms (limit: " + 500 + "ms), remaining entry queue size: " + this.f8135a.f8138a.size());
                }
                this.f8135a.f8161x = false;
                this.f8135a.m11526n();
                return;
            }
            this.f8135a.f8161x = false;
        }
    }

    class C23612 implements C2337d {
        final /* synthetic */ C2363e f8136a;

        C23612(C2363e c2363e) {
            this.f8136a = c2363e;
        }

        public void mo1283a(C2347j c2347j) {
            this.f8136a.m11522b(c2347j);
        }

        public void mo1282a(C1015l c1015l, RelativeTimestamp relativeTimestamp) {
            this.f8136a.m11538b(c1015l, relativeTimestamp);
        }
    }

    private void m11526n() {
        if (m11548k() && !this.f8161x) {
            this.f8161x = true;
            if (this.f8138a.isEmpty()) {
                this.f8159v.postDelayed(this.f8139b, 1000);
            } else {
                this.f8159v.post(this.f8139b);
            }
        }
    }

    public C2363e(EobrDevice eobrDevice, C2320a c2320a, C2355b c2355b, C2032f c2032f) {
        this.f8140c = c2032f;
        this.f8146i = eobrDevice;
        this.f8147j = c2355b;
        this.f8148k = c2320a;
        this.f8156s = new C2365f();
        this.f8157t = new C2366h(c2032f, this.f8156s);
        this.f8141d = c2032f.mo1299g();
        this.f8142e = c2032f.mo1300h();
        this.f8143f = c2032f.mo1301i();
        this.f8145h = c2032f.mo1295c();
        this.f8144g = c2032f.mo1314v();
        this.f8150m = C2369i.m11590a(this.f8146i);
        this.f8149l = m11527o();
        this.f8158u = null;
        this.f8155r = new C2334a();
        this.f8154q = new C2336b(new C23612(this), this.f8155r);
    }

    private C2358c m11527o() {
        return new C2358c(this.f8145h.m12191a(), null, this.f8141d.m11013b(), null, null, false);
    }

    public RelativeTimestamp m11528a() {
        return this.f8156s.m11560b();
    }

    public C2358c m11536b() {
        return this.f8149l;
    }

    public ProcessingState m11539c() {
        return this.f8156s.mo1285a();
    }

    public EobrDevice m11541d() {
        return this.f8146i;
    }

    public C2369i m11542e() {
        return this.f8150m;
    }

    public void m11530a(C1015l c1015l) {
        this.f8151n = c1015l;
    }

    public C1015l m11543f() {
        return this.f8151n;
    }

    public boolean m11544g() {
        return this.f8149l != null && this.f8149l.m11510h();
    }

    public void m11537b(C1015l c1015l) {
        this.f8152o = c1015l;
    }

    public void m11540c(C1015l c1015l) {
        this.f8153p = c1015l;
    }

    public boolean m11545h() {
        return this.f8156s.m11562d();
    }

    public void m11532a(C2347j c2347j) {
        this.f8154q.m11440a(c2347j);
    }

    private void m11522b(C2347j c2347j) {
        if (!m11545h()) {
            C2134e.m10680d("TT-ClientSessionTracker", "Attempting to processMessage when not ready");
        }
        ProcessingState a = this.f8156s.mo1285a();
        C1015l c1015l = null;
        if (c2347j instanceof C2348f) {
            C2348f c2348f = (C2348f) c2347j;
            C1015l c = c2348f.m11468c();
            if (this.f8153p != null && c.m5231b(this.f8153p) < 0) {
                this.f8156s.m11558a(ProcessingState.BEFORE_APP_START);
            } else if (this.f8152o != null && c.m5231b(this.f8152o) < 0) {
                this.f8156s.m11558a(ProcessingState.BEFORE_CURSOR);
            } else if (this.f8152o != null && c.m5231b(this.f8152o) == 0) {
                this.f8156s.m11558a(ProcessingState.AT_CURSOR);
            } else if (a != ProcessingState.AT_CURSOR || this.f8152o == null || c.m5231b(this.f8152o) <= 0) {
                this.f8156s.m11558a(ProcessingState.INCREMENTING_CURSOR);
                if (this.f8152o == null) {
                    C2134e.m10680d("TT-ClientSessionTracker", "Unexpected missing last cursor position");
                }
            } else {
                this.f8156s.m11558a(ProcessingState.TEMPORALLY_AT_CURSOR);
            }
            if (c2348f.m11470e()) {
                C2134e.m10676b("TT-ClientSessionTracker", "Found Reset");
                m11524d(c);
                c1015l = c;
            } else {
                if (c2348f.m11471f()) {
                    m11518a(c2348f.m11472g(), c);
                }
                c1015l = c;
            }
        }
        C2369i c2369i = this.f8150m;
        this.f8150m = this.f8157t.m11564a(m11541d(), this.f8149l, this.f8150m, c2347j);
        if (c2347j.mo1281l().hasAbsoluteTimeMillis()) {
            this.f8156s.m11559a(c2347j.mo1281l());
        }
        if (c1015l != null) {
            this.f8156s.m11557a(c1015l);
        }
        if (c2369i != this.f8150m) {
            this.f8148k.mo1276a(this, this.f8150m, this.f8156s.m11560b());
        }
        this.f8148k.mo1277a(this.f8156s.m11560b());
        if (a != this.f8156s.mo1285a()) {
            this.f8148k.mo1275a(this.f8156s.mo1285a());
        }
    }

    private void m11524d(C1015l c1015l) {
        C2368a a = C2369i.m11589a(C2369i.m11590a(this.f8146i));
        if (this.f8155r.m11437a(this.f8149l, c1015l)) {
            C2134e.m10676b("TT-ClientSessionTracker", "continuing session through reset: " + this.f8149l.m11508f());
            a.m11576a(this.f8150m.m11600b());
            a.m11581b(this.f8150m.m11620s());
            a.m11572a(this.f8150m.m11613l());
            a.m11578a(this.f8150m.m11614m());
        } else {
            this.f8149l = m11527o();
            C2134e.m10676b("TT-ClientSessionTracker", "reset caused new default session");
        }
        this.f8149l = m11527o();
        if (this.f8150m != null) {
            a.m11577a(this.f8150m.m11611j());
        }
        this.f8150m = a.m11584c();
    }

    public void m11529a(int i) {
        this.f8160w = Integer.valueOf(i);
    }

    private void m11518a(EobrSessionLogEntry eobrSessionLogEntry, C1015l c1015l) {
        if (eobrSessionLogEntry != null) {
            boolean z = this.f8151n != null && c1015l.m5231b(this.f8151n) > 0;
            switch (eobrSessionLogEntry.mo756j()) {
                case START:
                    this.f8149l = C2358c.m11501a(this.f8141d.m11013b(), eobrSessionLogEntry, z);
                    if (this.f8149l.m11508f().equals(this.f8160w)) {
                        if (this.f8149l.m11509g().intValue() == -1 || !this.f8147j.m11493a(this.f8149l.m11509g().intValue())) {
                            this.f8157t.m11565a(this.f8147j);
                        } else {
                            C2134e.m10678c("TT-ClientSessionTracker", "Skipping EOBR login for session " + this.f8149l.m11508f() + " as it is already recorded (probably by a previous session)");
                        }
                    }
                    C2134e.m10676b("TT-ClientSessionTracker", "Starting mobile client session at position: " + c1015l);
                    break;
                case STATUS:
                    if (this.f8156s.mo1285a().m11311b()) {
                        this.f8149l = C2358c.m11501a(this.f8141d.m11013b(), eobrSessionLogEntry, z);
                        break;
                    }
                    break;
                case END:
                    int a;
                    if (this.f8149l != null) {
                        if (this.f8149l.m11510h()) {
                            C2134e.m10680d("TT-ClientSessionTracker", "Unexpected session end entry while connected");
                        }
                        if (!this.f8149l.m11502a(eobrSessionLogEntry)) {
                            C2134e.m10680d("TT-ClientSessionTracker", "Session end metadata doesn't match session start");
                        }
                        if (!(this.f8158u == null || this.f8149l.m11508f() == null)) {
                            a = this.f8158u.m11511a(this.f8149l.m11508f().intValue());
                            if (a != -1) {
                                this.f8149l = m11527o();
                                C2134e.m10676b("TT-ClientSessionTracker", "Ending mobile client session at position: " + c1015l);
                                this.f8150m = C2369i.m11589a(this.f8150m).m11572a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE).m11578a(false).m11584c();
                                break;
                            }
                            C2134e.m10676b("TT-ClientSessionTracker", "Extending session at position " + c1015l + " until sessionId " + a);
                            break;
                        }
                    }
                    a = -1;
                    if (a != -1) {
                        this.f8149l = m11527o();
                        C2134e.m10676b("TT-ClientSessionTracker", "Ending mobile client session at position: " + c1015l);
                        this.f8150m = C2369i.m11589a(this.f8150m).m11572a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE).m11578a(false).m11584c();
                    } else {
                        C2134e.m10676b("TT-ClientSessionTracker", "Extending session at position " + c1015l + " until sessionId " + a);
                    }
                default:
                    C2134e.m10680d("TT-ClientSessionTracker", "Unexpected client session state: " + eobrSessionLogEntry.mo756j());
                    break;
            }
            this.f8147j.m11492a(eobrSessionLogEntry, c1015l);
        }
    }

    public void m11531a(C1015l c1015l, RelativeTimestamp relativeTimestamp) {
        this.f8154q.m11439a(c1015l, relativeTimestamp);
    }

    public void m11538b(C1015l c1015l, RelativeTimestamp relativeTimestamp) {
        if (!m11545h()) {
            C2134e.m10680d("TT-ClientSessionTracker", "Attempting to processTimestamp when not ready");
        }
        if (!m11544g()) {
            C2134e.m10680d("TT-ClientSessionTracker", "processTimestamp should only be called while processing current session");
        }
        C2369i c2369i = this.f8150m;
        this.f8150m = this.f8157t.m11563a(m11541d(), this.f8149l, c1015l, relativeTimestamp, this.f8150m);
        this.f8156s.m11559a(relativeTimestamp);
        this.f8156s.m11557a(c1015l);
        if (c2369i != this.f8150m) {
            this.f8148k.mo1276a(this, this.f8150m, this.f8156s.m11560b());
        }
        this.f8148k.mo1277a(this.f8156s.m11560b());
    }

    public void m11546i() {
        this.f8157t.m11566a(this.f8149l);
    }

    public void m11547j() {
        if (this.f8149l != null && this.f8156s.mo1285a() != ProcessingState.CORRUPT_ENTRIES_DETECTED) {
            m11546i();
            this.f8156s.m11558a(ProcessingState.CORRUPT_ENTRIES_DETECTED);
            this.f8148k.mo1275a(this.f8156s.mo1285a());
        }
    }

    public void m11534a(Truck truck) {
        if (this.f8146i != null && truck != null) {
            C3642c firmwareOdometerAssociatedDashLink = truck.getFirmwareOdometerAssociatedDashLink();
            byte[] d = this.f8146i.m8992d();
            if (firmwareOdometerAssociatedDashLink != null && !firmwareOdometerAssociatedDashLink.m19090c() && !Arrays.equals(d, firmwareOdometerAssociatedDashLink.m19091d())) {
                this.f8143f.m10050e(C2022a.m10095b(this.f8140c, truck, firmwareOdometerAssociatedDashLink.m19091d()));
                C2134e.m10676b("TT-ClientSessionTracker", "Clearing odometer calibration; currentFirmwareId: " + C1180y.m5989a(firmwareOdometerAssociatedDashLink) + " deviceId: " + C1180y.m5990a(d));
                this.f8142e.m6581g(truck.getTruckNumber());
            }
        }
    }

    public void m11533a(C2359d c2359d) {
        this.f8158u = c2359d;
    }

    protected synchronized boolean m11548k() {
        return this.f8138a != null;
    }

    public synchronized void m11549l() {
        if (this.f8138a == null) {
            C2134e.m10676b("TT-ClientSessionTracker", "Starting LogEntry Queue");
            this.f8138a = new LinkedBlockingQueue();
        }
    }

    public boolean m11535a(C2348f c2348f) {
        boolean z = false;
        if (m11548k()) {
            try {
                z = this.f8138a.offer(c2348f);
            } catch (NullPointerException e) {
                C2134e.m10682e("TT-ClientSessionTracker", "Cannot enqueue a null message " + e);
            } finally {
                m11526n();
            }
        }
        return z;
    }

    public void m11550m() {
        this.f8159v.removeCallbacks(this.f8139b);
        if (m11548k()) {
            C2134e.m10676b("TT-ClientSessionTracker", "Clearing LogEntry Queue");
            this.f8138a.clear();
        }
        this.f8161x = false;
    }
}
