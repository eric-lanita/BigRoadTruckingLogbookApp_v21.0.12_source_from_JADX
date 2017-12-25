package com.bigroad.shared.duty;

import com.bigroad.shared.duty.rule.C0912j;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class DutyLimits {
    private final C0902k f2703a;
    private final C0902k f2704b;
    private final C0902k f2705c;
    private final C0902k f2706d;
    private final C0902k f2707e;
    private final C0955u f2708f;
    private final C0955u f2709g;
    private final C0955u f2710h;
    private final C0955u f2711i;
    private final SplitSleeperResetStatus f2712j;
    private final C0902k f2713k;
    private final C0902k f2714l;
    private final Date f2715m;
    private final List<C0882q> f2716n;

    public enum SplitSleeperResetStatus {
        OFF_DUTY_OR_SLEEPER,
        SLEEPER_ONLY
    }

    public static class C0868a {
        private final long f2689a;
        private C0902k f2690b = C0902k.f2794a;
        private C0902k f2691c = C0902k.f2794a;
        private C0902k f2692d = C0902k.f2794a;
        private C0955u f2693e = C0955u.f2931a;
        private C0955u f2694f = C0955u.f2931a;
        private C0902k f2695g = null;
        private C0955u f2696h = null;
        private C0955u f2697i = null;
        private SplitSleeperResetStatus f2698j = SplitSleeperResetStatus.OFF_DUTY_OR_SLEEPER;
        private C0902k f2699k = C0902k.f2794a;
        private C0902k f2700l = C0902k.f2794a;
        private Date f2701m = null;
        private List<C0882q> f2702n = Collections.emptyList();

        public C0868a(long j) {
            this.f2689a = j;
        }

        public void m4350a(C0902k c0902k) {
            this.f2691c = C0902k.m4574a(this.f2691c, c0902k);
        }

        public void m4354b(C0902k c0902k) {
            this.f2692d = C0902k.m4574a(this.f2692d, c0902k);
        }

        public void m4356c(C0902k c0902k) {
            this.f2690b = C0902k.m4574a(this.f2690b, c0902k);
        }

        public void m4358d(C0902k c0902k) {
            this.f2695g = C0902k.m4574a(this.f2695g, c0902k);
        }

        public void m4351a(C0955u c0955u) {
            this.f2696h = C0955u.m4858a(this.f2696h, c0955u);
        }

        public void m4355b(C0955u c0955u) {
            this.f2693e = C0955u.m4858a(this.f2693e, c0955u);
        }

        public void m4357c(C0955u c0955u) {
            this.f2694f = C0955u.m4858a(this.f2694f, c0955u);
        }

        public void m4359d(C0955u c0955u) {
            this.f2697i = C0955u.m4858a(this.f2697i, c0955u);
        }

        public void m4349a(DutyStatus dutyStatus) {
            if (dutyStatus == DutyStatus.SLEEPER) {
                this.f2698j = SplitSleeperResetStatus.SLEEPER_ONLY;
            }
        }

        public void m4360e(C0902k c0902k) {
            this.f2699k = C0902k.m4574a(this.f2699k, c0902k);
        }

        public void m4361f(C0902k c0902k) {
            this.f2700l = C0902k.m4574a(this.f2700l, c0902k);
        }

        public void m4353a(List<C0882q> list) {
            this.f2702n = Collections.unmodifiableList(list);
        }

        public void m4348a(long j) {
            if (j != Long.MAX_VALUE) {
                m4352a(new Date(this.f2689a + j));
            }
        }

        public void m4352a(Date date) {
            if (this.f2701m == null || date.before(this.f2701m)) {
                this.f2701m = date;
            }
        }

        public DutyLimits m4347a() {
            return new DutyLimits();
        }
    }

    private DutyLimits(C0868a c0868a) {
        Date date;
        this.f2706d = c0868a.f2692d;
        this.f2705c = C0902k.m4574a(c0868a.f2691c, c0868a.f2692d);
        this.f2707e = this.f2705c;
        this.f2704b = c0868a.f2695g;
        this.f2708f = c0868a.f2696h;
        this.f2703a = C0902k.m4574a(c0868a.f2690b, this.f2707e);
        this.f2709g = c0868a.f2693e;
        this.f2710h = c0868a.f2694f;
        this.f2711i = c0868a.f2697i;
        this.f2712j = c0868a.f2698j;
        this.f2714l = c0868a.f2700l;
        this.f2713k = C0902k.m4574a(c0868a.f2699k, this.f2714l);
        long a = TimeWindow.m4400a(this.f2703a, this.f2705c, this.f2706d);
        if (this.f2709g.m4404d()) {
            a = Math.min(a, this.f2709g.m4402b());
        }
        if (this.f2710h.m4404d()) {
            a = Math.min(a, this.f2710h.m4402b());
        }
        if (this.f2711i != null && this.f2711i.m4404d()) {
            a = Math.min(a, this.f2711i.m4402b());
        }
        Date l = c0868a.f2701m;
        if (a != Long.MAX_VALUE) {
            Date date2 = new Date(a + c0868a.f2689a);
            if (l == null || date2.before(l)) {
                date = date2;
                this.f2715m = date;
                this.f2716n = c0868a.f2702n;
            }
        }
        date = l;
        this.f2715m = date;
        this.f2716n = c0868a.f2702n;
    }

    public static DutyLimits m4362a(Collection<C0912j> collection, C0898i c0898i) {
        return m4363a(collection, c0898i, null);
    }

    public static DutyLimits m4363a(Collection<C0912j> collection, C0898i c0898i, Event event) {
        C0868a c0868a = new C0868a(c0898i.mo698g());
        for (C0912j a : collection) {
            a.mo732a(c0898i, c0868a);
        }
        if (event != null) {
            c0868a.m4352a(new Date(event.getOccurredAt()));
        }
        return c0868a.m4347a();
    }

    public C0902k m4364a() {
        return this.f2703a;
    }

    public C0902k m4366b() {
        return this.f2704b;
    }

    public C0902k m4367c() {
        return this.f2705c;
    }

    public C0902k m4368d() {
        return this.f2706d;
    }

    public C0902k m4369e() {
        return this.f2707e;
    }

    public C0955u m4370f() {
        return this.f2708f;
    }

    public C0955u m4371g() {
        return this.f2709g;
    }

    public C0955u m4372h() {
        return this.f2710h;
    }

    public List<C0882q> m4373i() {
        return this.f2716n;
    }

    public boolean m4374j() {
        return this.f2711i != null && this.f2714l.m4402b() > 0;
    }

    public boolean m4375k() {
        if (this.f2711i == null || !m4374j()) {
            return false;
        }
        long b = this.f2711i.m4402b();
        if (m4371g().m4402b() <= b || m4372h().m4402b() <= b) {
            return false;
        }
        return true;
    }

    public SplitSleeperResetStatus m4376l() {
        return this.f2712j;
    }

    public boolean m4365a(DutyStatus dutyStatus) {
        boolean z = true;
        switch (this.f2712j) {
            case SLEEPER_ONLY:
                if (dutyStatus != DutyStatus.SLEEPER) {
                    z = false;
                }
                return z;
            case OFF_DUTY_OR_SLEEPER:
                if (dutyStatus.m4396d() || dutyStatus == DutyStatus.SLEEPER) {
                    return true;
                }
                return false;
            default:
                return false;
        }
    }

    public C0955u m4377m() {
        return this.f2711i;
    }

    public C0902k m4378n() {
        return this.f2713k;
    }

    public C0902k m4379o() {
        return this.f2714l;
    }

    public boolean m4380p() {
        return this.f2704b != null && this.f2704b.m4402b() < this.f2703a.m4402b();
    }
}
