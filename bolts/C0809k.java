package bolts;

import bolts.C0808i.C0807b;

class C0809k {
    private C0808i<?> f2437a;

    public C0809k(C0808i<?> c0808i) {
        this.f2437a = c0808i;
    }

    protected void finalize() {
        try {
            C0808i c0808i = this.f2437a;
            if (c0808i != null) {
                C0807b a = C0808i.m3992a();
                if (a != null) {
                    a.m3991a(c0808i, new UnobservedTaskException(c0808i.m4014g()));
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
        }
    }

    public void m4016a() {
        this.f2437a = null;
    }
}
