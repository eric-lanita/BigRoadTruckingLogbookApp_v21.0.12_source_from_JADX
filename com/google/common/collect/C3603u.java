package com.google.common.collect;

import java.lang.reflect.Array;

final class C3603u {
    static <T> T[] m18820a(T[] tArr, int i) {
        return (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i);
    }
}
