package android.support.v4.view;

import android.view.View;

class an {
    public static void m1857a(View view) {
        view.postInvalidateOnAnimation();
    }

    public static void m1859a(View view, Runnable runnable) {
        view.postOnAnimation(runnable);
    }

    public static void m1860a(View view, Runnable runnable, long j) {
        view.postOnAnimationDelayed(runnable, j);
    }

    public static int m1861b(View view) {
        return view.getImportantForAccessibility();
    }

    public static void m1858a(View view, int i) {
        view.setImportantForAccessibility(i);
    }

    public static int m1862c(View view) {
        return view.getMinimumHeight();
    }

    public static void m1863d(View view) {
        view.requestFitSystemWindows();
    }

    public static boolean m1864e(View view) {
        return view.getFitsSystemWindows();
    }

    public static boolean m1865f(View view) {
        return view.hasOverlappingRendering();
    }
}
