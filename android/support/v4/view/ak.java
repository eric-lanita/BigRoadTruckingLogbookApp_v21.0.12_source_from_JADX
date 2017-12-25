package android.support.v4.view;

import android.animation.ValueAnimator;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewParent;

class ak {
    static long m1837a() {
        return ValueAnimator.getFrameDelay();
    }

    public static void m1840a(View view, int i, Paint paint) {
        view.setLayerType(i, paint);
    }

    public static int m1836a(View view) {
        return view.getLayerType();
    }

    public static int m1835a(int i, int i2, int i3) {
        return View.resolveSizeAndState(i, i2, i3);
    }

    public static int m1842b(View view) {
        return view.getMeasuredWidthAndState();
    }

    public static int m1846c(View view) {
        return view.getMeasuredState();
    }

    public static float m1848d(View view) {
        return view.getTranslationY();
    }

    public static float m1850e(View view) {
        return view.getScaleX();
    }

    public static void m1838a(View view, float f) {
        view.setTranslationY(f);
    }

    public static void m1843b(View view, float f) {
        view.setAlpha(f);
    }

    public static void m1847c(View view, float f) {
        view.setScaleX(f);
    }

    public static void m1849d(View view, float f) {
        view.setScaleY(f);
    }

    public static void m1851f(View view) {
        view.jumpDrawablesToCurrentState();
    }

    public static void m1841a(View view, boolean z) {
        view.setSaveFromParentEnabled(z);
    }

    public static void m1845b(View view, boolean z) {
        view.setActivated(z);
    }

    static void m1839a(View view, int i) {
        view.offsetTopAndBottom(i);
        m1852g(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m1852g((View) parent);
        }
    }

    static void m1844b(View view, int i) {
        view.offsetLeftAndRight(i);
        m1852g(view);
        ViewParent parent = view.getParent();
        if (parent instanceof View) {
            m1852g((View) parent);
        }
    }

    private static void m1852g(View view) {
        float translationY = view.getTranslationY();
        view.setTranslationY(1.0f + translationY);
        view.setTranslationY(translationY);
    }
}
