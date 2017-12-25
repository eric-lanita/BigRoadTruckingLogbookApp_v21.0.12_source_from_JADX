package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.C0658m;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.view.menu.C0666f.C0657b;
import android.support.v7.view.menu.C0669h;
import android.support.v7.widget.aj.C0691a;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewDebug.ExportedProperty;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityEvent;

public class ActionMenuView extends aj implements C0657b, C0658m {
    private C0666f f1866a;
    private Context f1867b;
    private int f1868c;
    private boolean f1869d;
    private C0747d f1870e;
    private C0607a f1871f;
    private C0591a f1872g;
    private boolean f1873h;
    private int f1874i;
    private int f1875j;
    private int f1876k;
    private C0694e f1877l;

    public interface C0656a {
        boolean mo525c();

        boolean mo526d();
    }

    private class C0690b implements C0607a {
        final /* synthetic */ ActionMenuView f1841a;

        private C0690b(ActionMenuView actionMenuView) {
            this.f1841a = actionMenuView;
        }

        public void mo471a(C0666f c0666f, boolean z) {
        }

        public boolean a_(C0666f c0666f) {
            return false;
        }
    }

    public static class C0692c extends C0691a {
        @ExportedProperty
        public boolean f1844a;
        @ExportedProperty
        public int f1845b;
        @ExportedProperty
        public int f1846c;
        @ExportedProperty
        public boolean f1847d;
        @ExportedProperty
        public boolean f1848e;
        boolean f1849f;

        public C0692c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0692c(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0692c(C0692c c0692c) {
            super(c0692c);
            this.f1844a = c0692c.f1844a;
        }

        public C0692c(int i, int i2) {
            super(i, i2);
            this.f1844a = false;
        }
    }

    private class C0693d implements C0591a {
        final /* synthetic */ ActionMenuView f1850a;

        private C0693d(ActionMenuView actionMenuView) {
            this.f1850a = actionMenuView;
        }

        public boolean mo449a(C0666f c0666f, MenuItem menuItem) {
            return this.f1850a.f1877l != null && this.f1850a.f1877l.mo607a(menuItem);
        }

        public void mo445a(C0666f c0666f) {
            if (this.f1850a.f1872g != null) {
                this.f1850a.f1872g.mo445a(c0666f);
            }
        }
    }

    public interface C0694e {
        boolean mo607a(MenuItem menuItem);
    }

    public /* synthetic */ C0691a mo590b(AttributeSet attributeSet) {
        return m3356a(attributeSet);
    }

    protected /* synthetic */ C0691a mo591b(LayoutParams layoutParams) {
        return m3357a(layoutParams);
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3363b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3356a(attributeSet);
    }

    protected /* synthetic */ LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return m3357a(layoutParams);
    }

    protected /* synthetic */ C0691a mo596j() {
        return m3363b();
    }

