package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Queue;

public abstract class C3543j<E> extends C3542h<E> implements Queue<E> {
    protected abstract Queue<E> mo2672b();

    protected /* synthetic */ Collection mo2669c() {
        return mo2672b();
    }

    protected /* synthetic */ Object mo2668d() {
        return mo2672b();
    }

    protected C3543j() {
    }

    @CanIgnoreReturnValue
    public boolean offer(E e) {
        return mo2672b().offer(e);
    }

    @CanIgnoreReturnValue
    public E poll() {
        return mo2672b().poll();
    }

    @CanIgnoreReturnValue
    public E remove() {
        return mo2672b().remove();
    }

    public E peek() {
        return mo2672b().peek();
    }

    public E element() {
        return mo2672b().element();
    }
}
