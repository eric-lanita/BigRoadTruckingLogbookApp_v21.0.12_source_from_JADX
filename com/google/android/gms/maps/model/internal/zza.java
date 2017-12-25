package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.zzd;

public interface zza extends IInterface {

    public static abstract class zza extends Binder implements zza {

        private static class zza implements zza {
            private IBinder f12108a;

            zza(IBinder iBinder) {
                this.f12108a = iBinder;
            }

            public IBinder asBinder() {
                return this.f12108a;
            }

            public zzd zzbpn() {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    this.f12108a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzc(Bitmap bitmap) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    if (bitmap != null) {
                        obtain.writeInt(1);
                        bitmap.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f12108a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzi(float f) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeFloat(f);
                    this.f12108a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzkv(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.f12108a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzkw(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.f12108a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzkx(String str) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeString(str);
                    this.f12108a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public zzd zzvh(int i) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    obtain.writeInt(i);
                    this.f12108a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                    zzd zzfc = com.google.android.gms.dynamic.zzd.zza.zzfc(obtain2.readStrongBinder());
                    return zzfc;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static zza zziv(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zza)) ? new zza(iBinder) : (zza) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            IBinder iBinder = null;
            zzd zzvh;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzvh(parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeStrongBinder(zzvh != null ? zzvh.asBinder() : null);
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzkv(parcel.readString());
                    parcel2.writeNoException();
                    if (zzvh != null) {
                        iBinder = zzvh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzkw(parcel.readString());
                    parcel2.writeNoException();
                    if (zzvh != null) {
                        iBinder = zzvh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzbpn();
                    parcel2.writeNoException();
                    if (zzvh != null) {
                        iBinder = zzvh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzi(parcel.readFloat());
                    parcel2.writeNoException();
                    if (zzvh != null) {
                        iBinder = zzvh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzc(parcel.readInt() != 0 ? (Bitmap) Bitmap.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    if (zzvh != null) {
                        iBinder = zzvh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    zzvh = zzkx(parcel.readString());
                    parcel2.writeNoException();
                    if (zzvh != null) {
                        iBinder = zzvh.asBinder();
                    }
                    parcel2.writeStrongBinder(iBinder);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    zzd zzbpn();

    zzd zzc(Bitmap bitmap);

    zzd zzi(float f);

    zzd zzkv(String str);

    zzd zzkw(String str);

    zzd zzkx(String str);

    zzd zzvh(int i);
}
