package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<CircleOptions> {
    static void m17691a(CircleOptions circleOptions, Parcel parcel, int i) {
        int zzcn = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, circleOptions.m17660a());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, circleOptions.getCenter(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, circleOptions.getRadius());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, circleOptions.getStrokeWidth());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 5, circleOptions.getStrokeColor());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 6, circleOptions.getFillColor());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 7, circleOptions.getZIndex());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 8, circleOptions.isVisible());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 9, circleOptions.isClickable());
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzny(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzus(i);
    }

    public CircleOptions zzny(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        LatLng latLng = null;
        double d = 0.0d;
        boolean z2 = false;
        int i = 0;
        int i2 = 0;
        float f2 = 0.0f;
        int i3 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    latLng = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 3:
                    d = zza.zzn(parcel, zzcl);
                    break;
                case 4:
                    f2 = zza.zzl(parcel, zzcl);
                    break;
                case 5:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 6:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 7:
                    f = zza.zzl(parcel, zzcl);
                    break;
                case 8:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 9:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new CircleOptions(i3, latLng, d, f2, i2, i, f, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public CircleOptions[] zzus(int i) {
        return new CircleOptions[i];
    }
}
