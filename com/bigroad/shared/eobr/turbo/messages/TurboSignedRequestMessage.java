package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.C1000c;

public abstract class TurboSignedRequestMessage extends al {
    public final MessageSigner f3357e;
    public final byte[] f3358g;

    public enum MessageSigner implements C1000c {
        SIGNER_UNKNOWN(0),
        SIGNER_SIMULATOR_V1(1);
        
        private final int m_id;

        private MessageSigner(int i) {
            this.m_id = i;
        }

        public int mo760a() {
            return this.m_id;
        }

        public boolean mo761b() {
            return this == SIGNER_UNKNOWN;
        }
    }

    public TurboSignedRequestMessage(int i, MessageSigner messageSigner, byte[] bArr) {
        super(i);
        this.f3357e = messageSigner;
        this.f3358g = bArr;
    }
}
