package android.support.v7.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.view.ag;
import android.support.v4.view.ax;
import android.support.v4.view.bc;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0557e;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0561i;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.menu.C0659a;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.widget.Toolbar.C0709b;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window.Callback;

public class az implements ag {
    private Toolbar f2196a;
    private int f2197b;
    private View f2198c;
    private View f2199d;
    private Drawable f2200e;
    private Drawable f2201f;
    private Drawable f2202g;
    private boolean f2203h;
    private CharSequence f2204i;
    private CharSequence f2205j;
    private CharSequence f2206k;
    private Callback f2207l;
    private boolean f2208m;
    private C0747d f2209n;
    private int f2210o;
    private final C0765l f2211p;
    private int f2212q;
    private Drawable f2213r;

    class C07351 implements OnClickListener {
        final C0659a f2191a = new C0659a(this.f2192b.f2196a.getContext(), 0, 16908332, 0, 0, this.f2192b.f2204i);
        final /* synthetic */ az f2192b;

        C07351(az azVar) {
            this.f2192b = azVar;
        }

        public void onClick(View view) {
            if (this.f2192b.f2207l != null && this.f2192b.f2208m) {
                this.f2192b.f2207l.onMenuItemSelected(0, this.f2191a);
            }
        }
    }

    public az(Toolbar toolbar, boolean z) {
        this(toolbar, z, C0561i.abc_action_bar_up_description, C0557e.abc_ic_ab_back_mtrl_am_alpha);
    }

    public az(Toolbar toolbar, boolean z, int i, int i2) {
        this.f2210o = 0;
        this.f2212q = 0;
        this.f2196a = toolbar;
        this.f2204i = toolbar.getTitle();
        this.f2205j = toolbar.getSubtitle();
        this.f2203h = this.f2204i != null;
        this.f2202g = toolbar.getNavigationIcon();
        if (z) {
            ay a = ay.m3733a(toolbar.getContext(), null, C0563k.ActionBar, C0553a.actionBarStyle, 0);
            CharSequence c = a.m3742c(C0563k.ActionBar_title);
            if (!TextUtils.isEmpty(c)) {
                m3776b(c);
            }
            c = a.m3742c(C0563k.ActionBar_subtitle);
            if (!TextUtils.isEmpty(c)) {
                m3780c(c);
            }
            Drawable a2 = a.m3736a(C0563k.ActionBar_logo);
            if (a2 != null) {
                m3779c(a2);
            }
            a2 = a.m3736a(C0563k.ActionBar_icon);
            if (this.f2202g == null && a2 != null) {
                mo637a(a2);
            }
            a2 = a.m3736a(C0563k.ActionBar_homeAsUpIndicator);
            if (a2 != null) {
                m3784d(a2);
            }
            mo647c(a.m3735a(C0563k.ActionBar_displayOptions, 0));
            int g = a.m3749g(C0563k.ActionBar_customNavigationLayout, 0);
            if (g != 0) {
                m3769a(LayoutInflater.from(this.f2196a.getContext()).inflate(g, this.f2196a, false));
                mo647c(this.f2197b | 16);
            }
            g = a.m3747f(C0563k.ActionBar_height, 0);
            if (g > 0) {
                LayoutParams layoutParams = this.f2196a.getLayoutParams();
                layoutParams.height = g;
                this.f2196a.setLayoutParams(layoutParams);
            }
            g = a.m3743d(C0563k.ActionBar_contentInsetStart, -1);
            int d = a.m3743d(C0563k.ActionBar_contentInsetEnd, -1);
            if (g >= 0 || d >= 0) {
                this.f2196a.m3492a(Math.max(g, 0), Math.max(d, 0));
            }
            g = a.m3749g(C0563k.ActionBar_titleTextStyle, 0);
            if (g != 0) {
                this.f2196a.m3493a(this.f2196a.getContext(), g);
            }
            g = a.m3749g(C0563k.ActionBar_subtitleTextStyle, 0);
            if (g != 0) {
                this.f2196a.m3497b(this.f2196a.getContext(), g);
            }
            int g2 = a.m3749g(C0563k.ActionBar_popupTheme, 0);
            if (g2 != 0) {
                this.f2196a.setPopupTheme(g2);
            }
            a.m3737a();
        } else {
            this.f2197b = m3758s();
        }
        this.f2211p = C0765l.m3902a();
        m3783d(i);
        this.f2206k = this.f2196a.getNavigationContentDescription();
        m3775b(this.f2211p.m3925a(mo644b(), i2));
        this.f2196a.setNavigationOnClickListener(new C07351(this));
    }

