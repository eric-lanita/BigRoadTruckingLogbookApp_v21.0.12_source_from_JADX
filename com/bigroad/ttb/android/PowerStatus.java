package com.bigroad.ttb.android;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.bigroad.shared.ad;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.logging.C2134e;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashSet;
import java.util.Set;

public class PowerStatus {
    private static PowerStatus f4140a;
    private static ap f4141b = OurApplication.m6269Z();
    private final Set<C1216a> f4142c = new HashSet();
    private PlugStatus f4143d = PlugStatus.UNPLUGGED;
    private ChargeStatus f4144e = ChargeStatus.UNKNOWN;
    private float f4145f = 0.0f;
    private long f4146g = 0;
    private String f4147h = null;
    private long f4148i = f4141b.mo915c();

    public enum ChargeStatus {
        UNKNOWN,
        NOT_CHARGING,
        CHARGING,
        DISCHARGING,
        FULL
    }

    public enum PlugStatus {
        UNPLUGGED,
        PLUGGED_AC,
        PLUGGED_USB,
        PLUGGED_AC_USB
    }

    public interface C1216a {
        void mo908a(PowerStatus powerStatus);
    }

    public static PowerStatus m6308a(Context context) {
        if (f4140a == null) {
            f4140a = new PowerStatus();
        }
        return f4140a;
    }

    private PowerStatus() {
    }

    public void m6311a(C1216a c1216a) {
        this.f4142c.add(c1216a);
    }

    public void m6314b(C1216a c1216a) {
        this.f4142c.remove(c1216a);
    }

    private void m6309d() {
        for (C1216a a : (C1216a[]) this.f4142c.toArray(new C1216a[this.f4142c.size()])) {
            a.mo908a(this);
        }
    }

    public boolean m6312a() {
        return this.f4143d == PlugStatus.PLUGGED_AC || this.f4143d == PlugStatus.PLUGGED_USB || this.f4143d == PlugStatus.PLUGGED_AC_USB || this.f4144e == ChargeStatus.CHARGING || this.f4144e == ChargeStatus.FULL;
    }

    public long m6313b() {
        if (m6312a()) {
            return 0;
        }
        long c = f4141b.mo915c();
        if (this.f4148i > c) {
            this.f4148i = c;
        }
        return c - this.f4148i;
    }

    public float m6315c() {
        return this.f4145f;
    }

    public void m6310a(Intent intent) {
        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null) {
                boolean a = m6312a();
                if (extras.containsKey("level") && extras.containsKey("scale")) {
                    this.f4145f = ((float) extras.getInt("level")) / ((float) Math.max(1, extras.getInt("scale")));
                    this.f4145f = ad.m4149a(0.0f, this.f4145f, 1.0f);
                }
                if (extras.containsKey("plugged")) {
                    switch (extras.getInt("plugged")) {
                        case 1:
                            this.f4143d = PlugStatus.PLUGGED_AC;
                            break;
                        case 2:
                            this.f4143d = PlugStatus.PLUGGED_USB;
                            break;
                        case 3:
                            this.f4143d = PlugStatus.PLUGGED_AC_USB;
                            break;
                        default:
                            this.f4143d = PlugStatus.UNPLUGGED;
                            break;
                    }
                }
                if (extras.containsKey(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                    switch (extras.getInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS)) {
                        case 2:
                            this.f4144e = ChargeStatus.CHARGING;
                            break;
                        case 3:
                            this.f4144e = ChargeStatus.DISCHARGING;
                            break;
                        case 4:
                            this.f4144e = ChargeStatus.NOT_CHARGING;
                            break;
                        case 5:
                            this.f4144e = ChargeStatus.FULL;
                            break;
                        default:
                            this.f4144e = ChargeStatus.UNKNOWN;
                            break;
                    }
                }
                if (a || m6312a()) {
                    this.f4148i = f4141b.mo915c();
                }
                long c = f4141b.mo915c();
                String str = "Battery level " + ((int) (this.f4145f * 100.0f)) + "%, " + this.f4143d + ", " + this.f4144e;
                if (this.f4146g + 60000 <= c || !str.equals(this.f4147h)) {
                    this.f4146g = c;
                    this.f4147h = str;
                    C2134e.m10676b("TT-PowerStatus", str);
                }
                m6309d();
            }
        }
    }
}
