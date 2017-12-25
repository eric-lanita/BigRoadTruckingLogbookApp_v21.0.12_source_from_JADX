package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.NoSuchElementException;

abstract class C3547a<E> extends ac<E> {
    private final int f12981a;
    private int f12982b;

    protected abstract E mo2682a(int i);

    protected C3547a(int i, int i2) {
        Preconditions.checkPositionIndex(i2, i);
        this.f12981a = i;
        this.f12982b = i2;
    }

    public final boolean hasNext() {
        return this.f12982b < this.f12981a;
    }

    public final E next() {
        if (hasNext()) {
            int i = this.f12982b;
            this.f12982b = i + 1;
            return mo2682a(i);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f12982b;
    }

    public final boolean hasPrevious() {
        return this.f12982b > 0;
    }

    public final E previous() {
        if (hasPrevious()) {
            int i = this.f12982b - 1;
            this.f12982b = i;
            return mo2682a(i);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f12982b - 1;
    }
}
