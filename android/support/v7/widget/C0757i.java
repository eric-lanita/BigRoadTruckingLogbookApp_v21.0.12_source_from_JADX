package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.C0126a;
import android.support.v4.widget.C0552z;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.widget.CheckBox;

public class C0757i extends CheckBox implements C0552z {
    private C0765l f2280a;
    private C0759k f2281b;

    public C0757i(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.checkboxStyle);
    }

    public C0757i(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        this.f2280a = C0765l.m3902a();
        this.f2281b = new C0759k(this, this.f2280a);
        this.f2281b.m3886a(attributeSet, i);
    }

    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        if (this.f2281b != null) {
            this.f2281b.m3888c();
        }
    }

    public void setButtonDrawable(int i) {
        setButtonDrawable(this.f2280a != null ? this.f2280a.m3925a(getContext(), i) : C0126a.m582a(getContext(), i));
    }

    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        return this.f2281b != null ? this.f2281b.m3882a(compoundPaddingLeft) : compoundPaddingLeft;
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        if (this.f2281b != null) {
            this.f2281b.m3884a(colorStateList);
        }
    }

    public ColorStateList getSupportButtonTintList() {
        return this.f2281b != null ? this.f2281b.m3883a() : null;
    }

    public void setSupportButtonTintMode(Mode mode) {
        if (this.f2281b != null) {
            this.f2281b.m3885a(mode);
        }
    }

    public Mode getSupportButtonTintMode() {
        return this.f2281b != null ? this.f2281b.m3887b() : null;
    }
}
