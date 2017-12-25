package android.support.v7.view.menu;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v4.p004b.p005a.C0234c;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

class C0682q extends C0680o implements SubMenu {
    C0682q(Context context, C0234c c0234c) {
        super(context, c0234c);
    }

    public C0234c m3272b() {
        return (C0234c) this.b;
    }

    public SubMenu setHeaderTitle(int i) {
        m3272b().setHeaderTitle(i);
        return this;
    }

    public SubMenu setHeaderTitle(CharSequence charSequence) {
        m3272b().setHeaderTitle(charSequence);
        return this;
    }

    public SubMenu setHeaderIcon(int i) {
        m3272b().setHeaderIcon(i);
        return this;
    }

    public SubMenu setHeaderIcon(Drawable drawable) {
        m3272b().setHeaderIcon(drawable);
        return this;
    }

    public SubMenu setHeaderView(View view) {
        m3272b().setHeaderView(view);
        return this;
    }

    public void clearHeader() {
        m3272b().clearHeader();
    }

    public SubMenu setIcon(int i) {
        m3272b().setIcon(i);
        return this;
    }

    public SubMenu setIcon(Drawable drawable) {
        m3272b().setIcon(drawable);
        return this;
    }

    public MenuItem getItem() {
        return m3118a(m3272b().getItem());
    }
}
