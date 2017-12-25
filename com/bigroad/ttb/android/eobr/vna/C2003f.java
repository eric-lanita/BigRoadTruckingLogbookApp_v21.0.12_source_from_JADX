package com.bigroad.ttb.android.eobr.vna;

import com.bigroad.shared.eobr.turbo.logs.C1017o;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.ttb.android.eobr.realtime.C1939b;
import com.bigroad.ttb.android.eobr.realtime.C1942c;
import com.bigroad.ttb.android.logging.C2134e;

public class C2003f {
    private C1942c f6918a = new C1942c();
    private C2002a f6919b = new C2002a();
    private final C1939b f6920c;

    public static class C2002a {
        public long f6915a = -2;
        public int[] f6916b = new int[OdometerSource.values().length];
        public boolean[] f6917c = new boolean[OdometerSource.values().length];

        public OdometerSource m9908a() {
            for (OdometerSource odometerSource : OdometerSource.values()) {
                if (this.f6917c[odometerSource.ordinal()]) {
                    return odometerSource;
                }
            }
            return null;
        }
    }

    public C2003f(C1939b c1939b) {
        this.f6920c = c1939b;
    }

    synchronized void m9914a(OdometerSource odometerSource, long j, long j2) {
        Object obj = !this.f6918a.m9560a(odometerSource) ? 1 : null;
        this.f6918a.m9558a(odometerSource, j, j2);
        if (obj != null) {
            m9911b(j2);
            m9912c(j2);
        }
    }

    synchronized boolean m9915a(C2002a c2002a, long j) {
        boolean z = false;
        synchronized (this) {
            if (c2002a == null) {
                C2134e.m10676b("TT-VnaOdometer", "Failed to write odometer calibration values");
            } else {
                for (OdometerSource odometerSource : OdometerSource.values()) {
                    if (!c2002a.f6917c[odometerSource.ordinal()] && this.f6918a.m9560a(odometerSource)) {
                        z = true;
                        break;
                    }
                }
                this.f6919b = c2002a;
                if (z) {
                    m9911b(j);
                } else {
                    m9909a(false, j);
                    m9912c(j);
                }
                C2134e.m10676b("TT-VnaOdometer", "Odometer calibration offsets updated");
                this.f6920c.mo1162a(this.f6919b.m9908a());
                z = true;
            }
        }
        return z;
    }

    synchronized void m9913a(long j) {
        this.f6918a.m9557a(j);
        if (m9910a()) {
            m9912c(j);
        }
    }

    private synchronized void m9911b(long j) {
        OdometerSource odometerSource;
        OdometerSource odometerSource2 = OdometerSource.ODOMETER_SOURCE_UNKNOWN;
        for (OdometerSource odometerSource3 : OdometerSource.values()) {
            if (C2005h.m9926a(odometerSource3) && this.f6919b.f6917c[odometerSource3.ordinal()] && this.f6918a.m9560a(odometerSource3)) {
                odometerSource = odometerSource3;
                break;
            }
        }
        odometerSource = odometerSource2;
        if (odometerSource != OdometerSource.ODOMETER_SOURCE_UNKNOWN) {
            Object obj = null;
            for (OdometerSource odometerSource4 : OdometerSource.values()) {
                if (C2005h.m9926a(odometerSource4) && this.f6918a.m9560a(odometerSource4) && !this.f6919b.f6917c[odometerSource4.ordinal()]) {
                    long b = this.f6918a.m9561b(odometerSource) - this.f6918a.m9561b(odometerSource4);
                    if (b > 0) {
                        b += 4;
                    } else if (b < 0) {
                        b -= 4;
                    }
                    this.f6919b.f6916b[odometerSource4.ordinal()] = ((int) (b / 5)) + this.f6919b.f6916b[odometerSource.ordinal()];
                    this.f6919b.f6917c[odometerSource4.ordinal()] = true;
                    obj = 1;
                }
            }
            if (obj != null) {
                m9909a(true, j);
                m9912c(j);
            }
        }
    }

    private synchronized void m9912c(long j) {
        C1017o a = this.f6918a.m9556a((int) (j / 1000));
        if (a != null) {
            this.f6920c.mo1163a(a);
        }
    }

    private synchronized void m9909a(boolean z, long j) {
        if (this.f6919b.f6915a == -2) {
            C2134e.m10676b("TT-VnaOdometer", "Can't write odometer calibration log entry with unknown truck id");
        } else {
            for (OdometerSource odometerSource : OdometerSource.values()) {
                C2134e.m10676b("TT-VnaOdometer", odometerSource + " - " + this.f6919b.f6917c[odometerSource.ordinal()] + " - " + this.f6919b.f6916b[odometerSource.ordinal()]);
            }
            this.f6920c.mo1163a(new C1029i((int) (j / 1000), this.f6919b.f6915a, this.f6919b.f6916b, this.f6919b.f6917c, z));
        }
    }

    private synchronized boolean m9910a() {
        return this.f6918a.m9559a();
    }
}
