package com.google.android.gms.iid;

import android.annotation.TargetApi;
import android.os.Binder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;

public class MessengerCompat implements Parcelable {
    public static final Creator<MessengerCompat> CREATOR = new C32521();
    Messenger f11049a;
    zzb f11050b;

    class C32521 implements Creator<MessengerCompat> {
        C32521() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return zzmo(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return zzsv(i);
        }

        public MessengerCompat zzmo(Parcel parcel) {
            IBinder readStrongBinder = parcel.readStrongBinder();
            return readStrongBinder != null ? new MessengerCompat(readStrongBinder) : null;
        }

        public MessengerCompat[] zzsv(int i) {
            return new MessengerCompat[i];
        }
    }

    private final class zza extends com.google.android.gms.iid.zzb.zza {
        Handler f11047a;
        final /* synthetic */ MessengerCompat f11048b;

        zza(MessengerCompat messengerCompat, Handler handler) {
            this.f11048b = messengerCompat;
            this.f11047a = handler;
        }

        public void send(Message message) {
            message.arg2 = Binder.getCallingUid();
            this.f11047a.dispatchMessage(message);
        }
    }

    public MessengerCompat(Handler handler) {
        if (VERSION.SDK_INT >= 21) {
            this.f11049a = new Messenger(handler);
        } else {
            this.f11050b = new zza(this, handler);
        }
    }

    public MessengerCompat(IBinder iBinder) {
        if (VERSION.SDK_INT >= 21) {
            this.f11049a = new Messenger(iBinder);
        } else {
            this.f11050b = com.google.android.gms.iid.zzb.zza.zzgq(iBinder);
        }
    }

    @TargetApi(21)
    private static int m17104a(Message message) {
        return message.sendingUid;
    }

    public static int zzc(Message message) {
        return VERSION.SDK_INT >= 21 ? m17104a(message) : message.arg2;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        boolean z = false;
        if (obj != null) {
            try {
                z = getBinder().equals(((MessengerCompat) obj).getBinder());
            } catch (ClassCastException e) {
            }
        }
        return z;
    }

    public IBinder getBinder() {
        return this.f11049a != null ? this.f11049a.getBinder() : this.f11050b.asBinder();
    }

    public int hashCode() {
        return getBinder().hashCode();
    }

    public void send(Message message) {
        if (this.f11049a != null) {
            this.f11049a.send(message);
        } else {
            this.f11050b.send(message);
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        if (this.f11049a != null) {
            parcel.writeStrongBinder(this.f11049a.getBinder());
        } else {
            parcel.writeStrongBinder(this.f11050b.asBinder());
        }
    }
}
