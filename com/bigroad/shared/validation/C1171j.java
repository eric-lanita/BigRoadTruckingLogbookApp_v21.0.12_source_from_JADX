package com.bigroad.shared.validation;

import com.bigroad.shared.am;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import java.util.List;

public abstract class C1171j {
    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5945a(FIELD_ENUM field_enum, String str, C1176p<FIELD_ENUM> c1176p, C1175o c1175o) {
        C1171j.m5946a((Enum) field_enum, str, (C1176p) c1176p, c1175o, Severity.ERROR);
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5943a(FIELD_ENUM field_enum, Integer num, C1176p<FIELD_ENUM> c1176p, C1175o c1175o) {
        C1171j.m5944a((Enum) field_enum, num, (C1176p) c1176p, c1175o, Severity.ERROR);
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5947a(FIELD_ENUM field_enum, List<String> list, C1176p<FIELD_ENUM> c1176p, C1175o c1175o) {
        C1171j.m5948a((Enum) field_enum, (List) list, (C1176p) c1176p, c1175o, Severity.ERROR);
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5946a(FIELD_ENUM field_enum, String str, C1176p<FIELD_ENUM> c1176p, C1175o c1175o, Severity severity) {
        if (am.m4188a((CharSequence) str)) {
            c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.IS_EMPTY, c1175o, severity, Category.FORM_AND_MANNER));
        }
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5944a(FIELD_ENUM field_enum, Integer num, C1176p<FIELD_ENUM> c1176p, C1175o c1175o, Severity severity) {
        if (num == null) {
            c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.IS_EMPTY, c1175o, severity, Category.FORM_AND_MANNER));
        }
    }

    public static <FIELD_ENUM extends Enum<FIELD_ENUM>> void m5948a(FIELD_ENUM field_enum, List<String> list, C1176p<FIELD_ENUM> c1176p, C1175o c1175o, Severity severity) {
        for (CharSequence a : list) {
            if (!am.m4188a(a)) {
                Object obj = null;
                break;
            }
        }
        int i = 1;
        if (obj != null) {
            c1176p.m5956a((Enum) field_enum, new ValidationError(ErrorCode.IS_EMPTY, c1175o, severity, Category.FORM_AND_MANNER));
        }
    }
}
