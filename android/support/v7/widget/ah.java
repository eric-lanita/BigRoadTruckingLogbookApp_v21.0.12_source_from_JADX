package android.support.v7.widget;

import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.DrawableContainer;
import android.graphics.drawable.DrawableContainer.DrawableContainerState;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ScaleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.support.v4.p002a.p003a.C0093i;
import android.support.v7.p013c.p014a.C0637a;

public class ah {
    public static final Rect f2029a = new Rect();
    private static Class<?> f2030b;

    static {
        if (VERSION.SDK_INT >= 18) {
            try {
                f2030b = Class.forName("android.graphics.Insets");
            } catch (ClassNotFoundException e) {
            }
        }
    }

    static void m3593a(Drawable drawable) {
        if (VERSION.SDK_INT == 21 && "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName())) {
            m3595c(drawable);
        }
    }

    public static boolean m3594b(Drawable drawable) {
        if (drawable instanceof LayerDrawable) {
            boolean z;
            if (VERSION.SDK_INT >= 16) {
                z = true;
            } else {
                z = false;
            }
            return z;
        } else if (drawable instanceof InsetDrawable) {
            if (VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (drawable instanceof StateListDrawable) {
            if (VERSION.SDK_INT < 8) {
                return false;
            }
            return true;
        } else if (drawable instanceof GradientDrawable) {
            if (VERSION.SDK_INT < 14) {
                return false;
            }
            return true;
        } else if (drawable instanceof DrawableContainer) {
            ConstantState constantState = drawable.getConstantState();
            if (!(constantState instanceof DrawableContainerState)) {
                return true;
            }
            for (Drawable b : ((DrawableContainerState) constantState).getChildren()) {
                if (!m3594b(b)) {
                    return false;
                }
            }
            return true;
        } else if (drawable instanceof C0093i) {
            return m3594b(((C0093i) drawable).mo70a());
        } else {
            if (drawable instanceof C0637a) {
                return m3594b(((C0637a) drawable).m2979a());
            }
            if (drawable instanceof ScaleDrawable) {
                return m3594b(((ScaleDrawable) drawable).getDrawable());
            }
            return true;
        }
    }

    private static void m3595c(Drawable drawable) {
        int[] state = drawable.getState();
        if (state == null || state.length == 0) {
            drawable.setState(at.f2175e);
        } else {
            drawable.setState(at.f2178h);
        }
        drawable.setState(state);
    }

    static Mode m3592a(int i, Mode mode) {
        switch (i) {
            case 3:
                return Mode.SRC_OVER;
            case 5:
                return Mode.SRC_IN;
            case 9:
                return Mode.SRC_ATOP;
            case 14:
                return Mode.MULTIPLY;
            case 15:
                return Mode.SCREEN;
            case 16:
                if (VERSION.SDK_INT >= 11) {
                    return Mode.valueOf("ADD");
                }
                return mode;
            default:
                return mode;
        }
    }
}
