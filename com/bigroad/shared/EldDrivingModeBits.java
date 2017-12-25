package com.bigroad.shared;

import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.Event;

public class EldDrivingModeBits {

    public enum Mode {
        NORMAL_DRIVING,
        PERSONAL_CONVEYANCE,
        YARD_MOVE
    }

    public static long m4064a(ActiveDrivingMode activeDrivingMode) {
        return ((long) m4067b(activeDrivingMode).ordinal()) & 3;
    }

    public static Mode m4067b(ActiveDrivingMode activeDrivingMode) {
        if (activeDrivingMode == null) {
            return Mode.NORMAL_DRIVING;
        }
        switch (activeDrivingMode) {
            case ELD_YARD_MOVE_MODE:
                return Mode.YARD_MOVE;
            case PERSONAL_CONVEYANCE_MODE:
                return Mode.PERSONAL_CONVEYANCE;
            default:
                return Mode.NORMAL_DRIVING;
        }
    }

    public static Mode m4065a(long j) {
        int i = (int) (3 & j);
        if (i < 0 || i >= Mode.values().length) {
            return Mode.NORMAL_DRIVING;
        }
        return Mode.values()[i];
    }

    public static Mode m4066a(Event event) {
        if (event != null && event.getEventType() == 36 && event.hasContextualData()) {
            return m4065a(event.getContextualData());
        }
        return null;
    }
}
