package com.google.protobuf;

public interface C2487l extends C2481m {

    public interface C2482a extends C2481m, Cloneable {
        C2482a mo1359b(byte[] bArr);

        C2482a mo1360c(C3643d c3643d, C3645e c3645e);

        C2487l mo1366i();

        C2487l mo1368j();
    }

    C2478n<? extends C2487l> getParserForType();

    int getSerializedSize();

    C2482a newBuilderForType();

    C2482a toBuilder();

    byte[] toByteArray();

    void writeTo(CodedOutputStream codedOutputStream);
}
