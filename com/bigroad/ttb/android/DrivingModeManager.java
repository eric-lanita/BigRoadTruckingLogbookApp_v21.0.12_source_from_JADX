package com.bigroad.ttb.android;

import android.app.Activity;
import com.bigroad.shared.C1130o;
import com.bigroad.shared.DrivingModeChangeBits;
import com.bigroad.shared.DrivingModeChangeBits.Reason;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.EldDrivingModeBits;
import com.bigroad.shared.EldDrivingModeBits.Mode;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.ag;
import com.bigroad.shared.ag.C0837a;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.ttb.android.TruckManager.C1203b;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.event.EventSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2287h;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.C2363e;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.DrivingModeChange;
import com.bigroad.ttb.protocol.TTProtocol.DrivingModeChange.C2628a;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntry;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntryType;
import com.bigroad.ttb.protocol.TTProtocol.FleetMembership;
import com.bigroad.ttb.protocol.TTProtocol.LegacyYardMoveStatus;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.common.base.Objects;
import com.google.common.collect.C3540t;
import com.google.common.collect.C3589f;
import com.google.protobuf.C3642c;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

public class DrivingModeManager {
    private static DrivingModeManager f4086a;
    private final C2081g f4087b;
    private final EventManager f4088c;
    private final C2474y f4089d;
    private final ap f4090e;
    private final TruckManager f4091f;
    private final VehicleConnectionManager f4092g;
    private final ag<C1209a> f4093h = new ag();
    private final C1208a f4094i = new C1208a();
    private C3642c f4095j;
    private Long f4096k;
    private boolean f4097l;
    private boolean f4098m = true;
    private ActiveDrivingMode f4099n;
    private DutyStatus f4100o;
    private final ChangeListener f4101p = new C12001(this);
    private final VehicleConnectionManager.ChangeListener f4102q = new C12022(this);
    private final TruckManager.ChangeListener f4103r = new C12043(this);

    class C12001 extends C1199e {
        final /* synthetic */ DrivingModeManager f4065a;

        C12001(DrivingModeManager drivingModeManager) {
            this.f4065a = drivingModeManager;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            DutyStatus j = this.f4065a.f4088c.m10060j();
            if (this.f4065a.f4100o != j) {
                this.f4065a.f4100o = j;
                this.f4065a.m6184g();
                this.f4065a.m6178c(Reason.EVENT_LIST_CHANGED);
            }
        }
    }

    class C12022 extends C1201a {
        final /* synthetic */ DrivingModeManager f4066a;

        C12022(DrivingModeManager drivingModeManager) {
            this.f4066a = drivingModeManager;
        }

        public void mo888a(C2338a c2338a) {
            this.f4066a.m6183f();
        }

        public void mo890a(C2369i c2369i) {
            this.f4066a.m6183f();
        }

        public void mo886a(long j) {
            this.f4066a.m6183f();
        }

        public void mo891a(MotionType motionType) {
            if (motionType == MotionType.MOVING) {
                this.f4066a.f4099n = null;
            }
        }
    }

    class C12043 extends C1203b {
        final /* synthetic */ DrivingModeManager f4067a;

        C12043(DrivingModeManager drivingModeManager) {
            this.f4067a = drivingModeManager;
        }

        public void mo894a(Truck truck) {
            if ((truck == null || truck.getTruckLogType() != 3) && this.f4067a.m6187a() == ActiveDrivingMode.ELD_YARD_MOVE_MODE) {
                this.f4067a.m6188a(Reason.ACTIVE_TRUCK_CHANGED);
            }
        }
    }

    class C12054 implements C0837a<C1209a> {
        final /* synthetic */ DrivingModeManager f4068a;

        C12054(DrivingModeManager drivingModeManager) {
            this.f4068a = drivingModeManager;
        }

        public void m6148a(C1209a c1209a) {
            c1209a.mo981a();
        }
    }

    private static class DrivingModeSnapshot implements Comparable<DrivingModeSnapshot> {
        private static final DrivingModeSnapshot f4081a = new DrivingModeSnapshot(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, Source.UNKNOWN, 0, null);
        private final long f4082b;
        private final ActiveDrivingMode f4083c;
        private final Source f4084d;
        private final String f4085e;

        public enum Source {
            UNKNOWN,
            PREFERENCES,
            USER,
            EOBR_SUBMITTED,
            EOBR_CONFIRMED,
            VEHICLE_STATE
        }

        private static class C1208a {
            private final SortedSet<DrivingModeSnapshot> f4079a;
            private final Map<Source, DrivingModeSnapshot> f4080b;

