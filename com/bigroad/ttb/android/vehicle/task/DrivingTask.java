package com.bigroad.ttb.android.vehicle.task;

import android.app.Activity;
import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.ai;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2104l;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.aobrd.DutyStatusConflict;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C1199e;
import com.bigroad.ttb.android.event.EventManager.C2018a;
import com.bigroad.ttb.android.event.EventManager.ChangeListener;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.C2371k;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.ContinueDrivingPromptResponse;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VarDutyStatusChange;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification;
import com.google.common.base.Objects;
import com.google.protobuf.C2487l;
import java.util.Arrays;
import java.util.EnumSet;

public class DrivingTask implements C2379j {
    public static EnumSet<EventType> f8223a = EnumSet.of(EventType.DRIVING, EventType.OFF_DUTY_DRIVING, EventType.AOBRD_YARD_MOVE, EventType.ELD_YARD_MOVE);
    private static final long f8224f = DutyStatusChangeBits.m4033a(Reason.EOBR_AUTO);
    private static final long f8225g = DutyStatusChangeBits.m4033a(Reason.EOBR_DUTY_STATUS_SELECTED);
    private static final long f8226h = DutyStatusChangeBits.m4033a(Reason.EOBR_AUTO_STOP_TIMEOUT);
    private static final long f8227i = DutyStatusChangeBits.m4033a(Reason.EOBR_AUTO_ENGINE_OFF);
    private static final long f8228j = DutyStatusChangeBits.m4033a(Reason.EOBR_DRIVING_SPLIT);
    protected final ChangeListener f8229b;
    protected C2376c f8230c;
    protected long f8231d;
    protected C2369i f8232e;
    private final C2032f f8233k;
    private final C2374a f8234l;
    private final C2474y f8235m;
    private C2369i f8236n;
    private boolean f8237o;
    private C2377d f8238p;
    private final long f8239q;
    private long f8240r;
    private int f8241s;

    class C23721 extends C1199e {
        final /* synthetic */ DrivingTask f8204a;

        C23721(DrivingTask drivingTask) {
            this.f8204a = drivingTask;
        }

        public void mo884a(EventManager eventManager, boolean z) {
            this.f8204a.f8237o = true;
        }
    }

    private enum SegmentStopReason {
        MANUAL,
        AUTO,
        SPLIT
    }

    public interface C2374a {
        void mo1287a(Event event, long j, int i);
    }

    private static class C2375b implements C2374a {
        private final C2032f f8211a;
        private Event f8212b = null;
        private long f8213c = -1;

        public C2375b(C2032f c2032f) {
            this.f8211a = c2032f;
        }

        public void mo1287a(Event event, long j, int i) {
            if (!this.f8211a.mo1311s().m11411i()) {
                return;
            }
            if (this.f8212b == null || !event.getEventId().equals(this.f8212b.getEventId()) || j != this.f8213c) {
                C2081g b = this.f8211a.mo1294b();
                if (b.m10447a()) {
                    Activity c = b.m10451c();
                    if (c != null) {
                        this.f8212b = event;
                        this.f8213c = j;
                        C1632a.m7943a(c, this.f8212b.getEventId().m19091d(), i);
                    }
                }
            }
        }
    }

    protected static class C2376c {
        private ActiveDrivingMode f8214a;
        private Event f8215b;
        private C2358c f8216c;
        private OdometerOffsets f8217d;

        public C2376c(ActiveDrivingMode activeDrivingMode, Event event, C2358c c2358c, OdometerOffsets odometerOffsets) {
            this.f8214a = activeDrivingMode;
            this.f8215b = event;
            this.f8216c = c2358c;
            this.f8217d = odometerOffsets;
        }

        public ActiveDrivingMode m11638a() {
            return this.f8214a;
        }

        public Event m11640b() {
            return this.f8215b;
        }

        public void m11639a(Event event) {
            this.f8215b = event;
        }

        public C2358c m11641c() {
            return this.f8216c;
        }

        public OdometerOffsets m11642d() {
            return this.f8217d;
        }

        public long m11643e() {
            return this.f8215b.getPersonId();
        }

        public Long m11644f() {
            return this.f8215b.hasTruckId() ? Long.valueOf(this.f8215b.getTruckId()) : null;
        }
    }

    private static class C2377d {
        private RelativeTimestamp f8218a;
        private C1015l f8219b;
        private boolean f8220c;

        public C2377d(RelativeTimestamp relativeTimestamp, C1015l c1015l, boolean z) {
            this.f8218a = relativeTimestamp;
            this.f8219b = c1015l;
            this.f8220c = z;
            if (this.f8220c) {
                this.f8218a = RelativeTimestamp.newBuilder(this.f8218a).m14805b(this.f8218a.getAbsoluteTimeMillis() + 1).m14807c();
            }
        }

        public RelativeTimestamp m11645a() {
            return this.f8218a;
        }

        public C1015l m11646b() {
            return this.f8219b;
        }

        public boolean m11647c() {
            return this.f8220c;
        }
    }

    private static class C2378e implements C2018a {
        private final EventManager f8221a;
        private final Event f8222b;

