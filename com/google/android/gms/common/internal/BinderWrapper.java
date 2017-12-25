package com.google.android.gms.common.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.annotation.KeepName;

@KeepName
public final class BinderWrapper implements Parcelable {
    public static final Creator<BinderWrapper> CREATOR = new C32131();
    private IBinder f10657a;

    class C32131 implements Creator<BinderWrapper> {
        C32131() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzcf(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzgd(i);
        }

        public BinderWrapper zzcf(Parcel parcel) {
            return new BinderWrapper(parcel);
        }

        public BinderWrapper[] zzgd(int i) {
            return new BinderWrapper[i];
        }
    }

    public BinderWrapper() {
        this.f10657a = null;
    }

    public BinderWrapper(IBinder iBinder) {
        this.f10657a = null;
        this.f10657a = iBinder;
    }

    private BinderWrapper(Parcel parcel) {
        this.f10657a = null;
        this.f10657a = parcel.readStrongBinder();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeStrongBinder(this.f10657a);
    }
}