            private C1208a() {
                this.f4079a = new TreeSet();
                this.f4080b = new HashMap();
            }

            public DrivingModeSnapshot m6154a(ActiveDrivingMode activeDrivingMode, Source source, long j, String str) {
                DrivingModeSnapshot drivingModeSnapshot = new DrivingModeSnapshot(activeDrivingMode, source, j, str);
                DrivingModeSnapshot b = m6157b(source);
                if (b == null) {
                    this.f4080b.put(drivingModeSnapshot.m6162c(), drivingModeSnapshot);
                } else if (drivingModeSnapshot.m6160a() >= b.m6160a()) {
                    if (!C1208a.m6152c(drivingModeSnapshot.m6162c())) {
                        this.f4079a.remove(b);
                    }
                    this.f4080b.put(drivingModeSnapshot.m6162c(), drivingModeSnapshot);
                }
                this.f4079a.add(drivingModeSnapshot);
                return drivingModeSnapshot;
            }

            public void m6156a(DrivingModeSnapshot drivingModeSnapshot) {
                if (drivingModeSnapshot != null) {
                    this.f4079a.remove(drivingModeSnapshot);
                    DrivingModeSnapshot b = m6157b(drivingModeSnapshot.m6162c());
                    if (b != null && b.equals(drivingModeSnapshot)) {
                        this.f4080b.remove(drivingModeSnapshot.m6162c());
                        if (C1208a.m6152c(drivingModeSnapshot.m6162c())) {
                            for (DrivingModeSnapshot b2 : this.f4079a) {
                                if (b2.m6162c() == drivingModeSnapshot.m6162c()) {
                                    this.f4080b.put(drivingModeSnapshot.m6162c(), b2);
                                }
                            }
                        }
                    }
                }
            }

            public DrivingModeSnapshot m6153a() {
                return this.f4079a.isEmpty() ? DrivingModeSnapshot.f4081a : (DrivingModeSnapshot) this.f4079a.last();
            }

            public ActiveDrivingMode m6155a(Source source) {
                DrivingModeSnapshot b = m6157b(source);
                return b == null ? null : b.m6161b();
            }

            public DrivingModeSnapshot m6157b(Source source) {
                return (DrivingModeSnapshot) this.f4080b.get(source);
            }

            private static boolean m6152c(Source source) {
                return source == Source.EOBR_SUBMITTED;
            }
        }

        public /* synthetic */ int compareTo(Object obj) {
            return m6159a((DrivingModeSnapshot) obj);
        }

        private DrivingModeSnapshot(ActiveDrivingMode activeDrivingMode, Source source, long j, String str) {
            this.f4083c = activeDrivingMode;
            this.f4084d = source;
            this.f4082b = j;
            this.f4085e = str;
        }

        public long m6160a() {
            return this.f4082b;
        }

        public ActiveDrivingMode m6161b() {
            return this.f4083c;
        }

        public Source m6162c() {
            return this.f4084d;
        }

        public String m6163d() {
            return this.f4085e;
        }

        public boolean m6164e() {
            return this.f4084d == Source.VEHICLE_STATE || this.f4084d == Source.EOBR_SUBMITTED || this.f4084d == Source.EOBR_CONFIRMED;
        }

        public int m6159a(DrivingModeSnapshot drivingModeSnapshot) {
            return C3589f.m18773a().mo2736a(this.f4082b, drivingModeSnapshot.f4082b).mo2737a(this.f4084d, drivingModeSnapshot.f4084d).mo2737a(this.f4083c, drivingModeSnapshot.f4083c).mo2738a(this.f4085e, drivingModeSnapshot.f4085e, C3540t.m18450c().mo2709b()).mo2740b();
        }

        public boolean equals(Object obj) {
            if (obj != null && getClass() == obj.getClass() && m6159a((DrivingModeSnapshot) obj) == 0) {
                return true;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hashCode(Long.valueOf(this.f4082b), this.f4083c, this.f4084d);
        }
    }

    public interface C1209a {
        void mo981a();
    }

    public static DrivingModeManager m6167a(C2032f c2032f) {
        if (f4086a == null) {
            f4086a = new DrivingModeManager(c2032f);
        }
        return f4086a;
    }

