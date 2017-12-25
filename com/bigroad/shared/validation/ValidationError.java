package com.bigroad.shared.validation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public class ValidationError {
    public static final List<ErrorCode> f3855c;
    private final ErrorCode f3856a;
    private final C1175o f3857b;
    private final Severity f3858d;
    private final Category f3859e;
    private final ValidationErrorRelatedLogLink f3860f;

    public enum Category {
        DRIVE_TIME("common.validationCategory.driverContext.driveTime", "common.validationCategory.short.driveTime"),
        SENSOR_FAILURE("common.validationCategory.driverContext.sensorFailure", "common.validationCategory.short.sensorFailure"),
        FORM_AND_MANNER("common.validationCategory.driverContext.formAndManner", "common.validationCategory.short.formAndManner"),
        NOT_SUBMITTED("common.validationCategory.driverContext.notSubmitted", "common.validationCategory.short.notSubmitted"),
        MISSING_SIGNATURE("common.validationCategory.driverContext.missingSignature", "common.validationCategory.short.missingSignature"),
        MILEAGE_GAP("common.validationCategory.driverContext.mileageGap", "common.validationCategory.short.mileageGap"),
        SUSPICIOUS_LOGS("common.validationCategory.driverContext.suspiciousLogs", "common.validationCategory.short.suspiciousLogs");
        
        private final String m_resourceKeyDriverContext;
        private final String m_resourceKeyShort;

        private Category(String str, String str2) {
            this.m_resourceKeyDriverContext = str;
            this.m_resourceKeyShort = str2;
        }
    }

    public enum ErrorCode {
        IS_EMPTY,
        IS_LESS_THAN_MIN_LENGTH,
        IS_MORE_THAN_MAX_LENGTH,
        DISTANCE_MISMATCH,
        DAILY_LOG_NOT_SIGNED,
        DAILY_LOG_NOT_SUBMITTED,
        DAILY_LOG_HEADER_MISSING,
        DAILY_LOG_HEADER_PERSON_MISMATCH,
        DAILY_LOG_HEADER_END_ODOMETER_BEFORE_START_ODOMETER,
        DAILY_LOG_HEADER_TOTAL_DISTANCE_INCORRECT,
        DVIR_NOT_SIGNED,
        DVIR_INSPECTION_NO_REMARKS_FOR_DEFECT,
        DAILY_LOG_TRUCK_END_ODOMETER_BEFORE_START_ODOMETER,
        DAILY_LOG_TRUCK_TOTAL_DISTANCE_INCORRECT,
        DAILY_LOG_TRUCK_AOBRD_WITHOUT_ODOMETER_READING,
        DAILY_LOG_TRUCK_GAP,
        DAILY_LOG_DRIVING_WITH_NO_TRUCKS,
        DRIVE_TIME_EXCEEDED,
        DAILY_LOG_ODOMETER_DISTANCE_TOO_LARGE,
        DAILY_LOG_TOTAL_DISTANCE_TOO_LARGE,
        DAILY_LOG_TOO_MANY_TRUCK_LOGS,
        INVALID_PHONE_NUMBER,
        DRIVING_OVER_SHIFT_DRIVE_LIMIT,
        DRIVING_OVER_SHIFT_DUTY_LIMIT,
        DRIVING_OVER_SHIFT_DURATION_LIMIT,
        DRIVING_OVER_DUTY_CYCLE_LIMIT,
        DRIVING_OVER_DUTY_CYCLE_SINCE_BREAK_LIMIT,
        DRIVING_WITHOUT_SHIFT_BREAK,
        DRIVING_WITHOUT_CYCLE_BREAK,
        DRIVING_WITH_SENSOR_FAILURE,
        DAY_WITHOUT_MINIMUM_REST,
        DRIVING_OVER_DAILY_DRIVE_LIMIT,
        DRIVING_OVER_DAILY_DUTY_LIMIT
    }

    public enum Severity {
        SUSPICIOUS(false, false),
        WARNING(true, false),
        ERROR(true, true);
        
        public static Set<Severity> f3853d;
        private boolean m_isError;
        private boolean m_isImportant;

        static {
            f3853d = Collections.unmodifiableSet(EnumSet.of(WARNING, ERROR));
        }

        private Severity(boolean z, boolean z2) {
            this.m_isError = z;
            this.m_isImportant = z2;
        }

        public boolean m5779a() {
            return this.m_isError;
        }
    }

    static {
        List arrayList = new ArrayList(2);
        arrayList.add(ErrorCode.DAILY_LOG_NOT_SIGNED);
        arrayList.add(ErrorCode.DAILY_LOG_NOT_SUBMITTED);
        f3855c = Collections.unmodifiableList(arrayList);
    }

    public ValidationError(ErrorCode errorCode, C1175o c1175o, Category category) {
        this(errorCode, c1175o, category, null);
    }

    public ValidationError(ErrorCode errorCode, C1175o c1175o, Category category, ValidationErrorRelatedLogLink validationErrorRelatedLogLink) {
        this(errorCode, c1175o, Severity.ERROR, category, validationErrorRelatedLogLink);
    }

    public ValidationError(ErrorCode errorCode, C1175o c1175o, Severity severity, Category category) {
        this(errorCode, c1175o, severity, category, null);
    }

    public ValidationError(ErrorCode errorCode, C1175o c1175o, Severity severity, Category category, ValidationErrorRelatedLogLink validationErrorRelatedLogLink) {
        this.f3856a = errorCode;
        this.f3857b = c1175o;
        this.f3858d = severity;
        this.f3859e = category;
        this.f3860f = validationErrorRelatedLogLink;
    }

    public ErrorCode m5780b() {
        return this.f3856a;
    }

    public C1175o m5781c() {
        return this.f3857b;
    }

    public Severity m5782d() {
        return this.f3858d;
    }

    public Category m5783e() {
        return this.f3859e;
    }
}
