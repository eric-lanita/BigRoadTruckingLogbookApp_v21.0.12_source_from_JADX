package com.google.android.gms.common;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.util.Log;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.common.internal.zzs;

public class zzf {
    private static zzf f10925a;
    private final Context f10926b;

    private zzf(Context context) {
        this.f10926b = context.getApplicationContext();
    }

    private boolean m17028a(PackageInfo packageInfo, boolean z) {
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return false;
        }
        zza com_google_android_gms_common_zzd_zzb = new zzb(packageInfo.signatures[0].toByteArray());
        for (zzs equals : z ? zzd.m17023a() : zzd.m17026b()) {
            if (com_google_android_gms_common_zzd_zzb.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static zzf zzbz(Context context) {
        zzab.zzy(context);
        synchronized (zzf.class) {
            if (f10925a == null) {
                zzd.m17025a(context);
                f10925a = new zzf(context);
            }
        }
        return f10925a;
    }

    zza m17029a(PackageInfo packageInfo, zza... com_google_android_gms_common_zzd_zzaArr) {
        int i = 0;
        if (packageInfo.signatures == null) {
            return null;
        }
        if (packageInfo.signatures.length != 1) {
            Log.w("GoogleSignatureVerifier", "Package has more than one signature.");
            return null;
        }
        zzb com_google_android_gms_common_zzd_zzb = new zzb(packageInfo.signatures[0].toByteArray());
        while (i < com_google_android_gms_common_zzd_zzaArr.length) {
            if (com_google_android_gms_common_zzd_zzaArr[i].equals(com_google_android_gms_common_zzd_zzb)) {
                return com_google_android_gms_common_zzd_zzaArr[i];
            }
            i++;
        }
        return null;
    }

    public boolean zza(PackageInfo packageInfo, boolean z) {
        if (!(packageInfo == null || packageInfo.signatures == null)) {
            zza a;
            if (z) {
                a = m17029a(packageInfo, zzd.f10920a);
            } else {
                a = m17029a(packageInfo, zzd.f10920a[0]);
            }
            if (a != null) {
                return true;
            }
        }
        return false;
    }

    public boolean zza(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zze.zzbu(this.f10926b)) {
            return m17028a(packageInfo, true);
        }
        boolean a = m17028a(packageInfo, false);
        if (a || !m17028a(packageInfo, true)) {
            return a;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return a;
    }

    public boolean zzb(PackageManager packageManager, PackageInfo packageInfo) {
        if (packageInfo == null) {
            return false;
        }
        if (zza(packageInfo, false)) {
            return true;
        }
        if (!zza(packageInfo, true)) {
            return false;
        }
        if (zze.zzbu(this.f10926b)) {
            return true;
        }
        Log.w("GoogleSignatureVerifier", "Test-keys aren't accepted on this build.");
        return false;
    }

    public boolean zzb(PackageManager packageManager, String str) {
        try {
            return zza(packageManager, packageManager.getPackageInfo(str, 64));
        } catch (NameNotFoundException e) {
            return false;
        }
    }
}
