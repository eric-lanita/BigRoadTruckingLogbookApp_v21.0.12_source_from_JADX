package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v4.p006c.C0245d;
import android.support.v4.view.C0474s;
import android.support.v4.view.ag;
import android.support.v4.view.ax;
import android.support.v4.widget.C0524l;
import android.support.v4.widget.C0539q;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0563k;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import com.facebook.login.widget.ProfilePictureView;
import java.lang.reflect.Method;

public class ak {
    private static Method f2055a;
    private static Method f2056c;
    private final C0722c f2057A;
    private Runnable f2058B;
    private final Handler f2059C;
    private Rect f2060D;
    private boolean f2061E;
    private int f2062F;
    int f2063b;
    private Context f2064d;
    private PopupWindow f2065e;
    private ListAdapter f2066f;
    private C0719a f2067g;
    private int f2068h;
    private int f2069i;
    private int f2070j;
    private int f2071k;
    private int f2072l;
    private boolean f2073m;
    private int f2074n;
    private boolean f2075o;
    private boolean f2076p;
    private View f2077q;
    private int f2078r;
    private DataSetObserver f2079s;
    private View f2080t;
    private Drawable f2081u;
    private OnItemClickListener f2082v;
    private OnItemSelectedListener f2083w;
    private final C0726g f2084x;
    private final C0725f f2085y;
    private final C0724e f2086z;

    public static abstract class C0651b implements OnTouchListener {
        private final float f1611a;
        private final int f1612b;
        private final int f1613c;
        private final View f1614d;
        private Runnable f1615e;
        private Runnable f1616f;
        private boolean f1617g;
        private boolean f1618h;
        private int f1619i;
        private final int[] f1620j = new int[2];

        private class C0720a implements Runnable {
            final /* synthetic */ C0651b f2048a;

            private C0720a(C0651b c0651b) {
                this.f2048a = c0651b;
            }

            public void run() {
                this.f2048a.f1614d.getParent().requestDisallowInterceptTouchEvent(true);
            }
        }

        private class C0721b implements Runnable {
            final /* synthetic */ C0651b f2049a;

            private C0721b(C0651b c0651b) {
                this.f2049a = c0651b;
            }

            public void run() {
                this.f2049a.m3058e();
            }
        }

        public abstract ak mo517a();

        public C0651b(View view) {
            this.f1614d = view;
            this.f1611a = (float) ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            this.f1612b = ViewConfiguration.getTapTimeout();
            this.f1613c = (this.f1612b + ViewConfiguration.getLongPressTimeout()) / 2;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            boolean b;
            boolean z = this.f1617g;
            if (z) {
                b = this.f1618h ? m3055b(motionEvent) : m3055b(motionEvent) || !mo666c();
            } else {
                boolean z2 = m3051a(motionEvent) && mo518b();
                if (z2) {
                    long uptimeMillis = SystemClock.uptimeMillis();
                    MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                    this.f1614d.onTouchEvent(obtain);
                    obtain.recycle();
                }
                b = z2;
            }
            this.f1617g = b;
            if (b || z) {
                return true;
            }
            return false;
        }

        protected boolean mo518b() {
            ak a = mo517a();
            if (!(a == null || a.m3641k())) {
                a.mo680c();
            }
            return true;
        }

        protected boolean mo666c() {
            ak a = mo517a();
            if (a != null && a.m3641k()) {
                a.m3639i();
            }
            return true;
        }

        private boolean m3051a(MotionEvent motionEvent) {
            View view = this.f1614d;
            if (!view.isEnabled()) {
                return false;
            }
            switch (C0474s.m2141a(motionEvent)) {
                case 0:
                    this.f1619i = motionEvent.getPointerId(0);
                    this.f1618h = false;
                    if (this.f1615e == null) {
                        this.f1615e = new C0720a();
                    }
                    view.postDelayed(this.f1615e, (long) this.f1612b);
                    if (this.f1616f == null) {
                        this.f1616f = new C0721b();
                    }
                    view.postDelayed(this.f1616f, (long) this.f1613c);
                    return false;
                case 1:
                case 3:
                    m3057d();
                    return false;
                case 2:
                    int findPointerIndex = motionEvent.findPointerIndex(this.f1619i);
                    if (findPointerIndex < 0 || C0651b.m3052a(view, motionEvent.getX(findPointerIndex), motionEvent.getY(findPointerIndex), this.f1611a)) {
                        return false;
                    }
                    m3057d();
                    view.getParent().requestDisallowInterceptTouchEvent(true);
                    return true;
                default:
                    return false;
            }
        }

