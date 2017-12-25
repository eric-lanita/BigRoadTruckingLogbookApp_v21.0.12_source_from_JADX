package android.support.v7.app;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.ax;
import android.support.v4.view.bb;
import android.support.v4.view.bc;
import android.support.v4.view.bd;
import android.support.v7.app.C0569a.C0567b;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.view.C0640a;
import android.support.v7.view.C0648g;
import android.support.v7.view.C0650h;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.widget.ActionBarContainer;
import android.support.v7.widget.ActionBarContextView;
import android.support.v7.widget.ActionBarOverlayLayout;
import android.support.v7.widget.ActionBarOverlayLayout.C0630a;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.ag;
import android.support.v7.widget.ar;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

public class C0631p extends C0569a implements C0630a {
    static final /* synthetic */ boolean f1513h = (!C0631p.class.desiredAssertionStatus());
    private static final Interpolator f1514i = new AccelerateInterpolator();
    private static final Interpolator f1515j = new DecelerateInterpolator();
    private static final boolean f1516k;
    private boolean f1517A;
    private int f1518B = 0;
    private boolean f1519C = true;
    private boolean f1520D;
    private boolean f1521E;
    private boolean f1522F;
    private boolean f1523G = true;
    private C0650h f1524H;
    private boolean f1525I;
    C0629a f1526a;
    C0628b f1527b;
    C0610a f1528c;
    boolean f1529d;
    final bb f1530e = new C06251(this);
    final bb f1531f = new C06262(this);
    final bd f1532g = new C06273(this);
    private Context f1533l;
    private Context f1534m;
    private Activity f1535n;
    private Dialog f1536o;
    private ActionBarOverlayLayout f1537p;
    private ActionBarContainer f1538q;
    private ag f1539r;
    private ActionBarContextView f1540s;
    private View f1541t;
    private ar f1542u;
    private ArrayList<Object> f1543v = new ArrayList();
    private int f1544w = -1;
    private boolean f1545x;
    private boolean f1546y;
    private ArrayList<C0567b> f1547z = new ArrayList();

    class C06251 extends bc {
        final /* synthetic */ C0631p f1503a;

        C06251(C0631p c0631p) {
            this.f1503a = c0631p;
        }

        public void mo327b(View view) {
            if (this.f1503a.f1519C && this.f1503a.f1541t != null) {
                android.support.v4.view.ag.m1780a(this.f1503a.f1541t, 0.0f);
                android.support.v4.view.ag.m1780a(this.f1503a.f1538q, 0.0f);
            }
            this.f1503a.f1538q.setVisibility(8);
            this.f1503a.f1538q.setTransitioning(false);
            this.f1503a.f1524H = null;
            this.f1503a.m2970i();
            if (this.f1503a.f1537p != null) {
                android.support.v4.view.ag.m1813m(this.f1503a.f1537p);
            }
        }
    }

    class C06262 extends bc {
        final /* synthetic */ C0631p f1504a;

        C06262(C0631p c0631p) {
            this.f1504a = c0631p;
        }

        public void mo327b(View view) {
            this.f1504a.f1524H = null;
            this.f1504a.f1538q.requestLayout();
        }
    }

    class C06273 implements bd {
        final /* synthetic */ C0631p f1505a;

        C06273(C0631p c0631p) {
            this.f1505a = c0631p;
        }

        public void mo493a(View view) {
            ((View) this.f1505a.f1538q.getParent()).invalidate();
        }
    }

    public class C0629a extends C0628b implements C0591a {
        final /* synthetic */ C0631p f1508a;
        private final Context f1509b;
        private final C0666f f1510c;
        private C0610a f1511d;
        private WeakReference<View> f1512e;

        public C0629a(C0631p c0631p, Context context, C0610a c0610a) {
            this.f1508a = c0631p;
            this.f1509b = context;
            this.f1511d = c0610a;
            this.f1510c = new C0666f(context).m3145a(1);
            this.f1510c.mo563a((C0591a) this);
        }

        public MenuInflater mo494a() {
            return new C0648g(this.f1509b);
        }

        public Menu mo499b() {
            return this.f1510c;
        }

        public void mo502c() {
            if (this.f1508a.f1526a == this) {
                if (C0631p.m2938b(this.f1508a.f1520D, this.f1508a.f1521E, false)) {
                    this.f1511d.mo473a(this);
                } else {
                    this.f1508a.f1527b = this;
                    this.f1508a.f1528c = this.f1511d;
                }
                this.f1511d = null;
                this.f1508a.m2973j(false);
                this.f1508a.f1540s.m3286b();
                this.f1508a.f1539r.mo635a().sendAccessibilityEvent(32);
                this.f1508a.f1537p.setHideOnContentScrollEnabled(this.f1508a.f1529d);
                this.f1508a.f1526a = null;
            }
        }

