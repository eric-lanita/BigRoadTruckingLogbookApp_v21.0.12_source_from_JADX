package com.bigroad.shared.validation;

public abstract class C1177q {
    private long f3995a = 0;
    private long f3996b = 0;

    public abstract long mo1218c();

    public void m5966a(long j) {
        this.f3995a += j;
    }

    public void m5968b(long j) {
        this.f3996b += j;
    }

    public long m5965a() {
        return this.f3995a;
    }

    public long m5967b() {
        return this.f3996b;
    }

    public long m5970c(long j) {
        return Math.max(0, mo1218c() - j);
    }
}
