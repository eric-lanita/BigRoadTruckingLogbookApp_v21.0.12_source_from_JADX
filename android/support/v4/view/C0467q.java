package android.support.v4.view;

import android.view.MenuItem;
import android.view.View;

class C0467q {
    public static void m2116a(MenuItem menuItem, int i) {
        menuItem.setShowAsAction(i);
    }

    public static MenuItem m2114a(MenuItem menuItem, View view) {
        return menuItem.setActionView(view);
    }

    public static MenuItem m2117b(MenuItem menuItem, int i) {
        return menuItem.setActionView(i);
    }

    public static View m2115a(MenuItem menuItem) {
        return menuItem.getActionView();
    }
}
