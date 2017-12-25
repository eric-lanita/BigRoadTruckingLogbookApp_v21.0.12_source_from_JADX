package android.support.v4.p006c;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0241c {
    private static Method f750a;
    private static Method f751b;

    static {
        try {
            Class cls = Class.forName("libcore.icu.ICU");
            if (cls != null) {
                f750a = cls.getMethod("getScript", new Class[]{String.class});
                f751b = cls.getMethod("addLikelySubtags", new Class[]{String.class});
            }
        } catch (Throwable e) {
            f750a = null;
            f751b = null;
            Log.w("ICUCompatIcs", e);
        }
    }

    public static String m1061a(Locale locale) {
        String b = C0241c.m1062b(locale);
        if (b != null) {
            return C0241c.m1060a(b);
        }
        return null;
    }

    private static String m1060a(String str) {
        try {
            if (f750a != null) {
                return (String) f750a.invoke(null, new Object[]{str});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return null;
    }

    private static String m1062b(Locale locale) {
        String locale2 = locale.toString();
        try {
            if (f751b != null) {
                return (String) f751b.invoke(null, new Object[]{locale2});
            }
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
        }
        return locale2;
    }
}
