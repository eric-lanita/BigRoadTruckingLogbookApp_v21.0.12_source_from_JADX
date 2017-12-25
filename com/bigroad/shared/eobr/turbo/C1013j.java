package com.bigroad.shared.eobr.turbo;

import com.bigroad.shared.C0856d;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class C1013j extends C1005f {
    private final OutputStream f3183b;
    private int f3184c;
    private int f3185d;

    public C1013j(OutputStream outputStream) {
        this.f3183b = outputStream;
        this.a = new FilterOutputStream(this, outputStream) {
            final /* synthetic */ C1013j f3182a;

            public void write(int i) {
                this.f3182a.f3184c = C0856d.m4274a(this.f3182a.f3184c, i);
                this.f3182a.f3185d = this.f3182a.f3185d + 1;
                switch (i) {
                    case 125:
                        this.out.write(125);
                        this.out.write(93);
                        return;
                    case 126:
                        this.out.write(125);
                        this.out.write(94);
                        return;
                    default:
                        this.out.write(i);
                        return;
                }
            }
        };
    }

    protected void mo766a() {
        this.f3184c = 0;
        this.f3185d = 0;
        this.f3183b.write(126);
    }

    private void m5219a(int i) {
        this.a.write((i >>> 0) & 255);
        this.a.write((i >>> 8) & 255);
    }

    protected void mo767b() {
        m5219a(this.f3184c);
        if (this.f3185d > 2048) {
            throw new TurboDataSerializationException("Message exceeds MAX_MESSAGE_LENGTH");
        }
        this.a.flush();
    }
}
