package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewConfiguration;

public final class as {
    static final C0403e f1013a;

    interface C0403e {
        int mo307a(ViewConfiguration viewConfiguration);

        boolean mo308b(ViewConfiguration viewConfiguration);
    }

    static class C0404a implements C0403e {
        C0404a() {
        }

        public int mo307a(ViewConfiguration viewConfiguration) {
            return viewConfiguration.getScaledTouchSlop();
        }

        public boolean mo308b(ViewConfiguration viewConfiguration) {
            return true;
        }
    }

    static class C0405b extends C0404a {
        C0405b() {
        }

        public int mo307a(ViewConfiguration viewConfiguration) {
            return at.m1896a(viewConfiguration);
        }
    }

    static class C0406c extends C0405b {
        C0406c() {
        }

        public boolean mo308b(ViewConfiguration viewConfiguration) {
            return false;
        }
    }

    static class C0407d extends C0406c {
        C0407d() {
        }

        public boolean mo308b(ViewConfiguration viewConfiguration) {
            return au.m1897a(viewConfiguration);
        }
    }

    static {
        if (VERSION.SDK_INT >= 14) {
            f1013a = new C0407d();
        } else if (VERSION.SDK_INT >= 11) {
            f1013a = new C0406c();
        } else if (VERSION.SDK_INT >= 8) {
            f1013a = new C0405b();
        } else {
            f1013a = new C0404a();
        }
    }

    public static int m1894a(ViewConfiguration viewConfiguration) {
        return f1013a.mo307a(viewConfiguration);
    }

    public static boolean m1895b(ViewConfiguration viewConfiguration) {
        return f1013a.mo308b(viewConfiguration);
    }
}
