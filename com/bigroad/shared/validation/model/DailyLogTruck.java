package com.bigroad.shared.validation.model;

import com.bigroad.shared.C0906x;
import com.bigroad.shared.model.C1106h;
import com.bigroad.shared.validation.C0887n;

public interface DailyLogTruck extends C1106h, C0887n<Field>, C0906x {

    public enum Field {
        NONE,
        START_ODOMETER,
        END_ODOMETER,
        TOTAL_DISTANCE
    }

    String mo823b();
}
