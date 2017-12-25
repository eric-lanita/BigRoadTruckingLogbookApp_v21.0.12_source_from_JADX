package android.support.v4.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.widget.CompoundButton;

public final class C0507c {
    private static final C0503c f1197a;

    interface C0503c {
        Drawable mo372a(CompoundButton compoundButton);

        void mo373a(CompoundButton compoundButton, ColorStateList colorStateList);

        void mo374a(CompoundButton compoundButton, Mode mode);
    }

    static class C0504b implements C0503c {
        C0504b() {
        }

        public void mo373a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0509e.m2357a(compoundButton, colorStateList);
        }

        public void mo374a(CompoundButton compoundButton, Mode mode) {
            C0509e.m2358a(compoundButton, mode);
        }

        public Drawable mo372a(CompoundButton compoundButton) {
            return C0509e.m2356a(compoundButton);
        }
    }

    static class C0505d extends C0504b {
        C0505d() {
        }

        public void mo373a(CompoundButton compoundButton, ColorStateList colorStateList) {
            C0510f.m2359a(compoundButton, colorStateList);
        }

        public void mo374a(CompoundButton compoundButton, Mode mode) {
            C0510f.m2360a(compoundButton, mode);
        }
    }

    static class C0506a extends C0505d {
        C0506a() {
        }

        public Drawable mo372a(CompoundButton compoundButton) {
            return C0508d.m2355a(compoundButton);
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f1197a = new C0506a();
        } else if (i >= 21) {
            f1197a = new C0505d();
        } else {
            f1197a = new C0504b();
        }
    }

    public static void m2353a(CompoundButton compoundButton, ColorStateList colorStateList) {
        f1197a.mo373a(compoundButton, colorStateList);
    }

    public static void m2354a(CompoundButton compoundButton, Mode mode) {
        f1197a.mo374a(compoundButton, mode);
    }

    public static Drawable m2352a(CompoundButton compoundButton) {
        return f1197a.mo372a(compoundButton);
    }
}
