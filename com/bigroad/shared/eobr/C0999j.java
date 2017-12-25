package com.bigroad.shared.eobr;

public abstract class C0999j {
    public static String m5112a(short s) {
        switch (s) {
            case (short) 268:
                return "ENGINE_RPM_REQUEST";
            case (short) 269:
                return "VEHICLE_SPEED_REQUEST";
            case (short) 287:
                return "ENGINE_RUN_TIME_REQUEST";
            case (short) 2306:
                return "VEHICLE_IDENTIFICATION_NUMBER_REQUEST";
            case (short) 16652:
                return "ENGINE_RPM_RESPONSE";
            case (short) 16653:
                return "VEHICLE_SPEED_RESPONSE";
            case (short) 16671:
                return "ENGINE_RUN_TIME_RESPONSE";
            case (short) 18690:
                return "VEHICLE_IDENTIFICATION_NUMBER_RESPONSE";
            default:
                return "PID_" + s;
        }
    }
}
