package com.bigroad.ttb.android.location;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import com.bigroad.shared.ap;
import com.bigroad.shared.as;
import com.bigroad.shared.eobr.EobrType;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.AuthMonitor.AuthStatus;
import com.bigroad.ttb.android.AuthMonitor.C1185a;
import com.bigroad.ttb.android.C2081g;
import com.bigroad.ttb.android.C2081g.C1230a;
import com.bigroad.ttb.android.C2081g.C1231b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.PowerStatus;
import com.bigroad.ttb.android.PowerStatus.C1216a;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.EobrDevice.ConnectionState;
import com.bigroad.ttb.android.location.C2119a.C1285a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.Permission;
import com.bigroad.ttb.android.vehicle.C2338a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.C1201a;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager.ChangeListener;
import com.bigroad.ttb.protocol.TTProtocol.Geocode;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.GroundOverlayOptions;
import com.google.common.collect.EvictingQueue;
import com.google.common.primitives.C3608c;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class LocationTracker {
    private static LocationTracker f7374E;
    private static final String[] f7375g = new String[]{"gps", "passive", "network"};
    private static final double f7376h = as.m4240a(20.0d);
    private Context f7377A;
    private long f7378B = -1;
    private long f7379C = -1;
    private boolean f7380D = true;
    private final C1285a f7381F = new C21138(this);
    private final LocationListener f7382a = new C21061(this);
    private final C1216a f7383b = new C21072(this);
    private final C1230a f7384c = new C21083(this);
    private final ChangeListener f7385d = new C21094(this);
    private final C1185a f7386e = new C21105(this);
    private final Runnable f7387f = new C21116(this);
    private final Handler f7388i = new Handler();
    private VehicleConnectionManager f7389j;
    private final C2081g f7390k;
    private final AuthMonitor f7391l;
    private final LocationManager f7392m;
    private final PowerStatus f7393n;
    private final ap f7394o;
    private final Set<Object> f7395p = new HashSet();
    private final Set<C1191c> f7396q = new HashSet();
    private final EvictingQueue<Float> f7397r = EvictingQueue.m18488a(5);
    private long f7398s = 0;
    private long f7399t = -1;
    private float f7400u = GroundOverlayOptions.NO_DIMENSION;
    private PollingStatus f7401v = PollingStatus.UNKNOWN;
    private C2115a f7402w = new C2117e();
    private C2115a f7403x = new C2116b();
    private Geocode f7404y = null;
    private Location f7405z = null;

    public interface C1191c {
        void mo879a();

        void mo880a(Location location);

        void mo881b(Location location);
    }

    public static class C1192d implements C1191c {
        public void mo880a(Location location) {
        }

        public void mo881b(Location location) {
        }

        public void mo879a() {
        }
    }

    class C21061 implements LocationListener {
        final /* synthetic */ LocationTracker f7354a;

        C21061(LocationTracker locationTracker) {
            this.f7354a = locationTracker;
        }

        private String m10561a(int i) {
            switch (i) {
                case 0:
                    return "OUT_OF_SERVICE";
                case 1:
                    return "TEMPORARILY_UNAVAILABLE";
                case 2:
                    return "AVAILABLE";
                default:
                    return Integer.toString(i);
            }
        }

        public void onLocationChanged(Location location) {
            this.f7354a.m10577a(location);
        }

        public void onProviderDisabled(String str) {
            this.f7354a.m10582a(str);
        }

        public void onProviderEnabled(String str) {
            this.f7354a.m10582a(str);
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
            int i2 = bundle.getInt("satellites", -1);
            C2134e.m10673a("TT-LocTracker", str + " status changed to " + m10561a(i) + (i2 >= 0 ? " (" + i2 + " satellites)" : ""));
        }
    }

    class C21072 implements C1216a {
        final /* synthetic */ LocationTracker f7355a;

        C21072(LocationTracker locationTracker) {
            this.f7355a = locationTracker;
        }

        public void mo908a(PowerStatus powerStatus) {
            this.f7355a.m10601b();
        }
    }

    class C21083 extends C1231b {
        final /* synthetic */ LocationTracker f7356a;

        C21083(LocationTracker locationTracker) {
            this.f7356a = locationTracker;
        }

        public void mo906a(C2081g c2081g) {
            this.f7356a.m10601b();
        }
    }

    class C21094 extends C1201a {
        final /* synthetic */ LocationTracker f7357a;

        C21094(LocationTracker locationTracker) {
            this.f7357a = locationTracker;
        }

        public void mo888a(C2338a c2338a) {
            this.f7357a.m10601b();
        }
    }

    class C21105 implements C1185a {
        final /* synthetic */ LocationTracker f7358a;

        C21105(LocationTracker locationTracker) {
            this.f7358a = locationTracker;
        }

        public void mo912a(AuthStatus authStatus) {
            this.f7358a.m10601b();
        }
    }

    class C21116 implements Runnable {
        final /* synthetic */ LocationTracker f7359a;

        C21116(LocationTracker locationTracker) {
            this.f7359a = locationTracker;
        }

        public void run() {
            C2134e.m10676b("TT-LocTracker", "Wait for Gps fixes from Turbo timed out, re-enabling Android GPS");
            this.f7359a.f7397r.clear();
            this.f7359a.f7380D = true;
            this.f7359a.m10601b();
        }
    }

    class C21127 implements Runnable {
        final /* synthetic */ LocationTracker f7360a;

        C21127(LocationTracker locationTracker) {
            this.f7360a = locationTracker;
        }

        public void run() {
            this.f7360a.f7389j = OurApplication.m6252I();
            this.f7360a.f7389j.m11399a(this.f7360a.f7385d);
        }
    }

    class C21138 implements C1285a {
        final /* synthetic */ LocationTracker f7361a;

        C21138(LocationTracker locationTracker) {
            this.f7361a = locationTracker;
        }

        public void mo936a(C2119a c2119a) {
            this.f7361a.m10581a(c2119a, c2119a.m10615a(this.f7361a.f7405z));
        }
    }

    private enum PollingStatus {
        ACTIVE,
        PASSIVE,
        NOT_POLLING,
        UNKNOWN
    }

    public enum ProviderStatus {
        NOT_FOUND,
        DISABLED,
        ENABLED
    }

    private static abstract class C2115a {
        protected Location f7373a;

        private C2115a() {
        }

        protected static boolean m10567a(Location location) {
            if (location == null) {
                return false;
            }
            if ("gps".equals(location.getProvider()) || "turbo_gps".equals(location.getProvider())) {
                return true;
            }
            return false;
        }

        protected boolean mo1233a(Location location, Location location2) {
            if (location == null) {
                return false;
            }
            if (location2 == null) {
                return true;
            }
            long time = location.getTime() - location2.getTime();
            if (time < 0) {
                return false;
            }
            if (!location2.hasAccuracy()) {
                return true;
            }
            if (location.hasAccuracy() && location.getAccuracy() < BitmapDescriptorFactory.HUE_ORANGE) {
                return true;
            }
            if ((!location.hasAccuracy() || ((double) location.getAccuracy()) > 1.1d * ((double) location2.getAccuracy())) && time <= 60000) {
                return false;
            }
            return true;
        }

        public boolean m10571b(Location location) {
            if (!mo1233a(location, this.f7373a)) {
                return false;
            }
            this.f7373a = location;
            return true;
        }

        public Location m10568a() {
            return this.f7373a;
        }

        public void m10570b() {
            this.f7373a = null;
        }
    }

    private static class C2116b extends C2115a {
        private C2116b() {
            super();
        }

        protected boolean mo1233a(Location location, Location location2) {
            if (location == null) {
                return false;
            }
            if (location2 == null) {
                return true;
            }
            long time = location.getTime() - location2.getTime();
            if (time < 0) {
                return false;
            }
            if (!C2115a.m10567a(location2)) {
                return true;
            }
            if (C2115a.m10567a(location)) {
                return super.mo1233a(location, location2);
            }
            if (time <= 300000) {
                return false;
            }
            return true;
        }
    }

    private static class C2117e extends C2115a {
        private C2117e() {
            super();
        }

        protected boolean mo1233a(Location location, Location location2) {
            boolean z = true;
            if (!C2115a.m10567a(location) || !super.mo1233a(location, location2)) {
                return false;
            }
            if (location2 == null || ((double) location.getSpeed()) <= LocationTracker.f7376h) {
                return true;
            }
            if ((((double) (location.getTime() - location2.getTime())) / 1000.0d) * ((double) location.getSpeed()) > ((double) ((location2.distanceTo(location) + location2.getAccuracy()) + location.getAccuracy())) * 5.0d) {
                z = false;
            }
            return z;
        }
    }

    public static LocationTracker m10574a(Context context) {
        if (f7374E == null) {
            f7374E = new LocationTracker(context);
        }
        return f7374E;
    }

    private LocationTracker(Context context) {
        this.f7377A = context.getApplicationContext();
        this.f7392m = (LocationManager) this.f7377A.getSystemService("location");
        this.f7393n = OurApplication.m6286h();
        this.f7393n.m6311a(this.f7383b);
        this.f7390k = OurApplication.m6284f();
        this.f7390k.m10446a(this.f7384c);
        this.f7391l = OurApplication.m6249F();
        this.f7391l.m6027a(this.f7386e);
        this.f7394o = OurApplication.m6269Z();
        this.f7388i.post(new C21127(this));
        m10601b();
    }

    private void m10581a(C2119a c2119a, Geocode geocode) {
        if (geocode != null) {
            c2119a.m10618b(this.f7381F);
            this.f7404y = geocode;
            this.f7398s = System.currentTimeMillis();
        }
    }

    private void m10582a(String str) {
        if ("gps".equals(str)) {
            m10594l();
        }
    }

    private void m10577a(Location location) {
        if (location != null) {
            if (!this.f7380D || !"turbo_gps".equals(location.getProvider())) {
                if (this.f7380D || "turbo_gps".equals(location.getProvider())) {
                    if (this.f7402w.m10571b(location)) {
                        m10592j();
                    }
                    if (this.f7403x.m10571b(location)) {
                        m10593k();
                    }
                    m10586b(location);
                }
            }
        }
    }

    private void m10586b(Location location) {
        if (location != null && System.currentTimeMillis() - this.f7398s > 300000 && "turbo_gps".equals(location.getProvider())) {
            C2119a m = OurApplication.m6291m();
            this.f7405z = new Location(location);
            m.m10616a(this.f7381F);
            m10581a(m, m.m10615a(this.f7405z));
        }
    }

    public Geocode m10597a() {
        return this.f7404y;
    }

    private void m10590h() {
        if (this.f7402w.m10568a() != null) {
            this.f7402w.m10570b();
            m10592j();
        }
        if (this.f7403x.m10568a() != null) {
            this.f7403x.m10570b();
            m10593k();
        }
        this.f7397r.clear();
    }

    private void m10591i() {
        if (Permission.LOCATION.m11151a(this.f7377A)) {
            for (String str : f7375g) {
                if (this.f7392m.getProvider(str) != null) {
                    final Location lastKnownLocation = this.f7392m.getLastKnownLocation(str);
                    this.f7388i.post(new Runnable(this) {
                        final /* synthetic */ LocationTracker f7363b;

                        public void run() {
                            this.f7363b.m10577a(lastKnownLocation);
                        }
                    });
                }
            }
        }
    }

    public void m10599a(C1191c c1191c) {
        for (C1191c c1191c2 : this.f7396q) {
            if (c1191c2.getClass() == c1191c.getClass() && !this.f7396q.contains(c1191c)) {
                C2134e.m10680d("TT-LocTracker", "Registering multiple listeners of class " + c1191c.getClass().getName());
            }
        }
        this.f7396q.add(c1191c);
    }

    public void m10602b(C1191c c1191c) {
        this.f7396q.remove(c1191c);
    }

    private void m10592j() {
        for (C1191c a : (C1191c[]) this.f7396q.toArray(new C1191c[this.f7396q.size()])) {
            a.mo880a(this.f7402w.m10568a());
        }
    }

    private void m10593k() {
        for (C1191c b : (C1191c[]) this.f7396q.toArray(new C1191c[this.f7396q.size()])) {
            b.mo881b(this.f7403x.m10568a());
        }
    }

    private void m10594l() {
        for (C1191c a : (C1191c[]) this.f7396q.toArray(new C1191c[this.f7396q.size()])) {
            a.mo879a();
        }
    }

    public void m10600a(Object obj, boolean z) {
        if (z) {
            this.f7395p.add(obj);
        } else {
            this.f7395p.remove(obj);
        }
        m10601b();
    }

    private boolean m10595m() {
        return !this.f7395p.isEmpty();
    }

    public void m10601b() {
        if (Permission.LOCATION.m11151a(this.f7377A)) {
            long j;
            float f;
            int i;
            PollingStatus pollingStatus;
            float c = this.f7393n.m6315c();
            PollingStatus pollingStatus2;
            if (this.f7391l.m6030c()) {
                pollingStatus2 = PollingStatus.NOT_POLLING;
                j = -1;
                f = GroundOverlayOptions.NO_DIMENSION;
                i = 0;
                pollingStatus = pollingStatus2;
            } else if (m10595m()) {
                j = 1000;
                f = 0.0f;
                i = 1;
                pollingStatus = PollingStatus.ACTIVE;
            } else if (this.f7393n.m6312a() || this.f7390k.m10447a()) {
                j = 60000;
                f = 0.0f;
                i = 60;
                pollingStatus = PollingStatus.ACTIVE;
            } else if (((double) c) > 0.65d) {
                j = 300000;
                f = 0.0f;
                i = 60;
                pollingStatus = PollingStatus.ACTIVE;
            } else if (((double) c) > 0.35d) {
                j = 3600000;
                f = 0.0f;
                i = 60;
                pollingStatus = PollingStatus.ACTIVE;
            } else {
                pollingStatus2 = PollingStatus.PASSIVE;
                j = -1;
                f = GroundOverlayOptions.NO_DIMENSION;
                i = 60;
                pollingStatus = pollingStatus2;
            }
            Object obj = this.f7401v != pollingStatus ? 1 : null;
            Object obj2 = (pollingStatus != PollingStatus.ACTIVE || (this.f7399t == j && this.f7400u == f)) ? null : 1;
            if ((this.f7378B != ((long) i) ? 1 : null) != null && m10583a(i)) {
                C2134e.m10676b("TT-LocTracker", "Requesting GPS fixes from Turbo, interval=" + i + " second(s)");
                this.f7379C = (((long) i) * 1000) + 10000;
                this.f7388i.removeCallbacks(this.f7387f);
                this.f7388i.postDelayed(this.f7387f, this.f7379C);
                this.f7378B = (long) i;
            }
            EobrDevice eobrDevice = null;
            if (this.f7389j != null) {
                eobrDevice = this.f7389j.m11412j();
            }
            if (eobrDevice == null || eobrDevice.m8997i() != ConnectionState.CONNECTED) {
                if (!this.f7380D) {
                    C2134e.m10676b("TT-LocTracker", "No active connection to Turbo, re-enabling Android GPS");
                    this.f7388i.removeCallbacks(this.f7387f);
                    m10590h();
                    this.f7380D = true;
                }
                this.f7378B = -1;
            }
            if (!this.f7380D) {
                return;
            }
            if (obj != null || obj2 != null) {
                this.f7392m.removeUpdates(this.f7382a);
                if (pollingStatus == PollingStatus.ACTIVE) {
                    C2134e.m10676b("TT-LocTracker", "Enabling Android location tracking: interval=" + j + " milliseconds, distance=" + f);
                    for (String str : f7375g) {
                        if (this.f7392m.getProvider(str) == null) {
                            C2134e.m10680d("TT-LocTracker", "Location provider is null (" + str + ")");
                        } else {
                            this.f7392m.requestLocationUpdates(str, j, f, this.f7382a);
                        }
                    }
                } else if (pollingStatus == PollingStatus.PASSIVE) {
                    C2134e.m10676b("TT-LocTracker", "Android passive location tracking");
                    this.f7392m.requestLocationUpdates("passive", 1000, 0.0f, this.f7382a);
                } else {
                    C2134e.m10676b("TT-LocTracker", "Android location tracking disabled");
                }
                this.f7401v = pollingStatus;
                this.f7399t = j;
                this.f7400u = f;
                if (pollingStatus != PollingStatus.NOT_POLLING) {
                    m10591i();
                }
            }
        }
    }

    private boolean m10583a(int i) {
        if (this.f7389j == null) {
            return false;
        }
        EobrDevice j = this.f7389j.m11412j();
        if (j == null || j.mo1121o() != EobrType.TURBO || j.m8997i() != ConnectionState.CONNECTED) {
            return false;
        }
        j.m8981a(i);
        return true;
    }

    public void m10598a(C1051n c1051n, EobrDevice eobrDevice) {
        if (this.f7389j != null && eobrDevice != null && eobrDevice == this.f7389j.m11412j()) {
            Location location = new Location("turbo_gps");
            location.setLatitude(((double) c1051n.f3443a) / 1.0E7d);
            location.setLongitude(((double) c1051n.f3444b) / 1.0E7d);
            location.setAccuracy(((float) C3608c.m18849b(c1051n.f3445c)) / 1000.0f);
            location.setSpeed(((float) C3608c.m18849b(c1051n.f3446d)) / 1000.0f);
            location.setTime(c1051n.f3447e);
            this.f7397r.add(Float.valueOf(location.getAccuracy()));
            if (this.f7380D && this.f7397r.m18489a() <= 0) {
                Iterator it = this.f7397r.iterator();
                float f = 0.0f;
                while (it.hasNext()) {
                    f = ((Float) it.next()).floatValue() + f;
                }
                if (f / ((float) this.f7397r.size()) < BitmapDescriptorFactory.HUE_ORANGE && this.f7380D) {
                    C2134e.m10676b("TT-LocTracker", "Turbo's GPS fixes are sufficiently accurate, disabling Android's GPS and only using Turbo's GPS");
                    m10596n();
                    m10601b();
                }
            }
            if (this.f7379C != -1) {
                this.f7388i.removeCallbacks(this.f7387f);
                this.f7388i.postDelayed(this.f7387f, this.f7379C);
            }
            m10577a(location);
        }
    }

    private void m10596n() {
        if (this.f7380D) {
            this.f7380D = false;
            this.f7392m.removeUpdates(this.f7382a);
            this.f7399t = -1;
            this.f7400u = GroundOverlayOptions.NO_DIMENSION;
            this.f7401v = PollingStatus.UNKNOWN;
            m10590h();
        }
    }

    public Location m10603c() {
        m10591i();
        return this.f7403x.m10568a();
    }

    public Location m10604d() {
        m10591i();
        return this.f7402w.m10568a();
    }

    public Location m10605e() {
        Location d = m10604d();
        if (d != null && d.getTime() >= this.f7394o.mo913a() - 3600000) {
            return new Location(d);
        }
        return null;
    }

    public ProviderStatus m10606f() {
        if (!Permission.LOCATION.m11151a(this.f7377A)) {
            return ProviderStatus.NOT_FOUND;
        }
        if (this.f7392m.getProvider("gps") == null) {
            return ProviderStatus.NOT_FOUND;
        }
        return this.f7392m.isProviderEnabled("gps") ? ProviderStatus.ENABLED : ProviderStatus.DISABLED;
    }
}
