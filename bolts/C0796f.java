package bolts;

import java.io.Closeable;

public class C0796f implements Closeable {
    private final Object f2388a;
    private C0797g f2389b;
    private Runnable f2390c;
    private boolean f2391d;

    public void close() {
        synchronized (this.f2388a) {
            if (this.f2391d) {
                return;
            }
            this.f2391d = true;
            this.f2389b.m3978a(this);
            this.f2389b = null;
            this.f2390c = null;
        }
    }
}
