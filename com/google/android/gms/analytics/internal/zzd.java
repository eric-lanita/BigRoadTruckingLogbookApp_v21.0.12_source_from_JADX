package com.google.android.gms.analytics.internal;

public abstract class zzd extends zzc {
    private boolean f10198a;

    protected zzd(zzf com_google_android_gms_analytics_internal_zzf) {
        super(com_google_android_gms_analytics_internal_zzf);
    }

    protected abstract void mo1605a();

    public void initialize() {
        mo1605a();
        this.f10198a = true;
    }

    public boolean isInitialized() {
        return this.f10198a;
    }

    protected void m16553s() {
        if (!isInitialized()) {
            throw new IllegalStateException("Not initialized");
        }
    }
}
