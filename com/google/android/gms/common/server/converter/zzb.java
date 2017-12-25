package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;
import java.util.ArrayList;

public class zzb implements Creator<StringToIntConverter> {
    static void m16954a(StringToIntConverter stringToIntConverter, Parcel parcel, int i) {
        int zzcn = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, stringToIntConverter.m16951a());
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, stringToIntConverter.m16952b(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgq(i);
    }

    public StringToIntConverter zzcq(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        ArrayList arrayList = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    arrayList = zza.zzc(parcel, zzcl, Entry.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new StringToIntConverter(i, arrayList);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public StringToIntConverter[] zzgq(int i) {
        return new StringToIntConverter[i];
    }
}
