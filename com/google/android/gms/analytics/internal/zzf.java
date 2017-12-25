package com.google.android.gms.analytics.internal;

import android.content.Context;
import com.google.android.gms.analytics.GoogleAnalytics;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;
import java.lang.Thread.UncaughtExceptionHandler;

public class zzf {
    private static zzf f10301a;
    private final Context f10302b;
    private final Context f10303c;
    private final zze f10304d;
    private final zzr f10305e;
    private final zzaf f10306f;
    private final zzi f10307g;
    private final zzb f10308h;
    private final zzv f10309i;
    private final zzap f10310j;
    private final zzai f10311k;
    private final GoogleAnalytics f10312l;
    private final zzn f10313m;
    private final zza f10314n;
    private final zzk f10315o;
    private final zzu f10316p;

    class C31931 implements UncaughtExceptionHandler {
        final /* synthetic */ zzf f10300a;

        C31931(zzf com_google_android_gms_analytics_internal_zzf) {
            this.f10300a = com_google_android_gms_analytics_internal_zzf;
        }

        public void uncaughtException(Thread thread, Throwable th) {
            zzaf zzzj = this.f10300a.zzzj();
            if (zzzj != null) {
                zzzj.zze("Job execution failed", th);
            }
        }
    }

    protected zzf(zzg com_google_android_gms_analytics_internal_zzg) {
        Context applicationContext = com_google_android_gms_analytics_internal_zzg.getApplicationContext();
        zzab.zzb((Object) applicationContext, (Object) "Application context can't be null");
        Context zzzi = com_google_android_gms_analytics_internal_zzg.zzzi();
        zzab.zzy(zzzi);
        this.f10302b = applicationContext;
        this.f10303c = zzzi;
        this.f10304d = com_google_android_gms_analytics_internal_zzg.m16651h(this);
        this.f10305e = com_google_android_gms_analytics_internal_zzg.m16650g(this);
        zzaf f = com_google_android_gms_analytics_internal_zzg.m16649f(this);
        f.initialize();
        this.f10306f = f;
        String str;
        if (zzyy().zzabc()) {
            f = zzyx();
            str = zze.VERSION;
            f.zzej(new StringBuilder(String.valueOf(str).length() + 33).append("Google Analytics ").append(str).append(" is starting up.").toString());
        } else {
            f = zzyx();
            str = zze.VERSION;
            f.zzej(new StringBuilder(String.valueOf(str).length() + 134).append("Google Analytics ").append(str).append(" is starting up. To enable debug logging on a device run:\n  adb shell setprop log.tag.GAv4 DEBUG\n  adb logcat -s GAv4").toString());
        }
        zzai zzq = com_google_android_gms_analytics_internal_zzg.zzq(this);
        zzq.initialize();
        this.f10311k = zzq;
        zzap e = com_google_android_gms_analytics_internal_zzg.m16648e(this);
        e.initialize();
        this.f10310j = e;
        zzb l = com_google_android_gms_analytics_internal_zzg.m16655l(this);
        zzn d = com_google_android_gms_analytics_internal_zzg.m16647d(this);
        zza c = com_google_android_gms_analytics_internal_zzg.m16646c(this);
        zzk b = com_google_android_gms_analytics_internal_zzg.m16645b(this);
        zzu a = com_google_android_gms_analytics_internal_zzg.m16643a(this);
        zzi a2 = com_google_android_gms_analytics_internal_zzg.m16644a(applicationContext);
        a2.zza(m16642a());
        this.f10307g = a2;
        GoogleAnalytics i = com_google_android_gms_analytics_internal_zzg.m16652i(this);
        d.initialize();
        this.f10313m = d;
        c.initialize();
        this.f10314n = c;
        b.initialize();
        this.f10315o = b;
        a.initialize();
        this.f10316p = a;
        zzv zzp = com_google_android_gms_analytics_internal_zzg.zzp(this);
        zzp.initialize();
        this.f10309i = zzp;
        l.initialize();
        this.f10308h = l;
        if (zzyy().zzabc()) {
            zzyx().zzb("Device AnalyticsService version", zze.VERSION);
        }
        i.initialize();
        this.f10312l = i;
        l.start();
    }

    private void m16641a(zzd com_google_android_gms_analytics_internal_zzd) {
        zzab.zzb((Object) com_google_android_gms_analytics_internal_zzd, (Object) "Analytics service not created/initialized");
        zzab.zzb(com_google_android_gms_analytics_internal_zzd.isInitialized(), (Object) "Analytics service not initialized");
    }

    public static zzf zzay(Context context) {
        zzab.zzy(context);
        if (f10301a == null) {
            synchronized (zzf.class) {
                if (f10301a == null) {
                    zze zzavm = zzh.zzavm();
                    long elapsedRealtime = zzavm.elapsedRealtime();
                    zzf com_google_android_gms_analytics_internal_zzf = new zzf(new zzg(context));
                    f10301a = com_google_android_gms_analytics_internal_zzf;
                    GoogleAnalytics.zzwa();
                    elapsedRealtime = zzavm.elapsedRealtime() - elapsedRealtime;
                    long longValue = ((Long) zzy.f10387D.get()).longValue();
                    if (elapsedRealtime > longValue) {
                        com_google_android_gms_analytics_internal_zzf.zzyx().zzc("Slow initialization (ms)", Long.valueOf(elapsedRealtime), Long.valueOf(longValue));
                    }
                }
            }
        }
        return f10301a;
    }

    protected UncaughtExceptionHandler m16642a() {
        return new C31931(this);
    }

    public Context getContext() {
        return this.f10302b;
    }

    public zzb zzwd() {
        m16641a(this.f10308h);
        return this.f10308h;
    }

    public zzap zzwe() {
        m16641a(this.f10310j);
        return this.f10310j;
    }

    public void zzwu() {
        zzi.zzwu();
    }

    public zze zzyw() {
        return this.f10304d;
    }

    public zzaf zzyx() {
        m16641a(this.f10306f);
        return this.f10306f;
    }

    public zzr zzyy() {
        return this.f10305e;
    }

    public zzi zzyz() {
        zzab.zzy(this.f10307g);
        return this.f10307g;
    }

    public zzv zzza() {
        m16641a(this.f10309i);
        return this.f10309i;
    }

    public zzai zzzb() {
        m16641a(this.f10311k);
        return this.f10311k;
    }

    public zzk zzze() {
        m16641a(this.f10315o);
        return this.f10315o;
    }

    public zzu zzzf() {
        return this.f10316p;
    }

    public Context zzzi() {
        return this.f10303c;
    }

    public zzaf zzzj() {
        return this.f10306f;
    }

    public GoogleAnalytics zzzk() {
        zzab.zzy(this.f10312l);
        zzab.zzb(this.f10312l.isInitialized(), (Object) "Analytics instance not initialized");
        return this.f10312l;
    }

    public zzai zzzl() {
        return (this.f10311k == null || !this.f10311k.isInitialized()) ? null : this.f10311k;
    }

    public zza zzzm() {
        m16641a(this.f10314n);
        return this.f10314n;
    }

    public zzn zzzn() {
        m16641a(this.f10313m);
        return this.f10313m;
    }
}