    private DrivingModeManager(C2032f c2032f) {
        this.f4087b = c2032f.mo1294b();
        this.f4088c = c2032f.mo1301i();
        this.f4089d = c2032f.mo1295c();
        this.f4090e = c2032f.mo1314v();
        this.f4091f = c2032f.mo1300h();
        this.f4092g = c2032f.mo1311s();
        this.f4100o = this.f4088c.m10060j();
        ActiveDrivingMode X = this.f4089d.m12179X();
        if (!(X == null || X == ActiveDrivingMode.UNKNOWN_NO_OP_DRIVING_MODE)) {
            this.f4094i.m6154a(X, Source.PREFERENCES, this.f4090e.mo915c(), null);
        }
        m6178c(Reason.MANAGER_INIT);
        this.f4088c.m10012a(this.f4101p);
        this.f4091f.m6559a(this.f4103r);
        this.f4092g.m11399a(this.f4102q);
    }

    public void m6190a(C1209a c1209a) {
        this.f4093h.m4159a(c1209a, 0);
    }

    public void m6195b(C1209a c1209a) {
        this.f4093h.m4158a((Object) c1209a);
    }

    private void m6176b(Reason reason) {
        C2134e.m10676b("TT-DrivingModeManager", "Active driving mode changed to " + m6187a() + ", reason: " + reason);
        this.f4088c.m10050e(C2022a.m10079a(OurApplication.ac(), m6187a(), reason, this.f4092g.m11412j()));
        this.f4089d.m12185a(m6187a());
        this.f4093h.m4157a(new C12054(this));
        if (this.f4092g.m11411i()) {
            boolean a = DrivingModeChangeBits.m4032a(reason);
            DrivingModeSnapshot e = m6182e();
            if (e.m6164e() && e.m6161b() == ActiveDrivingMode.UNKNOWN_NO_OP_DRIVING_MODE) {
                C2134e.m10680d("TT-DrivingModeManager", "current-connected vehicle state had the NO_OP driving mode - correcting to UNSPECIFIED");
                m6172a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, a, null);
            } else if (!a) {
                C2369i e2 = this.f4092g.m11410h().m11542e();
                if (e2 == null || e2.m11614m()) {
                    m6173a(m6182e().m6163d());
                } else {
                    m6185h();
                }
            }
        }
    }

    private DrivingModeSnapshot m6182e() {
        return this.f4094i.m6153a();
    }

    public ActiveDrivingMode m6187a() {
        return m6182e().m6161b();
    }

    public void m6189a(Reason reason, DutyStatusChangeBits.Reason reason2) {
        DutyStatus j = this.f4088c.m10060j();
        if (j == DutyStatus.OFF_DUTY_DRIVING) {
            C2287h.m11213a(DutyStatus.OFF_DUTY, reason2, EventSource.USER);
        } else if (j == DutyStatus.ELD_YARD_MOVE) {
            C2287h.m11213a(DutyStatus.ON_DUTY_NOT_DRIVING, reason2, EventSource.USER);
        }
        m6188a(reason);
    }

