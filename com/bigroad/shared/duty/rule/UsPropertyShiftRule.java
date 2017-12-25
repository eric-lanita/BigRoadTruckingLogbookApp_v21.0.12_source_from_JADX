package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0904n;
import com.bigroad.shared.duty.C0907o;
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
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;

public class UsPropertyShiftRule implements C0917w {
    private final long f2827a;
    private final long f2828b;
    private final long f2829c;
    private final boolean f2830d;

    public enum CaliforniaExceptions {
        _500_GALLON,
        FARM_PRODUCTS,
        MOTION_PICTURE
    }

    private class C0915a {
        final /* synthetic */ UsPropertyShiftRule f2818a;
        private final long f2819b;
        private C0916b f2820c;
        private long f2821d = 28800000;
        private DutyStatus f2822e = null;
        private C0916b f2823f = this.f2820c;

        public C0915a(UsPropertyShiftRule usPropertyShiftRule, C0898i c0898i) {
            this.f2818a = usPropertyShiftRule;
            this.f2819b = C0950u.m4822a(c0898i.m4557d()).getTimeInMillis();
            this.f2820c = new C0916b(usPropertyShiftRule.f2828b, usPropertyShiftRule.f2829c, null);
        }

        public C0916b m4611a(C0882q c0882q) {
            long a = this.f2818a.f2828b - c0882q.m4454e();
            long b = this.f2818a.f2829c - (c0882q.mo689a() - C0952v.m4838d(c0882q));
            if (!m4615a(c0882q.mo698g())) {
                return new C0916b(a, b);
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
            return new C0916b(a, b, Long.valueOf(Math.min(28800000 - j, a)));
        }

        private void m4610a(C0898i c0898i, C0882q c0882q, List<C0952v> list, C0953s<C0952v> c0953s) {
            int j;
            C0952v c0952v;
            if (c0953s == null) {
                j = c0882q.m4463j();
            } else {
                j = ((C0952v) c0953s.m4846b()).m4463j();
            }
            int k = c0882q.m4464k();
            for (C0952v c0952v2 : C0831a.m4105a(list)) {
                if (c0952v2.m4463j() >= j) {
                    if (c0952v2.m4464k() < k) {
                        break;
                    }
                } else {
                    c0952v2 = null;
                    break;
                }
            }
            c0952v2 = null;
            if (c0952v2 != null) {
                if (c0952v2.m4842c()) {
                    this.f2822e = DutyStatus.OFF_DUTY;
                    this.f2821d = 7200000 - c0898i.m4558e().m4457f(7200000);
                } else if (c0952v2.m4841b()) {
                    this.f2822e = DutyStatus.SLEEPER;
                    this.f2821d = 28800000 - c0898i.m4558e().m4459g(28800000);
                }
                if (this.f2822e != null) {
                    List arrayList = new ArrayList(c0898i.m4561h() - c0952v2.m4843l());
                    for (int l = c0952v2.m4843l(); l < c0898i.m4561h(); l++) {
                        arrayList.add(c0898i.m4552b(l));
                    }
                    arrayList.add(new C0896g(c0898i.mo698g(), c0898i.mo698g() + this.f2821d, this.f2822e));
                    this.f2823f = m4611a(new C0882q(arrayList));
                }
            }
        }

        public void m4614a(C0898i c0898i, C0882q c0882q) {
            C0953s c0953s;
            List b = C0952v.m4836b(c0882q);
            List a = C0952v.m4834a(b);
            if (a.isEmpty()) {
                c0953s = null;
            } else {
                c0953s = (C0953s) a.get(a.size() - 1);
            }
            m4610a(c0898i, c0882q, b, c0953s);
            if (c0953s != null) {
                this.f2820c = m4611a(c0898i.m4550a(((C0952v) c0953s.m4845a()).m4843l(), c0882q.m4464k()));
            }
        }

        public boolean m4615a(long j) {
            return this.f2818a.f2830d && j > this.f2819b;
        }

        public void m4613a(C0868a c0868a, DutyStatus dutyStatus, long j) {
            c0868a.m4356c(new C0902k(this.f2820c.m4616a(), this.f2818a.f2828b, DutyStatus.DRIVING.mo701a(dutyStatus)));
            c0868a.m4350a(new C0902k(this.f2820c.m4619d(), this.f2818a.f2829c, j > 0));
            if (this.f2820c.m4617b()) {
                c0868a.m4358d(new C0902k(this.f2820c.m4618c(), 28800000));
            }
        }

        public void m4612a(C0868a c0868a, DutyStatus dutyStatus) {
            if (this.f2822e != null) {
                c0868a.m4359d(new C0955u(this.f2821d, this.f2818a.f2827a, C0904n.m4577a(this.f2822e, dutyStatus)));
                c0868a.m4349a(this.f2822e);
                c0868a.m4360e(new C0902k(this.f2823f.m4616a(), this.f2818a.f2828b));
                c0868a.m4361f(new C0902k(this.f2823f.m4619d(), this.f2818a.f2829c));
            }
        }
    }

