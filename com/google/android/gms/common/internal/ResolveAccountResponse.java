package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzq.zza;

public class ResolveAccountResponse extends AbstractSafeParcelable {
    public static final Creator<ResolveAccountResponse> CREATOR = new zzad();
    final int f10675a;
    IBinder f10676b;
    private ConnectionResult f10677c;
    private boolean f10678d;
    private boolean f10679e;

    ResolveAccountResponse(int i, IBinder iBinder, ConnectionResult connectionResult, boolean z, boolean z2) {
        this.f10675a = i;
        this.f10676b = iBinder;
        this.f10677c = connectionResult;
        this.f10678d = z;
        this.f10679e = z2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResolveAccountResponse)) {
            return false;
        }
        ResolveAccountResponse resolveAccountResponse = (ResolveAccountResponse) obj;
        return this.f10677c.equals(resolveAccountResponse.f10677c) && zzatg().equals(resolveAccountResponse.zzatg());
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzad.m16874a(this, parcel, i);
    }

    public zzq zzatg() {
        return zza.zzdp(this.f10676b);
    }

    public ConnectionResult zzath() {
        return this.f10677c;
    }

    public boolean zzati() {
        return this.f10678d;
    }

    public boolean zzatj() {
        return this.f10679e;
    }
}
