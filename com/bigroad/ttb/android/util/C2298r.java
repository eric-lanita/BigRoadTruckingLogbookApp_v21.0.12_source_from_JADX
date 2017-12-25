package com.bigroad.ttb.android.util;

import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.ttb.android.model.C2182e;

public class C2298r {
    private boolean f7937a = true;
    private Long[] f7938b = new Long[CanonicalOdometerSource.f3603l];
    private Long[] f7939c = new Long[CanonicalOdometerSource.f3603l];

    public void m11246a() {
        this.f7937a = true;
        for (int i = 0; i < CanonicalOdometerSource.f3603l; i++) {
            this.f7938b[i] = null;
            this.f7939c[i] = null;
        }
    }

    public void m11247a(C2182e c2182e) {
        if (c2182e != null) {
            for (CanonicalOdometerSource canonicalOdometerSource : CanonicalOdometerSource.values()) {
                long a = c2182e.m10816a(canonicalOdometerSource);
                if (a > 0) {
                    this.f7937a = false;
                    if (this.f7938b[canonicalOdometerSource.ordinal()] == null) {
                        this.f7938b[canonicalOdometerSource.ordinal()] = Long.valueOf(a);
                    } else {
                        this.f7938b[canonicalOdometerSource.ordinal()] = Long.valueOf(Math.min(this.f7938b[canonicalOdometerSource.ordinal()].longValue(), a));
                    }
                    if (this.f7939c[canonicalOdometerSource.ordinal()] == null) {
                        this.f7939c[canonicalOdometerSource.ordinal()] = Long.valueOf(a);
                    } else {
                        this.f7939c[canonicalOdometerSource.ordinal()] = Long.valueOf(Math.max(this.f7939c[canonicalOdometerSource.ordinal()].longValue(), a));
                    }
                }
            }
        }
    }

    public long m11248b() {
        long j = 0;
        if (!this.f7937a) {
            for (int i = 0; i < CanonicalOdometerSource.f3603l; i++) {
                Long l = this.f7938b[i];
                Long l2 = this.f7939c[i];
                if (!(l == null || l2 == null)) {
                    j = Math.max(j, l2.longValue() - l.longValue());
                }
            }
        }
        return j;
    }
}
