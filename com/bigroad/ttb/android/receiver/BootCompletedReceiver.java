package com.bigroad.ttb.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.logging.C2134e;

public class BootCompletedReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        C2134e.m10676b("TT-BootReceiver", "Boot completed");
        OurApplication.m6262S().m6105e();
        OurApplication.m6247D();
    }
}
