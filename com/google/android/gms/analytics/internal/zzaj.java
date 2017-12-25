package com.google.android.gms.analytics.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public final class zzaj {
    static Object f10262a = new Object();
    static zzvw f10263b;
    static Boolean f10264c;

    public static boolean zzav(Context context) {
        zzab.zzy(context);
        if (f10264c != null) {
            return f10264c.booleanValue();
        }
        boolean zzb = zzao.zzb(context, "com.google.android.gms.analytics.AnalyticsReceiver", false);
        f10264c = Boolean.valueOf(zzb);
        return zzb;
    }

    public void onReceive(Context context, Intent intent) {
        zzf zzay = zzf.zzay(context);
        zzaf zzyx = zzay.zzyx();
        if (intent == null) {
            zzyx.zzek("AnalyticsReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (zzay.zzyy().zzabc()) {
            zzyx.zza("Device AnalyticsReceiver got", action);
        } else {
            zzyx.zza("Local AnalyticsReceiver got", action);
        }
        if ("com.google.android.gms.analytics.ANALYTICS_DISPATCH".equals(action)) {
            boolean zzaw = zzak.zzaw(context);
            Intent intent2 = new Intent("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            intent2.setComponent(new ComponentName(context, "com.google.android.gms.analytics.AnalyticsService"));
            intent2.setAction("com.google.android.gms.analytics.ANALYTICS_DISPATCH");
            synchronized (f10262a) {
                context.startService(intent2);
                if (zzaw) {
                    try {
                        if (f10263b == null) {
                            f10263b = new zzvw(context, 1, "Analytics WakeLock");
                            f10263b.setReferenceCounted(false);
                        }
                        f10263b.acquire(1000);
                    } catch (SecurityException e) {
                        zzyx.zzek("Analytics service at risk of not starting. For more reliable analytics, add the WAKE_LOCK permission to your manifest. See http://goo.gl/8Rd3yj for instructions.");
                    }
                    return;
                }
            }
        }
    }
}
