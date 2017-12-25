package com.bigroad.shared.eobr.p025a;

import java.io.OutputStream;

public class C0966c {
    private final OutputStream f2993a;

    public C0966c(OutputStream outputStream) {
        this.f2993a = outputStream;
    }

    private void m4958a() {
        this.f2993a.flush();
    }

    private void m4959a(byte b) {
        this.f2993a.write(b);
    }

    private void m4962b(byte b) {
        switch (b) {
            case (byte) -64:
                m4959a((byte) -37);
                m4959a((byte) -36);
                return;
            case (byte) -37:
                m4959a((byte) -37);
                m4959a((byte) -35);
                return;
            default:
                m4959a(b);
                return;
        }
    }

    private void m4960a(int i) {
        m4962b((byte) (i >> 8));
        m4962b((byte) i);
    }

    private void m4961a(byte[] bArr) {
        for (byte b : bArr) {
            m4962b(b);
        }
    }

    public void m4963a(C0964a c0964a) {
        if (c0964a != null) {
            byte[] b = c0964a.m4950b();
            int length = b.length + 1;
            m4959a((byte) -64);
            m4960a(length);
            m4961a(b);
            m4962b(c0964a.m4951c());
            m4958a();
        }
    }
}
