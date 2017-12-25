package android.support.v7.view.menu;

import android.content.Context;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.view.menu.C0658m.C0655a;
import android.support.v7.view.menu.C0660l.C0607a;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListAdapter;
import java.util.ArrayList;

public class C0665e implements C0660l, OnItemClickListener {
    Context f1683a;
    LayoutInflater f1684b;
    C0666f f1685c;
    ExpandedMenuView f1686d;
    int f1687e;
    int f1688f;
    C0664a f1689g;
    private int f1690h;
    private C0607a f1691i;

    private class C0664a extends BaseAdapter {
        final /* synthetic */ C0665e f1681a;
        private int f1682b = -1;

        public /* synthetic */ Object getItem(int i) {
            return m3123a(i);
        }

        public C0664a(C0665e c0665e) {
            this.f1681a = c0665e;
            m3124a();
        }

        public int getCount() {
            int size = this.f1681a.f1685c.m3182l().size() - this.f1681a.f1690h;
            return this.f1682b < 0 ? size : size - 1;
        }

        public C0669h m3123a(int i) {
            ArrayList l = this.f1681a.f1685c.m3182l();
            int a = this.f1681a.f1690h + i;
            if (this.f1682b >= 0 && a >= this.f1682b) {
                a++;
            }
            return (C0669h) l.get(a);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f1681a.f1684b.inflate(this.f1681a.f1688f, viewGroup, false);
            } else {
                inflate = view;
            }
            ((C0655a) inflate).mo523a(m3123a(i), 0);
            return inflate;
        }

        void m3124a() {
            C0669h r = this.f1681a.f1685c.m3188r();
            if (r != null) {
                ArrayList l = this.f1681a.f1685c.m3182l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0669h) l.get(i)) == r) {
                        this.f1682b = i;
                        return;
                    }
                }
            }
            this.f1682b = -1;
        }

        public void notifyDataSetChanged() {
            m3124a();
            super.notifyDataSetChanged();
        }
    }

    public C0665e(Context context, int i) {
        this(i, 0);
        this.f1683a = context;
        this.f1684b = LayoutInflater.from(this.f1683a);
    }

    public C0665e(int i, int i2) {
        this.f1688f = i;
        this.f1687e = i2;
    }

    public void mo541a(Context context, C0666f c0666f) {
        if (this.f1687e != 0) {
            this.f1683a = new ContextThemeWrapper(context, this.f1687e);
            this.f1684b = LayoutInflater.from(this.f1683a);
        } else if (this.f1683a != null) {
            this.f1683a = context;
            if (this.f1684b == null) {
                this.f1684b = LayoutInflater.from(this.f1683a);
            }
        }
        this.f1685c = c0666f;
        if (this.f1689g != null) {
            this.f1689g.notifyDataSetChanged();
        }
    }

    public C0658m m3126a(ViewGroup viewGroup) {
        if (this.f1686d == null) {
            this.f1686d = (ExpandedMenuView) this.f1684b.inflate(C0560h.abc_expanded_menu_layout, viewGroup, false);
            if (this.f1689g == null) {
                this.f1689g = new C0664a(this);
            }
            this.f1686d.setAdapter(this.f1689g);
            this.f1686d.setOnItemClickListener(this);
        }
        return this.f1686d;
    }

    public ListAdapter m3127a() {
        if (this.f1689g == null) {
            this.f1689g = new C0664a(this);
        }
        return this.f1689g;
    }

    public void mo545b(boolean z) {
        if (this.f1689g != null) {
            this.f1689g.notifyDataSetChanged();
        }
    }

    public void m3130a(C0607a c0607a) {
        this.f1691i = c0607a;
    }

    public boolean mo544a(C0681p c0681p) {
        if (!c0681p.hasVisibleItems()) {
            return false;
        }
        new C0667g(c0681p).m3190a(null);
        if (this.f1691i != null) {
            this.f1691i.a_(c0681p);
        }
        return true;
    }

    public void mo542a(C0666f c0666f, boolean z) {
        if (this.f1691i != null) {
            this.f1691i.mo471a(c0666f, z);
        }
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.f1685c.m3162a(this.f1689g.m3123a(i), (C0660l) this, 0);
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
}
