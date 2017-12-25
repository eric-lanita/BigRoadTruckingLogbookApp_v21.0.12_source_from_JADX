package com.google.protobuf;

import com.google.protobuf.C3642c.C3640a;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Stack;

class C3660o extends C3642c {
    private static final int[] f13259c;
    private final int f13260d;
    private final C3642c f13261e;
    private final C3642c f13262f;
    private final int f13263g;
    private final int f13264h;
    private int f13265i;

    private static class C3656a {
        private final Stack<C3642c> f13245a;

        private C3656a() {
            this.f13245a = new Stack();
        }

        private C3642c m19182a(C3642c c3642c, C3642c c3642c2) {
            m19184a(c3642c);
            m19184a(c3642c2);
            C3642c c3642c3 = (C3642c) this.f13245a.pop();
            while (!this.f13245a.isEmpty()) {
                c3642c3 = new C3660o((C3642c) this.f13245a.pop(), c3642c3);
            }
            return c3642c3;
        }

        private void m19184a(C3642c c3642c) {
            if (c3642c.mo2762j()) {
                m19185b(c3642c);
            } else if (c3642c instanceof C3660o) {
                C3660o c3660o = (C3660o) c3642c;
                m19184a(c3660o.f13261e);
                m19184a(c3660o.f13262f);
            } else {
                throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + c3642c.getClass());
            }
        }

        private void m19185b(C3642c c3642c) {
            int a = m19181a(c3642c.mo2752b());
            int i = C3660o.f13259c[a + 1];
            if (this.f13245a.isEmpty() || ((C3642c) this.f13245a.peek()).mo2752b() >= i) {
                this.f13245a.push(c3642c);
                return;
            }
            int i2 = C3660o.f13259c[a];
            C3642c c3642c2 = (C3642c) this.f13245a.pop();
            while (!this.f13245a.isEmpty() && ((C3642c) this.f13245a.peek()).mo2752b() < i2) {
                c3642c2 = new C3660o((C3642c) this.f13245a.pop(), c3642c2);
            }
            c3642c2 = new C3660o(c3642c2, c3642c);
            while (!this.f13245a.isEmpty()) {
                if (((C3642c) this.f13245a.peek()).mo2752b() >= C3660o.f13259c[m19181a(c3642c2.mo2752b()) + 1]) {
                    break;
                }
                c3642c2 = new C3660o((C3642c) this.f13245a.pop(), c3642c2);
            }
            this.f13245a.push(c3642c2);
        }

