package com.bigroad.shared;

import java.util.HashSet;
import java.util.Set;

public abstract class ap {
    private final Set<C0842a> f2633a = new HashSet();

    public interface C0842a {
        void mo1016a();
    }

    public abstract long mo913a();

    public abstract long mo914b();

    public abstract long mo915c();

    public void m4201a(C0842a c0842a) {
        this.f2633a.add(c0842a);
    }

    public void m4203b(C0842a c0842a) {
        this.f2633a.remove(c0842a);
    }

    protected void m4205d() {
        for (C0842a a : (C0842a[]) this.f2633a.toArray(new C0842a[this.f2633a.size()])) {
            a.mo1016a();
        }
    }
}
