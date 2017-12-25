package com.bigroad.ttb.android.event;

import com.bigroad.shared.C1144s;
import com.bigroad.shared.eobr.C0972e;
import com.bigroad.shared.eobr.C0973f;
import com.bigroad.shared.eobr.genx.C0991q;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.shared.eobr.turbo.logs.EobrEventLogData;
import com.bigroad.shared.eobr.turbo.messages.C1043f;
import com.bigroad.shared.eobr.turbo.messages.C1044g;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.C1902e.C1206c;
import com.bigroad.ttb.android.event.EventManager.C2019b;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.util.C2297q;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.ExternalVarEntry;
import com.google.protobuf.InvalidProtocolBufferException;
import java.io.IOException;

class C2026c implements C1206c {
    private final EventManager f6999a;
    private final C2032f f7000b;

    C2026c(EventManager eventManager, C2032f c2032f) {
        this.f6999a = eventManager;
        this.f7000b = c2032f;
    }

    public void mo897a(C0972e c0972e, C0973f c0973f) {
        String str = null;
        if (c0973f != null) {
            Event event;
            boolean z;
            if (c0972e instanceof C1043f) {
                Event b;
                try {
                    b = EobrEventLogData.m5242b(((C1043f) c0972e).f3432a);
                } catch (IOException e) {
                    b = null;
                }
                event = b;
                z = true;
            } else if (c0972e instanceof C0991q) {
                boolean e2 = ((C0991q) c0972e).m5086e();
                try {
                    boolean z2 = e2;
                    event = ((C0991q) c0972e).m5088h();
                    z = z2;
                } catch (IOException e3) {
                    z = e2;
                    event = null;
                }
            } else {
                z = false;
                event = null;
            }
            if (!z) {
                ExternalVarEntry externalVarEntry;
                if (c0972e instanceof C1044g) {
                    ExternalVarEntry parseFrom;
                    try {
                        parseFrom = ExternalVarEntry.parseFrom(((C1044g) c0972e).f3433a);
                    } catch (InvalidProtocolBufferException e4) {
                        parseFrom = null;
                    }
                    externalVarEntry = parseFrom;
                    z = true;
                } else if (c0972e instanceof C0991q) {
                    z = ((C0991q) c0972e).m5085d();
                    C1024d f = ((C0991q) c0972e).m5087f();
                    externalVarEntry = (f == null || !f.m5261a()) ? null : f.m5270j();
                } else {
                    z = false;
                    externalVarEntry = null;
                }
                if (!z) {
                    return;
                }
                if (externalVarEntry == null || !c0973f.mo744f()) {
                    String str2 = "TT-WriteEobrMsgCallback";
                    StringBuilder append = new StringBuilder().append("ExternalEvent not written. status=").append(c0973f.mo745g()).append("; requestType=");
                    if (externalVarEntry != null) {
                        str = externalVarEntry.getEntryType().name();
                    }
                    C2134e.m10680d(str2, append.append(str).toString());
                    return;
                }
                C2134e.m10676b("TT-WriteEobrMsgCallback", "Wrote ExternalEvent:" + externalVarEntry.getEntryType().name());
            } else if (event == null || !c0973f.mo744f()) {
                C2134e.m10680d("TT-WriteEobrMsgCallback", "EOBR event not written. status=" + c0973f.mo745g() + "; event=" + C2297q.m11245a(event));
                if (event != null) {
                    this.f6999a.m10000a(event.getEventId());
                }
            } else if (this.f6999a.m10034b(event.getEventId())) {
                C2019b a = this.f6999a.m10000a(event.getEventId());
                C2134e.m10678c("TT-WriteEobrMsgCallback", "EOBR event written: " + C1144s.m5763c(event));
                this.f6999a.m10040c(event);
                if (a.f6951b != null) {
                    a.f6951b.mo1288a(event);
                }
                this.f7000b.mo1313u().m9058c();
            } else {
                C2134e.m10680d("TT-WriteEobrMsgCallback", "Confirmed EOBR event write for unexpected event: " + C2297q.m11245a(event));
            }
        }
    }
}
