package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.C1064f;
import com.bigroad.shared.LogPriority;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1021r;
import com.bigroad.shared.eobr.turbo.logs.C1022b;
import java.io.ByteArrayInputStream;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class C1009h {
    private int f3147a;
    private int f3148b;
    private int f3149c;
    private int f3150d = -1;
    private TurboData f3151e = null;
    private C1008a f3152f = null;

    private class C1008a extends C1004e {
        final /* synthetic */ C1009h f3146b;

        C1008a(C1009h c1009h, InputStream inputStream) {
            this.f3146b = c1009h;
            this.a = inputStream;
        }

        InputStream mo765c() {
            return this.a;
        }

        protected void mo763a() {
            this.f3146b.f3147a = 1;
            try {
                this.f3146b.f3147a = this.a.read();
                if (this.f3146b.f3147a == 255) {
                    throw new EOFException();
                }
                this.f3146b.f3148b = this.f3146b.f3150d;
                this.f3146b.f3149c = C1064f.m5308a(0, this.f3146b.f3147a);
            } catch (TurboDataShortPageException e) {
                throw new EOFException();
            }
        }

        protected TurboData mo762a(int i, TurboData turboData) {
            Object obj = this.f3146b.f3147a > 1 ? 1 : null;
            while (this.f3146b.f3147a > 1) {
                this.a.read();
            }
            if (this.f3146b.f3149c != this.a.read()) {
                this.f3146b.m5182a("Bad CRC", LogPriority.LOG_WARN);
            }
            if (turboData == null) {
                throw new TurboDataUnrecognizedException(i);
            }
            if (obj != null) {
                this.f3146b.m5181a("Short frame");
            }
            return turboData;
        }

        protected void mo764a(int i) {
            if (i < 0 || i >= 253) {
                this.f3146b.m5182a("Invalid data length 0x" + Integer.toHexString(i) + " @ 0x" + Integer.toHexString(this.f3146b.f3150d), LogPriority.LOG_WARN);
            }
        }
    }

    public C1009h(ByteArrayInputStream byteArrayInputStream) {
        this.f3152f = new C1008a(this, new FilterInputStream(this, byteArrayInputStream) {
            final /* synthetic */ C1009h f3145a;

            public int read() {
                if (this.f3145a.f3147a <= 0) {
                    throw new TurboDataSerializationException("Entry @ 0x" + Integer.toHexString(this.f3145a.f3148b) + ": End of frame @ 0x" + Integer.toHexString(this.f3145a.f3150d));
                }
                this.f3145a.f3150d = this.f3145a.f3150d + 1;
                int read = this.in.read();
                if (read < 0) {
                    throw new TurboDataShortPageException();
                }
                this.f3145a.f3147a = this.f3145a.f3147a - 1;
                this.f3145a.f3149c = C1064f.m5308a(this.f3145a.f3149c, read);
                return read;
            }
        });
    }

    public C1016p m5192a() {
        this.f3151e = null;
        try {
            this.f3151e = this.f3152f.m5152b();
        } catch (TurboDataUnrecognizedException e) {
            this.f3151e = new C1021r(0);
        } catch (TurboDataSerializationException e2) {
            this.f3151e = new C1022b();
        } catch (EOFException e3) {
            this.f3151e = null;
        } catch (Throwable e4) {
            throw new RuntimeException("It should not be possible to throw an exception here.", e4);
        }
        if (this.f3151e == null) {
            return null;
        }
        if (this.f3151e instanceof C1016p) {
            return (C1016p) this.f3151e;
        }
        return new C1021r(0);
    }

    public static byte[] m5183a(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        C1009h c1009h = new C1009h(new ByteArrayInputStream(bArr));
        for (int i = 0; i < 253 && c1009h.m5192a() != null; i++) {
        }
        return Arrays.copyOf(bArr, c1009h.f3150d);
    }

    public static Integer m5186b(byte[] bArr) {
        C1009h c1009h = new C1009h(new ByteArrayInputStream(bArr));
        Integer valueOf = Integer.valueOf(-1);
        while (valueOf.intValue() < 253) {
            C1016p a = c1009h.m5192a();
            if (a == null) {
                break;
            } else if (a instanceof C1022b) {
                return null;
            } else {
                valueOf = Integer.valueOf(valueOf.intValue() + 1);
            }
        }
        return Integer.valueOf(Math.max(0, valueOf.intValue()));
    }

    public int m5193b() {
        return this.f3150d;
    }

    private void m5181a(String str) {
        m5182a(str, LogPriority.LOG_ERROR);
    }

    private void m5182a(String str, LogPriority logPriority) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Entry @ 0x");
        stringBuilder.append(Integer.toHexString(this.f3148b));
        stringBuilder.append(": ");
        stringBuilder.append(str);
        while (this.f3147a > 0) {
            try {
                this.f3152f.mo765c().read();
            } catch (IOException e) {
            }
        }
        throw new TurboDataSerializationException(stringBuilder.toString(), logPriority);
    }
}