        private int m19181a(int i) {
            int binarySearch = Arrays.binarySearch(C3660o.f13259c, i);
            if (binarySearch < 0) {
                return (-(binarySearch + 1)) - 1;
            }
            return binarySearch;
        }
    }

    private static class C3657b implements Iterator<C3654k> {
        private final Stack<C3660o> f13246a;
        private C3654k f13247b;

        public /* synthetic */ Object next() {
            return m19188a();
        }

        private C3657b(C3642c c3642c) {
            this.f13246a = new Stack();
            this.f13247b = m19186a(c3642c);
        }

        private C3654k m19186a(C3642c c3642c) {
            C3642c c3642c2 = c3642c;
            while (c3642c2 instanceof C3660o) {
                C3660o c3660o = (C3660o) c3642c2;
                this.f13246a.push(c3660o);
                c3642c2 = c3660o.f13261e;
            }
            return (C3654k) c3642c2;
        }

        private C3654k m19187b() {
            while (!this.f13246a.isEmpty()) {
                C3654k a = m19186a(((C3660o) this.f13246a.pop()).f13262f);
                if (!a.m19090c()) {
                    return a;
                }
            }
            return null;
        }

        public boolean hasNext() {
            return this.f13247b != null;
        }

        public C3654k m19188a() {
            if (this.f13247b == null) {
                throw new NoSuchElementException();
            }
            C3654k c3654k = this.f13247b;
            this.f13247b = m19187b();
            return c3654k;
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class C3658c implements C3640a {
        int f13248a;
        final /* synthetic */ C3660o f13249b;
        private final C3657b f13250c;
        private C3640a f13251d;

        public /* synthetic */ Object next() {
            return m19190b();
        }

        private C3658c(C3660o c3660o) {
            this.f13249b = c3660o;
            this.f13250c = new C3657b(c3660o);
            this.f13251d = this.f13250c.m19188a().mo2751a();
            this.f13248a = c3660o.mo2752b();
        }

        public boolean hasNext() {
            return this.f13248a > 0;
        }

        public Byte m19190b() {
            return Byte.valueOf(mo2748a());
        }

        public byte mo2748a() {
            if (!this.f13251d.hasNext()) {
                this.f13251d = this.f13250c.m19188a().mo2751a();
            }
            this.f13248a--;
            return this.f13251d.mo2748a();
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    private class C3659d extends InputStream {
        final /* synthetic */ C3660o f13252a;
        private C3657b f13253b;
        private C3654k f13254c;
        private int f13255d;
        private int f13256e;
        private int f13257f;
        private int f13258g;

        public C3659d(C3660o c3660o) {
            this.f13252a = c3660o;
            m19192a();
        }

        public int read(byte[] bArr, int i, int i2) {
            if (bArr == null) {
                throw new NullPointerException();
            } else if (i >= 0 && i2 >= 0 && i2 <= bArr.length - i) {
                return m19191a(bArr, i, i2);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public long skip(long j) {
            if (j < 0) {
                throw new IndexOutOfBoundsException();
            }
            if (j > 2147483647L) {
                j = 2147483647L;
            }
            return (long) m19191a(null, 0, (int) j);
        }

        private int m19191a(byte[] bArr, int i, int i2) {
            int i3 = i2;
            int i4 = i;
            while (i3 > 0) {
                m19193b();
                if (this.f13254c == null) {
                    if (i3 == i2) {
                        return -1;
                    }
                    return i2 - i3;
                }
                int min = Math.min(this.f13255d - this.f13256e, i3);
                if (bArr != null) {
                    this.f13254c.m19085a(bArr, this.f13256e, i4, min);
                    i4 += min;
                }
                this.f13256e += min;
                i3 -= min;
            }
            return i2 - i3;
        }

        public int read() {
            m19193b();
            if (this.f13254c == null) {
                return -1;
            }
            C3654k c3654k = this.f13254c;
            int i = this.f13256e;
            this.f13256e = i + 1;
            return c3654k.mo2749a(i) & 255;
        }

        public int available() {
            return this.f13252a.mo2752b() - (this.f13257f + this.f13256e);
        }

        public boolean markSupported() {
            return true;
        }

        public void mark(int i) {
            this.f13258g = this.f13257f + this.f13256e;
        }

        public synchronized void reset() {
            m19192a();
            m19191a(null, 0, this.f13258g);
        }

        private void m19192a() {
            this.f13253b = new C3657b(this.f13252a);
            this.f13254c = this.f13253b.m19188a();
            this.f13255d = this.f13254c.mo2752b();
            this.f13256e = 0;
            this.f13257f = 0;
        }

        private void m19193b() {
            if (this.f13254c != null && this.f13256e == this.f13255d) {
                this.f13257f += this.f13255d;
                this.f13256e = 0;
                if (this.f13253b.hasNext()) {
                    this.f13254c = this.f13253b.m19188a();
                    this.f13255d = this.f13254c.mo2752b();
                    return;
                }
                this.f13254c = null;
                this.f13255d = 0;
            }
        }
    }

    public /* synthetic */ Iterator iterator() {
        return mo2751a();
    }

    static {
        int i = 1;
        List arrayList = new ArrayList();
        int i2 = 1;
        while (i > 0) {
            arrayList.add(Integer.valueOf(i));
            int i3 = i2 + i;
            i2 = i;
            i = i3;
        }
        arrayList.add(Integer.valueOf(Integer.MAX_VALUE));
        f13259c = new int[arrayList.size()];
        for (i2 = 0; i2 < f13259c.length; i2++) {
            f13259c[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
    }

    private C3660o(C3642c c3642c, C3642c c3642c2) {
        this.f13265i = 0;
        this.f13261e = c3642c;
        this.f13262f = c3642c2;
        this.f13263g = c3642c.mo2752b();
        this.f13260d = this.f13263g + c3642c2.mo2752b();
        this.f13264h = Math.max(c3642c.mo2760i(), c3642c2.mo2760i()) + 1;
    }

    static C3642c m19194a(C3642c c3642c, C3642c c3642c2) {
        C3660o c3660o = c3642c instanceof C3660o ? (C3660o) c3642c : null;
        if (c3642c2.mo2752b() == 0) {
            return c3642c;
        }
        if (c3642c.mo2752b() == 0) {
            return c3642c2;
        }
        int b = c3642c.mo2752b() + c3642c2.mo2752b();
        if (b < 128) {
            return C3660o.m19197b(c3642c, c3642c2);
        }
        if (c3660o != null && c3660o.f13262f.mo2752b() + c3642c2.mo2752b() < 128) {
            return new C3660o(c3660o.f13261e, C3660o.m19197b(c3660o.f13262f, c3642c2));
        } else if (c3660o == null || c3660o.f13261e.mo2760i() <= c3660o.f13262f.mo2760i() || c3660o.mo2760i() <= c3642c2.mo2760i()) {
            if (b >= f13259c[Math.max(c3642c.mo2760i(), c3642c2.mo2760i()) + 1]) {
                return new C3660o(c3642c, c3642c2);
            }
            return new C3656a().m19182a(c3642c, c3642c2);
        } else {
            return new C3660o(c3660o.f13261e, new C3660o(c3660o.f13262f, c3642c2));
        }
    }

    private static C3654k m19197b(C3642c c3642c, C3642c c3642c2) {
        int b = c3642c.mo2752b();
        int b2 = c3642c2.mo2752b();
        byte[] bArr = new byte[(b + b2)];
        c3642c.m19085a(bArr, 0, 0, b);
        c3642c2.m19085a(bArr, 0, b, b2);
        return new C3654k(bArr);
    }

    public byte mo2749a(int i) {
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Index < 0: " + i);
        } else if (i > this.f13260d) {
            throw new ArrayIndexOutOfBoundsException("Index > length: " + i + ", " + this.f13260d);
        } else if (i < this.f13263g) {
            return this.f13261e.mo2749a(i);
        } else {
            return this.f13262f.mo2749a(i - this.f13263g);
        }
    }

    public int mo2752b() {
        return this.f13260d;
    }

    protected int mo2760i() {
        return this.f13264h;
    }

    protected boolean mo2762j() {
        return this.f13260d >= f13259c[this.f13264h];
    }

    protected void mo2755b(byte[] bArr, int i, int i2, int i3) {
        if (i + i3 <= this.f13263g) {
            this.f13261e.mo2755b(bArr, i, i2, i3);
        } else if (i >= this.f13263g) {
            this.f13262f.mo2755b(bArr, i - this.f13263g, i2, i3);
        } else {
            int i4 = this.f13263g - i;
            this.f13261e.mo2755b(bArr, i, i2, i4);
            this.f13262f.mo2755b(bArr, 0, i2 + i4, i3 - i4);
        }
    }

    public String mo2754b(String str) {
        return new String(m19091d(), str);
    }

    public boolean mo2757f() {
        if (this.f13262f.mo2750a(this.f13261e.mo2750a(0, 0, this.f13263g), 0, this.f13262f.mo2752b()) == 0) {
            return true;
        }
        return false;
    }

    protected int mo2750a(int i, int i2, int i3) {
        if (i2 + i3 <= this.f13263g) {
            return this.f13261e.mo2750a(i, i2, i3);
        }
        if (i2 >= this.f13263g) {
            return this.f13262f.mo2750a(i, i2 - this.f13263g, i3);
        }
        int i4 = this.f13263g - i2;
        return this.f13262f.mo2750a(this.f13261e.mo2750a(i, i2, i4), 0, i3 - i4);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3642c)) {
            return false;
        }
        C3642c c3642c = (C3642c) obj;
        if (this.f13260d != c3642c.mo2752b()) {
            return false;
        }
        if (this.f13260d == 0) {
            return true;
        }
        if (this.f13265i != 0) {
            int k = c3642c.mo2763k();
            if (!(k == 0 || this.f13265i == k)) {
                return false;
            }
        }
        return m19198b(c3642c);
    }

    private boolean m19198b(C3642c c3642c) {
        Iterator c3657b = new C3657b(this);
        C3654k c3654k = (C3654k) c3657b.next();
        Iterator c3657b2 = new C3657b(c3642c);
        C3654k c3654k2 = (C3654k) c3657b2.next();
        int i = 0;
        C3654k c3654k3 = c3654k;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int b = c3654k3.mo2752b() - i2;
            int b2 = c3654k2.mo2752b() - i;
            int min = Math.min(b, b2);
            if (!(i2 == 0 ? c3654k3.m19169a(c3654k2, i, min) : c3654k2.m19169a(c3654k3, i2, min))) {
                return false;
            }
            int i4 = i3 + min;
            if (i4 >= this.f13260d) {
                break;
            }
            boolean z;
            if (min == b) {
                c3654k3 = (C3654k) c3657b.next();
                i2 = 0;
            } else {
                i2 += min;
            }
            if (min == b2) {
                c3654k = (C3654k) c3657b2.next();
                z = false;
            } else {
                C3654k c3654k4 = c3654k2;
                z = i + min;
                c3654k = c3654k4;
            }
            boolean z2 = z;
            c3654k2 = c3654k;
            i3 = i4;
        }
        if (i4 == this.f13260d) {
            return true;
        }
        throw new IllegalStateException();
    }

    public int hashCode() {
        int i = this.f13265i;
        if (i == 0) {
            i = mo2753b(this.f13260d, 0, this.f13260d);
            if (i == 0) {
                i = 1;
            }
            this.f13265i = i;
        }
        return i;
    }

    protected int mo2763k() {
        return this.f13265i;
    }

    protected int mo2753b(int i, int i2, int i3) {
        if (i2 + i3 <= this.f13263g) {
            return this.f13261e.mo2753b(i, i2, i3);
        }
        if (i2 >= this.f13263g) {
            return this.f13262f.mo2753b(i, i2 - this.f13263g, i3);
        }
        int i4 = this.f13263g - i2;
        return this.f13262f.mo2753b(this.f13261e.mo2753b(i, i2, i4), 0, i3 - i4);
    }

    public C3643d mo2759h() {
        return C3643d.m19101a(new C3659d(this));
    }

    public InputStream mo2758g() {
        return new C3659d(this);
    }

    public C3640a mo2751a() {
        return new C3658c();
    }
}
