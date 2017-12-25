package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.Space;
import android.widget.TextView;

public class TextWrappingLinearLayout extends LinearLayout {
    public TextWrappingLinearLayout(Context context) {
        super(context);
    }

    public TextWrappingLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextWrappingLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    private boolean m12038a(View view) {
        return view instanceof TextView;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int mode = MeasureSpec.getMode(i);
        MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        if (mode == 0) {
            i3 = Integer.MAX_VALUE;
        } else {
            i3 = size;
        }
        int i5 = 0;
        long j = 0;
        while (i5 < getChildCount()) {
            long j2;
            View childAt = getChildAt(i5);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (!m12038a(childAt) || childAt.getVisibility() == 8) {
                j2 = j;
            } else {
                if (!(layoutParams.width == -2 && layoutParams.weight == 0.0f)) {
                    ViewGroup.LayoutParams layoutParams2 = new LayoutParams(layoutParams);
                    layoutParams2.width = -2;
                    layoutParams2.weight = 0.0f;
                    childAt.setLayoutParams(layoutParams2);
                }
                measureChildWithMargins(childAt, i, 0, i2, 0);
                j2 = j + ((long) ((childAt.getMeasuredWidth() + layoutParams.leftMargin) + layoutParams.rightMargin));
            }
            i5++;
            j = j2;
        }
        Object obj = (((long) getPaddingRight()) + j) + ((long) getPaddingLeft()) > ((long) i3) ? 1 : null;
        if (obj != null) {
            i4 = 0;
            mode = 1;
        } else {
            i4 = -2;
            mode = 0;
        }
        for (int i6 = 0; i6 < getChildCount(); i6++) {
            View childAt2 = getChildAt(i6);
            LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
            if ((childAt2 instanceof Space) || (childAt2 instanceof android.support.v4.widget.Space)) {
                if (obj != null) {
                    size = 8;
                } else {
                    size = 0;
                }
                childAt2.setVisibility(size);
            } else if (childAt2 instanceof TextView) {
                ViewGroup.LayoutParams layoutParams4 = new LayoutParams(layoutParams3);
                layoutParams4.width = i4;
                layoutParams4.weight = (float) mode;
                childAt2.setLayoutParams(layoutParams4);
            }
        }
        super.onMeasure(i, i2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    protected boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    protected LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }
}
