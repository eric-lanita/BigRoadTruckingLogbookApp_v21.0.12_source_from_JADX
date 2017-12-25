package com.bigroad.shared.eobr;

import com.facebook.internal.AnalyticsEvents;

public enum EobrType {
    UNKNOWN_EOBR_TYPE(AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN, 0),
    VNA_JBUS("Jbus", 3),
    VNA_OBD2("OBD-II", 4),
    TURBO("Turbo", 7),
    GENX("Genx", 7);
    
    private final String m_displayString;
    private final long m_supportedBusTypes;

    private EobrType(String str, long j) {
        this.m_displayString = str;
        this.m_supportedBusTypes = j;
    }

    public boolean m4937a(long j) {
        return (m4936a() & j) == j;
    }

    public long m4936a() {
        return this.m_supportedBusTypes;
    }

    public String m4938b() {
        return this.m_displayString;
    }

    public boolean m4939c() {
        return this == TURBO;
    }
}
