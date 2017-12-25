package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public abstract class ImmutableCollection<E> extends AbstractCollection<E> implements Serializable {
    private static final Object[] f12980a = new Object[0];

    public static abstract class C3544b<E> {
        @CanIgnoreReturnValue
        public abstract C3544b<E> mo2678b(E e);

        static int m18493a(int i, int i2) {
            if (i2 < 0) {
                throw new AssertionError("cannot store more than MAX_VALUE elements");
            }
            int i3 = ((i >> 1) + i) + 1;
            if (i3 < i2) {
                i3 = Integer.highestOneBit(i2 - 1) << 1;
            }
            if (i3 < 0) {
                return Integer.MAX_VALUE;
            }
            return i3;
        }

        C3544b() {
        }

        @CanIgnoreReturnValue
        public C3544b<E> mo2677a(E... eArr) {
            for (Object b : eArr) {
                mo2678b(b);
            }
            return this;
        }

        @CanIgnoreReturnValue
        public C3544b<E> mo2676a(Iterable<? extends E> iterable) {
            for (Object b : iterable) {
                mo2678b(b);
            }
            return this;
        }
    }

    static abstract class C3545a<E> extends C3544b<E> {
        Object[] f12977a;
        int f12978b = 0;
        boolean f12979c;

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2678b(Object obj) {
            return mo2697a(obj);
        }

        C3545a(int i) {
            C3587d.m18767a(i, "initialCapacity");
            this.f12977a = new Object[i];
        }

        private void m18497a(int i) {
            if (this.f12977a.length < i) {
                this.f12977a = Arrays.copyOf(this.f12977a, C3544b.m18493a(this.f12977a.length, i));
                this.f12979c = false;
            } else if (this.f12979c) {
                this.f12977a = (Object[]) this.f12977a.clone();
                this.f12979c = false;
            }
        }

        @CanIgnoreReturnValue
        public C3545a<E> mo2697a(E e) {
            Preconditions.checkNotNull(e);
            m18497a(this.f12978b + 1);
            Object[] objArr = this.f12977a;
            int i = this.f12978b;
            this.f12978b = i + 1;
            objArr[i] = e;
            return this;
        }

        @CanIgnoreReturnValue
        public C3544b<E> mo2677a(E... eArr) {
            C3602s.m18817a(eArr);
            m18497a(this.f12978b + eArr.length);
            System.arraycopy(eArr, 0, this.f12977a, this.f12978b, eArr.length);
            this.f12978b += eArr.length;
            return this;
        }

        @CanIgnoreReturnValue
        public C3544b<E> mo2676a(Iterable<? extends E> iterable) {
            if (iterable instanceof Collection) {
                Collection collection = (Collection) iterable;
                m18497a(collection.size() + this.f12978b);
            }
            super.mo2676a((Iterable) iterable);
            return this;
        }
    }

    public abstract ab<E> mo2684a();

    abstract boolean mo2690c();

    public abstract boolean contains(Object obj);

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    ImmutableCollection() {
    }

    public final Object[] toArray() {
        int size = size();
        if (size == 0) {
            return f12980a;
        }
        Object[] objArr = new Object[size];
        mo2683a(objArr, 0);
        return objArr;
    }

    @CanIgnoreReturnValue
    public final <T> T[] toArray(T[] tArr) {
        Preconditions.checkNotNull(tArr);
        int size = size();
        if (tArr.length < size) {
            tArr = C3602s.m18818a((Object[]) tArr, size);
        } else if (tArr.length > size) {
            tArr[size] = null;
        }
        mo2683a(tArr, 0);
        return tArr;
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean add(E e) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @CanIgnoreReturnValue
    @Deprecated
    public final boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public ImmutableList<E> mo2685b() {
        return isEmpty() ? ImmutableList.m18516d() : ImmutableList.m18513b(toArray());
    }

    @CanIgnoreReturnValue
    int mo2683a(Object[] objArr, int i) {
        Iterator a = mo2684a();
        while (a.hasNext()) {
            int i2 = i + 1;
            objArr[i] = a.next();
            i = i2;
        }
        return i;
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
