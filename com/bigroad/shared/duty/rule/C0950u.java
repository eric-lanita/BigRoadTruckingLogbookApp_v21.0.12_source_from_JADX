package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0904n;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.TimeZone;

public class C0950u implements C0933i {
    private final int f2914a;
    private final long f2915b;

    public static class C0948a {
        private final long f2908a;
        private final long f2909b;
        private final long f2910c = (this.f2908a - 604800000);

        public C0948a(TimeZone timeZone) {
            this.f2908a = C0950u.m4822a(timeZone).getTimeInMillis();
            this.f2909b = C0950u.m4825b(timeZone).getTimeInMillis();
        }

        public long m4811a() {
            return this.f2910c;
        }

        public boolean m4812a(long j) {
            return j >= this.f2908a && j < this.f2909b;
        }

        public boolean m4813a(long j, long j2) {
            return j2 > this.f2908a && j < this.f2909b;
        }
    }

    private static class C0949b {
        private final C0948a f2911a;
        private final List<C0882q> f2912b;
        private long f2913c;

        public boolean m4818a() {
            return this.f2912b.isEmpty();
        }

        public C0882q m4819b() {
            return m4818a() ? null : (C0882q) this.f2912b.get(this.f2912b.size() - 1);
        }

        public List<C0882q> m4820c() {
            return this.f2912b;
        }

        public C0949b(C0898i c0898i) {
            this.f2911a = new C0948a(c0898i.m4557d());
            List arrayList = new ArrayList();
            m4814a(c0898i, arrayList);
            this.f2913c = m4816b(c0898i, arrayList);
            this.f2912b = Collections.unmodifiableList(arrayList);
        }

        private void m4814a(C0898i c0898i, List<C0882q> list) {
            Iterator h = c0898i.m4558e().m4460h(122400000);
            while (h.hasNext()) {
                C0882q c0882q = (C0882q) h.next();
                if (c0882q.mo698g() <= this.f2911a.m4811a()) {
                    list.add(c0882q);
                } else {
                    return;
                }
            }
        }

        private long m4816b(C0898i c0898i, List<C0882q> list) {
            long b;
            long a;
            Event event = null;
            for (Event event2 : c0898i.m4553b()) {
                Event event22;
                if (DutyStatus.m4387b(event22.getEventType())) {
                    if (DutyStatus.m4383a(event22.getEventType()).m4396d() && event22.hasCycleResetStartedAt() && event22.hasCycleResetEndedAt()) {
                        if (event == null) {
                            b = C0949b.m4815b(c0898i);
                        } else {
                            b = aq.m4214a(event.getCycleResetEndedAt());
                        }
                        a = aq.m4214a(event22.getCycleResetStartedAt());
                        if (b < a && a > this.f2911a.m4811a()) {
                            list.add(c0898i.m4548a(b, a));
                        }
                    } else {
                        event22 = event;
                    }
                    event = event22;
                }
            }
            if (event != null) {
                b = aq.m4214a(event.getCycleResetEndedAt());
                a = c0898i.mo698g();
                Object obj = !c0898i.m4562i() ? c0898i.m4552b(c0898i.m4561h() + -1).mo689a() == 0 ? 1 : null : null;
                if (b < a && a > this.f2911a.m4811a()) {
                    list.add(c0898i.m4548a(b, c0898i.mo698g()));
                } else if (b == a && r0 != null && a > this.f2911a.m4811a()) {
                    list.add(c0898i.m4549a(c0898i.m4561h() - 1));
                }
                return aq.m4214a(event.getCycleResetStartedAt());
            }
            long b2 = C0949b.m4815b(c0898i);
            b = c0898i.mo698g();
            if (b2 < b && b > this.f2911a.m4811a()) {
                list.add(c0898i.m4548a(b2, c0898i.mo698g()));
            }
            return 0;
        }

        public long m4817a(C0898i c0898i) {
            if (m4818a() || !this.f2911a.m4812a(c0898i.mo698g())) {
                return 122400000;
            }
            long g = c0898i.mo698g() - c0898i.m4558e().m4457f(m4819b().mo689a());
            long max = Math.max(0, 604800000 - (g - this.f2913c));
            long j = g + max;
            Calendar c = c0898i.m4556d(j).m4586c();
            Calendar a = aq.m4222a(c);
            int i = 0;
            while (i < 2) {
                a.setTimeInMillis(c.getTimeInMillis());
                aq.m4223a(a, 1, 0);
                if (a.getTimeInMillis() >= j) {
                    aq.m4223a(a, 5, 0);
                    i++;
                }
                c.add(5, 1);
            }
            return Math.max(122400000 + max, a.getTimeInMillis() - g);
        }

