package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.C0474s;
import android.support.v4.view.ag;
import android.support.v4.view.ax;
import android.support.v4.view.bb;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;

abstract class C0684a extends ViewGroup {
    protected final C0712a f1791a;
    protected final Context f1792b;
    protected ActionMenuView f1793c;
    protected C0747d f1794d;
    protected int f1795e;
    protected ax f1796f;
    private boolean f1797g;
    private boolean f1798h;

    protected class C0712a implements bb {
        int f2023a;
        final /* synthetic */ C0684a f2024b;
        private boolean f2025c = false;

        protected C0712a(C0684a c0684a) {
            this.f2024b = c0684a;
        }

        public C0712a m3510a(ax axVar, int i) {
            this.f2024b.f1796f = axVar;
            this.f2023a = i;
            return this;
        }

        public void mo326a(View view) {
            super.setVisibility(0);
            this.f2025c = false;
        }

        public void mo327b(View view) {
            if (!this.f2025c) {
                this.f2024b.f1796f = null;
                super.setVisibility(this.f2023a);
            }
        }

        public void mo328c(View view) {
            this.f2025c = true;
        }
    }

    C0684a(Context context) {
        this(context, null);
    }

    C0684a(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    C0684a(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1791a = new C0712a(this);
        TypedValue typedValue = new TypedValue();
        if (!context.getTheme().resolveAttribute(C0553a.actionBarPopupTheme, typedValue, true) || typedValue.resourceId == 0) {
            this.f1792b = context;
        } else {
            this.f1792b = new ContextThemeWrapper(context, typedValue.resourceId);
        }
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(null, C0563k.ActionBar, C0553a.actionBarStyle, 0);
        setContentHeight(obtainStyledAttributes.getLayoutDimension(C0563k.ActionBar_height, 0));
        obtainStyledAttributes.recycle();
        if (this.f1794d != null) {
            this.f1794d.m3830a(configuration);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0474s.m2141a(motionEvent);
        if (a == 0) {
            this.f1797g = false;
        }
        if (!this.f1797g) {
            boolean onTouchEvent = super.onTouchEvent(motionEvent);
            if (a == 0 && !onTouchEvent) {
                this.f1797g = true;
            }
        }
        if (a == 1 || a == 3) {
            this.f1797g = false;
        }
        return true;
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        int a = C0474s.m2141a(motionEvent);
        if (a == 9) {
            this.f1798h = false;
        }
        if (!this.f1798h) {
            boolean onHoverEvent = super.onHoverEvent(motionEvent);
            if (a == 9 && !onHoverEvent) {
                this.f1798h = true;
            }
        }
        if (a == 10 || a == 3) {
            this.f1798h = false;
        }
        return true;
    }

    public void setContentHeight(int i) {
        this.f1795e = i;
        requestLayout();
    }

    public int getContentHeight() {
        return this.f1795e;
    }

    public int getAnimatedVisibility() {
        if (this.f1796f != null) {
            return this.f1791a.f2023a;
        }
        return getVisibility();
    }

    public ax mo571a(int i, long j) {
        if (this.f1796f != null) {
            this.f1796f.m1988b();
        }
        if (i == 0) {
            if (getVisibility() != 0) {
                ag.m1794b((View) this, 0.0f);
            }
            ax a = ag.m1810j(this).m1981a(1.0f);
            a.m1982a(j);
            a.m1983a(this.f1791a.m3510a(a, i));
            return a;
        }
        a = ag.m1810j(this).m1981a(0.0f);
        a.m1982a(j);
        a.m1983a(this.f1791a.m3510a(a, i));
        return a;
    }

    public void setVisibility(int i) {
        if (i != getVisibility()) {
            if (this.f1796f != null) {
                this.f1796f.m1988b();
            }
            super.setVisibility(i);
        }
    }

    public boolean mo572a() {
        if (this.f1794d != null) {
            return this.f1794d.m3844d();
        }
        return false;
    }

    protected int m3278a(View view, int i, int i2, int i3) {
        view.measure(MeasureSpec.makeMeasureSpec(i, Integer.MIN_VALUE), i2);
        return Math.max(0, (i - view.getMeasuredWidth()) - i3);
    }

    protected static int m3275a(int i, int i2, boolean z) {
        return z ? i - i2 : i + i2;
    }

    protected int m3279a(View view, int i, int i2, int i3, boolean z) {
        int measuredWidth = view.getMeasuredWidth();
        int measuredHeight = view.getMeasuredHeight();
        int i4 = ((i3 - measuredHeight) / 2) + i2;
        if (z) {
            view.layout(i - measuredWidth, i4, i, measuredHeight + i4);
        } else {
            view.layout(i, i4, i + measuredWidth, measuredHeight + i4);
        }
        return z ? -measuredWidth : measuredWidth;
    }
}
