package com.bigroad.shared.duty;

import com.bigroad.shared.duty.C0882q.C0909a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class C0910r<T extends C0882q> implements C0909a {
    private final long f2805a;
    private final List<T> f2806b;

    protected abstract T mo730b(List<C0896g> list, int i, int i2);

    public C0910r() {
        this(0);
    }

    public C0910r(long j) {
        this.f2806b = new ArrayList();
        this.f2805a = j;
    }

    public static C0910r<C0882q> m4592a(long j) {
        return new C0910r<C0882q>(j) {
            protected C0882q mo730b(List<C0896g> list, int i, int i2) {
                return new C0882q(list, i, i2);
            }
        };
    }

    public void mo729a(List<C0896g> list, int i, int i2) {
        if (((C0896g) list.get(i2 - 1)).mo698g() - ((C0896g) list.get(i)).mo697f() >= this.f2805a) {
            C0882q b = mo730b(list, i, i2);
            if (b != null) {
                this.f2806b.add(b);
            }
        }
    }

    public List<T> m4593a() {
        return Collections.unmodifiableList(this.f2806b);
    }

    public T m4595b() {
        if (this.f2806b.isEmpty()) {
            return null;
        }
        return (C0882q) this.f2806b.get(this.f2806b.size() - 1);
    }
}
