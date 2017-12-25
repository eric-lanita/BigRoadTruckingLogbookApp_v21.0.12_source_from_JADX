package android.support.v4.view;

import android.content.Context;
import android.util.Log;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

public abstract class C0434d {
    private final Context f1039a;
    private C0432a f1040b;
    private C0433b f1041c;

    public interface C0432a {
        void mo670a(boolean z);
    }

    public interface C0433b {
        void mo548a(boolean z);
    }

    public abstract View mo549a();

    public C0434d(Context context) {
        this.f1039a = context;
    }

    public View mo557a(MenuItem menuItem) {
        return mo549a();
    }

    public boolean mo559b() {
        return false;
    }

    public boolean mo560c() {
        return true;
    }

    public boolean mo551d() {
        return false;
    }

    public boolean mo552e() {
        return false;
    }

    public void mo550a(SubMenu subMenu) {
    }

    public void m2037a(boolean z) {
        if (this.f1040b != null) {
            this.f1040b.mo670a(z);
        }
    }

    public void m2034a(C0432a c0432a) {
        this.f1040b = c0432a;
    }

    public void mo558a(C0433b c0433b) {
        if (!(this.f1041c == null || c0433b == null)) {
            Log.w("ActionProvider(support)", "setVisibilityListener: Setting a new ActionProvider.VisibilityListener when one is already set. Are you reusing this " + getClass().getSimpleName() + " instance while it is still in use somewhere else?");
        }
        this.f1041c = c0433b;
    }

    public void m2042f() {
        this.f1041c = null;
        this.f1040b = null;
    }
}
