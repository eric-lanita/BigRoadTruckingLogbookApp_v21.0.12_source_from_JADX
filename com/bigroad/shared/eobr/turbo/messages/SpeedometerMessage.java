package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public class SpeedometerMessage extends aj {
    public final int f3314a;
    public final SpeedometerSource f3315b;

    public enum SpeedometerSource implements C1000c {
        SPEEDOMETER_SOURCE_NONE(0),
        SPEEDOMETER_SOURCE_J1939_WHEEL_AXLE_SPEED(1),
        SPEEDOMETER_SOURCE_J1939_CRUISE_CONTROL_SPEED(2),
        SPEEDOMETER_SOURCE_J1587_ROAD_SPEED(3),
        SPEEDOMETER_SOURCE_OBD_VEHICLE_SPEED(4),
        SPEEDOMETER_SOURCE_UNKNOWN(5);
        
        private final int m_id;

        private SpeedometerSource(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == SPEEDOMETER_SOURCE_UNKNOWN;
        }
    }

    public SpeedometerMessage(int i, SpeedometerSource speedometerSource) {
        this.f3314a = i;
        this.f3315b = speedometerSource;
    }
}
