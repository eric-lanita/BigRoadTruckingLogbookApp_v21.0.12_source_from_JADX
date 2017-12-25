package com.google.android.gms.analytics;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.internal.zzaj;

public final class AnalyticsReceiver extends BroadcastReceiver {
    private zzaj f10147a;

    private zzaj m16508a() {
        if (this.f10147a == null) {
            this.f10147a = new zzaj();
        }
        return this.f10147a;
    }

    public void onReceive(Context context, Intent intent) {
        m16508a().onReceive(context, intent);
    }
}
