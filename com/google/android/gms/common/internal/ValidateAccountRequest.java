package com.google.android.gms.common.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

@Deprecated
public class ValidateAccountRequest extends AbstractSafeParcelable {
    public static final Creator<ValidateAccountRequest> CREATOR = new zzaj();
    final int f10684a;
    final IBinder f10685b;
    private final int f10686c;
    private final Scope[] f10687d;
    private final Bundle f10688e;
    private final String f10689f;

    ValidateAccountRequest(int i, int i2, IBinder iBinder, Scope[] scopeArr, Bundle bundle, String str) {
        this.f10684a = i;
        this.f10686c = i2;
        this.f10685b = iBinder;
        this.f10687d = scopeArr;
        this.f10688e = bundle;
        this.f10689f = str;
    }

    public String getCallingPackage() {
        return this.f10689f;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzaj.m16915a(this, parcel, i);
    }

    public Scope[] zzatm() {
        return this.f10687d;
    }

    public int zzato() {
        return this.f10686c;
    }

    public Bundle zzatp() {
        return this.f10688e;
    }
}
