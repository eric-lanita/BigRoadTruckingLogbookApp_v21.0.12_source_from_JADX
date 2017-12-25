package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzp implements Creator<VisibleRegion> {
    static void m17705a(VisibleRegion visibleRegion, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, visibleRegion.m17689a());
        zzb.zza(parcel, 2, visibleRegion.nearLeft, i, false);
        zzb.zza(parcel, 3, visibleRegion.nearRight, i, false);
        zzb.zza(parcel, 4, visibleRegion.farLeft, i, false);
        zzb.zza(parcel, 5, visibleRegion.farRight, i, false);
        zzb.zza(parcel, 6, visibleRegion.latLngBounds, i, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzom(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvg(i);
    }

    public VisibleRegion zzom(Parcel parcel) {
        LatLngBounds latLngBounds = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        LatLng latLng = null;
        LatLng latLng2 = null;
        LatLng latLng3 = null;
        LatLng latLng4 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    latLng4 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 3:
                    latLng3 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 4:
                    latLng2 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 5:
                    latLng = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 6:
                    latLngBounds = (LatLngBounds) zza.zza(parcel, zzcl, LatLngBounds.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new VisibleRegion(i, latLng4, latLng3, latLng2, latLng, latLngBounds);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public VisibleRegion[] zzvg(int i) {
        return new VisibleRegion[i];
    }
}
