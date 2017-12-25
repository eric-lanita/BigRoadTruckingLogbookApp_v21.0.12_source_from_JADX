package android.support.v4.view;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import android.view.View.OnApplyWindowInsetsListener;
import android.view.ViewParent;
import android.view.WindowInsets;

class aq {
    private static ThreadLocal<Rect> f1012a;

    public static void m1872a(View view) {
        view.requestApplyInsets();
    }

    public static void m1873a(View view, float f) {
        view.setElevation(f);
    }

    public static void m1877a(View view, final aa aaVar) {
        if (aaVar == null) {
            view.setOnApplyWindowInsetsListener(null);
        } else {
            view.setOnApplyWindowInsetsListener(new OnApplyWindowInsetsListener() {
                public WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
                    return ((bf) aaVar.mo184a(view, new bf(windowInsets))).m2026f();
                }
            });
        }
    }

    static ColorStateList m1878b(View view) {
        return view.getBackgroundTintList();
    }

    static void m1875a(View view, ColorStateList colorStateList) {
        view.setBackgroundTintList(colorStateList);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    static Mode m1881c(View view) {
        return view.getBackgroundTintMode();
    }

    static void m1876a(View view, Mode mode) {
        view.setBackgroundTintMode(mode);
        if (VERSION.SDK_INT == 21) {
            Drawable background = view.getBackground();
            Object obj = (view.getBackgroundTintList() == null || view.getBackgroundTintMode() == null) ? null : 1;
            if (background != null && obj != null) {
                if (background.isStateful()) {
                    background.setState(view.getDrawableState());
                }
                view.setBackground(background);
            }
        }
    }

    public static be m1871a(View view, be beVar) {
        if (!(beVar instanceof bf)) {
            return beVar;
        }
        WindowInsets f = ((bf) beVar).m2026f();
        WindowInsets onApplyWindowInsets = view.onApplyWindowInsets(f);
        if (onApplyWindowInsets != f) {
            return new bf(onApplyWindowInsets);
        }
        return beVar;
    }

    public static be m1879b(View view, be beVar) {
        if (!(beVar instanceof bf)) {
            return beVar;
        }
        WindowInsets f = ((bf) beVar).m2026f();
        WindowInsets dispatchApplyWindowInsets = view.dispatchApplyWindowInsets(f);
        if (dispatchApplyWindowInsets != f) {
            return new bf(dispatchApplyWindowInsets);
        }
        return beVar;
    }

    public static boolean m1882d(View view) {
        return view.isNestedScrollingEnabled();
    }

    public static void m1883e(View view) {
        view.stopNestedScroll();
    }

    static void m1874a(View view, int i) {
        Object obj;
        Rect a = m1870a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        ak.m1839a(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    static void m1880b(View view, int i) {
        Object obj;
        Rect a = m1870a();
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            View view2 = (View) parent;
            a.set(view2.getLeft(), view2.getTop(), view2.getRight(), view2.getBottom());
            obj = !a.intersects(view.getLeft(), view.getTop(), view.getRight(), view.getBottom()) ? 1 : null;
        } else {
            obj = null;
        }
        ak.m1844b(view, i);
        if (obj != null && a.intersect(view.getLeft(), view.getTop(), view.getRight(), view.getBottom())) {
            ((View) parent).invalidate(a);
        }
    }

    private static Rect m1870a() {
        if (f1012a == null) {
            f1012a = new ThreadLocal();
        }
        Rect rect = (Rect) f1012a.get();
        if (rect == null) {
            rect = new Rect();
            f1012a.set(rect);
        }
        rect.setEmpty();
        return rect;
    }
}
