package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Iterator;

abstract class C3556z<F, T> implements Iterator<T> {
    final Iterator<? extends F> f13002b;

    abstract T mo2703a(F f);

    C3556z(Iterator<? extends F> it) {
        this.f13002b = (Iterator) Preconditions.checkNotNull(it);
    }

    public final boolean hasNext() {
        return this.f13002b.hasNext();
    }

    public final T next() {
        return mo2703a(this.f13002b.next());
    }

    public final void remove() {
        this.f13002b.remove();
    }
}
