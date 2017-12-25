package com.bigroad.shared;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract class C1100l {
    private static final DateFormat f3577a = new SimpleDateFormat("HH:mm:ss", Locale.US);

    public static long m5448a(long j) {
        return 15 & j;
    }

    public static long m5449a(long j, long j2) {
        return (511 & j) | ((j2 / 1000) << 9);
    }

    public static Long m5450b(long j) {
        long j2 = (-512 & j) >> 9;
        return j2 == 0 ? null : Long.valueOf(j2 * 1000);
    }
}
