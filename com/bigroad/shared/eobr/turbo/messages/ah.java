package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;

public class ah extends TurboResponseMessage {
    public final int f3408a;
    public final byte[] f3409b;

    public ah(int i, TurboResponse turboResponse, int i2, byte[] bArr) {
        super(i, turboResponse);
        this.f3408a = i2;
        this.f3409b = bArr;
    }
}
