package com.bigroad.shared.dailylog;

import com.bigroad.shared.aa;
import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.duty.C0889h;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C1106h;
import com.bigroad.shared.model.C1107b;
import com.bigroad.shared.model.C1116d;
import com.bigroad.shared.model.C1116d.C1115b;
import com.bigroad.shared.p021a.C0835b;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.al;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;

public abstract class DailyLogUtils {
    public static final Comparator<DailyLog> f2668a = new C08571();
    public static final Comparator<AutoDailyLogTruck> f2669b = new C08582();

    static class C08571 implements Comparator<DailyLog> {
        C08571() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4275a((DailyLog) obj, (DailyLog) obj2);
        }

        public int m4275a(DailyLog dailyLog, DailyLog dailyLog2) {
            return Integer.signum(dailyLog.getLogDay() - dailyLog2.getLogDay());
        }
    }

    static class C08582 implements Comparator<AutoDailyLogTruck> {
        C08582() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m4276a((AutoDailyLogTruck) obj, (AutoDailyLogTruck) obj2);
        }

        public int m4276a(AutoDailyLogTruck autoDailyLogTruck, AutoDailyLogTruck autoDailyLogTruck2) {
            int c = aa.m4141c(autoDailyLogTruck.getStartTime(), autoDailyLogTruck2.getStartTime());
            if (c == 0) {
                return autoDailyLogTruck.getTruckNumber().compareTo(autoDailyLogTruck2.getTruckNumber());
            }
            return c;
        }
    }

    public enum DailyLogType {
        SINGLE_TRUCK_FIELD,
        MULTI_TRUCK
    }

    public static class C0859a {
        private Integer f2662a;
        private OdometerUnit f2663b;
        private boolean f2664c;
        private boolean f2665d;

        public boolean m4277a() {
            return this.f2662a != null;
        }

        public boolean m4278b() {
            return this.f2663b != null;
        }

        public Integer m4279c() {
            return this.f2662a;
        }

        public OdometerUnit m4280d() {
            return this.f2663b;
        }

        public boolean m4281e() {
            return this.f2664c;
        }

        public boolean m4282f() {
            return this.f2665d || !m4281e();
        }

        private C0859a(Integer num, OdometerUnit odometerUnit, boolean z, boolean z2) {
            this.f2662a = num;
            this.f2663b = odometerUnit;
            this.f2664c = z;
            this.f2665d = z2;
        }
    }

    public static class C0860b {
        public Calendar f2666a;
        public Calendar f2667b;

        public C0860b(Calendar calendar, Calendar calendar2) {
            this.f2666a = calendar;
            this.f2667b = calendar2;
        }
    }

    public static DailyLogType m4289a(DailyLog dailyLog) {
        if (!dailyLog.hasDailyLogTruckList() && dailyLog.getAutoDailyLogTruckCount() == 0 && (!am.m4188a(dailyLog.getTrucksDeprecated()) || dailyLog.hasStartOdometerDeprecated() || dailyLog.hasEndOdometerDeprecated())) {
            return DailyLogType.SINGLE_TRUCK_FIELD;
        }
        return DailyLogType.MULTI_TRUCK;
    }

    public static DailyLogType m4288a(C1116d c1116d) {
        if (c1116d != null && c1116d.m5666r().isEmpty() && c1116d.m5663o().isEmpty() && c1116d.m5662n()) {
            C1115b m = c1116d.m5661m();
            if (!am.m4188a(m.m5646a()) || m.m5648c() || m.m5650e()) {
                return DailyLogType.SINGLE_TRUCK_FIELD;
            }
        }
        return DailyLogType.MULTI_TRUCK;
    }

    public static int m4283a(long j) {
        return aq.m4230c(j);
    }

    public static int m4284a(Calendar calendar) {
        return aq.m4230c(aq.m4231c(calendar).getTimeInMillis());
    }

    public static int m4285a(TimeZone timeZone) {
        return m4284a(Calendar.getInstance(timeZone));
    }

    public static TimeZone m4305b(DailyLog dailyLog) {
        return TimeZone.getTimeZone(dailyLog.getTimezoneId());
    }

    public static Calendar m4306c(DailyLog dailyLog) {
        return m4298a(dailyLog.getLogDay(), m4305b(dailyLog));
    }

    public static Calendar m4298a(int i, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.setTimeInMillis(aq.m4213a(i));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.clear();
        instance2.set(instance.get(1), instance.get(2), instance.get(5));
        return instance2;
    }

    public static Calendar m4304b(int i, TimeZone timeZone) {
        Calendar instance = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        instance.setTimeInMillis(aq.m4213a(i));
        Calendar instance2 = Calendar.getInstance(timeZone);
        instance2.clear();
        instance2.set(instance.get(1), instance.get(2), instance.get(5) + 1);
        return instance2;
    }

    public static List<C0890f> m4299a(List<C0890f> list) {
        if (list == null || list.isEmpty() || !((C0890f) list.get(0)).mo720v()) {
            return list;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 1; i < list.size(); i++) {
            arrayList.add(list.get(i));
        }
        return arrayList;
    }

    public static C0890f m4293a(List<C0890f> list, byte[] bArr) {
        for (C0890f c0890f : list) {
            if (Arrays.equals(c0890f.m4521p(), bArr)) {
                return c0890f;
            }
        }
        return null;
    }

    public static int m4302b(long j) {
        return m4283a(j - 50400000);
    }

    public static long m4286a(int i) {
        return aq.m4213a(i) - 43200000;
    }

    public static long m4303b(int i) {
        return aq.m4213a(i + 1) + 50400000;
    }

    public static C0907o m4294a(List<C0907o> list, long j, TimeZone timeZone) {
        for (C0907o c0907o : list) {
            long f = c0907o.mo697f();
            if (j < f || j >= c0907o.mo698g()) {
                if (f > j) {
                    break;
                }
            }
            return c0907o;
        }
        return new C0907o(timeZone, m4284a(aq.m4224a(timeZone, j)));
    }

    public static C0860b m4291a(int i, C0956v c0956v, List<? extends C0889h> list) {
        TimeZone b = c0956v.m4868b();
        Calendar a = m4298a(i, b);
        if (!c0956v.m4867a(a)) {
            return null;
        }
        Calendar b2 = m4304b(i, b);
        for (C0889h c0889h : list) {
            Long l = c0889h.mo723l();
            if (l != null) {
                TimeZone timeZone = a.getTimeZone();
                Calendar a2 = aq.m4224a(timeZone, l.longValue());
                if (!a2.after(b2)) {
                    Calendar a3;
                    Long k = c0889h.mo722k();
                    if (k != null) {
                        a3 = aq.m4224a(timeZone, k.longValue());
                    } else {
                        a3 = null;
                    }
                    return new C0860b(a3, a2);
                }
            }
        }
        return null;
    }

    public static C0860b m4292a(DailyLog dailyLog, List<C0890f> list) {
        return m4291a(dailyLog.getLogDay(), new C0956v((al) dailyLog), (List) list);
    }

    public static long m4287a(C0907o c0907o, C0889h c0889h) {
        long f = c0907o.mo697f();
        long a = c0889h != null ? c0889h.mo721a() : 0;
        if (c0889h == null || a < f) {
            return f;
        }
        f = ((a + 900000) / 900000) * 900000;
        if (f >= c0907o.mo698g()) {
            return c0889h.mo721a();
        }
        return f;
    }

    public static boolean m4301a(AutoDailyLogTruck autoDailyLogTruck, AutoDailyLogTruck autoDailyLogTruck2) {
        if (autoDailyLogTruck.getStartTime() != autoDailyLogTruck2.getStartTime()) {
            return false;
        }
        if (autoDailyLogTruck.hasTruckDashLink() && autoDailyLogTruck2.hasTruckDashLink() && autoDailyLogTruck.getTruckDashLink().equals(autoDailyLogTruck2.getTruckDashLink())) {
            return true;
        }
        if (am.m4188a(autoDailyLogTruck.getTruckVin()) || am.m4188a(autoDailyLogTruck2.getTruckVin()) || !autoDailyLogTruck.getTruckVin().equalsIgnoreCase(autoDailyLogTruck2.getTruckVin())) {
            return false;
        }
        return true;
    }

    public static C0859a m4290a(OdometerUnit odometerUnit, List<? extends C1106h> list, List<? extends C1106h> list2, List<? extends C1106h> list3) {
        OdometerUnit t;
        boolean z = false;
        if (!list2.isEmpty()) {
            t = ((C1106h) list2.get(0)).mo782t();
        } else if (!list3.isEmpty()) {
            t = ((C1106h) list3.get(0)).mo782t();
        } else if (list.size() == 1) {
            t = ((C1106h) list.get(0)).mo782t();
        } else {
            if (odometerUnit == null) {
                for (C1106h c1106h : list) {
                    C1106h c1106h2;
                    if (c1106h2.mo782t() != null) {
                        t = c1106h2.mo782t();
                        break;
                    }
                }
            }
            t = odometerUnit;
        }
        if (t == null) {
            t = OdometerUnit.MILES;
        }
        Iterator a = C0835b.m4111a(list2.iterator(), list.iterator(), list3.iterator());
        boolean z2 = false;
        double d = 0.0d;
        while (a.hasNext()) {
            double d2;
            c1106h2 = (C1106h) a.next();
            if (c1106h2.mo781i() == null) {
                z2 = true;
                d2 = d;
            } else {
                OdometerUnit t2;
                double intValue = (double) c1106h2.mo781i().intValue();
                if (c1106h2.mo782t() != null) {
                    t2 = c1106h2.mo782t();
                } else {
                    t2 = null;
                }
                d2 = af.m4150a(intValue, t2, t) + d;
            }
            d = d2;
        }
        int floor = (int) Math.floor(d);
        Integer valueOf = floor >= 0 ? Integer.valueOf(floor) : null;
        if (!(list2.isEmpty() && list3.isEmpty())) {
            z = true;
        }
        return new C0859a(valueOf, t, z2, z);
    }

    public static void m4300a(C0859a c0859a, C2582a c2582a) {
        if (c0859a.m4282f()) {
            c2582a.m13102s();
            c2582a.m13028F();
            if (c0859a.m4278b()) {
                c2582a.m13080f(c0859a.m4280d().m14669a());
            }
            if (c0859a.m4277a()) {
                c2582a.m13071d(c0859a.m4279c().intValue());
            }
        }
    }

    public static Integer m4295a(DailyLogOdometerSearchType dailyLogOdometerSearchType, C1116d c1116d, String str) {
        if (c1116d == null) {
            return null;
        }
        if (m4288a(c1116d) == DailyLogType.SINGLE_TRUCK_FIELD) {
            if ((dailyLogOdometerSearchType == DailyLogOdometerSearchType.END_ODOMETER_ONLY || dailyLogOdometerSearchType == DailyLogOdometerSearchType.START_OR_END_ODOMETER) && c1116d.m5662n() && c1116d.m5661m().m5650e()) {
                return c1116d.m5661m().m5649d();
            }
            if ((dailyLogOdometerSearchType == DailyLogOdometerSearchType.START_ODOMETER_ONLY || dailyLogOdometerSearchType == DailyLogOdometerSearchType.START_OR_END_ODOMETER) && c1116d.m5662n() && c1116d.m5661m().m5648c()) {
                return c1116d.m5661m().m5647b();
            }
        } else if (am.m4188a((CharSequence) str)) {
            return null;
        } else {
            Iterator a = c1116d.m5669u().mo2691f().mo2684a();
            while (a.hasNext()) {
                C1107b c1107b = (C1107b) a.next();
                if (am.m4189a(str, c1107b.m5490q())) {
                    if ((dailyLogOdometerSearchType == DailyLogOdometerSearchType.END_ODOMETER_ONLY || dailyLogOdometerSearchType == DailyLogOdometerSearchType.START_OR_END_ODOMETER) && c1107b.m5488o()) {
                        return c1107b.mo780g();
                    }
                    if ((dailyLogOdometerSearchType == DailyLogOdometerSearchType.START_ODOMETER_ONLY || dailyLogOdometerSearchType == DailyLogOdometerSearchType.START_OR_END_ODOMETER) && c1107b.m5487n()) {
                        return c1107b.mo779f();
                    }
                }
            }
        }
        return null;
    }

    public static String m4296a(Long l) {
        return m4297a(null, l);
    }

    public static String m4297a(Locale locale, Long l) {
        if (l == null) {
            return "";
        }
        return String.format(locale, "%.1f", new Object[]{Double.valueOf(((double) l.longValue()) / 3600000.0d)});
    }
}
