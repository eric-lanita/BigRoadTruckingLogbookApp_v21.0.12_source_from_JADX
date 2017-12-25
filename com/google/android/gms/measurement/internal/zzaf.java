package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.util.zze;

public class zzaf extends zzaa {
    private Handler f12228a;
    private long f12229c;
    private final Runnable f12230d = new C33981(this);
    private final zzf f12231e = new zzf(this, this.b) {
        final /* synthetic */ zzaf f12222a;

        public void run() {
            this.f12222a.m17788h();
        }
    };
    private final zzf f12232f = new zzf(this, this.b) {
        final /* synthetic */ zzaf f12223a;

        public void run() {
            this.f12223a.m17789i();
        }
    };

    class C33981 implements Runnable {
        final /* synthetic */ zzaf f12221a;

        class C33971 implements Runnable {
            final /* synthetic */ C33981 f12220a;

            C33971(C33981 c33981) {
                this.f12220a = c33981;
            }

            public void run() {
                this.f12220a.f12221a.zzbva();
            }
        }

        C33981(zzaf com_google_android_gms_measurement_internal_zzaf) {
            this.f12221a = com_google_android_gms_measurement_internal_zzaf;
        }

        public void run() {
            this.f12221a.zzbsc().zzm(new C33971(this));
        }
    }

    zzaf(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
    }

    private void m17781a(long j) {
        zzwu();
        m17787g();
        this.f12231e.cancel();
        this.f12232f.cancel();
        zzbsd().zzbtc().zzj("Activity resumed, time", Long.valueOf(j));
        this.f12229c = j;
        if (zzyw().currentTimeMillis() - zzbse().aki.get() > zzbse().akk.get()) {
            zzbse().akj.set(true);
            zzbse().akl.set(0);
        }
        if (zzbse().akj.get()) {
            this.f12231e.zzv(Math.max(0, zzbse().akh.get() - zzbse().akl.get()));
        } else {
            this.f12232f.zzv(Math.max(0, 3600000 - zzbse().akl.get()));
        }
    }

    private void m17784b(long j) {
        zzwu();
        m17787g();
        this.f12231e.cancel();
        this.f12232f.cancel();
        zzbsd().zzbtc().zzj("Activity paused, time", Long.valueOf(j));
        if (this.f12229c != 0) {
            zzbse().akl.set(zzbse().akl.get() + (j - this.f12229c));
        }
        zzbse().akk.set(zzyw().currentTimeMillis());
        synchronized (this) {
            if (!zzbse().akj.get()) {
                this.f12228a.postDelayed(this.f12230d, 1000);
            }
        }
    }

    private void m17787g() {
        synchronized (this) {
            if (this.f12228a == null) {
                this.f12228a = new Handler(Looper.getMainLooper());
            }
        }
    }

    private void m17788h() {
        zzwu();
        zzbsd().zzbtc().zzj("Session started, time", Long.valueOf(zzyw().elapsedRealtime()));
        zzbse().akj.set(false);
        zzbru().zze("auto", "_s", new Bundle());
    }

    private void m17789i() {
        zzwu();
        long elapsedRealtime = zzyw().elapsedRealtime();
        if (this.f12229c == 0) {
            this.f12229c = elapsedRealtime - 3600000;
        }
        long j = zzbse().akl.get() + (elapsedRealtime - this.f12229c);
        zzbse().akl.set(j);
        zzbsd().zzbtc().zzj("Recording user engagement, ms", Long.valueOf(j));
        Bundle bundle = new Bundle();
        bundle.putLong("_et", j);
        zzbru().zze("auto", "_e", bundle);
        zzbse().akl.set(0);
        this.f12229c = elapsedRealtime;
        this.f12232f.zzv(Math.max(0, 3600000 - zzbse().akl.get()));
    }

    protected void mo2375d() {
    }

    protected void m17791e() {
        synchronized (this) {
            m17787g();
            this.f12228a.removeCallbacks(this.f12230d);
        }
        final long elapsedRealtime = zzyw().elapsedRealtime();
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzaf f12225b;

            public void run() {
                this.f12225b.m17781a(elapsedRealtime);
            }
        });
    }

    protected void m17792f() {
        final long elapsedRealtime = zzyw().elapsedRealtime();
        zzbsc().zzm(new Runnable(this) {
            final /* synthetic */ zzaf f12227b;

            public void run() {
                this.f12227b.m17784b(elapsedRealtime);
            }
        });
    }

    public /* bridge */ /* synthetic */ Context getContext() {
        return super.getContext();
    }

    public /* bridge */ /* synthetic */ void zzbrs() {
        super.zzbrs();
    }

    public /* bridge */ /* synthetic */ zzc zzbrt() {
        return super.zzbrt();
    }

    public /* bridge */ /* synthetic */ zzac zzbru() {
        return super.zzbru();
    }

    public /* bridge */ /* synthetic */ zzn zzbrv() {
        return super.zzbrv();
    }

    public /* bridge */ /* synthetic */ zzg zzbrw() {
        return super.zzbrw();
    }

    public /* bridge */ /* synthetic */ zzad zzbrx() {
        return super.zzbrx();
    }

    public /* bridge */ /* synthetic */ zze zzbry() {
        return super.zzbry();
    }

    public /* bridge */ /* synthetic */ zzal zzbrz() {
        return super.zzbrz();
    }

    public /* bridge */ /* synthetic */ zzv zzbsa() {
        return super.zzbsa();
    }

    public /* bridge */ /* synthetic */ zzaf zzbsb() {
        return super.zzbsb();
    }

    public /* bridge */ /* synthetic */ zzw zzbsc() {
        return super.zzbsc();
    }

    public /* bridge */ /* synthetic */ zzp zzbsd() {
        return super.zzbsd();
    }

    public /* bridge */ /* synthetic */ zzt zzbse() {
        return super.zzbse();
    }

    public /* bridge */ /* synthetic */ zzd zzbsf() {
        return super.zzbsf();
    }

    public void zzbva() {
        zzwu();
        zzbsd().zzbtb().log("Application backgrounded. Logging engagement");
        long j = zzbse().akl.get();
        if (j > 0) {
            Bundle bundle = new Bundle();
            bundle.putLong("_et", j);
            zzbru().zze("auto", "_e", bundle);
            zzbse().akl.set(0);
            return;
        }
        zzbsd().zzbsx().zzj("Not logging non-positive engagement time", Long.valueOf(j));
    }

    public /* bridge */ /* synthetic */ void zzwu() {
        super.zzwu();
    }

    public /* bridge */ /* synthetic */ void zzyv() {
        super.zzyv();
    }

    public /* bridge */ /* synthetic */ zze zzyw() {
        return super.zzyw();
    }
}
