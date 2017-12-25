package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzn extends zzal {
    private static final String f12778a = zzaf.CONSTANT.toString();
    private static final String f12779b = zzag.VALUE.toString();

    public zzn() {
        super(f12778a, f12779b);
    }

    public static String zzcaj() {
        return f12778a;
    }

    public static String zzcak() {
        return f12779b;
    }

    public zza zzav(Map<String, zza> map) {
        return (zza) map.get(f12779b);
    }

    public boolean zzcag() {
        return true;
    }
}
