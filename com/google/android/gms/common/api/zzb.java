package com.google.android.gms.common.api;

import android.support.v4.p008d.C0270a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpj;

public class zzb implements Result {
    private final Status f10560a;
    private final C0270a<zzpj<?>, ConnectionResult> f10561b;

    public zzb(Status status, C0270a<zzpj<?>, ConnectionResult> c0270a) {
        this.f10560a = status;
        this.f10561b = c0270a;
    }

    public Status getStatus() {
        return this.f10560a;
    }
}
