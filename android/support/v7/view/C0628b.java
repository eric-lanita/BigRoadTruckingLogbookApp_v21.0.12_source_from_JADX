package android.support.v7.view;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public abstract class C0628b {
    private Object f1506a;
    private boolean f1507b;

    public interface C0610a {
        void mo473a(C0628b c0628b);

        boolean mo474a(C0628b c0628b, Menu menu);

        boolean mo475a(C0628b c0628b, MenuItem menuItem);

        boolean mo476b(C0628b c0628b, Menu menu);
    }

    public abstract MenuInflater mo494a();

    public abstract void mo495a(int i);

    public abstract void mo496a(View view);

    public abstract void mo497a(CharSequence charSequence);

    public abstract Menu mo499b();

    public abstract void mo500b(int i);

    public abstract void mo501b(CharSequence charSequence);

    public abstract void mo502c();

    public abstract void mo503d();

    public abstract CharSequence mo504f();

    public abstract CharSequence mo505g();

    public abstract View mo507i();

    public void m2896a(Object obj) {
        this.f1506a = obj;
    }

    public Object m2907j() {
        return this.f1506a;
    }

    public void mo498a(boolean z) {
        this.f1507b = z;
    }

    public boolean m2908k() {
        return this.f1507b;
    }

    public boolean mo506h() {
        return false;
    }
}
