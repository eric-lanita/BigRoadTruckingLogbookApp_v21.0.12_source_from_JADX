package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.util.AttributeSet;
import android.widget.TextView;

public class C0654z extends TextView implements ad {
    private C0765l f1622a;
    private C0755g f1623b;
    private C0784x f1624c;

    public C0654z(Context context) {
        this(context, null);
    }

    public C0654z(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842884);
    }

    public C0654z(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        this.f1622a = C0765l.m3902a();
        this.f1623b = new C0755g(this, this.f1622a);
        this.f1623b.m3878a(attributeSet, i);
        this.f1624c = C0784x.m3957a((TextView) this);
        this.f1624c.mo682a(attributeSet, i);
        this.f1624c.mo681a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1623b != null) {
            this.f1623b.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1623b != null) {
            this.f1623b.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1623b != null) {
            this.f1623b.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1623b != null ? this.f1623b.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1623b != null) {
            this.f1623b.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1623b != null ? this.f1623b.m3879b() : null;
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f1624c != null) {
            this.f1624c.m3959a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1623b != null) {
            this.f1623b.m3881c();
        }
        if (this.f1624c != null) {
            this.f1624c.mo681a();
        }
    }
}
