package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.content.C0126a;
import android.support.v4.p004b.p005a.C0232a;
import android.support.v4.view.C0434d;
import android.support.v4.view.C0466p;
import android.support.v7.p011a.C0564a.C0554b;
import android.util.SparseArray;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyCharacterMap.KeyData;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class C0666f implements C0232a {
    private static final int[] f1692d = new int[]{1, 4, 5, 3, 2, 0};
    CharSequence f1693a;
    Drawable f1694b;
    View f1695c;
    private final Context f1696e;
    private final Resources f1697f;
    private boolean f1698g;
    private boolean f1699h;
    private C0591a f1700i;
    private ArrayList<C0669h> f1701j;
    private ArrayList<C0669h> f1702k;
    private boolean f1703l;
    private ArrayList<C0669h> f1704m;
    private ArrayList<C0669h> f1705n;
    private boolean f1706o;
    private int f1707p = 0;
    private ContextMenuInfo f1708q;
    private boolean f1709r = false;
    private boolean f1710s = false;
    private boolean f1711t = false;
    private boolean f1712u = false;
    private ArrayList<C0669h> f1713v = new ArrayList();
    private CopyOnWriteArrayList<WeakReference<C0660l>> f1714w = new CopyOnWriteArrayList();
    private C0669h f1715x;
    private boolean f1716y;

    public interface C0591a {
        void mo445a(C0666f c0666f);

        boolean mo449a(C0666f c0666f, MenuItem menuItem);
    }

    public interface C0657b {
        boolean mo529a(C0669h c0669h);
    }

    public C0666f(Context context) {
        this.f1696e = context;
        this.f1697f = context.getResources();
        this.f1701j = new ArrayList();
        this.f1702k = new ArrayList();
        this.f1703l = true;
        this.f1704m = new ArrayList();
        this.f1705n = new ArrayList();
        this.f1706o = true;
        m3143e(true);
    }

    public C0666f m3145a(int i) {
        this.f1707p = i;
        return this;
    }

    public void m3155a(C0660l c0660l) {
        m3156a(c0660l, this.f1696e);
    }

    public void m3156a(C0660l c0660l, Context context) {
        this.f1714w.add(new WeakReference(c0660l));
        c0660l.mo541a(context, this);
        this.f1706o = true;
    }

    public void m3166b(C0660l c0660l) {
        Iterator it = this.f1714w.iterator();
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0660l c0660l2 = (C0660l) weakReference.get();
            if (c0660l2 == null || c0660l2 == c0660l) {
                this.f1714w.remove(weakReference);
            }
        }
    }

    private void m3142d(boolean z) {
        if (!this.f1714w.isEmpty()) {
            m3177g();
            Iterator it = this.f1714w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0660l c0660l = (C0660l) weakReference.get();
                if (c0660l == null) {
                    this.f1714w.remove(weakReference);
                } else {
                    c0660l.mo545b(z);
                }
            }
            m3178h();
        }
    }

    private boolean m3140a(C0681p c0681p, C0660l c0660l) {
        boolean z = false;
        if (this.f1714w.isEmpty()) {
            return false;
        }
        if (c0660l != null) {
            z = c0660l.mo544a(c0681p);
        }
        Iterator it = this.f1714w.iterator();
        boolean z2 = z;
        while (it.hasNext()) {
            WeakReference weakReference = (WeakReference) it.next();
            C0660l c0660l2 = (C0660l) weakReference.get();
            if (c0660l2 == null) {
                this.f1714w.remove(weakReference);
                z = z2;
            } else if (z2) {
                z = z2;
            } else {
                z = c0660l2.mo544a(c0681p);
            }
            z2 = z;
        }
        return z2;
    }

    public void m3152a(Bundle bundle) {
        int size = size();
        int i = 0;
        SparseArray sparseArray = null;
        while (i < size) {
            MenuItem item = getItem(i);
            View a = C0466p.m2109a(item);
            if (!(a == null || a.getId() == -1)) {
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                }
                a.saveHierarchyState(sparseArray);
                if (C0466p.m2113c(item)) {
                    bundle.putInt("android:menu:expandedactionview", item.getItemId());
                }
            }
            SparseArray sparseArray2 = sparseArray;
            if (item.hasSubMenu()) {
                ((C0681p) item.getSubMenu()).m3152a(bundle);
            }
            i++;
            sparseArray = sparseArray2;
        }
        if (sparseArray != null) {
            bundle.putSparseParcelableArray(mo562a(), sparseArray);
        }
    }

    public void m3164b(Bundle bundle) {
        if (bundle != null) {
            MenuItem item;
            SparseArray sparseParcelableArray = bundle.getSparseParcelableArray(mo562a());
            int size = size();
            for (int i = 0; i < size; i++) {
                item = getItem(i);
                View a = C0466p.m2109a(item);
                if (!(a == null || a.getId() == -1)) {
                    a.restoreHierarchyState(sparseParcelableArray);
                }
                if (item.hasSubMenu()) {
                    ((C0681p) item.getSubMenu()).m3164b(bundle);
                }
            }
            int i2 = bundle.getInt("android:menu:expandedactionview");
            if (i2 > 0) {
                item = findItem(i2);
                if (item != null) {
                    C0466p.m2112b(item);
                }
            }
        }
    }

    protected String mo562a() {
        return "android:menu:actionviewstates";
    }

    public void mo563a(C0591a c0591a) {
        this.f1700i = c0591a;
    }

    protected MenuItem m3150a(int i, int i2, int i3, CharSequence charSequence) {
        int d = C0666f.m3141d(i3);
        MenuItem a = m3137a(i, i2, i3, d, charSequence, this.f1707p);
        if (this.f1708q != null) {
            a.m3201a(this.f1708q);
        }
        this.f1701j.add(C0666f.m3136a(this.f1701j, d), a);
        m3167b(true);
        return a;
    }

    private C0669h m3137a(int i, int i2, int i3, int i4, CharSequence charSequence, int i5) {
        return new C0669h(this, i, i2, i3, i4, charSequence, i5);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3150a(0, 0, 0, charSequence);
    }

    public MenuItem add(int i) {
        return m3150a(0, 0, 0, this.f1697f.getString(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3150a(i, i2, i3, charSequence);
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3150a(i, i2, i3, this.f1697f.getString(i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return addSubMenu(0, 0, 0, charSequence);
    }

    public SubMenu addSubMenu(int i) {
        return addSubMenu(0, 0, 0, this.f1697f.getString(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        C0669h c0669h = (C0669h) m3150a(i, i2, i3, charSequence);
        C0681p c0681p = new C0681p(this.f1696e, this, c0669h);
        c0669h.m3200a(c0681p);
        return c0681p;
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return addSubMenu(i, i2, i3, this.f1697f.getString(i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        PackageManager packageManager = this.f1696e.getPackageManager();
        List queryIntentActivityOptions = packageManager.queryIntentActivityOptions(componentName, intentArr, intent, 0);
        int size = queryIntentActivityOptions != null ? queryIntentActivityOptions.size() : 0;
        if ((i4 & 1) == 0) {
            removeGroup(i);
        }
        for (int i5 = 0; i5 < size; i5++) {
            Intent intent2;
            ResolveInfo resolveInfo = (ResolveInfo) queryIntentActivityOptions.get(i5);
            if (resolveInfo.specificIndex < 0) {
                intent2 = intent;
            } else {
                intent2 = intentArr[resolveInfo.specificIndex];
            }
            Intent intent3 = new Intent(intent2);
            intent3.setComponent(new ComponentName(resolveInfo.activityInfo.applicationInfo.packageName, resolveInfo.activityInfo.name));
            MenuItem intent4 = add(i, i2, i3, resolveInfo.loadLabel(packageManager)).setIcon(resolveInfo.loadIcon(packageManager)).setIntent(intent3);
            if (menuItemArr != null && resolveInfo.specificIndex >= 0) {
                menuItemArr[resolveInfo.specificIndex] = intent4;
            }
        }
        return size;
    }

    public void removeItem(int i) {
        m3139a(m3163b(i), true);
    }

    public void removeGroup(int i) {
        int c = m3169c(i);
        if (c >= 0) {
            int size = this.f1701j.size() - c;
            int i2 = 0;
            while (true) {
                int i3 = i2 + 1;
                if (i2 >= size || ((C0669h) this.f1701j.get(c)).getGroupId() != i) {
                    m3167b(true);
                } else {
                    m3139a(c, false);
                    i2 = i3;
                }
            }
            m3167b(true);
        }
    }

    private void m3139a(int i, boolean z) {
        if (i >= 0 && i < this.f1701j.size()) {
            this.f1701j.remove(i);
            if (z) {
                m3167b(true);
            }
        }
    }

    public void clear() {
        if (this.f1715x != null) {
            mo568d(this.f1715x);
        }
        this.f1701j.clear();
        m3167b(true);
    }

    void m3157a(MenuItem menuItem) {
        int groupId = menuItem.getGroupId();
        int size = this.f1701j.size();
        for (int i = 0; i < size; i++) {
            MenuItem menuItem2 = (C0669h) this.f1701j.get(i);
            if (menuItem2.getGroupId() == groupId && menuItem2.m3213g() && menuItem2.isCheckable()) {
                menuItem2.m3204b(menuItem2 == menuItem);
            }
        }
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        int size = this.f1701j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0669h c0669h = (C0669h) this.f1701j.get(i2);
            if (c0669h.getGroupId() == i) {
                c0669h.m3202a(z2);
                c0669h.setCheckable(z);
            }
        }
    }

    public void setGroupVisible(int i, boolean z) {
        int size = this.f1701j.size();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < size) {
            boolean z3;
            C0669h c0669h = (C0669h) this.f1701j.get(i2);
            if (c0669h.getGroupId() == i && c0669h.m3207c(z)) {
                z3 = true;
            } else {
                z3 = z2;
            }
            i2++;
            z2 = z3;
        }
        if (z2) {
            m3167b(true);
        }
    }

    public void setGroupEnabled(int i, boolean z) {
        int size = this.f1701j.size();
        for (int i2 = 0; i2 < size; i2++) {
            C0669h c0669h = (C0669h) this.f1701j.get(i2);
            if (c0669h.getGroupId() == i) {
                c0669h.setEnabled(z);
            }
        }
    }

    public boolean hasVisibleItems() {
        if (this.f1716y) {
            return true;
        }
        int size = size();
        for (int i = 0; i < size; i++) {
            if (((C0669h) this.f1701j.get(i)).isVisible()) {
                return true;
            }
        }
        return false;
    }

    public MenuItem findItem(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            C0669h c0669h = (C0669h) this.f1701j.get(i2);
            if (c0669h.getItemId() == i) {
                return c0669h;
            }
            if (c0669h.hasSubMenu()) {
                MenuItem findItem = c0669h.getSubMenu().findItem(i);
                if (findItem != null) {
                    return findItem;
                }
            }
        }
        return null;
    }

    public int m3163b(int i) {
        int size = size();
        for (int i2 = 0; i2 < size; i2++) {
            if (((C0669h) this.f1701j.get(i2)).getItemId() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int m3169c(int i) {
        return m3144a(i, 0);
    }

    public int m3144a(int i, int i2) {
        int size = size();
        if (i2 < 0) {
            i2 = 0;
        }
        for (int i3 = i2; i3 < size; i3++) {
            if (((C0669h) this.f1701j.get(i3)).getGroupId() == i) {
                return i3;
            }
        }
        return -1;
    }

    public int size() {
        return this.f1701j.size();
    }

    public MenuItem getItem(int i) {
        return (MenuItem) this.f1701j.get(i);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return m3149a(i, keyEvent) != null;
    }

    public void setQwertyMode(boolean z) {
        this.f1698g = z;
        m3167b(false);
    }

    private static int m3141d(int i) {
        int i2 = (-65536 & i) >> 16;
        if (i2 >= 0 && i2 < f1692d.length) {
            return (f1692d[i2] << 16) | (65535 & i);
        }
        throw new IllegalArgumentException("order does not contain a valid category.");
    }

    boolean mo565b() {
        return this.f1698g;
    }

    private void m3143e(boolean z) {
        boolean z2 = true;
        if (!(z && this.f1697f.getConfiguration().keyboard != 1 && this.f1697f.getBoolean(C0554b.abc_config_showMenuShortcutsWhenKeyboardPresent))) {
            z2 = false;
        }
        this.f1699h = z2;
    }

    public boolean mo566c() {
        return this.f1699h;
    }

    Resources m3173d() {
        return this.f1697f;
    }

    public Context m3175e() {
        return this.f1696e;
    }

    boolean mo564a(C0666f c0666f, MenuItem menuItem) {
        return this.f1700i != null && this.f1700i.mo449a(c0666f, menuItem);
    }

    public void m3176f() {
        if (this.f1700i != null) {
            this.f1700i.mo445a(this);
        }
    }

    private static int m3136a(ArrayList<C0669h> arrayList, int i) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            if (((C0669h) arrayList.get(size)).m3206c() <= i) {
                return size + 1;
            }
        }
        return 0;
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        MenuItem a = m3149a(i, keyEvent);
        boolean z = false;
        if (a != null) {
            z = m3161a(a, i2);
        }
        if ((i2 & 2) != 0) {
            m3159a(true);
        }
        return z;
    }

    void m3158a(List<C0669h> list, int i, KeyEvent keyEvent) {
        boolean b = mo565b();
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        if (keyEvent.getKeyData(keyData) || i == 67) {
            int size = this.f1701j.size();
            for (int i2 = 0; i2 < size; i2++) {
                C0669h c0669h = (C0669h) this.f1701j.get(i2);
                if (c0669h.hasSubMenu()) {
                    ((C0666f) c0669h.getSubMenu()).m3158a((List) list, i, keyEvent);
                }
                char alphabeticShortcut = b ? c0669h.getAlphabeticShortcut() : c0669h.getNumericShortcut();
                if ((metaState & 5) == 0 && alphabeticShortcut != '\u0000' && ((alphabeticShortcut == keyData.meta[0] || alphabeticShortcut == keyData.meta[2] || (b && alphabeticShortcut == '\b' && i == 67)) && c0669h.isEnabled())) {
                    list.add(c0669h);
                }
            }
        }
    }

    C0669h m3149a(int i, KeyEvent keyEvent) {
        List list = this.f1713v;
        list.clear();
        m3158a(list, i, keyEvent);
        if (list.isEmpty()) {
            return null;
        }
        int metaState = keyEvent.getMetaState();
        KeyData keyData = new KeyData();
        keyEvent.getKeyData(keyData);
        int size = list.size();
        if (size == 1) {
            return (C0669h) list.get(0);
        }
        boolean b = mo565b();
        for (int i2 = 0; i2 < size; i2++) {
            C0669h c0669h = (C0669h) list.get(i2);
            char alphabeticShortcut = b ? c0669h.getAlphabeticShortcut() : c0669h.getNumericShortcut();
            if (alphabeticShortcut == keyData.meta[0] && (metaState & 2) == 0) {
                return c0669h;
            }
            if (alphabeticShortcut == keyData.meta[2] && (metaState & 2) != 0) {
                return c0669h;
            }
            if (b && alphabeticShortcut == '\b' && i == 67) {
                return c0669h;
            }
        }
        return null;
    }

    public boolean performIdentifierAction(int i, int i2) {
        return m3161a(findItem(i), i2);
    }

    public boolean m3161a(MenuItem menuItem, int i) {
        return m3162a(menuItem, null, i);
    }

    public boolean m3162a(MenuItem menuItem, C0660l c0660l, int i) {
        C0669h c0669h = (C0669h) menuItem;
        if (c0669h == null || !c0669h.isEnabled()) {
            return false;
        }
        boolean z;
        boolean b = c0669h.m3205b();
        C0434d a = c0669h.mo532a();
        if (a == null || !a.mo552e()) {
            z = false;
        } else {
            z = true;
        }
        boolean expandActionView;
        if (c0669h.m3220n()) {
            expandActionView = c0669h.expandActionView() | b;
            if (!expandActionView) {
                return expandActionView;
            }
            m3159a(true);
            return expandActionView;
        } else if (c0669h.hasSubMenu() || z) {
            m3159a(false);
            if (!c0669h.hasSubMenu()) {
                c0669h.m3200a(new C0681p(m3175e(), this, c0669h));
            }
            C0681p c0681p = (C0681p) c0669h.getSubMenu();
            if (z) {
                a.mo550a((SubMenu) c0681p);
            }
            expandActionView = m3140a(c0681p, c0660l) | b;
            if (expandActionView) {
                return expandActionView;
            }
            m3159a(true);
            return expandActionView;
        } else {
            if ((i & 1) == 0) {
                m3159a(true);
            }
            return b;
        }
    }

    public final void m3159a(boolean z) {
        if (!this.f1712u) {
            this.f1712u = true;
            Iterator it = this.f1714w.iterator();
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0660l c0660l = (C0660l) weakReference.get();
                if (c0660l == null) {
                    this.f1714w.remove(weakReference);
                } else {
                    c0660l.mo542a(this, z);
                }
            }
            this.f1712u = false;
        }
    }

    public void close() {
        m3159a(true);
    }

    public void m3167b(boolean z) {
        if (this.f1709r) {
            this.f1710s = true;
            return;
        }
        if (z) {
            this.f1703l = true;
            this.f1706o = true;
        }
        m3142d(z);
    }

    public void m3177g() {
        if (!this.f1709r) {
            this.f1709r = true;
            this.f1710s = false;
        }
    }

    public void m3178h() {
        this.f1709r = false;
        if (this.f1710s) {
            this.f1710s = false;
            m3167b(true);
        }
    }

    void m3154a(C0669h c0669h) {
        this.f1703l = true;
        m3167b(true);
    }

    void m3165b(C0669h c0669h) {
        this.f1706o = true;
        m3167b(true);
    }

    public ArrayList<C0669h> m3179i() {
        if (!this.f1703l) {
            return this.f1702k;
        }
        this.f1702k.clear();
        int size = this.f1701j.size();
        for (int i = 0; i < size; i++) {
            C0669h c0669h = (C0669h) this.f1701j.get(i);
            if (c0669h.isVisible()) {
                this.f1702k.add(c0669h);
            }
        }
        this.f1703l = false;
        this.f1706o = true;
        return this.f1702k;
    }

    public void m3180j() {
        ArrayList i = m3179i();
        if (this.f1706o) {
            Iterator it = this.f1714w.iterator();
            int i2 = 0;
            while (it.hasNext()) {
                int i3;
                WeakReference weakReference = (WeakReference) it.next();
                C0660l c0660l = (C0660l) weakReference.get();
                if (c0660l == null) {
                    this.f1714w.remove(weakReference);
                    i3 = i2;
                } else {
                    i3 = c0660l.mo546b() | i2;
                }
                i2 = i3;
            }
            if (i2 != 0) {
                this.f1704m.clear();
                this.f1705n.clear();
                i2 = i.size();
                for (int i4 = 0; i4 < i2; i4++) {
                    C0669h c0669h = (C0669h) i.get(i4);
                    if (c0669h.m3216j()) {
                        this.f1704m.add(c0669h);
                    } else {
                        this.f1705n.add(c0669h);
                    }
                }
            } else {
                this.f1704m.clear();
                this.f1705n.clear();
                this.f1705n.addAll(m3179i());
            }
            this.f1706o = false;
        }
    }

    public ArrayList<C0669h> m3181k() {
        m3180j();
        return this.f1704m;
    }

    public ArrayList<C0669h> m3182l() {
        m3180j();
        return this.f1705n;
    }

    public void clearHeader() {
        this.f1694b = null;
        this.f1693a = null;
        this.f1695c = null;
        m3167b(false);
    }

    private void m3138a(int i, CharSequence charSequence, int i2, Drawable drawable, View view) {
        Resources d = m3173d();
        if (view != null) {
            this.f1695c = view;
            this.f1693a = null;
            this.f1694b = null;
        } else {
            if (i > 0) {
                this.f1693a = d.getText(i);
            } else if (charSequence != null) {
                this.f1693a = charSequence;
            }
            if (i2 > 0) {
                this.f1694b = C0126a.m582a(m3175e(), i2);
            } else if (drawable != null) {
                this.f1694b = drawable;
            }
            this.f1695c = null;
        }
        m3167b(false);
    }

    protected C0666f m3148a(CharSequence charSequence) {
        m3138a(0, charSequence, 0, null, null);
        return this;
    }

    protected C0666f m3146a(Drawable drawable) {
        m3138a(0, null, 0, drawable, null);
        return this;
    }

    protected C0666f m3147a(View view) {
        m3138a(0, null, 0, null, view);
        return this;
    }

    public CharSequence m3183m() {
        return this.f1693a;
    }

    public Drawable m3184n() {
        return this.f1694b;
    }

    public View m3185o() {
        return this.f1695c;
    }

    public C0666f mo569p() {
        return this;
    }

    boolean m3187q() {
        return this.f1711t;
    }

    public boolean mo567c(C0669h c0669h) {
        boolean z = false;
        if (!this.f1714w.isEmpty()) {
            m3177g();
            Iterator it = this.f1714w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0660l c0660l = (C0660l) weakReference.get();
                if (c0660l == null) {
                    this.f1714w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0660l.mo543a(this, c0669h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3178h();
            if (z) {
                this.f1715x = c0669h;
            }
        }
        return z;
    }

    public boolean mo568d(C0669h c0669h) {
        boolean z = false;
        if (!this.f1714w.isEmpty() && this.f1715x == c0669h) {
            m3177g();
            Iterator it = this.f1714w.iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                WeakReference weakReference = (WeakReference) it.next();
                C0660l c0660l = (C0660l) weakReference.get();
                if (c0660l == null) {
                    this.f1714w.remove(weakReference);
                    z = z2;
                } else {
                    z = c0660l.mo547b(this, c0669h);
                    if (z) {
                        break;
                    }
                }
                z2 = z;
            }
            z = z2;
            m3178h();
            if (z) {
                this.f1715x = null;
            }
        }
        return z;
    }

    public C0669h m3188r() {
        return this.f1715x;
    }

    public void m3170c(boolean z) {
        this.f1716y = z;
    }
}
