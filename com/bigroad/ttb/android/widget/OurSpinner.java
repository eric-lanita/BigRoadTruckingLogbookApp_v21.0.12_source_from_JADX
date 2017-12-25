package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.support.v7.widget.C0783w;
import android.util.AttributeSet;
import android.view.View;

public class OurSpinner extends C0783w {
    private C1435a f8591a;
    private C1471b f8592b;

    public interface C1435a {
        void mo995a(int i);
    }

    public interface C1471b {
        boolean mo1006a(View view);
    }

    public OurSpinner(Context context) {
        super(context);
    }

    public OurSpinner(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OurSpinner(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public C1435a getOnUserSelectedListener() {
        return this.f8591a;
    }

    public void setOnUserSelectedListener(C1435a c1435a) {
        this.f8591a = c1435a;
    }

    public C1471b getOverrideClickListener() {
        return this.f8592b;
    }

    public void setOverrideClickListener(C1471b c1471b) {
        this.f8592b = c1471b;
    }

    public void setSelection(int i) {
        super.setSelection(i);
        if (this.f8591a != null) {
            this.f8591a.mo995a(i);
        }
    }

    public void setNonUserSelection(int i) {
        super.setSelection(i);
    }

    public boolean performClick() {
        if (this.f8592b == null || !this.f8592b.mo1006a(this)) {
            return super.performClick();
        }
        return true;
    }
}
