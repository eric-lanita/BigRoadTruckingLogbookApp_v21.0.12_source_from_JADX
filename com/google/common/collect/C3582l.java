package com.google.common.collect;

import java.util.Collection;
import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

public abstract class C3582l<E> extends C3581k<E> implements SortedSet<E> {
    protected abstract SortedSet<E> mo2733b();

    protected /* synthetic */ Set mo2732a() {
        return mo2733b();
    }

    protected /* synthetic */ Collection mo2669c() {
        return mo2733b();
    }

    protected /* synthetic */ Object mo2668d() {
        return mo2733b();
    }

    protected C3582l() {
    }

    public Comparator<? super E> comparator() {
        return mo2733b().comparator();
    }

    public E first() {
        return mo2733b().first();
    }

    public SortedSet<E> headSet(E e) {
        return mo2733b().headSet(e);
    }

    public E last() {
        return mo2733b().last();
    }

    public SortedSet<E> subSet(E e, E e2) {
        return mo2733b().subSet(e, e2);
    }

    public SortedSet<E> tailSet(E e) {
        return mo2733b().tailSet(e);
    }
}
