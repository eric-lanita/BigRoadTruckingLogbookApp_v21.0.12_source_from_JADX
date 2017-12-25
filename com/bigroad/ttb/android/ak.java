package com.bigroad.ttb.android;

import com.bigroad.shared.C1130o;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.af;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.ap;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.ConnectionFlag;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.DrivingModeManager.C1209a;
import com.bigroad.ttb.android.activity.OurActivity;
import com.bigroad.ttb.android.dialog.ErrorDialogFragment;
import com.bigroad.ttb.android.dialog.YardMoveDialogFragment;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrManager;
import com.bigroad.ttb.android.eobr.EobrManager.C1449b;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2298r;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.common.base.Objects;

public class ak {
    public static final long f5945a = Math.round(CanonicalOdometerUnit.KM.m5469a(8));
    public static final long f5946b = ((long) CanonicalOdometerUnit.MILES.m5469a(5));
    private static ak f5947c;
    private final DrivingModeManager f5948d;
    private final EobrManager f5949e;
    private final EventManager f5950f;
    private final ap f5951g;
    private final VehicleConnectionManager f5952h;
    private final ag<C1536a> f5953i = new ag();
    private final C2298r f5954j = new C2298r();
    private final C2298r f5955k = new C2298r();
    private long f5956l = 0;
    private C1722b f5957m = new C1722b();
    private C2369i f5958n = null;
    private Long f5959o = null;
    private final ChangeListener f5960p = new C17171(this);
    private final EobrManager.ChangeListener f5961q = new C17182(this);
    private final C1209a f5962r = new C17193(this);

    public interface C1536a {
        void mo1011a(C1722b c1722b);
    }

    class C17171 extends C1201a {
        final /* synthetic */ ak f5935a;

        C17171(ak akVar) {
            this.f5935a = akVar;
        }

        public void mo890a(C2369i c2369i) {
            this.f5935a.f5958n = c2369i;
            if (c2369i == null) {
                this.f5935a.f5959o = null;
            }
            this.f5935a.m8420i();
        }

        public void mo886a(long j) {
            if (this.f5935a.f5958n != null) {
                this.f5935a.f5959o = Long.valueOf(j);
                this.f5935a.m8420i();
            }
        }

        public void mo888a(C2338a c2338a) {
            if (!c2338a.m11450a(ConnectionFlag.CONNECTED)) {
                this.f5935a.f5958n = null;
                this.f5935a.f5959o = null;
            }
            this.f5935a.m8414e();
        }
    }

    class C17182 extends C1449b {
        final /* synthetic */ ak f5936a;

        C17182(ak akVar) {
            this.f5936a = akVar;
        }

        public void mo997a(EobrDevice eobrDevice) {
            this.f5936a.m8414e();
        }

        public void mo1000b(EobrDevice eobrDevice) {
            if (eobrDevice == this.f5936a.f5952h.m11412j() && this.f5936a.m8418g()) {
                this.f5936a.m8414e();
            }
        }
    }

    class C17193 implements C1209a {
        final /* synthetic */ ak f5937a;

        C17193(ak akVar) {
            this.f5937a = akVar;
        }

        public void mo981a() {
            this.f5937a.m8414e();
        }
    }

    class C17204 implements C0837a<C1536a> {
        final /* synthetic */ ak f5938a;

        C17204(ak akVar) {
            this.f5938a = akVar;
        }

        public void m8396a(C1536a c1536a) {
            c1536a.mo1011a(this.f5938a.f5957m);
        }
    }

    public static class C1722b {
        public static final C1722b f5940a = new C1722b();
        private final boolean f5941b;
        private final boolean f5942c;
        private final long f5943d;
        private final OdometerUnit f5944e;

        private C1722b() {
            this.f5941b = false;
            this.f5942c = false;
            this.f5943d = 0;
            this.f5944e = OdometerUnit.MILES;
        }

        public C1722b(boolean z, long j, OdometerUnit odometerUnit) {
            this.f5941b = true;
            this.f5942c = z;
            this.f5943d = j;
            this.f5944e = odometerUnit;
        }

        public boolean m8398a() {
            return this.f5941b;
        }

        public boolean m8399b() {
            return this.f5942c;
        }

        public long m8400c() {
            return this.f5943d;
        }

