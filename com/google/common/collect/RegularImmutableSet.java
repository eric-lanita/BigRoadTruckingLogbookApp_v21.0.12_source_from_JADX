package com.google.common.collect;

import java.util.Iterator;

final class RegularImmutableSet<E> extends ImmutableSet<E> {
    static final RegularImmutableSet<Object> f13052a = new RegularImmutableSet(new Object[0], 0, null, 0, 0);
    final transient Object[] f13053b;
    final transient Object[] f13054c;
    private final transient int f13055d;
    private final transient int f13056e;
    private final transient int f13057f;

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    RegularImmutableSet(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.f13053b = objArr;
        this.f13054c = objArr2;
        this.f13055d = i2;
        this.f13056e = i;
        this.f13057f = i3;
    }

    public boolean contains(Object obj) {
        Object[] objArr = this.f13054c;
        if (obj == null || objArr == null) {
            return false;
        }
        int a = C3594m.m18804a(obj);
        while (true) {
            a &= this.f13055d;
            Object obj2 = objArr[a];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            a++;
        }
    }

    public int size() {
        return this.f13057f;
    }

    public ab<E> mo2684a() {
        return Iterators.m18617a(this.f13053b, 0, this.f13057f, 0);
    }

    int mo2683a(Object[] objArr, int i) {
        System.arraycopy(this.f13053b, 0, objArr, i, this.f13057f);
        return this.f13057f + i;
    }

    ImmutableList<E> mo2711f() {
        return ImmutableList.m18514b(this.f13053b, this.f13057f);
    }

    boolean mo2690c() {
        return false;
    }

    public int hashCode() {
        return this.f13056e;
    }

    boolean mo2717e() {
        return true;
    }
}
