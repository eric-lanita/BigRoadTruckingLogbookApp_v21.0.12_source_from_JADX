package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.C0963e;
import com.bigroad.shared.eobr.C0968a;
import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.OutputStream;

public class C0996s {
    private final OutputStream f3119a;
    private final OutputStream f3120b;
    private int f3121c;
    private int f3122d;
    private ByteArrayOutputStream f3123e = new ByteArrayOutputStream(1024);

    public C0996s(OutputStream outputStream) {
        this.f3120b = outputStream;
        this.f3119a = new FilterOutputStream(this, outputStream) {
            final /* synthetic */ C0996s f3118a;

            public void write(int i) {
                this.f3118a.f3121c = C0963e.m4927a(this.f3118a.f3121c, i);
                this.f3118a.f3122d = this.f3118a.f3122d + 1;
                switch (i) {
                    case 125:
                        this.out.write(125);
                        this.f3118a.f3123e.write(125);
                        this.out.write(93);
                        this.f3118a.f3123e.write(93);
                        return;
                    case 126:
                        this.out.write(125);
                        this.f3118a.f3123e.write(125);
                        this.out.write(94);
                        this.f3118a.f3123e.write(94);
                        return;
                    default:
                        this.out.write(i);
                        this.f3118a.f3123e.write(i);
                        return;
                }
            }
        };
    }

    protected void m5103a() {
        m5106b();
        m5104a(126);
    }

    protected void m5106b() {
        this.f3121c = 0;
        this.f3122d = 0;
    }

    protected void m5104a(int i) {
        this.f3120b.write(i);
        this.f3123e.write(i);
    }

    protected void m5107b(int i) {
        byte[] bArr = new byte[2];
        C0968a.m4968b(bArr, 0, i);
        this.f3119a.write(bArr);
    }

    private void m5102c() {
        m5107b(this.f3121c);
        this.f3120b.write(126);
        this.f3123e.write(126);
        if (this.f3122d > 362) {
            throw new GenxDataSerializationException("Message exceeds MAX_MESSAGE_LENGTH");
        }
        this.f3119a.flush();
    }

    public final synchronized void m5105a(C0981n c0981n) {
        this.f3123e.reset();
        m5103a();
        this.f3119a.write(c0981n.mo758b().m4981a());
        this.f3119a.write(c0981n.m5037g() & 255);
        this.f3119a.write(c0981n.mo759c());
        m5102c();
    }
}
