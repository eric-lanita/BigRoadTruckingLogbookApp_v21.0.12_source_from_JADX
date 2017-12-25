package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class PointOfInterest extends AbstractSafeParcelable {
    public static final zzg CREATOR = new zzg();
    private final int f12065a;
    public final LatLng aho;
    public final String ahp;
    public final String name;

    PointOfInterest(int i, LatLng latLng, String str, String str2) {
        this.f12065a = i;
        this.aho = latLng;
        this.ahp = str;
        this.name = str2;
    }

    int m17675a() {
        return this.f12065a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzg.m17696a(this, parcel, i);
    }
}
