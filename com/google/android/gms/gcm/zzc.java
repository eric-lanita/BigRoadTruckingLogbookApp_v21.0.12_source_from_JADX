package com.google.android.gms.gcm;

import android.os.Bundle;

public class zzc {
    public static final zzc ZC = new zzc(0, 30, 3600);
    public static final zzc ZD = new zzc(1, 30, 3600);
    private final int f11026a;
    private final int f11027b;
    private final int f11028c;

    private zzc(int i, int i2, int i3) {
        this.f11026a = i;
        this.f11027b = i2;
        this.f11028c = i3;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzc)) {
            return false;
        }
        zzc com_google_android_gms_gcm_zzc = (zzc) obj;
        return com_google_android_gms_gcm_zzc.f11026a == this.f11026a && com_google_android_gms_gcm_zzc.f11027b == this.f11027b && com_google_android_gms_gcm_zzc.f11028c == this.f11028c;
    }

    public int hashCode() {
        return (((((this.f11026a + 1) ^ 1000003) * 1000003) ^ this.f11027b) * 1000003) ^ this.f11028c;
    }

    public String toString() {
        int i = this.f11026a;
        int i2 = this.f11027b;
        return "policy=" + i + " initial_backoff=" + i2 + " maximum_backoff=" + this.f11028c;
    }

    public Bundle zzai(Bundle bundle) {
        bundle.putInt("retry_policy", this.f11026a);
        bundle.putInt("initial_backoff_seconds", this.f11027b);
        bundle.putInt("maximum_backoff_seconds", this.f11028c);
        return bundle;
    }

    public int zzblj() {
        return this.f11026a;
    }

    public int zzblk() {
        return this.f11027b;
    }

    public int zzbll() {
        return this.f11028c;
    }
}
