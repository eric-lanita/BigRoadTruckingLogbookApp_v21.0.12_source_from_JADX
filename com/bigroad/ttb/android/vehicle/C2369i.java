package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.turbo.BusType;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2175a;
import com.bigroad.ttb.android.model.C2175a.C2174a;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.model.C2178c;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.MotionState;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification.C2811a;
import com.google.common.collect.ImmutableMap;
import com.google.protobuf.C3642c;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class C2369i {
    private static final VehicleIdentification f8184p = VehicleIdentification.newBuilder().m15907c();
    private static final MotionState f8185q = MotionState.newBuilder().m14554a(MotionType.UNKNOWN_MOTION_TYPE).m14561c();
    private final VehicleIdentification f8186a;
    private final Breadcrumb f8187b;
    private final C2182e f8188c;
    private final MotionState f8189d;
    private final ActiveDrivingMode f8190e;
    private final boolean f8191f;
    private final EngineUseState f8192g;
    private final boolean f8193h;
    private final Map<VehicleStateMalfunction, Long> f8194i;
    private final int f8195j;
    private final Integer f8196k;
    private final OdometerOffsets f8197l;
    private final Map<Long, OdometerOffsets> f8198m;
    private final C2182e f8199n;
    private final C2175a f8200o;

    public static final class C2368a {
        private VehicleIdentification f8169a;
        private Breadcrumb f8170b;
        private C2182e f8171c;
        private MotionState f8172d;
        private ActiveDrivingMode f8173e;
        private boolean f8174f;
        private EngineUseState f8175g;
        private boolean f8176h;
        private Map<VehicleStateMalfunction, Long> f8177i;
        private int f8178j;
        private Integer f8179k;
        private OdometerOffsets f8180l;
        private Map<Long, OdometerOffsets> f8181m;
        private C2182e f8182n;
        private C2175a f8183o;

        private C2368a() {
            this.f8177i = new HashMap();
            this.f8181m = new HashMap();
            this.f8183o = new C2174a().m10794b();
            m11576a(C2369i.f8184p);
            m11574a(C2369i.f8185q);
            m11572a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE);
            m11569a(EngineUseState.ENGINE_USE_UNKNOWN);
        }

        private C2368a(C2369i c2369i) {
            this.f8177i = new HashMap();
            this.f8181m = new HashMap();
            this.f8183o = new C2174a().m10794b();
            m11576a(c2369i.m11600b());
            m11573a(c2369i.m11607f());
            m11571a(c2369i.m11609h());
            m11575a(c2369i.m11610i());
            m11577a(c2369i.m11611j());
            m11574a(c2369i.m11612k());
            m11572a(c2369i.m11613l());
            m11578a(c2369i.m11614m());
            m11569a(c2369i.m11615n());
            m11582b(c2369i.m11618q());
            m11583b(c2369i.m11616o());
            m11581b(c2369i.m11620s());
            m11570a(c2369i.m11623v());
            this.f8178j = c2369i.m11619r();
        }

        public C2368a m11576a(VehicleIdentification vehicleIdentification) {
            if (vehicleIdentification == null) {
                throw new IllegalArgumentException();
            }
            this.f8169a = vehicleIdentification;
            return this;
        }

        public VehicleIdentification m11579a() {
            return this.f8169a;
        }

        public C2368a m11573a(Breadcrumb breadcrumb) {
            this.f8170b = breadcrumb;
            return this;
        }

        public C2368a m11580b() {
            this.f8170b = null;
            return this;
        }

        public C2368a m11571a(C2182e c2182e) {
            this.f8171c = c2182e;
            return this;
        }

        public C2368a m11581b(C2182e c2182e) {
            this.f8182n = c2182e;
            return this;
        }

        public C2368a m11575a(OdometerOffsets odometerOffsets) {
            this.f8180l = odometerOffsets;
            if (this.f8169a.hasTruckId() && this.f8180l != null) {
                this.f8181m.put(Long.valueOf(this.f8169a.getTruckId()), this.f8180l);
            }
            return this;
        }

        public C2368a m11577a(Map<Long, OdometerOffsets> map) {
            this.f8181m.putAll(map);
            return this;
        }

        public C2368a m11574a(MotionState motionState) {
            this.f8172d = motionState;
            return this;
        }

        public C2368a m11572a(ActiveDrivingMode activeDrivingMode) {
            this.f8173e = activeDrivingMode;
            return this;
        }

        public C2368a m11578a(boolean z) {
            this.f8174f = z;
            return this;
        }

        public C2368a m11569a(EngineUseState engineUseState) {
            this.f8175g = engineUseState;
            return this;
        }

        public C2368a m11583b(boolean z) {
            this.f8176h = z;
            return this;
        }

        public C2368a m11582b(Map<VehicleStateMalfunction, Long> map) {
            this.f8177i.clear();
            if (map != null) {
                this.f8177i.putAll(map);
            }
            return this;
        }

        public C2368a m11568a(BusType busType) {
            this.f8178j |= 1 << busType.ordinal();
            return this;
        }

        public C2368a m11567a(int i) {
            this.f8179k = Integer.valueOf(i);
            return this;
        }

        public C2368a m11570a(C2175a c2175a) {
            if (c2175a == null) {
                this.f8183o = new C2174a().m10794b();
            } else {
                this.f8183o = c2175a;
            }
            return this;
        }

        public C2369i m11584c() {
            if (this.f8169a != null && this.f8172d != null) {
                return new C2369i(this.f8169a, this.f8170b, this.f8171c, this.f8172d, this.f8173e, this.f8174f, this.f8175g, this.f8176h, this.f8177i, this.f8178j, this.f8179k, this.f8180l, this.f8181m, this.f8182n, this.f8183o);
            }
            throw new IllegalStateException();
        }
    }

    private C2369i(VehicleIdentification vehicleIdentification, Breadcrumb breadcrumb, C2182e c2182e, MotionState motionState, ActiveDrivingMode activeDrivingMode, boolean z, EngineUseState engineUseState, boolean z2, Map<VehicleStateMalfunction, Long> map, int i, Integer num, OdometerOffsets odometerOffsets, Map<Long, OdometerOffsets> map2, C2182e c2182e2, C2175a c2175a) {
        this.f8186a = vehicleIdentification;
        this.f8187b = breadcrumb;
        this.f8188c = c2182e;
        this.f8189d = motionState;
        this.f8190e = activeDrivingMode;
        this.f8191f = z;
        this.f8192g = engineUseState;
        this.f8193h = z2;
        this.f8194i = ImmutableMap.m18549a((Map) map);
        this.f8195j = i;
        this.f8196k = num;
        this.f8197l = odometerOffsets;
        this.f8198m = ImmutableMap.m18549a((Map) map2);
        this.f8199n = c2182e2;
        this.f8200o = c2175a;
    }

    static C2369i m11590a(EobrDevice eobrDevice) {
        C2368a a = C2369i.m11588a();
        C2811a newBuilder = VehicleIdentification.newBuilder();
        if (eobrDevice != null) {
            if (eobrDevice.mo1121o() == EobrType.GENX) {
                newBuilder.m15905b(eobrDevice.mo1119g());
                a.m11575a(OdometerOffsets.newBuilder().m14593c());
            } else {
                newBuilder.m15901a(C3642c.m19078a(eobrDevice.m8992d()));
            }
        }
        a.m11576a(newBuilder.m15907c());
        return a.m11584c();
    }

    public static C2368a m11588a() {
        return new C2368a();
    }

    public static C2368a m11589a(C2369i c2369i) {
        return new C2368a();
    }

    public VehicleIdentification m11600b() {
        return this.f8186a;
    }

    public boolean m11603c() {
        return this.f8186a.hasTruckId();
    }

    public Long m11605d() {
        return this.f8186a.hasTruckId() ? Long.valueOf(this.f8186a.getTruckId()) : null;
    }

    public boolean m11606e() {
        return this.f8187b != null;
    }

    public Breadcrumb m11607f() {
        return this.f8187b;
    }

    public boolean m11608g() {
        return this.f8188c != null;
    }

    public C2182e m11609h() {
        return this.f8188c;
    }

    public OdometerOffsets m11594a(C2032f c2032f) {
        if (this.f8197l != null) {
            return this.f8197l;
        }
        if (this.f8186a.hasTruckId()) {
            OdometerOffsets odometerOffsets = (OdometerOffsets) this.f8198m.get(Long.valueOf(this.f8186a.getTruckId()));
            if (odometerOffsets != null) {
                return odometerOffsets;
            }
        }
        Truck a = C2371k.m11631a(c2032f, this);
        if (a == null || !a.hasOdometerOffsets()) {
            return null;
        }
        return a.getOdometerOffsets();
    }

    public OdometerOffsets m11610i() {
        return this.f8197l;
    }

    public Map<Long, OdometerOffsets> m11611j() {
        return this.f8198m;
    }

    public MotionState m11612k() {
        return this.f8189d;
    }

    public ActiveDrivingMode m11613l() {
        return this.f8190e == null ? ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE : this.f8190e;
    }

    public boolean m11614m() {
        return this.f8191f;
    }

    public Integer m11601b(C2032f c2032f) {
        if (m11621t()) {
            return m11591a(m11585a(m11620s(), c2032f), c2032f);
        }
        return null;
    }

    public Integer m11602c(C2032f c2032f) {
        return m11591a(m11604d(c2032f), c2032f);
    }

    public Integer m11595a(OdometerOffsets odometerOffsets, C2032f c2032f) {
        return m11591a(m11587a(odometerOffsets), c2032f);
    }

    private Integer m11591a(C2177b c2177b, C2032f c2032f) {
        if (c2177b == null) {
            return null;
        }
        Truck a = C2371k.m11631a(c2032f, this);
        if (a == null) {
            C2134e.m10682e("TT-VehicleState", "Vehicle state truck not available. Odometer will be in miles");
        }
        return Integer.valueOf(c2177b.m10801a(a));
    }

    public C2177b m11604d(C2032f c2032f) {
        return m11585a(m11609h(), c2032f);
    }

    private C2177b m11585a(C2182e c2182e, C2032f c2032f) {
        OdometerOffsets a = m11594a(c2032f);
        if (a != null) {
            return m11586a(c2182e, a);
        }
        C2177b a2 = m11586a(c2182e, OdometerOffsets.getDefaultInstance());
        if (a2 == null || a2.m10803b().m5465a()) {
            return null;
        }
        return a2;
    }

    private C2177b m11586a(C2182e c2182e, OdometerOffsets odometerOffsets) {
        return C2178c.m10804a(c2182e, odometerOffsets);
    }

    private C2177b m11587a(OdometerOffsets odometerOffsets) {
        return m11586a(m11609h(), odometerOffsets);
    }

    public EngineUseState m11615n() {
        return this.f8192g;
    }

    public boolean m11616o() {
        return this.f8193h;
    }

    public boolean m11617p() {
        return this.f8189d.getMotionType() == MotionType.MOVING;
    }

    public Map<VehicleStateMalfunction, Long> m11618q() {
        return this.f8194i;
    }

    public Set<VehicleStateMalfunction> m11597a(long j) {
        Set<VehicleStateMalfunction> hashSet = new HashSet();
        for (VehicleStateMalfunction vehicleStateMalfunction : this.f8194i.keySet()) {
            if (m11599a(vehicleStateMalfunction, j)) {
                hashSet.add(vehicleStateMalfunction);
            }
        }
        return hashSet;
    }

    public boolean m11599a(VehicleStateMalfunction vehicleStateMalfunction, long j) {
        Long a = m11596a(vehicleStateMalfunction);
        return a != null && a.longValue() >= j;
    }

    public Long m11596a(VehicleStateMalfunction vehicleStateMalfunction) {
        return (Long) this.f8194i.get(vehicleStateMalfunction);
    }

    public int m11619r() {
        return this.f8195j;
    }

    public boolean m11598a(BusType busType) {
        return (this.f8195j & (1 << busType.ordinal())) != 0;
    }

    public C2182e m11620s() {
        return this.f8199n;
    }

    public boolean m11621t() {
        return this.f8199n != null;
    }

    public Integer m11622u() {
        return this.f8196k;
    }

    public C2175a m11623v() {
        return this.f8200o;
    }
}
