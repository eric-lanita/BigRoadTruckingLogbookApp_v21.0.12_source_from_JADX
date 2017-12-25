package com.google.android.gms.measurement.internal;

import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.internal.zzab;

abstract class zzf {
    private static volatile Handler f12177b;
    private final zzx f12178a;
    private final Runnable f12179c = new C34031(this);
    private volatile long f12180d;
    private boolean f12181e = true;

    class C34031 implements Runnable {
        final /* synthetic */ zzf f12257a;

        C34031(zzf com_google_android_gms_measurement_internal_zzf) {
            this.f12257a = com_google_android_gms_measurement_internal_zzf;
        }

        public void run() {
            if (Looper.myLooper() == Looper.getMainLooper()) {
                this.f12257a.f12178a.zzbsc().zzm(this);
                return;
            }
            boolean zzfc = this.f12257a.zzfc();
            this.f12257a.f12180d = 0;
            if (zzfc && this.f12257a.f12181e) {
                this.f12257a.run();
            }
        }
    }

    zzf(zzx com_google_android_gms_measurement_internal_zzx) {
        zzab.zzy(com_google_android_gms_measurement_internal_zzx);
        this.f12178a = com_google_android_gms_measurement_internal_zzx;
    }

    private Handler m17751a() {
        if (f12177b != null) {
            return f12177b;
        }
        Handler handler;
        synchronized (zzf.class) {
            if (f12177b == null) {
                f12177b = new Handler(this.f12178a.getContext().getMainLooper());
            }
            handler = f12177b;
        }
        return handler;
    }

    public void cancel() {
        this.f12180d = 0;
        m17751a().removeCallbacks(this.f12179c);
    }

    public abstract void run();

    public boolean zzfc() {
        return this.f12180d != 0;
    }

    public void zzv(long j) {
        cancel();
        if (j >= 0) {
            this.f12180d = this.f12178a.zzyw().currentTimeMillis();
            if (!m17751a().postDelayed(this.f12179c, j)) {
                this.f12178a.zzbsd().zzbsv().zzj("Failed to schedule delayed post. time", Long.valueOf(j));
            }
        }
    }
}
