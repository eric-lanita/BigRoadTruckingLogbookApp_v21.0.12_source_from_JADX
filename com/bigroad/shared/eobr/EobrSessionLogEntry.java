package com.bigroad.shared.eobr;

public interface EobrSessionLogEntry {

    public enum SessionState {
        UNKNOWN,
        START,
        STATUS,
        END
    }

    byte[] mo751e();

    long mo752f();

    long mo753g();

    int mo754h();

    int mo755i();

    SessionState mo756j();
}
