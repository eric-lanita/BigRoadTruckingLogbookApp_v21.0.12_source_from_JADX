package com.bigroad.ttb.android;

import android.content.Context;
import com.bigroad.shared.duty.DutyStatus;

public abstract class C2224p {
    public static String m10958a(Context context, DutyStatus dutyStatus) {
        switch (dutyStatus) {
            case OFF_DUTY:
                return context.getString(R.string.dutyStatus.offDuty.abbreviation);
            case SLEEPER:
                return context.getString(R.string.dutyStatus.sleeper.abbreviation);
            case DRIVING:
                return context.getString(R.string.dutyStatus.driving.abbreviation);
            case ON_DUTY_NOT_DRIVING:
                return context.getString(R.string.dutyStatus.onDuty.abbreviation);
            case OFF_DUTY_WAITING:
                return context.getString(R.string.dutyStatus.offDutyWaiting.abbreviation);
            case OFF_DUTY_DRIVING:
                return context.getString(R.string.dutyStatus.offDutyDriving.abbreviation);
            default:
                return dutyStatus.toString();
        }
    }

    public static String m10959b(Context context, DutyStatus dutyStatus) {
        switch (dutyStatus) {
            case OFF_DUTY:
                return context.getString(R.string.dutyStatus.offDuty.title);
            case SLEEPER:
                return context.getString(R.string.dutyStatus.sleeper.title);
            case DRIVING:
                return context.getString(R.string.dutyStatus.driving.title);
            case ON_DUTY_NOT_DRIVING:
                return context.getString(R.string.dutyStatus.onDuty.title);
            case OFF_DUTY_WAITING:
                return context.getString(R.string.dutyStatus.offDutyWaiting.title);
            case OFF_DUTY_DRIVING:
                return context.getString(R.string.dutyStatus.offDutyDriving.title);
            default:
                return dutyStatus.toString();
        }
    }

    public static String m10960c(Context context, DutyStatus dutyStatus) {
        switch (dutyStatus) {
            case OFF_DUTY:
                return context.getString(R.string.dutyStatus.offDuty.longName);
            case SLEEPER:
                return context.getString(R.string.dutyStatus.sleeper.longName);
            case DRIVING:
                return context.getString(R.string.dutyStatus.driving.longName);
            case ON_DUTY_NOT_DRIVING:
                return context.getString(R.string.dutyStatus.onDuty.longName);
            case OFF_DUTY_WAITING:
                return context.getString(R.string.dutyStatus.offDutyWaiting.longName);
            case OFF_DUTY_DRIVING:
                return context.getString(R.string.dutyStatus.offDutyDriving.longName);
            default:
                return dutyStatus.toString();
        }
    }
}
