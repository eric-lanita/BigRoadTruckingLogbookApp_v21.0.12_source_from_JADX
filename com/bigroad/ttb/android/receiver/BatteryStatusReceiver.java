package com.bigroad.ttb.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;

public class BatteryStatusReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            String a = am.m4185a(intent.getAction());
            if ("android.intent.action.ACTION_POWER_CONNECTED".equals(a)) {
                C2134e.m10676b("TT-BatteryStat", "Power connected");
            } else if ("android.intent.action.ACTION_POWER_DISCONNECTED".equals(a)) {
                C2134e.m10676b("TT-BatteryStat", "Power disconnected");
            } else if ("android.intent.action.BATTERY_CHANGED".equals(a)) {
                OurApplication.m6286h().m6310a(intent);
            } else if ("android.intent.action.BATTERY_LOW".equals(a)) {
                C2134e.m10676b("TT-BatteryStat", "Battery low");
            } else if ("android.intent.action.BATTERY_OKAY".equals(a)) {
                C2134e.m10676b("TT-BatteryStat", "Battery OK");
            } else {
                C2134e.m10680d("TT-BatteryStat", "Ignoring unexpected action: " + a);
            }
        }
    }
}
