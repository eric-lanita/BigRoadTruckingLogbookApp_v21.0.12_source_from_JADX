package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.analytics.CampaignTrackingReceiver;
import com.google.android.gms.analytics.CampaignTrackingService;

public final class InstallReferrerReceiver extends CampaignTrackingReceiver {
    protected Class<? extends CampaignTrackingService> mo2426a() {
        return InstallReferrerService.class;
    }

    protected void mo2427a(Context context, String str) {
        zzbe.zzow(str);
        zzbe.m18097a(context, str);
    }
}
