package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0904n;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.Iterator;

public class C0938o implements C0912j {
    public void mo732a(C0898i c0898i, C0868a c0868a) {
        long j;
        Iterator h = c0898i.m4558e().m4460h(28800000);
        C0882q c0882q = null;
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
        }
        long f = 28800000 - c0898i.m4558e().m4457f(28800000);
        long j2 = 36000000;
        if (c0882q == null || f <= 0) {
            j = 54000000;
        } else {
            j2 = 36000000 - c0882q.m4454e();
            j = 54000000 - c0882q.m4452d();
        }
        DutyStatus a = C0904n.m4576a(c0898i);
        boolean a2 = C0896g.f2771d.mo701a(a);
        c0868a.m4356c(new C0902k(j2, 36000000, DutyStatus.DRIVING.mo701a(a)));
        c0868a.m4350a(new C0902k(j, 54000000, C0896g.f2769b.mo701a(a)));
        c0868a.m4355b(new C0955u(f, 28800000, a2));
        if (a2 && f > 0) {
            c0868a.m4348a(f);
        }
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(28800000);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b((ao) c)) {
                m4746a(c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4746a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
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
                    j2 = (j3 + a) - 36000000;
                    if (j2 > 0) {
                        Long valueOf = Long.valueOf(10);
                        Enum enumR2 = Field.NONE;
                        c1176p2 = c1176p;
                        enumR = enumR2;
                        c1176p2.m5957a(enumR, new C1168m(Math.max(e.mo697f(), e.mo698g() - j2), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DRIVE, new Object[]{valueOf})));
                    }
                    j2 = (j4 + a) - 54000000;
                    if (j2 > 0) {
                        Long valueOf2 = Long.valueOf(15);
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
