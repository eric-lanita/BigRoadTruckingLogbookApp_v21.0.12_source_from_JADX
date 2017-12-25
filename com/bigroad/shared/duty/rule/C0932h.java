package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0904n;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.duty.DutyStatus;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.Calendar;
import java.util.Iterator;

public class C0932h implements C0912j {
    private final int f2873a;
    private final long f2874b;

    public C0932h(int i, long j) {
        this.f2873a = i;
        this.f2874b = j;
    }

    private long m4711a(C0898i c0898i) {
        long g;
        for (C0896g c0896g : c0898i.m4558e().m4462i()) {
            if (c0896g.m4539b()) {
                g = c0896g.mo698g();
                break;
            }
        }
        g = 0;
        if (g == 0) {
            return 0;
        }
        Calendar calendar = (Calendar) aq.m4228b(c0898i.m4557d(), g).clone();
        calendar.add(5, this.f2873a);
        return Math.max(0, calendar.getTimeInMillis() - c0898i.mo698g());
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        long a = m4711a(c0898i);
        long a2 = this.f2874b - C0924k.m4657a(c0898i.m4558e(), c0898i.m4557d(), this.f2873a);
        DutyStatus a3 = C0904n.m4576a(c0898i);
        boolean a4 = C0896g.f2769b.mo701a(a3);
        boolean a5 = C0896g.f2771d.mo701a(a3);
        c0868a.m4354b(new C0902k(a2, this.f2874b, a4));
        c0868a.m4357c(new C0955u(a, ((long) this.f2873a) * 86400000, a5));
        if (a5 && a > 0) {
            c0868a.m4348a(a);
        }
        if (a > 0 || a4) {
            Calendar b = aq.m4228b(c0898i.m4557d(), c0898i.mo698g());
            b.add(5, 1);
            c0868a.m4352a(b.getTime());
        }
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        ao c = c0898i.m4554c(i);
        C0882q e = c0898i.m4558e();
        Calendar c2 = c.m4586c();
        c2.add(5, -(this.f2873a - 1));
        long a = e.m4445a(c2.getTimeInMillis(), c.mo697f());
        Iterator it = e.iterator();
        long j = a;
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (!c0896g.m4128c(c)) {
                if (!c0896g.mo695d(c)) {
                    if (!c0896g.m4540c()) {
                        ao e2 = c0896g.mo696e(c);
                        long a2 = e2.mo689a();
                        long max = Math.max(0, this.f2874b - j);
                        if (c0896g.m4541d() && max < a2) {
                            Long valueOf = Long.valueOf(this.f2874b / 3600000);
                            Integer valueOf2 = Integer.valueOf(this.f2873a);
                            Enum enumR = Field.NONE;
                            C1176p<Field> c1176p2 = c1176p;
                            Enum enumR2 = enumR;
                            c1176p2.m5957a(enumR2, new C1168m(max + e2.mo697f(), e2.mo698g(), ErrorCode.DRIVING_OVER_DUTY_CYCLE_LIMIT, new C1175o(ValidationMessageId.RULE_CYCLE_DUTY, new Object[]{valueOf, valueOf2})));
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
