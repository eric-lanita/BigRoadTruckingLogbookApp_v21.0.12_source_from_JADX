package com.bigroad.ttb.android.vehicle;

import com.bigroad.shared.ap;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice.EngineUseState;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.model.C2182e.C2181a;
import com.bigroad.ttb.android.util.C2294n;
import com.bigroad.ttb.android.vehicle.C2369i.C2368a;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.Truck;

public abstract class C2371k {
    public static boolean m11634a(RelativeTimestamp relativeTimestamp, ap apVar) {
        if (relativeTimestamp == null || !relativeTimestamp.hasAbsoluteTimeMillis()) {
            return false;
        }
        return C2371k.m11633a(relativeTimestamp.getAbsoluteTimeMillis(), apVar.mo914b());
    }

    public static boolean m11633a(long j, long j2) {
        return Math.abs(j2 - j) <= 15000;
    }

    public static Truck m11631a(C2032f c2032f, C2369i c2369i) {
        if (c2032f.mo1300h() == null) {
            return null;
        }
        if (c2369i.m11603c()) {
            return c2032f.mo1300h().m6552a(c2369i.m11605d().longValue());
        }
        return c2032f.mo1300h().m6578f();
    }

    public static void m11632a(EngineUseState engineUseState, EngineUseState engineUseState2, C2182e c2182e, C2182e c2182e2, C2368a c2368a) {
        if (engineUseState == EngineUseState.ENGINE_OFF) {
            c2182e = null;
        }
        if (engineUseState2 == EngineUseState.ENGINE_ON && c2182e == null) {
            if (c2182e2 != null) {
                c2182e = c2182e2;
            } else {
                c2182e = new C2181a().m10814a();
            }
        } else if (!(c2182e == null || c2182e2 == null)) {
            c2182e = C2294n.m11242a(c2182e, c2182e2);
        }
        c2368a.m11581b(c2182e);
    }
}
