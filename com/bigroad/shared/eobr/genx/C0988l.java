package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.C1180y;

public class C0988l extends C0975o {
    private final GenxDataType f3105a;
    private final byte[] f3106b;

    private C0988l(GenxDataType genxDataType, int i, byte[] bArr) {
        super(i);
        this.f3105a = genxDataType;
        this.f3106b = bArr;
    }

    public static C0988l m5074a(GenxDataType genxDataType, int i, byte[] bArr) {
        return new C0988l(genxDataType, i, bArr);
    }

    public byte[] m5075a() {
        return this.f3106b;
    }

    public String toString() {
        return "GenxGenericResponse SEQ:" + m4990v() + " ID:" + this.f3105a + " {" + C1180y.m5993b(m5075a()) + "}";
    }
}
