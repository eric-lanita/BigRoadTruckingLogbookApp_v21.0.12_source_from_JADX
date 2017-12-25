package com.bigroad.shared;

import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.security.DigestOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public abstract class C1097i {
    private static byte[] m5442a(String str, File file) {
        Closeable fileInputStream;
        Throwable e;
        try {
            fileInputStream = new FileInputStream(file);
            try {
                MessageDigest instance = MessageDigest.getInstance(str);
                OutputStream digestOutputStream = new DigestOutputStream(ae.f2618a, instance);
                C1181z.m5998a(fileInputStream, digestOutputStream);
                digestOutputStream.flush();
                byte[] digest = instance.digest();
                C1181z.m5999a(fileInputStream);
                return digest;
            } catch (NoSuchAlgorithmException e2) {
                e = e2;
                try {
                    throw new RuntimeException(e);
                } catch (Throwable th) {
                    e = th;
                    C1181z.m5999a(fileInputStream);
                    throw e;
                }
            }
        } catch (NoSuchAlgorithmException e3) {
            e = e3;
            fileInputStream = null;
            throw new RuntimeException(e);
        } catch (Throwable th2) {
            e = th2;
            fileInputStream = null;
            C1181z.m5999a(fileInputStream);
            throw e;
        }
    }

    public static byte[] m5441a(File file) {
        return C1097i.m5442a("MD5", file);
    }
}
