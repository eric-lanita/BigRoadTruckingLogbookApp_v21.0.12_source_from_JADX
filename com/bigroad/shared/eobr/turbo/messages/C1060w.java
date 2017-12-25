package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;

public class C1060w extends TurboResponseMessage {
    public final int f3469a;
    public final byte[] f3470b;

    public C1060w(int i, TurboResponse turboResponse, int i2, byte[] bArr) {
        super(i, turboResponse);
        this.f3469a = i2;
        this.f3470b = bArr;
    }
}
