package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.media.AudioManager;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0230y;
import android.support.v4.view.C0210m;
import android.support.v4.view.C0450i;
import android.support.v4.view.aa;
import android.support.v4.view.ag;
import android.support.v4.view.as;
import android.support.v4.view.ax;
import android.support.v4.view.bc;
import android.support.v4.view.be;
import android.support.v4.widget.C0539q;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0555c;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.p011a.C0564a.C0562j;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.view.C0642d;
import android.support.v7.view.C0643e;
import android.support.v7.view.menu.C0658m;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0665e;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.C0765l;
import android.support.v7.widget.ContentFrameLayout;
import android.support.v7.widget.ContentFrameLayout.C0602a;
import android.support.v7.widget.ViewStubCompat;
import android.support.v7.widget.af;
import android.support.v7.widget.ai;
import android.support.v7.widget.ai.C0600a;
import android.support.v7.widget.ba;
import android.support.v7.widget.bb;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.LayoutInflater.Factory;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewParent;
import android.view.Window;
import android.view.Window.Callback;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

class C0592j extends C0590f implements C0210m, C0591a {
    private boolean f1399A;
    private C0613d[] f1400B;
    private C0613d f1401C;
    private boolean f1402D;
    private boolean f1403E;
    private int f1404F;
    private final Runnable f1405G = new C05981(this);
    private boolean f1406H;
    private Rect f1407I;
    private Rect f1408J;
    private C0616l f1409K;
    C0628b f1410m;
    ActionBarContextView f1411n;
    PopupWindow f1412o;
    Runnable f1413p;
    ax f1414q = null;
    private af f1415r;
    private C0608a f1416s;
    private C0614e f1417t;
    private boolean f1418u;
    private ViewGroup f1419v;
    private TextView f1420w;
    private View f1421x;
    private boolean f1422y;
    private boolean f1423z;

    class C05981 implements Runnable {
        final /* synthetic */ C0592j f1431a;

        C05981(C0592j c0592j) {
            this.f1431a = c0592j;
        }

        public void run() {
            if ((this.f1431a.f1404F & 1) != 0) {
                this.f1431a.m2770f(0);
            }
            if ((this.f1431a.f1404F & 4096) != 0) {
                this.f1431a.m2770f(108);
            }
            this.f1431a.f1403E = false;
            this.f1431a.f1404F = 0;
        }
    }

    class C05992 implements aa {
        final /* synthetic */ C0592j f1432a;

        C05992(C0592j c0592j) {
            this.f1432a = c0592j;
        }

        public be mo184a(View view, be beVar) {
            int b = beVar.mo332b();
            int c = this.f1432a.m2771g(b);
            if (b != c) {
                beVar = beVar.mo331a(beVar.mo330a(), c, beVar.mo333c(), beVar.mo334d());
            }
            return ag.m1779a(view, beVar);
        }
    }

    class C06013 implements C0600a {
        final /* synthetic */ C0592j f1433a;

        C06013(C0592j c0592j) {
            this.f1433a = c0592j;
        }

        public void mo468a(Rect rect) {
            rect.top = this.f1433a.m2771g(rect.top);
        }
    }

    class C06034 implements C0602a {
        final /* synthetic */ C0592j f1434a;

        C06034(C0592j c0592j) {
            this.f1434a = c0592j;
        }

        public void mo469a() {
        }

        public void mo470b() {
            this.f1434a.m2778x();
        }
    }

    class C06055 implements Runnable {
        final /* synthetic */ C0592j f1436a;

        class C06041 extends bc {
            final /* synthetic */ C06055 f1435a;

            C06041(C06055 c06055) {
                this.f1435a = c06055;
            }

            public void mo327b(View view) {
                ag.m1794b(this.f1435a.f1436a.f1411n, 1.0f);
                this.f1435a.f1436a.f1414q.m1983a(null);
                this.f1435a.f1436a.f1414q = null;
            }

            public void mo326a(View view) {
                this.f1435a.f1436a.f1411n.setVisibility(0);
            }
        }

        C06055(C0592j c0592j) {
            this.f1436a = c0592j;
        }

        public void run() {
            this.f1436a.f1412o.showAtLocation(this.f1436a.f1411n, 55, 0, 0);
            this.f1436a.m2776v();
            ag.m1794b(this.f1436a.f1411n, 0.0f);
            this.f1436a.f1414q = ag.m1810j(this.f1436a.f1411n).m1981a(1.0f);
            this.f1436a.f1414q.m1983a(new C06041(this));
        }
    }

    class C06066 extends bc {
        final /* synthetic */ C0592j f1437a;

        C06066(C0592j c0592j) {
            this.f1437a = c0592j;
        }

        public void mo327b(View view) {
            ag.m1794b(this.f1437a.f1411n, 1.0f);
            this.f1437a.f1414q.m1983a(null);
            this.f1437a.f1414q = null;
        }

        public void mo326a(View view) {
            this.f1437a.f1411n.setVisibility(0);
            this.f1437a.f1411n.sendAccessibilityEvent(32);
            if (this.f1437a.f1411n.getParent() != null) {
                ag.m1813m((View) this.f1437a.f1411n.getParent());
            }
        }
    }

    private final class C0608a implements C0607a {
        final /* synthetic */ C0592j f1438a;

        private C0608a(C0592j c0592j) {
            this.f1438a = c0592j;
        }

        public boolean a_(C0666f c0666f) {
            Callback p = this.f1438a.m2737p();
            if (p != null) {
                p.onMenuOpened(108, c0666f);
            }
            return true;
        }

        public void mo471a(C0666f c0666f, boolean z) {
            this.f1438a.m2759b(c0666f);
        }
    }

    class C0611b implements C0610a {
        final /* synthetic */ C0592j f1440a;
        private C0610a f1441b;

        class C06091 extends bc {
            final /* synthetic */ C0611b f1439a;

            C06091(C0611b c0611b) {
                this.f1439a = c0611b;
            }

