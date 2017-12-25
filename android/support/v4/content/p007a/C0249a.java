package android.support.v4.content.p007a;

import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;

public final class C0249a {
    public static Drawable m1082a(Resources resources, int i, Theme theme) {
        if (VERSION.SDK_INT >= 21) {
            return C0250b.m1083a(resources, i, theme);
        }
        return resources.getDrawable(i);
    }
}
