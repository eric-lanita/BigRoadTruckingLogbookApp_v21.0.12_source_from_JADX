package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.EngineHoursLogEntry;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2175a.C2174a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.protocol.TTProtocol.EngineHoursSource;
import com.google.common.primitives.UnsignedInteger;

public class C2343b {
    public static C2369i m11458a(C2369i c2369i, C2348f c2348f) {
        C1016p a = c2348f.m11466a();
        if (a instanceof EngineHoursLogEntry) {
            EngineHoursLogEntry engineHoursLogEntry = (EngineHoursLogEntry) a;
            if (engineHoursLogEntry.f3195b.length == 0 || engineHoursLogEntry.f3194a.length == 0 || engineHoursLogEntry.f3195b.length != engineHoursLogEntry.f3194a.length) {
                throw new IllegalArgumentException("Malformatted log entry: " + engineHoursLogEntry.toString());
            }
            C2174a c2174a = new C2174a(c2369i.m11623v());
            for (int i = 0; i < engineHoursLogEntry.f3195b.length; i++) {
                try {
                    EngineHoursSource a2 = C2343b.m11459a(engineHoursLogEntry.f3195b[i]);
                    if (a2 != EngineHoursSource.UNKNOWN_EH_SOURCE) {
                        c2174a.m10793a(a2, (UnsignedInteger.m18836a(engineHoursLogEntry.f3194a[i]).longValue() * 3) * 60000);
                    }
                } catch (IllegalArgumentException e) {
                    C2134e.m10680d("TT-EngineHoursLEC", e.toString());
                }
            }
            return C2369i.m11589a(c2369i).m11570a(c2174a.m10794b()).m11584c();
        }
        throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
    }

    public static EngineHoursSource m11459a(EngineHoursLogEntry.EngineHoursSource engineHoursSource) {
        switch (engineHoursSource) {
            case ENGINE_HOURS_SOURCE_J1939:
                return EngineHoursSource.EH_J1939;
            case ENGINE_HOURS_SOURCE_J1587:
                return EngineHoursSource.EH_J1587;
            case ENGINE_HOURS_SOURCE_DASHLINK_FIRMWARE:
                return EngineHoursSource.EH_DASHLINK_FIRMWARE;
            case ENGINE_HOURS_SOURCE_UNKNOWN:
                return EngineHoursSource.UNKNOWN_EH_SOURCE;
            default:
                throw new IllegalArgumentException("Unhandled source " + engineHoursSource.toString());
        }
    }
}
