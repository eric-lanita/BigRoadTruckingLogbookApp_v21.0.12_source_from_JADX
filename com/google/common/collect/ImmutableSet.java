package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection.C3544b;
import com.google.common.collect.ImmutableCollection.C3545a;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.LazyInit;
import com.google.j2objc.annotations.RetainedWith;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;

public abstract class ImmutableSet<E> extends ImmutableCollection<E> implements Set<E> {
    @RetainedWith
    @LazyInit
    private transient ImmutableList<E> f12995a;

    private static class SerializedForm implements Serializable {
        private static final long serialVersionUID = 0;
        final Object[] elements;

        SerializedForm(Object[] objArr) {
            this.elements = objArr;
        }

        Object readResolve() {
            return ImmutableSet.m18567a(this.elements);
        }
    }

    public static class C3551a<E> extends C3545a<E> {
        @CanIgnoreReturnValue
        public /* synthetic */ C3545a mo2697a(Object obj) {
            return mo2700c(obj);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2676a(Iterable iterable) {
            return mo2698b(iterable);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2677a(Object[] objArr) {
            return mo2699b(objArr);
        }

        @CanIgnoreReturnValue
        public /* synthetic */ C3544b mo2678b(Object obj) {
            return mo2700c(obj);
        }

        public C3551a() {
            this(4);
        }

        C3551a(int i) {
            super(i);
        }

        @CanIgnoreReturnValue
        public C3551a<E> mo2700c(E e) {
            super.mo2697a((Object) e);
            return this;
        }

        @CanIgnoreReturnValue
        public C3551a<E> mo2699b(E... eArr) {
            super.mo2677a((Object[]) eArr);
            return this;
        }

        @CanIgnoreReturnValue
        public C3551a<E> mo2698b(Iterable<? extends E> iterable) {
            super.mo2676a((Iterable) iterable);
            return this;
        }
    }

    public abstract ab<E> mo2684a();

    public /* synthetic */ Iterator iterator() {
        return mo2684a();
    }

    public static <E> ImmutableSet<E> m18568d() {
        return RegularImmutableSet.f13052a;
    }

    public static <E> ImmutableSet<E> m18566a(E e) {
        return new SingletonImmutableSet(e);
    }

    private static <E> ImmutableSet<E> m18565a(int i, Object... objArr) {
        switch (i) {
            case 0:
                return m18568d();
            case 1:
                return m18566a(objArr[0]);
            default:
                int a = m18564a(i);
                Object[] objArr2 = new Object[a];
                int i2 = a - 1;
                int i3 = 0;
                int i4 = 0;
                for (int i5 = 0; i5 < i; i5++) {
                    Object a2 = C3602s.m18816a(objArr[i5], i5);
                    int hashCode = a2.hashCode();
                    int a3 = C3594m.m18803a(hashCode);
                    while (true) {
                        int i6 = a3 & i2;
                        Object obj = objArr2[i6];
                        if (obj == null) {
                            a3 = i3 + 1;
                            objArr[i3] = a2;
                            objArr2[i6] = a2;
                            i4 += hashCode;
                            i3 = a3;
                        } else if (!obj.equals(a2)) {
                            a3++;
                        }
                    }
                }
                Arrays.fill(objArr, i3, i, null);
                if (i3 == 1) {
                    return new SingletonImmutableSet(objArr[0], i4);
                }
                if (m18564a(i3) < a / 2) {
                    return m18565a(i3, objArr);
                }
                Object[] copyOf;
                if (i3 < objArr.length / 2) {
                    copyOf = Arrays.copyOf(objArr, i3);
                } else {
                    copyOf = objArr;
                }
                return new RegularImmutableSet(copyOf, i4, objArr2, i2, i3);
        }
    }

    static int m18564a(int i) {
        if (i < 751619276) {
            int highestOneBit = Integer.highestOneBit(i - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) i)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        Preconditions.checkArgument(i < 1073741824, "collection too large");
        return 1073741824;
    }

    public static <E> ImmutableSet<E> m18567a(E[] eArr) {
        switch (eArr.length) {
            case 0:
                return m18568d();
            case 1:
                return m18566a(eArr[0]);
            default:
                return m18565a(eArr.length, (Object[]) eArr.clone());
        }
    }

    ImmutableSet() {
    }

    boolean mo2717e() {
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj instanceof ImmutableSet) && mo2717e() && ((ImmutableSet) obj).mo2717e() && hashCode() != obj.hashCode()) {
            return false;
        }
        return Sets.m18757a((Set) this, obj);
    }

    public int hashCode() {
        return Sets.m18753a((Set) this);
    }

    public ImmutableList<E> mo2685b() {
        ImmutableList<E> immutableList = this.f12995a;
        if (immutableList != null) {
            return immutableList;
        }
        immutableList = mo2711f();
        this.f12995a = immutableList;
        return immutableList;
    }

    ImmutableList<E> mo2711f() {
        return ImmutableList.m18513b(toArray());
    }

    Object writeReplace() {
        return new SerializedForm(toArray());
    }
}
