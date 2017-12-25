package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.view.C0434d;
import android.support.v4.view.C0434d.C0433b;
import android.support.v4.view.C0466p.C0465e;
import android.support.v7.view.menu.C0658m.C0655a;
import android.support.v7.widget.C0765l;
import android.util.Log;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.view.ViewDebug.CapturedViewProperty;
import android.widget.LinearLayout;

public final class C0669h implements C0233b {
    private static String f1722w;
    private static String f1723x;
    private static String f1724y;
    private static String f1725z;
    private final int f1726a;
    private final int f1727b;
    private final int f1728c;
    private final int f1729d;
    private CharSequence f1730e;
    private CharSequence f1731f;
    private Intent f1732g;
    private char f1733h;
    private char f1734i;
    private Drawable f1735j;
    private int f1736k = 0;
    private C0666f f1737l;
    private C0681p f1738m;
    private Runnable f1739n;
    private OnMenuItemClickListener f1740o;
    private int f1741p = 16;
    private int f1742q = 0;
    private View f1743r;
    private C0434d f1744s;
    private C0465e f1745t;
    private boolean f1746u = false;
    private ContextMenuInfo f1747v;

    class C06681 implements C0433b {
        final /* synthetic */ C0669h f1721a;

        C06681(C0669h c0669h) {
            this.f1721a = c0669h;
        }

