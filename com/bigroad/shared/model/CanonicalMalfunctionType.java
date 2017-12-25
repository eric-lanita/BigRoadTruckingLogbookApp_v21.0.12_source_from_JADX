package com.bigroad.shared.model;

import com.bigroad.shared.am;
import com.bigroad.ttb.protocol.TTProtocol.EventType;

public enum CanonicalMalfunctionType {
    SENSOR_FAILURE_NOT_CONNECTED("common.malfunction.notConnected", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_NOT_CONNECTED"),
    SENSOR_FAILURE_ODOMETER_FAST("common.malfunction.odometerFast", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_ODOMETER_FAST"),
    SENSOR_FAILURE_ODOMETER_SLOW("common.malfunction.odometerSlow", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_ODOMETER_SLOW"),
    SENSOR_FAILURE_NO_ROADSPEED("common.malfunction.noRoadspeed", EventType.DRIVING_WITHOUT_DASH_LINK, "CONNECTED_WITH_NO_ROAD_SPEED"),
    SENSOR_FAILURE_MISSING_ROADSPEED_DATA("common.malfunction.missingRoadspeed", EventType.DRIVING_WITHOUT_DASH_LINK, "MISSING_ROAD_SPEED_DATA"),
    SENSOR_FAILURE_UNCALIBRATED_ODOMETER("common.malfunction.uncalibratedOdometer", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_UNCALIBRATED_ODOMETER"),
    SENSOR_FAILURE_WRONG_FIRMWARE_VERSION("common.malfunction.wrongFirmware", EventType.DRIVING_WITHOUT_DASH_LINK, "WRONG_FIRMWARE_VERSION"),
    SENSOR_FAILURE_MISSING_ODOMETER_READINGS("common.malfunction.missingOdometer", EventType.DRIVING_WITHOUT_DASH_LINK, "MISSING_ODOMETER_READINGS"),
    DUTY_STATUS_CONFLICT("common.malfunction.dutyStatusConflict", EventType.DUTY_STATUS_CONFLICT, ""),
    GENX_LOST_ECM("common.malfunction.genxLostEcm", EventType.DRIVING_WITHOUT_DASH_LINK, "GENX_LOST_ECM");
    
    private static CanonicalMalfunctionType f3588k;
    private final String m_descriptionResourceKey;
    private final String m_eventSubType;
    private final EventType m_pbEventType;

    static {
        f3588k = SENSOR_FAILURE_NOT_CONNECTED;
    }

    private CanonicalMalfunctionType(String str, EventType eventType, String str2) {
        this.m_descriptionResourceKey = str;
        this.m_pbEventType = eventType;
        this.m_eventSubType = str2;
    }

    public String m5455a() {
        return this.m_descriptionResourceKey;
    }

    public EventType m5456b() {
        return this.m_pbEventType;
    }

    public String m5457c() {
        return this.m_eventSubType;
    }

    public static boolean m5453a(int i, String str) {
        return m5454b(i, str) != null;
    }

    public static CanonicalMalfunctionType m5454b(int i, String str) {
        return m5452a(EventType.m13979a(i), str);
    }

    public static CanonicalMalfunctionType m5452a(EventType eventType, String str) {
        if (eventType == null) {
            return null;
        }
        for (CanonicalMalfunctionType canonicalMalfunctionType : values()) {
            if (canonicalMalfunctionType.m5456b() == eventType && am.m4189a(str, canonicalMalfunctionType.m5457c())) {
                return canonicalMalfunctionType;
            }
        }
        if (eventType == EventType.DRIVING_WITHOUT_DASH_LINK) {
            return f3588k;
        }
        return null;
    }
}
