package com.bigroad.shared.model;

import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.TruckLogType;

public abstract class C1107b implements C1106h {
    private final TruckLogType f3618a;
    private final String f3619b;
    private final String f3620c;
    private final CanonicalOdometerUnit f3621d;

    public abstract Integer mo779f();

    public abstract Integer mo780g();

    public abstract Integer mo781i();

    public C1107b(TruckLogType truckLogType, String str, String str2, CanonicalOdometerUnit canonicalOdometerUnit) {
        this.f3618a = truckLogType;
        this.f3619b = str;
        this.f3620c = str2;
        this.f3621d = canonicalOdometerUnit;
    }

    public TruckLogType m5486m() {
        return this.f3618a;
    }

    public boolean m5487n() {
        return mo779f() != null;
    }

    public boolean m5488o() {
        return mo780g() != null;
    }

    public boolean m5489p() {
        return mo781i() != null;
    }

    public String m5490q() {
        return this.f3619b;
    }

    public String m5491r() {
        return this.f3620c;
    }

    public CanonicalOdometerUnit m5492s() {
        return this.f3621d;
    }

    public OdometerUnit mo782t() {
        return this.f3621d != null ? this.f3621d.m5472b() : null;
    }

    public boolean m5494u() {
        return this.f3621d != null;
    }
}
