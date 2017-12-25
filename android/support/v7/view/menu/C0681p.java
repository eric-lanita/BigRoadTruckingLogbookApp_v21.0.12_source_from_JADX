package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.content.C0126a;
import android.support.v7.view.menu.C0666f.C0591a;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public class C0681p extends C0666f implements SubMenu {
    private C0666f f1777d;
    private C0669h f1778e;

    public C0681p(Context context, C0666f c0666f, C0669h c0669h) {
        super(context);
        this.f1777d = c0666f;
        this.f1778e = c0669h;
    }

    public void setQwertyMode(boolean z) {
        this.f1777d.setQwertyMode(z);
    }

    public boolean mo565b() {
        return this.f1777d.mo565b();
    }

    public boolean mo566c() {
        return this.f1777d.mo566c();
    }

    public Menu m3271s() {
        return this.f1777d;
    }

    public MenuItem getItem() {
        return this.f1778e;
    }

    public void mo563a(C0591a c0591a) {
        this.f1777d.mo563a(c0591a);
    }

    public C0666f mo569p() {
        return this.f1777d;
    }

    boolean mo564a(C0666f c0666f, MenuItem menuItem) {
        return super.mo564a(c0666f, menuItem) || this.f1777d.mo564a(c0666f, menuItem);
    }

    public SubMenu setIcon(Drawable drawable) {
        this.f1778e.setIcon(drawable);
        return this;
    }

    public SubMenu setIcon(int i) {
        this.f1778e.setIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        super.m3146a(drawable);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        super.m3146a(C0126a.m582a(m3175e(), i));
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        super.m3148a(charSequence);
        return this;
    }

    public SubMenu setHeaderTitle(int i) {
        super.m3148a(m3175e().getResources().getString(i));
        return this;
    }

    public SubMenu setHeaderView(View view) {
        super.m3147a(view);
        return this;
    }

    public boolean mo567c(C0669h c0669h) {
        return this.f1777d.mo567c(c0669h);
    }

    public boolean mo568d(C0669h c0669h) {
        return this.f1777d.mo568d(c0669h);
    }

    public String mo562a() {
        int itemId = this.f1778e != null ? this.f1778e.getItemId() : 0;
        if (itemId == 0) {
            return null;
        }
        return super.mo562a() + ":" + itemId;
    }
}
