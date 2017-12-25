package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;

public final class C3602s {
    public static <T> T[] m18818a(T[] tArr, int i) {
        return C3603u.m18820a(tArr, i);
    }

    @CanIgnoreReturnValue
    static Object[] m18817a(Object... objArr) {
        return C3602s.m18819b(objArr, objArr.length);
    }

    @CanIgnoreReturnValue
    static Object[] m18819b(Object[] objArr, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            C3602s.m18816a(objArr[i2], i2);
        }
        return objArr;
    }

    @CanIgnoreReturnValue
    static Object m18816a(Object obj, int i) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException("at index " + i);
    }
}
