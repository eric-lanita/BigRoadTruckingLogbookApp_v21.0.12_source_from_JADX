package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.genx.C0975o;
import com.bigroad.shared.eobr.genx.GenxEntryReasonCode;
import com.bigroad.shared.eobr.genx.GenxEntryResponse;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2175a.C2174a;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.model.C2182e.C2181a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.C2371k;
import com.bigroad.ttb.android.vehicle.task.C2383d;
import com.bigroad.ttb.android.vehicle.task.C2385e;
import com.bigroad.ttb.android.vehicle.task.DrivingTask;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.EngineHoursSource;
import com.bigroad.ttb.protocol.TTProtocol.MotionState;
import com.bigroad.ttb.protocol.TTProtocol.MotionState.C2707a;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public abstract class C2345d {
    public static C2369i m11461a(C2369i c2369i, C2348f c2348f, C2370j c2370j, C2032f c2032f) {
        C0975o b = c2348f.m11467b();
        if (b instanceof GenxEntryResponse) {
            GenxEntryResponse genxEntryResponse = (GenxEntryResponse) b;
            C2368a a = C2369i.m11589a(c2369i);
            long[] jArr = new long[CanonicalOdometerSource.f3603l];
            jArr[CanonicalOdometerSource.GENX_ECM.ordinal()] = genxEntryResponse.m5005k();
            jArr[CanonicalOdometerSource.GENX_FW.ordinal()] = Math.max(genxEntryResponse.m5006l(), 1);
            C2182e a2 = new C2181a(jArr).m10814a();
            a.m11571a(a2);
            MotionState k = c2369i.m11612k();
            MotionType motionType = k.getMotionType();
            if (genxEntryResponse.m5004j() == GenxEntryReasonCode.BEGIN_MOVE) {
                motionType = MotionType.MOVING;
            } else if (genxEntryResponse.m5004j() == GenxEntryReasonCode.BEGIN_STOP) {
                motionType = MotionType.STOPPED;
            }
            EngineUseState n = c2369i.m11615n();
            EngineUseState n2 = c2369i.m11615n();
            if (GenxEntryReasonCode.m4985c(genxEntryResponse.m5004j())) {
                n2 = EngineUseState.ENGINE_OFF;
            } else if (GenxEntryReasonCode.m4984b(genxEntryResponse.m5004j())) {
                n2 = EngineUseState.ENGINE_ON;
                if (!c2370j.m11630a(C2385e.class)) {
                    C2134e.m10673a("TT-GenxLEC", "Starting EngineInUseTask");
                    c2370j.m11629a(new C2385e(c2032f));
                }
            }
            if (n2 == EngineUseState.ENGINE_OFF) {
                a.m11578a(false);
            }
            if (motionType == MotionType.MOVING && !c2369i.m11614m()) {
                a.m11572a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE).m11578a(true);
                C2383d.m11687a(c2369i, ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, c2370j, c2032f);
            }
            a.m11569a(n2);
            if (n != n2) {
                C2134e.m10673a("TT-GenxLEC", "Engine State changed from " + n + ", to " + n2);
            }
            if (genxEntryResponse.m5004j() == GenxEntryReasonCode.VIN) {
                a = C2354l.m11483a(a, genxEntryResponse.m5013s(), c2032f);
            }
            RelativeTimestamp l = c2348f.mo1281l();
            C2707a a3 = MotionState.newBuilder().m14554a(motionType).m14555a(l);
            if (genxEntryResponse.m5012r()) {
                a3.m14560c(l);
            } else if (k.hasLastValidDataAt()) {
                a3.m14560c(k.getLastValidDataAt());
            }
            if (a3.m14571k() == MotionType.MOVING && !c2370j.m11630a(DrivingTask.class)) {
                C2134e.m10673a("TT-GenxLEC", "Starting DrivingTask");
                c2370j.m11629a(new DrivingTask(c2032f, DrivingTask.m11652a(c2032f.mo1307o())));
            }
            C2174a a4 = new C2174a(c2369i.m11623v()).m10793a(EngineHoursSource.EH_GENX_ECM, genxEntryResponse.m5007m()).m10793a(EngineHoursSource.EH_GENX_FW, genxEntryResponse.m5008n());
            if (n == EngineUseState.ENGINE_OFF && n2 != EngineUseState.ENGINE_OFF) {
                a4.m10792a();
            }
            a.m11574a(a3.m14561c()).m11583b(genxEntryResponse.m5012r()).m11570a(a4.m10794b()).m11567a(genxEntryResponse.m5003i());
            C2345d.m11463a(a, genxEntryResponse);
            C2371k.m11632a(c2369i.m11615n(), n2, c2369i.m11620s(), a2, a);
            return a.m11584c();
        }
        throw new IllegalArgumentException("Unexpected type: " + (b != null ? b.getClass().getName() : "null"));
    }

    private static void m11463a(C2368a c2368a, GenxEntryResponse genxEntryResponse) {
        if (genxEntryResponse.m5004j() == GenxEntryReasonCode.GPS_LOST) {
            C2134e.m10673a("TT-GenxLEC", "Clearing gps position because of " + GenxEntryReasonCode.GPS_LOST.toString());
            c2368a.m11580b();
            return;
        }
        Breadcrumb a = C2345d.m11462a(genxEntryResponse);
        if (a == null) {
            C2134e.m10673a("TT-GenxLEC", "Clearing gps position because lat/long are 0");
            c2368a.m11580b();
            return;
        }
        c2368a.m11573a(a);
    }

    private static Breadcrumb m11462a(GenxEntryResponse genxEntryResponse) {
        if (genxEntryResponse.m5009o() == 0 && genxEntryResponse.m5010p() == 0) {
            return null;
        }
        return Breadcrumb.newBuilder().m12526a(genxEntryResponse.m5009o()).m12531b(genxEntryResponse.m5010p()).m12527a(genxEntryResponse.mo749d()).m12534c();
    }
}
