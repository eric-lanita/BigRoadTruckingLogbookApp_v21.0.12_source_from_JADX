package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.view.C0480y;
import android.support.v4.view.C0481z;
import android.support.v4.view.ag;
import android.support.v4.view.ax;
import android.support.v4.view.bb;
import android.support.v4.view.bc;
import android.support.v4.widget.C0549w;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.view.menu.C0660l.C0607a;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window.Callback;

public class ActionBarOverlayLayout extends ViewGroup implements C0480y, af {
    static final int[] f1813a = new int[]{C0553a.actionBarSize, 16842841};
    private final Runnable f1814A;
    private final C0481z f1815B;
    private int f1816b;
    private int f1817c;
    private ContentFrameLayout f1818d;
    private ActionBarContainer f1819e;
    private ag f1820f;
    private Drawable f1821g;
    private boolean f1822h;
    private boolean f1823i;
    private boolean f1824j;
    private boolean f1825k;
    private boolean f1826l;
    private int f1827m;
    private int f1828n;
    private final Rect f1829o;
    private final Rect f1830p;
    private final Rect f1831q;
    private final Rect f1832r;
    private final Rect f1833s;
    private final Rect f1834t;
    private C0630a f1835u;
    private final int f1836v;
    private C0549w f1837w;
    private ax f1838x;
    private final bb f1839y;
    private final Runnable f1840z;

    public interface C0630a {
        void mo509a(int i);

        void mo512g(boolean z);

        void mo513l();

        void mo514m();

        void mo515n();

        void mo516o();
    }

    class C06851 extends bc {
        final /* synthetic */ ActionBarOverlayLayout f1810a;

        C06851(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1810a = actionBarOverlayLayout;
        }

        public void mo327b(View view) {
            this.f1810a.f1838x = null;
            this.f1810a.f1826l = false;
        }

        public void mo328c(View view) {
            this.f1810a.f1838x = null;
            this.f1810a.f1826l = false;
        }
    }

    class C06862 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1811a;

