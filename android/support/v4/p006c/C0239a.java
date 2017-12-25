package android.support.v4.p006c;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0239a {
    private static final C0235a f748a;

    interface C0235a {
        String mo164a(Locale locale);
    }

    static class C0236b implements C0235a {
        C0236b() {
        }

        public String mo164a(Locale locale) {
            return null;
        }
    }

    static class C0237c implements C0235a {
        C0237c() {
        }

        public String mo164a(Locale locale) {
            return C0241c.m1061a(locale);
        }
    }

    static class C0238d implements C0235a {
        C0238d() {
        }

        public String mo164a(Locale locale) {
            return C0240b.m1059a(locale);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 21) {
            f748a = new C0238d();
        } else if (i >= 14) {
            f748a = new C0237c();
        } else {
            f748a = new C0236b();
        }
    }

    public static String m1058a(Locale locale) {
        return f748a.mo164a(locale);
    }
}
