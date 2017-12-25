package com.bigroad.ttb.android.util;

import android.location.Location;
import com.bigroad.shared.as;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;

public class C2290j {
    private static final float f7931a = as.m4241a(20.0f);
    private static final float f7932b = as.m4241a(15.0f);

    private static MotionType m11216a(double d) {
        if (d < 0.0d) {
            return MotionType.UNKNOWN_MOTION_TYPE;
        }
        if (d >= ((double) f7931a)) {
            return MotionType.MOVING;
        }
        if (d <= ((double) f7932b)) {
            return MotionType.STOPPED;
        }
        return MotionType.UNKNOWN_MOTION_TYPE;
    }

    public static MotionType m11217a(Location location) {
        if (location == null || !location.hasSpeed()) {
            return MotionType.UNKNOWN_MOTION_TYPE;
        }
        return C2290j.m11216a((double) location.getSpeed());
    }

    public static MotionType m11218a(Breadcrumb breadcrumb) {
        if (breadcrumb == null) {
            return MotionType.UNKNOWN_MOTION_TYPE;
        }
        if (breadcrumb.hasSpeedE2()) {
            return C2290j.m11216a(((double) breadcrumb.getSpeedE2()) / 100.0d);
        }
        return MotionType.UNKNOWN_MOTION_TYPE;
    }
}
