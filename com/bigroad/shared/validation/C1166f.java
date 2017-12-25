package com.bigroad.shared.validation;

import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.Dvir;
import com.bigroad.shared.validation.model.Dvir.Field;
import com.bigroad.shared.validation.model.DvirInspection;

public abstract class C1166f {
    public static void m5932a(Dvir dvir, C1157a c1157a, int i) {
        C1176p A = dvir.mo716A();
        A.m5955a();
        int a = c1157a.mo1219a();
        C1171j.m5945a(Field.CARRIER_NAME, dvir.mo854d(), A, new C1175o(ValidationMessageId.DVIR_CARRIER_NAME_REQUIRED));
        C1171j.m5945a(Field.INSPECTOR_NAME, dvir.mo853c(), A, new C1175o(ValidationMessageId.DVIR_INSPECTOR_NAME_REQUIRED));
        for (DvirInspection a2 : dvir.mo855e()) {
            C1165e.m5931a(a2, c1157a, i);
        }
        if (dvir.mo852b() != a && !dvir.mo856f()) {
            A.m5956a(Field.NONE, new ValidationError(ErrorCode.DVIR_NOT_SIGNED, new C1175o(ValidationMessageId.DVIR_NOT_SIGNED), Category.MISSING_SIGNATURE));
        }
    }
}
