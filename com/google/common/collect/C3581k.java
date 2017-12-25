package com.google.common.collect;

import java.util.Collection;
import java.util.Set;

public abstract class C3581k<E> extends C3542h<E> implements Set<E> {
    protected abstract Set<E> mo2732a();

    protected /* synthetic */ Collection mo2669c() {
        return mo2732a();
    }

    protected /* synthetic */ Object mo2668d() {
        return mo2732a();
    }

    protected C3581k() {
    }

    public boolean equals(Object obj) {
        return obj == this || mo2732a().equals(obj);
    }

    public int hashCode() {
        return mo2732a().hashCode();
    }
}
