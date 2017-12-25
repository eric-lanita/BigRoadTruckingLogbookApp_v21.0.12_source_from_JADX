package com.bigroad.shared.dailylog;

import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils.DailyLogType;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.model.C0864i;
import com.bigroad.shared.model.C1116d.C1114a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruck.C2602a;
import com.bigroad.ttb.protocol.TTProtocol.DailyLogTruckList;
import com.bigroad.ttb.protocol.TTProtocol.Event;
import com.bigroad.ttb.protocol.TTProtocol.Fleet;
import com.bigroad.ttb.protocol.TTProtocol.Person;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.ct;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

public class C0866b {

    public interface C0863a {
        DailyLog mo1057a(int i);

        Person mo1058a();

        Truck mo1059a(String str);

        Fleet mo1060b();

        Truck mo1061c();
    }

    private static class C0865b implements C0864i {
        private C0865b() {
        }

        public List<Event> mo699a() {
            return Collections.emptyList();
        }

        public Map<Long, Truck> mo700b() {
            return Collections.emptyMap();
        }
    }

    private static String m4323a(DailyLog dailyLog, Person person) {
        if (dailyLog != null && dailyLog.hasDriverName()) {
            return dailyLog.getDriverName();
        }
        if (person == null) {
            return null;
        }
        return am.m4187a(" ", person.getFirstName(), person.getLastName());
    }

    public static Truck m4321a(C0863a c0863a, DailyLog dailyLog, boolean z) {
        Truck c;
        if (z) {
            c = c0863a.mo1061c();
            if (c == null || c.getHasAobrd()) {
                return null;
            }
            return c;
        } else if (dailyLog == null) {
            return null;
        } else {
            if (DailyLogUtils.m4289a(dailyLog) == DailyLogType.SINGLE_TRUCK_FIELD) {
                String trucksDeprecated = dailyLog.getTrucksDeprecated();
                if (!am.m4188a((CharSequence) trucksDeprecated)) {
                    c = c0863a.mo1059a(trucksDeprecated);
                }
                c = null;
            } else if (!dailyLog.hasDailyLogTruckList()) {
                return null;
            } else {
                List dailyLogTruckList = dailyLog.getDailyLogTruckList().getDailyLogTruckList();
                if (!dailyLogTruckList.isEmpty()) {
                    c = c0863a.mo1059a(((DailyLogTruck) dailyLogTruckList.get(dailyLogTruckList.size() - 1)).getTruckNumber());
                }
                c = null;
            }
            if (c == null || !c.getHasAobrd()) {
                return c;
            }
            return null;
        }
    }

    private static String m4322a(DailyLog dailyLog) {
        if (!dailyLog.hasTrailersDeprecated() || dailyLog.getTrailersDeprecated().length() > 10) {
            return null;
        }
        return dailyLog.getTrailersDeprecated();
    }

    private static String m4324b(DailyLog dailyLog) {
        if (dailyLog == null) {
            return null;
        }
        if (dailyLog.getTrailersList().isEmpty()) {
            return C0866b.m4322a(dailyLog);
        }
        return dailyLog.getTrailers(0);
    }

    private static Long m4325c(DailyLog dailyLog) {
        if (dailyLog == null || !dailyLog.hasCodriverId()) {
            return null;
        }
        return Long.valueOf(dailyLog.getCodriverId());
    }

    private static String m4326d(DailyLog dailyLog) {
        if (dailyLog == null || !dailyLog.hasHomeTerminalAddress()) {
            return null;
        }
        return dailyLog.getHomeTerminalAddress();
    }

    private static String m4327e(DailyLog dailyLog) {
        if (!dailyLog.hasShipmentsDeprecated() || dailyLog.getShipmentsDeprecated().length() > 40) {
            return null;
        }
        return dailyLog.getShipmentsDeprecated();
    }

    private static String m4328f(DailyLog dailyLog) {
        if (dailyLog == null) {
            return null;
        }
        if (dailyLog.getShipmentsList().isEmpty()) {
            return C0866b.m4327e(dailyLog);
        }
        return dailyLog.getShipments(0);
    }

    private static int m4329g(DailyLog dailyLog) {
        if (dailyLog == null || !dailyLog.hasRecapType()) {
            return 2;
        }
        return dailyLog.getRecapType();
    }

