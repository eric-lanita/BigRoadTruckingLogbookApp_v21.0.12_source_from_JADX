package com.google.android.gms.common.data;

import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zza implements Creator<BitmapTeleporter> {
    static void m16822a(BitmapTeleporter bitmapTeleporter, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, bitmapTeleporter.f10577a);
        zzb.zza(parcel, 2, bitmapTeleporter.f10578b, i, false);
        zzb.zzc(parcel, 3, bitmapTeleporter.f10579c);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcb(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfp(i);
    }

    public BitmapTeleporter zzcb(Parcel parcel) {
        int i = 0;
        int zzcm = com.google.android.gms.common.internal.safeparcel.zza.zzcm(parcel);
        ParcelFileDescriptor parcelFileDescriptor = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            ParcelFileDescriptor parcelFileDescriptor2;
            int zzg;
            int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgm(zzcl)) {
                case 1:
                    int i3 = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcl);
                    zzcl = i3;
                    break;
                case 2:
                    zzg = i2;
                    ParcelFileDescriptor parcelFileDescriptor3 = (ParcelFileDescriptor) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcl, ParcelFileDescriptor.CREATOR);
                    zzcl = i;
                    parcelFileDescriptor2 = parcelFileDescriptor3;
                    break;
                case 3:
                    zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcl);
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i2;
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcl);
                    zzcl = i;
                    parcelFileDescriptor2 = parcelFileDescriptor;
                    zzg = i2;
                    break;
            }
            i2 = zzg;
            parcelFileDescriptor = parcelFileDescriptor2;
            i = zzcl;
        }
        if (parcel.dataPosition() == zzcm) {
            return new BitmapTeleporter(i2, parcelFileDescriptor, i);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public BitmapTeleporter[] zzfp(int i) {
        return new BitmapTeleporter[i];
    }
}
