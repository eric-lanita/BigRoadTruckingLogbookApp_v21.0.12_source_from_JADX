package android.support.v4.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.View;

class C0452j {

    static class C0451a implements Factory {
        final C0210m f1045a;

        C0451a(C0210m c0210m) {
            this.f1045a = c0210m;
        }

        public View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return this.f1045a.mo151a(null, str, context, attributeSet);
        }

        public String toString() {
            return getClass().getName() + "{" + this.f1045a + "}";
        }
    }

    static void m2071a(LayoutInflater layoutInflater, C0210m c0210m) {
        layoutInflater.setFactory(c0210m != null ? new C0451a(c0210m) : null);
    }

    static C0210m m2070a(LayoutInflater layoutInflater) {
        Factory factory = layoutInflater.getFactory();
        if (factory instanceof C0451a) {
            return ((C0451a) factory).f1045a;
        }
        return null;
    }
}
