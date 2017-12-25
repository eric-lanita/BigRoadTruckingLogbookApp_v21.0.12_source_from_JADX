package com.urbanairship.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.GoogleApiClient.Builder;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.urbanairship.C3783j;
import com.urbanairship.C3790k;
import java.util.concurrent.Semaphore;

class C3807a implements C3806b {
    private final Context f13618a;
    private GoogleApiClient f13619b;

    private class C3805a extends C3790k<Location> {
        final /* synthetic */ C3807a f13615a;
        private final LocationRequest f13616b;
        private final LocationListener f13617c;

        C3805a(final C3807a c3807a, C3799c c3799c, LocationRequestOptions locationRequestOptions) {
            this.f13615a = c3807a;
            super(c3799c);
            this.f13616b = c3807a.m19863a(locationRequestOptions);
            this.f13616b.setNumUpdates(1);
            this.f13617c = new LocationListener(this) {
                final /* synthetic */ C3805a f13614b;
            };
            C3783j.m19723b("FusedLocationAdapter - Starting single location request.");
            LocationServices.FusedLocationApi.requestLocationUpdates(c3807a.f13619b, this.f13616b, this.f13617c, Looper.myLooper());
        }

        protected void mo2792c() {
            C3783j.m19723b("FusedLocationAdapter - Canceling single location request.");
            LocationServices.FusedLocationApi.removeLocationUpdates(this.f13615a.f13619b, this.f13617c);
        }
    }

    C3807a(Context context) {
        this.f13618a = context;
    }

    public C3790k<Location> mo2793a(C3799c c3799c, LocationRequestOptions locationRequestOptions) {
        if (this.f13619b != null && this.f13619b.isConnected()) {
            return new C3805a(this, c3799c, locationRequestOptions);
        }
        C3783j.m19725c("FusedLocationAdapter - Adapter is not connected. Unable to request single location.");
        return null;
    }

    public void mo2794a(PendingIntent pendingIntent) {
        if (this.f13619b == null || !this.f13619b.isConnected()) {
            C3783j.m19725c("FusedLocationAdapter - Adapter is not connected. Unable to cancel location updates.");
            return;
        }
        C3783j.m19723b("FusedLocationAdapter - Canceling updates.");
        LocationServices.FusedLocationApi.removeLocationUpdates(this.f13619b, pendingIntent);
    }

    public void mo2795a(LocationRequestOptions locationRequestOptions, PendingIntent pendingIntent) {
        if (this.f13619b == null || !this.f13619b.isConnected()) {
            C3783j.m19725c("FusedLocationAdapter - Adapter is not connected. Unable to request location updates.");
            return;
        }
        C3783j.m19723b("FusedLocationAdapter - Requesting updates.");
        LocationServices.FusedLocationApi.requestLocationUpdates(this.f13619b, m19863a(locationRequestOptions), pendingIntent);
    }

    public boolean mo2796a() {
        final Semaphore semaphore = new Semaphore(0);
        try {
            if (GooglePlayServicesUtil.isGooglePlayServicesAvailable(this.f13618a) != 0) {
                C3783j.m19725c("FusedLocationAdapter - Google Play services is currently unavailable, unable to connect for fused location.");
                return false;
            }
            this.f13619b = new Builder(this.f13618a).addApi(LocationServices.API).addConnectionCallbacks(new ConnectionCallbacks(this) {
                final /* synthetic */ C3807a f13612b;

                public void onConnected(Bundle bundle) {
                    C3783j.m19723b("FusedLocationAdapter - Google Play services connected for fused location.");
                    semaphore.release();
                }

                public void onConnectionSuspended(int i) {
                    C3783j.m19723b("FusedLocationAdapter - Google Play services connection suspended for fused location.");
                }
            }).addOnConnectionFailedListener(new OnConnectionFailedListener(this) {
                final /* synthetic */ C3807a f13610b;

                public void onConnectionFailed(ConnectionResult connectionResult) {
                    C3783j.m19723b("FusedLocationAdapter - Google Play services failed to connect for fused location.");
                    semaphore.release();
                }
            }).build();
            this.f13619b.connect();
            try {
                semaphore.acquire();
                return this.f13619b.isConnected();
            } catch (Throwable e) {
                C3783j.m19726c("FusedLocationAdapter - Exception while connecting to fused location", e);
                mo2797b();
                return false;
            }
        } catch (IllegalStateException e2) {
            C3783j.m19725c("FusedLocationAdapter - Google Play services is currently unavailable, unable to connect for fused location. " + e2.getMessage());
            return false;
        }
    }

    public void mo2797b() {
        if (this.f13619b != null && this.f13619b.isConnected()) {
            this.f13619b.disconnect();
        }
        this.f13619b = null;
    }

    private LocationRequest m19863a(LocationRequestOptions locationRequestOptions) {
        LocationRequest smallestDisplacement = LocationRequest.create().setInterval(locationRequestOptions.m19833b()).setSmallestDisplacement(locationRequestOptions.m19834c());
        switch (locationRequestOptions.m19832a()) {
            case 1:
                smallestDisplacement.setPriority(100);
                break;
            case 2:
                smallestDisplacement.setPriority(102);
                break;
            case 3:
                smallestDisplacement.setPriority(104);
                break;
            case 4:
                smallestDisplacement.setPriority(105);
                break;
        }
        return smallestDisplacement;
    }
}
