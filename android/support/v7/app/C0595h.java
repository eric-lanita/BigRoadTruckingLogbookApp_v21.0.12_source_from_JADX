package android.support.v7.app;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.C0590f.C0589a;
import android.support.v7.view.C0628b;
import android.support.v7.view.C0628b.C0610a;
import android.support.v7.view.C0645f.C0644a;
import android.view.ActionMode;
import android.view.Window;
import android.view.Window.Callback;

class C0595h extends C0593g {
    private static C0624o f1425r;
    private int f1426s = -100;
    private boolean f1427t;
    private boolean f1428u = true;

    class C0594a extends C0589a {
        final /* synthetic */ C0595h f1424b;

        C0594a(C0595h c0595h, Callback callback) {
            this.f1424b = c0595h;
            super(c0595h, callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (this.f1424b.mo466n()) {
                return m2811a(callback);
            }
            return super.onWindowStartingActionMode(callback);
        }

        final ActionMode m2811a(ActionMode.Callback callback) {
            Object c0644a = new C0644a(this.f1424b.a, callback);
            C0628b b = this.f1424b.m2792b((C0610a) c0644a);
            if (b != null) {
                return c0644a.m3015b(b);
            }
            return null;
        }
    }

    C0595h(Context context, Window window, C0565d c0565d) {
        super(context, window, c0565d);
    }

    public void mo444a(Bundle bundle) {
        super.mo444a(bundle);
        if (bundle != null && this.f1426s == -100) {
            this.f1426s = bundle.getInt("appcompat:local_night_mode", -100);
        }
    }

    Callback mo464a(Callback callback) {
        return new C0594a(this, callback);
    }

    public boolean mo466n() {
        return this.f1428u;
    }

    public boolean mo439h() {
        this.f1427t = true;
        int d = mo465d(this.f1426s == -100 ? C0587e.m2698i() : this.f1426s);
        if (d != -1) {
            return m2812e(d);
        }
        return false;
    }

    int mo465d(int i) {
        switch (i) {
            case -100:
                return -1;
            case 0:
                return m2813s().m2888a() ? 2 : 1;
            default:
                return i;
        }
    }

    public void mo437c(Bundle bundle) {
        super.mo437c(bundle);
        if (this.f1426s != -100) {
            bundle.putInt("appcompat:local_night_mode", this.f1426s);
        }
    }

    private boolean m2812e(int i) {
        Resources resources = this.a.getResources();
        Configuration configuration = resources.getConfiguration();
        int i2 = configuration.uiMode & 48;
        int i3 = i == 2 ? 32 : 16;
        if (i2 == i3) {
            return false;
        }
        Configuration configuration2 = new Configuration(configuration);
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        resources.updateConfiguration(configuration2, null);
        return true;
    }

    private C0624o m2813s() {
        if (f1425r == null) {
            f1425r = new C0624o(this.a.getApplicationContext());
        }
        return f1425r;
    }
}
