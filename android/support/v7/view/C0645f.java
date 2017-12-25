package android.support.v7.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.support.v4.p004b.p005a.C0232a;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.p008d.C0269h;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.view.menu.C0679n;
import android.view.ActionMode;
import android.view.ActionMode.Callback;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import java.util.ArrayList;

@TargetApi(11)
public class C0645f extends ActionMode {
    final Context f1565a;
    final C0628b f1566b;

    public static class C0644a implements C0610a {
        final Callback f1561a;
        final Context f1562b;
        final ArrayList<C0645f> f1563c = new ArrayList();
        final C0269h<Menu, Menu> f1564d = new C0269h();

        public C0644a(Context context, Callback callback) {
            this.f1562b = context;
            this.f1561a = callback;
        }

        public boolean mo474a(C0628b c0628b, Menu menu) {
            return this.f1561a.onCreateActionMode(m3015b(c0628b), m3011a(menu));
        }

        public boolean mo476b(C0628b c0628b, Menu menu) {
            return this.f1561a.onPrepareActionMode(m3015b(c0628b), m3011a(menu));
        }

        public boolean mo475a(C0628b c0628b, MenuItem menuItem) {
            return this.f1561a.onActionItemClicked(m3015b(c0628b), C0679n.m3261a(this.f1562b, (C0233b) menuItem));
        }

        public void mo473a(C0628b c0628b) {
            this.f1561a.onDestroyActionMode(m3015b(c0628b));
        }

        private Menu m3011a(Menu menu) {
            Menu menu2 = (Menu) this.f1564d.get(menu);
            if (menu2 != null) {
                return menu2;
            }
            menu2 = C0679n.m3260a(this.f1562b, (C0232a) menu);
            this.f1564d.put(menu, menu2);
            return menu2;
        }

        public ActionMode m3015b(C0628b c0628b) {
            int size = this.f1563c.size();
            for (int i = 0; i < size; i++) {
                C0645f c0645f = (C0645f) this.f1563c.get(i);
                if (c0645f != null && c0645f.f1566b == c0628b) {
                    return c0645f;
                }
            }
            ActionMode c0645f2 = new C0645f(this.f1562b, c0628b);
            this.f1563c.add(c0645f2);
            return c0645f2;
        }
    }

    public C0645f(Context context, C0628b c0628b) {
        this.f1565a = context;
        this.f1566b = c0628b;
    }

    public Object getTag() {
        return this.f1566b.m2907j();
    }

    public void setTag(Object obj) {
        this.f1566b.m2896a(obj);
    }

    public void setTitle(CharSequence charSequence) {
        this.f1566b.mo501b(charSequence);
    }

    public void setSubtitle(CharSequence charSequence) {
        this.f1566b.mo497a(charSequence);
    }

    public void invalidate() {
        this.f1566b.mo503d();
    }

    public void finish() {
        this.f1566b.mo502c();
    }

    public Menu getMenu() {
        return C0679n.m3260a(this.f1565a, (C0232a) this.f1566b.mo499b());
    }

    public CharSequence getTitle() {
        return this.f1566b.mo504f();
    }

    public void setTitle(int i) {
        this.f1566b.mo495a(i);
    }

    public CharSequence getSubtitle() {
        return this.f1566b.mo505g();
    }

    public void setSubtitle(int i) {
        this.f1566b.mo500b(i);
    }

    public View getCustomView() {
        return this.f1566b.mo507i();
    }

    public void setCustomView(View view) {
        this.f1566b.mo496a(view);
    }

    public MenuInflater getMenuInflater() {
        return this.f1566b.mo494a();
    }

    public boolean getTitleOptionalHint() {
        return this.f1566b.m2908k();
    }

    public void setTitleOptionalHint(boolean z) {
        this.f1566b.mo498a(z);
    }

    public boolean isTitleOptional() {
        return this.f1566b.mo506h();
    }
}
