package com.crashlytics.android.core;

import io.fabric.sdk.android.C3969c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class C2951s implements ad {
    private final File[] f10095a;
    private final Map<String, String> f10096b = new HashMap(ae.f9946a);
    private final String f10097c;

    public C2951s(String str, File[] fileArr) {
        this.f10095a = fileArr;
        this.f10097c = str;
    }

    public String mo1462a() {
        return this.f10095a[0].getName();
    }

    public String mo1463b() {
        return this.f10097c;
    }

    public File mo1464c() {
        return this.f10095a[0];
    }

    public File[] mo1465d() {
        return this.f10095a;
    }

    public Map<String, String> mo1466e() {
        return Collections.unmodifiableMap(this.f10096b);
    }

    public void mo1467f() {
        for (File file : this.f10095a) {
            C3969c.m20576h().mo2849a("CrashlyticsCore", "Removing invalid report file at " + file.getPath());
            file.delete();
        }
    }
}
