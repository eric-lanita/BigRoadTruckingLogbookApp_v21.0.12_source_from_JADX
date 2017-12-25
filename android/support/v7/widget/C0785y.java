package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

class C0785y extends C0784x {
    private static final int[] f2367b = new int[]{16843666, 16843667};
    private aw f2368c;
    private aw f2369d;

    C0785y(TextView textView) {
        super(textView);
    }

    void mo682a(AttributeSet attributeSet, int i) {
        super.mo682a(attributeSet, i);
        Context context = this.a.getContext();
        C0765l a = C0765l.m3902a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2367b, i, 0);
        if (obtainStyledAttributes.hasValue(0)) {
            this.f2368c = C0784x.m3956a(context, a, obtainStyledAttributes.getResourceId(0, 0));
        }
        if (obtainStyledAttributes.hasValue(1)) {
            this.f2369d = C0784x.m3956a(context, a, obtainStyledAttributes.getResourceId(1, 0));
        }
        obtainStyledAttributes.recycle();
    }

    void mo681a() {
        super.mo681a();
        if (this.f2368c != null || this.f2369d != null) {
            Drawable[] compoundDrawablesRelative = this.a.getCompoundDrawablesRelative();
            m3960a(compoundDrawablesRelative[0], this.f2368c);
            m3960a(compoundDrawablesRelative[2], this.f2369d);
        }
    }
}
