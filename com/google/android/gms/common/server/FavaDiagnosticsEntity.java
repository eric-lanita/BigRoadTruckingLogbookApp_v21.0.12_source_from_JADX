package com.google.android.gms.common.server;

import android.os.Parcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final zza CREATOR = new zza();
    final int f10812a;
    public final String zx;
    public final int zy;

    public FavaDiagnosticsEntity(int i, String str, int i2) {
        this.f10812a = i;
        this.zx = str;
        this.zy = i2;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m16985a(this, parcel, i);
    }
}
