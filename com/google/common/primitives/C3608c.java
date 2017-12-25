package com.google.common.primitives;

public final class C3608c {
    static int m18847a(int i) {
        return Integer.MIN_VALUE ^ i;
    }

    public static int m18848a(int i, int i2) {
        return Ints.m18830a(C3608c.m18847a(i), C3608c.m18847a(i2));
    }

    public static long m18849b(int i) {
        return ((long) i) & 4294967295L;
    }

    public static String m18850b(int i, int i2) {
        return Long.toString(((long) i) & 4294967295L, i2);
    }
}
