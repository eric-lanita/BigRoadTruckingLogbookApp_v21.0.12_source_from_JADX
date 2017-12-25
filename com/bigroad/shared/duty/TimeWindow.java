package com.bigroad.shared.duty;

import com.bigroad.shared.ad;
import com.bigroad.shared.aq;

public abstract class TimeWindow {
    private final long f2730a;
    private final long f2731b;
    private final boolean f2732c;
    private final long f2733d;

    public enum Condition {
        FINE,
        WARN,
        BAD
    }

    public abstract Condition mo727a();

    public TimeWindow(long j, long j2) {
        this(j, j2, false);
    }

    public TimeWindow(long j, long j2, boolean z) {
        this(j, j2, z, Long.MAX_VALUE);
    }

    public TimeWindow(long j, long j2, boolean z, long j3) {
        this.f2730a = Math.max(0, j);
        this.f2731b = Math.max(0, j2);
        if (this.f2730a == 0) {
            this.f2732c = false;
        } else {
            this.f2732c = z;
        }
        this.f2733d = Math.max(0, j3);
    }

    public long m4402b() {
        return this.f2730a;
    }

    public long m4403c() {
        return this.f2731b;
    }

    public boolean m4404d() {
        return this.f2732c;
    }

    public long m4405e() {
        return this.f2733d;
    }

    public float m4406f() {
        return ad.m4149a(0.0f, (float) (((double) this.f2730a) / ((double) this.f2731b)), 1.0f);
    }

    public String toString() {
        return "TimeWindow [current=" + aq.m4232d(this.f2730a) + ", total=" + aq.m4232d(this.f2731b) + "]";
    }

    public static long m4400a(TimeWindow... timeWindowArr) {
        if (timeWindowArr == null || timeWindowArr.length == 0) {
            return Long.MAX_VALUE;
        }
        long e = timeWindowArr[0].m4405e();
        for (int i = 1; i < timeWindowArr.length; i++) {
            e = Math.min(e, timeWindowArr[i].m4405e());
        }
        return e;
    }
}
