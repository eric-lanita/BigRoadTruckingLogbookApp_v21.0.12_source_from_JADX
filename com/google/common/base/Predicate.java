package com.google.common.base;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public interface Predicate<T> {
    @CanIgnoreReturnValue
    boolean apply(T t);

    boolean equals(Object obj);
}
