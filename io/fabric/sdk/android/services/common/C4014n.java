package io.fabric.sdk.android.services.common;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.NoSuchElementException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class C4014n implements Closeable {
    private static final Logger f14182b = Logger.getLogger(C4014n.class.getName());
    int f14183a;
    private final RandomAccessFile f14184c;
    private int f14185d;
    private C4012a f14186e;
    private C4012a f14187f;
    private final byte[] f14188g = new byte[16];

    public interface C2881c {
        void mo1454a(InputStream inputStream, int i);
    }

    static class C4012a {
        static final C4012a f14176a = new C4012a(0, 0);
        final int f14177b;
        final int f14178c;

        C4012a(int i, int i2) {
            this.f14177b = i;
            this.f14178c = i2;
        }

        public String toString() {
            return getClass().getSimpleName() + "[position = " + this.f14177b + ", length = " + this.f14178c + "]";
        }
    }

    private final class C4013b extends InputStream {
        final /* synthetic */ C4014n f14179a;
        private int f14180b;
        private int f14181c;

        private C4013b(C4014n c4014n, C4012a c4012a) {
            this.f14179a = c4014n;
            this.f14180b = c4014n.m20798b(c4012a.f14177b + 4);
            this.f14181c = c4012a.f14178c;
        }

        public int read(byte[] bArr, int i, int i2) {
            C4014n.m20800b(bArr, "buffer");
            if ((i | i2) < 0 || i2 > bArr.length - i) {
                throw new ArrayIndexOutOfBoundsException();
            } else if (this.f14181c <= 0) {
                return -1;
            } else {
                if (i2 > this.f14181c) {
                    i2 = this.f14181c;
                }
                this.f14179a.m20801b(this.f14180b, bArr, i, i2);
                this.f14180b = this.f14179a.m20798b(this.f14180b + i2);
                this.f14181c -= i2;
                return i2;
            }
        }

        public int read() {
            if (this.f14181c == 0) {
                return -1;
            }
            this.f14179a.f14184c.seek((long) this.f14180b);
            int read = this.f14179a.f14184c.read();
            this.f14180b = this.f14179a.m20798b(this.f14180b + 1);
            this.f14181c--;
            return read;
        }
    }

    public C4014n(File file) {
        if (!file.exists()) {
            C4014n.m20796a(file);
        }
        this.f14184c = C4014n.m20799b(file);
        m20805e();
    }

    private static void m20802b(byte[] bArr, int i, int i2) {
        bArr[i] = (byte) (i2 >> 24);
        bArr[i + 1] = (byte) (i2 >> 16);
        bArr[i + 2] = (byte) (i2 >> 8);
        bArr[i + 3] = (byte) i2;
    }

    private static void m20797a(byte[] bArr, int... iArr) {
        int i = 0;
        int length = iArr.length;
        int i2 = 0;
        while (i < length) {
            C4014n.m20802b(bArr, i2, iArr[i]);
            i2 += 4;
            i++;
        }
    }

    private static int m20789a(byte[] bArr, int i) {
        return ((((bArr[i] & 255) << 24) + ((bArr[i + 1] & 255) << 16)) + ((bArr[i + 2] & 255) << 8)) + (bArr[i + 3] & 255);
    }

    private void m20805e() {
        this.f14184c.seek(0);
        this.f14184c.readFully(this.f14188g);
        this.f14183a = C4014n.m20789a(this.f14188g, 0);
        if (((long) this.f14183a) > this.f14184c.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f14183a + ", Actual length: " + this.f14184c.length());
        }
        this.f14185d = C4014n.m20789a(this.f14188g, 4);
        int a = C4014n.m20789a(this.f14188g, 8);
        int a2 = C4014n.m20789a(this.f14188g, 12);
        this.f14186e = m20790a(a);
        this.f14187f = m20790a(a2);
    }

    private void m20793a(int i, int i2, int i3, int i4) {
        C4014n.m20797a(this.f14188g, i, i2, i3, i4);
        this.f14184c.seek(0);
        this.f14184c.write(this.f14188g);
    }

    private C4012a m20790a(int i) {
        if (i == 0) {
            return C4012a.f14176a;
        }
        this.f14184c.seek((long) i);
        return new C4012a(i, this.f14184c.readInt());
    }

    private static void m20796a(File file) {
        File file2 = new File(file.getPath() + ".tmp");
        RandomAccessFile b = C4014n.m20799b(file2);
        try {
            b.setLength(4096);
            b.seek(0);
            byte[] bArr = new byte[16];
            C4014n.m20797a(bArr, 4096, 0, 0, 0);
            b.write(bArr);
            if (!file2.renameTo(file)) {
                throw new IOException("Rename failed!");
            }
        } finally {
            b.close();
        }
    }

    private static RandomAccessFile m20799b(File file) {
        return new RandomAccessFile(file, "rwd");
    }

    private int m20798b(int i) {
        return i < this.f14183a ? i : (i + 16) - this.f14183a;
    }

    private void m20794a(int i, byte[] bArr, int i2, int i3) {
        int b = m20798b(i);
        if (b + i3 <= this.f14183a) {
            this.f14184c.seek((long) b);
            this.f14184c.write(bArr, i2, i3);
            return;
        }
        int i4 = this.f14183a - b;
        this.f14184c.seek((long) b);
        this.f14184c.write(bArr, i2, i4);
        this.f14184c.seek(16);
        this.f14184c.write(bArr, i2 + i4, i3 - i4);
    }

    private void m20801b(int i, byte[] bArr, int i2, int i3) {
        int b = m20798b(i);
        if (b + i3 <= this.f14183a) {
            this.f14184c.seek((long) b);
            this.f14184c.readFully(bArr, i2, i3);
            return;
        }
        int i4 = this.f14183a - b;
        this.f14184c.seek((long) b);
        this.f14184c.readFully(bArr, i2, i4);
        this.f14184c.seek(16);
        this.f14184c.readFully(bArr, i2 + i4, i3 - i4);
    }

    public void m20809a(byte[] bArr) {
        m20810a(bArr, 0, bArr.length);
    }

    public synchronized void m20810a(byte[] bArr, int i, int i2) {
        C4014n.m20800b(bArr, "buffer");
        if ((i | i2) < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        }
        int i3;
        m20803c(i2);
        boolean b = m20812b();
        if (b) {
            i3 = 16;
        } else {
            i3 = m20798b((this.f14187f.f14177b + 4) + this.f14187f.f14178c);
        }
        C4012a c4012a = new C4012a(i3, i2);
        C4014n.m20802b(this.f14188g, 0, i2);
        m20794a(c4012a.f14177b, this.f14188g, 0, 4);
        m20794a(c4012a.f14177b + 4, bArr, i, i2);
        m20793a(this.f14183a, this.f14185d + 1, b ? c4012a.f14177b : this.f14186e.f14177b, c4012a.f14177b);
        this.f14187f = c4012a;
        this.f14185d++;
        if (b) {
            this.f14186e = this.f14187f;
        }
    }

    public int m20807a() {
        if (this.f14185d == 0) {
            return 16;
        }
        if (this.f14187f.f14177b >= this.f14186e.f14177b) {
            return (((this.f14187f.f14177b - this.f14186e.f14177b) + 4) + this.f14187f.f14178c) + 16;
        }
        return (((this.f14187f.f14177b + 4) + this.f14187f.f14178c) + this.f14183a) - this.f14186e.f14177b;
    }

    private int m20806f() {
        return this.f14183a - m20807a();
    }

    public synchronized boolean m20812b() {
        return this.f14185d == 0;
    }

    private void m20803c(int i) {
        int i2 = i + 4;
        int f = m20806f();
        if (f < i2) {
            int i3 = this.f14183a;
            do {
                f += i3;
                i3 <<= 1;
            } while (f < i2);
            m20804d(i3);
            i2 = m20798b((this.f14187f.f14177b + 4) + this.f14187f.f14178c);
            if (i2 < this.f14186e.f14177b) {
                FileChannel channel = this.f14184c.getChannel();
                channel.position((long) this.f14183a);
                int i4 = i2 - 4;
                if (channel.transferTo(16, (long) i4, channel) != ((long) i4)) {
                    throw new AssertionError("Copied insufficient number of bytes!");
                }
            }
            if (this.f14187f.f14177b < this.f14186e.f14177b) {
                f = (this.f14183a + this.f14187f.f14177b) - 16;
                m20793a(i3, this.f14185d, this.f14186e.f14177b, f);
                this.f14187f = new C4012a(f, this.f14187f.f14178c);
            } else {
                m20793a(i3, this.f14185d, this.f14186e.f14177b, this.f14187f.f14177b);
            }
            this.f14183a = i3;
        }
    }

    private void m20804d(int i) {
        this.f14184c.setLength((long) i);
        this.f14184c.getChannel().force(true);
    }

    public synchronized void m20808a(C2881c c2881c) {
        int i = this.f14186e.f14177b;
        for (int i2 = 0; i2 < this.f14185d; i2++) {
            C4012a a = m20790a(i);
            c2881c.mo1454a(new C4013b(a), a.f14178c);
            i = m20798b(a.f14178c + (a.f14177b + 4));
        }
    }

    private static <T> T m20800b(T t, String str) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(str);
    }

    public synchronized void m20813c() {
        if (m20812b()) {
            throw new NoSuchElementException();
        } else if (this.f14185d == 1) {
            m20814d();
        } else {
            int b = m20798b((this.f14186e.f14177b + 4) + this.f14186e.f14178c);
            m20801b(b, this.f14188g, 0, 4);
            int a = C4014n.m20789a(this.f14188g, 0);
            m20793a(this.f14183a, this.f14185d - 1, b, this.f14187f.f14177b);
            this.f14185d--;
            this.f14186e = new C4012a(b, a);
        }
    }

    public synchronized void m20814d() {
        m20793a(4096, 0, 0, 0);
        this.f14185d = 0;
        this.f14186e = C4012a.f14176a;
        this.f14187f = C4012a.f14176a;
        if (this.f14183a > 4096) {
            m20804d(4096);
        }
        this.f14183a = 4096;
    }

    public synchronized void close() {
        this.f14184c.close();
    }

    public boolean m20811a(int i, int i2) {
        return (m20807a() + 4) + i <= i2;
    }

    public String toString() {
        final StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(getClass().getSimpleName()).append('[');
        stringBuilder.append("fileLength=").append(this.f14183a);
        stringBuilder.append(", size=").append(this.f14185d);
        stringBuilder.append(", first=").append(this.f14186e);
        stringBuilder.append(", last=").append(this.f14187f);
        stringBuilder.append(", element lengths=[");
        try {
            m20808a(new C2881c(this) {
                boolean f14173a = true;
                final /* synthetic */ C4014n f14175c;

                public void mo1454a(InputStream inputStream, int i) {
                    if (this.f14173a) {
                        this.f14173a = false;
                    } else {
                        stringBuilder.append(", ");
                    }
                    stringBuilder.append(i);
                }
            });
        } catch (Throwable e) {
            f14182b.log(Level.WARNING, "read error", e);
        }
        stringBuilder.append("]]");
        return stringBuilder.toString();
    }
}
