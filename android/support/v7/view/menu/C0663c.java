package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.p004b.p005a.C0234c;
import android.support.v4.p008d.C0270a;
import android.view.MenuItem;
import android.view.SubMenu;
import java.util.Iterator;
import java.util.Map;

abstract class C0663c<T> extends C0662d<T> {
    final Context f1678a;
    private Map<C0233b, MenuItem> f1679c;
    private Map<C0234c, SubMenu> f1680d;

    C0663c(Context context, T t) {
        super(t);
        this.f1678a = context;
    }

    final MenuItem m3118a(MenuItem menuItem) {
        if (!(menuItem instanceof C0233b)) {
            return menuItem;
        }
        C0233b c0233b = (C0233b) menuItem;
        if (this.f1679c == null) {
            this.f1679c = new C0270a();
        }
        MenuItem menuItem2 = (MenuItem) this.f1679c.get(menuItem);
        if (menuItem2 != null) {
            return menuItem2;
        }
        menuItem2 = C0679n.m3261a(this.f1678a, c0233b);
        this.f1679c.put(c0233b, menuItem2);
        return menuItem2;
    }

    final SubMenu m3119a(SubMenu subMenu) {
        if (!(subMenu instanceof C0234c)) {
            return subMenu;
        }
        C0234c c0234c = (C0234c) subMenu;
        if (this.f1680d == null) {
            this.f1680d = new C0270a();
        }
        SubMenu subMenu2 = (SubMenu) this.f1680d.get(c0234c);
        if (subMenu2 != null) {
            return subMenu2;
        }
        subMenu2 = C0679n.m3262a(this.f1678a, c0234c);
        this.f1680d.put(c0234c, subMenu2);
        return subMenu2;
    }

    final void m3120a() {
        if (this.f1679c != null) {
            this.f1679c.clear();
        }
        if (this.f1680d != null) {
            this.f1680d.clear();
        }
    }

    final void m3121a(int i) {
        if (this.f1679c != null) {
            Iterator it = this.f1679c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getGroupId()) {
                    it.remove();
                }
            }
        }
    }

    final void m3122b(int i) {
        if (this.f1679c != null) {
            Iterator it = this.f1679c.keySet().iterator();
            while (it.hasNext()) {
                if (i == ((MenuItem) it.next()).getItemId()) {
                    it.remove();
                    return;
                }
            }
        }
    }
}
