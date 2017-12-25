package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.facebook.share.internal.ShareConstants;
import com.google.android.gms.common.data.DataHolder.zza;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

public class zzd<T extends SafeParcelable> extends AbstractDataBuffer<T> {
    private static final String[] f10606b = new String[]{ShareConstants.WEB_DIALOG_PARAM_DATA};
    private final Creator<T> f10607c;

    public zzd(DataHolder dataHolder, Creator<T> creator) {
        super(dataHolder);
        this.f10607c = creator;
    }

    public static <T extends SafeParcelable> void zza(zza com_google_android_gms_common_data_DataHolder_zza, T t) {
        Parcel obtain = Parcel.obtain();
        t.writeToParcel(obtain, 0);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ShareConstants.WEB_DIALOG_PARAM_DATA, obtain.marshall());
        com_google_android_gms_common_data_DataHolder_zza.zza(contentValues);
        obtain.recycle();
    }

    public static zza zzarg() {
        return DataHolder.zzb(f10606b);
    }

    public /* synthetic */ Object get(int i) {
        return zzfr(i);
    }

    public T zzfr(int i) {
        byte[] zzg = this.a.zzg(ShareConstants.WEB_DIALOG_PARAM_DATA, i, this.a.zzfs(i));
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(zzg, 0, zzg.length);
        obtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) this.f10607c.createFromParcel(obtain);
        obtain.recycle();
        return safeParcelable;
    }
}
