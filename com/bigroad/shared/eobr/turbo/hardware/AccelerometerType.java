package com.bigroad.shared.eobr.turbo.hardware;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum AccelerometerType implements C1000c {
    ACCELEROMETER_TYPE_UNKNOWN(0),
    ACCELEROMETER_TYPE_LIS331DLH(1),
    ACCELEROMETER_TYPE_LIS3DH(2);
    
    private final int m_id;

    private AccelerometerType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == ACCELEROMETER_TYPE_UNKNOWN;
    }
}
