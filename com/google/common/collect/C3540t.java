package com.google.common.collect;

import com.google.common.base.Function;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Comparator;

public abstract class C3540t<T> implements Comparator<T> {
    @CanIgnoreReturnValue
    public abstract int compare(T t, T t2);

    public static <C extends Comparable> C3540t<C> m18450c() {
        return NaturalOrdering.f13030a;
    }

    public static <T> C3540t<T> m18449a(Comparator<T> comparator) {
        return comparator instanceof C3540t ? (C3540t) comparator : new ComparatorOrdering(comparator);
    }

    protected C3540t() {
    }

    public <S extends T> C3540t<S> mo2708a() {
        return new NullsFirstOrdering(this);
    }

    public <S extends T> C3540t<S> mo2709b() {
        return new NullsLastOrdering(this);
    }

    public <F> C3540t<F> m18452a(Function<F, ? extends T> function) {
        return new ByFunctionOrdering(function, this);
    }
}
