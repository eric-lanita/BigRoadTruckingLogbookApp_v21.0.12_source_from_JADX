package com.bigroad.shared.eobr.turbo.hardware;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum GpsType implements C1000c {
    GPS_TYPE_UNKNOWN(0),
    GPS_TYPE_MAX7Q(1);
    
    private final int m_id;

    private GpsType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == GPS_TYPE_UNKNOWN;
    }
}
