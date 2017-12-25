package com.google.common.collect;

import java.util.Iterator;

public abstract class ab<E> implements Iterator<E> {
    protected ab() {
    }

    @Deprecated
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
