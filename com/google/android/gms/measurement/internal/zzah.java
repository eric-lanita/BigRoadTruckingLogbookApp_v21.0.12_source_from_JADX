package com.google.android.gms.measurement.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

class zzah {
    private final zze f12239a;
    private long f12240b;

    public zzah(zze com_google_android_gms_common_util_zze) {
        zzab.zzy(com_google_android_gms_common_util_zze);
        this.f12239a = com_google_android_gms_common_util_zze;
    }

    public void clear() {
        this.f12240b = 0;
    }

    public void start() {
        this.f12240b = this.f12239a.elapsedRealtime();
    }

    public boolean zzx(long j) {
        return this.f12240b == 0 || this.f12239a.elapsedRealtime() - this.f12240b >= j;
    }
}
