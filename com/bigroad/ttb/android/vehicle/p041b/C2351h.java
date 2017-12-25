package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.model.C2182e.C2181a;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.android.vehicle.C2371k;
import com.google.common.primitives.UnsignedInteger;

public class C2351h {
    public static C2369i m11480a(C2369i c2369i, C2348f c2348f) {
        C1016p a = c2348f.m11466a();
        if (a instanceof MultiOdometerLogEntry) {
            MultiOdometerLogEntry multiOdometerLogEntry = (MultiOdometerLogEntry) a;
            if (multiOdometerLogEntry.f3235b.length == 0 || multiOdometerLogEntry.f3234a.length == 0 || multiOdometerLogEntry.f3235b.length != multiOdometerLogEntry.f3234a.length) {
                throw new IllegalArgumentException("Malformatted log entry: " + multiOdometerLogEntry.toString());
            }
            C2182e h = c2369i.m11609h();
            long[] jArr = new long[CanonicalOdometerSource.f3603l];
            int i = 0;
            while (i < multiOdometerLogEntry.f3235b.length) {
                try {
                    CanonicalOdometerSource a2 = C2351h.m11479a(multiOdometerLogEntry.f3235b[i]);
                    long longValue = UnsignedInteger.m18836a(multiOdometerLogEntry.f3234a[i]).longValue();
                    if (a2 == CanonicalOdometerSource.DASHLINK_FIRMWARE) {
                        longValue = Math.max(longValue, 1);
                    }
                    if (h == null || longValue >= h.m10816a(a2)) {
                        jArr[a2.ordinal()] = longValue;
                        i++;
                    } else {
                        C2134e.m10676b("TT-MultiOdometerLEC", "Ignoring " + multiOdometerLogEntry.toString() + " for " + multiOdometerLogEntry.f3235b[i].toString());
                        jArr[a2.ordinal()] = h.m10816a(a2);
                        i++;
                    }
                } catch (IllegalArgumentException e) {
                    C2134e.m10680d("TT-MultiOdometerLEC", e.toString());
                }
            }
            C2182e a3 = new C2181a(jArr).m10814a();
            C2368a a4 = C2369i.m11589a(c2369i).m11571a(a3);
            EngineUseState n = c2369i.m11615n();
            C2371k.m11632a(n, n, c2369i.m11620s(), a3, a4);
            return a4.m11584c();
        }
        throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
    }

    public static CanonicalOdometerSource m11479a(OdometerSource odometerSource) {
        switch (odometerSource) {
            case ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_INSTRUMENT_CLUSTER:
                return CanonicalOdometerSource.J1939_HR_SRC23;
            case ODOMETER_SOURCE_J1939_INSTRUMENT_CLUSTER:
                return CanonicalOdometerSource.J1939_SRC23;
            case ODOMETER_SOURCE_J1587_INSTRUMENT_CLUSTER:
                return CanonicalOdometerSource.J1587_MID140;
            case ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_ENGINE_1:
                return CanonicalOdometerSource.J1939_HR_SRC0;
            case ODOMETER_SOURCE_J1939_ENGINE_1:
                return CanonicalOdometerSource.J1939_SRC0;
            case ODOMETER_SOURCE_J1587_ENGINE_1:
                return CanonicalOdometerSource.J1587_MID128;
            case ODOMETER_SOURCE_J1587_VEHICLE_MANAGEMENT_SYSTEM:
                return CanonicalOdometerSource.J1587_MID142;
            case ODOMETER_SOURCE_J1939_HINO:
                return CanonicalOdometerSource.J1939_HINO_ODOMETER;
            case ODOMETER_SOURCE_DASHLINK_FIRMWARE:
                return CanonicalOdometerSource.DASHLINK_FIRMWARE;
            case ODOMETER_SOURCE_GENX_FW:
                return CanonicalOdometerSource.GENX_FW;
            case ODOMETER_SOURCE_GENX_ECM:
                return CanonicalOdometerSource.GENX_ECM;
            default:
                throw new IllegalArgumentException("Unhandled source " + odometerSource.toString());
        }
    }
}
