package android.support.v4.widget;

import android.widget.PopupWindow;
import java.lang.reflect.Method;

class C0542t {
    private static Method f1260a;
    private static boolean f1261b;

    static void m2495a(PopupWindow popupWindow, int i) {
        if (!f1261b) {
            try {
                f1260a = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", new Class[]{Integer.TYPE});
                f1260a.setAccessible(true);
            } catch (Exception e) {
            }
            f1261b = true;
        }
        if (f1260a != null) {
            try {
                f1260a.invoke(popupWindow, new Object[]{Integer.valueOf(i)});
            } catch (Exception e2) {
            }
        }
    }
}
