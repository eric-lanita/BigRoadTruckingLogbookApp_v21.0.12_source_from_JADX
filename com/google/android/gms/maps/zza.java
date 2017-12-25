package com.google.android.gms.maps;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLngBounds;

public class zza implements Creator<GoogleMapOptions> {
    static void m17706a(GoogleMapOptions googleMapOptions, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, googleMapOptions.m17616a());
        zzb.zza(parcel, 2, googleMapOptions.m17617b());
        zzb.zza(parcel, 3, googleMapOptions.m17618c());
        zzb.zzc(parcel, 4, googleMapOptions.getMapType());
        zzb.zza(parcel, 5, googleMapOptions.getCamera(), i, false);
        zzb.zza(parcel, 6, googleMapOptions.m17619d());
        zzb.zza(parcel, 7, googleMapOptions.m17620e());
        zzb.zza(parcel, 8, googleMapOptions.m17621f());
        zzb.zza(parcel, 9, googleMapOptions.m17622g());
        zzb.zza(parcel, 10, googleMapOptions.m17623h());
        zzb.zza(parcel, 11, googleMapOptions.m17624i());
        zzb.zza(parcel, 12, googleMapOptions.m17625j());
        zzb.zza(parcel, 14, googleMapOptions.m17626k());
        zzb.zza(parcel, 15, googleMapOptions.m17627l());
        zzb.zza(parcel, 16, googleMapOptions.getMinZoomPreference(), false);
        zzb.zza(parcel, 17, googleMapOptions.getMaxZoomPreference(), false);
        zzb.zza(parcel, 18, googleMapOptions.getLatLngBoundsForCameraTarget(), i, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zznv(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzup(i);
    }

    public GoogleMapOptions zznv(Parcel parcel) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zza.zzcm(parcel);
        int i = 0;
        byte b = (byte) -1;
        byte b2 = (byte) -1;
        int i2 = 0;
        CameraPosition cameraPosition = null;
        byte b3 = (byte) -1;
        byte b4 = (byte) -1;
        byte b5 = (byte) -1;
        byte b6 = (byte) -1;
        byte b7 = (byte) -1;
        byte b8 = (byte) -1;
        byte b9 = (byte) -1;
        byte b10 = (byte) -1;
        byte b11 = (byte) -1;
        Float f = null;
        Float f2 = null;
        LatLngBounds latLngBounds = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgm(zzcl)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    b = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 3:
                    b2 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 4:
                    i2 = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcl);
                    break;
                case 5:
                    cameraPosition = (CameraPosition) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcl, CameraPosition.CREATOR);
                    break;
                case 6:
                    b3 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 7:
                    b4 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 8:
                    b5 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 9:
                    b6 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 10:
                    b7 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 11:
                    b8 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 12:
                    b9 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 14:
                    b10 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 15:
                    b11 = com.google.android.gms.common.internal.safeparcel.zza.zze(parcel, zzcl);
                    break;
                case 16:
                    f = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzcl);
                    break;
                case 17:
                    f2 = com.google.android.gms.common.internal.safeparcel.zza.zzm(parcel, zzcl);
                    break;
                case 18:
                    latLngBounds = (LatLngBounds) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcl, LatLngBounds.CREATOR);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new GoogleMapOptions(i, b, b2, i2, cameraPosition, b3, b4, b5, b6, b7, b8, b9, b10, b11, f, f2, latLngBounds);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public GoogleMapOptions[] zzup(int i) {
        return new GoogleMapOptions[i];
    }
}
