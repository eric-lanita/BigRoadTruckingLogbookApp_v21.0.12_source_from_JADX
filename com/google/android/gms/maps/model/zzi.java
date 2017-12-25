package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzi implements Creator<PolylineOptions> {
    static void m17698a(PolylineOptions polylineOptions, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, polylineOptions.m17678a());
        zzb.zzc(parcel, 2, polylineOptions.getPoints(), false);
        zzb.zza(parcel, 3, polylineOptions.getWidth());
        zzb.zzc(parcel, 4, polylineOptions.getColor());
        zzb.zza(parcel, 5, polylineOptions.getZIndex());
        zzb.zza(parcel, 6, polylineOptions.isVisible());
        zzb.zza(parcel, 7, polylineOptions.isGeodesic());
        zzb.zza(parcel, 8, polylineOptions.isClickable());
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzof(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzuz(i);
    }

    public PolylineOptions zzof(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        List list = null;
        boolean z2 = false;
        boolean z3 = false;
        int i = 0;
        float f2 = 0.0f;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    list = zza.zzc(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 3:
                    f2 = zza.zzl(parcel, zzcl);
                    break;
                case 4:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 5:
                    f = zza.zzl(parcel, zzcl);
                    break;
                case 6:
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                case 7:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 8:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new PolylineOptions(i2, list, f2, i, f, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public PolylineOptions[] zzuz(int i) {
        return new PolylineOptions[i];
    }
}
