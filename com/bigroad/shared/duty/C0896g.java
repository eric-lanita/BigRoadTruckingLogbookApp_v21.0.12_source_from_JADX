package com.bigroad.shared.duty;

import com.bigroad.shared.C0836a;
import com.bigroad.shared.aq;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.text.DateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class C0896g extends C0836a implements C0871l, Comparable<C0896g> {
    public static final C0870a f2768a = new C08911();
    public static final C0870a f2769b = new C08922();
    public static final C0870a f2770c = new C08933();
    public static final C0870a f2771d = new C08944();
    public static final C0870a f2772e = new C08955();
    private final long f2773f;
    private final long f2774g;
    private final DutyStatus f2775h;

    public interface C0870a {
        boolean mo701a(DutyStatus dutyStatus);
    }

    static class C08911 implements C0870a {
        C08911() {
        }

        public boolean mo701a(DutyStatus dutyStatus) {
            return true;
        }
    }

    static class C08922 implements C0870a {
        C08922() {
        }

        public boolean mo701a(DutyStatus dutyStatus) {
            return dutyStatus.m4395c();
        }
    }

    static class C08933 implements C0870a {
        C08933() {
        }

        public boolean mo701a(DutyStatus dutyStatus) {
            return dutyStatus == DutyStatus.OFF_DUTY || dutyStatus == DutyStatus.OFF_DUTY_DRIVING || dutyStatus == DutyStatus.SLEEPER;
        }
    }

    static class C08944 implements C0870a {
        C08944() {
        }

        public boolean mo701a(DutyStatus dutyStatus) {
            return dutyStatus.m4396d();
        }
    }

    static class C08955 implements C0870a {
        C08955() {
        }

        public boolean mo701a(DutyStatus dutyStatus) {
            return dutyStatus == DutyStatus.OFF_DUTY || dutyStatus == DutyStatus.OFF_DUTY_WAITING || dutyStatus == DutyStatus.OFF_DUTY_DRIVING || dutyStatus == DutyStatus.SLEEPER;
        }
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m4537a((C0896g) obj);
    }

    public C0896g(Event event, Event event2) {
        this(event, event2.getOccurredAt());
    }

    public C0896g(long j, long j2, DutyStatus dutyStatus) {
        this.f2773f = aq.m4214a(j);
        this.f2774g = aq.m4214a(j2);
        this.f2775h = dutyStatus;
    }

    public C0896g(Event event, long j) {
        if (event == null) {
            this.f2773f = 0;
            this.f2775h = DutyStatus.OFF_DUTY;
        } else {
            this.f2773f = aq.m4214a(event.getOccurredAt());
            this.f2775h = DutyStatus.m4383a(event.getEventType());
        }
        this.f2774g = aq.m4214a(j);
    }

    public long mo697f() {
        return this.f2773f;
    }

    public long mo698g() {
        return this.f2774g;
    }

    public DutyStatus mo702m() {
        return this.f2775h;
    }

    public long m4538a(long j, long j2) {
        if (this.f2774g <= j || this.f2773f >= j2) {
            return 0;
        }
        return Math.max(0, Math.min(j2, this.f2774g) - Math.max(j, this.f2773f));
    }

    public boolean m4539b() {
        return mo702m().m4395c();
    }

    public boolean m4540c() {
        return mo702m().m4396d();
    }

    public boolean m4541d() {
        return mo702m() == DutyStatus.DRIVING;
    }

    public boolean m4542e() {
        return mo702m() == DutyStatus.SLEEPER;
    }

    public int m4537a(C0896g c0896g) {
        return Long.signum(this.f2773f - c0896g.f2773f);
    }

    public String toString() {
        DateFormat dateTimeInstance = DateFormat.getDateTimeInstance(2, 2);
        dateTimeInstance.setTimeZone(TimeZone.getTimeZone("UTC"));
        return "DutySegment [m_startUTC=" + dateTimeInstance.format(new Date(this.f2773f)) + ", m_endUTC=" + dateTimeInstance.format(new Date(this.f2774g)) + ", m_type=" + this.f2775h + ", duration=" + aq.m4232d(mo689a()) + "]";
    }
}
