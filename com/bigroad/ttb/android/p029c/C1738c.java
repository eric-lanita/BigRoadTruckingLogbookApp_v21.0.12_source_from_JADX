package com.bigroad.ttb.android.p029c;

import android.content.Context;
import android.content.res.Resources;
import android.text.format.DateFormat;
import com.bigroad.shared.am;
import com.bigroad.shared.aq;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.dailylog.DailyLogUtils.C0860b;
import com.bigroad.shared.duty.C0874m;
import com.bigroad.shared.duty.C0882q;
import com.bigroad.shared.duty.C0890f;
import com.bigroad.shared.duty.C0898i;
import com.bigroad.shared.duty.C0956v;
import com.bigroad.shared.duty.C0959y;
import com.bigroad.shared.duty.DutyLimits;
import com.bigroad.ttb.android.OurApplication;
import com.bigroad.ttb.android.R;
import com.bigroad.ttb.android.TruckManager;
import com.bigroad.ttb.android.logging.C2134e;
import com.bigroad.ttb.protocol.TTProtocol.AutoDailyLogTruck;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog;
import com.bigroad.ttb.protocol.TTProtocol.DailyLog.C2582a;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import com.bigroad.ttb.protocol.TTProtocol.al;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.List;
import java.util.TimeZone;

public class C1738c extends DailyLogUtils {

    public static class C1737a {
        private final long f6014a;
        private final long f6015b;
        private final long f6016c;
        private final long f6017d;

        public C1737a(long j, long j2, long j3, long j4) {
            this.f6014a = j;
            this.f6015b = j2;
            this.f6016c = j3;
            this.f6017d = j4;
        }

        public long m8496a() {
            return this.f6014a;
        }

        public long m8497b() {
            return this.f6015b;
        }

        public long m8498c() {
            return this.f6016c;
        }

        public long m8499d() {
            return this.f6017d;
        }
    }

    public static TimeZone m8515d(DailyLog dailyLog) {
        if (dailyLog == null) {
            return OurApplication.m6285g().m12228r().m4868b();
        }
        return DailyLogUtils.m4305b(dailyLog);
    }

    public static Calendar m8509a(int i, DailyLog dailyLog) {
        return DailyLogUtils.m4298a(i, C1738c.m8515d(dailyLog));
    }

    public static int m8516e(DailyLog dailyLog) {
        return DailyLogUtils.m4285a(C1738c.m8515d(dailyLog));
    }

    public static String m8506a(C0956v c0956v, C0860b c0860b, Context context) {
        long timeInMillis;
        long b = DutyLimits.m4362a(c0956v.m4881o(), new C0898i(OurApplication.m6296r().m8493g(), OurApplication.m6295q().m10025b(), c0860b.f2666a.getTimeInMillis() + 1, c0956v.m4868b())).m4372h().m4402b();
        if (b == 0) {
            timeInMillis = c0860b.f2667b.getTimeInMillis() - c0860b.f2666a.getTimeInMillis();
        } else {
            timeInMillis = b;
        }
        return C1738c.m8508a(c0860b.f2666a.getTimeZone(), c0860b.f2666a.getTimeInMillis(), timeInMillis + c0860b.f2666a.getTimeInMillis(), context);
    }

    public static String m8508a(TimeZone timeZone, long j, long j2, Context context) {
        Resources resources = context.getResources();
        new SimpleDateFormat("h:mma").setTimeZone(timeZone);
        new SimpleDateFormat("MMM d").setTimeZone(timeZone);
        return resources.getString(R.string.hosSummary_cycleResetNotificationTime, new Object[]{r2.format(Long.valueOf(j)), r1.format(Long.valueOf(j)).toLowerCase(), r2.format(Long.valueOf(j2)), r1.format(Long.valueOf(j2)).toLowerCase()});
    }

    public static CharSequence m8503a(int i, String str) {
        return DateFormat.format(str, DailyLogUtils.m4298a(i, TimeZone.getTimeZone("UTC")));
    }

    public static CharSequence m8514c(int i) {
        return C1738c.m8503a(i, "E MMM d");
    }

