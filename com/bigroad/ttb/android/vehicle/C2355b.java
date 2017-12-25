package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.EobrSessionLogEntry.SessionState;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.HashMap;
import java.util.Map;

public class C2355b {
    private final Truck f8114a;
    private final Map<Integer, C2340a> f8115b = new HashMap();
    private C1015l f8116c;

    private static class C2340a {
        boolean f8109a;

        private C2340a() {
        }
    }

    public C2355b(Truck truck) {
        this.f8114a = truck;
    }

    public long m11491a() {
        return this.f8114a.getTruckId();
    }

    public void m11492a(EobrSessionLogEntry eobrSessionLogEntry, C1015l c1015l) {
        if (this.f8116c == null || this.f8116c.m5231b(c1015l) < 0) {
            if (eobrSessionLogEntry.mo756j() == SessionState.START) {
                m11486a(eobrSessionLogEntry);
            } else if (eobrSessionLogEntry.mo756j() == SessionState.END) {
                m11487b(eobrSessionLogEntry);
            }
            this.f8116c = c1015l;
        }
    }

    private void m11486a(EobrSessionLogEntry eobrSessionLogEntry) {
        if (m11490e(eobrSessionLogEntry.mo755i())) {
            m11488c(eobrSessionLogEntry.mo754h());
        } else {
            m11485a(eobrSessionLogEntry.mo755i(), eobrSessionLogEntry.mo754h());
        }
    }

    private void m11487b(EobrSessionLogEntry eobrSessionLogEntry) {
        m11489d(eobrSessionLogEntry.mo754h());
    }

    private void m11488c(int i) {
        this.f8115b.put(Integer.valueOf(i), new C2340a());
    }

    private void m11485a(int i, int i2) {
        Object obj = (C2340a) this.f8115b.get(Integer.valueOf(i));
        if (obj == null) {
            obj = new C2340a();
            this.f8115b.put(Integer.valueOf(i), obj);
        }
        this.f8115b.put(Integer.valueOf(i2), obj);
    }

    private void m11489d(int i) {
        if (((C2340a) this.f8115b.get(Integer.valueOf(i))) == null) {
            this.f8115b.put(Integer.valueOf(i), new C2340a());
        }
    }

    private boolean m11490e(int i) {
        return i == -1;
    }

    public boolean m11493a(int i) {
        C2340a c2340a = (C2340a) this.f8115b.get(Integer.valueOf(i));
        return c2340a != null && c2340a.f8109a;
    }

    public void m11494b(int i) {
        C2340a c2340a = (C2340a) this.f8115b.get(Integer.valueOf(i));
        if (c2340a != null) {
            c2340a.f8109a = true;
        }
    }
}
