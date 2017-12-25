package com.bigroad.shared.eobr.turbo;

public class TurboDataUnrecognizedException extends TurboDataSerializationException {
    private static final long serialVersionUID = -3892005715686415890L;

    public TurboDataUnrecognizedException(int i) {
        super("Unknown ID 0x" + Integer.toHexString(i));
    }
}
