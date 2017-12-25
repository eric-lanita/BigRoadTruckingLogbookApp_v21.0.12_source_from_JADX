package com.bigroad.ttb.android.vehicle.task;

import com.bigroad.shared.as;
import com.bigroad.shared.eobr.turbo.C1015l;
import com.bigroad.shared.eobr.turbo.logs.C1024d;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.eobr.EobrDevice;
import com.bigroad.ttb.android.model.C2182e;
import com.bigroad.ttb.android.vehicle.C2358c;
import com.bigroad.ttb.android.vehicle.C2369i;
import com.bigroad.ttb.android.vehicle.C2370j;
import com.bigroad.ttb.android.vehicle.ProcessingState;
import com.bigroad.ttb.protocol.TTProtocol.Breadcrumb;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.RelativeTimestamp;
import com.google.protobuf.C3642c;

public class C2386f implements C2379j {
    private static final long f8254a = Math.round(as.m4245d(0.1d));
    private final C2032f f8255b;
    private byte[] f8256c;
    private C2182e f8257d;

    public C2386f(C2032f c2032f, byte[] bArr, C2182e c2182e) {
        this.f8255b = c2032f;
        this.f8256c = bArr;
        this.f8257d = c2182e;
    }

    private static boolean m11696a(Event event) {
        return (event == null || (event.hasLatitudeE6() && event.hasLongitudeE6())) ? false : true;
    }

    public static C2386f m11695a(C2032f c2032f, Event event, C2369i c2369i) {
        if (C2386f.m11696a(event)) {
            return new C2386f(c2032f, event.getEventId().m19091d(), c2369i.m11609h());
        }
        return null;
    }

    public boolean mo1291a(EobrDevice eobrDevice, C1015l c1015l, RelativeTimestamp relativeTimestamp, C2358c c2358c, ProcessingState processingState, C2369i c2369i, C2370j c2370j, C1024d c1024d) {
        Event c;
        Event a = this.f8255b.mo1301i().m10005a(this.f8256c);
        if (a == null) {
            c = this.f8255b.mo1301i().m10038c(C3642c.m19078a(this.f8256c));
        } else {
            c = a;
        }
        if (c == null) {
            return false;
        }
        C2647a c2647a;
        boolean z;
        C2647a c2647a2 = null;
        boolean z2 = false;
        if (C2386f.m11696a(c)) {
            if (this.f8257d == null) {
                this.f8257d = c2369i.m11609h();
            }
            Long l = null;
            if (this.f8257d != null && c2369i.m11608g()) {
                l = c2369i.m11609h().m10820a(this.f8257d);
            }
            if (l == null || l.longValue() <= f8254a) {
                z2 = true;
                if (c2369i.m11606e()) {
                    Breadcrumb f = c2369i.m11607f();
                    if (f != null && f.hasLatitudeE6() && f.hasLongitudeE6()) {
                        if (null == null) {
                            c2647a2 = Event.newBuilder(c);
                        }
                        c2647a2.m13852b(f.getLatitudeE6());
                        c2647a2.m13858c(f.getLongitudeE6());
                        if (f.hasAccuracy()) {
                            c2647a2.m13841a(f.getAccuracy());
                        }
                        c2647a = c2647a2;
                        z = true;
                        if (c2647a != null) {
                            return z;
                        }
                        this.f8255b.mo1301i().m10057h(c2647a.m13862c());
                        return false;
                    }
                }
            }
        }
        boolean z3 = z2;
        c2647a = null;
        z = z3;
        if (c2647a != null) {
            return z;
        }
        this.f8255b.mo1301i().m10057h(c2647a.m13862c());
        return false;
    }

    public void mo1290a(C2358c c2358c, ProcessingState processingState, C2370j c2370j) {
    }

    public void mo1289a() {
    }
}
