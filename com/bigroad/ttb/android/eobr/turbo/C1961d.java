package com.bigroad.ttb.android.eobr.turbo;

import com.bigroad.shared.eobr.turbo.C1011i;
import com.bigroad.shared.eobr.turbo.TurboData;
import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.C1038a;
import com.bigroad.shared.eobr.turbo.messages.C1042e;
import com.bigroad.shared.eobr.turbo.messages.C1051n;
import com.bigroad.shared.eobr.turbo.messages.C1054q;
import com.bigroad.shared.eobr.turbo.messages.C1056s;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;
import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage;
import com.bigroad.shared.eobr.turbo.messages.ab;
import com.bigroad.shared.eobr.turbo.messages.ad;
import com.bigroad.shared.eobr.turbo.messages.an;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.eobr.EobrReader;
import com.bigroad.ttb.android.eobr.RpmSource;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p038g.C2078a;
import java.io.InputStream;

public final class C1961d extends EobrReader {
    public C1961d(C1960c c1960c, C2078a c2078a) {
        super(c1960c, c2078a);
    }

    private void m9672a(TurboData turboData) {
        m9194d();
        if (turboData instanceof C1056s) {
            C1056s c1056s = (C1056s) turboData;
            m9184a(c1056s.f3461c, (byte) c1056s.f3462d, c1056s.f3463e, 0);
        } else if (turboData instanceof C1054q) {
            C1054q c1054q = (C1054q) turboData;
            m9182a((byte) c1054q.f3453b, c1054q.f3454c, c1054q.f3455d, 0);
        } else if (turboData instanceof ab) {
            ab abVar = (ab) turboData;
            m9183a((byte) abVar.f3396b, (short) ((abVar.f3397c << 8) | (abVar.f3398d & 255)), abVar.f3399e, 0);
        } else if (turboData instanceof ad) {
            m9185a((long) ((ad) turboData).f3403a);
            m9193c();
        } else if (turboData instanceof C1038a) {
            C1038a c1038a = (C1038a) turboData;
            ((C1960c) this.a).m9653a(c1038a.f3389b, c1038a.f3388a);
        } else if (turboData instanceof C1042e) {
            ((C1960c) this.a).m9660a((C1042e) turboData);
        } else if (turboData instanceof C1051n) {
            ((C1960c) this.a).m9661a((C1051n) turboData, OurApplication.m6269Z().mo914b(), OurApplication.m6269Z().mo915c());
        } else if (turboData instanceof an) {
            m9190a(((an) turboData).f3412a);
        }
        if (turboData instanceof TurboResponseMessage) {
            ((C1960c) this.a).m9659a((TurboResponseMessage) turboData);
        }
    }

    protected void mo1147a(InputStream inputStream) {
        C1011i c1011i = new C1011i(inputStream);
        while (!this.d) {
            try {
                m9672a(c1011i.m5152b());
                m9195e();
            } catch (Throwable e) {
                C2134e.m10668a(e.m5124a().m4086a(), "TT-TurboReader", "processInput", e);
            }
        }
    }

    protected void mo1145a(SpeedometerSource speedometerSource, int i, int i2, long j) {
    }

    protected void mo1144a(OdometerSource odometerSource, long j, long j2) {
    }

    protected void mo1146a(RpmSource rpmSource, int i) {
    }

    protected void mo1148b(String str) {
    }

    protected void mo1149f() {
    }
}
