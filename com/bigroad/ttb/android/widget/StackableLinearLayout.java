package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.bigroad.ttb.android.C2476z.C2475a;

public class StackableLinearLayout extends LinearLayout {
    private int f8664a;
    private boolean f8665b = false;

    public StackableLinearLayout(Context context) {
        super(context);
    }

    public StackableLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.StackableLinearLayout);
        this.f8664a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public StackableLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C2475a.StackableLinearLayout);
        this.f8664a = obtainStyledAttributes.getInt(0, 0);
        obtainStyledAttributes.recycle();
    }

    public void setStackRotation(int i) {
        if (this.f8664a != i) {
            this.f8664a = i;
        }
    }

    public int getStackRotation() {
        return this.f8664a;
    }

    private boolean m12037a(View view) {
        return (view instanceof TextView) || (view instanceof ViewGroup);
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        int mode = MeasureSpec.getMode(i);
        MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        MeasureSpec.getSize(i2);
        if (mode == 0) {
            i3 = Integer.MAX_VALUE;
        } else {
            i3 = size;
        }
        int i4 = 0;
        long j = 0;
        while (i4 < getChildCount()) {
            long j2;
            View childAt = getChildAt(i4);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            if (!m12037a(childAt) || childAt.getVisibility() == 8) {
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
            i4++;
            j = j2;
        }
        if ((((long) getPaddingRight()) + j) + ((long) getPaddingLeft()) > ((long) i3)) {
            setOrientation(1);
            this.f8665b = true;
            mode = -1;
        } else {
            setOrientation(0);
            this.f8665b = false;
            mode = -2;
        }
        for (int i5 = 0; i5 < getChildCount(); i5++) {
            View childAt2 = getChildAt(i5);
            LayoutParams layoutParams3 = (LayoutParams) childAt2.getLayoutParams();
            ViewGroup.LayoutParams layoutParams4 = new LayoutParams(layoutParams3);
            layoutParams4.width = mode;
            layoutParams4.gravity = layoutParams3.gravity;
            layoutParams4.weight = layoutParams3.weight;
            childAt2.setLayoutParams(layoutParams4);
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

    public View getChildAt(int i) {
        if (this.f8665b && 1 == getStackRotation()) {
            i = (getChildCount() - i) - 1;
        }
        return super.getChildAt(i);
    }
}
