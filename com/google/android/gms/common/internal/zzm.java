package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;

public abstract class zzm {
    private static final Object f10775a = new Object();
    private static zzm f10776b;

    public static zzm zzce(Context context) {
        synchronized (f10775a) {
            if (f10776b == null) {
                f10776b = new zzn(context.getApplicationContext());
            }
        }
        return f10776b;
    }

    public abstract boolean zza(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract boolean zza(String str, String str2, ServiceConnection serviceConnection, String str3);

    public abstract void zzb(ComponentName componentName, ServiceConnection serviceConnection, String str);

    public abstract void zzb(String str, String str2, ServiceConnection serviceConnection, String str3);
}
