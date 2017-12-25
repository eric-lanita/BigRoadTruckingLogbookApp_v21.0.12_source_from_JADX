package com.bigroad.shared.eobr;

public enum ConnectionSetupFlag {
    REQUIRED(2097152),
    SEARCHING(4194304),
    RECONNECTING(1024),
    CORRUPTED(1073741824),
    TURBO_FIRMWARE_UPDATING(536870912),
    FIRMWARE_DETECTING(17179869184L),
    FIRMWARE_INCOMPATIBLE(34359738368L),
    BACKGROUND_SEARCH_TIMEOUT(4294967296L),
    BACKGROUND_DISCONNECT_TIMEOUT(8589934592L);
    
    private final long m_dashlinkStatusBits;

    private ConnectionSetupFlag(long j) {
        this.m_dashlinkStatusBits = j;
    }

    public long m4929a() {
        return this.m_dashlinkStatusBits;
    }
}
