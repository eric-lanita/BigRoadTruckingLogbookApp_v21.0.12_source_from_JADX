package com.google.android.gms.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public final class zzqe extends BroadcastReceiver {
    protected Context f11636a;
    private final zza f11637b;

    public static abstract class zza {
        public abstract void zzaou();
    }

    public zzqe(zza com_google_android_gms_internal_zzqe_zza) {
        this.f11637b = com_google_android_gms_internal_zzqe_zza;
    }

    public void onReceive(Context context, Intent intent) {
        Uri data = intent.getData();
        Object obj = null;
        if (data != null) {
            obj = data.getSchemeSpecificPart();
        }
        if ("com.google.android.gms".equals(obj)) {
            this.f11637b.zzaou();
            unregister();
        }
    }

    public void setContext(Context context) {
        this.f11636a = context;
    }

    public synchronized void unregister() {
        if (this.f11636a != null) {
            this.f11636a.unregisterReceiver(this);
        }
        this.f11636a = null;
    }
}
