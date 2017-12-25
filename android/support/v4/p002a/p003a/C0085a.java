package android.support.v4.p002a.p003a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;

public final class C0085a {
    static final C0077b f408a;

    interface C0077b {
        void mo54a(Drawable drawable);

        void mo55a(Drawable drawable, float f, float f2);

        void mo56a(Drawable drawable, int i);

        void mo57a(Drawable drawable, int i, int i2, int i3, int i4);

        void mo58a(Drawable drawable, ColorStateList colorStateList);

        void mo59a(Drawable drawable, Theme theme);

        void mo60a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme);

        void mo61a(Drawable drawable, Mode mode);

        void mo62a(Drawable drawable, boolean z);

        boolean mo63b(Drawable drawable);

        Drawable mo64c(Drawable drawable);

        int mo65d(Drawable drawable);

        int mo66e(Drawable drawable);

        boolean mo67f(Drawable drawable);

        ColorFilter mo68g(Drawable drawable);
    }

    static class C0078a implements C0077b {
        C0078a() {
        }

        public void mo54a(Drawable drawable) {
        }

        public void mo62a(Drawable drawable, boolean z) {
        }

        public boolean mo63b(Drawable drawable) {
            return false;
        }

        public void mo55a(Drawable drawable, float f, float f2) {
        }

        public void mo57a(Drawable drawable, int i, int i2, int i3, int i4) {
        }

        public void mo56a(Drawable drawable, int i) {
            C0087c.m467a(drawable, i);
        }

        public void mo58a(Drawable drawable, ColorStateList colorStateList) {
            C0087c.m468a(drawable, colorStateList);
        }

        public void mo61a(Drawable drawable, Mode mode) {
            C0087c.m470a(drawable, mode);
        }

        public Drawable mo64c(Drawable drawable) {
            return C0087c.m466a(drawable);
        }

        public int mo65d(Drawable drawable) {
            return 0;
        }

        public int mo66e(Drawable drawable) {
            return 0;
        }

        public void mo59a(Drawable drawable, Theme theme) {
        }

        public boolean mo67f(Drawable drawable) {
            return false;
        }

        public ColorFilter mo68g(Drawable drawable) {
            return null;
        }

        public void mo60a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0087c.m469a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class C0079c extends C0078a {
        C0079c() {
        }

        public Drawable mo64c(Drawable drawable) {
            return C0088d.m471a(drawable);
        }
    }

    static class C0080d extends C0079c {
        C0080d() {
        }

        public void mo54a(Drawable drawable) {
            C0089e.m472a(drawable);
        }

        public Drawable mo64c(Drawable drawable) {
            return C0089e.m473b(drawable);
        }
    }

    static class C0081e extends C0080d {
        C0081e() {
        }

        public int mo65d(Drawable drawable) {
            int a = C0090f.m474a(drawable);
            return a >= 0 ? a : 0;
        }
    }

    static class C0082f extends C0081e {
        C0082f() {
        }

        public void mo62a(Drawable drawable, boolean z) {
            C0091g.m475a(drawable, z);
        }

        public boolean mo63b(Drawable drawable) {
            return C0091g.m476a(drawable);
        }

        public Drawable mo64c(Drawable drawable) {
            return C0091g.m477b(drawable);
        }

        public int mo66e(Drawable drawable) {
            return C0091g.m478c(drawable);
        }
    }

    static class C0083g extends C0082f {
        C0083g() {
        }

        public void mo55a(Drawable drawable, float f, float f2) {
            C0092h.m480a(drawable, f, f2);
        }

        public void mo57a(Drawable drawable, int i, int i2, int i3, int i4) {
            C0092h.m482a(drawable, i, i2, i3, i4);
        }

        public void mo56a(Drawable drawable, int i) {
            C0092h.m481a(drawable, i);
        }

        public void mo58a(Drawable drawable, ColorStateList colorStateList) {
            C0092h.m483a(drawable, colorStateList);
        }

        public void mo61a(Drawable drawable, Mode mode) {
            C0092h.m486a(drawable, mode);
        }

        public Drawable mo64c(Drawable drawable) {
            return C0092h.m479a(drawable);
        }

        public void mo59a(Drawable drawable, Theme theme) {
            C0092h.m484a(drawable, theme);
        }

        public boolean mo67f(Drawable drawable) {
            return C0092h.m487b(drawable);
        }

        public ColorFilter mo68g(Drawable drawable) {
            return C0092h.m488c(drawable);
        }

        public void mo60a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
            C0092h.m485a(drawable, resources, xmlPullParser, attributeSet, theme);
        }
    }

    static class C0084h extends C0083g {
        C0084h() {
        }

        public int mo65d(Drawable drawable) {
            return C0086b.m465a(drawable);
        }

        public Drawable mo64c(Drawable drawable) {
            return drawable;
        }
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 23) {
            f408a = new C0084h();
        } else if (i >= 21) {
            f408a = new C0083g();
        } else if (i >= 19) {
            f408a = new C0082f();
        } else if (i >= 17) {
            f408a = new C0081e();
        } else if (i >= 11) {
            f408a = new C0080d();
        } else if (i >= 5) {
            f408a = new C0079c();
        } else {
            f408a = new C0078a();
        }
    }

    public static void m450a(Drawable drawable) {
        f408a.mo54a(drawable);
    }

    public static void m458a(Drawable drawable, boolean z) {
        f408a.mo62a(drawable, z);
    }

    public static boolean m459b(Drawable drawable) {
        return f408a.mo63b(drawable);
    }

    public static void m451a(Drawable drawable, float f, float f2) {
        f408a.mo55a(drawable, f, f2);
    }

    public static void m453a(Drawable drawable, int i, int i2, int i3, int i4) {
        f408a.mo57a(drawable, i, i2, i3, i4);
    }

    public static void m452a(Drawable drawable, int i) {
        f408a.mo56a(drawable, i);
    }

    public static void m454a(Drawable drawable, ColorStateList colorStateList) {
        f408a.mo58a(drawable, colorStateList);
    }

    public static void m457a(Drawable drawable, Mode mode) {
        f408a.mo61a(drawable, mode);
    }

    public static int m460c(Drawable drawable) {
        return f408a.mo66e(drawable);
    }

    public static void m455a(Drawable drawable, Theme theme) {
        f408a.mo59a(drawable, theme);
    }

    public static boolean m461d(Drawable drawable) {
        return f408a.mo67f(drawable);
    }

    public static ColorFilter m462e(Drawable drawable) {
        return f408a.mo68g(drawable);
    }

    public static void m456a(Drawable drawable, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Theme theme) {
        f408a.mo60a(drawable, resources, xmlPullParser, attributeSet, theme);
    }

    public static Drawable m463f(Drawable drawable) {
        return f408a.mo64c(drawable);
    }

    public static int m464g(Drawable drawable) {
        return f408a.mo65d(drawable);
    }
}
