package com.urbanairship.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.urbanairship.C3783j;
import com.urbanairship.C3790k;
import com.urbanairship.util.C3954i;
import java.util.List;

class C3814e implements C3806b {
    private final LocationManager f13631a;

    private static class C3810a implements LocationListener {
        private C3810a() {
        }

        public void onLocationChanged(Location location) {
        }

        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        public void onProviderEnabled(String str) {
        }

        public void onProviderDisabled(String str) {
        }
    }

    private class C3813b extends C3790k<Location> {
        final /* synthetic */ C3814e f13625a;
        private final Criteria f13626b;
        private final LocationRequestOptions f13627c;
        private String f13628d = null;
        private final C3810a f13629e;
        private final C3810a f13630f;

        C3813b(final C3814e c3814e, C3799c c3799c, final LocationRequestOptions locationRequestOptions) {
            this.f13625a = c3814e;
            super(c3799c);
            this.f13627c = locationRequestOptions;
            this.f13626b = c3814e.m19879a(locationRequestOptions);
            this.f13629e = new C3810a(this) {
                final /* synthetic */ C3813b f13621b;

                public void onLocationChanged(Location location) {
                    this.f13621b.m19877g();
                    this.f13621b.m19788a(location);
                }

                public void onProviderDisabled(String str) {
                    C3783j.m19723b("StandardLocationAdapter - Provider disabled: " + str);
                    synchronized (this) {
                        if (!this.f13621b.mo2788b()) {
                            this.f13621b.m19875e();
                        }
                    }
                }
            };
            this.f13630f = new C3810a(this) {
                final /* synthetic */ C3813b f13624c;

                public void onProviderEnabled(String str) {
                    C3783j.m19723b("StandardLocationAdapter - Provider enabled: " + str);
                    synchronized (this) {
                        if (!this.f13624c.mo2788b()) {
                            String a = this.f13624c.f13625a.m19882a(this.f13624c.f13626b, locationRequestOptions);
                            if (!(a == null || a.equals(this.f13624c.f13628d))) {
                                this.f13624c.m19875e();
                            }
                        }
                    }
                }
            };
            if (locationRequestOptions.m19832a() != 4) {
                m19876f();
            }
            m19875e();
        }

        private void m19875e() {
            if (this.f13628d != null) {
                this.f13625a.f13631a.removeUpdates(this.f13629e);
            }
            String a = this.f13625a.m19882a(this.f13626b, this.f13627c);
            this.f13628d = a;
            if (a != null) {
                C3783j.m19723b("StandardLocationAdapter - Single request using provider: " + a);
                this.f13625a.f13631a.requestLocationUpdates(a, 0, 0.0f, this.f13629e);
            }
        }

        private void m19876f() {
            List<String> providers = this.f13625a.f13631a.getProviders(this.f13626b, false);
            if (providers != null) {
                for (String str : providers) {
                    C3783j.m19723b("StandardLocationAdapter - Single location request listening provider enable/disabled for: " + str);
                    this.f13625a.f13631a.requestLocationUpdates(str, Long.MAX_VALUE, Float.MAX_VALUE, this.f13630f);
                }
            }
        }

        protected void mo2792c() {
            C3783j.m19723b("StandardLocationAdapter - Canceling single request.");
            m19877g();
        }

        private void m19877g() {
            this.f13625a.f13631a.removeUpdates(this.f13629e);
            this.f13625a.f13631a.removeUpdates(this.f13630f);
        }
    }

    C3814e(Context context) {
        this.f13631a = (LocationManager) context.getSystemService("location");
    }

    public void mo2795a(LocationRequestOptions locationRequestOptions, PendingIntent pendingIntent) {
        Criteria a = m19879a(locationRequestOptions);
        List<String> providers = this.f13631a.getProviders(a, false);
        if (providers != null) {
            for (String str : providers) {
                C3783j.m19723b("StandardLocationAdapter - Update listening provider enable/disabled for: " + str);
                this.f13631a.requestLocationUpdates(str, Long.MAX_VALUE, Float.MAX_VALUE, pendingIntent);
            }
        }
        String str2 = m19882a(a, locationRequestOptions);
        if (!C3954i.m20512a(str2)) {
            C3783j.m19723b("StandardLocationAdapter - Requesting location updates from provider: " + str2);
            this.f13631a.requestLocationUpdates(str2, locationRequestOptions.m19833b(), locationRequestOptions.m19834c(), pendingIntent);
        }
    }

    public boolean mo2796a() {
        return true;
    }

    public void mo2797b() {
    }

    public void mo2794a(PendingIntent pendingIntent) {
        C3783j.m19723b("StandardLocationAdapter - Canceling location updates.");
        this.f13631a.removeUpdates(pendingIntent);
    }

    public C3790k<Location> mo2793a(C3799c c3799c, LocationRequestOptions locationRequestOptions) {
        return new C3813b(this, c3799c, locationRequestOptions);
    }

    private Criteria m19879a(LocationRequestOptions locationRequestOptions) {
        Criteria criteria = new Criteria();
        switch (locationRequestOptions.m19832a()) {
            case 1:
                criteria.setAccuracy(1);
                criteria.setPowerRequirement(3);
                break;
            case 2:
                criteria.setAccuracy(2);
                criteria.setPowerRequirement(2);
                break;
            case 3:
            case 4:
                criteria.setAccuracy(0);
                criteria.setPowerRequirement(1);
                break;
        }
        return criteria;
    }

    private String m19882a(Criteria criteria, LocationRequestOptions locationRequestOptions) {
        if (locationRequestOptions.m19832a() != 4) {
            return this.f13631a.getBestProvider(criteria, true);
        }
        List providers = this.f13631a.getProviders(criteria, true);
        if (providers != null && providers.contains("passive")) {
            return "passive";
        }
        return null;
    }
}
