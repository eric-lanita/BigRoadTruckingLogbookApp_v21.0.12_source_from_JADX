package com.google.android.gms.auth.api.signin;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.safeparcel.zzb;
import java.util.List;

public class zza implements Creator<GoogleSignInAccount> {
    static void m16772a(GoogleSignInAccount googleSignInAccount, Parcel parcel, int i) {
        int zzcn = zzb.zzcn(parcel);
        zzb.zzc(parcel, 1, googleSignInAccount.f10447a);
        zzb.zza(parcel, 2, googleSignInAccount.getId(), false);
        zzb.zza(parcel, 3, googleSignInAccount.getIdToken(), false);
        zzb.zza(parcel, 4, googleSignInAccount.getEmail(), false);
        zzb.zza(parcel, 5, googleSignInAccount.getDisplayName(), false);
        zzb.zza(parcel, 6, googleSignInAccount.getPhotoUrl(), i, false);
        zzb.zza(parcel, 7, googleSignInAccount.getServerAuthCode(), false);
        zzb.zza(parcel, 8, googleSignInAccount.zzafl());
        zzb.zza(parcel, 9, googleSignInAccount.zzafm(), false);
        zzb.zzc(parcel, 10, googleSignInAccount.f10448b, false);
        zzb.zza(parcel, 11, googleSignInAccount.getGivenName(), false);
        zzb.zza(parcel, 12, googleSignInAccount.getFamilyName(), false);
        zzb.zzaj(parcel, zzcn);
    }

    public /* synthetic */ Object createFromParcel(Parcel parcel) {
        return zzas(parcel);
    }

    public /* synthetic */ Object[] newArray(int i) {
        return zzda(i);
    }

    public GoogleSignInAccount zzas(Parcel parcel) {
        int zzcm = com.google.android.gms.common.internal.safeparcel.zza.zzcm(parcel);
        int i = 0;
        String str = null;
        String str2 = null;
        String str3 = null;
        String str4 = null;
        Uri uri = null;
        String str5 = null;
        long j = 0;
        String str6 = null;
        List list = null;
        String str7 = null;
        String str8 = null;
        while (parcel.dataPosition() < zzcm) {
            int zzcl = com.google.android.gms.common.internal.safeparcel.zza.zzcl(parcel);
            switch (com.google.android.gms.common.internal.safeparcel.zza.zzgm(zzcl)) {
                case 1:
                    i = com.google.android.gms.common.internal.safeparcel.zza.zzg(parcel, zzcl);
                    break;
                case 2:
                    str = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 3:
                    str2 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 4:
                    str3 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 5:
                    str4 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 6:
                    uri = (Uri) com.google.android.gms.common.internal.safeparcel.zza.zza(parcel, zzcl, Uri.CREATOR);
                    break;
                case 7:
                    str5 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 8:
                    j = com.google.android.gms.common.internal.safeparcel.zza.zzi(parcel, zzcl);
                    break;
                case 9:
                    str6 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 10:
                    list = com.google.android.gms.common.internal.safeparcel.zza.zzc(parcel, zzcl, Scope.CREATOR);
                    break;
                case 11:
                    str7 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                case 12:
                    str8 = com.google.android.gms.common.internal.safeparcel.zza.zzq(parcel, zzcl);
                    break;
                default:
                    com.google.android.gms.common.internal.safeparcel.zza.zzb(parcel, zzcl);
                    break;
            }
        }
        if (parcel.dataPosition() == zzcm) {
            return new GoogleSignInAccount(i, str, str2, str3, str4, uri, str5, j, str6, list, str7, str8);
        }
        throw new com.google.android.gms.common.internal.safeparcel.zza.zza("Overread allowed size end=" + zzcm, parcel);
    }

    public GoogleSignInAccount[] zzda(int i) {
        return new GoogleSignInAccount[i];
    }
}
