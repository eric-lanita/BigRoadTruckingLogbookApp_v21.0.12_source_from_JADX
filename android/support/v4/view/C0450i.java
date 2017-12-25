package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.LayoutInflater;

public final class C0450i {
    static final C0446a f1044a;

    interface C0446a {
        C0210m mo340a(LayoutInflater layoutInflater);

        void mo341a(LayoutInflater layoutInflater, C0210m c0210m);
    }

    static class C0447b implements C0446a {
        C0447b() {
        }

        public void mo341a(LayoutInflater layoutInflater, C0210m c0210m) {
            C0452j.m2071a(layoutInflater, c0210m);
        }

        public C0210m mo340a(LayoutInflater layoutInflater) {
            return C0452j.m2070a(layoutInflater);
        }
    }

    static class C0448c extends C0447b {
        C0448c() {
        }

        public void mo341a(LayoutInflater layoutInflater, C0210m c0210m) {
            C0454k.m2072a(layoutInflater, c0210m);
        }
    }

    static class C0449d extends C0448c {
        C0449d() {
        }

        public void mo341a(LayoutInflater layoutInflater, C0210m c0210m) {
            C0455l.m2074a(layoutInflater, c0210m);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f1044a = new C0449d();
        } else if (i >= 11) {
            f1044a = new C0448c();
        } else {
            f1044a = new C0447b();
        }
    }

    public static void m2069a(LayoutInflater layoutInflater, C0210m c0210m) {
        f1044a.mo341a(layoutInflater, c0210m);
    }

    public static C0210m m2068a(LayoutInflater layoutInflater) {
        return f1044a.mo340a(layoutInflater);
    }
}
