package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.List;

public class CheckServerAuthResult extends AbstractSafeParcelable {
    public static final Creator<CheckServerAuthResult> CREATOR = new zzc();
    final int f12453a;
    final boolean f12454b;
    final List<Scope> f12455c;

    CheckServerAuthResult(int i, boolean z, List<Scope> list) {
        this.f12453a = i;
        this.f12454b = z;
        this.f12455c = list;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m18023a(this, parcel, i);
    }
}
