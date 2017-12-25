package com.bigroad.shared.validation;

import com.bigroad.shared.am;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.model.DvirInspection;
import com.bigroad.shared.validation.model.DvirInspection.Field;

public abstract class C1165e {
    public static void m5931a(DvirInspection dvirInspection, C1157a c1157a, int i) {
        C1176p A = dvirInspection.mo716A();
        A.m5955a();
        C1171j.m5945a(Field.VEHICLE_NUMBER, dvirInspection.mo846c(), A, new C1175o(ValidationMessageId.DVIR_VEHICLE_NUMBER_REQUIRED));
        if (c1157a.mo1221a(i).mo706e()) {
            C1171j.m5945a(Field.LOCATION_NAME, dvirInspection.mo848e(), A, new C1175o(ValidationMessageId.DVIR_LOCATION_NAME_REQUIRED));
            if (dvirInspection.mo845b() == 1) {
                C1171j.m5943a(Field.ODOMETER, dvirInspection.mo847d(), A, new C1175o(ValidationMessageId.DVIR_ODOMETER_REQUIRED));
            }
        }
        if (dvirInspection.mo849f() && am.m4188a(dvirInspection.mo850g())) {
            A.m5956a(Field.REMARKS, new ValidationError(ErrorCode.DVIR_INSPECTION_NO_REMARKS_FOR_DEFECT, new C1175o(ValidationMessageId.DVIR_REMARK_REQUIRED), Category.FORM_AND_MANNER));
        }
    }
}
