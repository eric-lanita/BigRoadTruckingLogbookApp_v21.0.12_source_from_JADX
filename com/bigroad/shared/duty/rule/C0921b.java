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

public class C0921b implements C0912j {

    private static class C0920a {
        private long f2831a;
        private long f2832b;
        private long f2833c;
        private long f2834d;
        private long f2835e;
        private DutyStatus f2836f;

        private C0920a() {
            this.f2831a = 72000000;
            this.f2832b = 54000000;
            this.f2833c = 28800000;
            this.f2834d = -1;
            this.f2835e = -1;
            this.f2836f = null;
        }

        private void m4644a(C0898i c0898i, C0882q c0882q, List<C0952v> list, C0953s<C0952v> c0953s) {
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
                    this.f2836f = DutyStatus.OFF_DUTY;
                    this.f2833c = 7200000 - c0898i.m4558e().m4457f(7200000);
                } else if (c0952v2.m4841b()) {
                    this.f2836f = DutyStatus.SLEEPER;
                    this.f2833c = 28800000 - c0898i.m4558e().m4459g(28800000);
                }
                if (this.f2836f != null) {
                    List arrayList = new ArrayList(c0898i.m4561h() - c0952v2.m4843l());
                    for (int l = c0952v2.m4843l(); l < c0898i.m4561h(); l++) {
                        arrayList.add(c0898i.m4552b(l));
                    }
                    arrayList.add(new C0896g(c0898i.mo698g(), c0898i.mo698g() + this.f2833c, this.f2836f));
                    C0882q c0882q2 = new C0882q(arrayList);
                    this.f2834d = 54000000 - c0882q2.m4454e();
                    this.f2835e = 72000000 - c0882q2.m4452d();
                }
            }
        }

        public void m4647a(C0898i c0898i, C0882q c0882q) {
            C0953s c0953s;
            List b = C0952v.m4836b(c0882q);
            List a = C0952v.m4834a(b);
            if (a.isEmpty()) {
                c0953s = null;
            } else {
                c0953s = (C0953s) a.get(a.size() - 1);
            }
            m4644a(c0898i, c0882q, b, c0953s);
            if (c0953s != null) {
                C0882q a2 = c0898i.m4550a(((C0952v) c0953s.m4845a()).m4843l(), c0882q.m4464k());
                this.f2832b = 54000000 - a2.m4454e();
                this.f2831a = 72000000 - a2.m4452d();
            }
        }

        public void m4646a(C0868a c0868a, DutyStatus dutyStatus) {
            c0868a.m4356c(new C0902k(this.f2832b, 54000000, DutyStatus.DRIVING.mo701a(dutyStatus)));
            c0868a.m4350a(new C0902k(this.f2831a, 72000000, C0896g.f2769b.mo701a(dutyStatus)));
        }

        public void m4648b(C0868a c0868a, DutyStatus dutyStatus) {
            if (this.f2836f != null) {
                c0868a.m4359d(new C0955u(this.f2833c, 36000000, C0904n.m4577a(this.f2836f, dutyStatus)));
                c0868a.m4349a(this.f2836f);
            }
            if (this.f2834d >= 0) {
                c0868a.m4360e(new C0902k(this.f2834d, 54000000));
            }
            if (this.f2835e >= 0) {
                c0868a.m4361f(new C0902k(this.f2835e, 72000000));
            }
        }
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0920a c0920a = new C0920a();
        Iterator h = c0898i.m4558e().m4460h(36000000);
        C0882q c0882q = null;
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
        }
        long f = 36000000 - c0898i.m4558e().m4457f(36000000);
        if (c0882q != null && f > 0) {
            c0920a.f2832b = 54000000 - c0882q.m4454e();
            c0920a.f2831a = 72000000 - c0882q.m4452d();
            c0920a.m4647a(c0898i, c0882q);
        }
        DutyStatus a = C0904n.m4576a(c0898i);
        c0920a.m4646a(c0868a, a);
        boolean a2 = C0896g.f2771d.mo701a(a);
        c0868a.m4355b(new C0955u(f, 36000000, a2));
        if (a2 && f > 0) {
            c0868a.m4348a(f);
        }
        c0920a.m4648b(c0868a, a);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        ao c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(36000000);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b(c)) {
                m4649a(c0898i, c, c0882q, c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4649a(C0898i c0898i, C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        List<C0953s> c = C0952v.m4837c(c0882q);
        int j = c0882q.m4463j();
        int i = j;
        for (C0953s a : c) {
            C0882q a2 = c0898i.m4550a(i, ((C0952v) a.m4845a()).m4843l());
            m4650a(c0907o, a2, (C1176p) c1176p);
            i = a2.m4464k();
        }
        m4650a(c0907o, c0898i.m4550a(i, c0882q.m4464k()), (C1176p) c1176p);
    }

    private void m4650a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
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
                    j2 = (j3 + a) - 54000000;
                    if (j2 > 0) {
                        Long valueOf = Long.valueOf(15);
                        Enum enumR2 = Field.NONE;
                        c1176p2 = c1176p;
                        enumR = enumR2;
                        c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j2), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DRIVE, new Object[]{valueOf})));
                    }
                    j2 = (j4 + a) - 72000000;
                    if (j2 > 0) {
                        Long valueOf2 = Long.valueOf(20);
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
