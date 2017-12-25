package com.google.android.gms.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.internal.zzg;
import com.google.android.gms.common.internal.zzk;
import com.google.android.gms.internal.zzrk.zza;

public class zzri extends zzk<zzrk> {
    public zzri(Context context, Looper looper, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, 39, com_google_android_gms_common_internal_zzg, connectionCallbacks, onConnectionFailedListener);
    }

    protected zzrk m17550a(IBinder iBinder) {
        return zza.zzea(iBinder);
    }

    protected String mo1672a() {
        return "com.google.android.gms.common.internal.service.ICommonService";
    }

    protected /* synthetic */ IInterface zzbb(IBinder iBinder) {
        return m17550a(iBinder);
    }

    public String zzqz() {
        return "com.google.android.gms.common.service.START";
    }
}
