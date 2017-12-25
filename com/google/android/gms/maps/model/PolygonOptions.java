package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class PolygonOptions extends AbstractSafeParcelable {
    public static final zzh CREATOR = new zzh();
    private final int f12067a;
    private final List<LatLng> f12068b;
    private final List<List<LatLng>> f12069c;
    private float f12070d;
    private int f12071e;
    private int f12072f;
    private float f12073g;
    private boolean f12074h;
    private boolean f12075i;
    private boolean f12076j;

    public PolygonOptions() {
        this.f12070d = 10.0f;
        this.f12071e = -16777216;
        this.f12072f = 0;
        this.f12073g = 0.0f;
        this.f12074h = true;
        this.f12075i = false;
        this.f12076j = false;
        this.f12067a = 1;
        this.f12068b = new ArrayList();
        this.f12069c = new ArrayList();
    }

    PolygonOptions(int i, List<LatLng> list, List list2, float f, int i2, int i3, float f2, boolean z, boolean z2, boolean z3) {
        this.f12070d = 10.0f;
        this.f12071e = -16777216;
        this.f12072f = 0;
        this.f12073g = 0.0f;
        this.f12074h = true;
        this.f12075i = false;
        this.f12076j = false;
        this.f12067a = i;
        this.f12068b = list;
        this.f12069c = list2;
        this.f12070d = f;
        this.f12071e = i2;
        this.f12072f = i3;
        this.f12073g = f2;
        this.f12074h = z;
        this.f12075i = z2;
        this.f12076j = z3;
    }

    int m17676a() {
        return this.f12067a;
    }

    public PolygonOptions add(LatLng latLng) {
        this.f12068b.add(latLng);
        return this;
    }

    public PolygonOptions add(LatLng... latLngArr) {
        this.f12068b.addAll(Arrays.asList(latLngArr));
        return this;
    }

    public PolygonOptions addAll(Iterable<LatLng> iterable) {
        for (LatLng add : iterable) {
            this.f12068b.add(add);
        }
        return this;
    }

    public PolygonOptions addHole(Iterable<LatLng> iterable) {
        ArrayList arrayList = new ArrayList();
        for (LatLng add : iterable) {
            arrayList.add(add);
        }
        this.f12069c.add(arrayList);
        return this;
    }

    List m17677b() {
        return this.f12069c;
    }

    public PolygonOptions clickable(boolean z) {
        this.f12076j = z;
        return this;
    }

    public PolygonOptions fillColor(int i) {
        this.f12072f = i;
        return this;
    }

    public PolygonOptions geodesic(boolean z) {
        this.f12075i = z;
        return this;
    }

    public int getFillColor() {
        return this.f12072f;
    }

    public List<List<LatLng>> getHoles() {
        return this.f12069c;
    }

    public List<LatLng> getPoints() {
        return this.f12068b;
    }

    public int getStrokeColor() {
        return this.f12071e;
    }

    public float getStrokeWidth() {
        return this.f12070d;
    }

    public float getZIndex() {
        return this.f12073g;
    }

    public boolean isClickable() {
        return this.f12076j;
    }

    public boolean isGeodesic() {
        return this.f12075i;
    }

    public boolean isVisible() {
        return this.f12074h;
    }

    public PolygonOptions strokeColor(int i) {
        this.f12071e = i;
        return this;
    }

    public PolygonOptions strokeWidth(float f) {
        this.f12070d = f;
        return this;
    }

    public PolygonOptions visible(boolean z) {
        this.f12074h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzh.m17697a(this, parcel, i);
    }

    public PolygonOptions zIndex(float f) {
        this.f12073g = f;
        return this;
    }
}
