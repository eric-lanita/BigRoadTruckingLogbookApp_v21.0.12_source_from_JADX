package com.google.android.gms.common.internal;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class ResolveAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountRequest> CREATOR = new zzac();
    final int f10671a;
    private final Account f10672b;
    private final int f10673c;
    private final GoogleSignInAccount f10674d;

    ResolveAccountRequest(int i, Account account, int i2, GoogleSignInAccount googleSignInAccount) {
        this.f10671a = i;
        this.f10672b = account;
        this.f10673c = i2;
        this.f10674d = googleSignInAccount;
    }

    public ResolveAccountRequest(Account account, int i, GoogleSignInAccount googleSignInAccount) {
        this(2, account, i, googleSignInAccount);
    }

    public Account getAccount() {
        return this.f10672b;
    }

    public int getSessionId() {
        return this.f10673c;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzac.m16873a(this, parcel, i);
    }

    public GoogleSignInAccount zzatf() {
        return this.f10674d;
    }
}
