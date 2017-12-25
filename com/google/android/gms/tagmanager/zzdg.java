package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

abstract class zzdg extends zzch {
    public zzdg(String str) {
        super(str);
    }

    protected boolean mo2435a(zza com_google_android_gms_internal_zzai_zza, zza com_google_android_gms_internal_zzai_zza2, Map<String, zza> map) {
        String zzg = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        String zzg2 = zzdl.zzg(com_google_android_gms_internal_zzai_zza2);
        return (zzg == zzdl.zzcdt() || zzg2 == zzdl.zzcdt()) ? false : mo2436a(zzg, zzg2, (Map) map);
    }

    protected abstract boolean mo2436a(String str, String str2, Map<String, zza> map);
}
