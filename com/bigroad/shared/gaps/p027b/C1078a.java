package com.bigroad.shared.gaps.p027b;

import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.CanonicalOdometerUnit;

public class C1078a implements C1072a {
    private final C1108a f3513a;
    private final int f3514b;
    private final long f3515c;

    public C1078a(C1108a c1108a, int i, long j) {
        this.f3513a = c1108a;
        this.f3514b = i;
        this.f3515c = j;
    }

    public int mo770a() {
        return this.f3514b;
    }

    public String mo772c() {
        return this.f3513a.m5490q();
    }

    public CanonicalOdometerUnit mo776g() {
        CanonicalOdometerUnit s = this.f3513a.m5492s();
        return s != null ? s : CanonicalOdometerUnit.MILES;
    }

    public long mo775f() {
        return this.f3513a.m5507d() - this.f3513a.m5506c();
    }

    public Long mo773d() {
        return Long.valueOf(this.f3513a.m5506c());
    }

    public Long mo774e() {
        return Long.valueOf(this.f3513a.m5507d());
    }

    public long mo771b() {
        return this.f3515c;
    }
}
