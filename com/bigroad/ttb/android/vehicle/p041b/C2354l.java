package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification.C2811a;

public abstract class C2354l {
    public static C2369i m11484a(C2369i c2369i, C2348f c2348f, C2032f c2032f) {
        C1016p a = c2348f.m11466a();
        if (a instanceof C1037t) {
            return C2354l.m11483a(C2369i.m11589a(c2369i), ((C1037t) a).f3284a, c2032f).m11584c();
        }
        throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
    }

    static C2368a m11483a(C2368a c2368a, String str, C2032f c2032f) {
        C2134e.m10678c("TT-VinLEC", "Found VIN: " + str);
        Truck f = c2032f.mo1300h().m6579f(str);
        if (f != null) {
            C2134e.m10678c("TT-VinLEC", "VIN matches truck: " + f.getTruckId() + " (" + f.getTruckNumber() + ")");
            C2811a newBuilder = VehicleIdentification.newBuilder(c2368a.m11579a());
            newBuilder.m15899a(f.getTruckId());
            newBuilder.m15903a(str);
            c2368a.m11576a(newBuilder.m15907c());
        } else if (c2368a.m11579a().hasTruckId()) {
            C2134e.m10680d("TT-VinLEC", "VIN " + str + " not found, but vehicleState already associated with truck " + c2368a.m11579a().getTruckId());
        }
        return c2368a;
    }
}
