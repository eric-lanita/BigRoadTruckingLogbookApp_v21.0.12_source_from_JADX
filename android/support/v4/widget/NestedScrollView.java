package android.support.v4.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.v4.view.C0332a;
import android.support.v4.view.C0474s;
import android.support.v4.view.C0478w;
import android.support.v4.view.C0479x;
import android.support.v4.view.C0480y;
import android.support.v4.view.C0481z;
import android.support.v4.view.ac;
import android.support.v4.view.ae;
import android.support.v4.view.ag;
import android.support.v4.view.p009a.C0352a;
import android.support.v4.view.p009a.C0362b;
import android.support.v4.view.p009a.C0383h;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.FocusFinder;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.View.BaseSavedState;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import com.facebook.internal.Utility;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.List;

public class NestedScrollView extends FrameLayout implements ac, C0478w, C0480y {
    private static final C0483a f1058v = new C0483a();
    private static final int[] f1059w = new int[]{16843130};
    private C0484b f1060A;
    private long f1061a;
    private final Rect f1062b;
    private C0549w f1063c;
    private C0521i f1064d;
    private C0521i f1065e;
    private int f1066f;
    private boolean f1067g;
    private boolean f1068h;
    private View f1069i;
    private boolean f1070j;
    private VelocityTracker f1071k;
    private boolean f1072l;
    private boolean f1073m;
    private int f1074n;
    private int f1075o;
    private int f1076p;
    private int f1077q;
    private final int[] f1078r;
    private final int[] f1079s;
    private int f1080t;
    private SavedState f1081u;
    private final C0481z f1082x;
    private final C0479x f1083y;
    private float f1084z;

    static class SavedState extends BaseSavedState {
        public static final Creator<SavedState> CREATOR = new C04821();
        public int f1057a;

        static class C04821 implements Creator<SavedState> {
            C04821() {
            }

            public /* synthetic */ Object createFromParcel(Parcel parcel) {
                return m2169a(parcel);
            }

            public /* synthetic */ Object[] newArray(int i) {
                return m2170a(i);
            }

            public SavedState m2169a(Parcel parcel) {
                return new SavedState(parcel);
            }

            public SavedState[] m2170a(int i) {
                return new SavedState[i];
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f1057a = parcel.readInt();
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            parcel.writeInt(this.f1057a);
        }

        public String toString() {
            return "HorizontalScrollView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " scrollPosition=" + this.f1057a + "}";
        }
    }

    static class C0483a extends C0332a {
        C0483a() {
        }

        public boolean mo188a(View view, int i, Bundle bundle) {
            if (super.mo188a(view, i, bundle)) {
                return true;
            }
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            if (!nestedScrollView.isEnabled()) {
                return false;
            }
            int min;
            switch (i) {
                case 4096:
                    min = Math.min(((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()) + nestedScrollView.getScrollY(), nestedScrollView.getScrollRange());
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2200b(0, min);
                    return true;
                case Utility.DEFAULT_STREAM_BUFFER_SIZE /*8192*/:
                    min = Math.max(nestedScrollView.getScrollY() - ((nestedScrollView.getHeight() - nestedScrollView.getPaddingBottom()) - nestedScrollView.getPaddingTop()), 0);
                    if (min == nestedScrollView.getScrollY()) {
                        return false;
                    }
                    nestedScrollView.m2200b(0, min);
                    return true;
                default:
                    return false;
            }
        }

        public void mo187a(View view, C0362b c0362b) {
            super.mo187a(view, c0362b);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            c0362b.m1493a(ScrollView.class.getName());
            if (nestedScrollView.isEnabled()) {
                int a = nestedScrollView.getScrollRange();
                if (a > 0) {
                    c0362b.m1494a(true);
                    if (nestedScrollView.getScrollY() > 0) {
                        c0362b.m1491a((int) Utility.DEFAULT_STREAM_BUFFER_SIZE);
                    }
                    if (nestedScrollView.getScrollY() < a) {
                        c0362b.m1491a(4096);
                    }
                }
            }
        }

        public void mo189d(View view, AccessibilityEvent accessibilityEvent) {
            super.mo189d(view, accessibilityEvent);
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            accessibilityEvent.setClassName(ScrollView.class.getName());
            C0383h a = C0352a.m1425a(accessibilityEvent);
            a.m1583a(nestedScrollView.getScrollRange() > 0);
            a.m1586d(nestedScrollView.getScrollX());
            a.m1587e(nestedScrollView.getScrollY());
            a.m1588f(nestedScrollView.getScrollX());
            a.m1589g(nestedScrollView.getScrollRange());
        }
    }

