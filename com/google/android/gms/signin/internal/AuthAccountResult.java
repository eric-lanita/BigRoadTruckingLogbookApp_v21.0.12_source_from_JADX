package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountResult extends AbstractSafeParcelable implements Result {
    public static final Creator<AuthAccountResult> CREATOR = new zza();
    final int f12450a;
    private int f12451b;
    private Intent f12452c;

    public AuthAccountResult() {
        this(0, null);
    }

    AuthAccountResult(int i, int i2, Intent intent) {
        this.f12450a = i;
        this.f12451b = i2;
        this.f12452c = intent;
    }

    public AuthAccountResult(int i, Intent intent) {
        this(2, i, intent);
    }

    public Status getStatus() {
        return this.f12451b == 0 ? Status.sq : Status.su;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m18022a(this, parcel, i);
    }

    public int zzbzu() {
        return this.f12451b;
    }

    public Intent zzbzv() {
        return this.f12452c;
    }
}
