package com.bigroad.shared.validation;

import com.bigroad.shared.af;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;

public abstract class MaxDistanceValidator {

    private enum TotalDistanceType {
        SINGLE_TRUCK,
        ALL_TRUCKS
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5777a(FIELD_ENUM field_enum, Integer num, Integer num2, OdometerUnit odometerUnit, C1176p<FIELD_ENUM> c1176p) {
        if (num != null && num2 != null && num2.intValue() > num.intValue()) {
            int intValue = num2.intValue() - num.intValue();
            if ((odometerUnit == OdometerUnit.MILES && intValue > 2000) || intValue > 3200) {
                c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.DAILY_LOG_ODOMETER_DISTANCE_TOO_LARGE, m5773a(intValue, odometerUnit), Severity.ERROR, Category.FORM_AND_MANNER));
            }
        }
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5776a(FIELD_ENUM field_enum, Integer num, OdometerUnit odometerUnit, C1176p<FIELD_ENUM> c1176p) {
        m5775a((Enum) field_enum, TotalDistanceType.ALL_TRUCKS, num, odometerUnit, (C1176p) c1176p);
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5778b(FIELD_ENUM field_enum, Integer num, OdometerUnit odometerUnit, C1176p<FIELD_ENUM> c1176p) {
        m5775a((Enum) field_enum, TotalDistanceType.SINGLE_TRUCK, num, odometerUnit, (C1176p) c1176p);
    }

    private static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5775a(FIELD_ENUM field_enum, TotalDistanceType totalDistanceType, Integer num, OdometerUnit odometerUnit, C1176p<FIELD_ENUM> c1176p) {
        if (num == null) {
            return;
        }
        if ((odometerUnit == OdometerUnit.MILES && num.intValue() > 2000) || num.intValue() > 3200) {
            c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.DAILY_LOG_TOTAL_DISTANCE_TOO_LARGE, m5774a(totalDistanceType, num.intValue(), odometerUnit), Severity.ERROR, Category.FORM_AND_MANNER));
        }
    }

    private static C1175o m5773a(int i, OdometerUnit odometerUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        String a = af.m4153a(odometerUnit);
        if (a != null) {
            stringBuilder.append(" ");
            stringBuilder.append(a);
        }
        return new C1175o(ValidationMessageId.ODOMETER_DISTANCE_TOO_BIG, new Object[]{stringBuilder.toString()});
    }

    private static C1175o m5774a(TotalDistanceType totalDistanceType, int i, OdometerUnit odometerUnit) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(i);
        String a = af.m4153a(odometerUnit);
        if (a != null) {
            stringBuilder.append(" ");
            stringBuilder.append(a);
        }
        return new C1175o(totalDistanceType == TotalDistanceType.SINGLE_TRUCK ? ValidationMessageId.TOTAL_DISTNACE_TOO_BIG_SINGLE : ValidationMessageId.ODOMETER_DISTANCE_TOO_BIG, new Object[]{stringBuilder.toString()});
    }
}
