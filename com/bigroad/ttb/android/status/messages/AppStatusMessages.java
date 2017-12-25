package com.bigroad.ttb.android.status.messages;

import android.content.Context;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.status.C2262f;
import com.bigroad.ttb.android.status.Type;

public enum AppStatusMessages implements C2262f {
    TRUCK_NOT_CREATED,
    OUT_OF_DATE;

    public Type mo1264a() {
        return Type.APP_WARNING;
    }

    public String mo1265c(Context context) {
        switch (this) {
            case TRUCK_NOT_CREATED:
                return context.getString(R.string.notice_truckNotCreated, new Object[]{OurApplication.m6294p().m6586j()});
            case OUT_OF_DATE:
                return context.getString(R.string.notice_newVersionAvailable);
            default:
                return null;
        }
    }

    public String mo1266d(Context context) {
        return null;
    }
}
