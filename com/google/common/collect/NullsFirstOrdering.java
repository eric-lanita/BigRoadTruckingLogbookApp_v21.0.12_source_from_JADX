package com.google.common.collect;

import java.io.Serializable;

final class NullsFirstOrdering<T> extends C3540t<T> implements Serializable {
    private static final long serialVersionUID = 0;
    final C3540t<? super T> ordering;

    NullsFirstOrdering(C3540t<? super T> c3540t) {
        this.ordering = c3540t;
    }

    public int compare(T t, T t2) {
        if (t == t2) {
            return 0;
        }
        if (t == null) {
            return -1;
        }
        if (t2 == null) {
            return 1;
        }
        return this.ordering.compare(t, t2);
    }

    public <S extends T> C3540t<S> mo2708a() {
        return this;
    }

    public <S extends T> C3540t<S> mo2709b() {
        return this.ordering.mo2709b();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NullsFirstOrdering)) {
            return false;
        }
        return this.ordering.equals(((NullsFirstOrdering) obj).ordering);
    }

    public int hashCode() {
        return this.ordering.hashCode() ^ 957692532;
    }

    public String toString() {
        return this.ordering + ".nullsFirst()";
    }
}
