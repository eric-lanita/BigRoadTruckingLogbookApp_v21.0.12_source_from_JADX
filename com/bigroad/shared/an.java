package com.bigroad.shared;

public class an {
    public static boolean m4194a(long j) {
        return j != 0;
    }

    public static boolean m4195b(long j) {
        return (j & 1) == 1;
    }

    public static boolean m4196c(long j) {
        return (j & 2) == 2;
    }

    public static boolean m4197d(long j) {
        return (j & 4) == 4;
    }

    public static boolean m4198e(long j) {
        return m4195b(j) || m4196c(j);
    }
}
