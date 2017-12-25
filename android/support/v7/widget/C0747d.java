package android.support.v7.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.v4.p002a.p003a.C0085a;
import android.support.v4.view.C0434d;
import android.support.v4.view.C0434d.C0432a;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0559g;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.p016e.C0639a;
import android.support.v7.view.C0640a;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.view.menu.ActionMenuItemView.C0653b;
import android.support.v7.view.menu.C0658m;
import android.support.v7.view.menu.C0658m.C0655a;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0661b;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0669h;
import android.support.v7.view.menu.C0678k;
import android.support.v7.view.menu.C0681p;
import android.support.v7.widget.ActionMenuView.C0656a;
import android.support.v7.widget.ak.C0651b;
import android.util.SparseBooleanArray;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import java.util.ArrayList;

class C0747d extends C0661b implements C0432a {
    private C0741b f2228A;
    final C0746f f2229g = new C0746f();
    int f2230h;
    private C0744d f2231i;
    private Drawable f2232j;
    private boolean f2233k;
    private boolean f2234l;
    private boolean f2235m;
    private int f2236n;
    private int f2237o;
    private int f2238p;
    private boolean f2239q;
    private boolean f2240r;
    private boolean f2241s;
    private boolean f2242t;
    private int f2243u;
    private final SparseBooleanArray f2244v = new SparseBooleanArray();
    private View f2245w;
    private C0745e f2246x;
    private C0740a f2247y;
    private C0742c f2248z;

    private class C0740a extends C0678k {
        final /* synthetic */ C0747d f2217c;
        private C0681p f2218d;

        public C0740a(C0747d c0747d, Context context, C0681p c0681p) {
            boolean z = false;
            this.f2217c = c0747d;
            super(context, c0681p, null, false, C0553a.actionOverflowMenuStyle);
            this.f2218d = c0681p;
            if (!((C0669h) c0681p.getItem()).m3216j()) {
                m3249a(c0747d.f2231i == null ? (View) c0747d.f : c0747d.f2231i);
            }
            m3248a(c0747d.f2229g);
            int size = c0681p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0681p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            m3250a(z);
        }

        public void onDismiss() {
            super.onDismiss();
            this.f2217c.f2247y = null;
            this.f2217c.f2230h = 0;
        }
    }

    private class C0741b extends C0653b {
        final /* synthetic */ C0747d f2219a;

        private C0741b(C0747d c0747d) {
            this.f2219a = c0747d;
        }

        public ak mo665a() {
            return this.f2219a.f2247y != null ? this.f2219a.f2247y.m3256c() : null;
        }
    }

    private class C0742c implements Runnable {
        final /* synthetic */ C0747d f2220a;
        private C0745e f2221b;

        public C0742c(C0747d c0747d, C0745e c0745e) {
            this.f2220a = c0747d;
            this.f2221b = c0745e;
        }

        public void run() {
            this.f2220a.c.m3176f();
            View view = (View) this.f2220a.f;
            if (!(view == null || view.getWindowToken() == null || !this.f2221b.m3257d())) {
                this.f2220a.f2246x = this.f2221b;
            }
            this.f2220a.f2248z = null;
        }
    }

    private class C0744d extends AppCompatImageView implements C0656a {
        final /* synthetic */ C0747d f2224a;
        private final float[] f2225b = new float[2];

        public C0744d(final C0747d c0747d, Context context) {
            this.f2224a = c0747d;
            super(context, null, C0553a.actionOverflowButtonStyle);
            setClickable(true);
            setFocusable(true);
            setVisibility(0);
            setEnabled(true);
            setOnTouchListener(new C0651b(this, this) {
                final /* synthetic */ C0744d f2223b;

                public ak mo517a() {
                    if (this.f2223b.f2224a.f2246x == null) {
                        return null;
                    }
                    return this.f2223b.f2224a.f2246x.m3256c();
                }

                public boolean mo518b() {
                    this.f2223b.f2224a.m3844d();
                    return true;
                }

                public boolean mo666c() {
                    if (this.f2223b.f2224a.f2248z != null) {
                        return false;
                    }
                    this.f2223b.f2224a.m3845e();
                    return true;
                }
            });
        }

        public boolean performClick() {
            if (!super.performClick()) {
                playSoundEffect(0);
                this.f2224a.m3844d();
            }
            return true;
        }

        public boolean mo525c() {
            return false;
        }

        public boolean mo526d() {
            return false;
        }

        protected boolean setFrame(int i, int i2, int i3, int i4) {
            boolean frame = super.setFrame(i, i2, i3, i4);
            Drawable drawable = getDrawable();
            Drawable background = getBackground();
            if (!(drawable == null || background == null)) {
                int width = getWidth();
                int height = getHeight();
                int max = Math.max(width, height) / 2;
                width = (width + (getPaddingLeft() - getPaddingRight())) / 2;
                height = (height + (getPaddingTop() - getPaddingBottom())) / 2;
                C0085a.m453a(background, width - max, height - max, width + max, height + max);
            }
            return frame;
        }
    }

