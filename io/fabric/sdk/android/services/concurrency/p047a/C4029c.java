package io.fabric.sdk.android.services.concurrency.p047a;

public class C4029c implements C2860a {
    private final long f14215a;
    private final int f14216b;

    public C4029c(long j, int i) {
        this.f14215a = j;
        this.f14216b = i;
    }

    public long mo1448a(int i) {
        return (long) (((double) this.f14215a) * Math.pow((double) this.f14216b, (double) i));
    }
}
