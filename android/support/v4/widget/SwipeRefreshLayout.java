package android.support.v4.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.C0474s;
import android.support.v4.view.C0478w;
import android.support.v4.view.C0479x;
import android.support.v4.view.C0480y;
import android.support.v4.view.C0481z;
import android.support.v4.view.ag;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Transformation;
import android.widget.AbsListView;
import com.google.android.gms.maps.model.GroundOverlayOptions;

public class SwipeRefreshLayout extends ViewGroup implements C0478w, C0480y {
    private static final String f1095c = SwipeRefreshLayout.class.getSimpleName();
    private static final int[] f1096y = new int[]{16842766};
    private int f1097A;
    private float f1098B;
    private C0532p f1099C;
    private Animation f1100D;
    private Animation f1101E;
    private Animation f1102F;
    private Animation f1103G;
    private Animation f1104H;
    private float f1105I;
    private boolean f1106J;
    private int f1107K;
    private int f1108L;
    private boolean f1109M;
    private AnimationListener f1110N;
    private final Animation f1111O;
    private final Animation f1112P;
    protected int f1113a;
    protected int f1114b;
    private View f1115d;
    private C0493a f1116e;
    private boolean f1117f;
    private int f1118g;
    private float f1119h;
    private float f1120i;
    private final C0481z f1121j;
    private final C0479x f1122k;
    private final int[] f1123l;
    private final int[] f1124m;
    private boolean f1125n;
    private int f1126o;
    private int f1127p;
    private boolean f1128q;
    private float f1129r;
    private float f1130s;
    private boolean f1131t;
    private int f1132u;
    private boolean f1133v;
    private boolean f1134w;
    private final DecelerateInterpolator f1135x;
    private C0502b f1136z;

    class C04851 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f1085a;

