package com.crashlytics.android.core;

import io.fabric.sdk.android.C3969c;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class ag implements ad {
    private final File f9956a;
    private final File[] f9957b;
    private final Map<String, String> f9958c;

    public ag(File file) {
        this(file, Collections.emptyMap());
    }

    public ag(File file, Map<String, String> map) {
        this.f9956a = file;
        this.f9957b = new File[]{file};
        this.f9958c = new HashMap(map);
        if (this.f9956a.length() == 0) {
            this.f9958c.putAll(ae.f9946a);
        }
    }

    public File mo1464c() {
        return this.f9956a;
    }

    public File[] mo1465d() {
        return this.f9957b;
    }

    public String mo1462a() {
        return mo1464c().getName();
    }

    public String mo1463b() {
        String a = mo1462a();
        return a.substring(0, a.lastIndexOf(46));
    }

    public Map<String, String> mo1466e() {
        return Collections.unmodifiableMap(this.f9958c);
    }

    public void mo1467f() {
        C3969c.m20576h().mo2849a("CrashlyticsCore", "Removing report at " + this.f9956a.getPath());
        this.f9956a.delete();
    }
}
