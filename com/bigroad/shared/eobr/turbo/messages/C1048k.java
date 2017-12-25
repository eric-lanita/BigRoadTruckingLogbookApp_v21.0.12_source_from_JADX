package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;

public class C1048k extends TurboResponseMessage {
    public final ValueRegister f3438a;
    public final long f3439b;

    public C1048k(int i, TurboResponse turboResponse, ValueRegister valueRegister, long j) {
        super(i, turboResponse);
        this.f3438a = valueRegister;
        this.f3439b = j;
    }
}
