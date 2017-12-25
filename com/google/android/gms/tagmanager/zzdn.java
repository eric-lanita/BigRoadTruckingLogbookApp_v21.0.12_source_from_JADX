package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzdn extends zzal {
    private static final String f12753a = zzaf.UPPERCASE_STRING.toString();
    private static final String f12754b = zzag.ARG0.toString();

    public zzdn() {
        super(f12753a, f12754b);
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(zzdl.zzg((zza) map.get(f12754b)).toUpperCase());
    }

    public boolean zzcag() {
        return true;
    }
}
