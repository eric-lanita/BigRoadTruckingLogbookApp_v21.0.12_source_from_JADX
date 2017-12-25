package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zze implements Creator<LatLng> {
    static void m17694a(LatLng latLng, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, latLng.m17664a());
        zzb.zza(parcel, 2, latLng.latitude);
        zzb.zza(parcel, 3, latLng.longitude);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzob(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzuv(i);
    }

    public LatLng zzob(Parcel parcel) {
        double d = 0.0d;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        double d2 = 0.0d;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    d2 = zza.zzn(parcel, zzcl);
                    break;
                case 3:
                    d = zza.zzn(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new LatLng(i, d2, d);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public LatLng[] zzuv(int i) {
        return new LatLng[i];
    }
}
