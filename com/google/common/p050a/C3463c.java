package com.google.common.p050a;

import com.google.common.base.Preconditions;

public abstract class C3463c extends C3462d {
    protected abstract char[] mo2542a(char c);

    protected C3463c() {
    }

    public String mo2541a(String str) {
        Preconditions.checkNotNull(str);
        int length = str.length();
        for (int i = 0; i < length; i++) {
            if (mo2542a(str.charAt(i)) != null) {
                return m18296a(str, i);
            }
        }
        return str;
    }

    protected final String m18296a(String str, int i) {
        int length = str.length();
        char[] a = C3472f.m18313a();
        int length2 = a.length;
        int i2 = 0;
        int i3 = 0;
        while (i < length) {
            Object a2 = mo2542a(str.charAt(i));
            if (a2 != null) {
                int length3 = a2.length;
                int i4 = i - i2;
                int i5 = (i3 + i4) + length3;
                if (length2 < i5) {
                    length2 = ((length - i) * 2) + i5;
                    a = C3463c.m18294a(a, i3, length2);
                }
                if (i4 > 0) {
                    str.getChars(i2, i, a, i3);
                    i2 = i3 + i4;
                } else {
                    i2 = i3;
                }
                if (length3 > 0) {
                    System.arraycopy(a2, 0, a, i2, length3);
                    i2 += length3;
                }
                i3 = i2;
                i2 = i + 1;
            }
            i++;
        }
        int i6 = length - i2;
        if (i6 > 0) {
            i6 += i3;
            if (length2 < i6) {
                a = C3463c.m18294a(a, i3, i6);
            }
            str.getChars(i2, length, a, i3);
            i3 = i6;
        }
        return new String(a, 0, i3);
    }

    private static char[] m18294a(char[] cArr, int i, int i2) {
        if (i2 < 0) {
            throw new AssertionError("Cannot increase internal buffer any further");
        }
        Object obj = new char[i2];
        if (i > 0) {
            System.arraycopy(cArr, 0, obj, 0, i);
        }
        return obj;
    }
}
