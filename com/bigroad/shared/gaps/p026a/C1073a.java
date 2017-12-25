package com.bigroad.shared.gaps.p026a;

import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public class C1073a implements C1072a {
    private final AutoDailyLogTruck f3503a;
    private final int f3504b;
    private final long f3505c;

    public C1073a(AutoDailyLogTruck autoDailyLogTruck, int i, long j) {
        this.f3503a = autoDailyLogTruck;
        this.f3504b = i;
        this.f3505c = j;
    }

    public int mo770a() {
        return this.f3504b;
    }

    public String mo772c() {
        return this.f3503a.getTruckNumber();
    }

    public CanonicalOdometerUnit mo776g() {
        if (this.f3503a.hasOdometerUnit()) {
            return CanonicalOdometerUnit.m5466a(OdometerUnit.m14668a(this.f3503a.getOdometerUnit()));
        }
        return CanonicalOdometerUnit.MILES;
    }

    public long mo775f() {
        Long d = mo773d();
        Long e = mo774e();
        if (d == null || e == null) {
            return 0;
        }
        return e.longValue() - d.longValue();
    }

    public Long mo773d() {
        if (this.f3503a.hasStartDistance() && this.f3503a.hasEndDistance()) {
            return Long.valueOf(this.f3503a.getStartDistance());
        }
        return null;
    }

    public Long mo774e() {
        if (this.f3503a.hasStartDistance() && this.f3503a.hasEndDistance()) {
            return Long.valueOf(this.f3503a.getEndDistance());
        }
        return null;
    }

    public long mo771b() {
        return this.f3505c;
    }
}
