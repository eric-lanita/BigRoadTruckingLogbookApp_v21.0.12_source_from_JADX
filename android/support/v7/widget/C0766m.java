package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

public class C0766m extends EditText implements ad {
    private C0765l f2307a;
    private C0755g f2308b;
    private C0784x f2309c;

    public C0766m(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.editTextStyle);
    }

    public C0766m(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        this.f2307a = C0765l.m3902a();
        this.f2308b = new C0755g(this, this.f2307a);
        this.f2308b.m3878a(attributeSet, i);
        this.f2309c = C0784x.m3957a((TextView) this);
        this.f2309c.mo682a(attributeSet, i);
        this.f2309c.mo681a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2308b != null) {
            this.f2308b.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2308b != null) {
            this.f2308b.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2308b != null) {
            this.f2308b.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2308b != null ? this.f2308b.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2308b != null) {
            this.f2308b.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2308b != null ? this.f2308b.m3879b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2308b != null) {
            this.f2308b.m3881c();
        }
        if (this.f2309c != null) {
            this.f2309c.mo681a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2309c != null) {
            this.f2309c.m3959a(context, i);
        }
    }
}
