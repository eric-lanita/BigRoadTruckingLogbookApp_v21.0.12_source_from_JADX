package com.bigroad.ttb.android.notification;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.p030a.C1257b;

class C2204d {
    protected final NotificationManager f7620a;
    protected final Context f7621b;

    protected C2204d(Context context) {
        this.f7620a = (NotificationManager) context.getSystemService("notification");
        this.f7621b = context;
    }

    protected void m10874a(int i, Notification notification) {
        C1257b.m6612a(notification, this.f7621b.getResources().getColor(R.color.brand));
        this.f7620a.notify(i, notification);
    }

    protected void m10873a(int i) {
        this.f7620a.cancel(i);
    }
}
