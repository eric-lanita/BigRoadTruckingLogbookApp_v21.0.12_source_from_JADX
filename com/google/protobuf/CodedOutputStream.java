package com.google.protobuf;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public final class CodedOutputStream {
    private final byte[] f13160a;
    private final int f13161b;
    private int f13162c;
    private final OutputStream f13163d;

    public static class OutOfSpaceException extends IOException {
        private static final long serialVersionUID = -6947486886997889499L;

        OutOfSpaceException() {
            super("CodedOutputStream was writing to a flat byte array and ran out of space.");
        }
    }

    static int m18984a(int i) {
        if (i > 4096) {
            return 4096;
        }
        return i;
    }

    private CodedOutputStream(byte[] bArr, int i, int i2) {
        this.f13163d = null;
        this.f13160a = bArr;
        this.f13162c = i;
        this.f13161b = i + i2;
    }

    private CodedOutputStream(OutputStream outputStream, byte[] bArr) {
        this.f13163d = outputStream;
        this.f13160a = bArr;
        this.f13162c = 0;
        this.f13161b = bArr.length;
    }

    public static CodedOutputStream m18985a(OutputStream outputStream, int i) {
        return new CodedOutputStream(outputStream, new byte[i]);
    }

    public static CodedOutputStream m18986a(byte[] bArr) {
        return m18987a(bArr, 0, bArr.length);
    }

    public static CodedOutputStream m18987a(byte[] bArr, int i, int i2) {
        return new CodedOutputStream(bArr, i, i2);
    }

    public void m19014a(int i, float f) {
        m19036i(i, 5);
        m19013a(f);
    }

    public void m19016a(int i, long j) {
        m19036i(i, 0);
        m19020a(j);
    }

    public void m19015a(int i, int i2) {
        m19036i(i, 0);
        m19026b(i2);
    }

    public void m19019a(int i, boolean z) {
        m19036i(i, 0);
        m19024a(z);
    }

    public void m19018a(int i, C2487l c2487l) {
        m19036i(i, 2);
        m19023a(c2487l);
    }

    public void m19017a(int i, C3642c c3642c) {
        m19036i(i, 2);
        m19021a(c3642c);
    }

    public void m19027b(int i, int i2) {
        m19036i(i, 0);
        m19029c(i2);
    }

    public void m19030c(int i, int i2) {
        m19036i(i, 5);
        m19033d(i2);
    }

    public void m19034d(int i, int i2) {
        m19036i(i, 0);
        m19035e(i2);
    }

    public void m19013a(float f) {
        m19039n(Float.floatToRawIntBits(f));
    }

    public void m19020a(long j) {
        m19031c(j);
    }

    public void m19026b(int i) {
        if (i >= 0) {
            m19038l(i);
        } else {
            m19031c((long) i);
        }
    }

    public void m19024a(boolean z) {
        m19037j(z ? 1 : 0);
    }

    public void m19023a(C2487l c2487l) {
        m19038l(c2487l.getSerializedSize());
        c2487l.writeTo(this);
    }

    public void m19021a(C3642c c3642c) {
        m19038l(c3642c.mo2752b());
        m19032c(c3642c);
    }

    public void m19029c(int i) {
        m19026b(i);
    }

    public void m19033d(int i) {
        m19039n(i);
    }

    public void m19035e(int i) {
        m19038l(m19010o(i));
    }

    public static int m18989b(int i, float f) {
        return m19008k(i) + m18988b(f);
    }

    public static int m18990b(int i, long j) {
        return m19008k(i) + m18994b(j);
    }

    public static int m19000e(int i, int i2) {
        return m19008k(i) + m19001f(i2);
    }

    public static int m18993b(int i, boolean z) {
        return m19008k(i) + m18997b(z);
    }

    public static int m18992b(int i, C2487l c2487l) {
        return m19008k(i) + m18996b(c2487l);
    }

    public static int m18991b(int i, C3642c c3642c) {
        return m19008k(i) + m18995b(c3642c);
    }

    public static int m19002f(int i, int i2) {
        return m19008k(i) + m19003g(i2);
    }

    public static int m19004g(int i, int i2) {
        return m19008k(i) + m19005h(i2);
    }

    public static int m19006h(int i, int i2) {
        return m19008k(i) + m19007i(i2);
    }

    public static int m18988b(float f) {
        return 4;
    }

    public static int m18994b(long j) {
        return m18998d(j);
    }

    public static int m19001f(int i) {
        if (i >= 0) {
            return m19009m(i);
        }
        return 10;
    }

    public static int m18997b(boolean z) {
        return 1;
    }

    public static int m18996b(C2487l c2487l) {
        int serializedSize = c2487l.getSerializedSize();
        return serializedSize + m19009m(serializedSize);
    }

    public static int m18995b(C3642c c3642c) {
        return m19009m(c3642c.mo2752b()) + c3642c.mo2752b();
    }

    public static int m19003g(int i) {
        return m19001f(i);
    }

    public static int m19005h(int i) {
        return 4;
    }

    public static int m19007i(int i) {
        return m19009m(m19010o(i));
    }

    private void m18999d() {
        if (this.f13163d == null) {
            throw new OutOfSpaceException();
        }
        this.f13163d.write(this.f13160a, 0, this.f13162c);
        this.f13162c = 0;
    }

    public void m19011a() {
        if (this.f13163d != null) {
            m18999d();
        }
    }

    public int m19025b() {
        if (this.f13163d == null) {
            return this.f13161b - this.f13162c;
        }
        throw new UnsupportedOperationException("spaceLeft() can only be called on CodedOutputStreams that are writing to a flat array.");
    }

    public void m19028c() {
        if (m19025b() != 0) {
            throw new IllegalStateException("Did not write as much data as expected.");
        }
    }

    public void m19012a(byte b) {
        if (this.f13162c == this.f13161b) {
            m18999d();
        }
        byte[] bArr = this.f13160a;
        int i = this.f13162c;
        this.f13162c = i + 1;
        bArr[i] = b;
    }

    public void m19037j(int i) {
        m19012a((byte) i);
    }

    public void m19032c(C3642c c3642c) {
        m19022a(c3642c, 0, c3642c.mo2752b());
    }

    public void m19022a(C3642c c3642c, int i, int i2) {
        if (this.f13161b - this.f13162c >= i2) {
            c3642c.m19085a(this.f13160a, i, this.f13162c, i2);
            this.f13162c += i2;
            return;
        }
        int i3 = this.f13161b - this.f13162c;
        c3642c.m19085a(this.f13160a, i, this.f13162c, i3);
        int i4 = i + i3;
        i3 = i2 - i3;
        this.f13162c = this.f13161b;
        m18999d();
        if (i3 <= this.f13161b) {
            c3642c.m19085a(this.f13160a, i4, 0, i3);
            this.f13162c = i3;
            return;
        }
        InputStream g = c3642c.mo2758g();
        if (((long) i4) != g.skip((long) i4)) {
            throw new IllegalStateException("Skip failed? Should never happen.");
        }
        while (i3 > 0) {
            i4 = Math.min(i3, this.f13161b);
            int read = g.read(this.f13160a, 0, i4);
            if (read != i4) {
                throw new IllegalStateException("Read failed? Should never happen");
            }
            this.f13163d.write(this.f13160a, 0, read);
            i3 -= read;
        }
    }

    public void m19036i(int i, int i2) {
        m19038l(WireFormat.m19072a(i, i2));
    }

    public static int m19008k(int i) {
        return m19009m(WireFormat.m19072a(i, 0));
    }

    public void m19038l(int i) {
        while ((i & -128) != 0) {
            m19037j((i & 127) | 128);
            i >>>= 7;
        }
        m19037j(i);
    }

    public static int m19009m(int i) {
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

    public void m19031c(long j) {
        while ((-128 & j) != 0) {
            m19037j((((int) j) & 127) | 128);
            j >>>= 7;
        }
        m19037j((int) j);
    }

    public static int m18998d(long j) {
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

    public void m19039n(int i) {
        m19037j(i & 255);
        m19037j((i >> 8) & 255);
        m19037j((i >> 16) & 255);
        m19037j((i >> 24) & 255);
    }

    public static int m19010o(int i) {
        return (i << 1) ^ (i >> 31);
    }
}
