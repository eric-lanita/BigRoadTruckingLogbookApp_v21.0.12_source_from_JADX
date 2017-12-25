package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.view.menu.C0666f.C0657b;
import android.support.v7.widget.ay;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public final class ExpandedMenuView extends ListView implements C0657b, C0658m, OnItemClickListener {
    private static final int[] f1636a = new int[]{16842964, 16843049};
    private C0666f f1637b;
    private int f1638c;

    public ExpandedMenuView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842868);
    }

    public ExpandedMenuView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        setOnItemClickListener(this);
        ay a = ay.m3733a(context, attributeSet, f1636a, i, 0);
        if (a.m3748f(0)) {
            setBackgroundDrawable(a.m3736a(0));
        }
        if (a.m3748f(1)) {
            setDivider(a.m3736a(1));
        }
        a.m3737a();
    }

    public void mo528a(C0666f c0666f) {
        this.f1637b = c0666f;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        setChildrenDrawingCacheEnabled(false);
    }

    public boolean mo529a(C0669h c0669h) {
        return this.f1637b.m3161a((MenuItem) c0669h, 0);
    }

    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        mo529a((C0669h) getAdapter().getItem(i));
    }

    public int getWindowAnimations() {
        return this.f1638c;
    }
}
