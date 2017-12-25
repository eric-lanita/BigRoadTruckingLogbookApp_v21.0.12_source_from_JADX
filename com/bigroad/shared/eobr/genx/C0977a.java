package com.bigroad.shared.eobr.genx;

import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.EobrSessionLogEntry.SessionState;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.protocol.TTProtocol;
import com.facebook.internal.ServerProtocol;
import com.google.common.base.MoreObjects;
import com.google.common.base.MoreObjects.ToStringHelper;
import java.util.Date;

public class C0977a implements EobrSessionLogEntry, C0971c {
    private final C0984g f3082a;
    private final TTProtocol.EobrSessionLogEntry f3083b;

    public C0977a(C0984g c0984g) {
        this.f3082a = c0984g;
        this.f3083b = c0984g.m5053o();
    }

    public int mo748b() {
        return this.f3082a.mo748b();
    }

    public long mo749d() {
        return this.f3082a.mo749d();
    }

    public C1015l mo747c() {
        return this.f3082a.mo747c();
    }

    public byte[] mo751e() {
        return this.f3083b.getMobileClientId().m19091d();
    }

    public long mo752f() {
        return this.f3083b.getPersonId();
    }

    public long mo753g() {
        return this.f3083b.getTruckId();
    }

    public int mo754h() {
        return this.f3083b.getSessionId();
    }

    public int mo755i() {
        return this.f3083b.getPreviousSessionId();
    }

    public SessionState mo756j() {
        return C0990p.m5079a(this.f3082a.m5054p());
    }

    public boolean mo746a() {
        return false;
    }

    public String toString() {
        ToStringHelper toStringHelper = MoreObjects.toStringHelper(C0977a.class);
        toStringHelper.add(ServerProtocol.DIALOG_PARAM_STATE, mo756j().toString()).add("timestamp", new Date(mo749d())).add("position", mo747c()).add("personId", mo752f()).add("truckId", mo753g()).add("sessionId", mo754h()).add("prevSessionId", mo755i());
        return toStringHelper.toString();
    }
}
