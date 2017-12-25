package com.google.android.gms.maps.model;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.util.AttributeSet;
import com.google.android.gms.C3176R;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzab;

public final class LatLngBounds extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final zzd CREATOR = new zzd();
    private final int f12048a;
    public final LatLng northeast;
    public final LatLng southwest;

    public static final class Builder {
        private double f12044a = Double.POSITIVE_INFINITY;
        private double f12045b = Double.NEGATIVE_INFINITY;
        private double f12046c = Double.NaN;
        private double f12047d = Double.NaN;

        private boolean m17665a(double d) {
            boolean z = false;
            if (this.f12046c <= this.f12047d) {
                return this.f12046c <= d && d <= this.f12047d;
            } else {
                if (this.f12046c <= d || d <= this.f12047d) {
                    z = true;
                }
                return z;
            }
        }

        public LatLngBounds build() {
            zzab.zza(!Double.isNaN(this.f12046c), (Object) "no included points");
            return new LatLngBounds(new LatLng(this.f12044a, this.f12046c), new LatLng(this.f12045b, this.f12047d));
        }

        public Builder include(LatLng latLng) {
            this.f12044a = Math.min(this.f12044a, latLng.latitude);
            this.f12045b = Math.max(this.f12045b, latLng.latitude);
            double d = latLng.longitude;
            if (Double.isNaN(this.f12046c)) {
                this.f12046c = d;
                this.f12047d = d;
            } else if (!m17665a(d)) {
                if (LatLngBounds.m17670c(this.f12046c, d) < LatLngBounds.m17671d(this.f12047d, d)) {
                    this.f12046c = d;
                } else {
                    this.f12047d = d;
                }
            }
            return this;
        }
    }

    LatLngBounds(int i, LatLng latLng, LatLng latLng2) {
        zzab.zzb((Object) latLng, (Object) "null southwest");
        zzab.zzb((Object) latLng2, (Object) "null northeast");
        zzab.zzb(latLng2.latitude >= latLng.latitude, "southern latitude exceeds northern latitude (%s > %s)", Double.valueOf(latLng.latitude), Double.valueOf(latLng2.latitude));
        this.f12048a = i;
        this.southwest = latLng;
        this.northeast = latLng2;
    }

    public LatLngBounds(LatLng latLng, LatLng latLng2) {
        this(1, latLng, latLng2);
    }

    private boolean m17667a(double d) {
        return this.southwest.latitude <= d && d <= this.northeast.latitude;
    }

    private boolean m17669b(double d) {
        boolean z = false;
        if (this.southwest.longitude <= this.northeast.longitude) {
            return this.southwest.longitude <= d && d <= this.northeast.longitude;
        } else {
            if (this.southwest.longitude <= d || d <= this.northeast.longitude) {
                z = true;
            }
            return z;
        }
    }

    public static Builder builder() {
        return new Builder();
    }

    private static double m17670c(double d, double d2) {
        return ((d - d2) + 360.0d) % 360.0d;
    }

    public static LatLngBounds createFromAttributes(Context context, AttributeSet attributeSet) {
        if (context == null || attributeSet == null) {
            return null;
        }
        TypedArray obtainAttributes = context.getResources().obtainAttributes(attributeSet, C3176R.styleable.MapAttrs);
        Float valueOf = obtainAttributes.hasValue(C3176R.styleable.MapAttrs_latLngBoundsSouthWestLatitude) ? Float.valueOf(obtainAttributes.getFloat(C3176R.styleable.MapAttrs_latLngBoundsSouthWestLatitude, 0.0f)) : null;
        Float valueOf2 = obtainAttributes.hasValue(C3176R.styleable.MapAttrs_latLngBoundsSouthWestLongitude) ? Float.valueOf(obtainAttributes.getFloat(C3176R.styleable.MapAttrs_latLngBoundsSouthWestLongitude, 0.0f)) : null;
        Float valueOf3 = obtainAttributes.hasValue(C3176R.styleable.MapAttrs_latLngBoundsNorthEastLatitude) ? Float.valueOf(obtainAttributes.getFloat(C3176R.styleable.MapAttrs_latLngBoundsNorthEastLatitude, 0.0f)) : null;
        Float valueOf4 = obtainAttributes.hasValue(C3176R.styleable.MapAttrs_latLngBoundsNorthEastLongitude) ? Float.valueOf(obtainAttributes.getFloat(C3176R.styleable.MapAttrs_latLngBoundsNorthEastLongitude, 0.0f)) : null;
        return (valueOf == null || valueOf2 == null || valueOf3 == null || valueOf4 == null) ? null : new LatLngBounds(new LatLng((double) valueOf.floatValue(), (double) valueOf2.floatValue()), new LatLng((double) valueOf3.floatValue(), (double) valueOf4.floatValue()));
    }

    private static double m17671d(double d, double d2) {
        return ((d2 - d) + 360.0d) % 360.0d;
    }

    int m17672a() {
        return this.f12048a;
    }

    public boolean contains(LatLng latLng) {
        return m17667a(latLng.latitude) && m17669b(latLng.longitude);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LatLngBounds)) {
            return false;
        }
        LatLngBounds latLngBounds = (LatLngBounds) obj;
        return this.southwest.equals(latLngBounds.southwest) && this.northeast.equals(latLngBounds.northeast);
    }

    public LatLng getCenter() {
        double d = (this.southwest.latitude + this.northeast.latitude) / 2.0d;
        double d2 = this.northeast.longitude;
        double d3 = this.southwest.longitude;
        return new LatLng(d, d3 <= d2 ? (d2 + d3) / 2.0d : ((d2 + 360.0d) + d3) / 2.0d);
    }

    public int hashCode() {
        return zzaa.hashCode(this.southwest, this.northeast);
    }

    public LatLngBounds including(LatLng latLng) {
        double min = Math.min(this.southwest.latitude, latLng.latitude);
        double max = Math.max(this.northeast.latitude, latLng.latitude);
        double d = this.northeast.longitude;
        double d2 = this.southwest.longitude;
        double d3 = latLng.longitude;
        if (m17669b(d3)) {
            d3 = d2;
            d2 = d;
        } else if (m17670c(d2, d3) < m17671d(d, d3)) {
            d2 = d;
        } else {
            double d4 = d2;
            d2 = d3;
            d3 = d4;
        }
        return new LatLngBounds(new LatLng(min, d3), new LatLng(max, d2));
    }

    public String toString() {
        return zzaa.zzx(this).zzg("southwest", this.southwest).zzg("northeast", this.northeast).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzd.m17693a(this, parcel, i);
    }
}
