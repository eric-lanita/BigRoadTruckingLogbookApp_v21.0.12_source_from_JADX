package android.support.v4.widget;

import android.util.Log;
import android.widget.PopupWindow;
import java.lang.reflect.Field;

class C0540r {
    private static Field f1259a;

    static {
        try {
            f1259a = PopupWindow.class.getDeclaredField("mOverlapAnchor");
            f1259a.setAccessible(true);
        } catch (Throwable e) {
            Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", e);
        }
    }

    static void m2492a(PopupWindow popupWindow, boolean z) {
        if (f1259a != null) {
            try {
                f1259a.set(popupWindow, Boolean.valueOf(z));
            } catch (Throwable e) {
                Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", e);
            }
        }
    }
}
