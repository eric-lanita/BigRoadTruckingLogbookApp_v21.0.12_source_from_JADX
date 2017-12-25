package com.bigroad.ttb.android.model;

import com.bigroad.shared.af;
import com.bigroad.shared.model.CanonicalOdometerSource;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public class C2177b {
    private final long f7563a;
    private final long f7564b;
    private final CanonicalOdometerSource f7565c;

    public C2177b(long j, long j2, CanonicalOdometerSource canonicalOdometerSource) {
        this.f7563a = j;
        this.f7564b = j2;
        this.f7565c = canonicalOdometerSource;
    }

    public long m10802a() {
        return this.f7563a;
    }

    public CanonicalOdometerSource m10803b() {
        return this.f7565c;
    }

    private double m10799a(OdometerUnit odometerUnit) {
        switch (odometerUnit) {
            case KM:
                return CanonicalOdometerUnit.KM.m5471b(this.f7563a);
            case MILES:
                return CanonicalOdometerUnit.MILES.m5471b(this.f7563a);
            default:
                throw new IllegalArgumentException("Unknown odometer unit: " + odometerUnit);
        }
    }

    public int m10801a(Truck truck) {
        return (int) Math.round(m10799a(af.m4151a(truck)));
    }

    public String toString() {
        return m10800a(false);
    }

    private String m10800a(boolean z) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("OdometerReading [m_distance=").append(this.f7563a);
        stringBuilder.append(", m_rawDistance=").append(this.f7564b);
        if (z) {
            stringBuilder.append(", source=").append(this.f7565c);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}
