package com.bigroad.shared.validation.model;

import com.bigroad.shared.validation.C0887n;
import java.util.List;

public interface Dvir extends C0887n<Field> {

    public enum Field {
        NONE,
        CARRIER_NAME,
        INSPECTOR_NAME
    }

    byte[] mo851a();

    int mo852b();

    String mo853c();

    String mo854d();

    List<? extends DvirInspection> mo855e();

    boolean mo856f();
}