    public static DailyLog m8501a(DailyLog dailyLog, AutoDailyLogTruck autoDailyLogTruck) {
        Object obj = null;
        if (!am.m4188a(autoDailyLogTruck.getTruckVin()) || autoDailyLogTruck.hasTruckDashLink()) {
            C2582a newBuilder = DailyLog.newBuilder(dailyLog);
            AutoDailyLogTruck autoDailyLogTruck2 = null;
            int i = 0;
            while (i < newBuilder.m13034L()) {
                AutoDailyLogTruck g = newBuilder.m13084g(i);
                if (DailyLogUtils.m4301a(g, autoDailyLogTruck)) {
                    obj = 1;
                    newBuilder.m13043a(i, autoDailyLogTruck);
                    break;
                }
                i++;
                autoDailyLogTruck2 = g;
            }
            if (obj == null) {
                if (autoDailyLogTruck2 == null || autoDailyLogTruck.getStartTime() > autoDailyLogTruck2.getStartTime()) {
                    newBuilder.m13045a(autoDailyLogTruck);
                } else {
                    Iterable arrayList = new ArrayList(newBuilder.m13033K());
                    arrayList.add(autoDailyLogTruck);
                    Collections.sort(arrayList, b);
                    newBuilder.m13035M();
                    newBuilder.mo1377a(arrayList);
                }
            }
            return newBuilder.m13069c();
        }
        C2134e.m10682e("TT-DailyLogUtils", "Attempt to merge an AutoDailyLogTruck record with no VIN or Device ID.");
        return dailyLog;
    }

    public static DailyLog m8502a(DailyLog dailyLog, String str) {
        if (am.m4188a((CharSequence) str)) {
            C2134e.m10680d("TT-DailyLogUtils", "Attempt to merge an empty trailer.");
            return dailyLog;
        }
        C2582a newBuilder = DailyLog.newBuilder(dailyLog);
        if (newBuilder.m13037O().isEmpty()) {
            newBuilder.m13089h(str);
            return newBuilder.m13069c();
        }
        Iterable arrayList = new ArrayList(newBuilder.m13037O());
        int indexOf = arrayList.indexOf(str);
        if (indexOf >= 0) {
            arrayList.remove(indexOf);
        }
        arrayList.add(0, str);
        newBuilder.m13038P();
        newBuilder.m13060b(arrayList);
        return newBuilder.m13069c();
    }

    public static DailyLog m8513b(DailyLog dailyLog, String str) {
        if (am.m4188a((CharSequence) str)) {
            C2134e.m10680d("TT-DailyLogUtils", "Attempt to merge an empty shippingDoc.");
            return dailyLog;
        }
        C2582a newBuilder = DailyLog.newBuilder(dailyLog);
        if (newBuilder.m13039Q().isEmpty()) {
            newBuilder.m13091i(str);
            return newBuilder.m13069c();
        }
        Iterable arrayList = new ArrayList(newBuilder.m13039Q());
        int indexOf = arrayList.indexOf(str);
        if (indexOf >= 0) {
            arrayList.remove(indexOf);
        }
        arrayList.add(0, str);
        newBuilder.m13040R();
        newBuilder.m13066c(arrayList);
        return newBuilder.m13069c();
    }

    public static boolean m8511a(DailyLog dailyLog, Iterable<? extends C0890f> iterable) {
        return C1738c.m8517f(dailyLog) || ((dailyLog != null && dailyLog.getAutoDailyLogTruckCount() > 0) || C0890f.m4502a((Iterable) iterable));
    }

