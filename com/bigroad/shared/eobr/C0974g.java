package com.bigroad.shared.eobr;

import com.facebook.internal.FacebookRequestErrorClassification;

public abstract class C0974g {
    public static String m4979a(int i) {
        switch (i) {
            case 49:
                return "ABS_CONTROL_STATUS";
            case 61:
                return "PARKING_BRAKE_ACTUATOR_STATUS";
            case 70:
                return "PARKING_BRAKE_SWITCH_STATUS";
            case 84:
                return "ROAD_SPEED";
            case 92:
                return "PERCENT_ENGINE_LOAD";
            case 151:
                return "ATC_CONTROL_STATUS";
            case 168:
                return "BATTERY_POTENTIAL";
            case FacebookRequestErrorClassification.EC_INVALID_TOKEN /*190*/:
                return "ENGINE_SPEED";
            case 237:
                return "VEHICLE_IDENTIFICATION_NUMBER";
            case 243:
                return "COMPONENT_IDENTIFICATION";
            case 245:
                return "TOTAL_VEHICLE_DISTANCE";
            case 247:
                return "TOTAL_ENGINE_HOURS";
            default:
                return "PID_" + i;
        }
    }
}
