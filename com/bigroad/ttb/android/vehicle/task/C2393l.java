package com.bigroad.ttb.android.vehicle.task;

import com.android.internal.util.Predicate;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.vehicle.C2364g;

public class C2393l implements Predicate<C2364g> {
    private final byte[] f8275a;
    private final C2032f f8276b;

    public /* synthetic */ boolean apply(Object obj) {
        return m11716a((C2364g) obj);
    }

    public C2393l(byte[] bArr, C2032f c2032f) {
        this.f8275a = bArr;
        this.f8276b = c2032f;
    }

    public boolean m11716a(C2364g c2364g) {
        return !this.f8276b.mo1301i().m10035b(this.f8275a);
    }
}
