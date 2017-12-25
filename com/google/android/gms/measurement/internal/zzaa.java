package com.google.android.gms.measurement.internal;

abstract class zzaa extends zzz {
    private boolean f12147a;

    zzaa(zzx com_google_android_gms_measurement_internal_zzx) {
        super(com_google_android_gms_measurement_internal_zzx);
        this.b.m17982a(this);
    }

    boolean m17713a() {
        return this.f12147a;
    }

    boolean m17714b() {
        return false;
    }

    protected void m17715c() {
        if (!m17713a()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    protected abstract void mo2375d();

    public final void initialize() {
        if (this.f12147a) {
            throw new IllegalStateException("Can't initialize twice");
        }
        mo2375d();
        this.b.m18002l();
        this.f12147a = true;
    }
}
