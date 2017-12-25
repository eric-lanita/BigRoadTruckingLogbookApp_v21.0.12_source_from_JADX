package com.bigroad.ttb.android;

import android.os.Handler;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.location.C2122b;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import java.util.HashSet;
import java.util.Set;

public class ab {
    private static ab f4297a;
    private final Set<C1261a> f4298b = new HashSet();
    private long f4299c = 0;
    private boolean f4300d = this.f4303g.m6312a();
    private final Handler f4301e = new Handler();
    private final C2122b f4302f = OurApplication.m6303y();
    private final PowerStatus f4303g = OurApplication.m6286h();
    private final C2081g f4304h = OurApplication.m6284f();
    private final VehicleConnectionManager f4305i = OurApplication.m6252I();
    private final Runnable f4306j = new C12601(this);

    class C12601 implements Runnable {
        final /* synthetic */ ab f4296a;

        C12601(ab abVar) {
            this.f4296a = abVar;
        }

        public void run() {
            boolean z = true;
            if (this.f4296a.f4303g.m6312a()) {
                this.f4296a.m6639a(true);
            } else if (this.f4296a.f4304h.m10447a()) {
                ap Z = OurApplication.m6269Z();
                if (this.f4296a.f4302f.m10628a() || this.f4296a.f4305i.m11413k()) {
                    this.f4296a.f4299c = Z.mo915c();
                }
                ab abVar = this.f4296a;
                if (Z.mo915c() - this.f4296a.f4299c >= 900000) {
                    z = false;
                }
                abVar.m6639a(z);
            } else {
                this.f4296a.m6639a(false);
            }
            this.f4296a.f4301e.postDelayed(this.f4296a.f4306j, 15000);
        }
    }

    public interface C1261a {
        void mo1270a();
    }

    public static ab m6637a() {
        if (f4297a == null) {
            f4297a = new ab();
        }
        return f4297a;
    }

    private ab() {
        this.f4301e.post(this.f4306j);
    }

    private void m6642c() {
        for (C1261a a : (C1261a[]) this.f4298b.toArray(new C1261a[this.f4298b.size()])) {
            a.mo1270a();
        }
    }

    public void m6647a(C1261a c1261a) {
        this.f4298b.add(c1261a);
    }

    public void m6648b(C1261a c1261a) {
        this.f4298b.remove(c1261a);
    }

    public boolean m6649b() {
        return this.f4300d;
    }

    private void m6639a(boolean z) {
        if (this.f4300d != z) {
            this.f4300d = z;
            m6642c();
        }
    }
}
