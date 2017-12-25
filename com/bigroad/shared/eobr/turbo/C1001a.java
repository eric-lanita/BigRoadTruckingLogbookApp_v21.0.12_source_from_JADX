package com.bigroad.shared.eobr.turbo;

import java.io.InputStream;
import java.io.OutputStream;

public class C1001a {
    public static int m5125a(InputStream inputStream) {
        return ((inputStream.read() | (inputStream.read() << 8)) | (inputStream.read() << 16)) | (inputStream.read() << 24);
    }

    public static long m5128b(InputStream inputStream) {
        return ((((((((long) inputStream.read()) | (((long) inputStream.read()) << 8)) | (((long) inputStream.read()) << 16)) | (((long) inputStream.read()) << 24)) | (((long) inputStream.read()) << 32)) | (((long) inputStream.read()) << 40)) | (((long) inputStream.read()) << 48)) | (((long) inputStream.read()) << 56);
    }

    public static void m5126a(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >>> 8) & 255);
        outputStream.write((i >>> 16) & 255);
        outputStream.write((i >>> 24) & 255);
    }

    public static void m5127a(OutputStream outputStream, long j) {
        outputStream.write(((int) j) & 255);
        outputStream.write(((int) (j >>> 8)) & 255);
        outputStream.write(((int) (j >>> 16)) & 255);
        outputStream.write(((int) (j >>> 24)) & 255);
        outputStream.write(((int) (j >>> 32)) & 255);
        outputStream.write(((int) (j >>> 40)) & 255);
        outputStream.write(((int) (j >>> 48)) & 255);
        outputStream.write(((int) (j >>> 56)) & 255);
    }
}
