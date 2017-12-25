package com.google.android.gms.analytics.internal;

import com.google.android.gms.internal.zzlu;

public class zzk extends zzd {
    private final zzlu f10347a = new zzlu();

    zzk(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    protected void mo1605a() {
        m16543j().zzws().zza(this.f10347a);
        zzvz();
    }

    public zzlu zzaad() {
        m16553s();
        return this.f10347a;
    }

    public void zzvz() {
        zzap m = m16546m();
        String zzxb = m.zzxb();
        if (zzxb != null) {
            this.f10347a.setAppName(zzxb);
        }
        String zzxc = m.zzxc();
        if (zzxc != null) {
            this.f10347a.setAppVersion(zzxc);
        }
    }
}
