package com.bigroad.shared.duty.rule;

import com.bigroad.shared.ao;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0883p;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.DutyLimits.C0868a;
import com.bigroad.shared.duty.rule.C0917w.C0913a;
import com.bigroad.shared.validation.C1176p;
import com.bigroad.shared.validation.model.DailyLog.Field;
import java.util.Iterator;
import java.util.TimeZone;

public class BigDayCycleAndShiftRule implements C0912j {
    private final C0912j f2810a;
    private final C0933i f2811b;
    private final C0913a f2812c;

    public enum CycleLength {
        _7_DAY,
        _8_DAY
    }

    public BigDayCycleAndShiftRule(CycleLength cycleLength, C0912j c0912j, C0913a c0913a) {
        C0933i a;
        this.f2810a = c0912j;
        if (cycleLength == CycleLength._7_DAY) {
            a = C0950u.m4821a();
        } else {
            a = C0950u.m4824b();
        }
        this.f2811b = a;
        this.f2812c = c0913a;
    }

    private boolean m4600a(C0898i c0898i) {
        return m4601a(c0898i, null);
    }

    private boolean m4601a(C0898i c0898i, C0907o c0907o) {
        C0882q a;
        if (c0907o == null) {
            a = this.f2811b.mo741a(c0898i);
        } else {
            a = this.f2811b.mo742a(c0898i, c0907o);
        }
        C0917w a2 = this.f2812c.mo733a();
        TimeZone d = c0898i.m4557d();
        if (a == null) {
            return true;
        }
        C0907o c0907o2 = null;
        C0882q c0882q = null;
        Iterator h = a.m4460h(36000000);
        while (h.hasNext()) {
            c0882q = (C0882q) h.next();
            if (c0907o != null && c0882q.mo693b((ao) c0907o)) {
                break;
            } else if (c0882q.mo689a() > a2.mo738d() && !a2.mo736a(c0882q, 57600000) && c0898i.m4548a(c0882q.mo697f() + a2.mo738d(), c0882q.mo698g()).m4454e() > 0) {
                c0907o2 = C0907o.m4580a(d, c0882q.mo698g());
            }
        }
        if (c0882q == null) {
            return true;
        }
        if (c0907o != null) {
            a = C0883p.m4467a(a, a.mo697f(), c0907o.mo698g());
        }
        long max = Math.max(36000000, a2.mo737c());
        if (a.m4457f(max) == max) {
            return m4602a(c0907o2, a.mo698g(), d);
        }
        if (a2.mo735a(c0898i, c0882q)) {
            return false;
        }
        if (a2.mo736a(c0882q, 57600000)) {
            return false;
        }
        return m4602a(c0907o2, c0882q.mo697f(), d);
    }

    private static boolean m4602a(C0907o c0907o, long j, TimeZone timeZone) {
        if (c0907o == null) {
            return true;
        }
        return c0907o.m4128c(C0907o.m4580a(timeZone, j).m4584a(-6));
    }

    public void mo732a(C0898i c0898i, C0868a c0868a) {
        C0912j a;
        this.f2810a.mo732a(c0898i, c0868a);
        if (m4600a(c0898i)) {
            a = this.f2812c.mo734a(57600000);
        } else {
            a = this.f2812c.mo733a();
        }
        a.mo732a(c0898i, c0868a);
    }

    public void mo731a(C0898i c0898i, int i, C1176p<Field> c1176p) {
        C0912j a;
        this.f2810a.mo731a(c0898i, i, c1176p);
        if (m4601a(c0898i, c0898i.m4554c(i))) {
            a = this.f2812c.mo734a(57600000);
        } else {
            a = this.f2812c.mo733a();
        }
        a.mo731a(c0898i, i, c1176p);
    }
}
