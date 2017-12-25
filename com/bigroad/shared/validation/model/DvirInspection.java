package com.bigroad.shared.validation.model;

import com.bigroad.shared.validation.C0887n;

public interface DvirInspection extends C0887n<Field> {

    public enum Field {
        NONE,
        VEHICLE_NUMBER,
        VEHICLE_LICENSE,
        ODOMETER,
        LOCATION_NAME,
        REMARKS
    }

    byte[] mo844a();

    int mo845b();

    String mo846c();

    Integer mo847d();

    String mo848e();

    boolean mo849f();

    String mo850g();
}
