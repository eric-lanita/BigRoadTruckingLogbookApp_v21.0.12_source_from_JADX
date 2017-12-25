package com.bigroad.shared.eobr.turbo.logs;

import com.bigroad.shared.eobr.turbo.C1000c;

public class EngineHoursLogEntry extends C1017o {
    public final int[] f3194a;
    public final EngineHoursSource[] f3195b;

    public enum EngineHoursSource implements C1000c {
        ENGINE_HOURS_SOURCE_UNKNOWN(9, "UKNOWN"),
        ENGINE_HOURS_SOURCE_J1939(1, "J1939"),
        ENGINE_HOURS_SOURCE_J1587(2, "J1587"),
        ENGINE_HOURS_SOURCE_DASHLINK_FIRMWARE(3, "FW");
        
        private final int m_id;
        private final String m_shortMsg;

        private EngineHoursSource(int i, String str) {
            this.m_id = i;
            this.m_shortMsg = str;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == ENGINE_HOURS_SOURCE_UNKNOWN;
        }
    }

    public EngineHoursLogEntry(int i, int[] iArr, EngineHoursSource[] engineHoursSourceArr) {
        super(i);
        this.f3194a = iArr;
        this.f3195b = engineHoursSourceArr;
    }
}
