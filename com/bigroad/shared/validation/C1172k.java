package com.bigroad.shared.validation;

import com.bigroad.shared.am;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;
import java.util.ArrayList;
import java.util.List;

public class C1172k {
    public static List<ValidationError> m5949a(String str) {
        List<ValidationError> arrayList = new ArrayList();
        if (am.m4188a((CharSequence) str)) {
            arrayList.add(new ValidationError(ErrorCode.IS_EMPTY, new C1175o(ValidationMessageId.PHONE_NUMBER_EMPTY), Severity.ERROR, Category.FORM_AND_MANNER));
        } else {
            String replaceAll = str.replaceAll("(?i)[^0-9x]|(x(.*))", "");
            if (replaceAll.length() == 11) {
                if (replaceAll.charAt(0) != '1') {
                    arrayList.add(new ValidationError(ErrorCode.INVALID_PHONE_NUMBER, new C1175o(ValidationMessageId.PHONE_NUMBER_COUNTRY), Severity.ERROR, Category.FORM_AND_MANNER));
                }
            } else if (replaceAll.length() != 10) {
                arrayList.add(new ValidationError(ErrorCode.INVALID_PHONE_NUMBER, new C1175o(ValidationMessageId.PHONE_NUMBER_DIGITS), Severity.ERROR, Category.FORM_AND_MANNER));
            } else if (replaceAll.charAt(0) == '1') {
                arrayList.add(new ValidationError(ErrorCode.INVALID_PHONE_NUMBER, new C1175o(ValidationMessageId.PHONE_NUMBER_DIGITS_COUNTRY), Severity.ERROR, Category.FORM_AND_MANNER));
            }
        }
        return arrayList;
    }
}
