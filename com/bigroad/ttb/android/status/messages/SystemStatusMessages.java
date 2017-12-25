package com.bigroad.ttb.android.status.messages;

import android.content.Context;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.status.C2262f;
import com.bigroad.ttb.android.status.Type;

public enum SystemStatusMessages implements C2262f {
    CLOCK_SKEW;

    public Type mo1264a() {
        return Type.SYSTEM_WARNING;
    }

    public String mo1265c(Context context) {
        switch (this) {
            case CLOCK_SKEW:
                return context.getString(R.string.customTitle_clockSkewed);
            default:
                return null;
        }
    }

    public String mo1266d(Context context) {
        return null;
    }
}
