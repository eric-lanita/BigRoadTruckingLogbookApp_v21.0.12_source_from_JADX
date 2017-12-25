package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.C0963e;
import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.C0968a;
import com.google.protobuf.C3642c;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;
import java.util.Arrays;

public class C0994r {
    protected long f3112a = -1;
    private final InputStream f3113b;
    private final PushbackInputStream f3114c;
    private ByteArrayOutputStream f3115d = new ByteArrayOutputStream(2048);
    private ByteArrayOutputStream f3116e = new ByteArrayOutputStream(1024);
    private ByteArrayOutputStream f3117f = new ByteArrayOutputStream(256);

    public C0994r(InputStream inputStream) {
        this.f3114c = new PushbackInputStream(inputStream);
        this.f3113b = new FilterInputStream(this, this.f3114c) {
            final /* synthetic */ C0994r f3110a;

            private int m5089a(int i) {
                switch (i) {
                    case 93:
                        return 125;
                    case 94:
                        return 126;
                    default:
                        return i;
                }
            }

            public int read() {
                int a = this.f3110a.m5092a();
                this.f3110a.f3116e.write(a);
                switch (a) {
                    case 125:
                        return m5089a(this.f3110a.m5092a());
                    case 126:
                        return -2;
                    default:
                        return a;
                }
            }
        };
    }