        public void mo503d() {
            if (this.f1508a.f1526a == this) {
                this.f1510c.m3177g();
                try {
                    this.f1511d.mo476b(this, this.f1510c);
                } finally {
                    this.f1510c.m3178h();
                }
            }
        }

        public boolean m2921e() {
            this.f1510c.m3177g();
            try {
                boolean a = this.f1511d.mo474a((C0628b) this, this.f1510c);
                return a;
            } finally {
                this.f1510c.m3178h();
            }
        }

        public void mo496a(View view) {
            this.f1508a.f1540s.setCustomView(view);
            this.f1512e = new WeakReference(view);
        }

        public void mo497a(CharSequence charSequence) {
            this.f1508a.f1540s.setSubtitle(charSequence);
        }

        public void mo501b(CharSequence charSequence) {
            this.f1508a.f1540s.setTitle(charSequence);
        }

        public void mo495a(int i) {
            mo501b(this.f1508a.f1533l.getResources().getString(i));
        }

        public void mo500b(int i) {
            mo497a(this.f1508a.f1533l.getResources().getString(i));
        }

        public CharSequence mo504f() {
            return this.f1508a.f1540s.getTitle();
        }

        public CharSequence mo505g() {
            return this.f1508a.f1540s.getSubtitle();
        }

        public void mo498a(boolean z) {
            super.mo498a(z);
            this.f1508a.f1540s.setTitleOptional(z);
        }

        public boolean mo506h() {
            return this.f1508a.f1540s.m3288d();
        }

        public View mo507i() {
            return this.f1512e != null ? (View) this.f1512e.get() : null;
        }

        public boolean mo449a(C0666f c0666f, MenuItem menuItem) {
            if (this.f1511d != null) {
                return this.f1511d.mo475a((C0628b) this, menuItem);
            }
            return false;
        }

        public void mo445a(C0666f c0666f) {
            if (this.f1511d != null) {
                mo503d();
                this.f1508a.f1540s.mo572a();
            }
        }
    }

    static {
        boolean z = true;
        if (VERSION.SDK_INT < 14) {
            z = false;
        }
        f1516k = z;
    }

    public C0631p(Activity activity, boolean z) {
        this.f1535n = activity;
        View decorView = activity.getWindow().getDecorView();
        m2933a(decorView);
        if (!z) {
            this.f1541t = decorView.findViewById(16908290);
        }
    }

    public C0631p(Dialog dialog) {
        this.f1536o = dialog;
        m2933a(dialog.getWindow().getDecorView());
    }

