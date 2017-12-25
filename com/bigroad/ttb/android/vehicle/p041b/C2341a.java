package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.ttb.android.vehicle.C2369i;

public abstract class C2341a {
    public static C2369i m11457a(C2369i c2369i, C2348f c2348f) {
        C1016p a = c2348f.m11466a();
        if (a instanceof C1020a) {
            C1020a c1020a = (C1020a) a;
            if (c2369i.m11598a(c1020a.f3246b)) {
                return c2369i;
            }
            return C2369i.m11589a(c2369i).m11568a(c1020a.f3246b).m11584c();
        }
        throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
    }
}
