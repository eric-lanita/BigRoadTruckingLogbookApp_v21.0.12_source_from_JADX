package com.bigroad.ttb.android.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.C0699f;
import android.util.AttributeSet;
import android.widget.Filterable;
import android.widget.ListAdapter;
import com.bigroad.shared.am;
import com.bigroad.ttb.android.util.C2291k;
import com.bigroad.ttb.android.util.ac;

public class InstantAutoComplete extends C0699f {
    private boolean f8573a = false;
    private boolean f8574b = false;

    public InstantAutoComplete(Context context) {
        super(context);
        m11974a(context);
    }

    public InstantAutoComplete(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11974a(context);
    }

    public InstantAutoComplete(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11974a(context);
    }

    private void m11974a(Context context) {
        if (C2291k.m11225d() <= 10) {
            setTextColor(ac.m11172a(context));
        }
    }

    public boolean enoughToFilter() {
        return true;
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f8573a = true;
        if (this.f8574b) {
            performFiltering(getText(), 0);
            showDropDown();
            this.f8574b = false;
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f8573a = false;
    }

    public <T extends ListAdapter & Filterable> void setAdapter(T t) {
        super.setAdapter(t);
        if (isFocused() && this.f8573a && am.m4188a(getText())) {
            showDropDown();
        }
    }

    protected void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (isFocused() && this.f8573a) {
            showDropDown();
        }
    }

    protected void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (!z || !am.m4188a(getText())) {
            return;
        }
        if (this.f8573a) {
            performFiltering(getText(), 0);
            showDropDown();
            return;
        }
        this.f8574b = true;
    }
}
