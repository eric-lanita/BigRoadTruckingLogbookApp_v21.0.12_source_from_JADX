package android.support.v7.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0553a;
import android.util.AttributeSet;
import android.widget.RatingBar;

public class C0774t extends RatingBar {
    private C0772r f2329a;
    private C0765l f2330b;

    public C0774t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.ratingBarStyle);
    }

    public C0774t(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f2330b = C0765l.m3902a();
        this.f2329a = new C0772r(this, this.f2330b);
        this.f2329a.mo676a(attributeSet, i);
    }

    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        Bitmap a = this.f2329a.m3936a();
        if (a != null) {
            setMeasuredDimension(ag.m1777a(a.getWidth() * getNumStars(), i, 0), getMeasuredHeight());
        }
    }
}
