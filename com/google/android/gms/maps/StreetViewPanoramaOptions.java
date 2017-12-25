package com.google.android.gms.maps;

import android.os.Parcel;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.StreetViewPanoramaCamera;

public final class StreetViewPanoramaOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final zzb CREATOR = new zzb();
    private final int f11925a;
    private StreetViewPanoramaCamera f11926b;
    private String f11927c;
    private LatLng f11928d;
    private Integer f11929e;
    private Boolean f11930f;
    private Boolean f11931g;
    private Boolean f11932h;
    private Boolean f11933i;
    private Boolean f11934j;

    public StreetViewPanoramaOptions() {
        this.f11930f = Boolean.valueOf(true);
        this.f11931g = Boolean.valueOf(true);
        this.f11932h = Boolean.valueOf(true);
        this.f11933i = Boolean.valueOf(true);
        this.f11925a = 1;
    }

    StreetViewPanoramaOptions(int i, StreetViewPanoramaCamera streetViewPanoramaCamera, String str, LatLng latLng, Integer num, byte b, byte b2, byte b3, byte b4, byte b5) {
        this.f11930f = Boolean.valueOf(true);
        this.f11931g = Boolean.valueOf(true);
        this.f11932h = Boolean.valueOf(true);
        this.f11933i = Boolean.valueOf(true);
        this.f11925a = i;
        this.f11926b = streetViewPanoramaCamera;
        this.f11928d = latLng;
        this.f11929e = num;
        this.f11927c = str;
        this.f11930f = zza.zza(b);
        this.f11931g = zza.zza(b2);
        this.f11932h = zza.zza(b3);
        this.f11933i = zza.zza(b4);
        this.f11934j = zza.zza(b5);
    }

    int m17638a() {
        return this.f11925a;
    }

    byte m17639b() {
        return zza.zze(this.f11930f);
    }

    byte m17640c() {
        return zza.zze(this.f11931g);
    }

    byte m17641d() {
        return zza.zze(this.f11932h);
    }

    byte m17642e() {
        return zza.zze(this.f11933i);
    }

    byte m17643f() {
        return zza.zze(this.f11934j);
    }

    public Boolean getPanningGesturesEnabled() {
        return this.f11932h;
    }

    public String getPanoramaId() {
        return this.f11927c;
    }

    public LatLng getPosition() {
        return this.f11928d;
    }

    public Integer getRadius() {
        return this.f11929e;
    }

    public Boolean getStreetNamesEnabled() {
        return this.f11933i;
    }

    public StreetViewPanoramaCamera getStreetViewPanoramaCamera() {
        return this.f11926b;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f11934j;
    }

    public Boolean getUserNavigationEnabled() {
        return this.f11930f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f11931g;
    }

    public StreetViewPanoramaOptions panningGesturesEnabled(boolean z) {
        this.f11932h = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions panoramaCamera(StreetViewPanoramaCamera streetViewPanoramaCamera) {
        this.f11926b = streetViewPanoramaCamera;
        return this;
    }

    public StreetViewPanoramaOptions panoramaId(String str) {
        this.f11927c = str;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng) {
        this.f11928d = latLng;
        return this;
    }

    public StreetViewPanoramaOptions position(LatLng latLng, Integer num) {
        this.f11928d = latLng;
        this.f11929e = num;
        return this;
    }

    public StreetViewPanoramaOptions streetNamesEnabled(boolean z) {
        this.f11933i = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions useViewLifecycleInFragment(boolean z) {
        this.f11934j = Boolean.valueOf(z);
        return this;
    }

    public StreetViewPanoramaOptions userNavigationEnabled(boolean z) {
        this.f11930f = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m17707a(this, parcel, i);
    }

    public StreetViewPanoramaOptions zoomGesturesEnabled(boolean z) {
        this.f11931g = Boolean.valueOf(z);
        return this;
    }
}
