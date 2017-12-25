package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.DutyStatusChangeBits;
import com.bigroad.shared.DutyStatusChangeBits.Reason;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.MotionType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.bigroad.ttb.protocol.TTProtocol.VarDutyStatusChange;

public class C2380a implements C2379j {
    private static final long f8242b = DutyStatusChangeBits.m4033a(Reason.EOBR_DUTY_STATUS_SELECTED);
    private final C2032f f8243a;

    public C2380a(C2032f c2032f) {
        this.f8243a = c2032f;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (c2369i.m11612k().getMotionType() == MotionType.MOVING) {
            C2134e.m10680d("TT-DriverDutyStatusTask", "Duty status change during motion");
            return false;
        }
        if (!c1024d.m5262b()) {
            C2134e.m10680d("TT-DriverDutyStatusTask", "Unexpected external event: " + C2297q.m11245a(c1024d.m5270j()));
        } else if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return false;
        } else {
            VarDutyStatusChange c = c1024d.m5263c();
            DutyStatus a = DutyStatus.m4383a(c.getEventType());
            String str = null;
            if (c.hasLocationName() && !am.m4188a(c.getLocationName())) {
                str = c.getLocationName();
            }
            Event a2 = C2022a.m10086a(a.m4392a(), null, RecordOrigin.AUTOMATICALLY_RECORDED, c2358c.m11504b(), relativeTimestamp.getAbsoluteTimeMillis(), str, c2369i, c1015l, relativeTimestamp, null, Long.valueOf(f8242b), c2370j.m11626a(), this.f8243a);
            if (a2 != null) {
                if (c.hasNotes() && !am.m4188a(c.getNotes())) {
                    a2 = Event.newBuilder(a2).m13856b(c.getNotes()).m13862c();
                }
                C2392k.m11715a(this.f8243a, relativeTimestamp, a2, eobrDevice, processingState, c2369i, c2370j, null);
                if (c1024d.m5263c().getSignOutRequested()) {
                    this.f8243a.mo1315w().m8040a(a2.getEventId().m19091d());
                }
            }
        }
        return false;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
    }
}
