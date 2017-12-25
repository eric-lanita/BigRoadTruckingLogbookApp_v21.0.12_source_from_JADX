package android.support.v7.view.menu;

import android.content.Context;
import android.os.Build.VERSION;
import android.support.v4.p004b.p005a.C0232a;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.p004b.p005a.C0234c;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

public final class C0679n {
    public static Menu m3260a(Context context, C0232a c0232a) {
        if (VERSION.SDK_INT >= 14) {
            return new C0680o(context, c0232a);
        }
        throw new UnsupportedOperationException();
    }

    public static MenuItem m3261a(Context context, C0233b c0233b) {
        if (VERSION.SDK_INT >= 16) {
            return new C0676j(context, c0233b);
        }
        if (VERSION.SDK_INT >= 14) {
            return new C0674i(context, c0233b);
        }
        throw new UnsupportedOperationException();
    }

    public static SubMenu m3262a(Context context, C0234c c0234c) {
        if (VERSION.SDK_INT >= 14) {
            return new C0682q(context, c0234c);
        }
        throw new UnsupportedOperationException();
    }
}
