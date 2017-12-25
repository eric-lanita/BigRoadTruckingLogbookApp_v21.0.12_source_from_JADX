package com.bigroad.shared.duty;

import com.bigroad.shared.ah;
import com.bigroad.shared.am;
import com.bigroad.shared.duty.rule.BigDayCycleAndShiftRule;
import com.bigroad.shared.duty.rule.BigDayCycleAndShiftRule.CycleLength;
import com.bigroad.shared.duty.rule.C0912j;
import com.bigroad.shared.duty.rule.C0917w.C0913a;
import com.bigroad.shared.duty.rule.C0918a;
import com.bigroad.shared.duty.rule.C0921b;
import com.bigroad.shared.duty.rule.C0922c;
import com.bigroad.shared.duty.rule.C0923d;
import com.bigroad.shared.duty.rule.C0925e;
import com.bigroad.shared.duty.rule.C0926f;
import com.bigroad.shared.duty.rule.C0931g;
import com.bigroad.shared.duty.rule.C0934l;
import com.bigroad.shared.duty.rule.C0935m;
import com.bigroad.shared.duty.rule.C0936r;
import com.bigroad.shared.duty.rule.C0937n;
import com.bigroad.shared.duty.rule.C0938o;
import com.bigroad.shared.duty.rule.C0942p;
import com.bigroad.shared.duty.rule.C0943q;
import com.bigroad.shared.duty.rule.C0945s;
import com.bigroad.shared.duty.rule.C0950u;
import com.bigroad.shared.duty.rule.UsPropertyShiftRule;
import com.bigroad.shared.duty.rule.UsPropertyShiftRule.CaliforniaExceptions;
import com.bigroad.ttb.protocol.TTProtocol.al;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.TimeZone;

public class C0956v implements C0874m {
    private final TimeZone f2932a;
    private final boolean f2933b;
    private final boolean f2934c;
    private final boolean f2935d;
    private final boolean f2936e;
    private final C0960w f2937f;
    private final C0962x f2938g;
    private final C0879c f2939h;
    private final C0881d f2940i;

    public C0956v(ct ctVar) {
        this(ah.m4163c(ctVar), ah.m4164d(ctVar), ah.m4165e(ctVar), ah.m4166f(ctVar), ah.m4167g(ctVar), ah.m4168h(ctVar), ah.m4169i(ctVar), ah.m4170j(ctVar), ah.m4171k(ctVar));
    }

    public C0956v(al alVar) {
        this(alVar.getTimezoneId(), alVar.getHosUs7DayCycleEnabled(), alVar.getHosUs8DayCycleEnabled(), alVar.getHosCanadianCycle1Enabled(), alVar.getHosCanadianCycle2Enabled(), alVar.getHosUs7DayCycleFlags(), alVar.getHosUs8DayCycleFlags(), alVar.getHosCanadianCycle1Flags(), alVar.getHosCanadianCycle2Flags());
    }

    public C0956v(C0874m c0874m) {
        this(c0874m.mo703a(), c0874m.mo704c(), c0874m.mo705d(), c0874m.mo707f(), c0874m.mo708g(), c0874m.mo709h(), c0874m.mo710i(), c0874m.mo711j(), c0874m.mo712k());
    }

    public C0956v(String str, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, long j3, long j4) {
        this(am.m4188a((CharSequence) str) ? null : TimeZone.getTimeZone(str), z, z2, z3, z4, j, j2, j3, j4);
    }

    public C0956v(TimeZone timeZone, boolean z, boolean z2, boolean z3, boolean z4, long j, long j2, long j3, long j4) {
        this(timeZone, z, z2, z3, z4, new C0960w(j), new C0962x(j2), new C0879c(j3), new C0881d(j4));
    }

    public C0956v(String str, boolean z, boolean z2, boolean z3, boolean z4, C0960w c0960w, C0962x c0962x, C0879c c0879c, C0881d c0881d) {
        this(am.m4188a((CharSequence) str) ? null : TimeZone.getTimeZone(str), z, z2, z3, z4, c0960w, c0962x, c0879c, c0881d);
    }

    public C0956v(TimeZone timeZone, boolean z, boolean z2, boolean z3, boolean z4, C0960w c0960w, C0962x c0962x, C0879c c0879c, C0881d c0881d) {
        this.f2932a = timeZone;
        this.f2933b = z;
        this.f2934c = z2;
        this.f2935d = z3;
        this.f2936e = z4;
        this.f2937f = c0960w;
        this.f2938g = c0962x;
        this.f2939h = c0879c;
        this.f2940i = c0881d;
    }

