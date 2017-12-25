package com.bigroad.ttb.android.util;

import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public abstract class C2307z {
    public static boolean m11276a(Truck truck, Fleet fleet) {
        return (truck != null && truck.getAllowClaim()) || (fleet != null && fleet.getAllowClaim());
    }

    public static Long m11277b(Truck truck, Fleet fleet) {
        Long l;
        Long l2 = null;
        if (truck == null || !truck.hasAllowClaimEffectiveAt()) {
            l = null;
        } else {
            l = Long.valueOf(truck.getAllowClaimEffectiveAt());
        }
        if (fleet != null && fleet.hasAllowClaimEffectiveAt()) {
            l2 = Long.valueOf(fleet.getAllowClaimEffectiveAt());
        }
        if (l == null) {
            return l2;
        }
        if (l2 == null) {
            return l;
        }
        return Long.valueOf(Math.min(l.longValue(), l2.longValue()));
    }
}
