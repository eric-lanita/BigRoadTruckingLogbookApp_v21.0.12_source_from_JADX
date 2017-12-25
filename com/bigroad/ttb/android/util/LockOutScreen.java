package com.bigroad.ttb.android.util;

import android.content.Context;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.DashboardActivity;
import com.bigroad.ttb.android.activity.HosSummaryActivity;

public enum LockOutScreen {
    MAIN_DASHBOARD(R.string.lock_out_screen_option_main_dashboard, DashboardActivity.class),
    HOURS_OF_SERVICE(R.string.lock_out_screen_option_hours_of_service, HosSummaryActivity.class);
    
    private Class m_lockOutScreenClass;
    private int m_lockOutScreenName;

    private LockOutScreen(int i, Class cls) {
        this.m_lockOutScreenName = i;
        this.m_lockOutScreenClass = cls;
    }

    private String m11141a(Context context) {
        return context.getResources().getString(this.m_lockOutScreenName);
    }

    private Class m11139a() {
        return this.m_lockOutScreenClass;
    }

    public static Class m11140a(String str, Context context) {
        for (LockOutScreen lockOutScreen : values()) {
            if (lockOutScreen.m11141a(context).equals(str)) {
                return lockOutScreen.m11139a();
            }
        }
        return MAIN_DASHBOARD.m11139a();
    }
}
