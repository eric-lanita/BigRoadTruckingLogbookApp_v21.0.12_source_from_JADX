package com.bigroad.shared.duty;

import com.bigroad.shared.duty.TimeWindow.Condition;

public class C0955u extends TimeWindow {
    public static final C0955u f2931a = new C0955u(0, 0);

    public C0955u(long j, long j2) {
        super(j, j2);
    }

    public C0955u(long j, long j2, boolean z) {
        super(j, j2, z);
    }

    public C0955u(long j, long j2, boolean z, long j3) {
        super(j, j2, z, j3);
    }

    public Condition mo727a() {
        if (m4402b() >= 1) {
            return Condition.WARN;
        }
        return Condition.FINE;
    }

    public static C0955u m4858a(C0955u c0955u, C0955u c0955u2) {
        if (c0955u == null) {
            return c0955u2;
        }
        if (c0955u2 == null) {
            return c0955u;
        }
        long j;
        boolean z;
        long max = Math.max(c0955u.m4402b(), c0955u2.m4402b());
        long max2 = Math.max(c0955u.m4403c(), c0955u2.m4403c());
        long min = Math.min(c0955u.m4405e(), c0955u2.m4405e());
        if (c0955u.m4402b() == c0955u2.m4402b()) {
            boolean z2;
            if (c0955u.m4404d() && c0955u2.m4404d()) {
                z2 = true;
            } else {
                z2 = false;
            }
            j = min;
            z = z2;
        } else {
            long j2;
            if (c0955u.m4402b() <= c0955u2.m4402b()) {
                C0955u c0955u3 = c0955u;
                c0955u = c0955u2;
                c0955u2 = c0955u3;
            }
            if (!c0955u.m4404d() || c0955u2.m4404d() || c0955u2.m4402b() == 0) {
                j2 = min;
            } else {
                j2 = Math.min(min, c0955u.m4402b() - c0955u2.m4402b());
            }
            z = c0955u.m4404d();
            j = j2;
        }
        return new C0955u(max, max2, z, j);
    }
}
