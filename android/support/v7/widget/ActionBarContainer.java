package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

public class ActionBarContainer extends FrameLayout {
    Drawable f1779a;
    Drawable f1780b;
    Drawable f1781c;
    boolean f1782d;
    boolean f1783e;
    private boolean f1784f;
    private View f1785g;
    private View f1786h;
    private View f1787i;
    private int f1788j;

    public ActionBarContainer(Context context) {
        this(context, null);
    }

    public ActionBarContainer(Context context, AttributeSet attributeSet) {
        Drawable c0738c;
        super(context, attributeSet);
        if (VERSION.SDK_INT >= 21) {
            c0738c = new C0738c(this);
        } else {
            c0738c = new C0737b(this);
        }
        setBackgroundDrawable(c0738c);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.ActionBar);
        this.f1779a = obtainStyledAttributes.getDrawable(C0563k.ActionBar_background);
        this.f1780b = obtainStyledAttributes.getDrawable(C0563k.ActionBar_backgroundStacked);
        this.f1788j = obtainStyledAttributes.getDimensionPixelSize(C0563k.ActionBar_height, -1);
        if (getId() == C0558f.split_action_bar) {
            this.f1782d = true;
            this.f1781c = obtainStyledAttributes.getDrawable(C0563k.ActionBar_backgroundSplit);
        }
        obtainStyledAttributes.recycle();
        boolean z = this.f1782d ? this.f1781c == null : this.f1779a == null && this.f1780b == null;
        setWillNotDraw(z);
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f1786h = findViewById(C0558f.action_bar);
        this.f1787i = findViewById(C0558f.action_context_bar);
    }

    public void setPrimaryBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1779a != null) {
            this.f1779a.setCallback(null);
            unscheduleDrawable(this.f1779a);
        }
        this.f1779a = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1786h != null) {
                this.f1779a.setBounds(this.f1786h.getLeft(), this.f1786h.getTop(), this.f1786h.getRight(), this.f1786h.getBottom());
            }
        }
        if (this.f1782d) {
            if (this.f1781c != null) {
                z = false;
            }
        } else if (!(this.f1779a == null && this.f1780b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setStackedBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1780b != null) {
            this.f1780b.setCallback(null);
            unscheduleDrawable(this.f1780b);
        }
        this.f1780b = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1783e && this.f1780b != null) {
                this.f1780b.setBounds(this.f1785g.getLeft(), this.f1785g.getTop(), this.f1785g.getRight(), this.f1785g.getBottom());
            }
        }
        if (this.f1782d) {
            if (this.f1781c != null) {
                z = false;
            }
        } else if (!(this.f1779a == null && this.f1780b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setSplitBackground(Drawable drawable) {
        boolean z = true;
        if (this.f1781c != null) {
            this.f1781c.setCallback(null);
            unscheduleDrawable(this.f1781c);
        }
        this.f1781c = drawable;
        if (drawable != null) {
            drawable.setCallback(this);
            if (this.f1782d && this.f1781c != null) {
                this.f1781c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
            }
        }
        if (this.f1782d) {
            if (this.f1781c != null) {
                z = false;
            }
        } else if (!(this.f1779a == null && this.f1780b == null)) {
            z = false;
        }
        setWillNotDraw(z);
        invalidate();
    }

    public void setVisibility(int i) {
        boolean z;
        super.setVisibility(i);
        if (i == 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1779a != null) {
            this.f1779a.setVisible(z, false);
        }
        if (this.f1780b != null) {
            this.f1780b.setVisible(z, false);
        }
        if (this.f1781c != null) {
            this.f1781c.setVisible(z, false);
        }
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return (drawable == this.f1779a && !this.f1782d) || ((drawable == this.f1780b && this.f1783e) || ((drawable == this.f1781c && this.f1782d) || super.verifyDrawable(drawable)));
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        if (this.f1779a != null && this.f1779a.isStateful()) {
            this.f1779a.setState(getDrawableState());
        }
        if (this.f1780b != null && this.f1780b.isStateful()) {
            this.f1780b.setState(getDrawableState());
        }
        if (this.f1781c != null && this.f1781c.isStateful()) {
            this.f1781c.setState(getDrawableState());
        }
    }

    public void jumpDrawablesToCurrentState() {
        if (VERSION.SDK_INT >= 11) {
            super.jumpDrawablesToCurrentState();
            if (this.f1779a != null) {
                this.f1779a.jumpToCurrentState();
            }
            if (this.f1780b != null) {
                this.f1780b.jumpToCurrentState();
            }
            if (this.f1781c != null) {
                this.f1781c.jumpToCurrentState();
            }
        }
    }

    public void setTransitioning(boolean z) {
        this.f1784f = z;
        setDescendantFocusability(z ? 393216 : 262144);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f1784f || super.onInterceptTouchEvent(motionEvent);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        return true;
    }

    public void setTabContainer(ar arVar) {
        if (this.f1785g != null) {
            removeView(this.f1785g);
        }
        this.f1785g = arVar;
        if (arVar != null) {
            addView(arVar);
            LayoutParams layoutParams = arVar.getLayoutParams();
            layoutParams.width = -1;
            layoutParams.height = -2;
            arVar.setAllowCollapse(false);
        }
    }

    public View getTabContainer() {
        return this.f1785g;
    }

    public ActionMode startActionModeForChild(View view, Callback callback) {
        return null;
    }

    private boolean m3273a(View view) {
        return view == null || view.getVisibility() == 8 || view.getMeasuredHeight() == 0;
    }

    private int m3274b(View view) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        return layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
    }

    public void onMeasure(int i, int i2) {
        if (this.f1786h == null && MeasureSpec.getMode(i2) == Integer.MIN_VALUE && this.f1788j >= 0) {
            i2 = MeasureSpec.makeMeasureSpec(Math.min(this.f1788j, MeasureSpec.getSize(i2)), Integer.MIN_VALUE);
        }
        super.onMeasure(i, i2);
        if (this.f1786h != null) {
            int mode = MeasureSpec.getMode(i2);
            if (this.f1785g != null && this.f1785g.getVisibility() != 8 && mode != 1073741824) {
                int b;
                if (!m3273a(this.f1786h)) {
                    b = m3274b(this.f1786h);
                } else if (m3273a(this.f1787i)) {
                    b = 0;
                } else {
                    b = m3274b(this.f1787i);
                }
                setMeasuredDimension(getMeasuredWidth(), Math.min(b + m3274b(this.f1785g), mode == Integer.MIN_VALUE ? MeasureSpec.getSize(i2) : Integer.MAX_VALUE));
            }
        }
    }

    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = 1;
        super.onLayout(z, i, i2, i3, i4);
        View view = this.f1785g;
        boolean z2 = (view == null || view.getVisibility() == 8) ? false : true;
        if (!(view == null || view.getVisibility() == 8)) {
            int measuredHeight = getMeasuredHeight();
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
            view.layout(i, (measuredHeight - view.getMeasuredHeight()) - layoutParams.bottomMargin, i3, measuredHeight - layoutParams.bottomMargin);
        }
        if (!this.f1782d) {
            int i6;
            if (this.f1779a != null) {
                if (this.f1786h.getVisibility() == 0) {
                    this.f1779a.setBounds(this.f1786h.getLeft(), this.f1786h.getTop(), this.f1786h.getRight(), this.f1786h.getBottom());
                } else if (this.f1787i == null || this.f1787i.getVisibility() != 0) {
                    this.f1779a.setBounds(0, 0, 0, 0);
                } else {
                    this.f1779a.setBounds(this.f1787i.getLeft(), this.f1787i.getTop(), this.f1787i.getRight(), this.f1787i.getBottom());
                }
                i6 = 1;
            } else {
                i6 = 0;
            }
            this.f1783e = z2;
            if (!z2 || this.f1780b == null) {
                i5 = i6;
            } else {
                this.f1780b.setBounds(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
            }
        } else if (this.f1781c != null) {
            this.f1781c.setBounds(0, 0, getMeasuredWidth(), getMeasuredHeight());
        } else {
            i5 = 0;
        }
        if (i5 != 0) {
            invalidate();
        }
    }
}
