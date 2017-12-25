package android.support.v7.view;

import android.content.Context;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.view.menu.C0666f;
import android.support.v7.view.menu.C0666f.C0591a;
import android.support.v7.widget.ActionBarContextView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.lang.ref.WeakReference;

public class C0643e extends C0628b implements C0591a {
    private Context f1554a;
    private ActionBarContextView f1555b;
    private C0610a f1556c;
    private WeakReference<View> f1557d;
    private boolean f1558e;
    private boolean f1559f;
    private C0666f f1560g;

    public C0643e(Context context, ActionBarContextView actionBarContextView, C0610a c0610a, boolean z) {
        this.f1554a = context;
        this.f1555b = actionBarContextView;
        this.f1556c = c0610a;
        this.f1560g = new C0666f(actionBarContextView.getContext()).m3145a(1);
        this.f1560g.mo563a((C0591a) this);
        this.f1559f = z;
    }

    public void mo501b(CharSequence charSequence) {
        this.f1555b.setTitle(charSequence);
    }

    public void mo497a(CharSequence charSequence) {
        this.f1555b.setSubtitle(charSequence);
    }

    public void mo495a(int i) {
        mo501b(this.f1554a.getString(i));
    }

    public void mo500b(int i) {
        mo497a(this.f1554a.getString(i));
    }

    public void mo498a(boolean z) {
        super.mo498a(z);
        this.f1555b.setTitleOptional(z);
    }

    public boolean mo506h() {
        return this.f1555b.m3288d();
    }

    public void mo496a(View view) {
        this.f1555b.setCustomView(view);
        this.f1557d = view != null ? new WeakReference(view) : null;
    }

    public void mo503d() {
        this.f1556c.mo476b(this, this.f1560g);
    }

    public void mo502c() {
        if (!this.f1558e) {
            this.f1558e = true;
            this.f1555b.sendAccessibilityEvent(32);
            this.f1556c.mo473a(this);
        }
    }

    public Menu mo499b() {
        return this.f1560g;
    }

    public CharSequence mo504f() {
        return this.f1555b.getTitle();
    }

    public CharSequence mo505g() {
        return this.f1555b.getSubtitle();
    }

    public View mo507i() {
        return this.f1557d != null ? (View) this.f1557d.get() : null;
    }

    public MenuInflater mo494a() {
        return new C0648g(this.f1555b.getContext());
    }

    public boolean mo449a(C0666f c0666f, MenuItem menuItem) {
        return this.f1556c.mo475a((C0628b) this, menuItem);
    }

    public void mo445a(C0666f c0666f) {
        mo503d();
        this.f1555b.mo572a();
    }
}
