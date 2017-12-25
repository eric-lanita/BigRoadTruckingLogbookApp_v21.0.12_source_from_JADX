package com.urbanairship.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

public class C3948c {
    private static final SimpleDateFormat f14005a = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.US);
    private static final SimpleDateFormat f14006b = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.US);

    static {
        f14005a.setTimeZone(TimeZone.getTimeZone("UTC"));
        f14006b.setTimeZone(TimeZone.getTimeZone("UTC"));
    }

    public static long m20490a(String str) {
        if (str == null) {
            throw new ParseException("Unable to parse null timestamp", -1);
        }
        try {
            return f14005a.parse(str).getTime();
        } catch (ParseException e) {
            return f14006b.parse(str).getTime();
        }
    }

    public static long m20491a(String str, long j) {
        try {
            j = C3948c.m20490a(str);
        } catch (ParseException e) {
        }
        return j;
    }

    public static String m20492a(long j) {
        return f14005a.format(new Date(j));
    }
}
