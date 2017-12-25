package com.bigroad.ttb.android.aobrd;

import com.bigroad.ttb.android.vehicle.VehicleStateMalfunction;
import com.bigroad.ttb.protocol.TTProtocol.EventType;
import com.google.common.collect.ImmutableList;
import java.util.List;

public enum MalfunctionReason {
    NO_ODOMETER_READINGS("No odometer readings", EventType.DRIVING_WITHOUT_DASH_LINK, "MISSING_ODOMETER_READINGS"),
    UNCALIBRATED_ODOMETER("EOBR odometer is not calibrated", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_UNCALIBRATED_ODOMETER"),
    SENSOR_FAILURE_ODOMETER_SLOW("EOBR odometer is slow", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_ODOMETER_SLOW"),
    SENSOR_FAILURE_ODOMETER_FAST("EOBR odometer is fast", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_ODOMETER_FAST"),
    DUTY_STATUS_CONFLICT("Data conflict", EventType.DUTY_STATUS_CONFLICT, null),
    MISSING_ROAD_SPEED_DATA("Truck missing road speed data", EventType.DRIVING_WITHOUT_DASH_LINK, "MISSING_ROAD_SPEED_DATA"),
    MANUAL_ENTRY_DRIVING_WITHOUT_DASH_LINK("Driving without DashLink", EventType.DRIVING_WITHOUT_DASH_LINK, "DASH_LINK_NOT_CONNECTED"),
    GPS_MOTION_WHILE_NOT_DRIVING("GPS motion while not driving", EventType.GPS_MOTION_WHILE_NOT_DRIVING, null),
    WRONG_FIRMWARE_VERSION("Truck requires newer version of DashLink", EventType.DRIVING_WITHOUT_DASH_LINK, "WRONG_FIRMWARE_VERSION"),
    CONNECTED_WITH_NO_ROAD_SPEED("Truck not reporting road speed", EventType.DRIVING_WITHOUT_DASH_LINK, "CONNECTED_WITH_NO_ROAD_SPEED"),
    GENX_LOST_ECM("EOBR lost connection with engine", EventType.DRIVING_WITHOUT_DASH_LINK, "GENX_LOST_ECM");
    
    static List<MalfunctionReason> f5978l;
    private final String m_analyticsEventName;
    private final String m_eventSubType;
    private final EventType m_eventType;

    static {
        f5978l = ImmutableList.m18509a(MANUAL_ENTRY_DRIVING_WITHOUT_DASH_LINK, DUTY_STATUS_CONFLICT);
    }

    private MalfunctionReason(String str, EventType eventType, String str2) {
        this.m_analyticsEventName = str;
        this.m_eventType = eventType;
        this.m_eventSubType = str2;
    }

    public EventType m8431a() {
        return this.m_eventType;
    }

    public String m8432b() {
        return this.m_eventSubType;
    }

    public static MalfunctionReason m8430a(VehicleStateMalfunction vehicleStateMalfunction) {
        switch (vehicleStateMalfunction) {
            case NO_ODOMETER_READINGS:
                return NO_ODOMETER_READINGS;
            case UNCALIBRATED_ODOMETER:
                return UNCALIBRATED_ODOMETER;
            case FAST_ODOMETER:
                return SENSOR_FAILURE_ODOMETER_FAST;
            case SLOW_ODOMETER:
                return SENSOR_FAILURE_ODOMETER_SLOW;
            case MISSING_ROAD_SPEED:
                return MISSING_ROAD_SPEED_DATA;
            case GENX_LOST_ECM:
                return GENX_LOST_ECM;
            default:
                return null;
        }
    }
}
