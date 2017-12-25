package com.bigroad.ttb.android.p029c;

import android.content.Context;
import com.bigroad.shared.am;
import com.bigroad.shared.ap;
import com.bigroad.shared.dailylog.C0866b;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.duty.C0907o;
import com.bigroad.shared.p021a.C0831a;
import com.bigroad.ttb.android.C2474y;
import com.bigroad.ttb.android.C2474y.C1182a;
import com.bigroad.ttb.android.C2474y.C1183b;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.SyncManager;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.aj;
import com.bigroad.ttb.android.aj.C1716a;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.android.p035d.C1790a;
import com.bigroad.ttb.android.p035d.p036a.C1771j;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogList;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.C3512o;
import com.google.common.collect.Range;
import com.google.protobuf.C3642c;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Set;
import java.util.TimeZone;

public class C1736b {
    private static final Comparator<DailyLog> f6001a = new C17311();
    private static C1736b f6002b;
    private final C2474y f6003c = OurApplication.m6285g();
    private final aj f6004d = OurApplication.ai();
    private final C1790a f6005e = OurApplication.m6287i();
    private final C1739d f6006f = OurApplication.m6260Q();
    private final ap f6007g = OurApplication.m6269Z();
    private final Set<C1219a> f6008h = new HashSet();
    private final C1748g f6009i;
    private C3642c f6010j;
    private List<DailyLog> f6011k = new ArrayList();
    private final C1182a f6012l = new C17322(this);
    private final C1716a f6013m = new C17333(this);

    public interface C1219a {
        void mo904a(C1736b c1736b);
    }

    static class C17311 implements Comparator<DailyLog> {
        C17311() {
        }

        public /* synthetic */ int compare(Object obj, Object obj2) {
            return m8453a((DailyLog) obj, (DailyLog) obj2);
        }

        public int m8453a(DailyLog dailyLog, DailyLog dailyLog2) {
            int logDay = dailyLog.getLogDay();
            int logDay2 = dailyLog2.getLogDay();
            if (logDay == logDay2) {
                return 0;
            }
            return logDay < logDay2 ? -1 : 1;
        }
    }

    class C17322 extends C1183b {
        final /* synthetic */ C1736b f5995a;

        C17322(C1736b c1736b) {
            this.f5995a = c1736b;
        }

        public void mo863a(C2474y c2474y) {
            this.f5995a.m8467l();
        }
    }

    class C17333 implements C1716a {
        final /* synthetic */ C1736b f5996a;

        C17333(C1736b c1736b) {
            this.f5996a = c1736b;
        }

        public void mo1055a(String str) {
            this.f5996a.m8464a(str, null);
        }

        public void mo1056b(String str) {
            this.f5996a.m8464a(null, str);
        }
    }

    public static C1736b m8459a(Context context) {
        if (f6002b == null) {
            f6002b = new C1736b();
        }
        return f6002b;
    }

    private static SyncManager m8465j() {
        return OurApplication.m6289k();
    }

    private C1736b() {
        this.f6003c.m12184a(this.f6012l);
        this.f6004d.m8385a(this.f6013m);
        m8466k();
        this.f6009i = new C1748g();
    }

    private void m8466k() {
        this.f6011k.clear();
        for (C1771j d : this.f6005e.m8807s()) {
            DailyLog d2 = d.m8606d();
            if (d2 != null) {
                this.f6011k.add(d2);
            }
        }
        Collections.sort(this.f6011k, f6001a);
    }

    private void m8467l() {
        this.f6010j = null;
        this.f6011k.clear();
        this.f6005e.m8808t();
        m8468m();
    }

    public void m8474a(C1219a c1219a) {
        this.f6008h.add(c1219a);
    }

    public void m8483b(C1219a c1219a) {
        this.f6008h.remove(c1219a);
    }

    private void m8468m() {
        for (C1219a a : (C1219a[]) this.f6008h.toArray(new C1219a[this.f6008h.size()])) {
            a.mo904a(this);
        }
    }

    public C3642c m8472a() {
        return this.f6010j;
    }

