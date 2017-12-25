package android.support.v4.app;

import android.content.Context;
import android.os.Build.VERSION;

public final class C0187f {
    private static final C0185b f605a;

    private static class C0185b {
        private C0185b() {
        }

        public String mo136a(String str) {
            return null;
        }

        public int mo135a(Context context, String str, String str2) {
            return 1;
        }
    }

    private static class C0186a extends C0185b {
        private C0186a() {
            super();
        }

        public String mo136a(String str) {
            return C0188g.m806a(str);
        }

        public int mo135a(Context context, String str, String str2) {
            return C0188g.m805a(context, str, str2);
        }
    }

    static {
        if (VERSION.SDK_INT >= 23) {
            f605a = new C0186a();
        } else {
            f605a = new C0185b();
        }
    }

    public static String m804a(String str) {
        return f605a.mo136a(str);
    }

    public static int m803a(Context context, String str, String str2) {
        return f605a.mo135a(context, str, str2);
    }
}
