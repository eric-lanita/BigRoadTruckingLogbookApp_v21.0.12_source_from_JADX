package com.bigroad.ttb.android.location;

import com.bigroad.shared.C1147v;
import com.bigroad.ttb.protocol.TTProtocol.LatLon;

public class ApproximateLocation extends Location {
    public ApproximateLocation(int i, int i2) {
        super(C1147v.m5772a(i), C1147v.m5772a(i2), null);
    }

    public ApproximateLocation(LatLon latLon) {
        this(latLon.getLatitudeE6(), latLon.getLongitudeE6());
    }
}
