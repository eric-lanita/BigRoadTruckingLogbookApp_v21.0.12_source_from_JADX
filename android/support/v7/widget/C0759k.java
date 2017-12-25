package android.support.v7.widget;

import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v4.widget.C0507c;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.widget.CompoundButton;

class C0759k {
    private final CompoundButton f2285a;
    private final C0765l f2286b;
    private ColorStateList f2287c = null;
    private Mode f2288d = null;
    private boolean f2289e = false;
    private boolean f2290f = false;
    private boolean f2291g;

    C0759k(CompoundButton compoundButton, C0765l c0765l) {
        this.f2285a = compoundButton;
        this.f2286b = c0765l;
    }

    void m3886a(AttributeSet attributeSet, int i) {
        TypedArray obtainStyledAttributes = this.f2285a.getContext().obtainStyledAttributes(attributeSet, C0563k.CompoundButton, i, 0);
        try {
            if (obtainStyledAttributes.hasValue(C0563k.CompoundButton_android_button)) {
                int resourceId = obtainStyledAttributes.getResourceId(C0563k.CompoundButton_android_button, 0);
                if (resourceId != 0) {
                    this.f2285a.setButtonDrawable(this.f2286b.m3925a(this.f2285a.getContext(), resourceId));
                }
            }
            if (obtainStyledAttributes.hasValue(C0563k.CompoundButton_buttonTint)) {
                C0507c.m2353a(this.f2285a, obtainStyledAttributes.getColorStateList(C0563k.CompoundButton_buttonTint));
            }
            if (obtainStyledAttributes.hasValue(C0563k.CompoundButton_buttonTintMode)) {
                C0507c.m2354a(this.f2285a, ah.m3592a(obtainStyledAttributes.getInt(C0563k.CompoundButton_buttonTintMode, -1), null));
            }
            obtainStyledAttributes.recycle();
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
        }
    }

    void m3884a(ColorStateList colorStateList) {
        this.f2287c = colorStateList;
        this.f2289e = true;
        m3889d();
    }

    ColorStateList m3883a() {
        return this.f2287c;
    }

    void m3885a(Mode mode) {
        this.f2288d = mode;
        this.f2290f = true;
        m3889d();
    }

    Mode m3887b() {
        return this.f2288d;
    }

    void m3888c() {
        if (this.f2291g) {
            this.f2291g = false;
            return;
        }
        this.f2291g = true;
        m3889d();
    }

    void m3889d() {
        Drawable a = C0507c.m2352a(this.f2285a);
        if (a == null) {
            return;
        }
        if (this.f2289e || this.f2290f) {
            a = C0085a.m463f(a).mutate();
            if (this.f2289e) {
                C0085a.m454a(a, this.f2287c);
            }
            if (this.f2290f) {
                C0085a.m457a(a, this.f2288d);
            }
            if (a.isStateful()) {
                a.setState(this.f2285a.getDrawableState());
            }
            this.f2285a.setButtonDrawable(a);
        }
    }

    int m3882a(int i) {
        if (VERSION.SDK_INT >= 17) {
            return i;
        }
        Drawable a = C0507c.m2352a(this.f2285a);
        if (a != null) {
            return i + a.getIntrinsicWidth();
        }
        return i;
    }
}
