package android.support.v7.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.C0127a;
import android.support.v4.app.C0230y;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.at;
import android.support.v4.app.at.C0175a;
import android.support.v4.view.C0444g;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.widget.ba;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup.LayoutParams;

public class AppCompatActivity extends FragmentActivity implements C0175a, C0565d {
    private C0587e f1267a;
    private int f1268b = 0;
    private boolean f1269c;
    private Resources f1270d;

    protected void onCreate(Bundle bundle) {
        C0587e e = m2585e();
        e.mo460g();
        e.mo444a(bundle);
        if (e.mo439h() && this.f1268b != 0) {
            if (VERSION.SDK_INT >= 23) {
                onApplyThemeResource(getTheme(), this.f1268b, false);
            } else {
                setTheme(this.f1268b);
            }
        }
        super.onCreate(bundle);
    }

    public void setTheme(int i) {
        super.setTheme(i);
        this.f1268b = i;
    }

    protected void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m2585e().mo452b(bundle);
    }

    public C0569a m2579b() {
        return m2585e().mo434a();
    }

    public MenuInflater getMenuInflater() {
        return m2585e().mo436b();
    }

    public void setContentView(int i) {
        m2585e().mo451b(i);
    }

    public void setContentView(View view) {
        m2585e().mo446a(view);
    }

    public void setContentView(View view, LayoutParams layoutParams) {
        m2585e().mo447a(view, layoutParams);
    }

    public void addContentView(View view, LayoutParams layoutParams) {
        m2585e().mo453b(view, layoutParams);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m2585e().mo443a(configuration);
        if (this.f1270d != null) {
            this.f1270d.updateConfiguration(configuration, super.getResources().getDisplayMetrics());
        }
    }

    protected void onStop() {
        super.onStop();
        m2585e().mo456c();
    }

    protected void onPostResume() {
        super.onPostResume();
        m2585e().mo458d();
    }

    public View findViewById(int i) {
        return m2585e().mo441a(i);
    }

    public final boolean onMenuItemSelected(int i, MenuItem menuItem) {
        if (super.onMenuItemSelected(i, menuItem)) {
            return true;
        }
        C0569a b = m2579b();
        if (menuItem.getItemId() != 16908332 || b == null || (b.mo477a() & 4) == 0) {
            return false;
        }
        return m2583c();
    }

    protected void onDestroy() {
        super.onDestroy();
        m2585e().mo438f();
    }

    protected void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m2585e().mo435a(charSequence);
    }

    public void supportInvalidateOptionsMenu() {
        m2585e().mo459e();
    }

    public void invalidateOptionsMenu() {
        m2585e().mo459e();
    }

    public void mo412a(C0628b c0628b) {
    }

    public void mo413b(C0628b c0628b) {
    }

    public C0628b mo411a(C0610a c0610a) {
        return null;
    }

    public void m2576a(at atVar) {
        atVar.m781a((Activity) this);
    }

    public void m2581b(at atVar) {
    }

    public boolean m2583c() {
        Intent a = mo410a();
        if (a == null) {
            return false;
        }
        if (m2578a(a)) {
            at a2 = at.m780a((Context) this);
            m2576a(a2);
            m2581b(a2);
            a2.m784a();
            try {
                C0127a.m586a((Activity) this);
            } catch (IllegalStateException e) {
                finish();
            }
        } else {
            m2580b(a);
        }
        return true;
    }

    public Intent mo410a() {
        return C0230y.m1041a(this);
    }

    public boolean m2578a(Intent intent) {
        return C0230y.m1043a((Activity) this, intent);
    }

    public void m2580b(Intent intent) {
        C0230y.m1046b((Activity) this, intent);
    }

    public void onContentChanged() {
        m2584d();
    }

    @Deprecated
    public void m2584d() {
    }

    public boolean onMenuOpened(int i, Menu menu) {
        return super.onMenuOpened(i, menu);
    }

    public void onPanelClosed(int i, Menu menu) {
        super.onPanelClosed(i, menu);
    }

    protected void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        m2585e().mo437c(bundle);
    }

    public C0587e m2585e() {
        if (this.f1267a == null) {
            this.f1267a = C0587e.m2695a((Activity) this, (C0565d) this);
        }
        return this.f1267a;
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (C0444g.m2058a(keyEvent, 4096) && keyEvent.getUnicodeChar(keyEvent.getMetaState() & -28673) == 60) {
            int action = keyEvent.getAction();
            if (action == 0) {
                C0569a b = m2579b();
                if (b != null && b.mo484b() && b.mo491g()) {
                    this.f1269c = true;
                    return true;
                }
            } else if (action == 1 && this.f1269c) {
                this.f1269c = false;
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    public Resources getResources() {
        if (this.f1270d == null && ba.m3801a()) {
            this.f1270d = new ba(this, super.getResources());
        }
        return this.f1270d == null ? super.getResources() : this.f1270d;
    }
}
