package com.bigroad.ttb.android.status.messages;

import android.content.Context;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.aobrd.MalfunctionReason;
import com.bigroad.ttb.android.status.C2266c;
import com.bigroad.ttb.android.status.Type;

public enum MalfunctionMessages implements C2266c {
    NO_ODOMETER_READINGS(MalfunctionReason.NO_ODOMETER_READINGS, R.string.dashLink_dashLinkNoOdometerReadingsMessage, R.string.dashLink_dashLinkNoOdometerReadingsExplanation),
    UNCALIBRATED_ODOMETER(MalfunctionReason.UNCALIBRATED_ODOMETER, R.string.dashLink_dashLinkUncalibratedOdometerMessage, R.string.dashLink_dashLinkUncalibratedOdometerExplanation),
    SLOW_ODOMETER(MalfunctionReason.SENSOR_FAILURE_ODOMETER_SLOW, R.string.dashLink_dashLinkOdometerSlowMessage, R.string.dashLink_dashLinkOdometerSlowExplanation),
    FAST_ODOMETER(MalfunctionReason.SENSOR_FAILURE_ODOMETER_FAST, R.string.dashLink_dashLinkOdometerFastMessage, R.string.dashLink_dashLinkOdometerFastExplanation),
    MISSING_ROAD_SPEED(MalfunctionReason.MISSING_ROAD_SPEED_DATA, R.string.dashLink_dashLinkMissingRoadspeedMessage, R.string.dashLink_dashLinkMissingRoadspeedExplanation),
    DUTY_STATUS_CONFLICT(MalfunctionReason.DUTY_STATUS_CONFLICT, R.string.dashLink_customTitle_dutyStatusConflictMessage, R.string.dashLink_dutyStatusConflictExplanation),
    GENX_LOST_ECM(MalfunctionReason.GENX_LOST_ECM, R.string.dashLink_customTitle_genxLostEcmMessage, R.string.dashLink_genxLostEcmExplanation);
    
    private final int m_bannerMessageId;
    private final int m_explanationTextId;
    private final MalfunctionReason m_reason;

    private MalfunctionMessages(MalfunctionReason malfunctionReason, int i, int i2) {
        this.m_reason = malfunctionReason;
        this.m_bannerMessageId = i;
        this.m_explanationTextId = i2;
    }

    public Type mo1264a() {
        return Type.DASHLINK_ERROR;
    }

    public String mo1265c(Context context) {
        return context.getString(this.m_bannerMessageId);
    }

    public String mo1266d(Context context) {
        return mo1265c(context);
    }

    public MalfunctionReason m11127b() {
        return this.m_reason;
    }

    public String mo1269a(Context context) {
        return context.getString(this.m_explanationTextId);
    }

    public static C2266c m11124a(MalfunctionReason malfunctionReason) {
        for (C2266c c2266c : values()) {
            if (c2266c.m11127b() == malfunctionReason) {
                return c2266c;
            }
        }
        return null;
    }
}
