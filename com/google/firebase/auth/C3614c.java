package com.google.firebase.auth;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class C3614c implements Creator<UserProfileChangeRequest> {
    static void m18872a(UserProfileChangeRequest userProfileChangeRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, userProfileChangeRequest.f13100a);
        zzb.zza(parcel, 2, userProfileChangeRequest.m18868a(), false);
        zzb.zza(parcel, 3, userProfileChangeRequest.m18869b(), false);
        zzb.zza(parcel, 4, userProfileChangeRequest.m18870c());
        zzb.zza(parcel, 5, userProfileChangeRequest.m18871d());
        zzb.zzaj(parcel, zzcn);
    }

    public UserProfileChangeRequest m18873a(Parcel parcel) {
        String str = null;
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        boolean z2 = false;
        String str2 = null;
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str2 = zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    str = zza.zzq(parcel, zzcl);
                    break;
                case 4:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 5:
                    z = zza.zzc(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new UserProfileChangeRequest(i, str2, str, z2, z);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public UserProfileChangeRequest[] m18874a(int i) {
        return new UserProfileChangeRequest[i];
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return m18873a(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return m18874a(i);
    }
}
