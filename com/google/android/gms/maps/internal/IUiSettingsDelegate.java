package com.google.android.gms.maps.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface IUiSettingsDelegate extends IInterface {

    public static abstract class zza extends Binder implements IUiSettingsDelegate {

        private static class zza implements IUiSettingsDelegate {
            private IBinder f11975a;

            zza(IBinder iBinder) {
                this.f11975a = iBinder;
            }

            public IBinder asBinder() {
                return this.f11975a;
            }

            public boolean isCompassEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(10, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isIndoorLevelPickerEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(17, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isMapToolbarEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(19, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isMyLocationButtonEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(11, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isRotateGesturesEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(15, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isScrollGesturesEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(12, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isTiltGesturesEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(14, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isZoomControlsEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(9, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public boolean isZoomGesturesEnabled() {
                boolean z = false;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    this.f11975a.transact(13, obtain, obtain2, 0);
                    obtain2.readException();
                    if (obtain2.readInt() != 0) {
                        z = true;
                    }
                    obtain2.recycle();
                    obtain.recycle();
                    return z;
                } catch (Throwable th) {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setAllGesturesEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(8, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setCompassEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(2, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setIndoorLevelPickerEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(16, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMapToolbarEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(18, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setMyLocationButtonEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(3, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setRotateGesturesEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(7, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setScrollGesturesEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(4, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setTiltGesturesEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(6, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setZoomControlsEnabled(boolean z) {
                int i = 1;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (!z) {
                        i = 0;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(1, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }

            public void setZoomGesturesEnabled(boolean z) {
                int i = 0;
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (z) {
                        i = 1;
                    }
                    obtain.writeInt(i);
                    this.f11975a.transact(5, obtain, obtain2, 0);
                    obtain2.readException();
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public static IUiSettingsDelegate zziu(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IUiSettingsDelegate)) ? new zza(iBinder) : (IUiSettingsDelegate) queryLocalInterface;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            int i3 = 0;
            boolean z;
            boolean isZoomControlsEnabled;
            switch (i) {
                case 1:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setZoomControlsEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 2:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setCompassEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 3:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setMyLocationButtonEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 4:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setScrollGesturesEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 5:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setZoomGesturesEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 6:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setTiltGesturesEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 7:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setRotateGesturesEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 8:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setAllGesturesEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 9:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isZoomControlsEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 10:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isCompassEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 11:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isMyLocationButtonEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 12:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isScrollGesturesEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 13:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isZoomGesturesEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 14:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isTiltGesturesEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 15:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isRotateGesturesEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 16:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setIndoorLevelPickerEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 17:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isIndoorLevelPickerEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 18:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    if (parcel.readInt() != 0) {
                        z = true;
                    }
                    setMapToolbarEnabled(z);
                    parcel2.writeNoException();
                    return true;
                case 19:
                    parcel.enforceInterface("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    isZoomControlsEnabled = isMapToolbarEnabled();
                    parcel2.writeNoException();
                    if (isZoomControlsEnabled) {
                        i3 = 1;
                    }
                    parcel2.writeInt(i3);
                    return true;
                case 1598968902:
                    parcel2.writeString("com.google.android.gms.maps.internal.IUiSettingsDelegate");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean isCompassEnabled();

    boolean isIndoorLevelPickerEnabled();

    boolean isMapToolbarEnabled();

    boolean isMyLocationButtonEnabled();

    boolean isRotateGesturesEnabled();

    boolean isScrollGesturesEnabled();

    boolean isTiltGesturesEnabled();

    boolean isZoomControlsEnabled();

    boolean isZoomGesturesEnabled();

    void setAllGesturesEnabled(boolean z);

    void setCompassEnabled(boolean z);

    void setIndoorLevelPickerEnabled(boolean z);

    void setMapToolbarEnabled(boolean z);

    void setMyLocationButtonEnabled(boolean z);

    void setRotateGesturesEnabled(boolean z);

    void setScrollGesturesEnabled(boolean z);

    void setTiltGesturesEnabled(boolean z);

    void setZoomControlsEnabled(boolean z);

    void setZoomGesturesEnabled(boolean z);
}
