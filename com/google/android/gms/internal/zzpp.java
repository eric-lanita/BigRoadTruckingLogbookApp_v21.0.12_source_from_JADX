package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzab;

public class zzpp implements ConnectionCallbacks, OnConnectionFailedListener {
    private final int f11477a;
    private zzqa f11478b;
    public final Api<?> pN;

    public zzpp(Api<?> api, int i) {
        this.pN = api;
        this.f11477a = i;
    }

    private void m17376a() {
        zzab.zzb(this.f11478b, (Object) "Callbacks must be attached to a GoogleApiClient instance before connecting the client.");
    }

    public void onConnected(Bundle bundle) {
        m17376a();
        this.f11478b.onConnected(bundle);
    }

    public void onConnectionFailed(ConnectionResult connectionResult) {
        m17376a();
        this.f11478b.zza(connectionResult, this.pN, this.f11477a);
    }

    public void onConnectionSuspended(int i) {
        m17376a();
        this.f11478b.onConnectionSuspended(i);
    }

    public void zza(zzqa com_google_android_gms_internal_zzqa) {
        this.f11478b = com_google_android_gms_internal_zzqa;
    }
}
