package com.bigroad.ttb.android.eobr;

import android.os.Handler;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ap;
import com.bigroad.shared.eobr.C0970d;
import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.ConnectionSetupFlag;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.turbo.C1002b;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1022b;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.util.C2295o;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2359d;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.android.vehicle.p041b.C2347j;
import com.bigroad.ttb.android.vehicle.p041b.C2348f;
import com.bigroad.ttb.protocol.TTProtocol.CursorResetReason;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.common.base.Objects;
import java.util.Arrays;
import java.util.LinkedList;

public abstract class EobrEntryManager {
    private Runnable f6378A = new C18656(this);
    private final Runnable f6379B = new C18678(this);
    protected final Handler f6380a = new Handler();
    protected final C1790a f6381b;
    protected final ap f6382c;
    protected final VehicleConnectionManager f6383d;
    protected byte[] f6384e = null;
    public State f6385f = State.NOT_FETCHING_PAGES;
    protected C1015l f6386g;
    protected LinkedList<C0971c> f6387h = new LinkedList();
    protected C2363e f6388i = null;
    protected boolean f6389j = false;
    public C1015l f6390k = null;
    public C1015l f6391l = null;
    public C0970d f6392m = null;
    protected CursorResetReason f6393n = CursorResetReason.UNKNOWN_CURSOR_RESET_REASON;
    protected C2359d f6394o;
    protected long f6395p;
    protected boolean f6396q = true;
    protected Long f6397r;
    protected ChangeListener f6398s = new C18601(this);
    protected TruckManager.ChangeListener f6399t = new C18634(this);
    protected final Runnable f6400u = new C18667(this);
    private C2032f f6401v;
    private final ag<C1869a> f6402w = new ag();
    private final LinkedList<C2295o<Long, C1206c>> f6403x = new LinkedList();
    private State f6404y;
    private final Runnable f6405z = new C18645(this);

    class C18601 extends C1201a {
        final /* synthetic */ EobrEntryManager f6356a;

        C18601(EobrEntryManager eobrEntryManager) {
            this.f6356a = eobrEntryManager;
        }

        public void mo888a(C2338a c2338a) {
            if (c2338a == null) {
                C2134e.m10680d("TT-EobrEntryMgr", "Unexpected NULL onConnectionStateChanged.");
            } else if (!c2338a.m11450a(ConnectionFlag.CONNECTED) && !c2338a.m11451a(ConnectionSetupFlag.RECONNECTING)) {
                this.f6356a.mo1093a(true);
            } else if (c2338a.m11450a(ConnectionFlag.CONNECTED)) {
                C2363e h = this.f6356a.f6383d.m11410h();
                if (h == null) {
                    C2134e.m10682e("TT-EobrEntryMgr", "Unexpected " + c2338a + " with a null tracker");
                    this.f6356a.mo1093a(true);
                } else if (this.f6356a.mo1096a(h, c2338a)) {
                    this.f6356a.m9041b(h, false);
                } else if (this.f6356a.mo1095a(h.m11541d()) && this.f6356a.f6385f == State.PAUSED) {
                    this.f6356a.m9035a(h);
                }
            } else {
                switch (this.f6356a.f6385f) {
                    case POLL_FOR_NEW_ENTRIES:
                        if (this.f6356a.mo1095a(this.f6356a.f6388i.m11541d())) {
                            this.f6356a.mo1116x();
                            return;
                        }
                        return;
                    case PAUSED:
                        C2134e.m10680d("TT-EobrEntryMgr", "Already paused: " + c2338a);
                        return;
                    default:
                        this.f6356a.mo1093a(true);
                        return;
                }
            }
        }
    }

    class C18634 extends C1203b {
        final /* synthetic */ EobrEntryManager f6360a;

        C18634(EobrEntryManager eobrEntryManager) {
            this.f6360a = eobrEntryManager;
        }

        public void mo894a(Truck truck) {
            Long valueOf = truck == null ? null : Long.valueOf(truck.getTruckId());
            if (!Objects.equal(valueOf, this.f6360a.f6397r)) {
                this.f6360a.f6396q = true;
                this.f6360a.f6397r = valueOf;
            }
        }
    }

    class C18645 implements Runnable {
        final /* synthetic */ EobrEntryManager f6361a;

        C18645(EobrEntryManager eobrEntryManager) {
            this.f6361a = eobrEntryManager;
        }

        public void run() {
            this.f6361a.m9062g();
        }
    }

    class C18656 implements Runnable {
        final /* synthetic */ EobrEntryManager f6362a;

