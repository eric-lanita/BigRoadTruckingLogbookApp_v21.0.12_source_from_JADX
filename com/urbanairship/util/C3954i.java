package com.urbanairship.util;

public abstract class C3954i {
    public static String m20511a(String str, int i, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i2 = 0; i2 < i; i2++) {
            stringBuilder.append(str);
            if (i2 + 1 != i) {
                stringBuilder.append(str2);
            }
        }
        return stringBuilder.toString();
    }

    public static boolean m20512a(String str) {
        return str == null || str.length() == 0;
    }

    public static boolean m20513a(String str, String str2) {
        if (str == null) {
            return str2 == null;
        } else {
            return str.equals(str2);
        }
    }
}
