package android.support.v7.view.menu;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v4.p004b.p005a.C0233b;
import android.support.v4.view.C0434d;
import android.support.v4.view.C0466p.C0465e;
import android.support.v7.view.C0641c;
import android.util.Log;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.MenuItem;
import android.view.MenuItem.OnActionExpandListener;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.SubMenu;
import android.view.View;
import android.widget.FrameLayout;
import java.lang.reflect.Method;

@TargetApi(14)
public class C0674i extends C0663c<C0233b> implements MenuItem {
    private Method f1753c;

    class C0670a extends C0434d {
        final ActionProvider f1748a;
        final /* synthetic */ C0674i f1749b;

        public C0670a(C0674i c0674i, Context context, ActionProvider actionProvider) {
            this.f1749b = c0674i;
            super(context);
            this.f1748a = actionProvider;
        }

        public View mo549a() {
            return this.f1748a.onCreateActionView();
        }

        public boolean mo551d() {
            return this.f1748a.onPerformDefaultAction();
        }

        public boolean mo552e() {
            return this.f1748a.hasSubMenu();
        }

        public void mo550a(SubMenu subMenu) {
            this.f1748a.onPrepareSubMenu(this.f1749b.m3119a(subMenu));
        }
    }

    static class C0671b extends FrameLayout implements C0641c {
        final CollapsibleActionView f1750a;

        C0671b(View view) {
            super(view.getContext());
            this.f1750a = (CollapsibleActionView) view;
            addView(view);
        }

        public void mo553a() {
            this.f1750a.onActionViewExpanded();
        }

        public void mo554b() {
            this.f1750a.onActionViewCollapsed();
        }

        View m3227c() {
            return (View) this.f1750a;
        }
    }

    private class C0672c extends C0662d<OnActionExpandListener> implements C0465e {
        final /* synthetic */ C0674i f1751a;

        C0672c(C0674i c0674i, OnActionExpandListener onActionExpandListener) {
            this.f1751a = c0674i;
            super(onActionExpandListener);
        }

        public boolean mo555a(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionExpand(this.f1751a.m3118a(menuItem));
        }

        public boolean mo556b(MenuItem menuItem) {
            return ((OnActionExpandListener) this.b).onMenuItemActionCollapse(this.f1751a.m3118a(menuItem));
        }
    }

    private class C0673d extends C0662d<OnMenuItemClickListener> implements OnMenuItemClickListener {
        final /* synthetic */ C0674i f1752a;

        C0673d(C0674i c0674i, OnMenuItemClickListener onMenuItemClickListener) {
            this.f1752a = c0674i;
            super(onMenuItemClickListener);
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            return ((OnMenuItemClickListener) this.b).onMenuItemClick(this.f1752a.m3118a(menuItem));
        }
    }

    C0674i(Context context, C0233b c0233b) {
        super(context, c0233b);
    }

    public int getItemId() {
        return ((C0233b) this.b).getItemId();
    }

    public int getGroupId() {
        return ((C0233b) this.b).getGroupId();
    }

    public int getOrder() {
        return ((C0233b) this.b).getOrder();
    }

    public MenuItem setTitle(CharSequence charSequence) {
        ((C0233b) this.b).setTitle(charSequence);
        return this;
    }

    public MenuItem setTitle(int i) {
        ((C0233b) this.b).setTitle(i);
        return this;
    }

    public CharSequence getTitle() {
        return ((C0233b) this.b).getTitle();
    }

    public MenuItem setTitleCondensed(CharSequence charSequence) {
        ((C0233b) this.b).setTitleCondensed(charSequence);
        return this;
    }

    public CharSequence getTitleCondensed() {
        return ((C0233b) this.b).getTitleCondensed();
    }

    public MenuItem setIcon(Drawable drawable) {
        ((C0233b) this.b).setIcon(drawable);
        return this;
    }

    public MenuItem setIcon(int i) {
        ((C0233b) this.b).setIcon(i);
        return this;
    }

    public Drawable getIcon() {
        return ((C0233b) this.b).getIcon();
    }

    public MenuItem setIntent(Intent intent) {
        ((C0233b) this.b).setIntent(intent);
        return this;
    }

    public Intent getIntent() {
        return ((C0233b) this.b).getIntent();
    }

    public MenuItem setShortcut(char c, char c2) {
        ((C0233b) this.b).setShortcut(c, c2);
        return this;
    }

