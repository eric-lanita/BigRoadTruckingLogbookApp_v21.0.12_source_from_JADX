package com.bigroad.shared.eobr.turbo;

public enum ManufacturingEvent implements C1000c {
    MANUFACTURING_EVENT_UNKNOWN(0),
    MANUFACTURING_EVENT_ERASE_VAR(1),
    MANUFACTURING_EVENT_FORCE_REFLASH(2);
    
    private final int m_id;

    private ManufacturingEvent(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == MANUFACTURING_EVENT_UNKNOWN;
    }
}
