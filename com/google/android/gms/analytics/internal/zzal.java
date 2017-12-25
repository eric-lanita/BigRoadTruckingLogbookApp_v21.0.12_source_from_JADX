package com.google.android.gms.analytics.internal;

import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.util.zze;

class zzal {
    private final zze f10274a;
    private long f10275b;

    public zzal(zze com_google_android_gms_common_util_zze) {
        zzab.zzy(com_google_android_gms_common_util_zze);
        this.f10274a = com_google_android_gms_common_util_zze;
    }

    public zzal(zze com_google_android_gms_common_util_zze, long j) {
        zzab.zzy(com_google_android_gms_common_util_zze);
        this.f10274a = com_google_android_gms_common_util_zze;
        this.f10275b = j;
    }

    public void clear() {
        this.f10275b = 0;
    }

    public void start() {
        this.f10275b = this.f10274a.elapsedRealtime();
    }

    public boolean zzx(long j) {
        return this.f10275b == 0 || this.f10274a.elapsedRealtime() - this.f10275b > j;
    }
}
