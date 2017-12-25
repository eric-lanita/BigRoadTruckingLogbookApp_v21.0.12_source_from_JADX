package com.bigroad.shared.eobr.genx;

public enum GenxDataType {
    UNKNOWN(-1),
    ENTRY(0),
    AT_COMMAND(1),
    START_SESSION(2),
    STORE_DATA(3),
    HEART_BEAT(4),
    ACK(6),
    NAK(21);
    
    private final int m_id;

    private GenxDataType(int i) {
        this.m_id = i;
    }

    public int m4981a() {
        return this.m_id;
    }

    public static GenxDataType m4980a(int i) {
        switch (i) {
            case 0:
                return ENTRY;
            case 1:
                return AT_COMMAND;
            case 2:
                return START_SESSION;
            case 3:
                return STORE_DATA;
            case 4:
                return HEART_BEAT;
            case 6:
                return ACK;
            case 21:
                return NAK;
            default:
                return UNKNOWN;
        }
    }
}
