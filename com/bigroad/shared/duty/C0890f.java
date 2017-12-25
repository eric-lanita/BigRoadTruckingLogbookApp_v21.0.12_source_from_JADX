package com.bigroad.shared.duty;

import com.bigroad.shared.C1101m;
import com.bigroad.shared.C1144s;
import com.bigroad.shared.aa;
import com.bigroad.shared.al;
import com.bigroad.shared.am;
import com.bigroad.shared.ao;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.model.C1127k;
import com.bigroad.shared.validation.p024b.C0888e;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Event.C2647a;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.ListIterator;
import java.util.TimeZone;

public class C0890f extends C0888e implements C0889h {
    public static final Comparator<C0890f> f2761a = new C08851();
    private final Event f2762b;
    private final long f2763c;
    private final long f2764d;
    private final long f2765e;
    private final boolean f2766f;
    private final TimeZone f2767g;

    static class C08851 implements Comparator<C0890f> {
        C08851() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4474a((C0890f) obj, (C0890f) obj2);
        }

        public int m4474a(C0890f c0890f, C0890f c0890f2) {
            return C1144s.f3800a.compare(c0890f.m4519n(), c0890f2.m4519n());
        }
    }

    public static class C0886a {
        private final TimeZone f2753a;
        private final Calendar f2754b;
        private final Calendar f2755c;
        private Event f2756d;
        private List<Event> f2757e;
        private long f2758f;
        private boolean f2759g;

        public C0886a(C1101m c1101m, int i, TimeZone timeZone) {
            this(c1101m.mo822a(i, timeZone), i, timeZone);
        }

        public C0886a(List<Event> list, int i, TimeZone timeZone) {
            this.f2759g = false;
            this.f2757e = new ArrayList(list);
            this.f2753a = timeZone;
            this.f2754b = DailyLogUtils.m4298a(i, timeZone);
            this.f2755c = DailyLogUtils.m4304b(i, timeZone);
            long timeInMillis = this.f2754b.getTimeInMillis();
            long timeInMillis2 = this.f2755c.getTimeInMillis();
            this.f2756d = null;
            this.f2758f = Long.MAX_VALUE;
            ListIterator listIterator = this.f2757e.listIterator();
            while (listIterator.hasNext()) {
                Event event = (Event) listIterator.next();
                long occurredAt = event.getOccurredAt();
                if (occurredAt < timeInMillis) {
                    if (DutyStatus.m4387b(event.getEventType())) {
                        this.f2756d = event;
                    }
                    listIterator.remove();
                } else if (occurredAt >= timeInMillis2) {
                    if (occurredAt < this.f2758f) {
                        this.f2758f = occurredAt;
                    }
                    listIterator.remove();
                }
            }
        }

        public C0886a m4478a(boolean z) {
            this.f2759g = z;
            return this;
        }

        public List<C0890f> m4479a(long j) {
            C0890f b;
            int size = this.f2757e.size();
            List arrayList = new ArrayList(size + 1);
            if (this.f2757e.isEmpty() || ((Event) this.f2757e.get(0)).getOccurredAt() > this.f2754b.getTimeInMillis()) {
                b = m4477b(j);
                arrayList.add(b);
            } else {
                b = null;
            }
            int i = 0;
            C0890f c0890f = b;
            while (i < size) {
                c0890f = m4475a(c0890f, (Event) this.f2757e.get(i), i == size + -1 ? null : (Event) this.f2757e.get(i + 1), this.f2753a, j);
                arrayList.add(c0890f);
                i++;
            }
            return arrayList;
        }

        private C0890f m4477b(long j) {
            Event d;
            if (this.f2756d != null) {
                C2647a c = Event.newBuilder().m13842a(this.f2756d.getEventType()).m13859c(this.f2756d.getOccurredAt());
                if (this.f2756d.hasContextualData()) {
                    c.m13879g(this.f2756d.getContextualData());
                }
                if (this.f2756d.hasImmutableDutySegment()) {
                    c.m13850a(this.f2756d.getImmutableDutySegment());
                }
                if (this.f2756d.hasCycleResetStartedAt()) {
                    c.m13865d(this.f2756d.getCycleResetStartedAt());
                }
                if (this.f2756d.hasCycleResetEndedAt()) {
                    c.m13870e(this.f2756d.getCycleResetEndedAt());
                }
                d = c.m13868d();
            } else {
                d = Event.newBuilder().m13842a(3).m13859c(this.f2754b.getTimeInMillis()).m13868d();
            }
            return m4475a(null, d, this.f2757e.isEmpty() ? null : (Event) this.f2757e.get(0), this.f2753a, j);
        }

        private C0890f m4475a(C0890f c0890f, Event event, Event event2, TimeZone timeZone, long j) {
            long j2;
            long j3;
            long max = Math.max(event.getOccurredAt(), this.f2754b.getTimeInMillis());
            long occurredAt;
            if (event2 != null) {
                occurredAt = event2.getOccurredAt();
                j2 = occurredAt;
                j3 = occurredAt;
            } else {
                if (this.f2758f < Long.MAX_VALUE || this.f2759g) {
                    occurredAt = this.f2755c.getTimeInMillis();
                } else {
                    occurredAt = Math.min(j, this.f2755c.getTimeInMillis());
                }
                if (max > occurredAt) {
                    occurredAt = max;
                }
                if (this.f2758f == Long.MAX_VALUE) {
                    j3 = Math.max(j, event.getOccurredAt());
                    j2 = occurredAt;
                } else {
                    j3 = this.f2758f;
                    j2 = occurredAt;
                }
            }
            boolean z = ((c0890f == null || m4476a(max, c0890f.f2763c)) && m4476a(max, j2)) ? false : true;
            return new C0890f(event, max, j3, j2, z, timeZone);
        }

        private boolean m4476a(long j, long j2) {
            TimeZone timeZone = this.f2754b.getTimeZone();
            return timeZone.inDaylightTime(new Date(j)) == timeZone.inDaylightTime(new Date(j2));
        }
    }

    private C0890f(Event event, long j, long j2, long j3, boolean z, TimeZone timeZone) {
        this.f2762b = event;
        this.f2763c = j;
        this.f2764d = j2;
        this.f2765e = j3;
        this.f2766f = z;
        this.f2767g = timeZone;
    }

    public C0890f(C0890f c0890f) {
        this.f2762b = c0890f.f2762b;
        this.f2763c = c0890f.f2763c;
        this.f2764d = c0890f.f2764d;
        this.f2765e = c0890f.f2765e;
        this.f2766f = c0890f.f2766f;
        this.f2767g = c0890f.f2767g;
    }

    public long mo721a() {
        return this.f2762b.getOccurredAt();
    }

    public long m4507b() {
        return this.f2763c;
    }

    public long m4508c() {
        return aq.m4214a(m4507b());
    }

    public int m4503a(Calendar calendar) {
        return C0890f.m4497a(calendar, m4508c());
    }

    public long m4509d() {
        return this.f2764d;
    }

    public long m4510e() {
        return this.f2765e;
    }

    public long m4511f() {
        return aq.m4214a(m4510e());
    }

    public int m4506b(Calendar calendar) {
        return C0890f.m4497a(calendar, m4511f());
    }

    public ao m4512g() {
        return new al(m4508c(), m4511f());
    }

    public boolean m4513h() {
        return this.f2766f;
    }

    public long m4514i() {
        return m4509d() - mo721a();
    }

    public long m4515j() {
        return m4511f() - m4508c();
    }

    public Long mo722k() {
        Event n = m4519n();
        return n.hasCycleResetStartedAt() ? Long.valueOf(n.getCycleResetStartedAt()) : null;
    }

    public Long mo723l() {
        Event n = m4519n();
        return n.hasCycleResetEndedAt() ? Long.valueOf(n.getCycleResetEndedAt()) : null;
    }

    public DutyStatus mo702m() {
        return DutyStatus.m4383a(this.f2762b.getEventType());
    }

    public Event m4519n() {
        return this.f2762b;
    }

    public boolean m4520o() {
        return m4519n().hasEventId();
    }

    public byte[] m4521p() {
        return m4519n().getEventId().m19091d();
    }

    public long m4522q() {
        if (m4520o()) {
            return aa.m4137a(m4521p(), 0);
        }
        return 0;
    }

    public boolean m4523r() {
        Event n = m4519n();
        return (n.hasLatitudeE6() && n.hasLongitudeE6()) || n.hasLocationName();
    }

    public byte[] mo719s() {
        return m4521p();
    }

    public String mo724t() {
        if (m4519n().hasRelativeLocation() && m4519n().hasSequenceId()) {
            CharSequence a = C1127k.m5706a(m4519n().getRelativeLocation());
            if (!am.m4188a(a)) {
                return a;
            }
        }
        return m4519n().getLocationName();
    }

    public String mo725u() {
        return m4529x();
    }

    public boolean mo720v() {
        return !m4520o();
    }

    public Long m4528w() {
        Event n = m4519n();
        return n.hasTruckId() ? Long.valueOf(n.getTruckId()) : null;
    }

    public String m4529x() {
        return m4519n().getNotes();
    }

    public boolean mo726y() {
        return C0890f.m4501a(m4519n());
    }

    public boolean m4505a(long j) {
        return m4519n().getPersonId() != j;
    }

    public boolean m4531z() {
        return DutyStatus.m4391c(this.f2762b);
    }

    public static int m4497a(Calendar calendar, long j) {
        TimeZone timeZone = calendar.getTimeZone();
        long timeInMillis = calendar.getTimeInMillis();
        return (int) (((((long) timeZone.getOffset(j)) + j) - (((long) timeZone.getOffset(timeInMillis)) + timeInMillis)) / 60000);
    }

    public static long m4499a(Collection<C0890f> collection, DutyStatus dutyStatus) {
        if (collection == null) {
            return 0;
        }
        long j = 0;
        for (C0890f c0890f : collection) {
            long j2;
            if (c0890f.mo702m() == dutyStatus) {
                j2 = c0890f.m4515j() + j;
            } else {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    public static C0890f m4500a(long j, List<C0890f> list) {
        if (list == null) {
            return null;
        }
        for (C0890f c0890f : list) {
            if (c0890f.m4522q() == j) {
                return c0890f;
            }
        }
        return null;
    }

    public String toString() {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        dateTimeInstance.setTimeZone(this.f2767g);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(EventType.m13979a(this.f2762b.getEventType()).toString()).append("; ").append(dateTimeInstance.format(new Date(this.f2763c))).append(" - ").append(dateTimeInstance.format(new Date(this.f2765e)));
        return stringBuilder.toString();
    }

    public static boolean m4502a(Iterable<? extends C0890f> iterable) {
        for (C0890f y : iterable) {
            if (y.mo726y()) {
                return true;
            }
        }
        return false;
    }

    public static boolean m4501a(Event event) {
        return event != null && event.hasImmutableDutySegment() && event.getImmutableDutySegment();
    }
}
