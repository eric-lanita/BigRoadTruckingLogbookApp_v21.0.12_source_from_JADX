package com.bigroad.shared.duty;

import com.bigroad.shared.duty.TimeWindow.Condition;

public class C0902k extends TimeWindow {
    public static final C0902k f2794a = new C0902k(Long.MAX_VALUE, Long.MAX_VALUE);

    public C0902k(long j, long j2) {
        super(j, j2);
    }

    public C0902k(long j, long j2, boolean z) {
        super(j, j2, z);
    }

    public C0902k(long j, long j2, boolean z, long j3) {
        super(j, j2, z, j3);
    }

    public Condition mo727a() {
        if (m4402b() >= 3600000) {
            return Condition.FINE;
        }
        if (m4402b() >= 1800000) {
            return Condition.WARN;
        }
        return Condition.BAD;
    }

    public static C0902k m4574a(C0902k c0902k, C0902k c0902k2) {
        if (c0902k == null) {
            return c0902k2;
        }
        if (c0902k2 == null) {
            return c0902k;
        }
        long j;
        boolean z;
        long min = Math.min(c0902k.m4402b(), c0902k2.m4402b());
        long min2 = Math.min(c0902k.m4403c(), c0902k2.m4403c());
        long min3 = Math.min(c0902k.m4405e(), c0902k2.m4405e());
        if (c0902k.m4402b() == c0902k2.m4402b()) {
            boolean z2;
            if (c0902k.m4404d() || c0902k2.m4404d()) {
                z2 = true;
            } else {
                z2 = false;
            }
            j = min3;
            z = z2;
        } else {
            long j2;
            if (c0902k.m4402b() <= c0902k2.m4402b()) {
                C0902k c0902k3 = c0902k;
                c0902k = c0902k2;
                c0902k2 = c0902k3;
            }
            if (!c0902k.m4404d() || c0902k2.m4404d() || c0902k2.m4402b() == 0) {
                j2 = min3;
            } else {
                j2 = Math.min(min3, c0902k.m4402b() - c0902k2.m4402b());
            }
            z = c0902k2.m4404d();
            j = j2;
        }
        return new C0902k(min, min2, z, j);
    }
}
