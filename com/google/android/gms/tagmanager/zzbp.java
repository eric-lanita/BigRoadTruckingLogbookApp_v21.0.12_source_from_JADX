package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzbp extends zzal {
    private static final String f12584a = zzaf.LOWERCASE_STRING.toString();
    private static final String f12585b = zzag.ARG0.toString();

    public zzbp() {
        super(f12584a, f12585b);
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(zzdl.zzg((zza) map.get(f12585b)).toLowerCase());
    }

    public boolean zzcag() {
        return true;
    }
}
