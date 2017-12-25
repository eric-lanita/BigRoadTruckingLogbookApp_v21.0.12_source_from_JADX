package com.bigroad.shared;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class C1146u implements C1101m {
    private final List<Event> f3803a;

    public C1146u(List<Event> list) {
        this.f3803a = list;
    }

    public List<Event> mo822a(int i, TimeZone timeZone) {
        long timeInMillis = DailyLogUtils.m4298a(i, timeZone).getTimeInMillis();
        long timeInMillis2 = DailyLogUtils.m4304b(i, timeZone).getTimeInMillis();
        List<Event> arrayList = new ArrayList();
        Object obj = null;
        for (Event event : this.f3803a) {
            if (DutyStatus.m4387b(event.getEventType())) {
                long occurredAt = event.getOccurredAt();
                if (occurredAt >= timeInMillis) {
                    if (arrayList.isEmpty() && obj != null) {
                        arrayList.add(obj);
                    }
                    arrayList.add(event);
                    if (occurredAt >= timeInMillis2) {
                        break;
                    }
                }
                obj = event;
            }
        }
        if (arrayList.isEmpty() && obj != null) {
            arrayList.add(obj);
        }
        return arrayList;
    }
}
