package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0910r;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

public class C0926f implements C0912j {
    private static final C0902k f2840b = new C0902k(432000000, 432000000);
    private final long f2841a;
    private C0902k f2842c = f2840b;
    private C0955u f2843d;
    private C0902k f2844e;
    private C0955u f2845f;
    private List<C0882q> f2846g = new ArrayList();

    public C0926f(boolean z) {
        this.f2841a = z ? 288000000 : 252000000;
        this.f2844e = new C0902k(this.f2841a, this.f2841a);
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        m4661a(c0898i);
        m4663b(c0898i);
        c0868a.m4354b(C0902k.m4574a(this.f2842c, this.f2844e));
        c0868a.m4357c(this.f2842c.m4402b() < this.f2844e.m4402b() ? this.f2843d : this.f2845f);
        c0868a.m4353a(this.f2846g);
        c0868a.m4348a(60000);
    }

    private void m4661a(C0898i c0898i) {
        Iterator h = c0898i.m4558e().m4460h(259200000);
        while (h.hasNext()) {
            this.f2846g.add((C0882q) h.next());
        }
        this.f2843d = new C0955u(259200000 - c0898i.m4558e().m4457f(259200000), 259200000);
        if (!this.f2846g.isEmpty() && this.f2843d.m4402b() > 0) {
            this.f2842c = new C0902k(432000000 - C0924k.m4657a((C0882q) this.f2846g.get(this.f2846g.size() - 1), c0898i.m4557d(), 14), 432000000);
        }
    }

    private void m4663b(C0898i c0898i) {
        C0882q b = ((C0910r) c0898i.m4558e().m4450a(C0896g.f2771d, C0910r.m4592a(86400000))).m4595b();
        b = b == null ? c0898i.m4558e() : c0898i.m4550a(b.m4464k(), c0898i.m4561h());
        if (!b.m4461h()) {
            this.f2844e = new C0902k(this.f2841a - b.m4452d(), this.f2841a);
        }
        this.f2845f = new C0955u(86400000 - c0898i.m4558e().m4457f(86400000), 86400000);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(259200000);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (!c0882q.m4128c((ao) c)) {
                if (c0882q.mo693b((ao) c)) {
                    m4662a(c, c0882q, (C1176p) c1176p);
                    m4664b(c, c0882q, c1176p);
                    return;
                }
                return;
            }
        }
    }

    private void m4662a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Calendar c = c0907o.m4586c();
        c.add(5, -13);
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
                        long max = Math.max(0, 432000000 - j);
                        if (c0896g.m4541d() && max < a2) {
                            Long valueOf = Long.valueOf(120);
                            Integer valueOf2 = Integer.valueOf(14);
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

    private void m4664b(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Iterator h = c0882q.m4460h(86400000);
        while (h.hasNext()) {
            C0882q c0882q2 = (C0882q) h.next();
            if (c0882q2.mo693b((ao) c0907o)) {
                m4665c(c0907o, c0882q2, c1176p);
            } else if (c0882q2.mo695d(c0907o)) {
                return;
            }
        }
    }

    private void m4665c(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Iterator it = c0882q.iterator();
        long j = 0;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (!c0896g.mo695d(c0907o)) {
                if (!c0896g.m4540c()) {
                    if (c0896g.m4128c((ao) c0907o)) {
                        j = c0896g.mo689a() + j;
                    } else {
                        ao e = c0896g.mo696e(c0907o);
                        long f = j + (e.mo697f() - c0896g.mo697f());
                        j = (e.mo689a() + f) - this.f2841a;
                        if (c0896g.m4541d() && j > 0) {
                            Long valueOf = Long.valueOf(this.f2841a / 3600000);
                            Long valueOf2 = Long.valueOf(24);
                            Enum enumR = Field.NONE;
                            C1176p<Field> c1176p2 = c1176p;
                            Enum enumR2 = enumR;
                            c1176p2.m5957a(enumR2, new C1168m(Math.max(e.mo697f(), e.mo698g() - j), e.mo698g(), ErrorCode.DRIVING_OVER_DUTY_CYCLE_SINCE_BREAK_LIMIT, new C1175o(ValidationMessageId.RULE_CYCLE_OFF_DUTY, new Object[]{valueOf, valueOf2})));
                        }
                        j = (c0896g.mo698g() - e.mo697f()) + f;
                    }
                }
            } else {
                return;
            }
        }
    }
}
