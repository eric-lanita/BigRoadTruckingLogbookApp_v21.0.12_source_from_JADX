package com.bigroad.ttb.android.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.CampaignTrackingReceiver;

public class InstallReferrerReceiver extends BroadcastReceiver {
    public void onReceive(Context context, Intent intent) {
        new CampaignTrackingReceiver().onReceive(context, intent);
    }
}
