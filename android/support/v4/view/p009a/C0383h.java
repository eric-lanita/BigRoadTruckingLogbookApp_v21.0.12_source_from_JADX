package android.support.v4.view.p009a;

import android.os.Build.VERSION;

public class C0383h {
    private static final C0378c f1000a;
    private final Object f1001b;

    interface C0378c {
        void mo249a(Object obj, int i);

        void mo250a(Object obj, boolean z);

        void mo251b(Object obj, int i);

        void mo252c(Object obj, int i);

        void mo253d(Object obj, int i);

        void mo254e(Object obj, int i);

        void mo255f(Object obj, int i);

        void mo256g(Object obj, int i);
    }

    static class C0379e implements C0378c {
        C0379e() {
        }

        public void mo249a(Object obj, int i) {
        }

        public void mo251b(Object obj, int i) {
        }

        public void mo255f(Object obj, int i) {
        }

        public void mo256g(Object obj, int i) {
        }

        public void mo252c(Object obj, int i) {
        }

        public void mo253d(Object obj, int i) {
        }

        public void mo250a(Object obj, boolean z) {
        }

        public void mo254e(Object obj, int i) {
        }
    }

    static class C0380a extends C0379e {
        C0380a() {
        }

        public void mo249a(Object obj, int i) {
            C0384i.m1590a(obj, i);
        }

        public void mo251b(Object obj, int i) {
            C0384i.m1592b(obj, i);
        }

        public void mo252c(Object obj, int i) {
            C0384i.m1593c(obj, i);
        }

        public void mo253d(Object obj, int i) {
            C0384i.m1594d(obj, i);
        }

        public void mo250a(Object obj, boolean z) {
            C0384i.m1591a(obj, z);
        }

        public void mo254e(Object obj, int i) {
            C0384i.m1595e(obj, i);
        }
    }

    static class C0381b extends C0380a {
        C0381b() {
        }

        public void mo255f(Object obj, int i) {
            C0385j.m1596a(obj, i);
        }

        public void mo256g(Object obj, int i) {
            C0385j.m1597b(obj, i);
        }
    }

    static class C0382d extends C0381b {
        C0382d() {
        }
    }

    static {
        if (VERSION.SDK_INT >= 16) {
            f1000a = new C0382d();
        } else if (VERSION.SDK_INT >= 15) {
            f1000a = new C0381b();
        } else if (VERSION.SDK_INT >= 14) {
            f1000a = new C0380a();
        } else {
            f1000a = new C0379e();
        }
    }

    public C0383h(Object obj) {
        this.f1001b = obj;
    }

    public void m1583a(boolean z) {
        f1000a.mo250a(this.f1001b, z);
    }

    public void m1582a(int i) {
        f1000a.mo251b(this.f1001b, i);
    }

    public void m1584b(int i) {
        f1000a.mo249a(this.f1001b, i);
    }

    public void m1585c(int i) {
        f1000a.mo254e(this.f1001b, i);
    }

    public void m1586d(int i) {
        f1000a.mo252c(this.f1001b, i);
    }

    public void m1587e(int i) {
        f1000a.mo253d(this.f1001b, i);
    }

    public void m1588f(int i) {
        f1000a.mo255f(this.f1001b, i);
    }

    public void m1589g(int i) {
        f1000a.mo256g(this.f1001b, i);
    }

    public int hashCode() {
        return this.f1001b == null ? 0 : this.f1001b.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        C0383h c0383h = (C0383h) obj;
        if (this.f1001b == null) {
            if (c0383h.f1001b != null) {
                return false;
            }
            return true;
        } else if (this.f1001b.equals(c0383h.f1001b)) {
            return true;
        } else {
            return false;
        }
    }
}
