package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2355b;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public class C2381b implements C2379j {
    private final C2355b f8244a;
    private final C2032f f8245b;

    public C2381b(C2355b c2355b, C2032f c2032f) {
        this.f8244a = c2355b;
        this.f8245b = c2032f;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (!relativeTimestamp.hasAbsoluteTimeMillis()) {
            return true;
        }
        Event a = C2022a.m10086a(EventType.DRIVER_LOGIN, null, RecordOrigin.AUTOMATICALLY_RECORDED, c2358c.m11504b(), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp, null, Long.valueOf((long) c2358c.m11508f().intValue()), c2370j.m11626a(), this.f8245b);
        if (a != null) {
            C2134e.m10678c("TT-EobrLoginLogout", "Recording login of session " + a.getContextualData());
            if (processingState.m11310a()) {
                this.f8245b.mo1301i().m10046d(a);
            }
        }
        this.f8244a.m11494b(c2358c.m11508f().intValue());
        return false;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
    }
}
