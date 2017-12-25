package android.support.v4.app;

import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class C0198m {
    private static Method f657a;
    private static boolean f658b;

    public static void m863a(Bundle bundle, String str, IBinder iBinder) {
        if (!f658b) {
            try {
                f657a = Bundle.class.getMethod("putIBinder", new Class[]{String.class, IBinder.class});
                f657a.setAccessible(true);
            } catch (Throwable e) {
                Throwable e2;
                Log.i("BundleCompatDonut", "Failed to retrieve putIBinder method", e2);
            }
            f658b = true;
        }
        if (f657a != null) {
            try {
                f657a.invoke(bundle, new Object[]{str, iBinder});
                return;
            } catch (InvocationTargetException e3) {
                e2 = e3;
            } catch (IllegalAccessException e4) {
                e2 = e4;
            } catch (IllegalArgumentException e5) {
                e2 = e5;
            }
        } else {
            return;
        }
        Log.i("BundleCompatDonut", "Failed to invoke putIBinder via reflection", e2);
        f657a = null;
    }
}
