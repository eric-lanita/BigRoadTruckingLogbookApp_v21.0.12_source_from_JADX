package com.google.common.collect;

import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import java.util.Iterator;

public abstract class C3592g<E> implements Iterable<E> {
    private final Optional<Iterable<E>> f13070a = Optional.absent();

    protected C3592g() {
    }

    private Iterable<E> m18802a() {
        return (Iterable) this.f13070a.or((Object) this);
    }

    public static <T> C3592g<T> m18801a(Iterable<? extends T> iterable, Iterable<? extends T> iterable2, Iterable<? extends T> iterable3) {
        return C3592g.m18800a(ImmutableList.m18510a(iterable, iterable2, iterable3));
    }

    public static <T> C3592g<T> m18800a(final Iterable<? extends Iterable<? extends T>> iterable) {
        Preconditions.checkNotNull(iterable);
        return new C3592g<T>() {
            public Iterator<T> iterator() {
                return Iterators.m18628c(C3600n.m18808a(iterable, C3600n.m18806a()).iterator());
            }
        };
    }

    public String toString() {
        return C3600n.m18811a(m18802a());
    }
}
