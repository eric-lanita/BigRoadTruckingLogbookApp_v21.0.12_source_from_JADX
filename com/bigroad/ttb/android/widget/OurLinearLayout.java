package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.LinearLayout;
import com.bigroad.ttb.android.C2476z.C2475a;

public class OurLinearLayout extends LinearLayout {
    private int f8587a = 0;
    private int f8588b = 0;
    private boolean f8589c = true;
    private boolean f8590d = true;

    public OurLinearLayout(Context context) {
        super(context);
    }

    public OurLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.OurLinearLayout);
        this.f8587a = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f8588b = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        this.f8589c = obtainStyledAttributes.getBoolean(2, true);
        this.f8590d = obtainStyledAttributes.getBoolean(3, true);
        obtainStyledAttributes.recycle();
    }

    public void setMaxWidth(int i) {
        this.f8587a = i;
    }

    public void setMaxHeight(int i) {
        this.f8588b = i;
    }

    private int m11987a(int i, int i2) {
        if (i2 <= 0) {
            return i;
        }
        int mode = MeasureSpec.getMode(i);
        if (mode == 0) {
            return MeasureSpec.makeMeasureSpec(i2, Integer.MIN_VALUE);
        }
        return MeasureSpec.makeMeasureSpec(Math.min(MeasureSpec.getSize(i), i2), mode);
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(m11987a(i, this.f8587a), m11987a(i2, this.f8588b));
    }

    protected void dispatchSetPressed(boolean z) {
        if (this.f8589c) {
            super.dispatchSetPressed(z);
        }
    }

    public void dispatchSetSelected(boolean z) {
        if (this.f8590d) {
            super.dispatchSetSelected(z);
        }
    }
}
