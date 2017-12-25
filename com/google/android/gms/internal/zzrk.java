package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface zzrk extends IInterface {

    public static abstract class zza extends Binder implements zzrk {

        private static class zza implements zzrk {
            private IBinder f11726a;

            zza(IBinder iBinder) {
                this.f11726a = iBinder;
            }

            public IBinder asBinder() {
                return this.f11726a;
            }

            public void zza(zzrj com_google_android_gms_internal_zzrj) {
                IBinder iBinder = null;
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.service.ICommonService");
                    if (com_google_android_gms_internal_zzrj != null) {
                        iBinder = com_google_android_gms_internal_zzrj.asBinder();
                    }
                    obtain.writeStrongBinder(iBinder);
                    this.f11726a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static zzrk zzea(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.ICommonService");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzrk)) ? new zza(iBinder) : (zzrk) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.service.ICommonService");
                    zza(com.google.android.gms.internal.zzrj.zza.zzdz(parcel.readStrongBinder()));
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.service.ICommonService");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzrj com_google_android_gms_internal_zzrj);
}
