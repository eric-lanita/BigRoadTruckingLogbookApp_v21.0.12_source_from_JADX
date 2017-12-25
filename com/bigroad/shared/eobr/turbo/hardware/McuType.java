package com.bigroad.shared.eobr.turbo.hardware;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum McuType implements C1000c {
    MCU_TYPE_UNKNOWN(0),
    MCU_TYPE_TM4C1294KCPDT(1),
    MCU_TYPE_TM4C1290NCPDT(2),
    MCU_TYPE_TM4C1292NCPDT(3),
    MCU_TYPE_TM4C1294NCPDT(4);
    
    private final int m_id;

    private McuType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == MCU_TYPE_UNKNOWN;
    }
}
