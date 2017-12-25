package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Queue;

public final class EvictingQueue<E> extends C3543j<E> implements Serializable {
    private static final long serialVersionUID = 0;
    private final Queue<E> delegate;
    final int maxSize;

    protected /* synthetic */ Collection mo2669c() {
        return mo2672b();
    }

    protected /* synthetic */ Object mo2668d() {
        return mo2672b();
    }

    private EvictingQueue(int i) {
        Preconditions.checkArgument(i >= 0, "maxSize (%s) must >= 0", i);
        this.delegate = new ArrayDeque(i);
        this.maxSize = i;
    }

    public static <E> EvictingQueue<E> m18488a(int i) {
        return new EvictingQueue(i);
    }

    public int m18489a() {
        return this.maxSize - size();
    }

    protected Queue<E> mo2672b() {
        return this.delegate;
    }

    @CanIgnoreReturnValue
    public boolean offer(E e) {
        return add(e);
    }

    @CanIgnoreReturnValue
    public boolean add(E e) {
        Preconditions.checkNotNull(e);
        if (this.maxSize != 0) {
            if (size() == this.maxSize) {
                this.delegate.remove();
            }
            this.delegate.add(e);
        }
        return true;
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        int size = collection.size();
        if (size < this.maxSize) {
            return m18482a(collection);
        }
        clear();
        return C3600n.m18813a((Collection) this, C3600n.m18807a((Iterable) collection, size - this.maxSize));
    }

    public boolean contains(Object obj) {
        return mo2672b().contains(Preconditions.checkNotNull(obj));
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        return mo2672b().remove(Preconditions.checkNotNull(obj));
    }
}
