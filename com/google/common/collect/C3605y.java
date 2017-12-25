package com.google.common.collect;

import com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.SortedSet;

final class C3605y {
    public static boolean m18825a(Comparator<?> comparator, Iterable<?> iterable) {
        Object a;
        Preconditions.checkNotNull(comparator);
        Preconditions.checkNotNull(iterable);
        if (iterable instanceof SortedSet) {
            a = C3605y.m18824a((SortedSet) iterable);
        } else if (!(iterable instanceof C3553x)) {
            return false;
        } else {
            a = ((C3553x) iterable).comparator();
        }
        return comparator.equals(a);
    }

    public static <E> Comparator<? super E> m18824a(SortedSet<E> sortedSet) {
        Comparator<? super E> comparator = sortedSet.comparator();
        if (comparator == null) {
            return C3540t.m18450c();
        }
        return comparator;
    }
}
