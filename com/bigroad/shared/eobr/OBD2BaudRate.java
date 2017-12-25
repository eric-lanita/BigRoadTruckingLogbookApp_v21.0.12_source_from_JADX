package com.bigroad.shared.eobr;

import com.facebook.internal.AnalyticsEvents;

public enum OBD2BaudRate {
    UNKNOWN(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
    OBD2_250_KBPS("250Kbps"),
    OBD2_500_KBPS("500Kbps"),
    AUTO_CONNECT_FAILED("auto-connect failed"),
    INITIAL_STATE_NO_ATTEMPT("initial state - no attempt");
    
    private final String m_baudRate;

    private OBD2BaudRate(String str) {
        this.m_baudRate = str;
    }

    public String toString() {
        return this.m_baudRate;
    }
}
