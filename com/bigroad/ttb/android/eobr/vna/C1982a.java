package com.bigroad.ttb.android.eobr.vna;

import com.bigroad.shared.eobr.EobrType;
import com.bigroad.ttb.android.eobr.C1888d;
import com.bigroad.ttb.android.eobr.C1902e;
import com.bigroad.ttb.android.eobr.C1902e.C1856a;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.p038g.C2078a;

public final class C1982a extends EobrDevice {
    public C1982a(C1888d c1888d, boolean z) {
        super(c1888d, z);
    }

    protected C1902e mo1117a(C2078a c2078a, C1856a c1856a) {
        return new C1992b(c2078a, c1856a, m8991c());
    }

    public EobrType mo1121o() {
        return this.a != null ? ((C1992b) this.a).m9874u() : EobrType.UNKNOWN_EOBR_TYPE;
    }

    public byte[] mo1120h() {
        return m8992d();
    }

    public String mo1122w() {
        return null;
    }
}