    private void m2933a(View view) {
        this.f1537p = (ActionBarOverlayLayout) view.findViewById(C0558f.decor_content_parent);
        if (this.f1537p != null) {
            this.f1537p.setActionBarVisibilityCallback(this);
        }
        this.f1539r = m2936b(view.findViewById(C0558f.action_bar));
        this.f1540s = (ActionBarContextView) view.findViewById(C0558f.action_context_bar);
        this.f1538q = (ActionBarContainer) view.findViewById(C0558f.action_bar_container);
        if (this.f1539r == null || this.f1540s == null || this.f1538q == null) {
            throw new IllegalStateException(getClass().getSimpleName() + " can only be used " + "with a compatible window decor layout");
        }
        this.f1533l = this.f1539r.mo644b();
        boolean z = (this.f1539r.mo660o() & 4) != 0;
        if (z) {
            this.f1545x = true;
        }
        C0640a a = C0640a.m2982a(this.f1533l);
        if (a.m2988f() || z) {
            z = true;
        } else {
            z = false;
        }
        mo483b(z);
        m2946k(a.m2986d());
        TypedArray obtainStyledAttributes = this.f1533l.obtainStyledAttributes(null, C0563k.ActionBar, C0553a.actionBarStyle, 0);
        if (obtainStyledAttributes.getBoolean(C0563k.ActionBar_hideOnContentScroll, false)) {
            mo510c(true);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(C0563k.ActionBar_elevation, 0);
        if (dimensionPixelSize != 0) {
            mo478a((float) dimensionPixelSize);
        }
        obtainStyledAttributes.recycle();
    }

    private ag m2936b(View view) {
        if (view instanceof ag) {
            return (ag) view;
        }
        if (view instanceof Toolbar) {
            return ((Toolbar) view).getWrapper();
        }
        throw new IllegalStateException(new StringBuilder().append("Can't make a decor toolbar out of ").append(view).toString() != null ? view.getClass().getSimpleName() : "null");
    }

    public void mo478a(float f) {
        android.support.v4.view.ag.m1804e(this.f1538q, f);
    }

    public void mo479a(Configuration configuration) {
        m2946k(C0640a.m2982a(this.f1533l).m2986d());
    }

    private void m2946k(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4 = true;
        this.f1517A = z;
        if (this.f1517A) {
            this.f1538q.setTabContainer(null);
            this.f1539r.mo639a(this.f1542u);
        } else {
            this.f1539r.mo639a(null);
            this.f1538q.setTabContainer(this.f1542u);
        }
        if (m2972j() == 2) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (this.f1542u != null) {
            if (z2) {
                this.f1542u.setVisibility(0);
                if (this.f1537p != null) {
                    android.support.v4.view.ag.m1813m(this.f1537p);
                }
            } else {
                this.f1542u.setVisibility(8);
            }
        }
        ag agVar = this.f1539r;
        if (this.f1517A || !z2) {
            z3 = false;
        } else {
            z3 = true;
        }
        agVar.mo643a(z3);
        ActionBarOverlayLayout actionBarOverlayLayout = this.f1537p;
        if (this.f1517A || !z2) {
            z4 = false;
        }
        actionBarOverlayLayout.setHasNonEmbeddedTabs(z4);
    }

    void m2970i() {
        if (this.f1528c != null) {
            this.f1528c.mo473a(this.f1527b);
            this.f1527b = null;
            this.f1528c = null;
        }
    }

    public void mo509a(int i) {
        this.f1518B = i;
    }

    public void mo487e(boolean z) {
        this.f1525I = z;
        if (!z && this.f1524H != null) {
            this.f1524H.m3049b();
        }
    }

    public void mo489f(boolean z) {
        if (z != this.f1546y) {
            this.f1546y = z;
            int size = this.f1547z.size();
            for (int i = 0; i < size; i++) {
                ((C0567b) this.f1547z.get(i)).m2586a(z);
            }
        }
    }

    public void mo481a(boolean z) {
        m2954a(z ? 4 : 0, 4);
    }

    public void mo483b(boolean z) {
        this.f1539r.mo646b(z);
    }

    public void mo480a(CharSequence charSequence) {
        this.f1539r.mo642a(charSequence);
    }

    public boolean mo491g() {
        ViewGroup a = this.f1539r.mo635a();
        if (a == null || a.hasFocus()) {
            return false;
        }
        a.requestFocus();
        return true;
    }

    public void m2954a(int i, int i2) {
        int o = this.f1539r.mo660o();
        if ((i2 & 4) != 0) {
            this.f1545x = true;
        }
        this.f1539r.mo647c((o & (i2 ^ -1)) | (i & i2));
    }

    public int m2972j() {
        return this.f1539r.mo661p();
    }

    public int mo477a() {
        return this.f1539r.mo660o();
    }

    public C0628b mo508a(C0610a c0610a) {
        if (this.f1526a != null) {
            this.f1526a.mo502c();
        }
        this.f1537p.setHideOnContentScrollEnabled(false);
        this.f1540s.m3287c();
        C0628b c0629a = new C0629a(this, this.f1540s.getContext(), c0610a);
        if (!c0629a.m2921e()) {
            return null;
        }
        c0629a.mo503d();
        this.f1540s.m3284a(c0629a);
        m2973j(true);
        this.f1540s.sendAccessibilityEvent(32);
        this.f1526a = c0629a;
        return c0629a;
    }

    public int m2974k() {
        return this.f1538q.getHeight();
    }

    public void mo512g(boolean z) {
        this.f1519C = z;
    }

    private void m2948p() {
        if (!this.f1522F) {
            this.f1522F = true;
            if (this.f1537p != null) {
                this.f1537p.setShowingForActionMode(true);
            }
            m2947l(false);
        }
    }

    public void mo513l() {
        if (this.f1521E) {
            this.f1521E = false;
            m2947l(true);
        }
    }

    private void m2949q() {
        if (this.f1522F) {
            this.f1522F = false;
            if (this.f1537p != null) {
                this.f1537p.setShowingForActionMode(false);
            }
            m2947l(false);
        }
    }

    public void mo514m() {
        if (!this.f1521E) {
            this.f1521E = true;
            m2947l(true);
        }
    }

    public void mo510c(boolean z) {
        if (!z || this.f1537p.m3317a()) {
            this.f1529d = z;
            this.f1537p.setHideOnContentScrollEnabled(z);
            return;
        }
        throw new IllegalStateException("Action bar must be in overlay mode (Window.FEATURE_OVERLAY_ACTION_BAR) to enable hide on content scroll");
    }

    public int mo511d() {
        return this.f1537p.getActionBarHideOffset();
    }

    private static boolean m2938b(boolean z, boolean z2, boolean z3) {
        if (z3) {
            return true;
        }
        if (z || z2) {
            return false;
        }
        return true;
    }

    private void m2947l(boolean z) {
        if (C0631p.m2938b(this.f1520D, this.f1521E, this.f1522F)) {
            if (!this.f1523G) {
                this.f1523G = true;
                m2969h(z);
            }
        } else if (this.f1523G) {
            this.f1523G = false;
            m2971i(z);
        }
    }

    public void m2969h(boolean z) {
        if (this.f1524H != null) {
            this.f1524H.m3049b();
        }
        this.f1538q.setVisibility(0);
        if (this.f1518B == 0 && f1516k && (this.f1525I || z)) {
            android.support.v4.view.ag.m1780a(this.f1538q, 0.0f);
            float f = (float) (-this.f1538q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1538q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            android.support.v4.view.ag.m1780a(this.f1538q, f);
            C0650h c0650h = new C0650h();
            ax b = android.support.v4.view.ag.m1810j(this.f1538q).m1986b(0.0f);
            b.m1984a(this.f1532g);
            c0650h.m3044a(b);
            if (this.f1519C && this.f1541t != null) {
                android.support.v4.view.ag.m1780a(this.f1541t, f);
                c0650h.m3044a(android.support.v4.view.ag.m1810j(this.f1541t).m1986b(0.0f));
            }
            c0650h.m3047a(f1515j);
            c0650h.m3043a(250);
            c0650h.m3046a(this.f1531f);
            this.f1524H = c0650h;
            c0650h.m3048a();
        } else {
            android.support.v4.view.ag.m1794b(this.f1538q, 1.0f);
            android.support.v4.view.ag.m1780a(this.f1538q, 0.0f);
            if (this.f1519C && this.f1541t != null) {
                android.support.v4.view.ag.m1780a(this.f1541t, 0.0f);
            }
            this.f1531f.mo327b(null);
        }
        if (this.f1537p != null) {
            android.support.v4.view.ag.m1813m(this.f1537p);
        }
    }

    public void m2971i(boolean z) {
        if (this.f1524H != null) {
            this.f1524H.m3049b();
        }
        if (this.f1518B == 0 && f1516k && (this.f1525I || z)) {
            android.support.v4.view.ag.m1794b(this.f1538q, 1.0f);
            this.f1538q.setTransitioning(true);
            C0650h c0650h = new C0650h();
            float f = (float) (-this.f1538q.getHeight());
            if (z) {
                int[] iArr = new int[]{0, 0};
                this.f1538q.getLocationInWindow(iArr);
                f -= (float) iArr[1];
            }
            ax b = android.support.v4.view.ag.m1810j(this.f1538q).m1986b(f);
            b.m1984a(this.f1532g);
            c0650h.m3044a(b);
            if (this.f1519C && this.f1541t != null) {
                c0650h.m3044a(android.support.v4.view.ag.m1810j(this.f1541t).m1986b(f));
            }
            c0650h.m3047a(f1514i);
            c0650h.m3043a(250);
            c0650h.m3046a(this.f1530e);
            this.f1524H = c0650h;
            c0650h.m3048a();
            return;
        }
        this.f1530e.mo327b(null);
    }

    public boolean mo484b() {
        int k = m2974k();
        return this.f1523G && (k == 0 || mo511d() < k);
    }

    public void m2973j(boolean z) {
        ax a;
        ax a2;
        if (z) {
            m2948p();
        } else {
            m2949q();
        }
        if (z) {
            a = this.f1539r.mo634a(4, 100);
            a2 = this.f1540s.mo571a(0, 200);
        } else {
            a2 = this.f1539r.mo634a(0, 200);
            a = this.f1540s.mo571a(8, 100);
        }
        C0650h c0650h = new C0650h();
        c0650h.m3045a(a, a2);
        c0650h.m3048a();
    }

    public Context mo485c() {
        if (this.f1534m == null) {
            TypedValue typedValue = new TypedValue();
            this.f1533l.getTheme().resolveAttribute(C0553a.actionBarWidgetTheme, typedValue, true);
            int i = typedValue.resourceId;
            if (i != 0) {
                this.f1534m = new ContextThemeWrapper(this.f1533l, i);
            } else {
                this.f1534m = this.f1533l;
            }
        }
        return this.f1534m;
    }

    public void mo515n() {
        if (this.f1524H != null) {
            this.f1524H.m3049b();
            this.f1524H = null;
        }
    }

    public void mo516o() {
    }

    public boolean mo490f() {
        if (this.f1539r == null || !this.f1539r.mo648c()) {
            return false;
        }
        this.f1539r.mo649d();
        return true;
    }

    public void mo486d(boolean z) {
        if (!this.f1545x) {
            mo481a(z);
        }
    }
}
