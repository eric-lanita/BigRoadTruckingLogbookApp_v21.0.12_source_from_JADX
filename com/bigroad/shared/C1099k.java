package com.bigroad.shared;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

public abstract class C1099k {
    private static final DateFormat f3576a = new SimpleDateFormat("HH:mm:ss", Locale.US);

    public static long m5446a(long j, long j2) {
        return (511 & j) | ((j2 / 1000) << 9);
    }

    public static Long m5447a(long j) {
        long j2 = (-512 & j) >> 9;
        return j2 == 0 ? null : Long.valueOf(j2 * 1000);
    }
}
