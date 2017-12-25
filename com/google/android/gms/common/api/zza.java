package com.google.android.gms.common.api;

import android.support.v4.p008d.C0270a;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.internal.zzpj;

public class zza extends zzb {
    private final ConnectionResult f10562a;

    public zza(Status status, C0270a<zzpj<?>, ConnectionResult> c0270a) {
        super(status, c0270a);
        this.f10562a = (ConnectionResult) c0270a.get(c0270a.m1149b(0));
    }
}
