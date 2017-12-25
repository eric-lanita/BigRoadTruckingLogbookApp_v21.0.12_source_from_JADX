package com.crashlytics.android.answers;

import java.util.Set;

class C2863n implements C2858j {
    static final Set<Type> f9861b = new SamplingEventFilter$1();
    final int f9862a;

    public C2863n(int i) {
        this.f9862a = i;
    }

    public boolean mo1447a(SessionEvent sessionEvent) {
        boolean z;
        if (f9861b.contains(sessionEvent.f9805c) && sessionEvent.f9803a.f9883g == null) {
            z = true;
        } else {
            z = false;
        }
        boolean z2;
        if (Math.abs(sessionEvent.f9803a.f9879c.hashCode() % this.f9862a) != 0) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (z && r3) {
            return true;
        }
        return false;
    }
}
