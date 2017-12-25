package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1026f;
import com.bigroad.shared.eobr.turbo.logs.C1027g;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb.C2521a;

public class C2346e {
    public static C2369i m11464a(C2369i c2369i, C2348f c2348f) {
        C1016p a = c2348f.m11466a();
        if (!(a instanceof C1026f)) {
            throw new IllegalArgumentException("Unexpected type: " + (a != null ? a.getClass().getName() : "null"));
        } else if (c2369i == null) {
            throw new IllegalArgumentException("Null VehicleState");
        } else {
            C1026f c1026f = (C1026f) a;
            C2368a a2 = C2369i.m11589a(c2369i);
            if (c1026f.f3254a == 0 && c1026f.f3255b == 0 && c1026f.f3256c == 0) {
                a2.m11580b();
            } else {
                C2521a a3 = Breadcrumb.newBuilder().m12526a(Math.round((float) (c1026f.f3254a / 10))).m12531b(Math.round((float) (c1026f.f3255b / 10))).m12525a((float) c1026f.f3256c);
                if (c1026f instanceof C1027g) {
                    C1027g c1027g = (C1027g) c1026f;
                    a3.m12527a(c1027g.f3259e).m12533c(c1027g.f3258d * 100);
                } else {
                    a3.m12527a(c2348f.mo1281l().getAbsoluteTimeMillis());
                }
                a2.m11573a(a3.m12534c());
            }
            return a2.m11584c();
        }
    }
}