        C04851(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1085a = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (this.f1085a.f1117f) {
                this.f1085a.f1099C.setAlpha(255);
                this.f1085a.f1099C.start();
                if (this.f1085a.f1106J && this.f1085a.f1116e != null) {
                    this.f1085a.f1116e.mo2803a();
                }
                this.f1085a.f1127p = this.f1085a.f1136z.getTop();
                return;
            }
            this.f1085a.m2221b();
        }
    }

    class C04862 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1086a;

        C04862(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1086a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1086a.setAnimationProgress(f);
        }
    }

    class C04873 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1087a;

        C04873(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1087a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1087a.setAnimationProgress(1.0f - f);
        }
    }

    class C04895 implements AnimationListener {
        final /* synthetic */ SwipeRefreshLayout f1091a;

        C04895(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1091a = swipeRefreshLayout;
        }

        public void onAnimationStart(Animation animation) {
        }

        public void onAnimationEnd(Animation animation) {
            if (!this.f1091a.f1133v) {
                this.f1091a.m2225b(null);
            }
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    class C04906 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1092a;

        C04906(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1092a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            int i;
            if (this.f1092a.f1109M) {
                i = (int) this.f1092a.f1105I;
            } else {
                i = (int) (this.f1092a.f1105I - ((float) Math.abs(this.f1092a.f1114b)));
            }
            this.f1092a.m2211a((((int) (((float) (i - this.f1092a.f1113a)) * f)) + this.f1092a.f1113a) - this.f1092a.f1136z.getTop(), false);
            this.f1092a.f1099C.m2470a(1.0f - f);
        }
    }

    class C04917 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1093a;

        C04917(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1093a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1093a.m2227c(f);
        }
    }

    class C04928 extends Animation {
        final /* synthetic */ SwipeRefreshLayout f1094a;

        C04928(SwipeRefreshLayout swipeRefreshLayout) {
            this.f1094a = swipeRefreshLayout;
        }

        public void applyTransformation(float f, Transformation transformation) {
            this.f1094a.setAnimationProgress(this.f1094a.f1098B + ((-this.f1094a.f1098B) * f));
            this.f1094a.m2227c(f);
        }
    }

    public interface C0493a {
        void mo2803a();
    }

    private void m2221b() {
        this.f1136z.clearAnimation();
        this.f1099C.stop();
        this.f1136z.setVisibility(8);
        setColorViewAlpha(255);
        if (this.f1133v) {
            setAnimationProgress(0.0f);
        } else {
            m2211a(this.f1114b - this.f1127p, true);
        }
        this.f1127p = this.f1136z.getTop();
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        m2221b();
    }

    private void setColorViewAlpha(int i) {
        this.f1136z.getBackground().setAlpha(i);
        this.f1099C.setAlpha(i);
    }

    public void setSize(int i) {
        if (i == 0 || i == 1) {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i2;
            if (i == 0) {
                i2 = (int) (displayMetrics.density * 56.0f);
                this.f1107K = i2;
                this.f1108L = i2;
            } else {
                i2 = (int) (displayMetrics.density * 40.0f);
                this.f1107K = i2;
                this.f1108L = i2;
            }
            this.f1136z.setImageDrawable(null);
            this.f1099C.m2472a(i);
            this.f1136z.setImageDrawable(this.f1099C);
        }
    }

    public SwipeRefreshLayout(Context context) {
        this(context, null);
    }

    public SwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1117f = false;
        this.f1119h = GroundOverlayOptions.NO_DIMENSION;
        this.f1123l = new int[2];
        this.f1124m = new int[2];
        this.f1128q = false;
        this.f1132u = -1;
        this.f1097A = -1;
        this.f1110N = new C04851(this);
        this.f1111O = new C04906(this);
        this.f1112P = new C04917(this);
        this.f1118g = ViewConfiguration.get(context).getScaledTouchSlop();
        this.f1126o = getResources().getInteger(17694721);
        setWillNotDraw(false);
        this.f1135x = new DecelerateInterpolator(2.0f);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f1096y);
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        obtainStyledAttributes.recycle();
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        this.f1107K = (int) (displayMetrics.density * 40.0f);
        this.f1108L = (int) (displayMetrics.density * 40.0f);
        m2226c();
        ag.m1790a((ViewGroup) this, true);
        this.f1105I = displayMetrics.density * 64.0f;
        this.f1119h = this.f1105I;
        this.f1121j = new C0481z(this);
        this.f1122k = new C0479x(this);
        setNestedScrollingEnabled(true);
    }

    protected int getChildDrawingOrder(int i, int i2) {
        if (this.f1097A < 0) {
            return i2;
        }
        if (i2 == i - 1) {
            return this.f1097A;
        }
        if (i2 >= this.f1097A) {
            return i2 + 1;
        }
        return i2;
    }

    private void m2226c() {
        this.f1136z = new C0502b(getContext(), -328966, 20.0f);
        this.f1099C = new C0532p(getContext(), this);
        this.f1099C.m2476b(-328966);
        this.f1136z.setImageDrawable(this.f1099C);
        this.f1136z.setVisibility(8);
        addView(this.f1136z);
    }

    public void setOnRefreshListener(C0493a c0493a) {
        this.f1116e = c0493a;
    }

    private boolean m2231d() {
        return VERSION.SDK_INT < 11;
    }

    public void setRefreshing(boolean z) {
        if (!z || this.f1117f == z) {
            m2217a(z, false);
            return;
        }
        int i;
        this.f1117f = z;
        if (this.f1109M) {
            i = (int) this.f1105I;
        } else {
            i = (int) (this.f1105I + ((float) this.f1114b));
        }
        m2211a(i - this.f1127p, true);
        this.f1106J = false;
        m2216a(this.f1110N);
    }

    private void m2216a(AnimationListener animationListener) {
        this.f1136z.setVisibility(0);
        if (VERSION.SDK_INT >= 11) {
            this.f1099C.setAlpha(255);
        }
        this.f1100D = new C04862(this);
        this.f1100D.setDuration((long) this.f1126o);
        if (animationListener != null) {
            this.f1136z.m2342a(animationListener);
        }
        this.f1136z.clearAnimation();
        this.f1136z.startAnimation(this.f1100D);
    }

    private void setAnimationProgress(float f) {
        if (m2231d()) {
            setColorViewAlpha((int) (255.0f * f));
            return;
        }
        ag.m1798c(this.f1136z, f);
        ag.m1801d(this.f1136z, f);
    }

    private void m2217a(boolean z, boolean z2) {
        if (this.f1117f != z) {
            this.f1106J = z2;
            m2236g();
            this.f1117f = z;
            if (this.f1117f) {
                m2210a(this.f1127p, this.f1110N);
            } else {
                m2225b(this.f1110N);
            }
        }
    }

    private void m2225b(AnimationListener animationListener) {
        this.f1101E = new C04873(this);
        this.f1101E.setDuration(150);
        this.f1136z.m2342a(animationListener);
        this.f1136z.clearAnimation();
        this.f1136z.startAnimation(this.f1101E);
    }

    private void m2233e() {
        this.f1102F = m2208a(this.f1099C.getAlpha(), 76);
    }

    private void m2234f() {
        this.f1103G = m2208a(this.f1099C.getAlpha(), 255);
    }

    private Animation m2208a(final int i, final int i2) {
        if (this.f1133v && m2231d()) {
            return null;
        }
        Animation c04884 = new Animation(this) {
            final /* synthetic */ SwipeRefreshLayout f1090c;

            public void applyTransformation(float f, Transformation transformation) {
                this.f1090c.f1099C.setAlpha((int) (((float) i) + (((float) (i2 - i)) * f)));
            }
        };
        c04884.setDuration(300);
        this.f1136z.m2342a(null);
        this.f1136z.clearAnimation();
        this.f1136z.startAnimation(c04884);
        return c04884;
    }

    @Deprecated
    public void setProgressBackgroundColor(int i) {
        setProgressBackgroundColorSchemeResource(i);
    }

    public void setProgressBackgroundColorSchemeResource(int i) {
        setProgressBackgroundColorSchemeColor(getResources().getColor(i));
    }

    public void setProgressBackgroundColorSchemeColor(int i) {
        this.f1136z.setBackgroundColor(i);
        this.f1099C.m2476b(i);
    }

    @Deprecated
    public void setColorScheme(int... iArr) {
        setColorSchemeResources(iArr);
    }

    public void setColorSchemeResources(int... iArr) {
        Resources resources = getResources();
        int[] iArr2 = new int[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            iArr2[i] = resources.getColor(iArr[i]);
        }
        setColorSchemeColors(iArr2);
    }

    public void setColorSchemeColors(int... iArr) {
        m2236g();
        this.f1099C.m2474a(iArr);
    }

    private void m2236g() {
        if (this.f1115d == null) {
            int i = 0;
            while (i < getChildCount()) {
                View childAt = getChildAt(i);
                if (childAt.equals(this.f1136z)) {
                    i++;
                } else {
                    this.f1115d = childAt;
                    return;
                }
            }
        }
    }

    public void setDistanceToTriggerSync(int i) {
        this.f1119h = (float) i;
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (getChildCount() != 0) {
            if (this.f1115d == null) {
                m2236g();
            }
            if (this.f1115d != null) {
                View view = this.f1115d;
                int paddingLeft = getPaddingLeft();
                int paddingTop = getPaddingTop();
                view.layout(paddingLeft, paddingTop, ((measuredWidth - getPaddingLeft()) - getPaddingRight()) + paddingLeft, ((measuredHeight - getPaddingTop()) - getPaddingBottom()) + paddingTop);
                measuredHeight = this.f1136z.getMeasuredWidth();
                this.f1136z.layout((measuredWidth / 2) - (measuredHeight / 2), this.f1127p, (measuredWidth / 2) + (measuredHeight / 2), this.f1127p + this.f1136z.getMeasuredHeight());
            }
        }
    }

    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.f1115d == null) {
            m2236g();
        }
        if (this.f1115d != null) {
            int i3;
            this.f1115d.measure(MeasureSpec.makeMeasureSpec((getMeasuredWidth() - getPaddingLeft()) - getPaddingRight(), 1073741824), MeasureSpec.makeMeasureSpec((getMeasuredHeight() - getPaddingTop()) - getPaddingBottom(), 1073741824));
            this.f1136z.measure(MeasureSpec.makeMeasureSpec(this.f1107K, 1073741824), MeasureSpec.makeMeasureSpec(this.f1108L, 1073741824));
            if (!(this.f1109M || this.f1128q)) {
                this.f1128q = true;
                i3 = -this.f1136z.getMeasuredHeight();
                this.f1114b = i3;
                this.f1127p = i3;
            }
            this.f1097A = -1;
            for (i3 = 0; i3 < getChildCount(); i3++) {
                if (getChildAt(i3) == this.f1136z) {
                    this.f1097A = i3;
                    return;
                }
            }
        }
    }

    public int getProgressCircleDiameter() {
        return this.f1136z != null ? this.f1136z.getMeasuredHeight() : 0;
    }

    public boolean m2241a() {
        boolean z = false;
        if (VERSION.SDK_INT >= 14) {
            return ag.m1796b(this.f1115d, -1);
        }
        if (this.f1115d instanceof AbsListView) {
            AbsListView absListView = (AbsListView) this.f1115d;
            return absListView.getChildCount() > 0 && (absListView.getFirstVisiblePosition() > 0 || absListView.getChildAt(0).getTop() < absListView.getPaddingTop());
        } else {
            if (ag.m1796b(this.f1115d, -1) || this.f1115d.getScrollY() > 0) {
                z = true;
            }
            return z;
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        m2236g();
        int a = C0474s.m2141a(motionEvent);
        if (this.f1134w && a == 0) {
            this.f1134w = false;
        }
        if (!isEnabled() || this.f1134w || m2241a() || this.f1117f || this.f1125n) {
            return false;
        }
        float a2;
        switch (a) {
            case 0:
                m2211a(this.f1114b - this.f1136z.getTop(), true);
                this.f1132u = C0474s.m2144b(motionEvent, 0);
                this.f1131t = false;
                a2 = m2206a(motionEvent, this.f1132u);
                if (a2 != GroundOverlayOptions.NO_DIMENSION) {
                    this.f1130s = a2;
                    break;
                }
                return false;
            case 1:
            case 3:
                this.f1131t = false;
                this.f1132u = -1;
                break;
            case 2:
                if (this.f1132u == -1) {
                    Log.e(f1095c, "Got ACTION_MOVE event but don't have an active pointer id.");
                    return false;
                }
                a2 = m2206a(motionEvent, this.f1132u);
                if (a2 != GroundOverlayOptions.NO_DIMENSION) {
                    if (a2 - this.f1130s > ((float) this.f1118g) && !this.f1131t) {
                        this.f1129r = this.f1130s + ((float) this.f1118g);
                        this.f1131t = true;
                        this.f1099C.setAlpha(76);
                        break;
                    }
                }
                return false;
            case 6:
                m2215a(motionEvent);
                break;
        }
        return this.f1131t;
    }

    private float m2206a(MotionEvent motionEvent, int i) {
        int a = C0474s.m2142a(motionEvent, i);
        if (a < 0) {
            return GroundOverlayOptions.NO_DIMENSION;
        }
        return C0474s.m2147d(motionEvent, a);
    }

    public void requestDisallowInterceptTouchEvent(boolean z) {
        if (VERSION.SDK_INT < 21 && (this.f1115d instanceof AbsListView)) {
            return;
        }
        if (this.f1115d == null || ag.m1819s(this.f1115d)) {
            super.requestDisallowInterceptTouchEvent(z);
        }
    }

    public boolean onStartNestedScroll(View view, View view2, int i) {
        return (!isEnabled() || this.f1134w || this.f1117f || (i & 2) == 0) ? false : true;
    }

    public void onNestedScrollAccepted(View view, View view2, int i) {
        this.f1121j.m2168a(view, view2, i);
        startNestedScroll(i & 2);
        this.f1120i = 0.0f;
        this.f1125n = true;
    }

    public void onNestedPreScroll(View view, int i, int i2, int[] iArr) {
        if (i2 > 0 && this.f1120i > 0.0f) {
            if (((float) i2) > this.f1120i) {
                iArr[1] = i2 - ((int) this.f1120i);
                this.f1120i = 0.0f;
            } else {
                this.f1120i -= (float) i2;
                iArr[1] = i2;
            }
            m2209a(this.f1120i);
        }
        if (this.f1109M && i2 > 0 && this.f1120i == 0.0f && Math.abs(i2 - iArr[1]) > 0) {
            this.f1136z.setVisibility(8);
        }
        int[] iArr2 = this.f1123l;
        if (dispatchNestedPreScroll(i - iArr[0], i2 - iArr[1], iArr2, null)) {
            iArr[0] = iArr[0] + iArr2[0];
            iArr[1] = iArr2[1] + iArr[1];
        }
    }

    public int getNestedScrollAxes() {
        return this.f1121j.m2166a();
    }

    public void onStopNestedScroll(View view) {
        this.f1121j.m2167a(view);
        this.f1125n = false;
        if (this.f1120i > 0.0f) {
            m2222b(this.f1120i);
            this.f1120i = 0.0f;
        }
        stopNestedScroll();
    }

    public void onNestedScroll(View view, int i, int i2, int i3, int i4) {
        dispatchNestedScroll(i, i2, i3, i4, this.f1124m);
        int i5 = this.f1124m[1] + i4;
        if (i5 < 0 && !m2241a()) {
            this.f1120i = ((float) Math.abs(i5)) + this.f1120i;
            m2209a(this.f1120i);
        }
    }

    public void setNestedScrollingEnabled(boolean z) {
        this.f1122k.m2157a(z);
    }

    public boolean isNestedScrollingEnabled() {
        return this.f1122k.m2158a();
    }

    public boolean startNestedScroll(int i) {
        return this.f1122k.m2161a(i);
    }

    public void stopNestedScroll() {
        this.f1122k.m2165c();
    }

    public boolean hasNestedScrollingParent() {
        return this.f1122k.m2164b();
    }

    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.f1122k.m2162a(i, i2, i3, i4, iArr);
    }

    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.f1122k.m2163a(i, i2, iArr, iArr2);
    }

    public boolean onNestedPreFling(View view, float f, float f2) {
        return dispatchNestedPreFling(f, f2);
    }

    public boolean onNestedFling(View view, float f, float f2, boolean z) {
        return dispatchNestedFling(f, f2, z);
    }

    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.f1122k.m2160a(f, f2, z);
    }

    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.f1122k.m2159a(f, f2);
    }

    private boolean m2219a(Animation animation) {
        return (animation == null || !animation.hasStarted() || animation.hasEnded()) ? false : true;
    }

    private void m2209a(float f) {
        this.f1099C.m2473a(true);
        float min = Math.min(1.0f, Math.abs(f / this.f1119h));
        float max = (((float) Math.max(((double) min) - 0.4d, 0.0d)) * 5.0f) / 3.0f;
        float abs = Math.abs(f) - this.f1119h;
        float f2 = this.f1109M ? this.f1105I - ((float) this.f1114b) : this.f1105I;
        abs = Math.max(0.0f, Math.min(abs, f2 * 2.0f) / f2);
        abs = ((float) (((double) (abs / 4.0f)) - Math.pow((double) (abs / 4.0f), 2.0d))) * 2.0f;
        int i = ((int) ((f2 * min) + ((f2 * abs) * 2.0f))) + this.f1114b;
        if (this.f1136z.getVisibility() != 0) {
            this.f1136z.setVisibility(0);
        }
        if (!this.f1133v) {
            ag.m1798c(this.f1136z, 1.0f);
            ag.m1801d(this.f1136z, 1.0f);
        }
        if (this.f1133v) {
            setAnimationProgress(Math.min(1.0f, f / this.f1119h));
        }
        if (f < this.f1119h) {
            if (this.f1099C.getAlpha() > 76 && !m2219a(this.f1102F)) {
                m2233e();
            }
        } else if (this.f1099C.getAlpha() < 255 && !m2219a(this.f1103G)) {
            m2234f();
        }
        this.f1099C.m2471a(0.0f, Math.min(0.8f, max * 0.8f));
        this.f1099C.m2470a(Math.min(1.0f, max));
        this.f1099C.m2475b(((-0.25f + (max * 0.4f)) + (abs * 2.0f)) * 0.5f);
        m2211a(i - this.f1127p, true);
    }

    private void m2222b(float f) {
        if (f > this.f1119h) {
            m2217a(true, true);
            return;
        }
        this.f1117f = false;
        this.f1099C.m2471a(0.0f, 0.0f);
        AnimationListener animationListener = null;
        if (!this.f1133v) {
            animationListener = new C04895(this);
        }
        m2223b(this.f1127p, animationListener);
        this.f1099C.m2473a(false);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        int a = C0474s.m2141a(motionEvent);
        if (this.f1134w && a == 0) {
            this.f1134w = false;
        }
        if (!isEnabled() || this.f1134w || m2241a() || this.f1125n) {
            return false;
        }
        float d;
        switch (a) {
            case 0:
                this.f1132u = C0474s.m2144b(motionEvent, 0);
                this.f1131t = false;
                break;
            case 1:
                a = C0474s.m2142a(motionEvent, this.f1132u);
                if (a < 0) {
                    Log.e(f1095c, "Got ACTION_UP event but don't have an active pointer id.");
                    return false;
                }
                d = (C0474s.m2147d(motionEvent, a) - this.f1129r) * 0.5f;
                this.f1131t = false;
                m2222b(d);
                this.f1132u = -1;
                return false;
            case 2:
                a = C0474s.m2142a(motionEvent, this.f1132u);
                if (a < 0) {
                    Log.e(f1095c, "Got ACTION_MOVE event but have an invalid active pointer id.");
                    return false;
                }
                d = (C0474s.m2147d(motionEvent, a) - this.f1129r) * 0.5f;
                if (this.f1131t) {
                    if (d > 0.0f) {
                        m2209a(d);
                        break;
                    }
                    return false;
                }
                break;
            case 3:
                return false;
            case 5:
                a = C0474s.m2143b(motionEvent);
                if (a >= 0) {
                    this.f1132u = C0474s.m2144b(motionEvent, a);
                    break;
                }
                Log.e(f1095c, "Got ACTION_POINTER_DOWN event but have an invalid action index.");
                return false;
            case 6:
                m2215a(motionEvent);
                break;
        }
        return true;
    }

    private void m2210a(int i, AnimationListener animationListener) {
        this.f1113a = i;
        this.f1111O.reset();
        this.f1111O.setDuration(200);
        this.f1111O.setInterpolator(this.f1135x);
        if (animationListener != null) {
            this.f1136z.m2342a(animationListener);
        }
        this.f1136z.clearAnimation();
        this.f1136z.startAnimation(this.f1111O);
    }

    private void m2223b(int i, AnimationListener animationListener) {
        if (this.f1133v) {
            m2228c(i, animationListener);
            return;
        }
        this.f1113a = i;
        this.f1112P.reset();
        this.f1112P.setDuration(200);
        this.f1112P.setInterpolator(this.f1135x);
        if (animationListener != null) {
            this.f1136z.m2342a(animationListener);
        }
        this.f1136z.clearAnimation();
        this.f1136z.startAnimation(this.f1112P);
    }

    private void m2227c(float f) {
        m2211a((this.f1113a + ((int) (((float) (this.f1114b - this.f1113a)) * f))) - this.f1136z.getTop(), false);
    }

    private void m2228c(int i, AnimationListener animationListener) {
        this.f1113a = i;
        if (m2231d()) {
            this.f1098B = (float) this.f1099C.getAlpha();
        } else {
            this.f1098B = ag.m1811k(this.f1136z);
        }
        this.f1104H = new C04928(this);
        this.f1104H.setDuration(150);
        if (animationListener != null) {
            this.f1136z.m2342a(animationListener);
        }
        this.f1136z.clearAnimation();
        this.f1136z.startAnimation(this.f1104H);
    }

    private void m2211a(int i, boolean z) {
        this.f1136z.bringToFront();
        this.f1136z.offsetTopAndBottom(i);
        this.f1127p = this.f1136z.getTop();
        if (z && VERSION.SDK_INT < 11) {
            invalidate();
        }
    }

    private void m2215a(MotionEvent motionEvent) {
        int b = C0474s.m2143b(motionEvent);
        if (C0474s.m2144b(motionEvent, b) == this.f1132u) {
            this.f1132u = C0474s.m2144b(motionEvent, b == 0 ? 1 : 0);
        }
    }
}
