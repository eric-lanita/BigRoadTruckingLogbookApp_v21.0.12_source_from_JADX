package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.aobrd.MalfunctionReason;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public class C2390i implements C2379j {
    private final C2032f f8268a;
    private final EventManager f8269b;
    private final C2474y f8270c;

    public C2390i(C2032f c2032f) {
        this.f8268a = c2032f;
        this.f8269b = c2032f.mo1301i();
        this.f8270c = c2032f.mo1295c();
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (!relativeTimestamp.hasAbsoluteTimeMillis() || !c2358c.m11510h()) {
            return true;
        }
        Long b = c2358c.m11504b();
        if (b == null || b.longValue() != this.f8270c.m12202d()) {
            return true;
        }
        if (!c2370j.m11630a(C2388g.class)) {
            c2370j.m11629a(new C2388g(this.f8268a));
        }
        if (!c2370j.m11630a(C2382c.class)) {
            Event a = this.f8269b.m10001a(relativeTimestamp.getAbsoluteTimeMillis(), b.longValue(), MalfunctionReason.DUTY_STATUS_CONFLICT);
            if (a != null) {
                C2382c.m11683a(a, relativeTimestamp.getAbsoluteTimeMillis(), this.f8269b);
            }
        }
        return false;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
    }
}
