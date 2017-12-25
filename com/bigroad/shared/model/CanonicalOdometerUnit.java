package com.bigroad.shared.model;

import com.bigroad.shared.af;
import com.bigroad.ttb.protocol.TTProtocol.OdometerUnit;
import com.bigroad.ttb.protocol.TTProtocol.Truck;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum CanonicalOdometerUnit {
    KM("km", "km", SpeedUnit.KMH, 0.001d, OdometerUnit.KM),
    MILES("miles", "mi", SpeedUnit.MPH, 6.21371E-4d, OdometerUnit.MILES);
    
    public static final List<CanonicalOdometerUnit> f3608c = null;
    private final SpeedUnit m_associatedSpeedUnit;
    private final String m_displayName;
    private final String m_displaySuffix;
    private final double m_oneMeter;
    private final OdometerUnit m_pbOdometerUnit;

    static {
        f3608c = Collections.unmodifiableList(Arrays.asList(new CanonicalOdometerUnit[]{MILES, KM}));
    }

    private CanonicalOdometerUnit(String str, String str2, SpeedUnit speedUnit, double d, OdometerUnit odometerUnit) {
        this.m_displayName = str;
        this.m_displaySuffix = str2;
        this.m_associatedSpeedUnit = speedUnit;
        this.m_oneMeter = d;
        this.m_pbOdometerUnit = odometerUnit;
    }

    public String m5470a() {
        return this.m_displaySuffix;
    }

    public double m5469a(long j) {
        return ((double) j) / this.m_oneMeter;
    }

    public double m5471b(long j) {
        return ((double) j) * this.m_oneMeter;
    }

    public double m5468a(double d) {
        return this.m_oneMeter * d;
    }

    public String m5473c(long j) {
        return Long.toString(Math.round(m5471b(j))) + " " + this.m_displaySuffix;
    }

    public String m5474d(long j) {
        return new BigDecimal(m5471b(j)).setScale(1, RoundingMode.CEILING).toString() + " " + this.m_displaySuffix;
    }

    public static CanonicalOdometerUnit m5467a(Truck truck) {
        CanonicalOdometerUnit a = m5466a(af.m4151a(truck));
        return a == null ? MILES : a;
    }

    public OdometerUnit m5472b() {
        return this.m_pbOdometerUnit;
    }

    public static CanonicalOdometerUnit m5466a(OdometerUnit odometerUnit) {
        if (odometerUnit == null) {
            return null;
        }
        switch (odometerUnit) {
            case KM:
                return KM;
            case MILES:
                return MILES;
            case UNKNOWN_UNIT:
                return null;
            default:
                throw new IllegalArgumentException("There is no canonical odometer unit for " + odometerUnit);
        }
    }
}
