package com.bigroad.ttb.android.eobr;

import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.android.eobr.turbo.VarPage;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.aa;
import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class C1934j {
    private aa f6667a;
    private SortedMap<Long, VarPage> f6668b = new TreeMap();

    public void m9510a() {
        this.f6668b.clear();
    }

    public boolean m9515a(long j) {
        return this.f6668b.containsKey(Long.valueOf(j));
    }

    public VarPage m9516b(long j) {
        return (VarPage) this.f6668b.get(Long.valueOf(j));
    }

    public void m9514a(VarPage varPage) {
        this.f6668b.put(Long.valueOf(varPage.m9607b()), varPage);
    }

    public void m9517b() {
        this.f6667a = null;
    }

    public void m9513a(C1790a c1790a, EobrDevice eobrDevice) {
        this.f6667a = c1790a.m8773e(eobrDevice.m8992d());
    }

    public Long m9518c() {
        return this.f6667a != null ? this.f6667a.m8568f() : null;
    }

    public Long m9509a(C1790a c1790a, byte[] bArr, long j) {
        aa e;
        if (this.f6667a == null || !Arrays.equals(this.f6667a.m8567e(), bArr)) {
            e = c1790a.m8773e(bArr);
        } else {
            e = this.f6667a;
        }
        Long f = e.m8568f();
        if (f == null || j > f.longValue()) {
            e.m8564b(Long.valueOf(j));
            c1790a.m8729a(e);
        }
        return e.m8568f();
    }

    public void m9520d() {
        if (this.f6667a != null) {
            this.f6667a.m8562a(null);
        }
    }

    public C1015l m9522e() {
        return this.f6667a != null ? this.f6667a.m8570h() : null;
    }

    public void m9511a(C1015l c1015l) {
        if (this.f6667a != null) {
            this.f6667a.m8562a(c1015l);
        }
    }

    public Long m9523f() {
        return this.f6667a != null ? this.f6667a.m8569g() : null;
    }

    public void m9519c(long j) {
        if (this.f6667a != null) {
            this.f6667a.m8563a(Long.valueOf(j));
        }
    }

    public boolean m9521d(long j) {
        return (this.f6667a == null || this.f6667a.m8569g() == null || this.f6667a.m8569g().longValue() <= j) ? false : true;
    }

    public void m9512a(C1790a c1790a, C1015l c1015l) {
        c1790a.m8763c(this.f6668b.values());
        if (c1015l != null) {
            this.f6668b.headMap(Long.valueOf(c1015l.m5228a() - 1)).clear();
        } else {
            this.f6668b.clear();
        }
        if (this.f6667a != null && this.f6667a.m8565b()) {
            c1790a.m8729a(this.f6667a);
            this.f6667a.m8566d();
        }
    }
}
