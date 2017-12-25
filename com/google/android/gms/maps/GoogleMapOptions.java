package com.google.android.gms.maps;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C3176R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.maps.internal.zza;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public final class GoogleMapOptions extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final zza CREATOR = new zza();
    private final int f11867a;
    private Boolean f11868b;
    private Boolean f11869c;
    private int f11870d;
    private CameraPosition f11871e;
    private Boolean f11872f;
    private Boolean f11873g;
    private Boolean f11874h;
    private Boolean f11875i;
    private Boolean f11876j;
    private Boolean f11877k;
    private Boolean f11878l;
    private Boolean f11879m;
    private Boolean f11880n;
    private Float f11881o;
    private Float f11882p;
    private LatLngBounds f11883q;

    public GoogleMapOptions() {
        this.f11870d = -1;
        this.f11881o = null;
        this.f11882p = null;
        this.f11883q = null;
        this.f11867a = 1;
    }

    GoogleMapOptions(int i, byte b, byte b2, int i2, CameraPosition cameraPosition, byte b3, byte b4, byte b5, byte b6, byte b7, byte b8, byte b9, byte b10, byte b11, Float f, Float f2, LatLngBounds latLngBounds) {
        this.f11870d = -1;
        this.f11881o = null;
        this.f11882p = null;
        this.f11883q = null;
        this.f11867a = i;
        this.f11868b = zza.zza(b);
        this.f11869c = zza.zza(b2);
        this.f11870d = i2;
        this.f11871e = cameraPosition;
        this.f11872f = zza.zza(b3);
        this.f11873g = zza.zza(b4);
        this.f11874h = zza.zza(b5);
        this.f11875i = zza.zza(b6);
        this.f11876j = zza.zza(b7);
        this.f11877k = zza.zza(b8);
        this.f11878l = zza.zza(b9);
        this.f11879m = zza.zza(b10);
        this.f11880n = zza.zza(b11);
        this.f11881o = f;
        this.f11882p = f2;
        this.f11883q = latLngBounds;
    }

    public static GoogleMapOptions createFromAttributes(Context context, AttributeSet attributeSet) {
        if (attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C3176R.styleable.MapAttrs);
        GoogleMapOptions googleMapOptions = new GoogleMapOptions();
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_mapType)) {
            googleMapOptions.mapType(obtainAttributes.getInt(C3176R.styleable.MapAttrs_mapType, -1));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_zOrderOnTop)) {
            googleMapOptions.zOrderOnTop(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_zOrderOnTop, false));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_useViewLifecycle)) {
            googleMapOptions.useViewLifecycleInFragment(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_useViewLifecycle, false));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiCompass)) {
            googleMapOptions.compassEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiCompass, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiRotateGestures)) {
            googleMapOptions.rotateGesturesEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiRotateGestures, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiScrollGestures)) {
            googleMapOptions.scrollGesturesEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiScrollGestures, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiTiltGestures)) {
            googleMapOptions.tiltGesturesEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiTiltGestures, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiZoomGestures)) {
            googleMapOptions.zoomGesturesEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiZoomGestures, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiZoomControls)) {
            googleMapOptions.zoomControlsEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiZoomControls, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_liteMode)) {
            googleMapOptions.liteMode(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_liteMode, false));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_uiMapToolbar)) {
            googleMapOptions.mapToolbarEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_uiMapToolbar, true));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_ambientEnabled)) {
            googleMapOptions.ambientEnabled(obtainAttributes.getBoolean(C3176R.styleable.MapAttrs_ambientEnabled, false));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.minZoomPreference(obtainAttributes.getFloat(C3176R.styleable.MapAttrs_cameraMinZoomPreference, Float.NEGATIVE_INFINITY));
        }
        if (obtainAttributes.hasValue(C3176R.styleable.MapAttrs_cameraMinZoomPreference)) {
            googleMapOptions.maxZoomPreference(obtainAttributes.getFloat(C3176R.styleable.MapAttrs_cameraMaxZoomPreference, Float.POSITIVE_INFINITY));
        }
        googleMapOptions.latLngBoundsForCameraTarget(LatLngBounds.createFromAttributes(context, attributeSet));
        googleMapOptions.camera(CameraPosition.createFromAttributes(context, attributeSet));
        obtainAttributes.recycle();
        return googleMapOptions;
    }

    int m17616a() {
        return this.f11867a;
    }

    public GoogleMapOptions ambientEnabled(boolean z) {
        this.f11880n = Boolean.valueOf(z);
        return this;
    }

    byte m17617b() {
        return zza.zze(this.f11868b);
    }

    byte m17618c() {
        return zza.zze(this.f11869c);
    }

    public GoogleMapOptions camera(CameraPosition cameraPosition) {
        this.f11871e = cameraPosition;
        return this;
    }

    public GoogleMapOptions compassEnabled(boolean z) {
        this.f11873g = Boolean.valueOf(z);
        return this;
    }

    byte m17619d() {
        return zza.zze(this.f11872f);
    }

    byte m17620e() {
        return zza.zze(this.f11873g);
    }

    byte m17621f() {
        return zza.zze(this.f11874h);
    }

    byte m17622g() {
        return zza.zze(this.f11875i);
    }

    public Boolean getAmbientEnabled() {
        return this.f11880n;
    }

    public CameraPosition getCamera() {
        return this.f11871e;
    }

    public Boolean getCompassEnabled() {
        return this.f11873g;
    }

    public LatLngBounds getLatLngBoundsForCameraTarget() {
        return this.f11883q;
    }

    public Boolean getLiteMode() {
        return this.f11878l;
    }

    public Boolean getMapToolbarEnabled() {
        return this.f11879m;
    }

    public int getMapType() {
        return this.f11870d;
    }

    public Float getMaxZoomPreference() {
        return this.f11882p;
    }

    public Float getMinZoomPreference() {
        return this.f11881o;
    }

    public Boolean getRotateGesturesEnabled() {
        return this.f11877k;
    }

    public Boolean getScrollGesturesEnabled() {
        return this.f11874h;
    }

    public Boolean getTiltGesturesEnabled() {
        return this.f11876j;
    }

    public Boolean getUseViewLifecycleInFragment() {
        return this.f11869c;
    }

    public Boolean getZOrderOnTop() {
        return this.f11868b;
    }

    public Boolean getZoomControlsEnabled() {
        return this.f11872f;
    }

    public Boolean getZoomGesturesEnabled() {
        return this.f11875i;
    }

    byte m17623h() {
        return zza.zze(this.f11876j);
    }

    byte m17624i() {
        return zza.zze(this.f11877k);
    }

    byte m17625j() {
        return zza.zze(this.f11878l);
    }

    byte m17626k() {
        return zza.zze(this.f11879m);
    }

    byte m17627l() {
        return zza.zze(this.f11880n);
    }

    public GoogleMapOptions latLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.f11883q = latLngBounds;
        return this;
    }

    public GoogleMapOptions liteMode(boolean z) {
        this.f11878l = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapToolbarEnabled(boolean z) {
        this.f11879m = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions mapType(int i) {
        this.f11870d = i;
        return this;
    }

    public GoogleMapOptions maxZoomPreference(float f) {
        this.f11882p = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions minZoomPreference(float f) {
        this.f11881o = Float.valueOf(f);
        return this;
    }

    public GoogleMapOptions rotateGesturesEnabled(boolean z) {
        this.f11877k = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions scrollGesturesEnabled(boolean z) {
        this.f11874h = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions tiltGesturesEnabled(boolean z) {
        this.f11876j = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions useViewLifecycleInFragment(boolean z) {
        this.f11869c = Boolean.valueOf(z);
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zza.m17706a(this, parcel, i);
    }

    public GoogleMapOptions zOrderOnTop(boolean z) {
        this.f11868b = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomControlsEnabled(boolean z) {
        this.f11872f = Boolean.valueOf(z);
        return this;
    }

    public GoogleMapOptions zoomGesturesEnabled(boolean z) {
        this.f11875i = Boolean.valueOf(z);
        return this;
    }
}
