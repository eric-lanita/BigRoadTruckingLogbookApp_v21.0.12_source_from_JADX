package com.bigroad.ttb.android.p029c;

import com.bigroad.shared.ap;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.C2103j;
import com.bigroad.ttb.android.C2315v;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.util.C2292l;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import java.util.Collection;
import java.util.TimeZone;

public class C1740e {
    private final int f6019a;
    private final DailyLog f6020b;
    private final EventManager f6021c = OurApplication.m6295q();
    private final C2103j f6022d = OurApplication.ae();
    private final ap f6023e = OurApplication.m6269Z();
    private final C2474y f6024f = OurApplication.m6285g();
    private final C2315v f6025g = OurApplication.m6298t();
    private final long f6026h;
    private final long f6027i;
    private final OdometerUnit f6028j;
    private final long f6029k;
    private final long f6030l;
    private final boolean f6031m;
    private final boolean f6032n;
    private final boolean f6033o;
    private final boolean f6034p;

    public C1740e(DailyLog dailyLog, int i, boolean z) {
        boolean z2;
        long intValue;
        double b;
        this.f6020b = dailyLog;
        if (dailyLog != null) {
            i = dailyLog.getLogDay();
        }
        this.f6019a = i;
        TimeZone d = C1738c.m8515d(this.f6020b);
        if (this.f6020b == null || !C2292l.m11231a(this.f6020b)) {
            z2 = false;
        } else {
            z2 = true;
        }
        Collection a = this.f6021c.m10008a(this.f6019a, d, z2);
        OdometerUnit t = this.f6024f.m12230t();
        if (this.f6020b != null) {
            C1116d a2 = C1114a.m5598a(this.f6020b, OurApplication.af(), this.f6023e.mo914b()).m5635a();
            if (a2.m5671w()) {
                intValue = (long) a2.m5670v().intValue();
            } else {
                intValue = 0;
            }
            if (a2.m5673y()) {
                t = a2.m5672x().m5472b();
            }
        } else {
            intValue = 0;
        }
        this.f6026h = intValue;
        this.f6028j = t;
        this.f6029k = C0890f.m4499a(a, DutyStatus.DRIVING);
        this.f6030l = this.f6021c.m10036c(this.f6019a);
        intValue = this.f6021c.m10048e(this.f6019a);
        if (this.f6028j == OdometerUnit.KM) {
            b = CanonicalOdometerUnit.KM.m5471b(intValue);
        } else {
            b = CanonicalOdometerUnit.MILES.m5471b(intValue);
        }
        this.f6027i = Math.round(b);
        this.f6031m = this.f6025g.m11309h(this.f6019a);
        if (!this.f6021c.m10064n() || this.f6021c.m10036c(this.f6019a) <= 0) {
            z2 = false;
        } else {
            z2 = true;
        }
        this.f6032n = z2;
        this.f6033o = this.f6022d.m10540c(this.f6019a);
        if (z && this.f6032n) {
            this.f6034p = true;
        } else {
            this.f6034p = false;
        }
    }

    public int m8525a() {
        return this.f6019a;
    }

    public DailyLog m8526b() {
        return this.f6020b;
    }

    public long m8527c() {
        return this.f6034p ? this.f6027i : this.f6026h;
    }

    public OdometerUnit m8528d() {
        return this.f6028j;
    }

    public long m8529e() {
        return this.f6034p ? this.f6030l : this.f6029k;
    }

    public boolean m8530f() {
        return this.f6031m;
    }

    public boolean m8531g() {
        return this.f6032n;
    }

    public boolean m8532h() {
        return this.f6033o;
    }

    public boolean m8533i() {
        return this.f6034p;
    }
}