    public static boolean m8512a(Iterable<? extends C0890f> iterable) {
        TruckManager p = OurApplication.m6294p();
        if (iterable != null) {
            for (C0890f w : iterable) {
                Long w2 = w.m4528w();
                if (w2 != null) {
                    Truck a = p.m6552a(w2.longValue());
                    if (a != null && a.getTruckLogType() == 3) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static boolean m8517f(DailyLog dailyLog) {
        return dailyLog != null && dailyLog.hasAmendedAt();
    }

    public static boolean m8518g(DailyLog dailyLog) {
        return dailyLog != null && dailyLog.hasDriverApproval();
    }

    public static List<String> m8510a(C0959y c0959y, Context context) {
        Resources resources = context.getResources();
        List<String> arrayList = new ArrayList();
        if (c0959y.m4899b()) {
            arrayList.add(resources.getString(R.string.cycle_passengerCarrying));
        } else {
            if (c0959y.m4903e()) {
                arrayList.add(resources.getString(R.string.cycle_oilfieldSpecialist));
            }
            if (c0959y.m4910l()) {
                arrayList.add(resources.getString(R.string.cycle_restBreakExempt));
            }
            if (c0959y.m4902d()) {
                arrayList.add(resources.getString(R.string.cycle_24HrReset));
            }
            if (c0959y.m4911m()) {
                arrayList.add(resources.getString(R.string.cycle_bigDay));
            }
        }
        if (c0959y.m4905g()) {
            if (c0959y.m4906h()) {
                arrayList.add(resources.getString(R.string.cycle_150AirMileShortHaul));
            }
        } else if (c0959y.m4904f()) {
            arrayList.add(resources.getString(R.string.cycle_100AirMileShortHaul));
        } else if (c0959y.m4912n()) {
            arrayList.add(resources.getString(R.string.cycle_motionPicture));
        }
        if (c0959y.m4909k()) {
            arrayList.add(resources.getString(R.string.cycle_farmProducts));
        }
        if ((c0959y.m4907i() || c0959y.m4909k()) && !c0959y.m4899b() && c0959y.m4908j()) {
            arrayList.add(resources.getString(R.string.cycle_500Gallons));
        }
        return arrayList;
    }

    public static String m8507a(DailyLog dailyLog, Context context) {
        return C1738c.m8505a(new C0956v((al) dailyLog), context);
    }

    public static String m8505a(C0874m c0874m, Context context) {
        C0959y h;
        StringBuilder stringBuilder;
        Iterable a;
        Resources resources = context.getResources();
        Iterable arrayList = new ArrayList();
        if (c0874m.mo704c()) {
            h = c0874m.mo709h();
            if (h.m4901c()) {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosAlaskan7DayCycle));
            } else if (h.m4905g()) {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosTexas7DayCycle));
            } else {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosUS7DayCycle));
            }
            a = C1738c.m8510a(h, context);
            if (!a.isEmpty()) {
                stringBuilder.append(" (").append(am.m4186a(", ", a)).append(')');
            }
            arrayList.add(stringBuilder.toString());
        }
        if (c0874m.mo705d()) {
            h = c0874m.mo710i();
            if (h.m4901c()) {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosAlaskan8DayCycle));
            } else if (h.m4907i()) {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosCalifornia8DayCycle));
            } else if (h.m4909k()) {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosCalifornia8DayFarmCycle));
            } else {
                stringBuilder = new StringBuilder(resources.getString(R.string.cycle_hosUS8DayCycle));
            }
            a = C1738c.m8510a(h, context);
            if (!a.isEmpty()) {
                stringBuilder.append(" (").append(am.m4186a(", ", a)).append(')');
            }
            arrayList.add(stringBuilder.toString());
        }
        if (c0874m.mo707f()) {
            if (c0874m.mo711j().m4437b()) {
                arrayList.add(resources.getString(R.string.cycle_hosCanadianNorthOf60Cycle1));
            } else {
                arrayList.add(resources.getString(R.string.cycle_hosCanadianCycle1));
            }
        }
        if (c0874m.mo708g()) {
            if (c0874m.mo712k().m4437b()) {
                arrayList.add(resources.getString(R.string.cycle_hosCanadianNorthOf60Cycle2));
            } else {
                arrayList.add(resources.getString(R.string.cycle_hosCanadianCycle2));
            }
        }
        return am.m4186a(", ", arrayList);
    }

    public static C1737a m8500a(C0898i c0898i, long j, int i, TimeZone timeZone) {
        Calendar a = DailyLogUtils.m4298a(i, timeZone);
        Calendar a2 = DailyLogUtils.m4298a(i - 6, timeZone);
        Calendar a3 = DailyLogUtils.m4298a(i - 7, timeZone);
        long timeInMillis = aq.m4224a(timeZone, j).getTimeInMillis();
        C0882q e = c0898i.m4558e();
        return new C1737a(e.m4451b(a.getTimeInMillis(), timeInMillis), e.m4445a(a.getTimeInMillis(), timeInMillis), e.m4445a(a2.getTimeInMillis(), timeInMillis), e.m4445a(a3.getTimeInMillis(), timeInMillis));
    }

    public static String m8504a(Context context, Long l) {
        return DailyLogUtils.m4297a(context.getResources().getConfiguration().locale, l);
    }
}