    public void m3783d(int i) {
        if (i != this.f2212q) {
            this.f2212q = i;
            if (TextUtils.isEmpty(this.f2196a.getNavigationContentDescription())) {
                m3787e(this.f2212q);
            }
        }
    }

    public void m3775b(Drawable drawable) {
        if (this.f2213r != drawable) {
            this.f2213r = drawable;
            m3761v();
        }
    }

    private int m3758s() {
        if (this.f2196a.getNavigationIcon() != null) {
            return 15;
        }
        return 11;
    }

    public ViewGroup mo635a() {
        return this.f2196a;
    }

    public Context mo644b() {
        return this.f2196a.getContext();
    }

    public boolean mo648c() {
        return this.f2196a.m3503g();
    }

    public void mo649d() {
        this.f2196a.m3504h();
    }

    public void mo641a(Callback callback) {
        this.f2207l = callback;
    }

    public void mo642a(CharSequence charSequence) {
        if (!this.f2203h) {
            m3757e(charSequence);
        }
    }

    public CharSequence mo650e() {
        return this.f2196a.getTitle();
    }

    public void m3776b(CharSequence charSequence) {
        this.f2203h = true;
        m3757e(charSequence);
    }

    private void m3757e(CharSequence charSequence) {
        this.f2204i = charSequence;
        if ((this.f2197b & 8) != 0) {
            this.f2196a.setTitle(charSequence);
        }
    }

    public void m3780c(CharSequence charSequence) {
        this.f2205j = charSequence;
        if ((this.f2197b & 8) != 0) {
            this.f2196a.setSubtitle(charSequence);
        }
    }

    public void mo651f() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo652g() {
        Log.i("ToolbarWidgetWrapper", "Progress display unsupported");
    }

    public void mo636a(int i) {
        mo637a(i != 0 ? this.f2211p.m3925a(mo644b(), i) : null);
    }

    public void mo637a(Drawable drawable) {
        this.f2200e = drawable;
        m3759t();
    }

    public void mo645b(int i) {
        m3779c(i != 0 ? this.f2211p.m3925a(mo644b(), i) : null);
    }

    public void m3779c(Drawable drawable) {
        this.f2201f = drawable;
        m3759t();
    }

    private void m3759t() {
        Drawable drawable = null;
        if ((this.f2197b & 2) != 0) {
            drawable = (this.f2197b & 1) != 0 ? this.f2201f != null ? this.f2201f : this.f2200e : this.f2200e;
        }
        this.f2196a.setLogo(drawable);
    }

    public boolean mo653h() {
        return this.f2196a.m3496a();
    }

    public boolean mo654i() {
        return this.f2196a.m3498b();
    }

    public boolean mo655j() {
        return this.f2196a.m3499c();
    }

    public boolean mo656k() {
        return this.f2196a.m3500d();
    }

    public boolean mo657l() {
        return this.f2196a.m3501e();
    }

    public void mo658m() {
        this.f2208m = true;
    }

    public void mo640a(Menu menu, C0607a c0607a) {
        if (this.f2209n == null) {
            this.f2209n = new C0747d(this.f2196a.getContext());
            this.f2209n.m3104a(C0558f.action_menu_presenter);
        }
        this.f2209n.m3108a(c0607a);
        this.f2196a.m3494a((C0666f) menu, this.f2209n);
    }

