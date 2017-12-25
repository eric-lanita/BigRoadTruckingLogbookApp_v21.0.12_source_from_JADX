package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.List;
import java.util.Map;

class zzx extends zzdj {
    private static final String f12841a = zzaf.DATA_LAYER_WRITE.toString();
    private static final String f12842b = zzag.VALUE.toString();
    private static final String f12843c = zzag.CLEAR_PERSISTENT_DATA_LAYER_PREFIX.toString();
    private final DataLayer f12844d;

    public zzx(DataLayer dataLayer) {
        super(f12841a, f12842b);
        this.f12844d = dataLayer;
    }

    private void m18273a(zza com_google_android_gms_internal_zzai_zza) {
        if (com_google_android_gms_internal_zzai_zza != null && com_google_android_gms_internal_zzai_zza != zzdl.zzcdo()) {
            String zzg = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
            if (zzg != zzdl.zzcdt()) {
                this.f12844d.m18054a(zzg);
            }
        }
    }

    private void m18274b(zza com_google_android_gms_internal_zzai_zza) {
        if (com_google_android_gms_internal_zzai_zza != null && com_google_android_gms_internal_zzai_zza != zzdl.zzcdo()) {
            Object zzl = zzdl.zzl(com_google_android_gms_internal_zzai_zza);
            if (zzl instanceof List) {
                for (Object zzl2 : (List) zzl2) {
                    if (zzl2 instanceof Map) {
                        this.f12844d.push((Map) zzl2);
                    }
                }
            }
        }
    }

    public void zzax(Map<String, zza> map) {
        m18274b((zza) map.get(f12842b));
        m18273a((zza) map.get(f12843c));
    }
}
