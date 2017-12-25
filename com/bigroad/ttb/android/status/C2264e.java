package com.bigroad.ttb.android.status;

public class C2264e {
    protected static final Long f7854a = null;
    private C2262f f7855b;
    private final long f7856c;
    private final Long f7857d;

    public C2264e(C2262f c2262f) {
        this(c2262f, 0, f7854a);
    }

    public C2264e(C2262f c2262f, long j, Long l) {
        this.f7855b = c2262f;
        this.f7856c = j;
        this.f7857d = l;
    }

    public C2262f m11109b() {
        return this.f7855b;
    }

    public boolean m11108a(long j) {
        return j >= this.f7856c && (this.f7857d == null || j < this.f7856c + this.f7857d.longValue());
    }

    public long m11110c() {
        return this.f7856c;
    }

    public Long m11111d() {
        return this.f7857d;
    }
}
