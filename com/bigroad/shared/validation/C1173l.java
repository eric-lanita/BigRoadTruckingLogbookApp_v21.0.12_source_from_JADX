package com.bigroad.shared.validation;

import com.bigroad.shared.am;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;

public abstract class C1173l {
    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5950a(FIELD_ENUM field_enum, String str, int i, int i2, C1176p<FIELD_ENUM> c1176p, C1175o c1175o, C1175o c1175o2) {
        if (am.m4188a((CharSequence) str) || str.length() < i) {
            c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.IS_LESS_THAN_MIN_LENGTH, c1175o, Severity.ERROR, Category.FORM_AND_MANNER));
        }
        if (!am.m4188a((CharSequence) str) && str.length() > i2) {
            c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.IS_MORE_THAN_MAX_LENGTH, c1175o2, Severity.ERROR, Category.FORM_AND_MANNER));
        }
    }
}