        public OdometerUnit m8401d() {
            return this.f5944e;
        }

        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1722b c1722b = (C1722b) obj;
            if (Objects.equal(Boolean.valueOf(this.f5941b), Boolean.valueOf(c1722b.f5941b)) && Objects.equal(Boolean.valueOf(this.f5942c), Boolean.valueOf(c1722b.f5942c)) && Objects.equal(Long.valueOf(this.f5943d), Long.valueOf(c1722b.f5943d)) && Objects.equal(this.f5944e, c1722b.f5944e)) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Boolean.valueOf(this.f5941b), Boolean.valueOf(this.f5942c), Long.valueOf(this.f5943d), this.f5944e);
        }
    }

    public static ak m8403a(C2032f c2032f) {
        if (f5947c == null) {
            f5947c = new ak(c2032f);
        }
        return f5947c;
    }

    private ak(C2032f c2032f) {
        this.f5948d = c2032f.mo1317y();
        this.f5949e = c2032f.mo1310r();
        this.f5950f = c2032f.mo1301i();
        this.f5951g = c2032f.mo1314v();
        this.f5952h = c2032f.mo1311s();
        this.f5948d.m6190a(this.f5962r);
        this.f5949e.m9118a(this.f5961q);
        this.f5952h.m11399a(this.f5960p);
    }

    public void m8424a(C1536a c1536a) {
        this.f5953i.m4159a(c1536a, 0);
    }

    public void m8425b(C1536a c1536a) {
        this.f5953i.m4158a((Object) c1536a);
    }

    private void m8409b() {
        this.f5953i.m4157a(new C17204(this));
    }

    public C1722b m8421a() {
        return this.f5957m;
    }

    public void m8423a(OurActivity ourActivity, Reason reason, DutyStatusChangeBits.Reason reason2) {
        C2338a d = this.f5952h.m11406d();
        if (this.f5952h.m11412j() != null && d.m11450a(ConnectionFlag.CONNECTED)) {
            boolean a = C1130o.m5714a(this.f5952h.m11407e());
            if ((a || this.f5950f.m10060j() != DutyStatus.DRIVING) && !C2188n.m10840a(this.f5948d.m6187a())) {
                ActiveDrivingMode activeDrivingMode = a ? ActiveDrivingMode.ELD_YARD_MOVE_MODE : ActiveDrivingMode.AOBRD_YARD_MOVE_MODE;
                if (activeDrivingMode == ActiveDrivingMode.AOBRD_YARD_MOVE_MODE) {
                    m8406a(this.f5951g.mo914b());
                    if (m8412d() <= 0) {
                        ErrorDialogFragment.m8860a(ourActivity, (int) R.string.dutyStatusDialog_yardMoveWaitingTitle, (int) R.string.dutyStatusDialog_yardMoveWaitingMessage);
                        return;
                    }
                }
                this.f5948d.m6192a(activeDrivingMode, reason, reason2, null);
            }
        }
    }

    public void m8422a(Reason reason, DutyStatusChangeBits.Reason reason2) {
        C2134e.m10676b("TT-YardMoveManager", "Ending yard move: USER_SELECTED");
        this.f5948d.m6189a(reason, reason2);
    }

    private void m8410c() {
        C2134e.m10676b("TT-YardMoveManager", "Ending yard move: YARD_MOVE_DISTANCE_EXCEEDED");
        this.f5948d.m6188a(Reason.YARD_MOVE_DISTANCE_EXCEEDED);
    }

    private long m8402a(OdometerUnit odometerUnit) {
        switch (odometerUnit) {
            case KM:
                return f5945a;
            case MILES:
                return f5946b;
            default:
                return 0;
        }
    }

    private long m8412d() {
        Truck e = this.f5952h.m11407e();
        if (e == null) {
            return 0;
        }
        return Math.max(0, m8402a(af.m4151a(e)) - (this.f5955k.m11248b() + this.f5954j.m11248b()));
    }

    private void m8414e() {
        m8419h();
        C1722b c1722b = C1722b.f5940a;
        Truck e = this.f5952h.m11407e();
        EobrDevice j = this.f5952h.m11412j();
        if (this.f5948d.m6187a() == ActiveDrivingMode.AOBRD_YARD_MOVE_MODE && this.f5952h.m11411i() && e != null && j != null) {
            if (!this.f5957m.m8398a() || this.f5957m.m8400c() > 0) {
                OdometerUnit a = af.m4151a(e);
                boolean z = this.f5958n != null && this.f5958n.m11617p();
                c1722b = new C1722b(z, m8412d(), a);
            } else {
                c1722b = this.f5957m;
            }
        }
        C1722b c1722b2 = this.f5957m;
        this.f5957m = c1722b;
        if (c1722b.m8398a()) {
            m8417f();
        }
        if (!c1722b.equals(c1722b2)) {
            m8409b();
            if (c1722b.m8398a() && c1722b2.m8400c() > 0 && c1722b.m8400c() <= 0) {
                m8410c();
            }
        }
    }

    private void m8417f() {
        YardMoveDialogFragment.m8909a();
    }

    private boolean m8418g() {
        EobrDevice j = this.f5952h.m11412j();
        if (j == null || !this.f5952h.m11411i() || !this.f5957m.m8398a()) {
            return false;
        }
        long b = this.f5954j.m11248b();
        this.f5954j.m11247a(j.m9001m());
        if (this.f5954j.m11248b() != b) {
            return true;
        }
        return false;
    }

    private void m8419h() {
        if (this.f5958n == null) {
            this.f5955k.m11246a();
            this.f5954j.m11246a();
            this.f5956l = 0;
        } else if (!C2188n.m10840a(this.f5958n.m11613l())) {
            m8406a(this.f5951g.mo914b());
        } else if (this.f5952h.m11411i()) {
            m8418g();
        }
    }

    private void m8420i() {
        if (!(this.f5959o == null || this.f5958n == null)) {
            if (C2188n.m10840a(this.f5958n.m11613l())) {
                if (this.f5958n.m11617p()) {
                    this.f5956l = this.f5959o.longValue();
                }
                if (!this.f5952h.m11411i()) {
                    this.f5955k.m11247a(this.f5958n.m11609h());
                }
            } else {
                m8406a(this.f5959o.longValue());
            }
        }
        if (this.f5952h.m11411i()) {
            m8414e();
        }
    }

    private void m8406a(long j) {
        if (j - this.f5956l >= 300000) {
            this.f5955k.m11246a();
            this.f5954j.m11246a();
        }
    }
}
