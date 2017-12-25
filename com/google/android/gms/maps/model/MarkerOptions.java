package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.dynamic.zzd.zza;

public final class MarkerOptions extends AbstractSafeParcelable {
    public static final zzf CREATOR = new zzf();
    private final int f12050a;
    private LatLng f12051b;
    private String f12052c;
    private String f12053d;
    private BitmapDescriptor f12054e;
    private float f12055f;
    private float f12056g;
    private boolean f12057h;
    private boolean f12058i;
    private boolean f12059j;
    private float f12060k;
    private float f12061l;
    private float f12062m;
    private float f12063n;
    private float f12064o;

    public MarkerOptions() {
        this.f12055f = 0.5f;
        this.f12056g = 1.0f;
        this.f12058i = true;
        this.f12059j = false;
        this.f12060k = 0.0f;
        this.f12061l = 0.5f;
        this.f12062m = 0.0f;
        this.f12063n = 1.0f;
        this.f12050a = 1;
    }

    MarkerOptions(int i, LatLng latLng, String str, String str2, IBinder iBinder, float f, float f2, boolean z, boolean z2, boolean z3, float f3, float f4, float f5, float f6, float f7) {
        this.f12055f = 0.5f;
        this.f12056g = 1.0f;
        this.f12058i = true;
        this.f12059j = false;
        this.f12060k = 0.0f;
        this.f12061l = 0.5f;
        this.f12062m = 0.0f;
        this.f12063n = 1.0f;
        this.f12050a = i;
        this.f12051b = latLng;
        this.f12052c = str;
        this.f12053d = str2;
        this.f12054e = iBinder == null ? null : new BitmapDescriptor(zza.zzfc(iBinder));
        this.f12055f = f;
        this.f12056g = f2;
        this.f12057h = z;
        this.f12058i = z2;
        this.f12059j = z3;
        this.f12060k = f3;
        this.f12061l = f4;
        this.f12062m = f5;
        this.f12063n = f6;
        this.f12064o = f7;
    }

    int m17673a() {
        return this.f12050a;
    }

    public MarkerOptions alpha(float f) {
        this.f12063n = f;
        return this;
    }

    public MarkerOptions anchor(float f, float f2) {
        this.f12055f = f;
        this.f12056g = f2;
        return this;
    }

    IBinder m17674b() {
        return this.f12054e == null ? null : this.f12054e.zzboj().asBinder();
    }

    public MarkerOptions draggable(boolean z) {
        this.f12057h = z;
        return this;
    }

    public MarkerOptions flat(boolean z) {
        this.f12059j = z;
        return this;
    }

    public float getAlpha() {
        return this.f12063n;
    }

    public float getAnchorU() {
        return this.f12055f;
    }

    public float getAnchorV() {
        return this.f12056g;
    }

    public BitmapDescriptor getIcon() {
        return this.f12054e;
    }

    public float getInfoWindowAnchorU() {
        return this.f12061l;
    }

    public float getInfoWindowAnchorV() {
        return this.f12062m;
    }

    public LatLng getPosition() {
        return this.f12051b;
    }

    public float getRotation() {
        return this.f12060k;
    }

    public String getSnippet() {
        return this.f12053d;
    }

    public String getTitle() {
        return this.f12052c;
    }

    public float getZIndex() {
        return this.f12064o;
    }

    public MarkerOptions icon(BitmapDescriptor bitmapDescriptor) {
        this.f12054e = bitmapDescriptor;
        return this;
    }

    public MarkerOptions infoWindowAnchor(float f, float f2) {
        this.f12061l = f;
        this.f12062m = f2;
        return this;
    }

    public boolean isDraggable() {
        return this.f12057h;
    }

    public boolean isFlat() {
        return this.f12059j;
    }

    public boolean isVisible() {
        return this.f12058i;
    }

    public MarkerOptions position(LatLng latLng) {
        if (latLng == null) {
            throw new IllegalArgumentException("latlng cannot be null - a position is required.");
        }
        this.f12051b = latLng;
        return this;
    }

    public MarkerOptions rotation(float f) {
        this.f12060k = f;
        return this;
    }

    public MarkerOptions snippet(String str) {
        this.f12053d = str;
        return this;
    }

    public MarkerOptions title(String str) {
        this.f12052c = str;
        return this;
    }

    public MarkerOptions visible(boolean z) {
        this.f12058i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzf.m17695a(this, parcel, i);
    }

    public MarkerOptions zIndex(float f) {
        this.f12064o = f;
        return this;
    }
}
