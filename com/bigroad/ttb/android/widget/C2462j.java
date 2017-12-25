package com.bigroad.ttb.android.widget;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.widget.TextView;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.TimeWindow;
import com.bigroad.shared.duty.TimeWindow.Condition;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;

public abstract class C2462j {
    public static void m12110a(Resources resources, TextView textView, TimeWindow timeWindow) {
        textView.setTextColor(C2462j.m12107a(resources, timeWindow.mo727a()));
    }

    public static ColorStateList m12107a(Resources resources, Condition condition) {
        switch (condition) {
            case FINE:
                return resources.getColorStateList(R.color.duty_status_fine);
            case WARN:
                return resources.getColorStateList(R.color.duty_status_warn);
            case BAD:
                return resources.getColorStateList(R.color.duty_status_bad);
            default:
                return null;
        }
    }

    public static int m12106a(Condition condition) {
        switch (condition) {
            case FINE:
                return 2;
            case BAD:
                return 0;
            default:
                return 1;
        }
    }

    public static CharSequence m12108a(Resources resources, DutyStatus dutyStatus) {
        switch (dutyStatus) {
            case OFF_DUTY_DRIVING:
                return resources.getString(R.string.dutyStatus_offDuty);
            case ELD_YARD_MOVE:
                return resources.getString(R.string.dutyStatus_notDriving);
            default:
                return C2462j.m12111b(resources, dutyStatus);
        }
    }

    public static CharSequence m12111b(Resources resources, DutyStatus dutyStatus) {
        switch (dutyStatus) {
            case OFF_DUTY_DRIVING:
                return resources.getString(R.string.dutyStatus_offDutyDriving);
            case ELD_YARD_MOVE:
                return resources.getString(R.string.dutyStatus_yardMoveDriving);
            case DRIVING:
                return resources.getString(R.string.dutyStatus_driving);
            case ON_DUTY_NOT_DRIVING:
                return resources.getString(R.string.dutyStatus_notDriving);
            case SLEEPER:
                return resources.getString(R.string.dutyStatus_sleeper);
            case OFF_DUTY:
                return resources.getString(R.string.dutyStatus_offDuty);
            case OFF_DUTY_WAITING:
                return resources.getString(R.string.dutyStatus_offDutyWaiting);
            default:
                return null;
        }
    }

    public static CharSequence m12109a(Resources resources, Event event) {
        switch (EventType.m13979a(event.getEventType())) {
            case INTERMEDIATE_DRIVING:
                return resources.getString(R.string.eventType_intermediateDriving);
            case ENGINE_ON:
                return resources.getString(R.string.eventType_engineOn);
            case ENGINE_OFF:
                return resources.getString(R.string.eventType_engineOff);
            case DRIVER_LOGIN:
                return resources.getString(R.string.eventType_driverLogin);
            case DRIVER_LOGOUT:
                return resources.getString(R.string.eventType_driverLogout);
            case ELD_DRIVING_MODE:
                return resources.getString(R.string.eventType_eldDrivingMode);
            default:
                return null;
        }
    }
}
