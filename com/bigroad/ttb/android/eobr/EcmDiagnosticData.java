package com.bigroad.ttb.android.eobr;

public class EcmDiagnosticData implements Comparable<EcmDiagnosticData> {
    private final Protocol f6324a;
    private final byte f6325b;
    private final int f6326c;
    private final int f6327d;

    public enum Protocol {
        J1587,
        J1939,
        OBD2
    }

    public /* synthetic */ int compareTo(Object obj) {
        return m8954a((EcmDiagnosticData) obj);
    }

    private EcmDiagnosticData(Protocol protocol, byte b, int i, int i2) {
        this.f6324a = protocol;
        this.f6325b = b;
        this.f6326c = i;
        this.f6327d = i2;
    }

    public static EcmDiagnosticData m8951a(byte b, int i, int i2) {
        return new EcmDiagnosticData(Protocol.J1587, b, i, i2);
    }

    public static EcmDiagnosticData m8952b(byte b, int i, int i2) {
        return new EcmDiagnosticData(Protocol.J1939, b, i, i2);
    }

    public static EcmDiagnosticData m8953c(byte b, int i, int i2) {
        return new EcmDiagnosticData(Protocol.OBD2, b, i, i2);
    }

    public int m8954a(EcmDiagnosticData ecmDiagnosticData) {
        if (this.f6327d == ecmDiagnosticData.f6327d) {
            return 0;
        }
        return this.f6327d < ecmDiagnosticData.f6327d ? -1 : 1;
    }

    public String toString() {
        String str = "%s value; %s=" + this.f6325b + "; %s=" + this.f6326c + "; DATA=" + this.f6327d;
        switch (this.f6324a) {
            case J1587:
                return String.format(str, new Object[]{"J1587", "MID", "PID"});
            case J1939:
                return String.format(str, new Object[]{"J1939", "SRC", "PGN"});
            case OBD2:
                return String.format(str, new Object[]{"OBD2", "SRC", "MODE/PID"});
            default:
                return String.format(str, new Object[]{"m_protocol = " + this.f6324a + ",", "m_src", "m_paramId", "m_data"});
        }
    }
}
