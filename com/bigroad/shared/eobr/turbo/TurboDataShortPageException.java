package com.bigroad.shared.eobr.turbo;

public class TurboDataShortPageException extends TurboDataSerializationException {
    private static final long serialVersionUID = -6048560039001666544L;

    public TurboDataShortPageException() {
        super("Short page");
    }
}
