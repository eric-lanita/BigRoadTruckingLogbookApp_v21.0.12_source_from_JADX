package com.crashlytics.android.core;

import android.annotation.SuppressLint;
import io.fabric.sdk.android.services.p057c.C3989c;
import io.fabric.sdk.android.services.p057c.C3990d;

@SuppressLint({"CommitPrefEdits"})
class aa {
    private final C3989c f9935a;

    public static aa m16171a(C3989c c3989c, C2939h c2939h) {
        if (!c3989c.mo2878a().getBoolean("preferences_migration_complete", false)) {
            C3989c c3990d = new C3990d(c2939h);
            boolean z = !c3989c.mo2878a().contains("always_send_reports_opt_in") && c3990d.mo2878a().contains("always_send_reports_opt_in");
            if (z) {
                c3989c.mo2879a(c3989c.mo2880b().putBoolean("always_send_reports_opt_in", c3990d.mo2878a().getBoolean("always_send_reports_opt_in", false)));
            }
            c3989c.mo2879a(c3989c.mo2880b().putBoolean("preferences_migration_complete", true));
        }
        return new aa(c3989c);
    }

    public aa(C3989c c3989c) {
        this.f9935a = c3989c;
    }

    void m16172a(boolean z) {
        this.f9935a.mo2879a(this.f9935a.mo2880b().putBoolean("always_send_reports_opt_in", z));
    }

    boolean m16173a() {
        return this.f9935a.mo2878a().getBoolean("always_send_reports_opt_in", false);
    }
}
