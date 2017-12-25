package com.google.android.gms.internal;

import java.util.Arrays;

final class zzapx {
    final int f11371a;
    final byte[] f11372b;

    zzapx(int i, byte[] bArr) {
        this.f11371a = i;
        this.f11372b = bArr;
    }

    int m17348a() {
        return (zzapo.zzagc(this.f11371a) + 0) + this.f11372b.length;
    }

    void m17349a(zzapo com_google_android_gms_internal_zzapo) {
        com_google_android_gms_internal_zzapo.zzagb(this.f11371a);
        com_google_android_gms_internal_zzapo.zzbh(this.f11372b);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzapx)) {
            return false;
        }
        zzapx com_google_android_gms_internal_zzapx = (zzapx) obj;
        return this.f11371a == com_google_android_gms_internal_zzapx.f11371a && Arrays.equals(this.f11372b, com_google_android_gms_internal_zzapx.f11372b);
    }

    public int hashCode() {
        return ((this.f11371a + 527) * 31) + Arrays.hashCode(this.f11372b);
    }
}
