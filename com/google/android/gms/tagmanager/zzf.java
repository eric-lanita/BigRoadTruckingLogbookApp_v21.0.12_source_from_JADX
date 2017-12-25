package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzf extends zzal {
    private static final String f12759a = zzaf.APP_ID.toString();
    private final Context f12760b;

    public zzf(Context context) {
        super(f12759a, new String[0]);
        this.f12760b = context;
    }

    public zza zzav(Map<String, zza> map) {
        return zzdl.zzap(this.f12760b.getPackageName());
    }

    public boolean zzcag() {
        return true;
    }
}
