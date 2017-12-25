package com.bigroad.ttb.android.eobr.vna;

import android.location.Location;
import com.bigroad.shared.ap;
import com.bigroad.shared.as;
import com.bigroad.shared.eobr.turbo.logs.C1017o;
import com.bigroad.shared.eobr.turbo.logs.C1027g;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.realtime.C1939b;
import com.bigroad.ttb.android.location.LocationTracker;
import com.bigroad.ttb.android.location.LocationTracker.C1191c;
import com.bigroad.ttb.android.location.LocationTracker.C1192d;
import com.bigroad.ttb.android.logging.C2134e;

public class C1997d {
    private static final double f6890a = ((double) as.m4241a(1.0f));
    private final ap f6891b;
    private final LocationTracker f6892c;
    private final C1939b f6893d;
    private boolean f6894e = false;
    private boolean f6895f = false;
    private long f6896g;
    private long f6897h;
    private final C1191c f6898i = new C19961(this);

    class C19961 extends C1192d {
        final /* synthetic */ C1997d f6889a;

        C19961(C1997d c1997d) {
            this.f6889a = c1997d;
        }

        public void mo880a(Location location) {
            this.f6889a.m9888a(location, this.f6889a.f6891b.mo915c());
        }
    }

    public C1997d(C2032f c2032f, C1939b c1939b) {
        this.f6891b = c2032f.mo1314v();
        this.f6892c = c2032f.mo1304l();
        this.f6892c.m10599a(this.f6898i);
        this.f6893d = c1939b;
        m9888a(this.f6892c.m10604d(), this.f6891b.mo915c());
    }

    public void m9887a() {
        this.f6892c.m10602b(this.f6898i);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void m9888a(android.location.Location r7, long r8) {
        /*
        r6 = this;
        r1 = 0;
        r0 = 1;
        if (r7 != 0) goto L_0x0017;
    L_0x0004:
        r2 = r6.f6894e;
        if (r2 == 0) goto L_0x0050;
    L_0x0008:
        r2 = "TT-VnaGps";
        r3 = "lost fix";
        com.bigroad.ttb.android.logging.C2134e.m10676b(r2, r3);
        r6.f6894e = r1;
    L_0x0011:
        if (r0 == 0) goto L_0x0016;
    L_0x0013:
        r6.m9886b(r7, r8);
    L_0x0016:
        return;
    L_0x0017:
        r2 = r7.hasSpeed();
        if (r2 == 0) goto L_0x002a;
    L_0x001d:
        r2 = r7.getSpeed();
        r2 = (double) r2;
        r4 = f6890a;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x002a;
    L_0x0028:
        r6.f6895f = r0;
    L_0x002a:
        r2 = r6.f6894e;
        if (r2 != 0) goto L_0x0038;
    L_0x002e:
        r1 = "TT-VnaGps";
        r2 = "got fix";
        com.bigroad.ttb.android.logging.C2134e.m10676b(r1, r2);
        r6.f6894e = r0;
        goto L_0x0011;
    L_0x0038:
        r2 = r6.f6897h;
        r2 = r8 - r2;
        r4 = 60000; // 0xea60 float:8.4078E-41 double:2.9644E-319;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 <= 0) goto L_0x0050;
    L_0x0043:
        r2 = r6.f6895f;
        if (r2 != 0) goto L_0x0011;
    L_0x0047:
        r2 = r6.f6896g;
        r2 = (double) r2;
        r4 = f6890a;
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 > 0) goto L_0x0011;
    L_0x0050:
        r0 = r1;
        goto L_0x0011;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.ttb.android.eobr.vna.d.a(android.location.Location, long):void");
    }

    private void m9886b(Location location, long j) {
        C1017o c1027g;
        int i = (int) (j / 1000);
        if (location == null) {
            c1027g = new C1027g(i, 0, 0, 0, 0, this.f6891b.mo913a());
        } else {
            c1027g = new C1027g(i, (int) Math.round(location.getLatitude() * 1.0E7d), (int) Math.round(location.getLongitude() * 1.0E7d), Math.round(location.getAccuracy()), Math.round(location.getSpeed()), location.getTime());
        }
        C2134e.m10676b("TT-VnaGps", "writing GPS log entry: " + c1027g);
        this.f6893d.mo1163a(c1027g);
        this.f6897h = j;
        this.f6896g = (long) c1027g.f3258d;
        this.f6895f = false;
    }
}
