package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.response.FieldMappingDictionary.Entry;
import java.util.ArrayList;

public class zzc implements Creator<FieldMappingDictionary> {
    static void m16982a(FieldMappingDictionary fieldMappingDictionary, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, fieldMappingDictionary.m16969a());
        zzb.zzc(parcel, 2, fieldMappingDictionary.m16970b(), false);
        zzb.zza(parcel, 3, fieldMappingDictionary.zzauj(), false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcu(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgu(i);
    }

    public FieldMappingDictionary zzcu(Parcel parcel) {
        String str = null;
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
                case 3:
                    str = zza.zzq(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new FieldMappingDictionary(i, arrayList, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public FieldMappingDictionary[] zzgu(int i) {
        return new FieldMappingDictionary[i];
    }
}
