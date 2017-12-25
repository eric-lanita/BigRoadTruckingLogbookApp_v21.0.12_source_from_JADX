package com.google.common.primitives;

import com.google.common.base.Preconditions;
import java.util.Arrays;

public final class C3607b {
    private static final byte[] f13084a = C3607b.m18845a();

    public static int m18841a(long j, long j2) {
        if (j < j2) {
            return -1;
        }
        return j > j2 ? 1 : 0;
    }

    public static long m18844a(long... jArr) {
        boolean z;
        int i = 1;
        if (jArr.length > 0) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z);
        long j = jArr[0];
        while (i < jArr.length) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
            i++;
        }
        return j;
    }

    public static byte[] m18846a(long j) {
        byte[] bArr = new byte[8];
        for (int i = 7; i >= 0; i--) {
            bArr[i] = (byte) ((int) (255 & j));
            j >>= 8;
        }
        return bArr;
    }

    public static long m18843a(byte[] bArr) {
        boolean z;
        if (bArr.length >= 8) {
            z = true;
        } else {
            z = false;
        }
        Preconditions.checkArgument(z, "array too small: %s < %s", bArr.length, 8);
        return C3607b.m18842a(bArr[0], bArr[1], bArr[2], bArr[3], bArr[4], bArr[5], bArr[6], bArr[7]);
    }

    public static long m18842a(byte b, byte b2, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8) {
        return ((((((((((long) b) & 255) << 56) | ((((long) b2) & 255) << 48)) | ((((long) b3) & 255) << 40)) | ((((long) b4) & 255) << 32)) | ((((long) b5) & 255) << 24)) | ((((long) b6) & 255) << 16)) | ((((long) b7) & 255) << 8)) | (((long) b8) & 255);
    }

    private static byte[] m18845a() {
        int i = 0;
        byte[] bArr = new byte[128];
        Arrays.fill(bArr, (byte) -1);
        for (int i2 = 0; i2 <= 9; i2++) {
            bArr[i2 + 48] = (byte) i2;
        }
        while (i <= 26) {
            bArr[i + 65] = (byte) (i + 10);
            bArr[i + 97] = (byte) (i + 10);
            i++;
        }
        return bArr;
    }
}