        public void mo548a(boolean z) {
            this.f1721a.f1737l.m3154a(this.f1721a);
        }
    }

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3194a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3197a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3203b(i);
    }

    C0669h(C0666f c0666f, int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        this.f1737l = c0666f;
        this.f1726a = i2;
        this.f1727b = i;
        this.f1728c = i3;
        this.f1729d = i4;
        this.f1730e = charSequence;
        this.f1742q = i5;
    }

    public boolean m3205b() {
        if ((this.f1740o != null && this.f1740o.onMenuItemClick(this)) || this.f1737l.mo564a(this.f1737l.mo569p(), (MenuItem) this)) {
            return true;
        }
        if (this.f1739n != null) {
            this.f1739n.run();
            return true;
        }
        if (this.f1732g != null) {
            try {
                this.f1737l.m3175e().startActivity(this.f1732g);
                return true;
            } catch (Throwable e) {
                Log.e("MenuItemImpl", "Can't find activity to handle intent; ignoring", e);
            }
        }
        if (this.f1744s == null || !this.f1744s.mo551d()) {
            return false;
        }
        return true;
    }

    public boolean isEnabled() {
        return (this.f1741p & 16) != 0;
    }

    public MenuItem setEnabled(boolean z) {
        if (z) {
            this.f1741p |= 16;
        } else {
            this.f1741p &= -17;
        }
        this.f1737l.m3167b(false);
        return this;
    }

    public int getGroupId() {
        return this.f1727b;
    }

    @CapturedViewProperty
    public int getItemId() {
        return this.f1726a;
    }

    public int getOrder() {
        return this.f1728c;
    }

    public int m3206c() {
        return this.f1729d;
    }

    public Intent getIntent() {
        return this.f1732g;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1732g = intent;
        return this;
    }

    public char getAlphabeticShortcut() {
        return this.f1734i;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        if (this.f1734i != c) {
            this.f1734i = Character.toLowerCase(c);
            this.f1737l.m3167b(false);
        }
        return this;
    }

    public char getNumericShortcut() {
        return this.f1733h;
    }

    public MenuItem setNumericShortcut(char c) {
        if (this.f1733h != c) {
            this.f1733h = c;
            this.f1737l.m3167b(false);
        }
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1733h = c;
        this.f1734i = Character.toLowerCase(c2);
        this.f1737l.m3167b(false);
        return this;
    }

    char m3208d() {
        return this.f1737l.mo565b() ? this.f1734i : this.f1733h;
    }

    String m3210e() {
        char d = m3208d();
        if (d == '\u0000') {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder(f1722w);
        switch (d) {
            case '\b':
                stringBuilder.append(f1724y);
                break;
            case '\n':
                stringBuilder.append(f1723x);
                break;
            case ' ':
                stringBuilder.append(f1725z);
                break;
            default:
                stringBuilder.append(d);
                break;
        }
        return stringBuilder.toString();
    }

    boolean m3212f() {
        return this.f1737l.mo566c() && m3208d() != '\u0000';
    }

    public SubMenu getSubMenu() {
        return this.f1738m;
    }

    public boolean hasSubMenu() {
        return this.f1738m != null;
    }

    public void m3200a(C0681p c0681p) {
        this.f1738m = c0681p;
        c0681p.setHeaderTitle(getTitle());
    }

    @CapturedViewProperty
    public CharSequence getTitle() {
        return this.f1730e;
    }

    CharSequence m3199a(C0655a c0655a) {
        return (c0655a == null || !c0655a.mo524a()) ? getTitle() : getTitleCondensed();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1730e = charSequence;
        this.f1737l.m3167b(false);
        if (this.f1738m != null) {
            this.f1738m.setHeaderTitle(charSequence);
        }
        return this;
    }

    public MenuItem setTitle(int i) {
        return setTitle(this.f1737l.m3175e().getString(i));
    }

    public CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f1731f != null ? this.f1731f : this.f1730e;
        if (VERSION.SDK_INT >= 18 || charSequence == null || (charSequence instanceof String)) {
            return charSequence;
        }
        return charSequence.toString();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1731f = charSequence;
        if (charSequence == null) {
            CharSequence charSequence2 = this.f1730e;
        }
        this.f1737l.m3167b(false);
        return this;
    }

    public Drawable getIcon() {
        if (this.f1735j != null) {
            return this.f1735j;
        }
        if (this.f1736k == 0) {
            return null;
        }
        Drawable a = C0765l.m3902a().m3925a(this.f1737l.m3175e(), this.f1736k);
        this.f1736k = 0;
        this.f1735j = a;
        return a;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1736k = 0;
        this.f1735j = drawable;
        this.f1737l.m3167b(false);
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1735j = null;
        this.f1736k = i;
        this.f1737l.m3167b(false);
        return this;
    }

    public boolean isCheckable() {
        return (this.f1741p & 1) == 1;
    }

    public MenuItem setCheckable(boolean z) {
        int i = this.f1741p;
        this.f1741p = (z ? 1 : 0) | (this.f1741p & -2);
        if (i != this.f1741p) {
            this.f1737l.m3167b(false);
        }
        return this;
    }

    public void m3202a(boolean z) {
        this.f1741p = (z ? 4 : 0) | (this.f1741p & -5);
    }

    public boolean m3213g() {
        return (this.f1741p & 4) != 0;
    }

    public boolean isChecked() {
        return (this.f1741p & 2) == 2;
    }

    public MenuItem setChecked(boolean z) {
        if ((this.f1741p & 4) != 0) {
            this.f1737l.m3157a((MenuItem) this);
        } else {
            m3204b(z);
        }
        return this;
    }

    void m3204b(boolean z) {
        int i;
        int i2 = this.f1741p;
        int i3 = this.f1741p & -3;
        if (z) {
            i = 2;
        } else {
            i = 0;
        }
        this.f1741p = i | i3;
        if (i2 != this.f1741p) {
            this.f1737l.m3167b(false);
        }
    }

    public boolean isVisible() {
        if (this.f1744s == null || !this.f1744s.mo559b()) {
            if ((this.f1741p & 8) != 0) {
                return false;
            }
            return true;
        } else if ((this.f1741p & 8) == 0 && this.f1744s.mo560c()) {
            return true;
        } else {
            return false;
        }
    }

    boolean m3207c(boolean z) {
        int i = this.f1741p;
        this.f1741p = (z ? 0 : 8) | (this.f1741p & -9);
        if (i != this.f1741p) {
            return true;
        }
        return false;
    }

    public MenuItem setVisible(boolean z) {
        if (m3207c(z)) {
            this.f1737l.m3154a(this);
        }
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1740o = onMenuItemClickListener;
        return this;
    }

    public String toString() {
        return this.f1730e != null ? this.f1730e.toString() : null;
    }

    void m3201a(ContextMenuInfo contextMenuInfo) {
        this.f1747v = contextMenuInfo;
    }

    public ContextMenuInfo getMenuInfo() {
        return this.f1747v;
    }

    public void m3214h() {
        this.f1737l.m3165b(this);
    }

    public boolean m3215i() {
        return this.f1737l.m3187q();
    }

    public boolean m3216j() {
        return (this.f1741p & 32) == 32;
    }

    public boolean m3217k() {
        return (this.f1742q & 1) == 1;
    }

    public boolean m3218l() {
        return (this.f1742q & 2) == 2;
    }

    public void m3209d(boolean z) {
        if (z) {
            this.f1741p |= 32;
        } else {
            this.f1741p &= -33;
        }
    }

    public boolean m3219m() {
        return (this.f1742q & 4) == 4;
    }

    public void setShowAsAction(int i) {
        switch (i & 3) {
            case 0:
            case 1:
            case 2:
                this.f1742q = i;
                this.f1737l.m3165b(this);
                return;
            default:
                throw new IllegalArgumentException("SHOW_AS_ACTION_ALWAYS, SHOW_AS_ACTION_IF_ROOM, and SHOW_AS_ACTION_NEVER are mutually exclusive.");
        }
    }

    public C0233b m3197a(View view) {
        this.f1743r = view;
        this.f1744s = null;
        if (view != null && view.getId() == -1 && this.f1726a > 0) {
            view.setId(this.f1726a);
        }
        this.f1737l.m3165b(this);
        return this;
    }

    public C0233b m3194a(int i) {
        Context e = this.f1737l.m3175e();
        m3197a(LayoutInflater.from(e).inflate(i, new LinearLayout(e), false));
        return this;
    }

    public View getActionView() {
        if (this.f1743r != null) {
            return this.f1743r;
        }
        if (this.f1744s == null) {
            return null;
        }
        this.f1743r = this.f1744s.mo557a((MenuItem) this);
        return this.f1743r;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setActionProvider()");
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.getActionProvider()");
    }

    public C0434d mo532a() {
        return this.f1744s;
    }

    public C0233b mo530a(C0434d c0434d) {
        if (this.f1744s != null) {
            this.f1744s.m2042f();
        }
        this.f1743r = null;
        this.f1744s = c0434d;
        this.f1737l.m3167b(true);
        if (this.f1744s != null) {
            this.f1744s.mo558a(new C06681(this));
        }
        return this;
    }

    public C0233b m3203b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        if (!m3220n()) {
            return false;
        }
        if (this.f1745t == null || this.f1745t.mo555a(this)) {
            return this.f1737l.mo567c(this);
        }
        return false;
    }

    public boolean collapseActionView() {
        if ((this.f1742q & 8) == 0) {
            return false;
        }
        if (this.f1743r == null) {
            return true;
        }
        if (this.f1745t == null || this.f1745t.mo556b(this)) {
            return this.f1737l.mo568d(this);
        }
        return false;
    }

    public C0233b mo531a(C0465e c0465e) {
        this.f1745t = c0465e;
        return this;
    }

    public boolean m3220n() {
        if ((this.f1742q & 8) == 0) {
            return false;
        }
        if (this.f1743r == null && this.f1744s != null) {
            this.f1743r = this.f1744s.mo557a((MenuItem) this);
        }
        if (this.f1743r != null) {
            return true;
        }
        return false;
    }

    public void m3211e(boolean z) {
        this.f1746u = z;
        this.f1737l.m3167b(false);
    }

    public boolean isActionViewExpanded() {
        return this.f1746u;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException("This is not supported, use MenuItemCompat.setOnActionExpandListener()");
    }
}