    public void m8477a(C3642c c3642c, C3642c c3642c2) {
        if (!c3642c.equals(this.f6010j)) {
            try {
                DailyLogList parseFrom = DailyLogList.parseFrom(c3642c2);
                this.f6010j = c3642c;
                this.f6011k.clear();
                this.f6011k.addAll(this.f6009i.m8547a(parseFrom.getDailyLogList()));
                Collections.sort(this.f6011k, f6001a);
                this.f6005e.m8786g(this.f6011k);
                m8468m();
            } catch (Throwable e) {
                C2134e.m10681d("TT-DailyLogManager", "Can't parse daily log list.", e);
            }
        }
    }

    public void m8478a(List<DailyLog> list) {
        this.f6011k = new ArrayList(list);
        this.f6010j = null;
        Collections.sort(this.f6011k, f6001a);
        this.f6005e.m8786g(this.f6011k);
        m8468m();
    }

    public int m8479b() {
        return m8469a(-1);
    }

    public int m8469a(int i) {
        if (i < 0) {
            i = 15;
        }
        Calendar instance = Calendar.getInstance();
        instance.add(5, 1 - i);
        return DailyLogUtils.m4284a(instance);
    }

    public int m8485c() {
        int d = m8487d();
        int a = DailyLogUtils.m4284a(this.f6003c.m12228r().m4879m());
        if (a <= d) {
            a = d;
        }
        Calendar m = this.f6003c.m12228r().m4879m();
        m.setTimeInMillis(OurApplication.m6295q().m10047e());
        d = DailyLogUtils.m4284a(m);
        if (d > a) {
            return d;
        }
        return a;
    }

    public DailyLog m8480b(int i) {
        for (DailyLog dailyLog : this.f6011k) {
            if (dailyLog.getLogDay() == i) {
                return dailyLog;
            }
        }
        return null;
    }

    public DailyLog m8486c(int i) {
        for (DailyLog dailyLog : C0831a.m4105a(this.f6011k)) {
            if (dailyLog.getLogDay() < i) {
                return dailyLog;
            }
        }
        return null;
    }

    public void m8475a(DailyLog dailyLog) {
        m8463a(dailyLog, false);
    }

    public void m8484b(DailyLog dailyLog) {
        m8463a(dailyLog, true);
    }

    private void m8463a(DailyLog dailyLog, boolean z) {
        Object obj;
        int logDay = dailyLog.getLogDay();
        ListIterator listIterator = this.f6011k.listIterator();
        while (listIterator.hasNext()) {
            if (((DailyLog) listIterator.next()).getLogDay() == logDay) {
                listIterator.set(dailyLog);
                obj = 1;
                break;
            }
        }
        obj = null;
        if (obj == null) {
            this.f6011k.add(dailyLog);
            Collections.sort(this.f6011k, f6001a);
        }
        this.f6010j = null;
        this.f6005e.m8733a(dailyLog);
        if (z) {
            C1736b.m8465j().m6466a(dailyLog);
        }
        m8468m();
    }

    public void m8476a(Event event) {
        TimeZone timeZone = TimeZone.getTimeZone(OurApplication.m6285g().m12222l().getHosHomeTimezoneId());
        C0907o a = C0907o.m4580a(timeZone, event.getOccurredAt());
        C0907o a2 = C0907o.m4580a(timeZone, event.getOccurredAt() + event.getMinDuration());
        for (int a_ = a.a_(); a_ <= a2.a_(); a_++) {
            m8460a(a_, timeZone);
        }
    }

    private void m8460a(int i, TimeZone timeZone) {
        if (m8480b(i) == null) {
            DailyLog a = C0866b.m4320a(this.f6006f, i, false, this.f6007g.mo914b());
            if (a != null) {
                m8484b(a.toBuilder().m13053a(timeZone.getID()).m13069c());
            }
        }
    }

