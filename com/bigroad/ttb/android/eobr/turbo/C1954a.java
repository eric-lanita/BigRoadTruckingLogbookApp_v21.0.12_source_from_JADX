package com.bigroad.ttb.android.eobr.turbo;

import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.turbo.messages.C1058u;
import com.bigroad.shared.eobr.turbo.messages.C1059v;
import com.bigroad.shared.eobr.turbo.messages.C1061x;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.turbo.C1978g.C1975a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;
import com.google.common.primitives.UnsignedInteger;

abstract class C1954a implements C1206c {
    final C1975a f6771a;
    private final VehicleConnectionManager f6772b = this.f6771a.mo1176z().mo1311s();
    private final String f6773c;

    abstract void mo1164a(C1059v c1059v);

    abstract void mo1165a(VarPage varPage, boolean z, C1059v c1059v, C1061x c1061x);

    C1954a(C1975a c1975a, String str) {
        this.f6771a = c1975a;
        this.f6773c = str;
    }

    protected void mo1166a(Long l) {
    }

    public void mo897a(C0972e c0972e, C0973f c0973f) {
        Long l = null;
        EobrDevice j;
        long longValue;
        try {
            C1059v c1059v;
            c0973f = c0973f instanceof C1061x ? (C1061x) c0973f : null;
            if (c0972e instanceof C1059v) {
                c1059v = (C1059v) c0972e;
            } else {
                C1058u c1058u = null;
            }
            if (c1059v != null) {
                try {
                    l = Long.valueOf(UnsignedInteger.m18836a(c1059v.a).longValue());
                } catch (Throwable th) {
                }
            }
            mo1166a(l);
            if (c0973f == null && c1059v == null) {
                C2134e.m10680d("TT-TurboRespCallbk", "Unexpected request/response types for VAR page callback");
            } else if (c0973f == null) {
                C2134e.m10680d("TT-TurboRespCallbk", "Var Request Timed out: " + c0972e.toString());
                this.f6771a.m9722g();
            } else {
                j = this.f6772b.m11412j();
                longValue = UnsignedInteger.m18836a(c0973f.a).longValue();
                if (j != null) {
                    if (c0973f.e == TurboResponse.TURBO_RESPONSE_OK) {
                        VarPage d = this.f6771a.mo1175d(longValue);
                        VarPage a = this.f6771a.mo1168a(j, longValue, d, c0973f.b);
                        if (a == null) {
                            C2134e.m10680d("TT-TurboRespCallbk", "Unable to process page " + longValue);
                        } else {
                            boolean z;
                            if (d != null) {
                                if (d.m9618k() >= a.m9618k()) {
                                    z = false;
                                    mo1165a(a, z, c1059v, c0973f);
                                    if (c1059v != null && c1059v.a == 0) {
                                        this.f6771a.mo1098b(longValue);
                                    }
                                }
                            }
                            z = true;
                            mo1165a(a, z, c1059v, c0973f);
                            this.f6771a.mo1098b(longValue);
                        }
                    } else {
                        C2134e.m10680d("TT-TurboRespCallbk", "LogPageResponse " + c0973f.e + " for page " + c0973f.a);
                        if (c0973f.e == TurboResponse.TURBO_RESPONSE_INVALID_PARAMETER) {
                            this.f6771a.mo1171a((C1058u) c1059v);
                            mo1164a(c1059v);
                        }
                    }
                }
                this.f6771a.m9722g();
            }
        } catch (Throwable e) {
            C2134e.m10681d("TT-TurboRespCallbk", "IOException reading page " + longValue + " from device " + j.mo1118f(), e);
        } finally {
            this.f6771a.m9722g();
        }
    }
}
