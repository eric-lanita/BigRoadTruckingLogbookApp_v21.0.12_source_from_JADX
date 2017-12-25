package com.bigroad.shared.eobr;

import com.facebook.internal.AnalyticsEvents;

public enum OBD2AddressType {
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
    OBD2_11_BIT("11-bit-OBD2"),
    OBD2_29_BIT("29-bit-OBD2");
    
    private final String m_addressType;

    private OBD2AddressType(String str) {
        this.m_addressType = str;
    }

    public String toString() {
        return this.m_addressType;
    }
}
