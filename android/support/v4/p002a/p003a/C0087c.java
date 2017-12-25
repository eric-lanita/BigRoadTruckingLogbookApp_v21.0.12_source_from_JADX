package android.support.v4.p002a.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0087c {
    public static void m467a(Drawable drawable, int i) {
        if (drawable instanceof C0004o) {
            ((C0004o) drawable).setTint(i);
        }
    }

    public static void m468a(Drawable drawable, ColorStateList colorStateList) {
        if (drawable instanceof C0004o) {
            ((C0004o) drawable).setTintList(colorStateList);
        }
    }

    public static void m470a(Drawable drawable, Mode mode) {
        if (drawable instanceof C0004o) {
            ((C0004o) drawable).setTintMode(mode);
        }
    }

    public static Drawable m466a(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0096j(drawable);
    }

    public static void m469a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet);
    }
}
