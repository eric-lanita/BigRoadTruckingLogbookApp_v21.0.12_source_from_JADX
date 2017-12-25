package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.C0856d;
import com.bigroad.shared.LogPriority;
import java.io.EOFException;
import java.io.FilterInputStream;
import java.io.InputStream;
import java.io.PushbackInputStream;

public class C1011i extends C1004e {
    private final PushbackInputStream f3180b;
    private int f3181c;

    public C1011i(InputStream inputStream) {
        this.f3180b = new PushbackInputStream(inputStream);
        this.a = new FilterInputStream(this, this.f3180b) {
            final /* synthetic */ C1011i f3179a;

            private int m5207a(int i) {
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
                int a = this.f3179a.m5211c();
                switch (a) {
                    case 125:
                        a = m5207a(this.f3179a.m5211c());
                        break;
                    case 126:
                        this.f3179a.f3180b.unread(a);
                        throw new TurboDataSerializationException("End of frame");
                }
                this.f3179a.f3181c = C0856d.m4274a(this.f3179a.f3181c, a);
                return a;
            }
        };
    }

    private int m5211c() {
        int read = this.f3180b.read();
        if (read >= 0) {
            return read;
        }
        throw new EOFException();
    }

    protected void mo764a(int i) {
        if (i < 0 || i >= 2048) {
            throw new TurboDataSerializationException("Invalid data length");
        }
    }

    private int m5213d() {
        return this.a.read() | (this.a.read() << 8);
    }

    protected void mo763a() {
        do {
        } while (m5211c() != 126);
        this.f3181c = 0;
    }

    protected TurboData mo762a(int i, TurboData turboData) {
        if (turboData == null) {
            throw new TurboDataSerializationException("Unknown ID: " + i);
        } else if (this.f3181c == m5213d()) {
            return turboData;
        } else {
            throw new TurboDataSerializationException("Bad CRC", LogPriority.LOG_WARN);
        }
    }
}
