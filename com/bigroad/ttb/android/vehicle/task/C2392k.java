package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.C1144s;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.eobr.vna.C1982a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.event.EventManager.C2018a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

abstract class C2392k {
    public static boolean m11715a(final C2032f c2032f, RelativeTimestamp relativeTimestamp, Event event, EobrDevice eobrDevice, ProcessingState processingState, final C2369i c2369i, final C2370j c2370j, final C2018a c2018a) {
        boolean z = true;
        EventManager i = c2032f.mo1301i();
        if (event == null) {
            C2134e.m10680d("TT-VehicleStateTaskUtils", "Failure to write EOBR event");
        } else if (!processingState.m11310a()) {
            C2134e.m10676b("TT-VehicleStateTaskUtils", "commitEobrEvent (not written): " + C1144s.m5763c(event));
        } else if (i.m10033b(event)) {
            boolean z2 = processingState == ProcessingState.TEMPORALLY_AT_CURSOR && event.getOccurredAt() < relativeTimestamp.getAbsoluteTimeMillis();
            if (!(processingState == ProcessingState.AT_CURSOR || z2)) {
                z = false;
            }
            if (z) {
                C2134e.m10676b("TT-VehicleStateTaskUtils", "Reprocessed cursor event: " + C1144s.m5763c(event));
            } else {
                C2134e.m10680d("TT-VehicleStateTaskUtils", "Unexpected duplicate event generation: " + C1144s.m5763c(event));
            }
        } else {
            C2134e.m10676b("TT-VehicleStateTaskUtils", "commitEobrEvent: " + C1144s.m5763c(event));
            if (eobrDevice instanceof C1982a) {
                i.m10046d(event);
                return true;
            } else if (i.m10024a(eobrDevice, event, new C2018a() {
                public void mo1288a(Event event) {
                    if (c2018a != null) {
                        c2018a.mo1288a(event);
                    }
                    C2379j a = C2386f.m11695a(c2032f, event, c2369i);
                    if (a != null) {
                        c2370j.m11629a(a);
                    }
                }
            })) {
                c2370j.m11626a().mo1286a(new C2393l(event.getEventId().m19091d(), c2032f));
                return true;
            }
        }
        return false;
    }
}
