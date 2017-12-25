package com.bigroad.shared.eobr;

public abstract class C0968a {
    public static long m4965a(byte[] bArr, int i) {
        return ((((((long) bArr[i]) & 255) << 24) | ((((long) bArr[i + 1]) & 255) << 16)) | ((((long) bArr[i + 2]) & 255) << 8)) | (((long) bArr[i + 3]) & 255);
    }

    public static int m4967b(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) | ((bArr[i + 1] & 255) << 16)) | ((bArr[i + 2] & 255) << 8)) | (bArr[i + 3] & 255);
    }

    public static int m4969c(byte[] bArr, int i) {
        return (((bArr[i] & 255) << 16) | ((bArr[i + 1] & 255) << 8)) | (bArr[i + 2] & 255);
    }

    public static int m4970d(byte[] bArr, int i) {
        return ((bArr[i] & 255) << 8) | (bArr[i + 1] & 255);
    }

    public static void m4966a(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 16);
        bArr[i + 1] = (byte) (i2 >> 8);
        bArr[i + 2] = (byte) i2;
    }

    public static void m4968b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 8);
        bArr[i + 1] = (byte) i2;
    }
}
