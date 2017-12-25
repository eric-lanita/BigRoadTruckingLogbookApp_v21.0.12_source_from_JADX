package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzab;
import com.google.android.gms.dynamic.zzd.zza;

public final class GroundOverlayOptions extends AbstractSafeParcelable {
    public static final zzc CREATOR = new zzc();
    public static final float NO_DIMENSION = -1.0f;
    private final int f12028a;
    private BitmapDescriptor f12029b;
    private LatLng f12030c;
    private float f12031d;
    private float f12032e;
    private LatLngBounds f12033f;
    private float f12034g;
    private float f12035h;
    private boolean f12036i;
    private float f12037j;
    private float f12038k;
    private float f12039l;
    private boolean f12040m;

    public GroundOverlayOptions() {
        this.f12036i = true;
        this.f12037j = 0.0f;
        this.f12038k = 0.5f;
        this.f12039l = 0.5f;
        this.f12040m = false;
        this.f12028a = 1;
    }

    GroundOverlayOptions(int i, IBinder iBinder, LatLng latLng, float f, float f2, LatLngBounds latLngBounds, float f3, float f4, boolean z, float f5, float f6, float f7, boolean z2) {
        this.f12036i = true;
        this.f12037j = 0.0f;
        this.f12038k = 0.5f;
        this.f12039l = 0.5f;
        this.f12040m = false;
        this.f12028a = i;
        this.f12029b = new BitmapDescriptor(zza.zzfc(iBinder));
        this.f12030c = latLng;
        this.f12031d = f;
        this.f12032e = f2;
        this.f12033f = latLngBounds;
        this.f12034g = f3;
        this.f12035h = f4;
        this.f12036i = z;
        this.f12037j = f5;
        this.f12038k = f6;
        this.f12039l = f7;
        this.f12040m = z2;
    }

    private GroundOverlayOptions m17661a(LatLng latLng, float f, float f2) {
        this.f12030c = latLng;
        this.f12031d = f;
        this.f12032e = f2;
        return this;
    }

    IBinder m17662a() {
        return this.f12029b.zzboj().asBinder();
    }

    public GroundOverlayOptions anchor(float f, float f2) {
        this.f12038k = f;
        this.f12039l = f2;
        return this;
    }

    int m17663b() {
        return this.f12028a;
    }

    public GroundOverlayOptions bearing(float f) {
        this.f12034g = ((f % 360.0f) + 360.0f) % 360.0f;
        return this;
    }

    public GroundOverlayOptions clickable(boolean z) {
        this.f12040m = z;
        return this;
    }

    public float getAnchorU() {
        return this.f12038k;
    }

    public float getAnchorV() {
        return this.f12039l;
    }

    public float getBearing() {
        return this.f12034g;
    }

    public LatLngBounds getBounds() {
        return this.f12033f;
    }

    public float getHeight() {
        return this.f12032e;
    }

    public BitmapDescriptor getImage() {
        return this.f12029b;
    }

    public LatLng getLocation() {
        return this.f12030c;
    }

    public float getTransparency() {
        return this.f12037j;
    }

    public float getWidth() {
        return this.f12031d;
    }

    public float getZIndex() {
        return this.f12035h;
    }

    public GroundOverlayOptions image(BitmapDescriptor bitmapDescriptor) {
        this.f12029b = bitmapDescriptor;
        return this;
    }

    public boolean isClickable() {
        return this.f12040m;
    }

    public boolean isVisible() {
        return this.f12036i;
    }

    public GroundOverlayOptions position(LatLng latLng, float f) {
        boolean z = true;
        zzab.zza(this.f12033f == null, (Object) "Position has already been set using positionFromBounds");
        zzab.zzb(latLng != null, (Object) "Location must be specified");
        if (f < 0.0f) {
            z = false;
        }
        zzab.zzb(z, (Object) "Width must be non-negative");
        return m17661a(latLng, f, NO_DIMENSION);
    }

    public GroundOverlayOptions position(LatLng latLng, float f, float f2) {
        boolean z = true;
        zzab.zza(this.f12033f == null, (Object) "Position has already been set using positionFromBounds");
        zzab.zzb(latLng != null, (Object) "Location must be specified");
        zzab.zzb(f >= 0.0f, (Object) "Width must be non-negative");
        if (f2 < 0.0f) {
            z = false;
        }
        zzab.zzb(z, (Object) "Height must be non-negative");
        return m17661a(latLng, f, f2);
    }

    public GroundOverlayOptions positionFromBounds(LatLngBounds latLngBounds) {
        boolean z = this.f12030c == null;
        String valueOf = String.valueOf(this.f12030c);
        zzab.zza(z, new StringBuilder(String.valueOf(valueOf).length() + 46).append("Position has already been set using position: ").append(valueOf).toString());
        this.f12033f = latLngBounds;
        return this;
    }

    public GroundOverlayOptions transparency(float f) {
        boolean z = f >= 0.0f && f <= 1.0f;
        zzab.zzb(z, (Object) "Transparency must be in the range [0..1]");
        this.f12037j = f;
        return this;
    }

    public GroundOverlayOptions visible(boolean z) {
        this.f12036i = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzc.m17692a(this, parcel, i);
    }

    public GroundOverlayOptions zIndex(float f) {
        this.f12035h = f;
        return this;
    }
}
