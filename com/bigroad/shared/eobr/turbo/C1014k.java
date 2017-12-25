package com.bigroad.shared.eobr.turbo;

import java.io.InputStream;
import java.io.OutputStream;

public class C1014k {
    public static int m5223a(InputStream inputStream) {
        int read = inputStream.read();
        int i = read & 127;
        if ((read & 128) == 0) {
            return i;
        }
        read = inputStream.read();
        i |= (read & 127) << 7;
        if ((read & 128) == 0) {
            return i;
        }
        read = inputStream.read();
        i |= (read & 127) << 14;
        if ((read & 128) == 0) {
            return i;
        }
        read = inputStream.read();
        i |= (read & 127) << 21;
        return (read & 128) != 0 ? i | ((inputStream.read() & 127) << 28) : i;
    }

    public static long m5226b(InputStream inputStream) {
        int read = inputStream.read();
        long j = ((long) read) & 127;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 7;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 14;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 21;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 28;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 35;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 42;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 49;
        if ((read & 128) == 0) {
            return j;
        }
        read = inputStream.read();
        j |= (((long) read) & 127) << 56;
        return (read & 128) != 0 ? j | ((((long) inputStream.read()) & 127) << 63) : j;
    }

    public static void m5224a(OutputStream outputStream, int i) {
        while ((i & -128) != 0) {
            outputStream.write((i & 127) | 128);
            i >>>= 7;
        }
        outputStream.write(i);
    }

    public static void m5225a(OutputStream outputStream, long j) {
        while ((-128 & j) != 0) {
            outputStream.write((((int) j) & 127) | 128);
            j >>>= 7;
        }
        outputStream.write((int) j);
    }
}
