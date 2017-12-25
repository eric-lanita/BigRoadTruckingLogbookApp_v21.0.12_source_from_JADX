package com.crashlytics.android.answers;

import io.fabric.sdk.android.services.concurrency.p047a.C4028b;
import io.fabric.sdk.android.services.concurrency.p047a.C4029c;
import io.fabric.sdk.android.services.concurrency.p047a.C4030e;
import io.fabric.sdk.android.services.p046b.C2849f;
import java.io.File;
import java.util.List;

class C2850f implements C2849f {
    private final C2866p f9835a;
    private final C2862m f9836b;

    public static C2850f m16052a(C2866p c2866p) {
        return new C2850f(c2866p, new C2862m(new C4030e(new C2861l(new C4029c(1000, 8), 0.1d), new C4028b(5))));
    }

    C2850f(C2866p c2866p, C2862m c2862m) {
        this.f9835a = c2866p;
        this.f9836b = c2862m;
    }

    public boolean mo1440a(List<File> list) {
        long nanoTime = System.nanoTime();
        if (!this.f9836b.m16087a(nanoTime)) {
            return false;
        }
        if (this.f9835a.mo1440a(list)) {
            this.f9836b.m16086a();
            return true;
        }
        this.f9836b.m16088b(nanoTime);
        return false;
    }
}