    private class C0745e extends C0678k {
        final /* synthetic */ C0747d f2226c;

        public C0745e(C0747d c0747d, Context context, C0666f c0666f, View view, boolean z) {
            this.f2226c = c0747d;
            super(context, c0666f, view, z, C0553a.actionOverflowMenuStyle);
            m3245a(8388613);
            m3248a(c0747d.f2229g);
        }

        public void onDismiss() {
            super.onDismiss();
            if (this.f2226c.c != null) {
                this.f2226c.c.close();
            }
            this.f2226c.f2246x = null;
        }
    }

    private class C0746f implements C0607a {
        final /* synthetic */ C0747d f2227a;

        private C0746f(C0747d c0747d) {
            this.f2227a = c0747d;
        }

        public boolean a_(C0666f c0666f) {
            if (c0666f == null) {
                return false;
            }
            this.f2227a.f2230h = ((C0681p) c0666f).getItem().getItemId();
            C0607a a = this.f2227a.m3101a();
            return a != null ? a.a_(c0666f) : false;
        }

        public void mo471a(C0666f c0666f, boolean z) {
            if (c0666f instanceof C0681p) {
                ((C0681p) c0666f).mo569p().m3159a(false);
            }
            C0607a a = this.f2227a.m3101a();
            if (a != null) {
                a.mo471a(c0666f, z);
            }
        }
    }

    public C0747d(Context context) {
        super(context, C0560h.abc_action_menu_layout, C0560h.abc_action_menu_item_layout);
    }

    public void mo541a(Context context, C0666f c0666f) {
        super.mo541a(context, c0666f);
        Resources resources = context.getResources();
        C0640a a = C0640a.m2982a(context);
        if (!this.f2235m) {
            this.f2234l = a.m2984b();
        }
        if (!this.f2241s) {
            this.f2236n = a.m2985c();
        }
        if (!this.f2239q) {
            this.f2238p = a.m2983a();
        }
        int i = this.f2236n;
        if (this.f2234l) {
            if (this.f2231i == null) {
                this.f2231i = new C0744d(this, this.a);
                if (this.f2233k) {
                    this.f2231i.setImageDrawable(this.f2232j);
                    this.f2232j = null;
                    this.f2233k = false;
                }
                int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
                this.f2231i.measure(makeMeasureSpec, makeMeasureSpec);
            }
            i -= this.f2231i.getMeasuredWidth();
        } else {
            this.f2231i = null;
        }
        this.f2237o = i;
        this.f2243u = (int) (56.0f * resources.getDisplayMetrics().density);
        this.f2245w = null;
    }

    public void m3830a(Configuration configuration) {
        if (!this.f2239q) {
            this.f2238p = this.b.getResources().getInteger(C0559g.abc_max_action_buttons);
        }
        if (this.c != null) {
            this.c.m3167b(true);
        }
    }

    public void m3842c(boolean z) {
        this.f2234l = z;
        this.f2235m = true;
    }

    public void m3843d(boolean z) {
        this.f2242t = z;
    }

    public void m3831a(Drawable drawable) {
        if (this.f2231i != null) {
            this.f2231i.setImageDrawable(drawable);
            return;
        }
        this.f2233k = true;
        this.f2232j = drawable;
    }

    public Drawable m3841c() {
        if (this.f2231i != null) {
            return this.f2231i.getDrawable();
        }
        if (this.f2233k) {
            return this.f2232j;
        }
        return null;
    }

    public C0658m mo667a(ViewGroup viewGroup) {
        C0658m a = super.mo667a(viewGroup);
        ((ActionMenuView) a).setPresenter(this);
        return a;
    }

    public View mo668a(C0669h c0669h, View view, ViewGroup viewGroup) {
        View actionView = c0669h.getActionView();
        if (actionView == null || c0669h.m3220n()) {
            actionView = super.mo668a(c0669h, view, viewGroup);
        }
        actionView.setVisibility(c0669h.isActionViewExpanded() ? 8 : 0);
        ActionMenuView actionMenuView = (ActionMenuView) viewGroup;
        LayoutParams layoutParams = actionView.getLayoutParams();
        if (!actionMenuView.checkLayoutParams(layoutParams)) {
            actionView.setLayoutParams(actionMenuView.m3357a(layoutParams));
        }
        return actionView;
    }

