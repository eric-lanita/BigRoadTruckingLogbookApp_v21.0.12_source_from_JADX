package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.C1098j;
import com.bigroad.shared.eobr.C0998i;
import java.io.IOException;
import java.io.InputStream;

public class C1006g {
    public static C1098j m5172a(InputStream inputStream) {
        byte[] bArr = new byte[4];
        inputStream.read(bArr);
        long a = C0998i.m5109a(bArr, 0);
        if (a == 4278320898L || a == 4278386435L) {
            inputStream.skip(64);
            inputStream.skip(16);
            inputStream.skip(4);
            bArr = new byte[2];
            inputStream.read(bArr);
            int b = C0998i.m5111b(bArr, 0);
            int read = inputStream.read();
            int read2 = inputStream.read();
            return new C1098j(b, read2, read);
        }
        throw new IOException("Invalid app header");
    }

    public static C1098j m5171a(int i, int i2) {
        int i3 = (i2 >> 8) & 255;
        int i4 = i2 & 255;
        return new C1098j(i, i3, i4);
    }
}
