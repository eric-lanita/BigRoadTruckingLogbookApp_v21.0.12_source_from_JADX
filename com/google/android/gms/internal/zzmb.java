package com.google.android.gms.internal;

import android.text.TextUtils;
import com.facebook.internal.NativeProtocol;
import com.google.android.gms.analytics.zzg;
import java.util.HashMap;
import java.util.Map;

public final class zzmb extends zzg<zzmb> {
    private String f11435a;
    private String f11436b;
    private String f11437c;
    private long f11438d;

    public String getAction() {
        return this.f11436b;
    }

    public String getCategory() {
        return this.f11435a;
    }

    public String getLabel() {
        return this.f11437c;
    }

    public long getValue() {
        return this.f11438d;
    }

    public String toString() {
        Map hashMap = new HashMap();
        hashMap.put("category", this.f11435a);
        hashMap.put(NativeProtocol.WEB_DIALOG_ACTION, this.f11436b);
        hashMap.put("label", this.f11437c);
        hashMap.put("value", Long.valueOf(this.f11438d));
        return zzg.zzj(hashMap);
    }

    public void zza(zzmb com_google_android_gms_internal_zzmb) {
        if (!TextUtils.isEmpty(this.f11435a)) {
            com_google_android_gms_internal_zzmb.zzdt(this.f11435a);
        }
        if (!TextUtils.isEmpty(this.f11436b)) {
            com_google_android_gms_internal_zzmb.zzdu(this.f11436b);
        }
        if (!TextUtils.isEmpty(this.f11437c)) {
            com_google_android_gms_internal_zzmb.zzdv(this.f11437c);
        }
        if (this.f11438d != 0) {
            com_google_android_gms_internal_zzmb.zzo(this.f11438d);
        }
    }

    public /* synthetic */ void zzb(zzg com_google_android_gms_analytics_zzg) {
        zza((zzmb) com_google_android_gms_analytics_zzg);
    }

    public void zzdt(String str) {
        this.f11435a = str;
    }

    public void zzdu(String str) {
        this.f11436b = str;
    }

    public void zzdv(String str) {
        this.f11437c = str;
    }

    public void zzo(long j) {
        this.f11438d = j;
    }
}
