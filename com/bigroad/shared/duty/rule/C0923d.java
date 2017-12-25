package com.bigroad.shared.duty.rule;

import com.bigroad.shared.al;
import com.bigroad.shared.ao;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0896g;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0910r;
import com.bigroad.shared.duty.C0955u;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.validation.C1168m;
import com.bigroad.shared.validation.C1175o;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationMessageId;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.Calendar;
import java.util.Iterator;

public class C0923d implements C0912j {
    public void mo732a(C0898i c0898i, C0868a c0868a) {
        long g;
        C0882q b = ((C0910r) c0898i.m4558e().m4450a(C0896g.f2771d, C0910r.m4592a(86400000))).m4595b();
        if (b != null) {
            g = b.mo698g() - 86400000;
            Calendar instance = Calendar.getInstance(c0898i.m4557d());
            instance.setTimeInMillis(g);
            instance.add(5, 15);
            aq.m4227b(instance);
            g = Math.max(0, instance.getTimeInMillis() - c0898i.mo698g());
        } else {
            g = 0;
        }
        c0868a.m4354b(new C0902k(g, Long.MAX_VALUE));
        c0868a.m4357c(new C0955u(86400000 - c0898i.m4558e().m4457f(86400000), 86400000));
        c0868a.m4348a(60000);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        ao c = c0898i.m4554c(i);
        Calendar c2 = c.m4586c();
        c2.add(5, -14);
        ao alVar = new al(c2.getTimeInMillis(), c.mo698g());
        for (C0882q c0882q : ((C0910r) c0898i.m4558e().m4450a(C0896g.f2771d, C0910r.m4592a(86400000))).m4593a()) {
            if (!c0882q.m4128c(alVar)) {
                if (c0882q.mo695d(alVar)) {
                    break;
                } else if (c0882q.mo696e(alVar).mo689a() >= 86400000) {
                    return;
                }
            }
        }
        Iterator it = c0898i.m4558e().iterator();
        while (it.hasNext()) {
            C0896g c0896g = (C0896g) it.next();
            if (!c0896g.m4128c(c)) {
                if (!c0896g.mo695d(c)) {
                    if (c0896g.m4541d()) {
                        c1176p.m5957a(Field.NONE, new C1168m(c0896g.mo696e(c), ErrorCode.DRIVING_WITHOUT_CYCLE_BREAK, new C1175o(ValidationMessageId.RULE_CYCLE_24H)));
                    }
                } else {
                    return;
                }
            }
        }
    }
}
