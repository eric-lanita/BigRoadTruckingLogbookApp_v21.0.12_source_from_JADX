package com.bigroad.shared;

import com.bigroad.shared.EventStatusMaskBits.RecordStatus;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.facebook.internal.NativeProtocol;
import com.google.common.base.Predicate;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class DutyStatusEventMerger {
    private static final Comparator<Event> f2509o = new C08191();
    private static Predicate<Event> f2510p = new C08202();
    private static Predicate<Event> f2511q = new C08213();
    private static Predicate<Event> f2512r = new C08224();
    private final Policy f2513a;
    private final int f2514b;
    private final TimeZone f2515c;
    private final long f2516d;
    private final long f2517e;
    private List<Event> f2518f;
    private List<Event> f2519g;
    private Event f2520h = null;
    private long f2521i = -1;
    private long f2522j = -1;
    private boolean f2523k = false;
    private final C1142r f2524l = new C1142r();
    private boolean f2525m = false;
    private List<ao> f2526n = Collections.emptyList();

    static class C08191 implements Comparator<Event> {
        C08191() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4040a((Event) obj, (Event) obj2);
        }

        public int m4040a(Event event, Event event2) {
            if (event == null) {
                return -1;
            }
            if (event2 == null) {
                return 1;
            }
            return ai.f2620a.compare(event.getEventId(), event2.getEventId());
        }
    }

    static class C08202 implements Predicate<Event> {
        C08202() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m4041a((Event) obj);
        }

        public boolean m4041a(Event event) {
            return event != null && C0890f.m4501a(event);
        }
    }

    static class C08213 implements Predicate<Event> {
        C08213() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m4042a((Event) obj);
        }

        public boolean m4042a(Event event) {
            return event != null && (C0890f.m4501a(event) || C1130o.m5712a(event));
        }
    }

    static class C08224 implements Predicate<Event> {
        C08224() {
        }

        public /* synthetic */ boolean apply(Object obj) {
            return m4043a((Event) obj);
        }

        public boolean m4043a(Event event) {
            return false;
        }
    }

    public enum Policy {
        PROTECT_ELD_AND_IMMUTABLE_SEGMENTS,
        PROTECT_IMMUTABLE_SEGMENTS,
        FAIL_ON_IMMUTABLE_CHANGE,
        ALLOW_ALL
    }

    public DutyStatusEventMerger(Policy policy, List<Event> list, int i, TimeZone timeZone, long j) {
        this.f2519g = new ArrayList(list.size());
        this.f2518f = new ArrayList(list.size());
        for (Event event : list) {
            if (C1130o.m5710a(event.getEventType())) {
                this.f2518f.add(event);
            } else if (DutyStatus.m4387b(event.getEventType())) {
                this.f2519g.add(event);
            }
        }
        this.f2513a = policy;
        this.f2514b = i;
        this.f2515c = timeZone;
        this.f2516d = DailyLogUtils.m4298a(this.f2514b, this.f2515c).getTimeInMillis();
        this.f2517e = DailyLogUtils.m4304b(this.f2514b, this.f2515c).getTimeInMillis();
        this.f2526n = Collections.unmodifiableList(m4046a(j));
        m4051d();
    }

    public C1142r m4058a() {
        return this.f2524l;
    }

    public List<ao> m4061b() {
        return this.f2526n;
    }

    private void m4051d() {
        this.f2524l.m5752b();
        this.f2525m = false;
    }

    public boolean m4063c() {
        return this.f2525m;
    }

    private boolean m4053e() {
        if (!m4056g() || this.f2521i >= this.f2520h.getOccurredAt()) {
            long occurredAt = this.f2520h.getOccurredAt();
            long j = this.f2521i;
            ao a = m4044a(this.f2526n, occurredAt);
            if (a == null) {
                return false;
            }
            if (a.mo692b(occurredAt)) {
                occurredAt = Math.max(a.mo697f(), a.mo698g() - 60000);
            } else if (a.mo694c(occurredAt)) {
                occurredAt = a.mo697f();
            }
            if (m4056g()) {
                if (j <= occurredAt) {
                    j = Math.min(a.mo698g(), occurredAt + 60000);
                } else if (a.mo692b(j)) {
                    j = a.mo698g();
                }
            }
            if (this.f2513a == Policy.FAIL_ON_IMMUTABLE_CHANGE && (occurredAt != this.f2520h.getOccurredAt() || j != this.f2521i)) {
                return false;
            }
            this.f2521i = j;
            if (occurredAt != this.f2520h.getOccurredAt()) {
                this.f2520h = Event.newBuilder(this.f2520h).m13859c(occurredAt).m13862c();
            }
            return true;
        }
        throw new AssertionError("End time is before merging event occurs");
    }

    private ao m4044a(List<ao> list, long j) {
        ao aoVar = null;
        for (ao aoVar2 : list) {
            if (aoVar2.mo698g() > j) {
                break;
            }
        }
        return aoVar2;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m4048a(com.bigroad.ttb.protocol.TTProtocol.Event r9, java.lang.Long r10) {
        /*
        r8 = this;
        r6 = 1;
        r0 = 0;
        r1 = 1;
        r2 = r8.f2520h;
        r2 = r2.getOccurredAt();
        r4 = r9.getOccurredAt();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0014;
    L_0x0012:
        r1 = r0;
    L_0x0013:
        return r1;
    L_0x0014:
        if (r10 != 0) goto L_0x0037;
    L_0x0016:
        r2 = r8.m4056g();
        if (r2 == 0) goto L_0x0031;
    L_0x001c:
        r4 = r8.f2521i;
        r6 = r9.getOccurredAt();
        r2 = r9.hasMinDuration();
        if (r2 == 0) goto L_0x0034;
    L_0x0028:
        r2 = r9.getMinDuration();
    L_0x002c:
        r2 = r2 + r6;
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 < 0) goto L_0x0032;
    L_0x0031:
        r0 = r1;
    L_0x0032:
        r1 = r0;
        goto L_0x0013;
    L_0x0034:
        r2 = 0;
        goto L_0x002c;
    L_0x0037:
        r2 = r8.m4056g();
        if (r2 == 0) goto L_0x0013;
    L_0x003d:
        r2 = r8.f2521i;
        r4 = r10.longValue();
        r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r2 == 0) goto L_0x0013;
    L_0x0047:
        r2 = r8.f2526n;
        r4 = r10.longValue();
        r4 = r4 + r6;
        r2 = r8.m4044a(r2, r4);
        if (r2 != 0) goto L_0x0056;
    L_0x0054:
        r1 = r0;
        goto L_0x0013;
    L_0x0056:
        r4 = r10.longValue();
        r4 = r4 + r6;
        r3 = r2.mo690a(r4);
        if (r3 == 0) goto L_0x0013;
    L_0x0061:
        r4 = r8.f2521i;
        r6 = r2.mo698g();
        r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1));
        if (r3 <= 0) goto L_0x0072;
    L_0x006b:
        r2 = r2.mo698g();
        r8.f2521i = r2;
        goto L_0x0013;
    L_0x0072:
        r4 = r8.f2521i;
        r2 = r2.mo697f();
        r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1));
        if (r2 >= 0) goto L_0x0013;
    L_0x007c:
        r1 = r0;
        goto L_0x0013;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bigroad.shared.DutyStatusEventMerger.a(com.bigroad.ttb.protocol.TTProtocol$Event, java.lang.Long):boolean");
    }

    public static Predicate<Event> m4045a(Policy policy) {
        switch (policy) {
            case PROTECT_ELD_AND_IMMUTABLE_SEGMENTS:
                return f2511q;
            case PROTECT_IMMUTABLE_SEGMENTS:
            case FAIL_ON_IMMUTABLE_CHANGE:
                return f2510p;
            default:
                return f2512r;
        }
    }

    private List<ao> m4046a(long j) {
        List<ao> arrayList = new ArrayList();
        long j2 = 0;
        Object obj = 1;
        Predicate a = m4045a(this.f2513a);
        Event event = null;
        for (Event event2 : this.f2519g) {
            boolean apply = a.apply(event2);
            if (!apply && obj == null) {
                j2 = event2.getOccurredAt();
                obj = 1;
            } else if (apply && obj != null) {
                if (event2.getOccurredAt() > this.f2516d && j2 < this.f2517e) {
                    al alVar = new al(Math.max(j2, this.f2516d), Math.min(event2.getOccurredAt(), this.f2517e));
                    if (alVar.mo689a() > 0) {
                        arrayList.add(alVar);
                    }
                }
                obj = null;
            }
        }
        if (obj != null && j2 < this.f2517e) {
            al alVar2 = new al(Math.max(j2, this.f2516d), this.f2517e);
            if (alVar2.mo689a() > 0) {
                arrayList.add(alVar2);
            }
        } else if (event2 != null && !m4056g() && obj == null && j > event2.getOccurredAt() && j < this.f2517e) {
            al alVar3 = new al(Math.max(event2.getMinDuration() + event2.getOccurredAt(), j), this.f2517e);
            if (alVar3.mo689a() > 0) {
                arrayList.add(alVar3);
            }
        }
        return arrayList;
    }

    public List<Event> m4060a(Event event, long j) {
        this.f2521i = j;
        return m4059a(event);
    }

    public List<Event> m4059a(Event event) {
        m4051d();
        if (C1130o.m5710a(event.getEventType())) {
            return m4049c(event);
        }
        this.f2520h = event;
        this.f2523k = false;
        if (this.f2522j != -1) {
            return m4055f();
        }
        return m4057h();
    }

    private List<Event> m4049c(Event event) {
        List<Event> arrayList = new ArrayList();
        for (Event event2 : this.f2518f) {
            if (event2.getEventId().equals(event.getEventId())) {
                arrayList.add(event);
                this.f2524l.m5746a(event);
            } else {
                arrayList.add(event2);
            }
        }
        arrayList.addAll(this.f2519g);
        Collections.sort(arrayList, C1144s.f3800a);
        return arrayList;
    }

    private List<Event> m4055f() {
        Event event;
        Event event2 = null;
        Event event3 = null;
        for (Event event4 : this.f2519g) {
            if (event4.getOccurredAt() >= this.f2522j) {
                event4 = event3;
            }
            event3 = event4;
        }
        List<Event> h = m4057h();
        Event event5 = null;
        for (Event event42 : h) {
            if (!C1130o.m5710a(event42.getEventType())) {
                if (event5 != null) {
                    break;
                }
                if (!event42.getEventId().equals(this.f2520h.getEventId())) {
                    event42 = event5;
                }
                event5 = event42;
            }
        }
        event42 = null;
        long j = this.f2517e;
        if (event42 != null) {
            j = event42.getOccurredAt();
        }
        if (event5 != null && this.f2522j < r6 && this.f2520h.getOccurredAt() < this.f2522j) {
            int eventType;
            C2647a a = Event.newBuilder().m13846a(C3642c.m19078a(aj.m4179a())).m13843a(this.f2520h.getPersonId());
            if (event3 != null) {
                eventType = event3.getEventType();
            } else {
                eventType = this.f2520h.getEventType();
            }
            C2647a j2 = a.m13842a(eventType).m13859c(this.f2522j).m13853b(this.f2520h.getTruckId()).m13886j(m4054f(this.f2520h));
            m4047a(this.f2520h, j2);
            event2 = j2.m13862c();
        }
        if (event2 == null) {
            return h;
        }
        this.f2519g = h;
        this.f2520h = event2;
        this.f2521i = -1;
        return m4057h();
    }

    public List<Event> m4062b(Event event) {
        m4051d();
        this.f2520h = event;
        this.f2521i = -1;
        this.f2523k = true;
        return m4057h();
    }

    private boolean m4056g() {
        return this.f2521i >= 0;
    }

    private C2647a m4050d(Event event) {
        C2647a newBuilder = Event.newBuilder(event);
        newBuilder.m13824A().m13905z().m13825B();
        if (event.hasContextualData()) {
            newBuilder.m13879g(DutyStatusChangeBits.m4039c(Long.valueOf(event.getContextualData())));
        }
        return newBuilder;
    }

    private Event m4052e(Event event) {
        if (event.getOccurredAt() < this.f2516d || event.getOccurredAt() >= this.f2517e) {
            return null;
        }
        return event;
    }

    private List<Event> m4057h() {
        List<Event> arrayList = new ArrayList(this.f2519g);
        if (this.f2520h == null) {
            return arrayList;
        }
        Event event;
        Event event2;
        Object obj;
        Event event3;
        byte[] d = this.f2520h.getEventId().m19091d();
        Predicate a = m4045a(this.f2513a);
        Event event4 = null;
        Event event5 = null;
        Iterator it = arrayList.iterator();
        Event event6 = null;
        while (it.hasNext()) {
            Event event7 = (Event) it.next();
            if (event7.getOccurredAt() >= this.f2517e) {
                event = null;
                event2 = null;
                obj = null;
                event3 = null;
                break;
            } else if (Arrays.equals(event7.getEventId().m19091d(), d)) {
                Object obj2;
                if (a.apply(event6)) {
                    obj2 = 1;
                } else {
                    obj2 = null;
                }
                if (it.hasNext()) {
                    event4 = m4052e((Event) it.next());
                }
                if (it.hasNext()) {
                    event5 = m4052e((Event) it.next());
                    event3 = event4;
                    event = event7;
                    event2 = event6;
                    obj = obj2;
                } else {
                    event3 = event4;
                    event = event7;
                    event2 = event6;
                    obj = obj2;
                }
            } else {
                event6 = event7;
            }
        }
        event = null;
        event2 = null;
        obj = null;
        event3 = null;
        if (event != null && a.apply(event) && (!a.apply(this.f2520h) || event.getOccurredAt() != this.f2520h.getOccurredAt())) {
            return this.f2519g;
        }
        int i;
        C2647a j;
        int i2;
        if (event != null && a.apply(this.f2520h)) {
            if (!m4048a(event, event3 != null ? Long.valueOf(event3.getOccurredAt()) : null)) {
                return this.f2519g;
            }
        } else if (!m4053e()) {
            return this.f2519g;
        }
        List<Event> arrayList2 = new ArrayList();
        event4 = null;
        event6 = null;
        Event event8 = null;
        Event event9 = null;
        for (Event event72 : arrayList) {
            long occurredAt = event72.getOccurredAt();
            if (occurredAt >= this.f2517e) {
                break;
            }
            if (!m4056g() || occurredAt < this.f2521i || event4 != null || event6 == null) {
                event6 = event4;
            }
            if (occurredAt < this.f2516d) {
                event9 = event72;
                event4 = event6;
                event6 = event72;
            } else {
                if (m4056g()) {
                    if (occurredAt >= this.f2520h.getOccurredAt() && occurredAt <= this.f2521i) {
                        C3642c eventId = event72.getEventId();
                        if ((event == null || !eventId.equals(event.getEventId())) && (event3 == null || !eventId.equals(event3.getEventId()))) {
                            arrayList2.add(event72);
                            if (event8 == null && event72.getOccurredAt() == this.f2521i) {
                                event8 = event72;
                            }
                        }
                    }
                } else if (event72.getOccurredAt() == this.f2520h.getOccurredAt()) {
                    arrayList2.add(event72);
                }
                event9 = event72;
                event4 = event6;
                event6 = event72;
            }
        }
        if (m4056g() && event6 != null && event6.getOccurredAt() < this.f2521i && event4 == null) {
            event4 = event6;
        }
        C0831a.m4106a(arrayList, event, f2509o);
        if (this.f2523k) {
            this.f2524l.m5751b(this.f2520h);
        } else {
            arrayList.add(this.f2520h);
            if (event == null) {
                this.f2524l.m5747a(this.f2520h, null);
            } else {
                this.f2524l.m5746a(this.f2520h);
            }
        }
        Object obj3 = (event == null || this.f2520h.getOccurredAt() != event.getOccurredAt()) ? 1 : null;
        Object obj4 = (!m4056g() || event3 == null || event3.getOccurredAt() == this.f2521i) ? null : 1;
        if (!(obj3 == null && obj4 == null)) {
            for (Event event722 : arrayList2) {
                if (!(event722.getOccurredAt() == this.f2521i || a.apply(event722))) {
                    C0831a.m4106a(arrayList, event722, f2509o);
                    this.f2524l.m5751b(event722);
                }
            }
        }
        if (!(event3 == null || obj4 == null)) {
            obj3 = (a.apply(event3) || event3.getOccurredAt() >= this.f2517e) ? null : 1;
            if (obj3 != null && ((event2 == null || this.f2521i > event2.getOccurredAt()) && ((r8 == null || this.f2521i < r8.getOccurredAt()) && this.f2520h.getOccurredAt() <= event3.getOccurredAt()))) {
                event722 = m4050d(event3).m13859c(this.f2521i).m13862c();
                C0831a.m4106a(arrayList, event3, f2509o);
                if (this.f2521i < this.f2517e) {
                    arrayList.add(event722);
                    this.f2524l.m5746a(event722);
                } else {
                    this.f2524l.m5751b(event3);
                }
            } else if (this.f2521i >= event3.getOccurredAt()) {
                if (event8 == null && this.f2521i < this.f2517e) {
                    i = 6;
                    if (event4 != null) {
                        i = event4.getEventType();
                    }
                    j = Event.newBuilder().m13846a(C3642c.m19078a(aj.m4179a())).m13859c(this.f2521i).m13842a(i).m13843a(this.f2520h.getPersonId()).m13886j(m4054f(this.f2520h));
                    m4047a(this.f2520h, j);
                    event722 = j.m13862c();
                    arrayList.add(event722);
                    this.f2524l.m5747a(event722, null);
                }
                if (this.f2520h.getOccurredAt() <= event3.getOccurredAt()) {
                    C0831a.m4106a(arrayList, event3, f2509o);
                    this.f2524l.m5751b(event3);
                }
            } else if (event8 == null) {
                i = 6;
                if (event != null && this.f2521i >= event.getOccurredAt() && event2 != null) {
                    i = event2.getEventType();
                } else if (event4 != null) {
                    i = event4.getEventType();
                }
                if (a.apply(event3)) {
                    if (i == 5) {
                        i = 6;
                    } else if (i == 23) {
                        i = 3;
                    } else if (i == 34) {
                        i = 6;
                    }
                }
                j = Event.newBuilder().m13846a(C3642c.m19078a(aj.m4179a())).m13859c(this.f2521i).m13842a(i).m13843a(this.f2520h.getPersonId()).m13886j(m4054f(this.f2520h));
                m4047a(this.f2520h, j);
                event722 = j.m13862c();
                arrayList.add(event722);
                this.f2524l.m5747a(event722, null);
            }
        }
        Collections.sort(arrayList, C1144s.f3800a);
        if (!(event == null || r12 == null || (!this.f2523k && event.getOccurredAt() == this.f2520h.getOccurredAt()))) {
            obj3 = (event3 == null || event3.getOccurredAt() >= this.f2517e || a.apply(event3)) ? null : 1;
            if (obj3 == null || (this.f2520h.getOccurredAt() > event.getOccurredAt() && (event3 == null || this.f2520h.getOccurredAt() < event3.getOccurredAt()))) {
                if (event3 == null || a.apply(event3)) {
                    i = 6;
                } else {
                    i = event3.getEventType();
                }
                j = Event.newBuilder().m13846a(C3642c.m19078a(aj.m4179a())).m13859c(event.getOccurredAt()).m13842a(i).m13843a(event.getPersonId()).m13886j(m4054f(event));
                m4047a(event, j);
                event722 = j.m13862c();
                arrayList.add(event722);
                this.f2524l.m5747a(event722, null);
            } else {
                event722 = m4050d(event3).m13859c(event.getOccurredAt()).m13862c();
                C0831a.m4106a(arrayList, event3, f2509o);
                arrayList.add(event722);
                this.f2524l.m5746a(event722);
            }
            Collections.sort(arrayList, C1144s.f3800a);
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            event722 = (Event) arrayList.get(size);
            if (event722.getOccurredAt() < this.f2517e) {
                event6 = event722;
                break;
            }
        }
        event6 = null;
        if (event9 == null) {
            i2 = 3;
        } else {
            i2 = event9.getEventType();
        }
        if (event6 == null) {
            i = 3;
        } else {
            i = event6.getEventType();
        }
        if (i2 != i) {
            this.f2525m = true;
        }
        return arrayList;
    }

    private static long m4054f(Event event) {
        return EventStatusMaskBits.m4075a(EventStatusMaskBits.m4081b(event.getStatusMask()), RecordStatus.ACTIVE);
    }

    private void m4047a(Event event, C2647a c2647a) {
        if (event.hasTruckId()) {
            c2647a.m13853b(event.getTruckId());
            if (event.hasAssociatedDashLink()) {
                c2647a.m13860c(event.getAssociatedDashLink());
            }
            if (event.hasAssociatedGenxDevice()) {
                c2647a.m13867d(event.getAssociatedGenxDevice());
            }
            if (event.hasSequenceId()) {
                c2647a.m13864d((int) NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
            }
        }
    }
}
