package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class C0699f extends AutoCompleteTextView implements ad {
    private static final int[] f1920a = new int[]{16843126};
    private C0765l f1921b;
    private C0755g f1922c;
    private C0784x f1923d;

    public C0699f(Context context) {
        this(context, null);
    }

    public C0699f(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.autoCompleteTextViewStyle);
    }

    public C0699f(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        this.f1921b = C0765l.m3902a();
        ay a = ay.m3733a(getContext(), attributeSet, f1920a, i, 0);
        if (a.m3748f(0)) {
            setDropDownBackgroundDrawable(a.m3736a(0));
        }
        a.m3737a();
        this.f1922c = new C0755g(this, this.f1921b);
        this.f1922c.m3878a(attributeSet, i);
        this.f1923d = C0784x.m3957a((TextView) this);
        this.f1923d.mo682a(attributeSet, i);
        this.f1923d.mo681a();
    }

    public void setDropDownBackgroundResource(int i) {
        if (this.f1921b != null) {
            setDropDownBackgroundDrawable(this.f1921b.m3925a(getContext(), i));
        } else {
            super.setDropDownBackgroundResource(i);
        }
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1922c != null) {
            this.f1922c.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1922c != null) {
            this.f1922c.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1922c != null) {
            this.f1922c.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1922c != null ? this.f1922c.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1922c != null) {
            this.f1922c.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1922c != null ? this.f1922c.m3879b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1922c != null) {
            this.f1922c.m3881c();
        }
        if (this.f1923d != null) {
            this.f1923d.mo681a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1923d != null) {
            this.f1923d.m3959a(context, i);
        }
    }
}
