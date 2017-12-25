package com.bigroad.ttb.android.eobr.turbo;

import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.C0969b;
import com.bigroad.shared.eobr.C0970d;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.turbo.C1009h;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1017o;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.C1034n;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData.C1019a;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.shared.eobr.turbo.messages.C1058u;
import com.bigroad.shared.eobr.turbo.messages.C1059v;
import com.bigroad.shared.eobr.turbo.messages.C1061x;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.C1934j;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrEntryManager;
import com.bigroad.ttb.android.eobr.EobrEntryManager.State;
import com.bigroad.ttb.android.eobr.turbo.C1978g.C1975a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.p036a.aa;
import com.bigroad.ttb.android.util.C2295o;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.protocol.TTProtocol.CursorResetReason;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp.C2730a;
import com.bigroad.ttb.protocol.TTProtocol.VarPage;
import com.bigroad.ttb.protocol.TTProtocol.VarSyncRequest;
import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.primitives.UnsignedInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class C1976f extends EobrEntryManager implements C1975a {
    private static final Predicate<C1016p> f6804L = new C19664();
    private static final Predicate<C1016p> f6805N = new C19686();
    private static C2032f f6806x;
    private static C1976f f6807y;
    private C1974b f6808A = null;
    private long f6809B = 0;
    private long f6810C = 1;
    private long f6811D = 1;
    private Long f6812E;
    private byte[] f6813F = null;
    private long f6814G;
    private C1934j f6815H = new C1934j();
    private final Runnable f6816I = new C19631(this);
    private final C1206c f6817J = new C19642(this);
    private final C1206c f6818K = new C1954a(this, this, "current position") {
        final /* synthetic */ C1976f f6795b;

        void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x) {
            if (this.f6795b.f == State.GET_CURRENT_VAR_POSITION && c1059v.a == 0) {
                Integer b = C1009h.m5186b(varPage.m9610c());
                if (b == null) {
                    C2134e.m10678c("TT-VarMgr", "Corruption detected in page " + varPage.m9607b() + "; getting the current VAR page");
                    this.f6795b.mo1109n();
                    return;
                }
                C1015l c1015l = new C1015l(varPage.m9607b(), b.intValue());
                this.f6795b.p = (long) c1061x.f3471c;
                C2134e.m10678c("TT-VarMgr", "Current VAR position: " + c1015l + " Uptime: " + this.f6795b.p);
                this.f6795b.i.m11530a(c1015l);
                this.f6795b.m9047a(State.FIND_LAST_EOBR_EVENT);
                this.f6795b.m9744b(varPage);
            }
        }

        void mo1164a(C1059v c1059v) {
        }
    };
    private final C1206c f6819M = new C1954a(this, this, "last EOBR event") {
        final /* synthetic */ C1976f f6796b;

        void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x) {
            if (this.f6796b.f == State.FIND_LAST_EOBR_EVENT) {
                this.f6796b.m9744b(varPage);
            }
        }

        void mo1164a(C1059v c1059v) {
            this.f6796b.m9739a("Out of valid pages");
        }
    };
    private final C1206c f6820O = new C1954a(this, this, "find app start") {
        final /* synthetic */ C1976f f6797b;

        void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x) {
            if (this.f6797b.f == State.FIND_APP_START_ENTRY) {
                this.f6797b.m9758f(varPage);
            }
        }

        void mo1164a(C1059v c1059v) {
            this.f6797b.m9725A();
        }
    };
    private final C1206c f6821P = new C1954a(this, this, "confirm app start") {
        final /* synthetic */ C1976f f6798b;

        void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x) {
            if (this.f6798b.f == State.FIND_APP_START_ENTRY) {
                this.f6798b.m9738a(this.f6798b.f6826w, varPage);
            }
        }

        void mo1164a(C1059v c1059v) {
            this.f6798b.m9725A();
        }
    };
    private final C1206c f6822Q = new C1954a(this, this, "find vehicle start") {
        final /* synthetic */ C1976f f6799b;

        void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x) {
            if (this.f6799b.f == State.FIND_VEHICLE_STATE_START_ENTRY) {
                this.f6799b.m9760g(varPage);
            }
        }

        void mo1164a(C1059v c1059v) {
            this.f6799b.m9748b("vehicle state start event");
        }
    };
    private final C1206c f6823R = new C1972c(this, this, "var page fetch");
    private final C1206c f6824S = new C1973a(this);
    public C2295o<C1016p, C1015l> f6825v;
    public C2295o<C1016p, C1015l> f6826w;
    private final LinkedList<C2295o<Long, C1206c>> f6827z = new LinkedList();

    class C19631 implements Runnable {
        final /* synthetic */ C1976f f6793a;

        C19631(C1976f c1976f) {
            this.f6793a = c1976f;
        }

        public void run() {
            this.f6793a.m9732a(0, this.f6793a.f6823R, "Newest page timer");
            this.f6793a.m9726B();
        }
    }

    class C19642 implements C1206c {
        final /* synthetic */ C1976f f6794a;

        C19642(C1976f c1976f) {
            this.f6794a = c1976f;
        }

        public void mo897a(C0972e c0972e, C0973f c0973f) {
            this.f6794a.mo1115w();
        }
    }

    static class C19664 implements Predicate<C1016p> {
        C19664() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9696a((C1016p) obj);
        }

        public boolean m9696a(C1016p c1016p) {
            if ((c1016p instanceof C1031k) || (c1016p instanceof MobileClientSessionLogEntry)) {
                return true;
            }
            return false;
        }
    }

    static class C19686 implements Predicate<C1016p> {
        C19686() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m9699a((C1016p) obj);
        }

        public boolean m9699a(C1016p c1016p) {
            return (c1016p instanceof C1031k) || (c1016p instanceof C1036s);
        }
    }

    private class C1972c extends C1954a {
        final /* synthetic */ C1976f f6800c;

        C1972c(C1976f c1976f, C1975a c1975a, String str) {
            this.f6800c = c1976f;
            super(c1975a, str);
        }

        void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x) {
            long b = varPage.m9607b();
            if (c1059v.a == -1) {
                this.f6800c.f6811D = b;
                C2134e.m10678c("TT-VarMgr", "Oldest available page is: " + this.f6800c.f6811D);
                Long c = this.f6800c.f6815H.m9518c();
                this.f6800c.f6810C = c != null ? c.longValue() : 1;
                if (this.f6800c.f6811D > this.f6800c.f6810C) {
                    this.f6800c.f6810C = this.f6800c.f6811D;
                }
            } else if (c1059v.a != 0) {
                this.f6800c.f6815H.m9512a(this.f6800c.b, this.f6800c.g);
            } else if (this.f6800c.f == State.POLL_FOR_NEW_ENTRIES) {
                if (this.f6800c.f6809B > 0 && this.f6800c.f6809B != b) {
                    for (long i = this.f6800c.f6809B; i < b; i++) {
                        this.f6800c.m9732a(i, this.f6800c.f6823R, "Fetch between " + this.f6800c.f6809B + " and " + b);
                    }
                }
                if (!z && b == this.f6800c.g.m5228a()) {
                    RelativeTimestamp a = this.f6800c.i.m11528a();
                    b = UnsignedInteger.m18836a(c1061x.f3471c).longValue();
                    if (a != null && b > a.getRelativeTimeSec()) {
                        long relativeTimeSec = b - a.getRelativeTimeSec();
                        C2730a newBuilder = RelativeTimestamp.newBuilder();
                        if (a.hasAbsoluteTimeMillis()) {
                            newBuilder.m14805b((relativeTimeSec * 1000) + a.getAbsoluteTimeMillis());
                        }
                        newBuilder.m14801a(b);
                        if (this.f6800c.i.m11545h()) {
                            this.f6800c.i.m11531a(this.f6800c.g, newBuilder.m14807c());
                        }
                    }
                }
            }
        }

        void mo1164a(C1059v c1059v) {
        }
    }

    private class C1973a extends C1972c {
        final /* synthetic */ C1976f f6801b;

        C1973a(C1976f c1976f) {
            this.f6801b = c1976f;
            super(c1976f, c1976f, "timestamp");
        }

        protected void mo1166a(Long l) {
            this.a.mo1173a(l);
        }
    }

    private static class C1974b {
        private long f6802a;
        private boolean f6803b = false;

        C1974b(long j) {
            this.f6802a = j;
        }

        long m9709a() {
            return this.f6802a;
        }

        boolean m9711b() {
            return this.f6803b;
        }

        void m9710a(boolean z) {
            this.f6803b = z;
        }
    }

    public static C1976f m9730a(C2032f c2032f) {
        if (f6807y == null) {
            f6806x = c2032f;
            f6807y = new C1976f();
        }
        return f6807y;
    }

    protected boolean mo1096a(C2363e c2363e, C2338a c2338a) {
        return mo1095a(c2363e.m11541d()) && this.f == State.NOT_FETCHING_PAGES && c2338a.m11450a(ConnectionFlag.TURBO_FIRMWARE_VALID);
    }

    protected void mo1092a(C2363e c2363e, boolean z) {
        Long c = this.f6815H.m9518c();
        this.f6810C = c != null ? c.longValue() : 1;
        if (this.f6811D > this.f6810C) {
            this.f6810C = this.f6811D;
        }
    }

    protected boolean mo1095a(EobrDevice eobrDevice) {
        return eobrDevice != null && eobrDevice.mo1121o().m4939c();
    }

    protected Runnable mo1091a() {
        return this.f6816I;
    }

    protected void mo1115w() {
        C2134e.m10676b("TT-VarMgr", "Resetting state to restart processing");
        this.f6815H.m9512a(this.b, this.g);
        mo1111r();
        mo1112s();
        C1015l f = this.i.m11543f();
        VarPage d = f != null ? mo1175d(f.m5228a()) : null;
        m9072q();
        if (d == null) {
            mo1110p();
            return;
        }
        m9047a(State.FIND_LAST_EOBR_EVENT);
        m9732a(0, this.f6819M, "Search for EOBR event following restart");
        m9726B();
    }

    private C1976f() {
        super(f6806x);
    }

    protected long mo1102f() {
        return 1000;
    }

    protected void mo1110p() {
        m9047a(State.GET_CURRENT_VAR_POSITION);
        m9732a(0, this.f6818K, "Kick off current position search");
        m9726B();
    }

    protected boolean mo1100d() {
        if (this.f != State.RESTARTING) {
            return false;
        }
        C2134e.m10676b("TT-VarMgr", "Writing restart cursor event");
        this.d.m11401a(this.n, this.f6817J);
        return true;
    }

    protected boolean mo1101e() {
        if (this.f6808A == null || !this.f6808A.m9711b()) {
            return false;
        }
        return true;
    }

    protected void mo1108m() {
        C1978g.m9810a((C1975a) this, this.g, this.h);
    }

    protected void mo1111r() {
        super.mo1111r();
        this.f6808A = null;
    }

    protected void mo1112s() {
        super.mo1112s();
        this.f6812E = null;
        this.f6809B = 0;
        this.f6825v = null;
        this.f6826w = null;
    }

    protected void mo1093a(boolean z) {
        super.mo1093a(z);
        this.f6810C = 1;
        this.f6811D = 1;
    }

    protected void mo1097b() {
        C2134e.m10680d("TT-VarMgr", "Startup cutoff timer engaged");
        m9050a(CursorResetReason.TIMEOUT);
    }

    protected void mo1109n() {
        C2134e.m10678c("TT-VarMgr", "Attempting corruption recovery...");
        m9047a(State.CORRUPTION_DETECTED);
        this.a.removeCallbacks(this.u);
        if (this.i == null) {
            C2134e.m10682e("TT-VarMgr", "Attempted to recover from corruption with no mobile client session tracker");
            return;
        }
        this.i.m11547j();
        EobrDevice d = this.i.m11541d();
        if (this.f6813F != d.m8992d() || this.c.mo915c() - this.f6814G >= 1800000) {
            this.f6813F = d.m8992d();
            this.f6814G = this.c.mo915c();
            d.m9006r();
        }
    }

    private void m9744b(VarPage varPage) {
        if (!m9754d(varPage)) {
            CursorResetReason e = m9755e(varPage);
            if (e != null) {
                m9050a(e);
                return;
            }
            long b = varPage.m9607b() - 1;
            while (b >= this.f6811D) {
                VarPage d = mo1175d(b);
                if (d == null || !d.m9611d()) {
                    m9732a(b, this.f6819M, "Search for EOBR event");
                    return;
                } else if (!m9754d(d)) {
                    CursorResetReason e2 = m9755e(d);
                    if (e2 != null) {
                        m9050a(e2);
                        return;
                    }
                    b--;
                } else {
                    return;
                }
            }
            m9050a(CursorResetReason.END_OF_STREAM);
        }
    }

    private void m9751c(VarPage varPage) {
        C2295o b = varPage.m9609b(f6804L, Integer.MAX_VALUE);
        if (b != null) {
            int b2 = ((C1015l) b.f7936b).m5230b();
            C0969b c0969b = (C1017o) b.f7935a;
            C1017o c1017o;
            do {
                this.o.m11514a(c0969b, new C1015l(varPage.m9607b(), b2));
                b2--;
                if (b2 > 0) {
                    c1017o = (C1017o) varPage.m9608b((long) b2);
                } else {
                    return;
                }
            } while (c1017o != null);
        }
    }

    protected boolean mo1094a(EobrSessionLogEntry eobrSessionLogEntry, C1015l c1015l) {
        VarPage d = mo1175d(c1015l.m5228a());
        if (d == null || !(eobrSessionLogEntry instanceof MobileClientSessionLogEntry)) {
            return false;
        }
        MobileClientSessionLogEntry mobileClientSessionLogEntry = (MobileClientSessionLogEntry) eobrSessionLogEntry;
        if (this.p - (d.m9614g().longValue() + ((long) mobileClientSessionLogEntry.g)) <= 60) {
            return true;
        }
        return false;
    }

    private boolean m9754d(VarPage varPage) {
        if (this.m == null) {
            C2295o a = varPage.m9602a(C1034n.class);
            if (a != null) {
                this.m = (C0970d) a.f7935a;
            }
        }
        C1015l f = varPage.m9613f();
        C1015l h = varPage.m9615h();
        m9751c(varPage);
        if (!(f == null || h == null)) {
            if (h.m5231b(f) > 0) {
                f = null;
            } else {
                h = null;
            }
        }
        if (f != null) {
            h = m9728a(varPage, f);
        } else if (h != null) {
            h = m9741b(varPage, h);
        } else {
            h = null;
        }
        if ((h == null || h.m5228a() < varPage.m9607b()) && varPage.m9619l() && varPage.m9617j().intValue() == 64) {
            h = new C1015l(varPage.m9607b(), 1);
            C2134e.m10678c("TT-VarMgr", "Found a soft reset entry, due to detected corruption: " + h.toString());
        }
        if (h == null) {
            return false;
        }
        m9743b(h);
        return true;
    }

    private C1015l m9728a(VarPage varPage, C1015l c1015l) {
        C1015l c1015l2;
        C1016p b = varPage.m9608b((long) c1015l.m5230b());
        if (b instanceof C1023c) {
            C1023c c1023c = (C1023c) b;
            C2134e.m10678c("TT-VarMgr", "Found EOBR event: " + c1015l.toString());
            try {
                C1019a a = EobrEventLogData.m5240a(c1023c.f3251a);
                if (a == null) {
                    C2134e.m10680d("TT-VarMgr", "Couldn't parse EOBR event metadata");
                    c1015l2 = null;
                } else {
                    c1015l2 = a.m5239a();
                }
            } catch (Throwable e) {
                C2134e.m10679c("TT-VarMgr", "IOException parsing EOBR event metadata", e);
            }
        } else {
            C2134e.m10680d("TT-VarMgr", "lastEobrEventPosition not an instance of EobrEventLog");
            c1015l2 = null;
        }
        if (c1015l2 == null) {
            return null;
        }
        C1015l e2 = this.f6815H.m9522e();
        if (e2 != null) {
            if (e2 == c1015l2) {
                C2134e.m10678c("TT-VarMgr", "Resuming processing at cursor position: " + e2.toString());
            } else {
                C2134e.m10678c("TT-VarMgr", "EOBR events written to this turbo not by this client instance; " + e2.toString() + " > " + c1015l2.toString());
            }
        }
        return c1015l2;
    }

    private C1015l m9741b(VarPage varPage, C1015l c1015l) {
        C1016p b = varPage.m9608b((long) c1015l.m5230b());
        if (b instanceof C1025e) {
            C2134e.m10678c("TT-VarMgr", "Found Cursor Reset: " + new C1024d((C1025e) b).m5267g().getReason().toString() + " at " + c1015l.toString());
            return c1015l;
        }
        C2134e.m10680d("TT-VarMgr", "lastCursorResetPosition not set to a Cursor Reset");
        return null;
    }

    private void m9743b(C1015l c1015l) {
        m9075t();
        m9047a(State.FIND_APP_START_ENTRY);
        C2134e.m10678c("TT-VarMgr", "New last stored cursor position: " + c1015l.toString());
        this.f6815H.m9511a(c1015l);
        this.i.m11537b(c1015l);
        VarPage d = mo1175d(c1015l.m5228a());
        if (d == null || !d.m9611d()) {
            m9732a(c1015l.m5228a(), this.f6820O, "Search for app start (2)");
        } else {
            m9758f(d);
        }
    }

    private CursorResetReason m9755e(VarPage varPage) {
        C2295o a = varPage.m9602a(C1031k.class);
        if (a != null && ((C1031k) a.f7935a).f3272c != 0 && ((C1031k) a.f7935a).f3272c < 13) {
            return CursorResetReason.DEPRECATED_FIRMWARE;
        }
        long j = 0;
        if (!(varPage.m9620m() == null || this.m == null)) {
            j = this.m.mo749d() - varPage.m9620m().longValue();
        }
        if (j > 691200000) {
            return CursorResetReason.SEARCH_UNREACHABLE;
        }
        return null;
    }

    private void m9739a(String str) {
        C2134e.m10680d("TT-VarMgr", "Unable to find EOBR event; " + str);
        m9075t();
        m9047a(State.FIND_APP_START_ENTRY);
        this.f6815H.m9520d();
        VarPage d = mo1175d(this.f6809B);
        if (d != null) {
            m9758f(d);
        } else {
            m9732a(this.f6809B, this.f6820O, "Search for app start (1)");
        }
    }

    private C2295o<C1016p, C1015l> m9731a(VarPage varPage, int i) {
        m9751c(varPage);
        if (this.f6826w != null) {
            C2134e.m10682e("TT-VarMgr", "Called findAppStart after m_confirmedAppStartLogEntry already set: " + this.f6826w.f7936b);
            return this.f6826w;
        }
        for (C2295o c2295o : Lists.m18640a(varPage.m9604a(f6805N, i))) {
            if (c2295o.f7935a instanceof C1031k) {
                if (((C1031k) c2295o.f7935a).f3275f == 64) {
                    this.f6826w = c2295o;
                    break;
                }
                this.f6825v = c2295o;
            } else if (c2295o.f7935a instanceof C1036s) {
                C1036s c1036s = (C1036s) c2295o.f7935a;
                if (!c1036s.m5280e()) {
                    if (!c1036s.m5281f()) {
                        if (this.f6825v != null && c1036s.m5278c() && c1036s.m5279d()) {
                            this.f6826w = this.f6825v;
                            break;
                        }
                    }
                    this.f6825v = c2295o;
                } else {
                    this.f6825v = c2295o;
                }
            } else {
                continue;
            }
        }
        return this.f6826w;
    }

    private void m9758f(VarPage varPage) {
        int i;
        C1015l e = this.f6815H.m9522e();
        if (e != null && e.m5228a() < varPage.m9607b()) {
            C2134e.m10680d("TT-VarMgr", "Unexpected stored cursor position; clear & continue");
            this.f6815H.m9520d();
            e = null;
        }
        if (e == null || e.m5228a() != varPage.m9607b()) {
            i = Integer.MAX_VALUE;
        } else {
            i = e.m5230b();
        }
        C2295o a = m9731a(varPage, i);
        if (a == null) {
            for (long b = varPage.m9607b() - 1; b >= this.f6811D; b--) {
                varPage = mo1175d(b);
                if (varPage == null || !varPage.m9611d()) {
                    m9732a(b, this.f6820O, "Search for app start (3)");
                    return;
                }
                a = m9731a(varPage, Integer.MAX_VALUE);
                if (a != null) {
                    break;
                }
            }
        }
        if (a != null) {
            C2134e.m10678c("TT-VarMgr", "Found app start event: " + a.f7936b);
            m9738a(a, varPage);
            return;
        }
        m9725A();
    }

    private void m9725A() {
        if (this.f6825v == null || !(this.f6825v.f7935a instanceof C1031k)) {
            m9748b("app start event");
            return;
        }
        this.f6826w = this.f6825v;
        m9738a(this.f6826w, null);
    }

    private void m9738a(C2295o<C1016p, C1015l> c2295o, VarPage varPage) {
        if (c2295o == null) {
            C2134e.m10682e("TT-VarMgr", "Attempted to confirmAppStartEntry with a null appStartEntry");
            m9725A();
            return;
        }
        C2134e.m10678c("TT-VarMgr", "Found app start event: " + c2295o.f7936b);
        long a = ((C1015l) c2295o.f7936b).m5228a();
        if (varPage == null || varPage.m9607b() != a) {
            varPage = mo1175d(a);
            if (varPage == null || !varPage.m9611d()) {
                m9732a(a, this.f6821P, "Search for app start (4)");
                return;
            }
        }
        if (c2295o.f7935a instanceof C1017o) {
            if (varPage.m9614g() != null) {
                this.f6812E = Long.valueOf(((long) ((C1017o) c2295o.f7935a).f3193g) + varPage.m9614g().longValue());
            } else {
                this.f6812E = null;
            }
            this.i.m11540c((C1015l) c2295o.f7936b);
        }
        this.g = (C1015l) c2295o.f7936b;
        this.k = (C1015l) c2295o.f7936b;
        m9047a(State.FIND_VEHICLE_STATE_START_ENTRY);
        m9760g(varPage);
    }

    private void m9748b(String str) {
        C2134e.m10680d("TT-VarMgr", "Could not find " + str);
        C1015l e = this.f6815H.m9522e();
        if (e != null) {
            this.g = e.m5235f();
        } else {
            this.g = new C1015l(this.f6809B, 0);
        }
        this.i.m11533a(this.o);
        m9047a(State.PROCESS_ENTRIES);
        this.a.removeCallbacks(this.u);
        m9062g();
    }

    private C2295o<C1016p, C1015l> m9742b(VarPage varPage, int i) {
        m9751c(varPage);
        return varPage.m9603a(Long.valueOf(this.f6812E.longValue() - 86400), i);
    }

    private void m9760g(VarPage varPage) {
        if (this.f6812E == null) {
            m9748b("vehicle state start event");
            return;
        }
        int b;
        C2295o c2295o;
        if (this.g.m5228a() == varPage.m9607b()) {
            b = this.g.m5230b();
        } else {
            b = Integer.MAX_VALUE;
        }
        C2295o b2 = m9742b(varPage, b);
        if (b2 == null) {
            for (long b3 = varPage.m9607b() - 1; b3 >= this.f6811D; b3--) {
                VarPage d = mo1175d(b3);
                if (d == null || !d.m9611d()) {
                    m9732a(b3, this.f6822Q, "Search for vehicle state start (3)");
                    return;
                }
                b2 = m9742b(d, Integer.MAX_VALUE);
                if (b2 != null) {
                    c2295o = b2;
                    break;
                }
            }
        }
        c2295o = b2;
        if (c2295o != null) {
            C2134e.m10678c("TT-VarMgr", "Found vehicle state start event: " + c2295o.f7936b);
            this.g = (C1015l) c2295o.f7936b;
            this.l = (C1015l) c2295o.f7936b;
            this.i.m11533a(this.o);
            m9047a(State.PROCESS_ENTRIES);
            this.a.removeCallbacks(this.u);
            m9062g();
            return;
        }
        m9748b("vehicle state start event");
    }

    public void mo1098b(long j) {
        this.f6809B = j;
    }

    public void mo1171a(C1058u c1058u) {
        m9732a(-1, this.f6823R, "Request oldest VAR page");
    }

    public boolean mo1174c(long j) {
        return this.f6815H.m9521d(j);
    }

    public long mo1116x() {
        return this.f6811D;
    }

    public VarPage mo1168a(EobrDevice eobrDevice, long j, VarPage varPage, byte[] bArr) {
        if (m9055a(eobrDevice.m8992d())) {
            Long f = this.f6815H.m9523f();
            boolean z = f != null && j < f.longValue();
            VarPage a = VarPage.m9598a(eobrDevice.m8992d(), Long.valueOf(j), varPage, bArr, z);
            mo1172a(a);
            if (f != null && j <= f.longValue()) {
                return a;
            }
            this.f6815H.m9519c(j);
            return a;
        }
        C2134e.m10680d("TT-VarMgr", "Attempt to update VAR database with non-matching page");
        return null;
    }

    protected boolean mo1103h() {
        return this.f6808A != null;
    }

    protected void mo1104i() {
        mo1107l();
    }

    protected boolean mo1105j() {
        return !this.f6827z.isEmpty();
    }

    protected void mo1106k() {
        m9726B();
    }

    private void m9726B() {
        if (this.f6827z.isEmpty()) {
            C2134e.m10680d("TT-VarMgr", "fetchNextVarPage called with empty queue");
            return;
        }
        EobrDevice j = this.d.m11412j();
        if (j != null && m9055a(j.m8992d()) && mo1095a(j)) {
            C2295o c2295o = (C2295o) this.f6827z.remove();
            j.m8982a(((Long) c2295o.f7935a).longValue(), (C1206c) c2295o.f7936b);
            m9046a(((Long) c2295o.f7935a).longValue());
        }
    }

    protected void mo1107l() {
        if (this.f6808A != null && !this.f6808A.m9711b()) {
            EobrDevice j = this.d.m11412j();
            if (j != null && m9055a(j.m8992d()) && mo1095a(j)) {
                j.m8982a(this.f6808A.m9709a(), this.f6824S);
                this.f6808A.m9710a(true);
                return;
            }
            this.f6808A = null;
        }
    }

    public void mo1173a(Long l) {
        if (this.f6808A == null) {
            C2134e.m10676b("TT-VarMgr", "Received unexpected var page: " + l);
        } else if (l == null) {
            C2134e.m10676b("TT-VarMgr", "VAR page " + this.f6808A.m9709a() + " response was not received");
        } else if (l.longValue() != this.f6808A.m9709a()) {
            C2134e.m10676b("TT-VarMgr", "VAR page receipt mismatch. Expecting " + this.f6808A + " received " + l);
        }
        this.f6808A = null;
    }

    public void mo1170a(long j, String str) {
        m9732a(j, this.f6823R, str);
    }

    private void m9732a(long j, C1206c c1206c, String str) {
        C2295o c2295o = new C2295o(Long.valueOf(j), c1206c);
        if (!this.f6827z.contains(c2295o)) {
            this.f6827z.addLast(c2295o);
        }
    }

    public void mo1169a(long j, long j2, String str) {
        if (this.f6808A != null) {
            C2134e.m10680d("TT-VarMgr", "Attempt to request page " + j2 + " to timestamp page " + j + " for reason: " + str + ", while there is an outstanding request for page " + this.f6808A.m9709a());
        } else {
            this.f6808A = new C1974b(j2);
        }
    }

    public void m9781a(byte[] bArr, long j) {
        Long a = this.f6815H.m9509a(this.b, bArr, j);
        if (m9055a(bArr)) {
            this.f6810C = a.longValue();
            if (this.f6811D > this.f6810C) {
                this.f6810C = this.f6811D;
            }
        }
    }

    public void m9807y() {
        for (aa aaVar : this.b.m8707B()) {
            Long valueOf;
            Long f = aaVar.m8568f();
            if (f == null) {
                f = this.b.m8770d(aaVar.m8567e());
                if (f == null) {
                    f = Long.valueOf(1);
                }
            }
            if (this.f6810C > f.longValue()) {
                valueOf = Long.valueOf(this.f6810C);
            } else {
                valueOf = f;
            }
            List a = this.b.m8722a(aaVar.m8567e(), valueOf.longValue(), 64);
            if (valueOf.longValue() != this.f6809B && (a.isEmpty() || ((VarPage) a.get(0)).m9607b() != valueOf.longValue())) {
                Object obj;
                String str = "TT-VarMgr";
                StringBuilder append = new StringBuilder().append("Requesting missing VAR pages for sync; start=").append(valueOf).append("; lastCurrentPageReceived=").append(this.f6809B).append("; firstPageToSync=");
                if (a.isEmpty()) {
                    obj = "empty";
                } else {
                    obj = Long.valueOf(((VarPage) a.get(0)).m9607b());
                }
                C2134e.m10678c(str, append.append(obj).toString());
                long min = Math.min(valueOf.longValue() + 64, this.f6809B);
                for (long longValue = valueOf.longValue(); longValue < min; longValue++) {
                    m9732a(longValue, this.f6823R, "Fetch page for sync");
                }
                this.f6810C = min;
            }
            if (!a.isEmpty()) {
                C2134e.m10676b("TT-VarMgr", "Device " + C1180y.m5996c(aaVar.m8567e()) + " syncing VAR pages (" + a.size() + " pages; min page number:" + ((VarPage) a.get(0)).m9607b() + ")");
                OurApplication.m6289k().m6488a(aaVar.m8567e(), a, this.f6811D);
            }
        }
    }

    public void m9778a(VarSyncRequest varSyncRequest) {
        byte[] d = varSyncRequest.getDashLinkId().m19091d();
        List arrayList = new ArrayList(varSyncRequest.getVarDataCount());
        for (VarPage pageNumber : varSyncRequest.getVarDataList()) {
            arrayList.add(Long.valueOf(pageNumber.getPageNumber()));
        }
        this.b.m8748a(d, arrayList);
    }

    public void mo1172a(VarPage varPage) {
        this.f6815H.m9514a(varPage);
    }

    public VarPage mo1175d(long j) {
        if (this.f6815H.m9515a(j)) {
            return this.f6815H.m9516b(j);
        }
        return this.b.m8717a(this.e, j);
    }

    public C1015l mo1167a(C1015l c1015l) {
        this.g = c1015l;
        return c1015l;
    }

    public C2032f mo1176z() {
        return f6806x;
    }

    protected void mo1113u() {
        this.f6815H.m9512a(this.b, this.g);
    }

    protected void mo1099b(EobrDevice eobrDevice) {
        this.f6815H.m9513a(this.b, eobrDevice);
    }

    protected void mo1114v() {
        this.f6815H.m9510a();
        this.f6815H.m9517b();
    }
}