    public interface C0484b {
        void mo424a(NestedScrollView nestedScrollView, int i, int i2, int i3, int i4);
    }

    public NestedScrollView(Context context) {
        this(context, null);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NestedScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f1062b = new Rect();
        this.f1067g = true;
        this.f1068h = false;
        this.f1069i = null;
        this.f1070j = false;
        this.f1073m = true;
        this.f1077q = -1;
        this.f1078r = new int[2];
        this.f1079s = new int[2];
        m2177a();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1059w, i, 0);
        setFillViewport(obtainStyledAttributes.getBoolean(0, false));
        obtainStyledAttributes.recycle();
        this.f1082x = new C0481z(this);
        this.f1083y = new C0479x(this);
        setNestedScrollingEnabled(true);
        ag.m1785a((View) this, f1058v);
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1083y.m2157a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1083y.m2158a();
    }

    public boolean startNestedScroll(int i) {
        return this.f1083y.m2161a(i);
    }

    public void stopNestedScroll() {
        this.f1083y.m2165c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1083y.m2164b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1083y.m2162a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1083y.m2163a(i, i2, iArr, iArr2);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1083y.m2160a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1083y.m2159a(f, f2);
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (i & 2) != 0;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1082x.m2168a(view, view2, i);
        startNestedScroll(2);
    }

