package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.Api.zzg;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;

public class zzah<T extends IInterface> extends zzk<T> {
    private final zzg<T> f10722c;

    public zzah(Context context, Looper looper, int i, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener, zzg com_google_android_gms_common_internal_zzg, zzg<T> com_google_android_gms_common_api_Api_zzg_T) {
        super(context, looper, i, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
        this.f10722c = com_google_android_gms_common_api_Api_zzg_T;
    }

    protected String mo1672a() {
        return this.f10722c.zzra();
    }

    protected void mo1673a(int i, T t) {
        this.f10722c.zza(i, t);
    }

    public zzg<T> zzatn() {
        return this.f10722c;
    }

    protected T zzbb(IBinder iBinder) {
        return this.f10722c.zzbb(iBinder);
    }

    protected String zzqz() {
        return this.f10722c.zzqz();
    }
}
