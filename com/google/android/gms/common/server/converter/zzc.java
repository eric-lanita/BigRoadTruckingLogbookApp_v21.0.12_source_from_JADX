package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import com.google.android.gms.common.server.converter.StringToIntConverter.Entry;

public class zzc implements Creator<Entry> {
    static void m16955a(Entry entry, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, entry.f10815a);
        zzb.zza(parcel, 2, entry.f10816b, false);
        zzb.zzc(parcel, 3, entry.f10817c);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzcr(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgr(i);
    }

    public Entry zzcr(Parcel parcel) {
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        String str = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i2 = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    i = zza.zzg(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new Entry(i2, str, i);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public Entry[] zzgr(int i) {
        return new Entry[i];
    }
}
