package com.google.android.gms.common;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;

public class zzb implements Creator<ConnectionResult> {
    static void m17015a(ConnectionResult connectionResult, Parcel parcel, int i) {
        int zzcn = com.google.android.gms.common.internal.safeparcel.zzb.zzcn(parcel);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 1, connectionResult.f10481a);
        com.google.android.gms.common.internal.safeparcel.zzb.zzc(parcel, 2, connectionResult.getErrorCode());
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 3, connectionResult.getResolution(), i, false);
        com.google.android.gms.common.internal.safeparcel.zzb.zza(parcel, 4, connectionResult.getErrorMessage(), false);
        com.google.android.gms.common.internal.safeparcel.zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzby(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzfb(i);
    }

    public ConnectionResult zzby(Parcel parcel) {
        String str = null;
        int i = 0;
        int zzcm = zza.zzcm(parcel);
        PendingIntent pendingIntent = null;
        int i2 = 0;
        while (parcel.dataPosition() < zzcm) {
            PendingIntent pendingIntent2;
            int i3;
            String str2;
            int zzcl = zza.zzcl(parcel);
            String str3;
            switch (zza.zzgm(zzcl)) {
                case 1:
                    str3 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = zza.zzg(parcel, zzcl);
                    str2 = str3;
                    break;
                case 2:
                    i = i2;
                    PendingIntent pendingIntent3 = pendingIntent;
                    i3 = zza.zzg(parcel, zzcl);
                    str2 = str;
                    pendingIntent2 = pendingIntent3;
                    break;
                case 3:
                    i3 = i;
                    i = i2;
                    str3 = str;
                    pendingIntent2 = (PendingIntent) zza.zza(parcel, zzcl, PendingIntent.CREATOR);
                    str2 = str3;
                    break;
                case 4:
                    str2 = zza.zzq(parcel, zzcl);
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    str2 = str;
                    pendingIntent2 = pendingIntent;
                    i3 = i;
                    i = i2;
                    break;
            }
            i2 = i;
            i = i3;
            pendingIntent = pendingIntent2;
            str = str2;
        }
        if (parcel.dataPosition() == zzcm) {
            return new ConnectionResult(i2, i, pendingIntent, str);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public ConnectionResult[] zzfb(int i) {
        return new ConnectionResult[i];
    }
}
