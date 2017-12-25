package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzv extends zzal {
    private static final String f12821a = zzaf.CUSTOM_VAR.toString();
    private static final String f12822b = zzag.NAME.toString();
    private static final String f12823c = zzag.DEFAULT_VALUE.toString();
    private final DataLayer f12824d;

    public zzv(DataLayer dataLayer) {
        super(f12821a, f12822b);
        this.f12824d = dataLayer;
    }

    public zza zzav(Map<String, zza> map) {
        Object obj = this.f12824d.get(zzdl.zzg((zza) map.get(f12822b)));
        if (obj != null) {
            return zzdl.zzap(obj);
        }
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12823c);
        return com_google_android_gms_internal_zzai_zza != null ? com_google_android_gms_internal_zzai_zza : zzdl.zzcdu();
    }

    public boolean zzcag() {
        return false;
    }
}
