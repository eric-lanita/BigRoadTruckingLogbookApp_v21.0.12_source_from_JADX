package com.bigroad.ttb.android.vehicle.p042c;

import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.model.C2177b;
import com.bigroad.ttb.android.model.C2179d;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.util.C2123x;
import com.bigroad.ttb.android.util.C2290j;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.VehicleStateMalfunction;
import com.bigroad.ttb.android.vehicle.task.C2388g;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.google.common.base.Objects;
import java.util.HashMap;
import java.util.Map;

public class C2357a {
    Long f8118a;
    private final C2032f f8119b;
    private Long f8120c;
    private C2123x<Long> f8121d;
    private C2123x<Long> f8122e;
    private C2179d f8123f;
    private C2177b f8124g;
    private boolean f8125h = false;
    private boolean f8126i = false;

    public C2357a(C2032f c2032f) {
        this.f8119b = c2032f;
        this.f8121d = new C2123x(27, 780000, 30000);
        this.f8122e = new C2123x(27, 780000, 30000);
    }

    public C2369i m11500a(C2369i c2369i, C2358c c2358c, RelativeTimestamp relativeTimestamp, C2370j c2370j) {
        if (c2369i != null && relativeTimestamp.hasAbsoluteTimeMillis()) {
            long absoluteTimeMillis = relativeTimestamp.getAbsoluteTimeMillis();
            m11496a(c2369i, c2358c, absoluteTimeMillis);
            Map hashMap = new HashMap(c2369i.m11618q());
            m11497a(hashMap, absoluteTimeMillis);
            m11498b(hashMap, absoluteTimeMillis);
            m11499c(hashMap, absoluteTimeMillis);
            if (!hashMap.equals(c2369i.m11618q())) {
                c2369i = C2369i.m11589a(c2369i).m11582b(hashMap).m11584c();
            }
            if (!(hashMap.isEmpty() || c2370j.m11630a(C2388g.class))) {
                c2370j.m11629a(new C2388g(this.f8119b));
            }
        }
        return c2369i;
    }

    private void m11495a() {
        this.f8120c = null;
        this.f8121d.m10632a();
        this.f8122e.m10632a();
        this.f8123f = null;
        this.f8124g = null;
        this.f8118a = null;
        this.f8125h = false;
    }

    private void m11496a(C2369i c2369i, C2358c c2358c, long j) {
        C2179d c2179d;
        if (!Objects.equal(c2369i.m11605d(), this.f8120c)) {
            m11495a();
            this.f8120c = c2369i.m11605d();
        }
        CanonicalOdometerSource canonicalOdometerSource;
        if (this.f8123f == null) {
            canonicalOdometerSource = null;
        } else {
            canonicalOdometerSource = this.f8123f.m10812b();
        }
        C2182e h = c2369i.m11609h();
        if (h == null) {
            c2179d = null;
        } else {
            c2179d = h.m10821b();
        }
        this.f8123f = c2179d;
        this.f8124g = c2369i.m11604d(this.f8119b);
        if (this.f8123f == null || r0 != this.f8123f.m10812b() || this.f8123f.m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
            this.f8122e.m10632a();
            this.f8121d.m10632a();
        }
        this.f8126i = c2369i.m11616o();
        if (!this.f8126i) {
            if (c2369i.m11602c(this.f8119b) != null) {
                switch (c2369i.m11615n()) {
                    case ENGINE_ON:
                        if (this.f8118a == null) {
                            this.f8118a = Long.valueOf(j);
                            break;
                        }
                        break;
                    default:
                        this.f8118a = null;
                        break;
                }
            }
            this.f8118a = null;
        } else {
            this.f8118a = null;
        }
        this.f8125h = c2369i.m11612k().getMotionType() == MotionType.MOVING;
        Breadcrumb f = c2369i.m11607f();
        if (f != null && f.hasRecordedAt() && j - f.getRecordedAt() <= 60000 && C2290j.m11218a(f) == MotionType.MOVING) {
            this.f8125h = true;
        }
        if (this.f8125h) {
            if (!(this.f8123f == null || this.f8123f.m10812b() == CanonicalOdometerSource.DASHLINK_FIRMWARE)) {
                this.f8122e.m10633a(Long.valueOf(this.f8123f.m10811a()), j);
            }
            if (!this.f8122e.m10634b() && h != null) {
                C2179d b = h.m10822b(CanonicalOdometerSource.DASHLINK_FIRMWARE);
                if (b != null) {
                    this.f8121d.m10633a(Long.valueOf(b.m10811a()), j);
                    return;
                }
                return;
            }
            return;
        }
        this.f8122e.m10632a();
        this.f8121d.m10632a();
    }

