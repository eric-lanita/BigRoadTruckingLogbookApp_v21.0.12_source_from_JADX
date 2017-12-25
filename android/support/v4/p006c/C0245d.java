package android.support.v4.p006c;

import android.os.Build.VERSION;
import java.util.Locale;

public final class C0245d {
    public static final Locale f752a = new Locale("", "");
    private static final C0243a f753b;
    private static String f754c = "Arab";
    private static String f755d = "Hebr";

    private static class C0243a {
        private C0243a() {
        }

        public int mo165a(Locale locale) {
            if (!(locale == null || locale.equals(C0245d.f752a))) {
                String a = C0239a.m1058a(locale);
                if (a == null) {
                    return C0243a.m1063b(locale);
                }
                if (a.equalsIgnoreCase(C0245d.f754c) || a.equalsIgnoreCase(C0245d.f755d)) {
                    return 1;
                }
            }
            return 0;
        }

        private static int m1063b(Locale locale) {
            switch (Character.getDirectionality(locale.getDisplayName(locale).charAt(0))) {
                case (byte) 1:
                case (byte) 2:
                    return 1;
                default:
                    return 0;
            }
        }
    }

    private static class C0244b extends C0243a {
        private C0244b() {
            super();
        }

        public int mo165a(Locale locale) {
            return C0246e.m1069a(locale);
        }
    }

    static {
        if (VERSION.SDK_INT >= 17) {
            f753b = new C0244b();
        } else {
            f753b = new C0243a();
        }
    }

    public static int m1066a(Locale locale) {
        return f753b.mo165a(locale);
    }
}
