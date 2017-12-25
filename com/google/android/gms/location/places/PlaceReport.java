package com.google.android.gms.location.places;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zzaa;
import com.google.android.gms.common.internal.zzaa.zza;
import com.google.android.gms.common.internal.zzab;

public class PlaceReport extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<PlaceReport> CREATOR = new zzi();
    final int f11810a;
    private final String f11811b;
    private final String f11812c;
    private final String f11813d;

    PlaceReport(int i, String str, String str2, String str3) {
        this.f11810a = i;
        this.f11811b = str;
        this.f11812c = str2;
        this.f11813d = str3;
    }

    private static boolean m17613a(String str) {
        boolean z = true;
        switch (str.hashCode()) {
            case -1436706272:
                if (str.equals("inferredGeofencing")) {
                    z = true;
                    break;
                }
                break;
            case -1194968642:
                if (str.equals("userReported")) {
                    z = true;
                    break;
                }
                break;
            case -284840886:
                if (str.equals("unknown")) {
                    z = false;
                    break;
                }
                break;
            case -262743844:
                if (str.equals("inferredReverseGeocoding")) {
                    z = true;
                    break;
                }
                break;
            case 1164924125:
                if (str.equals("inferredSnappedToRoad")) {
                    z = true;
                    break;
                }
                break;
            case 1287171955:
                if (str.equals("inferredRadioSignals")) {
                    z = true;
                    break;
                }
                break;
        }
        switch (z) {
            case false:
            case true:
            case true:
            case true:
            case true:
            case true:
                return true;
            default:
                return false;
        }
    }

    public static PlaceReport create(String str, String str2) {
        return zzk(str, str2, "unknown");
    }

    public static PlaceReport zzk(String str, String str2, String str3) {
        zzab.zzy(str);
        zzab.zzhr(str2);
        zzab.zzhr(str3);
        zzab.zzb(m17613a(str3), (Object) "Invalid source");
        return new PlaceReport(1, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PlaceReport)) {
            return false;
        }
        PlaceReport placeReport = (PlaceReport) obj;
        return zzaa.equal(this.f11811b, placeReport.f11811b) && zzaa.equal(this.f11812c, placeReport.f11812c) && zzaa.equal(this.f11813d, placeReport.f11813d);
    }

    public String getPlaceId() {
        return this.f11811b;
    }

    public String getSource() {
        return this.f11813d;
    }

    public String getTag() {
        return this.f11812c;
    }

    public int hashCode() {
        return zzaa.hashCode(this.f11811b, this.f11812c, this.f11813d);
    }

    public String toString() {
        zza zzx = zzaa.zzx(this);
        zzx.zzg("placeId", this.f11811b);
        zzx.zzg("tag", this.f11812c);
        if (!"unknown".equals(this.f11813d)) {
            zzx.zzg(ShareConstants.FEED_SOURCE_PARAM, this.f11813d);
        }
        return zzx.toString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        zzi.m17614a(this, parcel, i);
    }
}
