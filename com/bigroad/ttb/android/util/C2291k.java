package com.bigroad.ttb.android.util;

import android.content.Context;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.bigroad.shared.C1098j;
import com.bigroad.ttb.android.logging.C2134e;

public abstract class C2291k {
    public static String m11220a(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            C2134e.m10682e("TT-Identity", e.toString());
            return "";
        }
    }

    public static C1098j m11221b(Context context) {
        return new C1098j(C2291k.m11220a(context));
    }

    public static String m11224c(Context context) {
        String string = Secure.getString(context.getContentResolver(), "android_id");
        return string == null ? "" : string;
    }

    public static String m11219a() {
        return Build.MODEL;
    }

    public static String m11222b() {
        return "Android";
    }

    public static String m11223c() {
        return VERSION.RELEASE;
    }

    public static int m11225d() {
        return VERSION.SDK_INT;
    }
}
