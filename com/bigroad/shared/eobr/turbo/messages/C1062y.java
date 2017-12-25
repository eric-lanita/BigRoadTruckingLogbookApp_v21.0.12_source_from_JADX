package com.bigroad.shared.eobr.turbo.messages;

import com.bigroad.shared.eobr.turbo.ManufacturingEvent;
import com.bigroad.shared.eobr.turbo.messages.TurboSignedRequestMessage.MessageSigner;

public class C1062y extends TurboSignedRequestMessage {
    public final ManufacturingEvent f3472a;
    public final long f3473b;
    public final String f3474c;
    public final byte[] f3475d;

    public C1062y(int i, MessageSigner messageSigner, byte[] bArr, ManufacturingEvent manufacturingEvent, long j, String str, byte[] bArr2) {
        super(i, messageSigner, bArr);
        this.f3472a = manufacturingEvent;
        this.f3473b = j;
        this.f3474c = str;
        this.f3475d = bArr2;
    }
}
