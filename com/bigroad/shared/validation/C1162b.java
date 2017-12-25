package com.bigroad.shared.validation;

import com.bigroad.shared.af;
import com.bigroad.shared.am;
import com.bigroad.shared.dailylog.DailyLogUtils;
import com.bigroad.shared.dailylog.DailyLogUtils.C0859a;
import com.bigroad.shared.dailylog.DailyLogUtils.DailyLogType;
import com.bigroad.shared.gaps.C1080c;
import com.bigroad.shared.gaps.C1085f;
import com.bigroad.shared.gaps.LogDayCalculationError;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.model.DailyLog;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.DailyLogHeader.Field;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.model.Dvir;
import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class C1162b {
    private final DailyLog f3952a;

    public C1162b(DailyLog dailyLog) {
        this.f3952a = dailyLog;
    }

    private void m5924a(DailyLogHeader dailyLogHeader, C1176p<Field> c1176p) {
        Integer o = dailyLogHeader.mo838o();
        Integer p = dailyLogHeader.mo839p();
        Integer g = dailyLogHeader.mo830g();
        if (o != null && p != null) {
            if (p.intValue() < o.intValue()) {
                c1176p.m5956a(Field.END_ODOMETER, new ValidationError(ErrorCode.DAILY_LOG_HEADER_END_ODOMETER_BEFORE_START_ODOMETER, new C1175o(ValidationMessageId.END_ODOMETER_BEFORE_START_ODOMETER), Category.FORM_AND_MANNER));
            } else if (g != null) {
                Integer valueOf = Integer.valueOf(p.intValue() - o.intValue());
                if (p.intValue() - o.intValue() != g.intValue()) {
                    c1176p.m5956a(Field.TOTAL_DISTANCE, new ValidationError(ErrorCode.DAILY_LOG_HEADER_TOTAL_DISTANCE_INCORRECT, new C1175o(ValidationMessageId.TOTAL_DISTANCE_INCORRECT, new Object[]{valueOf}), Category.FORM_AND_MANNER));
                }
            }
        }
    }

    private static C1085f m5920a(C1157a c1157a, String str, int i, Map<String, C1085f> map) {
        if (str == null) {
            System.err.print("This should never happen!! After implementing DEV-1199, examine whether or not gaps should be displayed for trucks outside the current signed-in fleet.");
            return null;
        }
        C1085f c1085f = (C1085f) map.get(str);
        if (c1085f != null) {
            return c1085f;
        }
        C1080c c = c1157a.mo1223c();
        if (c == null) {
            return c1085f;
        }
        c1085f = c.mo778a(i, str);
        if (c1085f == null) {
            return c1085f;
        }
        map.put(str, c1085f);
        return c1085f;
    }

    private void m5923a(DailyLogHeader dailyLogHeader, C1157a c1157a, C1176p<Field> c1176p, boolean z, boolean z2, int i) {
        C1177q d = c1157a.mo1224d();
        long c = d.mo1218c();
        Map treeMap = new TreeMap();
        for (DailyLogTruck dailyLogTruck : dailyLogHeader.mo832i()) {
            C1163c.m5927a(dailyLogHeader, dailyLogTruck, z, z2, true, C1162b.m5920a(c1157a, dailyLogTruck.mo823b(), i, treeMap));
        }
        for (DailyLogTruck dailyLogTruck2 : dailyLogHeader.mo833j()) {
            C1163c.m5927a(dailyLogHeader, dailyLogTruck2, z, z2, true, C1162b.m5920a(c1157a, dailyLogTruck2.mo823b(), i, treeMap));
        }
        for (DailyLogTruck dailyLogTruck22 : dailyLogHeader.mo834k()) {
            C1163c.m5927a(dailyLogHeader, dailyLogTruck22, z, z2, true, C1162b.m5920a(c1157a, dailyLogTruck22.mo823b(), i, treeMap));
        }
        for (Entry value : treeMap.entrySet()) {
            LogDayCalculationError d2 = ((C1085f) value.getValue()).m5386d();
            if (d2 != null) {
                switch (d2) {
                    case TOO_MANY_TRUCK_LOGS:
                        c1176p.m5956a(Field.TOTAL_DISTANCE, new ValidationError(ErrorCode.DAILY_LOG_TOO_MANY_TRUCK_LOGS, new C1175o(ValidationMessageId.TOO_MANY_TRUCKS, new Object[]{value.getKey()}), Severity.SUSPICIOUS, Category.SUSPICIOUS_LOGS));
                        break;
                    default:
                        break;
                }
            }
        }
        d.m5968b(d.m5970c(c));
        C0859a a = DailyLogUtils.m4290a(dailyLogHeader.mo831h(), dailyLogHeader.mo832i(), dailyLogHeader.mo833j(), dailyLogHeader.mo834k());
        Object obj = (a.m4282f() && a.m4277a()) ? 1 : null;
        if (dailyLogHeader.mo833j().isEmpty() && dailyLogHeader.mo834k().isEmpty()) {
            int floor = obj != null ? (int) Math.floor((double) a.m4279c().intValue()) : 0;
            Integer g = dailyLogHeader.mo830g();
            if (obj != null && g != null && !g.equals(Integer.valueOf(floor))) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(floor);
                if (a.m4278b()) {
                    stringBuilder.append(" ");
                    stringBuilder.append(af.m4153a(a.m4280d()));
                }
                c1176p.m5956a(Field.TOTAL_DISTANCE, new ValidationError(ErrorCode.DAILY_LOG_HEADER_TOTAL_DISTANCE_INCORRECT, new C1175o(ValidationMessageId.TOTAL_DISTANCE_INCORRECT_AOBRD, new Object[]{stringBuilder.toString()}), Category.FORM_AND_MANNER));
            }
        }
    }

    private void m5921a(DailyLogHeader dailyLogHeader, C1157a c1157a, C1176p<Field> c1176p) {
        String b = am.m4191b(c1157a.mo1222b());
        String b2 = am.m4191b(dailyLogHeader.mo824a());
        if (!am.m4188a((CharSequence) b2) && !am.m4188a((CharSequence) b) && !am.m4189a(b2, b)) {
            c1176p.m5956a(Field.DRIVER_NAME, new ValidationError(ErrorCode.DAILY_LOG_HEADER_PERSON_MISMATCH, new C1175o(ValidationMessageId.DRIVER_NAME_MISMATCH, new Object[]{b}), Severity.WARNING, Category.FORM_AND_MANNER));
        }
    }

    private void m5922a(DailyLogHeader dailyLogHeader, C1157a c1157a, C1176p<Field> c1176p, DailyLogType dailyLogType, boolean z, int i) {
        if (dailyLogType == DailyLogType.SINGLE_TRUCK_FIELD) {
            m5924a(dailyLogHeader, c1176p);
        } else {
            m5923a(dailyLogHeader, c1157a, (C1176p) c1176p, z, true, i);
        }
        m5921a(dailyLogHeader, c1157a, (C1176p) c1176p);
    }

    public void m5925a(DailyLogHeader dailyLogHeader, C1157a c1157a, int i) {
        C1176p A = dailyLogHeader.mo716A();
        A.m5955a();
        DailyLogType a = C1178r.m5971a(dailyLogHeader);
        boolean z = false;
        if (this.f3952a != null) {
            z = this.f3952a.mo857a() == c1157a.mo1219a();
        }
        if (C1178r.m5974a(c1157a, i)) {
            m5922a(dailyLogHeader, c1157a, A, a, z, i);
            return;
        }
        C1171j.m5945a(Field.DRIVER_NAME, dailyLogHeader.mo824a(), A, new C1175o(ValidationMessageId.DRIVER_NAME_REQUIRED));
        m5921a(dailyLogHeader, c1157a, A);
        if (a == DailyLogType.SINGLE_TRUCK_FIELD) {
            m5924a(dailyLogHeader, A);
        } else {
            m5923a(dailyLogHeader, c1157a, A, z, false, i);
        }
        if (a == DailyLogType.MULTI_TRUCK && (dailyLogHeader.mo832i().size() + dailyLogHeader.mo833j().size()) + dailyLogHeader.mo834k().size() > 1) {
            OdometerUnit h = dailyLogHeader.mo831h();
            Integer g = dailyLogHeader.mo830g();
            if (!(dailyLogHeader.mo833j().isEmpty() || dailyLogHeader.mo834k().isEmpty())) {
                C0859a a2 = DailyLogUtils.m4290a(dailyLogHeader.mo831h(), dailyLogHeader.mo832i(), dailyLogHeader.mo833j(), dailyLogHeader.mo834k());
                h = a2.m4280d();
                g = a2.m4279c();
            }
            MaxDistanceValidator.m5776a(Field.TOTAL_DISTANCE, g, h, A);
        }
        if (this.f3952a == null || !C1178r.m5975a(this.f3952a)) {
            if (this.f3952a != null && C1178r.m5984b(this.f3952a)) {
                boolean a3 = a == DailyLogType.SINGLE_TRUCK_FIELD ? am.m4188a(dailyLogHeader.mo837n()) : dailyLogHeader.mo832i().isEmpty() && dailyLogHeader.mo833j().isEmpty() && dailyLogHeader.mo834k().isEmpty();
                if (a3) {
                    A.m5956a(Field.TRUCKS, new ValidationError(ErrorCode.DAILY_LOG_DRIVING_WITH_NO_TRUCKS, new C1175o(ValidationMessageId.TRUCK_NUMBERS_REQUIRED), Category.FORM_AND_MANNER));
                } else if (a == DailyLogType.SINGLE_TRUCK_FIELD || (dailyLogHeader.mo832i().size() > 1 && dailyLogHeader.mo833j().isEmpty() && dailyLogHeader.mo834k().isEmpty())) {
                    C1171j.m5944a(Field.TOTAL_DISTANCE, dailyLogHeader.mo830g(), A, new C1175o(ValidationMessageId.TOTAL_DISTANCE_REQUIRED), z ? Severity.WARNING : Severity.ERROR);
                }
            }
            C1171j.m5945a(Field.CARRIER_NAME, dailyLogHeader.mo826c(), A, new C1175o(ValidationMessageId.CARRIER_NAME_REQUIRED));
            if (dailyLogHeader.mo840q()) {
                C1171j.m5945a(Field.CARRIER_ADDRESS, dailyLogHeader.mo827d(), A, new C1175o(ValidationMessageId.CARRIER_ADDRESS_REQUIRED));
            } else if (dailyLogHeader.mo841r() && am.m4188a(dailyLogHeader.mo827d()) && am.m4188a(dailyLogHeader.mo828e())) {
                A.m5956a(Field.HOME_TERMINAL, new ValidationError(ErrorCode.IS_EMPTY, new C1175o(ValidationMessageId.HOME_TERMINAL_REQUIRED), Category.FORM_AND_MANNER));
            }
            if (a == DailyLogType.SINGLE_TRUCK_FIELD && dailyLogHeader.mo841r()) {
                Severity severity;
                C1171j.m5943a(Field.START_ODOMETER, dailyLogHeader.mo838o(), A, new C1175o(ValidationMessageId.START_ODOMETER_REQUIRED));
                Enum enumR = Field.END_ODOMETER;
                Integer p = dailyLogHeader.mo839p();
                C1175o c1175o = new C1175o(ValidationMessageId.END_ODOMETER_REQUIRED);
                if (z) {
                    severity = Severity.WARNING;
                } else {
                    severity = Severity.ERROR;
                }
                C1171j.m5944a(enumR, p, A, c1175o, severity);
            }
            if (dailyLogHeader.mo840q()) {
                List arrayList = new ArrayList(dailyLogHeader.mo836m());
                arrayList.add(dailyLogHeader.mo829f());
                C1171j.m5947a(Field.SHIPMENTS, arrayList, A, new C1175o(ValidationMessageId.SHIPPING_DOCUMENTS_REQUIRED));
            }
        }
        if (this.f3952a != null) {
            Object obj = null;
            for (Dvir e : this.f3952a.mo860d()) {
                Object obj2;
                for (DvirInspection b : e.mo855e()) {
                    if (b.mo845b() == 2) {
                        obj2 = 1;
                        break;
                    }
                }
                obj2 = obj;
                obj = obj2;
            }
            if (obj != null) {
                arrayList = new ArrayList(dailyLogHeader.mo835l());
                arrayList.add(dailyLogHeader.mo825b());
                C1171j.m5947a(Field.TRAILERS, arrayList, A, new C1175o(ValidationMessageId.TRAILER_NUMBERS_REQUIRED));
            }
        }
    }
}