        private void m3057d() {
            if (this.f1616f != null) {
                this.f1614d.removeCallbacks(this.f1616f);
            }
            if (this.f1615e != null) {
                this.f1614d.removeCallbacks(this.f1615e);
            }
        }

        private void m3058e() {
            m3057d();
            View view = this.f1614d;
            if (view.isEnabled() && !view.isLongClickable() && mo518b()) {
                view.getParent().requestDisallowInterceptTouchEvent(true);
                long uptimeMillis = SystemClock.uptimeMillis();
                MotionEvent obtain = MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0);
                view.onTouchEvent(obtain);
                obtain.recycle();
                this.f1617g = true;
                this.f1618h = true;
            }
        }

        private boolean m3055b(MotionEvent motionEvent) {
            boolean z = true;
            View view = this.f1614d;
            ak a = mo517a();
            if (a == null || !a.m3641k()) {
                return false;
            }
            View a2 = a.f2067g;
            if (a2 == null || !a2.isShown()) {
                return false;
            }
            MotionEvent obtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
            m3056b(view, obtainNoHistory);
            m3053a(a2, obtainNoHistory);
            boolean a3 = a2.m3610a(obtainNoHistory, this.f1619i);
            obtainNoHistory.recycle();
            int a4 = C0474s.m2141a(motionEvent);
            boolean z2;
            if (a4 == 1 || a4 == 3) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!(a3 && r2)) {
                z = false;
            }
            return z;
        }

        private static boolean m3052a(View view, float f, float f2, float f3) {
            return f >= (-f3) && f2 >= (-f3) && f < ((float) (view.getRight() - view.getLeft())) + f3 && f2 < ((float) (view.getBottom() - view.getTop())) + f3;
        }

        private boolean m3053a(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1620j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) (-iArr[0]), (float) (-iArr[1]));
            return true;
        }

        private boolean m3056b(View view, MotionEvent motionEvent) {
            int[] iArr = this.f1620j;
            view.getLocationOnScreen(iArr);
            motionEvent.offsetLocation((float) iArr[0], (float) iArr[1]);
            return true;
        }
    }

    class C07161 extends C0651b {
        final /* synthetic */ ak f2031a;

        public ak mo517a() {
            return this.f2031a;
        }
    }

    class C07172 implements Runnable {
        final /* synthetic */ ak f2032a;

        C07172(ak akVar) {
            this.f2032a = akVar;
        }

        public void run() {
            View e = this.f2032a.m3631e();
            if (e != null && e.getWindowToken() != null) {
                this.f2032a.mo680c();
            }
        }
    }

    class C07183 implements OnItemSelectedListener {
        final /* synthetic */ ak f2033a;

        C07183(ak akVar) {
            this.f2033a = akVar;
        }

        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            if (i != -1) {
                C0719a a = this.f2033a.f2067g;
                if (a != null) {
                    a.f2043g = false;
                }
            }
        }

        public void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    private static class C0719a extends al {
        private boolean f2043g;
        private boolean f2044h;
        private boolean f2045i;
        private ax f2046j;
        private C0524l f2047k;

        public C0719a(Context context, boolean z) {
            super(context, null, C0553a.dropDownListViewStyle);
            this.f2044h = z;
            setCacheColorHint(0);
        }

        public boolean m3610a(MotionEvent motionEvent, int i) {
            boolean z;
            boolean z2;
            int a = C0474s.m2141a(motionEvent);
            switch (a) {
                case 1:
                    z = false;
                    break;
                case 2:
                    z = true;
                    break;
                case 3:
                    z = false;
                    z2 = false;
                    break;
                default:
                    z = false;
                    z2 = true;
                    break;
            }
            int findPointerIndex = motionEvent.findPointerIndex(i);
            if (findPointerIndex < 0) {
                z = false;
                z2 = false;
            } else {
                int x = (int) motionEvent.getX(findPointerIndex);
                findPointerIndex = (int) motionEvent.getY(findPointerIndex);
                int pointToPosition = pointToPosition(x, findPointerIndex);
                if (pointToPosition == -1) {
                    z2 = z;
                    z = true;
                } else {
                    View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                    m3606a(childAt, pointToPosition, (float) x, (float) findPointerIndex);
                    if (a == 1) {
                        m3605a(childAt, pointToPosition);
                    }
                    z = false;
                    z2 = true;
                }
            }
            if (!z2 || r0) {
                m3608d();
            }
            if (z2) {
                if (this.f2047k == null) {
                    this.f2047k = new C0524l(this);
                }
                this.f2047k.m2278a(true);
                this.f2047k.onTouch(this, motionEvent);
            } else if (this.f2047k != null) {
                this.f2047k.m2278a(false);
            }
            return z2;
        }

        private void m3605a(View view, int i) {
            performItemClick(view, i, getItemIdAtPosition(i));
        }

        private void m3608d() {
            this.f2045i = false;
            setPressed(false);
            drawableStateChanged();
            View childAt = getChildAt(this.f - getFirstVisiblePosition());
            if (childAt != null) {
                childAt.setPressed(false);
            }
            if (this.f2046j != null) {
                this.f2046j.m1988b();
                this.f2046j = null;
            }
        }

        private void m3606a(View view, int i, float f, float f2) {
            this.f2045i = true;
            if (VERSION.SDK_INT >= 21) {
                drawableHotspotChanged(f, f2);
            }
            if (!isPressed()) {
                setPressed(true);
            }
            layoutChildren();
            if (this.f != -1) {
                View childAt = getChildAt(this.f - getFirstVisiblePosition());
                if (!(childAt == null || childAt == view || !childAt.isPressed())) {
                    childAt.setPressed(false);
                }
            }
            this.f = i;
            float left = f - ((float) view.getLeft());
            float top = f2 - ((float) view.getTop());
            if (VERSION.SDK_INT >= 21) {
                view.drawableHotspotChanged(left, top);
            }
            if (!view.isPressed()) {
                view.setPressed(true);
            }
            m3599a(i, view, f, f2);
            setSelectorEnabled(false);
            refreshDrawableState();
        }

        protected boolean mo622a() {
            return this.f2045i || super.mo622a();
        }

        public boolean isInTouchMode() {
            return (this.f2044h && this.f2043g) || super.isInTouchMode();
        }

        public boolean hasWindowFocus() {
            return this.f2044h || super.hasWindowFocus();
        }

        public boolean isFocused() {
            return this.f2044h || super.isFocused();
        }

        public boolean hasFocus() {
            return this.f2044h || super.hasFocus();
        }
    }

    private class C0722c implements Runnable {
        final /* synthetic */ ak f2050a;

        private C0722c(ak akVar) {
            this.f2050a = akVar;
        }

        public void run() {
            this.f2050a.m3640j();
        }
    }

    private class C0723d extends DataSetObserver {
        final /* synthetic */ ak f2051a;

        private C0723d(ak akVar) {
            this.f2051a = akVar;
        }

        public void onChanged() {
            if (this.f2051a.m3641k()) {
                this.f2051a.mo680c();
            }
        }

        public void onInvalidated() {
            this.f2051a.m3639i();
        }
    }

    private class C0724e implements OnScrollListener {
        final /* synthetic */ ak f2052a;

        private C0724e(ak akVar) {
            this.f2052a = akVar;
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !this.f2052a.m3642l() && this.f2052a.f2065e.getContentView() != null) {
                this.f2052a.f2059C.removeCallbacks(this.f2052a.f2084x);
                this.f2052a.f2084x.run();
            }
        }
    }

    private class C0725f implements OnTouchListener {
        final /* synthetic */ ak f2053a;

        private C0725f(ak akVar) {
            this.f2053a = akVar;
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && this.f2053a.f2065e != null && this.f2053a.f2065e.isShowing() && x >= 0 && x < this.f2053a.f2065e.getWidth() && y >= 0 && y < this.f2053a.f2065e.getHeight()) {
                this.f2053a.f2059C.postDelayed(this.f2053a.f2084x, 250);
            } else if (action == 1) {
                this.f2053a.f2059C.removeCallbacks(this.f2053a.f2084x);
            }
            return false;
        }
    }

    private class C0726g implements Runnable {
        final /* synthetic */ ak f2054a;

        private C0726g(ak akVar) {
            this.f2054a = akVar;
        }

        public void run() {
            if (this.f2054a.f2067g != null && ag.m1822v(this.f2054a.f2067g) && this.f2054a.f2067g.getCount() > this.f2054a.f2067g.getChildCount() && this.f2054a.f2067g.getChildCount() <= this.f2054a.f2063b) {
                this.f2054a.f2065e.setInputMethodMode(2);
                this.f2054a.mo680c();
            }
        }
    }

    static {
        try {
            f2055a = PopupWindow.class.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
        } catch (NoSuchMethodException e) {
            Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
        }
        try {
            f2056c = PopupWindow.class.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
        } catch (NoSuchMethodException e2) {
            Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
        }
    }

    public ak(Context context) {
        this(context, null, C0553a.listPopupWindowStyle);
    }

    public ak(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public ak(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f2068h = -2;
        this.f2069i = -2;
        this.f2072l = 1002;
        this.f2074n = 0;
        this.f2075o = false;
        this.f2076p = false;
        this.f2063b = Integer.MAX_VALUE;
        this.f2078r = 0;
        this.f2084x = new C0726g();
        this.f2085y = new C0725f();
        this.f2086z = new C0724e();
        this.f2057A = new C0722c();
        this.f2060D = new Rect();
        this.f2064d = context;
        this.f2059C = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0563k.ListPopupWindow, i, i2);
        this.f2070j = obtainStyledAttributes.getDimensionPixelOffset(C0563k.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f2071k = obtainStyledAttributes.getDimensionPixelOffset(C0563k.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f2071k != 0) {
            this.f2073m = true;
        }
        obtainStyledAttributes.recycle();
        this.f2065e = new C0771q(context, attributeSet, i);
        this.f2065e.setInputMethodMode(1);
        this.f2062F = C0245d.m1066a(this.f2064d.getResources().getConfiguration().locale);
    }

    public void mo678a(ListAdapter listAdapter) {
        if (this.f2079s == null) {
            this.f2079s = new C0723d();
        } else if (this.f2066f != null) {
            this.f2066f.unregisterDataSetObserver(this.f2079s);
        }
        this.f2066f = listAdapter;
        if (this.f2066f != null) {
            listAdapter.registerDataSetObserver(this.f2079s);
        }
        if (this.f2067g != null) {
            this.f2067g.setAdapter(this.f2066f);
        }
    }

    public void m3619a(int i) {
        this.f2078r = i;
    }

    public void m3625a(boolean z) {
        this.f2061E = z;
        this.f2065e.setFocusable(z);
    }

    public Drawable m3629d() {
        return this.f2065e.getBackground();
    }

    public void m3620a(Drawable drawable) {
        this.f2065e.setBackgroundDrawable(drawable);
    }

    public View m3631e() {
        return this.f2080t;
    }

    public void m3621a(View view) {
        this.f2080t = view;
    }

    public int m3633f() {
        return this.f2070j;
    }

    public void m3626b(int i) {
        this.f2070j = i;
    }

    public int m3635g() {
        if (this.f2073m) {
            return this.f2071k;
        }
        return 0;
    }

    public void m3628c(int i) {
        this.f2071k = i;
        this.f2073m = true;
    }

    public void m3630d(int i) {
        this.f2074n = i;
    }

    public int m3637h() {
        return this.f2069i;
    }

    public void m3632e(int i) {
        this.f2069i = i;
    }

    public void m3634f(int i) {
        Drawable background = this.f2065e.getBackground();
        if (background != null) {
            background.getPadding(this.f2060D);
            this.f2069i = (this.f2060D.left + this.f2060D.right) + i;
            return;
        }
        m3632e(i);
    }

    public void m3622a(OnItemClickListener onItemClickListener) {
        this.f2082v = onItemClickListener;
    }

    public void mo680c() {
        boolean z = true;
        boolean z2 = false;
        int i = -1;
        int b = mo679b();
        boolean l = m3642l();
        C0539q.m2489a(this.f2065e, this.f2072l);
        int i2;
        if (this.f2065e.isShowing()) {
            int i3;
            int i4;
            if (this.f2069i == -1) {
                i3 = -1;
            } else if (this.f2069i == -2) {
                i3 = m3631e().getWidth();
            } else {
                i3 = this.f2069i;
            }
            if (this.f2068h == -1) {
                if (!l) {
                    b = -1;
                }
                PopupWindow popupWindow;
                if (l) {
                    popupWindow = this.f2065e;
                    if (this.f2069i == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f2065e.setHeight(0);
                    i4 = b;
                } else {
                    popupWindow = this.f2065e;
                    if (this.f2069i == -1) {
                        i2 = -1;
                    } else {
                        i2 = 0;
                    }
                    popupWindow.setWidth(i2);
                    this.f2065e.setHeight(-1);
                    i4 = b;
                }
            } else if (this.f2068h == -2) {
                i4 = b;
            } else {
                i4 = this.f2068h;
            }
            PopupWindow popupWindow2 = this.f2065e;
            if (!(this.f2076p || this.f2075o)) {
                z2 = true;
            }
            popupWindow2.setOutsideTouchable(z2);
            popupWindow2 = this.f2065e;
            View e = m3631e();
            b = this.f2070j;
            int i5 = this.f2071k;
            if (i3 < 0) {
                i3 = -1;
            }
            if (i4 >= 0) {
                i = i4;
            }
            popupWindow2.update(e, b, i5, i3, i);
            return;
        }
        if (this.f2069i == -1) {
            i2 = -1;
        } else if (this.f2069i == -2) {
            i2 = m3631e().getWidth();
        } else {
            i2 = this.f2069i;
        }
        if (this.f2068h == -1) {
            b = -1;
        } else if (this.f2068h != -2) {
            b = this.f2068h;
        }
        this.f2065e.setWidth(i2);
        this.f2065e.setHeight(b);
        m3616b(true);
        popupWindow2 = this.f2065e;
        if (this.f2076p || this.f2075o) {
            z = false;
        }
        popupWindow2.setOutsideTouchable(z);
        this.f2065e.setTouchInterceptor(this.f2085y);
        C0539q.m2490a(this.f2065e, m3631e(), this.f2070j, this.f2071k, this.f2074n);
        this.f2067g.setSelection(-1);
        if (!this.f2061E || this.f2067g.isInTouchMode()) {
            m3640j();
        }
        if (!this.f2061E) {
            this.f2059C.post(this.f2057A);
        }
    }

    public void m3639i() {
        this.f2065e.dismiss();
        mo677a();
        this.f2065e.setContentView(null);
        this.f2067g = null;
        this.f2059C.removeCallbacks(this.f2084x);
    }

    public void m3624a(OnDismissListener onDismissListener) {
        this.f2065e.setOnDismissListener(onDismissListener);
    }

    private void mo677a() {
        if (this.f2077q != null) {
            ViewParent parent = this.f2077q.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f2077q);
            }
        }
    }

    public void m3636g(int i) {
        this.f2065e.setInputMethodMode(i);
    }

    public void m3638h(int i) {
        C0719a c0719a = this.f2067g;
        if (m3641k() && c0719a != null) {
            c0719a.f2043g = false;
            c0719a.setSelection(i);
            if (VERSION.SDK_INT >= 11 && c0719a.getChoiceMode() != 0) {
                c0719a.setItemChecked(i, true);
            }
        }
    }

    public void m3640j() {
        C0719a c0719a = this.f2067g;
        if (c0719a != null) {
            c0719a.f2043g = true;
            c0719a.requestLayout();
        }
    }

    public boolean m3641k() {
        return this.f2065e.isShowing();
    }

    public boolean m3642l() {
        return this.f2065e.getInputMethodMode() == 2;
    }

    public ListView m3643m() {
        return this.f2067g;
    }

    private int mo679b() {
        int i;
        int i2;
        int i3;
        int i4;
        boolean z = true;
        LayoutParams layoutParams;
        View view;
        if (this.f2067g == null) {
            Context context = this.f2064d;
            this.f2058B = new C07172(this);
            this.f2067g = new C0719a(context, !this.f2061E);
            if (this.f2081u != null) {
                this.f2067g.setSelector(this.f2081u);
            }
            this.f2067g.setAdapter(this.f2066f);
            this.f2067g.setOnItemClickListener(this.f2082v);
            this.f2067g.setFocusable(true);
            this.f2067g.setFocusableInTouchMode(true);
            this.f2067g.setOnItemSelectedListener(new C07183(this));
            this.f2067g.setOnScrollListener(this.f2086z);
            if (this.f2083w != null) {
                this.f2067g.setOnItemSelectedListener(this.f2083w);
            }
            View view2 = this.f2067g;
            View view3 = this.f2077q;
            if (view3 != null) {
                View linearLayout = new LinearLayout(context);
                linearLayout.setOrientation(1);
                ViewGroup.LayoutParams layoutParams2 = new LayoutParams(-1, 0, 1.0f);
                switch (this.f2078r) {
                    case 0:
                        linearLayout.addView(view3);
                        linearLayout.addView(view2, layoutParams2);
                        break;
                    case 1:
                        linearLayout.addView(view2, layoutParams2);
                        linearLayout.addView(view3);
                        break;
                    default:
                        Log.e("ListPopupWindow", "Invalid hint position " + this.f2078r);
                        break;
                }
                if (this.f2069i >= 0) {
                    i = this.f2069i;
                    i2 = Integer.MIN_VALUE;
                } else {
                    i2 = 0;
                    i = 0;
                }
                view3.measure(MeasureSpec.makeMeasureSpec(i, i2), 0);
                layoutParams = (LayoutParams) view3.getLayoutParams();
                i2 = layoutParams.bottomMargin + (view3.getMeasuredHeight() + layoutParams.topMargin);
                view = linearLayout;
            } else {
                view = view2;
                i2 = 0;
            }
            this.f2065e.setContentView(view);
            i3 = i2;
        } else {
            ViewGroup viewGroup = (ViewGroup) this.f2065e.getContentView();
            view = this.f2077q;
            if (view != null) {
                layoutParams = (LayoutParams) view.getLayoutParams();
                i3 = layoutParams.bottomMargin + (view.getMeasuredHeight() + layoutParams.topMargin);
            } else {
                i3 = 0;
            }
        }
        Drawable background = this.f2065e.getBackground();
        if (background != null) {
            background.getPadding(this.f2060D);
            i2 = this.f2060D.top + this.f2060D.bottom;
            if (this.f2073m) {
                i4 = i2;
            } else {
                this.f2071k = -this.f2060D.top;
                i4 = i2;
            }
        } else {
            this.f2060D.setEmpty();
            i4 = 0;
        }
        if (this.f2065e.getInputMethodMode() != 2) {
            z = false;
        }
        i = m3611a(m3631e(), this.f2071k, z);
        if (this.f2075o || this.f2068h == -1) {
            return i + i4;
        }
        int makeMeasureSpec;
        switch (this.f2069i) {
            case ProfilePictureView.SMALL /*-2*/:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2064d.getResources().getDisplayMetrics().widthPixels - (this.f2060D.left + this.f2060D.right), Integer.MIN_VALUE);
                break;
            case -1:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2064d.getResources().getDisplayMetrics().widthPixels - (this.f2060D.left + this.f2060D.right), 1073741824);
                break;
            default:
                makeMeasureSpec = MeasureSpec.makeMeasureSpec(this.f2069i, 1073741824);
                break;
        }
        i2 = this.f2067g.m3597a(makeMeasureSpec, 0, -1, i - i3, -1);
        if (i2 > 0) {
            i3 += i4;
        }
        return i2 + i3;
    }

    private void m3616b(boolean z) {
        if (f2055a != null) {
            try {
                f2055a.invoke(this.f2065e, new Object[]{Boolean.valueOf(z)});
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
        }
    }

    private int m3611a(View view, int i, boolean z) {
        if (f2056c != null) {
            try {
                return ((Integer) f2056c.invoke(this.f2065e, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception e) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f2065e.getMaxAvailableHeight(view, i);
    }
}
