package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.C1130o;
import com.bigroad.shared.EldDrivingModeBits;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.am;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.C2371k;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.ActiveDrivingMode;
import com.bigroad.ttb.protocol.TTProtocol.DrivingModeChange;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public class C2383d implements C2379j {
    private final C2032f f8249a;
    private String f8250b;

    public static void m11687a(C2369i c2369i, ActiveDrivingMode activeDrivingMode, C2370j c2370j, C2032f c2032f) {
        if (c2369i != null && EldDrivingModeBits.m4064a(c2369i.m11613l()) != EldDrivingModeBits.m4064a(activeDrivingMode) && !c2370j.m11630a(C2383d.class)) {
            c2370j.m11629a(new C2383d(c2032f));
        }
    }

    public C2383d(C2032f c2032f) {
        this.f8249a = c2032f;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (!C1130o.m5714a(C2371k.m11631a(this.f8249a, c2369i))) {
            return false;
        }
        if (c1024d != null && c1024d.m5264d()) {
            DrivingModeChange e = c1024d.m5265e();
            if (e != null && e.hasEldSpecialModeNote()) {
                this.f8250b = e.getEldSpecialModeNote();
            }
        }
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return true;
        }
        if (processingState.m11310a()) {
            Event a = C2022a.m10086a(EventType.ELD_DRIVING_MODE, null, RecordOrigin.AUTOMATICALLY_RECORDED, c2358c.m11504b(), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp, null, Long.valueOf(EldDrivingModeBits.m4064a(c2369i.m11613l())), c2370j.m11626a(), this.f8249a);
            if (!(a == null || am.m4188a(this.f8250b))) {
                a = Event.newBuilder(a).m13856b(this.f8250b).m13862c();
            }
            this.f8249a.mo1301i().m10046d(a);
        }
        return false;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
    }
}