        C18656(EobrEntryManager eobrEntryManager) {
            this.f6362a = eobrEntryManager;
        }

        public void run() {
            if (!this.f6362a.m9058c()) {
                this.f6362a.mo1098b(5000);
            }
        }
    }

    class C18667 implements Runnable {
        final /* synthetic */ EobrEntryManager f6363a;

        C18667(EobrEntryManager eobrEntryManager) {
            this.f6363a = eobrEntryManager;
        }

        public void run() {
            if (this.f6363a.f6385f == State.GET_CURRENT_VAR_POSITION || this.f6363a.f6385f == State.FIND_LAST_EOBR_EVENT || this.f6363a.f6385f == State.FIND_APP_START_ENTRY || this.f6363a.f6385f == State.FIND_VEHICLE_STATE_START_ENTRY) {
                this.f6363a.mo1097b();
            }
        }
    }

    class C18678 implements Runnable {
        final /* synthetic */ EobrEntryManager f6364a;

        C18678(EobrEntryManager eobrEntryManager) {
            this.f6364a = eobrEntryManager;
        }

        public void run() {
            this.f6364a.mo1113u();
            this.f6364a.f6380a.removeCallbacks(this.f6364a.f6379B);
            this.f6364a.f6380a.postDelayed(this.f6364a.f6379B, 30000);
        }
    }

    public enum State {
        NOT_FETCHING_PAGES,
        GET_CURRENT_VAR_POSITION,
        FIND_LAST_EOBR_EVENT,
        FIND_APP_START_ENTRY,
        FIND_VEHICLE_STATE_START_ENTRY,
        RESTARTING,
        PROCESS_ENTRIES,
        POLL_FOR_NEW_ENTRIES,
        CORRUPTION_DETECTED,
        PAUSED
    }

    public interface C1869a {
        void mo1076a(long j);

        void mo1077a(State state);

        void mo1078a(String str);

        void mo1079b(String str);
    }

    public static class C1870b implements C1869a {
        public void mo1078a(String str) {
        }

        public void mo1079b(String str) {
        }

        public void mo1077a(State state) {
        }

        public void mo1076a(long j) {
        }
    }

    protected abstract Runnable mo1091a();

    protected abstract void mo1092a(C2363e c2363e, boolean z);

    protected abstract boolean mo1094a(EobrSessionLogEntry eobrSessionLogEntry, C1015l c1015l);

    protected abstract boolean mo1095a(EobrDevice eobrDevice);

    protected abstract boolean mo1096a(C2363e c2363e, C2338a c2338a);

    protected abstract void mo1097b();

    protected abstract void mo1099b(EobrDevice eobrDevice);

    protected abstract boolean mo1100d();

    protected abstract boolean mo1101e();

    protected abstract long mo1102f();

    protected abstract boolean mo1103h();

    protected abstract void mo1104i();

    protected abstract boolean mo1105j();

    protected abstract void mo1106k();

    protected abstract void mo1107l();

    protected abstract void mo1108m();

    protected abstract void mo1109n();

    protected abstract void mo1110p();

    protected abstract void mo1113u();

    protected abstract void mo1114v();

    protected EobrEntryManager(C2032f c2032f) {
        this.f6401v = c2032f;
        this.f6381b = this.f6401v.mo1297e();
        this.f6382c = this.f6401v.mo1314v();
        this.f6383d = this.f6401v.mo1311s();
        this.f6383d.m11399a(this.f6398s);
        c2032f.mo1300h().m6559a(this.f6399t);
    }

    protected boolean m9055a(byte[] bArr) {
        return this.f6384e != null && Arrays.equals(bArr, this.f6384e);
    }

    private void m9034a(C2348f c2348f) {
        if (this.f6388i != null) {
            C1015l f = this.f6388i.m11543f();
            if (f != null && this.f6385f == State.PROCESS_ENTRIES && c2348f.m11468c().m5231b(f) >= 0) {
                C2134e.m10676b("TT-EobrEntryMgr", "Processing existing entries complete; Polling for new entries");
                m9047a(State.POLL_FOR_NEW_ENTRIES);
            }
            if (c2348f.m11469d()) {
                this.f6386g = c2348f.m11468c();
                return;
            }
            this.f6388i.m11532a((C2347j) c2348f);
            f = c2348f.m11468c();
            if (!(this.f6386g == null || this.f6386g.m5229a(f))) {
                C2134e.m10680d("TT-EobrEntryMgr", "Cursor position is " + this.f6386g + " but processing completed " + f);
            }
            this.f6386g = f;
        }
    }

