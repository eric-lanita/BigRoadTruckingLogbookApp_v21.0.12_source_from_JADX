package com.google.common.collect;

import java.io.Serializable;

final class NullsLastOrdering<T> extends C3540t<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final C3540t<? super T> ordering;

    NullsLastOrdering(C3540t<? super T> c3540t) {
        this.ordering = c3540t;
    }

    public int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return 1;
        }
        if (t2 == null) {
            return -1;
        }
        return this.ordering.compare(t, t2);
    }

    public <S extends T> C3540t<S> mo2708a() {
        return this.ordering.mo2708a();
    }

    public <S extends T> C3540t<S> mo2709b() {
        return this;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NullsLastOrdering)) {
            return false;
        }
        return this.ordering.equals(((NullsLastOrdering) obj).ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ -921210296;
    }

    public String toString() {
        return this.ordering + ".nullsLast()";
    }
}
