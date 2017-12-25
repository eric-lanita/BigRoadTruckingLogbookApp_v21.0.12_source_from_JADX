package com.bigroad.shared.eobr.turbo.hardware;

import com.bigroad.shared.eobr.turbo.C1000c;

public enum BluetoothType implements C1000c {
    BLUETOOTH_TYPE_UNKNOWN(0),
    BLUETOOTH_TYPE_CC2564MODN(1);
    
    private final int m_id;

    private BluetoothType(int i) {
        this.m_id = i;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == BLUETOOTH_TYPE_UNKNOWN;
    }
}
