package android.support.v4.view;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.Method;

class ai {
    private static Method f1010a;

    public static void m1833a(ViewGroup viewGroup, boolean z) {
        if (f1010a == null) {
            try {
                f1010a = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
            } catch (Throwable e) {
                Log.e("ViewCompat", "Unable to find childrenDrawingOrderEnabled", e);
            }
            f1010a.setAccessible(true);
        }
        try {
            f1010a.invoke(viewGroup, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e2) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e2);
        } catch (Throwable e22) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e22);
        } catch (Throwable e222) {
            Log.e("ViewCompat", "Unable to invoke childrenDrawingOrderEnabled", e222);
        }
    }
}
