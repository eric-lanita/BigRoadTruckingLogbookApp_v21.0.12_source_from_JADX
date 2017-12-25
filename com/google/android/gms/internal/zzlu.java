package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzlu extends zzg<zzlu> {
    private String f11413a;
    private String f11414b;
    private String f11415c;
    private String f11416d;

    public void setAppId(String str) {
        this.f11415c = str;
    }

    public void setAppInstallerId(String str) {
        this.f11416d = str;
    }

    public void setAppName(String str) {
        this.f11413a = str;
    }

    public void setAppVersion(String str) {
        this.f11414b = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("appName", this.f11413a);
        hashMap.put("appVersion", this.f11414b);
        hashMap.put("appId", this.f11415c);
        hashMap.put("appInstallerId", this.f11416d);
        return zzg.zzj(hashMap);
    }

    public void zza(zzlu com_google_android_gms_internal_zzlu) {
        if (!TextUtils.isEmpty(this.f11413a)) {
            com_google_android_gms_internal_zzlu.setAppName(this.f11413a);
        }
        if (!TextUtils.isEmpty(this.f11414b)) {
            com_google_android_gms_internal_zzlu.setAppVersion(this.f11414b);
        }
        if (!TextUtils.isEmpty(this.f11415c)) {
            com_google_android_gms_internal_zzlu.setAppId(this.f11415c);
        }
        if (!TextUtils.isEmpty(this.f11416d)) {
            com_google_android_gms_internal_zzlu.setAppInstallerId(this.f11416d);
        }
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzlu) com_google_android_gms_analytics_zzg);
    }

    public String zzsh() {
        return this.f11415c;
    }

    public String zzxb() {
        return this.f11413a;
    }

    public String zzxc() {
        return this.f11414b;
    }

    public String zzxd() {
        return this.f11416d;
    }
}
