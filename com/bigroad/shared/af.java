package com.bigroad.shared;

import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public abstract class af {
    public static OdometerUnit m4151a(Truck truck) {
        OdometerUnit odometerUnit = OdometerUnit.MILES;
        if (truck != null && truck.hasOdometerUnit()) {
            OdometerUnit a = OdometerUnit.m14668a(truck.getOdometerUnit());
            if (!(a == null || a == OdometerUnit.UNKNOWN_UNIT)) {
                return a;
            }
        }
        return odometerUnit;
    }

    public static double m4150a(double d, OdometerUnit odometerUnit, OdometerUnit odometerUnit2) {
        if (odometerUnit == null || odometerUnit2 == null || odometerUnit.equals(odometerUnit2)) {
            return d;
        }
        if (odometerUnit == OdometerUnit.KM && odometerUnit2 == OdometerUnit.MILES) {
            return as.m4246e(d);
        }
        if (odometerUnit == OdometerUnit.MILES && odometerUnit2 == OdometerUnit.KM) {
            return as.m4243b(d);
        }
        return d;
    }

    public static String m4153a(OdometerUnit odometerUnit) {
        CanonicalOdometerUnit a = CanonicalOdometerUnit.m5466a(odometerUnit);
        return a == null ? null : a.m5470a();
    }

    public static String m4152a(long j, OdometerUnit odometerUnit) {
        CanonicalOdometerUnit a = CanonicalOdometerUnit.m5466a(odometerUnit);
        return a == null ? null : a.m5473c(j);
    }

    public static String m4154a(String str, OdometerUnit odometerUnit) {
        if (am.m4188a((CharSequence) str) || odometerUnit == OdometerUnit.UNKNOWN_UNIT) {
            return str;
        }
        String a = m4153a(odometerUnit);
        return a != null ? str + " " + a : str;
    }
}
