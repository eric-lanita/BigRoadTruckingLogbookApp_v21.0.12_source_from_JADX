package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ai.C0600a;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class FitWindowsLinearLayout extends LinearLayout implements ai {
    private C0600a f1918a;

    public FitWindowsLinearLayout(Context context) {
        super(context);
    }

    public FitWindowsLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0600a c0600a) {
        this.f1918a = c0600a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1918a != null) {
            this.f1918a.mo468a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
