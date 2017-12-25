package android.support.v4.p002a.p003a;

import android.graphics.drawable.Drawable;
import android.util.Log;
import java.lang.reflect.Method;

class C0090f {
    private static Method f409a;
    private static boolean f410b;

    public static int m474a(Drawable drawable) {
        if (!f410b) {
            try {
                f409a = Drawable.class.getDeclaredMethod("getLayoutDirection", new Class[0]);
                f409a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to retrieve getLayoutDirection() method", e);
            }
            f410b = true;
        }
        if (f409a != null) {
            try {
                return ((Integer) f409a.invoke(drawable, new Object[0])).intValue();
            } catch (Throwable e2) {
                Log.i("DrawableCompatJellybeanMr1", "Failed to invoke getLayoutDirection() via reflection", e2);
                f409a = null;
            }
        }
        return -1;
    }
}
