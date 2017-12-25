package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.EventStatusMaskBits.RecordOrigin;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.event.C2022a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;

public class C2385e implements C2379j {
    private C2032f f8252a;
    private Event f8253b;

    public C2385e(C2032f c2032f) {
        this.f8252a = c2032f;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        if (relativeTimestamp == null || !relativeTimestamp.hasAbsoluteTimeMillis()) {
            return true;
        }
        switch (c2369i.m11615n()) {
            case ENGINE_ON:
                if (this.f8253b == null) {
                    this.f8253b = m11691a(EventType.ENGINE_ON, eobrDevice, c1015l, relativeTimestamp, c2358c, processingState, c2369i, c2370j, c1024d);
                    return this.f8253b != null;
                }
                break;
            case ENGINE_OFF:
                m11691a(EventType.ENGINE_OFF, eobrDevice, c1015l, relativeTimestamp, c2358c, processingState, c2369i, c2370j, c1024d);
                this.f8253b = null;
                return false;
        }
        return true;
    }

    private Event m11691a(EventType eventType, EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        Event a = C2022a.m10086a(eventType, null, RecordOrigin.AUTOMATICALLY_RECORDED, Long.valueOf(c2358c.m11506d()), relativeTimestamp.getAbsoluteTimeMillis(), null, c2369i, c1015l, relativeTimestamp, null, null, c2370j != null ? c2370j.m11626a() : null, this.f8252a);
        if (a == null) {
            C2134e.m10680d("TT-EngineUseTask", "Failed to create Engine Event");
            return null;
        }
        C2392k.m11715a(this.f8252a, relativeTimestamp, a, eobrDevice, processingState, c2369i, c2370j, null);
        return a;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
    }
}
