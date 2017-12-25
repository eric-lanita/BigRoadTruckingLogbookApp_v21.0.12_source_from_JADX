package com.google.android.gms.internal;

import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.PendingResult;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.internal.zzpm.zzb;

public final class zzrg implements zzrf {

    private static class zza extends zzrd {
        private final zzb<Status> f11724a;

        public zza(zzb<Status> com_google_android_gms_internal_zzpm_zzb_com_google_android_gms_common_api_Status) {
            this.f11724a = com_google_android_gms_internal_zzpm_zzb_com_google_android_gms_common_api_Status;
        }

        public void zzgn(int i) {
            this.f11724a.setResult(new Status(i));
        }
    }

    public PendingResult<Status> zzg(GoogleApiClient googleApiClient) {
        return googleApiClient.zzd(new zza(this, googleApiClient) {
            final /* synthetic */ zzrg f11723d;

            protected void m17549a(zzri com_google_android_gms_internal_zzri) {
                ((zzrk) com_google_android_gms_internal_zzri.zzasa()).zza(new zza(this));
            }
        });
    }
}
