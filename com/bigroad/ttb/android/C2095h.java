package com.bigroad.ttb.android;

import android.content.Context;
import android.location.Location;
import com.bigroad.shared.ap;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.FleetMembership;

public class C2095h {
    private static C2095h f7309a;
    private final C2474y f7310b = OurApplication.m6285g();
    private final LocationTracker f7311c = OurApplication.m6302x();
    private final SyncManager f7312d = OurApplication.m6289k();
    private final AuthMonitor f7313e = OurApplication.m6249F();
    private final TruckManager f7314f = OurApplication.m6294p();
    private final ap f7315g = OurApplication.m6269Z();
    private long f7316h = 0;
    private final C1191c f7317i = new C20821(this);
    private final C1185a f7318j = new C20832(this);

    class C20821 extends C1192d {
        final /* synthetic */ C2095h f7284a;

        C20821(C2095h c2095h) {
            this.f7284a = c2095h;
        }

        public void mo880a(Location location) {
            this.f7284a.m10490a(location);
        }
    }

    class C20832 implements C1185a {
        final /* synthetic */ C2095h f7285a;

        C20832(C2095h c2095h) {
            this.f7285a = c2095h;
        }

        public void mo912a(AuthStatus authStatus) {
            if (authStatus == AuthStatus.SIGNED_IN) {
                this.f7285a.m10494b();
            }
        }
    }

    public static C2095h m10489a(Context context) {
        if (f7309a == null) {
            f7309a = new C2095h();
        }
        return f7309a;
    }

    private C2095h() {
        this.f7311c.m10599a(this.f7317i);
        this.f7313e.m6027a(this.f7318j);
        m10494b();
    }

    private boolean m10493a() {
        FleetMembership u = this.f7310b.m12231u();
        if (u == null || u.getIsDriver() || this.f7314f.m6578f() != null) {
            return true;
        }
        return false;
    }

    private void m10490a(Location location) {
        if (location != null && this.f7313e.m6031d() && m10493a()) {
            long time = location.getTime();
            if (time >= this.f7316h + 60000) {
                this.f7316h = time;
                this.f7312d.m6457a(location);
            }
        }
    }

    private void m10494b() {
        long a = this.f7315g.mo913a();
        Location d = this.f7311c.m10604d();
        if (d == null || a - d.getTime() > 3600000) {
            C2134e.m10678c("TT-Breadcrumb", "GPS fix missing or old: using network fix");
            d = this.f7311c.m10603c();
        }
        this.f7316h = 0;
        m10490a(d);
    }
}
