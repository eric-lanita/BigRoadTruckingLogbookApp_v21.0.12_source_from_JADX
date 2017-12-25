package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.p011a.C0564a.C0553a;
import android.support.v7.p011a.C0564a.C0556d;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.view.menu.C0658m.C0655a;
import android.support.v7.view.menu.C0660l.C0607a;
import android.support.v7.widget.ak;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class C0678k implements C0660l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int f1759a = C0560h.abc_popup_menu_item_layout;
    boolean f1760b;
    private final Context f1761c;
    private final LayoutInflater f1762d;
    private final C0666f f1763e;
    private final C0677a f1764f;
    private final boolean f1765g;
    private final int f1766h;
    private final int f1767i;
    private final int f1768j;
    private View f1769k;
    private ak f1770l;
    private ViewTreeObserver f1771m;
    private C0607a f1772n;
    private ViewGroup f1773o;
    private boolean f1774p;
    private int f1775q;
    private int f1776r;

    private class C0677a extends BaseAdapter {
        final /* synthetic */ C0678k f1756a;
        private C0666f f1757b;
        private int f1758c = -1;

        public /* synthetic */ Object getItem(int i) {
            return m3238a(i);
        }

        public C0677a(C0678k c0678k, C0666f c0666f) {
            this.f1756a = c0678k;
            this.f1757b = c0666f;
            m3239a();
        }

        public int getCount() {
            ArrayList l = this.f1756a.f1765g ? this.f1757b.m3182l() : this.f1757b.m3179i();
            if (this.f1758c < 0) {
                return l.size();
            }
            return l.size() - 1;
        }

        public C0669h m3238a(int i) {
            ArrayList l = this.f1756a.f1765g ? this.f1757b.m3182l() : this.f1757b.m3179i();
            if (this.f1758c >= 0 && i >= this.f1758c) {
                i++;
            }
            return (C0669h) l.get(i);
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.f1756a.f1762d.inflate(C0678k.f1759a, viewGroup, false);
            } else {
                inflate = view;
            }
            C0655a c0655a = (C0655a) inflate;
            if (this.f1756a.f1760b) {
                ((ListMenuItemView) inflate).setForceShowIcon(true);
            }
            c0655a.mo523a(m3238a(i), 0);
            return inflate;
        }

        void m3239a() {
            C0669h r = this.f1756a.f1763e.m3188r();
            if (r != null) {
                ArrayList l = this.f1756a.f1763e.m3182l();
                int size = l.size();
                for (int i = 0; i < size; i++) {
                    if (((C0669h) l.get(i)) == r) {
                        this.f1758c = i;
                        return;
                    }
                }
            }
            this.f1758c = -1;
        }

        public void notifyDataSetChanged() {
            m3239a();
            super.notifyDataSetChanged();
        }
    }

    public C0678k(Context context, C0666f c0666f, View view) {
        this(context, c0666f, view, false, C0553a.popupMenuStyle);
    }

    public C0678k(Context context, C0666f c0666f, View view, boolean z, int i) {
        this(context, c0666f, view, z, i, 0);
    }

    public C0678k(Context context, C0666f c0666f, View view, boolean z, int i, int i2) {
        this.f1776r = 0;
        this.f1761c = context;
        this.f1762d = LayoutInflater.from(context);
        this.f1763e = c0666f;
        this.f1764f = new C0677a(this, this.f1763e);
        this.f1765g = z;
        this.f1767i = i;
        this.f1768j = i2;
        Resources resources = context.getResources();
        this.f1766h = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(C0556d.abc_config_prefDialogWidth));
        this.f1769k = view;
        c0666f.m3156a((C0660l) this, context);
    }

    public void m3249a(View view) {
        this.f1769k = view;
    }

    public void m3250a(boolean z) {
        this.f1760b = z;
    }

    public void m3245a(int i) {
        this.f1776r = i;
    }

    public void m3244a() {
        if (!m3257d()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    public ak m3256c() {
        return this.f1770l;
    }

    public boolean m3257d() {
        boolean z = false;
        this.f1770l = new ak(this.f1761c, null, this.f1767i, this.f1768j);
        this.f1770l.m3624a((OnDismissListener) this);
        this.f1770l.m3622a((OnItemClickListener) this);
        this.f1770l.mo678a(this.f1764f);
        this.f1770l.m3625a(true);
        View view = this.f1769k;
        if (view == null) {
            return false;
        }
        if (this.f1771m == null) {
            z = true;
        }
        this.f1771m = view.getViewTreeObserver();
        if (z) {
            this.f1771m.addOnGlobalLayoutListener(this);
        }
        this.f1770l.m3621a(view);
        this.f1770l.m3630d(this.f1776r);
        if (!this.f1774p) {
            this.f1775q = m3243g();
            this.f1774p = true;
        }
        this.f1770l.m3634f(this.f1775q);
        this.f1770l.m3636g(2);
        this.f1770l.mo680c();
        this.f1770l.m3643m().setOnKeyListener(this);
        return true;
    }

    public void m3258e() {
        if (m3259f()) {
            this.f1770l.m3639i();
        }
    }

    public void onDismiss() {
        this.f1770l = null;
        this.f1763e.close();
        if (this.f1771m != null) {
            if (!this.f1771m.isAlive()) {
                this.f1771m = this.f1769k.getViewTreeObserver();
            }
            this.f1771m.removeGlobalOnLayoutListener(this);
            this.f1771m = null;
        }
    }

    public boolean m3259f() {
        return this.f1770l != null && this.f1770l.m3641k();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        C0677a c0677a = this.f1764f;
        c0677a.f1757b.m3161a(c0677a.m3238a(i), 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        m3258e();
        return true;
    }

    private int m3243g() {
        ListAdapter listAdapter = this.f1764f;
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                i2 = itemViewType;
                view2 = null;
            } else {
                view2 = view;
            }
            if (this.f1773o == null) {
                this.f1773o = new FrameLayout(this.f1761c);
            }
            view = listAdapter.getView(i, view2, this.f1773o);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            itemViewType = view.getMeasuredWidth();
            if (itemViewType >= this.f1766h) {
                return this.f1766h;
            }
            if (itemViewType <= i3) {
                itemViewType = i3;
            }
            i++;
            i3 = itemViewType;
        }
        return i3;
    }

    public void onGlobalLayout() {
        if (m3259f()) {
            View view = this.f1769k;
            if (view == null || !view.isShown()) {
                m3258e();
            } else if (m3259f()) {
                this.f1770l.mo680c();
            }
        }
    }

    public void mo541a(Context context, C0666f c0666f) {
    }

    public void mo545b(boolean z) {
        this.f1774p = false;
        if (this.f1764f != null) {
            this.f1764f.notifyDataSetChanged();
        }
    }

    public void m3248a(C0607a c0607a) {
        this.f1772n = c0607a;
    }

    public boolean mo544a(C0681p c0681p) {
        if (c0681p.hasVisibleItems()) {
            boolean z;
            C0678k c0678k = new C0678k(this.f1761c, c0681p, this.f1769k);
            c0678k.m3248a(this.f1772n);
            int size = c0681p.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = c0681p.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            c0678k.m3250a(z);
            if (c0678k.m3257d()) {
                if (this.f1772n == null) {
                    return true;
                }
                this.f1772n.a_(c0681p);
                return true;
            }
        }
        return false;
    }

    public void mo542a(C0666f c0666f, boolean z) {
        if (c0666f == this.f1763e) {
            m3258e();
            if (this.f1772n != null) {
                this.f1772n.mo471a(c0666f, z);
            }
        }
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