    private void mo1115w() {
        this.f6380a.removeCallbacks(this.f6405z);
        this.f6380a.post(this.f6405z);
    }

    private void mo1098b(long j) {
        this.f6380a.removeCallbacks(this.f6378A);
        this.f6380a.postDelayed(this.f6378A, j);
    }

    public boolean m9058c() {
        if (!this.f6389j || this.f6388i == null || !this.f6388i.m11545h()) {
            return false;
        }
        mo1115w();
        return true;
    }

    protected void m9047a(State state) {
        if (this.f6385f != state) {
            this.f6385f = state;
            m9040b(state);
        }
    }

    public void m9062g() {
        if (!mo1100d() && !mo1101e()) {
            if (this.f6385f == State.PROCESS_ENTRIES || this.f6385f == State.POLL_FOR_NEW_ENTRIES) {
                m9070o();
            }
            if (mo1103h()) {
                mo1104i();
            } else if (mo1105j()) {
                mo1106k();
            } else if (this.f6385f == State.POLL_FOR_NEW_ENTRIES) {
                this.f6380a.removeCallbacks(mo1091a());
                this.f6380a.postDelayed(mo1091a(), mo1102f());
            } else if (!this.f6389j) {
                C2134e.m10680d("TT-EobrEntryMgr", "Unexpected empty fetch queue when not in polling state: " + this.f6385f + "; Cursor position: " + this.f6386g);
            }
        }
    }

    void m9070o() {
        if ((this.f6385f == State.POLL_FOR_NEW_ENTRIES || this.f6385f == State.PROCESS_ENTRIES) && this.f6386g != null && this.f6388i != null) {
            long c = this.f6382c.mo915c();
            int i = 0;
            while (this.f6388i.m11545h()) {
                this.f6389j = false;
                this.f6380a.removeCallbacks(this.f6378A);
                if (!this.f6387h.isEmpty()) {
                    C0971c c0971c = (C0971c) this.f6387h.removeFirst();
                    if ((c0971c instanceof C1002b) && (((C1002b) c0971c).m5133e() instanceof C1022b)) {
                        C2134e.m10678c("TT-EobrEntryMgr", "Corruption detected at " + c0971c.mo747c().toString() + " while processing VAR entries");
                        mo1109n();
                        break;
                    }
                    int i2 = i + 1;
                    m9034a(new C2348f(c0971c));
                    i = i2;
                } else {
                    if (this.f6387h.isEmpty()) {
                        mo1108m();
                    }
                    if (this.f6387h.isEmpty()) {
                        break;
                    }
                }
            }
            this.f6389j = true;
            mo1098b(5000);
            long c2 = this.f6382c.mo915c() - c;
            if (c2 > 500) {
                C2134e.m10680d("TT-EobrEntryMgr", "Processed " + i + " VAR log entries in " + c2 + "ms (limit: " + 500 + "ms), remaining entry count: " + this.f6387h.size());
            }
        }
    }

    private void m9041b(C2363e c2363e, boolean z) {
        mo1093a(!z);
        this.f6388i = c2363e;
        EobrDevice d = this.f6388i.m11541d();
        this.f6388i.m11534a(this.f6383d.m11407e());
        C2134e.m10678c("TT-EobrEntryMgr", "Using device " + C1180y.m5996c(d.m8992d()));
        m9036a(C1180y.m5996c(d.m8992d()));
        this.f6384e = d.m8992d();
        mo1099b(d);
        this.f6394o = new C2359d();
        mo1092a(c2363e, z);
        m9072q();
        mo1110p();
    }

    protected void m9050a(CursorResetReason cursorResetReason) {
        C2134e.m10680d("TT-EobrEntryMgr", "Restart processing due to: " + cursorResetReason);
        m9047a(State.RESTARTING);
        this.f6393n = cursorResetReason;
    }

    protected void m9072q() {
        this.f6379B.run();
        this.f6380a.postDelayed(this.f6400u, 30000);
    }

    protected void mo1111r() {
        this.f6380a.removeCallbacks(this.f6379B);
        this.f6380a.removeCallbacks(mo1091a());
        this.f6380a.removeCallbacks(this.f6405z);
        this.f6380a.removeCallbacks(this.f6378A);
        this.f6380a.removeCallbacks(this.f6400u);
        this.f6387h.clear();
        this.f6403x.clear();
    }

    protected void mo1112s() {
        m9047a(State.NOT_FETCHING_PAGES);
        this.f6386g = null;
        this.f6389j = false;
        this.f6393n = CursorResetReason.UNKNOWN_CURSOR_RESET_REASON;
    }

