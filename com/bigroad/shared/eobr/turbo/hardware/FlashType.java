package com.bigroad.shared.eobr.turbo.hardware;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum FlashType implements C1000c {
    FLASH_TYPE_UNKNOWN(0),
    FLASH_TYPE_SST26VF032B(1),
    FLASH_TYPE_S25FL164K(2),
    FLASH_TYPE_SST26VF064B(3);
    
    private final int m_id;

    private FlashType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == FLASH_TYPE_UNKNOWN;
    }
}
