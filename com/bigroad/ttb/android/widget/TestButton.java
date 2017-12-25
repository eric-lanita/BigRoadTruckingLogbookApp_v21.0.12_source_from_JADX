package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.support.v7.widget.C0756h;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import com.bigroad.ttb.android.logging.C2134e;

public class TestButton extends C0756h {
    public TestButton(Context context) {
        super(context);
    }

    public TestButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TestButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C2134e.m10676b("TT-Button", "LAYOUT(" + getText() + "): (" + i + "," + i2 + ") - (" + i3 + "," + i4 + ") width=" + (i3 - i) + "; height=" + (i4 - i2));
        super.onLayout(z, i, i2, i3, i4);
    }

    protected void onMeasure(int i, int i2) {
        C2134e.m10676b("TT-Button", "MEASURE(" + getText() + "): Width: " + MeasureSpec.toString(i) + "; Height: " + MeasureSpec.toString(i2));
        super.onMeasure(i, i2);
    }
}
