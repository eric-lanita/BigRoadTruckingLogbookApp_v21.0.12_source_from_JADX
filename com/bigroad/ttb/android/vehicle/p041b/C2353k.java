package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2175a.C2174a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.C2371k;
import com.bigroad.ttb.android.vehicle.task.C2383d;
import com.bigroad.ttb.android.vehicle.task.C2385e;
import com.bigroad.ttb.android.vehicle.task.DrivingTask;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.MotionState;
import com.bigroad.ttb.protocol.TTProtocol.MotionState.C2707a;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public abstract class C2353k {
    public static C2369i m11482a(C2369i c2369i, C2348f c2348f, C2370j c2370j, C2032f c2032f) {
        C1016p a = c2348f.m11466a();
        if (a instanceof C1036s) {
            boolean z;
            EngineUseState engineUseState;
            boolean z2;
            C1036s c1036s = (C1036s) a;
            MotionState k = c2369i.m11612k();
            EngineUseState n = c2369i.m11615n();
            boolean d = c1036s.m5279d();
            boolean h = c1036s.m5283h();
            if (k.getMotionType() != c1036s.m5277b()) {
                z = true;
            } else {
                z = false;
            }
            boolean z3;
            if (c1036s.m5278c() || c2369i.m11616o() != c1036s.m5278c()) {
                z3 = true;
            } else {
                z3 = false;
            }
            EngineUseState engineUseState2 = EngineUseState.ENGINE_USE_UNKNOWN;
            if (h && c1036s.m5282g()) {
                engineUseState = EngineUseState.ENGINE_ON;
            } else if (d && c1036s.m5280e()) {
                engineUseState = EngineUseState.ENGINE_ON;
            } else if (h || d) {
                engineUseState = EngineUseState.ENGINE_OFF;
            } else {
                engineUseState = engineUseState2;
            }
            if (engineUseState != n) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (!z && !r4 && !z2) {
                return c2369i;
            }
            MotionState k2 = c2369i.m11612k();
            RelativeTimestamp l = c2348f.mo1281l();
            C2707a a2 = MotionState.newBuilder().m14554a(c1036s.m5277b()).m14555a(l);
            if (c1036s.m5278c()) {
                a2.m14560c(l);
            } else if (k2.hasLastValidDataAt()) {
                a2.m14560c(k2.getLastValidDataAt());
            }
            C2134e.m10678c("TT-VehicleStateLEC", "Change to motion state: " + a2.m14571k());
            if (z2 && engineUseState == EngineUseState.ENGINE_ON && !c2370j.m11630a(C2385e.class)) {
                C2134e.m10678c("TT-VehicleStateLEC", "Starting EngineInUseTask");
                c2370j.m11629a(new C2385e(c2032f));
            }
            if (z && a2.m14571k() == MotionType.MOVING && !c2370j.m11630a(DrivingTask.class)) {
                C2134e.m10678c("TT-VehicleStateLEC", "Starting DrivingTask");
                c2370j.m11629a(new DrivingTask(c2032f, DrivingTask.m11652a(c2032f.mo1307o())));
            }
            C2368a a3 = C2369i.m11589a(c2369i);
            if (engineUseState == EngineUseState.ENGINE_OFF) {
                a3.m11578a(false);
            }
            if (n == EngineUseState.ENGINE_OFF && engineUseState != EngineUseState.ENGINE_OFF) {
                a3.m11570a(new C2174a(c2369i.m11623v()).m10792a().m10794b());
            }
            if (a2.m14571k() == MotionType.MOVING && !c2369i.m11614m()) {
                a3.m11572a(ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE).m11578a(true);
                C2383d.m11687a(c2369i, ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE, c2370j, c2032f);
            }
            a3.m11574a(a2.m14561c()).m11569a(engineUseState).m11583b(c1036s.m5278c());
            C2371k.m11632a(c2369i.m11615n(), engineUseState, c2369i.m11620s(), c2369i.m11609h(), a3);
            return a3.m11584c();
        }
        throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
    }
}
