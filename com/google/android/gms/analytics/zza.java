package com.google.android.gms.analytics;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.gms.analytics.internal.zzf;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzmd;
import java.util.ListIterator;

public class zza extends zzh<zza> {
    private final zzf f10174b;
    private boolean f10175c;

    public zza(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf.zzyz(), com_google_android_gms_analytics_internal_zzf.zzyw());
        this.f10174b = com_google_android_gms_analytics_internal_zzf;
    }

    protected void mo1601a(zze com_google_android_gms_analytics_zze) {
        zzmd com_google_android_gms_internal_zzmd = (zzmd) com_google_android_gms_analytics_zze.zzb(zzmd.class);
        if (TextUtils.isEmpty(com_google_android_gms_internal_zzmd.zzwb())) {
            com_google_android_gms_internal_zzmd.setClientId(this.f10174b.zzzn().zzaav());
        }
        if (this.f10175c && TextUtils.isEmpty(com_google_android_gms_internal_zzmd.zzxy())) {
            com.google.android.gms.analytics.internal.zza zzzm = this.f10174b.zzzm();
            com_google_android_gms_internal_zzmd.zzdx(zzzm.zzyk());
            com_google_android_gms_internal_zzmd.zzao(zzzm.zzxz());
        }
    }

    zzf m16521c() {
        return this.f10174b;
    }

    public void enableAdvertisingIdCollection(boolean z) {
        this.f10175c = z;
    }

    public void zzdg(String str) {
        zzab.zzhr(str);
        zzdh(str);
        zzwr().add(new zzb(this.f10174b, str));
    }

    public void zzdh(String str) {
        Uri a = zzb.m16733a(str);
        ListIterator listIterator = zzwr().listIterator();
        while (listIterator.hasNext()) {
            if (a.equals(((zzk) listIterator.next()).zzvu())) {
                listIterator.remove();
            }
        }
    }

    public zze zzvr() {
        zze zzwf = zzwq().zzwf();
        zzwf.zza(this.f10174b.zzze().zzaad());
        zzwf.zza(this.f10174b.zzzf().zzack());
        m16518b(zzwf);
        return zzwf;
    }
}
