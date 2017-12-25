package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.ListIterator;

class RegularImmutableList<E> extends ImmutableList<E> {
    static final ImmutableList<Object> f13036a = new RegularImmutableList(new Object[0], 0);
    final transient Object[] f13037b;
    private final transient int f13038c;

    public /* synthetic */ ListIterator listIterator(int i) {
        return mo2710a(i);
    }

    RegularImmutableList(Object[] objArr, int i) {
        this.f13037b = objArr;
        this.f13038c = i;
    }

    public int size() {
        return this.f13038c;
    }

    boolean mo2690c() {
        return false;
    }

    int mo2683a(Object[] objArr, int i) {
        System.arraycopy(this.f13037b, 0, objArr, i, this.f13038c);
        return this.f13038c + i;
    }

    public E get(int i) {
        Preconditions.checkElementIndex(i, this.f13038c);
        return this.f13037b[i];
    }

    public ac<E> mo2710a(int i) {
        return Iterators.m18617a(this.f13037b, 0, this.f13038c, i);
    }
}
