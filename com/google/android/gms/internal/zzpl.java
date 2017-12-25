package com.google.android.gms.internal;

import android.support.v4.p008d.C0270a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.zza;
import com.google.android.gms.common.api.zzb;
import java.util.Set;

public final class zzpl extends zzpo<zzb> {
    private int f11468d;
    private boolean f11469e;

    private void m17368a(ConnectionResult connectionResult) {
        C0270a c0270a = null;
        for (int i = 0; i < c0270a.size(); i++) {
            zza((zzpj) c0270a.m1149b(i), connectionResult);
        }
    }

    protected zzb m17369a(Status status) {
        zzb com_google_android_gms_common_api_zzb;
        synchronized (null) {
            try {
                m17368a(new ConnectionResult(8));
                C0270a c0270a = null;
                if (c0270a.size() != 1) {
                    com_google_android_gms_common_api_zzb = new zzb(status, null);
                }
            } finally {
            }
        }
        return com_google_android_gms_common_api_zzb;
    }

    public void zza(zzpj<?> com_google_android_gms_internal_zzpj_, ConnectionResult connectionResult) {
        synchronized (null) {
            C0270a c0270a = null;
            try {
                c0270a.put(com_google_android_gms_internal_zzpj_, connectionResult);
                this.f11468d--;
                boolean isSuccess = connectionResult.isSuccess();
                if (!isSuccess) {
                    this.f11469e = isSuccess;
                }
                if (this.f11468d == 0) {
                    Status status = this.f11469e ? new Status(13) : Status.sq;
                    c0270a = null;
                    zzc(c0270a.size() == 1 ? new zza(status, null) : new zzb(status, null));
                }
            } finally {
            }
        }
    }

    public Set<zzpj<?>> zzaoq() {
        C0270a c0270a = null;
        return c0270a.keySet();
    }

    protected /* synthetic */ Result zzc(Status status) {
        return m17369a(status);
    }
}
