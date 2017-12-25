package com.bigroad.ttb.android.p039h;

import com.bigroad.shared.C1144s;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.gaps.C1079b;
import com.bigroad.shared.gaps.C1079b.C1077a;
import com.bigroad.shared.gaps.C1083e;
import com.bigroad.shared.gaps.model.C1072a;
import com.bigroad.shared.gaps.model.C1087c;
import com.bigroad.shared.gaps.p026a.C1073a;
import com.bigroad.shared.gaps.p026a.C1074b;
import com.bigroad.shared.gaps.p027b.C1078a;
import com.bigroad.shared.model.C1108a;
import com.bigroad.shared.model.CanonicalOdometerUnit;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.p029c.C1736b;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.common.collect.Range;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map.Entry;

public class C2088c implements C1083e {
    private static final C1736b f7299a = OurApplication.m6296r();
    private static final C2474y f7300b = OurApplication.m6285g();
    private static final ap f7301c = OurApplication.m6269Z();
    private final int f7302d;
    private final List<C1072a> f7303e;

    private static class C2087a implements C1087c {
        private long f7293a;
        private CanonicalOdometerUnit f7294b;
        private long f7295c;
        private CanonicalOdometerUnit f7296d;
        private long f7297e;
        private String f7298f;

        public C2087a(String str, Event event, Event event2) {
            Integer num = null;
            this.f7294b = C1144s.m5761b(event);
            this.f7296d = C1144s.m5761b(event2);
            this.f7297e = event.getPersonId();
            this.f7298f = str;
            Integer valueOf = event.hasOdometer() ? Integer.valueOf(event.getOdometer()) : null;
            if (valueOf == null) {
                this.f7293a = 0;
            } else {
                this.f7293a = Math.round(this.f7294b.m5469a(valueOf.longValue()));
            }
            if (event2.hasOdometer()) {
                num = Integer.valueOf(event2.getOdometer());
            }
            if (num == null) {
                this.f7295c = 0;
            } else {
                this.f7295c = Math.round(this.f7296d.m5469a(num.longValue()));
            }
        }

        public long mo1225a() {
            return this.f7293a;
        }

        public CanonicalOdometerUnit mo1226b() {
            return this.f7294b;
        }

        public long mo1227c() {
            return this.f7295c;
        }

        public CanonicalOdometerUnit mo1228d() {
            return this.f7296d;
        }

        public long mo1229e() {
            return this.f7297e;
        }

        public String mo1230f() {
            return this.f7298f;
        }

        public String toString() {
            return "adjustment: " + Math.round(this.f7294b.m5471b(this.f7293a)) + this.f7294b.m5470a() + Math.round(this.f7296d.m5471b(this.f7295c)) + this.f7296d.m5470a();
        }
    }

    public C2088c() {
        this(-1, null);
    }

    private C2088c(int i, List<C1072a> list) {
        this.f7302d = i;
        this.f7303e = list;
    }

    public static C2088c m10470a(int i, List<C1072a> list) {
        return new C2088c(i, list);
    }

    public C1079b mo1231a(String str) {
        C1077a a = C1079b.m5368a(str);
        Truck c = OurApplication.m6294p().m6572c(str);
        if (c == null || !c.getHasAobrd()) {
            return a.m5360c();
        }
        List a2;
        long d = f7300b.m12202d();
        if (this.f7303e != null) {
            for (C1072a a3 : this.f7303e) {
                a.m5355a(a3);
            }
        }
        for (Entry entry : f7299a.m8471a(str).mo2619j()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if (intValue != this.f7302d) {
                a.m5355a(new C1073a((AutoDailyLogTruck) entry.getValue(), intValue, d));
            }
        }
        for (Entry entry2 : f7299a.m8482b(str).mo2619j()) {
            intValue = ((Integer) entry2.getKey()).intValue();
            if (intValue != this.f7302d) {
                a.m5355a(new C1074b((DailyLogTruck) entry2.getValue(), intValue, d));
            }
        }
        for (int intValue2 = ((Integer) mo1232a().m18698c()).intValue(); intValue2 <= ((Integer) mo1232a().m18700e()).intValue(); intValue2++) {
            if (intValue2 != this.f7302d) {
                DailyLog b = f7299a.m8480b(intValue2);
                if (b != null) {
                    for (C1108a c1078a : C1108a.m5497a(intValue2, b.getTimezoneId(), b.hasDriverApproval(), OurApplication.af(), f7301c.mo914b())) {
                        a.m5355a(new C1078a(c1078a, intValue2, d));
                    }
                }
            }
        }
        Integer a4 = a.m5358a();
        Integer b2 = a.m5359b();
        if (!(a4 == null || b2 == null)) {
            Date date = new Date(DailyLogUtils.m4286a(a4.intValue()));
            Date date2 = new Date(DailyLogUtils.m4303b(b2.intValue()));
            if (c != null) {
                Collection<Event> b3 = OurApplication.m6295q().m10027b(c.getTruckId());
                for (Event event : b3) {
                    if (event.getOccurredAt() >= date.getTime() && event.getOccurredAt() <= date2.getTime() && event.getEventType() == 16 && am.m4189a(event.getEventSubtype(), "ODOMETER_ADJUSTMENT_BEFORE")) {
                        Event a5 = C1144s.m5757a(event, (Collection) b3);
                        if (a5 != null) {
                            a.m5354a(DailyLogUtils.m4302b(event.getOccurredAt()), new C2087a(c.getTruckNumber(), event, a5));
                        }
                    }
                }
            }
        }
        if (this.f7302d > 0) {
            a2 = OurApplication.m6294p().m6558a(str, this.f7302d);
        } else {
            a2 = OurApplication.m6294p().m6585i(str);
        }
        a.m5357a(a2);
        return a.m5360c();
    }

    public Range<Integer> mo1232a() {
        return C2091e.m10483b();
    }
}
