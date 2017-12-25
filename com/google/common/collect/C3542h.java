package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Collection;
import java.util.Iterator;

public abstract class C3542h<E> extends C3541i implements Collection<E> {
    protected abstract Collection<E> mo2669c();

    protected /* synthetic */ Object mo2668d() {
        return mo2669c();
    }

    protected C3542h() {
    }

    public Iterator<E> iterator() {
        return mo2669c().iterator();
    }

    public int size() {
        return mo2669c().size();
    }

    @CanIgnoreReturnValue
    public boolean removeAll(Collection<?> collection) {
        return mo2669c().removeAll(collection);
    }

    public boolean isEmpty() {
        return mo2669c().isEmpty();
    }

    public boolean contains(Object obj) {
        return mo2669c().contains(obj);
    }

    @CanIgnoreReturnValue
    public boolean add(E e) {
        return mo2669c().add(e);
    }

    @CanIgnoreReturnValue
    public boolean remove(Object obj) {
        return mo2669c().remove(obj);
    }

    public boolean containsAll(Collection<?> collection) {
        return mo2669c().containsAll(collection);
    }

    @CanIgnoreReturnValue
    public boolean addAll(Collection<? extends E> collection) {
        return mo2669c().addAll(collection);
    }

    @CanIgnoreReturnValue
    public boolean retainAll(Collection<?> collection) {
        return mo2669c().retainAll(collection);
    }

    public void clear() {
        mo2669c().clear();
    }

    public Object[] toArray() {
        return mo2669c().toArray();
    }

    @CanIgnoreReturnValue
    public <T> T[] toArray(T[] tArr) {
        return mo2669c().toArray(tArr);
    }

    protected boolean m18482a(Collection<? extends E> collection) {
        return Iterators.m18620a((Collection) this, collection.iterator());
    }
}
