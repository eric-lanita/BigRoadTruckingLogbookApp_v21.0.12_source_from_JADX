package com.google.common.collect;

import java.util.ListIterator;

public abstract class ac<E> extends ab<E> implements ListIterator<E> {
    protected ac() {
    }

    @Deprecated
    public final void add(E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void set(E e) {
        throw new UnsupportedOperationException();
    }
}
