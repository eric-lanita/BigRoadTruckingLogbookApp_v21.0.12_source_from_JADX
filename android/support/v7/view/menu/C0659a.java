package android.support.v7.view.menu;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.content.C0126a;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.view.C0434d;
import android.support.v4.view.C0466p.C0465e;
import android.view.ActionProvider;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;

public class C0659a implements C0233b {
    private final int f1653a;
    private final int f1654b;
    private final int f1655c;
    private final int f1656d;
    private CharSequence f1657e;
    private CharSequence f1658f;
    private Intent f1659g;
    private char f1660h;
    private char f1661i;
    private Drawable f1662j;
    private int f1663k = 0;
    private Context f1664l;
    private OnMenuItemClickListener f1665m;
    private int f1666n = 16;

    public /* synthetic */ MenuItem setActionView(int i) {
        return m3088a(i);
    }

    public /* synthetic */ MenuItem setActionView(View view) {
        return m3091a(view);
    }

    public /* synthetic */ MenuItem setShowAsActionFlags(int i) {
        return m3093b(i);
    }

    public C0659a(Context context, int i, int i2, int i3, int i4, CharSequence charSequence) {
        this.f1664l = context;
        this.f1653a = i2;
        this.f1654b = i;
        this.f1655c = i3;
        this.f1656d = i4;
        this.f1657e = charSequence;
    }

    public char getAlphabeticShortcut() {
        return this.f1661i;
    }

    public int getGroupId() {
        return this.f1654b;
    }

    public Drawable getIcon() {
        return this.f1662j;
    }

    public Intent getIntent() {
        return this.f1659g;
    }

    public int getItemId() {
        return this.f1653a;
    }

    public ContextMenuInfo getMenuInfo() {
        return null;
    }

    public char getNumericShortcut() {
        return this.f1660h;
    }

    public int getOrder() {
        return this.f1656d;
    }

    public SubMenu getSubMenu() {
        return null;
    }

    public CharSequence getTitle() {
        return this.f1657e;
    }

    public CharSequence getTitleCondensed() {
        return this.f1658f != null ? this.f1658f : this.f1657e;
    }

    public boolean hasSubMenu() {
        return false;
    }

    public boolean isCheckable() {
        return (this.f1666n & 1) != 0;
    }

    public boolean isChecked() {
        return (this.f1666n & 2) != 0;
    }

    public boolean isEnabled() {
        return (this.f1666n & 16) != 0;
    }

    public boolean isVisible() {
        return (this.f1666n & 8) == 0;
    }

    public MenuItem setAlphabeticShortcut(char c) {
        this.f1661i = c;
        return this;
    }

    public MenuItem setCheckable(boolean z) {
        this.f1666n = (z ? 1 : 0) | (this.f1666n & -2);
        return this;
    }

    public MenuItem setChecked(boolean z) {
        this.f1666n = (z ? 2 : 0) | (this.f1666n & -3);
        return this;
    }

    public MenuItem setEnabled(boolean z) {
        this.f1666n = (z ? 16 : 0) | (this.f1666n & -17);
        return this;
    }

    public MenuItem setIcon(Drawable drawable) {
        this.f1662j = drawable;
        this.f1663k = 0;
        return this;
    }

    public MenuItem setIcon(int i) {
        this.f1663k = i;
        this.f1662j = C0126a.m582a(this.f1664l, i);
        return this;
    }

    public MenuItem setIntent(Intent intent) {
        this.f1659g = intent;
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        this.f1660h = c;
        return this;
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        this.f1665m = onMenuItemClickListener;
        return this;
    }

    public MenuItem setShortcut(char c, char c2) {
        this.f1660h = c;
        this.f1661i = c2;
        return this;
    }

    public MenuItem setTitle(CharSequence charSequence) {
        this.f1657e = charSequence;
        return this;
    }

    public MenuItem setTitle(int i) {
        this.f1657e = this.f1664l.getResources().getString(i);
        return this;
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f1658f = charSequence;
        return this;
    }

    public MenuItem setVisible(boolean z) {
        this.f1666n = (z ? 0 : 8) | (this.f1666n & 8);
        return this;
    }

    public void setShowAsAction(int i) {
    }

    public C0233b m3091a(View view) {
        throw new UnsupportedOperationException();
    }

    public View getActionView() {
        return null;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    public ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    public C0233b m3088a(int i) {
        throw new UnsupportedOperationException();
    }

    public C0434d mo532a() {
        return null;
    }

    public C0233b mo530a(C0434d c0434d) {
        throw new UnsupportedOperationException();
    }

    public C0233b m3093b(int i) {
        setShowAsAction(i);
        return this;
    }

    public boolean expandActionView() {
        return false;
    }

    public boolean collapseActionView() {
        return false;
    }

    public boolean isActionViewExpanded() {
        return false;
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    public C0233b mo531a(C0465e c0465e) {
        return this;
    }
}
