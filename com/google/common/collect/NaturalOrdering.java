package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.io.Serializable;

final class NaturalOrdering extends C3540t<Comparable> implements Serializable {
    static final NaturalOrdering f13030a = new NaturalOrdering();
    private static final long serialVersionUID = 0;
    private transient C3540t<Comparable> f13031b;
    private transient C3540t<Comparable> f13032c;

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m18680a((Comparable) obj, (Comparable) obj2);
    }

    public int m18680a(Comparable comparable, Comparable comparable2) {
        Preconditions.checkNotNull(comparable);
        Preconditions.checkNotNull(comparable2);
        return comparable.compareTo(comparable2);
    }

    public <S extends Comparable> C3540t<S> mo2708a() {
        C3540t<S> c3540t = this.f13031b;
        if (c3540t != null) {
            return c3540t;
        }
        c3540t = super.mo2708a();
        this.f13031b = c3540t;
        return c3540t;
    }

    public <S extends Comparable> C3540t<S> mo2709b() {
        C3540t<S> c3540t = this.f13032c;
        if (c3540t != null) {
            return c3540t;
        }
        c3540t = super.mo2709b();
        this.f13032c = c3540t;
        return c3540t;
    }

    private Object readResolve() {
        return f13030a;
    }

    public String toString() {
        return "Ordering.natural()";
    }

    private NaturalOrdering() {
    }
}
