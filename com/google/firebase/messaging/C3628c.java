package com.google.firebase.messaging;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class C3628c implements Creator<RemoteMessage> {
    static void m18980a(RemoteMessage remoteMessage, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, remoteMessage.f13153a);
        zzb.zza(parcel, 2, remoteMessage.f13154b, false);
        zzb.zzaj(parcel, zzcn);
    }

    public RemoteMessage m18981a(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        Bundle bundle = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    bundle = zza.zzs(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new RemoteMessage(i, bundle);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public RemoteMessage[] m18982a(int i) {
        return new RemoteMessage[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m18981a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m18982a(i);
    }
}
