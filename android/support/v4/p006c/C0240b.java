package android.support.v4.p006c;

import android.util.Log;
import java.lang.reflect.Method;
import java.util.Locale;

class C0240b {
    private static Method f749a;

    static {
        try {
            f749a = Class.forName("libcore.icu.ICU").getMethod("addLikelySubtags", new Class[]{Locale.class});
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
    }

    public static String m1059a(Locale locale) {
        try {
            return ((Locale) f749a.invoke(null, new Object[]{locale})).getScript();
        } catch (Throwable e) {
            Log.w("ICUCompatIcs", e);
            return locale.getScript();
        } catch (Throwable e2) {
            Log.w("ICUCompatIcs", e2);
            return locale.getScript();
        }
    }
}
