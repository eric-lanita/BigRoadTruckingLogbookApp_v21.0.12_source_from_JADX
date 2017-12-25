package com.urbanairship.location;

import android.app.PendingIntent;
import android.location.Location;
import com.urbanairship.C3790k;

interface C3806b {
    C3790k<Location> mo2793a(C3799c c3799c, LocationRequestOptions locationRequestOptions);

    void mo2794a(PendingIntent pendingIntent);

    void mo2795a(LocationRequestOptions locationRequestOptions, PendingIntent pendingIntent);

    boolean mo2796a();

    void mo2797b();
}