    private static class C0916b {
        private final long f2824a;
        private final Long f2825b;
        private final long f2826c;

        public C0916b(long j, long j2) {
            this(j, j2, null);
        }

        public C0916b(long j, long j2, Long l) {
            this.f2824a = j;
            this.f2826c = j2;
            this.f2825b = l;
        }

        public long m4616a() {
            return this.f2824a;
        }

        public boolean m4617b() {
            return this.f2825b != null;
        }

        public long m4618c() {
            return Math.min(this.f2824a, this.f2825b.longValue());
        }

        public long m4619d() {
            return this.f2826c;
        }
    }

    private UsPropertyShiftRule(long j, long j2, long j3, boolean z) {
        this.f2827a = j;
        this.f2828b = j2;
        this.f2829c = j3;
        this.f2830d = z;
    }

    public static C0913a m4626a(final boolean z) {
        return new C0913a() {
            public C0917w mo733a() {
                return UsPropertyShiftRule.m4630b(z);
            }

            public C0917w mo734a(long j) {
                return new UsPropertyShiftRule(36000000, 39600000, j, !z);
            }
        };
    }

    public static C0917w m4630b(boolean z) {
        return new UsPropertyShiftRule(36000000, 39600000, 50400000, !z);
    }

    public static C0912j m4625a(EnumSet<CaliforniaExceptions> enumSet) {
        long j = 36000000;
        long j2 = 28800000;
        boolean contains = enumSet.contains(CaliforniaExceptions._500_GALLON);
        boolean contains2 = enumSet.contains(CaliforniaExceptions.FARM_PRODUCTS);
        boolean contains3 = enumSet.contains(CaliforniaExceptions.MOTION_PICTURE);
        if (!(contains2 || contains3)) {
            j2 = 36000000;
        }
        if (!contains) {
            j = 43200000;
        }
        return new UsPropertyShiftRule(j2, j, contains3 ? 54000000 : 57600000, false);
    }

    public long mo737c() {
        return this.f2827a;
    }

    public long mo738d() {
        return this.f2829c;
    }

    public boolean mo735a(C0898i c0898i, C0882q c0882q) {
        return !C0952v.m4834a(C0952v.m4836b(c0882q)).isEmpty();
    }

