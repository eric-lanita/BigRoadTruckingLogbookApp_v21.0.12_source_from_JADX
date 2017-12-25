package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;
import java.util.Set;

public abstract class zzch extends zzal {
    private static final String f12526a = zzag.ARG0.toString();
    private static final String f12527b = zzag.ARG1.toString();

    public zzch(String str) {
        super(str, f12526a, f12527b);
    }

    protected abstract boolean mo2435a(zza com_google_android_gms_internal_zzai_zza, zza com_google_android_gms_internal_zzai_zza2, Map<String, zza> map);

    public zza zzav(Map<String, zza> map) {
        for (zza com_google_android_gms_internal_zzai_zza : map.values()) {
            if (com_google_android_gms_internal_zzai_zza == zzdl.zzcdu()) {
                return zzdl.zzap(Boolean.valueOf(false));
            }
        }
        zza com_google_android_gms_internal_zzai_zza2 = (zza) map.get(f12526a);
        zza com_google_android_gms_internal_zzai_zza3 = (zza) map.get(f12527b);
        boolean a = (com_google_android_gms_internal_zzai_zza2 == null || com_google_android_gms_internal_zzai_zza3 == null) ? false : mo2435a(com_google_android_gms_internal_zzai_zza2, com_google_android_gms_internal_zzai_zza3, map);
        return zzdl.zzap(Boolean.valueOf(a));
    }

    public boolean zzcag() {
        return true;
    }

    public /* bridge */ /* synthetic */ String zzcbp() {
        return super.zzcbp();
    }

    public /* bridge */ /* synthetic */ Set zzcbq() {
        return super.zzcbq();
    }
}