    private static String m4330h(DailyLog dailyLog) {
        if (dailyLog == null || !dailyLog.hasRemarks()) {
            return null;
        }
        return dailyLog.getRemarks();
    }

    public static DailyLog m4320a(C0863a c0863a, int i, boolean z, long j) {
        int i2 = 1;
        Person a = c0863a.mo1058a();
        if (a == null) {
            return null;
        }
        C0956v c0956v = new C0956v((ct) a);
        TimeZone b = c0956v.m4868b();
        C2582a e = DailyLog.newBuilder().m13044a(a.getPersonId()).m13042a(i).m13053a(b.getID()).m13054a(c0956v.mo705d()).m13062b(c0956v.mo704c()).m13068c(c0956v.mo707f()).m13074d(c0956v.mo708g()).m13057b(c0956v.m4883q()).m13065c(c0956v.m4882p()).m13072d(c0956v.m4884r()).m13077e(c0956v.m4885s());
        DailyLog a2 = c0863a.mo1057a(i);
        boolean z2 = j >= DailyLogUtils.m4298a(i, b).getTimeInMillis() && j < DailyLogUtils.m4304b(i, b).getTimeInMillis();
        String a3 = C0866b.m4323a(a2, a);
        if (a3 != null) {
            e.m13061b(a3);
        }
        if (c0956v.m4878l()) {
            i2 = 2;
        }
        if (z) {
            Truck a4 = C0866b.m4321a(c0863a, a2, z2);
            if (a4 != null) {
                int odometerUnit;
                C2602a a5 = DailyLogTruck.newBuilder().m13319a(a4.getTruckNumber());
                if (a4.hasTruckLicense()) {
                    a5.m13322b(a4.getTruckLicense());
                }
                if (a4.hasOdometerUnit()) {
                    odometerUnit = a4.getOdometerUnit();
                } else {
                    odometerUnit = i2;
                }
                a5.m13327d(odometerUnit);
                if (a2 != null) {
                    Integer a6 = DailyLogUtils.m4295a(DailyLogOdometerSearchType.END_ODOMETER_ONLY, C1114a.m5598a(a2, new C0865b(), j).m5635a(), a4.getTruckNumber());
                    if (a6 != null) {
                        a5.m13316a(a6.intValue());
                    }
                }
                e.m13048a(DailyLogTruckList.newBuilder().m13346a(a5).m13353c());
                i2 = odometerUnit;
            }
        }
        e.m13080f(i2);
        String b2 = C0866b.m4324b(a2);
        if (b2 != null) {
            e.m13089h(b2);
        }
        e.m13099p();
        Long c = C0866b.m4325c(a2);
        if (c != null) {
            e.m13088h(c.longValue());
        }
        C0861a a7 = C0861a.m4307a(a2, c0863a.mo1060b());
        if (a7.m4308a() != null) {
            e.m13073d(a7.m4308a());
        }
        if (a7.m4309b() != null) {
            e.m13078e(a7.m4309b());
        }
        b2 = C0866b.m4326d(a2);
        if (b2 != null) {
            e.m13086g(b2);
        }
        b2 = C0866b.m4328f(a2);
        if (!(b2 == null || am.m4189a(b2, "N/A"))) {
            e.m13091i(b2);
        }
        b2 = C0866b.m4330h(a2);
        if (b2 != null) {
            e.m13082f(b2);
        }
        e.m13076e(C0866b.m4329g(a2));
        return e.m13069c();
    }

    public static DailyLog m4319a(C0863a c0863a, int i) {
        ct a = c0863a.mo1058a();
        if (a == null) {
            return null;
        }
        C0956v c0956v = new C0956v(a);
        return DailyLog.newBuilder().m13044a(a.getPersonId()).m13042a(i).m13053a(c0956v.m4868b().getID()).m13054a(c0956v.mo705d()).m13062b(c0956v.mo704c()).m13068c(c0956v.mo707f()).m13074d(c0956v.mo708g()).m13057b(c0956v.m4883q()).m13065c(c0956v.m4882p()).m13072d(c0956v.m4884r()).m13077e(c0956v.m4885s()).m13069c();
    }
}