    public void mo659n() {
        this.f2196a.m3502f();
    }

    public int mo660o() {
        return this.f2197b;
    }

    public void mo647c(int i) {
        int i2 = this.f2197b ^ i;
        this.f2197b = i;
        if (i2 != 0) {
            if ((i2 & 4) != 0) {
                if ((i & 4) != 0) {
                    m3761v();
                    m3760u();
                } else {
                    this.f2196a.setNavigationIcon(null);
                }
            }
            if ((i2 & 3) != 0) {
                m3759t();
            }
            if ((i2 & 8) != 0) {
                if ((i & 8) != 0) {
                    this.f2196a.setTitle(this.f2204i);
                    this.f2196a.setSubtitle(this.f2205j);
                } else {
                    this.f2196a.setTitle(null);
                    this.f2196a.setSubtitle(null);
                }
            }
            if ((i2 & 16) != 0 && this.f2199d != null) {
                if ((i & 16) != 0) {
                    this.f2196a.addView(this.f2199d);
                } else {
                    this.f2196a.removeView(this.f2199d);
                }
            }
        }
    }

    public void mo639a(ar arVar) {
        if (this.f2198c != null && this.f2198c.getParent() == this.f2196a) {
            this.f2196a.removeView(this.f2198c);
        }
        this.f2198c = arVar;
        if (arVar != null && this.f2210o == 2) {
            this.f2196a.addView(this.f2198c, 0);
            C0709b c0709b = (C0709b) this.f2198c.getLayoutParams();
            c0709b.width = -2;
            c0709b.height = -2;
            c0709b.a = 8388691;
            arVar.setAllowCollapse(true);
        }
    }

    public void mo643a(boolean z) {
        this.f2196a.setCollapsible(z);
    }

    public void mo646b(boolean z) {
    }

    public int mo661p() {
        return this.f2210o;
    }

    public void m3769a(View view) {
        if (!(this.f2199d == null || (this.f2197b & 16) == 0)) {
            this.f2196a.removeView(this.f2199d);
        }
        this.f2199d = view;
        if (view != null && (this.f2197b & 16) != 0) {
            this.f2196a.addView(this.f2199d);
        }
    }

    public ax mo634a(final int i, long j) {
        return ag.m1810j(this.f2196a).m1981a(i == 0 ? 1.0f : 0.0f).m1982a(j).m1983a(new bc(this) {
            final /* synthetic */ az f2194b;
            private boolean f2195c = false;

            public void mo326a(View view) {
                this.f2194b.f2196a.setVisibility(0);
            }

            public void mo327b(View view) {
                if (!this.f2195c) {
                    this.f2194b.f2196a.setVisibility(i);
                }
            }

            public void mo328c(View view) {
                this.f2195c = true;
            }
        });
    }

    public void m3784d(Drawable drawable) {
        this.f2202g = drawable;
        m3761v();
    }

    public void m3785d(CharSequence charSequence) {
        this.f2206k = charSequence;
        m3760u();
    }

    public void m3787e(int i) {
        m3785d(i == 0 ? null : mo644b().getString(i));
    }

    private void m3760u() {
        if ((this.f2197b & 4) == 0) {
            return;
        }
        if (TextUtils.isEmpty(this.f2206k)) {
            this.f2196a.setNavigationContentDescription(this.f2212q);
        } else {
            this.f2196a.setNavigationContentDescription(this.f2206k);
        }
    }

    private void m3761v() {
        if ((this.f2197b & 4) != 0) {
            this.f2196a.setNavigationIcon(this.f2202g != null ? this.f2202g : this.f2213r);
        }
    }

    public int mo662q() {
        return this.f2196a.getVisibility();
    }

    public void mo638a(C0607a c0607a, C0591a c0591a) {
        this.f2196a.m3495a(c0607a, c0591a);
    }

    public Menu mo663r() {
        return this.f2196a.getMenu();
    }
}
