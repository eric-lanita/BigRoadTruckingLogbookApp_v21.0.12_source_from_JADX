package android.support.v7.widget;

import android.content.Context;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.view.C0648g;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.view.menu.C0678k;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class am implements C0591a, C0607a {
    private Context f2088a;
    private C0666f f2089b;
    private View f2090c;
    private C0678k f2091d;
    private C0729b f2092e;
    private C0728a f2093f;

    public interface C0728a {
        void m3645a(am amVar);
    }

    public interface C0729b {
        boolean mo1015a(MenuItem menuItem);
    }

    public am(Context context, View view) {
        this(context, view, 0);
    }

    public am(Context context, View view, int i) {
        this(context, view, i, C0553a.popupMenuStyle, 0);
    }

    public am(Context context, View view, int i, int i2, int i3) {
        this.f2088a = context;
        this.f2089b = new C0666f(context);
        this.f2089b.mo563a((C0591a) this);
        this.f2090c = view;
        this.f2091d = new C0678k(context, this.f2089b, view, false, i2, i3);
        this.f2091d.m3245a(i);
        this.f2091d.m3248a((C0607a) this);
    }

    public Menu m3647a() {
        return this.f2089b;
    }

    public MenuInflater m3653b() {
        return new C0648g(this.f2088a);
    }

    public void m3648a(int i) {
        m3653b().inflate(i, this.f2089b);
    }

    public void m3654c() {
        this.f2091d.m3244a();
    }

    public void m3655d() {
        this.f2091d.m3258e();
    }

    public void m3651a(C0729b c0729b) {
        this.f2092e = c0729b;
    }

    public boolean mo449a(C0666f c0666f, MenuItem menuItem) {
        if (this.f2092e != null) {
            return this.f2092e.mo1015a(menuItem);
        }
        return false;
    }

    public void mo471a(C0666f c0666f, boolean z) {
        if (this.f2093f != null) {
            this.f2093f.m3645a(this);
        }
    }

    public boolean a_(C0666f c0666f) {
        if (c0666f == null) {
            return false;
        }
        if (!c0666f.hasVisibleItems()) {
            return true;
        }
        new C0678k(this.f2088a, c0666f, this.f2090c).m3244a();
        return true;
    }

    public void mo445a(C0666f c0666f) {
    }
}
