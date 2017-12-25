package com.bigroad.shared.eobr.turbo;

public enum BusType implements C1000c {
    BUS_TYPE_NONE(0),
    BUS_TYPE_UNKNOWN(1),
    BUS_TYPE_OBD(2),
    BUS_TYPE_J1939(3),
    BUS_TYPE_J1708(4);
    
    private final int m_id;

    private BusType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == BUS_TYPE_UNKNOWN;
    }
}
