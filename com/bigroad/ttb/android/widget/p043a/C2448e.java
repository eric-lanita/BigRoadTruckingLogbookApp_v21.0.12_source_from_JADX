package com.bigroad.ttb.android.widget.p043a;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import com.bigroad.ttb.android.OurApplication;

public class C2448e {
    public static final C2446d f8701a = new C2446d("Maps", "Google", "com.google.android.apps.maps", "com.google.android.maps.driveabout.app.NavigationActivity");
    public static final C2446d f8702b = new C2446d("SmartTruckRoute", "Teletype", "com.teletype.smarttruckroute");
    public static final C2446d f8703c = new C2446d("CAT Scale", "Boomerco", "com.ieveryware.catscale");
    public static final C2446d f8704d = new C2446d("LongHaul", "LongHaul", null);
    public static final C2446d f8705e = new C2446d("Gas Buddy", "gasbuddy.com", "gbis.gbandroid");
    public static final C2446d f8706f = new C2446d("TA/Petro", "TA TravelCenters", "com.tatravelcenters.trucksmart");
    public static final C2446d f8707g = new C2446d("WiFi Finder", "Jiwire", "com.jiwire.android.finder");
    public static final C2446d f8708h = new C2446d("Pilot/FlyingJ", "Pilot Flying J", "com.pilottravelcenters.mypilot");
    public static final C2446d f8709i = new C2446d("Love's", "Love's Travel Stops", "com.loves.finder");
    public static final C2446d f8710j = new C2446d("Blue Beacon", "Blue Beacon Truck Washes", "sdinc.BlueBeacon");
    public static final C2446d f8711k = new C2446d("Mack", "Mack Trucks Inc.", "com.volvo.mack.mobile.locator");
    public static final C2446d f8712l = new C2446d("Volvo", "Volvo Group North America, LLC", "com.volvo.nat.mobile.locator");
    public static final C2446d f8713m = new C2446d("Daimler", "Daimler Trucks North America LLC", "com.bkv.mobileapp");
    public static final C2446d f8714n = new C2446d("Lose It", "FitNow, Inc.", "com.fitnow.loseit");
    public static final C2446d f8715o = new C2446d("Drivewyze", "Drivewyze Development Team", "com.drivewyze.agatha2", null, "&referrer=utm_source%3Dbigroad");
    public static final C2446d f8716p = new C2446d("My DAT", "TransCore", "com.tcore.android.LoadBoard");
    public static final C2446d f8717q = new C2446d("Truck Scale Calculator", "PavementPilot Software", "appinventor.ai_pavementpilot.TruckScaleCalculator");
    public static final C2446d f8718r = new C2446d("Axle Weight Calc", "PavementPilot Software", "appinventor.ai_pavementpilot.AxleWeightCalc");
    private static final C2446d f8719s = new C2446d("Phone", "Phone", "");
    private static final C2446d[] f8720t = new C2446d[]{new C2446d("Calculator", "Standard Calculator", "com.android.calculator2", "com.android.calculator2.Calculator"), new C2446d("Calculator", "Samsung Galaxy Calculator", "com.sec.android.app.calculator", "com.sec.android.app.calculator.Calculator"), new C2446d("Calculator", "Samsung S3 Calculator", "com.sec.android.app.popupcalculator", "com.sec.android.app.popupcalculator.Calculator")};
    private static final C2446d[] f8721u = new C2446d[]{new C2446d("Alarm Clock", "Standard Alarm Clock", "com.android.deskclock", "com.android.deskclock.AlarmClock"), new C2446d("Alarm Clock", "Froyo Nexus Alarm Clock", "com.google.android.deskclock", "com.android.deskclock.DeskClock"), new C2446d("Alarm Clock", "HTC Alarm Clock", "com.htc.android.worldclock", "com.htc.android.worldclock.WorldClockTabControl"), new C2446d("Alarm Clock", "Moto Blur Alarm Clock", "com.motorola.blur.alarmclock", "com.motorola.blur.alarmclock.AlarmClock"), new C2446d("Alarm Clock", "Samsung Galaxy Clock", "com.sec.android.app.clockpackage", "com.sec.android.app.clockpackage.ClockPackage")};

