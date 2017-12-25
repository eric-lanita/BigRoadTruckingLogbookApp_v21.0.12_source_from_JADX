package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzd implements Creator<LatLngBounds> {
    static void m17693a(LatLngBounds latLngBounds, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, latLngBounds.m17672a());
        zzb.zza(parcel, 2, latLngBounds.southwest, i, false);
        zzb.zza(parcel, 3, latLngBounds.northeast, i, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzoa(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzuu(i);
    }

    public LatLngBounds zzoa(Parcel parcel) {
        LatLng latLng = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        LatLng latLng2 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzg;
            LatLng latLng3;
            int zzcl = zza.zzcl(parcel);
            LatLng latLng4;
            switch (zza.zzgm(zzcl)) {
                case 1:
                    latLng4 = latLng;
                    latLng = latLng2;
                    zzg = zza.zzg(parcel, zzcl);
                    latLng3 = latLng4;
                    break;
                case 2:
                    zzg = i;
                    latLng4 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    latLng3 = latLng;
                    latLng = latLng4;
                    break;
                case 3:
                    latLng3 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    latLng = latLng2;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    latLng3 = latLng;
                    latLng = latLng2;
                    zzg = i;
                    break;
            }
            i = zzg;
            latLng2 = latLng;
            latLng = latLng3;
        }
        if (parcel.dataPosition() == zzcm) {
            return new LatLngBounds(i, latLng2, latLng);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public LatLngBounds[] zzuu(int i) {
        return new LatLngBounds[i];
    }
}
