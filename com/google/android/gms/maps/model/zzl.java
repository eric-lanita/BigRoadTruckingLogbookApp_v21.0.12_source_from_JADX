package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzl implements Creator<StreetViewPanoramaLocation> {
    static void m17701a(StreetViewPanoramaLocation streetViewPanoramaLocation, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, streetViewPanoramaLocation.m17681a());
        zzb.zza(parcel, 2, streetViewPanoramaLocation.links, i, false);
        zzb.zza(parcel, 3, streetViewPanoramaLocation.position, i, false);
        zzb.zza(parcel, 4, streetViewPanoramaLocation.panoId, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzoi(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvc(i);
    }

    public StreetViewPanoramaLocation zzoi(Parcel parcel) {
        String str = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        LatLng latLng = null;
        StreetViewPanoramaLink[] streetViewPanoramaLinkArr = null;
        while (parcel.dataPosition() < zzcm) {
            LatLng latLng2;
            StreetViewPanoramaLink[] streetViewPanoramaLinkArr2;
            int zzg;
            String str2;
            int zzcl = zza.zzcl(parcel);
            String str3;
            switch (zza.zzgm(zzcl)) {
                case 1:
                    str3 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = zza.zzg(parcel, zzcl);
                    str2 = str3;
                    break;
                case 2:
                    zzg = i;
                    LatLng latLng3 = latLng;
                    streetViewPanoramaLinkArr2 = (StreetViewPanoramaLink[]) zza.zzb(parcel, zzcl, StreetViewPanoramaLink.CREATOR);
                    str2 = str;
                    latLng2 = latLng3;
                    break;
                case 3:
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = i;
                    str3 = str;
                    latLng2 = (LatLng) zza.zza(parcel, zzcl, LatLng.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzcl);
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = i;
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    str2 = str;
                    latLng2 = latLng;
                    streetViewPanoramaLinkArr2 = streetViewPanoramaLinkArr;
                    zzg = i;
                    break;
            }
            i = zzg;
            streetViewPanoramaLinkArr = streetViewPanoramaLinkArr2;
            latLng = latLng2;
            str = str2;
        }
        if (parcel.dataPosition() == zzcm) {
            return new StreetViewPanoramaLocation(i, streetViewPanoramaLinkArr, latLng, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public StreetViewPanoramaLocation[] zzvc(int i) {
        return new StreetViewPanoramaLocation[i];
    }
}
