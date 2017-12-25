package android.support.v7.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v7.widget.ai.C0600a;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class FitWindowsFrameLayout extends FrameLayout implements ai {
    private C0600a f1917a;

    public FitWindowsFrameLayout(Context context) {
        super(context);
    }

    public FitWindowsFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void setOnFitSystemWindowsListener(C0600a c0600a) {
        this.f1917a = c0600a;
    }

    protected boolean fitSystemWindows(Rect rect) {
        if (this.f1917a != null) {
            this.f1917a.mo468a(rect);
        }
        return super.fitSystemWindows(rect);
    }
}
