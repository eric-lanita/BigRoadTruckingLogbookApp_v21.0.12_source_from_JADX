package com.bigroad.shared;

public abstract class aa {
    public static int m4133a(String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (Exception e) {
        }
        return i;
    }

    public static int m4132a(Integer num, int i) {
        return num == null ? i : num.intValue();
    }

    public static int m4131a(int i, int i2) {
        int abs = Math.abs(i2);
        return abs * ((((Integer.signum(i) * abs) / 2) + i) / abs);
    }

    public static int m4138b(int i, int i2) {
        int abs = Math.abs(i2);
        int i3 = (i / abs) * abs;
        if (i3 > i) {
            return i3 - abs;
        }
        return i3;
    }

    public static long m4136a(String str, long j) {
        try {
            j = Long.parseLong(str);
        } catch (Exception e) {
        }
        return j;
    }

    public static long m4135a(Long l, long j) {
        return l == null ? j : l.longValue();
    }

    public static long m4137a(byte[] bArr, int i) {
        long j = 0;
        for (int i2 = 0; i2 < 8; i2++) {
            j |= (((long) bArr[i + i2]) & 255) << (((8 - i2) - 1) * 8);
        }
        return j;
    }

    public static long m4134a(long j, long j2) {
        long abs = Math.abs(j2);
        long j3 = (j / abs) * abs;
        if (j3 < j) {
            return j3 + abs;
        }
        return j3;
    }

    public static long m4139b(long j, long j2) {
        long abs = Math.abs(j2);
        long j3 = (j / abs) * abs;
        if (j3 > j) {
            return j3 - abs;
        }
        return j3;
    }

    public static int m4141c(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j == j2 ? 0 : 1;
    }

    public static int m4140c(int i, int i2) {
        if (i < i2) {
            return -1;
        }
        return i == i2 ? 0 : 1;
    }
}