    private void m8464a(String str, String str2) {
        if (this.f6006f.mo1058a() != null) {
            if (!am.m4188a((CharSequence) str) || !am.m4188a((CharSequence) str2)) {
                DailyLog dailyLog;
                int a = DailyLogUtils.m4285a(this.f6003c.m12228r().m4868b());
                ListIterator listIterator = this.f6011k.listIterator();
                while (listIterator.hasNext()) {
                    dailyLog = (DailyLog) listIterator.next();
                    if (dailyLog.getLogDay() == a) {
                        break;
                    }
                }
                dailyLog = null;
                if (!am.m4188a((CharSequence) str) || !am.m4188a((CharSequence) str2)) {
                    if (dailyLog == null) {
                        C2582a newBuilder = DailyLog.newBuilder(C0866b.m4320a(this.f6006f, a, false, this.f6007g.mo914b()));
                        if (!am.m4188a((CharSequence) str)) {
                            newBuilder.m13089h(str);
                        }
                        if (!am.m4188a((CharSequence) str2)) {
                            newBuilder.m13091i(str2);
                        }
                        dailyLog = newBuilder.m13069c();
                    } else {
                        dailyLog = C1738c.m8513b(C1738c.m8502a(dailyLog, str), str2);
                    }
                    listIterator.set(dailyLog);
                    this.f6005e.m8733a(dailyLog);
                    C1736b.m8465j().m6466a(dailyLog);
                    m8468m();
                }
            }
        }
    }

    public int m8487d() {
        if (this.f6011k.isEmpty()) {
            return 0;
        }
        return ((DailyLog) this.f6011k.get(this.f6011k.size() - 1)).getLogDay();
    }

    public int m8489e() {
        if (this.f6011k.isEmpty()) {
            return Integer.MAX_VALUE;
        }
        return ((DailyLog) this.f6011k.get(0)).getLogDay();
    }

    public DailyLog m8488d(int i) {
        return C0866b.m4320a(this.f6006f, i, true, this.f6007g.mo914b());
    }

    public DailyLog m8490e(int i) {
        return C0866b.m4319a(this.f6006f, i);
    }

    public DailyLog m8491f(int i) {
        DailyLog b = m8480b(i);
        return b != null ? b : m8490e(i);
    }

    public void m8473a(int i, DvirInspection dvirInspection) {
        Truck c = OurApplication.m6294p().m6572c(dvirInspection.getVehicleNumber());
        if (c == null || !c.getHasAobrd()) {
            DailyLog b = m8480b(i);
            if (b == null) {
                b = C0866b.m4320a(this.f6006f, i, false, this.f6007g.mo914b());
                if (b == null) {
                    return;
                }
            }
            b = C1730a.m8452a(b, dvirInspection);
            if (b != null) {
                m8484b(b);
            }
        }
    }

    public List<DailyLog> m8492f() {
        return Collections.unmodifiableList(this.f6011k);
    }

    public List<C0907o> m8493g() {
        return C0907o.m4581a(m8492f());
    }

    public DailyLog m8494h() {
        return m8480b(DailyLogUtils.m4284a(this.f6003c.m12228r().m4879m()));
    }

    public DailyLog m8470a(int i, Predicate<DailyLog> predicate) {
        for (DailyLog dailyLog : C0831a.m4105a(this.f6011k)) {
            if (dailyLog.getLogDay() < i && predicate.apply(dailyLog)) {
                return dailyLog;
            }
        }
        return null;
    }

    public DailyLog m8481b(int i, Predicate<DailyLog> predicate) {
        for (DailyLog dailyLog : this.f6011k) {
            if (dailyLog.getLogDay() > i && predicate.apply(dailyLog)) {
                return dailyLog;
            }
        }
        return null;
    }

