package com.bigroad.shared.validation;

import com.bigroad.shared.af;
import com.bigroad.shared.gaps.C1085f;
import com.bigroad.shared.gaps.model.C1086b;
import com.bigroad.shared.gaps.model.C1091d;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.shared.validation.ValidationErrorRelatedLogLink.Type;
import com.bigroad.shared.validation.model.DailyLogHeader;
import com.bigroad.shared.validation.model.DailyLogTruck;
import com.bigroad.shared.validation.model.DailyLogTruck.Field;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public class C1163c {
    private static void m5929a(DailyLogTruck dailyLogTruck, C1176p<Field> c1176p, boolean z) {
        Integer f = dailyLogTruck.mo779f();
        Integer g = dailyLogTruck.mo780g();
        Integer i = dailyLogTruck.mo781i();
        OdometerUnit t = dailyLogTruck.mo782t();
        if (!(f == null || g == null)) {
            if (g.intValue() < f.intValue()) {
                c1176p.m5956a(Field.END_ODOMETER, new ValidationError(ErrorCode.DAILY_LOG_TRUCK_END_ODOMETER_BEFORE_START_ODOMETER, new C1175o(ValidationMessageId.DAILY_LOG_TRUCK_END_ODOMETER_BEFORE_START_ODOMETER), Category.FORM_AND_MANNER));
            } else if (i != null && z) {
                int intValue = g.intValue() - f.intValue();
                if (intValue != i.intValue()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(intValue);
                    if (t != null) {
                        stringBuilder.append(" ");
                        stringBuilder.append(af.m4153a(t));
                    }
                    String stringBuilder2 = stringBuilder.toString();
                    c1176p.m5956a(Field.TOTAL_DISTANCE, new ValidationError(ErrorCode.DAILY_LOG_TRUCK_TOTAL_DISTANCE_INCORRECT, new C1175o(ValidationMessageId.DAILY_LOG_TRUCK_TOTAL_DISTANCE_INCORRECT, new Object[]{stringBuilder2}), Category.FORM_AND_MANNER));
                }
            }
        }
        MaxDistanceValidator.m5777a(Field.END_ODOMETER, f, g, t, (C1176p) c1176p);
        MaxDistanceValidator.m5778b(Field.TOTAL_DISTANCE, i, t, c1176p);
    }

    private static void m5928a(DailyLogTruck dailyLogTruck, C1176p<Field> c1176p, C1085f c1085f) {
        if (c1085f != null) {
            for (C1086b c1086b : c1085f.m5384b()) {
                if (C1178r.m5979a(dailyLogTruck.mo779f(), Long.valueOf(c1086b.m5392b().m5421e()), c1086b.m5392b().m5422f()) && C1178r.m5976a(dailyLogTruck, c1086b.m5392b())) {
                    c1176p.m5956a(Field.START_ODOMETER, C1163c.m5926a(dailyLogTruck.a_(), c1086b, dailyLogTruck.mo782t(), true));
                }
                if (C1178r.m5979a(dailyLogTruck.mo780g(), Long.valueOf(c1086b.m5391a().m5423g()), c1086b.m5391a().m5424h()) && C1178r.m5976a(dailyLogTruck, c1086b.m5391a())) {
                    c1176p.m5956a(Field.END_ODOMETER, C1163c.m5926a(dailyLogTruck.a_(), c1086b, dailyLogTruck.mo782t(), false));
                }
            }
            if (dailyLogTruck.mo779f() == null && dailyLogTruck.mo780g() == null && dailyLogTruck.mo781i() != null && dailyLogTruck.mo781i().intValue() > 0) {
                for (C1091d a : c1085f.m5385c()) {
                    if (C1178r.m5976a(dailyLogTruck, a)) {
                        c1176p.m5956a(Field.START_ODOMETER, new ValidationError(ErrorCode.DAILY_LOG_TRUCK_AOBRD_WITHOUT_ODOMETER_READING, new C1175o(ValidationMessageId.AOBRD_WITHOUT_ODOMETER_READING), Severity.SUSPICIOUS, Category.MILEAGE_GAP));
                        return;
                    }
                }
            }
        }
    }

    private static ValidationError m5926a(int i, C1086b c1086b, OdometerUnit odometerUnit, boolean z) {
        C1091d a = z ? c1086b.m5391a() : c1086b.m5392b();
        ValidationErrorRelatedLogLink validationErrorRelatedLogLink = null;
        if (!(a.m5418b() == i && c1086b.m5391a().m5419c() == c1086b.m5392b().m5419c())) {
            validationErrorRelatedLogLink = new ValidationErrorRelatedLogLink(Type.ODOMETER_READING, a.m5418b(), z, a.m5419c());
        }
        return new ValidationError(ErrorCode.DAILY_LOG_TRUCK_GAP, new C1175o(z ? ValidationMessageId.DAILY_LOG_TRUCK_GAP_BEFORE : ValidationMessageId.DAILY_LOG_TRUCK_GAP_AFTER, new Object[]{c1086b.m5393b(odometerUnit)}), Severity.SUSPICIOUS, Category.MILEAGE_GAP, validationErrorRelatedLogLink);
    }

    public static void m5927a(DailyLogHeader dailyLogHeader, DailyLogTruck dailyLogTruck, boolean z, boolean z2, boolean z3, C1085f c1085f) {
        C1176p A = dailyLogTruck.mo716A();
        A.m5955a();
        if (!z2) {
            C1171j.m5944a(Field.TOTAL_DISTANCE, dailyLogTruck.mo781i(), A, new C1175o(ValidationMessageId.TRUCK_DISTANCE_REQUIRED), z ? Severity.WARNING : Severity.ERROR);
            if (dailyLogHeader.mo841r()) {
                C1171j.m5943a(Field.START_ODOMETER, dailyLogTruck.mo779f(), A, new C1175o(ValidationMessageId.TRUCK_START_ODOMETER_REQUIRED));
                C1171j.m5944a(Field.END_ODOMETER, dailyLogTruck.mo780g(), A, new C1175o(ValidationMessageId.TRUCK_END_ODOMETER_REQUIRED), z ? Severity.WARNING : Severity.ERROR);
            }
        }
        C1163c.m5929a(dailyLogTruck, A, z3);
        C1163c.m5928a(dailyLogTruck, A, c1085f);
    }
}
