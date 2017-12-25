package com.google.android.gms.tagmanager;

import com.google.android.gms.common.util.zze;

class zzbl implements zzck {
    private final long f12573a;
    private final long f12574b;
    private final int f12575c;
    private double f12576d;
    private long f12577e;
    private final Object f12578f = new Object();
    private final String f12579g;
    private final zze f12580h;

    public zzbl(int i, long j, long j2, String str, zze com_google_android_gms_common_util_zze) {
        this.f12575c = i;
        this.f12576d = (double) this.f12575c;
        this.f12573a = j;
        this.f12574b = j2;
        this.f12579g = str;
        this.f12580h = com_google_android_gms_common_util_zze;
    }

    public boolean zzade() {
        boolean z = false;
        synchronized (this.f12578f) {
            long currentTimeMillis = this.f12580h.currentTimeMillis();
            String str;
            if (currentTimeMillis - this.f12577e < this.f12574b) {
                str = this.f12579g;
                zzbn.zzcx(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
            } else {
                if (this.f12576d < ((double) this.f12575c)) {
                    double d = ((double) (currentTimeMillis - this.f12577e)) / ((double) this.f12573a);
                    if (d > 0.0d) {
                        this.f12576d = Math.min((double) this.f12575c, d + this.f12576d);
                    }
                }
                this.f12577e = currentTimeMillis;
                if (this.f12576d >= 1.0d) {
                    this.f12576d -= 1.0d;
                    z = true;
                } else {
                    str = this.f12579g;
                    zzbn.zzcx(new StringBuilder(String.valueOf(str).length() + 34).append("Excessive ").append(str).append(" detected; call ignored.").toString());
                }
            }
        }
        return z;
    }
}
