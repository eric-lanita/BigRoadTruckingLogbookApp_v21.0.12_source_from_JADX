package bolts;

import java.io.Closeable;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class C0797g implements Closeable {
    private final Object f2392a;
    private final List<C0796f> f2393b;
    private ScheduledFuture<?> f2394c;
    private boolean f2395d;
    private boolean f2396e;

    public boolean m3979a() {
        boolean z;
        synchronized (this.f2392a) {
            m3976b();
            z = this.f2395d;
        }
        return z;
    }

    public void close() {
        synchronized (this.f2392a) {
            if (this.f2396e) {
                return;
            }
            m3977c();
            for (C0796f close : this.f2393b) {
                close.close();
            }
            this.f2393b.clear();
            this.f2396e = true;
        }
    }

    void m3978a(C0796f c0796f) {
        synchronized (this.f2392a) {
            m3976b();
            this.f2393b.remove(c0796f);
        }
    }

    public String toString() {
        return String.format(Locale.US, "%s@%s[cancellationRequested=%s]", new Object[]{getClass().getName(), Integer.toHexString(hashCode()), Boolean.toString(m3979a())});
    }

    private void m3976b() {
        if (this.f2396e) {
            throw new IllegalStateException("Object already closed");
        }
    }

    private void m3977c() {
        if (this.f2394c != null) {
            this.f2394c.cancel(true);
            this.f2394c = null;
        }
    }
}
