package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.analytics.zzi;
import com.google.android.gms.common.internal.zzab;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class zzb extends zzd {
    private final zzl f10299a;

    class C31905 implements Runnable {
        final /* synthetic */ zzb f10295a;

        C31905(zzb com_google_android_gms_analytics_internal_zzb) {
            this.f10295a = com_google_android_gms_analytics_internal_zzb;
        }

        public void run() {
            this.f10295a.f10299a.zzyo();
        }
    }

    class C31927 implements Callable<Void> {
        final /* synthetic */ zzb f10298a;

        C31927(zzb com_google_android_gms_analytics_internal_zzb) {
            this.f10298a = com_google_android_gms_analytics_internal_zzb;
        }

        public /* synthetic */ Object call() {
            return zzcx();
        }

        public Void zzcx() {
            this.f10298a.f10299a.zzaal();
            return null;
        }
    }

    public zzb(zzf com_google_android_gms_analytics_internal_zzf, zzg com_google_android_gms_analytics_internal_zzg) {
        super(com_google_android_gms_analytics_internal_zzf);
        zzab.zzy(com_google_android_gms_analytics_internal_zzg);
        this.f10299a = com_google_android_gms_analytics_internal_zzg.m16653j(com_google_android_gms_analytics_internal_zzf);
    }

    protected void mo1605a() {
        this.f10299a.initialize();
    }

    void m16639b() {
        m16538e();
        this.f10299a.m16709u();
    }

    void m16640c() {
        m16538e();
        this.f10299a.m16708t();
    }

    public void setLocalDispatchPeriod(final int i) {
        m16553s();
        zzb("setLocalDispatchPeriod (sec)", Integer.valueOf(i));
        m16543j().zzg(new Runnable(this) {
            final /* synthetic */ zzb f10287b;

            public void run() {
                this.f10287b.f10299a.zzu(((long) i) * 1000);
            }
        });
    }

    public void start() {
        this.f10299a.m16706b();
    }

    public long zza(zzh com_google_android_gms_analytics_internal_zzh) {
        m16553s();
        zzab.zzy(com_google_android_gms_analytics_internal_zzh);
        m16538e();
        long zza = this.f10299a.zza(com_google_android_gms_analytics_internal_zzh, true);
        if (zza == 0) {
            this.f10299a.m16705a(com_google_android_gms_analytics_internal_zzh);
        }
        return zza;
    }

    public void zza(final zzab com_google_android_gms_analytics_internal_zzab) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzab);
        m16553s();
        zzb("Hit delivery requested", com_google_android_gms_analytics_internal_zzab);
        m16543j().zzg(new Runnable(this) {
            final /* synthetic */ zzb f10294b;

            public void run() {
                this.f10294b.f10299a.zza(com_google_android_gms_analytics_internal_zzab);
            }
        });
    }

    public void zza(final zzw com_google_android_gms_analytics_internal_zzw) {
        m16553s();
        m16543j().zzg(new Runnable(this) {
            final /* synthetic */ zzb f10297b;

            public void run() {
                this.f10297b.f10299a.zzb(com_google_android_gms_analytics_internal_zzw);
            }
        });
    }

    public void zza(final String str, final Runnable runnable) {
        zzab.zzh(str, "campaign param can't be empty");
        m16543j().zzg(new Runnable(this) {
            final /* synthetic */ zzb f10292c;

            public void run() {
                this.f10292c.f10299a.zzep(str);
                if (runnable != null) {
                    runnable.run();
                }
            }
        });
    }

    public void zzas(final boolean z) {
        zza("Network connectivity status changed", Boolean.valueOf(z));
        m16543j().zzg(new Runnable(this) {
            final /* synthetic */ zzb f10289b;

            public void run() {
                this.f10289b.f10299a.zzas(z);
            }
        });
    }

    public void zzyo() {
        m16553s();
        m16537d();
        m16543j().zzg(new C31905(this));
    }

    public void zzyp() {
        m16553s();
        Context g = m16540g();
        if (zzaj.zzav(g) && zzak.zzaw(g)) {
            Intent intent = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent.setComponent(new ComponentName(g, "com.google.android.gms.analytics.AnalyticsService"));
            g.startService(intent);
            return;
        }
        zza(null);
    }

    public boolean zzyq() {
        m16553s();
        try {
            m16543j().zzc(new C31927(this)).get(4, TimeUnit.SECONDS);
            return true;
        } catch (InterruptedException e) {
            zzd("syncDispatchLocalHits interrupted", e);
            return false;
        } catch (ExecutionException e2) {
            zze("syncDispatchLocalHits failed", e2);
            return false;
        } catch (TimeoutException e3) {
            zzd("syncDispatchLocalHits timed out", e3);
            return false;
        }
    }

    public void zzyr() {
        m16553s();
        zzi.zzwu();
        this.f10299a.zzyr();
    }

    public void zzys() {
        zzeh("Radio powered up");
        zzyp();
    }
}
