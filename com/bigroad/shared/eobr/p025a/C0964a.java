package com.bigroad.shared.eobr.p025a;

import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.C0968a;

public class C0964a {
    private final int f2989a;
    private final byte[] f2990b;
    private final byte f2991c;

    public String toString() {
        return "VnaFrame [m_length=" + this.f2989a + ", m_data=" + C1180y.m5990a(this.f2990b) + ", m_checksum=" + C1180y.m5988a(this.f2991c) + "]";
    }

    private static byte m4940a(int i, byte[] bArr) {
        int i2 = (i & 255) + ((i >> 8) & 255);
        for (byte b : bArr) {
            i2 += b;
        }
        return (byte) i2;
    }

    private byte m4948d() {
        return C0964a.m4940a(this.f2989a, this.f2990b);
    }

    private static C0964a m4947a(byte[] bArr) {
        int length = bArr.length + 1;
        return new C0964a(length, bArr, (byte) (-C0964a.m4940a(length, bArr)));
    }

    public C0964a(int i, byte[] bArr, byte b) {
        this.f2989a = i;
        this.f2990b = bArr;
        this.f2991c = b;
    }

    public boolean m4949a() {
        return ((this.f2991c + m4948d()) & 255) == 0;
    }

    public byte[] m4950b() {
        return this.f2990b;
    }

    public byte m4951c() {
        return this.f2991c;
    }

    public static C0964a m4943a(byte b, int i) {
        byte[] bArr = new byte[5];
        bArr[0] = (byte) 1;
        bArr[1] = b;
        C0968a.m4966a(bArr, 2, i);
        return C0964a.m4947a(bArr);
    }

    public static C0964a m4946a(int i) {
        byte[] bArr = new byte[3];
        bArr[0] = (byte) 3;
        C0968a.m4968b(bArr, 1, i);
        return C0964a.m4947a(bArr);
    }

    public static C0964a m4944a(byte b, int i, byte b2, byte b3, byte b4, byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 8)];
        bArr2[0] = (byte) 5;
        bArr2[1] = b;
        C0968a.m4966a(bArr2, 2, i);
        bArr2[5] = b2;
        bArr2[6] = b3;
        bArr2[7] = b4;
        System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
        return C0964a.m4947a(bArr2);
    }

    public static C0964a m4945a(byte b, int i, byte b2, byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 5)];
        bArr2[0] = (byte) 8;
        bArr2[1] = b;
        C0968a.m4968b(bArr2, 2, i);
        bArr2[4] = b2;
        System.arraycopy(bArr, 0, bArr2, 5, bArr.length);
        return C0964a.m4947a(bArr2);
    }

    public static C0964a m4942a(byte b, byte b2, byte b3, byte b4, byte b5, byte[] bArr) {
        byte[] bArr2 = new byte[(bArr.length + 6)];
        bArr2[0] = (byte) 42;
        bArr2[1] = b;
        bArr2[2] = b2;
        bArr2[3] = b3;
        bArr2[4] = b4;
        bArr2[5] = b5;
        System.arraycopy(bArr, 0, bArr2, 6, bArr.length);
        return C0964a.m4947a(bArr2);
    }

    public static C0964a m4941a(byte b, byte b2) {
        return C0964a.m4947a(new byte[]{(byte) -1, b, b2});
    }
}
