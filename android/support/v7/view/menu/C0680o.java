package android.support.v7.view.menu;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.v4.p004b.p005a.C0232a;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;

class C0680o extends C0663c<C0232a> implements Menu {
    C0680o(Context context, C0232a c0232a) {
        super(context, c0232a);
    }

    public MenuItem add(CharSequence charSequence) {
        return m3118a(((C0232a) this.b).add(charSequence));
    }

    public MenuItem add(int i) {
        return m3118a(((C0232a) this.b).add(i));
    }

    public MenuItem add(int i, int i2, int i3, CharSequence charSequence) {
        return m3118a(((C0232a) this.b).add(i, i2, i3, charSequence));
    }

    public MenuItem add(int i, int i2, int i3, int i4) {
        return m3118a(((C0232a) this.b).add(i, i2, i3, i4));
    }

    public SubMenu addSubMenu(CharSequence charSequence) {
        return m3119a(((C0232a) this.b).addSubMenu(charSequence));
    }

    public SubMenu addSubMenu(int i) {
        return m3119a(((C0232a) this.b).addSubMenu(i));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        return m3119a(((C0232a) this.b).addSubMenu(i, i2, i3, charSequence));
    }

    public SubMenu addSubMenu(int i, int i2, int i3, int i4) {
        return m3119a(((C0232a) this.b).addSubMenu(i, i2, i3, i4));
    }

    public int addIntentOptions(int i, int i2, int i3, ComponentName componentName, Intent[] intentArr, Intent intent, int i4, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = null;
        if (menuItemArr != null) {
            menuItemArr2 = new MenuItem[menuItemArr.length];
        }
        int addIntentOptions = ((C0232a) this.b).addIntentOptions(i, i2, i3, componentName, intentArr, intent, i4, menuItemArr2);
        if (menuItemArr2 != null) {
            int length = menuItemArr2.length;
            for (int i5 = 0; i5 < length; i5++) {
                menuItemArr[i5] = m3118a(menuItemArr2[i5]);
            }
        }
        return addIntentOptions;
    }

    public void removeItem(int i) {
        m3122b(i);
        ((C0232a) this.b).removeItem(i);
    }

    public void removeGroup(int i) {
        m3121a(i);
        ((C0232a) this.b).removeGroup(i);
    }

    public void clear() {
        m3120a();
        ((C0232a) this.b).clear();
    }

    public void setGroupCheckable(int i, boolean z, boolean z2) {
        ((C0232a) this.b).setGroupCheckable(i, z, z2);
    }

    public void setGroupVisible(int i, boolean z) {
        ((C0232a) this.b).setGroupVisible(i, z);
    }

    public void setGroupEnabled(int i, boolean z) {
        ((C0232a) this.b).setGroupEnabled(i, z);
    }

    public boolean hasVisibleItems() {
        return ((C0232a) this.b).hasVisibleItems();
    }

    public MenuItem findItem(int i) {
        return m3118a(((C0232a) this.b).findItem(i));
    }

    public int size() {
        return ((C0232a) this.b).size();
    }

    public MenuItem getItem(int i) {
        return m3118a(((C0232a) this.b).getItem(i));
    }

    public void close() {
        ((C0232a) this.b).close();
    }

    public boolean performShortcut(int i, KeyEvent keyEvent, int i2) {
        return ((C0232a) this.b).performShortcut(i, keyEvent, i2);
    }

    public boolean isShortcutKey(int i, KeyEvent keyEvent) {
        return ((C0232a) this.b).isShortcutKey(i, keyEvent);
    }

    public boolean performIdentifierAction(int i, int i2) {
        return ((C0232a) this.b).performIdentifierAction(i, i2);
    }

    public void setQwertyMode(boolean z) {
        ((C0232a) this.b).setQwertyMode(z);
    }
}
