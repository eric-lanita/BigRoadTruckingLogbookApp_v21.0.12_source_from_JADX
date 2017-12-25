package com.google.android.gms.common.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public interface zzv extends IInterface {

    public static abstract class zza extends Binder implements zzv {

        private static class zza implements zzv {
            private IBinder f10804a;

            zza(IBinder iBinder) {
                this.f10804a = iBinder;
            }

            public IBinder asBinder() {
                return this.f10804a;
            }

            public zzd zzatc() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    this.f10804a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzatd() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    this.f10804a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zzv zzdu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzv)) ? new zza(iBinder) : (zzv) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            zzd zzatc;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    zzatc = zzatc();
                    parcel2.writeNoException();
                    if (zzatc != null) {
                        iBinder = zzatc.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    zzatc = zzatd();
                    parcel2.writeNoException();
                    if (zzatc != null) {
                        iBinder = zzatc.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.common.internal.IGoogleCertificatesApi");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzd zzatc();

    zzd zzatd();
}
