package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.C1180y;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import com.google.common.base.Objects;
import java.util.Arrays;

public class C2358c {
    private final byte[] f8127a;
    private final Long f8128b;
    private final Fleet f8129c;
    private final Integer f8130d;
    private final Integer f8131e;
    private final boolean f8132f;

    public C2358c(byte[] bArr, Long l, Fleet fleet, Integer num, Integer num2, boolean z) {
        this.f8127a = bArr;
        this.f8128b = l;
        this.f8129c = fleet;
        this.f8130d = num;
        this.f8131e = num2;
        this.f8132f = z;
    }

    public byte[] m11503a() {
        return this.f8127a;
    }

    public Long m11504b() {
        return this.f8128b;
    }

    public Fleet m11505c() {
        return this.f8129c;
    }

    public long m11506d() {
        if (m11504b() == null) {
            return m11507e();
        }
        return m11504b().longValue();
    }

    public long m11507e() {
        return m11505c().getUnidentifiedDriverId();
    }

    public Integer m11508f() {
        return this.f8130d;
    }

    public Integer m11509g() {
        return this.f8131e;
    }

    public boolean m11510h() {
        return this.f8132f;
    }

    public boolean m11502a(EobrSessionLogEntry eobrSessionLogEntry) {
        return Arrays.equals(m11503a(), eobrSessionLogEntry.mo751e()) && Objects.equal(m11504b(), Long.valueOf(eobrSessionLogEntry.mo752f())) && Objects.equal(m11508f(), Integer.valueOf(eobrSessionLogEntry.mo754h()));
    }

    public static C2358c m11501a(Fleet fleet, EobrSessionLogEntry eobrSessionLogEntry, boolean z) {
        return new C2358c(eobrSessionLogEntry.mo751e(), Long.valueOf(eobrSessionLogEntry.mo752f()), fleet, Integer.valueOf(eobrSessionLogEntry.mo754h()), Integer.valueOf(eobrSessionLogEntry.mo755i()), z);
    }

    public String toString() {
        Object obj;
        ToStringHelper add = MoreObjects.toStringHelper((Object) this).add("mobileClientId", C1180y.m5990a(this.f8127a)).add("personId", this.f8128b);
        String str = "fleetId";
        if (this.f8129c == null) {
            obj = null;
        } else {
            obj = Long.valueOf(this.f8129c.getFleetId());
        }
        return add.add(str, obj).add("sessionId", this.f8130d).add("isCurrentConnected", this.f8132f).toString();
    }
}