    public void onStopNestedScroll(View view) {
        this.f1082x.m2167a(view);
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        int scrollY = getScrollY();
        scrollBy(0, i4);
        int scrollY2 = getScrollY() - scrollY;
        dispatchNestedScroll(0, scrollY2, 0, i4 - scrollY2, null);
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        dispatchNestedPreScroll(i, i2, iArr, null);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        if (z) {
            return false;
        }
        m2193f((int) f2);
        return true;
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public int getNestedScrollAxes() {
        return this.f1082x.m2166a();
    }

    public boolean shouldDelayChildPressedState() {
        return true;
    }

    protected float getTopFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int scrollY = getScrollY();
        if (scrollY < verticalFadingEdgeLength) {
            return ((float) scrollY) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    protected float getBottomFadingEdgeStrength() {
        if (getChildCount() == 0) {
            return 0.0f;
        }
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        int bottom = (getChildAt(0).getBottom() - getScrollY()) - (getHeight() - getPaddingBottom());
        if (bottom < verticalFadingEdgeLength) {
            return ((float) bottom) / ((float) verticalFadingEdgeLength);
        }
        return 1.0f;
    }

    public int getMaxScrollAmount() {
        return (int) (0.5f * ((float) getHeight()));
    }

    private void m2177a() {
        this.f1063c = C0549w.m2543a(getContext(), null);
        setFocusable(true);
        setDescendantFocusability(262144);
        setWillNotDraw(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.f1074n = viewConfiguration.getScaledTouchSlop();
        this.f1075o = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1076p = viewConfiguration.getScaledMaximumFlingVelocity();
    }

    public void addView(View view) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view);
    }

    public void addView(View view, int i) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i);
    }

    public void addView(View view, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, layoutParams);
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (getChildCount() > 0) {
            throw new IllegalStateException("ScrollView can host only one direct child");
        }
        super.addView(view, i, layoutParams);
    }

    public void setOnScrollChangeListener(C0484b c0484b) {
        this.f1060A = c0484b;
    }

    private boolean m2186b() {
        View childAt = getChildAt(0);
        if (childAt == null) {
            return false;
        }
        if (getHeight() < (childAt.getHeight() + getPaddingTop()) + getPaddingBottom()) {
            return true;
        }
        return false;
    }

    public void setFillViewport(boolean z) {
        if (z != this.f1072l) {
            this.f1072l = z;
            requestLayout();
        }
    }

    public void setSmoothScrollingEnabled(boolean z) {
        this.f1073m = z;
    }

    protected void onScrollChanged(int i, int i2, int i3, int i4) {
        super.onScrollChanged(i, i2, i3, i4);
        if (this.f1060A != null) {
            this.f1060A.mo424a(this, i, i2, i3, i4);
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1072l && MeasureSpec.getMode(i2) != 0 && getChildCount() > 0) {
            View childAt = getChildAt(0);
            int measuredHeight = getMeasuredHeight();
            if (childAt.getMeasuredHeight() < measuredHeight) {
                childAt.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), ((FrameLayout.LayoutParams) childAt.getLayoutParams()).width), MeasureSpec.makeMeasureSpec((measuredHeight - getPaddingTop()) - getPaddingBottom(), 1073741824));
            }
        }
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        return super.dispatchKeyEvent(keyEvent) || m2199a(keyEvent);
    }

    public boolean m2199a(KeyEvent keyEvent) {
        int i = 33;
        this.f1062b.setEmpty();
        if (m2186b()) {
            if (keyEvent.getAction() != 0) {
                return false;
            }
            switch (keyEvent.getKeyCode()) {
                case 19:
                    if (keyEvent.isAltPressed()) {
                        return m2201b(33);
                    }
                    return m2202c(33);
                case 20:
                    if (keyEvent.isAltPressed()) {
                        return m2201b(130);
                    }
                    return m2202c(130);
                case 62:
                    if (!keyEvent.isShiftPressed()) {
                        i = 130;
                    }
                    m2197a(i);
                    return false;
                default:
                    return false;
            }
        } else if (!isFocused() || keyEvent.getKeyCode() == 4) {
            return false;
        } else {
            boolean z;
            View findFocus = findFocus();
            if (findFocus == this) {
                findFocus = null;
            }
            findFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, 130);
            if (findFocus == null || findFocus == this || !findFocus.requestFocus(130)) {
                z = false;
            } else {
                z = true;
            }
            return z;
        }
    }

    private boolean m2188c(int i, int i2) {
        if (getChildCount() <= 0) {
            return false;
        }
        int scrollY = getScrollY();
        View childAt = getChildAt(0);
        if (i2 < childAt.getTop() - scrollY || i2 >= childAt.getBottom() - scrollY || i < childAt.getLeft() || i >= childAt.getRight()) {
            return false;
        }
        return true;
    }

    private void m2187c() {
        if (this.f1071k == null) {
            this.f1071k = VelocityTracker.obtain();
        } else {
            this.f1071k.clear();
        }
    }

    private void m2189d() {
        if (this.f1071k == null) {
            this.f1071k = VelocityTracker.obtain();
        }
    }

    private void m2190e() {
        if (this.f1071k != null) {
            this.f1071k.recycle();
            this.f1071k = null;
        }
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (z) {
            m2190e();
        }
        super.requestDisallowInterceptTouchEvent(z);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z = false;
        int action = motionEvent.getAction();
        if (action == 2 && this.f1070j) {
            return true;
        }
        switch (action & 255) {
            case 0:
                action = (int) motionEvent.getY();
                if (!m2188c((int) motionEvent.getX(), action)) {
                    this.f1070j = false;
                    m2190e();
                    break;
                }
                this.f1066f = action;
                this.f1077q = C0474s.m2144b(motionEvent, 0);
                m2187c();
                this.f1071k.addMovement(motionEvent);
                this.f1063c.m2555g();
                if (!this.f1063c.m2548a()) {
                    z = true;
                }
                this.f1070j = z;
                startNestedScroll(2);
                break;
            case 1:
            case 3:
                this.f1070j = false;
                this.f1077q = -1;
                m2190e();
                if (this.f1063c.m2549a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ag.m1793b(this);
                }
                stopNestedScroll();
                break;
            case 2:
                action = this.f1077q;
                if (action != -1) {
                    int a = C0474s.m2142a(motionEvent, action);
                    if (a != -1) {
                        action = (int) C0474s.m2147d(motionEvent, a);
                        if (Math.abs(action - this.f1066f) > this.f1074n && (getNestedScrollAxes() & 2) == 0) {
                            this.f1070j = true;
                            this.f1066f = action;
                            m2189d();
                            this.f1071k.addMovement(motionEvent);
                            this.f1080t = 0;
                            ViewParent parent = getParent();
                            if (parent != null) {
                                parent.requestDisallowInterceptTouchEvent(true);
                                break;
                            }
                        }
                    }
                    Log.e("NestedScrollView", "Invalid pointerId=" + action + " in onInterceptTouchEvent");
                    break;
                }
                break;
            case 6:
                m2178a(motionEvent);
                break;
        }
        return this.f1070j;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        m2189d();
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        int a = C0474s.m2141a(motionEvent);
        if (a == 0) {
            this.f1080t = 0;
        }
        obtain.offsetLocation(0.0f, (float) this.f1080t);
        switch (a) {
            case 0:
                if (getChildCount() != 0) {
                    boolean z = !this.f1063c.m2548a();
                    this.f1070j = z;
                    if (z) {
                        ViewParent parent = getParent();
                        if (parent != null) {
                            parent.requestDisallowInterceptTouchEvent(true);
                        }
                    }
                    if (!this.f1063c.m2548a()) {
                        this.f1063c.m2556h();
                    }
                    this.f1066f = (int) motionEvent.getY();
                    this.f1077q = C0474s.m2144b(motionEvent, 0);
                    startNestedScroll(2);
                    break;
                }
                return false;
            case 1:
                if (this.f1070j) {
                    VelocityTracker velocityTracker = this.f1071k;
                    velocityTracker.computeCurrentVelocity(1000, (float) this.f1076p);
                    a = (int) ae.m1623b(velocityTracker, this.f1077q);
                    if (Math.abs(a) > this.f1075o) {
                        m2193f(-a);
                    } else if (this.f1063c.m2549a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                        ag.m1793b(this);
                    }
                }
                this.f1077q = -1;
                m2192f();
                break;
            case 2:
                int a2 = C0474s.m2142a(motionEvent, this.f1077q);
                if (a2 != -1) {
                    int i;
                    int d = (int) C0474s.m2147d(motionEvent, a2);
                    a = this.f1066f - d;
                    if (dispatchNestedPreScroll(0, a, this.f1079s, this.f1078r)) {
                        a -= this.f1079s[1];
                        obtain.offsetLocation(0.0f, (float) this.f1078r[1]);
                        this.f1080t += this.f1078r[1];
                    }
                    if (this.f1070j || Math.abs(a) <= this.f1074n) {
                        i = a;
                    } else {
                        ViewParent parent2 = getParent();
                        if (parent2 != null) {
                            parent2.requestDisallowInterceptTouchEvent(true);
                        }
                        this.f1070j = true;
                        if (a > 0) {
                            i = a - this.f1074n;
                        } else {
                            i = a + this.f1074n;
                        }
                    }
                    if (this.f1070j) {
                        Object obj;
                        this.f1066f = d - this.f1078r[1];
                        int scrollY = getScrollY();
                        int scrollRange = getScrollRange();
                        a = ag.m1778a(this);
                        if (a == 0 || (a == 1 && scrollRange > 0)) {
                            obj = 1;
                        } else {
                            obj = null;
                        }
                        if (m2198a(0, i, 0, getScrollY(), 0, scrollRange, 0, 0, true) && !hasNestedScrollingParent()) {
                            this.f1071k.clear();
                        }
                        int scrollY2 = getScrollY() - scrollY;
                        if (!dispatchNestedScroll(0, scrollY2, 0, i - scrollY2, this.f1078r)) {
                            if (obj != null) {
                                m2194g();
                                a = scrollY + i;
                                if (a < 0) {
                                    this.f1064d.m2406a(((float) i) / ((float) getHeight()), C0474s.m2145c(motionEvent, a2) / ((float) getWidth()));
                                    if (!this.f1065e.m2404a()) {
                                        this.f1065e.m2410c();
                                    }
                                } else if (a > scrollRange) {
                                    this.f1065e.m2406a(((float) i) / ((float) getHeight()), 1.0f - (C0474s.m2145c(motionEvent, a2) / ((float) getWidth())));
                                    if (!this.f1064d.m2404a()) {
                                        this.f1064d.m2410c();
                                    }
                                }
                                if (!(this.f1064d == null || (this.f1064d.m2404a() && this.f1065e.m2404a()))) {
                                    ag.m1793b(this);
                                    break;
                                }
                            }
                        }
                        this.f1066f -= this.f1078r[1];
                        obtain.offsetLocation(0.0f, (float) this.f1078r[1]);
                        this.f1080t += this.f1078r[1];
                        break;
                    }
                }
                Log.e("NestedScrollView", "Invalid pointerId=" + this.f1077q + " in onTouchEvent");
                break;
                break;
            case 3:
                if (this.f1070j && getChildCount() > 0 && this.f1063c.m2549a(getScrollX(), getScrollY(), 0, 0, 0, getScrollRange())) {
                    ag.m1793b(this);
                }
                this.f1077q = -1;
                m2192f();
                break;
            case 5:
                a = C0474s.m2143b(motionEvent);
                this.f1066f = (int) C0474s.m2147d(motionEvent, a);
                this.f1077q = C0474s.m2144b(motionEvent, a);
                break;
            case 6:
                m2178a(motionEvent);
                this.f1066f = (int) C0474s.m2147d(motionEvent, C0474s.m2142a(motionEvent, this.f1077q));
                break;
        }
        if (this.f1071k != null) {
            this.f1071k.addMovement(obtain);
        }
        obtain.recycle();
        return true;
    }

    private void m2178a(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (C0474s.m2144b(motionEvent, action) == this.f1077q) {
            action = action == 0 ? 1 : 0;
            this.f1066f = (int) C0474s.m2147d(motionEvent, action);
            this.f1077q = C0474s.m2144b(motionEvent, action);
            if (this.f1071k != null) {
                this.f1071k.clear();
            }
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((C0474s.m2148d(motionEvent) & 2) == 0) {
            return false;
        }
        switch (motionEvent.getAction()) {
            case 8:
                if (this.f1070j) {
                    return false;
                }
                float e = C0474s.m2149e(motionEvent, 9);
                if (e == 0.0f) {
                    return false;
                }
                int verticalScrollFactorCompat = (int) (e * getVerticalScrollFactorCompat());
                int scrollRange = getScrollRange();
                int scrollY = getScrollY();
                verticalScrollFactorCompat = scrollY - verticalScrollFactorCompat;
                if (verticalScrollFactorCompat < 0) {
                    scrollRange = 0;
                } else if (verticalScrollFactorCompat <= scrollRange) {
                    scrollRange = verticalScrollFactorCompat;
                }
                if (scrollRange == scrollY) {
                    return false;
                }
                super.scrollTo(getScrollX(), scrollRange);
                return true;
            default:
                return false;
        }
    }

    private float getVerticalScrollFactorCompat() {
        if (this.f1084z == 0.0f) {
            TypedValue typedValue = new TypedValue();
            Context context = getContext();
            if (context.getTheme().resolveAttribute(16842829, typedValue, true)) {
                this.f1084z = typedValue.getDimension(context.getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f1084z;
    }

    protected void onOverScrolled(int i, int i2, boolean z, boolean z2) {
        super.scrollTo(i, i2);
    }

    boolean m2198a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z) {
        boolean z2;
        boolean z3;
        int a = ag.m1778a(this);
        Object obj = computeHorizontalScrollRange() > computeHorizontalScrollExtent() ? 1 : null;
        Object obj2 = computeVerticalScrollRange() > computeVerticalScrollExtent() ? 1 : null;
        Object obj3 = (a == 0 || (a == 1 && obj != null)) ? 1 : null;
        obj = (a == 0 || (a == 1 && obj2 != null)) ? 1 : null;
        int i9 = i3 + i;
        if (obj3 == null) {
            i7 = 0;
        }
        int i10 = i4 + i2;
        if (obj == null) {
            i8 = 0;
        }
        int i11 = -i7;
        int i12 = i7 + i5;
        a = -i8;
        int i13 = i8 + i6;
        if (i9 > i12) {
            z2 = true;
        } else if (i9 < i11) {
            z2 = true;
            i12 = i11;
        } else {
            z2 = false;
            i12 = i9;
        }
        if (i10 > i13) {
            z3 = true;
        } else if (i10 < a) {
            z3 = true;
            i13 = a;
        } else {
            z3 = false;
            i13 = i10;
        }
        if (z3) {
            this.f1063c.m2549a(i12, i13, 0, 0, 0, getScrollRange());
        }
        onOverScrolled(i12, i13, z2, z3);
        if (z2 || z3) {
            return true;
        }
        return false;
    }

    private int getScrollRange() {
        if (getChildCount() > 0) {
            return Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
        }
        return 0;
    }

    private View m2176a(boolean z, int i, int i2) {
        List focusables = getFocusables(2);
        View view = null;
        Object obj = null;
        int size = focusables.size();
        int i3 = 0;
        while (i3 < size) {
            View view2;
            Object obj2;
            View view3 = (View) focusables.get(i3);
            int top = view3.getTop();
            int bottom = view3.getBottom();
            if (i < bottom && top < i2) {
                Object obj3 = (i >= top || bottom >= i2) ? null : 1;
                if (view == null) {
                    Object obj4 = obj3;
                    view2 = view3;
                    obj2 = obj4;
                } else {
                    Object obj5 = ((!z || top >= view.getTop()) && (z || bottom <= view.getBottom())) ? null : 1;
                    if (obj != null) {
                        if (!(obj3 == null || obj5 == null)) {
                            view2 = view3;
                            obj2 = obj;
                        }
                    } else if (obj3 != null) {
                        view2 = view3;
                        int i4 = 1;
                    } else if (obj5 != null) {
                        view2 = view3;
                        obj2 = obj;
                    }
                }
                i3++;
                view = view2;
                obj = obj2;
            }
            obj2 = obj;
            view2 = view;
            i3++;
            view = view2;
            obj = obj2;
        }
        return view;
    }

    public boolean m2197a(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        if (i2 != 0) {
            this.f1062b.top = getScrollY() + height;
            i2 = getChildCount();
            if (i2 > 0) {
                View childAt = getChildAt(i2 - 1);
                if (this.f1062b.top + height > childAt.getBottom()) {
                    this.f1062b.top = childAt.getBottom() - height;
                }
            }
        } else {
            this.f1062b.top = getScrollY() - height;
            if (this.f1062b.top < 0) {
                this.f1062b.top = 0;
            }
        }
        this.f1062b.bottom = this.f1062b.top + height;
        return m2179a(i, this.f1062b.top, this.f1062b.bottom);
    }

    public boolean m2201b(int i) {
        int i2 = i == 130 ? 1 : 0;
        int height = getHeight();
        this.f1062b.top = 0;
        this.f1062b.bottom = height;
        if (i2 != 0) {
            i2 = getChildCount();
            if (i2 > 0) {
                this.f1062b.bottom = getChildAt(i2 - 1).getBottom() + getPaddingBottom();
                this.f1062b.top = this.f1062b.bottom - height;
            }
        }
        return m2179a(i, this.f1062b.top, this.f1062b.bottom);
    }

    private boolean m2179a(int i, int i2, int i3) {
        boolean z = false;
        int height = getHeight();
        int scrollY = getScrollY();
        int i4 = scrollY + height;
        boolean z2 = i == 33;
        View a = m2176a(z2, i2, i3);
        if (a == null) {
            a = this;
        }
        if (i2 < scrollY || i3 > i4) {
            m2191e(z2 ? i2 - scrollY : i3 - i4);
            z = true;
        }
        if (a != findFocus()) {
            a.requestFocus(i);
        }
        return z;
    }

    public boolean m2202c(int i) {
        View findFocus = findFocus();
        if (findFocus == this) {
            findFocus = null;
        }
        View findNextFocus = FocusFinder.getInstance().findNextFocus(this, findFocus, i);
        int maxScrollAmount = getMaxScrollAmount();
        if (findNextFocus == null || !m2182a(findNextFocus, maxScrollAmount, getHeight())) {
            if (i == 33 && getScrollY() < maxScrollAmount) {
                maxScrollAmount = getScrollY();
            } else if (i == 130 && getChildCount() > 0) {
                int bottom = getChildAt(0).getBottom();
                int scrollY = (getScrollY() + getHeight()) - getPaddingBottom();
                if (bottom - scrollY < maxScrollAmount) {
                    maxScrollAmount = bottom - scrollY;
                }
            }
            if (maxScrollAmount == 0) {
                return false;
            }
            if (i != 130) {
                maxScrollAmount = -maxScrollAmount;
            }
            m2191e(maxScrollAmount);
        } else {
            findNextFocus.getDrawingRect(this.f1062b);
            offsetDescendantRectToMyCoords(findNextFocus, this.f1062b);
            m2191e(m2195a(this.f1062b));
            findNextFocus.requestFocus(i);
        }
        if (findFocus != null && findFocus.isFocused() && m2181a(findFocus)) {
            int descendantFocusability = getDescendantFocusability();
            setDescendantFocusability(131072);
            requestFocus();
            setDescendantFocusability(descendantFocusability);
        }
        return true;
    }

    private boolean m2181a(View view) {
        return !m2182a(view, 0, getHeight());
    }

    private boolean m2182a(View view, int i, int i2) {
        view.getDrawingRect(this.f1062b);
        offsetDescendantRectToMyCoords(view, this.f1062b);
        return this.f1062b.bottom + i >= getScrollY() && this.f1062b.top - i <= getScrollY() + i2;
    }

    private void m2191e(int i) {
        if (i == 0) {
            return;
        }
        if (this.f1073m) {
            m2196a(0, i);
        } else {
            scrollBy(0, i);
        }
    }

    public final void m2196a(int i, int i2) {
        if (getChildCount() != 0) {
            if (AnimationUtils.currentAnimationTimeMillis() - this.f1061a > 250) {
                int max = Math.max(0, getChildAt(0).getHeight() - ((getHeight() - getPaddingBottom()) - getPaddingTop()));
                int scrollY = getScrollY();
                this.f1063c.m2544a(getScrollX(), scrollY, 0, Math.max(0, Math.min(scrollY + i2, max)) - scrollY);
                ag.m1793b(this);
            } else {
                if (!this.f1063c.m2548a()) {
                    this.f1063c.m2556h();
                }
                scrollBy(i, i2);
            }
            this.f1061a = AnimationUtils.currentAnimationTimeMillis();
        }
    }

    public final void m2200b(int i, int i2) {
        m2196a(i - getScrollX(), i2 - getScrollY());
    }

    public int computeVerticalScrollRange() {
        int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
        if (getChildCount() == 0) {
            return height;
        }
        int bottom = getChildAt(0).getBottom();
        int scrollY = getScrollY();
        height = Math.max(0, bottom - height);
        if (scrollY < 0) {
            return bottom - scrollY;
        }
        if (scrollY > height) {
            return bottom + (scrollY - height);
        }
        return bottom;
    }

    public int computeVerticalScrollOffset() {
        return Math.max(0, super.computeVerticalScrollOffset());
    }

    public int computeVerticalScrollExtent() {
        return super.computeVerticalScrollExtent();
    }

    public int computeHorizontalScrollRange() {
        return super.computeHorizontalScrollRange();
    }

    public int computeHorizontalScrollOffset() {
        return super.computeHorizontalScrollOffset();
    }

    public int computeHorizontalScrollExtent() {
        return super.computeHorizontalScrollExtent();
    }

    protected void measureChild(View view, int i, int i2) {
        view.measure(getChildMeasureSpec(i, getPaddingLeft() + getPaddingRight(), view.getLayoutParams().width), MeasureSpec.makeMeasureSpec(0, 0));
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        MarginLayoutParams marginLayoutParams = (MarginLayoutParams) view.getLayoutParams();
        view.measure(getChildMeasureSpec(i, (((getPaddingLeft() + getPaddingRight()) + marginLayoutParams.leftMargin) + marginLayoutParams.rightMargin) + i2, marginLayoutParams.width), MeasureSpec.makeMeasureSpec(marginLayoutParams.bottomMargin + marginLayoutParams.topMargin, 0));
    }

    public void computeScroll() {
        if (this.f1063c.m2555g()) {
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int b = this.f1063c.m2550b();
            int c = this.f1063c.m2551c();
            if (scrollX != b || scrollY != c) {
                int scrollRange = getScrollRange();
                int a = ag.m1778a(this);
                int i = (a == 0 || (a == 1 && scrollRange > 0)) ? 1 : 0;
                m2198a(b - scrollX, c - scrollY, scrollX, scrollY, 0, scrollRange, 0, 0, false);
                if (i != 0) {
                    m2194g();
                    if (c <= 0 && scrollY > 0) {
                        this.f1064d.m2407a((int) this.f1063c.m2554f());
                    } else if (c >= scrollRange && scrollY < scrollRange) {
                        this.f1065e.m2407a((int) this.f1063c.m2554f());
                    }
                }
            }
        }
    }

    private void m2185b(View view) {
        view.getDrawingRect(this.f1062b);
        offsetDescendantRectToMyCoords(view, this.f1062b);
        int a = m2195a(this.f1062b);
        if (a != 0) {
            scrollBy(0, a);
        }
    }

    private boolean m2180a(Rect rect, boolean z) {
        int a = m2195a(rect);
        boolean z2 = a != 0;
        if (z2) {
            if (z) {
                scrollBy(0, a);
            } else {
                m2196a(0, a);
            }
        }
        return z2;
    }

    protected int m2195a(Rect rect) {
        if (getChildCount() == 0) {
            return 0;
        }
        int height = getHeight();
        int scrollY = getScrollY();
        int i = scrollY + height;
        int verticalFadingEdgeLength = getVerticalFadingEdgeLength();
        if (rect.top > 0) {
            scrollY += verticalFadingEdgeLength;
        }
        if (rect.bottom < getChildAt(0).getHeight()) {
            i -= verticalFadingEdgeLength;
        }
        if (rect.bottom > i && rect.top > scrollY) {
            if (rect.height() > height) {
                scrollY = (rect.top - scrollY) + 0;
            } else {
                scrollY = (rect.bottom - i) + 0;
            }
            scrollY = Math.min(scrollY, getChildAt(0).getBottom() - i);
        } else if (rect.top >= scrollY || rect.bottom >= i) {
            scrollY = 0;
        } else {
            if (rect.height() > height) {
                scrollY = 0 - (i - rect.bottom);
            } else {
                scrollY = 0 - (scrollY - rect.top);
            }
            scrollY = Math.max(scrollY, -getScrollY());
        }
        return scrollY;
    }

    public void requestChildFocus(View view, View view2) {
        if (this.f1067g) {
            this.f1069i = view2;
        } else {
            m2185b(view2);
        }
        super.requestChildFocus(view, view2);
    }

    protected boolean onRequestFocusInDescendants(int i, Rect rect) {
        if (i == 2) {
            i = 130;
        } else if (i == 1) {
            i = 33;
        }
        View findNextFocus = rect == null ? FocusFinder.getInstance().findNextFocus(this, null, i) : FocusFinder.getInstance().findNextFocusFromRect(this, rect, i);
        if (findNextFocus == null || m2181a(findNextFocus)) {
            return false;
        }
        return findNextFocus.requestFocus(i, rect);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z) {
        rect.offset(view.getLeft() - view.getScrollX(), view.getTop() - view.getScrollY());
        return m2180a(rect, z);
    }

    public void requestLayout() {
        this.f1067g = true;
        super.requestLayout();
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        this.f1067g = false;
        if (this.f1069i != null && m2183a(this.f1069i, (View) this)) {
            m2185b(this.f1069i);
        }
        this.f1069i = null;
        if (!this.f1068h) {
            if (this.f1081u != null) {
                scrollTo(getScrollX(), this.f1081u.f1057a);
                this.f1081u = null;
            }
            int max = Math.max(0, (getChildCount() > 0 ? getChildAt(0).getMeasuredHeight() : 0) - (((i4 - i2) - getPaddingBottom()) - getPaddingTop()));
            if (getScrollY() > max) {
                scrollTo(getScrollX(), max);
            } else if (getScrollY() < 0) {
                scrollTo(getScrollX(), 0);
            }
        }
        scrollTo(getScrollX(), getScrollY());
        this.f1068h = true;
    }

    public void onAttachedToWindow() {
        this.f1068h = false;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        View findFocus = findFocus();
        if (findFocus != null && this != findFocus && m2182a(findFocus, 0, i4)) {
            findFocus.getDrawingRect(this.f1062b);
            offsetDescendantRectToMyCoords(findFocus, this.f1062b);
            m2191e(m2195a(this.f1062b));
        }
    }

    private static boolean m2183a(View view, View view2) {
        if (view == view2) {
            return true;
        }
        ViewParent parent = view.getParent();
        boolean z = (parent instanceof ViewGroup) && m2183a((View) parent, view2);
        return z;
    }

    public void m2203d(int i) {
        if (getChildCount() > 0) {
            int height = (getHeight() - getPaddingBottom()) - getPaddingTop();
            int height2 = getChildAt(0).getHeight();
            this.f1063c.m2547a(getScrollX(), getScrollY(), 0, i, 0, 0, 0, Math.max(0, height2 - height), 0, height / 2);
            ag.m1793b(this);
        }
    }

    private void m2193f(int i) {
        int scrollY = getScrollY();
        boolean z = (scrollY > 0 || i > 0) && (scrollY < getScrollRange() || i < 0);
        if (!dispatchNestedPreFling(0.0f, (float) i)) {
            dispatchNestedFling(0.0f, (float) i, z);
            if (z) {
                m2203d(i);
            }
        }
    }

    private void m2192f() {
        this.f1070j = false;
        m2190e();
        stopNestedScroll();
        if (this.f1064d != null) {
            this.f1064d.m2410c();
            this.f1065e.m2410c();
        }
    }

    public void scrollTo(int i, int i2) {
        if (getChildCount() > 0) {
            View childAt = getChildAt(0);
            int b = m2184b(i, (getWidth() - getPaddingRight()) - getPaddingLeft(), childAt.getWidth());
            int b2 = m2184b(i2, (getHeight() - getPaddingBottom()) - getPaddingTop(), childAt.getHeight());
            if (b != getScrollX() || b2 != getScrollY()) {
                super.scrollTo(b, b2);
            }
        }
    }

    private void m2194g() {
        if (ag.m1778a(this) == 2) {
            this.f1064d = null;
            this.f1065e = null;
        } else if (this.f1064d == null) {
            Context context = getContext();
            this.f1064d = new C0521i(context);
            this.f1065e = new C0521i(context);
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f1064d != null) {
            int save;
            int width;
            int scrollY = getScrollY();
            if (!this.f1064d.m2404a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                canvas.translate((float) getPaddingLeft(), (float) Math.min(0, scrollY));
                this.f1064d.m2403a(width, getHeight());
                if (this.f1064d.m2408a(canvas)) {
                    ag.m1793b(this);
                }
                canvas.restoreToCount(save);
            }
            if (!this.f1065e.m2404a()) {
                save = canvas.save();
                width = (getWidth() - getPaddingLeft()) - getPaddingRight();
                int height = getHeight();
                canvas.translate((float) ((-width) + getPaddingLeft()), (float) (Math.max(getScrollRange(), scrollY) + height));
                canvas.rotate(BitmapDescriptorFactory.HUE_CYAN, (float) width, 0.0f);
                this.f1065e.m2403a(width, height);
                if (this.f1065e.m2408a(canvas)) {
                    ag.m1793b(this);
                }
                canvas.restoreToCount(save);
            }
        }
    }

    private static int m2184b(int i, int i2, int i3) {
        if (i2 >= i3 || i < 0) {
            return 0;
        }
        if (i2 + i > i3) {
            return i3 - i2;
        }
        return i;
    }

    protected void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof SavedState) {
            SavedState savedState = (SavedState) parcelable;
            super.onRestoreInstanceState(savedState.getSuperState());
            this.f1081u = savedState;
            requestLayout();
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    protected Parcelable onSaveInstanceState() {
        Parcelable savedState = new SavedState(super.onSaveInstanceState());
        savedState.f1057a = getScrollY();
        return savedState;
    }
}
