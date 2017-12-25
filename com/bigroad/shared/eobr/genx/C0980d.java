package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.am;
import com.google.common.base.Ascii;
import java.io.EOFException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public class C0980d {
    public static final byte[] f3088a = new byte[]{Ascii.CR, (byte) 10};
    private final InputStream f3089b;

    public C0980d(InputStream inputStream) {
        this.f3089b = inputStream;
    }

    private byte m5030b() {
        int read = this.f3089b.read();
        if (read >= 0) {
            return (byte) read;
        }
        throw new EOFException("End of file");
    }

    private C0979c m5029a(byte[] bArr, int i, int i2) {
        if (bArr == null || i <= i2 || i2 == 0) {
            return null;
        }
        return new C0979c(new String(bArr, 0, i2 - 1), new String(bArr, i2, i - i2));
    }

    public C0979c m5031a() {
        return m5032a(null);
    }

    public C0979c m5032a(String str) {
        C0979c a;
        ByteBuffer allocate = ByteBuffer.allocate(128);
        int i = 0;
        while (true) {
            byte b = m5030b();
            allocate.put(b);
            if (allocate.position() > 2) {
                int position;
                if (allocate.get(allocate.position() - 1) == f3088a[1] && allocate.get(allocate.position() - 2) == f3088a[0]) {
                    position = allocate.position() - f3088a.length;
                } else if (allocate.get(allocate.position() - 1) == f3088a[1]) {
                    position = allocate.position() - 1;
                } else if (i == 0 && b == (byte) 58) {
                    i = allocate.position();
                }
                a = m5029a(allocate.array(), position, i);
                if (a == null || !(str == null || am.m4189a(a.m5027a(), str))) {
                    allocate.position(0);
                    i = 0;
                }
            }
        }
        return a;
    }
}
