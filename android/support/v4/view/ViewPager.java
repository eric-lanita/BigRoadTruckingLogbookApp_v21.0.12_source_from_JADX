package android.support.v4.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.os.C0320d;
import android.support.v4.os.C0321e;
import android.support.v4.view.p009a.C0352a;
import android.support.v4.view.p009a.C0362b;
import android.support.v4.view.p009a.C0383h;
import android.support.v4.widget.C0521i;
import android.util.AttributeSet;
import android.util.Log;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.SoundEffectConstants;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import com.facebook.internal.Utility;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ViewPager extends ViewGroup {
    private static final int[] f936a = new int[]{16842931};
    private static final C0339j ai = new C0339j();
    private static final Comparator<C0330b> f937c = new C03241();
    private static final Interpolator f938d = new C03252();
    private int f939A = 1;
    private boolean f940B;
    private boolean f941C;
    private int f942D;
    private int f943E;
    private int f944F;
    private float f945G;
    private float f946H;
    private float f947I;
    private float f948J;
    private int f949K = -1;
    private VelocityTracker f950L;
    private int f951M;
    private int f952N;
    private int f953O;
    private int f954P;
    private boolean f955Q;
    private C0521i f956R;
    private C0521i f957S;
    private boolean f958T = true;
    private boolean f959U = false;
    private boolean f960V;
    private int f961W;
    private List<C0335f> aa;
    private C0335f ab;
    private C0335f ac;
    private C0334e ad;
    private C0336g ae;
    private Method af;
    private int ag;
    private ArrayList<View> ah;
    private final Runnable aj = new C03263(this);
    private int ak = 0;
    private int f962b;
    private final ArrayList<C0330b> f963e = new ArrayList();
    private final C0330b f964f = new C0330b();
    private final Rect f965g = new Rect();
    private ab f966h;
    private int f967i;
    private int f968j = -1;
    private Parcelable f969k = null;
    private ClassLoader f970l = null;
    private Scroller f971m;
    private boolean f972n;
    private C0337h f973o;
    private int f974p;
    private Drawable f975q;
    private int f976r;
    private int f977s;
    private float f978t = -3.4028235E38f;
    private float f979u = Float.MAX_VALUE;
    private int f980v;
    private int f981w;
    private boolean f982x;
    private boolean f983y;
    private boolean f984z;

    static class C03241 implements Comparator<C0330b> {
        C03241() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1286a((C0330b) obj, (C0330b) obj2);
        }

        public int m1286a(C0330b c0330b, C0330b c0330b2) {
            return c0330b.f921b - c0330b2.f921b;
        }
    }

    static class C03252 implements Interpolator {
        C03252() {
        }

        public float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * (((f2 * f2) * f2) * f2)) + 1.0f;
        }
    }

    class C03263 implements Runnable {
        final /* synthetic */ ViewPager f914a;

        C03263(ViewPager viewPager) {
            this.f914a = viewPager;
        }

        public void run() {
            this.f914a.setScrollState(0);
            this.f914a.m1355c();
        }
    }

    class C03274 implements aa {
        final /* synthetic */ ViewPager f915a;
        private final Rect f916b = new Rect();

        C03274(ViewPager viewPager) {
            this.f915a = viewPager;
        }

        public be mo184a(View view, be beVar) {
            be a = ag.m1779a(view, beVar);
            if (a.mo335e()) {
                return a;
            }
            Rect rect = this.f916b;
            rect.left = a.mo330a();
            rect.top = a.mo332b();
            rect.right = a.mo333c();
            rect.bottom = a.mo334d();
            int childCount = this.f915a.getChildCount();
            for (int i = 0; i < childCount; i++) {
                be b = ag.m1792b(this.f915a.getChildAt(i), a);
                rect.left = Math.min(b.mo330a(), rect.left);
                rect.top = Math.min(b.mo332b(), rect.top);
                rect.right = Math.min(b.mo333c(), rect.right);
                rect.bottom = Math.min(b.mo334d(), rect.bottom);
            }
            return a.mo331a(rect.left, rect.top, rect.right, rect.bottom);
        }
    }

    public static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = C0320d.m1282a(new C03281());
        int f917a;
        Parcelable f918b;
        ClassLoader f919c;

        static class C03281 implements C0321e<SavedState> {
            C03281() {
            }

            public /* synthetic */ Object mo185a(Parcel parcel, ClassLoader classLoader) {
                return m1291b(parcel, classLoader);
            }

            public /* synthetic */ Object[] mo186a(int i) {
                return m1292b(i);
            }

            public SavedState m1291b(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState[] m1292b(int i) {
                return new SavedState[i];
            }
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f917a);
            parcel.writeParcelable(this.f918b, i);
        }

        public String toString() {
            return "FragmentPager.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " position=" + this.f917a + "}";
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel);
            if (classLoader == null) {
                classLoader = getClass().getClassLoader();
            }
            this.f917a = parcel.readInt();
            this.f918b = parcel.readParcelable(classLoader);
            this.f919c = classLoader;
        }
    }

    interface C0329a {
    }

    static class C0330b {
        Object f920a;
        int f921b;
        boolean f922c;
        float f923d;
        float f924e;

        C0330b() {
        }
    }

    public static class C0331c extends LayoutParams {
        public boolean f925a;
        public int f926b;
        float f927c = 0.0f;
        boolean f928d;
        int f929e;
        int f930f;

        public C0331c() {
            super(-1, -1);
        }

        public C0331c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, ViewPager.f936a);
            this.f926b = obtainStyledAttributes.getInteger(0, 48);
            obtainStyledAttributes.recycle();
        }
    }

    class C0333d extends C0332a {
        final /* synthetic */ ViewPager f934b;

        C0333d(ViewPager viewPager) {
            this.f934b = viewPager;
        }

        public void mo189d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo189d(view, accessibilityEvent);
            accessibilityEvent.setClassName(ViewPager.class.getName());
            C0383h a = C0352a.m1425a(accessibilityEvent);
            a.m1583a(m1303b());
            if (accessibilityEvent.getEventType() == 4096 && this.f934b.f966h != null) {
                a.m1582a(this.f934b.f966h.mo1334a());
                a.m1584b(this.f934b.f967i);
                a.m1585c(this.f934b.f967i);
            }
        }

        public void mo187a(View view, C0362b c0362b) {
            super.mo187a(view, c0362b);
            c0362b.m1493a(ViewPager.class.getName());
            c0362b.m1494a(m1303b());
            if (this.f934b.canScrollHorizontally(1)) {
                c0362b.m1491a(4096);
            }
            if (this.f934b.canScrollHorizontally(-1)) {
                c0362b.m1491a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
            }
        }

        public boolean mo188a(View view, int i, Bundle bundle) {
            if (super.mo188a(view, i, bundle)) {
                return true;
            }
            switch (i) {
                case 4096:
                    if (!this.f934b.canScrollHorizontally(1)) {
                        return false;
                    }
                    this.f934b.setCurrentItem(this.f934b.f967i + 1);
                    return true;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    if (!this.f934b.canScrollHorizontally(-1)) {
                        return false;
                    }
                    this.f934b.setCurrentItem(this.f934b.f967i - 1);
                    return true;
                default:
                    return false;
            }
        }

        private boolean m1303b() {
            return this.f934b.f966h != null && this.f934b.f966h.mo1334a() > 1;
        }
    }

    interface C0334e {
        void m1307a(ab abVar, ab abVar2);
    }

    public interface C0335f {
        void mo190a(int i);

        void mo191a(int i, float f, int i2);

        void mo192b(int i);
    }

    public interface C0336g {
        void m1311a(View view, float f);
    }

    private class C0337h extends DataSetObserver {
        final /* synthetic */ ViewPager f935a;

        private C0337h(ViewPager viewPager) {
            this.f935a = viewPager;
        }

        public void onChanged() {
            this.f935a.m1354b();
        }

        public void onInvalidated() {
            this.f935a.m1354b();
        }
    }

    public static class C0338i implements C0335f {
        public void mo191a(int i, float f, int i2) {
        }

        public void mo190a(int i) {
        }

        public void mo192b(int i) {
        }
    }

    static class C0339j implements Comparator<View> {
        C0339j() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m1315a((View) obj, (View) obj2);
        }

        public int m1315a(View view, View view2) {
            C0331c c0331c = (C0331c) view.getLayoutParams();
            C0331c c0331c2 = (C0331c) view2.getLayoutParams();
            if (c0331c.f925a != c0331c2.f925a) {
                return c0331c.f925a ? 1 : -1;
            } else {
                return c0331c.f929e - c0331c2.f929e;
            }
        }
    }

    public ViewPager(Context context) {
        super(context);
        m1343a();
    }

    void m1343a() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f971m = new Scroller(context, f938d);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        float f = context.getResources().getDisplayMetrics().density;
        this.f944F = as.m1894a(viewConfiguration);
        this.f951M = (int) (400.0f * f);
        this.f952N = viewConfiguration.getScaledMaximumFlingVelocity();
        this.f956R = new C0521i(context);
        this.f957S = new C0521i(context);
        this.f953O = (int) (25.0f * f);
        this.f954P = (int) (2.0f * f);
        this.f942D = (int) (16.0f * f);
        ag.m1785a((View) this, new C0333d(this));
        if (ag.m1797c(this) == 0) {
            ag.m1799c((View) this, 1);
        }
        ag.m1786a((View) this, new C03274(this));
    }

    protected void onDetachedFromWindow() {
        removeCallbacks(this.aj);
        if (!(this.f971m == null || this.f971m.isFinished())) {
            this.f971m.abortAnimation();
        }
        super.onDetachedFromWindow();
    }

    private void setScrollState(int i) {
        if (this.ak != i) {
            this.ak = i;
            if (this.ae != null) {
                m1328b(i != 0);
            }
            m1333f(i);
        }
    }

    public void setAdapter(ab abVar) {
        if (this.f966h != null) {
            this.f966h.m1603a(null);
            this.f966h.m1607a((ViewGroup) this);
            for (int i = 0; i < this.f963e.size(); i++) {
                C0330b c0330b = (C0330b) this.f963e.get(i);
                this.f966h.mo1337a((ViewGroup) this, c0330b.f921b, c0330b.f920a);
            }
            this.f966h.m1613b((ViewGroup) this);
            this.f963e.clear();
            m1335g();
            this.f967i = 0;
            scrollTo(0, 0);
        }
        ab abVar2 = this.f966h;
        this.f966h = abVar;
        this.f962b = 0;
        if (this.f966h != null) {
            if (this.f973o == null) {
                this.f973o = new C0337h();
            }
            this.f966h.m1603a(this.f973o);
            this.f984z = false;
            boolean z = this.f958T;
            this.f958T = true;
            this.f962b = this.f966h.mo1334a();
            if (this.f968j >= 0) {
                this.f966h.m1604a(this.f969k, this.f970l);
                m1348a(this.f968j, false, true);
                this.f968j = -1;
                this.f969k = null;
                this.f970l = null;
            } else if (z) {
                requestLayout();
            } else {
                m1355c();
            }
        }
        if (this.ad != null && abVar2 != abVar) {
            this.ad.m1307a(abVar2, abVar);
        }
    }

    private void m1335g() {
        int i = 0;
        while (i < getChildCount()) {
            if (!((C0331c) getChildAt(i).getLayoutParams()).f925a) {
                removeViewAt(i);
                i--;
            }
            i++;
        }
    }

    public ab getAdapter() {
        return this.f966h;
    }

    void setOnAdapterChangeListener(C0334e c0334e) {
        this.ad = c0334e;
    }

    private int getClientWidth() {
        return (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
    }

    public void setCurrentItem(int i) {
        boolean z;
        this.f984z = false;
        if (this.f958T) {
            z = false;
        } else {
            z = true;
        }
        m1348a(i, z, false);
    }

    public void m1347a(int i, boolean z) {
        this.f984z = false;
        m1348a(i, z, false);
    }

    public int getCurrentItem() {
        return this.f967i;
    }

    void m1348a(int i, boolean z, boolean z2) {
        m1349a(i, z, z2, 0);
    }

    void m1349a(int i, boolean z, boolean z2, int i2) {
        boolean z3 = false;
        if (this.f966h == null || this.f966h.mo1334a() <= 0) {
            setScrollingCacheEnabled(false);
        } else if (z2 || this.f967i != i || this.f963e.size() == 0) {
            if (i < 0) {
                i = 0;
            } else if (i >= this.f966h.mo1334a()) {
                i = this.f966h.mo1334a() - 1;
            }
            int i3 = this.f939A;
            if (i > this.f967i + i3 || i < this.f967i - i3) {
                for (int i4 = 0; i4 < this.f963e.size(); i4++) {
                    ((C0330b) this.f963e.get(i4)).f922c = true;
                }
            }
            if (this.f967i != i) {
                z3 = true;
            }
            if (this.f958T) {
                this.f967i = i;
                if (z3) {
                    m1332e(i);
                }
                requestLayout();
                return;
            }
            m1344a(i);
            m1320a(i, z, i2, z3);
        } else {
            setScrollingCacheEnabled(false);
        }
    }

    private void m1320a(int i, boolean z, int i2, boolean z2) {
        int max;
        C0330b b = m1352b(i);
        if (b != null) {
            max = (int) (Math.max(this.f978t, Math.min(b.f924e, this.f979u)) * ((float) getClientWidth()));
        } else {
            max = 0;
        }
        if (z) {
            m1346a(max, 0, i2);
            if (z2) {
                m1332e(i);
                return;
            }
            return;
        }
        if (z2) {
            m1332e(i);
        }
        m1324a(false);
        scrollTo(max, 0);
        m1331d(max);
    }

    @Deprecated
    public void setOnPageChangeListener(C0335f c0335f) {
        this.ab = c0335f;
    }

    void setChildrenDrawingOrderEnabledCompat(boolean z) {
        if (VERSION.SDK_INT >= 7) {
            if (this.af == null) {
                try {
                    this.af = ViewGroup.class.getDeclaredMethod("setChildrenDrawingOrderEnabled", new Class[]{Boolean.TYPE});
                } catch (Throwable e) {
                    Log.e("ViewPager", "Can't find setChildrenDrawingOrderEnabled", e);
                }
            }
            try {
                this.af.invoke(this, new Object[]{Boolean.valueOf(z)});
            } catch (Throwable e2) {
                Log.e("ViewPager", "Error changing children drawing order", e2);
            }
        }
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.ag == 2) {
            i2 = (i - 1) - i2;
        }
        return ((C0331c) ((View) this.ah.get(i2)).getLayoutParams()).f930f;
    }

    public int getOffscreenPageLimit() {
        return this.f939A;
    }

    public void setOffscreenPageLimit(int i) {
        if (i < 1) {
            Log.w("ViewPager", "Requested offscreen page limit " + i + " too small; defaulting to " + 1);
            i = 1;
        }
        if (i != this.f939A) {
            this.f939A = i;
            m1355c();
        }
    }

    public void setPageMargin(int i) {
        int i2 = this.f974p;
        this.f974p = i;
        int width = getWidth();
        m1319a(width, width, i, i2);
        requestLayout();
    }

    public int getPageMargin() {
        return this.f974p;
    }

    public void setPageMarginDrawable(Drawable drawable) {
        this.f975q = drawable;
        if (drawable != null) {
            refreshDrawableState();
        }
        setWillNotDraw(drawable == null);
        invalidate();
    }

    public void setPageMarginDrawable(int i) {
        setPageMarginDrawable(getContext().getResources().getDrawable(i));
    }

    protected boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f975q;
    }

    protected void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f975q;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    float m1340a(float f) {
        return (float) Math.sin((double) ((float) (((double) (f - 0.5f)) * 0.4712389167638204d)));
    }

    void m1346a(int i, int i2, int i3) {
        if (getChildCount() == 0) {
            setScrollingCacheEnabled(false);
            return;
        }
        int i4;
        boolean z = (this.f971m == null || this.f971m.isFinished()) ? false : true;
        if (z) {
            int currX = this.f972n ? this.f971m.getCurrX() : this.f971m.getStartX();
            this.f971m.abortAnimation();
            setScrollingCacheEnabled(false);
            i4 = currX;
        } else {
            i4 = getScrollX();
        }
        int scrollY = getScrollY();
        int i5 = i - i4;
        int i6 = i2 - scrollY;
        if (i5 == 0 && i6 == 0) {
            m1324a(false);
            m1355c();
            setScrollState(0);
            return;
        }
        setScrollingCacheEnabled(true);
        setScrollState(2);
        currX = getClientWidth();
        int i7 = currX / 2;
        float a = (((float) i7) * m1340a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) currX)))) + ((float) i7);
        int abs = Math.abs(i3);
        if (abs > 0) {
            currX = Math.round(1000.0f * Math.abs(a / ((float) abs))) * 4;
        } else {
            currX = (int) (((((float) Math.abs(i5)) / ((((float) currX) * this.f966h.m1598a(this.f967i)) + ((float) this.f974p))) + 1.0f) * 100.0f);
        }
        i7 = Math.min(currX, 600);
        this.f972n = false;
        this.f971m.startScroll(i4, scrollY, i5, i6, i7);
        ag.m1793b(this);
    }

    C0330b m1341a(int i, int i2) {
        C0330b c0330b = new C0330b();
        c0330b.f921b = i;
        c0330b.f920a = this.f966h.mo1336a((ViewGroup) this, i);
        c0330b.f923d = this.f966h.m1598a(i);
        if (i2 < 0 || i2 >= this.f963e.size()) {
            this.f963e.add(c0330b);
        } else {
            this.f963e.add(i2, c0330b);
        }
        return c0330b;
    }

    void m1354b() {
        int a = this.f966h.mo1334a();
        this.f962b = a;
        boolean z = this.f963e.size() < (this.f939A * 2) + 1 && this.f963e.size() < a;
        boolean z2 = false;
        int i = this.f967i;
        boolean z3 = z;
        int i2 = 0;
        while (i2 < this.f963e.size()) {
            int i3;
            boolean z4;
            int i4;
            boolean z5;
            C0330b c0330b = (C0330b) this.f963e.get(i2);
            int a2 = this.f966h.mo1335a(c0330b.f920a);
            if (a2 == -1) {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            } else if (a2 == -2) {
                this.f963e.remove(i2);
                i2--;
                if (!z2) {
                    this.f966h.m1607a((ViewGroup) this);
                    z2 = true;
                }
                this.f966h.mo1337a((ViewGroup) this, c0330b.f921b, c0330b.f920a);
                if (this.f967i == c0330b.f921b) {
                    i3 = i2;
                    z4 = z2;
                    i4 = Math.max(0, Math.min(this.f967i, a - 1));
                    z5 = true;
                } else {
                    i3 = i2;
                    z4 = z2;
                    i4 = i;
                    z5 = true;
                }
            } else if (c0330b.f921b != a2) {
                if (c0330b.f921b == this.f967i) {
                    i = a2;
                }
                c0330b.f921b = a2;
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = true;
            } else {
                i3 = i2;
                z4 = z2;
                i4 = i;
                z5 = z3;
            }
            z3 = z5;
            i = i4;
            z2 = z4;
            i2 = i3 + 1;
        }
        if (z2) {
            this.f966h.m1613b((ViewGroup) this);
        }
        Collections.sort(this.f963e, f937c);
        if (z3) {
            i4 = getChildCount();
            for (i2 = 0; i2 < i4; i2++) {
                C0331c c0331c = (C0331c) getChildAt(i2).getLayoutParams();
                if (!c0331c.f925a) {
                    c0331c.f927c = 0.0f;
                }
            }
            m1348a(i, false, true);
            requestLayout();
        }
    }

    void m1355c() {
        m1344a(this.f967i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    void m1344a(int r18) {
        /*
        r17 = this;
        r2 = 0;
        r0 = r17;
        r3 = r0.f967i;
        r0 = r18;
        if (r3 == r0) goto L_0x0323;
    L_0x0009:
        r0 = r17;
        r2 = r0.f967i;
        r0 = r17;
        r2 = r0.m1352b(r2);
        r0 = r18;
        r1 = r17;
        r1.f967i = r0;
        r3 = r2;
    L_0x001a:
        r0 = r17;
        r2 = r0.f966h;
        if (r2 != 0) goto L_0x0024;
    L_0x0020:
        r17.m1336h();
    L_0x0023:
        return;
    L_0x0024:
        r0 = r17;
        r2 = r0.f984z;
        if (r2 == 0) goto L_0x002e;
    L_0x002a:
        r17.m1336h();
        goto L_0x0023;
    L_0x002e:
        r2 = r17.getWindowToken();
        if (r2 == 0) goto L_0x0023;
    L_0x0034:
        r0 = r17;
        r2 = r0.f966h;
        r0 = r17;
        r2.m1607a(r0);
        r0 = r17;
        r2 = r0.f939A;
        r4 = 0;
        r0 = r17;
        r5 = r0.f967i;
        r5 = r5 - r2;
        r10 = java.lang.Math.max(r4, r5);
        r0 = r17;
        r4 = r0.f966h;
        r11 = r4.mo1334a();
        r4 = r11 + -1;
        r0 = r17;
        r5 = r0.f967i;
        r2 = r2 + r5;
        r12 = java.lang.Math.min(r4, r2);
        r0 = r17;
        r2 = r0.f962b;
        if (r11 == r2) goto L_0x00cb;
    L_0x0064:
        r2 = r17.getResources();	 Catch:{ NotFoundException -> 0x00c1 }
        r3 = r17.getId();	 Catch:{ NotFoundException -> 0x00c1 }
        r2 = r2.getResourceName(r3);	 Catch:{ NotFoundException -> 0x00c1 }
    L_0x0070:
        r3 = new java.lang.IllegalStateException;
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "The application's PagerAdapter changed the adapter's contents without calling PagerAdapter#notifyDataSetChanged! Expected adapter item count: ";
        r4 = r4.append(r5);
        r0 = r17;
        r5 = r0.f962b;
        r4 = r4.append(r5);
        r5 = ", found: ";
        r4 = r4.append(r5);
        r4 = r4.append(r11);
        r5 = " Pager id: ";
        r4 = r4.append(r5);
        r2 = r4.append(r2);
        r4 = " Pager class: ";
        r2 = r2.append(r4);
        r4 = r17.getClass();
        r2 = r2.append(r4);
        r4 = " Problematic adapter: ";
        r2 = r2.append(r4);
        r0 = r17;
        r4 = r0.f966h;
        r4 = r4.getClass();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r3.<init>(r2);
        throw r3;
    L_0x00c1:
        r2 = move-exception;
        r2 = r17.getId();
        r2 = java.lang.Integer.toHexString(r2);
        goto L_0x0070;
    L_0x00cb:
        r5 = 0;
        r2 = 0;
        r4 = r2;
    L_0x00ce:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.size();
        if (r4 >= r2) goto L_0x0320;
    L_0x00d8:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
        r6 = r2.f921b;
        r0 = r17;
        r7 = r0.f967i;
        if (r6 < r7) goto L_0x01bc;
    L_0x00ea:
        r6 = r2.f921b;
        r0 = r17;
        r7 = r0.f967i;
        if (r6 != r7) goto L_0x0320;
    L_0x00f2:
        if (r2 != 0) goto L_0x031d;
    L_0x00f4:
        if (r11 <= 0) goto L_0x031d;
    L_0x00f6:
        r0 = r17;
        r2 = r0.f967i;
        r0 = r17;
        r2 = r0.m1341a(r2, r4);
        r9 = r2;
    L_0x0101:
        if (r9 == 0) goto L_0x016d;
    L_0x0103:
        r8 = 0;
        r7 = r4 + -1;
        if (r7 < 0) goto L_0x01c1;
    L_0x0108:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r7);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
    L_0x0112:
        r13 = r17.getClientWidth();
        if (r13 > 0) goto L_0x01c4;
    L_0x0118:
        r5 = 0;
    L_0x0119:
        r0 = r17;
        r6 = r0.f967i;
        r6 = r6 + -1;
        r15 = r6;
        r6 = r8;
        r8 = r15;
        r16 = r7;
        r7 = r4;
        r4 = r16;
    L_0x0127:
        if (r8 < 0) goto L_0x0131;
    L_0x0129:
        r14 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1));
        if (r14 < 0) goto L_0x0203;
    L_0x012d:
        if (r8 >= r10) goto L_0x0203;
    L_0x012f:
        if (r2 != 0) goto L_0x01d3;
    L_0x0131:
        r5 = r9.f923d;
        r8 = r7 + 1;
        r2 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = (r5 > r2 ? 1 : (r5 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0168;
    L_0x013b:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.size();
        if (r8 >= r2) goto L_0x0239;
    L_0x0145:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r8);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
        r6 = r2;
    L_0x0150:
        if (r13 > 0) goto L_0x023c;
    L_0x0152:
        r2 = 0;
        r4 = r2;
    L_0x0154:
        r0 = r17;
        r2 = r0.f967i;
        r2 = r2 + 1;
        r15 = r2;
        r2 = r6;
        r6 = r8;
        r8 = r15;
    L_0x015e:
        if (r8 >= r11) goto L_0x0168;
    L_0x0160:
        r10 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1));
        if (r10 < 0) goto L_0x0283;
    L_0x0164:
        if (r8 <= r12) goto L_0x0283;
    L_0x0166:
        if (r2 != 0) goto L_0x0249;
    L_0x0168:
        r0 = r17;
        r0.m1321a(r9, r7, r3);
    L_0x016d:
        r0 = r17;
        r3 = r0.f966h;
        r0 = r17;
        r4 = r0.f967i;
        if (r9 == 0) goto L_0x02cd;
    L_0x0177:
        r2 = r9.f920a;
    L_0x0179:
        r0 = r17;
        r3.m1614b(r0, r4, r2);
        r0 = r17;
        r2 = r0.f966h;
        r0 = r17;
        r2.m1613b(r0);
        r4 = r17.getChildCount();
        r2 = 0;
        r3 = r2;
    L_0x018d:
        if (r3 >= r4) goto L_0x02d0;
    L_0x018f:
        r0 = r17;
        r5 = r0.getChildAt(r3);
        r2 = r5.getLayoutParams();
        r2 = (android.support.v4.view.ViewPager.C0331c) r2;
        r2.f930f = r3;
        r6 = r2.f925a;
        if (r6 != 0) goto L_0x01b8;
    L_0x01a1:
        r6 = r2.f927c;
        r7 = 0;
        r6 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1));
        if (r6 != 0) goto L_0x01b8;
    L_0x01a8:
        r0 = r17;
        r5 = r0.m1342a(r5);
        if (r5 == 0) goto L_0x01b8;
    L_0x01b0:
        r6 = r5.f923d;
        r2.f927c = r6;
        r5 = r5.f921b;
        r2.f929e = r5;
    L_0x01b8:
        r2 = r3 + 1;
        r3 = r2;
        goto L_0x018d;
    L_0x01bc:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x00ce;
    L_0x01c1:
        r2 = 0;
        goto L_0x0112;
    L_0x01c4:
        r5 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r6 = r9.f923d;
        r5 = r5 - r6;
        r6 = r17.getPaddingLeft();
        r6 = (float) r6;
        r14 = (float) r13;
        r6 = r6 / r14;
        r5 = r5 + r6;
        goto L_0x0119;
    L_0x01d3:
        r14 = r2.f921b;
        if (r8 != r14) goto L_0x01fd;
    L_0x01d7:
        r14 = r2.f922c;
        if (r14 != 0) goto L_0x01fd;
    L_0x01db:
        r0 = r17;
        r14 = r0.f963e;
        r14.remove(r4);
        r0 = r17;
        r14 = r0.f966h;
        r2 = r2.f920a;
        r0 = r17;
        r14.mo1337a(r0, r8, r2);
        r4 = r4 + -1;
        r7 = r7 + -1;
        if (r4 < 0) goto L_0x0201;
    L_0x01f3:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
    L_0x01fd:
        r8 = r8 + -1;
        goto L_0x0127;
    L_0x0201:
        r2 = 0;
        goto L_0x01fd;
    L_0x0203:
        if (r2 == 0) goto L_0x021d;
    L_0x0205:
        r14 = r2.f921b;
        if (r8 != r14) goto L_0x021d;
    L_0x0209:
        r2 = r2.f923d;
        r6 = r6 + r2;
        r4 = r4 + -1;
        if (r4 < 0) goto L_0x021b;
    L_0x0210:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
        goto L_0x01fd;
    L_0x021b:
        r2 = 0;
        goto L_0x01fd;
    L_0x021d:
        r2 = r4 + 1;
        r0 = r17;
        r2 = r0.m1341a(r8, r2);
        r2 = r2.f923d;
        r6 = r6 + r2;
        r7 = r7 + 1;
        if (r4 < 0) goto L_0x0237;
    L_0x022c:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r4);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
        goto L_0x01fd;
    L_0x0237:
        r2 = 0;
        goto L_0x01fd;
    L_0x0239:
        r6 = 0;
        goto L_0x0150;
    L_0x023c:
        r2 = r17.getPaddingRight();
        r2 = (float) r2;
        r4 = (float) r13;
        r2 = r2 / r4;
        r4 = 1073741824; // 0x40000000 float:2.0 double:5.304989477E-315;
        r2 = r2 + r4;
        r4 = r2;
        goto L_0x0154;
    L_0x0249:
        r10 = r2.f921b;
        if (r8 != r10) goto L_0x0318;
    L_0x024d:
        r10 = r2.f922c;
        if (r10 != 0) goto L_0x0318;
    L_0x0251:
        r0 = r17;
        r10 = r0.f963e;
        r10.remove(r6);
        r0 = r17;
        r10 = r0.f966h;
        r2 = r2.f920a;
        r0 = r17;
        r10.mo1337a(r0, r8, r2);
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x0281;
    L_0x026d:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
    L_0x0277:
        r15 = r5;
        r5 = r2;
        r2 = r15;
    L_0x027a:
        r8 = r8 + 1;
        r15 = r2;
        r2 = r5;
        r5 = r15;
        goto L_0x015e;
    L_0x0281:
        r2 = 0;
        goto L_0x0277;
    L_0x0283:
        if (r2 == 0) goto L_0x02a8;
    L_0x0285:
        r10 = r2.f921b;
        if (r8 != r10) goto L_0x02a8;
    L_0x0289:
        r2 = r2.f923d;
        r5 = r5 + r2;
        r6 = r6 + 1;
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02a6;
    L_0x0298:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
    L_0x02a2:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02a6:
        r2 = 0;
        goto L_0x02a2;
    L_0x02a8:
        r0 = r17;
        r2 = r0.m1341a(r8, r6);
        r6 = r6 + 1;
        r2 = r2.f923d;
        r5 = r5 + r2;
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.size();
        if (r6 >= r2) goto L_0x02cb;
    L_0x02bd:
        r0 = r17;
        r2 = r0.f963e;
        r2 = r2.get(r6);
        r2 = (android.support.v4.view.ViewPager.C0330b) r2;
    L_0x02c7:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x02cb:
        r2 = 0;
        goto L_0x02c7;
    L_0x02cd:
        r2 = 0;
        goto L_0x0179;
    L_0x02d0:
        r17.m1336h();
        r2 = r17.hasFocus();
        if (r2 == 0) goto L_0x0023;
    L_0x02d9:
        r2 = r17.findFocus();
        if (r2 == 0) goto L_0x0316;
    L_0x02df:
        r0 = r17;
        r2 = r0.m1353b(r2);
    L_0x02e5:
        if (r2 == 0) goto L_0x02ef;
    L_0x02e7:
        r2 = r2.f921b;
        r0 = r17;
        r3 = r0.f967i;
        if (r2 == r3) goto L_0x0023;
    L_0x02ef:
        r2 = 0;
    L_0x02f0:
        r3 = r17.getChildCount();
        if (r2 >= r3) goto L_0x0023;
    L_0x02f6:
        r0 = r17;
        r3 = r0.getChildAt(r2);
        r0 = r17;
        r4 = r0.m1342a(r3);
        if (r4 == 0) goto L_0x0313;
    L_0x0304:
        r4 = r4.f921b;
        r0 = r17;
        r5 = r0.f967i;
        if (r4 != r5) goto L_0x0313;
    L_0x030c:
        r4 = 2;
        r3 = r3.requestFocus(r4);
        if (r3 != 0) goto L_0x0023;
    L_0x0313:
        r2 = r2 + 1;
        goto L_0x02f0;
    L_0x0316:
        r2 = 0;
        goto L_0x02e5;
    L_0x0318:
        r15 = r5;
        r5 = r2;
        r2 = r15;
        goto L_0x027a;
    L_0x031d:
        r9 = r2;
        goto L_0x0101;
    L_0x0320:
        r2 = r5;
        goto L_0x00f2;
    L_0x0323:
        r3 = r2;
        goto L_0x001a;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.view.ViewPager.a(int):void");
    }

    private void m1336h() {
        if (this.ag != 0) {
            if (this.ah == null) {
                this.ah = new ArrayList();
            } else {
                this.ah.clear();
            }
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                this.ah.add(getChildAt(i));
            }
            Collections.sort(this.ah, ai);
        }
    }

    private void m1321a(C0330b c0330b, int i, C0330b c0330b2) {
        float f;
        float f2;
        int i2;
        C0330b c0330b3;
        int i3;
        int a = this.f966h.mo1334a();
        int clientWidth = getClientWidth();
        if (clientWidth > 0) {
            f = ((float) this.f974p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        if (c0330b2 != null) {
            clientWidth = c0330b2.f921b;
            int i4;
            if (clientWidth < c0330b.f921b) {
                f2 = (c0330b2.f924e + c0330b2.f923d) + f;
                i4 = clientWidth + 1;
                i2 = 0;
                while (i4 <= c0330b.f921b && i2 < this.f963e.size()) {
                    c0330b3 = (C0330b) this.f963e.get(i2);
                    while (i4 > c0330b3.f921b && i2 < this.f963e.size() - 1) {
                        i2++;
                        c0330b3 = (C0330b) this.f963e.get(i2);
                    }
                    while (i4 < c0330b3.f921b) {
                        f2 += this.f966h.m1598a(i4) + f;
                        i4++;
                    }
                    c0330b3.f924e = f2;
                    f2 += c0330b3.f923d + f;
                    i4++;
                }
            } else if (clientWidth > c0330b.f921b) {
                i2 = this.f963e.size() - 1;
                f2 = c0330b2.f924e;
                i4 = clientWidth - 1;
                while (i4 >= c0330b.f921b && i2 >= 0) {
                    c0330b3 = (C0330b) this.f963e.get(i2);
                    while (i4 < c0330b3.f921b && i2 > 0) {
                        i2--;
                        c0330b3 = (C0330b) this.f963e.get(i2);
                    }
                    while (i4 > c0330b3.f921b) {
                        f2 -= this.f966h.m1598a(i4) + f;
                        i4--;
                    }
                    f2 -= c0330b3.f923d + f;
                    c0330b3.f924e = f2;
                    i4--;
                }
            }
        }
        int size = this.f963e.size();
        float f3 = c0330b.f924e;
        i2 = c0330b.f921b - 1;
        this.f978t = c0330b.f921b == 0 ? c0330b.f924e : -3.4028235E38f;
        this.f979u = c0330b.f921b == a + -1 ? (c0330b.f924e + c0330b.f923d) - 1.0f : Float.MAX_VALUE;
        for (i3 = i - 1; i3 >= 0; i3--) {
            c0330b3 = (C0330b) this.f963e.get(i3);
            f2 = f3;
            while (i2 > c0330b3.f921b) {
                f2 -= this.f966h.m1598a(i2) + f;
                i2--;
            }
            f3 = f2 - (c0330b3.f923d + f);
            c0330b3.f924e = f3;
            if (c0330b3.f921b == 0) {
                this.f978t = f3;
            }
            i2--;
        }
        f3 = (c0330b.f924e + c0330b.f923d) + f;
        i2 = c0330b.f921b + 1;
        for (i3 = i + 1; i3 < size; i3++) {
            c0330b3 = (C0330b) this.f963e.get(i3);
            f2 = f3;
            while (i2 < c0330b3.f921b) {
                f2 = (this.f966h.m1598a(i2) + f) + f2;
                i2++;
            }
            if (c0330b3.f921b == a - 1) {
                this.f979u = (c0330b3.f923d + f2) - 1.0f;
            }
            c0330b3.f924e = f2;
            f3 = f2 + (c0330b3.f923d + f);
            i2++;
        }
        this.f959U = false;
    }

    public Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f917a = this.f967i;
        if (this.f966h != null) {
            savedState.f918b = this.f966h.m1610b();
        }
        return savedState;
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            if (this.f966h != null) {
                this.f966h.m1604a(savedState.f918b, savedState.f919c);
                m1348a(savedState.f917a, false, true);
                return;
            }
            this.f968j = savedState.f917a;
            this.f969k = savedState.f918b;
            this.f970l = savedState.f919c;
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        LayoutParams layoutParams2;
        if (checkLayoutParams(layoutParams)) {
            layoutParams2 = layoutParams;
        } else {
            layoutParams2 = generateLayoutParams(layoutParams);
        }
        C0331c c0331c = (C0331c) layoutParams2;
        c0331c.f925a |= view instanceof C0329a;
        if (!this.f982x) {
            super.addView(view, i, layoutParams2);
        } else if (c0331c == null || !c0331c.f925a) {
            c0331c.f928d = true;
            addViewInLayout(view, i, layoutParams2);
        } else {
            throw new IllegalStateException("Cannot add pager decor view during layout");
        }
    }

    public void removeView(View view) {
        if (this.f982x) {
            removeViewInLayout(view);
        } else {
            super.removeView(view);
        }
    }

    C0330b m1342a(View view) {
        for (int i = 0; i < this.f963e.size(); i++) {
            C0330b c0330b = (C0330b) this.f963e.get(i);
            if (this.f966h.mo1338a(view, c0330b.f920a)) {
                return c0330b;
            }
        }
        return null;
    }

    C0330b m1353b(View view) {
        while (true) {
            ViewPager parent = view.getParent();
            if (parent == this) {
                return m1342a(view);
            }
            if (parent != null && (parent instanceof View)) {
                view = parent;
            }
        }
        return null;
    }

    C0330b m1352b(int i) {
        for (int i2 = 0; i2 < this.f963e.size(); i2++) {
            C0330b c0330b = (C0330b) this.f963e.get(i2);
            if (c0330b.f921b == i) {
                return c0330b;
            }
        }
        return null;
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f958T = true;
    }

    protected void onMeasure(int i, int i2) {
        int i3;
        setMeasuredDimension(getDefaultSize(0, i), getDefaultSize(0, i2));
        int measuredWidth = getMeasuredWidth();
        this.f943E = Math.min(measuredWidth / 10, this.f942D);
        int paddingLeft = (measuredWidth - getPaddingLeft()) - getPaddingRight();
        int measuredHeight = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
        int childCount = getChildCount();
        for (int i4 = 0; i4 < childCount; i4++) {
            C0331c c0331c;
            int i5;
            View childAt = getChildAt(i4);
            if (childAt.getVisibility() != 8) {
                c0331c = (C0331c) childAt.getLayoutParams();
                if (c0331c != null && c0331c.f925a) {
                    int i6 = c0331c.f926b & 7;
                    int i7 = c0331c.f926b & 112;
                    i3 = Integer.MIN_VALUE;
                    i5 = Integer.MIN_VALUE;
                    Object obj = (i7 == 48 || i7 == 80) ? 1 : null;
                    Object obj2 = (i6 == 3 || i6 == 5) ? 1 : null;
                    if (obj != null) {
                        i3 = 1073741824;
                    } else if (obj2 != null) {
                        i5 = 1073741824;
                    }
                    if (c0331c.width != -2) {
                        i7 = 1073741824;
                        i3 = c0331c.width != -1 ? c0331c.width : paddingLeft;
                    } else {
                        i7 = i3;
                        i3 = paddingLeft;
                    }
                    if (c0331c.height != -2) {
                        i5 = 1073741824;
                        if (c0331c.height != -1) {
                            measuredWidth = c0331c.height;
                            childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                            if (obj != null) {
                                measuredHeight -= childAt.getMeasuredHeight();
                            } else if (obj2 != null) {
                                paddingLeft -= childAt.getMeasuredWidth();
                            }
                        }
                    }
                    measuredWidth = measuredHeight;
                    childAt.measure(MeasureSpec.makeMeasureSpec(i3, i7), MeasureSpec.makeMeasureSpec(measuredWidth, i5));
                    if (obj != null) {
                        measuredHeight -= childAt.getMeasuredHeight();
                    } else if (obj2 != null) {
                        paddingLeft -= childAt.getMeasuredWidth();
                    }
                }
            }
        }
        this.f980v = MeasureSpec.makeMeasureSpec(paddingLeft, 1073741824);
        this.f981w = MeasureSpec.makeMeasureSpec(measuredHeight, 1073741824);
        this.f982x = true;
        m1355c();
        this.f982x = false;
        i3 = getChildCount();
        for (i5 = 0; i5 < i3; i5++) {
            View childAt2 = getChildAt(i5);
            if (childAt2.getVisibility() != 8) {
                c0331c = (C0331c) childAt2.getLayoutParams();
                if (c0331c == null || !c0331c.f925a) {
                    childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0331c.f927c * ((float) paddingLeft)), 1073741824), this.f981w);
                }
            }
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3) {
            m1319a(i, i3, this.f974p, this.f974p);
        }
    }

    private void m1319a(int i, int i2, int i3, int i4) {
        if (i2 <= 0 || this.f963e.isEmpty()) {
            C0330b b = m1352b(this.f967i);
            int min = (int) ((b != null ? Math.min(b.f924e, this.f979u) : 0.0f) * ((float) ((i - getPaddingLeft()) - getPaddingRight())));
            if (min != getScrollX()) {
                m1324a(false);
                scrollTo(min, getScrollY());
            }
        } else if (this.f971m.isFinished()) {
            scrollTo((int) (((float) (((i - getPaddingLeft()) - getPaddingRight()) + i3)) * (((float) getScrollX()) / ((float) (((i2 - getPaddingLeft()) - getPaddingRight()) + i4)))), getScrollY());
        } else {
            this.f971m.setFinalX(getCurrentItem() * getClientWidth());
        }
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        C0331c c0331c;
        int max;
        int childCount = getChildCount();
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int paddingRight = getPaddingRight();
        int paddingBottom = getPaddingBottom();
        int scrollX = getScrollX();
        int i7 = 0;
        int i8 = 0;
        while (i8 < childCount) {
            int measuredWidth;
            View childAt = getChildAt(i8);
            if (childAt.getVisibility() != 8) {
                c0331c = (C0331c) childAt.getLayoutParams();
                if (c0331c.f925a) {
                    int i9 = c0331c.f926b & 112;
                    switch (c0331c.f926b & 7) {
                        case 1:
                            max = Math.max((i5 - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            break;
                        case 3:
                            max = paddingLeft;
                            paddingLeft = childAt.getMeasuredWidth() + paddingLeft;
                            break;
                        case 5:
                            measuredWidth = (i5 - paddingRight) - childAt.getMeasuredWidth();
                            paddingRight += childAt.getMeasuredWidth();
                            max = measuredWidth;
                            break;
                        default:
                            max = paddingLeft;
                            break;
                    }
                    int i10;
                    switch (i9) {
                        case 16:
                            measuredWidth = Math.max((i6 - childAt.getMeasuredHeight()) / 2, paddingTop);
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        case 48:
                            measuredWidth = childAt.getMeasuredHeight() + paddingTop;
                            i10 = paddingTop;
                            paddingTop = paddingBottom;
                            paddingBottom = measuredWidth;
                            measuredWidth = i10;
                            break;
                        case 80:
                            measuredWidth = (i6 - paddingBottom) - childAt.getMeasuredHeight();
                            i10 = paddingBottom + childAt.getMeasuredHeight();
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                        default:
                            measuredWidth = paddingTop;
                            i10 = paddingBottom;
                            paddingBottom = paddingTop;
                            paddingTop = i10;
                            break;
                    }
                    max += scrollX;
                    childAt.layout(max, measuredWidth, childAt.getMeasuredWidth() + max, childAt.getMeasuredHeight() + measuredWidth);
                    measuredWidth = i7 + 1;
                    i7 = paddingBottom;
                    paddingBottom = paddingTop;
                    paddingTop = paddingRight;
                    paddingRight = paddingLeft;
                    i8++;
                    paddingLeft = paddingRight;
                    paddingRight = paddingTop;
                    paddingTop = i7;
                    i7 = measuredWidth;
                }
            }
            measuredWidth = i7;
            i7 = paddingTop;
            paddingTop = paddingRight;
            paddingRight = paddingLeft;
            i8++;
            paddingLeft = paddingRight;
            paddingRight = paddingTop;
            paddingTop = i7;
            i7 = measuredWidth;
        }
        max = (i5 - paddingLeft) - paddingRight;
        for (paddingRight = 0; paddingRight < childCount; paddingRight++) {
            View childAt2 = getChildAt(paddingRight);
            if (childAt2.getVisibility() != 8) {
                c0331c = (C0331c) childAt2.getLayoutParams();
                if (!c0331c.f925a) {
                    C0330b a = m1342a(childAt2);
                    if (a != null) {
                        i5 = ((int) (a.f924e * ((float) max))) + paddingLeft;
                        if (c0331c.f928d) {
                            c0331c.f928d = false;
                            childAt2.measure(MeasureSpec.makeMeasureSpec((int) (c0331c.f927c * ((float) max)), 1073741824), MeasureSpec.makeMeasureSpec((i6 - paddingTop) - paddingBottom, 1073741824));
                        }
                        childAt2.layout(i5, paddingTop, childAt2.getMeasuredWidth() + i5, childAt2.getMeasuredHeight() + paddingTop);
                    }
                }
            }
        }
        this.f976r = paddingTop;
        this.f977s = i6 - paddingBottom;
        this.f961W = i7;
        if (this.f958T) {
            m1320a(this.f967i, false, 0, false);
        }
        this.f958T = false;
    }

    public void computeScroll() {
        this.f972n = true;
        if (this.f971m.isFinished() || !this.f971m.computeScrollOffset()) {
            m1324a(true);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f971m.getCurrX();
        int currY = this.f971m.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
            if (!m1331d(currX)) {
                this.f971m.abortAnimation();
                scrollTo(0, currY);
            }
        }
        ag.m1793b(this);
    }

    private boolean m1331d(int i) {
        if (this.f963e.size() != 0) {
            C0330b j = m1338j();
            int clientWidth = getClientWidth();
            int i2 = this.f974p + clientWidth;
            float f = ((float) this.f974p) / ((float) clientWidth);
            int i3 = j.f921b;
            float f2 = ((((float) i) / ((float) clientWidth)) - j.f924e) / (j.f923d + f);
            clientWidth = (int) (((float) i2) * f2);
            this.f960V = false;
            m1345a(i3, f2, clientWidth);
            if (this.f960V) {
                return true;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        } else if (this.f958T) {
            return false;
        } else {
            this.f960V = false;
            m1345a(0, 0.0f, 0);
            if (this.f960V) {
                return false;
            }
            throw new IllegalStateException("onPageScrolled did not call superclass implementation");
        }
    }

    protected void m1345a(int i, float f, int i2) {
        int paddingLeft;
        int paddingRight;
        int i3;
        if (this.f961W > 0) {
            int scrollX = getScrollX();
            paddingLeft = getPaddingLeft();
            paddingRight = getPaddingRight();
            int width = getWidth();
            int childCount = getChildCount();
            i3 = 0;
            while (i3 < childCount) {
                int i4;
                View childAt = getChildAt(i3);
                C0331c c0331c = (C0331c) childAt.getLayoutParams();
                if (c0331c.f925a) {
                    int max;
                    switch (c0331c.f926b & 7) {
                        case 1:
                            max = Math.max((width - childAt.getMeasuredWidth()) / 2, paddingLeft);
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        case 3:
                            max = childAt.getWidth() + paddingLeft;
                            i4 = paddingLeft;
                            paddingLeft = paddingRight;
                            paddingRight = max;
                            max = i4;
                            break;
                        case 5:
                            max = (width - paddingRight) - childAt.getMeasuredWidth();
                            i4 = paddingRight + childAt.getMeasuredWidth();
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                        default:
                            max = paddingLeft;
                            i4 = paddingRight;
                            paddingRight = paddingLeft;
                            paddingLeft = i4;
                            break;
                    }
                    max = (max + scrollX) - childAt.getLeft();
                    if (max != 0) {
                        childAt.offsetLeftAndRight(max);
                    }
                } else {
                    i4 = paddingRight;
                    paddingRight = paddingLeft;
                    paddingLeft = i4;
                }
                i3++;
                i4 = paddingLeft;
                paddingLeft = paddingRight;
                paddingRight = i4;
            }
        }
        m1327b(i, f, i2);
        if (this.ae != null) {
            paddingRight = getScrollX();
            i3 = getChildCount();
            for (paddingLeft = 0; paddingLeft < i3; paddingLeft++) {
                View childAt2 = getChildAt(paddingLeft);
                if (!((C0331c) childAt2.getLayoutParams()).f925a) {
                    this.ae.m1311a(childAt2, ((float) (childAt2.getLeft() - paddingRight)) / ((float) getClientWidth()));
                }
            }
        }
        this.f960V = true;
    }

    private void m1327b(int i, float f, int i2) {
        if (this.ab != null) {
            this.ab.mo191a(i, f, i2);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i3 = 0; i3 < size; i3++) {
                C0335f c0335f = (C0335f) this.aa.get(i3);
                if (c0335f != null) {
                    c0335f.mo191a(i, f, i2);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo191a(i, f, i2);
        }
    }

    private void m1332e(int i) {
        if (this.ab != null) {
            this.ab.mo190a(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0335f c0335f = (C0335f) this.aa.get(i2);
                if (c0335f != null) {
                    c0335f.mo190a(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo190a(i);
        }
    }

    private void m1333f(int i) {
        if (this.ab != null) {
            this.ab.mo192b(i);
        }
        if (this.aa != null) {
            int size = this.aa.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0335f c0335f = (C0335f) this.aa.get(i2);
                if (c0335f != null) {
                    c0335f.mo192b(i);
                }
            }
        }
        if (this.ac != null) {
            this.ac.mo192b(i);
        }
    }

    private void m1324a(boolean z) {
        int scrollX;
        boolean z2 = this.ak == 2;
        if (z2) {
            boolean z3;
            setScrollingCacheEnabled(false);
            if (this.f971m.isFinished()) {
                z3 = false;
            } else {
                z3 = true;
            }
            if (z3) {
                this.f971m.abortAnimation();
                scrollX = getScrollX();
                int scrollY = getScrollY();
                int currX = this.f971m.getCurrX();
                int currY = this.f971m.getCurrY();
                if (!(scrollX == currX && scrollY == currY)) {
                    scrollTo(currX, currY);
                    if (currX != scrollX) {
                        m1331d(currX);
                    }
                }
            }
        }
        this.f984z = false;
        boolean z4 = z2;
        for (scrollX = 0; scrollX < this.f963e.size(); scrollX++) {
            C0330b c0330b = (C0330b) this.f963e.get(scrollX);
            if (c0330b.f922c) {
                c0330b.f922c = false;
                z4 = true;
            }
        }
        if (!z4) {
            return;
        }
        if (z) {
            ag.m1787a((View) this, this.aj);
        } else {
            this.aj.run();
        }
    }

    private boolean m1325a(float f, float f2) {
        return (f < ((float) this.f943E) && f2 > 0.0f) || (f > ((float) (getWidth() - this.f943E)) && f2 < 0.0f);
    }

    private void m1328b(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            int i2;
            if (z) {
                i2 = 2;
            } else {
                i2 = 0;
            }
            ag.m1782a(getChildAt(i), i2, null);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            m1337i();
            return false;
        }
        if (action != 0) {
            if (this.f940B) {
                return true;
            }
            if (this.f941C) {
                return false;
            }
        }
        switch (action) {
            case 0:
                float x = motionEvent.getX();
                this.f947I = x;
                this.f945G = x;
                x = motionEvent.getY();
                this.f948J = x;
                this.f946H = x;
                this.f949K = C0474s.m2144b(motionEvent, 0);
                this.f941C = false;
                this.f972n = true;
                this.f971m.computeScrollOffset();
                if (this.ak == 2 && Math.abs(this.f971m.getFinalX() - this.f971m.getCurrX()) > this.f954P) {
                    this.f971m.abortAnimation();
                    this.f984z = false;
                    m1355c();
                    this.f940B = true;
                    m1330c(true);
                    setScrollState(1);
                    break;
                }
                m1324a(false);
                this.f940B = false;
                break;
            case 2:
                action = this.f949K;
                if (action != -1) {
                    action = C0474s.m2142a(motionEvent, action);
                    float c = C0474s.m2145c(motionEvent, action);
                    float f = c - this.f945G;
                    float abs = Math.abs(f);
                    float d = C0474s.m2147d(motionEvent, action);
                    float abs2 = Math.abs(d - this.f948J);
                    if (f == 0.0f || m1325a(this.f945G, f) || !m1351a(this, false, (int) f, (int) c, (int) d)) {
                        if (abs > ((float) this.f944F) && 0.5f * abs > abs2) {
                            this.f940B = true;
                            m1330c(true);
                            setScrollState(1);
                            this.f945G = f > 0.0f ? this.f947I + ((float) this.f944F) : this.f947I - ((float) this.f944F);
                            this.f946H = d;
                            setScrollingCacheEnabled(true);
                        } else if (abs2 > ((float) this.f944F)) {
                            this.f941C = true;
                        }
                        if (this.f940B && m1329b(c)) {
                            ag.m1793b(this);
                            break;
                        }
                    }
                    this.f945G = c;
                    this.f946H = d;
                    this.f941C = true;
                    return false;
                }
                break;
            case 6:
                m1323a(motionEvent);
                break;
        }
        if (this.f950L == null) {
            this.f950L = VelocityTracker.obtain();
        }
        this.f950L.addMovement(motionEvent);
        return this.f940B;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        if (this.f955Q) {
            return true;
        }
        if (motionEvent.getAction() == 0 && motionEvent.getEdgeFlags() != 0) {
            return false;
        }
        if (this.f966h == null || this.f966h.mo1334a() == 0) {
            return false;
        }
        if (this.f950L == null) {
            this.f950L = VelocityTracker.obtain();
        }
        this.f950L.addMovement(motionEvent);
        float x;
        int a;
        switch (motionEvent.getAction() & 255) {
            case 0:
                this.f971m.abortAnimation();
                this.f984z = false;
                m1355c();
                x = motionEvent.getX();
                this.f947I = x;
                this.f945G = x;
                x = motionEvent.getY();
                this.f948J = x;
                this.f946H = x;
                this.f949K = C0474s.m2144b(motionEvent, 0);
                break;
            case 1:
                if (this.f940B) {
                    VelocityTracker velocityTracker = this.f950L;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f952N);
                    a = (int) ae.m1622a(velocityTracker, this.f949K);
                    this.f984z = true;
                    int clientWidth = getClientWidth();
                    int scrollX = getScrollX();
                    C0330b j = m1338j();
                    m1349a(m1316a(j.f921b, ((((float) scrollX) / ((float) clientWidth)) - j.f924e) / (j.f923d + (((float) this.f974p) / ((float) clientWidth))), a, (int) (C0474s.m2145c(motionEvent, C0474s.m2142a(motionEvent, this.f949K)) - this.f947I)), true, true, a);
                    z = m1337i();
                    break;
                }
                break;
            case 2:
                if (!this.f940B) {
                    a = C0474s.m2142a(motionEvent, this.f949K);
                    if (a == -1) {
                        z = m1337i();
                        break;
                    }
                    float c = C0474s.m2145c(motionEvent, a);
                    float abs = Math.abs(c - this.f945G);
                    float d = C0474s.m2147d(motionEvent, a);
                    x = Math.abs(d - this.f946H);
                    if (abs > ((float) this.f944F) && abs > x) {
                        this.f940B = true;
                        m1330c(true);
                        if (c - this.f947I > 0.0f) {
                            x = this.f947I + ((float) this.f944F);
                        } else {
                            x = this.f947I - ((float) this.f944F);
                        }
                        this.f945G = x;
                        this.f946H = d;
                        setScrollState(1);
                        setScrollingCacheEnabled(true);
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                }
                if (this.f940B) {
                    z = false | m1329b(C0474s.m2145c(motionEvent, C0474s.m2142a(motionEvent, this.f949K)));
                    break;
                }
                break;
            case 3:
                if (this.f940B) {
                    m1320a(this.f967i, true, 0, false);
                    z = m1337i();
                    break;
                }
                break;
            case 5:
                a = C0474s.m2143b(motionEvent);
                this.f945G = C0474s.m2145c(motionEvent, a);
                this.f949K = C0474s.m2144b(motionEvent, a);
                break;
            case 6:
                m1323a(motionEvent);
                this.f945G = C0474s.m2145c(motionEvent, C0474s.m2142a(motionEvent, this.f949K));
                break;
        }
        if (z) {
            ag.m1793b(this);
        }
        return true;
    }

    private boolean m1337i() {
        this.f949K = -1;
        m1339k();
        return this.f956R.m2410c() | this.f957S.m2410c();
    }

    private void m1330c(boolean z) {
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
    }

    private boolean m1329b(float f) {
        boolean z;
        float f2;
        boolean z2 = true;
        boolean z3 = false;
        float f3 = this.f945G - f;
        this.f945G = f;
        float scrollX = ((float) getScrollX()) + f3;
        int clientWidth = getClientWidth();
        float f4 = ((float) clientWidth) * this.f978t;
        float f5 = ((float) clientWidth) * this.f979u;
        C0330b c0330b = (C0330b) this.f963e.get(0);
        C0330b c0330b2 = (C0330b) this.f963e.get(this.f963e.size() - 1);
        if (c0330b.f921b != 0) {
            f4 = c0330b.f924e * ((float) clientWidth);
            z = false;
        } else {
            z = true;
        }
        if (c0330b2.f921b != this.f966h.mo1334a() - 1) {
            f2 = c0330b2.f924e * ((float) clientWidth);
            z2 = false;
        } else {
            f2 = f5;
        }
        if (scrollX < f4) {
            if (z) {
                z3 = this.f956R.m2405a(Math.abs(f4 - scrollX) / ((float) clientWidth));
            }
        } else if (scrollX > f2) {
            if (z2) {
                z3 = this.f957S.m2405a(Math.abs(scrollX - f2) / ((float) clientWidth));
            }
            f4 = f2;
        } else {
            f4 = scrollX;
        }
        this.f945G += f4 - ((float) ((int) f4));
        scrollTo((int) f4, getScrollY());
        m1331d((int) f4);
        return z3;
    }

    private C0330b m1338j() {
        float f;
        int clientWidth = getClientWidth();
        float scrollX = clientWidth > 0 ? ((float) getScrollX()) / ((float) clientWidth) : 0.0f;
        if (clientWidth > 0) {
            f = ((float) this.f974p) / ((float) clientWidth);
        } else {
            f = 0.0f;
        }
        float f2 = 0.0f;
        float f3 = 0.0f;
        int i = -1;
        int i2 = 0;
        Object obj = 1;
        C0330b c0330b = null;
        while (i2 < this.f963e.size()) {
            int i3;
            C0330b c0330b2;
            C0330b c0330b3 = (C0330b) this.f963e.get(i2);
            C0330b c0330b4;
            if (obj != null || c0330b3.f921b == i + 1) {
                c0330b4 = c0330b3;
                i3 = i2;
                c0330b2 = c0330b4;
            } else {
                c0330b3 = this.f964f;
                c0330b3.f924e = (f2 + f3) + f;
                c0330b3.f921b = i + 1;
                c0330b3.f923d = this.f966h.m1598a(c0330b3.f921b);
                c0330b4 = c0330b3;
                i3 = i2 - 1;
                c0330b2 = c0330b4;
            }
            f2 = c0330b2.f924e;
            f3 = (c0330b2.f923d + f2) + f;
            if (obj == null && scrollX < f2) {
                return c0330b;
            }
            if (scrollX < f3 || i3 == this.f963e.size() - 1) {
                return c0330b2;
            }
            f3 = f2;
            i = c0330b2.f921b;
            obj = null;
            f2 = c0330b2.f923d;
            c0330b = c0330b2;
            i2 = i3 + 1;
        }
        return c0330b;
    }

    private int m1316a(int i, float f, int i2, int i3) {
        if (Math.abs(i3) <= this.f953O || Math.abs(i2) <= this.f951M) {
            i = (int) ((i >= this.f967i ? 0.4f : 0.6f) + (((float) i) + f));
        } else if (i2 <= 0) {
            i++;
        }
        if (this.f963e.size() <= 0) {
            return i;
        }
        return Math.max(((C0330b) this.f963e.get(0)).f921b, Math.min(i, ((C0330b) this.f963e.get(this.f963e.size() - 1)).f921b));
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        int i = 0;
        int a = ag.m1778a(this);
        if (a == 0 || (a == 1 && this.f966h != null && this.f966h.mo1334a() > 1)) {
            int height;
            int width;
            if (!this.f956R.m2404a()) {
                a = canvas.save();
                height = (getHeight() - getPaddingTop()) - getPaddingBottom();
                width = getWidth();
                canvas.rotate(BitmapDescriptorFactory.HUE_VIOLET);
                canvas.translate((float) ((-height) + getPaddingTop()), this.f978t * ((float) width));
                this.f956R.m2403a(height, width);
                i = 0 | this.f956R.m2408a(canvas);
                canvas.restoreToCount(a);
            }
            if (!this.f957S.m2404a()) {
                a = canvas.save();
                height = getWidth();
                width = (getHeight() - getPaddingTop()) - getPaddingBottom();
                canvas.rotate(90.0f);
                canvas.translate((float) (-getPaddingTop()), (-(this.f979u + 1.0f)) * ((float) height));
                this.f957S.m2403a(width, height);
                i |= this.f957S.m2408a(canvas);
                canvas.restoreToCount(a);
            }
        } else {
            this.f956R.m2409b();
            this.f957S.m2409b();
        }
        if (i != 0) {
            ag.m1793b(this);
        }
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f974p > 0 && this.f975q != null && this.f963e.size() > 0 && this.f966h != null) {
            int scrollX = getScrollX();
            int width = getWidth();
            float f = ((float) this.f974p) / ((float) width);
            C0330b c0330b = (C0330b) this.f963e.get(0);
            float f2 = c0330b.f924e;
            int size = this.f963e.size();
            int i = c0330b.f921b;
            int i2 = ((C0330b) this.f963e.get(size - 1)).f921b;
            int i3 = 0;
            int i4 = i;
            while (i4 < i2) {
                float f3;
                while (i4 > c0330b.f921b && i3 < size) {
                    i3++;
                    c0330b = (C0330b) this.f963e.get(i3);
                }
                if (i4 == c0330b.f921b) {
                    f3 = (c0330b.f924e + c0330b.f923d) * ((float) width);
                    f2 = (c0330b.f924e + c0330b.f923d) + f;
                } else {
                    float a = this.f966h.m1598a(i4);
                    f3 = (f2 + a) * ((float) width);
                    f2 += a + f;
                }
                if (((float) this.f974p) + f3 > ((float) scrollX)) {
                    this.f975q.setBounds(Math.round(f3), this.f976r, Math.round(((float) this.f974p) + f3), this.f977s);
                    this.f975q.draw(canvas);
                }
                if (f3 <= ((float) (scrollX + width))) {
                    i4++;
                } else {
                    return;
                }
            }
        }
    }

    private void m1323a(MotionEvent motionEvent) {
        int b = C0474s.m2143b(motionEvent);
        if (C0474s.m2144b(motionEvent, b) == this.f949K) {
            b = b == 0 ? 1 : 0;
            this.f945G = C0474s.m2145c(motionEvent, b);
            this.f949K = C0474s.m2144b(motionEvent, b);
            if (this.f950L != null) {
                this.f950L.clear();
            }
        }
    }

    private void m1339k() {
        this.f940B = false;
        this.f941C = false;
        if (this.f950L != null) {
            this.f950L.recycle();
            this.f950L = null;
        }
    }

    private void setScrollingCacheEnabled(boolean z) {
        if (this.f983y != z) {
            this.f983y = z;
        }
    }

    public boolean canScrollHorizontally(int i) {
        boolean z = true;
        if (this.f966h == null) {
            return false;
        }
        int clientWidth = getClientWidth();
        int scrollX = getScrollX();
        if (i < 0) {
            if (scrollX <= ((int) (((float) clientWidth) * this.f978t))) {
                z = false;
            }
            return z;
        } else if (i <= 0) {
            return false;
        } else {
            if (scrollX >= ((int) (((float) clientWidth) * this.f979u))) {
                z = false;
            }
            return z;
        }
    }

    protected boolean m1351a(View view, boolean z, int i, int i2, int i3) {
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int scrollX = view.getScrollX();
            int scrollY = view.getScrollY();
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (i2 + scrollX >= childAt.getLeft() && i2 + scrollX < childAt.getRight() && i3 + scrollY >= childAt.getTop() && i3 + scrollY < childAt.getBottom()) {
                    if (m1351a(childAt, true, i, (i2 + scrollX) - childAt.getLeft(), (i3 + scrollY) - childAt.getTop())) {
                        return true;
                    }
                }
            }
        }
        if (z && ag.m1791a(view, -i)) {
            return true;
        }
        return false;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m1350a(keyEvent);
    }

    public boolean m1350a(KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0) {
            return false;
        }
        switch (keyEvent.getKeyCode()) {
            case 21:
                return m1356c(17);
            case 22:
                return m1356c(66);
            case 61:
                if (VERSION.SDK_INT < 11) {
                    return false;
                }
                if (C0444g.m2057a(keyEvent)) {
                    return m1356c(2);
                }
                if (C0444g.m2058a(keyEvent, 1)) {
                    return m1356c(1);
                }
                return false;
            default:
                return false;
        }
    }

    public boolean m1356c(int i) {
        View view;
        boolean d;
        View findFocus = findFocus();
        if (findFocus == this) {
            view = null;
        } else {
            if (findFocus != null) {
                Object obj;
                for (ViewPager parent = findFocus.getParent(); parent instanceof ViewGroup; parent = parent.getParent()) {
                    if (parent == this) {
                        obj = 1;
                        break;
                    }
                }
                obj = null;
                if (obj == null) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(findFocus.getClass().getSimpleName());
                    for (ViewParent parent2 = findFocus.getParent(); parent2 instanceof ViewGroup; parent2 = parent2.getParent()) {
                        stringBuilder.append(" => ").append(parent2.getClass().getSimpleName());
                    }
                    Log.e("ViewPager", "arrowScroll tried to find focus based on non-child current focused view " + stringBuilder.toString());
                    view = null;
                }
            }
            view = findFocus;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, view, i);
        if (findNextFocus == null || findNextFocus == view) {
            if (i == 17 || i == 1) {
                d = m1357d();
            } else {
                if (i == 66 || i == 2) {
                    d = m1358e();
                }
                d = false;
            }
        } else if (i == 17) {
            d = (view == null || m1317a(this.f965g, findNextFocus).left < m1317a(this.f965g, view).left) ? findNextFocus.requestFocus() : m1357d();
        } else {
            if (i == 66) {
                d = (view == null || m1317a(this.f965g, findNextFocus).left > m1317a(this.f965g, view).left) ? findNextFocus.requestFocus() : m1358e();
            }
            d = false;
        }
        if (d) {
            playSoundEffect(SoundEffectConstants.getContantForFocusDirection(i));
        }
        return d;
    }

    private Rect m1317a(Rect rect, View view) {
        Rect rect2;
        if (rect == null) {
            rect2 = new Rect();
        } else {
            rect2 = rect;
        }
        if (view == null) {
            rect2.set(0, 0, 0, 0);
            return rect2;
        }
        rect2.left = view.getLeft();
        rect2.right = view.getRight();
        rect2.top = view.getTop();
        rect2.bottom = view.getBottom();
        ViewPager parent = view.getParent();
        while ((parent instanceof ViewGroup) && parent != this) {
            ViewGroup viewGroup = parent;
            rect2.left += viewGroup.getLeft();
            rect2.right += viewGroup.getRight();
            rect2.top += viewGroup.getTop();
            rect2.bottom += viewGroup.getBottom();
            parent = viewGroup.getParent();
        }
        return rect2;
    }

    boolean m1357d() {
        if (this.f967i <= 0) {
            return false;
        }
        m1347a(this.f967i - 1, true);
        return true;
    }

    boolean m1358e() {
        if (this.f966h == null || this.f967i >= this.f966h.mo1334a() - 1) {
            return false;
        }
        m1347a(this.f967i + 1, true);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i, int i2) {
        int size = arrayList.size();
        int descendantFocusability = getDescendantFocusability();
        if (descendantFocusability != 393216) {
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    C0330b a = m1342a(childAt);
                    if (a != null && a.f921b == this.f967i) {
                        childAt.addFocusables(arrayList, i, i2);
                    }
                }
            }
        }
        if ((descendantFocusability == 262144 && size != arrayList.size()) || !isFocusable()) {
            return;
        }
        if (((i2 & 1) != 1 || !isInTouchMode() || isFocusableInTouchMode()) && arrayList != null) {
            arrayList.add(this);
        }
    }

    public void addTouchables(ArrayList<View> arrayList) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0330b a = m1342a(childAt);
                if (a != null && a.f921b == this.f967i) {
                    childAt.addTouchables(arrayList);
                }
            }
        }
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        int i2;
        int i3 = -1;
        int childCount = getChildCount();
        if ((i & 2) != 0) {
            i3 = 1;
            i2 = 0;
        } else {
            i2 = childCount - 1;
            childCount = -1;
        }
        while (i2 != childCount) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 0) {
                C0330b a = m1342a(childAt);
                if (a != null && a.f921b == this.f967i && childAt.requestFocus(i, rect)) {
                    return true;
                }
            }
            i2 += i3;
        }
        return false;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        if (accessibilityEvent.getEventType() == 4096) {
            return super.dispatchPopulateAccessibilityEvent(accessibilityEvent);
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                C0330b a = m1342a(childAt);
                if (a != null && a.f921b == this.f967i && childAt.dispatchPopulateAccessibilityEvent(accessibilityEvent)) {
                    return true;
                }
            }
        }
        return false;
    }

    protected LayoutParams generateDefaultLayoutParams() {
        return new C0331c();
    }

    protected LayoutParams generateLayoutParams(LayoutParams layoutParams) {
        return generateDefaultLayoutParams();
    }

    protected boolean checkLayoutParams(LayoutParams layoutParams) {
        return (layoutParams instanceof C0331c) && super.checkLayoutParams(layoutParams);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new C0331c(getContext(), attributeSet);
    }
}
