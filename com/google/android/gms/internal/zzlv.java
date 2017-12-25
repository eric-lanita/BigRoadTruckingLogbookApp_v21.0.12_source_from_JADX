package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzlv extends zzg<zzlv> {
    private String f11417a;
    private String f11418b;
    private String f11419c;
    private String f11420d;
    private String f11421e;
    private String f11422f;
    private String f11423g;
    private String f11424h;
    private String f11425i;
    private String f11426j;

    public String getContent() {
        return this.f11421e;
    }

    public String getId() {
        return this.f11422f;
    }

    public String getName() {
        return this.f11417a;
    }

    public String getSource() {
        return this.f11418b;
    }

    public void setName(String str) {
        this.f11417a = str;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("name", this.f11417a);
        hashMap.put(ShareConstants.FEED_SOURCE_PARAM, this.f11418b);
        hashMap.put("medium", this.f11419c);
        hashMap.put("keyword", this.f11420d);
        hashMap.put("content", this.f11421e);
        hashMap.put(ShareConstants.WEB_DIALOG_PARAM_ID, this.f11422f);
        hashMap.put("adNetworkId", this.f11423g);
        hashMap.put("gclid", this.f11424h);
        hashMap.put("dclid", this.f11425i);
        hashMap.put("aclid", this.f11426j);
        return zzg.zzj(hashMap);
    }

    public void zza(zzlv com_google_android_gms_internal_zzlv) {
        if (!TextUtils.isEmpty(this.f11417a)) {
            com_google_android_gms_internal_zzlv.setName(this.f11417a);
        }
        if (!TextUtils.isEmpty(this.f11418b)) {
            com_google_android_gms_internal_zzlv.zzdj(this.f11418b);
        }
        if (!TextUtils.isEmpty(this.f11419c)) {
            com_google_android_gms_internal_zzlv.zzdk(this.f11419c);
        }
        if (!TextUtils.isEmpty(this.f11420d)) {
            com_google_android_gms_internal_zzlv.zzdl(this.f11420d);
        }
        if (!TextUtils.isEmpty(this.f11421e)) {
            com_google_android_gms_internal_zzlv.zzdm(this.f11421e);
        }
        if (!TextUtils.isEmpty(this.f11422f)) {
            com_google_android_gms_internal_zzlv.zzdn(this.f11422f);
        }
        if (!TextUtils.isEmpty(this.f11423g)) {
            com_google_android_gms_internal_zzlv.zzdo(this.f11423g);
        }
        if (!TextUtils.isEmpty(this.f11424h)) {
            com_google_android_gms_internal_zzlv.zzdp(this.f11424h);
        }
        if (!TextUtils.isEmpty(this.f11425i)) {
            com_google_android_gms_internal_zzlv.zzdq(this.f11425i);
        }
        if (!TextUtils.isEmpty(this.f11426j)) {
            com_google_android_gms_internal_zzlv.zzdr(this.f11426j);
        }
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzlv) com_google_android_gms_analytics_zzg);
    }

    public void zzdj(String str) {
        this.f11418b = str;
    }

    public void zzdk(String str) {
        this.f11419c = str;
    }

    public void zzdl(String str) {
        this.f11420d = str;
    }

    public void zzdm(String str) {
        this.f11421e = str;
    }

    public void zzdn(String str) {
        this.f11422f = str;
    }

    public void zzdo(String str) {
        this.f11423g = str;
    }

    public void zzdp(String str) {
        this.f11424h = str;
    }

    public void zzdq(String str) {
        this.f11425i = str;
    }

    public void zzdr(String str) {
        this.f11426j = str;
    }

    public String zzxe() {
        return this.f11419c;
    }

    public String zzxf() {
        return this.f11420d;
    }

    public String zzxg() {
        return this.f11423g;
    }

    public String zzxh() {
        return this.f11424h;
    }

    public String zzxi() {
        return this.f11425i;
    }

    public String zzxj() {
        return this.f11426j;
    }
}
