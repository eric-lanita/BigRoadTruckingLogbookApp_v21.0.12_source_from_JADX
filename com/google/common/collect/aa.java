package com.google.common.collect;

import java.util.ListIterator;

abstract class aa<F, T> extends C3556z<F, T> implements ListIterator<T> {
    aa(ListIterator<? extends F> listIterator) {
        super(listIterator);
    }

    private ListIterator<? extends F> m18633a() {
        return Iterators.m18632f(this.b);
    }

    public final boolean hasPrevious() {
        return m18633a().hasPrevious();
    }

    public final T previous() {
        return mo2703a(m18633a().previous());
    }

    public final int nextIndex() {
        return m18633a().nextIndex();
    }

    public final int previousIndex() {
        return m18633a().previousIndex();
    }

    public void set(T t) {
        throw new UnsupportedOperationException();
    }

    public void add(T t) {
        throw new UnsupportedOperationException();
    }
}
