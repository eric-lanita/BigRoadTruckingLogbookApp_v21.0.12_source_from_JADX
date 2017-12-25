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
import java.util.TimeZone;

public class C0924k implements C0912j {
    private final int f2837a;
    private final long f2838b;
    private final long f2839c;

    public C0924k(int i, long j, long j2) {
        this.f2837a = i;
        this.f2838b = j;
        this.f2839c = j2;
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        List arrayList = new ArrayList();
        Iterator h = c0898i.m4558e().m4460h(this.f2839c);
        while (h.hasNext()) {
            arrayList.add(h.next());
        }
        long f = this.f2839c - c0898i.m4558e().m4457f(this.f2839c);
        long j = this.f2838b;
        if (!arrayList.isEmpty() && f > 0) {
            j = this.f2838b - C0924k.m4657a((C0882q) arrayList.get(arrayList.size() - 1), c0898i.m4557d(), this.f2837a);
        }
        DutyStatus a = C0904n.m4576a(c0898i);
        boolean a2 = C0896g.f2769b.mo701a(a);
        boolean a3 = C0896g.f2771d.mo701a(a);
        c0868a.m4354b(new C0902k(j, this.f2838b, a2));
        c0868a.m4357c(new C0955u(f, this.f2839c, a3));
        if (a3 && f > 0) {
            c0868a.m4348a(f);
        }
        if (f > 0 || a2) {
            Calendar b = aq.m4228b(c0898i.m4557d(), c0898i.mo698g());
            b.add(5, 1);
            c0868a.m4352a(b.getTime());
        }
        c0868a.m4353a(arrayList);
    }

    public static long m4657a(C0882q c0882q, TimeZone timeZone, int i) {
        long g = c0882q.mo698g();
        Calendar b = aq.m4228b(timeZone, g);
        b.add(5, -(i - 1));
        return c0882q.m4445a(b.getTimeInMillis(), g);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0907o c = c0898i.m4554c(i);
        Iterator h = c0898i.m4558e().m4460h(this.f2839c);
        while (h.hasNext()) {
            C0882q c0882q = (C0882q) h.next();
            if (c0882q.mo693b((ao) c)) {
                m4658a(c, c0882q, (C1176p) c1176p);
            } else if (c0882q.mo695d(c)) {
                return;
            }
        }
    }

    private void m4658a(C0907o c0907o, C0882q c0882q, C1176p<Field> c1176p) {
        Calendar c = c0907o.m4586c();
        c.add(5, -(this.f2837a - 1));
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
                        long max = Math.max(0, this.f2838b - j);
                        if (c0896g.m4541d() && max < a2) {
                            Long valueOf = Long.valueOf(this.f2838b / 3600000);
                            Integer valueOf2 = Integer.valueOf(this.f2837a);
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
