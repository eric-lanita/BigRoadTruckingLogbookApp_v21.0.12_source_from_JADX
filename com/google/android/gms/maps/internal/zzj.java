package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.maps.model.internal.zzb;

public interface zzj extends IInterface {

    public static abstract class zza extends Binder implements zzj {

        private static class zza implements zzj {
            private IBinder f11993a;

            zza(IBinder iBinder) {
                this.f11993a = iBinder;
            }

            public IBinder asBinder() {
                return this.f11993a;
            }

            public void zza(zzb com_google_android_gms_maps_model_internal_zzb) {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IOnCircleClickListener");
                    obtain.writeStrongBinder(com_google_android_gms_maps_model_internal_zzb != null ? com_google_android_gms_maps_model_internal_zzb.asBinder() : null);
                    this.f11993a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public zza() {
            attachInterface(this, "com.google.android.gms.maps.internal.IOnCircleClickListener");
        }

        public static zzj zzhs(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IOnCircleClickListener");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof zzj)) ? new zza(iBinder) : (zzj) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IOnCircleClickListener");
                    zza(com.google.android.gms.maps.model.internal.zzb.zza.zziw(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IOnCircleClickListener");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void zza(zzb com_google_android_gms_maps_model_internal_zzb);
}
