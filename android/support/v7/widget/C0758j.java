package android.support.v7.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.CheckedTextView;
import android.widget.TextView;

public class C0758j extends CheckedTextView {
    private static final int[] f2282a = new int[]{16843016};
    private C0765l f2283b;
    private C0784x f2284c;

    public C0758j(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16843720);
    }

    public C0758j(Context context, AttributeSet attributeSet, int i) {
        super(av.m3729a(context), attributeSet, i);
        this.f2284c = C0784x.m3957a((TextView) this);
        this.f2284c.mo682a(attributeSet, i);
        this.f2284c.mo681a();
        this.f2283b = C0765l.m3902a();
        ay a = ay.m3733a(getContext(), attributeSet, f2282a, i, 0);
        setCheckMarkDrawable(a.m3736a(0));
        a.m3737a();
    }

    public void setCheckMarkDrawable(int i) {
        if (this.f2283b != null) {
            setCheckMarkDrawable(this.f2283b.m3925a(getContext(), i));
        } else {
            super.setCheckMarkDrawable(i);
        }
    }

    public void setTextAppearance(Context context, int i) {
        super.setTextAppearance(context, i);
        if (this.f2284c != null) {
            this.f2284c.m3959a(context, i);
        }
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f2284c != null) {
            this.f2284c.mo681a();
        }
    }
}