    public ActionMenuView(Context context) {
        this(context, null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f1875j = (int) (56.0f * f);
        this.f1876k = (int) (f * 4.0f);
        this.f1867b = context;
        this.f1868c = 0;
    }

    public void setPopupTheme(int i) {
        if (this.f1868c != i) {
            this.f1868c = i;
            if (i == 0) {
                this.f1867b = getContext();
            } else {
                this.f1867b = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public int getPopupTheme() {
        return this.f1868c;
    }

    public void setPresenter(C0747d c0747d) {
        this.f1870e = c0747d;
        this.f1870e.m3834a(this);
    }

    public void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        if (this.f1870e != null) {
            this.f1870e.mo545b(false);
            if (this.f1870e.m3848h()) {
                this.f1870e.m3845e();
                this.f1870e.m3844d();
            }
        }
    }

    public void setOnMenuItemClickListener(C0694e c0694e) {
        this.f1877l = c0694e;
    }

    protected void onMeasure(int i, int i2) {
        boolean z = this.f1873h;
        this.f1873h = MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f1873h) {
            this.f1874i = 0;
        }
        int size = MeasureSpec.getSize(i);
        if (!(!this.f1873h || this.f1866a == null || size == this.f1874i)) {
            this.f1874i = size;
            this.f1866a.m3167b(true);
        }
        int childCount = getChildCount();
        if (!this.f1873h || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0692c c0692c = (C0692c) getChildAt(i3).getLayoutParams();
                c0692c.rightMargin = 0;
                c0692c.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m3355c(i, i2);
    }

    private void m3355c(int i, int i2) {
        int mode = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingTop = getPaddingTop() + getPaddingBottom();
        int childMeasureSpec = getChildMeasureSpec(i2, paddingTop, -2);
        int i3 = size - paddingLeft;
        int i4 = i3 / this.f1875j;
        size = i3 % this.f1875j;
        if (i4 == 0) {
            setMeasuredDimension(i3, 0);
            return;
        }
        int i5;
        C0692c c0692c;
        Object obj;
        Object obj2;
        int i6 = this.f1875j + (size / i4);
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        paddingLeft = 0;
        Object obj3 = null;
        long j = 0;
        int childCount = getChildCount();
        int i10 = 0;
        while (i10 < childCount) {
            int i11;
            long j2;
            int i12;
            int i13;
            View childAt = getChildAt(i10);
            if (childAt.getVisibility() == 8) {
                i11 = paddingLeft;
                j2 = j;
                i12 = i7;
                i13 = i4;
                i4 = i8;
            } else {
                boolean z = childAt instanceof ActionMenuItemView;
                i5 = paddingLeft + 1;
                if (z) {
                    childAt.setPadding(this.f1876k, 0, this.f1876k, 0);
                }
                c0692c = (C0692c) childAt.getLayoutParams();
                c0692c.f1849f = false;
                c0692c.f1846c = 0;
                c0692c.f1845b = 0;
                c0692c.f1847d = false;
                c0692c.leftMargin = 0;
                c0692c.rightMargin = 0;
                boolean z2 = z && ((ActionMenuItemView) childAt).m3075b();
                c0692c.f1848e = z2;
                if (c0692c.f1844a) {
                    paddingLeft = 1;
                } else {
                    paddingLeft = i4;
                }
                int a = m3352a(childAt, i6, paddingLeft, childMeasureSpec, paddingTop);
                i8 = Math.max(i8, a);
                if (c0692c.f1847d) {
                    paddingLeft = i9 + 1;
                } else {
                    paddingLeft = i9;
                }
                if (c0692c.f1844a) {
                    obj = 1;
                } else {
                    obj = obj3;
                }
                int i14 = i4 - a;
                i9 = Math.max(i7, childAt.getMeasuredHeight());
                if (a == 1) {
                    long j3 = ((long) (1 << i10)) | j;
                    i12 = i9;
                    i13 = i14;
                    i9 = paddingLeft;
                    obj3 = obj;
                    j2 = j3;
                    i4 = i8;
                    i11 = i5;
                } else {
                    i11 = i5;
                    i4 = i8;
                    long j4 = j;
                    i12 = i9;
                    i13 = i14;
                    obj3 = obj;
                    i9 = paddingLeft;
                    j2 = j4;
                }
            }
            i10++;
            i8 = i4;
            i7 = i12;
            i4 = i13;
            j = j2;
            paddingLeft = i11;
        }
        if (obj3 == null || paddingLeft != 2) {
            obj2 = null;
        } else {
            obj2 = 1;
        }
        Object obj4 = null;
        long j5 = j;
        paddingTop = i4;
        while (i9 > 0 && paddingTop > 0) {
            i5 = Integer.MAX_VALUE;
            j = 0;
            i4 = 0;
            int i15 = 0;
            while (i15 < childCount) {
                c0692c = (C0692c) getChildAt(i15).getLayoutParams();
                if (!c0692c.f1847d) {
                    size = i4;
                    i4 = i5;
                } else if (c0692c.f1845b < i5) {
                    i4 = c0692c.f1845b;
                    j = (long) (1 << i15);
                    size = 1;
                } else if (c0692c.f1845b == i5) {
                    j |= (long) (1 << i15);
                    size = i4 + 1;
                    i4 = i5;
                } else {
                    size = i4;
                    i4 = i5;
                }
                i15++;
                i5 = i4;
                i4 = size;
            }
            j5 |= j;
            if (i4 > paddingTop) {
                j = j5;
                break;
            }
            i15 = i5 + 1;
            i5 = 0;
            i4 = paddingTop;
            long j6 = j5;
            while (i5 < childCount) {
                View childAt2 = getChildAt(i5);
                c0692c = (C0692c) childAt2.getLayoutParams();
                if ((((long) (1 << i5)) & j) != 0) {
                    if (obj2 != null && c0692c.f1848e && i4 == 1) {
                        childAt2.setPadding(this.f1876k + i6, 0, this.f1876k, 0);
                    }
                    c0692c.f1845b++;
                    c0692c.f1849f = true;
                    size = i4 - 1;
                } else if (c0692c.f1845b == i15) {
                    j6 |= (long) (1 << i5);
                    size = i4;
                } else {
                    size = i4;
                }
                i5++;
                i4 = size;
            }
            j5 = j6;
            i10 = 1;
            paddingTop = i4;
        }
        j = j5;
        obj = (obj3 == null && paddingLeft == 1) ? 1 : null;
        if (paddingTop <= 0 || j == 0 || (paddingTop >= paddingLeft - 1 && obj == null && i8 <= 1)) {
            obj2 = obj4;
        } else {
            float f;
            View childAt3;
            float bitCount = (float) Long.bitCount(j);
            if (obj == null) {
                if (!((1 & j) == 0 || ((C0692c) getChildAt(0).getLayoutParams()).f1848e)) {
                    bitCount -= 0.5f;
                }
                if (!((((long) (1 << (childCount - 1))) & j) == 0 || ((C0692c) getChildAt(childCount - 1).getLayoutParams()).f1848e)) {
                    f = bitCount - 0.5f;
                    paddingLeft = f <= 0.0f ? (int) (((float) (paddingTop * i6)) / f) : 0;
                    i4 = 0;
                    obj2 = obj4;
                    while (i4 < childCount) {
                        if ((((long) (1 << i4)) & j) != 0) {
                            obj = obj2;
                        } else {
                            childAt3 = getChildAt(i4);
                            c0692c = (C0692c) childAt3.getLayoutParams();
                            if (childAt3 instanceof ActionMenuItemView) {
                                c0692c.f1846c = paddingLeft;
                                c0692c.f1849f = true;
                                if (i4 == 0 && !c0692c.f1848e) {
                                    c0692c.leftMargin = (-paddingLeft) / 2;
                                }
                                obj = 1;
                            } else if (c0692c.f1844a) {
                                if (i4 != 0) {
                                    c0692c.leftMargin = paddingLeft / 2;
                                }
                                if (i4 != childCount - 1) {
                                    c0692c.rightMargin = paddingLeft / 2;
                                }
                                obj = obj2;
                            } else {
                                c0692c.f1846c = paddingLeft;
                                c0692c.f1849f = true;
                                c0692c.rightMargin = (-paddingLeft) / 2;
                                obj = 1;
                            }
                        }
                        i4++;
                        obj2 = obj;
                    }
                }
            }
            f = bitCount;
            if (f <= 0.0f) {
            }
            i4 = 0;
            obj2 = obj4;
            while (i4 < childCount) {
                if ((((long) (1 << i4)) & j) != 0) {
                    childAt3 = getChildAt(i4);
                    c0692c = (C0692c) childAt3.getLayoutParams();
                    if (childAt3 instanceof ActionMenuItemView) {
                        c0692c.f1846c = paddingLeft;
                        c0692c.f1849f = true;
                        c0692c.leftMargin = (-paddingLeft) / 2;
                        obj = 1;
                    } else if (c0692c.f1844a) {
                        if (i4 != 0) {
                            c0692c.leftMargin = paddingLeft / 2;
                        }
                        if (i4 != childCount - 1) {
                            c0692c.rightMargin = paddingLeft / 2;
                        }
                        obj = obj2;
                    } else {
                        c0692c.f1846c = paddingLeft;
                        c0692c.f1849f = true;
                        c0692c.rightMargin = (-paddingLeft) / 2;
                        obj = 1;
                    }
                } else {
                    obj = obj2;
                }
                i4++;
                obj2 = obj;
            }
        }
        if (obj2 != null) {
            for (paddingLeft = 0; paddingLeft < childCount; paddingLeft++) {
                childAt = getChildAt(paddingLeft);
                c0692c = (C0692c) childAt.getLayoutParams();
                if (c0692c.f1849f) {
                    childAt.measure(MeasureSpec.makeMeasureSpec(c0692c.f1846c + (c0692c.f1845b * i6), 1073741824), childMeasureSpec);
                }
            }
        }
        if (mode == 1073741824) {
            i7 = size2;
        }
        setMeasuredDimension(i3, i7);
    }

    static int m3352a(View view, int i, int i2, int i3, int i4) {
        boolean z;
        int i5;
        boolean z2 = false;
        C0692c c0692c = (C0692c) view.getLayoutParams();
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i3) - i4, MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        if (actionMenuItemView == null || !actionMenuItemView.m3075b()) {
            z = false;
        } else {
            z = true;
        }
        if (i2 <= 0 || (z && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(MeasureSpec.makeMeasureSpec(i * i2, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            i5 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i5++;
            }
            if (z && r1 < 2) {
                i5 = 2;
            }
        }
        if (!c0692c.f1844a && z) {
            z2 = true;
        }
        c0692c.f1847d = z2;
        c0692c.f1845b = i5;
        view.measure(MeasureSpec.makeMeasureSpec(i5 * i, 1073741824), makeMeasureSpec);
        return i5;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        if (this.f1873h) {
            int i5;
            int i6;
            C0692c c0692c;
            int paddingLeft;
            int childCount = getChildCount();
            int i7 = (i4 - i2) / 2;
            int dividerWidth = getDividerWidth();
            int i8 = 0;
            int i9 = 0;
            int paddingRight = ((i3 - i) - getPaddingRight()) - getPaddingLeft();
            Object obj = null;
            boolean a = bb.m3805a(this);
            int i10 = 0;
            while (i10 < childCount) {
                Object obj2;
                View childAt = getChildAt(i10);
                if (childAt.getVisibility() == 8) {
                    obj2 = obj;
                    i5 = i9;
                    i6 = paddingRight;
                    paddingRight = i8;
                } else {
                    c0692c = (C0692c) childAt.getLayoutParams();
                    if (c0692c.f1844a) {
                        i6 = childAt.getMeasuredWidth();
                        if (m3361a(i10)) {
                            i6 += dividerWidth;
                        }
                        int measuredHeight = childAt.getMeasuredHeight();
                        if (a) {
                            paddingLeft = c0692c.leftMargin + getPaddingLeft();
                            i5 = paddingLeft + i6;
                        } else {
                            i5 = (getWidth() - getPaddingRight()) - c0692c.rightMargin;
                            paddingLeft = i5 - i6;
                        }
                        int i11 = i7 - (measuredHeight / 2);
                        childAt.layout(paddingLeft, i11, i5, measuredHeight + i11);
                        i6 = paddingRight - i6;
                        obj2 = 1;
                        i5 = i9;
                        paddingRight = i8;
                    } else {
                        i5 = (childAt.getMeasuredWidth() + c0692c.leftMargin) + c0692c.rightMargin;
                        paddingLeft = i8 + i5;
                        i5 = paddingRight - i5;
                        if (m3361a(i10)) {
                            paddingLeft += dividerWidth;
                        }
                        Object obj3 = obj;
                        i6 = i5;
                        i5 = i9 + 1;
                        paddingRight = paddingLeft;
                        obj2 = obj3;
                    }
                }
                i10++;
                i8 = paddingRight;
                paddingRight = i6;
                i9 = i5;
                obj = obj2;
            }
            if (childCount == 1 && obj == null) {
                View childAt2 = getChildAt(0);
                i6 = childAt2.getMeasuredWidth();
                i5 = childAt2.getMeasuredHeight();
                paddingRight = ((i3 - i) / 2) - (i6 / 2);
                i9 = i7 - (i5 / 2);
                childAt2.layout(paddingRight, i9, i6 + paddingRight, i5 + i9);
                return;
            }
            paddingLeft = i9 - (obj != null ? 0 : 1);
            paddingRight = Math.max(0, paddingLeft > 0 ? paddingRight / paddingLeft : 0);
            View childAt3;
            if (a) {
                i6 = getWidth() - getPaddingRight();
                i5 = 0;
                while (i5 < childCount) {
                    childAt3 = getChildAt(i5);
                    c0692c = (C0692c) childAt3.getLayoutParams();
                    if (childAt3.getVisibility() == 8) {
                        paddingLeft = i6;
                    } else if (c0692c.f1844a) {
                        paddingLeft = i6;
                    } else {
                        i6 -= c0692c.rightMargin;
                        i8 = childAt3.getMeasuredWidth();
                        i10 = childAt3.getMeasuredHeight();
                        dividerWidth = i7 - (i10 / 2);
                        childAt3.layout(i6 - i8, dividerWidth, i6, i10 + dividerWidth);
                        paddingLeft = i6 - ((c0692c.leftMargin + i8) + paddingRight);
                    }
                    i5++;
                    i6 = paddingLeft;
                }
                return;
            }
            i6 = getPaddingLeft();
            i5 = 0;
            while (i5 < childCount) {
                childAt3 = getChildAt(i5);
                c0692c = (C0692c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() == 8) {
                    paddingLeft = i6;
                } else if (c0692c.f1844a) {
                    paddingLeft = i6;
                } else {
                    i6 += c0692c.leftMargin;
                    i8 = childAt3.getMeasuredWidth();
                    i10 = childAt3.getMeasuredHeight();
                    dividerWidth = i7 - (i10 / 2);
                    childAt3.layout(i6, dividerWidth, i6 + i8, i10 + dividerWidth);
                    paddingLeft = ((c0692c.rightMargin + i8) + paddingRight) + i6;
                }
                i5++;
                i6 = paddingLeft;
            }
            return;
        }
        super.onLayout(z, i, i2, i3, i4);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3372i();
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f1870e.m3831a(drawable);
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f1870e.m3841c();
    }

    public boolean m3360a() {
        return this.f1869d;
    }

    public void setOverflowReserved(boolean z) {
        this.f1869d = z;
    }

    protected C0692c m3363b() {
        C0692c c0692c = new C0692c(-2, -2);
        c0692c.h = 16;
        return c0692c;
    }

    public C0692c m3356a(AttributeSet attributeSet) {
        return new C0692c(getContext(), attributeSet);
    }

    protected C0692c m3357a(LayoutParams layoutParams) {
        if (layoutParams == null) {
            return m3363b();
        }
        C0692c c0692c = layoutParams instanceof C0692c ? new C0692c((C0692c) layoutParams) : new C0692c(layoutParams);
        if (c0692c.h > 0) {
            return c0692c;
        }
        c0692c.h = 16;
        return c0692c;
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams != null && (layoutParams instanceof C0692c);
    }

    public C0692c m3366c() {
        C0692c b = m3363b();
        b.f1844a = true;
        return b;
    }

    public boolean mo529a(C0669h c0669h) {
        return this.f1866a.m3161a((MenuItem) c0669h, 0);
    }

    public int getWindowAnimations() {
        return 0;
    }

    public void mo528a(C0666f c0666f) {
        this.f1866a = c0666f;
    }

    public Menu getMenu() {
        if (this.f1866a == null) {
            Context context = getContext();
            this.f1866a = new C0666f(context);
            this.f1866a.mo563a(new C0693d());
            this.f1870e = new C0747d(context);
            this.f1870e.m3842c(true);
            this.f1870e.m3108a(this.f1871f != null ? this.f1871f : new C0690b());
            this.f1866a.m3156a(this.f1870e, this.f1867b);
            this.f1870e.m3834a(this);
        }
        return this.f1866a;
    }

    public void m3359a(C0607a c0607a, C0591a c0591a) {
        this.f1871f = c0607a;
        this.f1872g = c0591a;
    }

    public C0666f m3367d() {
        return this.f1866a;
    }

    public boolean m3368e() {
        return this.f1870e != null && this.f1870e.m3844d();
    }

    public boolean m3369f() {
        return this.f1870e != null && this.f1870e.m3845e();
    }

    public boolean m3370g() {
        return this.f1870e != null && this.f1870e.m3848h();
    }

    public boolean m3371h() {
        return this.f1870e != null && this.f1870e.m3849i();
    }

    public void m3372i() {
        if (this.f1870e != null) {
            this.f1870e.m3846f();
        }
    }

    protected boolean m3361a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0656a)) {
            z = 0 | ((C0656a) childAt).mo526d();
        }
        return (i <= 0 || !(childAt2 instanceof C0656a)) ? z : ((C0656a) childAt2).mo525c() | z;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f1870e.m3843d(z);
    }
}
