package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.util.AttributeSet;
import android.widget.ImageView;

public class AppCompatImageView extends ImageView implements ad {
    private C0755g f1902a;
    private C0768o f1903b;

    public AppCompatImageView(Context context) {
        this(context, null);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AppCompatImageView(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        C0765l a = C0765l.m3902a();
        this.f1902a = new C0755g(this, a);
        this.f1902a.m3878a(attributeSet, i);
        this.f1903b = new C0768o(this, a);
        this.f1903b.m3930a(attributeSet, i);
    }

    public void setImageResource(int i) {
        this.f1903b.m3929a(i);
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f1902a != null) {
            this.f1902a.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f1902a != null) {
            this.f1902a.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f1902a != null) {
            this.f1902a.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f1902a != null ? this.f1902a.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f1902a != null) {
            this.f1902a.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f1902a != null ? this.f1902a.m3879b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1902a != null) {
            this.f1902a.m3881c();
        }
    }
}
