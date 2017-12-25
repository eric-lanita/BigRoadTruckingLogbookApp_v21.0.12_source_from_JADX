package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0438e;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class aj extends ViewGroup {
    private boolean f1851a;
    private int f1852b;
    private int f1853c;
    private int f1854d;
    private int f1855e;
    private int f1856f;
    private float f1857g;
    private boolean f1858h;
    private int[] f1859i;
    private int[] f1860j;
    private Drawable f1861k;
    private int f1862l;
    private int f1863m;
    private int f1864n;
    private int f1865o;

    public static class C0691a extends MarginLayoutParams {
        public float f1842g;
        public int f1843h;

        public C0691a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f1843h = -1;
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.LinearLayoutCompat_Layout);
            this.f1842g = obtainStyledAttributes.getFloat(C0563k.LinearLayoutCompat_Layout_android_layout_weight, 0.0f);
            this.f1843h = obtainStyledAttributes.getInt(C0563k.LinearLayoutCompat_Layout_android_layout_gravity, -1);
            obtainStyledAttributes.recycle();
        }

        public C0691a(int i, int i2) {
            super(i, i2);
            this.f1843h = -1;
            this.f1842g = 0.0f;
        }

        public C0691a(LayoutParams layoutParams) {
            super(layoutParams);
            this.f1843h = -1;
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return mo596j();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return mo590b(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return mo591b(layoutParams);
    }

    public aj(Context context) {
        this(context, null);
    }

    public aj(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public aj(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1851a = true;
        this.f1852b = -1;
        this.f1853c = 0;
        this.f1855e = 8388659;
        ay a = ay.m3733a(context, attributeSet, C0563k.LinearLayoutCompat, i, 0);
        int a2 = a.m3735a(C0563k.LinearLayoutCompat_android_orientation, -1);
        if (a2 >= 0) {
            setOrientation(a2);
        }
        a2 = a.m3735a(C0563k.LinearLayoutCompat_android_gravity, -1);
        if (a2 >= 0) {
            setGravity(a2);
        }
        boolean a3 = a.m3738a(C0563k.LinearLayoutCompat_android_baselineAligned, true);
        if (!a3) {
            setBaselineAligned(a3);
        }
        this.f1857g = a.m3734a(C0563k.LinearLayoutCompat_android_weightSum, (float) GroundOverlayOptions.NO_DIMENSION);
        this.f1852b = a.m3735a(C0563k.LinearLayoutCompat_android_baselineAlignedChildIndex, -1);
        this.f1858h = a.m3738a(C0563k.LinearLayoutCompat_measureWithLargestChild, false);
        setDividerDrawable(a.m3736a(C0563k.LinearLayoutCompat_divider));
        this.f1864n = a.m3735a(C0563k.LinearLayoutCompat_showDividers, 0);
        this.f1865o = a.m3745e(C0563k.LinearLayoutCompat_dividerPadding, 0);
        a.m3737a();
    }

    public void setShowDividers(int i) {
        if (i != this.f1864n) {
            requestLayout();
        }
        this.f1864n = i;
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public int getShowDividers() {
        return this.f1864n;
    }

    public Drawable getDividerDrawable() {
        return this.f1861k;
    }

    public void setDividerDrawable(Drawable drawable) {
        boolean z = false;
        if (drawable != this.f1861k) {
            this.f1861k = drawable;
            if (drawable != null) {
                this.f1862l = drawable.getIntrinsicWidth();
                this.f1863m = drawable.getIntrinsicHeight();
            } else {
                this.f1862l = 0;
                this.f1863m = 0;
            }
            if (drawable == null) {
                z = true;
            }
            setWillNotDraw(z);
            requestLayout();
        }
    }

    public void setDividerPadding(int i) {
        this.f1865o = i;
    }

    public int getDividerPadding() {
        return this.f1865o;
    }

    public int getDividerWidth() {
        return this.f1862l;
    }

    protected void onDraw(Canvas canvas) {
        if (this.f1861k != null) {
            if (this.f1854d == 1) {
                m3338a(canvas);
            } else {
                m3347b(canvas);
            }
        }
    }

    void m3338a(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        int i = 0;
        while (i < virtualChildCount) {
            View b = m3344b(i);
            if (!(b == null || b.getVisibility() == 8 || !m3349c(i))) {
                m3339a(canvas, (b.getTop() - ((C0691a) b.getLayoutParams()).topMargin) - this.f1863m);
            }
            i++;
        }
        if (m3349c(virtualChildCount)) {
            int height;
            View b2 = m3344b(virtualChildCount - 1);
            if (b2 == null) {
                height = (getHeight() - getPaddingBottom()) - this.f1863m;
            } else {
                C0691a c0691a = (C0691a) b2.getLayoutParams();
                height = c0691a.bottomMargin + b2.getBottom();
            }
            m3339a(canvas, height);
        }
    }

    void m3347b(Canvas canvas) {
        int virtualChildCount = getVirtualChildCount();
        boolean a = bb.m3805a(this);
        int i = 0;
        while (i < virtualChildCount) {
            C0691a c0691a;
            int right;
            View b = m3344b(i);
            if (!(b == null || b.getVisibility() == 8 || !m3349c(i))) {
                c0691a = (C0691a) b.getLayoutParams();
                if (a) {
                    right = c0691a.rightMargin + b.getRight();
                } else {
                    right = (b.getLeft() - c0691a.leftMargin) - this.f1862l;
                }
                m3348b(canvas, right);
            }
            i++;
        }
        if (m3349c(virtualChildCount)) {
            View b2 = m3344b(virtualChildCount - 1);
            if (b2 != null) {
                c0691a = (C0691a) b2.getLayoutParams();
                if (a) {
                    right = (b2.getLeft() - c0691a.leftMargin) - this.f1862l;
                } else {
                    right = c0691a.rightMargin + b2.getRight();
                }
            } else if (a) {
                right = getPaddingLeft();
            } else {
                right = (getWidth() - getPaddingRight()) - this.f1862l;
            }
            m3348b(canvas, right);
        }
    }

    void m3339a(Canvas canvas, int i) {
        this.f1861k.setBounds(getPaddingLeft() + this.f1865o, i, (getWidth() - getPaddingRight()) - this.f1865o, this.f1863m + i);
        this.f1861k.draw(canvas);
    }

    void m3348b(Canvas canvas, int i) {
        this.f1861k.setBounds(i, getPaddingTop() + this.f1865o, this.f1862l + i, (getHeight() - getPaddingBottom()) - this.f1865o);
        this.f1861k.draw(canvas);
    }

    public void setBaselineAligned(boolean z) {
        this.f1851a = z;
    }

    public void setMeasureWithLargestChildEnabled(boolean z) {
        this.f1858h = z;
    }

    public int getBaseline() {
        if (this.f1852b < 0) {
            return super.getBaseline();
        }
        if (getChildCount() <= this.f1852b) {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout set to an index that is out of bounds.");
        }
        View childAt = getChildAt(this.f1852b);
        int baseline = childAt.getBaseline();
        if (baseline != -1) {
            int i;
            int i2 = this.f1853c;
            if (this.f1854d == 1) {
                i = this.f1855e & 112;
                if (i != 48) {
                    switch (i) {
                        case 16:
                            i = i2 + (((((getBottom() - getTop()) - getPaddingTop()) - getPaddingBottom()) - this.f1856f) / 2);
                            break;
                        case 80:
                            i = ((getBottom() - getTop()) - getPaddingBottom()) - this.f1856f;
                            break;
                    }
                }
            }
            i = i2;
            return (((C0691a) childAt.getLayoutParams()).topMargin + i) + baseline;
        } else if (this.f1852b == 0) {
            return -1;
        } else {
            throw new RuntimeException("mBaselineAlignedChildIndex of LinearLayout points to a View that doesn't know how to get its baseline.");
        }
    }

    public int getBaselineAlignedChildIndex() {
        return this.f1852b;
    }

    public void setBaselineAlignedChildIndex(int i) {
        if (i < 0 || i >= getChildCount()) {
            throw new IllegalArgumentException("base aligned child index out of range (0, " + getChildCount() + ")");
        }
        this.f1852b = i;
    }

    View m3344b(int i) {
        return getChildAt(i);
    }

    int getVirtualChildCount() {
        return getChildCount();
    }

    public float getWeightSum() {
        return this.f1857g;
    }

    public void setWeightSum(float f) {
        this.f1857g = Math.max(0.0f, f);
    }

    protected void onMeasure(int i, int i2) {
        if (this.f1854d == 1) {
            m3336a(i, i2);
        } else {
            m3345b(i, i2);
        }
    }

    protected boolean m3349c(int i) {
        if (i == 0) {
            if ((this.f1864n & 1) != 0) {
                return true;
            }
            return false;
        } else if (i == getChildCount()) {
            if ((this.f1864n & 4) == 0) {
                return false;
            }
            return true;
        } else if ((this.f1864n & 2) == 0) {
            return false;
        } else {
            for (int i2 = i - 1; i2 >= 0; i2--) {
                if (getChildAt(i2).getVisibility() != 8) {
                    return true;
                }
            }
            return false;
        }
    }

    void m3336a(int i, int i2) {
        int i3;
        int i4;
        View b;
        this.f1856f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj2 = null;
        Object obj3 = null;
        int i9 = this.f1852b;
        boolean z = this.f1858h;
        int i10 = Integer.MIN_VALUE;
        int i11 = 0;
        while (i11 < virtualChildCount) {
            Object obj4;
            Object obj5;
            int i12;
            int i13;
            View b2 = m3344b(i11);
            if (b2 == null) {
                this.f1856f += m3350d(i11);
                i3 = i10;
                obj4 = obj3;
                obj5 = obj;
                i12 = i6;
                i13 = i5;
            } else if (b2.getVisibility() == 8) {
                i11 += m3335a(b2, i11);
                i3 = i10;
                obj4 = obj3;
                obj5 = obj;
                i12 = i6;
                i13 = i5;
            } else {
                if (m3349c(i11)) {
                    this.f1856f += this.f1863m;
                }
                C0691a c0691a = (C0691a) b2.getLayoutParams();
                float f2 = f + c0691a.f1842g;
                if (mode2 == 1073741824 && c0691a.height == 0 && c0691a.f1842g > 0.0f) {
                    i3 = this.f1856f;
                    this.f1856f = Math.max(i3, (c0691a.topMargin + i3) + c0691a.bottomMargin);
                    obj3 = 1;
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0691a.height == 0 && c0691a.f1842g > 0.0f) {
                        i3 = 0;
                        c0691a.height = -2;
                    }
                    int i14 = i3;
                    m3340a(b2, i11, i, 0, i2, f2 == 0.0f ? this.f1856f : 0);
                    if (i14 != Integer.MIN_VALUE) {
                        c0691a.height = i14;
                    }
                    i3 = b2.getMeasuredHeight();
                    int i15 = this.f1856f;
                    this.f1856f = Math.max(i15, (((i15 + i3) + c0691a.topMargin) + c0691a.bottomMargin) + m3341b(b2));
                    if (z) {
                        i10 = Math.max(i3, i10);
                    }
                }
                if (i9 >= 0 && i9 == i11 + 1) {
                    this.f1853c = this.f1856f;
                }
                if (i11 >= i9 || c0691a.f1842g <= 0.0f) {
                    Object obj6;
                    Object obj7 = null;
                    if (mode == 1073741824 || c0691a.width != -1) {
                        obj6 = obj2;
                    } else {
                        obj6 = 1;
                        obj7 = 1;
                    }
                    i12 = c0691a.rightMargin + c0691a.leftMargin;
                    i13 = b2.getMeasuredWidth() + i12;
                    i5 = Math.max(i5, i13);
                    int a = bb.m3803a(i6, ag.m1807g(b2));
                    obj5 = (obj == null || c0691a.width != -1) ? null : 1;
                    if (c0691a.f1842g > 0.0f) {
                        if (obj7 != null) {
                            i3 = i12;
                        } else {
                            i3 = i13;
                        }
                        i3 = Math.max(i8, i3);
                        i12 = i7;
                    } else {
                        if (obj7 == null) {
                            i12 = i13;
                        }
                        i12 = Math.max(i7, i12);
                        i3 = i8;
                    }
                    i11 += m3335a(b2, i11);
                    obj4 = obj3;
                    i8 = i3;
                    i7 = i12;
                    i13 = i5;
                    i3 = i10;
                    i12 = a;
                    obj2 = obj6;
                    f = f2;
                } else {
                    throw new RuntimeException("A child of LinearLayout with index less than mBaselineAlignedChildIndex has weight > 0, which won't work.  Either remove the weight, or don't set mBaselineAlignedChildIndex.");
                }
            }
            i11++;
            i10 = i3;
            obj3 = obj4;
            obj = obj5;
            i6 = i12;
            i5 = i13;
        }
        if (this.f1856f > 0 && m3349c(virtualChildCount)) {
            this.f1856f += this.f1863m;
        }
        if (z && (mode2 == Integer.MIN_VALUE || mode2 == 0)) {
            this.f1856f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                b = m3344b(i4);
                if (b == null) {
                    this.f1856f += m3350d(i4);
                    i3 = i4;
                } else if (b.getVisibility() == 8) {
                    i3 = m3335a(b, i4) + i4;
                } else {
                    C0691a c0691a2 = (C0691a) b.getLayoutParams();
                    int i16 = this.f1856f;
                    this.f1856f = Math.max(i16, (c0691a2.bottomMargin + ((i16 + i10) + c0691a2.topMargin)) + m3341b(b));
                    i3 = i4;
                }
                i4 = i3 + 1;
            }
        }
        this.f1856f += getPaddingTop() + getPaddingBottom();
        int a2 = ag.m1777a(Math.max(this.f1856f, getSuggestedMinimumHeight()), i2, 0);
        i4 = (16777215 & a2) - this.f1856f;
        int i17;
        if (obj3 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1857g > 0.0f) {
                f = this.f1857g;
            }
            this.f1856f = 0;
            i10 = 0;
            float f3 = f;
            Object obj8 = obj;
            i17 = i7;
            i16 = i6;
            i8 = i5;
            i15 = i4;
            while (i10 < virtualChildCount) {
                View b3 = m3344b(i10);
                if (b3.getVisibility() == 8) {
                    i3 = i17;
                    i4 = i16;
                    i12 = i8;
                    obj5 = obj8;
                } else {
                    float f4;
                    float f5;
                    c0691a2 = (C0691a) b3.getLayoutParams();
                    float f6 = c0691a2.f1842g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i15) * f6) / f3);
                        f3 -= f6;
                        i15 -= i4;
                        i12 = getChildMeasureSpec(i, ((getPaddingLeft() + getPaddingRight()) + c0691a2.leftMargin) + c0691a2.rightMargin, c0691a2.width);
                        if (c0691a2.height == 0 && mode2 == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        } else {
                            i4 += b3.getMeasuredHeight();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(i12, MeasureSpec.makeMeasureSpec(i4, 1073741824));
                        }
                        f4 = f3;
                        i11 = i15;
                        i15 = bb.m3803a(i16, ag.m1807g(b3) & -256);
                        f5 = f4;
                    } else {
                        f5 = f3;
                        i11 = i15;
                        i15 = i16;
                    }
                    i16 = c0691a2.leftMargin + c0691a2.rightMargin;
                    i12 = b3.getMeasuredWidth() + i16;
                    i8 = Math.max(i8, i12);
                    Object obj9 = (mode == 1073741824 || c0691a2.width != -1) ? null : 1;
                    if (obj9 == null) {
                        i16 = i12;
                    }
                    i12 = Math.max(i17, i16);
                    obj5 = (obj8 == null || c0691a2.width != -1) ? null : 1;
                    i13 = this.f1856f;
                    this.f1856f = Math.max(i13, (c0691a2.bottomMargin + ((b3.getMeasuredHeight() + i13) + c0691a2.topMargin)) + m3341b(b3));
                    i3 = i12;
                    i12 = i8;
                    f4 = f5;
                    i4 = i15;
                    i15 = i11;
                    f3 = f4;
                }
                i10++;
                i17 = i3;
                i8 = i12;
                obj8 = obj5;
                i16 = i4;
            }
            this.f1856f += getPaddingTop() + getPaddingBottom();
            obj = obj8;
            i3 = i17;
            i6 = i16;
            i4 = i8;
        } else {
            i17 = Math.max(i7, i8);
            if (z && mode2 != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    b = m3344b(i4);
                    if (!(b == null || b.getVisibility() == 8 || ((C0691a) b.getLayoutParams()).f1842g <= 0.0f)) {
                        b.measure(MeasureSpec.makeMeasureSpec(b.getMeasuredWidth(), 1073741824), MeasureSpec.makeMeasureSpec(i10, 1073741824));
                    }
                }
            }
            i3 = i17;
            i4 = i5;
        }
        if (obj != null || mode == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension(ag.m1777a(Math.max(i3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, i6), a2);
        if (obj2 != null) {
            m3332c(virtualChildCount, i2);
        }
    }

    private void m3332c(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m3344b(i3);
            if (b.getVisibility() != 8) {
                C0691a c0691a = (C0691a) b.getLayoutParams();
                if (c0691a.width == -1) {
                    int i4 = c0691a.height;
                    c0691a.height = b.getMeasuredHeight();
                    measureChildWithMargins(b, makeMeasureSpec, 0, i2, 0);
                    c0691a.height = i4;
                }
            }
        }
    }

    void m3345b(int i, int i2) {
        Object obj;
        int i3;
        Object obj2;
        int i4;
        C0691a c0691a;
        this.f1856f = 0;
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        Object obj3 = 1;
        float f = 0.0f;
        int virtualChildCount = getVirtualChildCount();
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        Object obj4 = null;
        Object obj5 = null;
        if (this.f1859i == null || this.f1860j == null) {
            this.f1859i = new int[4];
            this.f1860j = new int[4];
        }
        int[] iArr = this.f1859i;
        int[] iArr2 = this.f1860j;
        iArr[3] = -1;
        iArr[2] = -1;
        iArr[1] = -1;
        iArr[0] = -1;
        iArr2[3] = -1;
        iArr2[2] = -1;
        iArr2[1] = -1;
        iArr2[0] = -1;
        boolean z = this.f1851a;
        boolean z2 = this.f1858h;
        if (mode == 1073741824) {
            obj = 1;
        } else {
            obj = null;
        }
        int i9 = Integer.MIN_VALUE;
        int i10 = 0;
        while (i10 < virtualChildCount) {
            Object obj6;
            int i11;
            int i12;
            View b = m3344b(i10);
            if (b == null) {
                this.f1856f += m3350d(i10);
                i3 = i9;
                obj2 = obj5;
                obj6 = obj3;
                i11 = i6;
                i12 = i5;
            } else if (b.getVisibility() == 8) {
                i10 += m3335a(b, i10);
                i3 = i9;
                obj2 = obj5;
                obj6 = obj3;
                i11 = i6;
                i12 = i5;
            } else {
                Object obj7;
                if (m3349c(i10)) {
                    this.f1856f += this.f1862l;
                }
                C0691a c0691a2 = (C0691a) b.getLayoutParams();
                float f2 = f + c0691a2.f1842g;
                if (mode == 1073741824 && c0691a2.width == 0 && c0691a2.f1842g > 0.0f) {
                    if (obj != null) {
                        this.f1856f += c0691a2.leftMargin + c0691a2.rightMargin;
                    } else {
                        i3 = this.f1856f;
                        this.f1856f = Math.max(i3, (c0691a2.leftMargin + i3) + c0691a2.rightMargin);
                    }
                    if (z) {
                        i3 = MeasureSpec.makeMeasureSpec(0, 0);
                        b.measure(i3, i3);
                    } else {
                        obj5 = 1;
                    }
                } else {
                    i3 = Integer.MIN_VALUE;
                    if (c0691a2.width == 0 && c0691a2.f1842g > 0.0f) {
                        i3 = 0;
                        c0691a2.width = -2;
                    }
                    int i13 = i3;
                    m3340a(b, i10, i, f2 == 0.0f ? this.f1856f : 0, i2, 0);
                    if (i13 != Integer.MIN_VALUE) {
                        c0691a2.width = i13;
                    }
                    i3 = b.getMeasuredWidth();
                    if (obj != null) {
                        this.f1856f += ((c0691a2.leftMargin + i3) + c0691a2.rightMargin) + m3341b(b);
                    } else {
                        int i14 = this.f1856f;
                        this.f1856f = Math.max(i14, (((i14 + i3) + c0691a2.leftMargin) + c0691a2.rightMargin) + m3341b(b));
                    }
                    if (z2) {
                        i9 = Math.max(i3, i9);
                    }
                }
                Object obj8 = null;
                if (mode2 == 1073741824 || c0691a2.height != -1) {
                    obj7 = obj4;
                } else {
                    obj7 = 1;
                    obj8 = 1;
                }
                i11 = c0691a2.bottomMargin + c0691a2.topMargin;
                i12 = b.getMeasuredHeight() + i11;
                int a = bb.m3803a(i6, ag.m1807g(b));
                if (z) {
                    i6 = b.getBaseline();
                    if (i6 != -1) {
                        int i15 = ((((c0691a2.f1843h < 0 ? this.f1855e : c0691a2.f1843h) & 112) >> 4) & -2) >> 1;
                        iArr[i15] = Math.max(iArr[i15], i6);
                        iArr2[i15] = Math.max(iArr2[i15], i12 - i6);
                    }
                }
                i6 = Math.max(i5, i12);
                obj6 = (obj3 == null || c0691a2.height != -1) ? null : 1;
                if (c0691a2.f1842g > 0.0f) {
                    if (obj8 != null) {
                        i3 = i11;
                    } else {
                        i3 = i12;
                    }
                    i3 = Math.max(i8, i3);
                    i11 = i7;
                } else {
                    if (obj8 == null) {
                        i11 = i12;
                    }
                    i11 = Math.max(i7, i11);
                    i3 = i8;
                }
                i10 += m3335a(b, i10);
                obj2 = obj5;
                i8 = i3;
                i7 = i11;
                i12 = i6;
                i3 = i9;
                i11 = a;
                obj4 = obj7;
                f = f2;
            }
            i10++;
            i9 = i3;
            obj5 = obj2;
            obj3 = obj6;
            i6 = i11;
            i5 = i12;
        }
        if (this.f1856f > 0 && m3349c(virtualChildCount)) {
            this.f1856f += this.f1862l;
        }
        if (iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1) {
            i10 = i5;
        } else {
            i10 = Math.max(i5, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
        }
        if (z2 && (mode == Integer.MIN_VALUE || mode == 0)) {
            this.f1856f = 0;
            i4 = 0;
            while (i4 < virtualChildCount) {
                View b2 = m3344b(i4);
                if (b2 == null) {
                    this.f1856f += m3350d(i4);
                    i3 = i4;
                } else if (b2.getVisibility() == 8) {
                    i3 = m3335a(b2, i4) + i4;
                } else {
                    c0691a = (C0691a) b2.getLayoutParams();
                    if (obj != null) {
                        this.f1856f = ((c0691a.rightMargin + (c0691a.leftMargin + i9)) + m3341b(b2)) + this.f1856f;
                        i3 = i4;
                    } else {
                        i11 = this.f1856f;
                        this.f1856f = Math.max(i11, (c0691a.rightMargin + ((i11 + i9) + c0691a.leftMargin)) + m3341b(b2));
                        i3 = i4;
                    }
                }
                i4 = i3 + 1;
            }
        }
        this.f1856f += getPaddingLeft() + getPaddingRight();
        int a2 = ag.m1777a(Math.max(this.f1856f, getSuggestedMinimumWidth()), i, 0);
        i4 = (16777215 & a2) - this.f1856f;
        int i16;
        if (obj5 != null || (i4 != 0 && f > 0.0f)) {
            if (this.f1857g > 0.0f) {
                f = this.f1857g;
            }
            iArr[3] = -1;
            iArr[2] = -1;
            iArr[1] = -1;
            iArr[0] = -1;
            iArr2[3] = -1;
            iArr2[2] = -1;
            iArr2[1] = -1;
            iArr2[0] = -1;
            this.f1856f = 0;
            i9 = 0;
            float f3 = f;
            Object obj9 = obj3;
            i16 = i7;
            i15 = i6;
            i14 = i4;
            i7 = -1;
            while (i9 < virtualChildCount) {
                float f4;
                Object obj10;
                View b3 = m3344b(i9);
                if (b3 == null) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else if (b3.getVisibility() == 8) {
                    f4 = f3;
                    i4 = i14;
                    i11 = i7;
                    i14 = i16;
                    obj10 = obj9;
                } else {
                    float f5;
                    c0691a = (C0691a) b3.getLayoutParams();
                    float f6 = c0691a.f1842g;
                    if (f6 > 0.0f) {
                        i4 = (int) ((((float) i14) * f6) / f3);
                        f3 -= f6;
                        i11 = i14 - i4;
                        i14 = getChildMeasureSpec(i2, ((getPaddingTop() + getPaddingBottom()) + c0691a.topMargin) + c0691a.bottomMargin, c0691a.height);
                        if (c0691a.width == 0 && mode == 1073741824) {
                            if (i4 <= 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        } else {
                            i4 += b3.getMeasuredWidth();
                            if (i4 < 0) {
                                i4 = 0;
                            }
                            b3.measure(MeasureSpec.makeMeasureSpec(i4, 1073741824), i14);
                        }
                        i8 = bb.m3803a(i15, ag.m1807g(b3) & -16777216);
                        f5 = f3;
                    } else {
                        i11 = i14;
                        i8 = i15;
                        f5 = f3;
                    }
                    if (obj != null) {
                        this.f1856f += ((b3.getMeasuredWidth() + c0691a.leftMargin) + c0691a.rightMargin) + m3341b(b3);
                    } else {
                        i4 = this.f1856f;
                        this.f1856f = Math.max(i4, (((b3.getMeasuredWidth() + i4) + c0691a.leftMargin) + c0691a.rightMargin) + m3341b(b3));
                    }
                    obj2 = (mode2 == 1073741824 || c0691a.height != -1) ? null : 1;
                    i10 = c0691a.topMargin + c0691a.bottomMargin;
                    i14 = b3.getMeasuredHeight() + i10;
                    i7 = Math.max(i7, i14);
                    if (obj2 != null) {
                        i4 = i10;
                    } else {
                        i4 = i14;
                    }
                    i10 = Math.max(i16, i4);
                    obj2 = (obj9 == null || c0691a.height != -1) ? null : 1;
                    if (z) {
                        i12 = b3.getBaseline();
                        if (i12 != -1) {
                            i3 = ((((c0691a.f1843h < 0 ? this.f1855e : c0691a.f1843h) & 112) >> 4) & -2) >> 1;
                            iArr[i3] = Math.max(iArr[i3], i12);
                            iArr2[i3] = Math.max(iArr2[i3], i14 - i12);
                        }
                    }
                    f4 = f5;
                    i14 = i10;
                    obj10 = obj2;
                    i15 = i8;
                    i4 = i11;
                    i11 = i7;
                }
                i9++;
                i16 = i14;
                i7 = i11;
                obj9 = obj10;
                i14 = i4;
                f3 = f4;
            }
            this.f1856f += getPaddingLeft() + getPaddingRight();
            if (!(iArr[1] == -1 && iArr[0] == -1 && iArr[2] == -1 && iArr[3] == -1)) {
                i7 = Math.max(i7, Math.max(iArr[3], Math.max(iArr[0], Math.max(iArr[1], iArr[2]))) + Math.max(iArr2[3], Math.max(iArr2[0], Math.max(iArr2[1], iArr2[2]))));
            }
            obj3 = obj9;
            i3 = i16;
            i6 = i15;
            i4 = i7;
        } else {
            i16 = Math.max(i7, i8);
            if (z2 && mode != 1073741824) {
                for (i4 = 0; i4 < virtualChildCount; i4++) {
                    View b4 = m3344b(i4);
                    if (!(b4 == null || b4.getVisibility() == 8 || ((C0691a) b4.getLayoutParams()).f1842g <= 0.0f)) {
                        b4.measure(MeasureSpec.makeMeasureSpec(i9, 1073741824), MeasureSpec.makeMeasureSpec(b4.getMeasuredHeight(), 1073741824));
                    }
                }
            }
            i3 = i16;
            i4 = i10;
        }
        if (obj3 != null || mode2 == 1073741824) {
            i3 = i4;
        }
        setMeasuredDimension((-16777216 & i6) | a2, ag.m1777a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, i6 << 16));
        if (obj4 != null) {
            m3333d(virtualChildCount, i);
        }
    }

    private void m3333d(int i, int i2) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 1073741824);
        for (int i3 = 0; i3 < i; i3++) {
            View b = m3344b(i3);
            if (b.getVisibility() != 8) {
                C0691a c0691a = (C0691a) b.getLayoutParams();
                if (c0691a.height == -1) {
                    int i4 = c0691a.width;
                    c0691a.width = b.getMeasuredWidth();
                    measureChildWithMargins(b, i2, 0, makeMeasureSpec, 0);
                    c0691a.width = i4;
                }
            }
        }
    }

    int m3335a(View view, int i) {
        return 0;
    }

    int m3350d(int i) {
        return 0;
    }

    void m3340a(View view, int i, int i2, int i3, int i4, int i5) {
        measureChildWithMargins(view, i2, i3, i4, i5);
    }

    int m3334a(View view) {
        return 0;
    }

    int m3341b(View view) {
        return 0;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1854d == 1) {
            m3337a(i, i2, i3, i4);
        } else {
            m3346b(i, i2, i3, i4);
        }
    }

    void m3337a(int i, int i2, int i3, int i4) {
        int paddingLeft = getPaddingLeft();
        int i5 = i3 - i;
        int paddingRight = i5 - getPaddingRight();
        int paddingRight2 = (i5 - paddingLeft) - getPaddingRight();
        int virtualChildCount = getVirtualChildCount();
        int i6 = this.f1855e & 8388615;
        switch (this.f1855e & 112) {
            case 16:
                i5 = getPaddingTop() + (((i4 - i2) - this.f1856f) / 2);
                break;
            case 80:
                i5 = ((getPaddingTop() + i4) - i2) - this.f1856f;
                break;
            default:
                i5 = getPaddingTop();
                break;
        }
        int i7 = 0;
        int i8 = i5;
        while (i7 < virtualChildCount) {
            View b = m3344b(i7);
            if (b == null) {
                i8 += m3350d(i7);
                i5 = i7;
            } else if (b.getVisibility() != 8) {
                int i9;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0691a c0691a = (C0691a) b.getLayoutParams();
                i5 = c0691a.f1843h;
                if (i5 < 0) {
                    i5 = i6;
                }
                switch (C0438e.m2046a(i5, ag.m1803e(this)) & 7) {
                    case 1:
                        i9 = ((((paddingRight2 - measuredWidth) / 2) + paddingLeft) + c0691a.leftMargin) - c0691a.rightMargin;
                        break;
                    case 5:
                        i9 = (paddingRight - measuredWidth) - c0691a.rightMargin;
                        break;
                    default:
                        i9 = paddingLeft + c0691a.leftMargin;
                        break;
                }
                if (m3349c(i7)) {
                    i5 = this.f1863m + i8;
                } else {
                    i5 = i8;
                }
                int i10 = i5 + c0691a.topMargin;
                m3331a(b, i9, i10 + m3334a(b), measuredWidth, measuredHeight);
                i8 = i10 + ((c0691a.bottomMargin + measuredHeight) + m3341b(b));
                i5 = m3335a(b, i7) + i7;
            } else {
                i5 = i7;
            }
            i7 = i5 + 1;
        }
    }

    void m3346b(int i, int i2, int i3, int i4) {
        int paddingLeft;
        int i5;
        int i6;
        boolean a = bb.m3805a(this);
        int paddingTop = getPaddingTop();
        int i7 = i4 - i2;
        int paddingBottom = i7 - getPaddingBottom();
        int paddingBottom2 = (i7 - paddingTop) - getPaddingBottom();
        int virtualChildCount = getVirtualChildCount();
        i7 = this.f1855e & 8388615;
        int i8 = this.f1855e & 112;
        boolean z = this.f1851a;
        int[] iArr = this.f1859i;
        int[] iArr2 = this.f1860j;
        switch (C0438e.m2046a(i7, ag.m1803e(this))) {
            case 1:
                paddingLeft = getPaddingLeft() + (((i3 - i) - this.f1856f) / 2);
                break;
            case 5:
                paddingLeft = ((getPaddingLeft() + i3) - i) - this.f1856f;
                break;
            default:
                paddingLeft = getPaddingLeft();
                break;
        }
        if (a) {
            i5 = -1;
            i6 = virtualChildCount - 1;
        } else {
            i5 = 1;
            i6 = 0;
        }
        int i9 = 0;
        while (i9 < virtualChildCount) {
            int i10 = i6 + (i5 * i9);
            View b = m3344b(i10);
            if (b == null) {
                paddingLeft += m3350d(i10);
                i7 = i9;
            } else if (b.getVisibility() != 8) {
                int i11;
                int measuredWidth = b.getMeasuredWidth();
                int measuredHeight = b.getMeasuredHeight();
                C0691a c0691a = (C0691a) b.getLayoutParams();
                if (!z || c0691a.height == -1) {
                    i7 = -1;
                } else {
                    i7 = b.getBaseline();
                }
                int i12 = c0691a.f1843h;
                if (i12 < 0) {
                    i12 = i8;
                }
                switch (i12 & 112) {
                    case 16:
                        i11 = ((((paddingBottom2 - measuredHeight) / 2) + paddingTop) + c0691a.topMargin) - c0691a.bottomMargin;
                        break;
                    case 48:
                        i11 = paddingTop + c0691a.topMargin;
                        if (i7 != -1) {
                            i11 += iArr[1] - i7;
                            break;
                        }
                        break;
                    case 80:
                        i11 = (paddingBottom - measuredHeight) - c0691a.bottomMargin;
                        if (i7 != -1) {
                            i11 -= iArr2[2] - (b.getMeasuredHeight() - i7);
                            break;
                        }
                        break;
                    default:
                        i11 = paddingTop;
                        break;
                }
                if (m3349c(i10)) {
                    i7 = this.f1862l + paddingLeft;
                } else {
                    i7 = paddingLeft;
                }
                paddingLeft = i7 + c0691a.leftMargin;
                m3331a(b, paddingLeft + m3334a(b), i11, measuredWidth, measuredHeight);
                paddingLeft += (c0691a.rightMargin + measuredWidth) + m3341b(b);
                i7 = m3335a(b, i10) + i9;
            } else {
                i7 = i9;
            }
            i9 = i7 + 1;
        }
    }

    private void m3331a(View view, int i, int i2, int i3, int i4) {
        view.layout(i, i2, i + i3, i2 + i4);
    }

    public void setOrientation(int i) {
        if (this.f1854d != i) {
            this.f1854d = i;
            requestLayout();
        }
    }

    public int getOrientation() {
        return this.f1854d;
    }

    public void setGravity(int i) {
        if (this.f1855e != i) {
            int i2;
            if ((8388615 & i) == 0) {
                i2 = 8388611 | i;
            } else {
                i2 = i;
            }
            if ((i2 & 112) == 0) {
                i2 |= 48;
            }
            this.f1855e = i2;
            requestLayout();
        }
    }

    public void setHorizontalGravity(int i) {
        int i2 = i & 8388615;
        if ((this.f1855e & 8388615) != i2) {
            this.f1855e = i2 | (this.f1855e & -8388616);
            requestLayout();
        }
    }

    public void setVerticalGravity(int i) {
        int i2 = i & 112;
        if ((this.f1855e & 112) != i2) {
            this.f1855e = i2 | (this.f1855e & -113);
            requestLayout();
        }
    }

    public C0691a mo590b(AttributeSet attributeSet) {
        return new C0691a(getContext(), attributeSet);
    }

    protected C0691a mo596j() {
        if (this.f1854d == 0) {
            return new C0691a(-2, -2);
        }
        if (this.f1854d == 1) {
            return new C0691a(-1, -2);
        }
        return null;
    }

    protected C0691a mo591b(LayoutParams layoutParams) {
        return new C0691a(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0691a;
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName(aj.class.getName());
        }
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        if (VERSION.SDK_INT >= 14) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName(aj.class.getName());
        }
    }
}