            public void mo327b(View view) {
                this.f1439a.f1440a.f1411n.setVisibility(8);
                if (this.f1439a.f1440a.f1412o != null) {
                    this.f1439a.f1440a.f1412o.dismiss();
                } else if (this.f1439a.f1440a.f1411n.getParent() instanceof View) {
                    ag.m1813m((View) this.f1439a.f1440a.f1411n.getParent());
                }
                this.f1439a.f1440a.f1411n.removeAllViews();
                this.f1439a.f1440a.f1414q.m1983a(null);
                this.f1439a.f1440a.f1414q = null;
            }
        }

        public C0611b(C0592j c0592j, C0610a c0610a) {
            this.f1440a = c0592j;
            this.f1441b = c0610a;
        }

        public boolean mo474a(C0628b c0628b, Menu menu) {
            return this.f1441b.mo474a(c0628b, menu);
        }

        public boolean mo476b(C0628b c0628b, Menu menu) {
            return this.f1441b.mo476b(c0628b, menu);
        }

        public boolean mo475a(C0628b c0628b, MenuItem menuItem) {
            return this.f1441b.mo475a(c0628b, menuItem);
        }

        public void mo473a(C0628b c0628b) {
            this.f1441b.mo473a(c0628b);
            if (this.f1440a.f1412o != null) {
                this.f1440a.b.getDecorView().removeCallbacks(this.f1440a.f1413p);
            }
            if (this.f1440a.f1411n != null) {
                this.f1440a.m2776v();
                this.f1440a.f1414q = ag.m1810j(this.f1440a.f1411n).m1981a(0.0f);
                this.f1440a.f1414q.m1983a(new C06091(this));
            }
            if (this.f1440a.e != null) {
                this.f1440a.e.mo413b(this.f1440a.f1410m);
            }
            this.f1440a.f1410m = null;
        }
    }

    private class C0612c extends ContentFrameLayout {
        final /* synthetic */ C0592j f1450a;

        public C0612c(C0592j c0592j, Context context) {
            this.f1450a = c0592j;
            super(context);
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return this.f1450a.mo450a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !m2846a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            this.f1450a.mo465d(0);
            return true;
        }

        public void setBackgroundResource(int i) {
            setBackgroundDrawable(C0765l.m3902a().m3925a(getContext(), i));
        }

        private boolean m2846a(int i, int i2) {
            return i < -5 || i2 < -5 || i > getWidth() + 5 || i2 > getHeight() + 5;
        }
    }

    private static final class C0613d {
        int f1451a;
        int f1452b;
        int f1453c;
        int f1454d;
        int f1455e;
        int f1456f;
        ViewGroup f1457g;
        View f1458h;
        View f1459i;
        C0666f f1460j;
        C0665e f1461k;
        Context f1462l;
        boolean f1463m;
        boolean f1464n;
        boolean f1465o;
        public boolean f1466p;
        boolean f1467q = false;
        boolean f1468r;
        Bundle f1469s;

        C0613d(int i) {
            this.f1451a = i;
        }

        public boolean m2850a() {
            if (this.f1458h == null) {
                return false;
            }
            if (this.f1459i != null || this.f1461k.m3127a().getCount() > 0) {
                return true;
            }
            return false;
        }