    protected void mo1093a(boolean z) {
        mo1113u();
        mo1114v();
        if (this.f6384e != null) {
            C2134e.m10678c("TT-EobrEntryMgr", "No longer using device " + C1180y.m5996c(this.f6384e));
            m9042b(C1180y.m5996c(this.f6384e));
        }
        mo1111r();
        if (this.f6388i != null && z) {
            this.f6388i.m11546i();
        }
        this.f6388i = null;
        mo1112s();
        this.f6384e = null;
        this.f6404y = null;
        this.f6392m = null;
    }

    private void mo1116x() {
        C2134e.m10678c("TT-EobrEntryMgr", "Pausing use of device " + C1180y.m5996c(this.f6384e) + " in state " + this.f6385f);
        this.f6404y = this.f6385f;
        m9047a(State.PAUSED);
        mo1111r();
    }

    private void m9035a(C2363e c2363e) {
        boolean z;
        long g = this.f6401v.mo1300h().m6580g();
        Long l = null;
        if (this.f6388i.m11542e().m11600b() != null) {
            l = Long.valueOf(this.f6388i.m11542e().m11600b().getTruckId());
        }
        if (this.f6404y != State.POLL_FOR_NEW_ENTRIES || c2363e == null || this.f6388i == null || r0 == null || g != r0.longValue()) {
            z = false;
        } else {
            C2134e.m10678c("TT-EobrEntryMgr", "Resuming use of device " + C1180y.m5996c(this.f6384e));
            z = true;
        }
        m9041b(c2363e, z);
    }

    protected void m9075t() {
        int h;
        int a;
        if (this.f6394o != null) {
            C2295o a2 = this.f6394o.m11512a();
            if (a2 != null && (a2.f7935a instanceof EobrSessionLogEntry)) {
                EobrSessionLogEntry eobrSessionLogEntry = (EobrSessionLogEntry) a2.f7935a;
                if (m9037a(eobrSessionLogEntry) && mo1094a(eobrSessionLogEntry, (C1015l) a2.f7936b)) {
                    h = eobrSessionLogEntry.mo754h();
                    if (this.f6396q) {
                        if (h != -1) {
                            C2134e.m10678c("TT-EobrEntryMgr", "Previous session ID ignored, starting new session instead");
                            h = -1;
                        }
                        this.f6396q = false;
                    }
                    a = this.f6383d.m11397a(h);
                    if (!(h == -1 || a == -1)) {
                        this.f6394o.m11513a(h, a);
                    }
                    this.f6383d.m11408f();
                }
            }
        }
        h = -1;
        if (this.f6396q) {
            if (h != -1) {
                C2134e.m10678c("TT-EobrEntryMgr", "Previous session ID ignored, starting new session instead");
                h = -1;
            }
            this.f6396q = false;
        }
        a = this.f6383d.m11397a(h);
        this.f6394o.m11513a(h, a);
        this.f6383d.m11408f();
    }

    private boolean m9037a(EobrSessionLogEntry eobrSessionLogEntry) {
        return Arrays.equals(eobrSessionLogEntry.mo751e(), this.f6401v.mo1295c().m12191a()) && eobrSessionLogEntry.mo753g() == this.f6401v.mo1300h().m6580g() && eobrSessionLogEntry.mo752f() == this.f6401v.mo1295c().m12202d();
    }

    public void m9048a(C1869a c1869a) {
        this.f6402w.m4159a(c1869a, 0);
    }

    private void m9036a(final String str) {
        this.f6402w.m4157a(new C0837a<C1869a>(this) {
            final /* synthetic */ EobrEntryManager f6366b;

            public void m9020a(C1869a c1869a) {
                c1869a.mo1078a(str);
            }
        });
    }

    private void m9042b(final String str) {
        this.f6402w.m4157a(new C0837a<C1869a>(this) {
            final /* synthetic */ EobrEntryManager f6353b;

            public void m9012a(C1869a c1869a) {
                c1869a.mo1079b(str);
            }
        });
    }

    private void m9040b(final State state) {
        this.f6402w.m4157a(new C0837a<C1869a>(this) {
            final /* synthetic */ EobrEntryManager f6355b;

            public void m9014a(C1869a c1869a) {
                c1869a.mo1077a(state);
            }
        });
    }

    protected void m9046a(final long j) {
        this.f6402w.m4157a(new C0837a<C1869a>(this) {
            final /* synthetic */ EobrEntryManager f6358b;

            public void m9017a(C1869a c1869a) {
                c1869a.mo1076a(j);
            }
        });
    }
}
