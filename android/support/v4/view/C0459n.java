package android.support.v4.view;

import android.os.Build.VERSION;
import android.view.ViewGroup.MarginLayoutParams;

public final class C0459n {
    static final C0456a f1048a;

    interface C0456a {
        int mo342a(MarginLayoutParams marginLayoutParams);

        int mo343b(MarginLayoutParams marginLayoutParams);
    }

    static class C0457b implements C0456a {
        C0457b() {
        }

        public int mo342a(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.leftMargin;
        }

        public int mo343b(MarginLayoutParams marginLayoutParams) {
            return marginLayoutParams.rightMargin;
        }
    }

    static class C0458c implements C0456a {
        C0458c() {
        }

        public int mo342a(MarginLayoutParams marginLayoutParams) {
            return C0460o.m2083a(marginLayoutParams);
        }

        public int mo343b(MarginLayoutParams marginLayoutParams) {
            return C0460o.m2084b(marginLayoutParams);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f1048a = new C0458c();
        } else {
            f1048a = new C0457b();
        }
    }

    public static int m2081a(MarginLayoutParams marginLayoutParams) {
        return f1048a.mo342a(marginLayoutParams);
    }

    public static int m2082b(MarginLayoutParams marginLayoutParams) {
        return f1048a.mo343b(marginLayoutParams);
    }
}
