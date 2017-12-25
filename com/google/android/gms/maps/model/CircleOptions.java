package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public final class CircleOptions extends AbstractSafeParcelable {
    public static final zzb CREATOR = new zzb();
    private final int f12018a;
    private LatLng f12019b;
    private double f12020c;
    private float f12021d;
    private int f12022e;
    private int f12023f;
    private float f12024g;
    private boolean f12025h;
    private boolean f12026i;

    public CircleOptions() {
        this.f12019b = null;
        this.f12020c = 0.0d;
        this.f12021d = 10.0f;
        this.f12022e = -16777216;
        this.f12023f = 0;
        this.f12024g = 0.0f;
        this.f12025h = true;
        this.f12026i = false;
        this.f12018a = 1;
    }

    CircleOptions(int i, LatLng latLng, double d, float f, int i2, int i3, float f2, boolean z, boolean z2) {
        this.f12019b = null;
        this.f12020c = 0.0d;
        this.f12021d = 10.0f;
        this.f12022e = -16777216;
        this.f12023f = 0;
        this.f12024g = 0.0f;
        this.f12025h = true;
        this.f12026i = false;
        this.f12018a = i;
        this.f12019b = latLng;
        this.f12020c = d;
        this.f12021d = f;
        this.f12022e = i2;
        this.f12023f = i3;
        this.f12024g = f2;
        this.f12025h = z;
        this.f12026i = z2;
    }

    int m17660a() {
        return this.f12018a;
    }

    public CircleOptions center(LatLng latLng) {
        this.f12019b = latLng;
        return this;
    }

    public CircleOptions clickable(boolean z) {
        this.f12026i = z;
        return this;
    }

    public CircleOptions fillColor(int i) {
        this.f12023f = i;
        return this;
    }

    public LatLng getCenter() {
        return this.f12019b;
    }

    public int getFillColor() {
        return this.f12023f;
    }

    public double getRadius() {
        return this.f12020c;
    }

    public int getStrokeColor() {
        return this.f12022e;
    }

    public float getStrokeWidth() {
        return this.f12021d;
    }

    public float getZIndex() {
        return this.f12024g;
    }

    public boolean isClickable() {
        return this.f12026i;
    }

    public boolean isVisible() {
        return this.f12025h;
    }

    public CircleOptions radius(double d) {
        this.f12020c = d;
        return this;
    }

    public CircleOptions strokeColor(int i) {
        this.f12022e = i;
        return this;
    }

    public CircleOptions strokeWidth(float f) {
        this.f12021d = f;
        return this;
    }

    public CircleOptions visible(boolean z) {
        this.f12025h = z;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzb.m17691a(this, parcel, i);
    }

    public CircleOptions zIndex(float f) {
        this.f12024g = f;
        return this;
    }
}
