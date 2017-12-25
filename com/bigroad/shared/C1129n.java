package com.bigroad.shared;

import com.bigroad.shared.duty.DutyStatus;

public abstract class C1129n {
    public static boolean m5708a(DutyStatus dutyStatus) {
        switch (dutyStatus) {
            case OFF_DUTY:
            case SLEEPER:
            case DRIVING:
            case ON_DUTY_NOT_DRIVING:
            case OFF_DUTY_WAITING:
            case OFF_DUTY_DRIVING:
                return true;
            default:
                return false;
        }
    }
}
