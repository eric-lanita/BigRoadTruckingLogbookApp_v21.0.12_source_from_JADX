package com.bigroad.shared;

import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;
import java.util.TimeZone;

public class C1130o {
    private static final Set<EventType> f3783a = EnumSet.of(EventType.ENGINE_OFF, new EventType[]{EventType.ENGINE_ON, EventType.INTERMEDIATE_DRIVING, EventType.DRIVER_LOGIN, EventType.DRIVER_LOGOUT, EventType.ELD_DRIVING_MODE});
    private static final Set<EventType> f3784b = EnumSet.of(EventType.OFF_DUTY, new EventType[]{EventType.SLEEPER, EventType.DRIVING, EventType.OFF_DUTY_DRIVING, EventType.ON_DUTY_NOT_DRIVING, EventType.DRIVER_LOGIN, EventType.DRIVER_LOGOUT, EventType.INTERMEDIATE_DRIVING, EventType.ENGINE_ON, EventType.ENGINE_OFF, EventType.CERTIFY_DAILY_LOG, EventType.ELD_YARD_MOVE, EventType.ELD_DRIVING_MODE});

    public static boolean m5712a(Event event) {
        return event != null && event.hasSequenceId();
    }

    public static boolean m5714a(Truck truck) {
        return truck != null && truck.getTruckLogType() == 3;
    }

    public static List<Event> m5709a(List<Event> list, int i, TimeZone timeZone) {
        long timeInMillis = DailyLogUtils.m4298a(i, timeZone).getTimeInMillis();
        long timeInMillis2 = DailyLogUtils.m4304b(i, timeZone).getTimeInMillis();
        List<Event> arrayList = new ArrayList();
        for (Event event : list) {
            EventType a = EventType.m13979a(event.getEventType());
            if (C1130o.m5712a(event) && f3783a.contains(a)) {
                long occurredAt = event.getOccurredAt();
                if (occurredAt < timeInMillis) {
                    continue;
                } else if (occurredAt > timeInMillis2) {
                    break;
                } else {
                    arrayList.add(event);
                }
            }
        }
        return arrayList;
    }

    public static boolean m5710a(int i) {
        return C1130o.m5713a(EventType.m13979a(i));
    }

    public static boolean m5713a(EventType eventType) {
        return f3783a.contains(eventType);
    }

    public static boolean m5717b(EventType eventType) {
        return f3784b.contains(eventType);
    }

    public static boolean m5711a(int i, boolean z) {
        if (DutyStatus.m4387b(i)) {
            return true;
        }
        if (z) {
            return C1130o.m5710a(i);
        }
        return false;
    }

    public static boolean m5716b(Event event) {
        return C1130o.m5711a(event.getEventType(), event.hasSequenceId());
    }

    public static boolean m5715a(String str) {
        if (!am.m4188a((CharSequence) str) && str.length() >= 4 && str.length() <= 60) {
            return true;
        }
        return false;
    }
}
