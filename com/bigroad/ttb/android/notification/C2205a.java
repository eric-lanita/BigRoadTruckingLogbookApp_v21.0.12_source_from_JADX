package com.bigroad.ttb.android.notification;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.support.v4.app.ad.C0137c;
import android.support.v4.app.ad.C0138d;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.activity.C1632a;
import com.bigroad.ttb.android.widget.C2462j;

class C2205a extends C2204d {
    private static C2205a f7640c;
    private Notification f7641d;

    public static C2205a m10890a(Context context) {
        if (f7640c == null) {
            f7640c = new C2205a(context);
        }
        return f7640c;
    }

    private C2205a(Context context) {
        super(context);
    }

    public void m10891a(DutyStatus dutyStatus) {
        long a = OurApplication.m6269Z().mo913a();
        String charSequence = C2462j.m12108a(this.b.getResources(), dutyStatus).toString();
        CharSequence string = this.b.getString(R.string.notification_autoDutyChangeTitle, new Object[]{charSequence});
        CharSequence string2 = this.b.getString(R.string.notification_autoDutyChangeContent, new Object[]{charSequence});
        this.f7641d = new C0138d(this.b).m626a((int) R.drawable.status_notification_icon).m636a(string).m642b(string2).m635a(new C0137c().m622c(string2)).m628a(a).m649d(string).m640b(3).m646c(true).m630a(PendingIntent.getActivity(this.b, 2, C1632a.m8005m(this.b), 0)).m639b();
        m10874a(2, this.f7641d);
    }
}
