package com.bigroad.ttb.android.util;

import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;

public class UIBehaviourUtils {

    public enum ManualDutySelectionResponse {
        ALLOWED,
        DRIVE_TIME_MANAGED_BY_EOBR
    }

    public static ManualDutySelectionResponse m11152a(DailyLog dailyLog, C2032f c2032f) {
        if (OurApplication.m6252I().m11413k()) {
            return ManualDutySelectionResponse.DRIVE_TIME_MANAGED_BY_EOBR;
        }
        return ManualDutySelectionResponse.ALLOWED;
    }
}
