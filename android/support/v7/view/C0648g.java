package android.support.v7.view;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.support.v4.p004b.p005a.C0232a;
import android.support.v4.view.C0434d;
import android.support.v4.view.C0466p;
import android.support.v7.p011a.C0564a.C0563k;
import android.support.v7.view.menu.C0669h;
import android.support.v7.view.menu.C0674i;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class C0648g extends MenuInflater {
    private static final Class<?>[] f1596a = new Class[]{Context.class};
    private static final Class<?>[] f1597b = f1596a;
    private final Object[] f1598c;
    private final Object[] f1599d = this.f1598c;
    private Context f1600e;
    private Object f1601f;

    private static class C0646a implements OnMenuItemClickListener {
        private static final Class<?>[] f1567a = new Class[]{MenuItem.class};
        private Object f1568b;
        private Method f1569c;

        public C0646a(Object obj, String str) {
            this.f1568b = obj;
            Class cls = obj.getClass();
            try {
                this.f1569c = cls.getMethod(str, f1567a);
            } catch (Throwable e) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f1569c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f1569c.invoke(this.f1568b, new Object[]{menuItem})).booleanValue();
                }
                this.f1569c.invoke(this.f1568b, new Object[]{menuItem});
                return true;
            } catch (Throwable e) {
                throw new RuntimeException(e);
            }
        }
    }

    private class C0647b {
        final /* synthetic */ C0648g f1570a;
        private Menu f1571b;
        private int f1572c;
        private int f1573d;
        private int f1574e;
        private int f1575f;
        private boolean f1576g;
        private boolean f1577h;
        private boolean f1578i;
        private int f1579j;
        private int f1580k;
        private CharSequence f1581l;
        private CharSequence f1582m;
        private int f1583n;
        private char f1584o;
        private char f1585p;
        private int f1586q;
        private boolean f1587r;
        private boolean f1588s;
        private boolean f1589t;
        private int f1590u;
        private int f1591v;
        private String f1592w;
        private String f1593x;
        private String f1594y;
        private C0434d f1595z;

        public C0647b(C0648g c0648g, Menu menu) {
            this.f1570a = c0648g;
            this.f1571b = menu;
            m3021a();
        }

        public void m3021a() {
            this.f1572c = 0;
            this.f1573d = 0;
            this.f1574e = 0;
            this.f1575f = 0;
            this.f1576g = true;
            this.f1577h = true;
        }

        public void m3022a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = this.f1570a.f1600e.obtainStyledAttributes(attributeSet, C0563k.MenuGroup);
            this.f1572c = obtainStyledAttributes.getResourceId(C0563k.MenuGroup_android_id, 0);
            this.f1573d = obtainStyledAttributes.getInt(C0563k.MenuGroup_android_menuCategory, 0);
            this.f1574e = obtainStyledAttributes.getInt(C0563k.MenuGroup_android_orderInCategory, 0);
            this.f1575f = obtainStyledAttributes.getInt(C0563k.MenuGroup_android_checkableBehavior, 0);
            this.f1576g = obtainStyledAttributes.getBoolean(C0563k.MenuGroup_android_visible, true);
            this.f1577h = obtainStyledAttributes.getBoolean(C0563k.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void m3024b(AttributeSet attributeSet) {
            boolean z = true;
            TypedArray obtainStyledAttributes = this.f1570a.f1600e.obtainStyledAttributes(attributeSet, C0563k.MenuItem);
            this.f1579j = obtainStyledAttributes.getResourceId(C0563k.MenuItem_android_id, 0);
            this.f1580k = (obtainStyledAttributes.getInt(C0563k.MenuItem_android_menuCategory, this.f1573d) & -65536) | (obtainStyledAttributes.getInt(C0563k.MenuItem_android_orderInCategory, this.f1574e) & 65535);
            this.f1581l = obtainStyledAttributes.getText(C0563k.MenuItem_android_title);
            this.f1582m = obtainStyledAttributes.getText(C0563k.MenuItem_android_titleCondensed);
            this.f1583n = obtainStyledAttributes.getResourceId(C0563k.MenuItem_android_icon, 0);
            this.f1584o = m3017a(obtainStyledAttributes.getString(C0563k.MenuItem_android_alphabeticShortcut));
            this.f1585p = m3017a(obtainStyledAttributes.getString(C0563k.MenuItem_android_numericShortcut));
            if (obtainStyledAttributes.hasValue(C0563k.MenuItem_android_checkable)) {
                this.f1586q = obtainStyledAttributes.getBoolean(C0563k.MenuItem_android_checkable, false) ? 1 : 0;
            } else {
                this.f1586q = this.f1575f;
            }
            this.f1587r = obtainStyledAttributes.getBoolean(C0563k.MenuItem_android_checked, false);
            this.f1588s = obtainStyledAttributes.getBoolean(C0563k.MenuItem_android_visible, this.f1576g);
            this.f1589t = obtainStyledAttributes.getBoolean(C0563k.MenuItem_android_enabled, this.f1577h);
            this.f1590u = obtainStyledAttributes.getInt(C0563k.MenuItem_showAsAction, -1);
            this.f1594y = obtainStyledAttributes.getString(C0563k.MenuItem_android_onClick);
            this.f1591v = obtainStyledAttributes.getResourceId(C0563k.MenuItem_actionLayout, 0);
            this.f1592w = obtainStyledAttributes.getString(C0563k.MenuItem_actionViewClass);
            this.f1593x = obtainStyledAttributes.getString(C0563k.MenuItem_actionProviderClass);
            if (this.f1593x == null) {
                z = false;
            }
            if (z && this.f1591v == 0 && this.f1592w == null) {
                this.f1595z = (C0434d) m3019a(this.f1593x, C0648g.f1597b, this.f1570a.f1599d);
            } else {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f1595z = null;
            }
            obtainStyledAttributes.recycle();
            this.f1578i = false;
        }

        private char m3017a(String str) {
            if (str == null) {
                return '\u0000';
            }
            return str.charAt(0);
        }

        private void m3020a(MenuItem menuItem) {
            boolean z = true;
            menuItem.setChecked(this.f1587r).setVisible(this.f1588s).setEnabled(this.f1589t).setCheckable(this.f1586q >= 1).setTitleCondensed(this.f1582m).setIcon(this.f1583n).setAlphabeticShortcut(this.f1584o).setNumericShortcut(this.f1585p);
            if (this.f1590u >= 0) {
                C0466p.m2110a(menuItem, this.f1590u);
            }
            if (this.f1594y != null) {
                if (this.f1570a.f1600e.isRestricted()) {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
                menuItem.setOnMenuItemClickListener(new C0646a(this.f1570a.m3033c(), this.f1594y));
            }
            if (menuItem instanceof C0669h) {
                C0669h c0669h = (C0669h) menuItem;
            }
            if (this.f1586q >= 2) {
                if (menuItem instanceof C0669h) {
                    ((C0669h) menuItem).m3202a(true);
                } else if (menuItem instanceof C0674i) {
                    ((C0674i) menuItem).m3231a(true);
                }
            }
            if (this.f1592w != null) {
                C0466p.m2108a(menuItem, (View) m3019a(this.f1592w, C0648g.f1596a, this.f1570a.f1598c));
            } else {
                z = false;
            }
            if (this.f1591v > 0) {
                if (z) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                } else {
                    C0466p.m2111b(menuItem, this.f1591v);
                }
            }
            if (this.f1595z != null) {
                C0466p.m2107a(menuItem, this.f1595z);
            }
        }

        public void m3023b() {
            this.f1578i = true;
            m3020a(this.f1571b.add(this.f1572c, this.f1579j, this.f1580k, this.f1581l));
        }

        public SubMenu m3025c() {
            this.f1578i = true;
            SubMenu addSubMenu = this.f1571b.addSubMenu(this.f1572c, this.f1579j, this.f1580k, this.f1581l);
            m3020a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean m3026d() {
            return this.f1578i;
        }

        private <T> T m3019a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor constructor = this.f1570a.f1600e.getClassLoader().loadClass(str).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Throwable e) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e);
                return null;
            }
        }
    }

    public C0648g(Context context) {
        super(context);
        this.f1600e = context;
        this.f1598c = new Object[]{context};
    }

    public void inflate(int i, Menu menu) {
        if (menu instanceof C0232a) {
            XmlResourceParser xmlResourceParser = null;
            try {
                xmlResourceParser = this.f1600e.getResources().getLayout(i);
                m3029a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            } catch (Throwable e) {
                throw new InflateException("Error inflating menu XML", e);
            } catch (Throwable e2) {
                throw new InflateException("Error inflating menu XML", e2);
            } catch (Throwable th) {
                if (xmlResourceParser != null) {
                    xmlResourceParser.close();
                }
            }
        } else {
            super.inflate(i, menu);
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m3029a(org.xmlpull.v1.XmlPullParser r11, android.util.AttributeSet r12, android.view.Menu r13) {
        /*
        r10 = this;
        r4 = 0;
        r1 = 1;
        r6 = 0;
        r7 = new android.support.v7.view.g$b;
        r7.<init>(r10, r13);
        r0 = r11.getEventType();
    L_0x000c:
        r2 = 2;
        if (r0 != r2) goto L_0x004a;
    L_0x000f:
        r0 = r11.getName();
        r2 = "menu";
        r2 = r0.equals(r2);
        if (r2 == 0) goto L_0x0031;
    L_0x001b:
        r0 = r11.next();
    L_0x001f:
        r2 = r4;
        r5 = r6;
        r3 = r0;
        r0 = r6;
    L_0x0023:
        if (r0 != 0) goto L_0x00e1;
    L_0x0025:
        switch(r3) {
            case 1: goto L_0x00d9;
            case 2: goto L_0x0051;
            case 3: goto L_0x0087;
            default: goto L_0x0028;
        };
    L_0x0028:
        r3 = r5;
    L_0x0029:
        r5 = r11.next();
        r9 = r3;
        r3 = r5;
        r5 = r9;
        goto L_0x0023;
    L_0x0031:
        r1 = new java.lang.RuntimeException;
        r2 = new java.lang.StringBuilder;
        r2.<init>();
        r3 = "Expecting menu, got ";
        r2 = r2.append(r3);
        r0 = r2.append(r0);
        r0 = r0.toString();
        r1.<init>(r0);
        throw r1;
    L_0x004a:
        r0 = r11.next();
        if (r0 != r1) goto L_0x000c;
    L_0x0050:
        goto L_0x001f;
    L_0x0051:
        if (r5 == 0) goto L_0x0055;
    L_0x0053:
        r3 = r5;
        goto L_0x0029;
    L_0x0055:
        r3 = r11.getName();
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0066;
    L_0x0061:
        r7.m3022a(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0066:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0073;
    L_0x006e:
        r7.m3024b(r12);
        r3 = r5;
        goto L_0x0029;
    L_0x0073:
        r8 = "menu";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x0084;
    L_0x007b:
        r3 = r7.m3025c();
        r10.m3029a(r11, r12, r3);
        r3 = r5;
        goto L_0x0029;
    L_0x0084:
        r2 = r3;
        r3 = r1;
        goto L_0x0029;
    L_0x0087:
        r3 = r11.getName();
        if (r5 == 0) goto L_0x0096;
    L_0x008d:
        r8 = r3.equals(r2);
        if (r8 == 0) goto L_0x0096;
    L_0x0093:
        r2 = r4;
        r3 = r6;
        goto L_0x0029;
    L_0x0096:
        r8 = "group";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00a3;
    L_0x009e:
        r7.m3021a();
        r3 = r5;
        goto L_0x0029;
    L_0x00a3:
        r8 = "item";
        r8 = r3.equals(r8);
        if (r8 == 0) goto L_0x00cd;
    L_0x00ab:
        r3 = r7.m3026d();
        if (r3 != 0) goto L_0x0028;
    L_0x00b1:
        r3 = r7.f1595z;
        if (r3 == 0) goto L_0x00c7;
    L_0x00b7:
        r3 = r7.f1595z;
        r3 = r3.mo552e();
        if (r3 == 0) goto L_0x00c7;
    L_0x00c1:
        r7.m3025c();
        r3 = r5;
        goto L_0x0029;
    L_0x00c7:
        r7.m3023b();
        r3 = r5;
        goto L_0x0029;
    L_0x00cd:
        r8 = "menu";
        r3 = r3.equals(r8);
        if (r3 == 0) goto L_0x0028;
    L_0x00d5:
        r0 = r1;
        r3 = r5;
        goto L_0x0029;
    L_0x00d9:
        r0 = new java.lang.RuntimeException;
        r1 = "Unexpected end of document";
        r0.<init>(r1);
        throw r0;
    L_0x00e1:
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.view.g.a(org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.view.Menu):void");
    }

    private Object m3033c() {
        if (this.f1601f == null) {
            this.f1601f = m3028a(this.f1600e);
        }
        return this.f1601f;
    }

    private Object m3028a(Object obj) {
        if (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) {
            return m3028a(((ContextWrapper) obj).getBaseContext());
        }
        return obj;
    }
}
