package com.bigroad.shared.model;

import com.bigroad.shared.C1130o;
import com.bigroad.shared.EventStatusMaskBits;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeLocation;

public class C1127k {
    public static String m5706a(RelativeLocation relativeLocation) {
        if (relativeLocation == null) {
            return null;
        }
        CanonicalOdometerUnit canonicalOdometerUnit = CanonicalOdometerUnit.MILES;
        return Math.round(canonicalOdometerUnit.m5471b(relativeLocation.getDistanceMeters())) + " " + canonicalOdometerUnit.m5470a() + " " + relativeLocation.getCardinalDirection() + " " + relativeLocation.getName() + ", " + relativeLocation.getStateCode();
    }

    public static String m5705a(Event event) {
        return event.hasLocationName() ? event.getLocationName() : null;
    }

    public static String m5707b(Event event) {
        if (!C1130o.m5712a(event)) {
            return C1127k.m5705a(event);
        }
        if (event.hasRelativeLocation()) {
            return C1127k.m5706a(event.getRelativeLocation());
        }
        if (!event.hasStatusMask() || (!EventStatusMaskBits.m4083d(event.getStatusMask()) && EventStatusMaskBits.m4082c(event.getStatusMask()))) {
            return null;
        }
        return C1127k.m5705a(event);
    }
}
