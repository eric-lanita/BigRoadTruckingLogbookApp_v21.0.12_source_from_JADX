package com.google.android.gms.analytics;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import java.util.ArrayList;
import java.util.List;

public abstract class zzh<T extends zzh> {
    protected final zze f10171a;
    private final zzi f10172b;
    private final List<zzf> f10173c = new ArrayList();

    protected zzh(zzi com_google_android_gms_analytics_zzi, zze com_google_android_gms_common_util_zze) {
        zzab.zzy(com_google_android_gms_analytics_zzi);
        this.f10172b = com_google_android_gms_analytics_zzi;
        zze com_google_android_gms_analytics_zze = new zze(this, com_google_android_gms_common_util_zze);
        com_google_android_gms_analytics_zze.m16747e();
        this.f10171a = com_google_android_gms_analytics_zze;
    }

    protected void mo1601a(zze com_google_android_gms_analytics_zze) {
    }

    protected void m16518b(zze com_google_android_gms_analytics_zze) {
        for (zzf zza : this.f10173c) {
            zza.zza(this, com_google_android_gms_analytics_zze);
        }
    }

    protected zzi m16519d() {
        return this.f10172b;
    }

    public zze zzvr() {
        zze zzwf = this.f10171a.zzwf();
        m16518b(zzwf);
        return zzwf;
    }

    public zze zzwq() {
        return this.f10171a;
    }

    public List<zzk> zzwr() {
        return this.f10171a.zzwh();
    }
}
