package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzuf.zzd;

class zzs {
    final boolean f12320a;
    final int f12321b;
    long f12322c;
    double f12323d;
    long f12324e;
    double f12325f;
    long f12326g;
    double f12327h;
    final boolean f12328i;

    public zzs(zzd com_google_android_gms_internal_zzuf_zzd) {
        boolean z;
        boolean z2 = true;
        zzab.zzy(com_google_android_gms_internal_zzuf_zzd);
        if (com_google_android_gms_internal_zzuf_zzd.amN == null || com_google_android_gms_internal_zzuf_zzd.amN.intValue() == 0) {
            z = false;
        } else {
            if (com_google_android_gms_internal_zzuf_zzd.amN.intValue() != 4) {
                if (com_google_android_gms_internal_zzuf_zzd.amP == null) {
                    z = false;
                }
            } else if (com_google_android_gms_internal_zzuf_zzd.amQ == null || com_google_android_gms_internal_zzuf_zzd.amR == null) {
                z = false;
            }
            z = true;
        }
        if (z) {
            this.f12321b = com_google_android_gms_internal_zzuf_zzd.amN.intValue();
            if (com_google_android_gms_internal_zzuf_zzd.amO == null || !com_google_android_gms_internal_zzuf_zzd.amO.booleanValue()) {
                z2 = false;
            }
            this.f12320a = z2;
            if (com_google_android_gms_internal_zzuf_zzd.amN.intValue() == 4) {
                if (this.f12320a) {
                    this.f12325f = Double.parseDouble(com_google_android_gms_internal_zzuf_zzd.amQ);
                    this.f12327h = Double.parseDouble(com_google_android_gms_internal_zzuf_zzd.amR);
                } else {
                    this.f12324e = Long.parseLong(com_google_android_gms_internal_zzuf_zzd.amQ);
                    this.f12326g = Long.parseLong(com_google_android_gms_internal_zzuf_zzd.amR);
                }
            } else if (this.f12320a) {
                this.f12323d = Double.parseDouble(com_google_android_gms_internal_zzuf_zzd.amP);
            } else {
                this.f12322c = Long.parseLong(com_google_android_gms_internal_zzuf_zzd.amP);
            }
        } else {
            this.f12321b = 0;
            this.f12320a = false;
        }
        this.f12328i = z;
    }

    public Boolean zzbk(long j) {
        boolean z = true;
        if (!this.f12328i) {
            return null;
        }
        if (this.f12320a) {
            return null;
        }
        switch (this.f12321b) {
            case 1:
                if (j >= this.f12322c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (j <= this.f12322c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (j != this.f12322c) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 4:
                if (j < this.f12324e || j > this.f12326g) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }

    public Boolean zzj(double d) {
        boolean z = true;
        boolean z2 = false;
        if (!this.f12328i) {
            return null;
        }
        if (!this.f12320a) {
            return null;
        }
        switch (this.f12321b) {
            case 1:
                if (d >= this.f12323d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 2:
                if (d <= this.f12323d) {
                    z = false;
                }
                return Boolean.valueOf(z);
            case 3:
                if (d == this.f12323d || Math.abs(d - this.f12323d) < 2.0d * Math.max(Math.ulp(d), Math.ulp(this.f12323d))) {
                    z2 = true;
                }
                return Boolean.valueOf(z2);
            case 4:
                if (d < this.f12325f || d > this.f12327h) {
                    z = false;
                }
                return Boolean.valueOf(z);
            default:
                return null;
        }
    }
}
