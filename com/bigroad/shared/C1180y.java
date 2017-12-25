package com.bigroad.shared;

import com.google.protobuf.C3642c;
import java.util.Arrays;

public abstract class C1180y {
    private static final char[] f3997a = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    private static int m5987a(byte b, char[] cArr, int i) {
        int i2 = i + 1;
        cArr[i] = f3997a[(b & 240) >>> 4];
        int i3 = i2 + 1;
        cArr[i2] = f3997a[b & 15];
        return i3;
    }

    public static String m5988a(byte b) {
        char[] cArr = new char[2];
        C1180y.m5987a(b, cArr, 0);
        return new String(cArr);
    }

    public static String m5989a(C3642c c3642c) {
        int i = 0;
        if (c3642c == null) {
            return null;
        }
        int b = c3642c.mo2752b();
        char[] cArr = new char[(b * 2)];
        for (int i2 = 0; i2 < b; i2++) {
            i = C1180y.m5987a(c3642c.mo2749a(i2), cArr, i);
        }
        return new String(cArr);
    }

    public static String m5991a(byte[] bArr, int i) {
        int i2 = 0;
        if (bArr == null) {
            return null;
        }
        char[] cArr = new char[(Math.max(bArr.length - i, 0) * 2)];
        while (i < bArr.length) {
            i2 = C1180y.m5987a(bArr[i], cArr, i2);
            i++;
        }
        return new String(cArr);
    }

    public static String m5990a(byte[] bArr) {
        return C1180y.m5991a(bArr, 0);
    }

    public static String m5993b(byte[] bArr) {
        String a = C1180y.m5990a(bArr);
        if (a == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder(a.length() + (a.length() / 2));
        int i = 0;
        while (i < a.length()) {
            if (i != 0 && i % 2 == 0) {
                stringBuilder.append(' ');
            }
            stringBuilder.append(a.charAt(i));
            i++;
        }
        return stringBuilder.toString();
    }

    public static byte[] m5992a(String str) {
        int i = 0;
        if (am.m4188a((CharSequence) str)) {
            return null;
        }
        int length = str.length();
        if (length % 2 != 0) {
            return null;
        }
        byte[] bArr = new byte[(length / 2)];
        int i2 = 0;
        while (i2 < length) {
            int i3 = i2 + 1;
            int digit = Character.digit(str.charAt(i2), 16);
            int i4 = i3 + 1;
            i3 = Character.digit(str.charAt(i3), 16);
            if (digit < 0 || i3 < 0) {
                return null;
            }
            i2 = i + 1;
            bArr[i] = (byte) (i3 | (digit << 4));
            i = i2;
            i2 = i4;
        }
        return bArr;
    }

    public static byte[] m5994b(String str) {
        int i = 0;
        if (am.m4188a((CharSequence) str)) {
            return null;
        }
        int length = str.length();
        int i2 = (length / 2) + 1;
        byte[] bArr = new byte[i2];
        int i3 = 0;
        while (i < length) {
            int i4 = i + 1;
            int digit = Character.digit(str.charAt(i), 16);
            if (i4 >= length) {
                return null;
            }
            i = i4 + 1;
            int digit2 = Character.digit(str.charAt(i4), 16);
            if (digit < 0 || digit2 < 0) {
                return null;
            }
            i4 = i3 + 1;
            bArr[i3] = (byte) ((digit << 4) | digit2);
            if (i < length && str.charAt(i) == ':') {
                i++;
            }
            i3 = i4;
        }
        return i3 != i2 ? Arrays.copyOf(bArr, i3) : bArr;
    }

    public static String m5996c(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < bArr.length; i++) {
            if (i != 0) {
                stringBuilder.append(":");
            }
            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
        }
        return stringBuilder.toString();
    }

    public static String m5997d(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        while (i < bArr.length) {
            if (i != 0 && i % 2 == 0) {
                stringBuilder.append("-");
            }
            stringBuilder.append(String.format("%02X", new Object[]{Byte.valueOf(bArr[i])}));
            i++;
        }
        return stringBuilder.toString();
    }

    public static String m5995c(String str) {
        return C1180y.m5997d(C1180y.m5994b(str));
    }
}
