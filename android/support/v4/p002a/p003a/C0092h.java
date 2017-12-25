package android.support.v4.p002a.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

class C0092h {
    public static void m480a(Drawable drawable, float f, float f2) {
        drawable.setHotspot(f, f2);
    }

    public static void m482a(Drawable drawable, int i, int i2, int i3, int i4) {
        drawable.setHotspotBounds(i, i2, i3, i4);
    }

    public static void m481a(Drawable drawable, int i) {
        drawable.setTint(i);
    }

    public static void m483a(Drawable drawable, ColorStateList colorStateList) {
        drawable.setTintList(colorStateList);
    }

    public static void m486a(Drawable drawable, Mode mode) {
        drawable.setTintMode(mode);
    }

    public static Drawable m479a(Drawable drawable) {
        if (drawable instanceof C0004o) {
            return drawable;
        }
        return new C0104n(drawable);
    }

    public static void m484a(Drawable drawable, Theme theme) {
        drawable.applyTheme(theme);
    }

    public static boolean m487b(Drawable drawable) {
        return drawable.canApplyTheme();
    }

    public static ColorFilter m488c(Drawable drawable) {
        return drawable.getColorFilter();
    }

    public static void m485a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        drawable.inflate(resources, xmlPullParser, attributeSet, theme);
    }
}
