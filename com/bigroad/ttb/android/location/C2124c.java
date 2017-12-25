package com.bigroad.ttb.android.location;

import android.location.Location;
import com.bigroad.ttb.android.util.C2123x;

public class C2124c extends C2123x<Location> {
    public C2124c(int i, long j, long j2) {
        super(i, j, j2);
    }

    public void m10641a(Location location) {
        super.m10633a(location, location.getTime());
    }
}