        private static long m4815b(C0898i c0898i) {
            Iterator it = c0898i.m4558e().iterator();
            while (it.hasNext()) {
                C0896g c0896g = (C0896g) it.next();
                if (c0896g.m4539b()) {
                    return c0896g.mo697f();
                }
            }
            return c0898i.mo698g();
        }
    }

    private C0950u(int i, long j) {
        this.f2914a = i;
        this.f2915b = j;
    }

    public static C0950u m4821a() {
        return new C0950u(7, 216000000);
    }

    public static C0950u m4824b() {
        return new C0950u(8, 252000000);
    }

    public static C0950u m4826c() {
        return new C0950u(7, 252000000);
    }

    public static C0950u m4827d() {
        return new C0950u(8, 288000000);
    }

    public static Calendar m4822a(TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.set(2013, 6, 1, 0, 0, 0);
        return instance;
    }

    public static Calendar m4825b(TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(timeZone);
        instance.set(2014, 11, 17, 0, 0, 0);
        return instance;
    }

    public C0882q mo741a(C0898i c0898i) {
        C0949b c0949b = new C0949b(c0898i);
        long a = c0949b.m4817a(c0898i);
        return a - c0898i.m4558e().m4457f(a) == 0 ? null : c0949b.m4819b();
    }

    public C0882q mo742a(C0898i c0898i, C0907o c0907o) {
        for (C0882q c0882q : C0831a.m4105a(new C0949b(c0898i).m4820c())) {
            if (c0882q.mo693b((ao) c0907o)) {
                return c0882q;
            }
        }
        return null;
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0949b c0949b = new C0949b(c0898i);
        long a = c0949b.m4817a(c0898i);
        long f = a - c0898i.m4558e().m4457f(a);
        long j = this.f2915b;
        if (!c0949b.m4818a() && f > 0) {
            j = this.f2915b - C0924k.m4657a(c0949b.m4819b(), c0898i.m4557d(), this.f2914a);
        }
        DutyStatus a2 = C0904n.m4576a(c0898i);
        boolean a3 = C0896g.f2769b.mo701a(a2);
        boolean a4 = C0896g.f2771d.mo701a(a2);
        c0868a.m4354b(new C0902k(j, this.f2915b, a3));
        c0868a.m4357c(new C0955u(f, a, a4));
        if (a4 && f > 0) {
            c0868a.m4348a(f);
        }
        if (f > 0 || a3) {
            Calendar b = aq.m4228b(c0898i.m4557d(), c0898i.mo698g());
            b.add(5, 1);
            c0868a.m4352a(b.getTime());
        }
        c0868a.m4353a(c0949b.m4820c());
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0949b c0949b = new C0949b(c0898i);
        C0907o c = c0898i.m4554c(i);
        for (C0882q c0882q : c0949b.m4820c()) {
            if (c0882q.mo693b((ao) c)) {
                m4823a(c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4823a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Calendar c = c0907o.m4586c();
        c.add(5, -(this.f2914a - 1));
        long a = c0882q.m4445a(c.getTimeInMillis(), c0907o.mo697f());
        Iterator it = c0882q.iterator();
        long j = a;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (!c0896g.m4128c((ao) c0907o)) {
                if (!c0896g.mo695d(c0907o)) {
                    if (!c0896g.m4540c()) {
                        ao e = c0896g.mo696e(c0907o);
                        long a2 = e.mo689a();
                        long max = Math.max(0, this.f2915b - j);
                        if (c0896g.m4541d() && max < a2) {
                            Long valueOf = Long.valueOf(this.f2915b / 3600000);
                            Integer valueOf2 = Integer.valueOf(this.f2914a);
                            Enum enumR = Field.NONE;
                            C1176p<Field> c1176p2 = c1176p;
                            Enum enumR2 = enumR;
                            c1176p2.m5957a(enumR2, new C1168m(max + e.mo697f(), e.mo698g(), ErrorCode.DRIVING_OVER_DUTY_CYCLE_LIMIT, new C1175o(ValidationMessageId.RULE_CYCLE_DUTY, new Object[]{valueOf, valueOf2})));
                        }
                        j += a2;
                    }
                } else {
                    return;
                }
            }
        }
    }
}