    public void mo669a(C0669h c0669h, C0655a c0655a) {
        c0655a.mo523a(c0669h, 0);
        ActionMenuItemView actionMenuItemView = (ActionMenuItemView) c0655a;
        actionMenuItemView.setItemInvoker((ActionMenuView) this.f);
        if (this.f2228A == null) {
            this.f2228A = new C0741b();
        }
        actionMenuItemView.setPopupCallback(this.f2228A);
    }

    public boolean mo671a(int i, C0669h c0669h) {
        return c0669h.m3216j();
    }

    public void mo545b(boolean z) {
        int i;
        int i2 = 1;
        int i3 = 0;
        ViewGroup viewGroup = (ViewGroup) ((View) this.f).getParent();
        if (viewGroup != null) {
            C0639a.m2981a(viewGroup);
        }
        super.mo545b(z);
        ((View) this.f).requestLayout();
        if (this.c != null) {
            ArrayList k = this.c.m3181k();
            int size = k.size();
            for (i = 0; i < size; i++) {
                C0434d a = ((C0669h) k.get(i)).mo532a();
                if (a != null) {
                    a.m2034a((C0432a) this);
                }
            }
        }
        ArrayList l = this.c != null ? this.c.m3182l() : null;
        if (this.f2234l && l != null) {
            i = l.size();
            if (i == 1) {
                int i4;
                if (((C0669h) l.get(0)).isActionViewExpanded()) {
                    i4 = 0;
                } else {
                    i4 = 1;
                }
                i3 = i4;
            } else {
                if (i <= 0) {
                    i2 = 0;
                }
                i3 = i2;
            }
        }
        if (i3 != 0) {
            if (this.f2231i == null) {
                this.f2231i = new C0744d(this, this.a);
            }
            viewGroup = (ViewGroup) this.f2231i.getParent();
            if (viewGroup != this.f) {
                if (viewGroup != null) {
                    viewGroup.removeView(this.f2231i);
                }
                ActionMenuView actionMenuView = (ActionMenuView) this.f;
                actionMenuView.addView(this.f2231i, actionMenuView.m3366c());
            }
        } else if (this.f2231i != null && this.f2231i.getParent() == this.f) {
            ((ViewGroup) this.f).removeView(this.f2231i);
        }
        ((ActionMenuView) this.f).setOverflowReserved(this.f2234l);
    }

    public boolean mo672a(ViewGroup viewGroup, int i) {
        if (viewGroup.getChildAt(i) == this.f2231i) {
            return false;
        }
        return super.mo672a(viewGroup, i);
    }

    public boolean mo544a(C0681p c0681p) {
        if (!c0681p.hasVisibleItems()) {
            return false;
        }
        C0681p c0681p2 = c0681p;
        while (c0681p2.m3271s() != this.c) {
            c0681p2 = (C0681p) c0681p2.m3271s();
        }
        View a = m3818a(c0681p2.getItem());
        if (a == null) {
            if (this.f2231i == null) {
                return false;
            }
            a = this.f2231i;
        }
        this.f2230h = c0681p.getItem().getItemId();
        this.f2247y = new C0740a(this, this.b, c0681p);
        this.f2247y.m3249a(a);
        this.f2247y.m3244a();
        super.mo544a(c0681p);
        return true;
    }

