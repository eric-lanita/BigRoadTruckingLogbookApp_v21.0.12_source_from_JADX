package android.support.v4.p002a.p003a;

import android.graphics.drawable.Drawable;

class C0091g {
    public static void m475a(Drawable drawable, boolean z) {
        drawable.setAutoMirrored(z);
    }

    public static boolean m476a(Drawable drawable) {
        return drawable.isAutoMirrored();
    }

    public static Drawable m477b(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0102m(drawable);
    }

    public static int m478c(Drawable drawable) {
        return drawable.getAlpha();
    }
}
