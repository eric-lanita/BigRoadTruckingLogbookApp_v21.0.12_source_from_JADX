package com.urbanairship.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import com.urbanairship.C3783j;
import com.urbanairship.C3790k;
import com.urbanairship.google.C3780c;
import java.util.ArrayList;
import java.util.List;

class C3821g {
    private final List<C3806b> f13650a = new ArrayList();
    private C3806b f13651b;
    private boolean f13652c = false;

    public C3821g(Context context) {
        if (C3780c.m19709b(context) && C3780c.m19710c()) {
            this.f13650a.add(new C3807a(context));
        }
        this.f13650a.add(new C3814e(context));
    }

    public void m19915a(PendingIntent pendingIntent) {
        C3783j.m19723b("UALocationProvider - Canceling location requests.");
        for (C3806b c3806b : this.f13650a) {
            C3783j.m19723b("UALocationProvider - Canceling location requests for adapter: " + c3806b);
            if (c3806b == this.f13651b || c3806b.mo2796a()) {
                try {
                    c3806b.mo2794a(pendingIntent);
                } catch (Exception e) {
                    C3783j.m19723b("Unable to cancel location updates: " + e.getMessage());
                }
            }
            if (c3806b != this.f13651b) {
                c3806b.mo2797b();
            }
        }
    }

    public void m19916a(LocationRequestOptions locationRequestOptions, PendingIntent pendingIntent) {
        if (!this.f13652c) {
            throw new IllegalStateException("Provider must be connected before making requests.");
        } else if (this.f13651b == null) {
            C3783j.m19725c("UALocationProvider - Ignoring request, connected adapter unavailable.");
        } else {
            C3783j.m19723b("UALocationProvider - Requesting location updates: " + locationRequestOptions);
            try {
                this.f13651b.mo2795a(locationRequestOptions, pendingIntent);
            } catch (Exception e) {
                C3783j.m19728e("Unable to request location updates: " + e.getMessage());
            }
        }
    }

    public C3790k<Location> m19913a(C3799c c3799c, LocationRequestOptions locationRequestOptions) {
        C3790k<Location> c3790k = null;
        if (this.f13652c) {
            if (this.f13651b == null) {
                C3783j.m19725c("UALocationProvider - Ignoring request, connected adapter unavailable.");
            } else {
                C3783j.m19723b("UALocationProvider - Requesting single location update: " + locationRequestOptions);
                try {
                    c3790k = this.f13651b.mo2793a(c3799c, locationRequestOptions);
                } catch (Exception e) {
                    C3783j.m19728e("Unable to request location: " + e.getMessage());
                }
            }
            return c3790k;
        }
        throw new IllegalStateException("Provider must be connected before making requests.");
    }

    public void m19914a() {
        if (!this.f13652c) {
            for (C3806b c3806b : this.f13650a) {
                C3783j.m19723b("UALocationProvider - Attempting to connect to location adapter: " + c3806b);
                if (c3806b.mo2796a()) {
                    C3783j.m19723b("UALocationProvider - Connected to location adapter: " + c3806b);
                    this.f13651b = c3806b;
                    break;
                }
                C3783j.m19723b("UALocationProvider - Failed to connect to location adapter: " + c3806b);
            }
            this.f13652c = true;
        }
    }

    public void m19917b() {
        if (this.f13652c) {
            C3783j.m19723b("UALocationProvider - Disconnecting from location provider.");
            if (this.f13651b != null) {
                this.f13651b.mo2797b();
                this.f13651b = null;
            }
            this.f13652c = false;
        }
    }
}
