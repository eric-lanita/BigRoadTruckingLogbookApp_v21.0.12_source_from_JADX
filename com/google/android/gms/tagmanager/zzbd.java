package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzag;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzbd extends zzal {
    private static final String f12555a = zzaf.INSTALL_REFERRER.toString();
    private static final String f12556b = zzag.COMPONENT.toString();
    private final Context f12557c;

    public zzbd(Context context) {
        super(f12555a, new String[0]);
        this.f12557c = context;
    }

    public zza zzav(Map<String, zza> map) {
        String zzx = zzbe.zzx(this.f12557c, ((zza) map.get(f12556b)) != null ? zzdl.zzg((zza) map.get(f12556b)) : null);
        return zzx != null ? zzdl.zzap(zzx) : zzdl.zzcdu();
    }

    public boolean zzcag() {
        return true;
    }
}
