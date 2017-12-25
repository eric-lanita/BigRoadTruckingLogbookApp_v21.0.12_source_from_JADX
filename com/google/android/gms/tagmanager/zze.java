package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zze extends zzal {
    private static final String f12755a = zzaf.ADWORDS_CLICK_REFERRER.toString();
    private static final String f12756b = zzag.COMPONENT.toString();
    private static final String f12757c = zzag.CONVERSION_ID.toString();
    private final Context f12758d;

    public zze(Context context) {
        super(f12755a, f12757c);
        this.f12758d = context;
    }

    public zza zzav(Map<String, zza> map) {
        zza com_google_android_gms_internal_zzai_zza = (zza) map.get(f12757c);
        if (com_google_android_gms_internal_zzai_zza == null) {
            return zzdl.zzcdu();
        }
        String zzg = zzdl.zzg(com_google_android_gms_internal_zzai_zza);
        com_google_android_gms_internal_zzai_zza = (zza) map.get(f12756b);
        String zzh = zzbe.zzh(this.f12758d, zzg, com_google_android_gms_internal_zzai_zza != null ? zzdl.zzg(com_google_android_gms_internal_zzai_zza) : null);
        return zzh != null ? zzdl.zzap(zzh) : zzdl.zzcdu();
    }

    public boolean zzcag() {
        return true;
    }
}
