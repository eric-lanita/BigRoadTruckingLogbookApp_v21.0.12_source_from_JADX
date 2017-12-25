package android.support.v7.widget;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.view.ax;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0628b;
import android.support.v7.view.menu.C0666f;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ActionBarContextView extends C0684a {
    private CharSequence f1799g;
    private CharSequence f1800h;
    private View f1801i;
    private View f1802j;
    private LinearLayout f1803k;
    private TextView f1804l;
    private TextView f1805m;
    private int f1806n;
    private int f1807o;
    private boolean f1808p;
    private int f1809q;

    public /* bridge */ /* synthetic */ ax mo571a(int i, long j) {
        return super.mo571a(i, j);
    }

    public /* bridge */ /* synthetic */ int getAnimatedVisibility() {
        return super.getAnimatedVisibility();
    }

    public /* bridge */ /* synthetic */ int getContentHeight() {
        return super.getContentHeight();
    }

    public /* bridge */ /* synthetic */ boolean onHoverEvent(MotionEvent motionEvent) {
        return super.onHoverEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ boolean onTouchEvent(MotionEvent motionEvent) {
        return super.onTouchEvent(motionEvent);
    }

    public /* bridge */ /* synthetic */ void setVisibility(int i) {
        super.setVisibility(i);
    }

    public ActionBarContextView(Context context) {
        this(context, null);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, C0553a.actionModeStyle);
    }

    public ActionBarContextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        ay a = ay.m3733a(context, attributeSet, C0563k.ActionMode, i, 0);
        setBackgroundDrawable(a.m3736a(C0563k.ActionMode_background));
        this.f1806n = a.m3749g(C0563k.ActionMode_titleTextStyle, 0);
        this.f1807o = a.m3749g(C0563k.ActionMode_subtitleTextStyle, 0);
        this.e = a.m3747f(C0563k.ActionMode_height, 0);
        this.f1809q = a.m3749g(C0563k.ActionMode_closeItemLayout, C0560h.abc_action_mode_close_item_material);
        a.m3737a();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.d != null) {
            this.d.m3845e();
            this.d.m3847g();
        }
    }

    public void setContentHeight(int i) {
        this.e = i;
    }

    public void setCustomView(View view) {
        if (this.f1802j != null) {
            removeView(this.f1802j);
        }
        this.f1802j = view;
        if (!(view == null || this.f1803k == null)) {
            removeView(this.f1803k);
            this.f1803k = null;
        }
        if (view != null) {
            addView(view);
        }
        requestLayout();
    }

    public void setTitle(CharSequence charSequence) {
        this.f1799g = charSequence;
        m3282e();
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1800h = charSequence;
        m3282e();
    }

    public CharSequence getTitle() {
        return this.f1799g;
    }

    public CharSequence getSubtitle() {
        return this.f1800h;
    }

    private void m3282e() {
        int i;
        int i2 = 8;
        Object obj = 1;
        if (this.f1803k == null) {
            LayoutInflater.from(getContext()).inflate(C0560h.abc_action_bar_title_item, this);
            this.f1803k = (LinearLayout) getChildAt(getChildCount() - 1);
            this.f1804l = (TextView) this.f1803k.findViewById(C0558f.action_bar_title);
            this.f1805m = (TextView) this.f1803k.findViewById(C0558f.action_bar_subtitle);
            if (this.f1806n != 0) {
                this.f1804l.setTextAppearance(getContext(), this.f1806n);
            }
            if (this.f1807o != 0) {
                this.f1805m.setTextAppearance(getContext(), this.f1807o);
            }
        }
        this.f1804l.setText(this.f1799g);
        this.f1805m.setText(this.f1800h);
        Object obj2 = !TextUtils.isEmpty(this.f1799g) ? 1 : null;
        if (TextUtils.isEmpty(this.f1800h)) {
            obj = null;
        }
        TextView textView = this.f1805m;
        if (obj != null) {
            i = 0;
        } else {
            i = 8;
        }
        textView.setVisibility(i);
        LinearLayout linearLayout = this.f1803k;
        if (!(obj2 == null && obj == null)) {
            i2 = 0;
        }
        linearLayout.setVisibility(i2);
        if (this.f1803k.getParent() == null) {
            addView(this.f1803k);
        }
    }

    public void m3284a(final C0628b c0628b) {
        if (this.f1801i == null) {
            this.f1801i = LayoutInflater.from(getContext()).inflate(this.f1809q, this, false);
            addView(this.f1801i);
        } else if (this.f1801i.getParent() == null) {
            addView(this.f1801i);
        }
        this.f1801i.findViewById(C0558f.action_mode_close_button).setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ActionBarContextView f1790b;

            public void onClick(View view) {
                c0628b.mo502c();
            }
        });
        C0666f c0666f = (C0666f) c0628b.mo499b();
        if (this.d != null) {
            this.d.m3846f();
        }
        this.d = new C0747d(getContext());
        this.d.m3842c(true);
        LayoutParams layoutParams = new LayoutParams(-2, -1);
        c0666f.m3156a(this.d, this.b);
        this.c = (ActionMenuView) this.d.mo667a((ViewGroup) this);
        this.c.setBackgroundDrawable(null);
        addView(this.c, layoutParams);
    }

    public void m3286b() {
        if (this.f1801i == null) {
            m3287c();
        }
    }

    public void m3287c() {
        removeAllViews();
        this.f1802j = null;
        this.c = null;
    }

    public boolean mo572a() {
        if (this.d != null) {
            return this.d.m3844d();
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(-1, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new MarginLayoutParams(getContext(), attributeSet);
    }

    protected void onMeasure(int i, int i2) {
        int i3 = 1073741824;
        int i4 = 0;
        if (MeasureSpec.getMode(i) != 1073741824) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_width=\"match_parent\" (or fill_parent)");
        } else if (MeasureSpec.getMode(i2) == 0) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with android:layout_height=\"wrap_content\"");
        } else {
            int a;
            int size = MeasureSpec.getSize(i);
            int size2 = this.e > 0 ? this.e : MeasureSpec.getSize(i2);
            int paddingTop = getPaddingTop() + getPaddingBottom();
            int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
            int i5 = size2 - paddingTop;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE);
            if (this.f1801i != null) {
                a = m3278a(this.f1801i, paddingLeft, makeMeasureSpec, 0);
                MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1801i.getLayoutParams();
                paddingLeft = a - (marginLayoutParams.rightMargin + marginLayoutParams.leftMargin);
            }
            if (this.c != null && this.c.getParent() == this) {
                paddingLeft = m3278a(this.c, paddingLeft, makeMeasureSpec, 0);
            }
            if (this.f1803k != null && this.f1802j == null) {
                if (this.f1808p) {
                    this.f1803k.measure(MeasureSpec.makeMeasureSpec(0, 0), makeMeasureSpec);
                    a = this.f1803k.getMeasuredWidth();
                    makeMeasureSpec = a <= paddingLeft ? 1 : 0;
                    if (makeMeasureSpec != 0) {
                        paddingLeft -= a;
                    }
                    this.f1803k.setVisibility(makeMeasureSpec != 0 ? 0 : 8);
                } else {
                    paddingLeft = m3278a(this.f1803k, paddingLeft, makeMeasureSpec, 0);
                }
            }
            if (this.f1802j != null) {
                int min;
                LayoutParams layoutParams = this.f1802j.getLayoutParams();
                if (layoutParams.width != -2) {
                    makeMeasureSpec = 1073741824;
                } else {
                    makeMeasureSpec = Integer.MIN_VALUE;
                }
                if (layoutParams.width >= 0) {
                    paddingLeft = Math.min(layoutParams.width, paddingLeft);
                }
                if (layoutParams.height == -2) {
                    i3 = Integer.MIN_VALUE;
                }
                if (layoutParams.height >= 0) {
                    min = Math.min(layoutParams.height, i5);
                } else {
                    min = i5;
                }
                this.f1802j.measure(MeasureSpec.makeMeasureSpec(paddingLeft, makeMeasureSpec), MeasureSpec.makeMeasureSpec(min, i3));
            }
            if (this.e <= 0) {
                makeMeasureSpec = getChildCount();
                size2 = 0;
                while (i4 < makeMeasureSpec) {
                    paddingLeft = getChildAt(i4).getMeasuredHeight() + paddingTop;
                    if (paddingLeft <= size2) {
                        paddingLeft = size2;
                    }
                    i4++;
                    size2 = paddingLeft;
                }
                setMeasuredDimension(size, size2);
                return;
            }
            setMeasuredDimension(size, size2);
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        boolean a = bb.m3805a(this);
        int paddingRight = a ? (i3 - i) - getPaddingRight() : getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingTop2 = ((i4 - i2) - getPaddingTop()) - getPaddingBottom();
        if (this.f1801i == null || this.f1801i.getVisibility() == 8) {
            i5 = paddingRight;
        } else {
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1801i.getLayoutParams();
            i5 = a ? marginLayoutParams.rightMargin : marginLayoutParams.leftMargin;
            int i6 = a ? marginLayoutParams.leftMargin : marginLayoutParams.rightMargin;
            i5 = C0684a.m3275a(paddingRight, i5, a);
            i5 = C0684a.m3275a(m3279a(this.f1801i, i5, paddingTop, paddingTop2, a) + i5, i6, a);
        }
        if (!(this.f1803k == null || this.f1802j != null || this.f1803k.getVisibility() == 8)) {
            i5 += m3279a(this.f1803k, i5, paddingTop, paddingTop2, a);
        }
        if (this.f1802j != null) {
            int a2 = m3279a(this.f1802j, i5, paddingTop, paddingTop2, a) + i5;
        }
        i5 = a ? getPaddingLeft() : (i3 - i) - getPaddingRight();
        if (this.c != null) {
            a2 = m3279a(this.c, i5, paddingTop, paddingTop2, !a) + i5;
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT < 14) {
            return;
        }
        if (accessibilityEvent.getEventType() == 32) {
            accessibilityEvent.setSource(this);
            accessibilityEvent.setClassName(getClass().getName());
            accessibilityEvent.setPackageName(getContext().getPackageName());
            accessibilityEvent.setContentDescription(this.f1799g);
            return;
        }
        super.onInitializeAccessibilityEvent(accessibilityEvent);
    }

    public void setTitleOptional(boolean z) {
        if (z != this.f1808p) {
            requestLayout();
        }
        this.f1808p = z;
    }

    public boolean m3288d() {
        return this.f1808p;
    }
}
