package com.bigroad.ttb.android.eobr.genx;

import com.bigroad.shared.eobr.EobrType;
import com.bigroad.ttb.android.eobr.C1888d;
import com.bigroad.ttb.android.eobr.C1902e;
import com.bigroad.ttb.android.eobr.C1902e.C1856a;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.p038g.C2078a;

public final class C1916b extends EobrDevice {
    public C1916b(C1888d c1888d, boolean z) {
        super(c1888d, z);
    }

    protected C1902e mo1117a(C2078a c2078a, C1856a c1856a) {
        return new C1919c(c2078a, c1856a);
    }

    public EobrType mo1121o() {
        return EobrType.GENX;
    }

    public String mo1118f() {
        return mo1119g();
    }

    public String mo1119g() {
        return m8993e() == null ? null : m8993e().replace("GENX_", "");
    }

    public byte[] mo1120h() {
        String g = mo1119g();
        return g != null ? g.getBytes() : null;
    }

    public String mo1122w() {
        return "001G";
    }
}
