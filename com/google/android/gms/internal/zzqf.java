package com.google.android.gms.internal;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.google.android.gms.C3176R;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzai;
import com.google.android.gms.common.internal.zzz;

@Deprecated
public final class zzqf {
    private static Object f11638a = new Object();
    private static zzqf f11639b;
    private final String f11640c;
    private final String f11641d;
    private final Status f11642e;
    private final String f11643f;
    private final String f11644g;
    private final String f11645h;
    private final boolean f11646i;
    private final boolean f11647j;

    zzqf(Context context) {
        boolean z = true;
        Resources resources = context.getResources();
        int identifier = resources.getIdentifier("google_app_measurement_enable", "integer", resources.getResourcePackageName(C3176R.string.common_google_play_services_unknown_issue));
        if (identifier != 0) {
            boolean z2 = resources.getInteger(identifier) != 0;
            if (z2) {
                z = false;
            }
            this.f11647j = z;
            z = z2;
        } else {
            this.f11647j = false;
        }
        this.f11646i = z;
        zzai com_google_android_gms_common_internal_zzai = new zzai(context);
        this.f11643f = com_google_android_gms_common_internal_zzai.getString("firebase_database_url");
        this.f11645h = com_google_android_gms_common_internal_zzai.getString("google_storage_bucket");
        this.f11644g = com_google_android_gms_common_internal_zzai.getString("gcm_defaultSenderId");
        this.f11641d = com_google_android_gms_common_internal_zzai.getString("google_api_key");
        Object zzcf = zzz.zzcf(context);
        if (zzcf == null) {
            zzcf = com_google_android_gms_common_internal_zzai.getString("google_app_id");
        }
        if (TextUtils.isEmpty(zzcf)) {
            this.f11642e = new Status(10, "Missing google app id value from from string resources with name google_app_id.");
            this.f11640c = null;
            return;
        }
        this.f11640c = zzcf;
        this.f11642e = Status.sq;
    }

    zzqf(String str, boolean z) {
        this(str, z, null, null, null);
    }

    zzqf(String str, boolean z, String str2, String str3, String str4) {
        this.f11640c = str;
        this.f11641d = null;
        this.f11642e = Status.sq;
        this.f11646i = z;
        this.f11647j = !z;
        this.f11643f = str2;
        this.f11644g = str4;
        this.f11645h = str3;
    }

    private static zzqf m17503b(String str) {
        zzqf com_google_android_gms_internal_zzqf;
        synchronized (f11638a) {
            if (f11639b == null) {
                throw new IllegalStateException(new StringBuilder(String.valueOf(str).length() + 34).append("Initialize must be called before ").append(str).append(".").toString());
            }
            com_google_android_gms_internal_zzqf = f11639b;
        }
        return com_google_android_gms_internal_zzqf;
    }

    public static String zzaqo() {
        return m17503b("getGoogleAppId").f11640c;
    }

    public static boolean zzaqp() {
        return m17503b("isMeasurementExplicitlyDisabled").f11647j;
    }

    public static Status zzc(Context context, String str, boolean z) {
        Status a;
        zzab.zzb((Object) context, (Object) "Context must not be null.");
        zzab.zzh(str, "App ID must be nonempty.");
        synchronized (f11638a) {
            if (f11639b != null) {
                a = f11639b.m17504a(str);
            } else {
                f11639b = new zzqf(str, z);
                a = f11639b.f11642e;
            }
        }
        return a;
    }

    public static Status zzcb(Context context) {
        Status status;
        zzab.zzb((Object) context, (Object) "Context must not be null.");
        synchronized (f11638a) {
            if (f11639b == null) {
                f11639b = new zzqf(context);
            }
            status = f11639b.f11642e;
        }
        return status;
    }

    Status m17504a(String str) {
        if (this.f11640c == null || this.f11640c.equals(str)) {
            return Status.sq;
        }
        String str2 = this.f11640c;
        return new Status(10, new StringBuilder(String.valueOf(str2).length() + 97).append("Initialize was called with two different Google App IDs.  Only the first app ID will be used: '").append(str2).append("'.").toString());
    }
}
