package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInRequest extends AbstractSafeParcelable {
    public static final Creator<SignInRequest> CREATOR = new zzh();
    final int f12460a;
    final ResolveAccountRequest f12461b;

    SignInRequest(int i, ResolveAccountRequest resolveAccountRequest) {
        this.f12460a = i;
        this.f12461b = resolveAccountRequest;
    }

    public SignInRequest(ResolveAccountRequest resolveAccountRequest) {
        this(1, resolveAccountRequest);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m18029a(this, parcel, i);
    }

    public ResolveAccountRequest zzbzy() {
        return this.f12461b;
    }
}
