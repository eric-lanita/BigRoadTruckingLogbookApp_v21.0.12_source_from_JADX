package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0904n;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0910r;
import com.bigroad.shared.duty.C0953s;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.duty.rule.C0917w.C0913a;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C0942p implements C0917w {
    private final long f2890a;
    private final long f2891b;
    private final long f2892c;
    private final boolean f2893d;
    private final boolean f2894e;

    private final class C0940a {
        final /* synthetic */ C0942p f2881a;
        private final long f2882b;
        private C0941b f2883c;
        private long f2884d = -1;
        private long f2885e = -1;
        private long f2886f = -1;

        public C0940a(C0942p c0942p, C0898i c0898i) {
            this.f2881a = c0942p;
            this.f2882b = C0950u.m4822a(c0898i.m4557d()).getTimeInMillis();
            this.f2883c = new C0941b(c0942p.f2891b, c0942p.f2892c, null);
        }

        public C0941b m4753a(C0882q c0882q) {
            return m4754a(c0882q, c0882q);
        }

        public C0941b m4754a(C0882q c0882q, C0882q c0882q2) {
            long a = this.f2881a.f2891b - c0882q.m4454e();
            long b = this.f2881a.f2892c - c0882q2.mo689a();
            if (this.f2881a.f2894e) {
                b += c0882q2.m4446a(DutyStatus.OFF_DUTY_WAITING);
            }
            if (!m4758a(c0882q.mo698g())) {
                return new C0941b(a, b);
            }
            Iterator it = c0882q.iterator();
            long j = 0;
            long j2 = 0;
            while (it.hasNext()) {
                long j3;
                C0896g c0896g = (C0896g) it.next();
                long a2 = c0896g.mo689a();
                if (c0896g.m4540c()) {
                    j3 = j2 + a2;
                    if (j3 >= 1800000) {
                        j2 = 0;
                    } else {
                        j2 = j + a2;
                    }
                } else {
                    j3 = 0;
                    j2 = j + a2;
                }
                j = j2;
                j2 = j3;
            }
            return new C0941b(a, b, Long.valueOf(Math.min(28800000 - j, a)));
        }

        private void m4752a(C0898i c0898i, C0882q c0882q, List<C0882q> list, C0953s<C0882q> c0953s) {
            int j;
            C0882q c0882q2;
            if (c0953s == null) {
                j = c0882q.m4463j();
            } else {
                j = c0953s.m4846b().m4464k();
            }
            int k = c0882q.m4464k();
            for (C0882q c0882q3 : C0831a.m4105a(list)) {
                if (c0882q3.m4463j() >= j) {
                    if (c0882q3.m4464k() < k) {
                        c0882q2 = c0882q3;
                        break;
                    }
                }
                c0882q2 = null;
                break;
            }
            c0882q2 = null;
            if (c0882q2 != null) {
                Object obj = null;
                for (int k2 = c0882q2.m4464k(); k2 < k; k2++) {
                    if (c0898i.m4552b(k2).m4539b()) {
                        obj = 1;
                        break;
                    }
                }
                if (obj != null) {
                    if (!this.f2881a.m4773a(c0882q2, c0898i.m4550a(j, k))) {
                        this.f2884d = this.f2881a.f2890a - (c0898i.m4558e().m4459g(this.f2881a.f2890a) + c0882q2.mo689a());
                        this.f2885e = this.f2881a.f2891b - c0898i.m4550a(c0882q2.m4464k(), c0882q.m4464k()).m4454e();
                        this.f2886f = this.f2881a.f2892c;
                    }
                }
            }
        }

        public void m4757a(C0898i c0898i, C0882q c0882q) {
            C0953s c0953s;
            List a = this.f2881a.m4767a(c0882q);
            List a2 = this.f2881a.m4766a(c0898i, c0882q, a);
            if (a2.isEmpty()) {
                c0953s = null;
            } else {
                c0953s = (C0953s) a2.get(a2.size() - 1);
            }
            m4752a(c0898i, c0882q, a, c0953s);
            if (c0953s != null) {
                this.f2883c = m4754a(c0898i.m4550a(c0953s.m4845a().m4464k(), c0882q.m4464k()), c0898i.m4550a(c0953s.m4846b().m4464k(), c0882q.m4464k()));
            }
        }

        public boolean m4758a(long j) {
            return this.f2881a.f2893d && j > this.f2882b;
        }

        public void m4756a(C0868a c0868a, DutyStatus dutyStatus, long j) {
            c0868a.m4356c(new C0902k(this.f2883c.m4759a(), this.f2881a.f2891b, DutyStatus.DRIVING.mo701a(dutyStatus)));
            long d = this.f2883c.m4762d();
            long b = this.f2881a.f2892c;
            boolean z = j > 0 && dutyStatus != DutyStatus.OFF_DUTY_WAITING;
            c0868a.m4350a(new C0902k(d, b, z));
            if (this.f2883c.m4760b()) {
                c0868a.m4358d(new C0902k(this.f2883c.m4761c(), 28800000));
            }
        }

        public void m4755a(C0868a c0868a, DutyStatus dutyStatus) {
            if (this.f2884d >= 0) {
                c0868a.m4359d(new C0955u(this.f2884d, this.f2881a.f2890a, C0896g.f2770c.mo701a(dutyStatus)));
                c0868a.m4349a(DutyStatus.OFF_DUTY);
                c0868a.m4360e(new C0902k(this.f2885e, this.f2881a.f2891b));
                c0868a.m4361f(new C0902k(this.f2886f, this.f2881a.f2892c));
            }
        }
    }

    private static class C0941b {
        private final long f2887a;
        private final Long f2888b;
        private final long f2889c;

        public C0941b(long j, long j2) {
            this(j, j2, null);
        }

        public C0941b(long j, long j2, Long l) {
            this.f2887a = j;
            this.f2889c = j2;
            this.f2888b = l;
        }

        public long m4759a() {
            return this.f2887a;
        }

        public boolean m4760b() {
            return this.f2888b != null;
        }

        public long m4761c() {
            return Math.min(this.f2887a, this.f2888b.longValue());
        }

        public long m4762d() {
            return this.f2889c;
        }
    }

    private C0942p(long j, long j2, long j3, boolean z) {
        this(j, j2, j3, z, true);
    }

    protected C0942p(long j, long j2, long j3, boolean z, boolean z2) {
        this.f2890a = j;
        this.f2891b = j2;
        this.f2892c = j3;
        this.f2893d = z;
        this.f2894e = z2;
    }

    public static C0913a m4765a(final boolean z) {
        return new C0913a() {
            public C0917w mo733a() {
                return C0942p.m4777b(z);
            }

            public C0917w mo734a(long j) {
                return new C0942p(36000000, 39600000, j, !z, false);
            }
        };
    }

    public static C0917w m4777b(boolean z) {
        return new C0942p(36000000, 39600000, 50400000, !z);
    }

    public static C0912j m4764a() {
        return new C0942p(36000000, 43200000, 57600000, false);
    }

    public static C0912j m4776b() {
        return new C0942p(36000000, 36000000, 57600000, false);
    }

    public long mo737c() {
        return this.f2890a;
    }

    public long mo738d() {
        return this.f2892c;
    }

    public boolean mo735a(C0898i c0898i, C0882q c0882q) {
        return !m4766a(c0898i, c0882q, m4767a(c0882q)).isEmpty();
    }

    public boolean mo736a(C0882q c0882q, long j) {
        return c0882q.m4446a(DutyStatus.OFF_DUTY_WAITING) > j - this.f2892c;
    }

    private boolean m4773a(C0882q c0882q, C0882q c0882q2) {
        if (c0882q2.m4454e() > this.f2891b) {
            return true;
        }
        C0896g c0896g;
        Iterator it = c0882q2.iterator();
        while (it.hasNext()) {
            c0896g = (C0896g) it.next();
            if (c0896g.m4539b()) {
                break;
            }
        }
        c0896g = null;
        if (c0896g != null) {
            long a = c0896g.mo689a();
            while (it.hasNext()) {
                c0896g = (C0896g) it.next();
                if (!((this.f2894e && c0896g.mo702m() == DutyStatus.OFF_DUTY_WAITING) || c0882q.mo691a((ao) c0896g))) {
                    a += c0896g.mo689a();
                }
                if (a > this.f2892c && c0896g.m4541d()) {
                    return true;
                }
            }
        }
        return false;
    }

    private List<C0882q> m4767a(C0882q c0882q) {
        return ((C0910r) c0882q.m4450a(C0896g.f2770c, C0910r.m4592a(7200000))).m4593a();
    }

    private List<C0953s<C0882q>> m4766a(C0898i c0898i, C0882q c0882q, List<C0882q> list) {
        int size = list.size();
        int j = c0882q.m4463j();
        List<C0953s<C0882q>> arrayList = new ArrayList();
        int i = 0;
        while (i < size - 1) {
            int i2;
            int i3;
            C0882q c0882q2 = (C0882q) list.get(i);
            int i4 = i + 1;
            while (i4 < size) {
                C0882q c0882q3 = (C0882q) list.get(i4);
                if (c0882q2.mo689a() + c0882q3.mo689a() < this.f2890a) {
                    i4++;
                } else {
                    if (m4773a(c0882q2, c0898i.m4550a(j, c0882q3.m4463j()))) {
                        i2 = i;
                        i3 = j;
                    } else {
                        if (c0898i.m4550a(c0882q2.m4464k(), i4 < size + -1 ? ((C0882q) list.get(i4 + 1)).m4463j() : c0882q.m4464k()).m4454e() > this.f2891b) {
                            i2 = i;
                            i3 = j;
                        } else {
                            arrayList.add(new C0953s(c0882q2, c0882q3));
                            i3 = c0882q3.m4464k();
                            i2 = i4;
                        }
                    }
                    i = i2 + 1;
                    j = i3;
                }
            }
            i2 = i;
            i3 = j;
            i = i2 + 1;
            j = i3;
        }
        return arrayList;
    }

    private List<C0953s<C0882q>> m4778b(C0898i c0898i, C0882q c0882q) {
        return m4766a(c0898i, c0882q, m4767a(c0882q));
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0940a c0940a = new C0940a(this, c0898i);
        Iterator h = c0898i.m4558e().m4460h(this.f2890a);
        C0882q c0882q = null;
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
        }
        long f = this.f2890a - c0898i.m4558e().m4457f(this.f2890a);
        Long l = null;
        if (c0940a.m4758a(c0898i.mo698g())) {
            c0940a.f2883c = new C0941b(this.f2891b, this.f2892c, Long.valueOf(28800000));
            l = Long.valueOf(1800000 - c0898i.m4558e().m4455e(1800000));
        }
        if (c0882q != null && f > 0) {
            c0940a.f2883c = c0940a.m4753a(c0882q);
            c0940a.m4757a(c0898i, c0882q);
        }
        DutyStatus a = C0904n.m4576a(c0898i);
        c0940a.m4756a(c0868a, a, f);
        if (l != null) {
            c0868a.m4351a(new C0955u(l.longValue(), 1800000));
        }
        boolean a2 = C0896g.f2771d.mo701a(a);
        c0868a.m4355b(new C0955u(f, this.f2890a, a2));
        if (a2 && f > 0) {
            c0868a.m4348a(f);
        }
        c0940a.m4755a(c0868a, a);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(this.f2890a);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b((ao) c)) {
                m4770a(c0898i, c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4770a(C0898i c0898i, C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        List<C0953s> b = m4778b(c0898i, c0882q);
        int j = c0882q.m4463j();
        int i = j;
        for (C0953s c0953s : b) {
            C0882q a = c0898i.m4550a(i, c0953s.m4846b().m4464k());
            m4771a(c0907o, a, c0953s, (C1176p) c1176p);
            i = a.m4464k();
        }
        m4771a(c0907o, c0898i.m4550a(i, c0882q.m4464k()), null, (C1176p) c1176p);
    }

    private void m4771a(C0907o c0907o, C0882q c0882q, C0953s<C0882q> c0953s, C1176p<Field> c1176p) {
        Iterator it = c0882q.iterator();
        long j = 0;
        long j2 = 0;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (c0896g.mo695d(c0907o)) {
                break;
            } else if (c0896g.m4128c((ao) c0907o) || !c0896g.m4541d()) {
                if (c0896g.m4541d()) {
                    j2 += c0896g.mo689a();
                }
                if (!(this.f2894e && c0896g.mo702m() == DutyStatus.OFF_DUTY_WAITING) && (c0953s == null || !c0953s.m4845a().mo691a((ao) c0896g))) {
                    j = c0896g.mo689a() + j;
                }
            } else {
                C1176p<Field> c1176p2;
                Enum enumR;
                ao e = c0896g.mo696e(c0907o);
                long f = e.mo697f() - c0896g.mo697f();
                long j3 = j2 + f;
                long j4 = j + f;
                long a = e.mo689a();
                j2 = (j3 + a) - this.f2891b;
                if (j2 > 0) {
                    Long valueOf = Long.valueOf(this.f2891b / 3600000);
                    Enum enumR2 = Field.NONE;
                    c1176p2 = c1176p;
                    enumR = enumR2;
                    c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j2), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DRIVE, new Object[]{valueOf})));
                }
                j2 = (j4 + a) - this.f2892c;
                if (j2 > 0) {
                    Long valueOf2 = Long.valueOf(this.f2892c / 3600000);
                    Enum enumR3 = Field.NONE;
                    c1176p2 = c1176p;
                    enumR = enumR3;
                    c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j2), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DURATION_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DUTY_PROPERTY, new Object[]{valueOf2})));
                }
                j2 = c0896g.mo698g() - e.mo697f();
                j = j2 + j4;
                j2 = j3 + j2;
            }
        }
        m4772a(c0907o, c0882q, (C1176p) c1176p);
    }

    private void m4772a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        if (this.f2893d && c0907o.a_() >= 15887) {
            Iterator h = c0882q.m4460h(1800000);
            while (h.hasNext()) {
                C0882q c0882q2 = (C0882q) h.next();
                if (c0882q2.mo693b((ao) c0907o)) {
                    m4779b(c0907o, c0882q2, c1176p);
                } else if (c0882q2.mo695d(c0907o)) {
                    return;
                }
            }
        }
    }

    private void m4779b(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Iterator it = c0882q.iterator();
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (c0896g.m4541d() && !c0896g.m4128c((ao) c0907o)) {
                if (!c0896g.mo695d(c0907o)) {
                    ao e = c0896g.mo696e(c0907o);
                    long g = (e.mo698g() - c0882q.mo697f()) - 28800000;
                    if (g > 0) {
                        Long valueOf = Long.valueOf(8);
                        Long valueOf2 = Long.valueOf(30);
                        C1176p<Field> c1176p2 = c1176p;
                        c1176p2.m5957a(Field.NONE, new C1168m(Math.max(e.mo697f(), e.mo698g() - g), e.mo698g(), ErrorCode.DRIVING_WITHOUT_SHIFT_BREAK, new C1175o(ValidationMessageId.RULE_SHIFT_BETWEEN_BREAKS, new Object[]{valueOf, valueOf2})));
                    }
                } else {
                    return;
                }
            }
        }
    }
}
