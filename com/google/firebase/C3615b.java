package com.google.firebase;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.util.zzw;

public final class C3615b {
    private final String f13106a;
    private final String f13107b;
    private final String f13108c;
    private final String f13109d;
    private final String f13110e;
    private final String f13111f;

    private C3615b(String str, String str2, String str3, String str4, String str5, String str6) {
        zzab.zza(!zzw.zzib(str), (Object) "ApplicationId must be set.");
        this.f13107b = str;
        this.f13106a = str2;
        this.f13108c = str3;
        this.f13109d = str4;
        this.f13110e = str5;
        this.f13111f = str6;
    }

    public static C3615b m18875a(Context context) {
        zzai com_google_android_gms_common_internal_zzai = new zzai(context);
        Object string = com_google_android_gms_common_internal_zzai.getString("google_app_id");
        return TextUtils.isEmpty(string) ? null : new C3615b(string, com_google_android_gms_common_internal_zzai.getString("google_api_key"), com_google_android_gms_common_internal_zzai.getString("firebase_database_url"), com_google_android_gms_common_internal_zzai.getString("ga_trackingId"), com_google_android_gms_common_internal_zzai.getString("gcm_defaultSenderId"), com_google_android_gms_common_internal_zzai.getString("google_storage_bucket"));
    }

    public String m18876a() {
        return this.f13107b;
    }

    public String m18877b() {
        return this.f13110e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C3615b)) {
            return false;
        }
        C3615b c3615b = (C3615b) obj;
        return zzaa.equal(this.f13107b, c3615b.f13107b) && zzaa.equal(this.f13106a, c3615b.f13106a) && zzaa.equal(this.f13108c, c3615b.f13108c) && zzaa.equal(this.f13109d, c3615b.f13109d) && zzaa.equal(this.f13110e, c3615b.f13110e) && zzaa.equal(this.f13111f, c3615b.f13111f);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f13107b, this.f13106a, this.f13108c, this.f13109d, this.f13110e, this.f13111f);
    }

    public String toString() {
        return zzaa.zzx(this).zzg("applicationId", this.f13107b).zzg("apiKey", this.f13106a).zzg("databaseUrl", this.f13108c).zzg("gcmSenderId", this.f13110e).zzg("storageBucket", this.f13111f).toString();
    }
}
