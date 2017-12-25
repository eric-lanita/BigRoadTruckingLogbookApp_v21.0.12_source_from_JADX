package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.turbo.C1015l;
import java.util.Arrays;

public abstract class C0976j extends C0975o implements C0971c {
    private final long f3060a;
    private final byte[] f3061b;

    public abstract boolean mo750h();

    protected C0976j(int i, long j, byte[] bArr) {
        super(i);
        this.f3060a = j;
        this.f3061b = bArr;
    }

    public static C1015l m4991a(long j) {
        return new C1015l(1, (int) j);
    }

    public C1015l mo747c() {
        return C0976j.m4991a(m4995t());
    }

    public long m4995t() {
        return this.f3060a;
    }

    public byte[] m4996u() {
        if (this.f3061b == null) {
            return null;
        }
        return Arrays.copyOf(this.f3061b, this.f3061b.length);
    }

    public boolean mo746a() {
        return false;
    }
}
