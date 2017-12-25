package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;

public class zzg {
    private final Context f10317a;
    private final Context f10318b;

    public zzg(Context context) {
        zzab.zzy(context);
        Object applicationContext = context.getApplicationContext();
        zzab.zzb(applicationContext, (Object) "Application context can't be null");
        this.f10317a = applicationContext;
        this.f10318b = applicationContext;
    }

    protected zzu m16643a(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzu(com_google_android_gms_analytics_internal_zzf);
    }

    protected zzi m16644a(Context context) {
        return zzi.zzax(context);
    }

    protected zzk m16645b(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzk(com_google_android_gms_analytics_internal_zzf);
    }

    protected zza m16646c(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zza(com_google_android_gms_analytics_internal_zzf);
    }

    protected zzn m16647d(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzn(com_google_android_gms_analytics_internal_zzf);
    }

    protected zzap m16648e(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzap(com_google_android_gms_analytics_internal_zzf);
    }

    protected zzaf m16649f(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzaf(com_google_android_gms_analytics_internal_zzf);
    }

    protected zzr m16650g(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzr(com_google_android_gms_analytics_internal_zzf);
    }

    public Context getApplicationContext() {
        return this.f10317a;
    }

    protected zze m16651h(zzf com_google_android_gms_analytics_internal_zzf) {
        return zzh.zzavm();
    }

    protected GoogleAnalytics m16652i(zzf com_google_android_gms_analytics_internal_zzf) {
        return new GoogleAnalytics(com_google_android_gms_analytics_internal_zzf);
    }

    zzl m16653j(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzl(com_google_android_gms_analytics_internal_zzf, this);
    }

    zzag m16654k(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzag(com_google_android_gms_analytics_internal_zzf);
    }

    protected zzb m16655l(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzb(com_google_android_gms_analytics_internal_zzf, this);
    }

    public zzj zzm(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzj(com_google_android_gms_analytics_internal_zzf);
    }

    public zzah zzn(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzah(com_google_android_gms_analytics_internal_zzf);
    }

    public zzi zzo(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzi(com_google_android_gms_analytics_internal_zzf);
    }

    public zzv zzp(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzv(com_google_android_gms_analytics_internal_zzf);
    }

    public zzai zzq(zzf com_google_android_gms_analytics_internal_zzf) {
        return new zzai(com_google_android_gms_analytics_internal_zzf);
    }

    public Context zzzi() {
        return this.f10318b;
    }
}
