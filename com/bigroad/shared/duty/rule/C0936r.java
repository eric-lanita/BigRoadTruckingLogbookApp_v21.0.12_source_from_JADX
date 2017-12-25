package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0896g.C0870a;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0904n;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0910r;
import com.bigroad.shared.duty.C0953s;
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
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C0936r implements C0912j {
    private final long f2877a;
    private final long f2878b;

    private final class C0944a {
        final /* synthetic */ C0936r f2895a;
        private long f2896b;
        private long f2897c;
        private long f2898d = -1;
        private long f2899e = -1;
        private long f2900f = -1;

        public C0944a(C0936r c0936r) {
            this.f2895a = c0936r;
            this.f2896b = c0936r.f2877a;
            this.f2897c = c0936r.f2878b;
        }

        private void m4796a(C0898i c0898i, C0882q c0882q, List<C0882q> list, C0953s<C0882q> c0953s) {
            int j;
            C0882q c0882q2;
            if (c0953s == null) {
                j = c0882q.m4463j();
            } else {
                j = c0953s.m4846b().m4464k();
            }
            int k = c0882q.m4464k();
            for (C0882q c0882q3 : C0831a.m4105a(list)) {
                C0882q c0882q32;
                if (c0882q32.m4463j() >= j) {
                    if (c0882q32.m4464k() < k) {
                        c0882q2 = c0882q32;
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
                    if (!this.f2895a.m4731a(c0898i.m4550a(j, k))) {
                        this.f2898d = 28800000 - (c0898i.m4558e().m4459g(28800000) + c0882q2.mo689a());
                        c0882q32 = c0898i.m4550a(c0882q2.m4464k(), c0882q.m4464k());
                        this.f2899e = this.f2895a.f2877a - c0882q32.m4454e();
                        this.f2900f = this.f2895a.f2878b - c0882q32.m4452d();
                    }
                }
            }
        }

        public void m4800a(C0898i c0898i, C0882q c0882q) {
            C0953s c0953s;
            List b = this.f2895a.m4734b(c0882q);
            List a = this.f2895a.m4727a(c0898i, c0882q, b);
            if (a.isEmpty()) {
                c0953s = null;
            } else {
                c0953s = (C0953s) a.get(a.size() - 1);
            }
            m4796a(c0898i, c0882q, b, c0953s);
            if (c0953s != null) {
                C0882q a2 = c0898i.m4550a(c0953s.m4845a().m4464k(), c0882q.m4464k());
                this.f2896b = this.f2895a.f2877a - a2.m4454e();
                this.f2897c = this.f2895a.f2878b - a2.m4452d();
            }
        }

        public void m4799a(C0868a c0868a, DutyStatus dutyStatus) {
            if (this.f2898d >= 0) {
                c0868a.m4359d(new C0955u(this.f2898d, 28800000, this.f2895a.mo739c().mo701a(dutyStatus)));
            }
            c0868a.m4349a(this.f2895a.mo740d());
            if (this.f2899e >= 0) {
                c0868a.m4360e(new C0902k(this.f2899e, this.f2895a.f2877a));
            }
            if (this.f2900f >= 0) {
                c0868a.m4361f(new C0902k(this.f2900f, this.f2895a.f2878b));
            }
        }
    }

    protected C0936r(long j, long j2) {
        this.f2877a = j;
        this.f2878b = j2;
    }

    public static C0936r m4736e() {
        return new C0936r(36000000, 54000000);
    }

    public static C0936r m4737f() {
        return new C0936r(54000000, 72000000);
    }

    private boolean m4731a(C0882q c0882q) {
        return c0882q.m4454e() > this.f2877a || c0882q.m4453d(this.f2878b) != null;
    }

    private List<C0882q> m4734b(C0882q c0882q) {
        return ((C0910r) c0882q.m4450a(mo739c(), C0910r.m4592a(7200000))).m4593a();
    }

    private List<C0953s<C0882q>> m4727a(C0898i c0898i, C0882q c0882q, List<C0882q> list) {
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
                if (c0882q2.mo689a() + c0882q3.mo689a() < 28800000) {
                    i4++;
                } else {
                    if (m4731a(c0898i.m4550a(j, c0882q3.m4463j()))) {
                        i2 = i;
                        i3 = j;
                    } else {
                        if (m4731a(c0898i.m4550a(c0882q2.m4464k(), i4 < size + -1 ? ((C0882q) list.get(i4 + 1)).m4463j() : c0882q.m4464k()))) {
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

    private List<C0953s<C0882q>> m4726a(C0898i c0898i, C0882q c0882q) {
        return m4727a(c0898i, c0882q, m4734b(c0882q));
    }

    protected C0870a mo739c() {
        return DutyStatus.SLEEPER;
    }

    protected DutyStatus mo740d() {
        return DutyStatus.SLEEPER;
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0944a c0944a = new C0944a(this);
        Iterator h = c0898i.m4558e().m4460h(28800000);
        C0882q c0882q = null;
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
        }
        long f = 28800000 - c0898i.m4558e().m4457f(28800000);
        if (c0882q != null && f > 0) {
            c0944a.f2896b = this.f2877a - c0882q.m4454e();
            c0944a.f2897c = this.f2878b - c0882q.m4452d();
            c0944a.m4800a(c0898i, c0882q);
        }
        DutyStatus a = C0904n.m4576a(c0898i);
        boolean a2 = C0896g.f2771d.mo701a(a);
        c0868a.m4356c(new C0902k(c0944a.f2896b, this.f2877a, DutyStatus.DRIVING.mo701a(a)));
        c0868a.m4350a(new C0902k(c0944a.f2897c, this.f2878b, C0896g.f2769b.mo701a(a)));
        c0868a.m4355b(new C0955u(f, 28800000, a2));
        if (a2 && f > 0) {
            c0868a.m4348a(f);
        }
        c0944a.m4799a(c0868a, a);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(28800000);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b((ao) c)) {
                m4729a(c0898i, c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4729a(C0898i c0898i, C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        List<C0953s> a = m4726a(c0898i, c0882q);
        int j = c0882q.m4463j();
        int i = j;
        for (C0953s b : a) {
            C0882q a2 = c0898i.m4550a(i, b.m4846b().m4464k());
            m4730a(c0907o, a2, (C1176p) c1176p);
            i = a2.m4464k();
        }
        m4730a(c0907o, c0898i.m4550a(i, c0882q.m4464k()), (C1176p) c1176p);
    }

    private void m4730a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Iterator it = c0882q.iterator();
        long j = 0;
        long j2 = 0;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (!c0896g.mo695d(c0907o)) {
                if (c0896g.m4128c((ao) c0907o) || !c0896g.m4541d()) {
                    if (c0896g.m4541d()) {
                        j2 += c0896g.mo689a();
                    }
                    if (c0896g.m4539b()) {
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
                    j2 = (j3 + a) - this.f2877a;
                    if (j2 > 0) {
                        Long valueOf = Long.valueOf(this.f2877a / 3600000);
                        Enum enumR2 = Field.NONE;
                        c1176p2 = c1176p;
                        enumR = enumR2;
                        c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j2), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DRIVE, new Object[]{valueOf})));
                    }
                    j2 = (j4 + a) - this.f2878b;
                    if (j2 > 0) {
                        Long valueOf2 = Long.valueOf(this.f2878b / 3600000);
                        Enum enumR3 = Field.NONE;
                        c1176p2 = c1176p;
                        enumR = enumR3;
                        c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j2), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DUTY_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DUTY, new Object[]{valueOf2})));
                    }
                    j2 = c0896g.mo698g() - e.mo697f();
                    j = j2 + j4;
                    j2 = j3 + j2;
                }
            } else {
                return;
            }
        }
    }
}
