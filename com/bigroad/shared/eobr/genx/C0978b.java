package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.am;
import com.google.common.base.Charsets;
import java.io.ByteArrayOutputStream;

public class C0978b extends C0975o {
    private final byte[] f3084a;
    private String f3085b;

    protected C0978b(int i, String str, byte[] bArr) {
        super(i);
        this.f3085b = str;
        this.f3084a = bArr;
    }

    public static C0978b m5024a(int i, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (bArr.length > 0 && bArr[i2] != (byte) 0) {
            int i3 = i2 + 1;
            byteArrayOutputStream.write(bArr[i2]);
            i2 = i3;
        }
        return new C0978b(i, new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8), bArr);
    }

    public String m5025a() {
        return am.m4191b(this.f3085b);
    }

    public String toString() {
        return "ACK(" + m4990v() + "): " + m5025a();
    }

    public String mo745g() {
        return toString();
    }
}
