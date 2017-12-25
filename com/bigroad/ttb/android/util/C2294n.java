package com.bigroad.ttb.android.util;

import com.bigroad.shared.af;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.model.C2182e.C2181a;

public class C2294n extends af {
    public static C2182e m11242a(C2182e c2182e, C2182e c2182e2) {
        C2181a c2181a = new C2181a(c2182e);
        for (CanonicalOdometerSource canonicalOdometerSource : CanonicalOdometerSource.values()) {
            Long valueOf = Long.valueOf(c2182e2.m10816a(canonicalOdometerSource));
            if (valueOf.longValue() > 0 && Long.valueOf(c2182e.m10816a(canonicalOdometerSource)).longValue() <= 0) {
                c2181a.m10813a(canonicalOdometerSource, valueOf.longValue());
            }
        }
        return c2181a.m10814a();
    }
}
