package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzce extends zzal {
    private static final String f12595a = zzaf.OS_VERSION.toString();

    public zzce() {
        super(f12595a, new String[0]);
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(VERSION.RELEASE);
    }

    public boolean zzcag() {
        return true;
    }
}
