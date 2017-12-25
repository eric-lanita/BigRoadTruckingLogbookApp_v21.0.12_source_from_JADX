package com.bigroad.shared.validation.model;

import com.bigroad.shared.duty.C0871l;
import com.bigroad.shared.validation.C0887n;

public interface Event extends C0871l, C0887n<Field> {

    public enum Field {
        NONE,
        LOCATION_NAME,
        EVENT_NOTE
    }

    byte[] mo719s();

    String mo724t();

    String mo725u();

    boolean mo720v();

    boolean mo726y();
}
