package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.C3544b;
import com.google.common.collect.ImmutableCollection.C3545a;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public abstract class ImmutableList<E> extends ImmutableCollection<E> implements List<E>, RandomAccess {

    private static class ReverseImmutableList<E> extends ImmutableList<E> {
        private final transient ImmutableList<E> f12984a;

        public /* synthetic */ Iterator iterator() {
            return super.mo2684a();
        }

        public /* synthetic */ ListIterator listIterator() {
            return super.m18524e();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return super.mo2710a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return mo2689a(i, i2);
        }

        ReverseImmutableList(ImmutableList<E> immutableList) {
            this.f12984a = immutableList;
        }

        private int m18526b(int i) {
            return (size() - 1) - i;
        }

        private int m18527c(int i) {
            return size() - i;
        }

        public ImmutableList<E> mo2691f() {
            return this.f12984a;
        }

        public boolean contains(Object obj) {
            return this.f12984a.contains(obj);
        }

        public int indexOf(Object obj) {
            int lastIndexOf = this.f12984a.lastIndexOf(obj);
            return lastIndexOf >= 0 ? m18526b(lastIndexOf) : -1;
        }

        public int lastIndexOf(Object obj) {
            int indexOf = this.f12984a.indexOf(obj);
            return indexOf >= 0 ? m18526b(indexOf) : -1;
        }

        public ImmutableList<E> mo2689a(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, size());
            return this.f12984a.mo2689a(m18527c(i2), m18527c(i)).mo2691f();
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, size());
            return this.f12984a.get(m18526b(i));
        }

        public int size() {
            return this.f12984a.size();
        }

        boolean mo2690c() {
            return this.f12984a.mo2690c();
        }
    }

    static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableList.m18512a(this.elements);
        }
    }

    class SubList extends ImmutableList<E> {
        final transient int f12985a;
        final transient int f12986b;

        public /* synthetic */ Iterator iterator() {
            return super.mo2684a();
        }

        public /* synthetic */ ListIterator listIterator() {
            return super.m18524e();
        }

        public /* synthetic */ ListIterator listIterator(int i) {
            return super.mo2710a(i);
        }

        public /* synthetic */ List subList(int i, int i2) {
            return mo2689a(i, i2);
        }

        SubList(int i, int i2) {
            this.f12985a = i;
            this.f12986b = i2;
        }

        public int size() {
            return this.f12986b;
        }

        public E get(int i) {
            Preconditions.checkElementIndex(i, this.f12986b);
            return ImmutableList.this.get(this.f12985a + i);
        }

        public ImmutableList<E> mo2689a(int i, int i2) {
            Preconditions.checkPositionIndexes(i, i2, this.f12986b);
            return ImmutableList.this.mo2689a(this.f12985a + i, this.f12985a + i2);
        }

        boolean mo2690c() {
            return true;
        }
    }

    public static final class C3549a<E> extends C3545a<E> {
        @CanIgnoreReturnValue
        public /* synthetic */ C3545a mo2697a(Object obj) {
            return m18540c(obj);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2676a(Iterable iterable) {
            return m18538b(iterable);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2677a(Object[] objArr) {
            return m18539b(objArr);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2678b(Object obj) {
            return m18540c(obj);
        }

        public C3549a() {
            this(4);
        }

        C3549a(int i) {
            super(i);
        }

        @CanIgnoreReturnValue
        public C3549a<E> m18540c(E e) {
            super.mo2697a((Object) e);
            return this;
        }

        @CanIgnoreReturnValue
        public C3549a<E> m18538b(Iterable<? extends E> iterable) {
            super.mo2676a((Iterable) iterable);
            return this;
        }

        @CanIgnoreReturnValue
        public C3549a<E> m18539b(E... eArr) {
            super.mo2677a((Object[]) eArr);
            return this;
        }

        public ImmutableList<E> m18536a() {
            this.c = true;
            return ImmutableList.m18514b(this.a, this.b);
        }
    }

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    public /* synthetic */ ListIterator listIterator() {
        return m18524e();
    }

    public /* synthetic */ ListIterator listIterator(int i) {
        return mo2710a(i);
    }

    public /* synthetic */ List subList(int i, int i2) {
        return mo2689a(i, i2);
    }

    public static <E> ImmutableList<E> m18516d() {
        return RegularImmutableList.f13036a;
    }

    public static <E> ImmutableList<E> m18508a(E e) {
        return m18515c(e);
    }

    public static <E> ImmutableList<E> m18509a(E e, E e2) {
        return m18515c(e, e2);
    }

    public static <E> ImmutableList<E> m18510a(E e, E e2, E e3) {
        return m18515c(e, e2, e3);
    }

    public static <E> ImmutableList<E> m18511a(Collection<? extends E> collection) {
        if (!(collection instanceof ImmutableCollection)) {
            return m18515c(collection.toArray());
        }
        ImmutableList<E> b = ((ImmutableCollection) collection).mo2685b();
        if (b.mo2690c()) {
            return m18513b(b.toArray());
        }
        return b;
    }

    public static <E> ImmutableList<E> m18512a(E[] eArr) {
        if (eArr.length == 0) {
            return m18516d();
        }
        return m18515c((Object[]) eArr.clone());
    }

    private static <E> ImmutableList<E> m18515c(Object... objArr) {
        return m18513b(C3602s.m18817a(objArr));
    }

    static <E> ImmutableList<E> m18513b(Object[] objArr) {
        return m18514b(objArr, objArr.length);
    }

    static <E> ImmutableList<E> m18514b(Object[] objArr, int i) {
        if (i == 0) {
            return m18516d();
        }
        return new RegularImmutableList(objArr, i);
    }

    ImmutableList() {
    }

    public ab<E> mo2684a() {
        return m18524e();
    }

    public ac<E> m18524e() {
        return mo2710a(0);
    }

    public ac<E> mo2710a(int i) {
        return new C3547a<E>(this, size(), i) {
            final /* synthetic */ ImmutableList f12983a;

            protected E mo2682a(int i) {
                return this.f12983a.get(i);
            }
        };
    }

    public int indexOf(Object obj) {
        return obj == null ? -1 : Lists.m18643b(this, obj);
    }

    public int lastIndexOf(Object obj) {
        return obj == null ? -1 : Lists.m18644c(this, obj);
    }

    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    public ImmutableList<E> mo2689a(int i, int i2) {
        Preconditions.checkPositionIndexes(i, i2, size());
        int i3 = i2 - i;
        if (i3 == size()) {
            return this;
        }
        if (i3 == 0) {
            return m18516d();
        }
        return m18523b(i, i2);
    }

    ImmutableList<E> m18523b(int i, int i2) {
        return new SubList(i, i2 - i);
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(int i, Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E set(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void add(int i, E e) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E remove(int i) {
        throw new UnsupportedOperationException();
    }

    public final ImmutableList<E> mo2685b() {
        return this;
    }

    int mo2683a(Object[] objArr, int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            objArr[i + i2] = get(i2);
        }
        return i + size;
    }

    public ImmutableList<E> mo2691f() {
        return size() <= 1 ? this : new ReverseImmutableList(this);
    }

    public boolean equals(Object obj) {
        return Lists.m18642a((List) this, obj);
    }

    public int hashCode() {
        int i = 1;
        for (int i2 = 0; i2 < size(); i2++) {
            i = (((i * 31) + get(i2).hashCode()) ^ -1) ^ -1;
        }
        return i;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }

    public static <E> C3549a<E> m18517g() {
        return new C3549a();
    }
}
