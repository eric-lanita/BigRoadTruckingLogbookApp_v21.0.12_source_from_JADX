package com.bigroad.ttb.android;

import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Set;

public abstract class C2188n {
    public static final Set<ActiveDrivingMode> f7581a = Collections.unmodifiableSet(EnumSet.of(ActiveDrivingMode.AOBRD_YARD_MOVE_MODE, ActiveDrivingMode.ELD_YARD_MOVE_MODE));
    private static final Set<EventType> f7582b = Collections.unmodifiableSet(EnumSet.of(EventType.OFF_DUTY, EventType.SLEEPER));
    private static final Set<DutyStatus> f7583c = Collections.unmodifiableSet(EnumSet.of(DutyStatus.OFF_DUTY_DRIVING, DutyStatus.OFF_DUTY));
    private static final Set<DutyStatus> f7584d = Collections.unmodifiableSet(EnumSet.of(DutyStatus.ELD_YARD_MOVE, DutyStatus.ON_DUTY_NOT_DRIVING));

    public static boolean m10840a(ActiveDrivingMode activeDrivingMode) {
        return activeDrivingMode != null && f7581a.contains(activeDrivingMode);
    }

    public static ActiveDrivingMode m10839a(DutyStatus dutyStatus, ActiveDrivingMode activeDrivingMode) {
        ActiveDrivingMode activeDrivingMode2;
        if (activeDrivingMode == null) {
            activeDrivingMode2 = ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE;
        } else {
            activeDrivingMode2 = activeDrivingMode;
        }
        if (dutyStatus == null) {
            return activeDrivingMode2;
        }
        switch (dutyStatus) {
            case OFF_DUTY_DRIVING:
                return ActiveDrivingMode.PERSONAL_CONVEYANCE_MODE;
            case ELD_YARD_MOVE:
                return ActiveDrivingMode.ELD_YARD_MOVE_MODE;
            default:
                switch (activeDrivingMode2) {
                    case PERSONAL_CONVEYANCE_MODE:
                        if (f7583c.contains(dutyStatus)) {
                            return activeDrivingMode2;
                        }
                        return ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE;
                    case ELD_YARD_MOVE_MODE:
                        if (f7584d.contains(dutyStatus)) {
                            return activeDrivingMode2;
                        }
                        return ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE;
                    case UNKNOWN_NO_OP_DRIVING_MODE:
                        return ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE;
                    case AOBRD_YARD_MOVE_MODE:
                        return activeDrivingMode2;
                    case NORMAL_DRIVING_MODE:
                        if (C2188n.m10841a(dutyStatus.m4392a())) {
                            return ActiveDrivingMode.UNSPECIFIED_DRIVING_MODE;
                        }
                        return activeDrivingMode2;
                    case UNSPECIFIED_DRIVING_MODE:
                        if (C2188n.m10841a(dutyStatus.m4392a()) || dutyStatus == DutyStatus.DRIVING) {
                            return activeDrivingMode2;
                        }
                        return ActiveDrivingMode.NORMAL_DRIVING_MODE;
                    default:
                        return activeDrivingMode2;
                }
        }
    }

    public static boolean m10841a(EventType eventType) {
        return f7582b.contains(eventType);
    }
}
