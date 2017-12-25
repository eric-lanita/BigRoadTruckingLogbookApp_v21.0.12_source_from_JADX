package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.eobr.turbo.C1000c;

public class MultiOdometerLogEntry extends C1017o {
    public final int[] f3234a;
    public final OdometerSource[] f3235b;

    public enum OdometerSource implements C1000c {
        ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_INSTRUMENT_CLUSTER(0, "J1939_HR_SRC23"),
        ODOMETER_SOURCE_J1939_INSTRUMENT_CLUSTER(1, "J1939_SRC23"),
        ODOMETER_SOURCE_J1587_INSTRUMENT_CLUSTER(2, "J1587_MID140"),
        ODOMETER_SOURCE_J1939_HIGH_RESOLUTION_ENGINE_1(3, "J1939_HR_SRC0"),
        ODOMETER_SOURCE_J1939_ENGINE_1(4, "J1939_SRC0"),
        ODOMETER_SOURCE_J1587_ENGINE_1(5, "J1587_MID128"),
        ODOMETER_SOURCE_J1587_VEHICLE_MANAGEMENT_SYSTEM(6, "J1587_MID142"),
        ODOMETER_SOURCE_J1939_HINO(7, "J1939_HINO"),
        ODOMETER_SOURCE_DASHLINK_FIRMWARE(8, "FW"),
        ODOMETER_SOURCE_UNKNOWN(9, "UKNOWN"),
        ODOMETER_SOURCE_GENX_FW(10, "GENX_FW"),
        ODOMETER_SOURCE_GENX_ECM(11, "GENX_ECM");
        
        private final int m_id;
        private final String m_shortMsg;

        private OdometerSource(int i, String str) {
            this.m_id = i;
            this.m_shortMsg = str;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == ODOMETER_SOURCE_UNKNOWN;
        }
    }

    public MultiOdometerLogEntry(int i, int[] iArr, OdometerSource[] odometerSourceArr) {
        super(i);
        this.f3234a = iArr;
        this.f3235b = odometerSourceArr;
    }
}
