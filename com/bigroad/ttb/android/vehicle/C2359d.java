package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.eobr.C0969b;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.android.util.C2295o;
import java.util.HashMap;

public class C2359d {
    private C2295o<C0969b, C1015l> f8133a = null;
    private HashMap<Integer, Integer> f8134b = new HashMap();

    public boolean m11514a(C0969b c0969b, C1015l c1015l) {
        if (c0969b == null) {
            return false;
        }
        EobrSessionLogEntry eobrSessionLogEntry;
        if (c0969b instanceof EobrSessionLogEntry) {
            eobrSessionLogEntry = (EobrSessionLogEntry) c0969b;
        } else {
            eobrSessionLogEntry = null;
        }
        if (eobrSessionLogEntry == null && !c0969b.mo746a()) {
            return false;
        }
        if (this.f8133a == null || c1015l.m5232c() > ((C1015l) this.f8133a.f7936b).m5232c()) {
            this.f8133a = new C2295o(c0969b, c1015l);
        }
        if (!(eobrSessionLogEntry == null || eobrSessionLogEntry.mo755i() == -1)) {
            m11513a(eobrSessionLogEntry.mo755i(), eobrSessionLogEntry.mo754h());
        }
        return true;
    }

    public void m11513a(int i, int i2) {
        this.f8134b.put(Integer.valueOf(i), Integer.valueOf(i2));
    }

    public C2295o<C0969b, C1015l> m11512a() {
        return this.f8133a;
    }

    public int m11511a(int i) {
        Integer num = (Integer) this.f8134b.get(Integer.valueOf(i));
        if (num != null) {
            return num.intValue();
        }
        return -1;
    }
}
