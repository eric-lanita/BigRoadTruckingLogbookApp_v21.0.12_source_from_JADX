package android.support.v4.view;

import android.view.View;
import android.view.View.AccessibilityDelegate;

class al {
    public static boolean m1854a(View view, int i) {
        return view.canScrollHorizontally(i);
    }

    public static boolean m1855b(View view, int i) {
        return view.canScrollVertically(i);
    }

    public static void m1853a(View view, Object obj) {
        view.setAccessibilityDelegate((AccessibilityDelegate) obj);
    }
}
