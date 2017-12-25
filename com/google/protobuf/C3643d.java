package com.google.protobuf;

import com.google.protobuf.C2487l.C2482a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public final class C3643d {
    private final byte[] f13212a;
    private int f13213b;
    private int f13214c;
    private int f13215d;
    private final InputStream f13216e;
    private int f13217f;
    private int f13218g;
    private int f13219h;
    private int f13220i;
    private int f13221j;
    private int f13222k;

    public static C3643d m19101a(InputStream inputStream) {
        return new C3643d(inputStream);
    }

    public static C3643d m19102a(byte[] bArr, int i, int i2) {
        C3643d c3643d = new C3643d(bArr, i, i2);
        try {
            c3643d.m19115d(i2);
            return c3643d;
        } catch (Throwable e) {
            throw new IllegalArgumentException(e);
        }
    }

    public int m19106a() {
        if (m19138x()) {
            this.f13217f = 0;
            return 0;
        }
        this.f13217f = m19133s();
        if (WireFormat.m19073b(this.f13217f) != 0) {
            return this.f13217f;
        }
        throw InvalidProtocolBufferException.m19056e();
    }

    public void m19108a(int i) {
        if (this.f13217f != i) {
            throw InvalidProtocolBufferException.m19057f();
        }
    }

    public boolean m19112b(int i) {
        switch (WireFormat.m19071a(i)) {
            case 0:
                m19120g();
                return true;
            case 1:
                m19136v();
                return true;
            case 2:
                m19121g(m19133s());
                return true;
            case 3:
                m19111b();
                m19108a(WireFormat.m19072a(WireFormat.m19073b(i), 4));
                return true;
            case 4:
                return false;
            case 5:
                m19135u();
                return true;
            default:
                throw InvalidProtocolBufferException.m19058g();
        }
    }

    public void m19111b() {
        int a;
        do {
            a = m19106a();
            if (a == 0) {
                return;
            }
        } while (m19112b(a));
    }

    public double m19113c() {
        return Double.longBitsToDouble(m19136v());
    }

    public float m19114d() {
        return Float.intBitsToFloat(m19135u());
    }

    public long m19116e() {
        return m19134t();
    }

    public long m19118f() {
        return m19134t();
    }

    public int m19120g() {
        return m19133s();
    }

    public long m19122h() {
        return m19136v();
    }

    public int m19123i() {
        return m19135u();
    }

    public boolean m19124j() {
        return m19133s() != 0;
    }

    public String m19125k() {
        int s = m19133s();
        if (s > this.f13213b - this.f13215d || s <= 0) {
            return new String(m19119f(s), "UTF-8");
        }
        String str = new String(this.f13212a, this.f13215d, s, "UTF-8");
        this.f13215d = s + this.f13215d;
        return str;
    }

    public void m19109a(int i, C2482a c2482a, C3645e c3645e) {
        if (this.f13220i >= this.f13221j) {
            throw InvalidProtocolBufferException.m19059h();
        }
        this.f13220i++;
        c2482a.mo1360c(this, c3645e);
        m19108a(WireFormat.m19072a(i, 4));
        this.f13220i--;
    }

    public void m19110a(C2482a c2482a, C3645e c3645e) {
        int s = m19133s();
        if (this.f13220i >= this.f13221j) {
            throw InvalidProtocolBufferException.m19059h();
        }
        s = m19115d(s);
        this.f13220i++;
        c2482a.mo1360c(this, c3645e);
        m19108a(0);
        this.f13220i--;
        m19117e(s);
    }

    public <T extends C2487l> T m19107a(C2478n<T> c2478n, C3645e c3645e) {
        int s = m19133s();
        if (this.f13220i >= this.f13221j) {
            throw InvalidProtocolBufferException.m19059h();
        }
        int d = m19115d(s);
        this.f13220i++;
        C2487l c2487l = (C2487l) c2478n.mo1358b(this, c3645e);
        m19108a(0);
        this.f13220i--;
        m19117e(d);
        return c2487l;
    }

    public C3642c m19126l() {
        int s = m19133s();
        if (s == 0) {
            return C3642c.f13210a;
        }
        if (s > this.f13213b - this.f13215d || s <= 0) {
            return C3642c.m19078a(m19119f(s));
        }
        C3642c a = C3642c.m19079a(this.f13212a, this.f13215d, s);
        this.f13215d = s + this.f13215d;
        return a;
    }

    public int m19127m() {
        return m19133s();
    }

    public int m19128n() {
        return m19133s();
    }

    public int m19129o() {
        return m19135u();
    }

    public long m19130p() {
        return m19136v();
    }

    public int m19131q() {
        return C3643d.m19104c(m19133s());
    }

    public long m19132r() {
        return C3643d.m19100a(m19134t());
    }

    public int m19133s() {
        byte y = m19139y();
        if (y >= (byte) 0) {
            return y;
        }
        int i = y & 127;
        byte y2 = m19139y();
        if (y2 >= (byte) 0) {
            return i | (y2 << 7);
        }
        i |= (y2 & 127) << 7;
        y2 = m19139y();
        if (y2 >= (byte) 0) {
            return i | (y2 << 14);
        }
        i |= (y2 & 127) << 14;
        y2 = m19139y();
        if (y2 >= (byte) 0) {
            return i | (y2 << 21);
        }
        i |= (y2 & 127) << 21;
        y2 = m19139y();
        i |= y2 << 28;
        if (y2 >= (byte) 0) {
            return i;
        }
        for (int i2 = 0; i2 < 5; i2++) {
            if (m19139y() >= (byte) 0) {
                return i;
            }
        }
        throw InvalidProtocolBufferException.m19055d();
    }

    public static int m19099a(int i, InputStream inputStream) {
        if ((i & 128) != 0) {
            int read;
            i &= 127;
            int i2 = 7;
            while (i2 < 32) {
                read = inputStream.read();
                if (read != -1) {
                    i |= (read & 127) << i2;
                    if ((read & 128) == 0) {
                        break;
                    }
                    i2 += 7;
                } else {
                    throw InvalidProtocolBufferException.m19053b();
                }
            }
            while (i2 < 64) {
                read = inputStream.read();
                if (read == -1) {
                    throw InvalidProtocolBufferException.m19053b();
                } else if ((read & 128) != 0) {
                    i2 += 7;
                }
            }
            throw InvalidProtocolBufferException.m19055d();
        }
        return i;
    }

    public long m19134t() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte y = m19139y();
            j |= ((long) (y & 127)) << i;
            if ((y & 128) == 0) {
                return j;
            }
        }
        throw InvalidProtocolBufferException.m19055d();
    }

    public int m19135u() {
        return (((m19139y() & 255) | ((m19139y() & 255) << 8)) | ((m19139y() & 255) << 16)) | ((m19139y() & 255) << 24);
    }

    public long m19136v() {
        byte y = m19139y();
        byte y2 = m19139y();
        return ((((((((((long) y2) & 255) << 8) | (((long) y) & 255)) | ((((long) m19139y()) & 255) << 16)) | ((((long) m19139y()) & 255) << 24)) | ((((long) m19139y()) & 255) << 32)) | ((((long) m19139y()) & 255) << 40)) | ((((long) m19139y()) & 255) << 48)) | ((((long) m19139y()) & 255) << 56);
    }

    public static int m19104c(int i) {
        return (i >>> 1) ^ (-(i & 1));
    }

    public static long m19100a(long j) {
        return (j >>> 1) ^ (-(1 & j));
    }

    private C3643d(byte[] bArr, int i, int i2) {
        this.f13219h = Integer.MAX_VALUE;
        this.f13221j = 64;
        this.f13222k = 67108864;
        this.f13212a = bArr;
        this.f13213b = i + i2;
        this.f13215d = i;
        this.f13218g = -i;
        this.f13216e = null;
    }

    private C3643d(InputStream inputStream) {
        this.f13219h = Integer.MAX_VALUE;
        this.f13221j = 64;
        this.f13222k = 67108864;
        this.f13212a = new byte[4096];
        this.f13213b = 0;
        this.f13215d = 0;
        this.f13218g = 0;
        this.f13216e = inputStream;
    }

    public int m19115d(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.m19054c();
        }
        int i2 = (this.f13218g + this.f13215d) + i;
        int i3 = this.f13219h;
        if (i2 > i3) {
            throw InvalidProtocolBufferException.m19053b();
        }
        this.f13219h = i2;
        m19105z();
        return i3;
    }

    private void m19105z() {
        this.f13213b += this.f13214c;
        int i = this.f13218g + this.f13213b;
        if (i > this.f13219h) {
            this.f13214c = i - this.f13219h;
            this.f13213b -= this.f13214c;
            return;
        }
        this.f13214c = 0;
    }

    public void m19117e(int i) {
        this.f13219h = i;
        m19105z();
    }

    public int m19137w() {
        if (this.f13219h == Integer.MAX_VALUE) {
            return -1;
        }
        return this.f13219h - (this.f13218g + this.f13215d);
    }

    public boolean m19138x() {
        return this.f13215d == this.f13213b && !m19103a(false);
    }

    private boolean m19103a(boolean z) {
        if (this.f13215d < this.f13213b) {
            throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
        } else if (this.f13218g + this.f13213b != this.f13219h) {
            this.f13218g += this.f13213b;
            this.f13215d = 0;
            this.f13213b = this.f13216e == null ? -1 : this.f13216e.read(this.f13212a);
            if (this.f13213b == 0 || this.f13213b < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f13213b + "\nThe InputStream implementation is buggy.");
            } else if (this.f13213b == -1) {
                this.f13213b = 0;
                if (!z) {
                    return false;
                }
                throw InvalidProtocolBufferException.m19053b();
            } else {
                m19105z();
                int i = (this.f13218g + this.f13213b) + this.f13214c;
                if (i <= this.f13222k && i >= 0) {
                    return true;
                }
                throw InvalidProtocolBufferException.m19060i();
            }
        } else if (!z) {
            return false;
        } else {
            throw InvalidProtocolBufferException.m19053b();
        }
    }

    public byte m19139y() {
        if (this.f13215d == this.f13213b) {
            m19103a(true);
        }
        byte[] bArr = this.f13212a;
        int i = this.f13215d;
        this.f13215d = i + 1;
        return bArr[i];
    }

    public byte[] m19119f(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.m19054c();
        } else if ((this.f13218g + this.f13215d) + i > this.f13219h) {
            m19121g((this.f13219h - this.f13218g) - this.f13215d);
            throw InvalidProtocolBufferException.m19053b();
        } else if (i <= this.f13213b - this.f13215d) {
            Object obj = new byte[i];
            System.arraycopy(this.f13212a, this.f13215d, obj, 0, i);
            this.f13215d += i;
            return obj;
        } else if (i < 4096) {
            Object obj2 = new byte[i];
            r0 = this.f13213b - this.f13215d;
            System.arraycopy(this.f13212a, this.f13215d, obj2, 0, r0);
            this.f13215d = this.f13213b;
            m19103a(true);
            while (i - r0 > this.f13213b) {
                System.arraycopy(this.f13212a, 0, obj2, r0, this.f13213b);
                r0 += this.f13213b;
                this.f13215d = this.f13213b;
                m19103a(true);
            }
            System.arraycopy(this.f13212a, 0, obj2, r0, i - r0);
            this.f13215d = i - r0;
            return obj2;
        } else {
            int read;
            int i2 = this.f13215d;
            int i3 = this.f13213b;
            this.f13218g += this.f13213b;
            this.f13215d = 0;
            this.f13213b = 0;
            r0 = i - (i3 - i2);
            List<byte[]> arrayList = new ArrayList();
            int i4 = r0;
            while (i4 > 0) {
                Object obj3 = new byte[Math.min(i4, 4096)];
                r0 = 0;
                while (r0 < obj3.length) {
                    read = this.f13216e == null ? -1 : this.f13216e.read(obj3, r0, obj3.length - r0);
                    if (read == -1) {
                        throw InvalidProtocolBufferException.m19053b();
                    }
                    this.f13218g += read;
                    r0 += read;
                }
                r0 = i4 - obj3.length;
                arrayList.add(obj3);
                i4 = r0;
            }
            Object obj4 = new byte[i];
            r0 = i3 - i2;
            System.arraycopy(this.f13212a, i2, obj4, 0, r0);
            read = r0;
            for (byte[] bArr : arrayList) {
                System.arraycopy(bArr, 0, obj4, read, bArr.length);
                read = bArr.length + read;
            }
            return obj4;
        }
    }

    public void m19121g(int i) {
        if (i < 0) {
            throw InvalidProtocolBufferException.m19054c();
        } else if ((this.f13218g + this.f13215d) + i > this.f13219h) {
            m19121g((this.f13219h - this.f13218g) - this.f13215d);
            throw InvalidProtocolBufferException.m19053b();
        } else if (i <= this.f13213b - this.f13215d) {
            this.f13215d += i;
        } else {
            int i2 = this.f13213b - this.f13215d;
            this.f13215d = this.f13213b;
            m19103a(true);
            while (i - i2 > this.f13213b) {
                i2 += this.f13213b;
                this.f13215d = this.f13213b;
                m19103a(true);
            }
            this.f13215d = i - i2;
        }
    }
}
