package android.support.v4.view;

import android.os.Build.VERSION;
import android.support.v4.p004b.p005a.C0233b;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

public final class C0466p {
    static final C0461d f1049a;

    interface C0461d {
        MenuItem mo344a(MenuItem menuItem, View view);

        View mo345a(MenuItem menuItem);

        void mo346a(MenuItem menuItem, int i);

        MenuItem mo347b(MenuItem menuItem, int i);

        boolean mo348b(MenuItem menuItem);

        boolean mo349c(MenuItem menuItem);
    }

    static class C0462a implements C0461d {
        C0462a() {
        }

        public void mo346a(MenuItem menuItem, int i) {
        }

        public MenuItem mo344a(MenuItem menuItem, View view) {
            return menuItem;
        }

        public MenuItem mo347b(MenuItem menuItem, int i) {
            return menuItem;
        }

        public View mo345a(MenuItem menuItem) {
            return null;
        }

        public boolean mo348b(MenuItem menuItem) {
            return false;
        }

        public boolean mo349c(MenuItem menuItem) {
            return false;
        }
    }

    static class C0463b implements C0461d {
        C0463b() {
        }

        public void mo346a(MenuItem menuItem, int i) {
            C0467q.m2116a(menuItem, i);
        }

        public MenuItem mo344a(MenuItem menuItem, View view) {
            return C0467q.m2114a(menuItem, view);
        }

        public MenuItem mo347b(MenuItem menuItem, int i) {
            return C0467q.m2117b(menuItem, i);
        }

        public View mo345a(MenuItem menuItem) {
            return C0467q.m2115a(menuItem);
        }

        public boolean mo348b(MenuItem menuItem) {
            return false;
        }

        public boolean mo349c(MenuItem menuItem) {
            return false;
        }
    }

    static class C0464c extends C0463b {
        C0464c() {
        }

        public boolean mo348b(MenuItem menuItem) {
            return C0468r.m2118a(menuItem);
        }

        public boolean mo349c(MenuItem menuItem) {
            return C0468r.m2119b(menuItem);
        }
    }

    public interface C0465e {
        boolean mo555a(MenuItem menuItem);

        boolean mo556b(MenuItem menuItem);
    }

    static {
        int i = VERSION.SDK_INT;
        if (i >= 14) {
            f1049a = new C0464c();
        } else if (i >= 11) {
            f1049a = new C0463b();
        } else {
            f1049a = new C0462a();
        }
    }

    public static void m2110a(MenuItem menuItem, int i) {
        if (menuItem instanceof C0233b) {
            ((C0233b) menuItem).setShowAsAction(i);
        } else {
            f1049a.mo346a(menuItem, i);
        }
    }

    public static MenuItem m2108a(MenuItem menuItem, View view) {
        if (menuItem instanceof C0233b) {
            return ((C0233b) menuItem).setActionView(view);
        }
        return f1049a.mo344a(menuItem, view);
    }

    public static MenuItem m2111b(MenuItem menuItem, int i) {
        if (menuItem instanceof C0233b) {
            return ((C0233b) menuItem).setActionView(i);
        }
        return f1049a.mo347b(menuItem, i);
    }

    public static View m2109a(MenuItem menuItem) {
        if (menuItem instanceof C0233b) {
            return ((C0233b) menuItem).getActionView();
        }
        return f1049a.mo345a(menuItem);
    }

    public static MenuItem m2107a(MenuItem menuItem, C0434d c0434d) {
        if (menuItem instanceof C0233b) {
            return ((C0233b) menuItem).mo530a(c0434d);
        }
        Log.w("MenuItemCompat", "setActionProvider: item does not implement SupportMenuItem; ignoring");
        return menuItem;
    }

    public static boolean m2112b(MenuItem menuItem) {
        if (menuItem instanceof C0233b) {
            return ((C0233b) menuItem).expandActionView();
        }
        return f1049a.mo348b(menuItem);
    }

    public static boolean m2113c(MenuItem menuItem) {
        if (menuItem instanceof C0233b) {
            return ((C0233b) menuItem).isActionViewExpanded();
        }
        return f1049a.mo349c(menuItem);
    }
}
