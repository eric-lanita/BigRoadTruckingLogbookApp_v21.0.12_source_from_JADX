package com.bigroad.shared.eobr;

public enum ConnectionFlag {
    CONNECTED(1),
    EOBR_TYPE_MATCH(268435456),
    CURRENT(8388608),
    ENGINE_ON(16777216),
    ODOMETER_READINGS_VALID(33554432),
    ODOMETER_CALIBRATED(67108864),
    ABSOLUTE_TIMESTAMP(134217728),
    TURBO_FIRMWARE_VALID(2147483648L);
    
    private final long m_dashlinkStatusBits;

    private ConnectionFlag(long j) {
        this.m_dashlinkStatusBits = j;
    }

    public long m4928a() {
        return this.m_dashlinkStatusBits;
    }
}
