package com.google.protobuf;

import java.io.InputStream;
import java.util.Iterator;

public abstract class C3642c implements Iterable<Byte> {
    public static final C3642c f13210a = new C3654k(new byte[0]);
    static final /* synthetic */ boolean f13211b;

    public interface C3640a extends Iterator<Byte> {
        byte mo2748a();
    }

    static final class C3641b {
        private final CodedOutputStream f13208a;
        private final byte[] f13209b;

        private C3641b(int i) {
            this.f13209b = new byte[i];
            this.f13208a = CodedOutputStream.m18986a(this.f13209b);
        }

        public C3642c m19075a() {
            this.f13208a.m19028c();
            return new C3654k(this.f13209b);
        }

        public CodedOutputStream m19076b() {
            return this.f13208a;
        }
    }

    public abstract byte mo2749a(int i);

    protected abstract int mo2750a(int i, int i2, int i3);

    public abstract C3640a mo2751a();

    public abstract int mo2752b();

    protected abstract int mo2753b(int i, int i2, int i3);

    public abstract String mo2754b(String str);

    protected abstract void mo2755b(byte[] bArr, int i, int i2, int i3);

    public abstract boolean equals(Object obj);

    public abstract boolean mo2757f();

    public abstract InputStream mo2758g();

    public abstract C3643d mo2759h();

    protected abstract int mo2760i();

    protected abstract boolean mo2762j();

    protected abstract int mo2763k();

    static {
        boolean z;
        if (C3642c.class.desiredAssertionStatus()) {
            z = false;
        } else {
            z = true;
        }
        f13211b = z;
    }

    public /* synthetic */ Iterator iterator() {
        return mo2751a();
    }

    C3642c() {
    }

    public boolean m19090c() {
        return mo2752b() == 0;
    }

    public static C3642c m19079a(byte[] bArr, int i, int i2) {
        Object obj = new byte[i2];
        System.arraycopy(bArr, i, obj, 0, i2);
        return new C3654k(obj);
    }

    public static C3642c m19078a(byte[] bArr) {
        return C3642c.m19079a(bArr, 0, bArr.length);
    }

    public static C3642c m19077a(String str) {
        try {
            return new C3654k(str.getBytes("UTF-8"));
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    public C3642c m19084a(C3642c c3642c) {
        int b = mo2752b();
        int b2 = c3642c.mo2752b();
        if (((long) b) + ((long) b2) < 2147483647L) {
            return C3660o.m19194a(this, c3642c);
        }
        throw new IllegalArgumentException("ByteString would be too long: " + b + "+" + b2);
    }

    public void m19085a(byte[] bArr, int i, int i2, int i3) {
        if (i < 0) {
            throw new IndexOutOfBoundsException("Source offset < 0: " + i);
        } else if (i2 < 0) {
            throw new IndexOutOfBoundsException("Target offset < 0: " + i2);
        } else if (i3 < 0) {
            throw new IndexOutOfBoundsException("Length < 0: " + i3);
        } else if (i + i3 > mo2752b()) {
            throw new IndexOutOfBoundsException("Source end offset < 0: " + (i + i3));
        } else if (i2 + i3 > bArr.length) {
            throw new IndexOutOfBoundsException("Target end offset < 0: " + (i2 + i3));
        } else if (i3 > 0) {
            mo2755b(bArr, i, i2, i3);
        }
    }

    public byte[] m19091d() {
        int b = mo2752b();
        byte[] bArr = new byte[b];
        mo2755b(bArr, 0, 0, b);
        return bArr;
    }

    public String m19092e() {
        try {
            return mo2754b("UTF-8");
        } catch (Throwable e) {
            throw new RuntimeException("UTF-8 not supported?", e);
        }
    }

    static C3641b m19080b(int i) {
        return new C3641b(i);
    }

    public String toString() {
        return String.format("<ByteString@%s size=%d>", new Object[]{Integer.toHexString(System.identityHashCode(this)), Integer.valueOf(mo2752b())});
    }
}
