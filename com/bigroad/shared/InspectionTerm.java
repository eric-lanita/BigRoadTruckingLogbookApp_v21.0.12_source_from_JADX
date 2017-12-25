package com.bigroad.shared;

public enum InspectionTerm {
    SEVEN_DAYS(8),
    FOURTEEN_DAYS(15);
    
    private final int m_numDaysInspectable;

    private InspectionTerm(int i) {
        this.m_numDaysInspectable = i;
    }

    public int m4085a() {
        return this.m_numDaysInspectable;
    }

    public static InspectionTerm m4084a(int i) {
        return (i < 0 || i >= values().length) ? SEVEN_DAYS : values()[i];
    }
}
