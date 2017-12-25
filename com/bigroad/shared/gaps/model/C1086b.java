package com.bigroad.shared.gaps.model;

import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public class C1086b {
    private final C1091d f3534a;
    private final C1091d f3535b;

    public C1086b(C1091d c1091d, C1091d c1091d2) {
        this.f3534a = c1091d;
        this.f3535b = c1091d2;
    }

    public C1091d m5391a() {
        return this.f3534a;
    }

    public C1091d m5392b() {
        return this.f3535b;
    }

    public long m5394c() {
        return this.f3535b.m5421e() - this.f3534a.m5423g();
    }

    public int m5390a(OdometerUnit odometerUnit) {
        CanonicalOdometerUnit h;
        if (this.f3534a.m5424h() == this.f3535b.m5422f() && this.f3534a.m5424h().m5472b() == odometerUnit) {
            h = this.f3534a.m5424h();
            if (h == null) {
                h = CanonicalOdometerUnit.MILES;
            }
            return ((int) Math.round(h.m5471b(this.f3535b.m5421e()))) - ((int) Math.round(h.m5471b(this.f3534a.m5423g())));
        }
        h = CanonicalOdometerUnit.m5466a(odometerUnit);
        if (h == null) {
            h = CanonicalOdometerUnit.MILES;
        }
        return (int) Math.round(h.m5471b(m5394c()));
    }

    public String m5393b(OdometerUnit odometerUnit) {
        CanonicalOdometerUnit a = CanonicalOdometerUnit.m5466a(odometerUnit);
        if (a == null) {
            a = this.f3534a.m5424h();
        }
        if (a == null) {
            a = CanonicalOdometerUnit.MILES;
        }
        return Integer.toString(m5390a(a.m5472b())) + " " + a.m5470a();
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("gap(");
        if (this.f3534a == null) {
            stringBuilder.append("(null)");
        } else {
            stringBuilder.append(Math.round(this.f3534a.m5424h().m5471b(this.f3534a.m5423g())));
            stringBuilder.append(this.f3534a.m5424h().m5470a());
        }
        stringBuilder.append("-");
        if (this.f3535b == null) {
            stringBuilder.append("(null)");
        } else {
            stringBuilder.append(Math.round(this.f3535b.m5422f().m5471b(this.f3535b.m5421e())));
            stringBuilder.append(this.f3535b.m5422f().m5470a());
        }
        stringBuilder.append(")");
        return stringBuilder.toString();
    }
}
