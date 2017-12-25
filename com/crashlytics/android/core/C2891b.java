package com.crashlytics.android.core;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

final class C2891b {
    public static final C2891b f9972a = new C2891b(new byte[0]);
    private final byte[] f9973b;
    private volatile int f9974c = 0;

    private C2891b(byte[] bArr) {
        this.f9973b = bArr;
    }

    public int m16254a() {
        return this.f9973b.length;
    }

    public static C2891b m16253a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C2891b(obj);
    }

    public static C2891b m16252a(String str) {
        try {
            return new C2891b(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported.", e);
        }
    }

    public void m16255a(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f9973b, i, bArr, i2, i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C2891b)) {
            return false;
        }
        C2891b c2891b = (C2891b) obj;
        int length = this.f9973b.length;
        if (length != c2891b.f9973b.length) {
            return false;
        }
        byte[] bArr = this.f9973b;
        byte[] bArr2 = c2891b.f9973b;
        for (int i = 0; i < length; i++) {
            if (bArr[i] != bArr2[i]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i = this.f9974c;
        if (i == 0) {
            byte[] bArr = this.f9973b;
            int length = this.f9973b.length;
            int i2 = 0;
            i = length;
            while (i2 < length) {
                int i3 = bArr[i2] + (i * 31);
                i2++;
                i = i3;
            }
            if (i == 0) {
                i = 1;
            }
            this.f9974c = i;
        }
        return i;
    }

    public InputStream m16256b() {
        return new ByteArrayInputStream(this.f9973b);
    }
}
