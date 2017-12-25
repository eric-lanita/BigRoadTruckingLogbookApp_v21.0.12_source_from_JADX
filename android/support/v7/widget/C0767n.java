package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.widget.ImageButton;

public class C0767n extends ImageButton implements ad {
    private C0755g f2310a;
    private C0768o f2311b;

    public C0767n(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.imageButtonStyle);
    }

    public C0767n(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        C0765l a = C0765l.m3902a();
        this.f2310a = new C0755g(this, a);
        this.f2310a.m3878a(attributeSet, i);
        this.f2311b = new C0768o(this, a);
        this.f2311b.m3930a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f2311b.m3929a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2310a != null) {
            this.f2310a.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2310a != null) {
            this.f2310a.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2310a != null) {
            this.f2310a.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2310a != null ? this.f2310a.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2310a != null) {
            this.f2310a.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2310a != null ? this.f2310a.m3879b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2310a != null) {
            this.f2310a.m3881c();
        }
    }
}
