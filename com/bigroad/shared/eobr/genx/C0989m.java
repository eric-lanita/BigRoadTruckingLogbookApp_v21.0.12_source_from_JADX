package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.am;
import com.google.common.base.Charsets;
import java.io.ByteArrayOutputStream;

public class C0989m extends C0975o {
    private String f3107a;

    private C0989m(int i, String str) {
        super(i);
        this.f3107a = str;
    }

    public static C0989m m5076a(int i, byte[] bArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i2 = 0;
        while (bArr.length > 0 && bArr[i2] != (byte) 0) {
            int i3 = i2 + 1;
            byteArrayOutputStream.write(bArr[i2]);
            i2 = i3;
        }
        return new C0989m(i, new String(byteArrayOutputStream.toByteArray(), Charsets.UTF_8));
    }

    public String toString() {
        return "NAK(" + m4990v() + "):  " + am.m4191b(this.f3107a);
    }

    public boolean mo744f() {
        return false;
    }

    public String mo745g() {
        return toString();
    }
}
