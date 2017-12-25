package com.bigroad.ttb.android;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bigroad.ttb.android.ab.C1261a;

public class C2272u {
    private final Activity f7893a;
    private View f7894b;
    private final C1261a f7895c = new C22711(this);

    class C22711 implements C1261a {
        final /* synthetic */ C2272u f7892a;

        C22711(C2272u c2272u) {
            this.f7892a = c2272u;
        }

        public void mo1270a() {
            this.f7892a.m11135d();
        }
    }

    private void m11135d() {
        if (this.f7894b != null) {
            this.f7894b.setKeepScreenOn(OurApplication.m6263T().m6649b());
        }
    }

    public C2272u(Activity activity) {
        this.f7893a = activity;
    }

    public void m11136a() {
        OurApplication.m6263T().m6647a(this.f7895c);
    }

    public void m11137b() {
        OurApplication.m6263T().m6648b(this.f7895c);
    }

    public void m11138c() {
        if (this.f7894b == null) {
            this.f7894b = ((ViewGroup) this.f7893a.findViewById(16908290)).getChildAt(0);
        }
        m11135d();
    }
}
