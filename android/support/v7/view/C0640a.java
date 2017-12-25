package android.support.v7.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build.VERSION;
import android.support.v4.view.as;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0554b;
import android.support.v7.p011a.C0564a.C0556d;
import android.support.v7.p011a.C0564a.C0559g;
import android.support.v7.p011a.C0564a.C0563k;
import android.view.ViewConfiguration;

public class C0640a {
    private Context f1550a;

    public static C0640a m2982a(Context context) {
        return new C0640a(context);
    }

    private C0640a(Context context) {
        this.f1550a = context;
    }

    public int m2983a() {
        return this.f1550a.getResources().getInteger(C0559g.abc_max_action_buttons);
    }

    public boolean m2984b() {
        if (VERSION.SDK_INT < 19 && as.m1895b(ViewConfiguration.get(this.f1550a))) {
            return false;
        }
        return true;
    }

    public int m2985c() {
        return this.f1550a.getResources().getDisplayMetrics().widthPixels / 2;
    }

    public boolean m2986d() {
        if (this.f1550a.getApplicationInfo().targetSdkVersion >= 16) {
            return this.f1550a.getResources().getBoolean(C0554b.abc_action_bar_embed_tabs);
        }
        return this.f1550a.getResources().getBoolean(C0554b.abc_action_bar_embed_tabs_pre_jb);
    }

    public int m2987e() {
        TypedArray obtainStyledAttributes = this.f1550a.obtainStyledAttributes(null, C0563k.ActionBar, C0553a.actionBarStyle, 0);
        int layoutDimension = obtainStyledAttributes.getLayoutDimension(C0563k.ActionBar_height, 0);
        Resources resources = this.f1550a.getResources();
        if (!m2986d()) {
            layoutDimension = Math.min(layoutDimension, resources.getDimensionPixelSize(C0556d.abc_action_bar_stacked_max_height));
        }
        obtainStyledAttributes.recycle();
        return layoutDimension;
    }

    public boolean m2988f() {
        return this.f1550a.getApplicationInfo().targetSdkVersion < 14;
    }

    public int m2989g() {
        return this.f1550a.getResources().getDimensionPixelSize(C0556d.abc_action_bar_stacked_tab_max_width);
    }
}
