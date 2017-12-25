package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolylineOptions extends AbstractSafeParcelable {
    public static final zzi CREATOR = new zzi();
    private final int f12078a;
    private final List<LatLng> f12079b;
    private float f12080c;
    private int f12081d;
    private float f12082e;
    private boolean f12083f;
    private boolean f12084g;
    private boolean f12085h;

    public PolylineOptions() {
        this.f12080c = 10.0f;
        this.f12081d = -16777216;
        this.f12082e = 0.0f;
        this.f12083f = true;
        this.f12084g = false;
        this.f12085h = false;
        this.f12078a = 1;
        this.f12079b = new ArrayList();
    }

    PolylineOptions(int i, List list, float f, int i2, float f2, boolean z, boolean z2, boolean z3) {
        this.f12080c = 10.0f;
        this.f12081d = -16777216;
        this.f12082e = 0.0f;
        this.f12083f = true;
        this.f12084g = false;
        this.f12085h = false;
        this.f12078a = i;
        this.f12079b = list;
        this.f12080c = f;
        this.f12081d = i2;
        this.f12082e = f2;
        this.f12083f = z;
        this.f12084g = z2;
        this.f12085h = z3;
    }

    int m17678a() {
        return this.f12078a;
    }

    public PolylineOptions add(LatLng latLng) {
        this.f12079b.add(latLng);
        return this;
    }

    public PolylineOptions add(LatLng... latLngArr) {
        this.f12079b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolylineOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f12079b.add(add);
        }
        return this;
    }

    public PolylineOptions clickable(boolean z) {
        this.f12085h = z;
        return this;
    }

    public PolylineOptions color(int i) {
        this.f12081d = i;
        return this;
    }

    public PolylineOptions geodesic(boolean z) {
        this.f12084g = z;
        return this;
    }

    public int getColor() {
        return this.f12081d;
    }

    public List<LatLng> getPoints() {
        return this.f12079b;
    }

    public float getWidth() {
        return this.f12080c;
    }

    public float getZIndex() {
        return this.f12082e;
    }

    public boolean isClickable() {
        return this.f12085h;
    }

    public boolean isGeodesic() {
        return this.f12084g;
    }

    public boolean isVisible() {
        return this.f12083f;
    }

    public PolylineOptions visible(boolean z) {
        this.f12083f = z;
        return this;
    }

    public PolylineOptions width(float f) {
        this.f12080c = f;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m17698a(this, parcel, i);
    }

    public PolylineOptions zIndex(float f) {
        this.f12082e = f;
        return this;
    }
}
