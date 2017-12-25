package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class AuthAccountRequest extends AbstractSafeParcelable {
    public static final Creator<AuthAccountRequest> CREATOR = new zzc();
    final int f10652a;
    final IBinder f10653b;
    final Scope[] f10654c;
    Integer f10655d;
    Integer f10656e;

    AuthAccountRequest(int i, IBinder iBinder, Scope[] scopeArr, Integer num, Integer num2) {
        this.f10652a = i;
        this.f10653b = iBinder;
        this.f10654c = scopeArr;
        this.f10655d = num;
        this.f10656e = num2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m16916a(this, parcel, i);
    }
}
