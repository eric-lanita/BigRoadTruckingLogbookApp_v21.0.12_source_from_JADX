package com.google.android.gms.internal;

import android.os.Process;
import com.google.android.gms.internal.zzb.zza;
import java.util.concurrent.BlockingQueue;

public class zzc extends Thread {
    private static final boolean f11375a = zzs.DEBUG;
    private final BlockingQueue<zzk<?>> f11376b;
    private final BlockingQueue<zzk<?>> f11377c;
    private final zzb f11378d;
    private final zzn f11379e;
    private volatile boolean f11380f = false;

    public zzc(BlockingQueue<zzk<?>> blockingQueue, BlockingQueue<zzk<?>> blockingQueue2, zzb com_google_android_gms_internal_zzb, zzn com_google_android_gms_internal_zzn) {
        super("VolleyCacheDispatcher");
        this.f11376b = blockingQueue;
        this.f11377c = blockingQueue2;
        this.f11378d = com_google_android_gms_internal_zzb;
        this.f11379e = com_google_android_gms_internal_zzn;
    }

    public void quit() {
        this.f11380f = true;
        interrupt();
    }

    public void run() {
        if (f11375a) {
            zzs.zza("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        this.f11378d.initialize();
        while (true) {
            try {
                final zzk com_google_android_gms_internal_zzk = (zzk) this.f11376b.take();
                com_google_android_gms_internal_zzk.zzc("cache-queue-take");
                if (com_google_android_gms_internal_zzk.isCanceled()) {
                    com_google_android_gms_internal_zzk.m17137b("cache-discard-canceled");
                } else {
                    zza zza = this.f11378d.zza(com_google_android_gms_internal_zzk.zzg());
                    if (zza == null) {
                        com_google_android_gms_internal_zzk.zzc("cache-miss");
                        this.f11377c.put(com_google_android_gms_internal_zzk);
                    } else if (zza.zza()) {
                        com_google_android_gms_internal_zzk.zzc("cache-hit-expired");
                        com_google_android_gms_internal_zzk.zza(zza);
                        this.f11377c.put(com_google_android_gms_internal_zzk);
                    } else {
                        com_google_android_gms_internal_zzk.zzc("cache-hit");
                        zzm a = com_google_android_gms_internal_zzk.mo1810a(new zzi(zza.data, zza.zzf));
                        com_google_android_gms_internal_zzk.zzc("cache-hit-parsed");
                        if (zza.zzb()) {
                            com_google_android_gms_internal_zzk.zzc("cache-hit-refresh-needed");
                            com_google_android_gms_internal_zzk.zza(zza);
                            a.zzbh = true;
                            this.f11379e.zza(com_google_android_gms_internal_zzk, a, new Runnable(this) {
                                final /* synthetic */ zzc f11374b;

                                public void run() {
                                    try {
                                        this.f11374b.f11377c.put(com_google_android_gms_internal_zzk);
                                    } catch (InterruptedException e) {
                                    }
                                }
                            });
                        } else {
                            this.f11379e.zza(com_google_android_gms_internal_zzk, a);
                        }
                    }
                }
            } catch (InterruptedException e) {
                if (this.f11380f) {
                    return;
                }
            }
        }
    }
}