    private static class C2447a {
        private final C2446d f8699a;
        private final Intent f8700b;

        public C2447a(C2446d c2446d, Intent intent) {
            this.f8699a = c2446d;
            this.f8700b = intent;
        }

        public C2446d m12063a() {
            return this.f8699a;
        }

        public Intent m12064b() {
            return this.f8700b;
        }
    }

    private static Intent m12065a(Context context, C2446d c2446d) {
        PackageManager e = OurApplication.m6283e();
        if (e == null) {
            return null;
        }
        Intent addCategory = new Intent("android.intent.action.MAIN").addCategory("android.intent.category.LAUNCHER");
        try {
            ComponentName componentName = new ComponentName(c2446d.m12060b(), c2446d.m12061c());
            e.getActivityInfo(componentName, 128);
            addCategory.setComponent(componentName);
            return addCategory;
        } catch (NameNotFoundException e2) {
            return null;
        }
    }

    private static Intent m12072b(Context context, C2446d c2446d) {
        PackageManager e = OurApplication.m6283e();
        if (e == null) {
            return null;
        }
        return e.getLaunchIntentForPackage(c2446d.m12060b());
    }

    private static C2447a m12071a(Context context, C2446d[] c2446dArr) {
        int i = 0;
        for (C2446d c2446d : c2446dArr) {
            Intent a = C2448e.m12065a(context, c2446d);
            if (a != null) {
                return new C2447a(c2446d, a);
            }
        }
        int length = c2446dArr.length;
        while (i < length) {
            C2446d c2446d2 = c2446dArr[i];
            Intent b = C2448e.m12072b(context, c2446d2);
            if (b != null) {
                return new C2447a(c2446d2, b);
            }
            i++;
        }
        return null;
    }

    public static C2443c m12066a(Activity activity, int i) {
        C2443c c2444a = new C2444a(activity, f8719s, new Intent("android.intent.action.DIAL"), 101, new ComponentName("com.android.contacts", "com.android.contacts.activities.DialtactsActivity"), activity.getString(i));
        c2444a.m12054a(true);
        return c2444a.mo1341a() ? c2444a : null;
    }

    public static C2443c m12073b(Activity activity, int i) {
        return C2448e.m12070a(activity, 103, f8720t, i);
    }

    public static C2443c m12074c(Activity activity, int i) {
        return C2448e.m12070a(activity, 104, f8721u, i);
    }

    private static C2443c m12070a(Activity activity, int i, C2446d[] c2446dArr, int i2) {
        C2447a a = C2448e.m12071a((Context) activity, c2446dArr);
        if (a == null) {
            return null;
        }
        C2443c c2444a = new C2444a(activity, a.m12063a(), a.m12064b(), i, a.m12064b().getComponent(), activity.getString(i2));
        if (c2444a.mo1341a()) {
            return c2444a;
        }
        return null;
    }

    public static C2443c m12067a(Activity activity, int i, int i2, C2446d c2446d, int i3, int i4, int i5) {
        return C2448e.m12068a(activity, i, i2, c2446d, i3, i4, i5, false);
    }

    public static C2443c m12068a(Activity activity, int i, int i2, C2446d c2446d, int i3, int i4, int i5, boolean z) {
        C2443c c2444a;
        Intent b = C2448e.m12072b((Context) activity, c2446d);
        if (b != null) {
            c2444a = new C2444a(activity, c2446d, b, i2, b.getComponent(), activity.getString(i3));
            if (c2444a.mo1341a()) {
                return c2444a;
            }
        }
        c2444a = new C2450f(activity, c2446d, i, i2 | (z ? 0 : 1024), activity.getString(i3), activity.getString(i4), c2446d.m12060b(), c2446d.m12062d(), activity.getString(i5));
        return !c2444a.mo1341a() ? null : c2444a;
    }

    public static C2443c m12069a(Activity activity, int i, C2446d c2446d, int i2, int i3, int i4) {
        C2443c c2445b = new C2445b(activity, c2446d, i | 1024, activity.getString(i2), activity.getString(i3), activity.getString(i4));
        return c2445b.mo1341a() ? c2445b : null;
    }
}
