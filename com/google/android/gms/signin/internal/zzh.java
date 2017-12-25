package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ResolveAccountRequest;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzh implements Creator<SignInRequest> {
    static void m18029a(SignInRequest signInRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, signInRequest.f12460a);
        zzb.zza(parcel, 2, signInRequest.zzbzy(), i, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzrs(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzzc(i);
    }

    public SignInRequest zzrs(Parcel parcel) {
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        ResolveAccountRequest resolveAccountRequest = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    resolveAccountRequest = (ResolveAccountRequest) zza.zza(parcel, zzcl, ResolveAccountRequest.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new SignInRequest(i, resolveAccountRequest);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public SignInRequest[] zzzc(int i) {
        return new SignInRequest[i];
    }
}
