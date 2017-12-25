package com.bigroad.shared.model;

import com.bigroad.ttb.protocol.TTProtocol.RecapType;

public enum CanonicalRecapType {
    NO_RECAP("common.recapType.none", RecapType.NO_RECAP),
    SUMMARY("common.recapType.summary", RecapType.SUMMARY),
    FULL("common.recapType.full", RecapType.FULL);
    
    private final String m_displayNameResourceId;
    private final RecapType m_pbRecapType;

    private CanonicalRecapType(String str, RecapType recapType) {
        this.m_displayNameResourceId = str;
        this.m_pbRecapType = recapType;
    }

    public RecapType m5476a() {
        return this.m_pbRecapType;
    }

    public static CanonicalRecapType m5475a(RecapType recapType) {
        for (CanonicalRecapType canonicalRecapType : values()) {
            if (canonicalRecapType.m5476a() == recapType) {
                return canonicalRecapType;
            }
        }
        throw new IllegalArgumentException("There is no canonical recap type for " + recapType);
    }
}
