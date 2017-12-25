package com.google.android.gms.internal;

import android.os.Looper;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzb;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.zzc;
import com.google.android.gms.internal.zzpm.zza;

public class zzqd<O extends ApiOptions> extends zzpu {
    private final zzc<O> f11635a;

    public zzqd(zzc<O> com_google_android_gms_common_api_zzc_O) {
        super("Method is not supported by connectionless client. APIs supporting connectionless client must not call this method.");
        this.f11635a = com_google_android_gms_common_api_zzc_O;
    }

    public Looper getLooper() {
        return this.f11635a.getLooper();
    }

    public void zza(zzqx com_google_android_gms_internal_zzqx) {
        this.f11635a.zzanx();
    }

    public void zzb(zzqx com_google_android_gms_internal_zzqx) {
        this.f11635a.zzany();
    }

    public <A extends zzb, R extends Result, T extends zza<R, A>> T zzc(T t) {
        return this.f11635a.zza((zza) t);
    }

    public <A extends zzb, T extends zza<? extends Result, A>> T zzd(T t) {
        return this.f11635a.zzb((zza) t);
    }
}
