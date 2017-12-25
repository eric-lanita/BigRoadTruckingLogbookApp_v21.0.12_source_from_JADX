package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum GpsMessageType implements C1000c {
    GPS_MESSAGE_TYPE_NMEA_GPRMC(0),
    GPS_MESSAGE_TYPE_NMEA_GPGGA(1),
    GPS_MESSAGE_TYPE_NMEA_GPGSV(2),
    GPS_MESSAGE_TYPE_PVT(3),
    GPS_MESSAGE_TYPE_UNKNOWN(4);
    
    private final int m_id;

    private GpsMessageType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == GPS_MESSAGE_TYPE_UNKNOWN;
    }
}
