package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzdh extends zzal {
    private static final String f12722a = zzaf.TIME.toString();

    public zzdh() {
        super(f12722a, new String[0]);
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(Long.valueOf(System.currentTimeMillis()));
    }

    public boolean zzcag() {
        return false;
    }
}
