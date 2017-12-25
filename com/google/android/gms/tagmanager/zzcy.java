package com.google.android.gms.tagmanager;

import android.os.Build.VERSION;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzcy extends zzal {
    private static final String f12685a = zzaf.SDK_VERSION.toString();

    public zzcy() {
        super(f12685a, new String[0]);
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(Integer.valueOf(VERSION.SDK_INT));
    }

    public boolean zzcag() {
        return true;
    }
}
