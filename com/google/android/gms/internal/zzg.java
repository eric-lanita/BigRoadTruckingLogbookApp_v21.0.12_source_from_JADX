package com.google.android.gms.internal;

import android.annotation.TargetApi;
import android.net.TrafficStats;
import android.os.Build.VERSION;
import android.os.Process;
import android.os.SystemClock;
import java.util.concurrent.BlockingQueue;

public class zzg extends Thread {
    private final BlockingQueue<zzk<?>> f11393a;
    private final zzf f11394b;
    private final zzb f11395c;
    private final zzn f11396d;
    private volatile boolean f11397e = false;

    public zzg(BlockingQueue<zzk<?>> blockingQueue, zzf com_google_android_gms_internal_zzf, zzb com_google_android_gms_internal_zzb, zzn com_google_android_gms_internal_zzn) {
        super("VolleyNetworkDispatcher");
        this.f11393a = blockingQueue;
        this.f11394b = com_google_android_gms_internal_zzf;
        this.f11395c = com_google_android_gms_internal_zzb;
        this.f11396d = com_google_android_gms_internal_zzn;
    }

    @TargetApi(14)
    private void m17353a(zzk<?> com_google_android_gms_internal_zzk_) {
        if (VERSION.SDK_INT >= 14) {
            TrafficStats.setThreadStatsTag(com_google_android_gms_internal_zzk_.zzf());
        }
    }

    private void m17354a(zzk<?> com_google_android_gms_internal_zzk_, zzr com_google_android_gms_internal_zzr) {
        this.f11396d.zza((zzk) com_google_android_gms_internal_zzk_, com_google_android_gms_internal_zzk_.m17133a(com_google_android_gms_internal_zzr));
    }

    public void quit() {
        this.f11397e = true;
        interrupt();
    }

    public void run() {
        Process.setThreadPriority(10);
        while (true) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            try {
                zzk com_google_android_gms_internal_zzk = (zzk) this.f11393a.take();
                try {
                    com_google_android_gms_internal_zzk.zzc("network-queue-take");
                    if (com_google_android_gms_internal_zzk.isCanceled()) {
                        com_google_android_gms_internal_zzk.m17137b("network-discard-cancelled");
                    } else {
                        m17353a(com_google_android_gms_internal_zzk);
                        zzi zza = this.f11394b.zza(com_google_android_gms_internal_zzk);
                        com_google_android_gms_internal_zzk.zzc("network-http-complete");
                        if (zza.zzaa && com_google_android_gms_internal_zzk.zzv()) {
                            com_google_android_gms_internal_zzk.m17137b("not-modified");
                        } else {
                            zzm a = com_google_android_gms_internal_zzk.mo1810a(zza);
                            com_google_android_gms_internal_zzk.zzc("network-parse-complete");
                            if (com_google_android_gms_internal_zzk.zzq() && a.zzbf != null) {
                                this.f11395c.zza(com_google_android_gms_internal_zzk.zzg(), a.zzbf);
                                com_google_android_gms_internal_zzk.zzc("network-cache-written");
                            }
                            com_google_android_gms_internal_zzk.zzu();
                            this.f11396d.zza(com_google_android_gms_internal_zzk, a);
                        }
                    }
                } catch (zzr e) {
                    e.m17127a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    m17354a(com_google_android_gms_internal_zzk, e);
                } catch (Throwable e2) {
                    zzs.zza(e2, "Unhandled exception %s", e2.toString());
                    zzr com_google_android_gms_internal_zzr = new zzr(e2);
                    com_google_android_gms_internal_zzr.m17127a(SystemClock.elapsedRealtime() - elapsedRealtime);
                    this.f11396d.zza(com_google_android_gms_internal_zzk, com_google_android_gms_internal_zzr);
                }
            } catch (InterruptedException e3) {
                if (this.f11397e) {
                    return;
                }
            }
        }
    }
}
