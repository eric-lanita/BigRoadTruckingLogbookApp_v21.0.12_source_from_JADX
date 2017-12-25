package com.bigroad.shared;

import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;

public abstract class DrivingModeChangeBits {

    public enum Reason {
        UNKNOWN,
        MANAGER_INIT,
        USER_SIGN_OUT,
        USER_SIGN_OUT_AND_OFF_DUTY,
        EVENT_LIST_CHANGED,
        GPS_AUTO,
        USER_SELECTED_DASHBOARD,
        USER_SELECTED_SUMMARY,
        EOBR_SELECTED_DIALOG,
        EOBR_AUTO_DIALOG,
        EOBR_WRITE_FAILED,
        VEHICLE_STATE_CHANGED,
        YARD_MOVE_DISTANCE_EXCEEDED,
        YARD_MOVE_USER_ENDED,
        ACTIVE_TRUCK_CHANGED,
        EOBR_CONFIRM_NON_SPECIAL,
        MODAL_YARD_MOVE_MAINTAINED,
        AOBRD_PERSIST_PERSONAL_USE
    }

    public static long m4031a(Reason reason, ActiveDrivingMode activeDrivingMode) {
        if (reason == null) {
            reason = Reason.UNKNOWN;
        }
        if (activeDrivingMode == null) {
            activeDrivingMode = ActiveDrivingMode.UNKNOWN_NO_OP_DRIVING_MODE;
        }
        return (((long) reason.ordinal()) & 31) | (((long) (activeDrivingMode.ordinal() << 5)) & 224);
    }

    public static boolean m4032a(Reason reason) {
        switch (reason) {
            case USER_SIGN_OUT:
            case USER_SIGN_OUT_AND_OFF_DUTY:
                return true;
            default:
                return false;
        }
    }
}
