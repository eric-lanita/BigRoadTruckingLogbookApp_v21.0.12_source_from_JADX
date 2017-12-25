package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets;
import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets.C2710a;

public class C2352i {
    public static C2369i m11481a(C2369i c2369i, C2348f c2348f) {
        C1016p a = c2348f.m11466a();
        if (a instanceof C1029i) {
            C1029i c1029i = (C1029i) a;
            if (c1029i.f3266c.length != c1029i.f3265b.length) {
                throw new IllegalArgumentException("Mismatched arrays " + c1029i.f3265b.length + " - " + c1029i.f3266c.length);
            } else if (c1029i.f3264a != c2369i.m11600b().getTruckId()) {
                C2134e.m10680d("TT-OdometerCalibrationLEC", "Ignoring calibration information for mismatch truckId. State: " + c2369i.m11600b().getTruckId() + " " + c1029i.toString());
                return c2369i;
            } else {
                C2710a newBuilder = OdometerOffsets.newBuilder();
                for (int i = 0; i < c1029i.f3266c.length; i++) {
                    if (c1029i.f3266c[i]) {
                        if (i == OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_INSTRUMENT_CLUSTER.ordinal()) {
                            newBuilder.m14595d(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1939_INSTRUMENT_CLUSTER.ordinal()) {
                            newBuilder.m14592c(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1587_INSTRUMENT_CLUSTER.ordinal()) {
                            newBuilder.m14597e(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_ENGINE_1.ordinal()) {
                            newBuilder.m14590b(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1939_ENGINE_1.ordinal()) {
                            newBuilder.m14586a(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1587_ENGINE_1.ordinal()) {
                            newBuilder.m14598f(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1587_VEHICLE_MANAGEMENT_SYSTEM.ordinal()) {
                            newBuilder.m14600g(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_J1939_HINO.ordinal()) {
                            newBuilder.m14604i(c1029i.f3265b[i]);
                        } else if (i == OdometerSource.ODOMETER_SOURCE_DASHLINK_FIRMWARE.ordinal()) {
                            newBuilder.m14602h(c1029i.f3265b[i]);
                        } else {
                            C2134e.m10680d("TT-OdometerCalibrationLEC", "Ignoring unhandled calibration data for source " + i);
                        }
                    }
                }
                return C2369i.m11589a(c2369i).m11575a(newBuilder.m14593c()).m11584c();
            }
        }
        throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
    }
}