    public String mo703a() {
        return this.f2932a == null ? null : this.f2932a.getID();
    }

    public TimeZone m4868b() {
        return this.f2932a;
    }

    public boolean mo704c() {
        return this.f2933b;
    }

    public boolean mo705d() {
        return this.f2934c;
    }

    public boolean m4878l() {
        return mo704c() || mo705d();
    }

    public boolean mo707f() {
        return this.f2935d;
    }

    public boolean mo708g() {
        return this.f2936e;
    }

    public boolean mo706e() {
        return mo707f() || mo708g();
    }

    public Calendar m4879m() {
        return Calendar.getInstance(this.f2932a);
    }

    public boolean m4880n() {
        return (mo704c() && mo709h().m4903e()) || (mo705d() && mo710i().m4903e());
    }

    private void m4860a(C0960w c0960w, List<C0912j> list) {
        boolean b = c0960w.m4899b();
        boolean d = c0960w.m4902d();
        boolean f = c0960w.m4904f();
        if (b) {
            if (f) {
                list.add(C0934l.m4716a());
            } else {
                list.add(C0936r.m4737f());
            }
            list.add(C0943q.m4791c());
            return;
        }
        if (f) {
            list.add(C0934l.m4718b());
        } else {
            list.add(new C0921b());
        }
        list.add(C0918a.m4641a(d));
    }

    private void m4861a(C0962x c0962x, List<C0912j> list) {
        boolean b = c0962x.m4899b();
        boolean d = c0962x.m4902d();
        boolean f = c0962x.m4904f();
        if (b) {
            if (f) {
                list.add(C0934l.m4716a());
            } else {
                list.add(C0936r.m4737f());
            }
            list.add(C0943q.m4792d());
            return;
        }
        if (f) {
            list.add(C0934l.m4718b());
        } else {
            list.add(new C0921b());
        }
        list.add(C0918a.m4642b(d));
    }

    private void m4863b(C0960w c0960w, List<C0912j> list) {
        boolean b = c0960w.m4899b();
        boolean e = c0960w.m4903e();
        boolean d = c0960w.m4902d();
        boolean h = c0960w.m4906h();
        if (!b && e) {
            list.add(C0937n.m4743b());
        } else if (h) {
            list.add(C0934l.m4721e());
        } else {
            list.add(C0937n.m4742a());
        }
        if (b) {
            list.add(C0935m.m4724a(false));
        } else {
            list.add(C0935m.m4724a(d));
        }
    }

    private void m4864b(C0962x c0962x, List<C0912j> list) {
        boolean b = c0962x.m4899b();
        boolean d = c0962x.m4902d();
        boolean e = c0962x.m4903e();
        boolean f = c0962x.m4904f();
        boolean n = c0962x.m4912n();
        boolean j = c0962x.m4908j();
        boolean k = c0962x.m4909k();
        EnumSet noneOf = EnumSet.noneOf(CaliforniaExceptions.class);
        if (j) {
            noneOf.add(CaliforniaExceptions._500_GALLON);
        }
        if (k) {
            noneOf.add(CaliforniaExceptions.FARM_PRODUCTS);
        }
        if (n && !b) {
            noneOf.add(CaliforniaExceptions.MOTION_PICTURE);
        }
        if (b) {
            if (f) {
                list.add(C0934l.m4716a());
            } else {
                list.add(C0936r.m4736e());
            }
            list.add(C0943q.m4793e());
            return;
        }
        if (e) {
            if (j) {
                list.add(C0942p.m4776b());
            } else {
                list.add(C0942p.m4764a());
            }
        } else if (k) {
            list.add(UsPropertyShiftRule.m4625a(noneOf));
        } else if (!f) {
            list.add(UsPropertyShiftRule.m4625a(noneOf));
        } else if (j) {
            list.add(C0934l.m4720d());
        } else {
            list.add(C0934l.m4719c());
        }
        if (k) {
            list.add(C0922c.m4654b(d));
        } else {
            list.add(C0922c.m4653a(d));
        }
    }

