package android.support.v4.view;

import android.os.Build.VERSION;

public final class C0438e {
    static final C0435a f1042a;

    interface C0435a {
        int mo336a(int i, int i2);
    }

    static class C0436b implements C0435a {
        C0436b() {
        }

        public int mo336a(int i, int i2) {
            return -8388609 & i;
        }
    }

    static class C0437c implements C0435a {
        C0437c() {
        }

        public int mo336a(int i, int i2) {
            return C0439f.m2047a(i, i2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1042a = new C0437c();
        } else {
            f1042a = new C0436b();
        }
    }

    public static int m2046a(int i, int i2) {
        return f1042a.mo336a(i, i2);
    }
}
