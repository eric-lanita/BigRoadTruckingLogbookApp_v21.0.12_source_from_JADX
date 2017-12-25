package com.bigroad.ttb.android.util;

import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0902k;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.ttb.android.AuthMonitor;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.event.EventManager;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.protocol.TTProtocol.Person;

public class C2306y {
    private static C2474y f7954a = OurApplication.m6285g();
    private static AuthMonitor f7955b = OurApplication.m6249F();
    private static EventManager f7956c = OurApplication.m6295q();
    private static C1736b f7957d = OurApplication.m6296r();
    private static ap f7958e = OurApplication.m6269Z();

    public static Person m11273a() {
        if (f7954a.m12227q()) {
            return null;
        }
        Person l = f7954a.m12222l();
        if (l == null || C2306y.m11275b(l) || !f7955b.m6031d()) {
            return null;
        }
        return l;
    }

    public static boolean m11274a(Person person) {
        if (person == null || C2306y.m11275b(person)) {
            return false;
        }
        Person a = C2306y.m11273a();
        if (a == null || a.getPersonId() != person.getPersonId() || f7956c.m10060j().m4395c()) {
            return false;
        }
        C0956v r = f7954a.m12228r();
        DutyLimits a2 = DutyLimits.m4362a(r.m4881o(), new C0898i(f7957d.m8493g(), f7956c.m10025b(), f7958e.mo913a(), r.m4868b()));
        C0902k e = a2.m4369e();
        C0902k a3 = a2.m4364a();
        if (e.m4402b() == e.m4403c() && a3.m4402b() == a3.m4403c()) {
            return true;
        }
        return false;
    }

    public static boolean m11275b(Person person) {
        return (person == null || am.m4188a(person.getEmailAddress()) || !person.getPasswordSet()) ? false : true;
    }
}
