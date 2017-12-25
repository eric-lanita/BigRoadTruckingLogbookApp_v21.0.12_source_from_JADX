package com.bigroad.ttb.android.vehicle.p041b;

import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.am;
import com.bigroad.shared.eobr.EobrSessionLogEntry;
import com.bigroad.shared.eobr.EobrSessionLogEntry.SessionState;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.task.C2389h;
import com.bigroad.ttb.android.vehicle.task.C2390i;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.VehicleIdentification;

public abstract class C2349g {
    public static C2369i m11478a(C2369i c2369i, C2348f c2348f, C2370j c2370j, C2032f c2032f) {
        if (c2348f == null || !c2348f.m11471f()) {
            throw new IllegalArgumentException("Unexpected type: " + (c2348f != null ? c2348f.getClass().getName() : "null"));
        }
        EobrSessionLogEntry g = c2348f.m11472g();
        if (g == null) {
            C2134e.m10682e("TT-SessionLEC", "Invalid session entry");
            return c2369i;
        }
        C2134e.m10678c("TT-SessionLEC", "Truck ID is " + g.mo753g() + " in mobile client session");
        Event a;
        if (g.mo756j() == SessionState.START) {
            C2369i c;
            if (g.mo753g() != c2369i.m11600b().getTruckId()) {
                Truck a2 = c2032f.mo1300h().m6552a(g.mo753g());
                if (a2 != null) {
                    String vin = c2369i.m11600b().getVin();
                    if (!(am.m4188a((CharSequence) vin) || am.m4189a(vin, a2.getVin()))) {
                        C2134e.m10680d("TT-SessionLEC", "Mismatch between VIN in vehicle state and VIN stored in truck record. vehicleState=" + vin + "; truck=" + a2.getVin());
                    }
                }
                c = C2369i.m11589a(c2369i).m11576a(VehicleIdentification.newBuilder(c2369i.m11600b()).m15899a(g.mo753g()).m15907c()).m11584c();
            } else {
                c = c2369i;
            }
            if (c2348f.mo1281l().hasAbsoluteTimeMillis()) {
                a = C2022a.m10086a(EventType.MOBILE_SESSION_START, null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(g.mo752f()), c2348f.mo1281l().getAbsoluteTimeMillis(), null, c, c2348f.m11468c(), c2348f.mo1281l(), null, null, c2370j.m11626a(), c2032f);
                if (a != null) {
                    c2370j.m11629a(new C2389h(c2032f, a));
                }
            } else {
                C2134e.m10676b("TT-SessionLEC", "MobileClientSessionLogEntry (start) no timestamp; skipping event creation.");
            }
            if (c2370j.m11630a(C2390i.class)) {
                return c;
            }
            c2370j.m11629a(new C2390i(c2032f));
            return c;
        } else if (g.mo756j() == SessionState.END) {
            C2134e.m10678c("TT-SessionLEC", "Ending mobile client session for truck ID " + g.mo753g());
            if (c2348f.mo1281l().hasAbsoluteTimeMillis()) {
                a = C2022a.m10086a(EventType.MOBILE_SESSION_END, null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(g.mo752f()), c2348f.mo1281l().getAbsoluteTimeMillis(), null, c2369i, c2348f.m11468c(), c2348f.mo1281l(), null, null, c2370j.m11626a(), c2032f);
                if (a == null) {
                    return c2369i;
                }
                c2370j.m11629a(new C2389h(c2032f, a));
                return c2369i;
            }
            C2134e.m10676b("TT-SessionLEC", "MobileClientSessionLogEntry (end) no timestamp; skipping event creation.");
            return c2369i;
        } else if (g.mo756j() != SessionState.STATUS || g.mo753g() == 0 || c2369i.m11600b().hasTruckId()) {
            return c2369i;
        } else {
            return C2369i.m11589a(c2369i).m11576a(VehicleIdentification.newBuilder(c2369i.m11600b()).m15899a(g.mo753g()).m15907c()).m11584c();
        }
    }
}
