package com.bigroad.shared.eobr.turbo;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.google.common.collect.C3589f;

public class C1015l implements Comparable<C1015l> {
    private final long f3186a;
    private final int f3187b;

    public /* synthetic */ int compareTo(Object obj) {
        return m5231b((C1015l) obj);
    }

    public C1015l(long j, int i) {
        if (j < 0 || j > 4294967295L || i < 0) {
            throw new IllegalArgumentException();
        }
        this.f3186a = j;
        this.f3187b = i;
    }

    public long m5228a() {
        return this.f3186a;
    }

    public int m5230b() {
        return this.f3187b;
    }

    public long m5232c() {
        return (this.f3186a << 32) | (((long) this.f3187b) & 4294967295L);
    }

    public C1015l m5233d() {
        return new C1015l(this.f3186a + 1, 0);
    }

    public C1015l m5234e() {
        return new C1015l(this.f3186a, this.f3187b + 1);
    }

    public C1015l m5235f() {
        return new C1015l(this.f3186a, Math.max(0, this.f3187b - 1));
    }

    public static C1015l m5227a(long j) {
        return new C1015l(j >>> 32, (int) (4294967295L & j));
    }

    public boolean m5229a(C1015l c1015l) {
        if (c1015l == null) {
            return false;
        }
        if (this.f3186a == c1015l.f3186a) {
            if (c1015l.f3187b != this.f3187b + 1) {
                return false;
            }
            return true;
        } else if (c1015l.f3186a == this.f3186a + 1 && c1015l.f3187b == 1) {
            return true;
        } else {
            return false;
        }
    }

    public int m5231b(C1015l c1015l) {
        return C3589f.m18773a().mo2736a(this.f3186a, c1015l.f3186a).mo2735a(this.f3187b, c1015l.f3187b).mo2740b();
    }

    public boolean equals(Object obj) {
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        C1015l c1015l = (C1015l) obj;
        if (Objects.equal(Long.valueOf(this.f3186a), Long.valueOf(c1015l.f3186a)) && Objects.equal(Integer.valueOf(this.f3187b), Integer.valueOf(c1015l.f3187b))) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return Objects.hashCode(Long.valueOf(this.f3186a), Integer.valueOf(this.f3187b));
    }

    public String toString() {
        return MoreObjects.toStringHelper((Object) this).add("pageNumber", this.f3186a).add("entryIndex", this.f3187b).toString();
    }
}
