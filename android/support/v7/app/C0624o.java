package android.support.v7.app;

import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.content.C0266j;
import android.util.Log;
import java.util.Calendar;

class C0624o {
    private static final C0623a f1500a = new C0623a();
    private final Context f1501b;
    private final LocationManager f1502c;

    private static class C0623a {
        boolean f1494a;
        long f1495b;
        long f1496c;
        long f1497d;
        long f1498e;
        long f1499f;

        private C0623a() {
        }
    }

    C0624o(Context context) {
        this.f1501b = context;
        this.f1502c = (LocationManager) context.getSystemService("location");
    }

    boolean m2888a() {
        C0623a c0623a = f1500a;
        if (m2886a(c0623a)) {
            return c0623a.f1494a;
        }
        Location b = m2887b();
        if (b != null) {
            m2885a(b);
            return c0623a.f1494a;
        }
        Log.i("TwilightManager", "Could not get last known location. This is probably because the app does not have any location permissions. Falling back to hardcoded sunrise/sunset values.");
        int i = Calendar.getInstance().get(11);
        return i < 6 || i >= 22;
    }

    private Location m2887b() {
        Location a;
        Location location = null;
        if (C0266j.m1111a(this.f1501b, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            a = m2884a("network");
        } else {
            a = null;
        }
        if (C0266j.m1111a(this.f1501b, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            location = m2884a("gps");
        }
        if (location == null || a == null) {
            if (location == null) {
                location = a;
            }
            return location;
        } else if (location.getTime() > a.getTime()) {
            return location;
        } else {
            return a;
        }
    }

    private Location m2884a(String str) {
        if (this.f1502c != null) {
            try {
                if (this.f1502c.isProviderEnabled(str)) {
                    return this.f1502c.getLastKnownLocation(str);
                }
            } catch (Throwable e) {
                Log.d("TwilightManager", "Failed to get last known location", e);
            }
        }
        return null;
    }

    private boolean m2886a(C0623a c0623a) {
        return c0623a != null && c0623a.f1499f > System.currentTimeMillis();
    }

    private void m2885a(Location location) {
        long j;
        C0623a c0623a = f1500a;
        long currentTimeMillis = System.currentTimeMillis();
        C0621n a = C0621n.m2882a();
        a.m2883a(currentTimeMillis - 86400000, location.getLatitude(), location.getLongitude());
        long j2 = a.f1491a;
        a.m2883a(currentTimeMillis, location.getLatitude(), location.getLongitude());
        boolean z = a.f1493c == 1;
        long j3 = a.f1492b;
        long j4 = a.f1491a;
        a.m2883a(86400000 + currentTimeMillis, location.getLatitude(), location.getLongitude());
        long j5 = a.f1492b;
        if (j3 == -1 || j4 == -1) {
            j = 43200000 + currentTimeMillis;
        } else {
            if (currentTimeMillis > j4) {
                j = 0 + j5;
            } else if (currentTimeMillis > j3) {
                j = 0 + j4;
            } else {
                j = 0 + j3;
            }
            j += 60000;
        }
        c0623a.f1494a = z;
        c0623a.f1495b = j2;
        c0623a.f1496c = j3;
        c0623a.f1497d = j4;
        c0623a.f1498e = j5;
        c0623a.f1499f = j;
    }
}
