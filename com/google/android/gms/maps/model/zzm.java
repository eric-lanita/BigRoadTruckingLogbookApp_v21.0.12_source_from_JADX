package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzm implements Creator<StreetViewPanoramaOrientation> {
    static void m17702a(StreetViewPanoramaOrientation streetViewPanoramaOrientation, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaOrientation.m17682a());
        zzb.zza(parcel, 2, streetViewPanoramaOrientation.tilt);
        zzb.zza(parcel, 3, streetViewPanoramaOrientation.bearing);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzoj(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvd(i);
    }

    public StreetViewPanoramaOrientation zzoj(Parcel parcel) {
        float f = 0.0f;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        float f2 = 0.0f;
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
                    f = zza.zzl(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new StreetViewPanoramaOrientation(i, f2, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public StreetViewPanoramaOrientation[] zzvd(int i) {
        return new StreetViewPanoramaOrientation[i];
    }
}
