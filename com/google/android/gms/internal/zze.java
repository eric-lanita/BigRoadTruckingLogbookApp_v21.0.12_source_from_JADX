package com.google.android.gms.internal;

import android.os.Handler;
import java.util.concurrent.Executor;

public class zze implements zzn {
    private final Executor f11392a;

    private class zza implements Runnable {
        final /* synthetic */ zze f11388a;
        private final zzk f11389b;
        private final zzm f11390c;
        private final Runnable f11391d;

        public zza(zze com_google_android_gms_internal_zze, zzk com_google_android_gms_internal_zzk, zzm com_google_android_gms_internal_zzm, Runnable runnable) {
            this.f11388a = com_google_android_gms_internal_zze;
            this.f11389b = com_google_android_gms_internal_zzk;
            this.f11390c = com_google_android_gms_internal_zzm;
            this.f11391d = runnable;
        }

        public void run() {
            if (this.f11389b.isCanceled()) {
                this.f11389b.m17137b("canceled-at-delivery");
                return;
            }
            if (this.f11390c.isSuccess()) {
                this.f11389b.mo1811a(this.f11390c.result);
            } else {
                this.f11389b.zzc(this.f11390c.zzbg);
            }
            if (this.f11390c.zzbh) {
                this.f11389b.zzc("intermediate-response");
            } else {
                this.f11389b.m17137b("done");
            }
            if (this.f11391d != null) {
                this.f11391d.run();
            }
        }
    }

    public zze(final Handler handler) {
        this.f11392a = new Executor(this) {
            final /* synthetic */ zze f11387b;

            public void execute(Runnable runnable) {
                handler.post(runnable);
            }
        };
    }

    public void zza(zzk<?> com_google_android_gms_internal_zzk_, zzm<?> com_google_android_gms_internal_zzm_) {
        zza(com_google_android_gms_internal_zzk_, com_google_android_gms_internal_zzm_, null);
    }

    public void zza(zzk<?> com_google_android_gms_internal_zzk_, zzm<?> com_google_android_gms_internal_zzm_, Runnable runnable) {
        com_google_android_gms_internal_zzk_.zzu();
        com_google_android_gms_internal_zzk_.zzc("post-response");
        this.f11392a.execute(new zza(this, com_google_android_gms_internal_zzk_, com_google_android_gms_internal_zzm_, runnable));
    }

    public void zza(zzk<?> com_google_android_gms_internal_zzk_, zzr com_google_android_gms_internal_zzr) {
        com_google_android_gms_internal_zzk_.zzc("post-error");
        this.f11392a.execute(new zza(this, com_google_android_gms_internal_zzk_, zzm.zzd(com_google_android_gms_internal_zzr), null));
    }
}
