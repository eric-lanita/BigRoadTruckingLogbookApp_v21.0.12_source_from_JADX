package com.bigroad.shared.eobr.genx;

import com.google.common.base.Charsets;

public class C0983f extends C0975o {
    private final String f3092a;
    private final byte[] f3093b;

    private C0983f(int i, byte[] bArr) {
        super(i);
        this.f3093b = bArr;
        String str = (bArr == null || bArr.length == 0) ? "" : new String(bArr, Charsets.UTF_8);
        this.f3092a = str;
    }

    public static C0983f m5040a(int i, byte[] bArr) {
        return new C0983f(i, bArr);
    }

    public String m5041a() {
        return this.f3092a;
    }

    public byte[] m5042b() {
        return this.f3093b;
    }

    public String toString() {
        return "GenxAtResponse{\"" + m5041a() + "\"}";
    }
}
