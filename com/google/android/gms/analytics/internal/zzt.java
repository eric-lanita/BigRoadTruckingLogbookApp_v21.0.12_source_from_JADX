package com.google.android.gms.analytics.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

abstract class zzt {
    private static volatile Handler f10325b;
    private final zzf f10326a;
    private final Runnable f10327c = new C32041(this);
    private volatile long f10328d;

    class C32041 implements Runnable {
        final /* synthetic */ zzt f10378a;

        C32041(zzt com_google_android_gms_analytics_internal_zzt) {
            this.f10378a = com_google_android_gms_analytics_internal_zzt;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f10378a.f10326a.zzyz().zzg(this);
                return;
            }
            boolean zzfc = this.f10378a.zzfc();
            this.f10378a.f10328d = 0;
            if (zzfc && !false) {
                this.f10378a.run();
            }
        }
    }

    zzt(zzf com_google_android_gms_analytics_internal_zzf) {
        zzab.zzy(com_google_android_gms_analytics_internal_zzf);
        this.f10326a = com_google_android_gms_analytics_internal_zzf;
    }

    private Handler m16657a() {
        if (f10325b != null) {
            return f10325b;
        }
        Handler handler;
        synchronized (zzt.class) {
            if (f10325b == null) {
                f10325b = new Handler(this.f10326a.getContext().getMainLooper());
            }
            handler = f10325b;
        }
        return handler;
    }

    public void cancel() {
        this.f10328d = 0;
        m16657a().removeCallbacks(this.f10327c);
    }

    public abstract void run();

    public long zzacj() {
        return this.f10328d == 0 ? 0 : Math.abs(this.f10326a.zzyw().currentTimeMillis() - this.f10328d);
    }

    public boolean zzfc() {
        return this.f10328d != 0;
    }

    public void zzv(long j) {
        cancel();
        if (j >= 0) {
            this.f10328d = this.f10326a.zzyw().currentTimeMillis();
            if (!m16657a().postDelayed(this.f10327c, j)) {
                this.f10326a.zzyx().zze("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }

    public void zzw(long j) {
        long j2 = 0;
        if (!zzfc()) {
            return;
        }
        if (j < 0) {
            cancel();
            return;
        }
        long abs = j - Math.abs(this.f10326a.zzyw().currentTimeMillis() - this.f10328d);
        if (abs >= 0) {
            j2 = abs;
        }
        m16657a().removeCallbacks(this.f10327c);
        if (!m16657a().postDelayed(this.f10327c, j2)) {
            this.f10326a.zzyx().zze("Failed to adjust delayed post. time", Long.valueOf(j2));
        }
    }
}
