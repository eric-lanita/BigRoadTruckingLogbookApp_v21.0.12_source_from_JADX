package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzq extends zzal {
    private static final String f12813a = zzaf.CONTAINER_VERSION.toString();
    private final String f12814b;

    public zzq(String str) {
        super(f12813a, new String[0]);
        this.f12814b = str;
    }

    public zza zzav(Map<String, zza> map) {
        return this.f12814b == null ? zzdl.zzcdu() : zzdl.zzap(this.f12814b);
    }

    public boolean zzcag() {
        return true;
    }
}
