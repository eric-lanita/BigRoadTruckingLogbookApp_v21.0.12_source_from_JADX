package com.urbanairship;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.C0265i;

public class C3766c extends C3680a {
    private final C3796l f13533a;
    private final Context f13534b;
    private BroadcastReceiver f13535c = new C37621(this);

    class C37621 extends BroadcastReceiver {
        final /* synthetic */ C3766c f13523a;

        C37621(C3766c c3766c) {
            this.f13523a = c3766c;
        }

        public void onReceive(Context context, Intent intent) {
            this.f13523a.f13533a.m19818b("com.urbanairship.application.metrics.LAST_OPEN", System.currentTimeMillis());
        }
    }

    C3766c(Context context, C3796l c3796l) {
        this.f13533a = c3796l;
        this.f13534b = context.getApplicationContext();
    }

    protected void mo2777a() {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.urbanairship.analytics.APP_FOREGROUND");
        C0265i.m1105a(this.f13534b).m1109a(this.f13535c, intentFilter);
    }

    public long m19676b() {
        return this.f13533a.m19808a("com.urbanairship.application.metrics.LAST_OPEN", -1);
    }
}
