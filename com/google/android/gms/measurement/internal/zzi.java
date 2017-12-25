package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;

class zzi {
    final String f12267a;
    final String f12268b;
    final long f12269c;
    final long f12270d;
    final long f12271e;

    zzi(String str, String str2, long j, long j2, long j3) {
        boolean z = true;
        zzab.zzhr(str);
        zzab.zzhr(str2);
        zzab.zzbo(j >= 0);
        if (j2 < 0) {
            z = false;
        }
        zzab.zzbo(z);
        this.f12267a = str;
        this.f12268b = str2;
        this.f12269c = j;
        this.f12270d = j2;
        this.f12271e = j3;
    }

    zzi m17873a() {
        return new zzi(this.f12267a, this.f12268b, this.f12269c + 1, this.f12270d + 1, this.f12271e);
    }

    zzi m17874a(long j) {
        return new zzi(this.f12267a, this.f12268b, this.f12269c, this.f12270d, j);
    }
}
