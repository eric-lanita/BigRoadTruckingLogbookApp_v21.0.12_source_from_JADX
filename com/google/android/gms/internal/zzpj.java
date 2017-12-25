package com.google.android.gms.internal;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Api.ApiOptions;
import com.google.android.gms.common.api.Api.zzc;
import com.google.android.gms.common.internal.zzaa;

public final class zzpj<O extends ApiOptions> {
    private final Api<O> f11457a;
    private final O f11458b;

    public zzpj(Api<O> api, O o) {
        this.f11457a = api;
        this.f11458b = o;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzpj)) {
            return false;
        }
        zzpj com_google_android_gms_internal_zzpj = (zzpj) obj;
        return zzaa.equal(this.f11457a, com_google_android_gms_internal_zzpj.f11457a) && zzaa.equal(this.f11458b, com_google_android_gms_internal_zzpj.f11458b);
    }

    public int hashCode() {
        return zzaa.hashCode(this.f11457a, this.f11458b);
    }

    public zzc<?> zzans() {
        return this.f11457a.zzans();
    }

    public String zzaon() {
        return this.f11457a.getName();
    }
}
