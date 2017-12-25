package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum ValueRegister implements C1000c {
    REGISTER_CAN0_BUS_MODE(0),
    REGISTER_CAN1_BUS_MODE(1),
    REGISTER_J1708_BUS_MODE(2),
    REGISTER_TIME(3),
    REGISTER_ROAD_SPEED(4),
    REGISTER_VEHICLE_DISTANCE(5),
    REGISTER_VEHICLE_DISTANCE_REMAINDER(6),
    REGISTER_TRIP_DISTANCE(7),
    REGISTER_TRIP_DISTANCE_REMAINDER(8),
    REGISTER_ENGINE_SPEED(9),
    REGISTER_ROAD_SPEED_SCALE(10),
    REGISTER_GPS_LATITUDE(11),
    REGISTER_GPS_LONGITUDE(12),
    REGISTER_GPS_HORIZONTAL_ACCURACY(13),
    REGISTER_GPS_GROUND_SPEED(14),
    REGISTER_GPS_TIMESTAMP(15),
    REGISTER_SOFTWARE_VERSION(16),
    REGISTER_OUTPUT_VOLTAGE(17),
    REGISTER_ODOMETER_CTRL(18),
    REGISTER_ODOMETER_MULTIPLIER(19),
    REGISTER_SCHEDULER_MULTIPLIER(20),
    REGISTER_SET_FLAGS(21),
    REGISTER_UPTIME(22),
    REGISTER_ENGINE_RUN_TIME(23);
    
    private final int m_id;

    private ValueRegister(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return false;
    }
}
