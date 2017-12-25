package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.util.zze;

public class zzad {
    private final long f10234a;
    private final int f10235b;
    private double f10236c;
    private long f10237d;
    private final Object f10238e;
    private final String f10239f;
    private final zze f10240g;

    public zzad(int i, long j, String str, zze com_google_android_gms_common_util_zze) {
        this.f10238e = new Object();
        this.f10235b = i;
        this.f10236c = (double) this.f10235b;
        this.f10234a = j;
        this.f10239f = str;
        this.f10240g = com_google_android_gms_common_util_zze;
    }

    public zzad(String str, zze com_google_android_gms_common_util_zze) {
        this(60, 2000, str, com_google_android_gms_common_util_zze);
    }

    public boolean zzade() {
        boolean z;
        synchronized (this.f10238e) {
            long currentTimeMillis = this.f10240g.currentTimeMillis();
            if (this.f10236c < ((double) this.f10235b)) {
                double d = ((double) (currentTimeMillis - this.f10237d)) / ((double) this.f10234a);
                if (d > 0.0d) {
                    this.f10236c = Math.min((double) this.f10235b, d + this.f10236c);
                }
            }
            this.f10237d = currentTimeMillis;
            if (this.f10236c >= 1.0d) {
                this.f10236c -= 1.0d;
                z = true;
            } else {
                String str = this.f10239f;
                zzae.zzcx(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                z = false;
            }
        }
        return z;
    }
}
