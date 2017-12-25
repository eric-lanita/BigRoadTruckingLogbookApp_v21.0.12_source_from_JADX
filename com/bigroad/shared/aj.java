package com.bigroad.shared;

import java.security.SecureRandom;

public abstract class aj {
    private static final SecureRandom f2622a = new SecureRandom();

    public static byte[] m4179a() {
        byte[] bArr = new byte[16];
        f2622a.nextBytes(bArr);
        return bArr;
    }

    public static int m4180b() {
        return f2622a.nextInt();
    }
}
