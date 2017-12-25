package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.C3544b;
import com.google.common.collect.ImmutableCollection.C3545a;
import com.google.common.collect.ImmutableSet.C3551a;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.SortedSet;

public abstract class ImmutableSortedSet<E> extends ImmutableSortedSetFauxverideShim<E> implements C3553x<E>, NavigableSet<E> {
    final transient Comparator<? super E> f12997a;
    @LazyInit
    transient ImmutableSortedSet<E> f12998b;

    private static class SerializedForm<E> implements Serializable {
        private static final long serialVersionUID = 0;
        final Comparator<? super E> comparator;
        final Object[] elements;

        public SerializedForm(Comparator<? super E> comparator, Object[] objArr) {
            this.comparator = comparator;
            this.elements = objArr;
        }

        Object readResolve() {
            return new C3552a(this.comparator).m18582c(this.elements).m18576a();
        }
    }

    public static final class C3552a<E> extends C3551a<E> {
        private final Comparator<? super E> f12996d;

        @CanIgnoreReturnValue
        public /* synthetic */ C3545a mo2697a(Object obj) {
            return m18583d(obj);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2676a(Iterable iterable) {
            return m18581c(iterable);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2677a(Object[] objArr) {
            return m18582c(objArr);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2678b(Object obj) {
            return m18583d(obj);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3551a mo2698b(Iterable iterable) {
            return m18581c(iterable);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3551a mo2699b(Object[] objArr) {
            return m18582c(objArr);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3551a mo2700c(Object obj) {
            return m18583d(obj);
        }

        public C3552a(Comparator<? super E> comparator) {
            this.f12996d = (Comparator) Preconditions.checkNotNull(comparator);
        }

        @CanIgnoreReturnValue
        public C3552a<E> m18583d(E e) {
            super.mo2700c(e);
            return this;
        }

        @CanIgnoreReturnValue
        public C3552a<E> m18582c(E... eArr) {
            super.mo2699b((Object[]) eArr);
            return this;
        }

        @CanIgnoreReturnValue
        public C3552a<E> m18581c(Iterable<? extends E> iterable) {
            super.mo2698b((Iterable) iterable);
            return this;
        }

        public ImmutableSortedSet<E> m18576a() {
            ImmutableSortedSet<E> a = ImmutableSortedSet.m18585a(this.f12996d, this.b, this.a);
            this.b = a.size();
            this.c = true;
            return a;
        }
    }

    public abstract ab<E> mo2684a();

    abstract ImmutableSortedSet<E> mo2719b(E e, boolean z, E e2, boolean z2);

    abstract ImmutableSortedSet<E> mo2720c(E e, boolean z);

    abstract ImmutableSortedSet<E> mo2722d(E e, boolean z);

    abstract ImmutableSortedSet<E> mo2727h();

    public abstract ab<E> mo2729i();

    public /* synthetic */ Iterator descendingIterator() {
        return mo2729i();
    }

    public /* synthetic */ NavigableSet descendingSet() {
        return m18598g();
    }

    public /* synthetic */ NavigableSet headSet(Object obj, boolean z) {
        return m18588a(obj, z);
    }

    public /* synthetic */ SortedSet headSet(Object obj) {
        return m18591b(obj);
    }

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    public /* synthetic */ NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return m18589a(obj, z, obj2, z2);
    }

    public /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return m18592b(obj, obj2);
    }

    public /* synthetic */ NavigableSet tailSet(Object obj, boolean z) {
        return m18593b(obj, z);
    }

    public /* synthetic */ SortedSet tailSet(Object obj) {
        return m18595c(obj);
    }

    static <E> RegularImmutableSortedSet<E> m18586a(Comparator<? super E> comparator) {
        if (C3540t.m18450c().equals(comparator)) {
            return RegularImmutableSortedSet.f13058c;
        }
        return new RegularImmutableSortedSet(ImmutableList.m18516d(), comparator);
    }

    static <E> ImmutableSortedSet<E> m18585a(Comparator<? super E> comparator, int i, E... eArr) {
        if (i == 0) {
            return m18586a(comparator);
        }
        Object[] copyOf;
        C3602s.m18819b(eArr, i);
        Arrays.sort(eArr, 0, i, comparator);
        int i2 = 1;
        int i3 = 1;
        while (i2 < i) {
            int i4;
            Object obj = eArr[i2];
            if (comparator.compare(obj, eArr[i3 - 1]) != 0) {
                i4 = i3 + 1;
                eArr[i3] = obj;
            } else {
                i4 = i3;
            }
            i2++;
            i3 = i4;
        }
        Arrays.fill(eArr, i3, i, null);
        if (i3 < eArr.length / 2) {
            copyOf = Arrays.copyOf(eArr, i3);
        }
        return new RegularImmutableSortedSet(ImmutableList.m18514b(copyOf, i3), comparator);
    }

    int m18587a(Object obj, Object obj2) {
        return m18584a(this.f12997a, obj, obj2);
    }

    static int m18584a(Comparator<?> comparator, Object obj, Object obj2) {
        return comparator.compare(obj, obj2);
    }

    ImmutableSortedSet(Comparator<? super E> comparator) {
        this.f12997a = comparator;
    }

    public Comparator<? super E> comparator() {
        return this.f12997a;
    }

    public ImmutableSortedSet<E> m18591b(E e) {
        return m18588a((Object) e, false);
    }

    public ImmutableSortedSet<E> m18588a(E e, boolean z) {
        return mo2720c(Preconditions.checkNotNull(e), z);
    }

    public ImmutableSortedSet<E> m18592b(E e, E e2) {
        return m18589a(e, true, e2, false);
    }

    public ImmutableSortedSet<E> m18589a(E e, boolean z, E e2, boolean z2) {
        Preconditions.checkNotNull(e);
        Preconditions.checkNotNull(e2);
        Preconditions.checkArgument(this.f12997a.compare(e, e2) <= 0);
        return mo2719b(e, z, e2, z2);
    }

    public ImmutableSortedSet<E> m18595c(E e) {
        return m18593b((Object) e, true);
    }

    public ImmutableSortedSet<E> m18593b(E e, boolean z) {
        return mo2722d(Preconditions.checkNotNull(e), z);
    }

    public E lower(E e) {
        return Iterators.m18618a(m18588a((Object) e, false).mo2729i(), null);
    }

    public E floor(E e) {
        return Iterators.m18618a(m18588a((Object) e, true).mo2729i(), null);
    }

    public E ceiling(E e) {
        return C3600n.m18810a(m18593b((Object) e, true), null);
    }

    public E higher(E e) {
        return C3600n.m18810a(m18593b((Object) e, false), null);
    }

    public E first() {
        return mo2684a().next();
    }

    public E last() {
        return mo2729i().next();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E pollFirst() {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final E pollLast() {
        throw new UnsupportedOperationException();
    }

    public ImmutableSortedSet<E> m18598g() {
        ImmutableSortedSet<E> immutableSortedSet = this.f12998b;
        if (immutableSortedSet != null) {
            return immutableSortedSet;
        }
        immutableSortedSet = mo2727h();
        this.f12998b = immutableSortedSet;
        immutableSortedSet.f12998b = this;
        return immutableSortedSet;
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Use SerializedForm");
    }

    Object writeReplace() {
        return new SerializedForm(this.f12997a, toArray());
    }
}
