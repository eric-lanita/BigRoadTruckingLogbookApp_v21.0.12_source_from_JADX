package com.google.android.gms.internal;

import android.text.TextUtils;
import com.google.android.gms.analytics.zzg;
import com.google.android.gms.common.internal.zzab;
import java.util.HashMap;
import java.util.Map;

public final class zzmd extends zzg<zzmd> {
    private String f11439a;
    private String f11440b;
    private String f11441c;
    private String f11442d;
    private boolean f11443e;
    private String f11444f;
    private boolean f11445g;
    private double f11446h;

    public String getUserId() {
        return this.f11441c;
    }

    public void setClientId(String str) {
        this.f11440b = str;
    }

    public void setSampleRate(double d) {
        boolean z = d >= 0.0d && d <= 100.0d;
        zzab.zzb(z, (Object) "Sample rate must be between 0% and 100%");
        this.f11446h = d;
    }

    public void setUserId(String str) {
        this.f11441c = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("hitType", this.f11439a);
        hashMap.put("clientId", this.f11440b);
        hashMap.put("userId", this.f11441c);
        hashMap.put("androidAdId", this.f11442d);
        hashMap.put("AdTargetingEnabled", Boolean.valueOf(this.f11443e));
        hashMap.put("sessionControl", this.f11444f);
        hashMap.put("nonInteraction", Boolean.valueOf(this.f11445g));
        hashMap.put("sampleRate", Double.valueOf(this.f11446h));
        return zzg.zzj(hashMap);
    }

    public void zza(zzmd com_google_android_gms_internal_zzmd) {
        if (!TextUtils.isEmpty(this.f11439a)) {
            com_google_android_gms_internal_zzmd.zzdw(this.f11439a);
        }
        if (!TextUtils.isEmpty(this.f11440b)) {
            com_google_android_gms_internal_zzmd.setClientId(this.f11440b);
        }
        if (!TextUtils.isEmpty(this.f11441c)) {
            com_google_android_gms_internal_zzmd.setUserId(this.f11441c);
        }
        if (!TextUtils.isEmpty(this.f11442d)) {
            com_google_android_gms_internal_zzmd.zzdx(this.f11442d);
        }
        if (this.f11443e) {
            com_google_android_gms_internal_zzmd.zzao(true);
        }
        if (!TextUtils.isEmpty(this.f11444f)) {
            com_google_android_gms_internal_zzmd.zzdy(this.f11444f);
        }
        if (this.f11445g) {
            com_google_android_gms_internal_zzmd.zzap(this.f11445g);
        }
        if (this.f11446h != 0.0d) {
            com_google_android_gms_internal_zzmd.setSampleRate(this.f11446h);
        }
    }

    public void zzao(boolean z) {
        this.f11443e = z;
    }

    public void zzap(boolean z) {
        this.f11445g = z;
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzmd) com_google_android_gms_analytics_zzg);
    }

    public void zzdw(String str) {
        this.f11439a = str;
    }

    public void zzdx(String str) {
        this.f11442d = str;
    }

    public void zzdy(String str) {
        this.f11444f = str;
    }

    public String zzwb() {
        return this.f11440b;
    }

    public String zzxx() {
        return this.f11439a;
    }

    public String zzxy() {
        return this.f11442d;
    }

    public boolean zzxz() {
        return this.f11443e;
    }

    public String zzya() {
        return this.f11444f;
    }

    public boolean zzyb() {
        return this.f11445g;
    }

    public double zzyc() {
        return this.f11446h;
    }
}
