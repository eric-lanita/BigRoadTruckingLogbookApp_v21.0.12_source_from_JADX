package com.bigroad.ttb.android.notification;

import android.content.Context;
import com.bigroad.shared.duty.DutyStatus;

public class C2208c {
    private static C2208c f7648a;
    private final C2205a f7649b;
    private final C2212e f7650c;

    public static C2208c m10898a(Context context) {
        if (f7648a == null) {
            f7648a = new C2208c(context);
        }
        return f7648a;
    }

    private C2208c(Context context) {
        this.f7649b = C2205a.m10890a(context);
        this.f7650c = C2212e.m10906a(context);
        C2207b.m10894a(context);
        HosLocalNotificationManager.m10877a(context);
    }

    public void m10900a(DutyStatus dutyStatus) {
        this.f7649b.m10891a(dutyStatus);
    }

    public void m10899a() {
        this.f7649b.m10873a(2);
    }

    public void m10901a(boolean z) {
        this.f7650c.m10914a(z);
    }
}
