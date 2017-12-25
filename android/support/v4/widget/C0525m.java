package android.support.v4.widget;

import android.os.Build.VERSION;
import android.widget.ListView;

public final class C0525m {
    public static void m2423a(ListView listView, int i) {
        if (VERSION.SDK_INT >= 19) {
            C0527o.m2425a(listView, i);
        } else {
            C0526n.m2424a(listView, i);
        }
    }
}
