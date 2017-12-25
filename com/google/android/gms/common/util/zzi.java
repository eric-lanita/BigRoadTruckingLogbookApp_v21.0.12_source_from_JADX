package com.google.android.gms.common.util;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

public final class zzi {
    private static Boolean f10894a;
    private static Boolean f10895b;
    private static Boolean f10896c;
    private static Boolean f10897d;

    @TargetApi(13)
    private static boolean m17004a(Resources resources) {
        if (f10895b == null) {
            Configuration configuration = resources.getConfiguration();
            boolean z = zzs.zzavp() && (configuration.screenLayout & 15) <= 3 && configuration.smallestScreenWidthDp >= 600;
            f10895b = Boolean.valueOf(z);
        }
        return f10895b.booleanValue();
    }

    public static boolean zzb(Resources resources) {
        boolean z = false;
        if (resources == null) {
            return false;
        }
        if (f10894a == null) {
            boolean z2 = (resources.getConfiguration().screenLayout & 15) > 3;
            if ((zzs.zzavn() && z2) || m17004a(resources)) {
                z = true;
            }
            f10894a = Boolean.valueOf(z);
        }
        return f10894a.booleanValue();
    }

    @TargetApi(20)
    public static boolean zzck(Context context) {
        if (f10896c == null) {
            boolean z = zzs.zzavv() && context.getPackageManager().hasSystemFeature("android.hardware.type.watch");
            f10896c = Boolean.valueOf(z);
        }
        return f10896c.booleanValue();
    }

    @TargetApi(21)
    public static boolean zzcl(Context context) {
        if (f10897d == null) {
            boolean z = zzs.zzavx() && context.getPackageManager().hasSystemFeature("cn.google");
            f10897d = Boolean.valueOf(z);
        }
        return f10897d.booleanValue();
    }
}