    public C3512o<Integer, AutoDailyLogTruck> m8471a(final String str) {
        Predicate c17344 = new Predicate<DailyLog>(this) {
            final /* synthetic */ C1736b f5998b;

            public /* synthetic */ boolean apply(Object obj) {
                return m8457a((DailyLog) obj);
            }

            public boolean m8457a(DailyLog dailyLog) {
                if (dailyLog != null) {
                    for (AutoDailyLogTruck truckNumber : dailyLog.getAutoDailyLogTruckList()) {
                        if (am.m4189a(str, truckNumber.getTruckNumber())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        DailyLog a = m8470a(m8479b(), c17344);
        DailyLog b = m8481b(m8485c(), c17344);
        Range a2 = Range.m18692a(Integer.valueOf(a != null ? a.getLogDay() : m8479b()), Integer.valueOf(b != null ? b.getLogDay() : m8485c()));
        C3512o<Integer, AutoDailyLogTruck> q = ArrayListMultimap.m18434q();
        for (DailyLog dailyLog : this.f6011k) {
            if (dailyLog.getLogDay() >= ((Integer) a2.m18698c()).intValue()) {
                if (dailyLog.getLogDay() > ((Integer) a2.m18700e()).intValue()) {
                    break;
                }
                for (AutoDailyLogTruck autoDailyLogTruck : dailyLog.getAutoDailyLogTruckList()) {
                    if (am.m4189a(str, autoDailyLogTruck.getTruckNumber())) {
                        q.mo2614a(Integer.valueOf(dailyLog.getLogDay()), autoDailyLogTruck);
                    }
                }
            }
        }
        return q;
    }

    public C3512o<Integer, DailyLogTruck> m8482b(final String str) {
        Predicate c17355 = new Predicate<DailyLog>(this) {
            final /* synthetic */ C1736b f6000b;

            public /* synthetic */ boolean apply(Object obj) {
                return m8458a((DailyLog) obj);
            }

            public boolean m8458a(DailyLog dailyLog) {
                if (dailyLog != null && dailyLog.hasDailyLogTruckList()) {
                    for (DailyLogTruck truckNumber : dailyLog.getDailyLogTruckList().getDailyLogTruckList()) {
                        if (am.m4189a(str, truckNumber.getTruckNumber())) {
                            return true;
                        }
                    }
                }
                return false;
            }
        };
        DailyLog a = m8470a(m8479b(), c17355);
        DailyLog b = m8481b(m8485c(), c17355);
        Range a2 = Range.m18692a(Integer.valueOf(a != null ? a.getLogDay() : m8479b()), Integer.valueOf(b != null ? b.getLogDay() : m8485c()));
        C3512o<Integer, DailyLogTruck> q = ArrayListMultimap.m18434q();
        for (DailyLog dailyLog : this.f6011k) {
            if (dailyLog.getLogDay() >= ((Integer) a2.m18698c()).intValue()) {
                if (dailyLog.getLogDay() > ((Integer) a2.m18700e()).intValue()) {
                    break;
                } else if (dailyLog.hasDailyLogTruckList()) {
                    for (DailyLogTruck dailyLogTruck : dailyLog.getDailyLogTruckList().getDailyLogTruckList()) {
                        if (am.m4189a(str, dailyLogTruck.getTruckNumber())) {
                            q.mo2614a(Integer.valueOf(dailyLog.getLogDay()), dailyLogTruck);
                        }
                    }
                }
            }
        }
        return q;
    }

    public List<Truck> m8495i() {
        Truck c;
        TruckManager p = OurApplication.m6294p();
        int b = m8479b();
        int c2 = m8485c();
        Set<String> hashSet = new HashSet(16);
        for (DailyLog dailyLog : this.f6011k) {
            int logDay = dailyLog.getLogDay();
            if (logDay >= b) {
                if (logDay > c2) {
                    break;
                }
                for (DailyLogTruck truckNumber : dailyLog.getDailyLogTruckList().getDailyLogTruckList()) {
                    Truck c3 = p.m6572c(truckNumber.getTruckNumber());
                    if (c3 != null && c3.getHasAobrd()) {
                        hashSet.add(c3.getTruckNumber());
                    }
                }
                for (AutoDailyLogTruck truckNumber2 : dailyLog.getAutoDailyLogTruckList()) {
                    c = p.m6572c(truckNumber2.getTruckNumber());
                    if (c != null && c.getHasAobrd()) {
                        hashSet.add(c.getTruckNumber());
                    }
                }
            }
        }
        for (Event event : OurApplication.m6295q().m10025b()) {
            if (event.hasTruckId()) {
                c = p.m6552a(event.getTruckId());
                if (c != null) {
                    hashSet.add(c.getTruckNumber());
                }
            }
        }
        List<Truck> arrayList = new ArrayList(hashSet.size());
        for (String c4 : hashSet) {
            c = p.m6572c(c4);
            if (c != null) {
                arrayList.add(c);
            }
        }
        return arrayList;
    }
}
