package com.google.common.collect;

final class C3594m {
    static int m18803a(int i) {
        return (int) (461845907 * ((long) Integer.rotateLeft((int) (((long) i) * -862048943), 15)));
    }

    static int m18804a(Object obj) {
        return C3594m.m18803a(obj == null ? 0 : obj.hashCode());
    }
}
