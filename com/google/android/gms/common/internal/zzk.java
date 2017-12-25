package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.content.Context;
import android.os.Bundle;
import android.os.IInterface;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.Api.zze;
import com.google.android.gms.common.api.GoogleApiClient.ConnectionCallbacks;
import com.google.android.gms.common.api.GoogleApiClient.OnConnectionFailedListener;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zzd.zzb;
import com.google.android.gms.common.internal.zzd.zzc;
import com.google.android.gms.common.internal.zzl.zza;
import java.util.Set;

public abstract class zzk<T extends IInterface> extends zzd<T> implements zze, zza {
    private final zzg f10719c;
    private final Set<Scope> f10720d;
    private final Account f10721e;

    class C32271 implements zzb {
        final /* synthetic */ ConnectionCallbacks f10764a;

        C32271(ConnectionCallbacks connectionCallbacks) {
            this.f10764a = connectionCallbacks;
        }

        public void onConnected(Bundle bundle) {
            this.f10764a.onConnected(bundle);
        }

        public void onConnectionSuspended(int i) {
            this.f10764a.onConnectionSuspended(i);
        }
    }

    class C32282 implements zzc {
        final /* synthetic */ OnConnectionFailedListener f10765a;

        C32282(OnConnectionFailedListener onConnectionFailedListener) {
            this.f10765a = onConnectionFailedListener;
        }

        public void onConnectionFailed(ConnectionResult connectionResult) {
            this.f10765a.onConnectionFailed(connectionResult);
        }
    }

    protected zzk(Context context, Looper looper, int i, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        this(context, looper, zzm.zzce(context), GoogleApiAvailability.getInstance(), i, com_google_android_gms_common_internal_zzg, (ConnectionCallbacks) zzab.zzy(connectionCallbacks), (OnConnectionFailedListener) zzab.zzy(onConnectionFailedListener));
    }

    protected zzk(Context context, Looper looper, zzm com_google_android_gms_common_internal_zzm, GoogleApiAvailability googleApiAvailability, int i, zzg com_google_android_gms_common_internal_zzg, ConnectionCallbacks connectionCallbacks, OnConnectionFailedListener onConnectionFailedListener) {
        super(context, looper, com_google_android_gms_common_internal_zzm, googleApiAvailability, i, m16908a(connectionCallbacks), m16909a(onConnectionFailedListener), com_google_android_gms_common_internal_zzg.zzasn());
        this.f10719c = com_google_android_gms_common_internal_zzg;
        this.f10721e = com_google_android_gms_common_internal_zzg.getAccount();
        this.f10720d = m16910b(com_google_android_gms_common_internal_zzg.zzask());
    }

    private static zzb m16908a(ConnectionCallbacks connectionCallbacks) {
        return connectionCallbacks == null ? null : new C32271(connectionCallbacks);
    }

    private static zzc m16909a(OnConnectionFailedListener onConnectionFailedListener) {
        return onConnectionFailedListener == null ? null : new C32282(onConnectionFailedListener);
    }

    private Set<Scope> m16910b(Set<Scope> set) {
        Set<Scope> a = m16911a((Set) set);
        for (Scope contains : a) {
            if (!set.contains(contains)) {
                throw new IllegalStateException("Expanding scopes is not permitted, use implied scopes instead");
            }
        }
        return a;
    }

    protected Set<Scope> m16911a(Set<Scope> set) {
        return set;
    }

    protected final Set<Scope> mo1670f() {
        return this.f10720d;
    }

    public final Account getAccount() {
        return this.f10721e;
    }
}
