package com.bigroad.ttb.android.eobr.vna;

import com.bigroad.shared.eobr.turbo.logs.MultiOdometerLogEntry.OdometerSource;
import com.bigroad.shared.eobr.turbo.messages.SpeedometerMessage.SpeedometerSource;

public abstract class C2005h {
    public static boolean m9927a(SpeedometerSource speedometerSource) {
        return (speedometerSource == null || speedometerSource == SpeedometerSource.SPEEDOMETER_SOURCE_NONE || speedometerSource == SpeedometerSource.SPEEDOMETER_SOURCE_UNKNOWN) ? false : true;
    }

    public static boolean m9926a(OdometerSource odometerSource) {
        return (odometerSource == null || odometerSource == OdometerSource.ODOMETER_SOURCE_UNKNOWN) ? false : true;
    }
}
