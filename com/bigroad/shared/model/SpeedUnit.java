package com.bigroad.shared.model;

public enum SpeedUnit {
    MPS(1.0d, "m/s"),
    KMH(3.6d, "km/h"),
    MPH(2.236936292054402d, "mph");
    
    private final String m_displaySuffix;
    private final double m_oneMps;

    private SpeedUnit(double d, String str) {
        this.m_oneMps = d;
        this.m_displaySuffix = str;
    }
}
