package com.google.android.gms.maps.model;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.safeparcel.zza;
import com.google.android.gms.common.internal.safeparcel.zzb;

public class zzo implements Creator<TileOverlayOptions> {
    static void m17704a(TileOverlayOptions tileOverlayOptions, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, tileOverlayOptions.m17685a());
        zzb.zza(parcel, 2, tileOverlayOptions.m17686b(), false);
        zzb.zza(parcel, 3, tileOverlayOptions.isVisible());
        zzb.zza(parcel, 4, tileOverlayOptions.getZIndex());
        zzb.zza(parcel, 5, tileOverlayOptions.getFadeIn());
        zzb.zza(parcel, 6, tileOverlayOptions.getTransparency());
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzol(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzvf(i);
    }

    public TileOverlayOptions zzol(Parcel parcel) {
        boolean z = false;
        float f = 0.0f;
        int zzcm = zza.zzcm(parcel);
        IBinder iBinder = null;
        boolean z2 = true;
        float f2 = 0.0f;
        int i = 0;
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
                    z = zza.zzc(parcel, zzcl);
                    break;
                case 4:
                    f2 = zza.zzl(parcel, zzcl);
                    break;
                case 5:
                    z2 = zza.zzc(parcel, zzcl);
                    break;
                case 6:
                    f = zza.zzl(parcel, zzcl);
                    break;
                default:
                    zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new TileOverlayOptions(i, iBinder, z, f2, z2, f);
        }
        throw new zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public TileOverlayOptions[] zzvf(int i) {
        return new TileOverlayOptions[i];
    }
}