    public MenuItem setNumericShortcut(char c) {
        ((C0233b) this.b).setNumericShortcut(c);
        return this;
    }

    public char getNumericShortcut() {
        return ((C0233b) this.b).getNumericShortcut();
    }

    public MenuItem setAlphabeticShortcut(char c) {
        ((C0233b) this.b).setAlphabeticShortcut(c);
        return this;
    }

    public char getAlphabeticShortcut() {
        return ((C0233b) this.b).getAlphabeticShortcut();
    }

    public MenuItem setCheckable(boolean z) {
        ((C0233b) this.b).setCheckable(z);
        return this;
    }

    public boolean isCheckable() {
        return ((C0233b) this.b).isCheckable();
    }

    public MenuItem setChecked(boolean z) {
        ((C0233b) this.b).setChecked(z);
        return this;
    }

    public boolean isChecked() {
        return ((C0233b) this.b).isChecked();
    }

    public MenuItem setVisible(boolean z) {
        return ((C0233b) this.b).setVisible(z);
    }

    public boolean isVisible() {
        return ((C0233b) this.b).isVisible();
    }

    public MenuItem setEnabled(boolean z) {
        ((C0233b) this.b).setEnabled(z);
        return this;
    }

    public boolean isEnabled() {
        return ((C0233b) this.b).isEnabled();
    }

    public boolean hasSubMenu() {
        return ((C0233b) this.b).hasSubMenu();
    }

    public SubMenu getSubMenu() {
        return m3119a(((C0233b) this.b).getSubMenu());
    }

    public MenuItem setOnMenuItemClickListener(OnMenuItemClickListener onMenuItemClickListener) {
        ((C0233b) this.b).setOnMenuItemClickListener(onMenuItemClickListener != null ? new C0673d(this, onMenuItemClickListener) : null);
        return this;
    }

    public ContextMenuInfo getMenuInfo() {
        return ((C0233b) this.b).getMenuInfo();
    }

    public void setShowAsAction(int i) {
        ((C0233b) this.b).setShowAsAction(i);
    }

    public MenuItem setShowAsActionFlags(int i) {
        ((C0233b) this.b).setShowAsActionFlags(i);
        return this;
    }

    public MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new C0671b(view);
        }
        ((C0233b) this.b).setActionView(view);
        return this;
    }

    public MenuItem setActionView(int i) {
        ((C0233b) this.b).setActionView(i);
        View actionView = ((C0233b) this.b).getActionView();
        if (actionView instanceof CollapsibleActionView) {
            ((C0233b) this.b).setActionView(new C0671b(actionView));
        }
        return this;
    }

    public View getActionView() {
        View actionView = ((C0233b) this.b).getActionView();
        if (actionView instanceof C0671b) {
            return ((C0671b) actionView).m3227c();
        }
        return actionView;
    }

    public MenuItem setActionProvider(ActionProvider actionProvider) {
        ((C0233b) this.b).mo530a(actionProvider != null ? mo561a(actionProvider) : null);
        return this;
    }

    public ActionProvider getActionProvider() {
        C0434d a = ((C0233b) this.b).mo532a();
        if (a instanceof C0670a) {
            return ((C0670a) a).f1748a;
        }
        return null;
    }

    public boolean expandActionView() {
        return ((C0233b) this.b).expandActionView();
    }

    public boolean collapseActionView() {
        return ((C0233b) this.b).collapseActionView();
    }

    public boolean isActionViewExpanded() {
        return ((C0233b) this.b).isActionViewExpanded();
    }

    public MenuItem setOnActionExpandListener(OnActionExpandListener onActionExpandListener) {
        ((C0233b) this.b).mo531a(onActionExpandListener != null ? new C0672c(this, onActionExpandListener) : null);
        return this;
    }

    public void m3231a(boolean z) {
        try {
            if (this.f1753c == null) {
                this.f1753c = ((C0233b) this.b).getClass().getDeclaredMethod("setExclusiveCheckable", new Class[]{Boolean.TYPE});
            }
            this.f1753c.invoke(this.b, new Object[]{Boolean.valueOf(z)});
        } catch (Throwable e) {
            Log.w("MenuItemWrapper", "Error while calling setExclusiveCheckable", e);
        }
    }

    C0670a mo561a(ActionProvider actionProvider) {
        return new C0670a(this, this.a, actionProvider);
    }
}
