package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.CompoundButton;
import java.lang.reflect.Field;

class C0509e {
    private static Field f1198a;
    private static boolean f1199b;

    static void m2357a(CompoundButton compoundButton, ColorStateList colorStateList) {
        if (compoundButton instanceof C0552z) {
            ((C0552z) compoundButton).setSupportButtonTintList(colorStateList);
        }
    }

    static void m2358a(CompoundButton compoundButton, Mode mode) {
        if (compoundButton instanceof C0552z) {
            ((C0552z) compoundButton).setSupportButtonTintMode(mode);
        }
    }

    static Drawable m2356a(CompoundButton compoundButton) {
        if (!f1199b) {
            try {
                f1198a = CompoundButton.class.getDeclaredField("mButtonDrawable");
                f1198a.setAccessible(true);
            } catch (Throwable e) {
                Log.i("CompoundButtonCompatDonut", "Failed to retrieve mButtonDrawable field", e);
            }
            f1199b = true;
        }
        if (f1198a != null) {
            try {
                return (Drawable) f1198a.get(compoundButton);
            } catch (Throwable e2) {
                Log.i("CompoundButtonCompatDonut", "Failed to get button drawable via reflection", e2);
                f1198a = null;
            }
        }
        return null;
    }
}
