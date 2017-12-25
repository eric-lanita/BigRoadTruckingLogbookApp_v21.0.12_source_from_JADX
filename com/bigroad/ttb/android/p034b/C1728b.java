package com.bigroad.ttb.android.p034b;

import com.bigroad.shared.C1144s;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.p022b.C0848a;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.ay;
import java.util.List;

public class C1728b extends C0848a {
    public static boolean m8445a(List<Event> list, Delta delta) {
        if (delta.getEventChangesCount() == 0) {
            return false;
        }
        List a = DutyStatus.m4386a(C0848a.m4263a((List) list, C0848a.m4262a((ay) delta)));
        List a2 = DutyStatus.m4386a(delta.getBeforeEventsList());
        if (a.size() != a2.size()) {
            return true;
        }
        for (int i = 0; i < a.size(); i++) {
            if (!C1144s.m5760a((Event) a.get(i), (Event) a2.get(i))) {
                return true;
            }
        }
        return false;
    }
}