    private void m4862a(List<C0912j> list) {
        boolean b;
        boolean l;
        boolean d;
        boolean e;
        boolean m;
        boolean n;
        boolean f;
        if (mo704c()) {
            C0960w h = mo709h();
            if (h.m4901c()) {
                m4860a(h, (List) list);
            } else if (h.m4905g()) {
                m4863b(h, (List) list);
            } else {
                b = h.m4899b();
                l = h.m4910l();
                d = h.m4902d();
                e = h.m4903e();
                m = h.m4911m();
                n = h.m4912n();
                f = h.m4904f();
                if (b) {
                    if (f) {
                        list.add(C0934l.m4716a());
                    } else {
                        list.add(C0936r.m4736e());
                    }
                    list.add(C0943q.m4789a());
                } else {
                    C0913a a;
                    C0912j a2;
                    if (e) {
                        a = C0942p.m4765a(l);
                    } else if (f) {
                        list.add(C0934l.m4718b());
                        a = null;
                    } else if (n) {
                        list.add(new C0938o());
                        a = null;
                    } else {
                        a = UsPropertyShiftRule.m4626a(l);
                    }
                    if (d) {
                        a2 = C0945s.m4801a();
                    } else {
                        a2 = C0950u.m4821a();
                    }
                    if (!m || a == null) {
                        list.add(a2);
                        if (a != null) {
                            list.add(a.mo733a());
                        }
                    } else {
                        list.add(new BigDayCycleAndShiftRule(CycleLength._7_DAY, a2, a));
                    }
                }
            }
        }
        if (mo705d()) {
            C0962x i = mo710i();
            if (i.m4901c()) {
                m4861a(i, (List) list);
            } else if (i.m4907i() || i.m4909k()) {
                m4864b(i, (List) list);
            } else {
                b = i.m4899b();
                l = i.m4910l();
                d = i.m4902d();
                e = i.m4903e();
                m = i.m4911m();
                n = i.m4912n();
                f = i.m4904f();
                if (b) {
                    if (f) {
                        list.add(C0934l.m4716a());
                    } else {
                        list.add(C0936r.m4736e());
                    }
                    list.add(C0943q.m4790b());
                    return;
                }
                C0913a a3;
                C0912j b2;
                if (e) {
                    a3 = C0942p.m4765a(l);
                } else if (f) {
                    list.add(C0934l.m4718b());
                    a3 = null;
                } else if (n) {
                    list.add(new C0938o());
                    a3 = null;
                } else {
                    a3 = UsPropertyShiftRule.m4626a(l);
                }
                if (d) {
                    b2 = C0945s.m4802b();
                } else {
                    b2 = C0950u.m4824b();
                }
                if (!m || a3 == null) {
                    list.add(b2);
                    if (a3 != null) {
                        list.add(a3.mo733a());
                        return;
                    }
                    return;
                }
                list.add(new BigDayCycleAndShiftRule(CycleLength._8_DAY, b2, a3));
            }
        }
    }

    private void m4865b(List<C0912j> list) {
        boolean b;
        if (mo707f()) {
            b = mo711j().m4437b();
            list.add(new C0931g(b));
            list.add(new C0925e(b));
            list.add(new C0923d());
        } else if (mo708g()) {
            b = mo712k().m4437b();
            list.add(new C0931g(b));
            list.add(new C0926f(b));
            list.add(new C0923d());
        }
    }

    public Collection<C0912j> m4881o() {
        List arrayList = new ArrayList();
        m4862a(arrayList);
        m4865b(arrayList);
        return arrayList;
    }

    public C0960w mo709h() {
        return this.f2937f;
    }

    public long m4882p() {
        return this.f2937f.m4898a();
    }

    public C0962x mo710i() {
        return this.f2938g;
    }

    public long m4883q() {
        return this.f2938g.m4898a();
    }

    public C0879c mo711j() {
        return this.f2939h;
    }

    public long m4884r() {
        return this.f2939h.m4435a();
    }

    public C0881d mo712k() {
        return this.f2940i;
    }

    public long m4885s() {
        return this.f2940i.m4435a();
    }

    public boolean m4867a(Calendar calendar) {
        if (mo704c()) {
            C0960w h = mo709h();
            if (h.m4899b() || h.m4902d()) {
                return false;
            }
        }
        if (mo705d()) {
            C0962x i = mo710i();
            if (i.m4899b() || i.m4902d()) {
                return false;
            }
        }
        if (calendar.before(C0950u.m4822a(calendar.getTimeZone()))) {
            return false;
        }
        return true;
    }
}
