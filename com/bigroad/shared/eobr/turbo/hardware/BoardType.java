package com.bigroad.shared.eobr.turbo.hardware;

import com.bigroad.shared.eobr.turbo.C1000c;
import com.facebook.internal.AnalyticsEvents;

public enum BoardType implements C1000c {
    BOARD_TYPE_UNKNOWN(0, AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN),
    BOARD_TYPE_V1_1(1, "DL-100"),
    BOARD_TYPE_V1_2(2, "DL-100"),
    BOARD_TYPE_V2_0(3, "DL-200");
    
    private final int m_id;
    private final String m_modelName;

    private BoardType(int i, String str) {
        this.m_id = i;
        this.m_modelName = str;
    }

    public int mo760a() {
        return this.m_id;
    }

    public boolean mo761b() {
        return this == BOARD_TYPE_UNKNOWN;
    }

    public String m5200c() {
        return this.m_modelName;
    }
}
