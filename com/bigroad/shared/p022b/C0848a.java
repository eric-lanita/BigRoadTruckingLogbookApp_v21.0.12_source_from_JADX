package com.bigroad.shared.p022b;

import com.bigroad.shared.C1142r;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.ai;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogChangeListEntry;
import com.bigroad.ttb.protocol.TTProtocol.Delta;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.EventChangeListEntry;
import com.bigroad.ttb.protocol.TTProtocol.ay;
import com.google.common.collect.Range;
import com.google.protobuf.C3642c;
import com.google.protobuf.InvalidProtocolBufferException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class C0848a {
    public static Delta m4260a(C3642c c3642c) {
        try {
            return Delta.parseFrom(c3642c);
        } catch (InvalidProtocolBufferException e) {
            return null;
        }
    }

    public static int m4256a(Delta delta, int i) {
        for (int i2 = 0; i2 < delta.getDailyLogChangesCount(); i2++) {
            if (delta.getDailyLogChanges(i2).getBeforeChange().getLogDay() == i) {
                return i2;
            }
        }
        return -1;
    }

    public static DailyLog m4259a(DailyLogChangeListEntry dailyLogChangeListEntry, DailyLog dailyLog) {
        if (C0848a.m4264a(dailyLog, dailyLogChangeListEntry.getBeforeChange())) {
            return C0848a.m4266b(dailyLog, dailyLogChangeListEntry.getAfterChange());
        }
        return null;
    }

    public static Range<Integer> m4261a(Delta delta) {
        return Range.m18692a(Integer.valueOf(delta.getStartLogDay()), Integer.valueOf(delta.getEndLogDay()));
    }

    public static Range<Long> m4262a(ay ayVar) {
        return Range.m18692a(Long.valueOf(ayVar.getStartEventTimestamp()), Long.valueOf(ayVar.getEndEventTimestamp()));
    }

    public static boolean m4264a(DailyLog dailyLog, DailyLog dailyLog2) {
        return ai.m4177a(C0848a.m4258a(dailyLog), C0848a.m4258a(dailyLog2));
    }

    private static DailyLog m4258a(DailyLog dailyLog) {
        return dailyLog.toBuilder().m13032J().m13031I().m13108y().m13109z().m13069c();
    }

    private static DailyLog m4266b(DailyLog dailyLog, DailyLog dailyLog2) {
        C2582a toBuilder = dailyLog2.toBuilder();
        if (dailyLog.hasAmendedAt()) {
            toBuilder.m13085g(dailyLog.getAmendedAt());
        } else {
            toBuilder.m13032J();
        }
        if (dailyLog.hasAmendedBy()) {
            toBuilder.m13049a(dailyLog.getAmendedBy());
        } else {
            toBuilder.m13031I();
        }
        if (dailyLog.hasDriverApproval()) {
            toBuilder.m13081f(dailyLog.getDriverApproval());
        } else {
            toBuilder.m13108y();
        }
        if (dailyLog.hasSignatureId()) {
            toBuilder.m13050a(dailyLog.getSignatureId());
        } else {
            toBuilder.m13109z();
        }
        return toBuilder.m13069c();
    }

    public static C1142r m4265b(Delta delta) {
        return C0848a.m4257a(delta.getEventChangesList());
    }

    public static C1142r m4257a(List<EventChangeListEntry> list) {
        C1142r c1142r = new C1142r();
        for (EventChangeListEntry eventChangeListEntry : list) {
            switch (eventChangeListEntry.getType()) {
                case CREATE_EVENT_CHANGE:
                    c1142r.m5747a(eventChangeListEntry.getEvent(), Collections.emptyList());
                    break;
                case UPDATE_EVENT_CHANGE:
                    c1142r.m5746a(eventChangeListEntry.getEvent());
                    break;
                case DELETE_EVENT_CHANGE:
                    c1142r.m5751b(eventChangeListEntry.getEvent());
                    break;
                default:
                    break;
            }
        }
        return c1142r;
    }

    public static List<Event> m4263a(List<Event> list, Range<Long> range) {
        List<Event> arrayList = new ArrayList();
        for (Event event : list) {
            if (range.m18695a(Long.valueOf(event.getOccurredAt()))) {
                arrayList.add(event);
            }
        }
        Collections.sort(arrayList, C1144s.f3800a);
        return arrayList;
    }
}
