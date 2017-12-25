package com.crashlytics.android.p044a;

import java.io.InputStream;
import java.util.Properties;

class C2825d {
    public final String f9766a;
    public final String f9767b;
    public final String f9768c;
    public final String f9769d;

    C2825d(String str, String str2, String str3, String str4) {
        this.f9766a = str;
        this.f9767b = str2;
        this.f9768c = str3;
        this.f9769d = str4;
    }

    public static C2825d m15988a(Properties properties) {
        return new C2825d(properties.getProperty("version_code"), properties.getProperty("version_name"), properties.getProperty("build_id"), properties.getProperty("package_name"));
    }

    public static C2825d m15987a(InputStream inputStream) {
        Properties properties = new Properties();
        properties.load(inputStream);
        return C2825d.m15988a(properties);
    }
}