    protected int m5092a() {
        int read = this.f3114c.read();
        if (read < 0) {
            throw new EOFException();
        }
        this.f3115d.write(read);
        return read;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.bigroad.shared.eobr.genx.C0975o m5095b() {
        /*
        r6 = this;
        r0 = 1;
        monitor-enter(r6);
        r1 = r6.f3116e;	 Catch:{ all -> 0x006e }
        r1.reset();	 Catch:{ all -> 0x006e }
        r1 = r6.f3117f;	 Catch:{ all -> 0x006e }
        r1.reset();	 Catch:{ all -> 0x006e }
        r6.m5097d();	 Catch:{ all -> 0x006e }
    L_0x000f:
        r2 = r6.f3112a;	 Catch:{ EOFException -> 0x0065 }
        r4 = -1;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x0052;
    L_0x0017:
        r2 = r6.f3112a;	 Catch:{ EOFException -> 0x0065 }
        r4 = 1;
        r2 = r2 - r4;
        r6.f3112a = r2;	 Catch:{ EOFException -> 0x0065 }
        r2 = r6.f3112a;	 Catch:{ EOFException -> 0x0065 }
        r4 = 0;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 != 0) goto L_0x0052;
    L_0x0026:
        r1 = java.lang.System.out;	 Catch:{ EOFException -> 0x0065 }
        r2 = "Read byte limit reached";
        r1.println(r2);	 Catch:{ EOFException -> 0x0065 }
    L_0x002d:
        r1 = r6.f3117f;	 Catch:{ all -> 0x006e }
        r2 = r1.toByteArray();	 Catch:{ all -> 0x006e }
        r6.m5094a(r2);	 Catch:{ all -> 0x006e }
        r1 = 0;
        r1 = r2[r1];	 Catch:{ all -> 0x006e }
        r1 = r1 & 255;
        r3 = com.bigroad.shared.eobr.genx.GenxDataType.m4980a(r1);	 Catch:{ all -> 0x006e }
        r1 = -1;
        r4 = com.bigroad.shared.eobr.genx.GenxDataType.ENTRY;	 Catch:{ all -> 0x006e }
        if (r3 != r4) goto L_0x0077;
    L_0x0044:
        r0 = 0;
        r4 = r2.length;	 Catch:{ all -> 0x006e }
        r4 = r4 + -2;
        r0 = java.util.Arrays.copyOfRange(r2, r0, r4);	 Catch:{ all -> 0x006e }
    L_0x004c:
        r0 = r6.m5093a(r3, r1, r0);	 Catch:{ all -> 0x006e }
        monitor-exit(r6);
        return r0;
    L_0x0052:
        r1 = r6.f3113b;	 Catch:{ EOFException -> 0x0065 }
        r1 = r1.read();	 Catch:{ EOFException -> 0x0065 }
        r2 = -2;
        if (r1 == r2) goto L_0x002d;
    L_0x005b:
        if (r1 >= 0) goto L_0x0071;
    L_0x005d:
        r0 = new com.bigroad.shared.eobr.genx.GenxDataSerializationException;	 Catch:{ EOFException -> 0x0065 }
        r1 = "Missing end-of-frame marker";
        r0.<init>(r1);	 Catch:{ EOFException -> 0x0065 }
        throw r0;	 Catch:{ EOFException -> 0x0065 }
    L_0x0065:
        r0 = move-exception;
        r0 = new com.bigroad.shared.eobr.genx.GenxDataSerializationException;	 Catch:{ all -> 0x006e }
        r1 = "Missing end-of-frame marker";
        r0.<init>(r1);	 Catch:{ all -> 0x006e }
        throw r0;	 Catch:{ all -> 0x006e }
    L_0x006e:
        r0 = move-exception;
        monitor-exit(r6);
        throw r0;
    L_0x0071:
        r2 = r6.f3117f;	 Catch:{ EOFException -> 0x0065 }
        r2.write(r1);	 Catch:{ EOFException -> 0x0065 }
        goto L_0x000f;
    L_0x0077:
        r4 = r2.length;	 Catch:{ all -> 0x006e }
        r5 = 4;
        if (r4 < r5) goto L_0x0081;
    L_0x007b:
        r0 = 1;
        r0 = r2[r0];	 Catch:{ all -> 0x006e }
        r1 = r0 & 255;
        r0 = 2;
    L_0x0081:
        r4 = r2.length;	 Catch:{ all -> 0x006e }
        r4 = r4 + -2;
        r0 = java.util.Arrays.copyOfRange(r2, r0, r4);	 Catch:{ all -> 0x006e }
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.shared.eobr.genx.r.b():com.bigroad.shared.eobr.genx.o");
    }

    protected C0975o m5093a(GenxDataType genxDataType, int i, byte[] bArr) {
        switch (genxDataType) {
            case ENTRY:
                return GenxEntryResponse.m4997a(m5091b(bArr));
            case AT_COMMAND:
                return C0983f.m5040a(i, bArr);
            case ACK:
                return C0978b.m5024a(i, bArr);
            case NAK:
                return C0989m.m5076a(i, bArr);
            case START_SESSION:
                return C0988l.m5074a(genxDataType, i, bArr);
            default:
                return C0988l.m5074a(genxDataType, i, bArr);
        }
    }

    private byte[] m5091b(byte[] bArr) {
        byte[] bArr2 = new byte[2];
        C0968a.m4968b(bArr2, 0, 1);
        return C3642c.m19078a(bArr2).m19084a(C3642c.m19078a(bArr)).m19091d();
    }

    public void m5096c() {
        this.f3115d.reset();
    }

    protected void m5094a(byte[] bArr) {
        if (bArr.length < 3) {
            throw new GenxDataSerializationException("Data too short", bArr);
        }
        int d = C0968a.m4970d(bArr, bArr.length - 2);
        int i = 0;
        for (int i2 = 0; i2 <= bArr.length - 3; i2++) {
            i = C0963e.m4927a(i, bArr[i2]);
        }
        if (d != i) {
            byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr.length - 2, bArr.length);
            byte[] bArr2 = new byte[2];
            C0968a.m4968b(bArr2, 0, i);
            throw new GenxDataSerializationException("CRC mismatch {" + C1180y.m5993b(copyOfRange) + "} != {" + C1180y.m5993b(bArr2) + "}", bArr);
        }
    }

    protected void m5097d() {
        int a;
        do {
            a = m5092a();
            this.f3116e.write(a);
        } while (a != 126);
        a = m5092a();
        if (a != 126) {
            this.f3114c.unread(a);
        } else {
            this.f3116e.write(a);
        }
    }
}
