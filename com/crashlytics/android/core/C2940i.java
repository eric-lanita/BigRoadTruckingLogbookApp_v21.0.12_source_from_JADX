package com.crashlytics.android.core;

import io.fabric.sdk.android.C3969c;
import io.fabric.sdk.android.services.p057c.C3987a;
import java.io.File;

class C2940i {
    private final String f10075a;
    private final C3987a f10076b;

    public C2940i(String str, C3987a c3987a) {
        this.f10075a = str;
        this.f10076b = c3987a;
    }

    public boolean m16413a() {
        boolean z = false;
        try {
            z = m16412d().createNewFile();
        } catch (Throwable e) {
            C3969c.m20576h().mo2857e("CrashlyticsCore", "Error creating marker: " + this.f10075a, e);
        }
        return z;
    }

    public boolean m16414b() {
        return m16412d().exists();
    }

    public boolean m16415c() {
        return m16412d().delete();
    }

    private File m16412d() {
        return new File(this.f10076b.mo2877a(), this.f10075a);
    }
}
