package android.support.v4.os;

import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.RemoteException;
import android.support.v4.os.C0312c.C0313a;

public class ResultReceiver implements Parcelable {
    public static final Creator<ResultReceiver> CREATOR = new C03111();
    final boolean f908a = false;
    final Handler f909b = null;
    C0312c f910c;

    static class C03111 implements Creator<ResultReceiver> {
        C03111() {
        }

        public /* synthetic */ Object createFromParcel(Parcel parcel) {
            return m1272a(parcel);
        }

        public /* synthetic */ Object[] newArray(int i) {
            return m1273a(i);
        }

        public ResultReceiver m1272a(Parcel parcel) {
            return new ResultReceiver(parcel);
        }

        public ResultReceiver[] m1273a(int i) {
            return new ResultReceiver[i];
        }
    }

    class C0314a extends C0313a {
        final /* synthetic */ ResultReceiver f904a;

        C0314a(ResultReceiver resultReceiver) {
            this.f904a = resultReceiver;
        }

        public void mo183a(int i, Bundle bundle) {
            if (this.f904a.f909b != null) {
                this.f904a.f909b.post(new C0315b(this.f904a, i, bundle));
            } else {
                this.f904a.m1278b(i, bundle);
            }
        }
    }

    class C0315b implements Runnable {
        final int f905a;
        final Bundle f906b;
        final /* synthetic */ ResultReceiver f907c;

        C0315b(ResultReceiver resultReceiver, int i, Bundle bundle) {
            this.f907c = resultReceiver;
            this.f905a = i;
            this.f906b = bundle;
        }

        public void run() {
            this.f907c.m1278b(this.f905a, this.f906b);
        }
    }

    public void m1277a(int i, Bundle bundle) {
        if (this.f908a) {
            if (this.f909b != null) {
                this.f909b.post(new C0315b(this, i, bundle));
            } else {
                m1278b(i, bundle);
            }
        } else if (this.f910c != null) {
            try {
                this.f910c.mo183a(i, bundle);
            } catch (RemoteException e) {
            }
        }
    }

    protected void m1278b(int i, Bundle bundle) {
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        synchronized (this) {
            if (this.f910c == null) {
                this.f910c = new C0314a(this);
            }
            parcel.writeStrongBinder(this.f910c.asBinder());
        }
    }

    ResultReceiver(Parcel parcel) {
        this.f910c = C0313a.m1275a(parcel.readStrongBinder());
    }
}
