package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzdf extends zzdg {
    private static final String f12721a = zzaf.STARTS_WITH.toString();

    public zzdf() {
        super(f12721a);
    }

    protected boolean mo2436a(String str, String str2, Map<String, zza> map) {
        return str.startsWith(str2);
    }
}
