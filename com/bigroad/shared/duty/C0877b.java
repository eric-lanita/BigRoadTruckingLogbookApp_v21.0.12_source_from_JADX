package com.bigroad.shared.duty;

public abstract class C0877b {
    protected final long f2747a;

    protected static class C0876a {
        protected long f2746a;

        protected void m4434a(long j, boolean z) {
            if (z) {
                this.f2746a |= j;
            } else {
                this.f2746a &= -1 ^ j;
            }
        }

        protected C0876a(long j) {
            this.f2746a = j;
        }
    }

    protected C0877b(long j) {
        this.f2747a = j;
    }

    protected boolean m4436a(long j) {
        return (this.f2747a & j) != 0;
    }

    public long m4435a() {
        return this.f2747a;
    }

    public boolean m4437b() {
        return m4436a(1);
    }
}
