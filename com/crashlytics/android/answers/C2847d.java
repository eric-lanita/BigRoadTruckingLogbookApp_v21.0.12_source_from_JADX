package com.crashlytics.android.answers;

import android.app.Activity;
import android.os.Bundle;
import io.fabric.sdk.android.C3962a.C2819b;

class C2847d extends C2819b {
    private final C2867q f9832a;
    private final C2853g f9833b;

    public C2847d(C2867q c2867q, C2853g c2853g) {
        this.f9832a = c2867q;
        this.f9833b = c2853g;
    }

    public void mo1434a(Activity activity, Bundle bundle) {
    }

    public void mo1425a(Activity activity) {
        this.f9832a.m16111a(activity, Type.START);
    }

    public void mo1435b(Activity activity) {
        this.f9832a.m16111a(activity, Type.RESUME);
        this.f9833b.m16057a();
    }

    public void mo1437c(Activity activity) {
        this.f9832a.m16111a(activity, Type.PAUSE);
        this.f9833b.m16060b();
    }

    public void mo1438d(Activity activity) {
        this.f9832a.m16111a(activity, Type.STOP);
    }

    public void mo1436b(Activity activity, Bundle bundle) {
    }

    public void mo1439e(Activity activity) {
    }
}
