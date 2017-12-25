package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.C1099k;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.aobrd.MalfunctionReason;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.android.vehicle.VehicleStateMalfunction;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.google.protobuf.C3642c;

public class C2388g implements C2379j {
    private final C2032f f8262a;
    private final EventManager f8263b;
    private C2387a[] f8264c = new C2387a[VehicleStateMalfunction.values().length];
    private boolean f8265d = false;

    class C2387a {
        final /* synthetic */ C2388g f8258a;
        private final VehicleStateMalfunction f8259b;
        private final C3642c f8260c;
        private final long f8261d;

        C2387a(C2388g c2388g, VehicleStateMalfunction vehicleStateMalfunction, C3642c c3642c, long j) {
            this.f8258a = c2388g;
            this.f8259b = vehicleStateMalfunction;
            this.f8260c = c3642c;
            this.f8261d = j;
        }

        public VehicleStateMalfunction m11700a() {
            return this.f8259b;
        }

        public C3642c m11701b() {
            return this.f8260c;
        }

        public long m11702c() {
            return this.f8261d;
        }
    }

    public C2388g(C2032f c2032f) {
        this.f8262a = c2032f;
        this.f8263b = this.f8262a.mo1301i();
    }

    private void m11703a(VehicleStateMalfunction vehicleStateMalfunction, long j) {
        C2387a c2387a = this.f8264c[vehicleStateMalfunction.ordinal()];
        if (c2387a != null) {
            byte[] d = c2387a.m11701b().m19091d();
            Event a = this.f8263b.m10005a(d);
            if (a != null) {
                long a2 = C1099k.m5446a(a.getContextualData(), j);
                if (a.getContextualData() != a2) {
                    this.f8263b.m10067q().m9968a(d, a2);
                }
            }
        }
    }

    private void m11704a(VehicleStateMalfunction vehicleStateMalfunction, long j, String str) {
        m11703a(vehicleStateMalfunction, j);
        this.f8264c[vehicleStateMalfunction.ordinal()] = null;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return true;
        }
        Event a;
        long d = c2358c.m11506d();
        long absoluteTimeMillis = relativeTimestamp.getAbsoluteTimeMillis();
        if (c2358c.m11510h() && !this.f8265d) {
            this.f8265d = true;
            for (VehicleStateMalfunction vehicleStateMalfunction : VehicleStateMalfunction.values()) {
                if (this.f8264c[vehicleStateMalfunction.ordinal()] == null) {
                    a = this.f8263b.m10001a(absoluteTimeMillis, d, MalfunctionReason.m8430a(vehicleStateMalfunction));
                    if (a != null) {
                        this.f8264c[vehicleStateMalfunction.ordinal()] = new C2387a(this, vehicleStateMalfunction, a.getEventId(), C1099k.m5447a(a.getContextualData()).longValue());
                    }
                }
            }
        }
        for (C2387a c2387a : this.f8264c) {
            if (c2387a != null) {
                if (c2369i.m11599a(c2387a.m11700a(), absoluteTimeMillis)) {
                    Event a2 = this.f8263b.m10005a(c2387a.m11701b().m19091d());
                    if (!(a2 == null || a2.getPersonId() == d)) {
                        m11704a(c2387a.m11700a(), absoluteTimeMillis, "updated for new driver");
                    }
                } else if (c2387a.m11702c() < absoluteTimeMillis) {
                    m11704a(c2387a.m11700a(), c2387a.m11702c(), "expired");
                } else {
                    m11704a(c2387a.m11700a(), absoluteTimeMillis, "inactive");
                }
            }
        }
        Object obj = null;
        for (VehicleStateMalfunction vehicleStateMalfunction2 : c2369i.m11597a(absoluteTimeMillis)) {
            long longValue = c2369i.m11596a(vehicleStateMalfunction2).longValue();
            if (this.f8264c[vehicleStateMalfunction2.ordinal()] == null) {
                MalfunctionReason a3 = MalfunctionReason.m8430a(vehicleStateMalfunction2);
                if (a3 != null) {
                    a = this.f8263b.m10001a(absoluteTimeMillis, d, a3);
                    if (a != null) {
                        this.f8264c[vehicleStateMalfunction2.ordinal()] = new C2387a(this, vehicleStateMalfunction2, a.getEventId(), longValue);
                        m11703a(vehicleStateMalfunction2, longValue);
                    } else if (processingState.m11310a()) {
                        Event a4 = C2022a.m10086a(a3.m8431a(), a3.m8432b(), RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(c2358c.m11506d()), absoluteTimeMillis, null, c2369i, c1015l, relativeTimestamp, null, Long.valueOf(C1099k.m5446a(0, longValue)), c2370j.m11626a(), this.f8262a);
                        if (a4 != null && C2392k.m11715a(this.f8262a, relativeTimestamp, a4, eobrDevice, processingState, c2369i, c2370j, null)) {
                            this.f8264c[vehicleStateMalfunction2.ordinal()] = new C2387a(this, vehicleStateMalfunction2, a4.getEventId(), longValue);
                        }
                    } else {
                        obj = 1;
                    }
                }
            } else {
                m11703a(vehicleStateMalfunction2, longValue);
            }
        }
        if (obj != null) {
            return true;
        }
        for (C2387a c2387a2 : this.f8264c) {
            if (c2387a2 != null) {
                return true;
            }
        }
        return false;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
        this.f8263b.m10067q().m9966a();
    }
}
