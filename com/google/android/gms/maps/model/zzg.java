package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzg implements Creator<PointOfInterest> {
    static void m17696a(PointOfInterest pointOfInterest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, pointOfInterest.m17675a());
        zzb.zza(parcel, 2, pointOfInterest.aho, i, false);
        zzb.zza(parcel, 3, pointOfInterest.ahp, false);
        zzb.zza(parcel, 4, pointOfInterest.name, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzod(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzux(i);
    }

    public PointOfInterest zzod(Parcel parcel) {
        String str = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str2 = null;
        LatLng latLng = null;
        while (parcel.dataPosition() < zzcm) {
            LatLng latLng2;
            int zzg;
            String str3;
            int zzcl = zza.zzcl(parcel);
            String str4;
            switch (zza.zzgm(zzcl)) {
                case 1:
                    str4 = str;
                    str = str2;
                    latLng2 = latLng;
                    zzg = zza.zzg(parcel, zzcl);
                    str3 = str4;
                    break;
                case 2:
                    zzg = i;
                    str4 = str2;
                    latLng2 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    str3 = str;
                    str = str4;
                    break;
                case 3:
                    latLng2 = latLng;
                    zzg = i;
                    str4 = str;
                    str = zza.zzq(parcel, zzcl);
                    str3 = str4;
                    break;
                case 4:
                    str3 = zza.zzq(parcel, zzcl);
                    str = str2;
                    latLng2 = latLng;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    str3 = str;
                    str = str2;
                    latLng2 = latLng;
                    zzg = i;
                    break;
            }
            i = zzg;
            latLng = latLng2;
            str2 = str;
            str = str3;
        }
        if (parcel.dataPosition() == zzcm) {
            return new PointOfInterest(i, latLng, str2, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public PointOfInterest[] zzux(int i) {
        return new PointOfInterest[i];
    }
}