    public boolean mo736a(C0882q c0882q, long j) {
        return false;
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0915a c0915a = new C0915a(this, c0898i);
        Iterator h = c0898i.m4558e().m4460h(this.f2827a);
        C0882q c0882q = null;
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
        }
        long f = this.f2827a - c0898i.m4558e().m4457f(this.f2827a);
        Long l = null;
        if (c0915a.m4615a(c0898i.mo698g())) {
            c0915a.f2820c = new C0916b(this.f2828b, this.f2829c, Long.valueOf(28800000));
            l = Long.valueOf(1800000 - c0898i.m4558e().m4457f(1800000));
        }
        if (c0882q != null && f > 0) {
            c0915a.f2820c = c0915a.m4611a(c0882q);
            c0915a.m4614a(c0898i, c0882q);
        }
        DutyStatus a = C0904n.m4576a(c0898i);
        c0915a.m4613a(c0868a, a, f);
        boolean a2 = C0896g.f2771d.mo701a(a);
        if (l != null) {
            c0868a.m4351a(new C0955u(l.longValue(), 1800000));
        }
        c0868a.m4355b(new C0955u(f, this.f2827a, a2));
        if (a2 && f > 0) {
            c0868a.m4348a(f);
        }
        c0915a.m4612a(c0868a, a);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(this.f2827a);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b((ao) c)) {
                m4627a(c0898i, c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4627a(C0898i c0898i, C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        List<C0953s> c = C0952v.m4837c(c0882q);
        int j = c0882q.m4463j();
        long f = c0882q.mo697f();
        int i = j;
        for (C0953s c0953s : c) {
            C0882q a = c0898i.m4550a(i, ((C0952v) c0953s.m4846b()).m4463j());
            m4628a(c0907o, a, (C1176p) c1176p, f);
            j = ((C0952v) c0953s.m4845a()).m4843l();
            f = a.mo698g();
            i = j;
        }
        m4628a(c0907o, c0898i.m4550a(i, c0882q.m4464k()), (C1176p) c1176p, f);
    }

    private void m4628a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p, long j) {
        Iterator it = c0882q.iterator();
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (c0896g.mo695d(c0907o)) {
                break;
            } else if (c0896g.m4542e()) {
                j4 = c0896g.mo689a() + j4;
            } else {
                if (j4 < 28800000) {
                    j2 += j4;
                }
                if (c0896g.m4128c((ao) c0907o) || !c0896g.m4541d()) {
                    if (c0896g.m4541d()) {
                        j4 = c0896g.mo689a() + j3;
                    } else {
                        j4 = j3;
                    }
                    j3 = j4;
                    j2 = c0896g.mo689a() + j2;
                    j4 = 0;
                } else {
                    C1176p<Field> c1176p2;
                    Enum enumR;
                    ao e = c0896g.mo696e(c0907o);
                    j4 = e.mo697f() - c0896g.mo697f();
                    long j5 = j3 + j4;
                    long j6 = j2 + j4;
                    long a = e.mo689a();
                    j4 = (j5 + a) - this.f2828b;
                    if (j4 > 0 && c0896g.mo697f() >= j) {
                        Long valueOf = Long.valueOf(this.f2828b / 3600000);
                        Enum enumR2 = Field.NONE;
                        c1176p2 = c1176p;
                        enumR = enumR2;
                        c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j4), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DRIVE, new Object[]{valueOf})));
                    }
                    j4 = (j6 + a) - this.f2829c;
                    if (j4 > 0 && c0896g.mo697f() >= j) {
                        Long valueOf2 = Long.valueOf(this.f2829c / 3600000);
                        Enum enumR3 = Field.NONE;
                        c1176p2 = c1176p;
                        enumR = enumR3;
                        c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j4), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DURATION_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DUTY_PROPERTY, new Object[]{valueOf2})));
                    }
                    j4 = c0896g.mo698g() - e.mo697f();
                    j3 = j5 + j4;
                    j2 = j4 + j6;
                    j4 = 0;
                }
            }
        }
        m4631b(c0907o, c0882q, c1176p, j);
    }

    private void m4631b(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p, long j) {
        if (this.f2830d && c0907o.a_() >= 15887) {
            Iterator h = c0882q.m4460h(1800000);
            while (h.hasNext()) {
                C0882q c0882q2 = (C0882q) h.next();
                if (c0882q2.mo693b((ao) c0907o)) {
                    m4632c(c0907o, c0882q2, c1176p, j);
                } else if (c0882q2.mo695d(c0907o)) {
                    return;
                }
            }
        }
    }

    private void m4632c(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p, long j) {
        Iterator it = c0882q.iterator();
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (c0896g.m4541d() && !c0896g.m4128c((ao) c0907o)) {
                if (!c0896g.mo695d(c0907o)) {
                    ao e = c0896g.mo696e(c0907o);
                    long g = (e.mo698g() - c0882q.mo697f()) - 28800000;
                    if (g > 0 && c0896g.mo697f() >= j) {
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
