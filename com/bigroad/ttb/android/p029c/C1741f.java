package com.bigroad.ttb.android.p029c;

import com.bigroad.shared.model.C0864i;
import com.bigroad.ttb.android.C2032f;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.List;
import java.util.Map;

public class C1741f implements C0864i {
    private static C1741f f6035a;
    private final TruckManager f6036b;
    private final EventManager f6037c;

    public static C1741f m8534a(C2032f c2032f) {
        if (f6035a == null) {
            f6035a = new C1741f(c2032f);
        }
        return f6035a;
    }

    private C1741f(C2032f c2032f) {
        this.f6036b = c2032f.mo1300h();
        this.f6037c = c2032f.mo1301i();
    }

    public List<Event> mo699a() {
        return this.f6037c.m10025b();
    }

    public Map<Long, Truck> mo700b() {
        return this.f6036b.m6576e();
    }
}
