package com.bigroad.shared.validation;

import com.bigroad.shared.al;
import com.bigroad.shared.ao;
import com.bigroad.shared.model.CanonicalMalfunctionType;
import com.bigroad.shared.validation.ValidationError.Category;
import com.bigroad.shared.validation.ValidationError.ErrorCode;
import com.bigroad.shared.validation.ValidationError.Severity;

public class C1169h extends C1168m {
    public C1169h(ao aoVar, ErrorCode errorCode, CanonicalMalfunctionType canonicalMalfunctionType) {
        super(aoVar, errorCode, new C1175o(ValidationMessageId.m5785a(canonicalMalfunctionType)), Severity.WARNING, Category.SENSOR_FAILURE, canonicalMalfunctionType);
    }

    public C1169h(long j, ErrorCode errorCode, CanonicalMalfunctionType canonicalMalfunctionType) {
        this(new al(j, j), errorCode, canonicalMalfunctionType);
    }
}
