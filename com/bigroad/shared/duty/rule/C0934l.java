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

public class C0934l implements C0912j {
    private final long f2875a;
    private final long f2876b;

    public static C0934l m4716a() {
        return new C0934l(36000000, 28800000);
    }

    public static C0934l m4718b() {
        return new C0934l(39600000, 36000000);
    }

    public static C0934l m4719c() {
        return new C0934l(43200000, 36000000);
    }

    public static C0934l m4720d() {
        return new C0934l(36000000, 36000000);
    }

    public static C0934l m4721e() {
        return new C0934l(43200000, 28800000);
    }

    private C0934l(long j, long j2) {
        this.f2875a = j;
        this.f2876b = j2;
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        long e;
        long a;
        Iterator h = c0898i.m4558e().m4460h(this.f2876b);
        C0882q c0882q = null;
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
        }
        long f = this.f2876b - c0898i.m4558e().m4457f(this.f2876b);
        boolean z = c0882q != null && f > 0;
        if (z) {
            e = this.f2875a - c0882q.m4454e();
            a = 43200000 - c0882q.mo689a();
        } else {
            e = this.f2875a;
            a = 43200000;
        }
        DutyStatus a2 = C0904n.m4576a(c0898i);
        boolean a3 = C0896g.f2771d.mo701a(a2);
        c0868a.m4356c(new C0902k(e, this.f2875a, DutyStatus.DRIVING.mo701a(a2)));
        c0868a.m4350a(new C0902k(a, 43200000, z));
        c0868a.m4355b(new C0955u(f, this.f2876b, a3));
        if (a3 && f > 0) {
            c0868a.m4348a(f);
        }
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(this.f2876b);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b((ao) c)) {
                m4717a(c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4717a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        long f = c0882q.mo697f() + 43200000;
        Iterator it = c0882q.iterator();
        long j = 0;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (!c0896g.mo695d(c0907o)) {
                if (c0896g.m4541d()) {
                    if (c0896g.m4128c((ao) c0907o)) {
                        j = c0896g.mo689a() + j;
                    } else {
                        Long valueOf;
                        Enum enumR;
                        C1176p<Field> c1176p2;
                        Enum enumR2;
                        ao e = c0896g.mo696e(c0907o);
                        long f2 = j + (e.mo697f() - c0896g.mo697f());
                        j = (e.mo689a() + f2) - this.f2875a;
                        if (j > 0) {
                            valueOf = Long.valueOf(this.f2875a / 3600000);
                            enumR = Field.NONE;
                            c1176p2 = c1176p;
                            enumR2 = enumR;
                            c1176p2.m5957a(enumR2, new C1168m(Math.max(e.mo697f(), e.mo698g() - j), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DRIVE_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DRIVE, new Object[]{valueOf})));
                        }
                        if (e.mo698g() > f) {
                            valueOf = Long.valueOf(12);
                            enumR = Field.NONE;
                            c1176p2 = c1176p;
                            enumR2 = enumR;
                            c1176p2.m5957a(enumR2, new C1168m(Math.max(e.mo697f(), f), e.mo698g(), ErrorCode.DRIVING_OVER_SHIFT_DURATION_LIMIT, new C1175o(ValidationMessageId.RULE_SHIFT_DUTY_PROPERTY, new Object[]{valueOf})));
                        }
                        j = (c0896g.mo698g() - e.mo697f()) + f2;
                    }
                }
            } else {
                return;
            }
        }
    }
}
