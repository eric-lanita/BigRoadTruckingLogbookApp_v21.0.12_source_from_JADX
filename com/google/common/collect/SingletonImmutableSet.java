package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.util.Iterator;

final class SingletonImmutableSet<E> extends ImmutableSet<E> {
    final transient E f13061a;
    @LazyInit
    private transient int f13062b;

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    SingletonImmutableSet(E e) {
        this.f13061a = Preconditions.checkNotNull(e);
    }

    SingletonImmutableSet(E e, int i) {
        this.f13061a = e;
        this.f13062b = i;
    }

    public int size() {
        return 1;
    }

    public boolean contains(Object obj) {
        return this.f13061a.equals(obj);
    }

    public ab<E> mo2684a() {
        return Iterators.m18614a(this.f13061a);
    }

    ImmutableList<E> mo2711f() {
        return ImmutableList.m18508a(this.f13061a);
    }

    boolean mo2690c() {
        return false;
    }

    int mo2683a(Object[] objArr, int i) {
        objArr[i] = this.f13061a;
        return i + 1;
    }

    public final int hashCode() {
        int i = this.f13062b;
        if (i != 0) {
            return i;
        }
        i = this.f13061a.hashCode();
        this.f13062b = i;
        return i;
    }

    boolean mo2717e() {
        return this.f13062b != 0;
    }

    public String toString() {
        return '[' + this.f13061a.toString() + ']';
    }
}
