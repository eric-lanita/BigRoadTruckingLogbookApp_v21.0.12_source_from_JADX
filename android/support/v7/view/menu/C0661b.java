package android.support.v7.view.menu;

import android.content.Context;
import android.support.v4.view.ag;
import android.support.v7.view.menu.C0658m.C0655a;
import android.support.v7.view.menu.C0660l.C0607a;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public abstract class C0661b implements C0660l {
    protected Context f1667a;
    protected Context f1668b;
    protected C0666f f1669c;
    protected LayoutInflater f1670d;
    protected LayoutInflater f1671e;
    protected C0658m f1672f;
    private C0607a f1673g;
    private int f1674h;
    private int f1675i;
    private int f1676j;

    public abstract void mo669a(C0669h c0669h, C0655a c0655a);

    public C0661b(Context context, int i, int i2) {
        this.f1667a = context;
        this.f1670d = LayoutInflater.from(context);
        this.f1674h = i;
        this.f1675i = i2;
    }

    public void mo541a(Context context, C0666f c0666f) {
        this.f1668b = context;
        this.f1671e = LayoutInflater.from(this.f1668b);
        this.f1669c = c0666f;
    }

    public C0658m mo667a(ViewGroup viewGroup) {
        if (this.f1672f == null) {
            this.f1672f = (C0658m) this.f1670d.inflate(this.f1674h, viewGroup, false);
            this.f1672f.mo528a(this.f1669c);
            mo545b(true);
        }
        return this.f1672f;
    }

    public void mo545b(boolean z) {
        ViewGroup viewGroup = (ViewGroup) this.f1672f;
        if (viewGroup != null) {
            int i;
            if (this.f1669c != null) {
                this.f1669c.m3180j();
                ArrayList i2 = this.f1669c.m3179i();
                int size = i2.size();
                int i3 = 0;
                i = 0;
                while (i3 < size) {
                    int i4;
                    C0669h c0669h = (C0669h) i2.get(i3);
                    if (mo671a(i, c0669h)) {
                        View childAt = viewGroup.getChildAt(i);
                        C0669h itemData = childAt instanceof C0655a ? ((C0655a) childAt).getItemData() : null;
                        View a = mo668a(c0669h, childAt, viewGroup);
                        if (c0669h != itemData) {
                            a.setPressed(false);
                            ag.m1815o(a);
                        }
                        if (a != childAt) {
                            m3109a(a, i);
                        }
                        i4 = i + 1;
                    } else {
                        i4 = i;
                    }
                    i3++;
                    i = i4;
                }
            } else {
                i = 0;
            }
            while (i < viewGroup.getChildCount()) {
                if (!mo672a(viewGroup, i)) {
                    i++;
                }
            }
        }
    }

    protected void m3109a(View view, int i) {
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup != null) {
            viewGroup.removeView(view);
        }
        ((ViewGroup) this.f1672f).addView(view, i);
    }

    protected boolean mo672a(ViewGroup viewGroup, int i) {
        viewGroup.removeViewAt(i);
        return true;
    }

    public void m3108a(C0607a c0607a) {
        this.f1673g = c0607a;
    }

    public C0607a m3101a() {
        return this.f1673g;
    }

    public C0655a m3114b(ViewGroup viewGroup) {
        return (C0655a) this.f1670d.inflate(this.f1675i, viewGroup, false);
    }

    public View mo668a(C0669h c0669h, View view, ViewGroup viewGroup) {
        C0655a c0655a;
        if (view instanceof C0655a) {
            c0655a = (C0655a) view;
        } else {
            c0655a = m3114b(viewGroup);
        }
        mo669a(c0669h, c0655a);
        return (View) c0655a;
    }

    public boolean mo671a(int i, C0669h c0669h) {
        return true;
    }

    public void mo542a(C0666f c0666f, boolean z) {
        if (this.f1673g != null) {
            this.f1673g.mo471a(c0666f, z);
        }
    }

    public boolean mo544a(C0681p c0681p) {
        if (this.f1673g != null) {
            return this.f1673g.a_(c0681p);
        }
        return false;
    }

    public boolean mo546b() {
        return false;
    }

    public boolean mo543a(C0666f c0666f, C0669h c0669h) {
        return false;
    }

    public boolean mo547b(C0666f c0666f, C0669h c0669h) {
        return false;
    }

    public void m3104a(int i) {
        this.f1676j = i;
    }
}
