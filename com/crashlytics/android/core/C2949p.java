package com.crashlytics.android.core;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.facebook.internal.AnalyticsEvents;
import java.util.concurrent.atomic.AtomicBoolean;

class C2949p {
    private static final IntentFilter f10085a = new IntentFilter("android.intent.action.BATTERY_CHANGED");
    private static final IntentFilter f10086b = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
    private static final IntentFilter f10087c = new IntentFilter("android.intent.action.ACTION_POWER_DISCONNECTED");
    private final AtomicBoolean f10088d;
    private final Context f10089e;
    private final BroadcastReceiver f10090f;
    private final BroadcastReceiver f10091g;
    private boolean f10092h;

    class C29471 extends BroadcastReceiver {
        final /* synthetic */ C2949p f10083a;

        C29471(C2949p c2949p) {
            this.f10083a = c2949p;
        }

        public void onReceive(Context context, Intent intent) {
            this.f10083a.f10092h = true;
        }
    }

    class C29482 extends BroadcastReceiver {
        final /* synthetic */ C2949p f10084a;

        C29482(C2949p c2949p) {
            this.f10084a = c2949p;
        }

        public void onReceive(Context context, Intent intent) {
            this.f10084a.f10092h = false;
        }
    }

    public C2949p(Context context) {
        int i = -1;
        this.f10089e = context;
        Intent registerReceiver = context.registerReceiver(null, f10085a);
        if (registerReceiver != null) {
            i = registerReceiver.getIntExtra(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1);
        }
        boolean z = i == 2 || i == 5;
        this.f10092h = z;
        this.f10091g = new C29471(this);
        this.f10090f = new C29482(this);
        context.registerReceiver(this.f10091g, f10086b);
        context.registerReceiver(this.f10090f, f10087c);
        this.f10088d = new AtomicBoolean(true);
    }

    public boolean m16430a() {
        return this.f10092h;
    }

    public void m16431b() {
        if (this.f10088d.getAndSet(false)) {
            this.f10089e.unregisterReceiver(this.f10091g);
            this.f10089e.unregisterReceiver(this.f10090f);
        }
    }
}
