package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class SignInButtonConfig extends AbstractSafeParcelable {
    public static final Creator<SignInButtonConfig> CREATOR = new zzae();
    final int f10680a;
    private final int f10681b;
    private final int f10682c;
    private final Scope[] f10683d;

    SignInButtonConfig(int i, int i2, int i3, Scope[] scopeArr) {
        this.f10680a = i;
        this.f10681b = i2;
        this.f10682c = i3;
        this.f10683d = scopeArr;
    }

    public SignInButtonConfig(int i, int i2, Scope[] scopeArr) {
        this(1, i, i2, scopeArr);
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzae.m16875a(this, parcel, i);
    }

    public int zzatk() {
        return this.f10681b;
    }

    public int zzatl() {
        return this.f10682c;
    }

    public Scope[] zzatm() {
        return this.f10683d;
    }
}
