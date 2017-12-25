package android.support.v4.app;

import android.app.Notification;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public interface C0218v extends IInterface {

    public static abstract class C0220a extends Binder implements C0218v {

        private static class C0219a implements C0218v {
            private IBinder f724a;

            C0219a(IBinder iBinder) {
                this.f724a = iBinder;
            }

            public IBinder asBinder() {
                return this.f724a;
            }

            public void mo158a(String str, int i, String str2, Notification notification) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    if (notification != null) {
                        obtain.writeInt(1);
                        notification.writeToParcel(obtain, 0);
                    } else {
                        obtain.writeInt(0);
                    }
                    this.f724a.transact(1, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void mo157a(String str, int i, String str2) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    obtain.writeInt(i);
                    obtain.writeString(str2);
                    this.f724a.transact(2, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }

            public void mo156a(String str) {
                Parcel obtain = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken("android.support.v4.app.INotificationSideChannel");
                    obtain.writeString(str);
                    this.f724a.transact(3, obtain, null, 1);
                } finally {
                    obtain.recycle();
                }
            }
        }

        public static C0218v m1004a(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface("android.support.v4.app.INotificationSideChannel");
            if (queryLocalInterface == null || !(queryLocalInterface instanceof C0218v)) {
                return new C0219a(iBinder);
            }
            return (C0218v) queryLocalInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) {
            switch (i) {
                case 1:
                    Notification notification;
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    String readString = parcel.readString();
                    int readInt = parcel.readInt();
                    String readString2 = parcel.readString();
                    if (parcel.readInt() != 0) {
                        notification = (Notification) Notification.CREATOR.createFromParcel(parcel);
                    } else {
                        notification = null;
                    }
                    mo158a(readString, readInt, readString2, notification);
                    return true;
                case 2:
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    mo157a(parcel.readString(), parcel.readInt(), parcel.readString());
                    return true;
                case 3:
                    parcel.enforceInterface("android.support.v4.app.INotificationSideChannel");
                    mo156a(parcel.readString());
                    return true;
                case 1598968902:
                    parcel2.writeString("android.support.v4.app.INotificationSideChannel");
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    void mo156a(String str);

    void mo157a(String str, int i, String str2);

    void mo158a(String str, int i, String str2, Notification notification);
}
