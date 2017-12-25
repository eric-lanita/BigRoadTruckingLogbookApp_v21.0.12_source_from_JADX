package android.support.v7.widget;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.C0434d;
import android.support.v4.view.ag;
import android.support.v7.p011a.C0564a.C0558f;
import android.support.v7.p011a.C0564a.C0560h;
import android.support.v7.p011a.C0564a.C0561i;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    C0434d f1886a;
    private final C0695a f1887b;
    private final C0696b f1888c;
    private final aj f1889d;
    private final FrameLayout f1890e;
    private final ImageView f1891f;
    private final FrameLayout f1892g;
    private final int f1893h;
    private final DataSetObserver f1894i;
    private final OnGlobalLayoutListener f1895j;
    private ak f1896k;
    private OnDismissListener f1897l;
    private boolean f1898m;
    private int f1899n;
    private boolean f1900o;
    private int f1901p;

    public static class InnerLayout extends aj {
        private static final int[] f1878a = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ay a = ay.m3732a(context, attributeSet, f1878a);
            setBackgroundDrawable(a.m3736a(0));
            a.m3737a();
        }
    }

    private class C0695a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView f1879a;
        private C0754e f1880b;
        private int f1881c;
        private boolean f1882d;
        private boolean f1883e;
        private boolean f1884f;

        public void m3376a(C0754e c0754e) {
            C0754e d = this.f1879a.f1887b.m3381d();
            if (d != null && this.f1879a.isShown()) {
                d.unregisterObserver(this.f1879a.f1894i);
            }
            this.f1880b = c0754e;
            if (c0754e != null && this.f1879a.isShown()) {
                c0754e.registerObserver(this.f1879a.f1894i);
            }
            notifyDataSetChanged();
        }

        public int getItemViewType(int i) {
            if (this.f1884f && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public int getViewTypeCount() {
            return 3;
        }

        public int getCount() {
            int a = this.f1880b.m3866a();
            if (!(this.f1882d || this.f1880b.m3870b() == null)) {
                a--;
            }
            a = Math.min(a, this.f1881c);
            if (this.f1884f) {
                return a + 1;
            }
            return a;
        }

        public Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.f1882d || this.f1880b.m3870b() == null)) {
                        i++;
                    }
                    return this.f1880b.m3868a(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != C0558f.list_item) {
                        view = LayoutInflater.from(this.f1879a.getContext()).inflate(C0560h.abc_activity_chooser_view_list_item, viewGroup, false);
                    }
                    PackageManager packageManager = this.f1879a.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(C0558f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(C0558f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.f1882d && i == 0 && this.f1883e) {
                        ag.m1795b(view, true);
                        return view;
                    }
                    ag.m1795b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.f1879a.getContext()).inflate(C0560h.abc_activity_chooser_view_list_item, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(C0558f.title)).setText(this.f1879a.getContext().getString(C0561i.abc_activity_chooser_view_see_all));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public int m3374a() {
            int i = 0;
            int i2 = this.f1881c;
            this.f1881c = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.f1881c = i2;
            return i3;
        }

        public void m3375a(int i) {
            if (this.f1881c != i) {
                this.f1881c = i;
                notifyDataSetChanged();
            }
        }

        public ResolveInfo m3379b() {
            return this.f1880b.m3870b();
        }

        public void m3377a(boolean z) {
            if (this.f1884f != z) {
                this.f1884f = z;
                notifyDataSetChanged();
            }
        }

        public int m3380c() {
            return this.f1880b.m3866a();
        }

        public C0754e m3381d() {
            return this.f1880b;
        }

        public void m3378a(boolean z, boolean z2) {
            if (this.f1882d != z || this.f1883e != z2) {
                this.f1882d = z;
                this.f1883e = z2;
                notifyDataSetChanged();
            }
        }

        public boolean m3382e() {
            return this.f1882d;
        }
    }

    private class C0696b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView f1885a;

        public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((C0695a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.f1885a.m3395b();
                    if (!this.f1885a.f1898m) {
                        if (!this.f1885a.f1887b.m3382e()) {
                            i++;
                        }
                        Intent b = this.f1885a.f1887b.m3381d().m3869b(i);
                        if (b != null) {
                            b.addFlags(524288);
                            this.f1885a.getContext().startActivity(b);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        this.f1885a.f1887b.m3381d().m3871c(i);
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.f1885a.m3385a(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public void onClick(View view) {
            if (view == this.f1885a.f1892g) {
                this.f1885a.m3395b();
                Intent b = this.f1885a.f1887b.m3381d().m3869b(this.f1885a.f1887b.m3381d().m3867a(this.f1885a.f1887b.m3379b()));
                if (b != null) {
                    b.addFlags(524288);
                    this.f1885a.getContext().startActivity(b);
                }
            } else if (view == this.f1885a.f1890e) {
                this.f1885a.f1898m = false;
                this.f1885a.m3385a(this.f1885a.f1899n);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public boolean onLongClick(View view) {
            if (view == this.f1885a.f1892g) {
                if (this.f1885a.f1887b.getCount() > 0) {
                    this.f1885a.f1898m = true;
                    this.f1885a.m3385a(this.f1885a.f1899n);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public void onDismiss() {
            m3383a();
            if (this.f1885a.f1886a != null) {
                this.f1885a.f1886a.m2037a(false);
            }
        }

        private void m3383a() {
            if (this.f1885a.f1897l != null) {
                this.f1885a.f1897l.onDismiss();
            }
        }
    }

    public void setActivityChooserModel(C0754e c0754e) {
        this.f1887b.m3376a(c0754e);
        if (m3396c()) {
            m3395b();
            m3394a();
        }
    }

    public void setExpandActivityOverflowButtonDrawable(Drawable drawable) {
        this.f1891f.setImageDrawable(drawable);
    }

    public void setExpandActivityOverflowButtonContentDescription(int i) {
        this.f1891f.setContentDescription(getContext().getString(i));
    }

    public void setProvider(C0434d c0434d) {
        this.f1886a = c0434d;
    }

    public boolean m3394a() {
        if (m3396c() || !this.f1900o) {
            return false;
        }
        this.f1898m = false;
        m3385a(this.f1899n);
        return true;
    }

    private void m3385a(int i) {
        if (this.f1887b.m3381d() == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.f1895j);
        boolean z = this.f1892g.getVisibility() == 0;
        int c = this.f1887b.m3380c();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || c <= r3 + i) {
            this.f1887b.m3377a(false);
            this.f1887b.m3375a(i);
        } else {
            this.f1887b.m3377a(true);
            this.f1887b.m3375a(i - 1);
        }
        ak listPopupWindow = getListPopupWindow();
        if (!listPopupWindow.m3641k()) {
            if (this.f1898m || !z) {
                this.f1887b.m3378a(true, z);
            } else {
                this.f1887b.m3378a(false, false);
            }
            listPopupWindow.m3634f(Math.min(this.f1887b.m3374a(), this.f1893h));
            listPopupWindow.mo680c();
            if (this.f1886a != null) {
                this.f1886a.m2037a(true);
            }
            listPopupWindow.m3643m().setContentDescription(getContext().getString(C0561i.abc_activitychooserview_choose_application));
        }
    }

    public boolean m3395b() {
        if (m3396c()) {
            getListPopupWindow().m3639i();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.f1895j);
            }
        }
        return true;
    }

    public boolean m3396c() {
        return getListPopupWindow().m3641k();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        C0754e d = this.f1887b.m3381d();
        if (d != null) {
            d.registerObserver(this.f1894i);
        }
        this.f1900o = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        C0754e d = this.f1887b.m3381d();
        if (d != null) {
            d.unregisterObserver(this.f1894i);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.f1895j);
        }
        if (m3396c()) {
            m3395b();
        }
        this.f1900o = false;
    }

    protected void onMeasure(int i, int i2) {
        View view = this.f1889d;
        if (this.f1892g.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(view, i, i2);
        setMeasuredDimension(view.getMeasuredWidth(), view.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f1889d.layout(0, 0, i3 - i, i4 - i2);
        if (!m3396c()) {
            m3395b();
        }
    }

    public C0754e getDataModel() {
        return this.f1887b.m3381d();
    }

    public void setOnDismissListener(OnDismissListener onDismissListener) {
        this.f1897l = onDismissListener;
    }

    public void setInitialActivityCount(int i) {
        this.f1899n = i;
    }

    public void setDefaultActionButtonContentDescription(int i) {
        this.f1901p = i;
    }

    private ak getListPopupWindow() {
        if (this.f1896k == null) {
            this.f1896k = new ak(getContext());
            this.f1896k.mo678a(this.f1887b);
            this.f1896k.m3621a((View) this);
            this.f1896k.m3625a(true);
            this.f1896k.m3622a(this.f1888c);
            this.f1896k.m3624a(this.f1888c);
        }
        return this.f1896k;
    }
}
