package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.C1144s;
import com.bigroad.shared.eobr.genx.GenxEntryResponse;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1016p;
import com.bigroad.shared.eobr.turbo.logs.C1020a;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.C1026f;
import com.bigroad.shared.eobr.turbo.logs.C1029i;
import com.bigroad.shared.eobr.turbo.logs.C1036s;
import com.bigroad.shared.eobr.turbo.logs.C1037t;
import com.bigroad.shared.eobr.turbo.logs.EngineHoursLogEntry;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.p041b.C2341a;
import com.bigroad.ttb.android.vehicle.p041b.C2343b;
import com.bigroad.ttb.android.vehicle.p041b.C2344c;
import com.bigroad.ttb.android.vehicle.p041b.C2345d;
import com.bigroad.ttb.android.vehicle.p041b.C2346e;
import com.bigroad.ttb.android.vehicle.p041b.C2347j;
import com.bigroad.ttb.android.vehicle.p041b.C2348f;
import com.bigroad.ttb.android.vehicle.p041b.C2349g;
import com.bigroad.ttb.android.vehicle.p041b.C2351h;
import com.bigroad.ttb.android.vehicle.p041b.C2352i;
import com.bigroad.ttb.android.vehicle.p041b.C2353k;
import com.bigroad.ttb.android.vehicle.p041b.C2354l;
import com.bigroad.ttb.android.vehicle.p042c.C2357a;
import com.bigroad.ttb.android.vehicle.task.C2381b;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

class C2366h {
    private final C2032f f8166a;
    private C2357a f8167b = new C2357a(this.f8166a);
    private final C2370j f8168c;

    public C2366h(C2032f c2032f, C2364g c2364g) {
        this.f8166a = c2032f;
        this.f8168c = new C2370j(c2364g);
    }

    C2369i m11563a(EobrDevice eobrDevice, C2358c c2358c, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2369i c2369i) {
        C2369i a = this.f8167b.m11500a(c2369i, c2358c, relativeTimestamp, this.f8168c);
        this.f8168c.m11627a(eobrDevice, c1015l, relativeTimestamp, c2358c, a, null);
        return a;
    }

    C2369i m11564a(EobrDevice eobrDevice, C2358c c2358c, C2369i c2369i, C2347j c2347j) {
        if (c2347j == null) {
            return c2369i;
        }
        if (c2347j instanceof C2348f) {
            C1024d c1024d;
            C2348f c2348f = (C2348f) c2347j;
            C1015l c = c2348f.m11468c();
            RelativeTimestamp l = c2348f.mo1281l();
            if (c2348f.m11471f()) {
                c2369i = C2349g.m11478a(c2369i, c2348f, this.f8168c, this.f8166a);
                c1024d = null;
            } else if (c2348f.m11475j()) {
                Event k;
                if (l.hasAbsoluteTimeMillis()) {
                    k = c2348f.m11476k();
                } else {
                    k = c2348f.m11476k();
                }
                if (k != null) {
                    if (this.f8166a.mo1299g().m11020f().longValue() == k.getPersonId()) {
                        C2134e.m10676b("TT-VMConsumer", "Found unclaimed event: " + C1144s.m5763c(k));
                    } else {
                        C2134e.m10676b("TT-VMConsumer", "Found EOBR event: " + C1144s.m5763c(k));
                    }
                }
                c1024d = null;
            } else if (c2348f.m11473h()) {
                C1024d i = !l.hasAbsoluteTimeMillis() ? c2348f.m11474i() : c2348f.m11474i();
                if (i == null || !i.m5261a()) {
                    C2134e.m10676b("TT-VMConsumer", "Invalid external event: " + c2348f.m11468c());
                    i = null;
                } else {
                    c2369i = C2344c.m11460a(c2369i, i, this.f8168c, this.f8166a);
                }
                c1024d = i;
            } else if (c2348f.m11466a() != null) {
                C1016p a = c2348f.m11466a();
                if (a instanceof C1036s) {
                    c2369i = C2353k.m11482a(c2369i, c2348f, this.f8168c, this.f8166a);
                } else if (a instanceof C1037t) {
                    c2369i = C2354l.m11484a(c2369i, c2348f, this.f8166a);
                } else if (a instanceof MultiOdometerLogEntry) {
                    try {
                        c2369i = C2351h.m11480a(c2369i, c2348f);
                    } catch (IllegalArgumentException e) {
                        C2134e.m10680d("TT-VMConsumer", e.toString());
                    }
                } else if (a instanceof C1029i) {
                    try {
                        c2369i = C2352i.m11481a(c2369i, c2348f);
                    } catch (IllegalArgumentException e2) {
                        C2134e.m10680d("TT-VMConsumer", e2.toString());
                    }
                } else if (a instanceof EngineHoursLogEntry) {
                    try {
                        c2369i = C2343b.m11458a(c2369i, c2348f);
                    } catch (IllegalArgumentException e22) {
                        C2134e.m10680d("TT-VMConsumer", e22.toString());
                    }
                } else if (a instanceof C1026f) {
                    try {
                        c2369i = C2346e.m11464a(c2369i, c2348f);
                    } catch (IllegalArgumentException e222) {
                        C2134e.m10680d("TT-VMConsumer", e222.toString());
                    }
                } else if (a instanceof C1020a) {
                    try {
                        c2369i = C2341a.m11457a(c2369i, c2348f);
                    } catch (IllegalArgumentException e2222) {
                        C2134e.m10680d("TT-VMConsumer", e2222.toString());
                    }
                }
                c1024d = null;
            } else {
                if (c2348f.m11467b() != null && (c2348f.m11467b() instanceof GenxEntryResponse)) {
                    try {
                        c2369i = C2345d.m11461a(c2369i, c2348f, this.f8168c, this.f8166a);
                        c1024d = null;
                    } catch (IllegalArgumentException e22222) {
                        C2134e.m10680d("TT-VMConsumer", e22222.toString());
                    }
                }
                c1024d = null;
            }
            C2369i a2 = this.f8167b.m11500a(c2369i, c2358c, l, this.f8168c);
            this.f8168c.m11627a(eobrDevice, c, l, c2358c, a2, c1024d);
            return a2;
        }
        C2134e.m10680d("TT-VMConsumer", "Unexpected message type: " + c2347j.getClass().getName());
        return c2369i;
    }

    void m11566a(C2358c c2358c) {
        this.f8168c.m11628a(c2358c);
    }

    public void m11565a(C2355b c2355b) {
        this.f8168c.m11629a(new C2381b(c2355b, this.f8166a));
    }
}
