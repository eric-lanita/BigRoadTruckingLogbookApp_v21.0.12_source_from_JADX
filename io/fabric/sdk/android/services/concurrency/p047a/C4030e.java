package io.fabric.sdk.android.services.concurrency.p047a;

public class C4030e {
    private final int f14217a;
    private final C2860a f14218b;
    private final C4027d f14219c;

    public C4030e(C2860a c2860a, C4027d c4027d) {
        this(0, c2860a, c4027d);
    }

    public C4030e(int i, C2860a c2860a, C4027d c4027d) {
        this.f14217a = i;
        this.f14218b = c2860a;
        this.f14219c = c4027d;
    }

    public long m20833a() {
        return this.f14218b.mo1448a(this.f14217a);
    }

    public C4030e m20834b() {
        return new C4030e(this.f14217a + 1, this.f14218b, this.f14219c);
    }

    public C4030e m20835c() {
        return new C4030e(this.f14218b, this.f14219c);
    }
}