        void m2848a(Context context) {
            TypedValue typedValue = new TypedValue();
            Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(C0553a.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(C0553a.panelMenuListTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            } else {
                newTheme.applyStyle(C0562j.Theme_AppCompat_CompactMenu, true);
            }
            Context c0642d = new C0642d(context, 0);
            c0642d.getTheme().setTo(newTheme);
            this.f1462l = c0642d;
            TypedArray obtainStyledAttributes = c0642d.obtainStyledAttributes(C0563k.AppCompatTheme);
            this.f1452b = obtainStyledAttributes.getResourceId(C0563k.AppCompatTheme_panelBackground, 0);
            this.f1456f = obtainStyledAttributes.getResourceId(C0563k.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        void m2849a(C0666f c0666f) {
            if (c0666f != this.f1460j) {
                if (this.f1460j != null) {
                    this.f1460j.m3166b(this.f1461k);
                }
                this.f1460j = c0666f;
                if (c0666f != null && this.f1461k != null) {
                    c0666f.m3155a(this.f1461k);
                }
            }
        }

        C0658m m2847a(C0607a c0607a) {
            if (this.f1460j == null) {
                return null;
            }
            if (this.f1461k == null) {
                this.f1461k = new C0665e(this.f1462l, C0560h.abc_list_menu_item_layout);
                this.f1461k.m3130a(c0607a);
                this.f1460j.m3155a(this.f1461k);
            }
            return this.f1461k.m3126a(this.f1457g);
        }
    }

    private final class C0614e implements C0607a {
        final /* synthetic */ C0592j f1470a;

        private C0614e(C0592j c0592j) {
            this.f1470a = c0592j;
        }

        public void mo471a(C0666f c0666f, boolean z) {
            Menu menu;
            Menu p = c0666f.mo569p();
            boolean z2 = p != c0666f;
            C0592j c0592j = this.f1470a;
            if (z2) {
                menu = p;
            }
            C0613d a = c0592j.m2744a(menu);
            if (a == null) {
                return;
            }
            if (z2) {
                this.f1470a.m2745a(a.f1451a, a, p);
                this.f1470a.m2747a(a, true);
                return;
            }
            this.f1470a.m2747a(a, z);
        }

        public boolean a_(C0666f c0666f) {
            if (c0666f == null && this.f1470a.h) {
                Callback p = this.f1470a.m2737p();
                if (!(p == null || this.f1470a.m2736o())) {
                    p.onMenuOpened(108, c0666f);
                }
            }
            return true;
        }
    }

    C0592j(Context context, Window window, C0565d c0565d) {
        super(context, window, c0565d);
    }

    public void mo444a(Bundle bundle) {
        if ((this.c instanceof Activity) && C0230y.m1044b((Activity) this.c) != null) {
            C0569a l = m2733l();
            if (l == null) {
                this.f1406H = true;
            } else {
                l.mo486d(true);
            }
        }
    }

    public void mo452b(Bundle bundle) {
        m2773s();
    }

    public void mo461k() {
        m2773s();
        if (this.h && this.f == null) {
            if (this.c instanceof Activity) {
                this.f = new C0631p((Activity) this.c, this.i);
            } else if (this.c instanceof Dialog) {
                this.f = new C0631p((Dialog) this.c);
            }
            if (this.f != null) {
                this.f.mo486d(this.f1406H);
            }
        }
    }

    public View mo441a(int i) {
        m2773s();
        return this.b.findViewById(i);
    }

    public void mo443a(Configuration configuration) {
        if (this.h && this.f1418u) {
            C0569a a = mo434a();
            if (a != null) {
                a.mo479a(configuration);
            }
        }
        mo439h();
    }

    public void mo456c() {
        C0569a a = mo434a();
        if (a != null) {
            a.mo487e(false);
        }
    }

    public void mo458d() {
        C0569a a = mo434a();
        if (a != null) {
            a.mo487e(true);
        }
    }

    public void mo446a(View view) {
        m2773s();
        ViewGroup viewGroup = (ViewGroup) this.f1419v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.c.onContentChanged();
    }

    public void mo451b(int i) {
        m2773s();
        ViewGroup viewGroup = (ViewGroup) this.f1419v.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.a).inflate(i, viewGroup);
        this.c.onContentChanged();
    }

    public void mo447a(View view, LayoutParams layoutParams) {
        m2773s();
        ViewGroup viewGroup = (ViewGroup) this.f1419v.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void mo453b(View view, LayoutParams layoutParams) {
        m2773s();
        ((ViewGroup) this.f1419v.findViewById(16908290)).addView(view, layoutParams);
        this.c.onContentChanged();
    }

    public void mo438f() {
        super.mo438f();
        if (this.f != null) {
            this.f.mo492h();
        }
    }

    private void m2773s() {
        if (!this.f1418u) {
            this.f1419v = m2774t();
            CharSequence q = m2738q();
            if (!TextUtils.isEmpty(q)) {
                mo454b(q);
            }
            m2775u();
            m2788a(this.f1419v);
            this.f1418u = true;
            C0613d a = m2742a(0, false);
            if (!m2736o()) {
                if (a == null || a.f1460j == null) {
                    m2768e(108);
                }
            }
        }
    }

    private ViewGroup m2774t() {
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0563k.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(C0563k.AppCompatTheme_windowActionBar)) {
            View view;
            if (obtainStyledAttributes.getBoolean(C0563k.AppCompatTheme_windowNoTitle, false)) {
                mo457c(1);
            } else if (obtainStyledAttributes.getBoolean(C0563k.AppCompatTheme_windowActionBar, false)) {
                mo457c(108);
            }
            if (obtainStyledAttributes.getBoolean(C0563k.AppCompatTheme_windowActionBarOverlay, false)) {
                mo457c(109);
            }
            if (obtainStyledAttributes.getBoolean(C0563k.AppCompatTheme_windowActionModeOverlay, false)) {
                mo457c(10);
            }
            this.k = obtainStyledAttributes.getBoolean(C0563k.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            this.b.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.a);
            if (this.l) {
                View view2;
                if (this.j) {
                    view2 = (ViewGroup) from.inflate(C0560h.abc_screen_simple_overlay_action_mode, null);
                } else {
                    view2 = (ViewGroup) from.inflate(C0560h.abc_screen_simple, null);
                }
                if (VERSION.SDK_INT >= 21) {
                    ag.m1786a(view2, new C05992(this));
                    view = view2;
                } else {
                    ((ai) view2).setOnFitSystemWindowsListener(new C06013(this));
                    view = view2;
                }
            } else if (this.k) {
                r0 = (ViewGroup) from.inflate(C0560h.abc_dialog_title_material, null);
                this.i = false;
                this.h = false;
                view = r0;
            } else if (this.h) {
                Context c0642d;
                TypedValue typedValue = new TypedValue();
                this.a.getTheme().resolveAttribute(C0553a.actionBarTheme, typedValue, true);
                if (typedValue.resourceId != 0) {
                    c0642d = new C0642d(this.a, typedValue.resourceId);
                } else {
                    c0642d = this.a;
                }
                r0 = (ViewGroup) LayoutInflater.from(c0642d).inflate(C0560h.abc_screen_toolbar, null);
                this.f1415r = (af) r0.findViewById(C0558f.decor_content_parent);
                this.f1415r.setWindowCallback(m2737p());
                if (this.i) {
                    this.f1415r.mo579a(109);
                }
                if (this.f1422y) {
                    this.f1415r.mo579a(2);
                }
                if (this.f1423z) {
                    this.f1415r.mo579a(5);
                }
                view = r0;
            } else {
                view = null;
            }
            if (view == null) {
                throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.h + ", windowActionBarOverlay: " + this.i + ", android:windowIsFloating: " + this.k + ", windowActionModeOverlay: " + this.j + ", windowNoTitle: " + this.l + " }");
            }
            if (this.f1415r == null) {
                this.f1420w = (TextView) view.findViewById(C0558f.title);
            }
            bb.m3806b(view);
            ContentFrameLayout contentFrameLayout = (ContentFrameLayout) view.findViewById(C0558f.action_bar_activity_content);
            ViewGroup viewGroup = (ViewGroup) this.b.findViewById(16908290);
            if (viewGroup != null) {
                while (viewGroup.getChildCount() > 0) {
                    View childAt = viewGroup.getChildAt(0);
                    viewGroup.removeViewAt(0);
                    contentFrameLayout.addView(childAt);
                }
                viewGroup.setId(-1);
                contentFrameLayout.setId(16908290);
                if (viewGroup instanceof FrameLayout) {
                    ((FrameLayout) viewGroup).setForeground(null);
                }
            }
            this.b.setContentView(view);
            contentFrameLayout.setAttachListener(new C06034(this));
            return view;
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    void m2788a(ViewGroup viewGroup) {
    }

    private void m2775u() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f1419v.findViewById(16908290);
        View decorView = this.b.getDecorView();
        contentFrameLayout.m2844a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.a.obtainStyledAttributes(C0563k.AppCompatTheme);
        obtainStyledAttributes.getValue(C0563k.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(C0563k.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(C0563k.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(C0563k.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(C0563k.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(C0563k.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(C0563k.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(C0563k.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(C0563k.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(C0563k.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    public boolean mo457c(int i) {
        int h = m2772h(i);
        if (this.l && h == 108) {
            return false;
        }
        if (this.h && h == 1) {
            this.h = false;
        }
        switch (h) {
            case 1:
                m2777w();
                this.l = true;
                return true;
            case 2:
                m2777w();
                this.f1422y = true;
                return true;
            case 5:
                m2777w();
                this.f1423z = true;
                return true;
            case 10:
                m2777w();
                this.j = true;
                return true;
            case 108:
                m2777w();
                this.h = true;
                return true;
            case 109:
                m2777w();
                this.i = true;
                return true;
            default:
                return this.b.requestFeature(h);
        }
    }

    void mo454b(CharSequence charSequence) {
        if (this.f1415r != null) {
            this.f1415r.setWindowTitle(charSequence);
        } else if (m2733l() != null) {
            m2733l().mo480a(charSequence);
        } else if (this.f1420w != null) {
            this.f1420w.setText(charSequence);
        }
    }

    void mo442a(int i, Menu menu) {
        if (i == 108) {
            C0569a a = mo434a();
            if (a != null) {
                a.mo489f(false);
            }
        } else if (i == 0) {
            C0613d a2 = m2742a(i, true);
            if (a2.f1465o) {
                m2747a(a2, false);
            }
        }
    }

    boolean mo455b(int i, Menu menu) {
        if (i != 108) {
            return false;
        }
        C0569a a = mo434a();
        if (a == null) {
            return true;
        }
        a.mo489f(true);
        return true;
    }

    public boolean mo449a(C0666f c0666f, MenuItem menuItem) {
        Callback p = m2737p();
        if (!(p == null || m2736o())) {
            C0613d a = m2744a(c0666f.mo569p());
            if (a != null) {
                return p.onMenuItemSelected(a.f1451a, menuItem);
            }
        }
        return false;
    }

    public void mo445a(C0666f c0666f) {
        m2752a(c0666f, true);
    }

    public C0628b m2792b(C0610a c0610a) {
        if (c0610a == null) {
            throw new IllegalArgumentException("ActionMode callback can not be null.");
        }
        if (this.f1410m != null) {
            this.f1410m.mo502c();
        }
        C0610a c0611b = new C0611b(this, c0610a);
        C0569a a = mo434a();
        if (a != null) {
            this.f1410m = a.mo508a(c0611b);
            if (!(this.f1410m == null || this.e == null)) {
                this.e.mo412a(this.f1410m);
            }
        }
        if (this.f1410m == null) {
            this.f1410m = mo440a(c0611b);
        }
        return this.f1410m;
    }

    public void mo459e() {
        C0569a a = mo434a();
        if (a == null || !a.mo488e()) {
            m2768e(0);
        }
    }

    C0628b mo440a(C0610a c0610a) {
        C0628b c0628b;
        m2776v();
        if (this.f1410m != null) {
            this.f1410m.mo502c();
        }
        C0610a c0611b = new C0611b(this, c0610a);
        if (this.e == null || m2736o()) {
            c0628b = null;
        } else {
            try {
                c0628b = this.e.mo411a(c0611b);
            } catch (AbstractMethodError e) {
                c0628b = null;
            }
        }
        if (c0628b != null) {
            this.f1410m = c0628b;
        } else {
            if (this.f1411n == null) {
                if (this.k) {
                    Context c0642d;
                    TypedValue typedValue = new TypedValue();
                    Theme theme = this.a.getTheme();
                    theme.resolveAttribute(C0553a.actionBarTheme, typedValue, true);
                    if (typedValue.resourceId != 0) {
                        Theme newTheme = this.a.getResources().newTheme();
                        newTheme.setTo(theme);
                        newTheme.applyStyle(typedValue.resourceId, true);
                        c0642d = new C0642d(this.a, 0);
                        c0642d.getTheme().setTo(newTheme);
                    } else {
                        c0642d = this.a;
                    }
                    this.f1411n = new ActionBarContextView(c0642d);
                    this.f1412o = new PopupWindow(c0642d, null, C0553a.actionModePopupWindowStyle);
                    C0539q.m2489a(this.f1412o, 2);
                    this.f1412o.setContentView(this.f1411n);
                    this.f1412o.setWidth(-1);
                    c0642d.getTheme().resolveAttribute(C0553a.actionBarSize, typedValue, true);
                    this.f1411n.setContentHeight(TypedValue.complexToDimensionPixelSize(typedValue.data, c0642d.getResources().getDisplayMetrics()));
                    this.f1412o.setHeight(-2);
                    this.f1413p = new C06055(this);
                } else {
                    ViewStubCompat viewStubCompat = (ViewStubCompat) this.f1419v.findViewById(C0558f.action_mode_bar_stub);
                    if (viewStubCompat != null) {
                        viewStubCompat.setLayoutInflater(LayoutInflater.from(m2734m()));
                        this.f1411n = (ActionBarContextView) viewStubCompat.m3509a();
                    }
                }
            }
            if (this.f1411n != null) {
                boolean z;
                m2776v();
                this.f1411n.m3287c();
                Context context = this.f1411n.getContext();
                ActionBarContextView actionBarContextView = this.f1411n;
                if (this.f1412o == null) {
                    z = true;
                } else {
                    z = false;
                }
                C0628b c0643e = new C0643e(context, actionBarContextView, c0611b, z);
                if (c0610a.mo474a(c0643e, c0643e.mo499b())) {
                    c0643e.mo503d();
                    this.f1411n.m3284a(c0643e);
                    this.f1410m = c0643e;
                    ag.m1794b(this.f1411n, 0.0f);
                    this.f1414q = ag.m1810j(this.f1411n).m1981a(1.0f);
                    this.f1414q.m1983a(new C06066(this));
                    if (this.f1412o != null) {
                        this.b.getDecorView().post(this.f1413p);
                    }
                } else {
                    this.f1410m = null;
                }
            }
        }
        if (!(this.f1410m == null || this.e == null)) {
            this.e.mo412a(this.f1410m);
        }
        return this.f1410m;
    }

    private void m2776v() {
        if (this.f1414q != null) {
            this.f1414q.m1988b();
        }
    }

    boolean m2809r() {
        if (this.f1410m != null) {
            this.f1410m.mo502c();
            return true;
        }
        C0569a a = mo434a();
        if (a == null || !a.mo490f()) {
            return false;
        }
        return true;
    }

    boolean mo448a(int i, KeyEvent keyEvent) {
        C0569a a = mo434a();
        if (a != null && a.mo482a(i, keyEvent)) {
            return true;
        }
        if (this.f1401C == null || !m2754a(this.f1401C, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.f1401C == null) {
                C0613d a2 = m2742a(0, true);
                m2761b(a2, keyEvent);
                boolean a3 = m2754a(a2, keyEvent.getKeyCode(), keyEvent, 1);
                a2.f1463m = false;
                if (a3) {
                    return true;
                }
            }
            return false;
        } else if (this.f1401C == null) {
            return true;
        } else {
            this.f1401C.f1464n = true;
            return true;
        }
    }

    boolean mo450a(KeyEvent keyEvent) {
        boolean z = true;
        if (keyEvent.getKeyCode() == 82 && this.c.dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z = false;
        }
        return z ? m2803c(keyCode, keyEvent) : m2798b(keyCode, keyEvent);
    }

    boolean m2798b(int i, KeyEvent keyEvent) {
        switch (i) {
            case 4:
                boolean z = this.f1402D;
                this.f1402D = false;
                C0613d a = m2742a(0, false);
                if (a == null || !a.f1465o) {
                    if (m2809r()) {
                        return true;
                    }
                } else if (z) {
                    return true;
                } else {
                    m2747a(a, true);
                    return true;
                }
                break;
            case 82:
                m2769e(0, keyEvent);
                return true;
        }
        return false;
    }

    boolean m2803c(int i, KeyEvent keyEvent) {
        boolean z = true;
        switch (i) {
            case 4:
                if ((keyEvent.getFlags() & 128) == 0) {
                    z = false;
                }
                this.f1402D = z;
                break;
            case 82:
                m2767d(0, keyEvent);
                return true;
        }
        if (VERSION.SDK_INT < 11) {
            mo448a(i, keyEvent);
        }
        return false;
    }

    public View m2800c(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z;
        boolean z2 = VERSION.SDK_INT < 21;
        if (this.f1409K == null) {
            this.f1409K = new C0616l();
        }
        if (z2 && m2756a((ViewParent) view)) {
            z = true;
        } else {
            z = false;
        }
        return this.f1409K.m2857a(view, str, context, attributeSet, z, z2, true, ba.m3801a());
    }

    private boolean m2756a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        ViewParent decorView = this.b.getDecorView();
        ViewParent viewParent2 = viewParent;
        while (viewParent2 != null) {
            if (viewParent2 == decorView || !(viewParent2 instanceof View) || ag.m1822v((View) viewParent2)) {
                return false;
            }
            viewParent2 = viewParent2.getParent();
        }
        return true;
    }

    public void mo460g() {
        LayoutInflater from = LayoutInflater.from(this.a);
        if (from.getFactory() == null) {
            C0450i.m2069a(from, this);
        } else if (!(C0450i.m2068a(from) instanceof C0592j)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public final View mo151a(View view, String str, Context context, AttributeSet attributeSet) {
        View b = mo462b(view, str, context, attributeSet);
        return b != null ? b : m2800c(view, str, context, attributeSet);
    }

    View mo462b(View view, String str, Context context, AttributeSet attributeSet) {
        if (this.c instanceof Factory) {
            View onCreateView = ((Factory) this.c).onCreateView(str, context, attributeSet);
            if (onCreateView != null) {
                return onCreateView;
            }
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m2746a(android.support.v7.app.C0592j.C0613d r11, android.view.KeyEvent r12) {
        /*
        r10 = this;
        r1 = -1;
        r3 = 0;
        r9 = 1;
        r2 = -2;
        r0 = r11.f1465o;
        if (r0 != 0) goto L_0x000e;
    L_0x0008:
        r0 = r10.m2736o();
        if (r0 == 0) goto L_0x000f;
    L_0x000e:
        return;
    L_0x000f:
        r0 = r11.f1451a;
        if (r0 != 0) goto L_0x0034;
    L_0x0013:
        r4 = r10.a;
        r0 = r4.getResources();
        r0 = r0.getConfiguration();
        r0 = r0.screenLayout;
        r0 = r0 & 15;
        r5 = 4;
        if (r0 != r5) goto L_0x0048;
    L_0x0024:
        r0 = r9;
    L_0x0025:
        r4 = r4.getApplicationInfo();
        r4 = r4.targetSdkVersion;
        r5 = 11;
        if (r4 < r5) goto L_0x004a;
    L_0x002f:
        r4 = r9;
    L_0x0030:
        if (r0 == 0) goto L_0x0034;
    L_0x0032:
        if (r4 != 0) goto L_0x000e;
    L_0x0034:
        r0 = r10.m2737p();
        if (r0 == 0) goto L_0x004c;
    L_0x003a:
        r4 = r11.f1451a;
        r5 = r11.f1460j;
        r0 = r0.onMenuOpened(r4, r5);
        if (r0 != 0) goto L_0x004c;
    L_0x0044:
        r10.m2747a(r11, r9);
        goto L_0x000e;
    L_0x0048:
        r0 = r3;
        goto L_0x0025;
    L_0x004a:
        r4 = r3;
        goto L_0x0030;
    L_0x004c:
        r0 = r10.a;
        r4 = "window";
        r0 = r0.getSystemService(r4);
        r8 = r0;
        r8 = (android.view.WindowManager) r8;
        if (r8 == 0) goto L_0x000e;
    L_0x0059:
        r0 = r10.m2761b(r11, r12);
        if (r0 == 0) goto L_0x000e;
    L_0x005f:
        r0 = r11.f1457g;
        if (r0 == 0) goto L_0x0067;
    L_0x0063:
        r0 = r11.f1467q;
        if (r0 == 0) goto L_0x00f1;
    L_0x0067:
        r0 = r11.f1457g;
        if (r0 != 0) goto L_0x00df;
    L_0x006b:
        r0 = r10.m2753a(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x0071:
        r0 = r11.f1457g;
        if (r0 == 0) goto L_0x000e;
    L_0x0075:
        r0 = r10.m2764c(r11);
        if (r0 == 0) goto L_0x000e;
    L_0x007b:
        r0 = r11.m2850a();
        if (r0 == 0) goto L_0x000e;
    L_0x0081:
        r0 = r11.f1458h;
        r0 = r0.getLayoutParams();
        if (r0 != 0) goto L_0x0103;
    L_0x0089:
        r0 = new android.view.ViewGroup$LayoutParams;
        r0.<init>(r2, r2);
        r1 = r0;
    L_0x008f:
        r0 = r11.f1452b;
        r4 = r11.f1457g;
        r4.setBackgroundResource(r0);
        r0 = r11.f1458h;
        r0 = r0.getParent();
        if (r0 == 0) goto L_0x00a9;
    L_0x009e:
        r4 = r0 instanceof android.view.ViewGroup;
        if (r4 == 0) goto L_0x00a9;
    L_0x00a2:
        r0 = (android.view.ViewGroup) r0;
        r4 = r11.f1458h;
        r0.removeView(r4);
    L_0x00a9:
        r0 = r11.f1457g;
        r4 = r11.f1458h;
        r0.addView(r4, r1);
        r0 = r11.f1458h;
        r0 = r0.hasFocus();
        if (r0 != 0) goto L_0x00bd;
    L_0x00b8:
        r0 = r11.f1458h;
        r0.requestFocus();
    L_0x00bd:
        r1 = r2;
    L_0x00be:
        r11.f1464n = r3;
        r0 = new android.view.WindowManager$LayoutParams;
        r3 = r11.f1454d;
        r4 = r11.f1455e;
        r5 = 1002; // 0x3ea float:1.404E-42 double:4.95E-321;
        r6 = 8519680; // 0x820000 float:1.1938615E-38 double:4.209281E-317;
        r7 = -3;
        r0.<init>(r1, r2, r3, r4, r5, r6, r7);
        r1 = r11.f1453c;
        r0.gravity = r1;
        r1 = r11.f1456f;
        r0.windowAnimations = r1;
        r1 = r11.f1457g;
        r8.addView(r1, r0);
        r11.f1465o = r9;
        goto L_0x000e;
    L_0x00df:
        r0 = r11.f1467q;
        if (r0 == 0) goto L_0x0075;
    L_0x00e3:
        r0 = r11.f1457g;
        r0 = r0.getChildCount();
        if (r0 <= 0) goto L_0x0075;
    L_0x00eb:
        r0 = r11.f1457g;
        r0.removeAllViews();
        goto L_0x0075;
    L_0x00f1:
        r0 = r11.f1459i;
        if (r0 == 0) goto L_0x0101;
    L_0x00f5:
        r0 = r11.f1459i;
        r0 = r0.getLayoutParams();
        if (r0 == 0) goto L_0x0101;
    L_0x00fd:
        r0 = r0.width;
        if (r0 == r1) goto L_0x00be;
    L_0x0101:
        r1 = r2;
        goto L_0x00be;
    L_0x0103:
        r1 = r0;
        goto L_0x008f;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.app.j.a(android.support.v7.app.j$d, android.view.KeyEvent):void");
    }

    private boolean m2753a(C0613d c0613d) {
        c0613d.m2848a(m2734m());
        c0613d.f1457g = new C0612c(this, c0613d.f1462l);
        c0613d.f1453c = 81;
        return true;
    }

    private void m2752a(C0666f c0666f, boolean z) {
        if (this.f1415r == null || !this.f1415r.mo581d() || (as.m1895b(ViewConfiguration.get(this.a)) && !this.f1415r.mo583f())) {
            C0613d a = m2742a(0, true);
            a.f1467q = true;
            m2747a(a, false);
            m2746a(a, null);
            return;
        }
        Callback p = m2737p();
        if (this.f1415r.mo582e() && z) {
            this.f1415r.mo585h();
            if (!m2736o()) {
                p.onPanelClosed(108, m2742a(0, true).f1460j);
            }
        } else if (p != null && !m2736o()) {
            if (this.f1403E && (this.f1404F & 1) != 0) {
                this.b.getDecorView().removeCallbacks(this.f1405G);
                this.f1405G.run();
            }
            C0613d a2 = m2742a(0, true);
            if (a2.f1460j != null && !a2.f1468r && p.onPreparePanel(0, a2.f1459i, a2.f1460j)) {
                p.onMenuOpened(108, a2.f1460j);
                this.f1415r.mo584g();
            }
        }
    }

    private boolean m2760b(C0613d c0613d) {
        Context c0642d;
        C0666f c0666f;
        Context context = this.a;
        if ((c0613d.f1451a == 0 || c0613d.f1451a == 108) && this.f1415r != null) {
            TypedValue typedValue = new TypedValue();
            Theme theme = context.getTheme();
            theme.resolveAttribute(C0553a.actionBarTheme, typedValue, true);
            Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(C0553a.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(C0553a.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            Theme theme3 = theme2;
            if (theme3 != null) {
                c0642d = new C0642d(context, 0);
                c0642d.getTheme().setTo(theme3);
                c0666f = new C0666f(c0642d);
                c0666f.mo563a((C0591a) this);
                c0613d.m2849a(c0666f);
                return true;
            }
        }
        c0642d = context;
        c0666f = new C0666f(c0642d);
        c0666f.mo563a((C0591a) this);
        c0613d.m2849a(c0666f);
        return true;
    }

    private boolean m2764c(C0613d c0613d) {
        if (c0613d.f1459i != null) {
            c0613d.f1458h = c0613d.f1459i;
            return true;
        } else if (c0613d.f1460j == null) {
            return false;
        } else {
            if (this.f1417t == null) {
                this.f1417t = new C0614e();
            }
            c0613d.f1458h = (View) c0613d.m2847a(this.f1417t);
            return c0613d.f1458h != null;
        }
    }

    private boolean m2761b(C0613d c0613d, KeyEvent keyEvent) {
        if (m2736o()) {
            return false;
        }
        if (c0613d.f1463m) {
            return true;
        }
        if (!(this.f1401C == null || this.f1401C == c0613d)) {
            m2747a(this.f1401C, false);
        }
        Callback p = m2737p();
        if (p != null) {
            c0613d.f1459i = p.onCreatePanelView(c0613d.f1451a);
        }
        boolean z = c0613d.f1451a == 0 || c0613d.f1451a == 108;
        if (z && this.f1415r != null) {
            this.f1415r.mo586i();
        }
        if (c0613d.f1459i == null && !(z && (m2733l() instanceof C0620m))) {
            if (c0613d.f1460j == null || c0613d.f1468r) {
                if (c0613d.f1460j == null && (!m2760b(c0613d) || c0613d.f1460j == null)) {
                    return false;
                }
                if (z && this.f1415r != null) {
                    if (this.f1416s == null) {
                        this.f1416s = new C0608a();
                    }
                    this.f1415r.mo580a(c0613d.f1460j, this.f1416s);
                }
                c0613d.f1460j.m3177g();
                if (p.onCreatePanelMenu(c0613d.f1451a, c0613d.f1460j)) {
                    c0613d.f1468r = false;
                } else {
                    c0613d.m2849a(null);
                    if (!z || this.f1415r == null) {
                        return false;
                    }
                    this.f1415r.mo580a(null, this.f1416s);
                    return false;
                }
            }
            c0613d.f1460j.m3177g();
            if (c0613d.f1469s != null) {
                c0613d.f1460j.m3164b(c0613d.f1469s);
                c0613d.f1469s = null;
            }
            if (p.onPreparePanel(0, c0613d.f1459i, c0613d.f1460j)) {
                if (KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1) {
                    z = true;
                } else {
                    z = false;
                }
                c0613d.f1466p = z;
                c0613d.f1460j.setQwertyMode(c0613d.f1466p);
                c0613d.f1460j.m3178h();
            } else {
                if (z && this.f1415r != null) {
                    this.f1415r.mo580a(null, this.f1416s);
                }
                c0613d.f1460j.m3178h();
                return false;
            }
        }
        c0613d.f1463m = true;
        c0613d.f1464n = false;
        this.f1401C = c0613d;
        return true;
    }

    private void m2759b(C0666f c0666f) {
        if (!this.f1399A) {
            this.f1399A = true;
            this.f1415r.mo587j();
            Callback p = m2737p();
            if (!(p == null || m2736o())) {
                p.onPanelClosed(108, c0666f);
            }
            this.f1399A = false;
        }
    }

    private void mo465d(int i) {
        m2747a(m2742a(i, true), true);
    }

    private void m2747a(C0613d c0613d, boolean z) {
        if (z && c0613d.f1451a == 0 && this.f1415r != null && this.f1415r.mo582e()) {
            m2759b(c0613d.f1460j);
            return;
        }
        WindowManager windowManager = (WindowManager) this.a.getSystemService("window");
        if (!(windowManager == null || !c0613d.f1465o || c0613d.f1457g == null)) {
            windowManager.removeView(c0613d.f1457g);
            if (z) {
                m2745a(c0613d.f1451a, c0613d, null);
            }
        }
        c0613d.f1463m = false;
        c0613d.f1464n = false;
        c0613d.f1465o = false;
        c0613d.f1458h = null;
        c0613d.f1467q = true;
        if (this.f1401C == c0613d) {
            this.f1401C = null;
        }
    }

    private boolean m2767d(int i, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() == 0) {
            C0613d a = m2742a(i, true);
            if (!a.f1465o) {
                return m2761b(a, keyEvent);
            }
        }
        return false;
    }

    private boolean m2769e(int i, KeyEvent keyEvent) {
        boolean z = true;
        if (this.f1410m != null) {
            return false;
        }
        C0613d a = m2742a(i, true);
        if (i != 0 || this.f1415r == null || !this.f1415r.mo581d() || as.m1895b(ViewConfiguration.get(this.a))) {
            boolean z2;
            if (a.f1465o || a.f1464n) {
                z2 = a.f1465o;
                m2747a(a, true);
                z = z2;
            } else {
                if (a.f1463m) {
                    if (a.f1468r) {
                        a.f1463m = false;
                        z2 = m2761b(a, keyEvent);
                    } else {
                        z2 = true;
                    }
                    if (z2) {
                        m2746a(a, keyEvent);
                    }
                }
                z = false;
            }
        } else if (this.f1415r.mo582e()) {
            z = this.f1415r.mo585h();
        } else {
            if (!m2736o() && m2761b(a, keyEvent)) {
                z = this.f1415r.mo584g();
            }
            z = false;
        }
        if (z) {
            AudioManager audioManager = (AudioManager) this.a.getSystemService("audio");
            if (audioManager != null) {
                audioManager.playSoundEffect(0);
            } else {
                Log.w("AppCompatDelegate", "Couldn't get audio manager");
            }
        }
        return z;
    }

    private void m2745a(int i, C0613d c0613d, Menu menu) {
        if (menu == null) {
            if (c0613d == null && i >= 0 && i < this.f1400B.length) {
                c0613d = this.f1400B[i];
            }
            if (c0613d != null) {
                menu = c0613d.f1460j;
            }
        }
        if ((c0613d == null || c0613d.f1465o) && !m2736o()) {
            this.c.onPanelClosed(i, menu);
        }
    }

    private C0613d m2744a(Menu menu) {
        C0613d[] c0613dArr = this.f1400B;
        int length = c0613dArr != null ? c0613dArr.length : 0;
        for (int i = 0; i < length; i++) {
            C0613d c0613d = c0613dArr[i];
            if (c0613d != null && c0613d.f1460j == menu) {
                return c0613d;
            }
        }
        return null;
    }

    private C0613d m2742a(int i, boolean z) {
        Object obj = this.f1400B;
        if (obj == null || obj.length <= i) {
            Object obj2 = new C0613d[(i + 1)];
            if (obj != null) {
                System.arraycopy(obj, 0, obj2, 0, obj.length);
            }
            this.f1400B = obj2;
            obj = obj2;
        }
        C0613d c0613d = obj[i];
        if (c0613d != null) {
            return c0613d;
        }
        c0613d = new C0613d(i);
        obj[i] = c0613d;
        return c0613d;
    }

    private boolean m2754a(C0613d c0613d, int i, KeyEvent keyEvent, int i2) {
        boolean z = false;
        if (!keyEvent.isSystem()) {
            if ((c0613d.f1463m || m2761b(c0613d, keyEvent)) && c0613d.f1460j != null) {
                z = c0613d.f1460j.performShortcut(i, keyEvent, i2);
            }
            if (z && (i2 & 1) == 0 && this.f1415r == null) {
                m2747a(c0613d, true);
            }
        }
        return z;
    }

    private void m2768e(int i) {
        this.f1404F |= 1 << i;
        if (!this.f1403E) {
            ag.m1787a(this.b.getDecorView(), this.f1405G);
            this.f1403E = true;
        }
    }

    private void m2770f(int i) {
        C0613d a = m2742a(i, true);
        if (a.f1460j != null) {
            Bundle bundle = new Bundle();
            a.f1460j.m3152a(bundle);
            if (bundle.size() > 0) {
                a.f1469s = bundle;
            }
            a.f1460j.m3177g();
            a.f1460j.clear();
        }
        a.f1468r = true;
        a.f1467q = true;
        if ((i == 108 || i == 0) && this.f1415r != null) {
            a = m2742a(0, false);
            if (a != null) {
                a.f1463m = false;
                m2761b(a, null);
            }
        }
    }

    private int m2771g(int i) {
        int i2;
        int i3 = 1;
        int i4 = 0;
        if (this.f1411n == null || !(this.f1411n.getLayoutParams() instanceof MarginLayoutParams)) {
            i2 = 0;
        } else {
            int i5;
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams) this.f1411n.getLayoutParams();
            if (this.f1411n.isShown()) {
                if (this.f1407I == null) {
                    this.f1407I = new Rect();
                    this.f1408J = new Rect();
                }
                Rect rect = this.f1407I;
                Rect rect2 = this.f1408J;
                rect.set(0, i, 0, 0);
                bb.m3804a(this.f1419v, rect, rect2);
                if (marginLayoutParams.topMargin != (rect2.top == 0 ? i : 0)) {
                    marginLayoutParams.topMargin = i;
                    if (this.f1421x == null) {
                        this.f1421x = new View(this.a);
                        this.f1421x.setBackgroundColor(this.a.getResources().getColor(C0555c.abc_input_method_navigation_guard));
                        this.f1419v.addView(this.f1421x, -1, new LayoutParams(-1, i));
                        i5 = 1;
                    } else {
                        LayoutParams layoutParams = this.f1421x.getLayoutParams();
                        if (layoutParams.height != i) {
                            layoutParams.height = i;
                            this.f1421x.setLayoutParams(layoutParams);
                        }
                        i5 = 1;
                    }
                } else {
                    i5 = 0;
                }
                if (this.f1421x == null) {
                    i3 = 0;
                }
                if (!(this.j || i3 == 0)) {
                    i = 0;
                }
                int i6 = i5;
                i5 = i3;
                i3 = i6;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                i5 = 0;
            } else {
                i3 = 0;
                i5 = 0;
            }
            if (i3 != 0) {
                this.f1411n.setLayoutParams(marginLayoutParams);
            }
            i2 = i5;
        }
        if (this.f1421x != null) {
            View view = this.f1421x;
            if (i2 == 0) {
                i4 = 8;
            }
            view.setVisibility(i4);
        }
        return i;
    }

    private void m2777w() {
        if (this.f1418u) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int m2772h(int i) {
        if (i == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i != 9) {
            return i;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    private void m2778x() {
        if (this.f1415r != null) {
            this.f1415r.mo587j();
        }
        if (this.f1412o != null) {
            this.b.getDecorView().removeCallbacks(this.f1413p);
            if (this.f1412o.isShowing()) {
                try {
                    this.f1412o.dismiss();
                } catch (IllegalArgumentException e) {
                }
            }
            this.f1412o = null;
        }
        m2776v();
        C0613d a = m2742a(0, false);
        if (a != null && a.f1460j != null) {
            a.f1460j.close();
        }
    }
}
