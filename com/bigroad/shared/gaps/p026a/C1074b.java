package com.bigroad.shared.gaps.p026a;

import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public class C1074b implements C1072a {
    private final DailyLogTruck f3506a;
    private final int f3507b;
    private final long f3508c;

    public C1074b(DailyLogTruck dailyLogTruck, int i, long j) {
        this.f3506a = dailyLogTruck;
        this.f3507b = i;
        this.f3508c = j;
    }

    public int mo770a() {
        return this.f3507b;
    }

    public String mo772c() {
        return this.f3506a.getTruckNumber();
    }

    public CanonicalOdometerUnit mo776g() {
        if (this.f3506a.hasOdometerUnit()) {
            return CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(this.f3506a.getOdometerUnit()));
        }
        return CanonicalOdometerUnit.MILES;
    }

    public long mo775f() {
        if (this.f3506a.hasDistance()) {
            return (long) ((int) Math.round(mo776g().m5469a((long) this.f3506a.getDistance())));
        }
        return 0;
    }

    public Long mo773d() {
        if (!this.f3506a.hasStartOdometer() || !this.f3506a.hasEndOdometer()) {
            return null;
        }
        CanonicalOdometerUnit g = mo776g();
        if (g == null) {
            g = CanonicalOdometerUnit.MILES;
        }
        return Long.valueOf(Math.round(g.m5469a((long) this.f3506a.getStartOdometer())));
    }

    public Long mo774e() {
        if (!this.f3506a.hasStartOdometer() || !this.f3506a.hasEndOdometer()) {
            return null;
        }
        CanonicalOdometerUnit g = mo776g();
        if (g == null) {
            g = CanonicalOdometerUnit.MILES;
        }
        return Long.valueOf(Math.round(g.m5469a((long) this.f3506a.getEndOdometer())));
    }

    public long mo771b() {
        return this.f3508c;
    }
}
