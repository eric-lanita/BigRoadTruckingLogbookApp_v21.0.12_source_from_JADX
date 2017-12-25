package com.google.android.gms.common.util;

import android.os.SystemClock;

public final class zzh implements zze {
    private static zzh f10893a;

    public static synchronized zze zzavm() {
        zze com_google_android_gms_common_util_zze;
        synchronized (zzh.class) {
            if (f10893a == null) {
                f10893a = new zzh();
            }
            com_google_android_gms_common_util_zze = f10893a;
        }
        return com_google_android_gms_common_util_zze;
    }

    public long currentTimeMillis() {
        return System.currentTimeMillis();
    }

    public long elapsedRealtime() {
        return SystemClock.elapsedRealtime();
    }

    public long nanoTime() {
        return System.nanoTime();
    }
}
