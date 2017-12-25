package com.bigroad.shared.gaps.model;

public enum OdometerSegmentType {
    TRUCK_LOG("log", com.bigroad.ttb.protocol.TTProtocol.OdometerSegmentType.TRUCK_LOG_SEGMENT),
    ODOMETER_ADJUSTMENT("adjustment", com.bigroad.ttb.protocol.TTProtocol.OdometerSegmentType.ODOMETER_ADJUSTMENT_SEGMENT);
    
    private final com.bigroad.ttb.protocol.TTProtocol.OdometerSegmentType m_pbType;
    private final String m_shortName;

    private OdometerSegmentType(String str, com.bigroad.ttb.protocol.TTProtocol.OdometerSegmentType odometerSegmentType) {
        this.m_shortName = str;
        this.m_pbType = odometerSegmentType;
    }

    public String m5388a() {
        return this.m_shortName;
    }

    public com.bigroad.ttb.protocol.TTProtocol.OdometerSegmentType m5389b() {
        return this.m_pbType;
    }

    public static OdometerSegmentType m5387a(int i) {
        for (OdometerSegmentType odometerSegmentType : values()) {
            if (odometerSegmentType.m5389b().m14661a() == i) {
                return odometerSegmentType;
            }
        }
        throw new IllegalArgumentException("Unrecognized OdometerSegmentType value: " + i);
    }
}
