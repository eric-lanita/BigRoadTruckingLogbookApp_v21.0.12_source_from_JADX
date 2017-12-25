package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.view.View;
import android.view.ViewParent;
import java.lang.reflect.Field;

class ah {
    private static Field f1008a;
    private static boolean f1009b;

    static ColorStateList m1824a(View view) {
        return view instanceof ad ? ((ad) view).getSupportBackgroundTintList() : null;
    }

    static void m1826a(View view, ColorStateList colorStateList) {
        if (view instanceof ad) {
            ((ad) view).setSupportBackgroundTintList(colorStateList);
        }
    }

    static Mode m1828b(View view) {
        return view instanceof ad ? ((ad) view).getSupportBackgroundTintMode() : null;
    }

    static void m1827a(View view, Mode mode) {
        if (view instanceof ad) {
            ((ad) view).setSupportBackgroundTintMode(mode);
        }
    }

    static boolean m1830c(View view) {
        return view.getWidth() > 0 && view.getHeight() > 0;
    }

    static int m1831d(View view) {
        if (!f1009b) {
            try {
                f1008a = View.class.getDeclaredField("mMinHeight");
                f1008a.setAccessible(true);
            } catch (NoSuchFieldException e) {
            }
            f1009b = true;
        }
        if (f1008a != null) {
            try {
                return ((Integer) f1008a.get(view)).intValue();
            } catch (Exception e2) {
            }
        }
        return 0;
    }

    static boolean m1832e(View view) {
        return view.getWindowToken() != null;
    }

    static void m1825a(View view, int i) {
        int top = view.getTop();
        view.offsetTopAndBottom(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(view.getLeft(), top - abs, view.getRight(), (top + view.getHeight()) + abs);
                return;
            }
            view.invalidate();
        }
    }

    static void m1829b(View view, int i) {
        int left = view.getLeft();
        view.offsetLeftAndRight(i);
        if (i != 0) {
            ViewParent parent = view.getParent();
            if (parent instanceof View) {
                int abs = Math.abs(i);
                ((View) parent).invalidate(left - abs, view.getTop(), (left + view.getWidth()) + abs, view.getBottom());
                return;
            }
            view.invalidate();
        }
    }
}
