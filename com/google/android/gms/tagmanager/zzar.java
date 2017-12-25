package com.google.android.gms.tagmanager;

import android.text.TextUtils;

class zzar {
    private final long f12539a;
    private final long f12540b;
    private final long f12541c;
    private String f12542d;

    zzar(long j, long j2, long j3) {
        this.f12539a = j;
        this.f12540b = j2;
        this.f12541c = j3;
    }

    long m18087a() {
        return this.f12539a;
    }

    void m18088a(String str) {
        if (str != null && !TextUtils.isEmpty(str.trim())) {
            this.f12542d = str;
        }
    }

    long m18089b() {
        return this.f12541c;
    }

    String m18090c() {
        return this.f12542d;
    }
}
