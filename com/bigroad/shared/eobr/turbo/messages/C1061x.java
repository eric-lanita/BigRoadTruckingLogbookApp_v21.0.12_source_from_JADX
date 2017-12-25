package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;

public class C1061x extends C1060w {
    public final int f3471c;

    public C1061x(int i, TurboResponse turboResponse, int i2, byte[] bArr, int i3) {
        super(i, turboResponse, i2, bArr);
        this.f3471c = i3;
    }
}