    public void m6188a(Reason reason) {
        m6193a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, reason, null);
    }

    private void m6173a(String str) {
        DrivingModeSnapshot a = this.f4094i.m6153a();
        if (!a.m6164e()) {
            m6172a(a.m6161b(), false, str);
        }
    }

    private void m6172a(ActiveDrivingMode activeDrivingMode, boolean z, String str) {
        final EobrDevice j = this.f4092g.m11412j();
        if (j != null && this.f4092g.m11411i()) {
            if (z) {
                C2134e.m10678c("TT-DrivingModeManager", "Ignoring driving mode EOBR write request due to user sign out.");
                return;
            }
            final DrivingModeSnapshot a = this.f4094i.m6154a(activeDrivingMode, Source.EOBR_SUBMITTED, this.f4090e.mo915c(), str);
            j.m8990b(m6170a(a).toByteArray(), new C1206c(this) {
                final /* synthetic */ DrivingModeManager f4071c;

                public void mo897a(C0972e c0972e, C0973f c0973f) {
                    if (c0973f == null || !c0973f.mo744f()) {
                        C2134e.m10680d("TT-DrivingModeManager", "Driving mode " + a.m6161b() + " was not successfully written to " + j.mo1118f());
                        ActiveDrivingMode a = this.f4071c.m6187a();
                        this.f4071c.f4094i.m6156a(a);
                        if (this.f4071c.m6187a() != a) {
                            this.f4071c.m6176b(Reason.EOBR_WRITE_FAILED);
                            return;
                        }
                        return;
                    }
                    this.f4071c.f4094i.m6156a(a);
                    this.f4071c.f4094i.m6154a(a.m6161b(), Source.EOBR_CONFIRMED, a.m6160a(), a.m6163d());
                }
            });
        }
    }

    private boolean m6174a(ActiveDrivingMode activeDrivingMode) {
        return this.f4092g.m11411i() && C1130o.m5714a(this.f4092g.m11407e()) && EldDrivingModeBits.m4067b(activeDrivingMode) != Mode.NORMAL_DRIVING;
    }

    public void m6192a(ActiveDrivingMode activeDrivingMode, Reason reason, DutyStatusChangeBits.Reason reason2, String str) {
        m6194a(activeDrivingMode, reason, str, reason2);
    }

    public void m6193a(ActiveDrivingMode activeDrivingMode, Reason reason, String str) {
        m6194a(activeDrivingMode, reason, str, null);
    }

    public void m6194a(ActiveDrivingMode activeDrivingMode, Reason reason, String str, DutyStatusChangeBits.Reason reason2) {
        if (!m6174a(activeDrivingMode) || C1130o.m5715a(str)) {
            this.f4099n = null;
            if (reason2 != null) {
                DutyStatus j = this.f4088c.m10060j();
                DutyStatus dutyStatus = activeDrivingMode == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE ? DutyStatus.OFF_DUTY : activeDrivingMode == ActiveDrivingMode.ELD_YARD_MOVE_MODE ? DutyStatus.ON_DUTY_NOT_DRIVING : j;
                if (dutyStatus != j) {
                    C2287h.m11213a(dutyStatus, reason2, EventSource.USER);
                }
            }
            ActiveDrivingMode a = m6187a();
            if (this.f4092g.m11411i() && !(activeDrivingMode == m6187a() && m6182e().m6164e())) {
                m6172a(activeDrivingMode, DrivingModeChangeBits.m4032a(reason), str);
            }
            this.f4094i.m6154a(activeDrivingMode, Source.USER, this.f4090e.mo915c(), str);
            if (m6187a() != a) {
                m6176b(reason);
            }
        } else if (this.f4099n == null) {
            Activity c = this.f4087b.m10451c();
            int a2 = DailyLogUtils.m4285a(OurApplication.m6285g().m12228r().m4868b());
            if (c != null) {
                C1632a.m7927a(c, a2, activeDrivingMode);
                this.f4099n = activeDrivingMode;
            }
        }
    }

    public boolean m6196b() {
        return m6187a() == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE;
    }

    public boolean m6197c() {
        if (m6196b()) {
            return true;
        }
        FleetMembership u = this.f4089d.m12231u();
        if (u == null || !u.hasOffDutyDrivingConfig()) {
            return false;
        }
        return u.getOffDutyDrivingConfig().getAllowOffDutyDriving();
    }

    private void m6178c(Reason reason) {
        ActiveDrivingMode a = m6187a();
        ActiveDrivingMode a2 = C2188n.m10839a(this.f4088c.m10060j(), a);
        if (a2 != a) {
            m6193a(a2, reason, null);
        }
    }

    private void m6183f() {
        ActiveDrivingMode a = m6187a();
        C2363e h = this.f4092g.m11410h();
        C2369i e = h == null ? null : h.m11542e();
        if (!this.f4092g.m11411i() || e == null) {
            this.f4096k = null;
            this.f4097l = false;
            this.f4098m = true;
        } else {
            if (e.m11615n() == EngineUseState.ENGINE_OFF) {
                this.f4096k = null;
                this.f4097l = false;
            }
            if (e.m11614m()) {
                this.f4096k = null;
                this.f4097l = false;
                ActiveDrivingMode l = e.m11613l();
                if (l == this.f4099n) {
                    this.f4099n = null;
                }
                if (this.f4094i.m6155a(Source.VEHICLE_STATE) != l || this.f4098m) {
                    this.f4098m = false;
                    this.f4094i.m6154a(l, Source.VEHICLE_STATE, this.f4090e.mo915c(), null);
                }
            } else {
                this.f4098m = true;
            }
            m6185h();
        }
        if (a != m6187a()) {
            m6176b(Reason.VEHICLE_STATE_CHANGED);
        }
    }

    private static ExternalVarEntry m6170a(DrivingModeSnapshot drivingModeSnapshot) {
        C2628a a = DrivingModeChange.newBuilder().m13598a(drivingModeSnapshot.m6161b()).m13600a(C2188n.m10840a(drivingModeSnapshot.m6161b()) ? LegacyYardMoveStatus.LEGACY_DRIVER_REQUESTED_YARD_MOVE_START : LegacyYardMoveStatus.LEGACY_DRIVER_REQUESTED_YARD_MOVE_END);
        if (!am.m4188a(drivingModeSnapshot.m6163d())) {
            a.m13602a(drivingModeSnapshot.m6163d());
        }
        return ExternalVarEntry.newBuilder().m13994a(ExternalVarEntryType.DRIVING_MODE_CHANGE).m13991a(a).m14000c();
    }

    private void m6184g() {
        if (!C1130o.m5714a(this.f4092g.m11407e())) {
            Event h = this.f4088c.m10056h();
            if (h != null && h.getEventType() == 5 && EventStatusMaskBits.m4081b(h.getStatusMask()) == RecordOrigin.AUTOMATICALLY_RECORDED && !Objects.equal(this.f4095j, h.getEventId())) {
                this.f4095j = h.getEventId();
                if (m6197c() && this.f4092g.m11411i() && this.f4087b.m10447a() && !m6186i()) {
                    DutyStatus dutyStatus;
                    Event a = this.f4088c.m10004a(h);
                    if (a == null) {
                        dutyStatus = DutyStatus.OFF_DUTY;
                    } else {
                        dutyStatus = DutyStatus.m4384a(a);
                    }
                    if (C2188n.m10841a(dutyStatus.m4392a())) {
                        Activity c = this.f4087b.m10451c();
                        if (c != null) {
                            C1632a.m7942a(c, h.getEventId().m19091d());
                        }
                    }
                }
            }
        }
    }

    public void m6191a(ActiveDrivingMode activeDrivingMode, Reason reason) {
        if (this.f4092g.m11411i()) {
            C2369i e = this.f4092g.m11410h().m11542e();
            if (e != null && e.m11614m()) {
                return;
            }
        }
        if (activeDrivingMode == null) {
            activeDrivingMode = C2188n.m10839a(this.f4088c.m10060j(), ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE);
        }
        boolean a = m6174a(activeDrivingMode);
        if (a) {
            DrivingModeSnapshot b = this.f4094i.m6157b(Source.VEHICLE_STATE);
            if (b != null) {
                a = b.m6161b() != activeDrivingMode;
            }
        }
        if (activeDrivingMode != m6187a() || r0) {
            m6193a(activeDrivingMode, reason, null);
        } else {
            m6172a(activeDrivingMode, DrivingModeChangeBits.m4032a(reason), null);
        }
    }

    private void m6185h() {
        if (this.f4092g.m11411i() && !this.f4092g.m11413k()) {
            boolean a = C1130o.m5714a(this.f4092g.m11407e());
            C2369i e = this.f4092g.m11410h().m11542e();
            if (e != null && !e.m11614m() && e.m11615n() == EngineUseState.ENGINE_ON) {
                DrivingModeSnapshot e2 = m6182e();
                if (e2.m6162c() == Source.EOBR_SUBMITTED) {
                    return;
                }
                if (!e2.m6164e() || this.f4096k == null || e2.m6160a() < this.f4096k.longValue()) {
                    e2 = this.f4094i.m6157b(Source.USER);
                    DrivingModeSnapshot b = this.f4094i.m6157b(Source.VEHICLE_STATE);
                    if (e2 == null || e2.m6161b() != m6187a() || (b != null && e2.m6160a() <= b.m6160a())) {
                        if (m6187a() == ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE && !a) {
                            m6191a(ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE, Reason.AOBRD_PERSIST_PERSONAL_USE);
                        } else if (m6187a() == ActiveDrivingMode.AOBRD_YARD_MOVE_MODE && !a) {
                            m6191a(ActiveDrivingMode.AOBRD_YARD_MOVE_MODE, Reason.MODAL_YARD_MOVE_MAINTAINED);
                        } else if (m6187a() != ActiveDrivingMode.ELD_YARD_MOVE_MODE && m6187a() != ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE) {
                            m6191a(null, Reason.EOBR_CONFIRM_NON_SPECIAL);
                        } else if (this.f4096k == null || m6198d() > 0) {
                            if (this.f4096k == null) {
                                this.f4096k = Long.valueOf(this.f4090e.mo915c());
                            }
                            if (this.f4099n == null) {
                                Activity c = this.f4087b.m10451c();
                                if (c != null && !this.f4097l) {
                                    this.f4097l = true;
                                    C1632a.m7933a(c, m6187a(), 60);
                                }
                            }
                        } else {
                            m6191a(null, Reason.EOBR_AUTO_DIALOG);
                        }
                    } else if (!m6174a(m6187a()) || C1130o.m5715a(e2.m6163d())) {
                        m6173a(e2.m6163d());
                    } else {
                        m6193a(m6187a(), Reason.EOBR_SELECTED_DIALOG, null);
                    }
                }
            }
        }
    }

    private boolean m6186i() {
        return this.f4097l && m6198d() > 0;
    }

    public long m6198d() {
        if (this.f4096k == null) {
            return 0;
        }
        return 60000 - (this.f4090e.mo915c() - this.f4096k.longValue());
    }
}
