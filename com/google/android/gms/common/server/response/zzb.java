package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.server.response.FastJsonResponse.Field;
import com.google.android.gms.common.server.response.FieldMappingDictionary.FieldMapPair;

public class zzb implements Creator<FieldMapPair> {
    static void m16981a(FieldMapPair fieldMapPair, Parcel parcel, int i) {
        int zzcn = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, fieldMapPair.f10836a);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 2, fieldMapPair.f10837b, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, fieldMapPair.f10838c, i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzct(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgt(i);
    }

    public FieldMapPair zzct(Parcel parcel) {
        Field field = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        String str = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    field = (Field) zza.zza(parcel, zzcl, Field.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new FieldMapPair(i, str, field);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public FieldMapPair[] zzgt(int i) {
        return new FieldMapPair[i];
    }
}
