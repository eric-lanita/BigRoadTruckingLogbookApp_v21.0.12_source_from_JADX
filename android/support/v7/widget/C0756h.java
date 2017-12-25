package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ad;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import android.widget.TextView;

public class C0756h extends Button implements ad {
    private final C0765l f2277a;
    private final C0755g f2278b;
    private final C0784x f2279c;

    public C0756h(Context context) {
        this(context, null);
    }

    public C0756h(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.buttonStyle);
    }

    public C0756h(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        this.f2277a = C0765l.m3902a();
        this.f2278b = new C0755g(this, this.f2277a);
        this.f2278b.m3878a(attributeSet, i);
        this.f2279c = C0784x.m3957a((TextView) this);
        this.f2279c.mo682a(attributeSet, i);
        this.f2279c.mo681a();
    }

    public void setBackgroundResource(int i) {
        super.setBackgroundResource(i);
        if (this.f2278b != null) {
            this.f2278b.m3874a(i);
        }
    }

    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        if (this.f2278b != null) {
            this.f2278b.m3877a(drawable);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        if (this.f2278b != null) {
            this.f2278b.m3875a(colorStateList);
        }
    }

    public ColorStateList getSupportBackgroundTintList() {
        return this.f2278b != null ? this.f2278b.m3873a() : null;
    }

    public void setSupportBackgroundTintMode(Mode mode) {
        if (this.f2278b != null) {
            this.f2278b.m3876a(mode);
        }
    }

    public Mode getSupportBackgroundTintMode() {
        return this.f2278b != null ? this.f2278b.m3879b() : null;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2278b != null) {
            this.f2278b.m3881c();
        }
        if (this.f2279c != null) {
            this.f2279c.mo681a();
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2279c != null) {
            this.f2279c.m3959a(context, i);
        }
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    public void setSupportAllCaps(boolean z) {
        if (this.f2279c != null) {
            this.f2279c.m3962a(z);
        }
    }
}
