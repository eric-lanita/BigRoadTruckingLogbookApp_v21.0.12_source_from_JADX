package android.support.v4.p002a.p003a;

import android.graphics.drawable.Drawable;

class C0089e {
    public static void m472a(Drawable drawable) {
        drawable.jumpToCurrentState();
    }

    public static Drawable m473b(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0100l(drawable);
    }
}
