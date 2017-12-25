package android.support.v4.view;

import android.content.Context;
import android.support.v4.view.C0452j.C0451a;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.LayoutInflater.Factory2;
import android.view.View;
import java.lang.reflect.Field;

class C0454k {
    private static Field f1046a;
    private static boolean f1047b;

    static class C0453a extends C0451a implements Factory2 {
        C0453a(C0210m c0210m) {
            super(c0210m);
        }

        public View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
            return this.a.mo151a(view, str, context, attributeSet);
        }
    }

    static void m2072a(LayoutInflater layoutInflater, C0210m c0210m) {
        Factory2 c0453a;
        if (c0210m != null) {
            c0453a = new C0453a(c0210m);
        } else {
            c0453a = null;
        }
        layoutInflater.setFactory2(c0453a);
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof Factory2) {
            C0454k.m2073a(layoutInflater, (Factory2) factory);
        } else {
            C0454k.m2073a(layoutInflater, c0453a);
        }
    }

    static void m2073a(LayoutInflater layoutInflater, Factory2 factory2) {
        if (!f1047b) {
            try {
                f1046a = LayoutInflater.class.getDeclaredField("mFactory2");
                f1046a.setAccessible(true);
            } catch (Throwable e) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 Could not find field 'mFactory2' on class " + LayoutInflater.class.getName() + "; inflation may have unexpected results.", e);
            }
            f1047b = true;
        }
        if (f1046a != null) {
            try {
                f1046a.set(layoutInflater, factory2);
            } catch (Throwable e2) {
                Log.e("LayoutInflaterCompatHC", "forceSetFactory2 could not set the Factory2 on LayoutInflater " + layoutInflater + "; inflation may have unexpected results.", e2);
            }
        }
    }
}
