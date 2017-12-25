package com.google.protobuf;

import com.google.protobuf.C3642c.C3640a;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Iterator;
import java.util.NoSuchElementException;

class C3654k extends C3642c {
    protected final byte[] f13243c;
    private int f13244d = 0;

    private class C3653a implements C3640a {
        final /* synthetic */ C3654k f13240a;
        private int f13241b;
        private final int f13242c;

        public /* synthetic */ Object next() {
            return m19165b();
        }

        private C3653a(C3654k c3654k) {
            this.f13240a = c3654k;
            this.f13241b = 0;
            this.f13242c = c3654k.mo2752b();
        }

        public boolean hasNext() {
            return this.f13241b < this.f13242c;
        }

        public Byte m19165b() {
            return Byte.valueOf(mo2748a());
        }

        public byte mo2748a() {
            try {
                byte[] bArr = this.f13240a.f13243c;
                int i = this.f13241b;
                this.f13241b = i + 1;
                return bArr[i];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchElementException(e.getMessage());
            }
        }

        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public /* synthetic */ Iterator iterator() {
        return mo2751a();
    }

    C3654k(byte[] bArr) {
        this.f13243c = bArr;
    }

    public byte mo2749a(int i) {
        return this.f13243c[i];
    }

    public int mo2752b() {
        return this.f13243c.length;
    }

    protected void mo2755b(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.f13243c, i, bArr, i2, i3);
    }

    public String mo2754b(String str) {
        return new String(this.f13243c, m19180l(), mo2752b(), str);
    }

    public boolean mo2757f() {
        int l = m19180l();
        return C3672r.m19252a(this.f13243c, l, mo2752b() + l);
    }

    protected int mo2750a(int i, int i2, int i3) {
        int l = m19180l() + i2;
        return C3672r.m19251a(i, this.f13243c, l, l + i3);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C3642c)) {
            return false;
        }
        if (mo2752b() != ((C3642c) obj).mo2752b()) {
            return false;
        }
        if (mo2752b() == 0) {
            return true;
        }
        if (obj instanceof C3654k) {
            return m19169a((C3654k) obj, 0, mo2752b());
        }
        if (obj instanceof C3660o) {
            return obj.equals(this);
        }
        throw new IllegalArgumentException("Has a new type of ByteString been created? Found " + obj.getClass());
    }

    boolean m19169a(C3654k c3654k, int i, int i2) {
        if (i2 > c3654k.mo2752b()) {
            throw new IllegalArgumentException("Length too large: " + i2 + mo2752b());
        } else if (i + i2 > c3654k.mo2752b()) {
            throw new IllegalArgumentException("Ran off end of other: " + i + ", " + i2 + ", " + c3654k.mo2752b());
        } else {
            byte[] bArr = this.f13243c;
            byte[] bArr2 = c3654k.f13243c;
            int l = m19180l() + i2;
            int l2 = m19180l();
            int l3 = c3654k.m19180l() + i;
            while (l2 < l) {
                if (bArr[l2] != bArr2[l3]) {
                    return false;
                }
                l2++;
                l3++;
            }
            return true;
        }
    }

    public int hashCode() {
        int i = this.f13244d;
        if (i == 0) {
            i = mo2752b();
            i = mo2753b(i, 0, i);
            if (i == 0) {
                i = 1;
            }
            this.f13244d = i;
        }
        return i;
    }

    protected int mo2763k() {
        return this.f13244d;
    }

    protected int mo2753b(int i, int i2, int i3) {
        byte[] bArr = this.f13243c;
        int l = m19180l() + i2;
        int i4 = l + i3;
        while (l < i4) {
            i = (i * 31) + bArr[l];
            l++;
        }
        return i;
    }

    public InputStream mo2758g() {
        return new ByteArrayInputStream(this.f13243c, m19180l(), mo2752b());
    }

    public C3643d mo2759h() {
        return C3643d.m19102a(this.f13243c, m19180l(), mo2752b());
    }

    public C3640a mo2751a() {
        return new C3653a();
    }

    protected int mo2760i() {
        return 0;
    }

    protected boolean mo2762j() {
        return true;
    }

    protected int m19180l() {
        return 0;
    }
}
