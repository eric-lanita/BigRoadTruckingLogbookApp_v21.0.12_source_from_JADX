package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class Tile extends AbstractSafeParcelable {
    public static final zzn CREATOR = new zzn();
    private final int f12091a;
    public final byte[] data;
    public final int height;
    public final int width;

    Tile(int i, int i2, int i3, byte[] bArr) {
        this.f12091a = i;
        this.width = i2;
        this.height = i3;
        this.data = bArr;
    }

    public Tile(int i, int i2, byte[] bArr) {
        this(1, i, i2, bArr);
    }

    int m17683a() {
        return this.f12091a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzn.m17703a(this, parcel, i);
    }
}
