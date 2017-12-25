package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zzc implements Creator<CheckServerAuthResult> {
    static void m18023a(CheckServerAuthResult checkServerAuthResult, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, checkServerAuthResult.f12453a);
        zzb.zza(parcel, 2, checkServerAuthResult.f12454b);
        zzb.zzc(parcel, 3, checkServerAuthResult.f12455c, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzrq(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzyz(i);
    }

    public CheckServerAuthResult zzrq(Parcel parcel) {
        boolean z = false;
        int zzcm = zza.zzcm(parcel);
        List list = null;
        int i = 0;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 3:
                    list = zza.zzc(parcel, zzcl, Scope.CREATOR);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new CheckServerAuthResult(i, z, list);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public CheckServerAuthResult[] zzyz(int i) {
        return new CheckServerAuthResult[i];
    }
}
