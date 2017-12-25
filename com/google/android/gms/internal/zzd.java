package com.google.android.gms.internal;

public class zzd implements zzo {
    private int f11382a;
    private int f11383b;
    private final int f11384c;
    private final float f11385d;

    public zzd() {
        this(2500, 1, 1.0f);
    }

    public zzd(int i, int i2, float f) {
        this.f11382a = i;
        this.f11384c = i2;
        this.f11385d = f;
    }

    protected boolean m17352a() {
        return this.f11383b <= this.f11384c;
    }

    public void zza(zzr com_google_android_gms_internal_zzr) {
        this.f11383b++;
        this.f11382a = (int) (((float) this.f11382a) + (((float) this.f11382a) * this.f11385d));
        if (!m17352a()) {
            throw com_google_android_gms_internal_zzr;
        }
    }

    public int zzc() {
        return this.f11382a;
    }

    public int zzd() {
        return this.f11383b;
    }
}
