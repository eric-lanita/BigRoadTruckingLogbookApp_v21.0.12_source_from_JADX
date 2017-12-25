package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.internal.zzrp;

public class zzz {
    private static Object f10808a = new Object();
    private static boolean f10809b;
    private static String f10810c;
    private static int f10811d;

    private static void m16947a(Context context) {
        synchronized (f10808a) {
            if (f10809b) {
                return;
            }
            f10809b = true;
            try {
                Bundle bundle = zzrp.zzcq(context).getApplicationInfo(context.getPackageName(), 128).metaData;
                if (bundle == null) {
                    return;
                }
                f10810c = bundle.getString("com.google.app.id");
                f10811d = bundle.getInt("com.google.android.gms.version");
            } catch (Throwable e) {
                Log.wtf("MetadataValueReader", "This should never happen.", e);
            }
        }
    }

    public static String zzcf(Context context) {
        m16947a(context);
        return f10810c;
    }

    public static int zzcg(Context context) {
        m16947a(context);
        return f10811d;
    }
}
