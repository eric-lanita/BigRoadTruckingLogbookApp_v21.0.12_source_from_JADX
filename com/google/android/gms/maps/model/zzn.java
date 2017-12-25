package com.google.android.gms.maps.model;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzn implements Creator<Tile> {
    static void m17703a(Tile tile, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, tile.m17683a());
        zzb.zzc(parcel, 2, tile.width);
        zzb.zzc(parcel, 3, tile.height);
        zzb.zza(parcel, 4, tile.data, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzok(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzve(i);
    }

    public Tile zzok(Parcel parcel) {
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        byte[] bArr = null;
        int i2 = 0;
        int i3 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i3 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 4:
                    bArr = zza.zzt(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new Tile(i3, i2, i, bArr);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public Tile[] zzve(int i) {
        return new Tile[i];
    }
}
