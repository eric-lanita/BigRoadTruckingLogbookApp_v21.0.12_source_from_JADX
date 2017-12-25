package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;
import com.google.android.gms.common.util.zzh;

class zzcz implements zzck {
    private final long f12686a;
    private final int f12687b;
    private double f12688c;
    private long f12689d;
    private final Object f12690e;
    private final zze f12691f;

    public zzcz() {
        this(60, 2000);
    }

    public zzcz(int i, long j) {
        this.f12690e = new Object();
        this.f12687b = i;
        this.f12688c = (double) this.f12687b;
        this.f12686a = j;
        this.f12691f = zzh.zzavm();
    }

    public boolean zzade() {
        boolean z;
        synchronized (this.f12690e) {
            long currentTimeMillis = this.f12691f.currentTimeMillis();
            if (this.f12688c < ((double) this.f12687b)) {
                double d = ((double) (currentTimeMillis - this.f12689d)) / ((double) this.f12686a);
                if (d > 0.0d) {
                    this.f12688c = Math.min((double) this.f12687b, d + this.f12688c);
                }
            }
            this.f12689d = currentTimeMillis;
            if (this.f12688c >= 1.0d) {
                this.f12688c -= 1.0d;
                z = true;
            } else {
                zzbn.zzcx("No more tokens available.");
                z = false;
            }
        }
        return z;
    }
}
