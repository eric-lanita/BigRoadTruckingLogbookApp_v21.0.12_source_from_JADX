package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.C1100l;
import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.aobrd.DutyStatusConflict;
import com.bigroad.ttb.android.aobrd.MalfunctionReason;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import java.util.Set;

public class C2382c implements C2379j {
    private final C2032f f8246a;
    private final EventManager f8247b;
    private Event f8248c = null;

    public C2382c(C2032f c2032f) {
        this.f8246a = c2032f;
        this.f8247b = this.f8246a.mo1301i();
    }

    private Event m11682a(long j) {
        this.f8248c = C2382c.m11683a(this.f8248c, j, this.f8247b);
        return this.f8248c;
    }

    public static Event m11683a(Event event, long j, EventManager eventManager) {
        if (event == null) {
            return null;
        }
        long a = C1100l.m5449a(event.getContextualData(), j);
        if (a == event.getContextualData()) {
            return event;
        }
        event = Event.newBuilder(event).m13879g(a).m13862c();
        eventManager.m10067q().m9968a(event.getEventId().m19091d(), a);
        return event;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return true;
        }
        if (c2370j.m11630a(DrivingTask.class)) {
            Set a = DutyStatusConflict.m8428a(DailyLogUtils.m4283a(relativeTimestamp.getAbsoluteTimeMillis()), this.f8246a);
            if (a.isEmpty()) {
                m11682a(relativeTimestamp.getAbsoluteTimeMillis());
                this.f8248c = null;
                return false;
            }
            long d = c2358c.m11506d();
            MalfunctionReason malfunctionReason = MalfunctionReason.DUTY_STATUS_CONFLICT;
            long a2 = DutyStatusConflict.m8426a(0, a);
            long absoluteTimeMillis = relativeTimestamp.getAbsoluteTimeMillis() + 300000;
            if (!(this.f8248c == null || a2 == C1100l.m5448a(this.f8248c.getContextualData()))) {
                this.f8248c = null;
            }
            if (this.f8248c == null) {
                this.f8248c = this.f8247b.m10002a(relativeTimestamp.getAbsoluteTimeMillis(), d, malfunctionReason, a2, 15);
            }
            if (this.f8248c == null) {
                this.f8248c = C2022a.m10086a(malfunctionReason.m8431a(), malfunctionReason.m8432b(), RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(d), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp, null, Long.valueOf(C1100l.m5449a(a2, absoluteTimeMillis)), c2370j.m11626a(), this.f8246a);
                C2392k.m11715a(this.f8246a, relativeTimestamp, this.f8248c, eobrDevice, processingState, c2369i, c2370j, null);
            } else {
                m11682a(absoluteTimeMillis);
            }
            return this.f8248c != null;
        } else {
            m11682a(relativeTimestamp.getAbsoluteTimeMillis());
            this.f8248c = null;
            return false;
        }
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
        this.f8247b.m10067q().m9966a();
    }
}
