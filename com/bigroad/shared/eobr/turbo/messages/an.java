package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.messages.TurboResponseMessage.TurboResponse;

public class an extends TurboResponseMessage {
    public final String f3412a;

    public an(int i, TurboResponse turboResponse, String str) {
        super(i, turboResponse);
        this.f3412a = str;
    }
}
