package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.IPolylineDelegate;

public interface zzaa extends IInterface {

    public static abstract class zza extends Binder implements zzaa {

        private static class zza implements zzaa {
            private IBinder f11976a;

            zza(IBinder iBinder) {
                this.f11976a = iBinder;
            }

            public IBinder asBinder() {
                return this.f11976a;
            }

            public void zza(IPolylineDelegate iPolylineDelegate) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnPolylineClickListener");
                    obtain.writeStrongBinder(iPolylineDelegate != null ? iPolylineDelegate.asBinder() : null);
                    this.f11976a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnPolylineClickListener");
        }

        public static zzaa zzij(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnPolylineClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzaa)) ? new zza(iBinder) : (zzaa) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnPolylineClickListener");
                    zza(com.google.android.gms.maps.model.internal.IPolylineDelegate.zza.zzjc(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnPolylineClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(IPolylineDelegate iPolylineDelegate);
}
