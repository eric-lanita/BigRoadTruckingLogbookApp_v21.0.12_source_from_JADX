package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public class FirmwareUpdateRequestMessage extends al {
    public final FirmwareUpdateRequest f3299a;
    public final byte[] f3300b;

    public enum FirmwareUpdateRequest implements C1000c {
        FIRMWARE_UPDATE_REQUEST_START(0),
        FIRMWARE_UPDATE_REQUEST_WRITE(1),
        FIRMWARE_UPDATE_REQUEST_END(2),
        FIRMWARE_UPDATE_REQUEST_REFLASH(3),
        FIRMWARE_UPDATE_REQUEST_UNKNOWN(4);
        
        private final int m_id;

        private FirmwareUpdateRequest(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == FIRMWARE_UPDATE_REQUEST_UNKNOWN;
        }
    }

    public FirmwareUpdateRequestMessage(int i, FirmwareUpdateRequest firmwareUpdateRequest, byte[] bArr) {
        super(i);
        this.f3299a = firmwareUpdateRequest;
        this.f3300b = bArr;
    }
}
