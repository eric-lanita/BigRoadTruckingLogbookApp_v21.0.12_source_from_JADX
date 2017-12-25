package com.bigroad.shared.duty.rule;

import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.rule.C0950u.C0948a;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;

public class C0947t {
    private final long f2904a;
    private final long f2905b;
    private final TimeZone f2906c;
    private final C0948a f2907d;

    public static class C0946a {
        private final List<Event> f2901a;
        private final long f2902b;
        private final long f2903c;

        public C0946a(List<Event> list, long j, long j2) {
            this.f2901a = Collections.unmodifiableList(list);
            this.f2902b = j;
            this.f2903c = j2;
        }

        public C0946a(List<Event> list) {
            this(list, -1, -1);
        }

        public long m4803a() {
            return this.f2902b;
        }

        public long m4804b() {
            return this.f2903c;
        }

        public boolean m4805c() {
            return this.f2902b != -1;
        }

        public List<Event> m4806d() {
            List<Event> list = null;
            for (Event event : this.f2901a) {
                Object obj = null;
                if (event.hasCycleResetStartedAt() != m4805c()) {
                    obj = 1;
                } else if (m4805c() && event.getCycleResetStartedAt() != this.f2902b) {
                    r2 = 1;
                } else if (m4805c() && event.getCycleResetEndedAt() != this.f2903c) {
                    r2 = 1;
                }
                if (obj != null) {
                    if (list == null) {
                        list = new ArrayList();
                    }
                    list.add(event);
                }
            }
            return list == null ? Collections.emptyList() : list;
        }
    }

    private C0947t(long j, long j2, TimeZone timeZone) {
        this.f2904a = j;
        this.f2905b = j2;
        this.f2906c = timeZone;
        this.f2907d = new C0948a(this.f2906c);
    }

    public C0947t(TimeZone timeZone) {
        this(122400000, 604800000, timeZone);
    }

    public List<C0946a> m4810a(List<C0907o> list, List<Event> list2, long j) {
        if (list2.isEmpty()) {
            return Collections.emptyList();
        }
        Event event;
        int previousIndex;
        long j2 = 0;
        if ((((Event) list2.get(0)).getOccurredAt() > j ? 1 : null) == null) {
            ListIterator listIterator = list2.listIterator();
            int i = -1;
            Event event2 = null;
            while (listIterator.hasNext()) {
                event = (Event) listIterator.next();
                if (event.getOccurredAt() > j) {
                    if (i == -1) {
                        listIterator.previous();
                        previousIndex = listIterator.previousIndex();
                        if (previousIndex < 0) {
                            return Collections.emptyList();
                        }
                    }
                    previousIndex = i;
                    if (previousIndex < 0) {
                        return Collections.emptyList();
                    }
                } else if (DutyStatus.m4387b(event.getEventType())) {
                    int previousIndex2;
                    if (C0947t.m4808a(event2, event)) {
                        previousIndex2 = listIterator.previousIndex();
                    } else if (event2 == null || !C0947t.m4809b(event2, event)) {
                        previousIndex2 = i;
                    } else {
                        if (event2.hasCycleResetStartedAt()) {
                            j2 = event2.getCycleResetStartedAt();
                        }
                        previousIndex2 = -1;
                    }
                    i = previousIndex2;
                    event2 = event;
                }
            }
            previousIndex = i;
            if (previousIndex < 0) {
                return Collections.emptyList();
            }
        }
        previousIndex = 0;
        List<C0946a> arrayList = new ArrayList();
        List list3 = null;
        ListIterator listIterator2 = list2.listIterator(previousIndex);
        while (listIterator2.hasNext()) {
            event = (Event) listIterator2.next();
            if (DutyStatus.m4387b(event.getEventType())) {
                if (DutyStatus.m4383a(event.getEventType()).m4396d()) {
                    if (list3 == null) {
                        list3 = new ArrayList(1);
                    }
                    list3.add(event);
                } else if (list3 != null) {
                    j2 = m4807a(arrayList, j2, list, list3, event.getOccurredAt());
                    list3 = null;
                }
            }
        }
        if (list3 == null) {
            return arrayList;
        }
        arrayList.add(new C0946a(list3));
        return arrayList;
    }

    private static boolean m4808a(Event event, Event event2) {
        return (event == null || DutyStatus.m4383a(event.getEventType()).m4395c()) && DutyStatus.m4383a(event2.getEventType()).m4396d();
    }

    private static boolean m4809b(Event event, Event event2) {
        return DutyStatus.m4383a(event.getEventType()).m4396d() && DutyStatus.m4383a(event2.getEventType()).m4395c();
    }

    private long m4807a(List<C0946a> list, long j, List<C0907o> list2, List<Event> list3, long j2) {
        long occurredAt = ((Event) list3.get(0)).getOccurredAt();
        boolean a = this.f2907d.m4813a(occurredAt, j2);
        if (a) {
            occurredAt = Math.max(occurredAt, this.f2905b + j);
        }
        if (j2 - occurredAt < this.f2904a) {
            list.add(new C0946a(list3));
            return j;
        }
        if (a) {
            int i = 0;
            Calendar c = DailyLogUtils.m4294a((List) list2, occurredAt, this.f2906c).m4586c();
            Calendar a2 = aq.m4222a(c);
            while (c.getTimeInMillis() < j2 && i < 2) {
                a2.setTimeInMillis(c.getTimeInMillis());
                aq.m4223a(a2, 1, 0);
                if (a2.getTimeInMillis() >= occurredAt) {
                    aq.m4223a(a2, 5, 0);
                    if (a2.getTimeInMillis() <= j2) {
                        i++;
                    }
                }
                c.add(5, 1);
            }
            if (i < 2) {
                list.add(new C0946a(list3));
                return j;
            }
        }
        list.add(new C0946a(list3, occurredAt, j2));
        return occurredAt;
    }
}