        C06862(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1811a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1811a.m3309k();
            this.f1811a.f1838x = ag.m1810j(this.f1811a.f1819e).m1986b(0.0f).m1983a(this.f1811a.f1839y);
        }
    }

    class C06873 implements Runnable {
        final /* synthetic */ ActionBarOverlayLayout f1812a;

        C06873(ActionBarOverlayLayout actionBarOverlayLayout) {
            this.f1812a = actionBarOverlayLayout;
        }

        public void run() {
            this.f1812a.m3309k();
            this.f1812a.f1838x = ag.m1810j(this.f1812a.f1819e).m1986b((float) (-this.f1812a.f1819e.getHeight())).m1983a(this.f1812a.f1839y);
        }
    }

    public static class C0688b extends MarginLayoutParams {
        public C0688b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0688b(int i, int i2) {
            super(i, i2);
        }

        public C0688b(LayoutParams layoutParams) {
            super(layoutParams);
        }
    }

    protected /* synthetic */ LayoutParams generateDefaultLayoutParams() {
        return m3318b();
    }

    public /* synthetic */ LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return m3314a(attributeSet);
    }

    public ActionBarOverlayLayout(Context context) {
        this(context, null);
    }

    public ActionBarOverlayLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1817c = 0;
        this.f1829o = new Rect();
        this.f1830p = new Rect();
        this.f1831q = new Rect();
        this.f1832r = new Rect();
        this.f1833s = new Rect();
        this.f1834t = new Rect();
        this.f1836v = 600;
        this.f1839y = new C06851(this);
        this.f1840z = new C06862(this);
        this.f1814A = new C06873(this);
        m3302a(context);
        this.f1815B = new C0481z(this);
    }

    private void m3302a(Context context) {
        boolean z = true;
        TypedArray obtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(f1813a);
        this.f1816b = obtainStyledAttributes.getDimensionPixelSize(0, 0);
        this.f1821g = obtainStyledAttributes.getDrawable(1);
        setWillNotDraw(this.f1821g == null);
        obtainStyledAttributes.recycle();
        if (context.getApplicationInfo().targetSdkVersion >= 19) {
            z = false;
        }
        this.f1822h = z;
        this.f1837w = C0549w.m2542a(context);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m3309k();
    }

    public void setActionBarVisibilityCallback(C0630a c0630a) {
        this.f1835u = c0630a;
        if (getWindowToken() != null) {
            this.f1835u.mo509a(this.f1817c);
            if (this.f1828n != 0) {
                onWindowSystemUiVisibilityChanged(this.f1828n);
                ag.m1813m(this);
            }
        }
    }

    public void setOverlayMode(boolean z) {
        this.f1823i = z;
        boolean z2 = z && getContext().getApplicationInfo().targetSdkVersion < 19;
        this.f1822h = z2;
    }

    public boolean m3317a() {
        return this.f1823i;
    }

    public void setHasNonEmbeddedTabs(boolean z) {
        this.f1824j = z;
    }

    public void setShowingForActionMode(boolean z) {
    }

    protected void onConfigurationChanged(Configuration configuration) {
        if (VERSION.SDK_INT >= 8) {
            super.onConfigurationChanged(configuration);
        }
        m3302a(getContext());
        ag.m1813m(this);
    }

    public void onWindowSystemUiVisibilityChanged(int i) {
        boolean z;
        boolean z2 = true;
        if (VERSION.SDK_INT >= 16) {
            super.onWindowSystemUiVisibilityChanged(i);
        }
        m3319c();
        int i2 = this.f1828n ^ i;
        this.f1828n = i;
        boolean z3 = (i & 4) == 0;
        if ((i & 256) != 0) {
            z = true;
        } else {
            z = false;
        }
        if (this.f1835u != null) {
            C0630a c0630a = this.f1835u;
            if (z) {
                z2 = false;
            }
            c0630a.mo512g(z2);
            if (z3 || !z) {
                this.f1835u.mo513l();
            } else {
                this.f1835u.mo514m();
            }
        }
        if ((i2 & 256) != 0 && this.f1835u != null) {
            ag.m1813m(this);
        }
    }

    protected void onWindowVisibilityChanged(int i) {
        super.onWindowVisibilityChanged(i);
        this.f1817c = i;
        if (this.f1835u != null) {
            this.f1835u.mo509a(i);
        }
    }

    private boolean m3306a(View view, Rect rect, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        C0688b c0688b = (C0688b) view.getLayoutParams();
        if (z && c0688b.leftMargin != rect.left) {
            c0688b.leftMargin = rect.left;
            z5 = true;
        }
        if (z2 && c0688b.topMargin != rect.top) {
            c0688b.topMargin = rect.top;
            z5 = true;
        }
        if (z4 && c0688b.rightMargin != rect.right) {
            c0688b.rightMargin = rect.right;
            z5 = true;
        }
        if (!z3 || c0688b.bottomMargin == rect.bottom) {
            return z5;
        }
        c0688b.bottomMargin = rect.bottom;
        return true;
    }

    protected boolean fitSystemWindows(Rect rect) {
        boolean a;
        m3319c();
        if ((ag.m1812l(this) & 256) != 0) {
            a = m3306a(this.f1819e, rect, true, true, false, true);
            this.f1832r.set(rect);
            bb.m3804a(this, this.f1832r, this.f1829o);
        } else {
            a = m3306a(this.f1819e, rect, true, true, false, true);
            this.f1832r.set(rect);
            bb.m3804a(this, this.f1832r, this.f1829o);
        }
        if (!this.f1830p.equals(this.f1829o)) {
            this.f1830p.set(this.f1829o);
            a = true;
        }
        if (a) {
            requestLayout();
        }
        return true;
    }

    protected C0688b m3318b() {
        return new C0688b(-1, -1);
    }

    public C0688b m3314a(AttributeSet attributeSet) {
        return new C0688b(getContext(), attributeSet);
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return new C0688b(layoutParams);
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return layoutParams instanceof C0688b;
    }

    protected void onMeasure(int i, int i2) {
        Object obj;
        int i3;
        m3319c();
        measureChildWithMargins(this.f1819e, i, 0, i2, 0);
        C0688b c0688b = (C0688b) this.f1819e.getLayoutParams();
        int max = Math.max(0, (this.f1819e.getMeasuredWidth() + c0688b.leftMargin) + c0688b.rightMargin);
        int max2 = Math.max(0, c0688b.bottomMargin + (this.f1819e.getMeasuredHeight() + c0688b.topMargin));
        int a = bb.m3803a(0, ag.m1807g(this.f1819e));
        if ((ag.m1812l(this) & 256) != 0) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            i3 = this.f1816b;
            if (this.f1824j && this.f1819e.getTabContainer() != null) {
                i3 += this.f1816b;
            }
        } else {
            i3 = this.f1819e.getVisibility() != 8 ? this.f1819e.getMeasuredHeight() : 0;
        }
        this.f1831q.set(this.f1829o);
        this.f1833s.set(this.f1832r);
        Rect rect;
        Rect rect2;
        if (this.f1823i || obj != null) {
            rect = this.f1833s;
            rect.top = i3 + rect.top;
            rect2 = this.f1833s;
            rect2.bottom += 0;
        } else {
            rect = this.f1831q;
            rect.top = i3 + rect.top;
            rect2 = this.f1831q;
            rect2.bottom += 0;
        }
        m3306a(this.f1818d, this.f1831q, true, true, true, true);
        if (!this.f1834t.equals(this.f1833s)) {
            this.f1834t.set(this.f1833s);
            this.f1818d.m2845a(this.f1833s);
        }
        measureChildWithMargins(this.f1818d, i, 0, i2, 0);
        c0688b = (C0688b) this.f1818d.getLayoutParams();
        int max3 = Math.max(max, (this.f1818d.getMeasuredWidth() + c0688b.leftMargin) + c0688b.rightMargin);
        i3 = Math.max(max2, c0688b.bottomMargin + (this.f1818d.getMeasuredHeight() + c0688b.topMargin));
        int a2 = bb.m3803a(a, ag.m1807g(this.f1818d));
        setMeasuredDimension(ag.m1777a(Math.max(max3 + (getPaddingLeft() + getPaddingRight()), getSuggestedMinimumWidth()), i, a2), ag.m1777a(Math.max(i3 + (getPaddingTop() + getPaddingBottom()), getSuggestedMinimumHeight()), i2, a2 << 16));
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int childCount = getChildCount();
        int paddingLeft = getPaddingLeft();
        int paddingRight = (i3 - i) - getPaddingRight();
        int paddingTop = getPaddingTop();
        paddingRight = (i4 - i2) - getPaddingBottom();
        for (int i5 = 0; i5 < childCount; i5++) {
            View childAt = getChildAt(i5);
            if (childAt.getVisibility() != 8) {
                C0688b c0688b = (C0688b) childAt.getLayoutParams();
                int i6 = c0688b.leftMargin + paddingLeft;
                paddingRight = c0688b.topMargin + paddingTop;
                childAt.layout(i6, paddingRight, childAt.getMeasuredWidth() + i6, childAt.getMeasuredHeight() + paddingRight);
            }
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1821g != null && !this.f1822h) {
            int bottom = this.f1819e.getVisibility() == 0 ? (int) ((((float) this.f1819e.getBottom()) + ag.m1808h(this.f1819e)) + 0.5f) : 0;
            this.f1821g.setBounds(0, bottom, getWidth(), this.f1821g.getIntrinsicHeight() + bottom);
            this.f1821g.draw(canvas);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        if ((i & 2) == 0 || this.f1819e.getVisibility() != 0) {
            return false;
        }
        return this.f1825k;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1815B.m2168a(view, view2, i);
        this.f1827m = getActionBarHideOffset();
        m3309k();
        if (this.f1835u != null) {
            this.f1835u.mo515n();
        }
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        this.f1827m += i2;
        setActionBarHideOffset(this.f1827m);
    }

    public void onStopNestedScroll(View view) {
        if (this.f1825k && !this.f1826l) {
            if (this.f1827m <= this.f1819e.getHeight()) {
                m3310l();
            } else {
                m3311m();
            }
        }
        if (this.f1835u != null) {
            this.f1835u.mo516o();
        }
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (!this.f1825k || !z) {
            return false;
        }
        if (m3304a(f, f2)) {
            m3313o();
        } else {
            m3312n();
        }
        this.f1826l = true;
        return true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return false;
    }

    public int getNestedScrollAxes() {
        return this.f1815B.m2166a();
    }

    void m3319c() {
        if (this.f1818d == null) {
            this.f1818d = (ContentFrameLayout) findViewById(C0558f.action_bar_activity_content);
            this.f1819e = (ActionBarContainer) findViewById(C0558f.action_bar_container);
            this.f1820f = m3301a(findViewById(C0558f.action_bar));
        }
    }

    private ag m3301a(View view) {
        if (view instanceof ag) {
            return (ag) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException("Can't make a decor toolbar out of " + view.getClass().getSimpleName());
    }

    public void setHideOnContentScrollEnabled(boolean z) {
        if (z != this.f1825k) {
            this.f1825k = z;
            if (!z) {
                m3309k();
                setActionBarHideOffset(0);
            }
        }
    }

    public int getActionBarHideOffset() {
        return this.f1819e != null ? -((int) ag.m1808h(this.f1819e)) : 0;
    }

    public void setActionBarHideOffset(int i) {
        m3309k();
        ag.m1780a(this.f1819e, (float) (-Math.max(0, Math.min(i, this.f1819e.getHeight()))));
    }

    private void m3309k() {
        removeCallbacks(this.f1840z);
        removeCallbacks(this.f1814A);
        if (this.f1838x != null) {
            this.f1838x.m1988b();
        }
    }

    private void m3310l() {
        m3309k();
        postDelayed(this.f1840z, 600);
    }

    private void m3311m() {
        m3309k();
        postDelayed(this.f1814A, 600);
    }

    private void m3312n() {
        m3309k();
        this.f1840z.run();
    }

    private void m3313o() {
        m3309k();
        this.f1814A.run();
    }

    private boolean m3304a(float f, float f2) {
        this.f1837w.m2546a(0, 0, 0, (int) f2, 0, 0, Integer.MIN_VALUE, Integer.MAX_VALUE);
        if (this.f1837w.m2553e() > this.f1819e.getHeight()) {
            return true;
        }
        return false;
    }

    public void setWindowCallback(Callback callback) {
        m3319c();
        this.f1820f.mo641a(callback);
    }

    public void setWindowTitle(CharSequence charSequence) {
        m3319c();
        this.f1820f.mo642a(charSequence);
    }

    public CharSequence getTitle() {
        m3319c();
        return this.f1820f.mo650e();
    }

    public void mo579a(int i) {
        m3319c();
        switch (i) {
            case 2:
                this.f1820f.mo651f();
                return;
            case 5:
                this.f1820f.mo652g();
                return;
            case 109:
                setOverlayMode(true);
                return;
            default:
                return;
        }
    }

    public void setUiOptions(int i) {
    }

    public void setIcon(int i) {
        m3319c();
        this.f1820f.mo636a(i);
    }

    public void setIcon(Drawable drawable) {
        m3319c();
        this.f1820f.mo637a(drawable);
    }

    public void setLogo(int i) {
        m3319c();
        this.f1820f.mo645b(i);
    }

    public boolean mo581d() {
        m3319c();
        return this.f1820f.mo653h();
    }

    public boolean mo582e() {
        m3319c();
        return this.f1820f.mo654i();
    }

    public boolean mo583f() {
        m3319c();
        return this.f1820f.mo655j();
    }

    public boolean mo584g() {
        m3319c();
        return this.f1820f.mo656k();
    }

    public boolean mo585h() {
        m3319c();
        return this.f1820f.mo657l();
    }

    public void mo586i() {
        m3319c();
        this.f1820f.mo658m();
    }

    public void mo580a(Menu menu, C0607a c0607a) {
        m3319c();
        this.f1820f.mo640a(menu, c0607a);
    }

    public void mo587j() {
        m3319c();
        this.f1820f.mo659n();
    }
}
