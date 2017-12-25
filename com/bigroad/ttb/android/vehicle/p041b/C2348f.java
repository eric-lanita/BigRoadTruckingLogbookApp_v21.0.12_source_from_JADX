package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.genx.C0975o;
import com.bigroad.shared.eobr.genx.C0976j;
import com.bigroad.shared.eobr.genx.C0984g;
import com.bigroad.shared.eobr.genx.GenxEntryReasonCode;
import com.bigroad.shared.eobr.genx.GenxEntryResponse;
import com.bigroad.shared.eobr.turbo.C1002b;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1023c;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.C1025e;
import com.bigroad.shared.eobr.turbo.logs.C1031k;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData;
import com.bigroad.shared.eobr.turbo.logs.MobileClientSessionLogEntry;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp.C2730a;
import java.io.IOException;

public class C2348f implements C2347j {
    private final C0971c f8111a;
    private final RelativeTimestamp f8112b;

    public C2348f(C0971c c0971c) {
        this.f8111a = c0971c;
        C2730a a = RelativeTimestamp.newBuilder().m14801a((long) this.f8111a.mo748b());
        if (this.f8111a.mo749d() != 0) {
            a.m14805b(this.f8111a.mo749d());
        }
        this.f8112b = a.m14807c();
    }

    public C1016p m11466a() {
        return this.f8111a instanceof C1002b ? ((C1002b) this.f8111a).m5133e() : null;
    }

    public C0975o m11467b() {
        return this.f8111a instanceof C0975o ? (C0975o) this.f8111a : null;
    }

    public C1015l m11468c() {
        return this.f8111a.mo747c();
    }

    public boolean m11469d() {
        return (this.f8111a instanceof C0976j) && ((C0976j) this.f8111a).mo750h();
    }

    public boolean m11470e() {
        if (this.f8111a instanceof C1002b) {
            return ((C1002b) this.f8111a).m5133e() instanceof C1031k;
        }
        if (this.f8111a instanceof GenxEntryResponse) {
            return GenxEntryReasonCode.m4983a(((GenxEntryResponse) this.f8111a).m5004j());
        }
        return false;
    }

    public boolean m11471f() {
        if (this.f8111a instanceof C1002b) {
            return ((C1002b) this.f8111a).m5133e() instanceof MobileClientSessionLogEntry;
        }
        if (this.f8111a instanceof C0984g) {
            return ((C0984g) this.f8111a).m5049k();
        }
        return false;
    }

    public EobrSessionLogEntry m11472g() {
        if (this.f8111a instanceof C1002b) {
            C1002b c1002b = (C1002b) this.f8111a;
            if (c1002b.m5133e() instanceof MobileClientSessionLogEntry) {
                return (EobrSessionLogEntry) c1002b.m5133e();
            }
        } else if (this.f8111a instanceof C0984g) {
            C0984g c0984g = (C0984g) this.f8111a;
            if (c0984g.m5049k()) {
                try {
                    return c0984g.m5052n();
                } catch (IOException e) {
                    C2134e.m10676b("TT-LogEntryVM", "Invalid session entry: " + e.getMessage());
                }
            }
        }
        return null;
    }

    public boolean m11473h() {
        if (this.f8111a instanceof C1002b) {
            return ((C1002b) this.f8111a).m5133e() instanceof C1025e;
        }
        if (this.f8111a instanceof C0984g) {
            return ((C0984g) this.f8111a).m5047i();
        }
        return false;
    }

    public C1024d m11474i() {
        if (this.f8111a instanceof C1002b) {
            C1002b c1002b = (C1002b) this.f8111a;
            if (c1002b.m5133e() instanceof C1025e) {
                return ((C1025e) c1002b.m5133e()).m5271b();
            }
        } else if (this.f8111a instanceof C0984g) {
            C0984g c0984g = (C0984g) this.f8111a;
            if (c0984g.m5047i()) {
                return c0984g.m5050l();
            }
        }
        return null;
    }

    public boolean m11475j() {
        if (this.f8111a instanceof C1002b) {
            return ((C1002b) this.f8111a).m5133e() instanceof C1023c;
        }
        if (this.f8111a instanceof C0984g) {
            return ((C0984g) this.f8111a).m5048j();
        }
        return false;
    }

    public Event m11476k() {
        if (this.f8111a instanceof C1002b) {
            C1002b c1002b = (C1002b) this.f8111a;
            if (c1002b.m5133e() instanceof C1023c) {
                try {
                    return EobrEventLogData.m5242b(((C1023c) c1002b.m5133e()).f3251a);
                } catch (Throwable e) {
                    C2134e.m10679c("TT-LogEntryVM", "Failed to parse EobrEventLogEntry: " + this.f8111a, e);
                }
            }
        } else if (this.f8111a instanceof C0984g) {
            C0984g c0984g = (C0984g) this.f8111a;
            if (c0984g.m5048j()) {
                try {
                    return c0984g.m5051m();
                } catch (Throwable e2) {
                    C2134e.m10679c("TT-LogEntryVM", "GENX Failed to parse EobrEventLogData: " + this.f8111a, e2);
                }
            }
        }
        return null;
    }

    public RelativeTimestamp mo1281l() {
        return this.f8112b;
    }

    public String toString() {
        return this.f8111a.toString();
    }
}
