package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzc implements Creator<AuthAccountRequest> {
    static void m16916a(AuthAccountRequest authAccountRequest, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, authAccountRequest.f10652a);
        zzb.zza(parcel, 2, authAccountRequest.f10653b, false);
        zzb.zza(parcel, 3, authAccountRequest.f10654c, i, false);
        zzb.zza(parcel, 4, authAccountRequest.f10655d, false);
        zzb.zza(parcel, 5, authAccountRequest.f10656e, false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzce(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzgb(i);
    }

    public AuthAccountRequest zzce(Parcel parcel) {
        Integer num = null;
        int zzcm = zza.zzcm(parcel);
        int i = 0;
        Integer num2 = null;
        Scope[] scopeArr = null;
        IBinder iBinder = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = zza.zzcl(parcel);
            switch (zza.zzgm(zzcl)) {
                case 1:
                    i = zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    iBinder = zza.zzr(parcel, zzcl);
                    break;
                case 3:
                    scopeArr = (Scope[]) zza.zzb(parcel, zzcl, Scope.CREATOR);
                    break;
                case 4:
                    num2 = zza.zzh(parcel, zzcl);
                    break;
                case 5:
                    num = zza.zzh(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new AuthAccountRequest(i, iBinder, scopeArr, num2, num);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public AuthAccountRequest[] zzgb(int i) {
        return new AuthAccountRequest[i];
    }
}
