package com.bigroad.shared.eobr.turbo.messages;

public class af extends al {
    public final DataRegister f3404a;
    public final byte[] f3405b;

    public af(int i, DataRegister dataRegister, byte[] bArr) {
        super(i);
        if (bArr.length > 64) {
            throw new IllegalArgumentException("data too long");
        }
        this.f3404a = dataRegister;
        this.f3405b = bArr;
    }
}
