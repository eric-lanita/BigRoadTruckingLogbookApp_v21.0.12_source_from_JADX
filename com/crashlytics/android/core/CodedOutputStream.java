package com.crashlytics.android.core;

import java.io.Flushable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

final class CodedOutputStream implements Flushable {
    private final byte[] f9894a;
    private final int f9895b;
    private int f9896c = 0;
    private final OutputStream f9897d;

    static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f9897d = outputStream;
        this.f9894a = bArr;
        this.f9895b = bArr.length;
    }

    public static CodedOutputStream m16122a(OutputStream outputStream) {
        return m16123a(outputStream, 4096);
    }

    public static CodedOutputStream m16123a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public void m16147a(int i, float f) {
        m16165g(i, 5);
        m16145a(f);
    }

    public void m16149a(int i, long j) {
        m16165g(i, 0);
        m16152a(j);
    }

    public void m16151a(int i, boolean z) {
        m16165g(i, 0);
        m16155a(z);
    }

    public void m16150a(int i, C2891b c2891b) {
        m16165g(i, 2);
        m16153a(c2891b);
    }

    public void m16148a(int i, int i2) {
        m16165g(i, 0);
        m16158b(i2);
    }

    public void m16159b(int i, int i2) {
        m16165g(i, 0);
        m16160c(i2);
    }

    public void m16161c(int i, int i2) {
        m16165g(i, 0);
        m16164d(i2);
    }

    public void m16145a(float f) {
        m16168m(Float.floatToRawIntBits(f));
    }

    public void m16152a(long j) {
        m16162c(j);
    }

    public void m16146a(int i) {
        if (i >= 0) {
            m16167k(i);
        } else {
            m16162c((long) i);
        }
    }

    public void m16155a(boolean z) {
        m16166i(z ? 1 : 0);
    }

    public void m16153a(C2891b c2891b) {
        m16167k(c2891b.m16254a());
        m16163c(c2891b);
    }

    public void m16158b(int i) {
        m16167k(i);
    }

    public void m16160c(int i) {
        m16146a(i);
    }

    public void m16164d(int i) {
        m16167k(m16143n(i));
    }

    public static int m16126b(int i, float f) {
        return m16141j(i) + m16125b(f);
    }

    public static int m16127b(int i, long j) {
        return m16141j(i) + m16130b(j);
    }

    public static int m16129b(int i, boolean z) {
        return m16141j(i) + m16132b(z);
    }

    public static int m16128b(int i, C2891b c2891b) {
        return m16141j(i) + m16131b(c2891b);
    }

    public static int m16133d(int i, int i2) {
        return m16141j(i) + m16137f(i2);
    }

    public static int m16136e(int i, int i2) {
        return m16141j(i) + m16139g(i2);
    }

    public static int m16138f(int i, int i2) {
        return m16141j(i) + m16140h(i2);
    }

    public static int m16125b(float f) {
        return 4;
    }

    public static int m16130b(long j) {
        return m16134d(j);
    }

    public static int m16135e(int i) {
        if (i >= 0) {
            return m16142l(i);
        }
        return 10;
    }

    public static int m16132b(boolean z) {
        return 1;
    }

    public static int m16131b(C2891b c2891b) {
        return m16142l(c2891b.m16254a()) + c2891b.m16254a();
    }

    public static int m16137f(int i) {
        return m16142l(i);
    }

    public static int m16139g(int i) {
        return m16135e(i);
    }

    public static int m16140h(int i) {
        return m16142l(m16143n(i));
    }

    private void m16124a() {
        if (this.f9897d == null) {
            throw new OutOfSpaceException();
        }
        this.f9897d.write(this.f9894a, 0, this.f9896c);
        this.f9896c = 0;
    }

    public void flush() {
        if (this.f9897d != null) {
            m16124a();
        }
    }

    public void m16144a(byte b) {
        if (this.f9896c == this.f9895b) {
            m16124a();
        }
        byte[] bArr = this.f9894a;
        int i = this.f9896c;
        this.f9896c = i + 1;
        bArr[i] = b;
    }

    public void m16166i(int i) {
        m16144a((byte) i);
    }

    public void m16163c(C2891b c2891b) {
        m16154a(c2891b, 0, c2891b.m16254a());
    }

    public void m16156a(byte[] bArr) {
        m16157a(bArr, 0, bArr.length);
    }

    public void m16157a(byte[] bArr, int i, int i2) {
        if (this.f9895b - this.f9896c >= i2) {
            System.arraycopy(bArr, i, this.f9894a, this.f9896c, i2);
            this.f9896c += i2;
            return;
        }
        int i3 = this.f9895b - this.f9896c;
        System.arraycopy(bArr, i, this.f9894a, this.f9896c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f9896c = this.f9895b;
        m16124a();
        if (i3 <= this.f9895b) {
            System.arraycopy(bArr, i4, this.f9894a, 0, i3);
            this.f9896c = i3;
            return;
        }
        this.f9897d.write(bArr, i4, i3);
    }

    public void m16154a(C2891b c2891b, int i, int i2) {
        if (this.f9895b - this.f9896c >= i2) {
            c2891b.m16255a(this.f9894a, i, this.f9896c, i2);
            this.f9896c += i2;
            return;
        }
        int i3 = this.f9895b - this.f9896c;
        c2891b.m16255a(this.f9894a, i, this.f9896c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f9896c = this.f9895b;
        m16124a();
        if (i3 <= this.f9895b) {
            c2891b.m16255a(this.f9894a, i4, 0, i3);
            this.f9896c = i3;
            return;
        }
        InputStream b = c2891b.m16256b();
        if (((long) i4) != b.skip((long) i4)) {
            throw new IllegalStateException("Skip failed.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f9895b);
            int read = b.read(this.f9894a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed.");
            }
            this.f9897d.write(this.f9894a, 0, read);
            i3 -= read;
        }
    }

    public void m16165g(int i, int i2) {
        m16167k(am.m16251a(i, i2));
    }

    public static int m16141j(int i) {
        return m16142l(am.m16251a(i, 0));
    }

    public void m16167k(int i) {
        while ((i & -128) != 0) {
            m16166i((i & 127) | 128);
            i >>>= 7;
        }
        m16166i(i);
    }

    public static int m16142l(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public void m16162c(long j) {
        while ((-128 & j) != 0) {
            m16166i((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m16166i((int) j);
    }

    public static int m16134d(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }

    public void m16168m(int i) {
        m16166i(i & 255);
        m16166i((i >> 8) & 255);
        m16166i((i >> 16) & 255);
        m16166i((i >> 24) & 255);
    }

    public static int m16143n(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
