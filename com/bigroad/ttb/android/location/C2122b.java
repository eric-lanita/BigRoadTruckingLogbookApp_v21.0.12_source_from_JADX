package com.bigroad.ttb.android.location;

import android.content.Context;
import android.location.Location;
import com.bigroad.shared.ap;
import com.bigroad.shared.as;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.util.C2290j;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.util.HashSet;
import java.util.Set;

public class C2122b {
    private static final long f7415a = Math.max(180000, 180000);
    private static final int f7416b = ((int) (f7415a / 1000));
    private static final float f7417c = as.m4241a(15.0f);
    private static C2122b f7418d;
    private final LocationTracker f7419e = OurApplication.m6302x();
    private final ap f7420f = OurApplication.m6269Z();
    private final Set<C2121a> f7421g = new HashSet();
    private MotionType f7422h;
    private long f7423i;
    private long f7424j;
    private Location f7425k;
    private int f7426l;
    private final C2124c f7427m = new C2124c(f7416b, f7415a, 1000);
    private final C1191c f7428n = new C21201(this);

    class C21201 extends C1192d {
        final /* synthetic */ C2122b f7414a;

        C21201(C2122b c2122b) {
            this.f7414a = c2122b;
        }

        public void mo880a(Location location) {
            if (this.f7414a.m10623a(location)) {
                this.f7414a.m10626d();
            }
        }
    }

    public interface C2121a {
        void mo1261a();
    }

    public static C2122b m10621a(Context context) {
        if (f7418d == null) {
            f7418d = new C2122b();
        }
        return f7418d;
    }

    private C2122b() {
        m10625c();
        this.f7419e.m10599a(this.f7428n);
    }

    private void m10625c() {
        this.f7422h = MotionType.UNKNOWN_MOTION_TYPE;
        this.f7423i = this.f7420f.mo915c();
        this.f7424j = 0;
        this.f7425k = null;
        this.f7426l = 0;
        this.f7427m.m10632a();
    }

    private boolean m10623a(Location location) {
        if (location == null) {
            return false;
        }
        if (this.f7427m.m10634b() || location.getTime() > this.f7427m.m10639g()) {
            this.f7424j = this.f7420f.mo915c();
        }
        this.f7427m.m10641a(location);
        MotionType a = C2290j.m11217a(location);
        if (a == MotionType.UNKNOWN_MOTION_TYPE) {
            return false;
        }
        long c = this.f7420f.mo915c();
        if (this.f7423i > c) {
            this.f7423i = c;
        }
        if (location.getTime() < this.f7423i) {
            return false;
        }
        if (this.f7422h != a) {
            this.f7422h = a;
            this.f7423i = location.getTime();
            this.f7425k = location;
            this.f7426l = 0;
        }
        this.f7426l++;
        return true;
    }

    private void m10626d() {
        for (C2121a a : (C2121a[]) this.f7421g.toArray(new C2121a[this.f7421g.size()])) {
            a.mo1261a();
        }
    }

    public void m10627a(C2121a c2121a) {
        this.f7421g.add(c2121a);
    }

    public boolean m10628a() {
        if (this.f7426l < 5 || this.f7422h != MotionType.MOVING) {
            return false;
        }
        long c = this.f7420f.mo915c();
        if (this.f7424j == 0 || c - this.f7424j > 120000) {
            return false;
        }
        if (c - this.f7423i >= 180000) {
            return true;
        }
        if (this.f7427m.m10635c() < 5) {
            return false;
        }
        Location location = (Location) this.f7427m.m10636d();
        Location location2 = (Location) this.f7427m.m10638f();
        long time = location2.getTime() - location.getTime();
        if (time < 162000) {
            return false;
        }
        float distanceTo = location.distanceTo(location2);
        if (distanceTo < 600.0f) {
            return false;
        }
        return ((double) distanceTo) / (((double) time) / 1000.0d) >= ((double) f7417c);
    }

    public boolean m10629b() {
        if (this.f7422h != MotionType.STOPPED) {
            return false;
        }
        if (this.f7420f.mo915c() - this.f7423i < 180000) {
            return false;
        }
        if (this.f7427m.m10635c() < 2) {
            return false;
        }
        Location location = (Location) this.f7427m.m10636d();
        Location location2 = (Location) this.f7427m.m10638f();
        if (location2.getTime() - this.f7425k.getTime() >= 180000 && this.f7425k.distanceTo(location2) <= BitmapDescriptorFactory.HUE_MAGENTA) {
            return true;
        }
        if (location2.getTime() - location.getTime() < 162000 || location.distanceTo(location2) > BitmapDescriptorFactory.HUE_MAGENTA) {
            return false;
        }
        return true;
    }
}