    private void m11497a(Map<VehicleStateMalfunction, Long> map, long j) {
        if (this.f8126i) {
            map.remove(VehicleStateMalfunction.MISSING_ROAD_SPEED);
        } else if (this.f8125h && this.f8118a != null && j > this.f8118a.longValue() + 120000) {
            map.put(VehicleStateMalfunction.MISSING_ROAD_SPEED, Long.valueOf(86400000 + j));
        }
    }

    private void m11498b(Map<VehicleStateMalfunction, Long> map, long j) {
        if (!this.f8121d.m10634b() && !this.f8122e.m10634b()) {
            double h = (double) this.f8121d.m10640h();
            double h2 = (double) this.f8122e.m10640h();
            if (h >= 600000.0d && h2 >= 600000.0d) {
                double longValue = (double) (((Long) this.f8121d.m10638f()).longValue() - ((Long) this.f8121d.m10636d()).longValue());
                Object obj = longValue > 10000.0d ? 1 : null;
                double longValue2 = (double) (((Long) this.f8122e.m10638f()).longValue() - ((Long) this.f8122e.m10636d()).longValue());
                Object obj2 = longValue2 > 10000.0d ? 1 : null;
                h = (longValue * 1000.0d) / h;
                h2 = (1000.0d * longValue2) / h2;
                long g = this.f8122e.m10639g() + 600000;
                if (10.0d * h2 < h) {
                    if (obj != null) {
                        map.put(VehicleStateMalfunction.SLOW_ODOMETER, Long.valueOf(g));
                    }
                } else if (2.0d * h2 >= h && obj2 != null) {
                    map.remove(VehicleStateMalfunction.SLOW_ODOMETER);
                }
                if (map.containsKey(VehicleStateMalfunction.MISSING_ROAD_SPEED)) {
                    map.remove(VehicleStateMalfunction.FAST_ODOMETER);
                } else if (10.0d * h < h2) {
                    if (obj2 != null) {
                        map.put(VehicleStateMalfunction.FAST_ODOMETER, Long.valueOf(g));
                    }
                } else if (h * 2.0d >= h2 && obj != null) {
                    map.remove(VehicleStateMalfunction.FAST_ODOMETER);
                }
            }
        }
    }

    private void m11499c(Map<VehicleStateMalfunction, Long> map, long j) {
        if (this.f8123f != null) {
            map.remove(VehicleStateMalfunction.NO_ODOMETER_READINGS);
        }
        if (this.f8124g != null) {
            map.remove(VehicleStateMalfunction.UNCALIBRATED_ODOMETER);
        }
        if (this.f8125h) {
            long j2 = 86400000 + j;
            if (this.f8123f == null) {
                map.put(VehicleStateMalfunction.NO_ODOMETER_READINGS, Long.valueOf(j2));
                map.remove(VehicleStateMalfunction.UNCALIBRATED_ODOMETER);
            } else if (this.f8124g == null) {
                map.put(VehicleStateMalfunction.UNCALIBRATED_ODOMETER, Long.valueOf(j2));
                map.remove(VehicleStateMalfunction.NO_ODOMETER_READINGS);
            }
        }
    }
}
