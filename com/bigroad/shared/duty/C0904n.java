package com.bigroad.shared.duty;

import com.bigroad.ttb.protocol.TTProtocol.Event;

public class C0904n {

    static /* synthetic */ class C09031 {
        static final /* synthetic */ int[] f2795a = new int[DutyCycle.values().length];

        static {
            f2796b = new int[DutyStatus.values().length];
            try {
                f2796b[DutyStatus.SLEEPER.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                f2796b[DutyStatus.OFF_DUTY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_US_7DAY.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_ALASKAN_7DAY.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_TEXAS_7DAY.ordinal()] = 3;
            } catch (NoSuchFieldError e5) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_US_8DAY.ordinal()] = 4;
            } catch (NoSuchFieldError e6) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_ALASKAN_8DAY.ordinal()] = 5;
            } catch (NoSuchFieldError e7) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_CALIFORNIA_8DAY.ordinal()] = 6;
            } catch (NoSuchFieldError e8) {
            }
            try {
                f2795a[DutyCycle.DUTY_CYCLE_CALIFORNIA_8DAY_FARM.ordinal()] = 7;
            } catch (NoSuchFieldError e9) {
            }
        }
    }

    public static DutyStatus m4576a(C0898i c0898i) {
        DutyStatus dutyStatus = DutyStatus.OFF_DUTY;
        if (c0898i.m4553b().isEmpty()) {
            return dutyStatus;
        }
        return DutyStatus.m4383a(((Event) c0898i.m4553b().get(c0898i.m4553b().size() - 1)).getEventType());
    }

    public static boolean m4577a(DutyStatus dutyStatus, DutyStatus dutyStatus2) {
        switch (dutyStatus) {
            case SLEEPER:
                if (dutyStatus2 == DutyStatus.SLEEPER) {
                    return true;
                }
                return false;
            case OFF_DUTY:
                return dutyStatus2.m4396d();
            default:
                return false;
        }
    }
}
