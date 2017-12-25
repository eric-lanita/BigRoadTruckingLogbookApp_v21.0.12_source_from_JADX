package com.bigroad.shared.validation.p028a;

import com.bigroad.shared.validation.p024b.C1153c;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;

public class C1154d extends C1153c {
    private final DvirInspection f3938a;

    public C1154d(DvirInspection dvirInspection) {
        this.f3938a = dvirInspection;
    }

    public byte[] mo844a() {
        return this.f3938a.getId().m19091d();
    }

    public int mo845b() {
        return this.f3938a.getVehicleType();
    }

    public String mo846c() {
        return this.f3938a.getVehicleNumber();
    }

    public Integer mo847d() {
        return this.f3938a.hasOdometer() ? Integer.valueOf(this.f3938a.getOdometer()) : null;
    }

    public String mo848e() {
        return this.f3938a.getLocationName();
    }

    public boolean mo849f() {
        return this.f3938a.getFoundDefects();
    }

    public String mo850g() {
        return this.f3938a.getRemarks();
    }
}
