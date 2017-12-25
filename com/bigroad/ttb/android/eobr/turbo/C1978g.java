package com.bigroad.ttb.android.eobr.turbo;

import com.bigroad.shared.eobr.C0971c;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.messages.C1058u;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.logging.C2134e;
import java.io.IOException;
import java.util.List;

abstract class C1978g {

    interface C1975a {
        C1015l mo1167a(C1015l c1015l);

        VarPage mo1168a(EobrDevice eobrDevice, long j, VarPage varPage, byte[] bArr);

        void mo1169a(long j, long j2, String str);

        void mo1170a(long j, String str);

        void mo1171a(C1058u c1058u);

        void mo1172a(VarPage varPage);

        void mo1173a(Long l);

        void mo1098b(long j);

        boolean mo1174c(long j);

        VarPage mo1175d(long j);

        void m9722g();

        long mo1116x();

        C2032f mo1176z();
    }

    static void m9810a(C1975a c1975a, C1015l c1015l, List<C0971c> list) {
        Object obj;
        do {
            VarPage d = c1975a.mo1175d(c1015l.m5228a());
            if (d == null) {
                c1975a.mo1170a(c1015l.m5228a(), "Fetch for cursor " + c1015l);
                return;
            }
            if (!d.m9625r()) {
                d = C1978g.m9809a(c1975a, d);
            }
            if (!(d.m9626s() || d.m9619l())) {
                VarPage d2 = c1975a.mo1175d(c1015l.m5228a() - 1);
                if (d2 == null || !d2.m9621n()) {
                    return;
                }
            }
            try {
                switch (d.m9600a((long) (c1015l.m5230b() + 1), (List) list)) {
                    case MORE_EXPECTED:
                        if (c1975a.mo1174c(c1015l.m5228a())) {
                            c1975a.mo1170a(c1015l.m5228a(), "Complete page for cursor " + c1015l);
                            return;
                        }
                        break;
                    case COMPLETE:
                        if (list.isEmpty()) {
                            c1015l = c1975a.mo1167a(c1015l.m5233d());
                            obj = 1;
                            continue;
                        }
                        break;
                    case ERROR:
                        obj = null;
                        continue;
                }
            } catch (IOException e) {
                C2134e.m10680d("TT-VarPTS", "Unable to timestamp VAR page: " + d);
            }
            obj = null;
            continue;
        } while (obj != null);
    }

    static VarPage m9809a(C1975a c1975a, VarPage varPage) {
        long j;
        VarPage d;
        long b = varPage.m9607b();
        long b2 = varPage.m9607b();
        if (!varPage.m9619l()) {
            j = b - 1;
            while (j >= c1975a.mo1116x()) {
                d = c1975a.mo1175d(j);
                if (d != null && d.m9611d()) {
                    b2 = d.m9607b();
                    if (d.m9619l() || d.m9621n()) {
                        break;
                    }
                    j--;
                } else {
                    c1975a.mo1169a(varPage.m9607b(), j, "Prior page for " + varPage.m9607b());
                    return varPage;
                }
            }
        }
        Object obj = b2 == c1975a.mo1116x() ? 1 : null;
        if (b2 == b) {
            d = varPage.m9601a(null);
            C1978g.m9811a(c1975a, varPage, d);
        } else if (b2 < b) {
            d = c1975a.mo1175d(b2);
            if (!(obj == null && (d == null || !d.m9619l() || d.m9625r()))) {
                VarPage a = d.m9601a(null);
                C1978g.m9811a(c1975a, d, a);
                d = a;
            }
            j = b2 + 1;
            VarPage varPage2 = d;
            d = varPage;
            while (j <= b) {
                VarPage d2;
                if (j != b) {
                    d2 = c1975a.mo1175d(j);
                } else {
                    d2 = varPage;
                }
                varPage2 = d2.m9601a(varPage2);
                C1978g.m9811a(c1975a, d2, varPage2);
                if (varPage2.m9607b() == b) {
                    d2 = varPage2;
                } else {
                    d2 = d;
                }
                j++;
                d = d2;
            }
        } else {
            d = varPage;
        }
        return d;
    }

    private static void m9811a(C1975a c1975a, VarPage varPage, VarPage varPage2) {
        if (varPage2 != varPage) {
            c1975a.mo1172a(varPage2);
        }
    }
}
