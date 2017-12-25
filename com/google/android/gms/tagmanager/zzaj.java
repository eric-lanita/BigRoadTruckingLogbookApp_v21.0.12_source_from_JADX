package com.google.android.gms.tagmanager;

import com.google.android.gms.internal.zzaf;
import com.google.android.gms.internal.zzai.zza;
import java.util.Map;

class zzaj extends zzal {
    private static final String f12530a = zzaf.EVENT.toString();
    private final zzcw f12531b;

    public zzaj(zzcw com_google_android_gms_tagmanager_zzcw) {
        super(f12530a, new String[0]);
        this.f12531b = com_google_android_gms_tagmanager_zzcw;
    }

    public zza zzav(Map<String, zza> map) {
        String a = this.f12531b.m18167a();
        return a == null ? zzdl.zzcdu() : zzdl.zzap(a);
    }

    public boolean zzcag() {
        return false;
    }
}
