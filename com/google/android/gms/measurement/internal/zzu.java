package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.internal.zzvw;

public final class zzu {
    static final Object f12350a = new Object();
    static zzvw f12351b;
    static Boolean f12352c;

    public static boolean zzav(Context context) {
        zzab.zzy(context);
        if (f12352c != null) {
            return f12352c.booleanValue();
        }
        boolean zzb = zzal.zzb(context, "com.google.android.gms.measurement.AppMeasurementReceiver", false);
        f12352c = Boolean.valueOf(zzb);
        return zzb;
    }

    public void onReceive(Context context, Intent intent) {
        zzx zzdo = zzx.zzdo(context);
        zzp zzbsd = zzdo.zzbsd();
        if (intent == null) {
            zzbsd.zzbsx().log("AppMeasurementReceiver called with null intent");
            return;
        }
        String action = intent.getAction();
        if (zzdo.zzbsf().zzabc()) {
            zzbsd.zzbtc().zzj("Device AppMeasurementReceiver got", action);
        } else {
            zzbsd.zzbtc().zzj("Local AppMeasurementReceiver got", action);
        }
        if ("com.google.android.gms.measurement.UPLOAD".equals(action)) {
            boolean zzaw = zzae.zzaw(context);
            Intent className = new Intent().setClassName(context, "com.google.android.gms.measurement.AppMeasurementService");
            className.setAction("com.google.android.gms.measurement.UPLOAD");
            synchronized (f12350a) {
                context.startService(className);
                if (zzaw) {
                    try {
                        if (f12351b == null) {
                            f12351b = new zzvw(context, 1, "AppMeasurement WakeLock");
                            f12351b.setReferenceCounted(false);
                        }
                        f12351b.acquire(1000);
                    } catch (SecurityException e) {
                        zzbsd.zzbsx().log("AppMeasurementService at risk of not starting. For more reliable app measurements, add the WAKE_LOCK permission to your manifest.");
                    }
                    return;
                }
            }
        }
    }
}
