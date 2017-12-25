package com.google.android.gms.gcm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;

public class PendingCallback implements Parcelable, ReflectedParcelable {
    public static final Creator<PendingCallback> CREATOR = new C32471();
    final IBinder f11016a;

    class C32471 implements Creator<PendingCallback> {
        C32471() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzmj(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzsp(i);
        }

        public PendingCallback zzmj(Parcel parcel) {
            return new PendingCallback(parcel);
        }

        public PendingCallback[] zzsp(int i) {
            return new PendingCallback[i];
        }
    }

    public PendingCallback(Parcel parcel) {
        this.f11016a = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public IBinder getIBinder() {
        return this.f11016a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f11016a);
    }
}
