package com.bigroad.shared;

import com.bigroad.ttb.protocol.TTProtocol.EventType;

public abstract class DutyStatusChangeBits {

    private enum DutyStatusValue {
        UNKNOWN,
        OFF_DUTY,
        SLEEPER,
        DRIVING,
        ON_DUTY_NOT_DRIVING,
        OFF_DUTY_WAITING,
        OFF_DUTY_DRIVING,
        ELD_YARD_MOVE
    }

    public enum Reason {
        UNKNOWN,
        OFF_DUTY_AND_SIGN_OUT,
        USER_SELECTED_DASHBOARD,
        USER_SELECTED_SUMMARY,
        USER_SELECTED_ADD,
        USER_SELECTED_EDIT,
        GPS_AUTO,
        GPS_AUTO_DIALOG,
        GPS_SELECTED_DIALOG,
        EOBR_AUTO,
        TRUCK_PICKED_WHILE_DRIVING,
        EOBR_AUTO_ENGINE_OFF,
        EOBR_AUTO_EVENT_UPDATE,
        EOBR_AUTO_STOP_TIMEOUT,
        CONVERSION_FROM_PSEUDO_EVENT,
        WEB_APP_ADD,
        WEB_APP_EDIT,
        MERGE_COPIED_EVENT,
        EOBR_YARD_MOVE_EXCEEDED,
        EOBR_AUTO_TRUCK_PICKED_WHILE_DRIVING,
        GPS_AUTO_EOBR_DISCONNECTED,
        EOBR_AUTO_SPEEDOMETER_TIMEOUT,
        EOBR_AUTO_DIALOG,
        EOBR_SELECTED_DIALOG,
        EOBR_DISCONNECTED,
        EOBR_DUTY_STATUS_SELECTED,
        EOBR_DRIVING_SPLIT
    }

    private static DutyStatusValue m4037a(EventType eventType) {
        if (eventType == null) {
            return DutyStatusValue.UNKNOWN;
        }
        switch (eventType) {
            case OFF_DUTY:
                return DutyStatusValue.OFF_DUTY;
            case SLEEPER:
                return DutyStatusValue.SLEEPER;
            case DRIVING:
                return DutyStatusValue.DRIVING;
            case ON_DUTY_NOT_DRIVING:
                return DutyStatusValue.ON_DUTY_NOT_DRIVING;
            case OFF_DUTY_WAITING:
                return DutyStatusValue.OFF_DUTY_WAITING;
            case OFF_DUTY_DRIVING:
                return DutyStatusValue.OFF_DUTY_DRIVING;
            case ELD_YARD_MOVE:
                return DutyStatusValue.ELD_YARD_MOVE;
            default:
                return DutyStatusValue.UNKNOWN;
        }
    }

    public static long m4033a(Reason reason) {
        if (reason == null) {
            reason = Reason.UNKNOWN;
        }
        return ((long) reason.ordinal()) & 31;
    }

    public static long m4034a(Reason reason, EventType eventType) {
        return m4036a(Long.valueOf(m4033a(reason)), eventType);
    }

    public static long m4036a(Long l, EventType eventType) {
        if (l == null) {
            l = Long.valueOf(0);
        }
        return l.longValue() | ((((long) m4037a(eventType).ordinal()) & 7) << 5);
    }

    public static long m4035a(Long l) {
        if (l == null) {
            l = Long.valueOf(0);
        }
        return l.longValue() | 256;
    }

    public static long m4038b(Long l) {
        if (l == null) {
            l = Long.valueOf(0);
        }
        return l.longValue() | 1152921504606846976L;
    }

    public static long m4039c(Long l) {
        if (l == null) {
            l = Long.valueOf(0);
        }
        return l.longValue() & 262143;
    }
}
