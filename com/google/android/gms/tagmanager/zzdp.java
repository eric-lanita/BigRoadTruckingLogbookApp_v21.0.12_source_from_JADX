package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai.zza;
import java.net.URLEncoder;

class zzdp {
    private static zzcd<zza> m18217a(zzcd<zza> com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza) {
        try {
            return new zzcd(zzdl.zzap(m18220a(zzdl.zzg((zza) com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza.getObject()))), com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza.zzccd());
        } catch (Throwable e) {
            zzbn.zzb("Escape URI: unsupported encoding", e);
            return com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza;
        }
    }

    private static zzcd<zza> m18218a(zzcd<zza> com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza, int i) {
        if (m18221a((zza) com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza.getObject())) {
            switch (i) {
                case 12:
                    return m18217a((zzcd) com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza);
                default:
                    zzbn.m18105e("Unsupported Value Escaping: " + i);
                    return com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza;
            }
        }
        zzbn.m18105e("Escaping can only be applied to strings.");
        return com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza;
    }

    static zzcd<zza> m18219a(zzcd<zza> com_google_android_gms_tagmanager_zzcd_com_google_android_gms_internal_zzai_zza, int... iArr) {
        zzcd a;
        for (int a2 : iArr) {
            a = m18218a(a, a2);
        }
        return a;
    }

    static String m18220a(String str) {
        return URLEncoder.encode(str, "UTF-8").replaceAll("\\+", "%20");
    }

    private static boolean m18221a(zza com_google_android_gms_internal_zzai_zza) {
        return zzdl.zzl(com_google_android_gms_internal_zzai_zza) instanceof String;
    }
}
