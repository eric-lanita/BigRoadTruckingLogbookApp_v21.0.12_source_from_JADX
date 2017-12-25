package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInResponse extends AbstractSafeParcelable {
    public static final Creator<SignInResponse> CREATOR = new zzi();
    final int f12462a;
    private final ConnectionResult f12463b;
    private final ResolveAccountResponse f12464c;

    public SignInResponse(int i) {
        this(new ConnectionResult(i, null), null);
    }

    SignInResponse(int i, ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this.f12462a = i;
        this.f12463b = connectionResult;
        this.f12464c = resolveAccountResponse;
    }

    public SignInResponse(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, resolveAccountResponse);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m18030a(this, parcel, i);
    }

    public ConnectionResult zzath() {
        return this.f12463b;
    }

    public ResolveAccountResponse zzbzz() {
        return this.f12464c;
    }
}
