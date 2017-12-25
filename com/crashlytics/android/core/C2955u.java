package com.crashlytics.android.core;

import android.content.Context;
import android.os.Bundle;

class C2955u implements aj {
    private final Context f10102a;
    private final String f10103b;

    public C2955u(Context context, String str) {
        this.f10102a = context;
        this.f10103b = str;
    }

    public String mo1487a() {
        String str = null;
        try {
            Bundle bundle = this.f10102a.getPackageManager().getApplicationInfo(this.f10103b, 128).metaData;
            if (bundle != null) {
                str = bundle.getString("io.fabric.unity.crashlytics.version");
            }
        } catch (Exception e) {
        }
        return str;
    }
}
