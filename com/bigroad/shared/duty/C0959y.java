package com.bigroad.shared.duty;

public abstract class C0959y {
    protected final long f2942a;

    protected static class C0957a {
        protected long f2941a;

        protected void m4886a(long j, boolean z) {
            if (z) {
                this.f2941a |= j;
            } else {
                this.f2941a &= -1 ^ j;
            }
        }

        protected C0957a(long j) {
            this.f2941a = j;
        }
    }

    protected C0959y(long j) {
        this.f2942a = j;
    }

    protected boolean m4900b(long j) {
        return (this.f2942a & j) != 0;
    }

    public long m4898a() {
        return this.f2942a;
    }

    public boolean m4899b() {
        return m4900b(1);
    }

    public boolean m4901c() {
        return m4900b(2);
    }

    public boolean m4902d() {
        return m4900b(4);
    }

    public boolean m4903e() {
        return m4900b(8);
    }

    public boolean m4904f() {
        return m4900b(16);
    }

    public boolean m4905g() {
        return m4900b(32);
    }

    public boolean m4906h() {
        return m4900b(64);
    }

    public boolean m4907i() {
        return m4900b(128);
    }

    public boolean m4908j() {
        return m4900b(256);
    }

    public boolean m4909k() {
        return m4900b(512);
    }

    public boolean m4910l() {
        return m4900b(1024);
    }

    public boolean m4911m() {
        return m4900b(2048);
    }

    public boolean m4912n() {
        return m4900b(4096);
    }
}
