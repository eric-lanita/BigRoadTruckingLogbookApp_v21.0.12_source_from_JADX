package android.support.v7.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.p015d.C0638a;
import android.text.method.PasswordTransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;

class C0784x {
    private static final int[] f2360b = new int[]{16842804, 16843119, 16843117, 16843120, 16843118};
    private static final int[] f2361c = new int[]{C0553a.textAllCaps};
    final TextView f2362a;
    private aw f2363d;
    private aw f2364e;
    private aw f2365f;
    private aw f2366g;

    static C0784x m3957a(TextView textView) {
        if (VERSION.SDK_INT >= 17) {
            return new C0785y(textView);
        }
        return new C0784x(textView);
    }

    C0784x(TextView textView) {
        this.f2362a = textView;
    }

    void mo682a(AttributeSet attributeSet, int i) {
        int i2 = 1;
        Context context = this.f2362a.getContext();
        C0765l a = C0765l.m3902a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2360b, i, 0);
        int resourceId = obtainStyledAttributes.getResourceId(0, -1);
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2363d = C0784x.m3956a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        if (obtainStyledAttributes.hasValue(2)) {
            this.f2364e = C0784x.m3956a(context, a, obtainStyledAttributes.getResourceId(2, 0));
        }
        if (obtainStyledAttributes.hasValue(3)) {
            this.f2365f = C0784x.m3956a(context, a, obtainStyledAttributes.getResourceId(3, 0));
        }
        if (obtainStyledAttributes.hasValue(4)) {
            this.f2366g = C0784x.m3956a(context, a, obtainStyledAttributes.getResourceId(4, 0));
        }
        obtainStyledAttributes.recycle();
        if (!(this.f2362a.getTransformationMethod() instanceof PasswordTransformationMethod)) {
            boolean z;
            int i3;
            boolean z2;
            if (resourceId != -1) {
                TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, C0563k.TextAppearance);
                if (obtainStyledAttributes2.hasValue(C0563k.TextAppearance_textAllCaps)) {
                    z = obtainStyledAttributes2.getBoolean(C0563k.TextAppearance_textAllCaps, false);
                    i3 = 1;
                } else {
                    z2 = false;
                    z = false;
                }
                obtainStyledAttributes2.recycle();
            } else {
                z2 = false;
                z = false;
            }
            TypedArray obtainStyledAttributes3 = context.obtainStyledAttributes(attributeSet, f2361c, i, 0);
            if (obtainStyledAttributes3.hasValue(0)) {
                z = obtainStyledAttributes3.getBoolean(0, false);
            } else {
                i2 = i3;
            }
            obtainStyledAttributes3.recycle();
            if (i2 != 0) {
                m3962a(z);
            }
        }
    }

    void m3959a(Context context, int i) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, f2361c);
        if (obtainStyledAttributes.hasValue(0)) {
            m3962a(obtainStyledAttributes.getBoolean(0, false));
        }
        obtainStyledAttributes.recycle();
    }

    void m3962a(boolean z) {
        this.f2362a.setTransformationMethod(z ? new C0638a(this.f2362a.getContext()) : null);
    }

    void mo681a() {
        if (this.f2363d != null || this.f2364e != null || this.f2365f != null || this.f2366g != null) {
            Drawable[] compoundDrawables = this.f2362a.getCompoundDrawables();
            m3960a(compoundDrawables[0], this.f2363d);
            m3960a(compoundDrawables[1], this.f2364e);
            m3960a(compoundDrawables[2], this.f2365f);
            m3960a(compoundDrawables[3], this.f2366g);
        }
    }

    final void m3960a(Drawable drawable, aw awVar) {
        if (drawable != null && awVar != null) {
            C0765l.m3905a(drawable, awVar, this.f2362a.getDrawableState());
        }
    }

    protected static aw m3956a(Context context, C0765l c0765l, int i) {
        ColorStateList b = c0765l.m3928b(context, i);
        if (b == null) {
            return null;
        }
        aw awVar = new aw();
        awVar.f2187d = true;
        awVar.f2184a = b;
        return awVar;
    }
}
