package com.bigroad.shared.validation;

import com.bigroad.shared.am;
import com.bigroad.shared.model.CanonicalMalfunctionType;

public enum ValidationMessageId {
    DAILY_LOG_TRUCK_END_ODOMETER_BEFORE_START_ODOMETER("validation.dailyLogTruckEndOdometerBeforeStartOdometer"),
    DAILY_LOG_TRUCK_TOTAL_DISTANCE_INCORRECT("validation.dailyLogTruckTotalDistanceIncorrect"),
    AOBRD_WITHOUT_ODOMETER_READING("validation.aobrdWithoutOdometerReading"),
    DAILY_LOG_TRUCK_GAP_BEFORE("validation.dailyLogTruckGap.before"),
    DAILY_LOG_TRUCK_GAP_AFTER("validation.dailyLogTruckGap.after"),
    ODOMETER_DISTANCE_TOO_BIG("validation.odometerDistanceTooBig"),
    TOTAL_DISTNACE_TOO_BIG("validation.totalDistanceTooBig"),
    TOTAL_DISTNACE_TOO_BIG_SINGLE("validation.totalDistanceTooBig.single"),
    PHONE_NUMBER_EMPTY("validation.phoneNumber.empty"),
    PHONE_NUMBER_COUNTRY("validation.phoneNumber.countryCode"),
    PHONE_NUMBER_DIGITS("validation.phoneNumber.digits"),
    PHONE_NUMBER_DIGITS_COUNTRY("validation.phoneNumber.digitsCountry"),
    END_ODOMETER_BEFORE_START_ODOMETER("validation.header.endOdometerBeforeStart"),
    TOTAL_DISTANCE_INCORRECT("validation.header.totalDistanceIncorrect"),
    TOO_MANY_TRUCKS("validation.header.tooManyTrucks"),
    TOTAL_DISTANCE_INCORRECT_AOBRD("validation.header.totalDistanceIncorrect.aobrd"),
    DRIVER_NAME_MISMATCH("validation.header.driverNameMismatch"),
    DRIVER_NAME_REQUIRED("validation.header.driverNameRequired"),
    TRUCK_NUMBERS_REQUIRED("validation.header.truckNumbersRequired"),
    TOTAL_DISTANCE_REQUIRED("validation.header.totalDistanceRequired"),
    CARRIER_NAME_REQUIRED("validation.header.carrierNameRequired"),
    CARRIER_ADDRESS_REQUIRED("validation.header.carrierAddressRequired"),
    HOME_TERMINAL_REQUIRED("validation.header.homeTerminalRequired"),
    START_ODOMETER_REQUIRED("validation.header.startOdometerRequired"),
    END_ODOMETER_REQUIRED("validation.header.endOdometerRequired"),
    SHIPPING_DOCUMENTS_REQUIRED("validation.header.shippingDocumentsRequired"),
    TRAILER_NUMBERS_REQUIRED("validation.header.trailerNumbersRequired"),
    DVIR_VEHICLE_NUMBER_REQUIRED("validation.dvir.vehicleNumberRequired"),
    DVIR_LOCATION_NAME_REQUIRED("validation.dvir.locationNameRequired"),
    DVIR_ODOMETER_REQUIRED("validation.dvir.odometerRequired"),
    DVIR_REMARK_REQUIRED("validation.dvir.remarkRequired"),
    DVIR_CARRIER_NAME_REQUIRED("validation.dvir.carrierNameRequired"),
    DVIR_INSPECTOR_NAME_REQUIRED("validation.dvir.inspectorNameRequired"),
    DVIR_NOT_SIGNED("validation.dvir.notSigned"),
    DRIVE_TIME_EXCEEDED("validation.driverTime.exceeded"),
    DRIVE_TIME_EXCEEDED_REST_BREAK("validation.driverTime.exceeded.restBreak"),
    LOG_MISSING_HEADER("validation.dailyLog.missingHeader"),
    LOG_NOT_SUBMITTED("validation.dailyLog.notSubmitted"),
    LOG_NOT_SIGNED("validation.dailyLog.notSigned"),
    CDN_DAY_OFF_DUTY_REQUIRED("validation.canadianDayAndShift.day.totalOffDutyTime"),
    CDN_DAY_OFF_DUTY_REQUIRED_30_MIN("validation.canadianDayAndShift.day.totalOffDutyTime.minBlock"),
    CDN_DAY_OFF_DUTY_REQUIRED_30_MIN_RESET("validation.canadianDayAndShift.day.totalOffDutyTime.minBlockWithReset"),
    CDN_DAY_SHIFT_DUTY("validation.canadianDayAndShift.shift.onDuty"),
    CDN_DAY_SHIFT_DRIVE("validation.canadianDayAndShift.shift.drive"),
    CDN_DAY_SHIFT_DRIVE_SINCE_START("validation.canadianDayAndShift.shift.driveSinceStart"),
    CDN_DAY_SHIFT_DUTY_TODAY("validation.canadianDayAndShift.shift.onDutyToday"),
    CDN_DAY_SHIFT_DRIVE_TODAY("validation.canadianDayAndShift.shift.driveToday"),
    RULE_SHIFT_DRIVE("validation.rule.shift.drive"),
    RULE_SHIFT_DUTY("validation.rule.shift.onDuty"),
    RULE_SHIFT_DUTY_PROPERTY("validation.rule.shift.onDuty.property"),
    RULE_SHIFT_BETWEEN_BREAKS("validation.rule.shift.break"),
    RULE_CYCLE_DUTY("validation.rule.cycle.onDuty"),
    RULE_CYCLE_OFF_DUTY("validation.rule.cycle.offDuty"),
    RULE_CYCLE_24H("validation.rule.cycle.24h"),
    EVENT_LOCATION_REQUIRED("validation.event.locationRequired"),
    EVENT_LOCATION_TOO_SHORT("validation.event.locationTooShort"),
    EVENT_LOCATION_TOO_LONG("validation.event.locationTooLong"),
    EVENT_NOTE_REQUIRED("validation.event.noteRequired"),
    EVENT_NOTE_TOO_SHORT("validation.event.noteTooShort"),
    EVENT_NOTE_TOO_LONG("validation.event.noteTooLong"),
    TRUCK_DISTANCE_REQUIRED("validation.truck.distanceRequired"),
    TRUCK_START_ODOMETER_REQUIRED("validation.truck.startOdometerRequired"),
    TRUCK_END_ODOMETER_REQUIRED("validation.truck.endOdometerRequired"),
    MALFUNCTION_UNKNOWN("common.malfunction.unknown"),
    MALFUNCTION_NOT_CONNECTED("common.malfunction.notConnected"),
    MALFUNCTION_ODOMETER_FAST("common.malfunction.odometerFast"),
    MALFUNCTION_ODOMETER_SLOW("common.malfunction.odometerSlow"),
    MALFUNCTION_NO_ROADSPEED("common.malfunction.noRoadspeed"),
    MALFUNCTION_MISISNG_ROADSPEED("common.malfunction.missingRoadspeed"),
    MALFUNCTION_UNCALIBRATED_ODOMETER("common.malfunction.uncalibratedOdometer"),
    MALFUNCTION_WRONG_FIRMWARE("common.malfunction.wrongFirmware"),
    MALFUNCTION_MISSING_ODOMETER("common.malfunction.missingOdometer"),
    MALFUNCTION_DUTY_STATUS_CONFLICT("common.malfunction.dutyStatusConflict"),
    MALFUNCTION_GENX_LOST_ECM("common.malfunction.genxLostEcm");
    
    private final String m_id;

    private ValidationMessageId(String str) {
        this.m_id = str;
    }

    public String m5786a() {
        return this.m_id;
    }

    public static ValidationMessageId m5785a(CanonicalMalfunctionType canonicalMalfunctionType) {
        for (ValidationMessageId validationMessageId : values()) {
            if (am.m4189a(validationMessageId.m5786a(), canonicalMalfunctionType.m5455a())) {
                return validationMessageId;
            }
        }
        return MALFUNCTION_UNKNOWN;
    }
}
