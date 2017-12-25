package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.genx.C0975o;
import com.bigroad.shared.eobr.genx.C0985h;
import com.bigroad.shared.eobr.genx.C0986i;
import com.bigroad.shared.eobr.genx.C0989m;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.VehicleConnectionManager;

abstract class C1907a implements C1206c {
    final GenxManager f6599a;
    private final String f6600b;
    private final VehicleConnectionManager f6601c = this.f6599a.mo1115w().mo1311s();

    abstract void mo1089a(C0986i c0986i, C0985h c0985h);

    abstract void mo1090b(C0986i c0986i, C0985h c0985h);

    C1907a(GenxManager genxManager, String str) {
        this.f6599a = genxManager;
        this.f6600b = str;
    }

    protected void m9320a(C0986i c0986i) {
    }

    protected void m9322b(C0986i c0986i) {
    }

    public void mo897a(C0972e c0972e, C0973f c0973f) {
        C0986i c0986i = null;
        EobrDevice j;
        C0985h c0985h;
        try {
            C0975o c0975o;
            if (c0973f instanceof C0975o) {
                c0975o = (C0975o) c0973f;
            } else {
                Object obj = null;
            }
            if (c0972e instanceof C0986i) {
                c0986i = (C0986i) c0972e;
            }
            try {
                m9320a(c0986i);
            } catch (Throwable th) {
            }
            if (c0975o == null && c0986i == null) {
                C2134e.m10680d("TT-GenxRespCallbk", "Unexpected request/response types for GENX entry callback");
            } else if (c0975o == null) {
                C2134e.m10680d("TT-GenxRespCallbk", "GENX Entry Request Timed out: " + c0972e.toString());
                this.f6599a.m9062g();
            } else {
                j = this.f6601c.m11412j();
                if (j != null) {
                    if (c0975o instanceof C0985h) {
                        c0985h = (C0985h) c0975o;
                        if (c0986i == null || c0986i.m5070f() == null || c0985h.m5061i() <= c0986i.m5070f().longValue()) {
                            this.f6599a.m9378a(j, c0985h);
                            mo1089a(c0986i, c0985h);
                            if (c0986i != null && c0986i.m5068d()) {
                                this.f6599a.mo1098b(c0985h.m5064l());
                            }
                        } else {
                            this.f6599a.m9376a(c0986i, c0985h);
                            mo1090b(c0986i, c0985h);
                            this.f6599a.m9062g();
                            return;
                        }
                    } else if (c0973f instanceof C0989m) {
                        C2134e.m10680d("TT-GenxRespCallbk", "Response: " + c0973f.toString() + " for request " + (c0986i != null ? c0986i.toString() : "null"));
                        m9322b(c0986i);
                    } else {
                        C2134e.m10680d("TT-GenxRespCallbk", "Unhandled response type: " + c0973f.getClass().getName());
                    }
                }
                this.f6599a.m9062g();
            }
        } catch (Throwable e) {
            C2134e.m10681d("TT-GenxRespCallbk", "IOException reading entries " + c0985h.toString() + " from device " + j.mo1118f(), e);
        } finally {
            this.f6599a.m9062g();
        }
    }
}
