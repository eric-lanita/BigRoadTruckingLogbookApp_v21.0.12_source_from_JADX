package com.crashlytics.android.core;

import android.content.Context;
import android.content.pm.PackageInfo;
import io.fabric.sdk.android.services.common.IdManager;

class C2880a {
    public final String f9929a;
    public final String f9930b;
    public final String f9931c;
    public final String f9932d;
    public final String f9933e;
    public final String f9934f;

    public static C2880a m16170a(Context context, IdManager idManager, String str, String str2) {
        String packageName = context.getPackageName();
        String j = idManager.m20743j();
        PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
        return new C2880a(str, str2, j, packageName, Integer.toString(packageInfo.versionCode), packageInfo.versionName == null ? "0.0" : packageInfo.versionName);
    }

    C2880a(String str, String str2, String str3, String str4, String str5, String str6) {
        this.f9929a = str;
        this.f9930b = str2;
        this.f9931c = str3;
        this.f9932d = str4;
        this.f9933e = str5;
        this.f9934f = str6;
    }
}
