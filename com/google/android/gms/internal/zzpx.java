package com.google.android.gms.internal;

import android.os.Bundle;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.internal.zzpm.zza;
import java.util.Collections;

public class zzpx implements zzpz {
    private final zzqa f11544a;

    public zzpx(zzqa com_google_android_gms_internal_zzqa) {
        this.f11544a = com_google_android_gms_internal_zzqa;
    }

    public void begin() {
        this.f11544a.m17462c();
        this.f11544a.f11588g.f11560d = Collections.emptySet();
    }

    public void connect() {
        this.f11544a.m17457a();
    }

    public boolean disconnect() {
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(T t) {
        this.f11544a.f11588g.f11557a.add(t);
        return t;
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(T t) {
        throw new IllegalStateException("GoogleApiClient is not connected yet.");
    }
}
