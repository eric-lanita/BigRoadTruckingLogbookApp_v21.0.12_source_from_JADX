package com.google.protobuf;

import java.util.List;

public class UninitializedMessageException extends RuntimeException {
    private static final long serialVersionUID = -7466929953374883507L;
    private final List<String> missingFields = null;

    public UninitializedMessageException(C2487l c2487l) {
        super("Message was missing required fields.  (Lite runtime could not determine which fields were missing).");
    }

    public InvalidProtocolBufferException m19063a() {
        return new InvalidProtocolBufferException(getMessage());
    }
}