        public C2378e(Event event, EventManager eventManager) {
            this.f8221a = eventManager;
            this.f8222b = event;
        }

        public void mo1288a(Event event) {
            if (this.f8222b.hasOdometer()) {
                this.f8221a.m10015a(this.f8222b.getEventId(), event);
            }
        }
    }

    private static long m11653a(Truck truck) {
        if (m11667b(truck)) {
            return 360000;
        }
        return 300000;
    }

    private static boolean m11665a(Truck truck, long j) {
        if (!m11667b(truck)) {
            return false;
        }
        long j2 = j - 300000;
        if (j2 < 0 || j2 >= 60000) {
            return false;
        }
        return true;
    }

    private static boolean m11667b(Truck truck) {
        if (truck != null && truck.hasTruckLogType() && truck.getTruckLogType() == 3) {
            return true;
        }
        return false;
    }

    public static long m11652a(C2104l c2104l) {
        if (c2104l.m10550e()) {
            return 15000;
        }
        return 900000;
    }

    public static void m11659a(C2032f c2032f, Event event, C2369i c2369i) {
        DutyStatus a = m11654a(event);
        if (a != null) {
            Event a2;
            if (c2369i != null) {
                a2 = C2022a.m10087a(a.m4392a(), null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(event.getPersonId()), (event.getOccurredAt() + event.getMinDuration()) + 1, null, c2369i, Long.valueOf(DutyStatusChangeBits.m4033a(Reason.EOBR_DISCONNECTED)), c2032f);
            } else {
                a2 = C2022a.m10096b(a.m4392a(), (event.getOccurredAt() + event.getMinDuration()) + 1, event.getPersonId(), Long.valueOf(event.getTruckId()), null, DutyStatusChangeBits.m4033a(Reason.EOBR_DISCONNECTED), c2032f);
            }
            c2032f.mo1301i().m10050e(a2);
        }
    }

    public DrivingTask(C2032f c2032f, long j) {
        this(c2032f, new C2375b(c2032f), j);
    }

    public DrivingTask(C2032f c2032f, C2374a c2374a, long j) {
        this.f8229b = new C23721(this);
        this.f8236n = null;
        this.f8237o = false;
        this.f8238p = null;
        this.f8230c = null;
        this.f8231d = -1;
        this.f8232e = null;
        this.f8240r = -1;
        this.f8241s = 0;
        this.f8233k = c2032f;
        this.f8234l = c2374a;
        this.f8235m = c2032f.mo1295c();
        this.f8239q = j;
        if (this.f8233k.mo1301i() != null) {
            this.f8233k.mo1301i().m10012a(this.f8229b);
        }
    }

    private void m11666b() {
        this.f8238p = null;
        this.f8230c = null;
        this.f8231d = -1;
        this.f8232e = null;
        this.f8240r = -1;
        this.f8241s = 0;
    }

    private boolean m11661a(long j, ProcessingState processingState, long j2, C2370j c2370j, boolean z) {
        if (j2 != this.f8235m.m12202d() || !processingState.m11310a()) {
            return false;
        }
        int a = DailyLogUtils.m4283a(j);
        if (z && this.f8233k.mo1312t().m6103c()) {
            int d = this.f8233k.mo1302j().m8487d();
            for (int i = a; i <= d; i++) {
                DailyLog b = this.f8233k.mo1302j().m8480b(i);
                if (C2292l.m11231a(b)) {
                    C2292l.m11227a(b, false, this.f8233k);
                }
            }
        }
        if (DutyStatusConflict.m8428a(a, this.f8233k).isEmpty()) {
            return false;
        }
        if (!c2370j.m11630a(C2382c.class)) {
            c2370j.m11629a(new C2382c(this.f8233k));
        }
        return true;
    }

    private boolean m11664a(Event event, Event event2) {
        if (event != null && event2 != null && event.getOccurredAt() == event2.getOccurredAt() && f8223a.contains(EventType.m13979a(event2.getEventType())) && event.getTruckId() == event2.getTruckId() && event.getPersonId() == event2.getPersonId() && event.getImmutableDutySegment() == event2.getImmutableDutySegment()) {
            return true;
        }
        return false;
    }

    public void mo1289a() {
        this.f8233k.mo1301i().m10067q().m9966a();
        this.f8233k.mo1301i().m10029b(this.f8229b);
    }

    private static EventType m11657a(ActiveDrivingMode activeDrivingMode) {
        switch (activeDrivingMode) {
            case UNKNOWN_NO_OP_DRIVING_MODE:
                C2134e.m10682e("TT-DrivingTask", "DrivingTask should not try to create an event in the NO_OP driving mode");
                return null;
            case UNSPECIFIED_DRIVING_MODE:
                return EventType.DRIVING;
            case NORMAL_DRIVING_MODE:
                return EventType.DRIVING;
            case PERSONAL_CONVEYANCE_MODE:
                return EventType.OFF_DUTY_DRIVING;
            case AOBRD_YARD_MOVE_MODE:
                return EventType.AOBRD_YARD_MOVE;
            case ELD_YARD_MOVE_MODE:
                return EventType.ELD_YARD_MOVE;
            default:
                return null;
        }
    }

