package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.view.View;

class C0755g {
    private final View f2272a;
    private final C0765l f2273b;
    private aw f2274c;
    private aw f2275d;
    private aw f2276e;

    C0755g(View view, C0765l c0765l) {
        this.f2272a = view;
        this.f2273b = c0765l;
    }

    void m3878a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2272a.getContext().obtainStyledAttributes(attributeSet, C0563k.ViewBackgroundHelper, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0563k.ViewBackgroundHelper_android_background)) {
                ColorStateList b = this.f2273b.m3928b(this.f2272a.getContext(), obtainStyledAttributes.getResourceId(C0563k.ViewBackgroundHelper_android_background, -1));
                if (b != null) {
                    m3880b(b);
                }
            }
            if (obtainStyledAttributes.hasValue(C0563k.ViewBackgroundHelper_backgroundTint)) {
                ag.m1783a(this.f2272a, obtainStyledAttributes.getColorStateList(C0563k.ViewBackgroundHelper_backgroundTint));
            }
            if (obtainStyledAttributes.hasValue(C0563k.ViewBackgroundHelper_backgroundTintMode)) {
                ag.m1784a(this.f2272a, ah.m3592a(obtainStyledAttributes.getInt(C0563k.ViewBackgroundHelper_backgroundTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void m3874a(int i) {
        m3880b(this.f2273b != null ? this.f2273b.m3928b(this.f2272a.getContext(), i) : null);
    }

    void m3877a(Drawable drawable) {
        m3880b(null);
    }

    void m3875a(ColorStateList colorStateList) {
        if (this.f2275d == null) {
            this.f2275d = new aw();
        }
        this.f2275d.f2184a = colorStateList;
        this.f2275d.f2187d = true;
        m3881c();
    }

    ColorStateList m3873a() {
        return this.f2275d != null ? this.f2275d.f2184a : null;
    }

    void m3876a(Mode mode) {
        if (this.f2275d == null) {
            this.f2275d = new aw();
        }
        this.f2275d.f2185b = mode;
        this.f2275d.f2186c = true;
        m3881c();
    }

    Mode m3879b() {
        return this.f2275d != null ? this.f2275d.f2185b : null;
    }

    void m3881c() {
        Drawable background = this.f2272a.getBackground();
        if (background == null) {
            return;
        }
        if (VERSION.SDK_INT != 21 || !m3872b(background)) {
            if (this.f2275d != null) {
                C0765l.m3905a(background, this.f2275d, this.f2272a.getDrawableState());
            } else if (this.f2274c != null) {
                C0765l.m3905a(background, this.f2274c, this.f2272a.getDrawableState());
            }
        }
    }

    void m3880b(ColorStateList colorStateList) {
        if (colorStateList != null) {
            if (this.f2274c == null) {
                this.f2274c = new aw();
            }
            this.f2274c.f2184a = colorStateList;
            this.f2274c.f2187d = true;
        } else {
            this.f2274c = null;
        }
        m3881c();
    }

    private boolean m3872b(Drawable drawable) {
        if (this.f2276e == null) {
            this.f2276e = new aw();
        }
        aw awVar = this.f2276e;
        awVar.m3731a();
        ColorStateList q = ag.m1817q(this.f2272a);
        if (q != null) {
            awVar.f2187d = true;
            awVar.f2184a = q;
        }
        Mode r = ag.m1818r(this.f2272a);
        if (r != null) {
            awVar.f2186c = true;
            awVar.f2185b = r;
        }
        if (!awVar.f2187d && !awVar.f2186c) {
            return false;
        }
        C0765l.m3905a(drawable, awVar, this.f2272a.getDrawableState());
        return true;
    }
}