    private View m3818a(MenuItem menuItem) {
        ViewGroup viewGroup = (ViewGroup) this.f;
        if (viewGroup == null) {
            return null;
        }
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            if ((childAt instanceof C0655a) && ((C0655a) childAt).getItemData() == menuItem) {
                return childAt;
            }
        }
        return null;
    }

    public boolean m3844d() {
        if (!this.f2234l || m3848h() || this.c == null || this.f == null || this.f2248z != null || this.c.m3182l().isEmpty()) {
            return false;
        }
        this.f2248z = new C0742c(this, new C0745e(this, this.b, this.c, this.f2231i, true));
        ((View) this.f).post(this.f2248z);
        super.mo544a(null);
        return true;
    }

    public boolean m3845e() {
        if (this.f2248z == null || this.f == null) {
            C0678k c0678k = this.f2246x;
            if (c0678k == null) {
                return false;
            }
            c0678k.m3258e();
            return true;
        }
        ((View) this.f).removeCallbacks(this.f2248z);
        this.f2248z = null;
        return true;
    }

    public boolean m3846f() {
        return m3845e() | m3847g();
    }

    public boolean m3847g() {
        if (this.f2247y == null) {
            return false;
        }
        this.f2247y.m3258e();
        return true;
    }

    public boolean m3848h() {
        return this.f2246x != null && this.f2246x.m3259f();
    }

    public boolean m3849i() {
        return this.f2248z != null || m3848h();
    }

    public boolean mo546b() {
        int i;
        ArrayList i2 = this.c.m3179i();
        int size = i2.size();
        int i3 = this.f2238p;
        int i4 = this.f2237o;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        ViewGroup viewGroup = (ViewGroup) this.f;
        int i5 = 0;
        int i6 = 0;
        Object obj = null;
        int i7 = 0;
        while (i7 < size) {
            C0669h c0669h = (C0669h) i2.get(i7);
            if (c0669h.m3218l()) {
                i5++;
            } else if (c0669h.m3217k()) {
                i6++;
            } else {
                obj = 1;
            }
            if (this.f2242t && c0669h.isActionViewExpanded()) {
                i = 0;
            } else {
                i = i3;
            }
            i7++;
            i3 = i;
        }
        if (this.f2234l && (r4 != null || i5 + i6 > i3)) {
            i3--;
        }
        i7 = i3 - i5;
        SparseBooleanArray sparseBooleanArray = this.f2244v;
        sparseBooleanArray.clear();
        i = 0;
        if (this.f2240r) {
            i = i4 / this.f2243u;
            i6 = ((i4 % this.f2243u) / i) + this.f2243u;
        } else {
            i6 = 0;
        }
        int i8 = 0;
        i3 = 0;
        int i9 = i;
        while (i8 < size) {
            c0669h = (C0669h) i2.get(i8);
            int i10;
            if (c0669h.m3218l()) {
                View a = mo668a(c0669h, this.f2245w, viewGroup);
                if (this.f2245w == null) {
                    this.f2245w = a;
                }
                if (this.f2240r) {
                    i9 -= ActionMenuView.m3352a(a, i6, i9, makeMeasureSpec, 0);
                } else {
                    a.measure(makeMeasureSpec, makeMeasureSpec);
                }
                i5 = a.getMeasuredWidth();
                i10 = i4 - i5;
                if (i3 != 0) {
                    i5 = i3;
                }
                i3 = c0669h.getGroupId();
                if (i3 != 0) {
                    sparseBooleanArray.put(i3, true);
                }
                c0669h.m3209d(true);
                i = i10;
                i3 = i7;
            } else if (c0669h.m3217k()) {
                boolean z;
                int groupId = c0669h.getGroupId();
                boolean z2 = sparseBooleanArray.get(groupId);
                boolean z3 = (i7 > 0 || z2) && i4 > 0 && (!this.f2240r || i9 > 0);
                if (z3) {
                    View a2 = mo668a(c0669h, this.f2245w, viewGroup);
                    if (this.f2245w == null) {
                        this.f2245w = a2;
                    }
                    boolean z4;
                    if (this.f2240r) {
                        int a3 = ActionMenuView.m3352a(a2, i6, i9, makeMeasureSpec, 0);
                        i10 = i9 - a3;
                        if (a3 == 0) {
                            i9 = 0;
                        } else {
                            z4 = z3;
                        }
                        i5 = i10;
                    } else {
                        a2.measure(makeMeasureSpec, makeMeasureSpec);
                        boolean z5 = z3;
                        i5 = i9;
                        z4 = z5;
                    }
                    i10 = a2.getMeasuredWidth();
                    i4 -= i10;
                    if (i3 == 0) {
                        i3 = i10;
                    }
                    if (this.f2240r) {
                        z = i9 & (i4 >= 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    } else {
                        z = i9 & (i4 + i3 > 0 ? 1 : 0);
                        i10 = i3;
                        i3 = i5;
                    }
                } else {
                    z = z3;
                    i10 = i3;
                    i3 = i9;
                }
                if (z && groupId != 0) {
                    sparseBooleanArray.put(groupId, true);
                    i9 = i7;
                } else if (z2) {
                    sparseBooleanArray.put(groupId, false);
                    i5 = i7;
                    for (i7 = 0; i7 < i8; i7++) {
                        C0669h c0669h2 = (C0669h) i2.get(i7);
                        if (c0669h2.getGroupId() == groupId) {
                            if (c0669h2.m3216j()) {
                                i5++;
                            }
                            c0669h2.m3209d(false);
                        }
                    }
                    i9 = i5;
                } else {
                    i9 = i7;
                }
                if (z) {
                    i9--;
                }
                c0669h.m3209d(z);
                i5 = i10;
                i = i4;
                int i11 = i3;
                i3 = i9;
                i9 = i11;
            } else {
                c0669h.m3209d(false);
                i5 = i3;
                i = i4;
                i3 = i7;
            }
            i8++;
            i4 = i;
            i7 = i3;
            i3 = i5;
        }
        return true;
    }

    public void mo542a(C0666f c0666f, boolean z) {
        m3846f();
        super.mo542a(c0666f, z);
    }

    public void mo670a(boolean z) {
        if (z) {
            super.mo544a(null);
        } else {
            this.c.m3159a(false);
        }
    }

    public void m3834a(ActionMenuView actionMenuView) {
        this.f = actionMenuView;
        actionMenuView.mo528a(this.c);
    }
}
