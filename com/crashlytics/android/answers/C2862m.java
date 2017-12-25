package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p047a.C4030e;

class C2862m {
    long f9859a;
    private C4030e f9860b;

    public C2862m(C4030e c4030e) {
        if (c4030e == null) {
            throw new NullPointerException("retryState must not be null");
        }
        this.f9860b = c4030e;
    }

    public boolean m16087a(long j) {
        return j - this.f9859a >= 1000000 * this.f9860b.m20833a();
    }

    public void m16088b(long j) {
        this.f9859a = j;
        this.f9860b = this.f9860b.m20834b();
    }

    public void m16086a() {
        this.f9859a = 0;
        this.f9860b = this.f9860b.m20835c();
    }
}
