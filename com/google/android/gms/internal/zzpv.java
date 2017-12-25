package com.google.android.gms.internal;

import android.os.Bundle;
import android.os.DeadObjectException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.zzah;
import com.google.android.gms.internal.zzpm.zza;

public class zzpv implements zzpz {
    private final zzqa f11503a;
    private boolean f11504b = false;

    public zzpv(zzqa com_google_android_gms_internal_zzqa) {
        this.f11503a = com_google_android_gms_internal_zzqa;
    }

    private <A extends zzb> void m17403a(zza<? extends Result, A> com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A) {
        this.f11503a.f11588g.f11565i.m17534a((zza) com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A);
        zzb a = this.f11503a.f11588g.m17449a(com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A.zzans());
        if (a.isConnected() || !this.f11503a.f11583b.containsKey(com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A.zzans())) {
            if (a instanceof zzah) {
                a = ((zzah) a).zzatn();
            }
            com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A.zzb(a);
            return;
        }
        com_google_android_gms_internal_zzpm_zza__extends_com_google_android_gms_common_api_Result__A.zzz(new Status(17));
    }

    void m17404a() {
        if (this.f11504b) {
            this.f11504b = false;
            this.f11503a.f11588g.f11565i.release();
            disconnect();
        }
    }

    public void begin() {
    }

    public void connect() {
        if (this.f11504b) {
            this.f11504b = false;
            this.f11503a.m17459a(new zza(this, this) {
                final /* synthetic */ zzpv f11502a;

                public void zzapl() {
                    this.f11502a.f11503a.f11589h.zzm(null);
                }
            });
        }
    }

    public boolean disconnect() {
        if (this.f11504b) {
            return false;
        }
        if (this.f11503a.f11588g.m17453e()) {
            this.f11504b = true;
            for (zzqx a : this.f11503a.f11588g.f11564h) {
                a.m17529a();
            }
            return false;
        }
        this.f11503a.m17458a(null);
        return true;
    }

    public void onConnected(Bundle bundle) {
    }

    public void onConnectionSuspended(int i) {
        this.f11503a.m17458a(null);
        this.f11503a.f11589h.zzc(i, this.f11504b);
    }

    public void zza(ConnectionResult connectionResult, Api<?> api, int i) {
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(T t) {
        return zzd(t);
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(T t) {
        try {
            m17403a((zza) t);
        } catch (DeadObjectException e) {
            this.f11503a.m17459a(new zza(this, this) {
                final /* synthetic */ zzpv f11501a;

                public void zzapl() {
                    this.f11501a.onConnectionSuspended(1);
                }
            });
        }
        return t;
    }
}
