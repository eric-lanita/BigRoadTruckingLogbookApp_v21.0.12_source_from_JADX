package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzj implements Creator<StreetViewPanoramaCamera> {
    static void m17699a(StreetViewPanoramaCamera streetViewPanoramaCamera, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaCamera.m17679a());
        zzb.zza(parcel, 2, streetViewPanoramaCamera.zoom);
        zzb.zza(parcel, 3, streetViewPanoramaCamera.tilt);
        zzb.zza(parcel, 4, streetViewPanoramaCamera.bearing);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzog(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzva(i);
    }

    public StreetViewPanoramaCamera zzog(Parcel parcel) {
        float f = 0.0f;
        int zzcm = zza.zzcm(parcel);
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    f2 = zza.zzl(parcel, zzcl);
                    break;
                case 3:
                    f3 = zza.zzl(parcel, zzcl);
                    break;
                case 4:
                    f = zza.zzl(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new StreetViewPanoramaCamera(i, f2, f3, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public StreetViewPanoramaCamera[] zzva(int i) {
        return new StreetViewPanoramaCamera[i];
    }
}
