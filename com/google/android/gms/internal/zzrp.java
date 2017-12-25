package com.google.android.gms.internal;

import android.content.Context;

public class zzrp {
    private static zzrp f11738b = new zzrp();
    private zzro f11739a = null;

    public static zzro zzcq(Context context) {
        return f11738b.zzcp(context);
    }

    public synchronized zzro zzcp(Context context) {
        if (this.f11739a == null) {
            if (context.getApplicationContext() != null) {
                context = context.getApplicationContext();
            }
            this.f11739a = new zzro(context);
        }
        return this.f11739a;
    }
}
