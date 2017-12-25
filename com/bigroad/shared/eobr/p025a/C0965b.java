package com.bigroad.shared.eobr.p025a;

import java.io.IOException;
import java.io.InputStream;

public class C0965b {
    private final InputStream f2992a;

    public C0965b(InputStream inputStream) {
        this.f2992a = inputStream;
    }

    private byte m4953b() {
        int read = this.f2992a.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new IOException("End of file");
    }

    private byte m4954c() {
        byte b = m4953b();
        switch (b) {
            case (byte) -36:
                return (byte) -64;
            case (byte) -35:
                return (byte) -37;
            default:
                return b;
        }
    }

    private byte m4955d() {
        byte b = m4953b();
        if (b == (byte) -37) {
            return m4954c();
        }
        return b;
    }

    private int m4956e() {
        return ((m4955d() & 255) << 8) | (m4955d() & 255);
    }

    private byte[] m4952a(int i) {
        byte[] bArr = new byte[i];
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = m4955d();
        }
        return bArr;
    }

    public C0964a m4957a() {
        do {
        } while (m4953b() != (byte) -64);
        int e = m4956e();
        return new C0964a(e, m4952a(Math.max(0, e - 1)), m4955d());
    }
}
