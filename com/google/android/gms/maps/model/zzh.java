package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.ArrayList;
import java.util.List;

public class zzh implements Creator<PolygonOptions> {
    static void m17697a(PolygonOptions polygonOptions, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, polygonOptions.m17676a());
        zzb.zzc(parcel, 2, polygonOptions.getPoints(), false);
        zzb.zzd(parcel, 3, polygonOptions.m17677b(), false);
        zzb.zza(parcel, 4, polygonOptions.getStrokeWidth());
        zzb.zzc(parcel, 5, polygonOptions.getStrokeColor());
        zzb.zzc(parcel, 6, polygonOptions.getFillColor());
        zzb.zza(parcel, 7, polygonOptions.getZIndex());
        zzb.zza(parcel, 8, polygonOptions.isVisible());
        zzb.zza(parcel, 9, polygonOptions.isGeodesic());
        zzb.zza(parcel, 10, polygonOptions.isClickable());
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzoe(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzuy(i);
    }

    public PolygonOptions zzoe(Parcel parcel) {
        float f = 0.0f;
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        List list = null;
        List arrayList = new ArrayList();
        boolean z2 = false;
        boolean z3 = false;
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
                    list = zza.zzc(parcel, zzcl, LatLng.CREATOR);
                    break;
                case 3:
                    zza.zza(parcel, zzcl, arrayList, getClass().getClassLoader());
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
                    z3 = zza.zzc(parcel, zzcl);
                    break;
                case 9:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 10:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new PolygonOptions(i3, list, arrayList, f2, i2, i, f, z3, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public PolygonOptions[] zzuy(int i) {
        return new PolygonOptions[i];
    }
}
