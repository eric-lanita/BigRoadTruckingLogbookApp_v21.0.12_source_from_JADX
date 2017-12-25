package com.bigroad.shared;

import java.util.Arrays;
import java.util.regex.Pattern;

public class C1098j implements Comparable<C1098j> {
    private static final Pattern f3574a = Pattern.compile("\\.");
    private final int[] f3575b;

    public /* synthetic */ int compareTo(Object obj) {
        return m5443a((C1098j) obj);
    }

    public C1098j(String str) {
        int[] iArr;
        int i = 0;
        if (am.m4188a((CharSequence) str)) {
            iArr = new int[0];
        } else {
            int indexOf = str.indexOf(45);
            if (indexOf >= 0) {
                str = str.substring(0, indexOf);
            }
            String[] split = f3574a.split(str);
            int length = split.length;
            iArr = new int[length];
            while (i < length) {
                try {
                    iArr[i] = Integer.parseInt(split[i]);
                    i++;
                } catch (NumberFormatException e) {
                    iArr = Arrays.copyOf(iArr, i);
                }
            }
        }
        this.f3575b = iArr;
    }

    public C1098j(int... iArr) {
        this.f3575b = iArr;
    }

    public Integer m5444a() {
        if (this.f3575b.length >= 1) {
            return Integer.valueOf(this.f3575b[0]);
        }
        return null;
    }

    public Integer m5445b() {
        if (this.f3575b.length >= 2) {
            return Integer.valueOf(this.f3575b[1]);
        }
        return null;
    }

    public int m5443a(C1098j c1098j) {
        int max = Math.max(this.f3575b.length, c1098j.f3575b.length);
        int i = 0;
        while (i < max) {
            int i2;
            int i3 = i < this.f3575b.length ? this.f3575b[i] : 0;
            if (i < c1098j.f3575b.length) {
                i2 = c1098j.f3575b[i];
            } else {
                i2 = 0;
            }
            if (i3 < i2) {
                return -1;
            }
            if (i3 > i2) {
                return 1;
            }
            i++;
        }
        return 0;
    }

    public int hashCode() {
        return Arrays.hashCode(this.f3575b);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1098j)) {
            return false;
        }
        if (m5443a((C1098j) obj) != 0) {
            return false;
        }
        return true;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i : this.f3575b) {
            if (stringBuilder.length() > 0) {
                stringBuilder.append('.');
            }
            stringBuilder.append(i);
        }
        return stringBuilder.toString();
    }
}
