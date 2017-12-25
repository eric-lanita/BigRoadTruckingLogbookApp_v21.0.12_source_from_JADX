package com.bigroad.ttb.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bigroad.ttb.android.OurApplication;

public class TimeChangeReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        if (intent != null) {
            OurApplication.m6262S().m6101a(intent.getStringExtra("time-zone"));
        }
    }
}
