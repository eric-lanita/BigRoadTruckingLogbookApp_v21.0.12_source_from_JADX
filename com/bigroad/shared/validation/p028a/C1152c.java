package com.bigroad.shared.validation.p028a;

import com.bigroad.shared.validation.p024b.C1148b;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public class C1152c extends C1148b {
    private final DailyLogTruck f3935a;
    private final int f3936b;

    public C1152c(DailyLogTruck dailyLogTruck, int i) {
        this.f3935a = dailyLogTruck;
        this.f3936b = i;
    }

    public int a_() {
        return this.f3936b;
    }

    public String mo823b() {
        return this.f3935a.getTruckNumber();
    }

    public Integer mo779f() {
        return this.f3935a.hasStartOdometer() ? Integer.valueOf(this.f3935a.getStartOdometer()) : null;
    }

    public Integer mo780g() {
        return this.f3935a.hasEndOdometer() ? Integer.valueOf(this.f3935a.getEndOdometer()) : null;
    }

    public Integer mo781i() {
        return this.f3935a.hasDistance() ? Integer.valueOf(this.f3935a.getDistance()) : null;
    }

    public OdometerUnit mo782t() {
        if (this.f3935a.hasOdometerUnit()) {
            return OdometerUnit.m14668a(this.f3935a.getOdometerUnit());
        }
        return null;
    }
}
