package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum DataRegister implements C1000c {
    REGISTER_CAN0_DATA(0),
    REGISTER_CAN1_DATA(1),
    REGISTER_VIN(2),
    REGISTER_DATA_TO_SIGN(3),
    REGISTER_DATA_SIGNATURE(4),
    REGISTER_SOFTWARE_BUILD_INFO(5);
    
    private final int m_id;

    private DataRegister(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return false;
    }
}
