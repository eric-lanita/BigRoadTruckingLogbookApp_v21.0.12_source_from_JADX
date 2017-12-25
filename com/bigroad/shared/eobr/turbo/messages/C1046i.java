package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;

public class C1046i extends TurboResponseMessage {
    public final DataRegister f3435a;
    public final byte[] f3436b;

    public C1046i(int i, TurboResponse turboResponse, DataRegister dataRegister, byte[] bArr) {
        super(i, turboResponse);
        if (bArr.length > 64) {
            throw new IllegalArgumentException("data too long");
        }
        this.f3435a = dataRegister;
        this.f3436b = bArr;
    }
}
