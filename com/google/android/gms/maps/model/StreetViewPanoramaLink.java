package com.google.android.gms.maps.model;

import android.os.Parcel;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;

public class StreetViewPanoramaLink extends AbstractSafeParcelable {
    public static final zzk CREATOR = new zzk();
    private final int f12088a;
    public final float bearing;
    public final String panoId;

    StreetViewPanoramaLink(int i, String str, float f) {
        this.f12088a = i;
        this.panoId = str;
        if (((double) f) <= 0.0d) {
            f = (f % 360.0f) + 360.0f;
        }
        this.bearing = f % 360.0f;
    }

    int m17680a() {
        return this.f12088a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof StreetViewPanoramaLink)) {
            return false;
        }
        StreetViewPanoramaLink streetViewPanoramaLink = (StreetViewPanoramaLink) obj;
        return this.panoId.equals(streetViewPanoramaLink.panoId) && Float.floatToIntBits(this.bearing) == Float.floatToIntBits(streetViewPanoramaLink.bearing);
    }

    public int hashCode() {
        return zzaa.hashCode(this.panoId, Float.valueOf(this.bearing));
    }

    public String toString() {
        return zzaa.zzx(this).zzg("panoId", this.panoId).zzg("bearing", Float.valueOf(this.bearing)).toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzk.m17700a(this, parcel, i);
    }
}
