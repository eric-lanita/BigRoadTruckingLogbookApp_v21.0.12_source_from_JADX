package com.bigroad.shared.model;

import com.bigroad.ttb.protocol.TTProtocol.OdometerOffsets.C2710a;
import com.bigroad.ttb.protocol.TTProtocol.OdometerSource;
import com.bigroad.ttb.protocol.TTProtocol.cn;

public enum CanonicalOdometerSource {
    J1939_HR_SRC23(true),
    J1939_SRC23(true),
    J1587_MID140(true),
    J1939_HR_SRC0(true),
    J1939_SRC0(true),
    J1587_MID128(true),
    J1587_MID142(true),
    J1939_HINO_ODOMETER(true),
    DASHLINK_FIRMWARE(true),
    GENX_ECM(false),
    GENX_FW(false);
    
    public static final int f3603l = 0;
    private boolean m_requiresCalibration;

    static {
        f3603l = values().length;
    }

    private CanonicalOdometerSource(boolean z) {
        this.m_requiresCalibration = z;
    }

    public boolean m5465a() {
        return this.m_requiresCalibration;
    }

    public static boolean m5463a(cn cnVar, CanonicalOdometerSource canonicalOdometerSource) {
        switch (canonicalOdometerSource) {
            case J1587_MID142:
                return cnVar.hasJ1587Mid142Offset();
            case J1587_MID140:
                return cnVar.hasJ1587Mid140Offset();
            case J1587_MID128:
                return cnVar.hasJ1587Mid128Offset();
            case J1939_HR_SRC0:
                return cnVar.hasJ1939HrSrc0Offset();
            case J1939_HR_SRC23:
                return cnVar.hasJ1939HrSrc23Offset();
            case J1939_SRC0:
                return cnVar.hasJ1939Src0Offset();
            case J1939_SRC23:
                return cnVar.hasJ1939Src23Offset();
            case J1939_HINO_ODOMETER:
                return cnVar.hasJ1939HinoOdometerOffset();
            case DASHLINK_FIRMWARE:
                return cnVar.hasDashlinkFirmwareOffset();
            case GENX_ECM:
            case GENX_FW:
                return false;
            default:
                throw new IllegalArgumentException("Unrecognized OdometerSource: " + canonicalOdometerSource);
        }
    }

    public static boolean m5462a(cn cnVar) {
        if (cnVar == null) {
            return false;
        }
        for (CanonicalOdometerSource a : values()) {
            if (m5463a(cnVar, a)) {
                return true;
            }
        }
        return false;
    }

    public static int m5464b(cn cnVar, CanonicalOdometerSource canonicalOdometerSource) {
        switch (canonicalOdometerSource) {
            case J1587_MID142:
                return cnVar.getJ1587Mid142Offset();
            case J1587_MID140:
                return cnVar.getJ1587Mid140Offset();
            case J1587_MID128:
                return cnVar.getJ1587Mid128Offset();
            case J1939_HR_SRC0:
                return cnVar.getJ1939HrSrc0Offset();
            case J1939_HR_SRC23:
                return cnVar.getJ1939HrSrc23Offset();
            case J1939_SRC0:
                return cnVar.getJ1939Src0Offset();
            case J1939_SRC23:
                return cnVar.getJ1939Src23Offset();
            case J1939_HINO_ODOMETER:
                return cnVar.getJ1939HinoOdometerOffset();
            case DASHLINK_FIRMWARE:
                return cnVar.getDashlinkFirmwareOffset();
            case GENX_ECM:
            case GENX_FW:
                return 0;
            default:
                throw new IllegalArgumentException("Unrecognized CanonicalOdometerSource: " + canonicalOdometerSource);
        }
    }

    public static C2710a m5460a(C2710a c2710a, CanonicalOdometerSource canonicalOdometerSource, int i) {
        switch (canonicalOdometerSource) {
            case J1587_MID142:
                return c2710a.m14600g(i);
            case J1587_MID140:
                return c2710a.m14597e(i);
            case J1587_MID128:
                return c2710a.m14598f(i);
            case J1939_HR_SRC0:
                return c2710a.m14590b(i);
            case J1939_HR_SRC23:
                return c2710a.m14595d(i);
            case J1939_SRC0:
                return c2710a.m14586a(i);
            case J1939_SRC23:
                return c2710a.m14592c(i);
            case J1939_HINO_ODOMETER:
                return c2710a.m14604i(i);
            case DASHLINK_FIRMWARE:
                return c2710a.m14602h(i);
            case GENX_ECM:
            case GENX_FW:
                return c2710a;
            default:
                throw new IllegalArgumentException("Unrecognized CanonicalOdometerSource: " + canonicalOdometerSource);
        }
    }

    public static C2710a m5461a(C2710a c2710a, CanonicalOdometerSource canonicalOdometerSource, long j, long j2) {
        long j3 = j - j2;
        return m5460a(c2710a, canonicalOdometerSource, (int) ((j3 + ((long) (Long.signum(j3) * 4))) / 5));
    }

    public static long m5458a(cn cnVar, CanonicalOdometerSource canonicalOdometerSource, long j) {
        return (5 * ((long) m5464b(cnVar, canonicalOdometerSource))) + j;
    }

    public static CanonicalOdometerSource m5459a(OdometerSource odometerSource) {
        switch (odometerSource) {
            case J1587_MID142:
                return J1587_MID142;
            case J1587_MID140:
                return J1587_MID140;
            case J1587_MID128:
                return J1587_MID128;
            case J1939_HR_SRC0:
                return J1939_HR_SRC0;
            case J1939_HR_SRC23:
                return J1939_HR_SRC23;
            case J1939_SRC0:
                return J1939_SRC0;
            case J1939_SRC23:
                return J1939_SRC23;
            case J1939_HINO_ODOMETER:
                return J1939_HINO_ODOMETER;
            case DASHLINK_FIRMWARE:
                return DASHLINK_FIRMWARE;
            case GENX_ECM:
                return GENX_ECM;
            case GENX_FW:
                return GENX_FW;
            default:
                throw new IllegalArgumentException("Unrecognized OdometerSource: " + odometerSource);
        }
    }
}
