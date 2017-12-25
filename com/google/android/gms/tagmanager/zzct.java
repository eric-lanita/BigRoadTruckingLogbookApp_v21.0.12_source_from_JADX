package com.google.android.gms.tagmanager;

import android.content.Context;
import com.google.android.gms.internal.zzah.zzj;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

class zzct implements zze {
    private final String f12639a;
    private final Context f12640b;
    private final ScheduledExecutorService f12641c;
    private final zza f12642d;
    private ScheduledFuture<?> f12643e;
    private boolean f12644f;
    private zzs f12645g;
    private String f12646h;
    private zzbm<zzj> f12647i;

    interface zzb {
        ScheduledExecutorService zzccp();
    }

    class C34331 implements zzb {
        final /* synthetic */ zzct f12637a;

        C34331(zzct com_google_android_gms_tagmanager_zzct) {
            this.f12637a = com_google_android_gms_tagmanager_zzct;
        }

        public ScheduledExecutorService zzccp() {
            return Executors.newSingleThreadScheduledExecutor();
        }
    }

    interface zza {
        zzcs zza(zzs com_google_android_gms_tagmanager_zzs);
    }

    class C34342 implements zza {
        final /* synthetic */ zzct f12638a;

        C34342(zzct com_google_android_gms_tagmanager_zzct) {
            this.f12638a = com_google_android_gms_tagmanager_zzct;
        }

        public zzcs zza(zzs com_google_android_gms_tagmanager_zzs) {
            return new zzcs(this.f12638a.f12640b, this.f12638a.f12639a, com_google_android_gms_tagmanager_zzs);
        }
    }

    public zzct(Context context, String str, zzs com_google_android_gms_tagmanager_zzs) {
        this(context, str, com_google_android_gms_tagmanager_zzs, null, null);
    }

    zzct(Context context, String str, zzs com_google_android_gms_tagmanager_zzs, zzb com_google_android_gms_tagmanager_zzct_zzb, zza com_google_android_gms_tagmanager_zzct_zza) {
        this.f12645g = com_google_android_gms_tagmanager_zzs;
        this.f12640b = context;
        this.f12639a = str;
        if (com_google_android_gms_tagmanager_zzct_zzb == null) {
            com_google_android_gms_tagmanager_zzct_zzb = new C34331(this);
        }
        this.f12641c = com_google_android_gms_tagmanager_zzct_zzb.zzccp();
        if (com_google_android_gms_tagmanager_zzct_zza == null) {
            this.f12642d = new C34342(this);
        } else {
            this.f12642d = com_google_android_gms_tagmanager_zzct_zza;
        }
    }

    private zzcs m18144a(String str) {
        zzcs zza = this.f12642d.zza(this.f12645g);
        zza.m18140a(this.f12647i);
        zza.m18141a(this.f12646h);
        zza.m18142b(str);
        return zza;
    }

    private synchronized void m18145a() {
        if (this.f12644f) {
            throw new IllegalStateException("called method after closed");
        }
    }

    public synchronized void release() {
        m18145a();
        if (this.f12643e != null) {
            this.f12643e.cancel(false);
        }
        this.f12641c.shutdown();
        this.f12644f = true;
    }

    public synchronized void zza(zzbm<zzj> com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzah_zzj) {
        m18145a();
        this.f12647i = com_google_android_gms_tagmanager_zzbm_com_google_android_gms_internal_zzah_zzj;
    }

    public synchronized void zzf(long j, String str) {
        String str2 = this.f12639a;
        zzbn.m18106v(new StringBuilder(String.valueOf(str2).length() + 55).append("loadAfterDelay: containerId=").append(str2).append(" delay=").append(j).toString());
        m18145a();
        if (this.f12647i == null) {
            throw new IllegalStateException("callback must be set before loadAfterDelay() is called.");
        }
        if (this.f12643e != null) {
            this.f12643e.cancel(false);
        }
        this.f12643e = this.f12641c.schedule(m18144a(str), j, TimeUnit.MILLISECONDS);
    }

    public synchronized void zzol(String str) {
        m18145a();
        this.f12646h = str;
    }
}
