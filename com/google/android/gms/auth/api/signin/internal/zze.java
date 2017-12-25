package com.google.android.gms.auth.api.signin.internal;

public class zze {
    static int f10475a = 31;
    private int f10476b = 1;

    public int zzagc() {
        return this.f10476b;
    }

    public zze zzba(boolean z) {
        this.f10476b = (z ? 1 : 0) + (this.f10476b * f10475a);
        return this;
    }

    public zze zzq(Object obj) {
        this.f10476b = (obj == null ? 0 : obj.hashCode()) + (this.f10476b * f10475a);
        return this;
    }
}
