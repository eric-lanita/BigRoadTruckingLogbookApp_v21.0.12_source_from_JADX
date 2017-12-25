package com.crashlytics.android.answers;

import android.annotation.SuppressLint;
import android.content.Context;
import io.fabric.sdk.android.services.p057c.C3989c;
import io.fabric.sdk.android.services.p057c.C3990d;

class C2848e {
    private final C3989c f9834a;

    public static C2848e m16048a(Context context) {
        return new C2848e(new C3990d(context, "settings"));
    }

    C2848e(C3989c c3989c) {
        this.f9834a = c3989c;
    }

    @SuppressLint({"CommitPrefEdits"})
    public void m16049a() {
        this.f9834a.mo2879a(this.f9834a.mo2880b().putBoolean("analytics_launched", true));
    }

    @SuppressLint({"CommitPrefEdits"})
    public boolean m16050b() {
        return this.f9834a.mo2878a().getBoolean("analytics_launched", false);
    }
}