    private Event m11656a(RelativeTimestamp relativeTimestamp, long j, C2369i c2369i, C1015l c1015l, RelativeTimestamp relativeTimestamp2, C2370j c2370j, long j2) {
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return null;
        }
        EventType a = m11657a(c2369i.m11613l());
        if (a == null) {
            return null;
        }
        if (a == EventType.OFF_DUTY_DRIVING) {
            j2 = DutyStatusChangeBits.m4038b(Long.valueOf(j2));
        }
        return C2022a.m10086a(a, null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(j), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp2, null, Long.valueOf(j2), c2370j.m11626a(), this.f8233k);
    }

    Event m11669a(long j, C2369i c2369i, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2370j c2370j, boolean z) {
        if (this.f8230c == null) {
            return null;
        }
        Event a = C2022a.m10086a(EventType.INTERMEDIATE_DRIVING, null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(j), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp, null, null, c2370j.m11626a(), this.f8233k);
        if (a == null || z) {
            return a;
        }
        return Event.newBuilder(a).m13832I().m13862c();
    }

    private Event m11655a(C2376c c2376c, long j, C2369i c2369i, long j2, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2370j c2370j) {
        Event b = c2376c.m11640b();
        DutyStatus a = m11654a(b);
        if (a == null) {
            return null;
        }
        return C2022a.m10086a(a.m4392a(), null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(b.getPersonId()), j, null, c2369i, c1015l, relativeTimestamp, null, Long.valueOf(j2), c2370j.m11626a(), this.f8233k);
    }

    public void m11672a(long j, C2369i c2369i, C2358c c2358c, C2370j c2370j, ProcessingState processingState) {
        if (this.f8230c != null && c2358c.m11504b() != null && !this.f8233k.mo1299g().m11017c(c2358c.m11504b().longValue())) {
            long occurredAt = j - this.f8230c.m11640b().getOccurredAt();
            if (occurredAt > 0) {
                long round;
                Integer c = c2369i.m11602c(this.f8233k);
                long distanceMeters = this.f8230c.m11640b().getDistanceMeters();
                if (this.f8230c.m11640b().hasOdometer() && c != null) {
                    int intValue = c.intValue() - this.f8230c.m11640b().getOdometer();
                    if (intValue >= 0) {
                        round = Math.round(CanonicalOdometerUnit.m5467a(C2371k.m11631a(this.f8233k, c2369i)).m5469a((long) intValue));
                        if (!m11661a(j, processingState, c2358c.m11504b().longValue(), c2370j, c2358c.m11510h())) {
                            this.f8233k.mo1301i().m10067q().m9967a(this.f8230c.m11640b(), occurredAt, round, c2358c.m11510h());
                        }
                    }
                    C2134e.m10680d("TT-DrivingTask", "Unexpected negative distance travelled.  " + this.f8230c.m11640b().getOdometer() + " to " + c);
                }
                round = distanceMeters;
                if (!m11661a(j, processingState, c2358c.m11504b().longValue(), c2370j, c2358c.m11510h())) {
                    this.f8233k.mo1301i().m10067q().m9967a(this.f8230c.m11640b(), occurredAt, round, c2358c.m11510h());
                }
            }
        }
    }

    public Event m11670a(long j, RelativeTimestamp relativeTimestamp, VehicleIdentification vehicleIdentification) {
        return this.f8233k.mo1301i().m10003a(j, relativeTimestamp.getAbsoluteTimeMillis(), vehicleIdentification);
    }

    private boolean m11662a(C2369i c2369i, long j) {
        OdometerOffsets a = c2369i.m11594a(this.f8233k);
        if (a == null && c2369i.m11605d() == null && this.f8238p != null && j - this.f8238p.m11645a().getAbsoluteTimeMillis() >= 30000 && this.f8233k.mo1300h().m6578f() != null && this.f8233k.mo1300h().m6578f().hasOdometerOffsets()) {
            a = this.f8233k.mo1300h().m6578f().getOdometerOffsets();
        }
        return (a == null || c2369i.m11595a(a, this.f8233k) == null) ? false : true;
    }

    private void m11658a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, VarDutyStatusChange varDutyStatusChange, ContinueDrivingPromptResponse continueDrivingPromptResponse) {
        if (this.f8238p != null || this.f8230c != null) {
            Event a;
            Event event;
            SegmentStopReason segmentStopReason;
            SegmentStopReason segmentStopReason2;
            Object obj;
            C2358c c;
            int i;
            Object d;
            Truck f;
            int i2;
            int i3;
            ActiveDrivingMode a2;
            int i4;
            SegmentStopReason segmentStopReason3;
            C2487l d2;
            C2487l a3;
            SegmentStopReason segmentStopReason4;
            EventManager i5 = this.f8233k.mo1301i();
            Truck a4 = C2371k.m11631a(this.f8233k, c2369i);
            if (c2369i.m11612k().getMotionType() == MotionType.STOPPED) {
                if (this.f8231d < 0) {
                    this.f8231d = relativeTimestamp.getAbsoluteTimeMillis();
                    this.f8232e = c2369i;
                    m11672a(relativeTimestamp.getAbsoluteTimeMillis(), this.f8232e, c2358c, c2370j, processingState);
                }
                if (this.f8231d >= 0) {
                    long j;
                    long absoluteTimeMillis = relativeTimestamp.getAbsoluteTimeMillis() - this.f8231d;
                    SegmentStopReason segmentStopReason5;
                    if (varDutyStatusChange != null) {
                        segmentStopReason5 = SegmentStopReason.MANUAL;
                        if (this.f8230c != null) {
                            C2134e.m10676b("TT-DrivingTask", "Driving segment " + C1180y.m5989a(this.f8230c.m11640b().getEventId()) + " ended due to duty status change");
                            DutyStatus a5 = DutyStatus.m4383a(varDutyStatusChange.getEventType());
                            String str = null;
                            if (varDutyStatusChange.hasLocationName() && !am.m4188a(varDutyStatusChange.getLocationName())) {
                                str = varDutyStatusChange.getLocationName();
                            }
                            a = C2022a.m10086a(a5.m4392a(), null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(this.f8230c.m11640b().getPersonId()), relativeTimestamp.getAbsoluteTimeMillis(), str, c2369i, c1015l, relativeTimestamp, this.f8230c.m11642d(), Long.valueOf(f8225g), c2370j.m11626a(), this.f8233k);
                            if (!(a == null || !varDutyStatusChange.hasNotes() || am.m4188a(varDutyStatusChange.getNotes()))) {
                                a = Event.newBuilder(a).m13856b(varDutyStatusChange.getNotes()).m13862c();
                            }
                        } else {
                            a = null;
                        }
                        if (a == null || !varDutyStatusChange.getSignOutRequested()) {
                            event = a;
                            segmentStopReason = segmentStopReason5;
                            j = absoluteTimeMillis;
                        } else {
                            this.f8233k.mo1315w().m8040a(a.getEventId().m19091d());
                            event = a;
                            segmentStopReason = segmentStopReason5;
                            j = absoluteTimeMillis;
                        }
                    } else if (continueDrivingPromptResponse == null) {
                        if (absoluteTimeMillis >= m11653a(a4)) {
                            segmentStopReason2 = SegmentStopReason.AUTO;
                            if (this.f8230c != null) {
                                event = m11655a(this.f8230c, this.f8231d + m11653a(a4), this.f8232e, f8226h, c1015l, relativeTimestamp, c2370j);
                                segmentStopReason = segmentStopReason2;
                                j = absoluteTimeMillis;
                            }
                        } else if (c2369i.m11615n() == EngineUseState.ENGINE_OFF) {
                            segmentStopReason2 = SegmentStopReason.AUTO;
                            if (this.f8230c != null) {
                                C2134e.m10676b("TT-DrivingTask", "Driving segment " + C1180y.m5989a(this.f8230c.m11640b().getEventId()) + " ended due to engine off");
                                event = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), this.f8232e, f8227i, c1015l, relativeTimestamp, c2370j);
                                segmentStopReason = segmentStopReason2;
                                j = absoluteTimeMillis;
                            }
                        } else {
                            j = absoluteTimeMillis;
                            event = null;
                            segmentStopReason = null;
                        }
                        j = absoluteTimeMillis;
                        event = null;
                        segmentStopReason = segmentStopReason2;
                    } else if (this.f8230c == null) {
                        C2134e.m10680d("TT-DrivingTask", "Found continue driving prompt response but no driving segment is active, discarding prompt response");
                        j = absoluteTimeMillis;
                        event = null;
                        segmentStopReason = null;
                    } else if (this.f8230c.m11640b().getOccurredAt() != continueDrivingPromptResponse.getDrivingStartedAt()) {
                        C2134e.m10680d("TT-DrivingTask", "Found continue driving prompt response for driving starting at " + continueDrivingPromptResponse.getDrivingStartedAt() + " but current driving segment event started at " + this.f8230c.m11640b().getOccurredAt() + ", discarding prompt response");
                        j = absoluteTimeMillis;
                        event = null;
                        segmentStopReason = null;
                    } else if (continueDrivingPromptResponse.getContinueDriving()) {
                        this.f8231d = relativeTimestamp.getAbsoluteTimeMillis();
                        j = 0;
                        this.f8232e = c2369i;
                        event = null;
                        segmentStopReason = null;
                    } else {
                        segmentStopReason5 = SegmentStopReason.MANUAL;
                        event = C2022a.m10086a(DutyStatus.ON_DUTY_NOT_DRIVING.m4392a(), null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(this.f8230c.m11640b().getPersonId()), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp, this.f8230c.m11642d(), Long.valueOf(f8225g), c2370j.m11626a(), this.f8233k);
                        segmentStopReason = segmentStopReason5;
                        j = absoluteTimeMillis;
                    }
                    obj = (this.f8230c == null || !m11665a(a4, j)) ? null : 1;
                    if (segmentStopReason == null && this.f8230c != null) {
                        if (m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                            c = this.f8230c.m11641c();
                            i = Objects.equal(c == null ? c.m11504b() : null, c2358c == null ? c2358c.m11504b() : null) ? 1 : 0;
                            d = c2369i.m11605d();
                            if (d == null) {
                                C2134e.m10680d("TT-DrivingTask", "VehicleState did not contain a valid truck. Trying to use the active truck.");
                                f = this.f8233k.mo1300h().m6578f();
                                if (f != null) {
                                    d = Long.valueOf(f.getTruckId());
                                }
                            }
                            i2 = Objects.equal(this.f8230c.m11644f(), d) ? 1 : 0;
                            i3 = Arrays.equals(c == null ? c.m11503a() : null, c2358c == null ? c2358c.m11503a() : null) ? 1 : 0;
                            a2 = this.f8230c.m11638a();
                            i4 = (a2 != c2369i.m11613l() || a2 == ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE) ? 0 : 1;
                            if ((((i | i2) | i3) | i4) != 0) {
                                segmentStopReason2 = SegmentStopReason.SPLIT;
                                a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8224f, c1015l, relativeTimestamp, c2370j);
                                segmentStopReason3 = segmentStopReason2;
                                if (this.f8230c != null) {
                                    if (m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                                        d2 = this.f8230c.m11642d();
                                        a3 = c2369i.m11594a(this.f8233k);
                                        if (segmentStopReason3 == null && !ai.m4177a(d2, a3)) {
                                            C2134e.m10676b("TT-DrivingTask", "Driving segment " + C1180y.m5989a(this.f8230c.m11640b().getEventId()) + " split due to odometer offset change.");
                                            segmentStopReason2 = SegmentStopReason.SPLIT;
                                            a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8228j, c1015l, relativeTimestamp, c2370j);
                                            if (a == null) {
                                                C2134e.m10680d("TT-DrivingTask", "Unable to split driving segment. Cannot create stop event.");
                                            }
                                            segmentStopReason3 = segmentStopReason2;
                                        }
                                        if (segmentStopReason3 == null && c2369i.m11613l() == ActiveDrivingMode.UNKNOWN_NO_OP_DRIVING_MODE) {
                                            segmentStopReason2 = SegmentStopReason.MANUAL;
                                            a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8224f, c1015l, relativeTimestamp, c2370j);
                                            if (a == null) {
                                                C2134e.m10680d("TT-DrivingTask", "Unable to end driving segment. Cannot create stop event.");
                                            }
                                            event = a;
                                            segmentStopReason4 = segmentStopReason2;
                                            if (event != null) {
                                                C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                                            }
                                            if (segmentStopReason4 == null) {
                                                if (this.f8230c == null) {
                                                    C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                                                }
                                                m11666b();
                                                if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                                                    m11660a(c2369i, c1015l, relativeTimestamp, true);
                                                }
                                            } else if (obj == null) {
                                                this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                                            }
                                        }
                                    }
                                }
                                event = a;
                                segmentStopReason4 = segmentStopReason3;
                                if (event != null) {
                                    C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                                }
                                if (segmentStopReason4 == null) {
                                    if (this.f8230c == null) {
                                        C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                                    }
                                    m11666b();
                                    if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                                        m11660a(c2369i, c1015l, relativeTimestamp, true);
                                    }
                                } else if (obj == null) {
                                    this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                                }
                            }
                        }
                    }
                    a = event;
                    segmentStopReason3 = segmentStopReason;
                    if (this.f8230c != null) {
                        if (m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                            d2 = this.f8230c.m11642d();
                            a3 = c2369i.m11594a(this.f8233k);
                            C2134e.m10676b("TT-DrivingTask", "Driving segment " + C1180y.m5989a(this.f8230c.m11640b().getEventId()) + " split due to odometer offset change.");
                            segmentStopReason2 = SegmentStopReason.SPLIT;
                            a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8228j, c1015l, relativeTimestamp, c2370j);
                            if (a == null) {
                                C2134e.m10680d("TT-DrivingTask", "Unable to split driving segment. Cannot create stop event.");
                            }
                            segmentStopReason3 = segmentStopReason2;
                            segmentStopReason2 = SegmentStopReason.MANUAL;
                            a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8224f, c1015l, relativeTimestamp, c2370j);
                            if (a == null) {
                                C2134e.m10680d("TT-DrivingTask", "Unable to end driving segment. Cannot create stop event.");
                            }
                            event = a;
                            segmentStopReason4 = segmentStopReason2;
                            if (event != null) {
                                C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                            }
                            if (segmentStopReason4 == null) {
                                if (this.f8230c == null) {
                                    C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                                }
                                m11666b();
                                if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                                    m11660a(c2369i, c1015l, relativeTimestamp, true);
                                }
                            } else if (obj == null) {
                                this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                            }
                        }
                    }
                    event = a;
                    segmentStopReason4 = segmentStopReason3;
                    if (event != null) {
                        C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                    }
                    if (segmentStopReason4 == null) {
                        if (this.f8230c == null) {
                            C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                        }
                        m11666b();
                        if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                            m11660a(c2369i, c1015l, relativeTimestamp, true);
                        }
                    } else if (obj == null) {
                        this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                    }
                }
            }
            obj = null;
            event = null;
            segmentStopReason = null;
            if (m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                c = this.f8230c.m11641c();
                if (c == null) {
                }
                if (c2358c == null) {
                }
                if (Objects.equal(c == null ? c.m11504b() : null, c2358c == null ? c2358c.m11504b() : null)) {
                }
                d = c2369i.m11605d();
                if (d == null) {
                    C2134e.m10680d("TT-DrivingTask", "VehicleState did not contain a valid truck. Trying to use the active truck.");
                    f = this.f8233k.mo1300h().m6578f();
                    if (f != null) {
                        d = Long.valueOf(f.getTruckId());
                    }
                }
                if (Objects.equal(this.f8230c.m11644f(), d)) {
                }
                if (c == null) {
                }
                if (c2358c == null) {
                }
                if (Arrays.equals(c == null ? c.m11503a() : null, c2358c == null ? c2358c.m11503a() : null)) {
                }
                a2 = this.f8230c.m11638a();
                if (a2 != c2369i.m11613l()) {
                }
                if ((((i | i2) | i3) | i4) != 0) {
                    segmentStopReason2 = SegmentStopReason.SPLIT;
                    a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8224f, c1015l, relativeTimestamp, c2370j);
                    segmentStopReason3 = segmentStopReason2;
                    if (this.f8230c != null) {
                        if (m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                            d2 = this.f8230c.m11642d();
                            a3 = c2369i.m11594a(this.f8233k);
                            C2134e.m10676b("TT-DrivingTask", "Driving segment " + C1180y.m5989a(this.f8230c.m11640b().getEventId()) + " split due to odometer offset change.");
                            segmentStopReason2 = SegmentStopReason.SPLIT;
                            a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8228j, c1015l, relativeTimestamp, c2370j);
                            if (a == null) {
                                C2134e.m10680d("TT-DrivingTask", "Unable to split driving segment. Cannot create stop event.");
                            }
                            segmentStopReason3 = segmentStopReason2;
                            segmentStopReason2 = SegmentStopReason.MANUAL;
                            a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8224f, c1015l, relativeTimestamp, c2370j);
                            if (a == null) {
                                C2134e.m10680d("TT-DrivingTask", "Unable to end driving segment. Cannot create stop event.");
                            }
                            event = a;
                            segmentStopReason4 = segmentStopReason2;
                            if (event != null) {
                                C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                            }
                            if (segmentStopReason4 == null) {
                                if (this.f8230c == null) {
                                    C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                                }
                                m11666b();
                                if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                                    m11660a(c2369i, c1015l, relativeTimestamp, true);
                                }
                            } else if (obj == null) {
                                this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                            }
                        }
                    }
                    event = a;
                    segmentStopReason4 = segmentStopReason3;
                    if (event != null) {
                        C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                    }
                    if (segmentStopReason4 == null) {
                        if (this.f8230c == null) {
                            C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                        }
                        m11666b();
                        if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                            m11660a(c2369i, c1015l, relativeTimestamp, true);
                        }
                    } else if (obj == null) {
                        this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                    }
                }
            }
            a = event;
            segmentStopReason3 = segmentStopReason;
            if (this.f8230c != null) {
                if (m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                    d2 = this.f8230c.m11642d();
                    a3 = c2369i.m11594a(this.f8233k);
                    C2134e.m10676b("TT-DrivingTask", "Driving segment " + C1180y.m5989a(this.f8230c.m11640b().getEventId()) + " split due to odometer offset change.");
                    segmentStopReason2 = SegmentStopReason.SPLIT;
                    a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8228j, c1015l, relativeTimestamp, c2370j);
                    if (a == null) {
                        C2134e.m10680d("TT-DrivingTask", "Unable to split driving segment. Cannot create stop event.");
                    }
                    segmentStopReason3 = segmentStopReason2;
                    segmentStopReason2 = SegmentStopReason.MANUAL;
                    a = m11655a(this.f8230c, relativeTimestamp.getAbsoluteTimeMillis(), c2369i, f8224f, c1015l, relativeTimestamp, c2370j);
                    if (a == null) {
                        C2134e.m10680d("TT-DrivingTask", "Unable to end driving segment. Cannot create stop event.");
                    }
                    event = a;
                    segmentStopReason4 = segmentStopReason2;
                    if (event != null) {
                        C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
                    }
                    if (segmentStopReason4 == null) {
                        if (this.f8230c == null) {
                            C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                        }
                        m11666b();
                        if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                            m11660a(c2369i, c1015l, relativeTimestamp, true);
                        }
                    } else if (obj == null) {
                        this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
                    }
                }
            }
            event = a;
            segmentStopReason4 = segmentStopReason3;
            if (event != null) {
                C2392k.m11715a(this.f8233k, relativeTimestamp, event, eobrDevice, processingState, c2369i, c2370j, new C2378e(this.f8230c.m11640b(), i5));
            }
            if (segmentStopReason4 == null) {
                if (this.f8230c == null) {
                    C2134e.m10676b("TT-DrivingTask", "Driving segment was stopped before a start event was created.");
                }
                m11666b();
                if (segmentStopReason4 != SegmentStopReason.SPLIT) {
                    m11660a(c2369i, c1015l, relativeTimestamp, true);
                }
            } else if (obj == null) {
                this.f8234l.mo1287a(this.f8230c.m11640b(), this.f8231d, (int) (((this.f8231d + m11653a(a4)) - relativeTimestamp.getAbsoluteTimeMillis()) / 1000));
            }
        }
    }

    public boolean m11675a(EobrDevice eobrDevice, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2370j c2370j) {
        this.f8231d = -1;
        this.f8232e = null;
        if (c2369i.m11613l() == ActiveDrivingMode.UNKNOWN_NO_OP_DRIVING_MODE) {
            return true;
        }
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return true;
        }
        if (c2369i.m11612k().getMotionType() != MotionType.MOVING) {
            return (this.f8238p == null && this.f8230c == null) ? false : true;
        } else {
            m11660a(c2369i, c1015l, relativeTimestamp, false);
            if (this.f8230c == null) {
                if (!m11662a(c2369i, relativeTimestamp.getAbsoluteTimeMillis())) {
                    return true;
                }
                long unidentifiedDriverId;
                Event a;
                long j;
                long d = c2358c.m11506d();
                if (d == this.f8235m.m12202d()) {
                    if (m11661a(this.f8238p.m11645a().getAbsoluteTimeMillis(), processingState, d, c2370j, c2358c.m11510h())) {
                        unidentifiedDriverId = c2358c.m11505c().getUnidentifiedDriverId();
                        a = m11670a(unidentifiedDriverId, this.f8238p.m11645a(), c2369i.m11600b());
                        if (a != null) {
                            this.f8230c = new C2376c(c2369i.m11613l(), a, c2358c, c2369i.m11594a(this.f8233k));
                            if (unidentifiedDriverId == c2358c.m11505c().getUnidentifiedDriverId() && unidentifiedDriverId != c2358c.m11506d()) {
                                if (!c2370j.m11630a(C2382c.class)) {
                                    c2370j.m11629a(new C2382c(this.f8233k));
                                }
                            }
                        }
                        if (this.f8230c == null && !processingState.m11310a()) {
                            C2134e.m10680d("TT-DrivingTask", "Missing driving event at " + aq.m4233e(this.f8238p.m11645a().getAbsoluteTimeMillis()));
                        }
                        if (this.f8230c == null) {
                            j = f8224f;
                            if (this.f8238p.m11647c()) {
                                j = f8228j;
                            }
                            a = m11656a(this.f8238p.m11645a(), unidentifiedDriverId, c2369i, this.f8238p.m11646b(), relativeTimestamp, c2370j, j);
                            if (a == null) {
                                this.f8230c = new C2376c(c2369i.m11613l(), a, c2358c, c2369i.m11594a(this.f8233k));
                                C2392k.m11715a(this.f8233k, this.f8238p.m11645a(), this.f8230c.m11640b(), eobrDevice, processingState, c2369i, c2370j, null);
                                this.f8240r = this.f8238p.m11645a().getAbsoluteTimeMillis();
                                this.f8241s = 0;
                                return true;
                            }
                            C2134e.m10680d("TT-DrivingTask", "Failure to create driving event");
                            return false;
                        }
                    }
                }
                unidentifiedDriverId = d;
                a = m11670a(unidentifiedDriverId, this.f8238p.m11645a(), c2369i.m11600b());
                if (a != null) {
                    this.f8230c = new C2376c(c2369i.m11613l(), a, c2358c, c2369i.m11594a(this.f8233k));
                    if (c2370j.m11630a(C2382c.class)) {
                        c2370j.m11629a(new C2382c(this.f8233k));
                    }
                }
                C2134e.m10680d("TT-DrivingTask", "Missing driving event at " + aq.m4233e(this.f8238p.m11645a().getAbsoluteTimeMillis()));
                if (this.f8230c == null) {
                    j = f8224f;
                    if (this.f8238p.m11647c()) {
                        j = f8228j;
                    }
                    a = m11656a(this.f8238p.m11645a(), unidentifiedDriverId, c2369i, this.f8238p.m11646b(), relativeTimestamp, c2370j, j);
                    if (a == null) {
                        C2134e.m10680d("TT-DrivingTask", "Failure to create driving event");
                        return false;
                    }
                    this.f8230c = new C2376c(c2369i.m11613l(), a, c2358c, c2369i.m11594a(this.f8233k));
                    C2392k.m11715a(this.f8233k, this.f8238p.m11645a(), this.f8230c.m11640b(), eobrDevice, processingState, c2369i, c2370j, null);
                    this.f8240r = this.f8238p.m11645a().getAbsoluteTimeMillis();
                    this.f8241s = 0;
                    return true;
                }
            }
            if (this.f8230c.m11640b().getImmutableDutySegment()) {
                long occurredAt = this.f8230c.m11640b().getOccurredAt();
                if ((relativeTimestamp.getAbsoluteTimeMillis() - occurredAt) / this.f8239q != (this.f8240r - occurredAt) / this.f8239q) {
                    this.f8241s++;
                    C2392k.m11715a(this.f8233k, relativeTimestamp, m11669a(this.f8230c.m11643e(), c2369i, c1015l, relativeTimestamp, c2370j, this.f8241s % 4 == 0), eobrDevice, processingState, c2369i, c2370j, null);
                    this.f8240r = relativeTimestamp.getAbsoluteTimeMillis();
                }
            }
            m11672a(relativeTimestamp.getAbsoluteTimeMillis(), c2369i, c2358c, c2370j, processingState);
            return true;
        }
    }

    private void m11668c() {
        if (this.f8230c != null) {
            Event a = this.f8233k.mo1301i().m10005a(this.f8230c.m11640b().getEventId().m19091d());
            if (a == null) {
                a = this.f8233k.mo1301i().m10038c(this.f8230c.m11640b().getEventId());
            }
            if (m11664a(this.f8230c.m11640b(), a)) {
                this.f8230c.m11639a(a);
                return;
            }
            C2134e.m10680d("TT-DrivingTask", "Tracked driving event changed during drive segment: " + C1144s.m5763c(this.f8230c.m11640b()) + " vs " + C1144s.m5763c(a));
            m11666b();
        }
    }

    private static DutyStatus m11654a(Event event) {
        if (!DutyStatus.m4387b(event.getEventType())) {
            return null;
        }
        switch (DutyStatus.m4383a(event.getEventType())) {
            case OFF_DUTY_DRIVING:
                return DutyStatus.OFF_DUTY;
            default:
                return DutyStatus.ON_DUTY_NOT_DRIVING;
        }
    }

    private void m11660a(C2369i c2369i, C1015l c1015l, RelativeTimestamp relativeTimestamp, boolean z) {
        if (this.f8238p == null && c2369i.m11612k().getMotionType() == MotionType.MOVING) {
            m11666b();
            this.f8238p = new C2377d(relativeTimestamp, c1015l, z);
            this.f8240r = this.f8238p.m11645a().getAbsoluteTimeMillis();
        }
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            C2134e.m10676b("TT-DrivingTask", "Timestamp: " + relativeTimestamp);
            return true;
        } else if (c2369i == null) {
            C2134e.m10676b("TT-DrivingTask", "Ignoring event without allocated vehicleState");
            return true;
        } else {
            VarDutyStatusChange varDutyStatusChange;
            this.f8236n = c2369i;
            MotionType motionType = c2369i.m11612k().getMotionType();
            boolean z = this.f8237o;
            this.f8237o = false;
            VarDutyStatusChange varDutyStatusChange2 = null;
            ContinueDrivingPromptResponse continueDrivingPromptResponse = null;
            if (c1024d != null) {
                if (c1024d.m5262b()) {
                    varDutyStatusChange2 = c1024d.m5263c();
                }
                if (c1024d.m5268h()) {
                    continueDrivingPromptResponse = c1024d.m5269i();
                    varDutyStatusChange = varDutyStatusChange2;
                } else {
                    varDutyStatusChange = varDutyStatusChange2;
                }
            } else {
                varDutyStatusChange = null;
            }
            if (this.f8230c != null && z && processingState.m11310a()) {
                m11668c();
            }
            if (!(this.f8230c == null || this.f8230c.m11638a() != ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE || c2369i.m11613l() == this.f8230c.m11638a())) {
                EventType a = m11657a(c2369i.m11613l());
                if (a != null) {
                    Event b = this.f8230c.m11640b();
                    if (a.m13980a() != this.f8230c.m11640b().getEventType()) {
                        b = Event.newBuilder(b).m13842a(a.m13980a()).m13862c();
                        this.f8233k.mo1301i().m10028b(new C1142r().m5746a(b), b.getOccurredAt());
                    }
                    this.f8230c = new C2376c(c2369i.m11613l(), b, this.f8230c.m11641c(), this.f8230c.m11642d());
                }
            }
            m11658a(eobrDevice, c1015l, relativeTimestamp, c2358c, processingState, c2369i, c2370j, varDutyStatusChange, continueDrivingPromptResponse);
            if (motionType == MotionType.MOVING) {
                m11675a(eobrDevice, c2358c, processingState, c2369i, c1015l, relativeTimestamp, c2370j);
            }
            return (this.f8238p == null && this.f8230c == null) ? false : true;
        }
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
        EventManager i = this.f8233k.mo1301i();
        if (this.f8230c != null) {
            i.m10067q().m9966a();
            C2369i c2369i = this.f8232e;
            if (c2369i == null) {
                c2369i = this.f8236n;
            }
            if (processingState.m11310a()) {
                m11668c();
            }
            if (this.f8230c != null) {
                m11659a(this.f8233k, this.f8230c.m11640b(), c2369i);
            }
        }
        m11666b();
    }
}
